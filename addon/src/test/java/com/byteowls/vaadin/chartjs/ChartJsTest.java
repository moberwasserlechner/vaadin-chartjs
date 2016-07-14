package com.byteowls.vaadin.chartjs;

import org.junit.Assert;
import org.junit.Test;

import com.byteowls.vaadin.chartjs.config.LineChartConfig;
import com.byteowls.vaadin.chartjs.data.LineDataset;
import com.byteowls.vaadin.chartjs.options.AnimationEasing;
import com.byteowls.vaadin.chartjs.options.Hover;
import com.byteowls.vaadin.chartjs.options.Position;
import com.byteowls.vaadin.chartjs.options.Tooltips;
import com.byteowls.vaadin.chartjs.options.elements.Rectangle.RectangleEdge;
import com.byteowls.vaadin.chartjs.options.scale.Axis;
import com.byteowls.vaadin.chartjs.options.scale.LinearScale;
import com.byteowls.vaadin.chartjs.options.scale.LogarithmicScale;

import elemental.json.JsonValue;

/**
 * @author michael@byteowls.com
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
                .mode(Hover.Mode.SINGLE)
                .and()
            .title()
                .display(true)
                .position(Position.LEFT)
                .text("Hello World")
                .and()
            .animation()
                .easing(AnimationEasing.easeOutQuart)
                .and()
            .tooltips()
                .mode(Tooltips.Mode.LABEL)
                .and()
            .elements()
                .arc()
                    .borderWidth(2)
                    .and()
                .rectangle()
                    .borderSkipped(RectangleEdge.BOTTOM)
                    .and()
                .line()
                    .fill(false)
                    .and()
                .point()
                    .radius(32)
                    .and()
                .and()
            .scales()
                .add(Axis.X, new LinearScale().position(Position.TOP))
                .add(Axis.Y, new LogarithmicScale().position(Position.LEFT))
                .and()
           .legend()
                .fullWidth(false)
                .labels()
                    .boxWidth(20.4)
                    .and()
                .position(Position.BOTTOM)
                .and()
            .tooltips()
                .mode(Tooltips.Mode.LABEL)
                .and()
                
            .done();

        JsonValue jsonValue = config.buildJson();
        Assert.assertNotNull(jsonValue);
    }

}
