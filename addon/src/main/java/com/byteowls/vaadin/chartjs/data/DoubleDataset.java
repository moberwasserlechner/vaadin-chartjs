package com.byteowls.vaadin.chartjs.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author michael@byteowls.com
 */
public abstract class DoubleDataset<T> implements Dataset<T, Double> {

    private List<Double> data;
    private List<String> labels;
    private Map<String, Double> dataMap;

    @Override
    public T data(Double... data) {
        this.data = Arrays.asList(data);
        return getThis();
    }

    @Override
    public T dataAsList(List<Double> data) {
        this.data = data;
        return getThis();
    }

    @Override
    public List<Double> getData() {
        if (dataMap != null) {
            return new ArrayList<>(dataMap.values());
        }
        return data;
    }

    public T addData(Double data) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(data);
        return getThis();
    }

    public T addData(Integer data) {
        if (data != null) {
            addData(data.doubleValue());
        } else {
            addData((Double) null);
        }
        return getThis();
    }
    
    /** 
     * 
     * @see com.byteowls.vaadin.chartjs.data.Dataset#addLabeledData(java.lang.String, java.lang.Object)
     */
    public T addLabeledData(String label, Double data) {
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
            
            Double value = dataMap.get(label);
            if (value == null) {
                value = data;
            } else {
                value += data;
            }
            dataMap.put(label, value);
        }
        
        return getThis();
    }

    @Override
    public List<String> getDataLabels() {
        return labels;
    }

    protected abstract T getThis();
}
