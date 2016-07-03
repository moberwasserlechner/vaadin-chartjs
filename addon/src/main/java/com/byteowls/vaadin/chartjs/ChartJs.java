package com.byteowls.vaadin.chartjs;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

@JavaScript({"vaadin://chartjs/Chart.min.js", "vaadin://chartjs/chartjs-connector.js"})
public class ChartJs extends AbstractJavaScriptComponent {

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

    @Override
    protected ChartJsState getState() {
        return (ChartJsState) super.getState();
    }
}
