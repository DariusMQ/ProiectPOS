package com.pos.proiectpos;

import com.pos.proiectpos.common.ProductDto;
import com.pos.proiectpos.ejb.ProductBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EditProduct", value = "/EditProduct")
public class EditProduct extends HttpServlet {

    @Inject
    ProductBean productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId = Long.parseLong(request.getParameter("id"));
        ProductDto product = productBean.findById(productId);
        request.setAttribute("product",product);

        request.getRequestDispatcher("WEB-INF/pages/editproduct.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("product_name");
        Long stock = Long.parseLong(request.getParameter("stock"));
        Long id = Long.parseLong(request.getParameter("product_id"));
        Float price = Float.parseFloat(request.getParameter("price"));

        productBean.updateProduct(id,productName,stock,price);

        response.sendRedirect(request.getContextPath()+"/Products");
    }
}