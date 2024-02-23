package com.pos.proiectpos.servlets;

import com.pos.proiectpos.common.ProductDto;
import com.pos.proiectpos.ejb.ProductBean;
import com.pos.proiectpos.entities.Product;
import jakarta.annotation.security.DeclareRoles;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@DeclareRoles({"WRITE_CARS"})
@ServletSecurity(
        httpMethodConstraints = {@HttpMethodConstraint(value = "POST", rolesAllowed =
                {"WRITE_CARS"})})
@WebServlet(name = "Products", value = "/Products")
public class Products extends HttpServlet {

    @Inject
    ProductBean productBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ProductDto> products = productBean.findAllProducts();
        request.setAttribute("products", products);
        request.setAttribute("numberOfProducts", products.size());
        request.getRequestDispatcher("/WEB-INF/pages/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("deleteThis"));

        productBean.deleteById(id);


        response.sendRedirect(request.getContextPath()+"/Products");
    }
}