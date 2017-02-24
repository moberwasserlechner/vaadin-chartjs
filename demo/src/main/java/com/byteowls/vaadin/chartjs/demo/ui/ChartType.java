package com.byteowls.vaadin.chartjs.demo.ui;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.FontIcon;

public enum ChartType {
    
    BAR(FontAwesome.BAR_CHART_O), 
    LINE(FontAwesome.LINE_CHART), 
    PIE(FontAwesome.PIE_CHART), 
    AREA(FontAwesome.AREA_CHART);
    
    
    FontIcon icon;
    
    private ChartType(FontIcon icon) {
        this.icon = icon;
    }

    public FontIcon getIcon() {
        return icon;
    }
    
}
