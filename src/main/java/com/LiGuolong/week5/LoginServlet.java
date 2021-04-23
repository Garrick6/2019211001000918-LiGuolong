package com.LiGuolong.week5;

import com.LiGuolong.dao.UserDao;
import com.LiGuolong.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    Connection con = null;
    PreparedStatement pstmt = null;


    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        UserDao userDao = new UserDao();
        try {
            User user = userDao.findByUsernamePassword(con, Username, Password);
            if (user != null) {
                String rememberMe=request.getParameter("rememberMe");
                if (rememberMe!=null && rememberMe.equals("1")){
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());

                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);

                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                }
                HttpSession session= request.getSession();
                System.out.println("session id:"+session.getId());
                session.setMaxInactiveInterval(10);
                session.setAttribute("user", user);
//                request.setAttribute("user", user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);
            } else {
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
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
