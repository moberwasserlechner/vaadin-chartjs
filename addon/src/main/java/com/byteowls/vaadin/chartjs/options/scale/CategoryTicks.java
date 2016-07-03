package com.byteowls.vaadin.chartjs.options.scale;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.JsonObject;

/**
 * @author michael@team-conductor.com
 */
public class CategoryTicks<T> extends Ticks<T> implements JsonBuilder {

    private String min;
    private String max;

    public CategoryTicks(T parent) {
        super(parent);
    }


    /**
     * The minimum item to display. Must be a value in the data.labels array
     */
    public CategoryTicks<T> min(String min) {
        this.min = min;
        return this;
    }

    /**
     * The maximum item to display. Must be a value in the data.labels array
     */
    public CategoryTicks<T> max(String max) {
        this.max = max;
        return this;
    }


    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "min", min);
        JUtils.putNotNull(map, "max", max);
        return map;
    }
}
