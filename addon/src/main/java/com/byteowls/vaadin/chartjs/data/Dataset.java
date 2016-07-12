package com.byteowls.vaadin.chartjs.data;

import java.util.List;

import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

/**
 * @author michael@team-conductor.com
 */
public interface Dataset<T> extends JsonBuilder {
    
    T data(Double... data);

    T dataAsList(List<Double> data);
    
    List<Double> getData();
    
}
