package com.byteowls.vaadin.chartjs.demo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = "/*", asyncSupported = true)
@VaadinServletConfiguration(ui = ChartJsDemoUI.class, productionMode = false)
public class ChartJsDemoServlet extends VaadinServlet {

    private static final long serialVersionUID = -3106247387634993220L;

}
