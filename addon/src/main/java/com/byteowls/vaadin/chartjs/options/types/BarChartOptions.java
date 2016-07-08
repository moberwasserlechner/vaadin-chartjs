package com.byteowls.vaadin.chartjs.options.types;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.byteowls.vaadin.chartjs.options.AbstractScalableOptions;

public class BarChartOptions extends AbstractScalableOptions<BarChartOptions> {

    public BarChartOptions(ChartConfig chartConfig) {
        super(chartConfig);
    }

    @Override
    public BarChartOptions getThis() {
        return this;
    }

}
