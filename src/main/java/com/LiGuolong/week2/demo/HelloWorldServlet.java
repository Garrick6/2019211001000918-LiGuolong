package com.LiGuolong.week2.demo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        ////当客户端请求方法在doGet()中为GET-here时，我们想向客户端发送HelLo
        // 我们需要在响应中写入Hello
        // get writer - java .io
        PrintWriter writer = response.getWriter();
        writer.println("Hello Client!!!");
        //下面我们需要向tomcat说明这个servlet --web.xml
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
