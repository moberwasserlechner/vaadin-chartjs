package com.byteowls.vaadin.chartjs.options.types;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.byteowls.vaadin.chartjs.options.AbstractScalableOptions;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import java.util.Map;

public class LineChartOptions extends AbstractScalableOptions<LineChartOptions> {

    private Boolean showLines;

    public LineChartOptions(ChartConfig chartConfig) {
        super(chartConfig);
    }

    public LineChartOptions showLines(boolean showLines) {
        this.showLines = showLines;
        return this;
    }

    @Override
    public Map<String, ?> buildJson() {
        Map<String, ?> map = super.buildJson();
        JUtils.putNotNull(map, "showLines", showLines);
        return map;
    }

    @Override
    public LineChartOptions getThis() {
        return this;
    }

}
