package com.byteowls.vaadin.chartjs.config;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.options.line.LineChartOptions;
import elemental.json.Json;
import elemental.json.JsonObject;

public class LineChartConfig implements ChartConfig {

    private LineChartOptions options;

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "type", "line");
        // data
        // options
        if (options != null) {
            JUtils.putNotNull(map, "options", options.buildJson());
        }
        return map;
    }

    public void data() {

    }

    public LineChartOptions options() {
        if (options == null) {
            options = new LineChartOptions(this);
        }
        return options;
    }
}
