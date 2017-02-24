package com.byteowls.vaadin.chartjs.demo.ui.charts;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.demo.ui.AbstractChartView;
import com.byteowls.vaadin.chartjs.demo.ui.ChartUtils;
import com.byteowls.vaadin.chartjs.options.InteractionMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;

@UIScope
@SpringView
public class TooltipInteractionModesChartView extends AbstractChartView {

    private static final long serialVersionUID = -1977315515493155463L;

    @Override
    public Component getChart() {
        CssLayout layout = new CssLayout();

        List<Boolean> intersects = new ArrayList<>();
        intersects.add(true);
        intersects.add(false);
        for (InteractionMode interactionMode : InteractionMode.values()) {
            for (Boolean intersect : intersects) {

                LineChartConfig config = new LineChartConfig();
                config.data()
                    .labels("January", "February", "March", "April", "May", "June", "July")
                    .addDataset(new LineDataset().label("My First dataset")
                            .borderColor(ChartUtils.RGB_RED)
                            .backgroundColor(ChartUtils.RGB_RED)
                            .data(10d, 30d, 46d, 2d, 8d, 50d, 0d)
                            .fill(false))
                    .addDataset(new LineDataset().label("My Second dataset")
                            .borderColor(ChartUtils.RGB_BLUE)
                            .backgroundColor(ChartUtils.RGB_BLUE)
                            .data(7d, 49d, 46d, 13d, 25d, 30d, 22d)
                            .fill(false))
                    .and()
                .options()
                    .responsive(true)
                    .title()
                        .display(true)
                        .text("Mode: "+interactionMode+", intersect: "+ intersect)
                        .and()
                    .tooltips()
                        .mode(interactionMode)
                        .intersect(intersect)
                        .and()
                    .hover()
                        .mode(interactionMode)
                        .intersect(intersect)
                        .and()
                    .done();

                ChartJs chart = new ChartJs(config);
                chart.addStyleName("chart-container");
                chart.setJsLoggingEnabled(true);
                //chart.setWidth(500, Unit.PIXELS);

                layout.addComponent(chart);
            }
        }
        Panel p = new Panel();
        p.setContent(layout);
        p.setSizeFull();
        return p;
    }

}
