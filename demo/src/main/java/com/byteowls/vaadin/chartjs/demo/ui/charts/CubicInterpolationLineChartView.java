package com.byteowls.vaadin.chartjs.demo.ui.charts;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.data.LineDataset.CubicInterpolationMode;
import com.byteowls.vaadin.chartjs.demo.ui.AbstractChartView;
import com.byteowls.vaadin.chartjs.demo.ui.ChartUtils;
import com.byteowls.vaadin.chartjs.options.Hover;
import com.byteowls.vaadin.chartjs.options.Tooltips.Mode;
import com.byteowls.vaadin.chartjs.options.scale.Axis;
import com.byteowls.vaadin.chartjs.options.scale.CategoryScale;
import com.byteowls.vaadin.chartjs.options.scale.LinearScale;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;

@UIScope
@SpringView
public class CubicInterpolationLineChartView extends AbstractChartView {

    private static final long serialVersionUID = -1977315515493155463L;

    @Override
    public Component getChart() {
        LineChartConfig lineConfig = new LineChartConfig();
        lineConfig.data()
            .labels("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12")
            .addDataset(new LineDataset().label("Cubic interpolation (monotone)").borderColor("rgba(255, 0, 0, 0.7)")
                    .backgroundColor("rgba(0, 0, 0, 0)").cubicInterpolationMode(CubicInterpolationMode.MONOTONE))
            .addDataset(new LineDataset().label("Cubic interpolation (default)").borderColor("rgba(0, 0, 255, 0.3)").backgroundColor("rgba(0, 0, 0, 0)"))
            .addDataset(new LineDataset().label("Linear interpolation").borderColor("rgba(0, 0, 0, 0.10)").backgroundColor("rgba(0, 0, 0, 0)").lineTension(0))
            .and()
        .options()
            .responsive(true)
            .title()
                .display(true)
                .text("Chart.js Line Chart - Cubic interpolation mode")
                .and()
            .tooltips()
                .mode(Mode.LABEL)
                .and()
            .hover()
                .mode(Hover.Mode.DATASET)
                .and()
            .scales()
            .add(Axis.X, new CategoryScale()
                    .display(true)
                    .scaleLabel()
                        .display(true)
                        .and())
            .add(Axis.Y, new LinearScale()
                    .display(true)
                    .scaleLabel()
                        .display(true)
                        .labelString("Value")
                        .and()
                    .ticks()
                        .suggestedMin(-10)
                        .suggestedMax(200)
                        .and())
            .and()
            .done();
        
        // add random data for demo
        for (Dataset<?, ?> ds : lineConfig.data().getDatasets()) {
            LineDataset lds = (LineDataset) ds;
            lds.data(0d, 20d, 20d, 60d, 60d, 120d, Double.NaN, 180d, 120d, 125d, 105d, 110d, 170d);
        }

        ChartJs chart = new ChartJs(lineConfig);
        chart.addClickListener((a,b) -> {
            LineDataset dataset = (LineDataset) lineConfig.data().getDatasets().get(a);
            ChartUtils.notification(a, b, dataset);
        });
        chart.setJsLoggingEnabled(true);
        return chart;
    }

}
