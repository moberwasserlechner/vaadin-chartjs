package com.byteowls.vaadin.chartjs.options.annotation;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.Json;
import elemental.json.JsonObject;

public class HorizontalLineAnnotation<T> extends AbstractAnnotation<T> implements Serializable {

    private static final long serialVersionUID = -2455507357025380823L;

    public HorizontalLineAnnotation(T parent, Double value) {
        super(parent);
        this.value = value;
    }

    private Integer borderWidth = 2;
    private String borderColor = "red";
    private Double value;

    public HorizontalLineAnnotation<T> borderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    public HorizontalLineAnnotation<T> borderColor(String borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    public HorizontalLineAnnotation<T> value(Double value) {
        this.value = value;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();

        JUtils.putNotNull(map, "type", "line");
        JUtils.putNotNull(map, "mode", "horizontal");
        JUtils.putNotNull(map, "scaleID", "y-axis-0");
        JUtils.putNotNull(map, "value", value);
        JUtils.putNotNull(map, "borderColor", borderColor);
        JUtils.putNotNull(map, "borderWidth", borderWidth);

        return map;
    }
}
