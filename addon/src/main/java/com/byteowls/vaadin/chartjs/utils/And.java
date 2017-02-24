package com.byteowls.vaadin.chartjs.utils;

import java.io.Serializable;

/**
 * @author michael@byteowls.com
 */
public abstract class And<T> implements Serializable {

    private static final long serialVersionUID = -4267668163111396815L;

    protected T parent;

    public And(T parent) {
        this.parent = parent;
    }

    public T and() {
        return parent;
    }

}
