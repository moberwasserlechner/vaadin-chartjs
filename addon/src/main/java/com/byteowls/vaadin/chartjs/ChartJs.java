package com.byteowls.vaadin.chartjs;

import com.byteowls.vaadin.chartjs.types.ChartConfig;
import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

@JavaScript({ "vaadin://chartjs/Chart.min.js", "vaadin://chartjs/chartjs-connector.js" })
public class ChartJs extends AbstractJavaScriptComponent {

    /**
     * Configure a ChartJs chart.
     * @param chartConfig a chart configuration implementation
     */
    public void configure(ChartConfig chartConfig) {
        if (chartConfig != null) {
            getState().configurationJson = chartConfig.buildJson();
        }
    }

    @Override
    protected ChartJsState getState() {
        return (ChartJsState) super.getState();
    }
}
