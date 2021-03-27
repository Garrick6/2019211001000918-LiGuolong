package com.LiGuolong.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

///使用@webservlet 代替web.xml中的代码
//@WebServlet(
//        urlPatterns = {"/jdbc"},
//        initParams = {
//                @WebInitParam(name = "driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
//                @WebInitParam(name = "url",value = "jdbc:sqlserver://localhost;databaseName=userdb"),
//                @WebInitParam(name = "username",value = "sa"),
//                @WebInitParam(name = "password",value = "605880327")
//        },loadOnStartup = 1
//)
public class JDBCDemoServlet extends HttpServlet {
    Connection con=null;//类变量
    @Override
    public void init() throws ServletException {
//        String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
//        String url="jdbc:sqlserver://localhost;databaseName=userdb";
//        String username="sa";
//        String password="605880327";
        //像这样的代码是糟糕的-->因为改变并不容易
        //例如:修改了数据库的密码-->你就还得修改java代码
        ServletConfig config=getServletConfig();
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");

        try {
            Class.forName(driver);
            con=DriverManager.getConnection(url,username,password);
            System.out.println("我在init()-->"+con);//成功
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // duGet中连接-多次连接-错误示范
        System.out.println("我在doGet");//成功
        //我们需要在doGet中进行连接
        String sql="select * from userdb.dbo.usertable";
        try {
            ResultSet rs = con.createStatement().executeQuery(sql);
            while (rs.next()){
                //获取结果并打印
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();//当tomcat停止时释放内存
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

