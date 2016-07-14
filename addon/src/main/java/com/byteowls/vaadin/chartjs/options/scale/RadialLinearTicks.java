package com.byteowls.vaadin.chartjs.options.scale;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.JsonObject;

/**
 * @author michael@byteowls.com
 */
public class RadialLinearTicks<T> extends Ticks<T> implements JsonBuilder {

    private Boolean beginAtZero;
    private String backdropColor;
    private Integer backdropPaddingX;
    private Integer backdropPaddingY;
    private Integer maxTicksLimit;
    private Boolean showLabelBackdrop;

    public RadialLinearTicks(T parent) {
        super(parent);
    }
    
    /**
     * if true, scale will include 0 if it is not already included.
     */
    public RadialLinearTicks<T> beginAtZero(Boolean beginAtZero) {
        this.beginAtZero = beginAtZero;
        return this;
    }

    /**
     * Color of label backdrops. Default: rgba(255, 255, 255, 0.75)
     */
    public RadialLinearTicks<T> backdropColor(String backdropColor) {
        this.backdropColor = backdropColor;
        return this;
    }

    /**
     * Horizontal padding of label backdrop. Default: 2
     */
    public RadialLinearTicks<T> backdropPaddingX(int backdropPaddingX) {
        this.backdropPaddingX = backdropPaddingX;
        return this;
    }

    /**
     * Vertical padding of label backdrop. Default: 2
     */
    public RadialLinearTicks<T> backdropPaddingY(int backdropPaddingY) {
        this.backdropPaddingY = backdropPaddingY;
        return this;
    }

    /**
     * Maximum number of ticks and gridlines to show. If not defined, it will limit to 11 ticks but will show all gridlines. Default: 11
     */
    public RadialLinearTicks<T> maxTicksLimit(int maxTicksLimit) {
        this.maxTicksLimit = maxTicksLimit;
        return this;
    }

    /**
     * If true, draw a background behind the tick labels. Default: true
     */
    public RadialLinearTicks<T> showLabelBackdrop(boolean showLabelBackdrop) {
        this.showLabelBackdrop = showLabelBackdrop;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "beginAtZero", beginAtZero);
        JUtils.putNotNull(map, "backdropColor", backdropColor);
        JUtils.putNotNull(map, "backdropPaddingX", backdropPaddingX);
        JUtils.putNotNull(map, "backdropPaddingY", backdropPaddingY);
        JUtils.putNotNull(map, "maxTicksLimit", maxTicksLimit);
        JUtils.putNotNull(map, "showLabelBackdrop", showLabelBackdrop);
        return map;
    }
}
