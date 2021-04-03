package com.LiGuolong.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    Connection con=null;
    String driver;
    String url;
    String username;
    String password;

    @Override
    public void init() throws ServletException{
        ServletContext context=this.getServletContext();
        driver = context.getInitParameter("driver");
        url = context.getInitParameter("url");
        username = context.getInitParameter("username");
        password = context.getInitParameter("password");


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
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");

        PrintWriter writer = response.getWriter();
        try {
            Statement createDbStatement = con.createStatement();
            String selectDb = "select * from userdb.dbo.usertable where username='"+Username+"'and password='"+Password+"'";
            ResultSet rs = createDbStatement.executeQuery(selectDb);
                if (rs.next()) {
                    writer.println("Login Success!!!");
                    writer.println("Welcome" + Username);

                } else {
                    writer.println("Username or Password Error!!!");
                }

        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
