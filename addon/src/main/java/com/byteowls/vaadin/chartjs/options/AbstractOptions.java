package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.byteowls.vaadin.chartjs.options.elements.Element;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractOptions<T> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 2220469604021816291L;

    private ChartConfig chartConfig;

    protected Boolean responsive;
    private Integer responsiveAnimationDuration;
    private Boolean maintainAspectRatio;
    private List<String> events;
    private Title<T> title;
    private Tooltips<T> tooltips;
    private Hover<T> hover;
    private Animation<T> animation;
    private Legend<T> legend;
    private Element<T> elements;

    public AbstractOptions(ChartConfig chartConfig) {
        this.chartConfig = chartConfig;
    }

    /**
     * Resizes when the canvas container does.
     */
    public T responsive(boolean responsive) {
        this.responsive = responsive;
        return getThis();
    }

    /**
     * Maintain the original canvas aspect ratio (width / height) when resizing
     */
    public T maintainAspectRatio(boolean maintainAspectRatio) {
        this.maintainAspectRatio = maintainAspectRatio;
        return getThis();
    }

    /**
     * Duration in milliseconds it takes to animate to new size after a resize event.
     */
    public T responsiveAnimationDuration(int responsiveAnimationDurationMs) {
        this.responsiveAnimationDuration = responsiveAnimationDurationMs;
        return getThis();
    }

    /**
     * Events that the chart should listen to for tooltips and hovering
     */
    public T events(String... events) {
        this.events = Arrays.asList(events);
        return getThis();
    }

    /**
     * Step into the charts title configuration
     */
    public Title<T> title() {
        if (title == null) {
            title = new Title<>(getThis());
        }
        return title;
    }

    /**
     * Step into the charts animation configuration
     */
    public Animation<T> animation() {
        if (animation == null) {
            animation = new Animation<>(getThis());
        }
        return animation;
    }

    /**
     * Step into the charts hover configuration
     */
    public Hover<T> hover() {
        if (hover == null) {
            hover = new Hover<>(getThis());
        }
        return hover;
    }

    /**
     * Step into the charts tooltip configuration
     */
    public Tooltips<T> tooltips() {
        if (tooltips == null) {
            tooltips = new Tooltips<>(getThis());
        }
        return tooltips;
    }

    /**
     * Step into the charts legend configuration
     */
    public Legend<T> legend() {
        if (legend == null) {
            legend = new Legend<>(getThis());
        }
        return legend;
    }
    
    /**
     * Step into the charts elements configuration
     */
    public Element<T> elements() {
        if (elements == null) {
            elements = new Element<>(getThis());
        }
        return elements;
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
        JUtils.putNotNull(map, "legend", legend);
        JUtils.putNotNull(map, "elements", elements);
        return map;
    }

    public ChartConfig done() {
        return chartConfig;
    }

}
