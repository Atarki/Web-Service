package com.study.lab1.servlets;

import com.study.lab1.main.PathFileReader;
import com.study.lab1.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "info")
public class InfoRequestsServlet extends HttpServlet {
    private Map<String, Object> data;
    String string = "src/city_list.txt";
    String string2 = "D:\\_JAVA_PROJ\\_JAVA_TUTS_FROM_TOLIK_WEB\\src\\city_list.txt";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        data = data(request);
        data.put("cities", new ArrayList<>());

        response.getWriter().println(PageGenerator.instance().getPage("cityData.html", data));
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList citiesID = PathFileReader.getItemList(request.getParameter("path"));
//        ArrayList citiesID = PathFileReader.getItemList(string2);
        data = data(request);
        data.put("cities", citiesID);
        if (citiesID.isEmpty()) {
            response.getWriter().println(PageGenerator.instance().getPage("error.html", data));
        } else {
            response.getWriter().println(PageGenerator.instance().getPage("cityData.html", data));
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    private static Map<String, Object> data(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("login", request.getParameter("login"));
        pageVariables.put("password", request.getParameter("password"));
        return pageVariables;
    }


}
