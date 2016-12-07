package com.byteowls.vaadin.chartjs.config;

import com.byteowls.vaadin.chartjs.data.Data;
import com.byteowls.vaadin.chartjs.options.types.PolarAreaChartOptions;
import com.byteowls.vaadin.chartjs.utils.JUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Polar area charts are similar to pie charts, but each segment has the same angle - the radius of the segment differs depending on the value.
 * 
 * This type of chart is often useful when we want to show a comparison data similar to a pie chart, but also show a scale of values for context.
 *
 * @author michael@byteowls.com
 */
public class PolarAreaChartConfig implements ChartConfig {

    private Data<PolarAreaChartConfig> data;
    private PolarAreaChartOptions options;

    public Data<PolarAreaChartConfig> data() {
        if (this.data == null) {
            this.data = new Data<>(this);
        }
        return this.data;
    }

    public PolarAreaChartOptions options() {
        if (options == null) {
            options = new PolarAreaChartOptions(this);
        }
        return options;
    }
    
    @Override
    public Map<String, ?> buildJson() {
        Map<String, ?> map = new HashMap();
        JUtils.putNotNull(map, "type", "polarArea");
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
