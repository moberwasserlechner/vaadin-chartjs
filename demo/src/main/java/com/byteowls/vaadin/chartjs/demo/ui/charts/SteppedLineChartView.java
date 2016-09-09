package com.byteowls.vaadin.chartjs.demo.ui.charts;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.data.LineDataset;
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
public class SteppedLineChartView extends AbstractChartView {

    private static final long serialVersionUID = -1977315515493155463L;

    @Override
    public Component getChart() {
        LineChartConfig config = new LineChartConfig();
        config.data()
            .labels("January", "February", "March", "April", "May", "June", "July")
            .addDataset(new LineDataset().label("My First dataset").fill(false).borderDash(5,5).steppedLine(true))
            .addDataset(new LineDataset().label("hidden dataset").steppedLine(true).hidden(true))
            .addDataset(new LineDataset().label("My Second dataset").steppedLine(true))
            .and()
        .options()
            .responsive(true)
            .title()
                .display(true)
                .text("Chart.js Line Chart - Stepped Line")
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
                        .labelString("Month")
                        .and())
            .add(Axis.Y, new LinearScale()
                    .display(true)
                    .scaleLabel()
                        .display(true)
                        .labelString("Value")
                        .and()
                    .ticks()
                        .suggestedMin(-10)
                        .suggestedMax(250)
                        .and())
            .and()
            .done();
        
        // add random data for demo
        List<String> labels = config.data().getLabels();
        for (Dataset<?, ?> ds : config.data().getDatasets()) {
            LineDataset lds = (LineDataset) ds;
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                data.add((double) (Math.random() > 0.5 ? -1 : 1) * Math.round(Math.random() * 100));
            }
            lds.dataAsList(data);
            lds.borderColor(ChartUtils.randomColor(0.4));
            lds.backgroundColor(ChartUtils.randomColor(0.5));
            lds.pointBorderColor(ChartUtils.randomColor(0.7));
            lds.pointBackgroundColor(ChartUtils.randomColor(0.5));
            lds.pointBorderWidth(1);
        }

        ChartJs chart = new ChartJs(config);
        chart.addClickListener((a,b) -> {
            LineDataset dataset = (LineDataset) config.data().getDatasets().get(a);
            ChartUtils.notification(a, b, dataset);
        });
        chart.setJsLoggingEnabled(true);
        return chart;
    }

}
