package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.byteowls.vaadin.chartjs.options.scale.Scales;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import elemental.json.JsonObject;

public abstract class AbstractScalableOptions<T extends AbstractScalableOptions<?>> extends AbstractOptions<T> {

    private static final long serialVersionUID = -585276899801295042L;

    private Scales<T> scales;
    private AnnotationOptions<T> annotation;

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

    /**
     * Step into the annotation configuration
     */
    public AnnotationOptions<T> annotation() {
        if (annotation == null) {
            annotation = new AnnotationOptions<>(getThis());
        }
        return annotation;
    }


    @Override
    public JsonObject buildJson() {
        JsonObject map = super.buildJson();
        JUtils.putNotNull(map, "scales", scales);
        JUtils.putNotNull(map, "annotation", annotation);
        return map;
    }

}
