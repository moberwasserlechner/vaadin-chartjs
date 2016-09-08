package com.byteowls.vaadin.chartjs.demo.ui.charts;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.BubbleChartConfig;
import com.byteowls.vaadin.chartjs.data.BubbleDataset;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.demo.ui.AbstractChartView;
import com.byteowls.vaadin.chartjs.demo.ui.ChartUtils;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;

@UIScope
@SpringView
public class SimpleBubbleChartView extends AbstractChartView {

    private static final long serialVersionUID = 2770593137320243086L;

    @Override
    public Component getChart() {
        
        BubbleChartConfig config = new BubbleChartConfig();
        config.
            data()
                .addDataset(new BubbleDataset().label("My First dataset"))
                .addDataset(new BubbleDataset().label("My Second dataset"))
                .and()
            .options()
                .responsive(true)
                .title()
                    .display(true)
                    .text("Chart.js Bubble Chart")
                    .and()
               .done();
        
        for (Dataset<?, ?> ds : config.data().getDatasets()) {
            BubbleDataset lds = (BubbleDataset) ds;
            lds.backgroundColor(ChartUtils.randomColor(.7));
            for (int i = 0; i < 7; i++) {
                lds.addData(ChartUtils.randomScalingFactor(), ChartUtils.randomScalingFactor(), Math.abs(ChartUtils.randomScalingFactor()) / 5);
            }
        }
        
        ChartJs chart = new ChartJs(config);
        chart.setJsLoggingEnabled(true);
        chart.addClickListener((a,b) -> {
            BubbleDataset dataset = (BubbleDataset) config.data().getDatasets().get(a);
            Notification.show("BubbleDataset at idx:" + a + "; Data: idx=" + b + "; Value=" + dataset.getData().get(b), Type.TRAY_NOTIFICATION);
        });
        return chart; 
    }

}
