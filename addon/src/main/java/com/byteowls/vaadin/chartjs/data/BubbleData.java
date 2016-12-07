package com.byteowls.vaadin.chartjs.data;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Data for the bubble chart is passed in the form of an object. 
 * 
 * It is important to note that the radius property, r is not scaled by the chart. It is the raw radius in pixels of the bubble that is drawn on the canvas.
 * 
 * @author michael@byteowls.com
 *
 */
public class BubbleData implements JsonBuilder {
    
    private Double x;
    private Double y;
    private Double r;
    
    /**
     * X Value
     */
    public BubbleData x(Double x) {
        this.x = x;
        return this;
    }
    
    /**
     * Y Value
     */
    public BubbleData y(Double y) {
        this.y = y;
        return this;
    }

    /**
     * Radius of bubble. This is not scaled.
     */
    public BubbleData r(Double r) {
        this.r = r;
        return this;
    }

    @Override
    public Map<String, ?> buildJson() {
        Map<String, ?> obj = new HashMap();
        JUtils.putNotNull(obj, "x", x);
        JUtils.putNotNull(obj, "y", y);
        JUtils.putNotNull(obj, "r", r);
        return obj;
    }
    
    @Override
    public String toString() {
        return "[x=" + x + ", y=" + y + ", r=" + r + "]";
    }

}
