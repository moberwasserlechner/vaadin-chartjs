package com.byteowls.vaadin.chartjs.demo;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.ChartJs;
import com.byteowls.vaadin.chartjs.config.BarChartConfig;
import com.byteowls.vaadin.chartjs.config.BubbleChartConfig;
import com.byteowls.vaadin.chartjs.config.DonutChartConfig;
import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.config.PolarAreaChartConfig;
import com.byteowls.vaadin.chartjs.config.RadarChartConfig;
import com.byteowls.vaadin.chartjs.config.ScatterChartConfig;
import com.byteowls.vaadin.chartjs.data.BarDataset;
import com.byteowls.vaadin.chartjs.data.BubbleDataset;
import com.byteowls.vaadin.chartjs.data.Dataset;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.data.PieDataset;
import com.byteowls.vaadin.chartjs.data.PolarAreaDataset;
import com.byteowls.vaadin.chartjs.data.RadarDataset;
import com.byteowls.vaadin.chartjs.data.ScatterDataset;
import com.byteowls.vaadin.chartjs.options.Hover;
import com.byteowls.vaadin.chartjs.options.Hover.Mode;
import com.byteowls.vaadin.chartjs.options.Position;
import com.byteowls.vaadin.chartjs.options.Tooltips;
import com.byteowls.vaadin.chartjs.options.elements.Rectangle.RectangleEdge;
import com.byteowls.vaadin.chartjs.options.scale.Axis;
import com.byteowls.vaadin.chartjs.options.scale.CategoryScale;
import com.byteowls.vaadin.chartjs.options.scale.LinearScale;
import com.byteowls.vaadin.chartjs.options.scale.RadialLinearScale;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;

@Theme("chartjs")
@SpringUI
@Widgetset("ChartJsWidgetset")
public class ChartJsDemoUI extends UI {

    private static final long serialVersionUID = -33887281222947647L;

