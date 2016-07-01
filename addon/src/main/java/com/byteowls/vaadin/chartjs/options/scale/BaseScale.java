package com.byteowls.vaadin.chartjs.options.scale;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import com.byteowls.vaadin.chartjs.utils.SubDone;
import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * @author michael@team-conductor.com
 */
public abstract class BaseScale<T, B> extends SubDone<T> implements JsonBuilder {

  public enum Position {
    TOP, RIGHT, BOTTOM, LEFT
  }

  private String id;
  protected String type;
  protected Boolean display;
  protected Position position;
  protected Boolean stacked;
  protected GridLines<B> gridLines;
  protected Ticks<B> ticks;
  protected ScaleLabel<B> scaleLabel;

  public BaseScale(T parent) {
    super(parent);
  }

  /**
   * "category", "linear", "logarithmic", "time", "radialLinear"
   */
  public BaseScale<T, B> type(String type) {
    this.type = type;
    return this;
  }

  public BaseScale<T, B> display(boolean display) {
    this.display = display;
    return this;
  }

  public BaseScale<T, B> id(String id) {
    this.id = id;
    return this;
  }

  public BaseScale<T, B> stacked(boolean stacked) {
    this.stacked = stacked;
    return this;
  }

  public BaseScale<T, B> position(Position position) {
    this.position = position;
    return this;
  }

  public GridLines<B> gridLines() {
    if (gridLines == null) {
      gridLines = new GridLines<>(getThis());
    }
    return gridLines;
  }

  public ScaleLabel<B> scaleLabel() {
    if (scaleLabel == null) {
      scaleLabel = new ScaleLabel<>(getThis());
    }
    return scaleLabel;
  }

  public Ticks<B> ticks() {
    if (ticks == null) {
      ticks = new Ticks<>(getThis());
    }
    return ticks;
  }

  public abstract B getThis();


  @Override
  public JsonObject buildJson() {
    JsonObject map = Json.createObject();
    JUtils.putNotNull(map, "type", type);
    JUtils.putNotNull(map, "display", display);
    JUtils.putNotNull(map, "id", id);
    JUtils.putNotNull(map, "stacked", stacked);
    if (position != null) {
      JUtils.putNotNull(map, "position", position.name().toLowerCase());
    }
    JUtils.putNotNull(map, "gridLines", gridLines);
    JUtils.putNotNull(map, "scaleLabel", scaleLabel);
    JUtils.putNotNull(map, "ticks", ticks);
    return map;
  }
}
