package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.options.line.ScalesOptions;
import elemental.json.JsonObject;

/**
 * @author michael@team-conductor.com
 */
public abstract class AbstractScalableOptions<T> extends AbstractOptions<T> {

  private ScalesOptions<T> scales;

  public ScalesOptions<T> scales() {
    if (scales == null) {
      scales = new ScalesOptions(getThis());
    }
    return scales;
  }

  @Override
  public JsonObject buildJson() {
    JsonObject map = super.buildJson();
    JUtils.putNotNull(map, "scales", scales);
    return map;
  }

}
