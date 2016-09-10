package com.byteowls.vaadin.chartjs.demo.ui;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.byteowls.vaadin.chartjs.demo.ui.charts.AngledPieChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.BarLineComboChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.CubicInterpolationLineChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.GaugeDonutChartView;
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
import com.vaadin.data.Item;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
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
    
    private static final String CAPTION_PROPERTY = "caption";
    private static final String ICON_PROPERTY = "icon";

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
        menuItems.add(new MenuItem(ChartType.PIE, "Angled pie", AngledPieChartView.class));
        menuItems.add(new MenuItem(ChartType.PIE, "Gauge donut", GaugeDonutChartView.class));
        menuItems.add(new MenuItem(ChartType.AREA, "Bubble", SimpleBubbleChartView.class));
        menuItems.add(new MenuItem(ChartType.AREA, "Polar", PolarChartView.class));
        menuItems.add(new MenuItem(ChartType.AREA, "Radar", SimpleRadarChartView.class));
        menuItems.add(new MenuItem(ChartType.AREA, "Radar skipped point", SkipDataRadarChartView.class));
    }

    @Autowired
    private SpringViewProvider viewProvider;
    @Autowired
    private Environment env;

    private Label codeLabel;

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
                + "| Created by: <strong>Michael Oberwasserlechner</strong> "
                + "| <a href=\"https://github.com/moberwasserlechner/vaadin-chartjs\">Checkout on Github</a>");
        info.setContentMode(ContentMode.HTML);
        
        CssLayout infoBar = new CssLayout(info);
        infoBar.setWidth(100, Unit.PERCENTAGE);
        infoBar.addStyleName("cjs-info-bar");
        vl.addComponent(infoBar);

        HorizontalSplitPanel splitContentCode = new HorizontalSplitPanel();
        splitContentCode.setSizeFull();
        splitContentCode.setFirstComponent(content);
        splitContentCode.setSecondComponent(buildCode());
        splitContentCode.setSplitPosition(50);

        HorizontalSplitPanel splitMenuContent = new HorizontalSplitPanel();
        splitMenuContent.setSizeFull();
        splitMenuContent.setFirstComponent(buildMenuTree());
        splitMenuContent.setSecondComponent(splitContentCode);
        splitMenuContent.setSplitPosition(15);
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
    
    private Component buildCode() {
        codeLabel = new Label();
        codeLabel.setContentMode(ContentMode.HTML);
//        codeLabel.setSizeFull();
        
        Panel codePanel = new Panel(codeLabel);
        codePanel.setSizeFull();
        codePanel.addStyleName(ValoTheme.PANEL_BORDERLESS);
        codePanel.addStyleName("cjs-code");
        return codePanel;
    }

    @SuppressWarnings("unchecked")
    private Component buildMenuTree() {
        Panel treePanel = new Panel();
        treePanel.setSizeFull();
        treePanel.addStyleName(ValoTheme.PANEL_BORDERLESS);
        treePanel.addStyleName("cjs-menu");
        
        Tree tree = new Tree();
        tree.setSelectable(true);

        HierarchicalContainer treeContainer = new HierarchicalContainer();
        treeContainer.addContainerProperty(CAPTION_PROPERTY, String.class, null); // label
        treeContainer.addContainerProperty(ICON_PROPERTY, Resource.class, null); // icon

        tree.setContainerDataSource(treeContainer);
        tree.setItemCaptionPropertyId(CAPTION_PROPERTY);
        tree.setItemIconPropertyId(ICON_PROPERTY);

        for (ChartType chartType : ChartType.values()) {
            List<MenuItem> children = new ArrayList<>();
            for (MenuItem i : menuItems) {
                if (i.getType() == chartType) {
                    children.add(i);
                }
            }

            Item item = treeContainer.addItem(chartType);
            item.getItemProperty(CAPTION_PROPERTY).setValue(chartType.toString() + " Charts");
            item.getItemProperty(ICON_PROPERTY).setValue(chartType.getIcon());
            treeContainer.setChildrenAllowed(chartType, !children.isEmpty());

            for (MenuItem i : children) {
                Item childItem = treeContainer.addItem(i);
                childItem.getItemProperty(CAPTION_PROPERTY).setValue(i.getLabel());
                //childItem.getItemProperty(ICON_PROPERTY).setValue(null);
                treeContainer.setParent(i, chartType);
                treeContainer.setChildrenAllowed(i, false);
            }
        }

        // Expand whole tree
        for (final Object id : tree.rootItemIds()) {
            tree.expandItem(id);
        }

        tree.addItemClickListener(e -> {
            Object itemId = e.getItemId();
            if (itemId instanceof MenuItem) {
                MenuItem menuItem = (MenuItem) itemId;
                if (menuItem.getViewName() != null) {
                    getUI().getNavigator().navigateTo(menuItem.getViewName());
                }

            }
        });
        treePanel.setContent(tree);
        return treePanel;
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
