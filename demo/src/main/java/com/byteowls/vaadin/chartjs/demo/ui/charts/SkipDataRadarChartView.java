package com.byteowls.vaadin.chartjs.demo.ui.charts;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.RadarChartConfig;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.data.RadarDataset;
import com.byteowls.vaadin.chartjs.demo.ui.AbstractChartView;
import com.byteowls.vaadin.chartjs.demo.ui.ChartUtils;
import com.byteowls.vaadin.chartjs.options.scale.RadialLinearScale;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;

@UIScope
@SpringView
public class SkipDataRadarChartView extends AbstractChartView {

    private static final long serialVersionUID = 3186779414679320384L;

    @Override
    public Component getChart() {
        RadarChartConfig config = new RadarChartConfig();
        config
            .data()
                .labels("Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running")
                .addDataset(new RadarDataset().label("Skip first dataset").borderColor("rgb(255, 0, 0)").backgroundColor("rgba(255,255,0,0.5)").pointBackgroundColor("rgba(220,220,220,1)"))
                .addDataset(new RadarDataset().label("Skip mid dataset").borderColor("rgb(255, 0, 255)").backgroundColor("rgba(0, 255, 0, 0.5)").pointBackgroundColor("rgba(151,187,205,1)").pointHoverBackgroundColor("#fff"))
                .addDataset(new RadarDataset().label("Skip last dataset").borderColor("rgb(0, 255, 255)").backgroundColor("rgba(0, 0, 255, 0.5)").pointBackgroundColor("rgba(151,187,205,1)").pointHoverBackgroundColor("#fff"))
                .and();
        
        config.
            options()
                .title()
                    .display(true)
                    .text("Chart.js Radar Chart - Skip Points")
                    .and()
                 .elements()
                     .line()
                         .tension(0.0)
                         .and()
                     .and()
                .scale(new RadialLinearScale().ticks().beginAtZero(true).and().reverse(false))
               .done();
        
        List<String> labels = config.data().getLabels();
        int cnt = 0;
        for (Dataset<?, ?> ds : config.data().getDatasets()) {
            RadarDataset lds = (RadarDataset) ds;
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                if ((cnt == 0 && i == 0) || (cnt == 1 && i == 3) || (cnt == 2 && i == 6)) {
                    data.add(Double.NaN);
                } else {
                    data.add((double) (Math.round(Math.random() * 100)));
                }
            }
            lds.dataAsList(data);
            cnt++;
        }
        
        ChartJs chart = new ChartJs(config);
        chart.setJsLoggingEnabled(true);
        
        chart.addClickListener((a,b) -> {
            RadarDataset dataset = (RadarDataset) config.data().getDatasets().get(a);
            ChartUtils.notification(a, b, dataset);
        });
        return chart;    
    }

}
