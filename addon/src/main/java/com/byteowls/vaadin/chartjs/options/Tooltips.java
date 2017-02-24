package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class Tooltips<T> extends And<T> implements JsonBuilder {


    /**
     * @deprecated Use {@link InteractionMode} instead
     */
    public enum Mode {
        /**
         * Finds the first item that intersects the point and returns it.
         *
         * @deprecated Behaves like {@link InteractionMode#NEAREST} mode with {@link Hover#intersect(true)}.
         */
        SINGLE,
        /**
         * @deprecated Use {@link InteractionMode#INDEX} instead.
         */
        LABEL
    }

    private Boolean enabled;
    // TODO custom call
    private InteractionMode mode;
    private Boolean intersect;
    private String backgroundColor;
    private String titleFontFamily;
    private Integer titleFontSize;
    private String titleFontStyle;
    private String titleFontColor;
    private Integer titleSpacing;
    private Integer titleMarginBottom;
    private String bodyFontFamily;
    private Integer bodyFontSize;
    private String bodyFontStyle;
    private String bodyFontColor;
    private Integer bodySpacing;
    private String footerFontFamily;
    private Integer footerFontSize;
    private String footerFontStyle;
    private String footerFontColor;
    private Integer footerSpacing;
    private Integer footerMarginTop;
    private Integer xPadding;
    private Integer yPadding;
    private Integer caretSize;
    private Integer cornerRadius;
    private String multiKeyBackground;
    private Boolean displayColors;
    // TODO private String callbacks;


    public Tooltips(T parent) {
        super(parent);
    }

    /**
     * Are tooltips enabled
     */
    public Tooltips<T> enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Sets which elements appear in the tooltip.
     * single highlights the closest element.
     * label highlights elements in all datasets at the same X value.
     * defaults to {@link Mode#SINGLE}
     * @deprecated use {@link #mode(InteractionMode)} instead
     */
    public Tooltips<T> mode(Mode mode) {
        switch (mode) {
        case LABEL:
            mode(InteractionMode.INDEX);
            break;
        case SINGLE:
            mode(InteractionMode.NEAREST);
            intersect(true);
            break;
        default:
            break;
        }
        return this;
    }

    /**
     * Sets which elements appear in the tooltip. Defaults to {@link InteractionMode#NEAREST}
     */
    public Tooltips<T> mode(InteractionMode mode) {
        this.mode = mode;
        return this;
    }

    /**
     * If true, the tooltip mode applies only when the mouse position intersects with an element else 
     * the mode will be applied at all times. Defaults to true.
     */
    public Tooltips<T> intersect(boolean intersect) {
        this.intersect = intersect;
        return this;
    }

    /**
     * Background color of the tooltip. Defaults to 'rgba(0,0,0,0.8)'
     */
    public Tooltips<T> backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Font family for tooltip title inherited from global font family.
     */
    public Tooltips<T> titleFontFamily(String titleFontFamily) {
        this.titleFontFamily = titleFontFamily;
        return this;
    }

    /**
     * Font size for tooltip title inherited from global font size. Default: 12
     */
    public Tooltips<T> titleFontSize(int titleFontSize) {
        this.titleFontSize = titleFontSize;
        return this;
    }

    /**
     * Default: bold
     */
    public Tooltips<T> titleFontStyle(String titleFontStyle) {
        this.titleFontStyle = titleFontStyle;
        return this;
    }

    /**
     * Font color for tooltip title. Default: #fff
     */
    public Tooltips<T> titleFontColor(String titleFontColor) {
        this.titleFontColor = titleFontColor;
        return this;
    }

    /**
     * Spacing to add to top and bottom of each title line. Default: 2
     */
    public Tooltips<T> titleSpacing(int titleSpacing) {
        this.titleSpacing = titleSpacing;
        return this;
    }

    /**
     * Margin to add on bottom of title section. Default: 12
     */
    public Tooltips<T> titleMarginBottom(int titleMarginBottom) {
        this.titleMarginBottom = titleMarginBottom;
        return this;
    }

    /**
     * Font family for tooltip items inherited from global font family
     */
    public Tooltips<T> bodyFontFamily(String bodyFontFamily) {
        this.bodyFontFamily = bodyFontFamily;
        return this;
    }

    /**
     * Font size for tooltip items inherited from global font size. Default: 12
     */
    public Tooltips<T> bodyFontSize(int bodyFontSize) {
        this.bodyFontSize = bodyFontSize;
        return this;
    }

    /**
     * Default: normal 
     */
    public Tooltips<T> bodyFontStyle(String bodyFontStyle) {
        this.bodyFontStyle = bodyFontStyle;
        return this;
    }

    /**
     * Font color for tooltip items. Default: #fff
     */
    public Tooltips<T> bodyFontColor(String bodyFontColor) {
        this.bodyFontColor = bodyFontColor;
        return this;
    }

    /**
     * Spacing to add to top and bottom of each tooltip item. Default: 2
     */
    public Tooltips<T> bodySpacing(int bodySpacing) {
        this.bodySpacing = bodySpacing;
        return this;
    }

    /**
     * Font family for tooltip footer inherited from global font family.
     */
    public Tooltips<T> footerFontFamily(String footerFontFamily) {
        this.footerFontFamily = footerFontFamily;
        return this;
    }

    /**
     * Font size for tooltip footer inherited from global font size.
     */
    public Tooltips<T> footerFontSize(int footerFontSize) {
        this.footerFontSize = footerFontSize;
        return this;
    }

    /**
     * Font style for tooltip footer. Default: bold
     */
    public Tooltips<T> footerFontStyle(String footerFontStyle) {
        this.footerFontStyle = footerFontStyle;
        return this;
    }

    /**
     * Font color for tooltip footer. Default: #fff
     */
    public Tooltips<T> footerFontColor(String footerFontColor) {
        this.footerFontColor = footerFontColor;
        return this;
    }

    /**
     * Spacing to add to top and bottom of each footer line. Default: 2
     */
    public Tooltips<T> footerSpacing(int footerSpacing) {
        this.footerSpacing = footerSpacing;
        return this;
    }

    /**
     * Margin to add before drawing the footer. Default: 6
     */
    public Tooltips<T> footerMarginTop(int footerMarginTop) {
        this.footerMarginTop = footerMarginTop;
        return this;
    }

    /**
     * Padding to add on left and right of tooltip. Default: 6
     */
    public Tooltips<T> xPadding(int xPadding) {
        this.xPadding = xPadding;
        return this;
    }    

    /**
     * Padding to add on top and bottom of tooltip. Default: 6
     */
    public Tooltips<T> yPadding(int yPadding) {
        this.yPadding = yPadding;
        return this;
    }

    /**
     * Size, in px, of the tooltip arrow. Default: 5
     */
    public Tooltips<T> caretSize(int caretSize) {
        this.caretSize = caretSize;
        return this;
    }

    /**
     * Radius of tooltip corner curves. Default: 6
     */
    public Tooltips<T> cornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        return this;
    }

    /**
     * Color to draw behind the colored boxes when multiple items are in the tooltip. Default: #fff
     */
    public Tooltips<T> multiKeyBackground(String multiKeyBackground) {
        this.multiKeyBackground = multiKeyBackground;
        return this;
    }

    /**
     * If true, color boxes are shown in the tooltip. Default: true.
     */
    public Tooltips<T> displayColors(boolean displayColors) {
        this.displayColors = displayColors;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "enabled", enabled);
        if (mode != null) {
            JUtils.putNotNull(map, "mode", mode.name().toLowerCase());
        }
        JUtils.putNotNull(map, "intersect", intersect);
        JUtils.putNotNull(map, "backgroundColor", backgroundColor);
        JUtils.putNotNull(map, "titleFontFamily", titleFontFamily);
        JUtils.putNotNull(map, "titleFontSize", titleFontSize);
        JUtils.putNotNull(map, "titleFontStyle", titleFontStyle);
        JUtils.putNotNull(map, "titleFontColor", titleFontColor);
        JUtils.putNotNull(map, "titleSpacing", titleSpacing);
        JUtils.putNotNull(map, "titleMarginBottom", titleMarginBottom);
        JUtils.putNotNull(map, "bodyFontFamily", bodyFontFamily);
        JUtils.putNotNull(map, "bodyFontSize", bodyFontSize);
        JUtils.putNotNull(map, "bodyFontStyle", bodyFontStyle);
        JUtils.putNotNull(map, "bodyFontColor", bodyFontColor);
        JUtils.putNotNull(map, "bodySpacing", bodySpacing);
        JUtils.putNotNull(map, "footerFontFamily", footerFontFamily);
        JUtils.putNotNull(map, "footerFontSize", footerFontSize);
        JUtils.putNotNull(map, "footerFontStyle", footerFontStyle);
        JUtils.putNotNull(map, "footerFontColor", footerFontColor);
        JUtils.putNotNull(map, "footerSpacing", footerSpacing);
        JUtils.putNotNull(map, "footerMarginTop", footerMarginTop);
        JUtils.putNotNull(map, "xPadding", xPadding);
        JUtils.putNotNull(map, "yPadding", yPadding);
        JUtils.putNotNull(map, "caretSize", caretSize);
        JUtils.putNotNull(map, "cornerRadius", cornerRadius);
        JUtils.putNotNull(map, "multiKeyBackground", multiKeyBackground);
        JUtils.putNotNull(map, "displayColors", displayColors);
        return map;
    }
}
