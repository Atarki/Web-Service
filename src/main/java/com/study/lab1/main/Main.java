package com.study.lab1.main;

import com.study.lab1.servlets.ErrorRequestServlet;
import com.study.lab1.servlets.InfoRequestsServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        InfoRequestsServlet infoRequestsServlet = new InfoRequestsServlet();
        ErrorRequestServlet errorRequestServlet = new ErrorRequestServlet();

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(infoRequestsServlet), "/home");
        context.addServlet(new ServletHolder(errorRequestServlet), "/error");

        Server server = new Server(8080);
        server.setHandler(context);
        server.start();
    }
}
