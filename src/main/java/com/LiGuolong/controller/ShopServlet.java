package com.LiGuolong.controller;

import com.LiGuolong.dao.ProductDao;
import com.LiGuolong.model.Category;
import com.LiGuolong.model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ShopServlet", value = "/shop")
public class ShopServlet extends HttpServlet {
    Connection con=null;

    @Override
    public void init() throws ServletException {
        con=(Connection)getServletContext().getAttribute("con");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Category> categoryList= Category.findAllCategory(con);
            request.setAttribute("categoryList",categoryList);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        ProductDao productDao = new ProductDao();
        try {
            if (request.getParameter("categoryId")==null){
                List<Product> productsList=productDao.findAll(con);
                request.setAttribute("productsList",productsList);
            }else {
                int catId=Integer.parseInt(request.getParameter("categoryId"));
                List<Product> productsList=productDao.findByCategoryId(catId,con);
                request.setAttribute("productList",productsList);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String path="../WEB-INF/views/shop.jsp";
        request.getRequestDispatcher(path).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
