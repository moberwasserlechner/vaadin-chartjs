package com.byteowls.vaadin.chartjs.utils;

import elemental.json.JsonObject;

public interface JsonBuilder {

    /**
     * For internal use only
     *
     * @return the JsonObject, which is sent to the client connector
     */
    JsonObject buildJson();

    /**
     * Prefix for properties which are set to a callback, ie. the property value is a JavaScript statement or function
     * which needs to be parsed at browser side and the result to be used on a property without prefix.
     */
    public static final String CALLBACK_PREFIX = "__cb_"; // A copy of the value is used in chartjs-connector.js.
}
