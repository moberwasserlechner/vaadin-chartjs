package com.byteowls.vaadin.chartjs.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * @author michael@byteowls.com
 */
public class Data<T> extends And<T> implements JsonBuilder {

    private List<String> labels;
    private List<Dataset<?, ?>> datasets;
    private boolean extractLabelsFromDataset;
    
    public Data(T chartConfig) {
        super(chartConfig);
    }

    public Data<T> labels(String... labels) {
        this.labels = Arrays.asList(labels);
        return this;
    }
    
    public Data<T> labelsAsList(List<String> labels) {
        this.labels = labels;
        return this;
    }

    public Data<T> addDataset(Dataset<?, ?> dataset) {
        if (this.datasets == null) {
            this.datasets = new ArrayList<>();
        }
        this.datasets.add(dataset);
        return this;
    }

    public List<Dataset<?, ?>> getDatasets() {
        return datasets;
    }
    
    /**
     * If true the data labels are extracted from the dataset.
     */
    public Data<T> extractLabelsFromDataset(boolean extractLabelsFromDataset) {
        this.extractLabelsFromDataset = extractLabelsFromDataset;
        return this;
    }

    public Data<T> clear() {
        if (datasets != null) {
            datasets.clear();
        }
        return this;
    }

    public List<String> getLabels() {
        return labels;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        if (extractLabelsFromDataset) {
            for (Dataset<?, ?> dataset : datasets) {
                labels = dataset.getDataLabels();
                break;
            }
        }
        JUtils.putNotNull(map, "labels", labels);
        JUtils.putNotNullBuilders(map, "datasets", datasets);
        return map;
    }
}
