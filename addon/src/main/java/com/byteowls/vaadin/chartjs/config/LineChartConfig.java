package com.byteowls.vaadin.chartjs.config;

import com.byteowls.vaadin.chartjs.data.Data;
import com.byteowls.vaadin.chartjs.options.types.LineChartOptions;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import java.util.HashMap;
import java.util.Map;

/**
 * A line chart is a way of plotting data points on a line.
 *
 * Often, it is used to show trend data, and the comparison of two data sets.
 *
 * @author michael@byteowls.com
 */
public class LineChartConfig implements ChartConfig {

    private Data<LineChartConfig> data;
    private LineChartOptions options;

    public Data<LineChartConfig> data() {
        if (this.data == null) {
            this.data = new Data<>(this);
        }
        return this.data;
    }

    public LineChartOptions options() {
        if (options == null) {
            options = new LineChartOptions(this);
        }
        return options;
    }

    @Override
    public Map<String, ?> buildJson() {
        Map<String, ?> map = new HashMap();
        JUtils.putNotNull(map, "type", "line");
        // data
        if (data != null) {
            JUtils.putNotNull(map, "data", data.buildJson());
        }
        // options
        if (options != null) {
            JUtils.putNotNull(map, "options", options.buildJson());
        }
        return map;
    }
}
