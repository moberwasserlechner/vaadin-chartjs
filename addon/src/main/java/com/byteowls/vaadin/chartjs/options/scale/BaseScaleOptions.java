package com.byteowls.vaadin.chartjs.options.scale;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * @author michael@team-conductor.com
 */
public abstract class BaseScaleOptions implements JsonBuilder {

  public enum Position {
    TOP, RIGHT, BOTTOM, LEFT
  }

  private String type;
  private String id; // missing in docs
  private Boolean display;
  private Position position;
  private Boolean stacked;

  public BaseScaleOptions type(String type) {
    this.type = type;
    return this;
  }

  public BaseScaleOptions display(boolean display) {
    this.display = display;
    return this;
  }

  public BaseScaleOptions id(String id) {
    this.id = id;
    return this;
  }

  public BaseScaleOptions stacked(boolean stacked) {
    this.stacked = stacked;
    return this;
  }

  public BaseScaleOptions position(Position position) {
    this.position = position;
    return this;
  }


  @Override
  public JsonObject buildJson() {
    JsonObject map = Json.createObject();
    JUtils.putNotNull(map, "type", type);
    JUtils.putNotNull(map, "display", display);
    JUtils.putNotNull(map, "id", id);
    JUtils.putNotNull(map, "stacked", stacked);
    if (position != null) {
      JUtils.putNotNull(map, "mode", position.name().toLowerCase());
    }
    return map;
  }
}
