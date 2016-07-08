package com.byteowls.vaadin.chartjs.demo;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.BarChartConfig;
import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.data.BarDataset;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.options.HoverOptions;
import com.byteowls.vaadin.chartjs.options.HoverOptions.Mode;
import com.byteowls.vaadin.chartjs.options.TooltipsOptions;
import com.byteowls.vaadin.chartjs.options.scale.Axis;
import com.byteowls.vaadin.chartjs.options.scale.BaseScale.Position;
import com.byteowls.vaadin.chartjs.options.scale.CategoryScale;
import com.byteowls.vaadin.chartjs.options.scale.LinearScale;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

@Theme("chartjs")
@Widgetset("ChartJsWidgetset")
public class ChartJsDemoUI extends UI {

    private static final long serialVersionUID = -33887281222947647L;

    @Override
    protected void init(VaadinRequest request) {
        Panel panel = new Panel();
        panel.setSizeFull();
        
        CssLayout vl = new CssLayout();
        vl.setSizeFull();

        vl.addComponent(simpleLineChart());
        vl.addComponent(stackedLineChart());
        vl.addComponent(barLineChart());
        
        panel.setContent(vl);
        setContent(panel);
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
        lineChart.setWidth(50, Unit.PERCENTAGE);
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
        lineChart.setWidth(50, Unit.PERCENTAGE);
        return lineChart;
    }
    
    private ChartJs barLineChart() {
        
        BarChartConfig barConfig = new BarChartConfig();
        barConfig.
            data()
                .labels("January", "February", "March", "April", "May", "June", "July")
                .addDataset(new BarDataset().backgroundColor("rgba(220,220,220,0.5)").label("Dataset 1").yAxisID("y-axis-1"))
                .addDataset(new BarDataset().backgroundColor("rgba(151,187,205,0.5)").label("Dataset 2").yAxisID("y-axis-2"))
                .addDataset(new BarDataset().backgroundColor(randomColor(0.7), randomColor(0.7), randomColor(0.7),randomColor(0.7),randomColor(0.7),randomColor(0.7),randomColor(0.7)).label("Dataset 3").yAxisID("y-axis-1").hidden(true))
                .and();
        
        barConfig.
            options()
                .responsive(true)
                .hover()
                    .mode(Mode.LABEL)
                    .animationDuration(400)
                    .and()
                .title()
                    .display(true)
                    .text("Chart.js Bar Chart - Multi Axis")
                    .and()
                .scales()
                    .add(Axis.Y, new LinearScale().display(true).position(Position.LEFT).id("y-axis-1"))
                    .add(Axis.Y, new LinearScale().display(true).position(Position.RIGHT).id("y-axis-2").gridLines().drawOnChartArea(false).and())
                    .and()
               .done();
        
        List<String> labels = barConfig.data().getLabels();
        for (Dataset ds : barConfig.data().getDatasets()) {
            BarDataset lds = (BarDataset) ds;
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                data.add((double) (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100));
            }
            lds.dataAsList(data);
        }
        
        ChartJs lineChart = new ChartJs(barConfig);
        lineChart.setJsLoggingEnabled(true);
        lineChart.setWidth(50, Unit.PERCENTAGE);
        return lineChart; 
    }
    
    private long randomColorFactor() {
        return Math.round(Math.random() * 255);
    }
    
    private String randomColor(double d) {
        return "rgba(" + randomColorFactor() + "," + randomColorFactor() + "," + randomColorFactor() + "," + d + ")";
    }
}
