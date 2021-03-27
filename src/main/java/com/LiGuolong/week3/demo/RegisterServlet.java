package com.LiGuolong.week3.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
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
        urlPatterns = {"/register"}
)

public class RegisterServlet extends HttpServlet {

    public Connection con;

    public void init() throws ServletException{
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("username");
        String password = getServletContext().getInitParameter("password");

        try{
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String Username = request.getParameter("Username");
        String Password = request.getParameter("Password");
        String Email = request.getParameter("Email");
        String Gender = request.getParameter("Gender");
        String BirthDate = request.getParameter("BirthDate");

        PrintWriter writer = response.getWriter();
        try {

            System.out.println("con:"+con);
            Statement createDbStatement = con.createStatement();
            String insertDb = "insert into userdb.dbo.usertable(Username,Password,Email,Gender,BirthDate) values('"+Username+"','"+Password+"','"+Email+"','"+Gender+"','"+BirthDate+"')";
            createDbStatement.executeUpdate(insertDb);
            String selectDb = "select * from userdb.dbo.usertable";
            ResultSet rs = createDbStatement.executeQuery(selectDb);
            while(rs.next()) {
                rs.getString("id");
                rs.getString("UserName");
                rs.getString("Password");
                rs.getString("Email");
                rs.getString("Gender");
                rs.getString("BirthDate");
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
                        "<td>" + id        + "</td>" +
                        "<td>" + Username  + "</td>" +
                        "<td>" + Password  + "</td>" +
                        "<td>" + Email     + "</td>" +
                        "<td>" + Gender    + "</td>" +
                        "<td>" + BirthDate + "</td>" +
                        "</tr>"    +
                        "</table>");
    }}