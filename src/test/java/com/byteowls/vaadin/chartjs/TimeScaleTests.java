package com.byteowls.vaadin.chartjs;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.byteowls.vaadin.chartjs.options.Position;
import com.byteowls.vaadin.chartjs.options.scale.TimeScale;
import com.byteowls.vaadin.chartjs.options.scale.TimeScaleOptions.Unit;

import elemental.json.JsonValue;

/**
 * @author Michael Peter
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TimeScaleTests {
	
	static private String jsonResult = "{\"type\":\"time\",\"position\":\"top\",\"time\":{\"displayFormats\":{\"hour\":\"'DD.MM hh:mm'\",\"day\":\"MMM DD\"},\"min\":\"2017-01-24T11:12\",\"unit\":\"hour\"}}";
	
	@Test
    public void testTimeScale() {
    	
        TimeScale scale = new TimeScale()
        	.position(Position.TOP)
        	.time()
        		.min(LocalDateTime.of(2017, 01, 24, 11, 12))
	        	.displayFormats()
	        		.hour("'DD.MM hh:mm'")
	        		.day("MMM DD")
	        		.and()
	           	.unit(Unit.HOUR)
	        	.and();

        JsonValue jsonValue = scale.buildJson();
        System.out.println("TimeScale: "+jsonValue);

        Assert.assertEquals(jsonValue.toJson(), jsonResult);
    }

}
