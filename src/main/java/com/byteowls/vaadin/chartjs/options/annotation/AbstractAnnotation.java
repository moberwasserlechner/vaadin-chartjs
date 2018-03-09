package com.byteowls.vaadin.chartjs.options.annotation;

import java.io.Serializable;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

public abstract class AbstractAnnotation<T> extends And<T> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 6861210127684854144L;

    public AbstractAnnotation(T parent) {
        super(parent);
    }

}
