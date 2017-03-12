package com.byteowls.vaadin.chartjs.demo.ui.charts;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.BarChartConfig;
import com.byteowls.vaadin.chartjs.data.BarDataset;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.demo.ui.AbstractChartView;
import com.byteowls.vaadin.chartjs.demo.ui.DemoUtils;
import com.byteowls.vaadin.chartjs.options.InteractionMode;
import com.byteowls.vaadin.chartjs.options.scale.Axis;
import com.byteowls.vaadin.chartjs.options.scale.DefaultScale;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;

@UIScope
@SpringView
public class GroupedStackedBarChartView extends AbstractChartView {

    private static final long serialVersionUID = -1977315515493155463L;

    @Override
    public Component getChart() {
        BarChartConfig config = new BarChartConfig();
        config.data()
            .labels("January", "February", "March", "April", "May", "June", "July")
            .addDataset(new BarDataset()
                    .label("Dataset 1")
                    .backgroundColor(DemoUtils.RGB_RED)
                    .stack("Stack 0"))
            .addDataset(new BarDataset()
                    .label("Dataset 2")
                    .backgroundColor(DemoUtils.RGB_BLUE)
                    .stack("Stack 0"))
            .addDataset(new BarDataset()
                    .label("Dataset 3")
                    .backgroundColor(DemoUtils.RGB_GREEN)
                    .stack("Stack 1"))
            .and()
        .options()
            .responsive(true)
            .title()
                .display(true)
                .text("Chart.js Bar Chart - Stacked and Grouped")
                .and()
            .tooltips()
                .mode(InteractionMode.INDEX)
                .intersect(false)
                .and()
            .scales()
            .add(Axis.X, new DefaultScale()
                    .stacked(true))
            .add(Axis.Y, new DefaultScale()
                    .stacked(true))
            .and()
            .done();

        // add random data for demo
        List<String> labels = config.data().getLabels();
        for (Dataset<?, ?> ds : config.data().getDatasets()) {
            BarDataset lds = (BarDataset) ds;
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                data.add((double) (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100));
            }
            lds.dataAsList(data);
        }

        ChartJs chart = new ChartJs(config);
        chart.addClickListener((a, b) -> {
            BarDataset dataset = (BarDataset) config.data().getDatasets().get(a);
            DemoUtils.notification(a, b, dataset);
        });
        chart.setJsLoggingEnabled(true);
        return chart;
    }

}
