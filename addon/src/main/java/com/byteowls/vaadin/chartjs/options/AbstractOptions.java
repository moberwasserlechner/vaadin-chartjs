package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractOptions<T> implements JsonBuilder {

    protected Boolean responsive;
    private Integer responsiveAnimationDuration;
    private Boolean maintainAspectRatio;
    private List<String> events;
    private TitleOptions<T> title;
    private TooltipsOptions<T> tooltips;
    private HoverOptions<T> hover;
    private AnimationOptions<T> animation;

    public T responsive(boolean responsive) {
        this.responsive = responsive;
        return getThis();
    }

    public T maintainAspectRatio(boolean maintainAspectRatio) {
        this.maintainAspectRatio = maintainAspectRatio;
        return getThis();
    }

    public T responsiveAnimationDuration(int responsiveAnimationDurationMs) {
        this.responsiveAnimationDuration = responsiveAnimationDurationMs;
        return getThis();
    }

    public T events(String... events) {
        this.events = Arrays.asList(events);
        return getThis();
    }

    public TitleOptions<T> title() {
        if (title == null) {
            title = new TitleOptions<>(getThis());
        }
        return title;
    }

    public AnimationOptions<T> animation() {
        if (animation == null) {
            animation = new AnimationOptions<>(getThis());
        }
        return animation;
    }

    public HoverOptions<T> hover() {
        if (hover == null) {
            hover = new HoverOptions(getThis());
        }
        return hover;
    }

    public TooltipsOptions<T> tooltips() {
        if (tooltips == null) {
            tooltips = new TooltipsOptions<>(getThis());
        }
        return tooltips;
    }

    public abstract T getThis();

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "responsive", responsive);
        JUtils.putNotNull(map, "maintainAspectRatio", maintainAspectRatio);
        JUtils.putNotNull(map, "responsiveAnimationDuration", responsiveAnimationDuration);
        JUtils.putNotNull(map, "events", events);
        JUtils.putNotNull(map, "title", title);
        JUtils.putNotNull(map, "hover", hover);
        JUtils.putNotNull(map, "tooltips", tooltips);
        JUtils.putNotNull(map, "animation", animation);
        return map;
    }

}
