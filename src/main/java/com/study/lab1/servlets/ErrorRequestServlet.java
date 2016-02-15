package com.study.lab1.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ErrorRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        String errorData = (String) req.getParameter("path");
        String errorData2 = (String) req.getAttribute("errorData");
        System.out.println("error is " + errorData);
        System.out.println("error is " + errorData2);
//
        Map<String, Object> dataError = new HashMap<>();
        dataError.put("error", errorData);
//
//

        resp.getWriter().println("error is " + errorData);
//        resp.getWriter().println(PageGenerator.instance().getPage("error.html", dataError));
    }
}
