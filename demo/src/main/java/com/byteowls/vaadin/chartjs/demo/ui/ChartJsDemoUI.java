package com.byteowls.vaadin.chartjs.demo.ui;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.byteowls.vaadin.chartjs.demo.ui.charts.BarLineComboChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.CubicInterpolationLineChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.HorizontalBarChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.MultiAxisBarChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.MultiDonutChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.PointSizeLineChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.PolarChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.ScatterLineChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.SimpleBubbleChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.SimpleLineChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.SimpleRadarChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.SinglePieChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.SkipDataRadarChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.SkipPointsLineChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.StackedBarChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.StackedLineChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.SteppedLineChartView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

import de.java2html.converter.JavaSource2HTMLConverter;
import de.java2html.javasource.JavaSource;
import de.java2html.javasource.JavaSourceParser;
import de.java2html.options.JavaSourceConversionOptions;
import de.java2html.util.IllegalConfigurationException;

@Theme("chartjs")
@SpringUI
@Widgetset("ChartJsWidgetset")
public class ChartJsDemoUI extends UI {

    private static final long serialVersionUID = -33887281222947647L;

    private static List<MenuItem> menuItems;
    static {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(ChartType.BAR, "Vertical", MultiAxisBarChartView.class));
        menuItems.add(new MenuItem(ChartType.BAR, "Horizontal", HorizontalBarChartView.class));
        menuItems.add(new MenuItem(ChartType.BAR, "Combo", BarLineComboChartView.class));
        menuItems.add(new MenuItem(ChartType.BAR, "Stacked", StackedBarChartView.class));
        menuItems.add(new MenuItem(ChartType.LINE, "Simple", SimpleLineChartView.class));
        menuItems.add(new MenuItem(ChartType.LINE, "Stacked", StackedLineChartView.class));
        menuItems.add(new MenuItem(ChartType.LINE, "Combo", BarLineComboChartView.class));
        menuItems.add(new MenuItem(ChartType.LINE, "PointSize", PointSizeLineChartView.class));
        menuItems.add(new MenuItem(ChartType.LINE, "Scatter", ScatterLineChartView.class));
        menuItems.add(new MenuItem(ChartType.LINE, "SkipPoints", SkipPointsLineChartView.class));
        menuItems.add(new MenuItem(ChartType.LINE, "Stepped", SteppedLineChartView.class));
        menuItems.add(new MenuItem(ChartType.LINE, "CubicInterpolation", CubicInterpolationLineChartView.class));
        menuItems.add(new MenuItem(ChartType.PIE, "Pie", SinglePieChartView.class));
        menuItems.add(new MenuItem(ChartType.PIE, "Donut", MultiDonutChartView.class));
        menuItems.add(new MenuItem(ChartType.BUBBLE, "Simple", SimpleBubbleChartView.class));
        menuItems.add(new MenuItem(ChartType.POLAR, "Simple", PolarChartView.class));
        menuItems.add(new MenuItem(ChartType.RADAR, "Simple", SimpleRadarChartView.class));
        menuItems.add(new MenuItem(ChartType.RADAR, "SkipPoints", SkipDataRadarChartView.class));
    }

    @Autowired
    private SpringViewProvider viewProvider;
    @Autowired
    private Environment env;

    private Label codeLabel = new Label("", ContentMode.HTML);

    @SuppressWarnings("serial")
    @Override
    protected void init(VaadinRequest request) {
        String title = "Vaadin ChartJs Addon";
        getPage().setTitle(title);
        Responsive.makeResponsive(this);

        Panel content = buildContent();

        Navigator navigator = new Navigator(this, content);
        navigator.addProvider(viewProvider);
        navigator.setErrorProvider(viewProvider);
        
        VerticalLayout vl = new VerticalLayout();
        vl.setSizeFull();
        
        Label info = new Label("<strong>" + title + "</strong> "
                + "| Version: <strong>" + env.getProperty("versions.vaadin-chartjs-addon") + "</strong> "
                + "| Chart.js: <strong>" + env.getProperty("versions.chartjs") + "</strong> "
                + "| Vaadin: <strong>" + env.getProperty("versions.vaadin") + "</strong> "
                //+ "| Created by: <strong>Michael Oberwasserlechner</strong> "
                + "| Fork on github: <strong>https://github.com/moberwasserlechner/vaadin-chartjs</strong>");
        info.setContentMode(ContentMode.HTML);
        
        CssLayout infoBar = new CssLayout(info);
        infoBar.setWidth(100, Unit.PERCENTAGE);
        infoBar.addStyleName("cjs-info-bar");
        vl.addComponent(infoBar);

        HorizontalSplitPanel splitContentCode = new HorizontalSplitPanel();
        splitContentCode.setSizeFull();
        splitContentCode.setFirstComponent(content);
        splitContentCode.setSecondComponent(buildCode());

        HorizontalSplitPanel splitMenuContent = new HorizontalSplitPanel();
        splitMenuContent.setSizeFull();
        splitMenuContent.setFirstComponent(buildMenu());
        splitMenuContent.setSecondComponent(splitContentCode);
        splitMenuContent.setSplitPosition(10);
        vl.addComponent(splitMenuContent);
        vl.setExpandRatio(splitMenuContent, 1);

        navigator.addViewChangeListener(new ViewChangeListener() {
            @Override
            public boolean beforeViewChange(ViewChangeEvent event) {
                ChartView view = (ChartView) event.getNewView();
                String formattedSourceCode = getFormattedSourceCode(view.getSource());
                codeLabel.setValue(formattedSourceCode);
                return true;
            }

            @Override
            public void afterViewChange(ViewChangeEvent event) {

            }
        });
        setContent(vl);

        String fragment = Page.getCurrent().getUriFragment();
        if (fragment == null || fragment.equals("")) {
            String viewName = menuItems.get(0).getViewName();
            navigator.navigateTo(viewName);
        }
    }

    private Panel buildContent() {
        Panel chartPanel = new Panel();
        chartPanel.setSizeFull();
        chartPanel.addStyleName(ValoTheme.PANEL_BORDERLESS);
        return chartPanel;
    }

    private Component buildMenu() {
        CssLayout rootMenu = new CssLayout();
        rootMenu.setSizeFull();
        rootMenu.setPrimaryStyleName(ValoTheme.MENU_ROOT);
        
        CssLayout menuContent = new CssLayout();
        menuContent.addStyleName(ValoTheme.MENU_PART);
        menuContent.addStyleName(ValoTheme.MENU_PART_LARGE_ICONS);
        menuContent.addStyleName("cjs-menu-part");
        menuContent.setSizeFull();

        for (ChartType chartType : ChartType.values()) {
            List<MenuItem> children = new ArrayList<>();
            for (MenuItem i : menuItems) {
                if (i.getType() == chartType) {
                    children.add(i);
                }
            }
            
            Button b = new Button(chartType.toString() + " Charts", FontAwesome.BAR_CHART_O);
            b.setPrimaryStyleName(ValoTheme.MENU_ITEM);
            b.addStyleName("cjs-menu-parent");
            b.setWidth(100, Unit.PERCENTAGE);
            
            b.addClickListener(e -> {
                if (!children.isEmpty()) {
                    getUI().getNavigator().navigateTo(children.get(0).getViewName());
                }
            });
            menuContent.addComponent(b);

            for (MenuItem i : children) {
                Button sub = new Button();
                sub.setCaption(i.getLabel());
                sub.setPrimaryStyleName(ValoTheme.MENU_ITEM);
                sub.addStyleName("cjs-menu-child");
                sub.setWidth(100, Unit.PERCENTAGE);
                sub.addClickListener(e -> {
                    getUI().getNavigator().navigateTo(i.getViewName());
                });
                menuContent.addComponent(sub);
            }
        }
        rootMenu.addComponent(menuContent);
        return rootMenu;
    }

    private Component buildCode() {
        Panel codePanel = new Panel(codeLabel);
        codePanel.setSizeFull();
        codePanel.addStyleName(ValoTheme.PANEL_BORDERLESS);
        codePanel.addStyleName("cjs-menu");
        return codePanel;
    }

    public String getFormattedSourceCode(String sourceCode) {
        if (sourceCode != null) {
            try {
                JavaSource source = new JavaSourceParser().parse(new StringReader(sourceCode));
                JavaSource2HTMLConverter converter = new JavaSource2HTMLConverter();
                StringWriter writer = new StringWriter();
                JavaSourceConversionOptions options = JavaSourceConversionOptions.getDefault();
                options.setShowLineNumbers(false);
                options.setAddLineAnchors(false);
                converter.convert(source, options, writer);
                return writer.toString();
            } catch (IllegalConfigurationException | IOException exception) {

            }
        }
        return sourceCode;
    }

}
