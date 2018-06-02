package com.byteowls.vaadin.chartjs.options.scale;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.JsonObject;

/**
 * @author michael@byteowls.com
 */
public class LinearTicks<T> extends Ticks<T> implements JsonBuilder {

    private static final long serialVersionUID = -7751881366365153424L;

    private Boolean beginAtZero;
    private Double min;
    private Double max;
    private Integer maxTicksLimit;
    private Double fixedStepSize;
    private Double stepSize;
    private Double suggestedMax;
    private Double suggestedMin;

    public LinearTicks(T parent) {
        super(parent);
    }

    /**
     * if true, scale will include 0 if it is not already included.
     */
    public LinearTicks<T> beginAtZero(Boolean beginAtZero) {
        this.beginAtZero = beginAtZero;
        return this;
    }

    /**
     * User defined minimum number for the scale, overrides minimum value from data.
     */
    public LinearTicks<T> min(int min) {
        this.min = (double) min;
        return this;
    }

    /**
     * User defined minimum number for the scale, overrides minimum value from data.
     */
    public LinearTicks<T> min(double min) {
        this.min = min;
        return this;
    }

    /**
     * User defined maximum number for the scale, overrides maximum value from data.
     */
    public LinearTicks<T> max(int max) {
        this.max = (double) max;
        return this;
    }

    /**
     * User defined maximum number for the scale, overrides maximum value from data.
     */
    public LinearTicks<T> max(double max) {
        this.max = max;
        return this;
    }

    /**
     * Maximum number of ticks and gridlines to show. If not defined, it will limit to 11 ticks but will show all gridlines.
     */
    public LinearTicks<T> maxTicksLimit(int maxTicksLimit) {
        this.maxTicksLimit = maxTicksLimit;
        return this;
    }

    /**
     * User defined fixed step size for the scale. If set, the scale ticks will be enumerated by multiple of stepSize, having one tick per increment.
     * If not set, the ticks are labeled automatically using the nice numbers algorithm.
     */
    public LinearTicks<T> fixedStepSize(double fixedStepSize) {
        this.fixedStepSize = fixedStepSize;
        return this;
    }

    /**
     * if defined, it can be used along with the min and the max to give a custom number of steps. See the example below.
     */
    public LinearTicks<T> stepSize(double stepSize) {
        this.stepSize = stepSize;
        return this;
    }

    /**
     * User defined maximum number for the scale, overrides maximum value except for if it is lower than the maximum value.
     */
    public LinearTicks<T> suggestedMax(int suggestedMax) {
        this.suggestedMax = (double) suggestedMax;
        return this;
    }

    /**
     * User defined maximum number for the scale, overrides maximum value except for if it is lower than the maximum value.
     */
    public LinearTicks<T> suggestedMax(double suggestedMax) {
        this.suggestedMax = suggestedMax;
        return this;
    }

    /**
     * User defined minimum number for the scale, overrides minimum value except for if it is higher than the minimum value.
     */
    public LinearTicks<T> suggestedMin(int suggestedMin) {
        this.suggestedMin = (double) suggestedMin;
        return this;
    }

    /**
     * User defined minimum number for the scale, overrides minimum value except for if it is higher than the minimum value.
     */
    public LinearTicks<T> suggestedMin(double suggestedMin) {
        this.suggestedMin = suggestedMin;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "beginAtZero", beginAtZero);
        JUtils.putNotNull(map, "min", min);
        JUtils.putNotNull(map, "max", max);
        JUtils.putNotNull(map, "maxTicksLimit", maxTicksLimit);
        JUtils.putNotNull(map, "fixedStepSize", fixedStepSize);
        JUtils.putNotNull(map, "stepSize", stepSize);
        JUtils.putNotNull(map, "suggestedMin", suggestedMin);
        JUtils.putNotNull(map, "suggestedMax", suggestedMax);
        return map;
    }
}
