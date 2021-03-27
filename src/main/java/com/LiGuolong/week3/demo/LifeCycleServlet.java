package com.LiGuolong.week3.demo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LifeCycleServlet extends HttpServlet {
    //类加载
    //Class cl = Class.forName("地址")

    //1.tomcat读取wen.xml文件并查找servLet类
    //2.加载servLet——什么时候?2. 对这个servLet的第一次请求进入到客户端的时候
    //3.调用默认构造函数-代码
    //无参构造--实例化  Object obj = cl.newInstance();
    public LifeCycleServlet(){
        System.out.println("i am in constructor --> LifeCycleServlet()");
    }
    //4.init()-代码
    //init()--初始化
    public  void init(){
        System.out.println("i am in init()");
    }
    //5.tomcat call service()——> call doGet() or doPost()
    @Override
    //doGet()--服务请求
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("i am in service() --> doGet()");
    }//第二次请求的时候

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    //destroy()--销毁操作
    @Override
    public void destroy(){
        System.out.println("i am in destroy()");//停止Tomcat的时候
    }
}
