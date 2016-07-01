package com.byteowls.vaadin.chartjs.options.line;

import com.byteowls.vaadin.chartjs.options.scale.Axis;
import com.byteowls.vaadin.chartjs.options.scale.LinearScale;
import com.byteowls.vaadin.chartjs.options.scale.LogarithmicScale;
import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import com.byteowls.vaadin.chartjs.options.scale.BaseScale;
import com.byteowls.vaadin.chartjs.utils.SubDone;
import elemental.json.Json;
import elemental.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author michael@team-conductor.com
 */
public class ScalesOptions<T> extends SubDone<T> implements JsonBuilder {

  private List<BaseScale> xAxes;
  private List<BaseScale> yAxes;

  public ScalesOptions(T parent) {
    super(parent);
  }

  public LinearScale linear(Axis axis) {
    LinearScale linearScale = new LinearScale(this);
    addToAxes(axis, linearScale);
    return linearScale;
  }

  public LogarithmicScale logarithmic(Axis axis) {
    LogarithmicScale logarithmicScale = new LogarithmicScale(this);
    addToAxes(axis, logarithmicScale);
    return logarithmicScale;
  }

  private void addToAxes(Axis axis, BaseScale scale) {
    if (axis == Axis.X) {
      if (xAxes == null) {
        xAxes = new ArrayList<>();
      }
      xAxes.add(scale);
    } else {
      if (yAxes == null) {
        yAxes = new ArrayList<>();
      }
      yAxes.add(scale);
    }
  }


  @Override
  public JsonObject buildJson() {
    JsonObject map = Json.createObject();
    JUtils.putNotNullBuilders(map, "xAxes", xAxes);
    JUtils.putNotNullBuilders(map, "yAxes", yAxes);
    return map;
  }
}
