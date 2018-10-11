package com.byteowls.vaadin.chartjs;

import java.util.Map;

import com.vaadin.shared.ui.JavaScriptComponentState;
import elemental.json.JsonValue;

public class ChartJsState extends JavaScriptComponentState {

    private static final long serialVersionUID = 542472889885500321L;
    
    public boolean loggingEnabled;
    public boolean dataPointClickListenerFound;
    public boolean legendClickListenerFound;
    public boolean showDownloadAction;
    public String downloadActionText;
    public String downloadActionFilename;
    public Map<String, String> menuItems;
    public JsonValue configurationJson;

}
