package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

public class Hover<T> extends And<T> implements JsonBuilder {

    public enum Mode {
        SINGLE, LABEL, DATASET
    }

    private Mode mode;
    private Integer animationDuration;
    // TODO Callback onhover Called when any of the events fire. Called in the context of the chart and passed an array of active elements (bars, points, etc)

    public Hover(T parent) {
        super(parent);
    }

    /**
     * Sets which elements hover.
     * <li>single highlights the closest element
     * <li>label highlights elements in all datasets at the same X value.
     * <li>dataset highlights the closest dataset
     */
    public Hover<T> mode(Mode mode) {
        this.mode = mode;
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
        JUtils.putNotNull(map, "animationDuration", animationDuration);
        return map;
    }
}
