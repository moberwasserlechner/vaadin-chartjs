package com.byteowls.vaadin.chartjs.demo.ui;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.byteowls.vaadin.chartjs.demo.ui.charts.BarLineComboChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.HorizontalBarChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.MultiAxisBarChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.MultiDonutChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.PolarChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.ScatterLineChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.SimpleBubbleChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.SimpleLineChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.SimpleRadarChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.SkipDataRadarChartView;
import com.byteowls.vaadin.chartjs.demo.ui.charts.StackedLineChartView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.data.Item;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontIcon;
import com.vaadin.server.Page;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Tree;
import com.vaadin.ui.UI;
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
        menuItems.add(new MenuItem(ChartType.BAR, "Multi Axis", MultiAxisBarChartView.class));
        menuItems.add(new MenuItem(ChartType.BAR, "Horizontal", HorizontalBarChartView.class));
        menuItems.add(new MenuItem(ChartType.BAR, "Combo Bar/Line", BarLineComboChartView.class));
        menuItems.add(new MenuItem(ChartType.LINE, "Simple", SimpleLineChartView.class));
        menuItems.add(new MenuItem(ChartType.LINE, "Stacked", StackedLineChartView.class));
        menuItems.add(new MenuItem(ChartType.LINE, "Combo Bar/Line", BarLineComboChartView.class));
        menuItems.add(new MenuItem(ChartType.LINE, "Scatter", ScatterLineChartView.class));
//        menuItems.add(new MenuItem(ChartType.PIE, "Pie", MultiDonutChartView.class));
//        menuItems.add(new MenuItem(ChartType.PIE, "Donut", MultiDonutChartView.class));
        menuItems.add(new MenuItem(ChartType.PIE, "Multi dataset Donut", MultiDonutChartView.class));
        menuItems.add(new MenuItem(ChartType.BUBBLE, "Bubble", SimpleBubbleChartView.class));
        menuItems.add(new MenuItem(ChartType.POLAR, "Simple", PolarChartView.class));
        menuItems.add(new MenuItem(ChartType.RADAR, "Simple", SimpleRadarChartView.class));
        menuItems.add(new MenuItem(ChartType.RADAR, "Skip data point", SkipDataRadarChartView.class));
        
    }

    @Autowired
    private SpringViewProvider viewProvider;

    private Label codeLabel = new Label("", ContentMode.HTML);

    @SuppressWarnings("serial")
    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Vaadin ChartJs addon Demo");
        Responsive.makeResponsive(this);

        Panel content = buildContent();

        Navigator navigator = new Navigator(this, content);
        navigator.addProvider(viewProvider);
        navigator.setErrorProvider(viewProvider);

        HorizontalSplitPanel splitContentCode = new HorizontalSplitPanel();
        splitContentCode.setSizeFull();
        splitContentCode.setFirstComponent(content);
        splitContentCode.setSecondComponent(buildCode());
        splitContentCode.setSplitPosition(70);

        HorizontalSplitPanel splitMenuContent = new HorizontalSplitPanel();
        splitMenuContent.setSizeFull();
        splitMenuContent.setFirstComponent(buildMenu());
        splitMenuContent.setSecondComponent(splitContentCode);
        splitMenuContent.setSplitPosition(15);

        navigator.addViewChangeListener(new ViewChangeListener() {
            @Override
            public boolean beforeViewChange(ViewChangeEvent event) {
                ChartView view = (ChartView) event.getNewView();
                String formattedSourceCode = getFormattedSourceCode(view.getSource());
                codeLabel.setValue(formattedSourceCode);
//                if (formattedSourceCode == null) {
//                    splitContentCode.setSplitPosition(100);
//                } else {
//                    splitContentCode.setSplitPosition(60);
//                }
                return true;
            }

            @Override
            public void afterViewChange(ViewChangeEvent event) {

            }
        });
        setContent(splitMenuContent);

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

    @SuppressWarnings("unchecked")
    private Component buildMenu() {
        Panel treePanel = new Panel();
        treePanel.setSizeFull();
        treePanel.addStyleName(ValoTheme.PANEL_BORDERLESS);
        treePanel.addStyleName("cjs-menu");

        Tree tree = new Tree("Chart Types");
        tree.setSelectable(true);

        HierarchicalContainer treeContainer = new HierarchicalContainer();
        treeContainer.addContainerProperty(CAPTION_PROPERTY, String.class, null); // label
        treeContainer.addContainerProperty(ICON_PROPERTY, FontIcon.class, null); // icon

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
            item.getItemProperty(CAPTION_PROPERTY).setValue(chartType.toString());
            item.getItemProperty(ICON_PROPERTY).setValue(chartType.getIcon());
            treeContainer.setChildrenAllowed(chartType, !children.isEmpty());

            for (MenuItem i : children) {
                Item childItem = treeContainer.addItem(i);
                childItem.getItemProperty(CAPTION_PROPERTY).setValue(i.getLabel());
                childItem.getItemProperty(ICON_PROPERTY).setValue(null);
                treeContainer.setParent(i, chartType);
                //treeContainer.setChildrenAllowed(childItem, false);
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
                options.setShowLineNumbers(true);
                options.setAddLineAnchors(false);
                converter.convert(source, options, writer);
                return writer.toString();
            } catch (IllegalConfigurationException | IOException exception) {

            }
        }
        return sourceCode;
    }

}
