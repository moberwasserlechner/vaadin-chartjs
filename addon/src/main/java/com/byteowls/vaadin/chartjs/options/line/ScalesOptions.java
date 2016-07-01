package com.byteowls.vaadin.chartjs.options.line;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import com.byteowls.vaadin.chartjs.options.scale.BaseScaleOptions;
import com.byteowls.vaadin.chartjs.utils.SubDone;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.util.List;

/**
 * @author michael@team-conductor.com
 */
public class ScalesOptions<T> extends SubDone<T> implements JsonBuilder {

  private List<? extends BaseScaleOptions> xAxes;
  private List<? extends BaseScaleOptions> yAxes;

  public ScalesOptions(T parent) {
    super(parent);
  }

  public ScalesOptions<T> addXAxes() {
    return this;
  }


  @Override
  public JsonObject buildJson() {
    JsonObject map = Json.createObject();
    JUtils.putNotNullBuilders(map, "xAxes", xAxes);
    JUtils.putNotNullBuilders(map, "yAxes", yAxes);
    return map;
  }
}
