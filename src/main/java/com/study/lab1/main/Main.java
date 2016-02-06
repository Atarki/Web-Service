package com.study.lab1.main;

import com.study.lab1.servlets.AllRequestsServlet;
import com.study.lab1.servlets.HomeRequestServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();
        HomeRequestServlet homeRequestServlet = new HomeRequestServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(allRequestsServlet), "/home");
        context.addServlet(new ServletHolder(homeRequestServlet), "/info");

//        ServletContextHandler context2 = new ServletContextHandler(ServletContextHandler.SESSIONS);
//        context2.addServlet(new ServletHolder(allRequestsServlet), "/info");


        Server server = new Server(8080);
        server.setHandler(context);
//        server.setHandler(context2);


        server.start();
    }
}
