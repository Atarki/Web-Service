package com.study.lab1.main;

import com.study.lab1.servlets.HomeRequestsServlet;
import com.study.lab1.servlets.InfoRequestsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        HomeRequestsServlet homeRequestsServlet = new HomeRequestsServlet();
        InfoRequestsServlet infoRequestsServlet = new InfoRequestsServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(infoRequestsServlet), "/*");
//        context.addServlet(new ServletHolder(homeRequestsServlet), "/*");

        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
    }
}
