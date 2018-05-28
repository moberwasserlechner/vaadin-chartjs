package com.byteowls.vaadin.chartjs.data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.util.Pair;

/**
 * @author slatequarry
 */
public abstract class TimeDoubleDataset<T> implements Dataset<T, Pair<LocalDateTime,Double>> {

	private static final long serialVersionUID = -6974707185168615990L;

	private List<Pair<LocalDateTime,Double>> data;

    @SuppressWarnings("unchecked")
	@Override
    public T data(Pair<LocalDateTime,Double>... data) {
        this.data = Arrays.asList(data);
        return getThis();
    }

    @Override
    public T dataAsList(List<Pair<LocalDateTime,Double>> data) {
        this.data = data;
        return getThis();
    }

    @Override
    public List<Pair<LocalDateTime,Double>> getData() {
        return data;
    }

    public T addData(Pair<LocalDateTime,Double> data) {
        if (this.data == null) {
            this.data = new ArrayList<>();
        }
        this.data.add(data);
        return getThis();
    }

    public T addData(LocalDateTime time, Double value) {
        addData(new Pair<>(time,value));
        return getThis();
    }
    
    protected abstract T getThis();
}
