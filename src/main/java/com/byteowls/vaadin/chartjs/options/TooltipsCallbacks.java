package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Callbacks for tooltips. All values are JavaScript functions which take the described arguments.
 * <p>
 * https://www.chartjs.org/docs/latest/configuration/tooltip.html#tooltip-callbacks
 */
public class TooltipsCallbacks<T> extends And<T> implements JsonBuilder {
    /**
     * Arguments: tooltipItems (Array), data
     */
    String beforeTitle;

    /**
     * Arguments: tooltipItems (Array), data
     */
    String title;

    /**
     * Arguments: tooltipItems (Array), data
     */
    String afterTitle;

    /**
     * Arguments: tooltipItems (Array), data
     */
    String beforeBody;

    /**
     * Arguments: tooltipItem, data
     */
    String beforeLabel;

    /**
     * Arguments: tooltipItem, data
     * <p>
     * https://www.chartjs.org/docs/latest/configuration/tooltip.html#label-callback
     */
    String label;

    /**
     * Arguments: tooltipItem, chart
     */
    String labelColor;

    /**
     * Arguments: tooltipItem, chart
     */
    String labelTextColor;

    /**
     * Arguments: tooltipItem, data
     */
    String afterLabel;

    /**
     * Arguments: tooltipItems (Array), data
     */
    String afterBody;

    /**
     * Arguments: tooltipItems (Array), data
     */
    String beforeFooter;

    /**
     * Arguments: tooltipItems (Array), data
     */
    String footer;

    /**
     * Arguments: tooltipItems (Array), data
     */
    String afterFooter;

    public TooltipsCallbacks(T parent) {
        super(parent);
    }

    /**
     * Arguments: tooltipItems (Array), data
     */
    public TooltipsCallbacks<T> beforeTitle(String beforeTitle) {
        this.beforeTitle = beforeTitle;
        return this;
    }

    /**
     * Arguments: tooltipItems (Array), data
     */
    public TooltipsCallbacks<T> title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Arguments: tooltipItems (Array), data
     */
    public TooltipsCallbacks<T> afterTitle(String afterTitle) {
        this.afterTitle = afterTitle;
        return this;
    }

    /**
     * Arguments: tooltipItems (Array), data
     */
    public TooltipsCallbacks<T> beforeBody(String beforeBody) {
        this.beforeBody = beforeBody;
        return this;
    }

    /**
     * Arguments: tooltipItem, data
     */
    public TooltipsCallbacks<T> beforeLabel(String beforeLabel) {
        this.beforeLabel = beforeLabel;
        return this;
    }

    /**
     * Arguments: tooltipItem, data
     */
    public TooltipsCallbacks<T> label(String label) {
        this.label = label;
        return this;
    }

    /**
     * Arguments: tooltipItem, chart
     */
    public TooltipsCallbacks<T> labelColor(String labelColor) {
        this.labelColor = labelColor;
        return this;
    }

    /**
     * Arguments: tooltipItem, chart
     */
    public TooltipsCallbacks<T> labelTextColor(String labelTextColor) {
        this.labelTextColor = labelTextColor;
        return this;
    }

    /**
     * Arguments: tooltipItem, data
     */
    public TooltipsCallbacks<T> afterLabel(String afterLabel) {
        this.afterLabel = afterLabel;
        return this;
    }

    /**
     * Arguments: tooltipItems (Array), data
     */
    public TooltipsCallbacks<T> afterBody(String afterBody) {
        this.afterBody = afterBody;
        return this;
    }

    /**
     * Arguments: tooltipItems (Array), data
     */
    public TooltipsCallbacks<T> beforeFooter(String beforeFooter) {
        this.beforeFooter = beforeFooter;
        return this;
    }

    /**
     * Arguments: tooltipItems (Array), data
     */
    public TooltipsCallbacks<T> footer(String footer) {
        this.footer = footer;
        return this;
    }

    /**
     * Arguments: tooltipItems (Array), data
     */
    public TooltipsCallbacks<T> afterFooter(String afterFooter) {
        this.afterFooter = afterFooter;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNullCallback(map, "beforeTitle", beforeTitle, "tooltipItems", "data");
        JUtils.putNotNullCallback(map, "title", title, "tooltipItems", "data");
        JUtils.putNotNullCallback(map, "afterTitle", afterTitle, "tooltipItems", "data");
        JUtils.putNotNullCallback(map, "beforeBody", beforeBody, "tooltipItems", "data");
        JUtils.putNotNullCallback(map, "beforeLabel", beforeLabel, "tooltipItem", "data");
        JUtils.putNotNullCallback(map, "label", label, "tooltipItem", "data");
        JUtils.putNotNullCallback(map, "labelColor", labelColor, "tooltipItem", "chart");
        JUtils.putNotNullCallback(map, "labelTextColor", labelTextColor, "tooltipItem", "chart");
        JUtils.putNotNullCallback(map, "afterLabel", afterLabel, "tooltipItem", "data");
        JUtils.putNotNullCallback(map, "afterBody", afterBody, "tooltipItems", "data");
        JUtils.putNotNullCallback(map, "beforeFooter", beforeFooter, "tooltipItems", "data");
        JUtils.putNotNullCallback(map, "footer", footer, "tooltipItems", "data");
        JUtils.putNotNullCallback(map, "afterFooter", afterFooter, "tooltipItems", "data");
        return map;
    }

}
