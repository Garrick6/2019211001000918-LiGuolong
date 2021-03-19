package com.LiGuolong.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从请求中获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");

        //print - 写入响应
        PrintWriter writer = response.getWriter();
        writer.println("username :" +username);
        writer.println("password :" +password);
        writer.println("email :" +email);
        writer.println("gender :" +gender);
        writer.println("birth Date :" +birthDate);
        writer.close();
    }
}
