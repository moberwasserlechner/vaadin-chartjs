package com.byteowls.vaadin.chartjs.config;

import com.byteowls.vaadin.chartjs.json.JUtils;
import com.byteowls.vaadin.chartjs.json.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;
import elemental.json.JsonValue;

public class TooltipsBuilder implements JsonBuilder {

    public enum Mode {
        SINGLE, LABEL
    }

    private CommonOptionBuilder commonOptionBuilder;
    private Boolean enabled;
    // TODO Callback onhover

    TooltipsBuilder(CommonOptionBuilder commonOptionBuilder) {
        this.commonOptionBuilder = commonOptionBuilder;
    }

    private Mode mode;

    public TooltipsBuilder enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public TooltipsBuilder mode(Mode mode) {
        this.mode = mode;
        return this;
    }

    public CommonOptionBuilder done() {
        return commonOptionBuilder;
    }

    @Override
    public JsonValue buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "enabled", enabled);
        if (mode != null) {
            JUtils.putNotNull(map, "mode", mode.name().toLowerCase());
        }
        return map;
    }
}
