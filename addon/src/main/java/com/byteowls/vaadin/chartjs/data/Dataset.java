package com.byteowls.vaadin.chartjs.data;

import java.util.List;

import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

/**
 * @author michael@byteowls.com
 */
public interface Dataset<T, D> extends JsonBuilder {
    
    T data(D... data);

    T dataAsList(List<D> data);
    
    List<D> getData();
    
}
