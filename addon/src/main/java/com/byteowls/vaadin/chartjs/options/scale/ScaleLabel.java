package com.byteowls.vaadin.chartjs.options.scale;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * @author michael@byteowls.com
 */
public class ScaleLabel<T extends BaseScale<?>> extends And<T> implements JsonBuilder {

    private Boolean display;
    private String labelString;
    private String fontColor;
    private String fontFamily;
    private Integer fontSize;
    private String fontStyle;

    public ScaleLabel(T parent) {
        super(parent);
    }

    /**
     * If true the scale label is shown.
     */
    public ScaleLabel<T> display(boolean display) {
        this.display = display;
        return this;
    }

    /**
     * The text for the title. (i.e. "# of People", "Response Choices")
     */
    public ScaleLabel<T> labelString(String labelString) {
        this.labelString = labelString;
        return this;
    }

    /**
     * Font color for the scale title.
     */
    public ScaleLabel<T> fontColor(String fontColor) {
        this.fontColor = fontColor;
        return this;
    }

    /**
     * Font family for the scale title, follows CSS font-family options.
     */
    public ScaleLabel<T> fontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    /**
     * Font size for the scale title.
     */
    public ScaleLabel<T> fontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    /**
     * Font style for the scale title, follows CSS font-style options (i.e. normal, italic, oblique, initial, inherit).
     */
    public ScaleLabel<T> fontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "display", display);
        JUtils.putNotNull(map, "labelString", labelString);
        JUtils.putNotNull(map, "fontColor", fontColor);
        JUtils.putNotNull(map, "fontFamily", fontFamily);
        JUtils.putNotNull(map, "fontSize", fontSize);
        JUtils.putNotNull(map, "fontStyle", fontStyle);
        return map;
    }
}
