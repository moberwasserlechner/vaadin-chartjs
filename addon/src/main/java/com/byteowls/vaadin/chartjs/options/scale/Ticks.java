package com.byteowls.vaadin.chartjs.options.scale;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import com.byteowls.vaadin.chartjs.utils.SubDone;
import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * @author michael@team-conductor.com
 */
public class Ticks<T> extends SubDone<T> implements JsonBuilder {

  private Boolean autoSkip;
  private Boolean display;

  public Ticks(T parent) {
    super(parent);
  }

  /**
   * 	If true, automatically calculates how many labels that can be shown and hides labels accordingly.
   *
   * 	Turn it off to show all labels no matter what
   */
  public Ticks<T> autoSkip(boolean autoSkip) {
    this.autoSkip = autoSkip;
    return this;
  }

  /**
   * 	If true, show the ticks.
   */
  public Ticks<T> display(boolean display) {
    this.display = display;
    return this;
  }

  @Override
  public JsonObject buildJson() {
    JsonObject map = Json.createObject();
    JUtils.putNotNull(map, "display", display);
    JUtils.putNotNull(map, "autoSkip", autoSkip);
    return map;
  }
}
