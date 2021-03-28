package com.LiGuolong.week3.demo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

//        1. Comment <servlet> and <servlet-mapping> in web.xml
//        2.使用@WebServlet用于RegisterServlet(第3周)
//        3.使用<context-param>设置web.xml中的4个context参数
//        4.在RegisterServlet->init()中获取所有4个context init参数
//        5.在init()中创建数据库连接
//        6.向doPost()中的数据库表“usertable”中插入一行
//        7.从usertable中选择所有行
//        8打印所有行-使用html <table><tr><td>

@WebServlet(
        urlPatterns = {"/register"},
        loadOnStartup = 3
)

public class RegisterServlet extends HttpServlet {

    Connection con=null;
    String driver;
    String url;
    String username;
    String password;


    public void init() throws ServletException{
        ServletContext context=this.getServletContext();
        driver = context.getInitParameter("driver");
        url = context.getInitParameter("url");
        username = context.getInitParameter("username");
        password = context.getInitParameter("password");
        System.out.println("R:"+driver);
        System.out.println("R:"+url);
        System.out.println("R:"+username);
        System.out.println("R:"+password);


        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("我在init()-->"+con);//成功
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = null;
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        String Email = request.getParameter("email");
        String Gender = request.getParameter("gender");
        String BirthDate = request.getParameter("birthDate");

        System.out.println("Username:"+Username);
        System.out.println("Password:"+Password);
        System.out.println("Email:"+Email);
        System.out.println("Gender:"+Gender);
        System.out.println("BirthDate:"+BirthDate);

        PrintWriter writer = response.getWriter();
        try {
            Statement createDbStatement = con.createStatement();
            String insertDb = "insert into userdb.dbo.usertable(Username,Password,Email,Gender,BirthDate) values('"+Username+"','"+Password+"','"+Email+"','"+Gender+"','"+BirthDate+"')";
            createDbStatement.executeUpdate(insertDb);
            String selectDb = "select * from userdb.dbo.usertable";
            ResultSet rs = createDbStatement.executeQuery(selectDb);
            while(rs.next()) {
                id =rs.getString("id");
                Username = rs.getString("UserName");
                Password = rs.getString("Password");
                Email = rs.getString("Email");
                Gender = rs.getString("Gender");
                BirthDate = rs.getString("BirthDate");
            }
        } catch (Exception e) {
            System.out.println(e);
        }


        writer.println(
                "<table border=\"1\">"       +
                        "<tr>"                   +
                        "<td>id</td>"        +
                        "<td>UserName</td>"  +
                        "<td>Password</td>"  +
                        "<td>Email</td>"     +
                        "<td>Gender</td>"    +
                        "<td>BirthDate</td>" +
                        "</tr>"    +
                        "<tr>"     +
                        "<td>" + id       + "</td>" +
                        "<td>" + Username + "</td>" +
                        "<td>" + Password  + "</td>" +
                        "<td>" + Email     + "</td>" +
                        "<td>" + Gender    + "</td>" +
                        "<td>" + BirthDate + "</td>" +
                        "</tr>"    +
                        "</table>");
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