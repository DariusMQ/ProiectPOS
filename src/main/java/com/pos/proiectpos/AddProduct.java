package com.pos.proiectpos;

import com.pos.proiectpos.ejb.ProductBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddProduct", value = "/AddProduct")
public class AddProduct extends HttpServlet {
    @Inject
    ProductBean productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/addproduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("product_name");
        Float price = Float.parseFloat(request.getParameter("price"));
        Long stock = Long.parseLong(request.getParameter("stock"));

        productBean.createProduct(productName,price,stock);

        response.sendRedirect(request.getContextPath()+"/Products");
    }
}