package com.LiGuolong.week3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        String BirthDate = request.getParameter("birthDate");

        try {
            String insertDb = "insert into userdb.dbo.usertable(username,password,email,gender,birthDate) " +
                    "values(?,?,?,?,?)";
            pstmt = con.prepareStatement(insertDb);
            pstmt.setString(1,Username);
            pstmt.setString(2,Password);
            pstmt.setString(3,Email);
            pstmt.setString(4,Gender);
            pstmt.setString(5,BirthDate);
            pstmt.executeUpdate();


            //使用请求属性
            //设置rs为请求属性
//            request.setAttribute("rsName",rs);//name -字符串，value -任何类型(对象)
//            request.getRequestDispatcher("userList.jsp").forward(request,response);//此时，请求已经给了userList
//            System.out.println("我在RegisterServlet——>doPost()——>再forward()");
            response.sendRedirect("login.jsp");//跳转登录界面.
        } catch (Exception e) {
            System.out.println(e);
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