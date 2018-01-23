package com.byteowls.vaadin.chartjs;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.byteowls.vaadin.chartjs.options.Position;
import com.byteowls.vaadin.chartjs.options.scale.BaseScale;
import com.byteowls.vaadin.chartjs.options.scale.LinearScale;
import com.byteowls.vaadin.chartjs.options.scale.LinearTicks;

import elemental.json.JsonValue;

/**
 * @author Michael Peter
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LinearScaleTests {
	
	private static String jsonResult = "{\"type\":\"linear\",\"position\":\"top\",\"ticks\":{\"reverse\":true}}";

    @Test
    public void _1_testLinearScaleDefault() {
    	
    	BaseScale<LinearScale> scale = new LinearScale()
    			.ticks().reverse(true).and()
    			.position(Position.TOP);
        
        JsonValue jsonValue = scale.buildJson();
        System.out.println("default: "+jsonValue);

        Assert.assertEquals(jsonValue.toJson(),jsonResult);
    }

    @Test
    public void _2_testLinearScaleReversed() {
    	
    	BaseScale<LinearScale> scale = new LinearScale()
    			.position(Position.TOP)
    			.ticks().reverse(true).and();
        
        JsonValue jsonValue = scale.buildJson();
        System.out.println("reversed: "+jsonValue);
        
        Assert.assertEquals(jsonValue.toJson(),jsonResult);
    }

    @Test
    public void _3_testLinearScaleDetailed() {
    	
    	LinearScale scale0 = new LinearScale();
        
        LinearTicks<LinearScale> ticks = scale0.ticks();
        LinearScale scale1 = ticks.reverse(true).and();

        BaseScale<LinearScale> scale2 = scale1.position(Position.TOP);
        
        JsonValue jsonValue = scale2.buildJson();
        System.out.println("detailed: "+jsonValue);

        Assert.assertEquals(jsonValue.toJson(),jsonResult);
    }

}
