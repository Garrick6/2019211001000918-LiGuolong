package com.LiGuolong.controller;

import com.LiGuolong.dao.ProductDao;
import com.LiGuolong.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/getImg")
public class GetImgServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id =0;
        if (request.getParameter("id")!=null)
            id=Integer.parseInt(request.getParameter("id"));
        ProductDao productDao=new ProductDao();
        byte[] imgByte =new byte[0];
        try {
            imgByte =productDao.getPictureById(id,con);
            if (imgByte!=null){
                response.setContentType("image/gif");
                OutputStream out =response.getOutputStream();
                out.write(imgByte);
                out.flush();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
