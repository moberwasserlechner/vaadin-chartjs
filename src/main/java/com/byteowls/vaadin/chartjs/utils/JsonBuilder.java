package com.byteowls.vaadin.chartjs.utils;

import elemental.json.JsonObject;

public interface JsonBuilder {

    /**
     * For internal use only
     *
     * @return the JsonObject, which is sent to the client connector
     */
    JsonObject buildJson();
}
