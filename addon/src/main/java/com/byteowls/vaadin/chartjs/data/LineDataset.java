package com.byteowls.vaadin.chartjs.data;

import java.util.Arrays;
import java.util.List;

import com.byteowls.vaadin.chartjs.utils.JUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author michael@byteowls.com
 *
 */
public class LineDataset extends DoubleDataset<LineDataset> {
    
    public enum CubicInterpolationMode {
        DEFAULT, MONOTONE
    }

    private String type;
    private Boolean hidden;
    private String label;
    private String xAxisID;
    private String yAxisID;
    private Boolean fill;
    private CubicInterpolationMode cubicInterpolationMode;
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
    private List<Integer> pointHitRadius;
    private List<String> pointHoverBackgroundColor;
    private List<String> pointHoverBorderColor;
    private List<Integer> pointHoverBorderWidth;
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
     * Algorithm used to interpolate a smooth curve from the discrete data points. 
     * 
     * The 'default' algorithm uses a custom weighted cubic interpolation, which produces pleasant curves for all types of datasets. 
     * 
     * The 'monotone' algorithm is more suited to y = f(x) datasets. It preserves monotonicity (or piecewise monotonicity) of the dataset being interpolated, and ensures local extremums (if any) stay at input data points. 
     */
    public LineDataset cubicInterpolationMode(CubicInterpolationMode cubicInterpolationMode) {
        this.cubicInterpolationMode = cubicInterpolationMode;
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
    public LineDataset pointBorderWidth(Integer... pointBorderWidth) {
        this.pointBorderWidth = Arrays.asList(pointBorderWidth);
        return this;
    }

    /**
     * The radius of the point shape. If set to 0, nothing is rendered.
     */
    public LineDataset pointRadius(Integer... pointRadius) {
        this.pointRadius = Arrays.asList(pointRadius);
        return this;
    }

    /**
     * The radius of the point when hovered
     */
    public LineDataset pointHoverRadius(Integer... pointHoverRadius) {
        this.pointHoverRadius = Arrays.asList(pointHoverRadius);
        return this;
    }

    /**
     * The pixel size of the non-displayed point that reacts to mouse events
     */
    public LineDataset pointHitRadius(Integer... pointHitRadius) {
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
    public LineDataset pointHoverBorderWidth(Integer... pointHoverBorderWidth) {
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
    public Map<String, ?> buildJson() {
        Map<String, ?> map = new HashMap();
        JUtils.putNotNull(map, "type", type);
        JUtils.putNotNull(map, "data", getData());
        JUtils.putNotNull(map, "label", label);
        JUtils.putNotNull(map, "xAxisID", xAxisID);
        JUtils.putNotNull(map, "yAxisID", yAxisID);
        JUtils.putNotNull(map, "fill", fill);
        if (cubicInterpolationMode != null) {
            JUtils.putNotNull(map, "cubicInterpolationMode", cubicInterpolationMode.toString().toLowerCase());
        }
        JUtils.putNotNull(map, "hidden", hidden);
        JUtils.putNotNull(map, "lineTension", lineTension);
        JUtils.putNotNull(map, "backgroundColor", backgroundColor);
        JUtils.putNotNull(map, "borderWidth", borderWidth);
        JUtils.putNotNull(map, "borderColor", borderColor);
        JUtils.putNotNull(map, "borderCapStyle", borderCapStyle);
        JUtils.putNotNull(map, "borderDash", borderDash);
        JUtils.putNotNull(map, "borderDashOffset", borderDashOffset);
        JUtils.putNotNull(map, "borderJoinStyle", borderJoinStyle);
        JUtils.putNotNullListOrSingle(map, "pointBorderColor", pointBorderColor);
        JUtils.putNotNullListOrSingle(map, "pointBackgroundColor", pointBackgroundColor);
        JUtils.putNotNullListOrSingle(map, "pointBorderWidth", pointBorderWidth);
        JUtils.putNotNullListOrSingle(map, "pointRadius", pointRadius);
        JUtils.putNotNullListOrSingle(map, "pointHoverRadius", pointHoverRadius);
        JUtils.putNotNullListOrSingle(map, "pointHitRadius", pointHitRadius);
        JUtils.putNotNullListOrSingle(map, "pointHoverBackgroundColor", pointHoverBackgroundColor);
        JUtils.putNotNullListOrSingle(map, "pointHoverBorderColor", pointHoverBorderColor);
        JUtils.putNotNullListOrSingle(map, "pointHoverBorderWidth", pointHoverBorderWidth);
        if (pointStyle != null) {
            JUtils.putNotNull(map, "pointStyle", pointStyle.name());
        }
        JUtils.putNotNull(map, "showLine", showLine);
        JUtils.putNotNull(map, "spanGaps", spanGaps);
        JUtils.putNotNull(map, "steppedLine", steppedLine);
        return map;
    }

    @Override
    public LineDataset getThis() {
        return this;
    }

}
