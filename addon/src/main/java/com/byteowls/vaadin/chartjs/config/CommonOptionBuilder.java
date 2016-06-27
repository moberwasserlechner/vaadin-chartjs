package com.byteowls.vaadin.chartjs.config;

import com.byteowls.vaadin.chartjs.json.JUtils;
import com.byteowls.vaadin.chartjs.json.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;
import elemental.json.JsonValue;

import java.util.Arrays;
import java.util.List;

public abstract class CommonOptionBuilder implements JsonBuilder {

    private Boolean responsive = true;
    private Boolean maintainAspectRatio = true;
    private Integer responsiveAnimationDuration;
    private TitleBuilder title;
    private HoverBuilder hover;
    private TooltipsBuilder tooltips;
    private List<String> events;

    public CommonOptionBuilder responsive(boolean responsive) {
        this.responsive = responsive;
        return this;
    }

    public CommonOptionBuilder maintainAspectRatio(boolean maintainAspectRatio) {
        this.maintainAspectRatio = maintainAspectRatio;
        return this;
    }

    public CommonOptionBuilder responsiveAnimationDuration(int responsiveAnimationDurationMs) {
        this.responsiveAnimationDuration = responsiveAnimationDurationMs;
        return this;
    }

    public CommonOptionBuilder events(String... events) {
        this.events = Arrays.asList(events);
        return this;
    }

    public TitleBuilder title() {
        if (title == null) {
            title = new TitleBuilder(this);
        }
        return title;
    }

    public HoverBuilder hover() {
        if (hover == null) {
            hover = new HoverBuilder(this);
        }
        return hover;
    }

    public TooltipsBuilder tooltips() {
        if (tooltips == null) {
            tooltips = new TooltipsBuilder(this);
        }
        return tooltips;
    }

    public CommonOptionBuilder done() {
        return this;
    }

    @Override
    public JsonValue buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "responsive", responsive);
        JUtils.putNotNull(map, "maintainAspectRatio", maintainAspectRatio);
        JUtils.putNotNull(map, "responsiveAnimationDuration", responsiveAnimationDuration);

        if (title != null) {
            JUtils.putNotNull(map, "title", title.buildJson());
        }
        if (hover != null) {
            JUtils.putNotNull(map, "hover", hover.buildJson());
        }
        if (tooltips != null) {
            JUtils.putNotNull(map, "tooltips", tooltips.buildJson());
        }

        JUtils.putNotNull(map, "events", events);
        return map;
    }

}
