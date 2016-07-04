package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

public class TitleOptions<T> extends And<T> implements JsonBuilder {

    public enum Position {
        TOP, BOTTOM
    }

    private Boolean display;
    private Position position;
    private String text;
    private Boolean fullWidth;
    private Integer fontSize;
    private String fontFamily;
    private String fontColor; //
    private String fontStyle;
    private Integer padding;


    public TitleOptions(T parent) {
        super(parent);
    }

    /**
     * Display the title block
     */
    public TitleOptions<T> display(boolean display) {
        this.display = display;
        return this;
    }

    /**
     * Position of the title. Only 'top' or 'bottom' are currently allowed
     */
    public TitleOptions<T> position(Position position) {
        this.position = position;
        return this;
    }

    /**
     * Title text
     */
    public TitleOptions<T> text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Marks that this box should take the full width of the canvas (pushing down other boxes)
     */
    public TitleOptions<T> fullWidth(boolean fullWidth) {
        this.fullWidth = fullWidth;
        return this;
    }

    /**
     * Font size inherited from global configuration
     */
    public TitleOptions<T> fontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    /**
     * Font family inherited from global configuration
     */
    public TitleOptions<T> fontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
        return this;
    }

    /**
     * Font color inherited from global configuration
     */
    public TitleOptions<T> fontColor(String fontColor) {
        this.fontColor = fontColor;
        return this;
    }

    /**
     * Font styling of the title.
     */
    public TitleOptions<T> fontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
        return this;
    }

    /**
     * Number of pixels to add above and below the title text
     */
    public TitleOptions<T> padding(int padding) {
        this.padding = padding;
        return this;
    }

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "display", display);
        if (position != null) {
            JUtils.putNotNull(map, "position", position.name().toLowerCase());
        }
        JUtils.putNotNull(map, "text", text);
        JUtils.putNotNull(map, "fullWidth", fullWidth);
        JUtils.putNotNull(map, "fontSize", fontSize);
        JUtils.putNotNull(map, "fontFamily", fontFamily);
        JUtils.putNotNull(map, "fontColor", fontColor);
        JUtils.putNotNull(map, "fontStyle", fontStyle);
        JUtils.putNotNull(map, "padding", padding);
        return map;
    }
}
