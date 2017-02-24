package com.byteowls.vaadin.chartjs.options.scale;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;

import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * Used to configure the point labels that are shown on the perimeter of the scale. 
 * 
 * Note that these options only apply if lineArc is false.
 */
public class RadialPointLabel<T> extends And<T> implements JsonBuilder {

    private static final long serialVersionUID = 3782246450705674195L;

    // TODO callback Callback function to transform data label to axis label
    private String fontColor;
    private String fontFamily;
    private Integer fontSize;
    private String fontStyle;

    /**
     * Font color. Default: #666
     */
    public RadialPointLabel<T> fontColor(String fontColor) {
        this.fontColor = fontColor;
        return this;
    }

    /**
     * Font family to render. Default: 'Helvetica Neue', 'Helvetica', 'Arial', sans-serif
     */
    public RadialPointLabel<T> fontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    /**
     * Font size in pixels. Default: 10
     */
    public RadialPointLabel<T> fontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    /**
     * Font Style to use. Default: normal
     */
    public RadialPointLabel<T> fontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }


    public RadialPointLabel(T parent) {
        super(parent);
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "fontColor", fontColor);
        JUtils.putNotNull(map, "fontFamily", fontFamily);
        JUtils.putNotNull(map, "fontSize", fontSize);
        JUtils.putNotNull(map, "fontStyle", fontStyle);
        return map;
    }

}
