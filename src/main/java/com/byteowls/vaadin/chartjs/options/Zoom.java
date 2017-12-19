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

//    /**
//     * Embedded class to make future changes easier
//     * @param <R>
//     */
//    public class Range<R> extends And<Zoom<R>> implements JsonBuilder, Serializable {
//
//        private Double x;
//        private Double y;
//
//        public Range(Zoom<R> parent) {
//            super(parent);
//        }
//
//        /**
//         * X Value
//         */
//        public Range x(double x) {
//            this.x = x;
//            return this;
//        }
//
//        /**
//         * Y Value
//         */
//        public Range y(double y) {
//            this.y = y;
//            return this;
//        }
//
//        @Override
//        public JsonObject buildJson() {
//            JsonObject obj = Json.createObject();
//            JUtils.putNotNull(obj, "x", x);
//            JUtils.putNotNull(obj, "y", y);
//            return obj;
//        }
//    }

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

    public Zoom<T> mode(XYMode mode) {
        this.mode = mode;
        return this;
    }

    public ZoomRange<T> rangeMin() {
        if (rangeMin == null) {
            rangeMin = new ZoomRange<>(this);
        }
        return rangeMin;
    }

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
