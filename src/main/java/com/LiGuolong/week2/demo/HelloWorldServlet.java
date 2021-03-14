package com.LiGuolong.week2.demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "helloServlet",value = "/hello-servlet")
public class HelloWorldServlet extends HttpServlet {
    private String message;
    Date day=new Date();
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public void init() {message = "Hello World!";}

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        response.setContentType("text/html");
        ////当客户端请求方法在doGet()中为GET-here时，我们想向客户端发送HelLo
        // 我们需要在响应中写入Hello
        // get writer - java .io
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("Name :LiGuolong");
        out.println("ID :2019211001000918");
        out.println(df.format(day));
        out.println("</body></html>");
        //下面我们需要向tomcat说明这个servlet --web.xml
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response){

    }
    public void destory(){

    }
}
