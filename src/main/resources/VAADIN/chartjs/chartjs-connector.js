window.com_byteowls_vaadin_chartjs_ChartJs = function() {
    // see the javadoc of com.vaadin.ui.
    // for all functions on this.
    var e = this.getElement();
    // Please note that in JavaScript, this is not necessarily defined inside callback functions and it might therefore be necessary to assign the reference to a separate variable
    var self = this;
    var loggingEnabled = false;
    var canvas;
    var chartjs;
    var stateChangedCnt = 0;
    var cbPrefix = '__cb_'; // Also cf. JsonBuilder

    // called every time the state is changed
    this.onStateChange = function() {
        stateChangedCnt++;
        var state = this.getState();
        loggingEnabled = state.loggingEnabled;
        if (loggingEnabled) {
            console.log("chartjs: accessing onStateChange the "+stateChangedCnt+". time");
        }
        if (typeof canvas === 'undefined') {
            if (loggingEnabled) {
                console.log("chartjs: create canvas");
            }
            canvas = document.createElement('canvas');
            if (state.width && state.width.length > 0) {
                if (loggingEnabled) {
                    console.log("chartjs: canvas width " + state.width);
                }
                canvas.setAttribute('width', state.width);
            }
            if (state.height && state.height.length > 0) {
                if (loggingEnabled) {
                    console.log("chartjs: canvas height " + state.height);
                }
                canvas.setAttribute('height', state.height);
            }
            e.appendChild(canvas)
        } else {
            if (loggingEnabled) {
                console.log("chartjs: canvas already exists");
            }
        }

        if (typeof chartjs === 'undefined' && state.configurationJson !== 'undefined') {
            if (loggingEnabled) {
                console.log("chartjs: init");
            }

            if (loggingEnabled) {
                console.log("chartjs: configuration is\n", JSON.stringify(state.configurationJson, null, 2));
            }
            // parse callback functions
            this.parseCallbacks(state.configurationJson);
            chartjs = new Chart(canvas, state.configurationJson);
            // #69 the zoom/plugin captures the wheel event so no vertical scrolling is enabled if mouse is on
            if (state.configurationJson && !state.configurationJson.options.zoom) {
                chartjs.ctx.canvas.removeEventListener('wheel', chartjs.zoom._wheelHandler );
            }

            // only enable if there is a listener
            if (state.dataPointClickListenerFound) {
                if (loggingEnabled) {
                    console.log("chartjs: add data point click callback");
                }
                canvas.onclick = function(e) {
                    var elementArr = chartjs.getElementAtEvent(e);
                    if (elementArr && elementArr.length > 0) {
                        if (loggingEnabled) {
                            console.log("chartjs: onclick elements at:");
                            console.log(elementArr[0]);
                        }
                        // call on function registered by server side component
                        self.onDataPointClick(elementArr[0]._datasetIndex, elementArr[0]._index);
                    }
                };
            }
            if (state.legendClickListenerFound) {
                if (loggingEnabled) {
                    console.log("chartjs: add legend click callback");
                }
                chartjs.legend.options.onClick = chartjs.options.legend.onClick = function (t,e) {
                    var datasets = this.chart.data.datasets;
                    var dataset = datasets[e.datasetIndex];
                    dataset.hidden= !dataset.hidden;
                    this.chart.update();
                    var ret = [];
                    for (var i = 0; i < datasets.length ; i++ ) {
                        if (!datasets[i].hidden) {
                            ret.push(i);
                        }
                    }
                    self.onLegendClick(e.datasetIndex,!dataset.hidden, ret);
                }
            }
        } else {
            // update the data
            chartjs.config.data = this.getState().configurationJson.data;
            // update config: options must be copied separately, just copying the "options" object does not work
            chartjs.config.options.legend = this.getState().configurationJson.options.legend;
            chartjs.config.options.annotation = this.getState().configurationJson.options.annotation;
            chartjs.update();
        }

    };

    /**
     * Recursively searches obj for string properties starting with this.cbPrefix and sets the
     * property with the name without the prefix with a function based on the JavaScript code found
     * in the property's value.
     * If obj is not set, starts with the chartjs configuration.
     */
    this.parseCallbacks = function(obj) {
        if (!obj) {
            obj = chartjs.config;
        }
        // walk all properties
        for (var key in obj) {
            // skip inherited properties
            if (!obj.hasOwnProperty(key)) {
                continue;
            }
            var prop = obj[key];
            // skip null values
            if (prop == null) {
                continue;
            }
            // recurse into objects (includes arrays)
            else if (typeof prop === 'object') {
                try {
                    this.parseCallbacks(prop);
                }
                catch (err) {
                    console.error('Error parsing script nested in property: ' + key);
                    throw err;
                }
            }
            // found a string property where the property name starts with the callback prefix
            else if (typeof prop === 'string' && key.indexOf(cbPrefix) == 0) {
                // strip the prefix from the property name
                var newKey = key.substring(cbPrefix.length);
                // parse the function and set it as property to obj
                try {
                    obj[newKey] = this.parseCallback(prop);
                }
                catch (err) {
                    // print property name and fail recursion
                    console.error('Error parsing script in property: ' + key);
                    throw err;
                }
            }
        }
    }

    /**
     * Parses callback code and returns it as function.
     */
    this.parseCallback = function(code) {
        var callback = code.trim();
        // declaration of the function or a return statement is not required to be provided for
        // a simple calculation, but required for parsing
        if (callback.indexOf('function') != 0) {
            if (callback.indexOf('return') != 0) {
                callback = 'return ' + callback;
            }
            callback = 'function(value, index, values){' + callback + '}';
        }
        try {
            return eval('(' + callback + ')');
        }
        catch (err) {
            console.error('Unable to parse script:', err, callback);
            throw err;
        }
    }

    this.getImageDataUrl = function(type, quality) {
        if (typeof quality !== 'undefined') {
            console.log("chartjs: download image quality: " + quality);
        }
        // TODO create issue on chart.js to allow jpeg downloads
        // call on function registered by server side component
        self.sendImageDataUrl(chartjs.toBase64Image());
    };

    this.destroyChart = function() {
        if (chartjs) {
            chartjs.destroy();
        }
    }

};
