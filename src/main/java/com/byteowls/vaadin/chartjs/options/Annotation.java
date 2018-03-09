package com.byteowls.vaadin.chartjs.options;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.options.annotation.AbstractAnnotation;
import com.byteowls.vaadin.chartjs.options.annotation.HorizontalLineAnnotation;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Options for annotation-plug-in (see https://github.com/chartjs/chartjs-plugin-annotation)
 *
 * @author mwyraz
 */
public class Annotation<T> extends AbstractAnnotation<T> implements JsonBuilder, Serializable {

    private static final long serialVersionUID = 7103025747407670414L;

    private List<AbstractAnnotation<Annotation<T>>> annotations;

    public Annotation(T parent) {
        super(parent);
    }

    protected <A extends AbstractAnnotation<Annotation<T>>> A add(A annotation) {
        if (annotations == null) {
            annotations = new ArrayList<>();
        }
        annotations.add(annotation);
        return annotation;
    }

    public void clear() {
        annotations = null;
    }

    public HorizontalLineAnnotation<Annotation<T>> horizontalLine(Double value) {
        return add(new HorizontalLineAnnotation<>(this, value));
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();

        JUtils.putNotNullBuilders(map, "annotations", annotations);

        return map;
    }

}
