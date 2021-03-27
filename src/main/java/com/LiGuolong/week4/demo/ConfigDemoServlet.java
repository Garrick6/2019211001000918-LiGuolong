package com.LiGuolong.week4.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        ServletConfig config=getServletConfig();
        String name=config.getInitParameter("name");
        String studentId=config.getInitParameter("studentId");
        out.println("<html><body>");
        out.println("name : " + name +"</br>");
        out.println("studentId : " + studentId + "</br>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
