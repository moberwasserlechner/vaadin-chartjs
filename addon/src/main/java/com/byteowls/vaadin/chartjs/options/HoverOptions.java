package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import com.byteowls.vaadin.chartjs.utils.SubDone;
import elemental.json.Json;
import elemental.json.JsonObject;

public class HoverOptions<T> extends SubDone<T> implements JsonBuilder {

    public enum Mode {
        SINGLE, LABEL, DATASET
    }

    private Mode mode;
    private Integer animationDuration;
    // TODO Callback onhover

    public HoverOptions(T parent) {
        super(parent);
    }

    public HoverOptions<T> mode(Mode mode) {
        this.mode = mode;
        return this;
    }

    public HoverOptions<T> animationDuration(int animationDuration) {
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
