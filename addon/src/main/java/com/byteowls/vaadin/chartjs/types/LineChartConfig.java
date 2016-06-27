package com.byteowls.vaadin.chartjs.types;

import com.byteowls.vaadin.chartjs.json.JUtils;
import com.byteowls.vaadin.chartjs.options.LineChartOptions;
import elemental.json.Json;
import elemental.json.JsonObject;
import elemental.json.JsonValue;

public class LineChartConfig implements ChartConfig {

    private LineChartOptions options;

    @Override
    public JsonValue buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "type", "line");
        // data
        // options
        if (options != null) {
            JUtils.putNotNull(map, "options", options.buildJson());
        }
        return map;
    }

    public LineChartOptions options() {
        if (options == null) {
            options = new LineChartOptions();
        }
        return options;
    }
}
