package com.byteowls.vaadin.chartjs.utils;

import elemental.json.impl.JsonUtil;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class JUtils {

    public static void putNotNull(Map obj, String key, Object value) {
        if (value != null) {
            obj.put(key, value);
        }
    }

    public static void putNotNullListOrSingle(Map obj, String key, List list) {
        if (list != null) {
            if (list.size() == 1) {
                putNotNull(obj, key, list.get(0));
            } else {
                obj.put(key, list);
            }
        }
    }

    public static String toJson(Map<String, ?> obj) {
        if (obj == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder("{");
        AtomicBoolean emptyObject = new AtomicBoolean(true);

        obj.entrySet().stream().forEach((entry) -> {
            emptyObject.set(false);
            builder.append('"').append(entry.getKey()).append("\":");

            valueToJson(builder, entry.getValue());

            builder.append(',');
        });

        if (!emptyObject.get()) {
            builder.deleteCharAt(builder.length() - 1);
        }
        builder.append('}');

        return builder.toString();
    }

    private static void valueToJson(StringBuilder builder, Object value) {
        if (value == null) {
            builder.append("null");
        } else if (value instanceof String) {
            builder.append(JsonUtil.quote((String) value));
        } else if (value instanceof JsonBuilder) {
            builder.append(toJson(((JsonBuilder) value).buildJson()));
        } else if (value instanceof Map) {
            builder.append(toJson((Map) value));
        } else if (value instanceof Iterable) {
            Iterable iterable = (Iterable) value;
            AtomicBoolean emptyIterable = new AtomicBoolean(true);
            builder.append("[");

            iterable.forEach((item) -> {
                emptyIterable.set(false);
                valueToJson(builder, item);
                builder.append(',');
            });

            if (!emptyIterable.get()) {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append("]");
        } else if (value.getClass().isArray()) {
            int length = Array.getLength(value);
            builder.append("[");
            
            for (int i = 0; i < length; i++) {
                valueToJson(builder, Array.get(value, i));
                builder.append(',');
            }
            
            if (length > 0) {
                builder.deleteCharAt(builder.length() - 1);
            }
            builder.append("]");
        } else {
            builder.append(value);
        }
    }
}
