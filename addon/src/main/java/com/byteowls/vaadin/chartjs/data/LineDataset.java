package com.byteowls.vaadin.chartjs.data;

import java.util.Arrays;
import java.util.List;

import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * @author michael@team-conductor.com
 *
 */
public class LineDataset implements Dataset<LineDataset> {
    
    public enum PointStyle {
        circle, triangle, rect, rectRot, cross, crossRot, star, line, dash
    }
    
    private String type;
    private List<Double> data;
    private Boolean hidden;
    private String label;
    private String xAxisID;
    private String yAxisID;
    private Boolean fill;
    private Double lineTension;
    private String backgroundColor;
    private Integer borderWidth;
    private String borderColor;
    private List<Integer> borderDash;
    private String borderCapStyle;
    private Double borderDashOffset;
    private String borderJoinStyle;
    private List<String> pointBorderColor;
    private List<String> pointBackgroundColor;
    private List<Double> pointBorderWidth;
    private List<Double> pointRadius;
    private List<Double> pointHoverRadius;
    private List<Double> pointHitRadius;
    private List<String> pointHoverBackgroundColor;
    private List<String> pointHoverBorderColor;
    private List<Double> pointHoverBorderWidth;
    private PointStyle pointStyle;
    private Boolean showLine;
    private Boolean spanGaps;
    private Boolean steppedLine;
    
    /**
     * Used if the type of a dataset is needed. e.g. combo chart type charts
     */
    public LineDataset type() {
        type = "line";
        return this;
    }
    
    @Override
    public LineDataset data(Double... data) {
        this.data = Arrays.asList(data);
        return this;
    }

