package com.byteowls.vaadin.chartjs.data;

import com.byteowls.vaadin.chartjs.options.FillMode;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.Pair;

import elemental.json.Json;
import elemental.json.JsonObject;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author michael@byteowls.com
 *
 */
public class TimeLineDataset extends TimeDoubleDataset<TimeLineDataset> {

    private static final long serialVersionUID = -2084714266214798266L;

    public enum CubicInterpolationMode {
        DEFAULT, MONOTONE
    }

    private String type;
    private Boolean hidden;
    private String label;
    private String xAxisID;
    private String yAxisID;
    private Boolean fill;
    private Boolean fillToPlus;
    private Integer fillToDatasetIndex;
    private FillMode fillMode;
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
    private String steppedLine;

    /**
     * Used if the type of a dataset is needed. e.g. combo chart type charts
     */
    public TimeLineDataset type() {
        type = "line";
        return this;
    }

    /**
     * The label for the dataset which appears in the legend and tooltips
     */
    public TimeLineDataset label(String label) {
        this.label = label;
        return this;
    }

    /**
     * The ID of the x axis to plot this dataset on
     */
    public TimeLineDataset xAxisID(String xAxisID) {
        this.xAxisID = xAxisID;
        return this;
    }

    /**
     * The ID of the y axis to plot this dataset on
     */
    public TimeLineDataset yAxisID(String yAxisID) {
        this.yAxisID = yAxisID;
        return this;
    }

    /**
     * If true, fill the area under the line
     */
    public TimeLineDataset fill(boolean fill) {
        this.fill = fill;
        return this;
    }

    /**
     * Use the modes to fill different locations.
     */
    public TimeLineDataset fill(FillMode fillMode) {
        this.fillMode = fillMode;
        return this;
    }

    /**
     * Sets the index of the target dataset till which it will be filled.
     */
    public TimeLineDataset fill(int datasetIndex) {
        this.fillToDatasetIndex = datasetIndex;
        return this;
    }

    /**
     * Fills the area between the current dataset and next or previous with the given index.
     */
    public TimeLineDataset fill(boolean next, int datasetIndex) {
        this.fillToPlus = next;
        this.fillToDatasetIndex = datasetIndex;
        return this;
    }

    /**
     * Algorithm used to interpolate a smooth curve from the discrete data points.
     *
     * The 'default' algorithm uses a custom weighted cubic interpolation, which produces pleasant curves for all types of datasets.
     *
     * The 'monotone' algorithm is more suited to y = f(x) datasets. It preserves monotonicity (or piecewise monotonicity) of the dataset being interpolated, and ensures local extremums (if any) stay at input data points.
     */
    public TimeLineDataset cubicInterpolationMode(CubicInterpolationMode cubicInterpolationMode) {
        this.cubicInterpolationMode = cubicInterpolationMode;
        return this;
    }

    /**
     * If true, the dataset is hidden
     */
    public TimeLineDataset hidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * Bezier curve tension of the line. Set to 0 to draw straightlines.
     */
    public TimeLineDataset lineTension(double lineTension) {
        this.lineTension = lineTension;
        return this;
    }

