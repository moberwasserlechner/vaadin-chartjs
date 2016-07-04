package com.byteowls.vaadin.chartjs.utils;

import elemental.json.Json;
import elemental.json.JsonArray;
import elemental.json.JsonObject;
import elemental.json.JsonValue;

import java.util.List;
import java.util.Map;

public abstract class JUtils {

    public static void putNotNull(JsonObject obj, String key, Map<String, String> map) {
        if (map != null) {
            JsonObject mapObj = Json.createObject();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                mapObj.put(entry.getKey(), entry.getValue());
            }
            obj.put(key, mapObj);
        }
    }

    public static void putNotNull(JsonObject obj, String key, List<String> list) {
        if (list != null) {
            JsonArray arr = Json.createArray();
            for (String entry : list) {
                arr.set(arr.length(), entry);
            }
            obj.put(key, arr);
        }
    }

    public static void putNotNull(JsonObject obj, String key, Boolean value) {
        if (value != null) {
            obj.put(key, value);
        }
    }

    public static void putNotNull(JsonObject obj, String key, String value) {
        if (value != null) {
            obj.put(key, value);
        }
    }


    public static void putNotNull(JsonObject obj, String key, JsonValue value) {
        if (value != null) {
            obj.put(key, value);
        }
    }

    public static void putNotNull(JsonObject obj, String key, Number value) {
        if (value != null) {
            obj.put(key, (JsonValue) value);
        }
    }

    public static void putNotNull(JsonObject obj, String key, JsonBuilder builder) {
        if (builder != null) {
            obj.put(key, builder.buildJson());
        }
    }

    public static void putNotNullBuilders(JsonObject obj, String key, List<? extends JsonBuilder> listOfBuilder) {
        if (listOfBuilder != null) {
            JsonArray arr = Json.createArray();
            for (JsonBuilder tbb : listOfBuilder) {
                arr.set(arr.length(), tbb.buildJson());
            }
            obj.put(key, arr);
        }
    }

    public static void putNotNullNumbers(JsonObject obj, String key, List<Double> listOfNumbers) {
        if (listOfNumbers != null) {
            JsonArray arr = Json.createArray();
            for (Double n : listOfNumbers) {
                arr.set(arr.length(), n);
            }
            obj.put(key, arr);
        }
    }
}
