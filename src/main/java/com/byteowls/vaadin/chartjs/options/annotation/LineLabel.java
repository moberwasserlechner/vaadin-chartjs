package com.byteowls.vaadin.chartjs.options.annotation;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.io.Serializable;

/**
 * Line annotation label
 * @author m.oberwasserlechner@byteowls.com
 */
public class LineLabel<T> extends And<LineAnnotation<T>> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 7711321721000267107L;

    public enum Position {
        top, bottom, left, right, center
    }

    private String backgroundColor;
    private String fontFamily;
    private Integer fontSize;
    private String fontStyle;
    private String fontColor;
    private Position position;
    private Integer xPadding;
    private Integer yPadding;
    private Integer cornerRadius;
    private Integer xAdjust;
    private Integer yAdjust;
    private Boolean enabled;
    private String content;

    public LineLabel(LineAnnotation<T> parent) {
        super(parent);
    }

    /**
     * Background color of label. Defaults to rgba(0,0,0,0.8)
     */
    public LineLabel<T> backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * Font family of text, inherits from global
     */
    public LineLabel<T> fontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    /**
     * Font size of text, inherits from global
     */
    public LineLabel<T> fontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    /**
     * Font style of text. Defaults to bold.
     */
    public LineLabel<T> fontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }

    /**
     * Font color of text. Defaults to #fff.
     */
    public LineLabel<T> fontColor(String fontColor) {
        this.fontColor = fontStyle;
        return this;
    }

    /**
     * Padding of label to add left/right. Defaults to 6.
     */
    public LineLabel<T> xPadding(int xPadding) {
        this.xPadding = xPadding;
        return this;
    }

    /**
     * Padding of label to add top/bottom. Defaults to 6.
     */
    public LineLabel<T> yPadding(int yPadding) {
        this.yPadding = yPadding;
        return this;
    }

    /**
     * Radius of label rectangle. Defaults to 6.
     */
    public LineLabel<T> cornerRadius(int cornerRadius) {
        this.cornerRadius = cornerRadius;
        return this;
    }

    /**
     * Anchor position of label on line. Defaults to {@link Position#center}.
     */
    public LineLabel<T> position(Position position) {
        this.position = position;
        return this;
    }

    /**
     * Adjustment along x-axis (left-right) of label relative to above number (can be negative)
     * For horizontal lines positioned left or right, negative values move the label toward the edge, and positive values toward the center.
     * Defaults to 0.
     */
    public LineLabel<T> xAdjust(int xAdjust) {
        this.xAdjust = xAdjust;
        return this;
    }

    /**
     * Adjustment along y-axis (top-bottom) of label relative to above number (can be negative).
     * For vertical lines positioned top or bottom, negative values move the label toward the edge, and positive values toward the center.
     * Defaults to 0.
     */
    public LineLabel<T> yAdjust(int yAdjust) {
        this.yAdjust = yAdjust;
        return this;
    }

    /**
     * Whether the label is enabled and should be displayed. Defaults to false.
     */
    public LineLabel<T> enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Text to display in label. Defaults to null.
     */
    public LineLabel<T> content(String content) {
        this.content = content;
        return this;
    }


    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "backgroundColor", backgroundColor);
        JUtils.putNotNull(map, "fontFamily", fontFamily);
        JUtils.putNotNull(map, "fontSize", fontSize);
        JUtils.putNotNull(map, "fontStyle", fontStyle);
        JUtils.putNotNull(map, "fontColor", fontColor);
        JUtils.putNotNull(map, "xPadding", xPadding);
        JUtils.putNotNull(map, "yPadding", yPadding);
        JUtils.putNotNull(map, "cornerRadius", cornerRadius);
        if (this.position != null) {
            JUtils.putNotNull(map, "position", position.name());
        }
        JUtils.putNotNull(map, "xAdjust", xAdjust);
        JUtils.putNotNull(map, "yAdjust", yAdjust);
        JUtils.putNotNull(map, "enabled", enabled);
        JUtils.putNotNull(map, "content", content);
        return map;
    }
}
