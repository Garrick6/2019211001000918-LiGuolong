package com.LiGuolong.controller;

import com.LiGuolong.dao.UserDao;
import com.LiGuolong.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {


    Connection con=null;

    public void init() throws ServletException{
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        String Email = request.getParameter("email");
        String Gender = request.getParameter("gender");
        Date BirthDate = Date.valueOf(request.getParameter("birthDate"));
        UserDao userDao=new UserDao();
        User user =new User(id,Username,Password,Email,Gender,BirthDate);
        try {
            int flag = userDao.updateUser(con,user);
            if (flag!=0) {
                response.sendRedirect("WEB-INF/views/userInfo.jsp");
            } else {
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
