package com.byteowls.vaadin.chartjs.options;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

public class Hover<T> extends And<T> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 1317225903701999027L;

    /**
     * @deprecated Use {@link InteractionMode} instead
     */
    public enum Mode {
        /**
         * Finds the first item that intersects the point and returns it.
         *
         * @deprecated Behaves like {@link InteractionMode#NEAREST} mode with {@link Hover#intersect(true)}.
         */
        SINGLE,
        /**
         * @deprecated Use {@link InteractionMode#INDEX} instead.
         */
        LABEL,
        /**
         * Finds items in the same dataset. If the intersect setting is true, the first intersecting item is used to determine the index in the data.
         * If intersect false the nearest item is used to determine the index.
         */
        DATASET
    }

    private InteractionMode mode;
    private Boolean intersect;
    private Integer animationDuration;
    // TODO Callback onhover Called when any of the events fire. Called in the context of the chart and passed an array of active elements (bars, points, etc)

    public Hover(T parent) {
        super(parent);
    }

    /**
     * <p>Sets which elements hover.</p>
     * single highlights the closest element
     * label highlights elements in all datasets at the same X value.
     * dataset highlights the closest dataset
     * @deprecated use {@link #mode(InteractionMode)} instead
     */
    public Hover<T> mode(Mode mode) {
        switch (mode) {
        case DATASET:
            mode(InteractionMode.DATASET);
            break;
        case LABEL:
            mode(InteractionMode.INDEX);
            break;
        case SINGLE:
            mode(InteractionMode.NEAREST);
            intersect(true);
            break;
        default:
            break;
        }
        return this;
    }

    /**
     * Sets which elements appear in the tooltip. Defaults to {@link InteractionMode#NEAREST}
     */
    public Hover<T> mode(InteractionMode mode) {
        this.mode = mode;
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
        JUtils.putNotNull(map, "intersect", intersect);
        JUtils.putNotNull(map, "animationDuration", animationDuration);
        return map;
    }
}
