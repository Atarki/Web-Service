package com.study.lab1.servlets;

import com.study.lab1.templater.PageGenerator;
import freemarker.template.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet(value = "info")
public class InfoRequestsServlet extends HttpServlet {

    private static ArrayList citiesID;
    private static Configuration config = new Configuration();;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        citiesID = getItemList();

        Map<String, Object> data = data(request);
        data.put("cities", citiesID);
        data.put("login", "");
        data.put("password", "");
        data.put("message", "");
        data.put("method", request.getMethod());
        data.put("URL", request.getRequestURL().toString());
        data.put("pathInfo", "");
        data.put("sessionId", request.getSession().getId());
        data.put("parameters", request.getParameterMap().toString());

        response.getWriter().println(PageGenerator.instance().getPage("cityData.html", data));

        StringWriter out = new StringWriter();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
       /* String infoMessage = req.getParameter("infoMessage");
        Map<String, Object> pageVariables = data(req);
        pageVariables.put("infoMessage", infoMessage == null ? "" : infoMessage);
        resp.getWriter().println(PageGenerator.instance().getPage("cityData.html", pageVariables));*/

    }

    private static Map<String, Object> data(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("login", request.getParameter("login"));
        pageVariables.put("password", request.getParameter("password"));
        return pageVariables;
    }

    private static ArrayList getItemList() throws IOException {
        citiesID = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/city_list.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            citiesID.add(line);
            System.out.println("city: " + line);
        }
        bufferedReader.close();
        return citiesID;
    }

}
