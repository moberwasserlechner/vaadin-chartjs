package com.byteowls.vaadin.chartjs.options.types;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.byteowls.vaadin.chartjs.options.AbstractOptions;
import com.byteowls.vaadin.chartjs.options.scale.RadialLinearScale;
import com.byteowls.vaadin.chartjs.utils.JUtils;

import java.util.Map;
import java.util.Map;

public class RadarChartOptions extends AbstractOptions<RadarChartOptions> {

    private RadialLinearScale scale;
    private Double offsetAngle;

    public RadarChartOptions(ChartConfig chartConfig) {
        super(chartConfig);
    }

    public RadarChartOptions scale(RadialLinearScale scale) {
        this.scale = scale;
        return this;
    }
    
    public RadarChartOptions offsetAngle(double offsetAngle) {
        this.offsetAngle = offsetAngle;
        return this;
    }

    @Override
    public Map<String, ?> buildJson() {
        Map<String, ?> map = super.buildJson();
        JUtils.putNotNull(map, "scale", scale);
        JUtils.putNotNull(map, "offsetAngle", offsetAngle);
        return map;
    }

    @Override
    public RadarChartOptions getThis() {
        return this;
    }

}
