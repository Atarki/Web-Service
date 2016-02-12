package com.study.lab1.servlets;

import com.study.lab1.main.PathFileReader;
import com.study.lab1.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "info")
public class InfoRequestsServlet extends HttpServlet {
    /*String string = "src/city_list.txt";
    String string2 = "D:\\_JAVA_PROJ\\_JAVA_TUTS_FROM_TOLIK_WEB\\src\\city_list.txt";*/
    private Map<String, Object> data = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        data.put("cities", new ArrayList<>());

        response.getWriter().println(PageGenerator.instance().getPage("cityData.html", data));
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList citiesID = PathFileReader.getItemList(request.getParameter("path"));
            data.put("cities", citiesID);

            response.getWriter().println(PageGenerator.instance().getPage("cityData.html", data));
            response.setContentType("text/html;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
        } catch (FileNotFoundException e) {
            data.put("errors", e.getMessage());
            response.getWriter().println(PageGenerator.instance().getPage("error.html", data));
            System.out.println(e.toString());
        }
    }
}
