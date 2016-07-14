package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.byteowls.vaadin.chartjs.options.scale.Scales;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import elemental.json.JsonObject;

/**
 * @author michael@byteowls.com
 */
public abstract class AbstractScalableOptions<T extends AbstractScalableOptions<?>> extends AbstractOptions<T> {

    private Scales<T> scales;

    public AbstractScalableOptions(ChartConfig chartConfig) {
        super(chartConfig);
    }

    /**
     * Step into the scale configuration
     */
    public Scales<T> scales() {
        if (scales == null) {
            scales = new Scales<>(getThis());
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