    /**
     * The fill color.
     */
    public TimeLineDataset backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * The width of the line in pixels
     */
    public TimeLineDataset borderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * The color of the line.
     */
    public TimeLineDataset borderColor(String borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * Cap style of the line. See https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/lineCap
     */
    public TimeLineDataset borderCapStyle(String borderCapStyle) {
        this.borderCapStyle = borderCapStyle;
        return this;
    }

    /**
     * Length and spacing of dashes.
     */
    public TimeLineDataset borderDash(Integer... borderDash) {
        this.borderDash = Arrays.asList(borderDash);
        return this;
    }

    /**
     * Offset for line dashes.
     */
    public TimeLineDataset borderDashOffset(double borderDashOffset) {
        this.borderDashOffset = borderDashOffset;
        return this;
    }

    /**
     * Line joint style.
     */
    public TimeLineDataset borderJoinStyle(String borderJoinStyle) {
        this.borderJoinStyle = borderJoinStyle;
        return this;
    }

    /**
     * The border color for points.
     */
    public TimeLineDataset pointBorderColor(String... pointBorderColor) {
        this.pointBorderColor = Arrays.asList(pointBorderColor);
        return this;
    }

    /**
     * The fill color for points
     */
    public TimeLineDataset pointBackgroundColor(String... pointBackgroundColor) {
        this.pointBackgroundColor = Arrays.asList(pointBackgroundColor);
        return this;
    }


    /**
     * The width of the point border in pixels
     */
    public TimeLineDataset pointBorderWidth(Integer... pointBorderWidth) {
        this.pointBorderWidth = Arrays.asList(pointBorderWidth);
        return this;
    }

    /**
     * The radius of the point shape. If set to 0, nothing is rendered.
     */
    public TimeLineDataset pointRadius(Integer... pointRadius) {
        this.pointRadius = Arrays.asList(pointRadius);
        return this;
    }

    /**
     * The radius of the point when hovered
     */
    public TimeLineDataset pointHoverRadius(Integer... pointHoverRadius) {
        this.pointHoverRadius = Arrays.asList(pointHoverRadius);
        return this;
    }

    /**
     * The pixel size of the non-displayed point that reacts to mouse events
     */
    public TimeLineDataset pointHitRadius(Integer... pointHitRadius) {
        this.pointHitRadius = Arrays.asList(pointHitRadius);
        return this;
    }

    /**
     * Point background color when hovered
     */
    public TimeLineDataset pointHoverBackgroundColor(String... pointHoverBackgroundColor) {
        this.pointHoverBackgroundColor = Arrays.asList(pointHoverBackgroundColor);
        return this;
    }

    /**
     * Point border color when hovered
     */
    public TimeLineDataset pointHoverBorderColor(String... pointHoverBorderColor) {
        this.pointHoverBorderColor = Arrays.asList(pointHoverBorderColor);
        return this;
    }

    /**
     * Border width of point when hovered
     */
    public TimeLineDataset pointHoverBorderWidth(Integer... pointHoverBorderWidth) {
        this.pointHoverBorderWidth = Arrays.asList(pointHoverBorderWidth);
        return this;
    }


    /**
     * The style of point. Options are 'circle', 'triangle', 'rect', 'rectRot', 'cross', 'crossRot', 'star', 'line', and 'dash'.
     */
    public TimeLineDataset pointStyle(PointStyle pointStyle) {
        this.pointStyle = pointStyle;
        return this;
    }

    /**
     * If false, the line is not drawn for this dataset
     */
    public TimeLineDataset showLine(boolean showLine) {
        this.showLine = showLine;
        return this;
    }

    /**
     * If true, lines will be drawn between points with no or null data
     */
    public TimeLineDataset spanGaps(boolean spanGaps) {
        this.spanGaps = spanGaps;
        return this;
    }

    /**
     * If true, the line is shown as a steeped line and 'lineTension' will be ignored
     */
    public TimeLineDataset steppedLine(boolean steppedLine) {
        this.steppedLine = Boolean.toString(steppedLine);
        return this;
    }

    public TimeLineDataset steppedLine(String steppedLine) {
        this.steppedLine = steppedLine;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "type", type);
        JUtils.putNotNullTimeDoublePairs(map, "data", getData());
        JUtils.putNotNull(map, "label", label);
        JUtils.putNotNull(map, "xAxisID", xAxisID);
        JUtils.putNotNull(map, "yAxisID", yAxisID);

        if (this.fillToPlus != null && this.fillToDatasetIndex != null) {
            JUtils.putNotNull(map, "fill", (this.fillToPlus ? "+":"-") + this.fillToDatasetIndex);
        } else if (this.fillToPlus == null && this.fillToDatasetIndex != null) {
            JUtils.putNotNull(map, "fill", this.fillToDatasetIndex);
        } else if (this.fillMode != null) {
            JUtils.putNotNull(map, "fill", fillMode.name().toLowerCase());
        } else {
            JUtils.putNotNull(map, "fill", fill);
        }

        if (cubicInterpolationMode != null) {
            JUtils.putNotNull(map, "cubicInterpolationMode", cubicInterpolationMode.toString().toLowerCase());
        }
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
        JUtils.putNotNullIntListOrSingle(map, "pointHitRadius", pointHitRadius);
        JUtils.putNotNullStringListOrSingle(map, "pointHoverBackgroundColor", pointHoverBackgroundColor);
        JUtils.putNotNullStringListOrSingle(map, "pointHoverBorderColor", pointHoverBorderColor);
        JUtils.putNotNullIntListOrSingle(map, "pointHoverBorderWidth", pointHoverBorderWidth);
        if (pointStyle != null) {
            JUtils.putNotNull(map, "pointStyle", pointStyle.name());
        }
        JUtils.putNotNull(map, "showLine", showLine);
        JUtils.putNotNull(map, "spanGaps", spanGaps);
        JUtils.putNotNull(map, "steppedLine", steppedLine);
        return map;
    }

    @Override
    public TimeLineDataset getThis() {
        return this;
    }

	@Override
	public TimeLineDataset addLabeledData(String label, Pair<LocalDateTime, Double> data) {
		return this;
	}

	@Override
	public List<String> getDataLabels() {
		return null;
	}

}
