package com.byteowls.vaadin.chartjs.options.scale;

import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.JsonObject;

/**
 * The time scale is used to display times and dates. It can only be placed on the X axis. 
 * 
 * When building its ticks, it will automatically calculate the most comfortable unit base on the size of the scale.
 *
 * @author michael@byteowls.com
 */
public class TimeScale extends BaseScale<TimeScale> {
    
    private TimeScaleOptions timeOptions;

    public TimeScale() {
        type("time");
    }
    
    public TimeScaleOptions time() {
        this.timeOptions = new TimeScaleOptions(this);
        return timeOptions;
    }
    

    @Override
    public TimeScale getThis() {
        return this;
    }
    
    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "time", timeOptions);
        return map;
    }
}
