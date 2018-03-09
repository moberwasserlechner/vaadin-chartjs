package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.options.annotation.AbstractAnnotation;
import com.byteowls.vaadin.chartjs.options.annotation.BoxAnnotation;
import com.byteowls.vaadin.chartjs.options.annotation.DrawTime;
import com.byteowls.vaadin.chartjs.options.annotation.LineAnnotation;
import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Annotation plugin configuration
 */
public class AnnotationOptions<T> extends And<T> implements JsonBuilder {


    private static final long serialVersionUID = -4653427395957468095L;

    private DrawTime drawTime;
    private List<String> events;
    private Integer dblClickSpeed;
    private List<AbstractAnnotation> annotations;

    public AnnotationOptions(T parent) {
        super(parent);
    }


    /**
     * Defines when the annotations are drawn.
     * This allows positioning of the annotation relative to the other elements to the graph.
     */
    public AnnotationOptions<T> drawTime(DrawTime drawTime) {
        this.drawTime = drawTime;
        return this;
    }

//    /**
//     * Mouse events to enable on each annotation. Should be an array of one or more browser-supported mouse events
//     */
//    public AnnotationOptions<T> events(String... mouseEvents) {
//        this.events = Arrays.asList(mouseEvents);
//        return this;
//    }

    /**
     * Double-click speed in ms used to distinguish single-clicks from double-clicks whenever you need to capture both.
     *
     * When listening for both click and dblclick, click events will be delayed by this amount.
     *
     * Defaults to 350ms
     *
     */
    public AnnotationOptions<T> dblClickSpeed(int dblClickSpeedMs) {
        this.dblClickSpeed = dblClickSpeedMs;
        return this;
    }

    /**
     * Add a line annotation and step into its configuration.
     */
    public LineAnnotation<T> line() {
        if (annotations == null) {
            annotations = new ArrayList<>();
        }
        LineAnnotation<T> line = new LineAnnotation<>(this);
        this.annotations.add(line);
        return line;
    }

    /**
     * Add a box annotation and step into its configuration.
     */
    public BoxAnnotation<T> box() {
        if (annotations == null) {
            annotations = new ArrayList<>();
        }
        BoxAnnotation<T> box = new BoxAnnotation<>(this);
        this.annotations.add(box);
        return box;
    }

    /**
     * Remove all annotations from the list.
     */
    public void clearAnnotations() {
        this.annotations = null;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        if (drawTime != null) {
            JUtils.putNotNull(map, "drawTime", drawTime.name());
        }
        JUtils.putNotNullStringListOrSingle(map, "events", events);
        JUtils.putNotNull(map, "dblClickSpeed", dblClickSpeed);
        JUtils.putNotNullBuilders(map, "annotations", annotations);
        return map;
    }

}
