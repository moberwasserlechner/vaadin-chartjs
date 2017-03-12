package com.byteowls.vaadin.chartjs.demo.ui.charts;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.BubbleChartConfig;
import com.byteowls.vaadin.chartjs.data.BubbleDataset;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.demo.ui.AbstractChartView;
import com.byteowls.vaadin.chartjs.demo.ui.DemoUtils;
import com.byteowls.vaadin.chartjs.utils.ColorUtils;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Component;

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
            lds.backgroundColor(ColorUtils.randomColor(.7));
            for (int i = 0; i < 15; i++) {
                lds.addData(DemoUtils.randomScalingFactor(), DemoUtils.randomScalingFactor(), Math.abs(DemoUtils.randomScalingFactor()) / 5);
            }
        }
        
        ChartJs chart = new ChartJs(config);
        chart.setJsLoggingEnabled(true);
        chart.addClickListener((a,b) -> {
            BubbleDataset dataset = (BubbleDataset) config.data().getDatasets().get(a);
            DemoUtils.notification(a, b, dataset);
        });
        return chart; 
    }

}
