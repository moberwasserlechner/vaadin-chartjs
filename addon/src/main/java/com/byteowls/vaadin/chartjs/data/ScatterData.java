package com.byteowls.vaadin.chartjs.data;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * Data for the scatter line chart is passed in the form of an object. 
 * 
 * @author michael@byteowls.com
 *
 */
public class ScatterData implements JsonBuilder {

    private Double x;
    private Double y;

    /**
     * X Value
     */
    public ScatterData x(Double x) {
        this.x = x;
        return this;
    }

    /**
     * Y Value
     */
    public ScatterData y(Double y) {
        this.y = y;
        return this;
    }


    @Override
    public Map<String, ?> buildJson() {
        Map<String, ?> obj = new HashMap();
        JUtils.putNotNull(obj, "x", x);
        JUtils.putNotNull(obj, "y", y);
        return obj;
    }

    @Override
    public String toString() {
        return "[x=" + x + ", y=" + y + "]";
    }

}
