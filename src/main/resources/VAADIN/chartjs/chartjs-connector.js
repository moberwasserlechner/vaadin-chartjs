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
			chartjs = new Chart(canvas, state.configurationJson);

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
		} else {
			// TODO update config
		}

	};

	this.updateData = function() {
		chartjs.config.data = this.getState().configurationJson.data;
		chartjs.update();
	};

	this.getImageDataUrl = function(type, quality) {
		if (typeof quality !== 'undefined') {
			console.log("chartjs: download image quality: " + quality);
		}
		// TODO create issue on chart.js to allow jpeg downloads
		// call on function registered by server side component
		self.sendImageDataUrl(chartjs.toBase64Image());
	}

};
