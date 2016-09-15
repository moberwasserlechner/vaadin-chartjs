package com.byteowls.vaadin.chartjs.utils;

public abstract class ColorUtils {
    
    public static long randomColorFactor() {
        return Math.round(Math.random() * 255);
    }
    
    public static String randomColor(double alphaFactor) {
        return "rgba(" + randomColorFactor() + "," + randomColorFactor() + "," + randomColorFactor() + "," + alphaFactor + ")";
    }

}
