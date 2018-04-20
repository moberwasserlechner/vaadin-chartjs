package com.byteowls.vaadin.chartjs.options.annotation;

import com.byteowls.vaadin.chartjs.options.AnnotationOptions;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import elemental.json.JsonObject;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Allows drawing a horizontal or vertical line
 */
public class LineAnnotation<T> extends AbstractAnnotation<LineAnnotation<T>, T> implements Serializable {

    private static final long serialVersionUID = -2455507357025380823L;

    public LineAnnotation(AnnotationOptions<T> parent) {
        super(parent, "line");
    }

    private Boolean vertical;
    private String scaleID;
    private Object value;
//    private Double doubleValue;
//    private String stringValue;
    private Object endValue;
    private String borderColor;
    private Integer borderWidth;
    private List<Integer> borderDash;
    private Integer borderDashOffset;
    private LineLabel<T> label;

    /**
     * Draw a vertical line
     */
    public LineAnnotation<T> vertical() {
        this.vertical = true;
        return this;
    }

    /**
     * Draw a horizontal line. Default!
     */
    public LineAnnotation<T> horizontal() {
        this.vertical = false;
        return this;
    }

    /**
     * ID of the scale to bind onto
     */
    public LineAnnotation<T> scaleID(String scaleID) {
        this.scaleID = scaleID;
        return this;
    }

    /**
     * Binds the annotation to the x-axis-0 scale
     */
    public LineAnnotation<T> xAxis0ScaleID() {
        this.scaleID = "x-axis-0";
        return this;
    }

    /**
     * Binds the annotation to the y-axis-0 scale
     */
    public LineAnnotation<T> yAxis0ScaleID() {
        this.scaleID = "y-axis-0";
        return this;
    }


    /**
     * Double data value to draw the line at
     */
    public LineAnnotation<T> value(Double value) {
        this.value = value;
        return this;
    }

    /**
     * String data value to draw the line at
     */
    public LineAnnotation<T> value(String value) {
        this.value = value;
        return this;
    }

    /**
     * Optional value at which the line draw should end
     */
    public LineAnnotation<T> endValue(Double endValue) {
        this.endValue = endValue;
        return this;
    }

    /**
     * Optional value at which the line draw should end
     */
    public LineAnnotation<T> endValue(String endValue) {
        this.endValue = endValue;
        return this;
    }

    /**
     * Line color
     */
    public LineAnnotation<T> borderColor(String borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * Line width
     */
    public LineAnnotation<T> borderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * Line dash
     * https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/setLineDash
     */
    public LineAnnotation<T> borderDash(Integer... borderDash) {
        this.borderDash = Arrays.asList(borderDash);
        return this;
    }

    /**
     * Line Dash Offset
     * https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/lineDashOffset
     */
    public LineAnnotation<T> borderDashOffset(int borderDashOffset) {
        this.borderDashOffset = borderDashOffset;
        return this;
    }

    /**
     * The line's label configuration. This enables the label.
     */
    public LineLabel<T> label() {
        if (this.label == null) {
            this.label = new LineLabel<>(this);
            this.label.enabled(true);
        }
        return this.label;
    }

    @Override
    public LineAnnotation<T> getThis() {
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        if (this.vertical != null) {
            JUtils.putNotNull(map, "mode", this.vertical ? "vertical" : "horizontal");
        }
        JUtils.putNotNull(map, "scaleID", scaleID);
        JUtils.putNotNullObj(map, "value", value);
//        JUtils.putNotNull(map, "value", stringValue);
//        JUtils.putNotNull(map, "value", doubleValue);
        JUtils.putNotNullObj(map, "endValue", endValue);
        JUtils.putNotNull(map, "borderColor", borderColor);
        JUtils.putNotNull(map, "borderWidth", borderWidth);
        JUtils.putNotNullIntList(map, "borderDash", borderDash);
        JUtils.putNotNull(map, "borderDashOffset", borderDashOffset);
        JUtils.putNotNull(map, "label", label);

        return map;
    }
}
