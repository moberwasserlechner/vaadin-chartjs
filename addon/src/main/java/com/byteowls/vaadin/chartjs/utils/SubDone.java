package com.byteowls.vaadin.chartjs.utils;

/**
 * @author michael@team-conductor.com
 */
public abstract class SubDone<T> {

    private T parent;

    public SubDone(T parent) {
        this.parent = parent;
    }

    public T done() {
        return parent;
    }

}
