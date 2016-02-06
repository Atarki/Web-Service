package com.study.lab1.servlets;

import com.study.lab1.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//@WebServlet(value = "home",urlPatterns = "Web Study pattern")
public class HomeRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("GET response");

        Map<String, Object> pageVariables = createPageVariablesMap(req);
        pageVariables.put("infoMessage", "");

        resp.getWriter().print("This is a home page.");

//        resp.getWriter().println(PageGenerator.instance().getPage("info.html", pageVariables));

        resp.setContentType("text/html;charset=utf-8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        String infoMessage = req.getParameter("infoMessage");
        Map<String, Object> pageVariables = createPageVariablesMap(req);
        pageVariables.put("infoMessage", infoMessage == null ? "" : infoMessage);
        resp.getWriter().println(PageGenerator.instance().getPage("info.html", pageVariables));
    }

    private static Map<String, Object> createPageVariablesMap(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("method", request.getMethod());
        pageVariables.put("URL", request.getRequestURL().toString());
        pageVariables.put("pathInfo", request.getPathInfo());
        pageVariables.put("sessionId", request.getSession().getId());
        pageVariables.put("parameters", request.getParameterMap().toString());
        return pageVariables;
    }

}
