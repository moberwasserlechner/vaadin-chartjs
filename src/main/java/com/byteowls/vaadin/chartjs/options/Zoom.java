package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.options.zoom.XYMode;
import com.byteowls.vaadin.chartjs.options.zoom.ZoomRange;
import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.io.Serializable;

/**
 * @author m.oberwasserlechner@byteowls.com
 */
public class Zoom<T> extends And<T> implements JsonBuilder, Serializable {

    private boolean enabled = true;
    private boolean drag;
    private Double sensitivity;
    private XYMode mode;
//    private ZoomLimit<T> limits;
    private ZoomRange<T> rangeMin;
    private ZoomRange<T> rangeMax;

    public Zoom(T parent) {
        super(parent);
    }

    /**
     * Enable zoom. Defaults to true.
     */
    public Zoom<T> enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Option exists in the zoom plugin but usage is not recommended when using a mouse.
     */
    public Zoom<T> drag(boolean drag) {
        this.drag = drag;
        return this;
    }

    public Zoom<T> sensitivity(double sensitivity) {
        this.sensitivity = sensitivity;
        return this;
    }

    /**
     * Axes on which zoom is enabled.
     */
    public Zoom<T> mode(XYMode mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Minimum range limits for zoom.
     * Range currently supports Double and String values. Usage depends on the datatypes in your scales.
     */
    public ZoomRange<T> rangeMin() {
        if (rangeMin == null) {
            rangeMin = new ZoomRange<>(this);
        }
        return rangeMin;
    }

    /**
     * Maximum range limits for zoom.
     * Range currently supports Double and String values. Usage depends on the datatypes in your scales.
     */
    public ZoomRange<T> rangeMax() {
        if (rangeMax == null) {
            rangeMax = new ZoomRange<>(this);
        }
        return rangeMax;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "enabled", enabled);
        JUtils.putNotNull(map, "drag", drag);
        JUtils.putNotNull(map, "sensitivity", sensitivity);
        if (mode != null) {
            JUtils.putNotNull(map, "mode", mode.name().toLowerCase());
        }
//        JUtils.putNotNull(map, "limits", limits);
        JUtils.putNotNull(map, "rangeMin", rangeMin);
        JUtils.putNotNull(map, "rangeMax", rangeMax);
        return map;
    }
}