    @Override
    public LineDataset dataAsList(List<Double> data) {
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
    public LineDataset label(String label) {
        this.label = label;
        return this;
    }

    /**
     * The ID of the x axis to plot this dataset on
     */
    public LineDataset xAxisID(String xAxisID) {
        this.xAxisID = xAxisID;
        return this;
    }

    /**
     * The ID of the y axis to plot this dataset on
     */
    public LineDataset yAxisID(String yAxisID) {
        this.yAxisID = yAxisID;
        return this;
    }

    /**
     * If true, fill the area under the line
     */
    public LineDataset fill(boolean fill) {
        this.fill = fill;
        return this;
    }
    
    /**
     * If true, the dataset is hidden
     */
    public LineDataset hidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * Bezier curve tension of the line. Set to 0 to draw straightlines.
     */
    public LineDataset lineTension(double lineTension) {
        this.lineTension = lineTension;
        return this;
    }

    /**
     * The fill color under the line.
     */
    public LineDataset backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * The width of the line in pixels
     */
    public LineDataset borderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * The color of the line.
     */
    public LineDataset borderColor(String borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * Cap style of the line. See https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/lineCap
     */
    public LineDataset borderCapStyle(String borderCapStyle) {
        this.borderCapStyle = borderCapStyle;
        return this;
    }
    
    /**
     * Length and spacing of dashes.
     */
    public LineDataset borderDash(Integer... borderDash) {
        this.borderDash = Arrays.asList(borderDash);
        return this;
    }

    /**
     * Offset for line dashes.
     */
    public LineDataset borderDashOffset(double borderDashOffset) {
        this.borderDashOffset = borderDashOffset;
        return this;
    }

    /**
     * Line joint style.
     */
    public LineDataset borderJoinStyle(String borderJoinStyle) {
        this.borderJoinStyle = borderJoinStyle;
        return this;
    }

    /**
     * The border color for points.
     */
    public LineDataset pointBorderColor(String... pointBorderColor) {
        this.pointBorderColor = Arrays.asList(pointBorderColor);
        return this;
    }
    
    /**
     * The fill color for points
     */
    public LineDataset pointBackgroundColor(String... pointBackgroundColor) {
        this.pointBackgroundColor = Arrays.asList(pointBackgroundColor);
        return this;
    }
    
    
    /**
     * The width of the point border in pixels
     */
    public LineDataset pointBorderWidth(Double... pointBorderWidth) {
        this.pointBorderWidth = Arrays.asList(pointBorderWidth);
        return this;
    }
    
    /**
     * The radius of the point shape. If set to 0, nothing is rendered.
     */
    public LineDataset pointRadius(Double... pointRadius) {
        this.pointRadius = Arrays.asList(pointRadius);
        return this;
    }
    
    /**
     * The radius of the point when hovered
     */
    public LineDataset pointHoverRadius(Double... pointHoverRadius) {
        this.pointHoverRadius = Arrays.asList(pointHoverRadius);
        return this;
    }
    
    /**
     * The pixel size of the non-displayed point that reacts to mouse events
     */
    public LineDataset pointHitRadius(Double... pointHitRadius) {
        this.pointHitRadius = Arrays.asList(pointHitRadius);
        return this;
    }
    
    /**
     * Point background color when hovered
     */
    public LineDataset pointHoverBackgroundColor(String... pointHoverBackgroundColor) {
        this.pointHoverBackgroundColor = Arrays.asList(pointHoverBackgroundColor);
        return this;
    }
    
    /**
     * Point border color when hovered
     */
    public LineDataset pointHoverBorderColor(String... pointHoverBorderColor) {
        this.pointHoverBorderColor = Arrays.asList(pointHoverBorderColor);
        return this;
    }
    
    /**
     * Border width of point when hovered
     */
    public LineDataset pointHoverBorderWidth(Double... pointHoverBorderWidth) {
        this.pointHoverBorderWidth = Arrays.asList(pointHoverBorderWidth);
        return this;
    }
    
    
    /**
     * The style of point. Options are 'circle', 'triangle', 'rect', 'rectRot', 'cross', 'crossRot', 'star', 'line', and 'dash'. 
     */
    public LineDataset pointStyle(PointStyle pointStyle) {
        this.pointStyle = pointStyle;
        return this;
    }
    
    /**
     * If false, the line is not drawn for this dataset
     */
    public LineDataset showLine(boolean showLine) {
        this.showLine = showLine;
        return this;
    }
    
    /**
     * If true, lines will be drawn between points with no or null data
     */
    public LineDataset spanGaps(boolean spanGaps) {
        this.spanGaps = spanGaps;
        return this;
    }
    
    /**
     * If true, the line is shown as a steeped line and 'lineTension' will be ignored
     */
    public LineDataset steppedLine(boolean steppedLine) {
        this.steppedLine = steppedLine;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "type", type);
        JUtils.putNotNullNumbers(map, "data", data);
        JUtils.putNotNull(map, "label", label);
        JUtils.putNotNull(map, "xAxisID", xAxisID);
        JUtils.putNotNull(map, "yAxisID", yAxisID);
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
        JUtils.putNotNullNumberListOrSingle(map, "pointBorderWidth", pointBorderWidth);
        JUtils.putNotNullNumberListOrSingle(map, "pointRadius", pointRadius);
        JUtils.putNotNullNumberListOrSingle(map, "pointHoverRadius", pointHoverRadius);
        JUtils.putNotNullNumberListOrSingle(map, "pointHitRadius", pointHitRadius);
        JUtils.putNotNullStringListOrSingle(map, "pointHoverBackgroundColor", pointHoverBackgroundColor);
        JUtils.putNotNullStringListOrSingle(map, "pointHoverBorderColor", pointHoverBorderColor);
        JUtils.putNotNullNumberListOrSingle(map, "pointHoverBorderWidth", pointHoverBorderWidth);
        if (pointStyle != null) {
            JUtils.putNotNull(map, "pointStyle", pointStyle.name());
        }
        JUtils.putNotNull(map, "showLine", showLine);
        JUtils.putNotNull(map, "spanGaps", spanGaps);
        JUtils.putNotNull(map, "steppedLine", steppedLine);
        return map;
    }

}
