package com.byteowls.vaadin.chartjs.demo;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.options.HoverOptions;
import com.byteowls.vaadin.chartjs.options.TooltipsOptions;
import com.byteowls.vaadin.chartjs.options.scale.Axis;
import com.byteowls.vaadin.chartjs.options.scale.BaseScale.Position;
import com.byteowls.vaadin.chartjs.options.scale.CategoryScale;
import com.byteowls.vaadin.chartjs.options.scale.LinearScale;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.UI;

@Theme("chartjs")
@Widgetset("ChartJsWidgetset")
public class ChartJsDemoUI extends UI {

    private static final long serialVersionUID = -33887281222947647L;

    @Override
    protected void init(VaadinRequest request) {
        HorizontalLayout vl = new HorizontalLayout();
        vl.setMargin(true);
        vl.setSpacing(true);
        vl.setSizeFull();

        vl.addComponent(simpleLineChart());
        vl.addComponent(stackedLineChart());

        setContent(vl);
    }
    
    private ChartJs simpleLineChart() {
        LineChartConfig lineConfig = new LineChartConfig();
        lineConfig.data()
            .labels("January", "February", "March", "April", "May", "June", "July")
            .addDataset(new LineDataset().label("My First dataset").fill(false))
            .addDataset(new LineDataset().label("My Second dataset").fill(false))
            .addDataset(new LineDataset().label("Hidden dataset").hidden(true))
            .and()
        .options()
            .responsive(true)
            .title()
            .display(true)
            .text("Chart.js Line Chart")
            .and()
        .tooltips()
            .mode(TooltipsOptions.Mode.LABEL)
            .and()
        .hover()
            .mode(HoverOptions.Mode.DATASET)
            .and()
        .scales()
        .add(Axis.X, new CategoryScale()
                .display(true)
                .scaleLabel()
                    .display(true)
                    .labelString("Month")
                    .and()
                .position(Position.TOP))
        .add(Axis.Y, new LinearScale()
                .display(true)
                .scaleLabel()
                    .display(true)
                    .labelString("Value")
                    .and()
                .ticks()
                    .suggestedMin(-10)
                    .suggestedMax(250)
                    .and()
                .position(Position.RIGHT))
        .and()
        .done();
        
        // add random data for demo
        List<String> labels = lineConfig.data().getLabels();
        for (Dataset ds : lineConfig.data().getDatasets()) {
            LineDataset lds = (LineDataset) ds;
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                data.add((double) Math.round(Math.random() * 100));
            }
            lds.dataAsList(data);
            lds.borderColor(randomColor(0.3));
            lds.backgroundColor(randomColor(0.5));
        }

        ChartJs lineChart = new ChartJs(lineConfig);
        lineChart.setJsLoggingEnabled(true);
        lineChart.setWidth(100, Unit.PERCENTAGE);
        return lineChart;
    }
    
    private ChartJs stackedLineChart() {
        LineChartConfig lineConfig = new LineChartConfig();
        lineConfig.data()
            .labels("January", "February", "March", "April", "May", "June", "July")
            .addDataset(new LineDataset().label("My First dataset"))
            .addDataset(new LineDataset().label("My Second dataset"))
            .addDataset(new LineDataset().label("My Third dataset"))
            .addDataset(new LineDataset().label("My Third dataset"))
            .and()
        .options()
            .responsive(true)
            .title()
                .display(true)
                .text("Chart.js Line Chart - Stacked Area")
                .and()
            .tooltips()
                .mode(TooltipsOptions.Mode.LABEL)
                .and()
            .hover()
                .mode(HoverOptions.Mode.LABEL)
                .and()
            .scales()
            .add(Axis.X, new CategoryScale()
                    .scaleLabel()
                        .display(true)
                        .labelString("Month")
                        .and())
            .add(Axis.Y, new LinearScale()
                    .stacked(true)
                    .scaleLabel()
                        .display(true)
                        .labelString("Value")
                        .and())
            .and()
        .done();
        
        // add random data for demo
        List<String> labels = lineConfig.data().getLabels();
        for (Dataset ds : lineConfig.data().getDatasets()) {
            LineDataset lds = (LineDataset) ds;
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                data.add((double) Math.round(Math.random() * 100));
            }
            lds.dataAsList(data);
            String color = randomColor(1);
            lds.borderColor(color);
            lds.backgroundColor(color);
            lds.pointBorderColor(color);
            lds.pointBackgroundColor(color);
            lds.pointBorderWidth(1d);
        }

        ChartJs lineChart = new ChartJs(lineConfig);
        lineChart.setJsLoggingEnabled(true);
        lineChart.setWidth(100, Unit.PERCENTAGE);
        return lineChart;
    }
    
    private long randomColorFactor() {
        return Math.round(Math.random() * 255);
    }
    
    private String randomColor(double d) {
        return "rgba(" + randomColorFactor() + "," + randomColorFactor() + "," + randomColorFactor() + "," + d + ")";
    }
}
