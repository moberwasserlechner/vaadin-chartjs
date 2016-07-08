package com.byteowls.vaadin.chartjs.options.types;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.byteowls.vaadin.chartjs.options.AbstractOptions;
import com.byteowls.vaadin.chartjs.options.PieAnimationOptions;
import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.JsonObject;

public class PieChartOptions extends AbstractOptions<PieChartOptions> {
    
    private Double cutoutPercentage;
    private Double rotation;
    private Double circumference;
    private PieAnimationOptions<PieChartOptions> pieAnimation;

    public PieChartOptions(ChartConfig chartConfig) {
        super(chartConfig);
    }
    
    /**
     * The percentage of the chart that is cut out of the middle.
     */
    public PieChartOptions cutoutPercentage(double cutoutPercentage) {
        this.cutoutPercentage = cutoutPercentage;
        return this;
    }
    
    /**
     * Starting angle to draw arcs from
     */
    public PieChartOptions rotation(double rotation) {
        this.rotation = rotation;
        return this;
    }
    
    /**
     * Step into the charts animation configuration
     */
    public PieAnimationOptions<PieChartOptions> animation() {
        if (pieAnimation == null) {
            pieAnimation = new PieAnimationOptions<>(getThis());
        }
        return pieAnimation;
    }
    
    /**
     * Sweep to allow arcs to cover
     */
    public PieChartOptions circumference(double circumference) {
        this.circumference = circumference;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "animation", pieAnimation);
        JUtils.putNotNull(map, "cutoutPercentage", cutoutPercentage);
        JUtils.putNotNull(map, "rotation", rotation);
        JUtils.putNotNull(map, "circumference", circumference);
        return map;
    }

    @Override
    public PieChartOptions getThis() {
        return this;
    }

}
