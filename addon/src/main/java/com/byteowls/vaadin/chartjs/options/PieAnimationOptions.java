package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.JsonObject;

public class PieAnimationOptions<T> extends AnimationOptions<T> {
    
    private Boolean animateRotate;
    private Boolean animateScale;

    public PieAnimationOptions(T parent) {
        super(parent);
    }
    
    /**
     * If true, will animate the rotation of the chart.
     */
    public PieAnimationOptions<T> animateRotate(boolean animateRotate) {
        this.animateRotate = animateRotate;
        return this;
    }
    
    /**
     * If true, will animate scaling the Doughnut from the centre.
     */
    public PieAnimationOptions<T> animateScale(boolean animateScale) {
        this.animateScale = animateScale;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject obj = super.buildJson();
        JUtils.putNotNull(obj, "animateRotate", animateRotate);
        JUtils.putNotNull(obj, "animateScale", animateScale);
        return obj;
    }
    
    

}
