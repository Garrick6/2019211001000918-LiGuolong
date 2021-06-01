package com.LiGuolong.controller;


import com.LiGuolong.dao.ProductDao;
import com.LiGuolong.model.Category;
import com.LiGuolong.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductDetailsServlet", value = "/productDetails")
public class ProductDetailsServlet extends HttpServlet {
    public Connection con;

    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categoryList = Category.findAllCategory(con);
        request.setAttribute("categoryList", categoryList);
        try {
            //get product by id
            if (request.getParameter("id") != null) {
                int productId = Integer.parseInt(request.getParameter("id"));
                ProductDao productDao = new ProductDao();

                Product product = productDao.findById(productId, con);
                request.setAttribute("p", product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //forward
        request.getRequestDispatcher("/WEB-INF/views/productDetails.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}