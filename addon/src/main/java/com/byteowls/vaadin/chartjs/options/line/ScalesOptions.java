package com.byteowls.vaadin.chartjs.options.line;

import com.byteowls.vaadin.chartjs.options.AbstractScalableOptions;
import com.byteowls.vaadin.chartjs.options.scale.*;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import com.byteowls.vaadin.chartjs.utils.SubDone;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author michael@team-conductor.com
 */
public class ScalesOptions<P extends AbstractScalableOptions> extends SubDone<P> implements JsonBuilder {

    private List<BaseScale> xAxes;
    private List<BaseScale> yAxes;

    public ScalesOptions(P parent) {
        super(parent);
    }

    @Override
    public P done() {
        return super.done();
    }

    /**
     * The category scale will be familiar to those who have used v1.0.
     * Labels are drawn in from the labels array included in the chart data.
     *
     * @param axis on which axis should the scale be placed
     */
    public CategoryScale category(Axis axis) {
        CategoryScale categoryScale = new CategoryScale(this);
        addToAxes(axis, categoryScale);
        return categoryScale;
    }

    /**
     * The linear scale is use to chart numerical data. It can be placed on either the x or y axis.
     * The scatter chart type automatically configures a line chart to use one of these scales for the x axis.
     * As the name suggests, linear interpolation is used to determine where a value lies on the axis.
     *
     * @param axis on which axis should the scale be placed
     */
    public LinearScale linear(Axis axis) {
        LinearScale linearScale = new LinearScale(this);
        addToAxes(axis, linearScale);
        return linearScale;
    }

    /**
     * The logarithmic scale is use to chart numerical data. It can be placed on either the x or y axis.
     * As the name suggests, logarithmic interpolation is used to determine where a value lies on the axis.
     *
     * @param axis on which axis should the scale be placed
     */
    public LogarithmicScale logarithmic(Axis axis) {
        LogarithmicScale logarithmicScale = new LogarithmicScale(this);
        addToAxes(axis, logarithmicScale);
        return logarithmicScale;
    }

    private void addToAxes(Axis axis, BaseScale scale) {
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
