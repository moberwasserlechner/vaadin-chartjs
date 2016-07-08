package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.byteowls.vaadin.chartjs.options.scale.ScalesOptions;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import elemental.json.JsonObject;

/**
 * @author michael@team-conductor.com
 */
public abstract class AbstractScalableOptions<T extends AbstractScalableOptions<?>> extends AbstractOptions<T> {

    private ScalesOptions<T> scales;

    public AbstractScalableOptions(ChartConfig chartConfig) {
        super(chartConfig);
    }

    /**
     * Step into the scale configuration
     */
    public ScalesOptions<T> scales() {
        if (scales == null) {
            scales = new ScalesOptions<>(getThis());
        }
        return scales;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "scales", scales);
        return map;
    }

}
