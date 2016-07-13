package com.byteowls.vaadin.chartjs.options.types;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.byteowls.vaadin.chartjs.options.AbstractOptions;
import com.byteowls.vaadin.chartjs.options.PieAnimationOptions;
import com.byteowls.vaadin.chartjs.options.scale.RadialLinearScale;
import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.JsonObject;

public class PolarAreaChartOptions extends AbstractOptions<PolarAreaChartOptions> {
    
    private PieAnimationOptions<PolarAreaChartOptions> pieAnimation;
    private RadialLinearScale scale;

    public PolarAreaChartOptions(ChartConfig chartConfig) {
        super(chartConfig);
    }
    
    public PolarAreaChartOptions scale(RadialLinearScale scale) {
        this.scale = scale;
        return this;
    }
    
    /**
     * Step into the charts animation configuration
     */
    public PieAnimationOptions<PolarAreaChartOptions> animation() {
        if (pieAnimation == null) {
            pieAnimation = new PieAnimationOptions<>(getThis());
        }
        return pieAnimation;
    }
    

    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "animation", pieAnimation);
        JUtils.putNotNull(map, "scale", scale);
        return map;
    }

    @Override
    public PolarAreaChartOptions getThis() {
        return this;
    }

}
