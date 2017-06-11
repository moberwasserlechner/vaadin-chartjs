package com.byteowls.vaadin.chartjs.options;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class Legend<T> extends And<T> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 6555390015983393957L;

    private Boolean display;
    private Position position;
    private Boolean fullWidth;
    private LegendLabel<T> labels;

    public Legend(T parent) {
        super(parent);
    }

    /**
     * Is the legend displayed. Default: true
     */
    public Legend<T> display(boolean display) {
        this.display = display;
        return this;
    }

    /**
     * Position of the legend. Options are 'top' or 'bottom'. Default: top
     */
    public Legend<T> position(Position position) {
        this.position = position;
        return this;
    }

    /**
     * Marks that this box should take the full width of the canvas (pushing down other boxes). Default: true
     */
    public Legend<T> fullWidth(boolean fullWidth) {
        this.fullWidth = fullWidth;
        return this;
    }

    public LegendLabel<T> labels() {
        if (labels == null) {
            labels = new LegendLabel<>(this);
        }
        return labels;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "display", display);
        if (position != null) {
            JUtils.putNotNull(map, "position", position.name().toLowerCase());
        }
        JUtils.putNotNull(map, "fullWidth", fullWidth);
        JUtils.putNotNull(map, "labels", labels);
        return map;
    }

}
