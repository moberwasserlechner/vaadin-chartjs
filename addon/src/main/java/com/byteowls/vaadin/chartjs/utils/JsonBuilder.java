package com.byteowls.vaadin.chartjs.utils;

import java.util.Map;

public interface JsonBuilder {

    /**
     * For internal use only
     *
     * @return the Map, which is converted to string and sent to the client connector
     */
    Map<String, ?> buildJson();
}
