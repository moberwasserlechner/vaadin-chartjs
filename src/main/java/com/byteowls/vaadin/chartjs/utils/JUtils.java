package com.byteowls.vaadin.chartjs.utils;

import elemental.json.Json;
import elemental.json.JsonArray;
import elemental.json.JsonObject;
import elemental.json.JsonValue;
import elemental.json.impl.JreJsonNull;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class JUtils {
    /**
     * Prefix for properties which are set to a callback, ie. the property value is a JavaScript statement or function
     * which needs to be parsed at browser side and the result to be used on a property without prefix.
     */
    public static final String CALLBACK_PREFIX = "__cb_"; // A copy of the value is used in chartjs-connector.js.

    /**
     * Postfix for the arguments of a property which is set to a callback. The value of the property is an array of
     * strings (the names of the arguments).
     */
    public static final String CALLBACK_ARGS_POSTFIX = "_args"; // A copy of the value is used in chartjs-connector.js.

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

    public static void putNotNull(JsonObject obj, String key, Double value) {
        if (value != null) {
            obj.put(key, value);
        }
    }

    public static void putNotNull(JsonObject obj, String key, LocalDateTime value) {
        if (value != null) {
            obj.put(key, value.toString());
        }
    }
    
    public static void putNotNullObj(JsonObject obj, String key, Object value) {
        if (value != null) {
            if (value instanceof String) {
                obj.put(key, (String) value);
            } else if (value instanceof Double) {
                obj.put(key, (Double) value);
            } else if (value instanceof Boolean) {
                obj.put(key, (Boolean) value);
            } else if (value instanceof JsonValue) {
                obj.put(key, (JsonValue) value);
            } else if (value instanceof Integer) {
                obj.put(key, (Integer) value);
	        } else if (value instanceof LocalDateTime) {
	            obj.put(key, (String) value.toString());
	        }
        }
    }

    public static void putNotNull(JsonObject obj, String key, Integer value) {
        if (value != null) {
            obj.put(key, value.doubleValue());
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

    public static void putNotNullList(JsonObject obj, String key, List<String> list) {
        if (list != null) {
            JsonArray arr = Json.createArray();
            for (String entry : list) {
                arr.set(arr.length(), entry);
            }
            obj.put(key, arr);
        }
    }

    public static void putNotNullNumbers(JsonObject obj, String key, List<Double> listOfNumbers) {
        if (listOfNumbers != null) {
            JsonArray arr = Json.createArray();
            for (Double n : listOfNumbers) {
                if (n == null) {
                    arr.set(arr.length(), new JreJsonNull());
                } else {
                    arr.set(arr.length(), n);
                }
            }
            obj.put(key, arr);
        }
    }
    
    public static void putNotNullTimeDoublePairs(JsonObject obj, String key, List<Pair<LocalDateTime,Double>> listOfPairs) {
        if (listOfPairs != null) {
            JsonArray arr = Json.createArray();
            for (Pair<LocalDateTime,Double> n : listOfPairs) {
                if (n != null) {
                    JsonObject map = Json.createObject();
                    JUtils.putNotNull(map, "t",	n.getFirst());
                    JUtils.putNotNull(map, "y", n.getSecond());
                    arr.set(arr.length(), map);
                }
            }
            obj.put(key, arr);
        }
    }

    public static void putNotNullIntList(JsonObject obj, String key, List<Integer> listOfNumbers) {
        if (listOfNumbers != null) {
            JsonArray arr = Json.createArray();
            for (Integer n : listOfNumbers) {
                arr.set(arr.length(), n.doubleValue());
            }
            obj.put(key, arr);
        }
    }

    public static void putNotNullStringListOrSingle(JsonObject obj, String key, List<String> list) {
        if (list != null) {
            if (list.size() == 1) {
                putNotNull(obj, key, list.get(0));
            } else {
                JsonArray arr = Json.createArray();
                for (String entry : list) {
                    arr.set(arr.length(), entry);
                }
                obj.put(key, arr);
            }
        }
    }

    public static void putNotNullNumberListOrSingle(JsonObject obj, String key, List<Double> listOfNumbers) {
        if (listOfNumbers != null) {
            if (listOfNumbers.size() == 1) {
                putNotNull(obj, key, listOfNumbers.get(0));
            } else {
                JsonArray arr = Json.createArray();
                for (Double n : listOfNumbers) {
                    arr.set(arr.length(), n);
                }
                obj.put(key, arr);
            }
        }
    }

    public static void putNotNullIntListOrSingle(JsonObject obj, String key, List<Integer> listOfNumbers) {
        if (listOfNumbers != null) {
            if (listOfNumbers.size() == 1) {
                putNotNull(obj, key, listOfNumbers.get(0));
            } else {
                JsonArray arr = Json.createArray();
                for (Integer n : listOfNumbers) {
                    arr.set(arr.length(), n.doubleValue());
                }
                obj.put(key, arr);
            }
        }
    }

    /**
     * Creates JSON entries for callback functions, ie. key is a property name of a callback function and value is
     * JavaScript code.
     *
     * @param obj
     *            The JSON object to add the values for.
     * @param key
     *            The original property name.
     * @param value
     *            The JavaScript function.
     * @param argumentNames
     *            The names of the arguments which are going to be supplied to the JavaScript call.
     */
    public static void putNotNullCallback(JsonObject obj, String key, String value, String... argumentNames) {
        if (value != null) {
            // add the property with the call back prefix
            obj.put(CALLBACK_PREFIX + key, value);
            JUtils.putNotNullStringListOrSingle(obj, CALLBACK_PREFIX + key + CALLBACK_ARGS_POSTFIX,
                    Arrays.asList(argumentNames));
        }

    }
}
