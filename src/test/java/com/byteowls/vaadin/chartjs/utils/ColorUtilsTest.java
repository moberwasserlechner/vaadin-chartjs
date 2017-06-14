package com.byteowls.vaadin.chartjs.utils;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * @author michael@team-conductor.com
 */
public class ColorUtilsTest {

    @Test
    public void toRgb() throws Exception {
        int[] rgbArr = {54, 162, 235};
        Assert.assertEquals("rgb(54,162,235)", ColorUtils.toRgb(rgbArr));
    }

    @Test
    public void toRgba() throws Exception {
        int[] rgbArr = {54, 162, 235};
        Assert.assertEquals("rgba(54,162,235,0.2)", ColorUtils.toRgba(rgbArr,0.2));
    }

    @Test
    public void toRgbaAlphaInteger() {
        int[] rgbArr = {54, 162, 235};
        Assert.assertEquals("rgba(54,162,235,1.0)", ColorUtils.toRgba(rgbArr,1));
    }


    @Test
    public void toRgbaAlphaOutofRange() {
        int[] rgbArr = {54, 162, 235};
        Assert.assertEquals("rgba(54,162,235,1.0)", ColorUtils.toRgba(rgbArr,10));

        Assert.assertEquals("rgba(54,162,235,0.0)", ColorUtils.toRgba(rgbArr,-10));
    }

}
