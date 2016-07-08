package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.And;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

public class TooltipsOptions<T> extends And<T> implements JsonBuilder {

    public enum Mode {
        SINGLE, LABEL
    }

    private Boolean enabled;
    // TODO custom call
    private Mode mode;
    private String backgroundColor;
    private String titleFontFamily;
    private Integer titleFontSize;
    private String titleFontStyle;
    private String titleFontColor;
    private Integer titleSpacing;
    private Integer titleMarginBottom;
    private String bodyFontFamily;
    private Integer bodyFontSize;
    private String bodyFontStyle;
    private String bodyFontColor;
    private Integer bodySpacing;
    private String footerFontFamily;
    private Integer footerFontSize;
    private String footerFontStyle;
    private String footerFontColor;
    private Integer footerSpacing;
    private Integer footerMarginTop;
    private Integer xPadding;
    private Integer yPadding;
    private Integer caretSize;
    private Integer cornerRadius;
    private String multiKeyBackground;
    // TODO private String callbacks;


    public TooltipsOptions(T parent) {
        super(parent);
    }

    /**
     * Are tooltips enabled
     */
    public TooltipsOptions<T> enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Sets which elements appear in the tooltip.
     * single highlights the closest element.
     * label highlights elements in all datasets at the same X value.
     * defaults to {@link Mode#SINGLE}
     */
    public TooltipsOptions<T> mode(Mode mode) {
        this.mode = mode;
        return this;
    }
    
    /**
     * Background color of the tooltip. Defaults to 'rgba(0,0,0,0.8)'
     */
    public TooltipsOptions<T> backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }
    
    /**
     * Font family for tooltip title inherited from global font family.
     */
    public TooltipsOptions<T> titleFontFamily(String titleFontFamily) {
        this.titleFontFamily = titleFontFamily;
        return this;
    }
    
    

    @Override
    public JsonObject buildJson() {
        JsonObject map = Json.createObject();
        JUtils.putNotNull(map, "enabled", enabled);
        if (mode != null) {
            JUtils.putNotNull(map, "mode", mode.name().toLowerCase());
        }
        JUtils.putNotNull(map, "backgroundColor", backgroundColor);
        JUtils.putNotNull(map, "titleFontFamily", titleFontFamily);
        return map;
    }
}
