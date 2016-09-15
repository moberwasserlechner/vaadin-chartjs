package com.byteowls.vaadin.chartjs.options.scale;

import java.util.Date;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class TimeScaleOptions extends And<TimeScale> implements JsonBuilder {
    
    public enum Unit {
        MILLISECOND,
        SECOND,
        MINUTE,
        HOUR,
        DAY,
        WEEK,
        MONTH,
        QUARTER,
        YEAR
    }
    
    private String format;
    private TimeDisplayFormat displayFormat;
    private Boolean isoWeekday;
    private Date max;
    private Date min;
    private Unit round;
    private String tooltipFormat;
    private Unit unit;
    private Integer unitStepSize;
    private Unit minUnit;

    public TimeScaleOptions(TimeScale parent) {
        super(parent);
    }
    
    /**
     * E.g. 'MM/DD/YYYY HH:mm'
     */
    public TimeScaleOptions format(String format) {
        this.format = format;
        return this;
    }
    
    
    /**
     * The following display formats are used to configure how different time units are formed into strings for the axis tick marks. 
     */
    public TimeDisplayFormat displayFormat() {
        this.displayFormat = new TimeDisplayFormat(this);
        return this.displayFormat;
    }
     
    
    /**
     * If true and the unit is set to 'week', iso weekdays will be used.
     */
    public TimeScaleOptions isoWeekday(boolean isoWeekday) {
        this.isoWeekday = isoWeekday;
        return this;
    }
    
    /**
     * If defined, this will override the data minimum
     */
    public TimeScaleOptions min(Date min) {
        this.min = min;
        return this;
    }
    
    /**
     * If defined, this will override the data maximum
     */
    public TimeScaleOptions max(Date max) {
        this.max = max;
        return this;
    }
    
    /**
     * If defined, dates will be rounded to the start of this unit.
     */
    public TimeScaleOptions round(Unit round) {
        this.round = round;
        return this;
    }
    
    /**
     * The moment js format string to use for the tooltip.
     */
    public TimeScaleOptions tooltipFormat(String tooltipFormat) {
        this.tooltipFormat = tooltipFormat;
        return this;
    }
    
    
    
    /**
     * If defined, will force the unit to be a certain type.
     */
    public TimeScaleOptions unit(Unit unit) {
        this.unit = unit;
        return this;
    }
    
    /**
     * The number of units between grid lines.
     */
    public TimeScaleOptions unitStepSize(int unitStepSize) {
        this.unitStepSize = unitStepSize;
        return this;
    }
    
    /**
     * The minimum display format to be used for a time unit.
     */
    public TimeScaleOptions minUnit(Unit minUnit) {
        this.minUnit = minUnit;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "format", format);
        JUtils.putNotNull(map, "displayFormat", displayFormat);
        JUtils.putNotNull(map, "isoWeekday", isoWeekday);
        if (min != null) {
            
//            JUtils.putNotNull(map, "min", min);
        }
        if (max != null) {
//            JUtils.putNotNull(map, "max", max);
        }
        if (this.round != null) {
            JUtils.putNotNull(map, "round", round.toString().toLowerCase());    
        }
        JUtils.putNotNull(map, "tooltipFormat", tooltipFormat);
        if (this.unit != null) {
            JUtils.putNotNull(map, "unit", unit.toString().toLowerCase());    
        }
        JUtils.putNotNull(map, "unitStepSize", unitStepSize);
        if (this.minUnit != null) {
            JUtils.putNotNull(map, "minUnit", minUnit.toString().toLowerCase());    
        }
        return map;
    }
    

}
