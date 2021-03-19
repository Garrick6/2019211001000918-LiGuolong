package com.LiGuolong.week2.demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet(name = "helloServlet",value = "/hello-servlet")
public class HelloWorldServlet extends HttpServlet {

    Date data=new Date();

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ////当客户端请求方法在doGet()中为GET-here时，我们想向客户端发送HelLo
        // 我们需要在响应中写入Hello
        // get writer - java .io
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("Name :LiGuolong</br>");
        out.println("ID :2019211001000918</br>");
        out.println("Date and Time"+data.toString());

        //下面我们需要向tomcat说明这个servlet --web.xml
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
