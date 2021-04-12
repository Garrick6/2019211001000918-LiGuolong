package com.LiGuolong.week5;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/log")
public class LoginServlet extends HttpServlet {

    Connection con = null;
    PreparedStatement pstmt = null;


    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
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
            String selectDb = "select * from userdb.dbo.usertable where username= ? and password= ? ";
            pstmt = con.prepareStatement(selectDb);
            pstmt.setString(1,Username);
            pstmt.setString(2,Password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                //Week5 code
//                    writer.println("Login Success!!!");
//                    writer.println("Welcome" + Username);
                request.setAttribute("id", rs.getInt("id"));
                request.setAttribute("username", rs.getString("username"));
                request.setAttribute("password", rs.getString("password"));
                request.setAttribute("gender", rs.getString("gender"));
                request.setAttribute("email", rs.getString("email"));
                request.setAttribute("birthdate", rs.getString("birthdate"));

                request.getRequestDispatcher("userInfo.jsp").forward(request, response);


            } else {
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request, response);
//                    writer.println("Username or Password Error!!!");
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    @Override
    public void destroy() {

        try {
            if (pstmt != null){
            pstmt.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    }
