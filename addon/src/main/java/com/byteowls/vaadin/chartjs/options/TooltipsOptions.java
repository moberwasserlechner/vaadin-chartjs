package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import com.byteowls.vaadin.chartjs.utils.SubDone;
import elemental.json.Json;
import elemental.json.JsonObject;

public class TooltipsOptions<T> extends SubDone<T> implements JsonBuilder {

    public enum Mode {
        SINGLE, LABEL
    }

    private Boolean enabled;
    // TODO Callback onhover

    public TooltipsOptions(T parent) {
        super(parent);
    }

    private Mode mode;

    public TooltipsOptions<T> enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public TooltipsOptions<T> mode(Mode mode) {
        this.mode = mode;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "enabled", enabled);
        if (mode != null) {
            JUtils.putNotNull(map, "mode", mode.name().toLowerCase());
        }
        return map;
    }
}
