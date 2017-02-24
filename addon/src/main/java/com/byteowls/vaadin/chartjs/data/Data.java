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

    private static final long serialVersionUID = 8683322928360358252L;

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

    /**
     * Add a dataset.
     * @param dataset the dataset
     */
    public Data<T> addDataset(Dataset<?, ?> dataset) {
        if (this.datasets == null) {
            this.datasets = new ArrayList<>();
        }
        this.datasets.add(dataset);
        return this;
    }

    /**
     * @return A {@link List} of datasets.
     */
    public List<Dataset<?, ?>> getDatasets() {
        return datasets;
    }

    /**
     * Gets the dataset at the given index.
     * @param index the dataset index
     * @return The dataset at the given index and null if the index does not exist.
     */
    public Dataset<?, ?> getDatasetAtIndex(int index) {
        if (this.datasets != null && index >= 0 && index < this.datasets.size()) {
            return this.datasets.get(index);
        }
        return null;
    }

    /**
     * Gets the first dataset.
     * @return The first dataset or null if there is none.
     */
    public Dataset<?, ?> getFirstDataset() {
        return getDatasetAtIndex(0);
    }

    /**
     * If true the data labels are extracted from the dataset.
     */
    public Data<T> extractLabelsFromDataset(boolean extractLabelsFromDataset) {
        this.extractLabelsFromDataset = extractLabelsFromDataset;
        return this;
    }

    /**
     * Clear the dataset list.
     */
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
        if (extractLabelsFromDataset && datasets != null) {
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
