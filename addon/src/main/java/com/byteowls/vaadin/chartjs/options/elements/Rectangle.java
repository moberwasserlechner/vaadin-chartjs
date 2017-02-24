package com.byteowls.vaadin.chartjs.options.elements;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Rectangle elements are used to represent the bars in a bar chart.
 * 
 * @author michael@byteowls.com
 */
public class Rectangle<T> extends And<Element<T>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = -7110880763985894909L;

    public enum RectangleEdge {
        BOTTOM, LEFT, TOP, RIGHT
    }

    private String backgroundColor;
    private String borderColor;
    private Integer borderWidth;
    private RectangleEdge borderSkipped;

    public Rectangle(Element<T> parent) {
        super(parent);
    }

    /**
     * Default bar fill color. Default: 'rgba(0,0,0,0.1)'
     */
    public Rectangle<T> backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Default bar stroke color. Default: 'rgba(0,0,0,0.1)'
     */
    public Rectangle<T> borderColor(String borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * Default bar stroke width. Default: 0
     */
    public Rectangle<T> borderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * Default skipped (excluded) border for rectangle. Can be one of bottom, left, top, right. Default: bottom
     */
    public Rectangle<T> borderSkipped(RectangleEdge borderSkipped) {
        this.borderSkipped = borderSkipped;
        return this;
    }


    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "backgroundColor", backgroundColor);
        JUtils.putNotNull(map, "borderColor", borderColor);
        JUtils.putNotNull(map, "borderWidth", borderWidth);
        if (borderSkipped != null) {
            JUtils.putNotNull(map, "borderSkipped", borderSkipped.name().toLowerCase());
        }
        return map;
    }

}
