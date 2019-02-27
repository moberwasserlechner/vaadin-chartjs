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
    var cbPrefix = '__cb_'; // Also cf. JUtils
    var cbArgsPostfix = '_args'; // Also cf. JUtils
    // The button HTML Element (div) opening the dropdown menu
    var menuButton;
    // The popup with the contents of the dropdown menu
    var menuPopup;
    // The the menu title element
    var menuTitle;
    // Set to true while rendering the image for export
    this.renderingExport = false;

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
            // build the menu
            if (state.showDownloadAction || state.menuItems && state.menuItems.length > 0) {
                this.buildMenu();
                e.appendChild(this.menuButton);
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

            Chart.plugins.register({
                beforeDraw: function(chartInstance) {
                    if (loggingEnabled) {
                        console.log("chartjs: rendering, for export: " + self.renderingExport);
                    }
                    // the image is re-rendered for export
                    if (self.renderingExport) {
                        // set a white background to the chart
                        if (state.downloadSetWhiteBackground) {
                            var ctx = chartInstance.chart.ctx;
                            ctx.fillStyle = 'white';
                            ctx.fillRect(0, 0, chartInstance.chart.width, chartInstance.chart.height);
                        }
                    }
                }
            });

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
                // find argument declaration
                var args = obj[key + cbArgsPostfix];
                // parse the function and set it as property to obj
                try {
                    obj[newKey] = this.parseCallback(prop, args);
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
    this.parseCallback = function(code, args) {
        var callback = code.trim();
        // declaration of the function or a return statement is not required to be provided for
        // a simple calculation, but required for parsing
        if (callback.indexOf('function') != 0) {
            if (callback.indexOf('return') != 0) {
                callback = 'return ' + callback;
            }
            if (!args) {
                args = '';
            }
            else if (typeof args !== 'string') {
                // multiple arguments, ie. args is an array
                args = args.join(',');
            }
            callback = 'function(' + args + '){' + callback + '}';
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
        if (this.menuPopup) {
            document.removeChild(this.menuPopup);
            this.menuPopup = null;
            document.removeEventListener('click', this.documentClickListener);
        }
    };

    // #21 Build a menu 
    this.buildMenu = function() {
        // create the menu button
        this.menuButton = this.createDiv('v-menubar v-widget');
        this.menuTitle = this.createDiv('v-menubar-menuitem');
        this.menuButton.appendChild(this.menuTitle);
        var menuTitleCaption = this.createDiv('v-menubar-menuitem-caption v-icon Vaadin-Icons');
        // for a text menu remove the v-icon class above and set the text content to some string
        // to be defined in the state
        // menuTitleCaption.textContent = 'Menu';
        this.menuTitle.appendChild(menuTitleCaption);
        // toggle state on click on the button
        this.menuButton.onclick = function() {
            self.setMenuOpenState(self.menuPopup.style.display === 'none');
        };
        // close the menu if the user clicked somewhere outside the menu
        document.addEventListener('click', this.documentClickListener);

        // build the popup / dropdown and its content
        this.menuPopup = this.createDiv('v-chartjs v-menubar-popup');
        // needs to be set here explicitly, since it is also used for detecting the state
        this.menuPopup.style.display = 'none';
        document.getElementsByClassName('v-overlay-container')[0].appendChild(this.menuPopup)
        // manual, absolute positioning on click
        var popupContent = this.createDiv('popupContent');
        this.menuPopup.appendChild(popupContent);
        var subMenu = this.createDiv('v-menubar-submenu v-widget');
        popupContent.appendChild(subMenu);
        var state = this.getState();
        // add the user defined menu items
        var menuItems = this.getState().menuItems;
        if (menuItems) {
            for (var action in menuItems) {
                this.createMenuItem(subMenu, menuItems[action], this[action]);
            }
        }
        // add the download action
        if (state.showDownloadAction) {
            var downloadActionText = 'Download PNG';
            if (state.downloadActionText) {
                downloadActionText = state.downloadActionText;
            }
            this.createMenuItem(subMenu, downloadActionText, this.startImageDownload);
        }
    };

    /**
     * Starts the image download
     */
    this.startImageDownload = function(e) {
        self.renderingExport = true;
        chartjs.render({duration: 0});
        var filename = self.getState().downloadActionFilename;
        if (!filename) {
            filename = 'chart.png';
        }
        if (canvas.msToBlob) {
            var blob = canvas.msToBlob();
            window.navigator.msSaveBlob(blob, filename);
        } else {
            var link = document.createElement('a');
            link.textContent = 'Download';
            link.href = canvas.toDataURL("image/png");
            link.download = filename;
            self.menuPopup.appendChild(link);
            link.click();
            self.menuPopup.removeChild(link);
        }
        self.renderingExport = false;
        chartjs.render({duration: 0});
    }

    /**
     * Creates and adds a new menu item
     * @param subMenu The sub menu HTML element.
     * @param title The menu entry title.
     * @param listener Callback called if the item is clicked.
     */
    this.createMenuItem = function(subMenu, title, listener) {
        var subMenuItem = document.createElement('span');
        subMenuItem.className = 'v-menubar-menuitem';
        subMenu.appendChild(subMenuItem);
        var subMenuItemCaption = document.createElement('span');
        subMenuItemCaption.className = 'v-menubar-menuitem-caption';
        subMenuItemCaption.textContent = title;
        subMenuItem.appendChild(subMenuItemCaption);
        subMenuItem.onclick = function() {
            listener();
            self.setMenuOpenState(false);
        }
    }

    /**
     * Opens or closes the dropdown menu, pass true to open it.
     */
    this.setMenuOpenState = function(open) {
        if (!open) {
            this.menuTitle.className = 'v-menubar-menuitem';
            this.menuPopup.style.display = 'none';
        } else {
            this.menuTitle.className = 'v-menubar-menuitem v-menubar-menuitem-selected';
            this.menuPopup.style.display = 'block';
            var clientRect = this.menuButton.getBoundingClientRect();
            this.menuPopup.style.top = (clientRect.top + clientRect.height) + 'px';
            // this.menuPopup.style.left = clientRect.left + 'px';
            this.menuPopup.style.right = (window.innerWidth - clientRect.right) + 'px';
        }
    }

    /**
     * Creates and returns a new div element and sets the class attribute to the
     * given css classes.
     */
    this.createDiv = function(className) {
        var div = document.createElement('div');
        if (className) {
            div.className = className;
        }
        return div;
    };

    /**
     * Document click listener used for detecting clicks outside of the menu, which should close
     * the menu.
     */
    this.documentClickListener = function(event) {
        var rect = self.menuPopup.getBoundingClientRect();
        var clickedInside = (event.clientX > rect.left && event.clientX < rect.right
                         && event.clientY > rect.top  && event.clientY < rect.bottom)
                         || self.menuButton.contains(event.target)
                         || self.menuPopup.contains(event.target);
        if (!clickedInside) {
          self.setMenuOpenState(false);
        }
    }
};
