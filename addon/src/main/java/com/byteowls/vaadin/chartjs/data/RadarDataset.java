package com.byteowls.vaadin.chartjs.data;

import java.util.Arrays;
import java.util.List;

import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * @author michael@byteowls.com
 *
 */
public class RadarDataset implements Dataset<RadarDataset, Double> {

    private String type;
    private List<Double> data;
    private Boolean hidden;
    private String label;
    private Boolean fill;
    private Double lineTension;
    private String backgroundColor;
    private Integer borderWidth;
    private String borderColor;
    private String borderCapStyle;
    private List<Integer> borderDash;
    private Double borderDashOffset;
    private String borderJoinStyle;
    private List<String> pointBorderColor;
    private List<String> pointBackgroundColor;
    private List<Integer> pointBorderWidth;
    private List<Integer> pointRadius;
    private List<Integer> pointHoverRadius;
    private List<Integer> hitRadius;
    private List<String> pointHoverBackgroundColor;
    private List<String> pointHoverBorderColor;
    private List<Integer> pointHoverBorderWidth;
    private PointStyle pointStyle;

    /**
     * Used if the type of a dataset is needed. e.g. combo chart type charts
     */
    public RadarDataset type() {
        type = "radar";
        return this;
    }

    @Override
    public RadarDataset data(Double... data) {
        this.data = Arrays.asList(data);
        return this;
    }

    @Override
    public RadarDataset dataAsList(List<Double> data) {
        this.data = data;
        return this;
    }

    @Override
    public List<Double> getData() {
        return data;
    }

    /**
     * The label for the dataset which appears in the legend and tooltips
     */
    public RadarDataset label(String label) {
        this.label = label;
        return this;
    }

    /**
     * If true, fill the area under the line
     */
    public RadarDataset fill(boolean fill) {
        this.fill = fill;
        return this;
    }

    /**
     * If true, the dataset is hidden
     */
    public RadarDataset hidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * Bezier curve tension of the line. Set to 0 to draw straightlines.
     */
    public RadarDataset lineTension(double lineTension) {
        this.lineTension = lineTension;
        return this;
    }

    /**
     * The fill color under the line.
     */
    public RadarDataset backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * The width of the line in pixels
     */
    public RadarDataset borderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * The color of the line.
     */
    public RadarDataset borderColor(String borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * Cap style of the line. See https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/lineCap
     */
    public RadarDataset borderCapStyle(String borderCapStyle) {
        this.borderCapStyle = borderCapStyle;
        return this;
    }

    /**
     * Length and spacing of dashes.
     */
    public RadarDataset borderDash(Integer... borderDash) {
        this.borderDash = Arrays.asList(borderDash);
        return this;
    }

    /**
     * Offset for line dashes.
     */
    public RadarDataset borderDashOffset(double borderDashOffset) {
        this.borderDashOffset = borderDashOffset;
        return this;
    }

    /**
     * Line joint style.
     */
    public RadarDataset borderJoinStyle(String borderJoinStyle) {
        this.borderJoinStyle = borderJoinStyle;
        return this;
    }

    /**
     * The border color for points.
     */
    public RadarDataset pointBorderColor(String... pointBorderColor) {
        this.pointBorderColor = Arrays.asList(pointBorderColor);
        return this;
    }

    /**
     * The fill color for points
     */
    public RadarDataset pointBackgroundColor(String... pointBackgroundColor) {
        this.pointBackgroundColor = Arrays.asList(pointBackgroundColor);
        return this;
    }


    /**
     * The width of the point border in pixels
     */
    public RadarDataset pointBorderWidth(Integer... pointBorderWidth) {
        this.pointBorderWidth = Arrays.asList(pointBorderWidth);
        return this;
    }

    /**
     * The radius of the point shape. If set to 0, nothing is rendered.
     */
    public RadarDataset pointRadius(Integer... pointRadius) {
        this.pointRadius = Arrays.asList(pointRadius);
        return this;
    }

    /**
     * The radius of the point when hovered
     */
    public RadarDataset pointHoverRadius(Integer... pointHoverRadius) {
        this.pointHoverRadius = Arrays.asList(pointHoverRadius);
        return this;
    }

    /**
     * The pixel size of the non-displayed point that reacts to mouse events
     */
    public RadarDataset hitRadius(Integer... hitRadius) {
        this.hitRadius = Arrays.asList(hitRadius);
        return this;
    }

    /**
     * Point background color when hovered
     */
    public RadarDataset pointHoverBackgroundColor(String... pointHoverBackgroundColor) {
        this.pointHoverBackgroundColor = Arrays.asList(pointHoverBackgroundColor);
        return this;
    }

    /**
     * Point border color when hovered
     */
    public RadarDataset pointHoverBorderColor(String... pointHoverBorderColor) {
        this.pointHoverBorderColor = Arrays.asList(pointHoverBorderColor);
        return this;
    }

    /**
     * Border width of point when hovered
     */
    public RadarDataset pointHoverBorderWidth(Integer... pointHoverBorderWidth) {
        this.pointHoverBorderWidth = Arrays.asList(pointHoverBorderWidth);
        return this;
    }


    /**
     * The style of point. Options are 'circle', 'triangle', 'rect', 'rectRot', 'cross', 'crossRot', 'star', 'line', and 'dash'. 
     */
    public RadarDataset pointStyle(PointStyle pointStyle) {
        this.pointStyle = pointStyle;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "type", type);
        JUtils.putNotNullNumbers(map, "data", data);
        JUtils.putNotNull(map, "label", label);
        JUtils.putNotNull(map, "fill", fill);
        JUtils.putNotNull(map, "hidden", hidden);
        JUtils.putNotNull(map, "lineTension", lineTension);
        JUtils.putNotNull(map, "backgroundColor", backgroundColor);
        JUtils.putNotNull(map, "borderWidth", borderWidth);
        JUtils.putNotNull(map, "borderColor", borderColor);
        JUtils.putNotNull(map, "borderCapStyle", borderCapStyle);
        JUtils.putNotNullIntList(map, "borderDash", borderDash);
        JUtils.putNotNull(map, "borderDashOffset", borderDashOffset);
        JUtils.putNotNull(map, "borderJoinStyle", borderJoinStyle);
        JUtils.putNotNullStringListOrSingle(map, "pointBorderColor", pointBorderColor);
        JUtils.putNotNullStringListOrSingle(map, "pointBackgroundColor", pointBackgroundColor);
        JUtils.putNotNullIntListOrSingle(map, "pointBorderWidth", pointBorderWidth);
        JUtils.putNotNullIntListOrSingle(map, "pointRadius", pointRadius);
        JUtils.putNotNullIntListOrSingle(map, "pointHoverRadius", pointHoverRadius);
        JUtils.putNotNullIntListOrSingle(map, "hitRadius", hitRadius);
        JUtils.putNotNullStringListOrSingle(map, "pointHoverBackgroundColor", pointHoverBackgroundColor);
        JUtils.putNotNullStringListOrSingle(map, "pointHoverBorderColor", pointHoverBorderColor);
        JUtils.putNotNullIntListOrSingle(map, "pointHoverBorderWidth", pointHoverBorderWidth);
        if (pointStyle != null) {
            JUtils.putNotNull(map, "pointStyle", pointStyle.name());
        }
        return map;
    }

}
