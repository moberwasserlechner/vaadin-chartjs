package com.byteowls.vaadin.chartjs.demo.ui;

import org.springframework.util.ClassUtils;

import com.vaadin.spring.internal.Conventions;

public class MenuItem {
    
    private ChartType type;
    private String label;
    private String viewName;
    
    public MenuItem(ChartType type, String label, Class<? extends ChartView> clazz) {
        super();
        this.type = type;
        this.label = label;
        Class<?> realBeanClass = ClassUtils.getUserClass(clazz);
        String viewName = realBeanClass.getSimpleName().replaceFirst("View$", "");
        this.viewName = Conventions.upperCamelToLowerHyphen(viewName);
    }

    public String getLabel() {
        return label;
    }

    public ChartType getType() {
        return type;
    }

    public void setType(ChartType type) {
        this.type = type;
    }

    public void setLabel(String label) {
        this.label = label;
    }


    public String getViewName() {
        return viewName;
    }


    public void setViewName(String viewName) {
        this.viewName = viewName;
    }


    @Override
    public String toString() {
        return "MenuItem [type=" + type + ", label=" + label + ", viewName=" + viewName + "]";
    }

}
