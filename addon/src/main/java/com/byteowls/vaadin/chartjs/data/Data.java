package com.byteowls.vaadin.chartjs.data;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author michael@team-conductor.com
 */
public class Data<T> extends And<T> implements JsonBuilder {

    private List<String> labels;
    private List<Dataset> datasets;

    public Data(T chartConfig) {
        super(chartConfig);
    }

    public Data<T> labels(String... labels) {
        this.labels = Arrays.asList(labels);
        return this;
    }

    public Data<T> addDataset(Dataset dataset) {
        if (this.datasets == null) {
            this.datasets = new ArrayList<>();
        }
        this.datasets.add(dataset);
        return this;
    }
    
    public List<Dataset> getDatasets() {
        return datasets;
    }
    
    public List<String> getLabels() {
        return labels;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "labels", labels);
        JUtils.putNotNullBuilders(map, "datasets", datasets);
        return map;
    }
}
