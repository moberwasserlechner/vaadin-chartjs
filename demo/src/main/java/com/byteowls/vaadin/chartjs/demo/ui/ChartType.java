package com.byteowls.vaadin.chartjs.demo.ui;

import com.vaadin.server.FontAwesome;
import com.vaadin.server.FontIcon;

public enum ChartType {
    
    BAR(FontAwesome.BAR_CHART), LINE(FontAwesome.LINE_CHART), PIE(FontAwesome.PIE_CHART), 
        POLAR(FontAwesome.AREA_CHART), BUBBLE(FontAwesome.SOCCER_BALL_O), RADAR(FontAwesome.PLANE);
    
    private FontIcon icon;
    
    ChartType(FontIcon icon) {
        this.icon = icon;
    }

    public FontIcon getIcon() {
        return icon;
    }
    
}
