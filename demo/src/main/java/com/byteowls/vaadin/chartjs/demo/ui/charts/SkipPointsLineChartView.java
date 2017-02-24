package com.byteowls.vaadin.chartjs.demo.ui.charts;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.demo.ui.AbstractChartView;
import com.byteowls.vaadin.chartjs.demo.ui.ChartUtils;
import com.byteowls.vaadin.chartjs.options.InteractionMode;
import com.byteowls.vaadin.chartjs.options.scale.Axis;
import com.byteowls.vaadin.chartjs.options.scale.CategoryScale;
import com.byteowls.vaadin.chartjs.options.scale.LinearScale;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;

@UIScope
@SpringView
public class SkipPointsLineChartView extends AbstractChartView {

    private static final long serialVersionUID = -1977315515493155463L;

    @Override
    public Component getChart() {
        LineChartConfig lineConfig = new LineChartConfig();
        lineConfig.data()
            .labels("January", "February", "March", "April", "May", "June", "July")
            .addDataset(new LineDataset().label("My First dataset").fill(true).borderDash(5,5))
            .addDataset(new LineDataset().label("My Second dataset"))
            .and()
        .options()
            .responsive(true)
            .title()
                .display(true)
                .text("Chart.js Line Chart - Skip Points")
                .and()
            .tooltips()
                .mode(InteractionMode.INDEX)
                .and()
            .hover()
                .mode(InteractionMode.INDEX)
                .and()
            .scales()
            .add(Axis.X, new CategoryScale()
                    .display(true)
                    .scaleLabel()
                        .display(true)
                        .labelString("Month")
                        .and())
            .add(Axis.Y, new LinearScale()
                    .display(true)
                    .scaleLabel()
                        .display(true)
                        .labelString("Value")
                        .and())
            .and()
            .done();
        
        // add random data for demo
        List<String> labels = lineConfig.data().getLabels();
        int cnt = 0;
        for (Dataset<?, ?> ds : lineConfig.data().getDatasets()) {
            LineDataset lds = (LineDataset) ds;
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                if ((cnt == 0 && i == 2) || (cnt == 1 && (i == 0 || i == 6))) {
                    data.add(Double.NaN);
                } else {
                    data.add((double) (Math.round(Math.random() * 100)));
                }
            }
            lds.dataAsList(data);
            lds.borderColor(ChartUtils.randomColor(0.4));
            lds.backgroundColor(ChartUtils.randomColor(0.5));
            lds.pointBorderColor(ChartUtils.randomColor(0.7));
            lds.pointBackgroundColor(ChartUtils.randomColor(0.5));
            lds.pointBorderWidth(1);
            cnt++;
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
