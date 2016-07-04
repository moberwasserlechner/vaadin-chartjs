package com.byteowls.vaadin.chartjs.utils;

/**
 * @author michael@team-conductor.com
 */
public abstract class And<T> {

    protected T parent;

    public And(T parent) {
        this.parent = parent;
    }

    public T and() {
        return parent;
    }

}
