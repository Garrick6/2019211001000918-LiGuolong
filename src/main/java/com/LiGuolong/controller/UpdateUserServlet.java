package com.LiGuolong.controller;

import com.LiGuolong.dao.UserDao;
import com.LiGuolong.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    private Connection con;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("id");
//        String username = request.getParameter("Username");
//        String password = request.getParameter("password");
//        String email = request.getParameter("Email");
//        String gender = request.getParameter("sex");
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date birth = null;
//        try {
//            System.out.println(request.getParameter("BirthDate").trim());
//
//            birth = simpleDateFormat.parse(request.getParameter("BirthDate").trim());
//        } catch (ParseException e) {
//            System.out.println(e);
//        }
//        String id = request.getParameter("id");
//        User u = new User(Integer.valueOf(id), username, password, email, gender, birth);
//        UserDao userDao = new UserDao();
//            try {
//                userDao.updateUser((Connection) getServletContext().getAttribute("con"), u);
//            } catch (SQLException e) {
//                System.out.println(e);
//            }
//            System.out.println(birth);
//            request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request, response);


        int id = Integer.parseInt(request.getParameter("id"));
        String Username = request.getParameter("Username");
        String Password = request.getParameter("password");
        String Email = request.getParameter("Email");
        String Gender = request.getParameter("sex");

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date BirthDate = sdf.parse(request.getParameter("BirthDate"));

            User user = new User();
            user.setId(id);
            user.setUsername(Username);
            user.setPassword(Password);
            user.setEmail(Email);
            user.setGender(Gender);
            user.setBirthDate(BirthDate);

            UserDao userDao = new UserDao();
            Connection con = (Connection) getServletContext().getAttribute("con");
            try {
                if (userDao.updateUser(con, user) != 0) {
                    User u = userDao.findByUsernamePassword(con, Username, Password);
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(10);
                    session.setAttribute("user", u);
                    request.getRequestDispatcher("accountDetails").forward(request, response);
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}