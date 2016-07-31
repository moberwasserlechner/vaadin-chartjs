package com.byteowls.vaadin.chartjs.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author michael@byteowls.com
 */
public abstract class DoubleDataset<T> implements Dataset<T, Double> {

    protected List<Double> data;

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

    protected abstract T getThis();
}
