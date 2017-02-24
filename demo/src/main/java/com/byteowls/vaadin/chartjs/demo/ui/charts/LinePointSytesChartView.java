package com.byteowls.vaadin.chartjs.demo.ui.charts;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.data.PointStyle;
import com.byteowls.vaadin.chartjs.demo.ui.AbstractChartView;
import com.byteowls.vaadin.chartjs.demo.ui.ChartUtils;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;

@UIScope
@SpringView
public class LinePointSytesChartView extends AbstractChartView {

    private static final long serialVersionUID = -1977315515493155463L;

    @Override
    public Component getChart() {
        CssLayout layout = new CssLayout();

        List<Boolean> intersects = new ArrayList<>();
        intersects.add(true);
        intersects.add(false);
        for (PointStyle pointStyle : PointStyle.values()) {
            LineChartConfig config = new LineChartConfig();
            config.data()
                .labels("January", "February", "March", "April", "May", "June", "July")
                .addDataset(new LineDataset().label("My First dataset")
                        .borderColor(ChartUtils.RGB_RED)
                        .backgroundColor(ChartUtils.RGB_RED)
                        .data(10d, 23d, 5d, 99d, 67d, 43d, 0d)
                        .fill(false)
                        .pointRadius(10)
                        .pointHoverRadius(15)
//                        .pointStyle(pointStyle)
                        .showLine(false))
                .and()
            .options()
                .responsive(true)
                .title()
                    .display(true)
                    .text("Point Style: "+pointStyle)
                    .and()
                .legend()
                    .display(false)
                    .and()
                .elements()
                    .point()
                        .pointStyle(pointStyle)
                        .and()
                    .and()
                .done();

            ChartJs chart = new ChartJs(config);
            chart.addStyleName("chart-container");
            chart.setJsLoggingEnabled(true);
            //chart.setWidth(500, Unit.PIXELS);

            layout.addComponent(chart);
        }
        Panel p = new Panel();
        p.setContent(layout);
        p.setSizeFull();
        return p;
    }

}
