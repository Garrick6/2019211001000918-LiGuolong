package com.LiGuolong.week6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//告诉tomcat这个类是侦听器类.
@WebListener
public class JDBCServeletContextListenter implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //这个web应用程序的main()方法
        //当tomcat启动时调用
        ServletContext context=sce.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");


        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("我在contextInitialized()中");
            System.out.println("连接数据库成功"+con);//成功
            context.setAttribute("con",con);

            //设置connection为上下文属性——用于所有的jsp和servLet
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // web应用程序的端点
        //这个方法在tomcat停止时被调用
        System.out.println("我在contextDestroyed()中");
        sce.getServletContext().removeAttribute("con");

    }
}
