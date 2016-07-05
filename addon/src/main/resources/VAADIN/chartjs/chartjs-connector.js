window.com_byteowls_vaadin_chartjs_ChartJs = function() {
    // see the javadoc of com.vaadin.ui.
    // for all functions on this.
    var e = this.getElement();
    // Please note that in JavaScript, this is not necessarily defined inside callback functions and it might therefore be necessary to assign the reference to a separate variable
    var self = this;
    var loggingEnabled = false;
    var canvas;
    var chartjs;

    // called every time the state is changed
    this.onStateChange = function() {
        var state = this.getState();
        loggingEnabled = state.loggingEnabled;
        if (typeof canvas === 'undefined') {
            if (loggingEnabled) {
                console.log("chartjs: create canvas");
            }
            canvas = document.createElement('canvas');
            e.appendChild(canvas)
        }
        if (state.width > 0) {
            canvas.setAttribute('width', state.width);
        }
        if (state.height > 0) {
            canvas.setAttribute('height', state.height);
        }

        
        if (typeof chartjs === 'undefined') {
            if (loggingEnabled) {
                console.log("chartjs: init");
            }

            if (loggingEnabled) {
                console.log("chartjs: configuration is\n", JSON.stringify(state.configurationJson, null, 2));
            }
            chartjs = new Chart(canvas, state.configurationJson);
        }

    };


    // TODO get data from server push and pull

};
