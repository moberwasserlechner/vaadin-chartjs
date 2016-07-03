package com.byteowls.vaadin.chartjs.config;

import com.byteowls.vaadin.chartjs.options.line.LineChartOptions;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * A line chart is a way of plotting data points on a line.
 *
 * Often, it is used to show trend data, and the comparison of two data sets.
 *
 * @author michael@team-conductor.com
 */
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
