package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

public class Tooltips<T> extends And<T> implements JsonBuilder {

    private static final long serialVersionUID = -528926154599828794L;

    public enum PositionMode {
        /**
         * Places the tooltip at the average position of the items displayed in the tooltip.
         */
        AVERAGE,
        /**
         * Places the tooltip at the position of the element closest to the event position.
         */
        NEAREST
    }

    private Boolean enabled;
    // TODO custom call
    private InteractionMode mode;
    private InteractionAxis axis;
    private Boolean intersect;
    private PositionMode position;
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
    private Integer caretPadding;
    private Integer caretSize;
    private Integer cornerRadius;
    private String multiKeyBackground;
    private Boolean displayColors;
    private TooltipsCallbacks<Tooltips<T>> callbacks;
    private String borderColor;
    private Integer borderWidth;


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
     * Sets which elements appear in the tooltip. Defaults to {@link InteractionMode#NEAREST}
     */
    public Tooltips<T> mode(InteractionMode mode) {
        this.mode = mode;
        return this;
    }

    /**
     * Defines which directions are used in calculating distances. Defaults to {@link Axis#X} for index mode and {@link Axis#XY} in dataset and nearest modes.
     */
    public Tooltips<T> axis(InteractionAxis axis) {
        this.axis = axis;
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
     * The mode for positioning the tooltip.
     */
    public Tooltips<T> position(PositionMode position) {
        this.position = position;
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
     *  Extra distance to move the end of the tooltip arrow away from the tooltip point. Default: 2
     */
    public Tooltips<T> caretPadding(int caretPadding) {
        this.caretPadding = caretPadding;
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

    /**
     * Color of the border. Default: rgba(0,0,0,0)
     */
    public Tooltips<T> borderColor(String borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * Size of the border. Default: 0
     */
    public Tooltips<T> borderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * Callbacks for tooltip formatting.
     */
    public TooltipsCallbacks<Tooltips<T>> callbacks() {
        if (callbacks == null) {
            callbacks = new TooltipsCallbacks<>(this);
        }
        return callbacks;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "enabled", enabled);
        if (mode != null) {
            JUtils.putNotNull(map, "mode", mode.name().toLowerCase());
        }
        if (axis != null) {
            JUtils.putNotNull(map, "axis", axis.name().toLowerCase());
        }
        JUtils.putNotNull(map, "intersect", intersect);
        if (position != null) {
            JUtils.putNotNull(map, "position", position.name().toLowerCase());
        }
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
        JUtils.putNotNull(map, "caretPadding", caretPadding);
        JUtils.putNotNull(map, "caretSize", caretSize);
        JUtils.putNotNull(map, "cornerRadius", cornerRadius);
        JUtils.putNotNull(map, "multiKeyBackground", multiKeyBackground);
        JUtils.putNotNull(map, "displayColors", displayColors);
        JUtils.putNotNull(map, "borderColor", borderColor );
        JUtils.putNotNull(map, "borderWidth", borderWidth );
        if (callbacks != null) {
            JUtils.putNotNull(map, "callbacks", callbacks.buildJson());
        }
        return map;
    }
}
