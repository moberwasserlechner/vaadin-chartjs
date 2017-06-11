package com.byteowls.vaadin.chartjs.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.byteowls.vaadin.chartjs.utils.ColorUtils;
import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * @author michael@byteowls.com
 */
public class BarDataset extends DoubleDataset<BarDataset> {

    private static final long serialVersionUID = -5049884704390777087L;

    public enum Edge {
        BOTTOM, LEFT, TOP, RIGHT
    }

    private String type;
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
    private String stack;

    private boolean randomBackgroundColors;

    /**
     * Used if the type of a dataset is needed. e.g. combo chart type charts
     */
    public BarDataset type() {
        type = "bar";
        return this;
    }

    /**
     * Used if the type of a dataset is needed. e.g. combo chart type charts
     */
    public BarDataset horizontalType() {
        type = "horizontalBar";
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
     * Set random background colors for every data
     */
    public BarDataset randomBackgroundColors(boolean randomBackgroundColors) {
        this.randomBackgroundColors = randomBackgroundColors;
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

    /**
     * The ID of the group to which this dataset belongs to (when stacked, each group will be a separate stack)
     */
    public BarDataset stack(String stack) {
        this.stack = stack;
        return this;
    }


    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "type", type);
        List<Double> data = getData();
        JUtils.putNotNullNumbers(map, "data", data);
        JUtils.putNotNull(map, "label", label);
        JUtils.putNotNull(map, "xAxisID", xAxisID);
        JUtils.putNotNull(map, "yAxisID", yAxisID);
        JUtils.putNotNull(map, "fill", fill);
        JUtils.putNotNull(map, "hidden", hidden);
        if (randomBackgroundColors && data != null) {
            List<String> bgColors = new ArrayList<>();
            for (int i = 0; i < data.size(); i++) {
                bgColors.add(ColorUtils.randomColor(0.7));
            }
            backgroundColor = bgColors;
        }
        JUtils.putNotNullStringListOrSingle(map, "backgroundColor", backgroundColor);
        JUtils.putNotNullStringListOrSingle(map, "borderColor", borderColor);
        JUtils.putNotNullIntListOrSingle(map, "borderWidth", borderWidth);
        if (borderSkipped != null) {
            List<String> list = new ArrayList<>();
            for (Edge e : borderSkipped) {
                list.add(e.name().toLowerCase());
            }
            JUtils.putNotNull(map, "borderSkipped", list);
        }
        JUtils.putNotNullStringListOrSingle(map, "hoverBackgroundColor", hoverBackgroundColor);
        JUtils.putNotNullStringListOrSingle(map, "hoverBorderColor", hoverBorderColor);
        JUtils.putNotNullIntListOrSingle(map, "hoverBorderWidth", hoverBorderWidth);
        JUtils.putNotNull(map, "stack", stack);
        return map;
    }

    @Override
    public BarDataset getThis() {
        return this;
    }
}
