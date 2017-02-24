package com.byteowls.vaadin.chartjs.options.types;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.byteowls.vaadin.chartjs.options.AbstractOptions;
import com.byteowls.vaadin.chartjs.options.scale.RadialLinearScale;
import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.JsonObject;

public class RadarChartOptions extends AbstractOptions<RadarChartOptions> {

    private static final long serialVersionUID = -4046074534117345099L;

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
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "scale", scale);
        JUtils.putNotNull(map, "offsetAngle", offsetAngle);
        return map;
    }

    @Override
    public RadarChartOptions getThis() {
        return this;
    }

}