    @Override
    protected void init(VaadinRequest request) {
        Panel panel = new Panel();
        
        CssLayout vl = new CssLayout();
        vl.setSizeFull();

        vl.addComponent(simpleLineChart());
        vl.addComponent(stackedLineChart());
        vl.addComponent(barChart());
        vl.addComponent(doughnutChart());
        vl.addComponent(comboBarLineChart());
        vl.addComponent(polarAreaChart());
        vl.addComponent(horizonalBarChart());
        vl.addComponent(bubbleChart());
        vl.addComponent(radarChart());
        vl.addComponent(radarSkipChart());
        vl.addComponent(multiAxisScatterChart());
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
            .mode(Tooltips.Mode.LABEL)
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
        for (Dataset<?, ?> ds : lineConfig.data().getDatasets()) {
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
        lineChart.addClickListener((a,b) -> {
            LineDataset dataset = (LineDataset) lineConfig.data().getDatasets().get(a);
            Notification.show("Dataset: " + a + "; Data: idx=" + b + "; Value=" + dataset.getData().get(b));
        });
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
                .mode(Tooltips.Mode.LABEL)
                .and()
            .hover()
                .mode(Hover.Mode.LABEL)
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
        for (Dataset<?, ?> ds : lineConfig.data().getDatasets()) {
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
            lds.pointBorderWidth(1);
        }

        ChartJs lineChart = new ChartJs(lineConfig);
        lineChart.setJsLoggingEnabled(true);
        lineChart.setWidth(50, Unit.PERCENTAGE);
        return lineChart;
    }
    
    private ChartJs barChart() {
        
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
        for (Dataset<?, ?> ds : barConfig.data().getDatasets()) {
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
    
    private ChartJs doughnutChart() {
        
        DonutChartConfig config = new DonutChartConfig();
        config
            .data()
                .labels("Red", "Green", "Yellow", "Grey", "Dark Grey")
                .addDataset(new PieDataset().label("Dataset 1"))
                .addDataset(new PieDataset().label("Dataset 2"))
                .addDataset(new PieDataset().label("Dataset 3"))
                .and();
        
        config.
            options()
                .responsive(true)
                .title()
                    .display(true)
                    .text("Chart.js Doughnut Chart")
                    .and()
                .animation()
                    .animateScale(true)
                    .animateRotate(true)
                    .and()
               .done();
        
        String[] colors = new String[] {"#F7464A", "#46BFBD", "#FDB45C", "#949FB1", "#4D5360"};
        
        List<String> labels = config.data().getLabels();
        for (Dataset<?, ?> ds : config.data().getDatasets()) {
            PieDataset lds = (PieDataset) ds;
            lds.backgroundColor(colors);
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                data.add((double) (Math.round(Math.random() * 100)));
            }
            lds.dataAsList(data);
        }
        
        ChartJs lineChart = new ChartJs(config);
        lineChart.setJsLoggingEnabled(true);
        lineChart.setWidth(50, Unit.PERCENTAGE);
        return lineChart; 
    }
    
    
    private ChartJs polarAreaChart() {
        
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
        
        ChartJs lineChart = new ChartJs(config);
        lineChart.setJsLoggingEnabled(true);
        lineChart.setWidth(50, Unit.PERCENTAGE);
        
        lineChart.addClickListener((a,b) -> {
            PolarAreaDataset dataset = (PolarAreaDataset) config.data().getDatasets().get(a);
            Notification.show("PolarAreaDataset at idx:" + a + "; Data: idx=" + b + "; Value=" + dataset.getData().get(b), Type.TRAY_NOTIFICATION);
        });
        return lineChart; 
    }
    
    private ChartJs comboBarLineChart() {
        
        BarChartConfig config = new BarChartConfig();
        config
            .data()
                .labels("January", "February", "March", "April", "May", "June", "July")
                .addDataset(new BarDataset().type().label("Dataset 1").backgroundColor("rgba(151,187,205,0.5)").borderColor("white").borderWidth(2))
                .addDataset(new LineDataset().type().label("Dataset 2").backgroundColor("rgba(151,187,205,0.5)").borderColor("white").borderWidth(2))
                .addDataset(new BarDataset().type().label("Dataset 3").backgroundColor("rgba(220,220,220,0.5)"))
                .and();
        
        config.
            options()
                .responsive(true)
                .title()
                    .display(true)
                    .position(Position.LEFT)
                    .text("Chart.js Combo Bar Line Chart")
                    .and()
               .done();
        
        List<String> labels = config.data().getLabels();
        for (Dataset<?, ?> ds : config.data().getDatasets()) {
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                data.add((double) (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100));
            }
            
            if (ds instanceof BarDataset) {
                BarDataset bds = (BarDataset) ds;
                bds.dataAsList(data);    
            }
                
            if (ds instanceof LineDataset) {
                LineDataset lds = (LineDataset) ds;
                lds.dataAsList(data);    
            }
        }
        
        ChartJs lineChart = new ChartJs(config);
        lineChart.setJsLoggingEnabled(true);
        lineChart.setWidth(50, Unit.PERCENTAGE);
        
        return lineChart; 
    }
    
    private ChartJs horizonalBarChart() {
        
        BarChartConfig barConfig = new BarChartConfig();
        barConfig.horizontal();
        barConfig.
            data()
                .labels("January", "February", "March", "April", "May", "June", "July")
                .addDataset(new BarDataset().backgroundColor("rgba(220,220,220,0.5)").label("Dataset 1"))
                .addDataset(new BarDataset().backgroundColor("rgba(151,187,205,0.5)").label("Dataset 2").hidden(true))
                .addDataset(new BarDataset().backgroundColor("rgba(151,187,205,0.5)").label("Dataset 3"))
                .and()
            .options()
                .responsive(true)
                .title()
                    .display(true)
                    .text("Chart.js Horizontal Bar Chart")
                    .and()
                 .elements()
                     .rectangle()
                         .borderWidth(2)
                         .borderColor("rgb(0, 255, 0)")
                         .borderSkipped(RectangleEdge.LEFT)
                         .and()
                     .and()
                 .legend()
                     .fullWidth(false)
                     .position(Position.LEFT)
                     .and()
               .done();
        
        List<String> labels = barConfig.data().getLabels();
        for (Dataset<?, ?> ds : barConfig.data().getDatasets()) {
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
        lineChart.addClickListener((a,b) -> {
            BarDataset dataset = (BarDataset) barConfig.data().getDatasets().get(a);
            Notification.show("BarDataset at idx:" + a + "; Data: idx=" + b + "; Value=" + dataset.getData().get(b), Type.WARNING_MESSAGE);
        });
        return lineChart; 
    }
    
    
    private ChartJs bubbleChart() {
        
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
            lds.backgroundColor(randomColor(.7));
            for (int i = 0; i < 7; i++) {
                lds.addData(randomScalingFactor(), randomScalingFactor(), Math.abs(randomScalingFactor()) / 5);
            }
        }
        
        ChartJs lineChart = new ChartJs(config);
        lineChart.setJsLoggingEnabled(true);
        lineChart.setWidth(50, Unit.PERCENTAGE);
        lineChart.addClickListener((a,b) -> {
            BubbleDataset dataset = (BubbleDataset) config.data().getDatasets().get(a);
            Notification.show("BubbleDataset at idx:" + a + "; Data: idx=" + b + "; Value=" + dataset.getData().get(b), Type.TRAY_NOTIFICATION);
        });
        return lineChart; 
    }
    
    private ChartJs radarChart() {
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
        
        ChartJs lineChart = new ChartJs(config);
        lineChart.setJsLoggingEnabled(true);
        lineChart.setWidth(50, Unit.PERCENTAGE);
        
        lineChart.addClickListener((a,b) -> {
            RadarDataset dataset = (RadarDataset) config.data().getDatasets().get(a);
            Notification.show("RadarDataset at idx:" + a + "; Data: idx=" + b + "; Value=" + dataset.getData().get(b), Type.TRAY_NOTIFICATION);
        });
        return lineChart; 
    }
    
    private ChartJs radarSkipChart() {
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
        
        ChartJs lineChart = new ChartJs(config);
        lineChart.setJsLoggingEnabled(true);
        lineChart.setWidth(50, Unit.PERCENTAGE);
        
        lineChart.addClickListener((a,b) -> {
            RadarDataset dataset = (RadarDataset) config.data().getDatasets().get(a);
            Notification.show("RadarDataset at idx:" + a + "; Data: idx=" + b + "; Value=" + dataset.getData().get(b), Type.TRAY_NOTIFICATION);
        });
        return lineChart; 
    }
    
    private ChartJs multiAxisScatterChart() {
        ScatterChartConfig config = new ScatterChartConfig();
        config
            .data()
                .addDataset(new ScatterDataset().label("My First dataset").xAxisID("x-axis-1").yAxisID("y-axis-1"))
                .addDataset(new ScatterDataset().label("My Second  dataset").xAxisID("x-axis-1").yAxisID("y-axis-2"))
                .and();
        config.
            options()
                .responsive(true)
                .hover()
                    .mode(Mode.SINGLE)
                    .and()
                .title()
                    .display(true)
                    .text("Chart.js Scatter Chart - Multi Axis")
                    .and()
                .scales()
                    .add(Axis.X, new LinearScale().position(Position.BOTTOM).gridLines().zeroLineColor("rgba(0,0,0,1)").and())
                    .add(Axis.Y, new LinearScale().display(true).position(Position.LEFT).id("y-axis-1"))
                    .add(Axis.Y, new LinearScale().display(true).position(Position.RIGHT).id("y-axis-2").ticks().reverse(true).and().gridLines().drawOnChartArea(false).and())
                    .and()
               .done();
        
        for (Dataset<?, ?> ds : config.data().getDatasets()) {
            ScatterDataset lds = (ScatterDataset) ds;
            lds.borderColor(randomColor(.4));
            lds.backgroundColor(randomColor(.1));
            lds.pointBorderColor(randomColor(.7));
            lds.pointBackgroundColor(randomColor(.5));
            lds.pointBorderWidth(1);
            for (int i = 0; i < 7; i++) {
                lds.addData(randomScalingFactor(), randomScalingFactor());
            }
        }
        
        ChartJs lineChart = new ChartJs(config);
        lineChart.setJsLoggingEnabled(true);
        lineChart.setWidth(50, Unit.PERCENTAGE);
        
        lineChart.addClickListener((a,b) -> {
            ScatterDataset dataset = (ScatterDataset) config.data().getDatasets().get(a);
            Notification.show("ScatterDataset at idx:" + a + "; Data: idx=" + b + "; Value=" + dataset.getData().get(b), Type.TRAY_NOTIFICATION);
        });
        return lineChart; 
    }
    
    private double randomScalingFactor() {
        return (double) (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100);
    }
    
    private long randomColorFactor() {
        return Math.round(Math.random() * 255);
    }
    
    private String randomColor(double d) {
        return "rgba(" + randomColorFactor() + "," + randomColorFactor() + "," + randomColorFactor() + "," + d + ")";
    }
}
