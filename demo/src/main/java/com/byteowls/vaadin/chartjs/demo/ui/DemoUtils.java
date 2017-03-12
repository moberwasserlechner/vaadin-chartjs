package com.byteowls.vaadin.chartjs.demo.ui;

import com.byteowls.vaadin.chartjs.data.Dataset;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

/**
 * This utils provide a few short cuts.
 * @author moberwasserlechner
 *
 */
public abstract class DemoUtils {

    public static final String RGB_RED = "rgb(255, 99, 132)";
    public static final String RGB_ORANGE = "rgb(255, 159, 64)";
    public static final String RGB_YELLOW = "rgb(255, 205, 86)";
    public static final String RGB_GREEN = "rgb(75, 192, 192)";
    public static final String RGB_BLUE = "rgb(54, 162, 235)";
    public static final String RGB_PURPLE = "rgb(153, 102, 255)";
    public static final String RGB_GREY = "rgb(231,233,237)";

    public static double randomScalingFactor() {
        return (double) (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100);
    }

    public static void notification(int dataSetIdx, int dataIdx, Dataset<?, ?> dataset) {
        Notification.show("Dataset at Idx:" + dataSetIdx + "; Data at Idx: " + dataIdx + "; Value: " + dataset.getData().get(dataIdx), Type.TRAY_NOTIFICATION);
    }
}
