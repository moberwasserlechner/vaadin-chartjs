package com.byteowls.vaadin.chartjs.config;

import com.byteowls.vaadin.chartjs.json.JUtils;
import com.byteowls.vaadin.chartjs.json.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;
import elemental.json.JsonValue;

public class TitleBuilder implements JsonBuilder {

    private CommonOptionBuilder commonOptionBuilder;
    private Boolean display;
    private String text;

    TitleBuilder(CommonOptionBuilder commonOptionBuilder) {
        super();
        this.commonOptionBuilder = commonOptionBuilder;
    }

    public TitleBuilder display(boolean display) {
        this.display = display;
        return this;
    }

    public TitleBuilder text(String text) {
        this.text = text;
        return this;
    }

    public CommonOptionBuilder done() {
        return commonOptionBuilder;
    }

    @Override
    public JsonValue buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "display", display);
        JUtils.putNotNull(map, "text", text);
        return map;
    }
}
