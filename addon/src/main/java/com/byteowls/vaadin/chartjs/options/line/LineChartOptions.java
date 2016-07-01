package com.byteowls.vaadin.chartjs.options.line;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.options.AbstractScalableOptions;
import elemental.json.JsonObject;

public class LineChartOptions extends AbstractScalableOptions<LineChartOptions> {

    private Boolean showLines;
    private LineChartConfig chartConfig;

    public LineChartOptions(LineChartConfig chartConfig) {
        this.chartConfig = chartConfig;
    }

    public LineChartOptions showLines(boolean showLines) {
        this.showLines = showLines;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "showLines", showLines);
        return map;
    }

    @Override
    public LineChartOptions getThis() {
        return this;
    }

    public ChartConfig done() {
        return chartConfig;
    }
}
