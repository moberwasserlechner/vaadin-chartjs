package com.byteowls.vaadin.chartjs.options.scale;

import java.time.LocalDateTime;
import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class TimeScaleOptions extends And<TimeScale> implements JsonBuilder {
    
	private static final long serialVersionUID = -9154944512274347096L;

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
    private TimeDisplayFormats displayFormats;
    private Boolean isoWeekday;
    private LocalDateTime max;
    private LocalDateTime min;
    private Unit round;
    private String tooltipFormat;
    private Unit unit;
    private Integer stepSize;
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
    public TimeDisplayFormats displayFormats() {
        this.displayFormats = new TimeDisplayFormats(this);
        return this.displayFormats;
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
    public TimeScaleOptions min(LocalDateTime min) {
        this.min = min;
        return this;
    }
    
    /**
     * If defined, this will override the data maximum
     */
    public TimeScaleOptions max(LocalDateTime max) {
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
    public TimeScaleOptions stepSize(int stepSize) {
        this.stepSize = stepSize;
        return this;
    }
    
    /**
     * The minimum display format to be used for a time unit.
     */
    public TimeScaleOptions minUnit(Unit minUnit) {
        this.minUnit = minUnit;
        return this;
    }

    private static void putNotNullUnit(JsonObject obj, String key, Unit value) {
        if (value != null) {
            JUtils.putNotNull(obj, key, value.toString().toLowerCase());    
        }
    }
    
    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "format", format);
        JUtils.putNotNull(map, "displayFormats", displayFormats);
        JUtils.putNotNull(map, "isoWeekday", isoWeekday);
        JUtils.putNotNull(map, "min", min);
        JUtils.putNotNull(map, "max", max);
        putNotNullUnit(map, "round", round);    
        JUtils.putNotNull(map, "tooltipFormat", tooltipFormat);
        putNotNullUnit(map, "unit", unit);    
        JUtils.putNotNull(map, "stepSize", stepSize);
        putNotNullUnit(map, "minUnit", minUnit);    
        return map;
    }
    

}
