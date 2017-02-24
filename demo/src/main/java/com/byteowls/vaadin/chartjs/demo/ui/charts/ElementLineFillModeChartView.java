package com.byteowls.vaadin.chartjs.demo.ui.charts;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.demo.ui.AbstractChartView;
import com.byteowls.vaadin.chartjs.demo.ui.ChartUtils;
import com.byteowls.vaadin.chartjs.options.elements.Line.FillMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;

@UIScope
@SpringView
public class ElementLineFillModeChartView extends AbstractChartView {

    private static final long serialVersionUID = -1977315515493155463L;

    @Override
    public Component getChart() {
        CssLayout layout = new CssLayout();
        for (FillMode fillMode : FillMode.values()) {
            LineChartConfig config = new LineChartConfig();
            config.data()
                .labels("January", "February", "March", "April", "May", "June", "July")
                .addDataset(new LineDataset().label("My First dataset")
                        .borderColor(ChartUtils.RGB_BLUE)
                        .backgroundColor(ChartUtils.RGB_GREY)
                        .data(10d, 30d, 46d, 2d, 8d, 50d, 0d)
                )
                .and()
            .options()
                .responsive(true)
                .title()
                    .display(true)
                    .text("Elements.Line FillMode: "+fillMode)
                    .and()
                .elements()
                    .line()
                        .fill(fillMode)
                        .and()
                    .and()
                .done();

            ChartJs chart = new ChartJs(config);
            chart.addStyleName("chart-container");
            chart.setJsLoggingEnabled(true);
            layout.addComponent(chart);
        }
        Panel p = new Panel();
        p.setContent(layout);
        p.setSizeFull();
        return p;
    }

}
