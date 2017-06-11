package com.byteowls.vaadin.chartjs.options.types;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.byteowls.vaadin.chartjs.options.AbstractScalableOptions;

public class BubbleChartOptions extends AbstractScalableOptions<BubbleChartOptions> {

    private static final long serialVersionUID = -3318129378787232820L;

    public BubbleChartOptions(ChartConfig chartConfig) {
        super(chartConfig);
    }

    @Override
    public BubbleChartOptions getThis() {
        return this;
    }

}
