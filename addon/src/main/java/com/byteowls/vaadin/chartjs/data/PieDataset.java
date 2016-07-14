package com.byteowls.vaadin.chartjs.data;

import java.util.Arrays;
import java.util.List;

import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * For a pie chart, datasets need to contain an array of data points. 
 * 
 * The data points should be a number, Chart.js will total all of the numbers and calculate the relative proportion of each. 
 * 
 * You can also add an array of background colors. 
 * 
 * The color attributes should be a string. Similar to CSS, for this string you can use HEX notation, RGB, RGBA or HSL.
 * 
 * @author michael@byteowls.com
 *
 */
public class PieDataset implements Dataset<PieDataset> {
    
    private String type;
    private List<Double> data;
    private Boolean hidden;
    private String label;
    private Boolean fill;
    private List<String> backgroundColor;
    private List<String> borderColor;
    private List<Integer> borderWidth;
    private List<String> hoverBackgroundColor;
    private List<String> hoverBorderColor;
    private List<Integer> hoverBorderWidth;
    
    /**
     * Used if the type of a dataset is needed. e.g. combo chart type charts
     */
    public PieDataset donut() {
        this.type = "doughnut";
        return this;
    }

    /**
     * Used if the type of a dataset is needed. e.g. combo chart type charts
     */
    public PieDataset doughnut() {
        this.type = "doughnut";
        return this;
    }

    /**
     * Used if the type of a dataset is needed. e.g. combo chart type charts
     */
    public PieDataset pie() {
        this.type = "pie";
        return this;
    }
    
    /**
     * The data to plot as arcs
     */
    @Override
    public PieDataset data(Double... data) {
        this.data = Arrays.asList(data);
        return this;
    }

    /**
     * The data to plot as bars
     */
    @Override
    public PieDataset dataAsList(List<Double> data) {
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
    public PieDataset label(String label) {
        this.label = label;
        return this;
    }

    /**
     * If true, fill the area under the line
     */
    public PieDataset fill(boolean fill) {
        this.fill = fill;
        return this;
    }
    
    /**
     * If true, the dataset is hidden
     */
    public PieDataset hidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * The fill color of the arcs.
     */
    public PieDataset backgroundColor(String...  backgroundColor) {
        this.backgroundColor = Arrays.asList(backgroundColor);
        return this;
    }
    
    /**
     * Arc border color.
     */
    public PieDataset borderColor(String... borderColor) {
        this.borderColor = Arrays.asList(borderColor);
        return this;
    }

    /**
     * Border width of arcs in pixels
     */
    public PieDataset borderWidth(Integer... borderWidth) {
        this.borderWidth = Arrays.asList(borderWidth);
        return this;
    }

    /**
     * Arc background color when hovered
     */
    public PieDataset hoverBackgroundColor(String...  hoverBackgroundColor) {
        this.hoverBackgroundColor = Arrays.asList(hoverBackgroundColor);
        return this;
    }
    
    /**
     * Arc border color when hovered
     */
    public PieDataset hoverBorderColor(String... hoverBorderColor) {
        this.hoverBorderColor = Arrays.asList(hoverBorderColor);
        return this;
    }

    /**
     * Border width of arc when hovered
     */
    public PieDataset hoverBorderWidth(Integer... hoverBorderWidth) {
        this.hoverBorderWidth = Arrays.asList(hoverBorderWidth);
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
        JUtils.putNotNullStringListOrSingle(map, "backgroundColor", backgroundColor);
        JUtils.putNotNullStringListOrSingle(map, "borderColor", borderColor);
        JUtils.putNotNullIntListOrSingle(map, "borderWidth", borderWidth);
        JUtils.putNotNullStringListOrSingle(map, "hoverBackgroundColor", hoverBackgroundColor);
        JUtils.putNotNullStringListOrSingle(map, "hoverBorderColor", hoverBorderColor);
        JUtils.putNotNullIntListOrSingle(map, "hoverBorderWidth", hoverBorderWidth);
        return map;
    }
}
