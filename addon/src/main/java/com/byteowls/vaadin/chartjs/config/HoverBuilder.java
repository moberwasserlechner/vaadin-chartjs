package com.byteowls.vaadin.chartjs.config;

import com.byteowls.vaadin.chartjs.json.JUtils;
import com.byteowls.vaadin.chartjs.json.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;
import elemental.json.JsonValue;

public class HoverBuilder implements JsonBuilder {

    public enum Mode {
        SINGLE, LABEL, DATASET
    }

    private CommonOptionBuilder commonOptionBuilder;
    private Mode mode;
    private Integer animationDuration;
    // TODO Callback onhover

    HoverBuilder(CommonOptionBuilder commonOptionBuilder) {
        this.commonOptionBuilder = commonOptionBuilder;
    }

    public HoverBuilder mode(Mode mode) {
        this.mode = mode;
        return this;
    }

    public HoverBuilder animationDuration(int animationDuration) {
        this.animationDuration = animationDuration;
        return this;
    }

    public CommonOptionBuilder done() {
        return commonOptionBuilder;
    }

    @Override
    public JsonValue buildJson() {
        JsonObject map = Json.createObject();
        if (mode != null) {
            JUtils.putNotNull(map, "mode", mode.name().toLowerCase());
        }
        JUtils.putNotNull(map, "animationDuration", animationDuration);
        return map;
    }
}
