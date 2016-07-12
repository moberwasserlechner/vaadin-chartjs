package com.byteowls.vaadin.chartjs;

import java.util.ArrayList;
import java.util.List;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;

import elemental.json.JsonArray;

@JavaScript({"vaadin://chartjs/Chart.min.js", "vaadin://chartjs/chartjs-connector.js"})
public class ChartJs extends AbstractJavaScriptComponent {

    private static final long serialVersionUID = 2999562112373836140L;

    public interface ClickListener {
        void onDataPointClick(int datasetIndex, int dataIndex);
    }

    private List<ChartJs.ClickListener> clickListeners = new ArrayList<>();

    public ChartJs(ChartConfig chartConfig) {
        configure(chartConfig);
        addJsFunctions();
    }

    /**
     * Configure a ChartJs chart.
     *
     * @param chartConfig a chart configuration implementation
     */
    private void configure(ChartConfig chartConfig) {
        if (chartConfig != null) {
            getState().configurationJson = chartConfig.buildJson();
        }
    }

    /**
     * @return True if the connector's logs defined messages to "console.log" else logging is disabled.
     */
    public boolean isJsLoggingEnabled() {
        return getState().loggingEnabled;
    }

    /**
     * Enable or disables the connector's logging to "console.log"
     * @param jsLoggingEnabled If true the connector script will log defined messages to "console.log". Defaults to false. 
     */
    public void setJsLoggingEnabled(boolean jsLoggingEnabled) {
        getState().loggingEnabled = jsLoggingEnabled;
    }

    /**
     * Adds a listener handling clicks on charts data points. 
     * @param listener the click listener.
     */
    public void addClickListener(ChartJs.ClickListener listener) {
        clickListeners.add(listener);
        checkListenerState();
    }

    public void removeClickListener(ChartJs.ClickListener listener) {
        clickListeners.remove(listener);
        checkListenerState();
    }

    private void checkListenerState() {
        getState().clickListenerFound = !this.clickListeners.isEmpty();
    }

    private void addJsFunctions() {
        // this function can be called in chartjs-connector e.g. self.onDataPointClick(datasetIndex, dataIndex)
        addFunction("onDataPointClick", new JavaScriptFunction() {
            private static final long serialVersionUID = -6280339244713509848L;

            @Override
            public void call(JsonArray arguments) {
                int datasetIndex = (int) arguments.getNumber(0);
                int dataIndex = (int) arguments.getNumber(1);
                for (ClickListener l : clickListeners) {
                    l.onDataPointClick(datasetIndex, dataIndex);
                }                
            }
        });
    }

    @Override
    protected ChartJsState getState() {
        return (ChartJsState) super.getState();
    }
}
