package com.byteowls.vaadin.chartjs.options.line;

import com.byteowls.vaadin.chartjs.options.scale.*;
import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author michael@team-conductor.com
 */
public class ScalesOptions<P> extends And<P> implements JsonBuilder {

    private List<BaseScale<?>> xAxes;
    private List<BaseScale<?>> yAxes;

    public ScalesOptions(P parent) {
        super(parent);
    }

    /**
     *
     * @param axis on which axis should the scale be placed
     * @param scale a scale
     * @return this for chaining.
     */
    public ScalesOptions<P> add(Axis axis, BaseScale<?> scale) {
        addToAxes(axis, scale);
        return this;
    }

    private void addToAxes(Axis axis, BaseScale<?> scale) {
        if (axis == Axis.X) {
            if (xAxes == null) {
                xAxes = new ArrayList<>();
            }
            xAxes.add(scale);
        } else {
            if (yAxes == null) {
                yAxes = new ArrayList<>();
            }
            yAxes.add(scale);
        }
    }


    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNullBuilders(map, "xAxes", xAxes);
        JUtils.putNotNullBuilders(map, "yAxes", yAxes);
        return map;
    }
}
