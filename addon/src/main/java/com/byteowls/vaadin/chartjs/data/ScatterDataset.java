package com.byteowls.vaadin.chartjs.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Scatter line charts can be created by changing the X axis to a linear axis. 
 * 
 * To use a scatter chart, data must be passed as objects containing X and Y properties.
 * 
 * @author michael@byteowls.com
 *
 */
public class ScatterDataset implements Dataset<ScatterDataset, ScatterData> {

    private String type;
    private List<ScatterData> data;
    private List<String> labels;
    private Map<String, ScatterData> dataMap;
    private Boolean hidden;
    private String label;
    private String xAxisID;
    private String yAxisID;
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
    public ScatterDataset type() {
        type = "line";
        return this;
    }

    @Override
    public ScatterDataset data(ScatterData... data) {
        this.data = Arrays.asList(data);
        return this;
    }

    /**
     * A single data object to plot as bubbles
     * @param x X Value
     * @param y Y Value
     */
    public ScatterDataset addData(Double x, Double y) {
        if (data == null) {
            data = new ArrayList<>();
        }
        data.add(new ScatterData().x(x).y(y));
        return this;
    }

    @Override
    public ScatterDataset dataAsList(List<ScatterData> data) {
        this.data = data;
        return this;
    }

    @Override
    public List<ScatterData> getData() {
        if (dataMap != null) {
            return new ArrayList<>(dataMap.values());
        }
        return data;
    }
    

    @Override
    public ScatterDataset addLabeledData(String label, ScatterData data) {
        if (label != null && data != null) {
            if (labels == null) {
                labels = new ArrayList<>();
            }
            if (!labels.contains(label)) {
                labels.add(label);
            }
            
            if (dataMap == null) {
                dataMap = new LinkedHashMap<>();
            }
            dataMap.put(label, data);
        }
        
        return this;
    }

    @Override
    public List<String> getDataLabels() {
        return labels;
    }

    /**
     * The label for the dataset which appears in the legend and tooltips
     */
    public ScatterDataset label(String label) {
        this.label = label;
        return this;
    }

    /**
     * The ID of the x axis to plot this dataset on
     */
    public ScatterDataset xAxisID(String xAxisID) {
        this.xAxisID = xAxisID;
        return this;
    }

    /**
     * The ID of the y axis to plot this dataset on
     */
    public ScatterDataset yAxisID(String yAxisID) {
        this.yAxisID = yAxisID;
        return this;
    }

    /**
     * If true, fill the area under the line
     */
    public ScatterDataset fill(boolean fill) {
        this.fill = fill;
        return this;
    }

    /**
     * If true, the dataset is hidden
     */
    public ScatterDataset hidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * Bezier curve tension of the line. Set to 0 to draw straightlines.
     */
    public ScatterDataset lineTension(double lineTension) {
        this.lineTension = lineTension;
        return this;
    }

    /**
     * The fill color under the line.
     */
    public ScatterDataset backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    /**
     * The width of the line in pixels
     */
    public ScatterDataset borderWidth(int borderWidth) {
        this.borderWidth = borderWidth;
        return this;
    }

    /**
     * The color of the line.
     */
    public ScatterDataset borderColor(String borderColor) {
        this.borderColor = borderColor;
        return this;
    }

    /**
     * Cap style of the line. See https://developer.mozilla.org/en-US/docs/Web/API/CanvasRenderingContext2D/lineCap
     */
    public ScatterDataset borderCapStyle(String borderCapStyle) {
        this.borderCapStyle = borderCapStyle;
        return this;
    }

    /**
     * Length and spacing of dashes.
     */
    public ScatterDataset borderDash(Integer... borderDash) {
        this.borderDash = Arrays.asList(borderDash);
        return this;
    }

    /**
     * Offset for line dashes.
     */
    public ScatterDataset borderDashOffset(double borderDashOffset) {
        this.borderDashOffset = borderDashOffset;
        return this;
    }

    /**
     * Line joint style.
     */
    public ScatterDataset borderJoinStyle(String borderJoinStyle) {
        this.borderJoinStyle = borderJoinStyle;
        return this;
    }

    /**
     * The border color for points.
     */
    public ScatterDataset pointBorderColor(String... pointBorderColor) {
        this.pointBorderColor = Arrays.asList(pointBorderColor);
        return this;
    }

    /**
     * The fill color for points
     */
    public ScatterDataset pointBackgroundColor(String... pointBackgroundColor) {
        this.pointBackgroundColor = Arrays.asList(pointBackgroundColor);
        return this;
    }


    /**
     * The width of the point border in pixels
     */
    public ScatterDataset pointBorderWidth(Integer... pointBorderWidth) {
        this.pointBorderWidth = Arrays.asList(pointBorderWidth);
        return this;
    }

    /**
     * The radius of the point shape. If set to 0, nothing is rendered.
     */
    public ScatterDataset pointRadius(Integer... pointRadius) {
        this.pointRadius = Arrays.asList(pointRadius);
        return this;
    }

    /**
     * The radius of the point when hovered
     */
    public ScatterDataset pointHoverRadius(Integer... pointHoverRadius) {
        this.pointHoverRadius = Arrays.asList(pointHoverRadius);
        return this;
    }

    /**
     * The pixel size of the non-displayed point that reacts to mouse events
     */
    public ScatterDataset pointHitRadius(Integer... pointHitRadius) {
        this.pointHitRadius = Arrays.asList(pointHitRadius);
        return this;
    }

    /**
     * Point background color when hovered
     */
    public ScatterDataset pointHoverBackgroundColor(String... pointHoverBackgroundColor) {
        this.pointHoverBackgroundColor = Arrays.asList(pointHoverBackgroundColor);
        return this;
    }

    /**
     * Point border color when hovered
     */
    public ScatterDataset pointHoverBorderColor(String... pointHoverBorderColor) {
        this.pointHoverBorderColor = Arrays.asList(pointHoverBorderColor);
        return this;
    }

    /**
     * Border width of point when hovered
     */
    public ScatterDataset pointHoverBorderWidth(Integer... pointHoverBorderWidth) {
        this.pointHoverBorderWidth = Arrays.asList(pointHoverBorderWidth);
        return this;
    }


    /**
     * The style of point. Options are 'circle', 'triangle', 'rect', 'rectRot', 'cross', 'crossRot', 'star', 'line', and 'dash'. 
     */
    public ScatterDataset pointStyle(PointStyle pointStyle) {
        this.pointStyle = pointStyle;
        return this;
    }

    /**
     * If false, the line is not drawn for this dataset
     */
    public ScatterDataset showLine(boolean showLine) {
        this.showLine = showLine;
        return this;
    }

    /**
     * If true, lines will be drawn between points with no or null data
     */
    public ScatterDataset spanGaps(boolean spanGaps) {
        this.spanGaps = spanGaps;
        return this;
    }

    /**
     * If true, the line is shown as a steeped line and 'lineTension' will be ignored
     */
    public ScatterDataset steppedLine(boolean steppedLine) {
        this.steppedLine = steppedLine;
        return this;
    }
    
    

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "type", type);
        JUtils.putNotNullBuilders(map, "data", data);
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

}
