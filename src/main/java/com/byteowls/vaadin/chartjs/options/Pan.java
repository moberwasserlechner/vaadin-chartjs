package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.options.zoom.PanRange;
import com.byteowls.vaadin.chartjs.options.zoom.XYMode;
import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.io.Serializable;

/**
 * @author m.oberwasserlechner@byteowls.com
 */
public class Pan<T> extends And<T> implements JsonBuilder, Serializable {

//    /**
//     * Embedded class to make future changes easier
//     * @param <R>
//     */
//    public class Range<R> extends And<Pan<R>> implements JsonBuilder, Serializable {
//
//        private Double x;
//        private Double y;
//
//        public Range(Pan<R> parent) {
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
    private Double speed;
    private Double threshold;
    private XYMode mode;
    private PanRange<T> rangeMin;
    private PanRange<T> rangeMax;


    public Pan(T parent) {
        super(parent);
    }

    /**
     * Enable zoom. Defaults to true.
     */
    public Pan<T> enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Pan<T> speed(double speed) {
        this.speed = speed;
        return this;
    }

    public Pan<T> threshold(double threshold) {
        this.threshold = threshold;
        return this;
    }

    public Pan<T> mode(XYMode mode) {
        this.mode = mode;
        return this;
    }

    public PanRange<T> rangeMin() {
        if (rangeMin == null) {
            rangeMin = new PanRange<>(this);
        }
        return rangeMin;
    }

    public PanRange<T> rangeMax() {
        if (rangeMax == null) {
            rangeMax = new PanRange<>(this);
        }
        return rangeMax;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "enabled", enabled);
        JUtils.putNotNull(map, "speed", speed);
        JUtils.putNotNull(map, "threshold", threshold);
        if (mode != null) {
            JUtils.putNotNull(map, "mode", mode.name().toLowerCase());
        }
//        JUtils.putNotNull(map, "limits", limits);
        JUtils.putNotNull(map, "rangeMin", rangeMin);
        JUtils.putNotNull(map, "rangeMax", rangeMax);
        return map;
    }
}
