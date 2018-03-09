package com.byteowls.vaadin.chartjs.options.annotation;

import com.byteowls.vaadin.chartjs.options.AnnotationOptions;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import elemental.json.JsonObject;

import java.io.Serializable;

public class BoxAnnotation<T> extends AbstractAnnotation<BoxAnnotation<T>, T> implements Serializable {

    private static final long serialVersionUID = -2455507357025380823L;

    public BoxAnnotation(AnnotationOptions<T> parent) {
        super(parent, "box");
    }

    private String xScaleID;
    private String yScaleID;

    private Object xMin;
    private Object xMax;
    private Object yMin;
    private Object yMax;

    private Double value;
    private Double endValue;
    private String borderColor;
    private Integer borderWidth;
    private String backgroundColor;

    /**
     * ID of the X scale to bind onto
     */
    public BoxAnnotation<T> xScaleID(String xScaleID) {
        this.xScaleID = xScaleID;
        return this;
    }

    /**
     * ID of the Y scale to bind onto
     */
    public BoxAnnotation<T> yScaleID(String yScaleID) {
        this.yScaleID = yScaleID;
        return this;
    }

    /**
     * Left edge of the box. in units along the x axis
     */
    public BoxAnnotation<T> xMin(Object xMin) {
        this.xMin = xMin;
        return this;
    }

    /**
     *  Right edge of the box
     */
    public BoxAnnotation<T> xMax(Object xMax) {
        this.xMax = xMax;
        return this;
    }

    /**
     * Top edge of the box in units along the y axis
     */
    public BoxAnnotation<T> yMax(Object yMax) {
        this.yMax = yMax;
        return this;
    }

    /**
     * Bottom edge of the box
     */
    public BoxAnnotation<T> yMin(Object yMin) {
        this.yMin = yMin;
        return this;
    }

    /**
     * The border color of the box
     */
    public BoxAnnotation<T> borderColor(String borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * The border width of the box
     */
    public BoxAnnotation<T> borderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * The background color
     */
    public BoxAnnotation<T> backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }


    @Override
    public BoxAnnotation<T> getThis() {
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "xScaleID", xScaleID);
        JUtils.putNotNull(map, "yScaleID", yScaleID);

        JUtils.putNotNullObj(map, "xMin", xMin);
        JUtils.putNotNullObj(map, "xMax", xMax);
        JUtils.putNotNullObj(map, "yMax", yMax);
        JUtils.putNotNullObj(map, "yMin", yMin);

        JUtils.putNotNull(map, "value", value);
        JUtils.putNotNull(map, "endValue", endValue);

        JUtils.putNotNull(map, "borderColor", borderColor);
        JUtils.putNotNull(map, "borderWidth", borderWidth);
        JUtils.putNotNull(map, "backgroundColor", backgroundColor);

        return map;
    }
}
