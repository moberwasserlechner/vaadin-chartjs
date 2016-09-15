package com.byteowls.vaadin.chartjs.data;

import java.util.Arrays;
import java.util.List;

import com.byteowls.vaadin.chartjs.utils.JUtils;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Polar area charts are similar to pie charts, but each segment has the same angle - the radius of the segment differs depending on the value.
 * 
 * This type of chart is often useful when we want to show a comparison data similar to a pie chart, but also show a scale of values for context.
 * 
 * @author michael@byteowls.com
 *
 */
public class PolarAreaDataset extends DoubleDataset<PolarAreaDataset> {

    private String type = "polarArea";
    private Boolean hidden;
    private String label;
    private List<String> backgroundColor;
    private List<String> borderColor;
    private List<Integer> borderWidth;
    private List<String> hoverBackgroundColor;
    private List<String> hoverBorderColor;
    private List<Integer> hoverBorderWidth;

    /**
     * Used if the type of a dataset is needed. e.g. combo chart type charts
     */
    public PolarAreaDataset type() {
        this.type = "polarArea";
        return this;
    }

    /**
     * The label for the dataset which appears in the legend and tooltips
     */
    public PolarAreaDataset label(String label) {
        this.label = label;
        return this;
    }

    /**
     * If true, the dataset is hidden
     */
    public PolarAreaDataset hidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * The fill color of the arcs.
     */
    public PolarAreaDataset backgroundColor(String...  backgroundColor) {
        this.backgroundColor = Arrays.asList(backgroundColor);
        return this;
    }

    /**
     * Arc border color.
     */
    public PolarAreaDataset borderColor(String... borderColor) {
        this.borderColor = Arrays.asList(borderColor);
        return this;
    }

    /**
     * Border width of arcs in pixels
     */
    public PolarAreaDataset borderWidth(Integer... borderWidth) {
        this.borderWidth = Arrays.asList(borderWidth);
        return this;
    }

    /**
     * Arc background color when hovered
     */
    public PolarAreaDataset hoverBackgroundColor(String...  hoverBackgroundColor) {
        this.hoverBackgroundColor = Arrays.asList(hoverBackgroundColor);
        return this;
    }

    /**
     * Arc border color when hovered
     */
    public PolarAreaDataset hoverBorderColor(String... hoverBorderColor) {
        this.hoverBorderColor = Arrays.asList(hoverBorderColor);
        return this;
    }

    /**
     * Border width of arc when hovered
     */
    public PolarAreaDataset hoverBorderWidth(Integer... hoverBorderWidth) {
        this.hoverBorderWidth = Arrays.asList(hoverBorderWidth);
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "type", type);
        JUtils.putNotNullNumbers(map, "data", getData());
        JUtils.putNotNull(map, "label", label);
        JUtils.putNotNull(map, "hidden", hidden);
        JUtils.putNotNullStringListOrSingle(map, "backgroundColor", backgroundColor);
        JUtils.putNotNullStringListOrSingle(map, "borderColor", borderColor);
        JUtils.putNotNullIntListOrSingle(map, "borderWidth", borderWidth);
        JUtils.putNotNullStringListOrSingle(map, "hoverBackgroundColor", hoverBackgroundColor);
        JUtils.putNotNullStringListOrSingle(map, "hoverBorderColor", hoverBorderColor);
        JUtils.putNotNullIntListOrSingle(map, "hoverBorderWidth", hoverBorderWidth);
        return map;
    }

    @Override
    public PolarAreaDataset getThis() {
        return this;
    }
}
