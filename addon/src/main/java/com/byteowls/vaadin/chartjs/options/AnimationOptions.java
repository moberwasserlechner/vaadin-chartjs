package com.byteowls.vaadin.chartjs.options;

import com.byteowls.vaadin.chartjs.utils.JUtils;
import com.byteowls.vaadin.chartjs.utils.JsonBuilder;
import com.byteowls.vaadin.chartjs.utils.SubDone;
import elemental.json.Json;
import elemental.json.JsonObject;

/**
 * @author michael@team-conductor.com
 */
public class AnimationOptions<T> extends SubDone<T> implements JsonBuilder {

  public AnimationOptions(T parent) {
    super(parent);
  }

  public enum Easing {
    linear, easeInQuad, easeOutQuad, easeInOutQuad, easeInCubic, easeOutCubic,
    easeInOutCubic, easeInQuart, easeOutQuart, easeInOutQuart, easeInQuint,
    easeOutQuint, easeInOutQuint, easeInSine, easeOutSine, easeInOutSine,
    easeInExpo, easeOutExpo, easeInOutExpo, easeInCirc, easeOutCirc, easeInOutCirc,
    easeInElastic, easeOutElastic, easeInOutElastic, easeInBack, easeOutBack,
    easeInOutBack, easeInBounce, easeOutBounce, easeInOutBounce
  }

  private Integer duration;
  private Easing easing;
  // TODO callback functions http://www.chartjs.org/docs/#chart-configuration-animation-configuration
  // onProgress
  // onComplete

  public AnimationOptions<T> duration(int duration) {
    this.duration = duration;
    return this;
  }

  public AnimationOptions<T> easing(Easing easing) {
    this.easing = easing;
    return this;
  }

  @Override
  public JsonObject buildJson() {
    JsonObject map = Json.createObject();
    JUtils.putNotNull(map, "duration", duration);
    if (easing != null) {
      JUtils.putNotNull(map, "easing", easing.name());
    }
    return map;
  }
}
