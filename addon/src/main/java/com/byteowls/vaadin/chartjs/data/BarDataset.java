package com.byteowls.vaadin.chartjs.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * @author mowl-private
 *
 */
public class BarDataset implements Dataset {
    
    public enum Edge {
        bottom, left, top, right
    }
    
    private List<Double> data;
    private Boolean hidden;
    private String label;
    private String xAxisID;
    private String yAxisID;
    private Boolean fill;
    private List<String> backgroundColor;
    private List<String> borderColor;
    private List<Integer> borderWidth;
    private List<Edge> borderSkipped;
    private List<String> hoverBackgroundColor;
    private List<String> hoverBorderColor;
    private List<Integer> hoverBorderWidth;
    
    /**
     * The data to plot as bars
     */
    public BarDataset data(Double... data) {
        this.data = Arrays.asList(data);
        return this;
    }

    /**
     * The data to plot as bars
     */
    public BarDataset dataAsList(List<Double> data) {
        this.data = data;
        return this;
    }

    /**
     * The label for the dataset which appears in the legend and tooltips
     */
    public BarDataset label(String label) {
        this.label = label;
        return this;
    }

    /**
     * The ID of the x axis to plot this dataset on
     */
    public BarDataset xAxisID(String xAxisID) {
        this.xAxisID = xAxisID;
        return this;
    }

    /**
     * The ID of the y axis to plot this dataset on
     */
    public BarDataset yAxisID(String yAxisID) {
        this.yAxisID = yAxisID;
        return this;
    }

    /**
     * If true, fill the area under the line
     */
    public BarDataset fill(boolean fill) {
        this.fill = fill;
        return this;
    }
    
    /**
     * If true, the dataset is hidden
     */
    public BarDataset hidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * The fill color of the bars.
     */
    public BarDataset backgroundColor(String...  backgroundColor) {
        this.backgroundColor = Arrays.asList(backgroundColor);
        return this;
    }
    
    /**
     * Bar border color.
     */
    public BarDataset borderColor(String... borderColor) {
        this.borderColor = Arrays.asList(borderColor);
        return this;
    }

    /**
     * Border width of bar in pixels
     */
    public BarDataset borderWidth(Integer... borderWidth) {
        this.borderWidth = Arrays.asList(borderWidth);
        return this;
    }

    /**
     * Which edge to skip drawing the border for. Options are 'bottom', 'left', 'top', and 'right'
     */
    public BarDataset borderSkipped(Edge... borderSkipped) {
        this.borderSkipped = Arrays.asList(borderSkipped);
        return this;
    }

    /**
     * Bar background color when hovered
     */
    public BarDataset hoverBackgroundColor(String...  hoverBackgroundColor) {
        this.hoverBackgroundColor = Arrays.asList(hoverBackgroundColor);
        return this;
    }
    
    /**
     * Bar border color when hovered
     */
    public BarDataset hoverBorderColor(String... hoverBorderColor) {
        this.hoverBorderColor = Arrays.asList(hoverBorderColor);
        return this;
    }

    /**
     * Border width of bar when hovered
     */
    public BarDataset hoverBorderWidth(Integer... hoverBorderWidth) {
        this.hoverBorderWidth = Arrays.asList(hoverBorderWidth);
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
        JUtils.putNotNull(map, "hidden", hidden);
        JUtils.putNotNullStringListOrSingle(map, "backgroundColor", backgroundColor);
        JUtils.putNotNullStringListOrSingle(map, "borderColor", borderColor);
        JUtils.putNotNullIntListOrSingle(map, "borderWidth", borderWidth);
        if (borderSkipped != null) {
            List<String> list = new ArrayList<>();
            for (Edge e : borderSkipped) {
                list.add(e.name());
            }
            JUtils.putNotNull(map, "borderSkipped", list);
        }
        JUtils.putNotNullStringListOrSingle(map, "hoverBackgroundColor", hoverBackgroundColor);
        JUtils.putNotNullStringListOrSingle(map, "hoverBorderColor", hoverBorderColor);
        JUtils.putNotNullIntListOrSingle(map, "hoverBorderWidth", hoverBorderWidth);
        return map;
    }
}
