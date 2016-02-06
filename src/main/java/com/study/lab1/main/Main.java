package com.study.lab1.main;

import com.study.lab1.servlets.AllRequestsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        AllRequestsServlet allRequestsServlet = new AllRequestsServlet();
        AllRequestsServlet allRequestsServlet2 = new AllRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(allRequestsServlet), "/*");

        ServletContextHandler context2 = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context2.addServlet(new ServletHolder(allRequestsServlet2), "/home");


        Server server = new Server(8080);
        server.setHandler(context);
        server.setHandler(context2);


        server.start();
    }
}
