package com.byteowls.vaadin.chartjs.data;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.util.Arrays;
import java.util.List;

/**
 * @author michael@team-conductor.com
 */
public class LineDataset implements Dataset {

    private List<Double> data;
    private String label;
    private String xAxisID;
    private String yAxisID;
    private Boolean fill;
    private Float lineTension;
    private String backgroundColor;
    private Integer borderWidth;
    private String borderColor;
    private String borderCapStyle;
    private Float borderDashOffset;
    private String borderJoinStyle;

    public LineDataset data(Double... data) {
        this.data = Arrays.asList(data);
        return this;
    }

    public LineDataset dataAsList(List<Double> data) {
        this.data = data;
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
     * Bezier curve tension of the line. Set to 0 to draw straightlines.
     */
    public LineDataset lineTension(float lineTension) {
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
     * Offset for line dashes.
     */
    public LineDataset borderDashOffset(float borderDashOffset) {
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

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNullNumbers(map, "data", data);
        JUtils.putNotNull(map, "label", label);
        JUtils.putNotNull(map, "xAxisID", xAxisID);
        JUtils.putNotNull(map, "yAxisID", yAxisID);
        JUtils.putNotNull(map, "fill", fill);
        JUtils.putNotNull(map, "lineTension", lineTension);
        JUtils.putNotNull(map, "backgroundColor", backgroundColor);
        JUtils.putNotNull(map, "borderWidth", borderWidth);
        JUtils.putNotNull(map, "borderColor", borderColor);
        JUtils.putNotNull(map, "borderCapStyle", borderCapStyle);
        JUtils.putNotNull(map, "borderDashOffset", borderDashOffset);
        JUtils.putNotNull(map, "borderJoinStyle", borderJoinStyle);
        return map;
    }
}
