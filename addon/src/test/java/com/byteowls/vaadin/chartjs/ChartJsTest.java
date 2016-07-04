package com.byteowls.vaadin.chartjs;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.options.AnimationOptions;
import com.byteowls.vaadin.chartjs.options.HoverOptions;
import com.byteowls.vaadin.chartjs.options.TitleOptions;
import com.byteowls.vaadin.chartjs.options.TooltipsOptions;
import com.byteowls.vaadin.chartjs.options.scale.Axis;
import com.byteowls.vaadin.chartjs.options.scale.BaseScale;
import elemental.json.JsonValue;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author michael@team-conductor.com
 */
public class ChartJsTest {

    @Test
    public void testConfigGeneral() {

        LineChartConfig config = new LineChartConfig();
        config
            .data()
                .labels("A", "B", "C")
                .addDataset(new LineDataset().fill(true).label("Dataset 1").data(1D, 2D, 3D))
                .addDataset(new LineDataset().label("Set 2").data(3.3, 1.3, 2.9))
              .and()
            .options()
                .events("test", "test1")
                .showLines(true)
                .responsive(true)
                .hover()
                .mode(HoverOptions.Mode.SINGLE)
                .and()
            .title()
                .display(true)
                .position(TitleOptions.Position.TOP)
                .text("Hello World")
                .and()
            .animation()
                .easing(AnimationOptions.Easing.easeOutQuart)
                .and()
            .tooltips()
                .mode(TooltipsOptions.Mode.LABEL)
                .and()
            // scales must be the last configured, which is not really great
            .scales()
                .linear(Axis.X)
                    .position(BaseScale.Position.TOP)
                    .and()
                .logarithmic(Axis.Y)
                    .position(BaseScale.Position.LEFT)
                    .and()
                .and()

//            .animation()
//            .done()
            .done();

        JsonValue jsonValue = config.buildJson();
        Assert.assertNotNull(jsonValue);
    }

}
