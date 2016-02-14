package com.study.lab1.servlets;

import com.study.lab1.main.PathFileReader;
import com.study.lab1.templater.PageGenerator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InfoRequestsServlet extends HttpServlet  {

    private Map<String, Object> pageData = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        pageData.put("person", new ArrayList<>());

        response.getWriter().println(PageGenerator.instance().getPage("personData.html", pageData));
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Object> personList = PathFileReader.getItemList(request.getParameter("path"));
            pageData.put("person", personList);

            response.getWriter().println(PageGenerator.instance().getPage("personData.html", pageData));
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {

            e.printStackTrace();
            String s = e.getMessage();
            System.out.println(s);

            RequestDispatcher rd = request.getRequestDispatcher("error");
            request.setAttribute("errorData",e.getMessage());
            rd.include(request, response);
        }
    }
}
