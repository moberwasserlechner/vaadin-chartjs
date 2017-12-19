package com.byteowls.vaadin.chartjs.options.zoom;

import com.byteowls.vaadin.chartjs.options.Zoom;
import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.io.Serializable;

/**
 *
 */
public class ZoomRange<T> extends And<Zoom<T>> implements JsonBuilder, Serializable {

    private Object x;
    private Object y;

    public ZoomRange(Zoom<T> parent) {
        super(parent);
    }

    public ZoomRange<T> x(double x) {
        this.x = x;
        return this;
    }

    public ZoomRange<T> x(String x) {
        this.x = x;
        return this;
    }

    public ZoomRange<T> y(double y) {
        this.y = y;
        return this;
    }

    public ZoomRange<T> y(String x) {
        this.x = x;
        return this;
    }


    @Override
    public JsonObject buildJson() {
        JsonObject obj = Json.createObject();
        setValue(obj, "x", x);
        setValue(obj, "y", y);
        return obj;
    }

    private void setValue(JsonObject obj, String key, Object value) {
        if (value instanceof String) {
            JUtils.putNotNull(obj, "x", (String) value);
        } else if (value instanceof Double) {
            JUtils.putNotNull(obj, "x", (Double) value);
        }
    }

}
