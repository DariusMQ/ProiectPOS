package com.pos.proiectpos.servlets;

import com.pos.proiectpos.common.ProductDto;
import com.pos.proiectpos.ejb.ProductBean;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddProductPhoto", value = "/AddProductPhoto")
public class AddProductPhoto extends HttpServlet {
    @Inject
    ProductBean productBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long carId = Long.parseLong(request.getParameter("id"));
        ProductDto product = productBean.findById(carId);
        request.setAttribute("product",product);
        request.getRequestDispatcher("WEB-INF/pages/addProductPhoto.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long productId = Long.parseLong(request.getParameter("Product_id"));

        Part filePart=request.getPart("file");
        String fileName=filePart.getSubmittedFileName();
        String fileType=filePart.getContentType();
        long fileSize=filePart.getSize();
        byte[] fileContent = new byte[(int)fileSize];
        filePart.getInputStream().read(fileContent);

        productBean.addPhotoToProduct(productId,fileName,fileType,fileContent);
        response.sendRedirect(request.getContextPath()+"/Products");
    }
}