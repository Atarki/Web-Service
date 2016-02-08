package com.study.lab1.servlets;

import com.study.lab1.templater.PageGenerator;
import j2html.tags.ContainerTag;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static j2html.TagCreator.*;

@WebServlet(value = "info")
public class InfoRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*HtmlCanvas html = new HtmlCanvas();
        html
                .html()
                .body()
                .h1().content("Hello Coder")
                .table().write("test")
                ._table()
                ._body()
                ._html();
        System.out.println(html.toHtml());*/

        System.out.println("test");
        Map<String, Object> data = data(request);
        data.put("message", "");

        ContainerTag html = html();
        html.with(
                head().with(
                        title("Title"),
                        link().withRel("stylesheet").withHref("/css/main.css")
                ),
                body().with(
                        main().with(
                                h1("Hello " + data.get("login")),
                                h1("Your password " + data.get("password"))
                        )
                )
        );

        if (data.get("login").equals("")) {
            response.getWriter().print("You are not filled the form");
        } else {
            // FIXME: 07.02.2016 
            response.getWriter().println(PageGenerator.instance().getPage("info.html", data));
//            response.getWriter().print(html);
        }

        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
       /* String infoMessage = req.getParameter("infoMessage");
        Map<String, Object> pageVariables = data(req);
        pageVariables.put("infoMessage", infoMessage == null ? "" : infoMessage);
        resp.getWriter().println(PageGenerator.instance().getPage("info.html", pageVariables));*/

    }

    private static Map<String, Object> data(HttpServletRequest request) {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("login", request.getParameter("login"));
        pageVariables.put("password", request.getParameter("password"));
        return pageVariables;
    }

}
