package com.byteowls.vaadin.chartjs.demo.ui.charts;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.PolarAreaChartConfig;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.data.PolarAreaDataset;
import com.byteowls.vaadin.chartjs.demo.ui.AbstractChartView;
import com.byteowls.vaadin.chartjs.options.scale.RadialLinearScale;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

@UIScope
@SpringView
public class PolarChartView extends AbstractChartView {

    private static final long serialVersionUID = -5101374789310958419L;

    @Override
    public Component getChart() {
        PolarAreaChartConfig config = new PolarAreaChartConfig();
        config
            .data()
                .labels("Red", "Green", "Yellow", "Grey", "Dark Grey")
                .addDataset(new PolarAreaDataset().label("My dataset").backgroundColor("#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360"))
                .and();
        
        config.
            options()
                .responsive(true)
                .title()
                    .display(true)
                    .text("Chart.js Polar Area Chart")
                    .and()
                .scale(new RadialLinearScale().ticks().beginAtZero(true).and().reverse(false))
                .animation()
                    .animateScale(true)
                    .animateRotate(false)
                    .and()
               .done();
        
        List<String> labels = config.data().getLabels();
        for (Dataset<?, ?> ds : config.data().getDatasets()) {
            PolarAreaDataset lds = (PolarAreaDataset) ds;
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                data.add((double) (Math.round(Math.random() * 100)));
            }
            lds.dataAsList(data);
        }
        
        ChartJs chart = new ChartJs(config);
        chart.setJsLoggingEnabled(true);
        
        chart.addClickListener((a,b) -> {
            PolarAreaDataset dataset = (PolarAreaDataset) config.data().getDatasets().get(a);
            Notification.show("PolarAreaDataset at idx:" + a + "; Data: idx=" + b + "; Value=" + dataset.getData().get(b), Type.TRAY_NOTIFICATION);
        });
        return chart; 
    }

}
