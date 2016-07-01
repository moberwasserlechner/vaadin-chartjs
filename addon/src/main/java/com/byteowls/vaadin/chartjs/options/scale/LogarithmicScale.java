package com.byteowls.vaadin.chartjs.options.scale;

import com.byteowls.vaadin.chartjs.options.line.ScalesOptions;

/**
 * @author michael@team-conductor.com
 */
public class LogarithmicScale extends BaseScale<ScalesOptions, LogarithmicScale> {

  private LogarithmicTicks logarithmicTicks;

  public LogarithmicScale(ScalesOptions parent) {
    super(parent);
    type("logarithmic");
  }

  @Override
  public LogarithmicTicks<LogarithmicScale> ticks() {
    if (this.logarithmicTicks == null) {
      this.logarithmicTicks = new LogarithmicTicks<>(getThis());
    }
    return this.logarithmicTicks;
  }

  @Override
  public LogarithmicScale getThis() {
    return this;
  }
}
