package com.byteowls.vaadin.chartjs.demo.ui;

public abstract class ChartUtils {
    
    public static double randomScalingFactor() {
        return (double) (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100);
    }
    
    public static long randomColorFactor() {
        return Math.round(Math.random() * 255);
    }
    
    public static String randomColor(double d) {
        return "rgba(" + randomColorFactor() + "," + randomColorFactor() + "," + randomColorFactor() + "," + d + ")";
    }

}
