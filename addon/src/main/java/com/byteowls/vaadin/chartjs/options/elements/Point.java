package com.byteowls.vaadin.chartjs.options.elements;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Point elements are used to represent the points in a line chart or a bubble chart.
 * 
 * @author michael@byteowls.com
 */
public class Point<T> extends And<Element<T>> implements JsonBuilder {
    
    private Integer radius;
    private String pointStyle;
    private String backgroundColor;
    private Integer borderWidth;
    private String borderColor;
    private Integer hitRadius;
    private Integer hoverRadius;
    private Integer hoverBorderWidth;

    public Point(Element<T> parent) {
        super(parent);
    }
    
    
    /**
     * Default point radius. Default: 3 
     */
    public Point<T> radius(int radius) {
        this.radius = radius;
        return this;
    }
    
    /**
     * Default point style. Default: circle
     */
    public Point<T> pointStyle(String pointStyle) {
        this.pointStyle = pointStyle;
        return this;
    }
    
    /**
     * Default point fill color. Default: 'rgba(0,0,0,0.1)'
     */
    public Point<T> backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }
    
    /**
     * Default point stroke width. Default: 1
     */
    public Point<T> borderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * Default point stroke color. Default: 'rgba(0,0,0,0.1)'
     */
    public Point<T> borderColor(String borderColor) {
        this.borderColor = borderColor;
        return this;
    }
    
    /**
     * Extra radius added to point radius for hit detection. Default: 1
     */
    public Point<T> hitRadius(int hitRadius) {
        this.hitRadius = hitRadius;
        return this;
    }
    
    /**
     * Default point radius when hovered. Default: 4
     */
    public Point<T> hoverRadius(int hoverRadius) {
        this.hoverRadius = hoverRadius;
        return this;
    }
    
    /**
     * Default stroke width when hovered. Default: 1
     */
    public Point<T> hoverBorderWidth(int hoverBorderWidth) {
        this.hoverBorderWidth = hoverBorderWidth;
        return this;
    }



    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "radius", radius);
        JUtils.putNotNull(map, "pointStyle", pointStyle);
        JUtils.putNotNull(map, "backgroundColor", backgroundColor);
        JUtils.putNotNull(map, "borderColor", borderColor);
        JUtils.putNotNull(map, "borderWidth", borderWidth);
        JUtils.putNotNull(map, "hitRadius", hitRadius);
        JUtils.putNotNull(map, "hoverRadius", hoverRadius);
        JUtils.putNotNull(map, "hoverBorderWidth", hoverBorderWidth);
        return map;
    }

}
