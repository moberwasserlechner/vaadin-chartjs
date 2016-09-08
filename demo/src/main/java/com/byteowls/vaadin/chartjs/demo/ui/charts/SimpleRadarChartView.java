package com.byteowls.vaadin.chartjs.demo.ui.charts;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.RadarChartConfig;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.data.RadarDataset;
import com.byteowls.vaadin.chartjs.demo.ui.AbstractChartView;
import com.byteowls.vaadin.chartjs.options.Position;
import com.byteowls.vaadin.chartjs.options.scale.RadialLinearScale;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

@UIScope
@SpringView
public class SimpleRadarChartView extends AbstractChartView {

    private static final long serialVersionUID = -8575881820534087527L;

    @Override
    public Component getChart() {
        RadarChartConfig config = new RadarChartConfig();
        config
            .data()
                .labels("Eating", "Drinking", "Sleeping", "Designing", "Coding", "Cycling", "Running")
                .addDataset(new RadarDataset().label("My First dataset").backgroundColor("rgba(220,220,220,0.2)").pointBackgroundColor("rgba(220,220,220,1)"))
                .addDataset(new RadarDataset().label("Hidden dataset").hidden(true))
                .addDataset(new RadarDataset().label("My Second  dataset").backgroundColor("rgba(151,187,205,0.2)").pointBackgroundColor("rgba(151,187,205,1)").pointHoverBackgroundColor("#fff"))
                .and();
        
        config.
            options()
                .legend()
                    .position(Position.TOP)
                    .and()
                .title()
                    .display(true)
                    .text("Chart.js Radar Chart")
                    .and()
                .scale(new RadialLinearScale().ticks().beginAtZero(true).and().reverse(false).gridLines().color("black", "red", "orange", "yellow", "green", "blue", "indigo", "violet").and())
               .done();
        
        List<String> labels = config.data().getLabels();
        for (Dataset<?, ?> ds : config.data().getDatasets()) {
            RadarDataset lds = (RadarDataset) ds;
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                data.add((double) (Math.round(Math.random() * 100)));
            }
            lds.dataAsList(data);
        }
        
        ChartJs chart = new ChartJs(config);
        chart.setJsLoggingEnabled(true);
        
        chart.addClickListener((a,b) -> {
            RadarDataset dataset = (RadarDataset) config.data().getDatasets().get(a);
            Notification.show("RadarDataset at idx:" + a + "; Data: idx=" + b + "; Value=" + dataset.getData().get(b), Type.TRAY_NOTIFICATION);
        });
        return chart; 
    }

}
