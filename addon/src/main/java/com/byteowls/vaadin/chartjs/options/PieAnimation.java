package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.JUtils;

import java.util.HashMap;
import java.util.Map;

public class PieAnimation<T> extends Animation<T> {
    
    private Integer duration;
    private AnimationEasing easing;
    // TODO callback functions http://www.chartjs.org/docs/#chart-configuration-animation-configuration
    // onProgress Callback called on each step of an animation. Passed a single argument, an object, containing the chart instance and an object with details of the animation.
    // onComplete Callback called at the end of an animation. Passed the same arguments as onProgress
    private Boolean animateRotate;
    private Boolean animateScale;

    public PieAnimation(T parent) {
        super(parent);
    }
    
    /**
     * If true, will animate the rotation of the chart.
     */
    public PieAnimation<T> animateRotate(boolean animateRotate) {
        this.animateRotate = animateRotate;
        return this;
    }
    
    /**
     * If true, will animate scaling the Doughnut from the centre.
     */
    public PieAnimation<T> animateScale(boolean animateScale) {
        this.animateScale = animateScale;
        return this;
    }
    
    /**
     * The number of milliseconds an animation takes.
     */
    public PieAnimation<T> duration(int duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Easing function to use.
     */
    public PieAnimation<T> easing(AnimationEasing easing) {
        this.easing = easing;
        return this;
    }
    
    @Override
    public Map<String, ?> buildJson() {
        Map<String, ?> map = new HashMap();
        JUtils.putNotNull(map, "duration", duration);
        if (easing != null) {
            JUtils.putNotNull(map, "easing", easing.name());
        }
        JUtils.putNotNull(map, "animateRotate", animateRotate);
        JUtils.putNotNull(map, "animateScale", animateScale);
        return map;
    }

}
