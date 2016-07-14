package com.byteowls.vaadin.chartjs.options.elements;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class Element<T> extends And<T> implements JsonBuilder {
    
    private Arc<T> arc;
    private Line<T> line;
    private Point<T> point;
    private Rectangle<T> rectangle;

    public Element(T parent) {
        super(parent);
    }
    
    /**
     * Arcs are used in the polar area, doughnut and pie charts.
     */
    public Arc<T> arc() {
        if (arc == null) {
            arc = new Arc<>(this);
        }
        return arc;
    }
    
    /**
     * Line elements are used to represent the line in a line chart.
     */
    public Line<T> line() {
        if (line == null) {
            line = new Line<>(this);
        }
        return line;
    }
    
    /**
     * Point elements are used to represent the points in a line chart or a bubble chart.
     */
    public Point<T> point() {
        if (point == null) {
            point = new Point<>(this);
        }
        return point;
    }
    
    /**
     * Rectangle elements are used to represent the bars in a bar chart. 
     */
    public Rectangle<T> rectangle() {
        if (rectangle == null) {
            rectangle = new Rectangle<>(this);
        }
        return rectangle;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject obj = Json.createObject();
        JUtils.putNotNull(obj, "arc", arc);
        JUtils.putNotNull(obj, "line", line);
        JUtils.putNotNull(obj, "point", point);
        JUtils.putNotNull(obj, "rectangle", rectangle);
        return obj;
    }

}
