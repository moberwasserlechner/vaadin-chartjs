package com.byteowls.vaadin.chartjs;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

@JavaScript({"vaadin://chartjs/Chart.min.js", "vaadin://chartjs/chartjs-connector.js"})
public class ChartJs extends AbstractJavaScriptComponent {

    private static final long serialVersionUID = 2999562112373836140L;

    public ChartJs(ChartConfig chartConfig) {
        configure(chartConfig);
    }

    /**
     * Configure a ChartJs chart.
     *
     * @param chartConfig a chart configuration implementation
     */
    private void configure(ChartConfig chartConfig) {
        if (chartConfig != null) {
            getState().configurationJson = chartConfig.buildJson();
        }
    }
    
    /**
     * @return True if the connector's logs defined messages to "console.log" else logging is disabled.
     */
    public boolean isJsLoggingEnabled() {
      return getState().loggingEnabled;
    }

    /**
     * Enable or disables the connector's logging to "console.log"
     * @param jsLoggingEnabled If true the connector script will log defined messages to "console.log". Defaults to false. 
     */
    public void setJsLoggingEnabled(boolean jsLoggingEnabled) {
      getState().loggingEnabled = jsLoggingEnabled;
    }

    @Override
    protected ChartJsState getState() {
        return (ChartJsState) super.getState();
    }
}
