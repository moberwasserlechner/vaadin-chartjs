package com.byteowls.vaadin.chartjs;

import com.vaadin.shared.ui.JavaScriptComponentState;
import elemental.json.JsonValue;

public class ChartJsState extends JavaScriptComponentState {

  public float width;
  public float height;
  public boolean loggingEnabled;
  public JsonValue configurationJson;

}
