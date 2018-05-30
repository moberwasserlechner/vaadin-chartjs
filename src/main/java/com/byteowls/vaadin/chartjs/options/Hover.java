package com.byteowls.vaadin.chartjs.options;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

public class Hover<T> extends And<T> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 1317225903701999027L;

    private InteractionMode mode;
    private InteractionAxis axis;
    private Boolean intersect;
    private Integer animationDuration;
    // TODO Callback onhover Called when any of the events fire. Called in the context of the chart and passed an array of active elements (bars, points, etc)

    public Hover(T parent) {
        super(parent);
    }

    /**
     * Sets which elements appear in the tooltip. Defaults to {@link InteractionMode#NEAREST}
     */
    public Hover<T> mode(InteractionMode mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Defines which directions are used in calculating distances. Defaults to {@link Axis#X} for index mode and {@link Axis#XY} in dataset and nearest modes.
     */
    public Hover<T> axis(InteractionAxis axis) {
        this.axis = axis;
        return this;
    }

    /**
     * If true, the hover mode only applies when the mouse position intersects an item on the chart. Defaults to true.
     */
    public Hover<T> intersect(boolean intersect) {
        this.intersect = intersect;
        return this;
    }

    /**
     * Duration in milliseconds it takes to animate hover style changes
     */
    public Hover<T> animationDuration(int animationDuration) {
        this.animationDuration = animationDuration;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        if (mode != null) {
            JUtils.putNotNull(map, "mode", mode.name().toLowerCase());
        }
        if (axis != null) {
            JUtils.putNotNull(map, "axis", axis.name().toLowerCase());
        }
        JUtils.putNotNull(map, "intersect", intersect);
        JUtils.putNotNull(map, "animationDuration", animationDuration);
        return map;
    }
}
