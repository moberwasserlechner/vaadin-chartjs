package com.byteowls.vaadin.chartjs;

import com.vaadin.shared.ui.JavaScriptComponentState;
import elemental.json.JsonValue;

public class ChartJsState extends JavaScriptComponentState {

    private static final long serialVersionUID = 542472889885500321L;
    
    public boolean loggingEnabled;
    public boolean dataPointClickListenerFound;
    public JsonValue configurationJson;

}
