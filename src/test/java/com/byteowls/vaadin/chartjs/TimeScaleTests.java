package com.byteowls.vaadin.chartjs;

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
	
	static private String jsonResult = "{\"type\":\"time\",\"position\":\"top\",\"time\":{\"displayFormat\":{\"hour\":\"'DD.MM hh:mm'\",\"day\":\"MMM DD\"},\"unit\":\"hour\"}}";
	
	@Test
    public void testTimeScale() {
    	
        TimeScale scale = new TimeScale()
        	.position(Position.TOP)
        	.time()
        	.displayFormat()
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
