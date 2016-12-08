package com.byteowls.vaadin.chartjs.options.scale;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import java.util.Map;

/**
 * @author michael@byteowls.com
 */
public class LogarithmicTicks<T> extends Ticks<T> implements JsonBuilder {

    private Integer min;
    private Integer max;

    public LogarithmicTicks(T parent) {
        super(parent);
    }


    /**
     * User defined minimum number for the scale, overrides minimum value from data.
     */
    public LogarithmicTicks<T> min(int min) {
        this.min = min;
        return this;
    }

    /**
     * User defined maximum number for the scale, overrides maximum value from data.
     */
    public LogarithmicTicks<T> max(int max) {
        this.max = max;
        return this;
    }


    @Override
    public Map<String, ?> buildJson() {
        Map<String, ?> map = super.buildJson();
        JUtils.putNotNull(map, "min", min);
        JUtils.putNotNull(map, "max", max);
        return map;
    }
}
