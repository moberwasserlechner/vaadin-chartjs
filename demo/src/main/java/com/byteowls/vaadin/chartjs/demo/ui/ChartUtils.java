package com.byteowls.vaadin.chartjs.demo.ui;

import com.byteowls.vaadin.chartjs.data.Dataset;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

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
    
    public static void notification(int dataSetIdx, int dataIdx, Dataset<?, ?> dataset) {
        Notification.show("Dataset at Idx:" + dataSetIdx + "; Data at Idx: " + dataIdx + "; Value: " + dataset.getData().get(dataIdx), Type.TRAY_NOTIFICATION);
    }

}
