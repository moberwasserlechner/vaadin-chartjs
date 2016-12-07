package com.byteowls.vaadin.chartjs.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.byteowls.vaadin.chartjs.utils.JUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * A bubble chart is used to display three dimensions of data at the same time. 
 * 
 * The location of the bubble is determined by the first two dimensions and the corresponding horizontal and vertical axes. 
 * 
 * The third dimension is represented by the size of the individual bubbles.
 *
 * @author michael@byteowls.com
 */
public class BubbleDataset implements Dataset<BubbleDataset, BubbleData> {
    
    private String type;
    private List<BubbleData> data;
    private List<String> labels;
    private Map<String, BubbleData> dataMap;
    private Boolean hidden;
    private String label;
    private List<String> backgroundColor;
    private List<String> borderColor;
    private List<Integer> borderWidth;
    private List<String> hoverBackgroundColor;
    private List<String> hoverBorderColor;
    private List<Integer> hoverBorderWidth;
    private List<Integer> hoverRadius;
    
    /**
     * Used if the type of a dataset is needed. e.g. combo chart type charts
     */
    public BubbleDataset type() {
        this.type = "bubble";
        return this;
    }
    
    /**
     * A single data object to plot as bubbles
     * @param x X Value
     * @param y Y Value
     * @param r Radius of bubble. This is not scaled.
     */
    public BubbleDataset addData(Double x, Double y, Double r) {
        if (data == null) {
            data = new ArrayList<>();
        }
        data.add(new BubbleData().x(x).y(y).r(r));
        return this;
    }

    /**
     * The data to plot as bubbles
     */
    @Override
    public BubbleDataset data(BubbleData... data) {
        this.data = Arrays.asList(data);
        return this;
    }

    /**
     * The data to plot as bubbles
     */
    @Override
    public BubbleDataset dataAsList(List<BubbleData> data) {
        this.data = data;
        return this;
    }
    
    @Override
    public List<BubbleData> getData() {
        if (dataMap != null) {
            return new ArrayList<>(dataMap.values());
        }
        return data;
    }
    
    @Override
    public BubbleDataset addLabeledData(String label, BubbleData data) {
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
    public BubbleDataset label(String label) {
        this.label = label;
        return this;
    }

    /**
     * If true, the dataset is hidden
     */
    public BubbleDataset hidden(boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    /**
     * The fill color of the bubbles.
     */
    public BubbleDataset backgroundColor(String...  backgroundColor) {
        this.backgroundColor = Arrays.asList(backgroundColor);
        return this;
    }
    
    /**
     * The stroke color of the bubbles.
     */
    public BubbleDataset borderColor(String... borderColor) {
        this.borderColor = Arrays.asList(borderColor);
        return this;
    }

    /**
     * The stroke width of bubble in pixels.
     */
    public BubbleDataset borderWidth(Integer... borderWidth) {
        this.borderWidth = Arrays.asList(borderWidth);
        return this;
    }

    /**
     * The fill color of the bubbles when hovered.
     */
    public BubbleDataset hoverBackgroundColor(String...  hoverBackgroundColor) {
        this.hoverBackgroundColor = Arrays.asList(hoverBackgroundColor);
        return this;
    }
    
    /**
     * The stroke color of the bubbles when hovered.
     */
    public BubbleDataset hoverBorderColor(String... hoverBorderColor) {
        this.hoverBorderColor = Arrays.asList(hoverBorderColor);
        return this;
    }

    /**
     * The stroke width of the bubbles when hovered.
     */
    public BubbleDataset hoverBorderWidth(Integer... hoverBorderWidth) {
        this.hoverBorderWidth = Arrays.asList(hoverBorderWidth);
        return this;
    }
    
    /**
     * Additional radius to add to data radius on hover.
     */
    public BubbleDataset hoverRadius(Integer... hoverRadius) {
        this.hoverRadius = Arrays.asList(hoverRadius);
        return this;
    }

    @Override
    public Map<String, ?> buildJson() {
        Map<String, ?> map = new HashMap();
        JUtils.putNotNull(map, "type", type);
        JUtils.putNotNull(map, "data", data);
        JUtils.putNotNull(map, "label", label);
        JUtils.putNotNull(map, "hidden", hidden);
        JUtils.putNotNullListOrSingle(map, "backgroundColor", backgroundColor);
        JUtils.putNotNullListOrSingle(map, "borderColor", borderColor);
        JUtils.putNotNullListOrSingle(map, "borderWidth", borderWidth);
        JUtils.putNotNullListOrSingle(map, "hoverBackgroundColor", hoverBackgroundColor);
        JUtils.putNotNullListOrSingle(map, "hoverBorderColor", hoverBorderColor);
        JUtils.putNotNullListOrSingle(map, "hoverBorderWidth", hoverBorderWidth);
        JUtils.putNotNullListOrSingle(map, "hoverRadius", hoverRadius);
        return map;
    }

}
