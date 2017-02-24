package com.byteowls.vaadin.chartjs.config;

import com.byteowls.vaadin.chartjs.data.Data;
import com.byteowls.vaadin.chartjs.options.types.BarChartOptions;
import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * A bar chart is a way of showing data as bars.
 * 
 * It is sometimes used to show trend data, and the comparison of multiple data sets side by side.
 *
 * @author michael@byteowls.com
 */
public class BarChartConfig implements ChartConfig {

    private static final long serialVersionUID = -5733734695357572646L;

    private String type = "bar";
    private Data<BarChartConfig> data;
    private BarChartOptions options;

    public Data<BarChartConfig> data() {
        if (this.data == null) {
            this.data = new Data<>(this);
        }
        return this.data;
    }

    /**
     * Switch to horizonal bar chart
     * @return
     */
    public BarChartConfig horizontal() {
        type = "horizontalBar";
        return this;
    }

    public BarChartOptions options() {
        if (options == null) {
            options = new BarChartOptions(this);
        }
        return options;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "type", type);
        if (data != null) {
            JUtils.putNotNull(map, "data", data.buildJson());
        }
        if (options != null) {
            JUtils.putNotNull(map, "options", options.buildJson());
        }
        return map;
    }
}
