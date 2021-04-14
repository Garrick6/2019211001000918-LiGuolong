package com.LiGuolong.week3;

import com.LiGuolong.dao.UserDao;
import com.LiGuolong.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
    PreparedStatement pstmt = null;

    public void init() throws ServletException{
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String Username = request.getParameter("username");
        String Password = request.getParameter("password");
        String Email = request.getParameter("email");
        String Gender = request.getParameter("gender");
        Date BirthDate = Date.valueOf(request.getParameter("birthDate"));
        UserDao userDao=new UserDao();
        User user =new User(0,Username,Password,Email,Gender,BirthDate);
        try {
            int flag = userDao.saveUser(con,user);
            if (flag!=0) {
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("message", "Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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