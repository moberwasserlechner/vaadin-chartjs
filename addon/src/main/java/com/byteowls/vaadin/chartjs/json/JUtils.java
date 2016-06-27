package com.byteowls.vaadin.chartjs.json;

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
    
}
