package com.byteowls.vaadin.chartjs;

import com.byteowls.vaadin.chartjs.config.ChartConfig;
import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;
import elemental.json.JsonArray;

import java.util.ArrayList;
import java.util.List;

@JavaScript({"vaadin://chartjs/Chart.min.js", "vaadin://chartjs/hammer.min.js", "vaadin://chartjs/chartjs-plugin-zoom.min.js", "vaadin://chartjs/chartjs-connector.js"})
public class ChartJs extends AbstractJavaScriptComponent {

    private static final long serialVersionUID = 2999562112373836140L;

//    public enum ImageType {
//        PNG
//    }

    public interface DataPointClickListener {
        void onDataPointClick(int datasetIndex, int dataIndex);
    }
    
    public interface LegendClickListener {
        void onLegendClick(int who, boolean isVisible, int[] visibles);
    }

//    public interface DownloadListener {
//        void onDownload(byte[] imageData);
//    }

    private List<ChartJs.DataPointClickListener> dataPointClickListeners = new ArrayList<>();
    private List<ChartJs.LegendClickListener> legendClickListeners = new ArrayList<>();
//    private List<ChartJs.DownloadListener> downloadListeners = new ArrayList<>();

    private ChartConfig chartConfig;

    /**
     * Construct a ChartJs. Be aware that you have to set a {@link ChartConfig} as well. Use {@link #configure(ChartConfig)} to do so.
     */
    public ChartJs() {
        addJsFunctions();
    }

    /**
     * Constructs a chart with a {@link ChartConfig}
     * @param chartConfig a chart configuration implementation
     */
    public ChartJs(ChartConfig chartConfig) {
        configure(chartConfig);
        addJsFunctions();
    }

    /**
     * Configure a ChartJs chart.
     * @param chartConfig a chart configuration implementation
     */
    public void configure(ChartConfig chartConfig) {
        if (chartConfig != null) {
            this.chartConfig = chartConfig;
        }
    }

    @Override
    public void attach() {
        if (chartConfig != null) {
            getState().configurationJson = chartConfig.buildJson();
        }
        super.attach();
    }

    /**
     * @return Chart configuration. Useful for update the data after chart drawing
     */
    public ChartConfig getConfig() {
        return this.chartConfig;
    }

    /**
     * Update the chart data. Before calling this method, new data must be supplied.
     */
    public void refreshData() {
        if (chartConfig != null) {
            getState().configurationJson = chartConfig.buildJson();
        }
        callFunction("updateData");
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
    public void addClickListener(ChartJs.DataPointClickListener listener) {
        dataPointClickListeners.add(listener);
        checkListenerState();
    }

    public void removeClickListener(ChartJs.DataPointClickListener listener) {
        dataPointClickListeners.remove(listener);
        checkListenerState();
    }
    public void addLegendClickListener(ChartJs.LegendClickListener listener) {
    	legendClickListeners.add(listener);
        checkListenerState();
    }

    public void removeLegendClickListener(ChartJs.LegendClickListener listener) {
    	legendClickListeners.remove(listener);
        checkListenerState();
    }

//    /**
//     * Adds a listener serving the downloaded image.
//     * @param listener the download listener.
//     */
//    public void addDownloadListener(ChartJs.DownloadListener listener) {
//        downloadListeners.add(listener);
//    }
//
//    public void removeDownloadListener(ChartJs.DownloadListener listener) {
//        downloadListeners.remove(listener);
//    }

    private void checkListenerState() {
        getState().dataPointClickListenerFound = !this.dataPointClickListeners.isEmpty();
        getState().legendClickListenerFound = !this.legendClickListeners.isEmpty();
    }

    private void addJsFunctions() {
        // this function can be called in chartjs-connector e.g. self.onDataPointClick(datasetIndex, dataIndex)
        addFunction("onDataPointClick", new JavaScriptFunction() {
            private static final long serialVersionUID = -6280339244713509848L;

            @Override
            public void call(JsonArray arguments) {
                int datasetIndex = (int) arguments.getNumber(0);
                int dataIndex = (int) arguments.getNumber(1);
                for (DataPointClickListener l : dataPointClickListeners) {
                    l.onDataPointClick(datasetIndex, dataIndex);
                }
            }
        });
        addFunction("onLegendClick", new JavaScriptFunction() {

			private static final long serialVersionUID = 2949833327369862993L;

			@Override
			public void call(JsonArray arguments) {
                int datasetIndex = (int) arguments.getNumber(0);
                boolean visible = arguments.getBoolean(1);
                JsonArray visblesJson = arguments.getArray(2); 
                int[] visibles = new int[visblesJson.length()];
                for (int i = 0 ; i < visblesJson.length(); i++) 
                	visibles[i] = (int)visblesJson.getNumber(i);

                for (LegendClickListener l : legendClickListeners) {
                    l.onLegendClick(datasetIndex, visible, visibles);
                }				
			}
        	
        });

//        addFunction("sendImageDataUrl",  new JavaScriptFunction() {
//            private static final long serialVersionUID = -6280339244713509848L;
//
//            @Override
//            public void call(JsonArray arguments) {
//                String dataUrl = arguments.getString(0);
//                String encodingPrefix = "base64,";
//                int contentStartIndex = dataUrl.indexOf(encodingPrefix) + encodingPrefix.length();
//                byte[] imageData = Base64.getDecoder().decode(dataUrl.substring(contentStartIndex));
//                for (DownloadListener l : downloadListeners) {
//                    l.onDownload(imageData);
//                }
//            }
//        });
    }

//    public void download() {
//        download(ImageType.PNG);
//    }
//
//    public void download(ImageType imageType) {
//        download(ImageType.PNG, null);
//    }
//
//    public void download(ImageType imageType, Double imageQuality) {
//        if (imageType == null) {
//            imageType = ImageType.PNG;
//        }
//        // assert that a download listener is added
//        if (this.downloadListeners == null || this.downloadListeners.isEmpty()) {
//            throw new IllegalArgumentException("No download listener found! Make sure use addDownloadListener before calling download");
//        }
//        callFunction("getImageDataUrl", imageType.toString().toLowerCase(), imageQuality);
//    }

    @Override
    protected ChartJsState getState() {
        return (ChartJsState) super.getState();
    }
}
