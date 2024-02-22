<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="POS">
    <h1> Products </h1>

    <div class="container text-center">
        <p:forEach var="prod" items="${products}">
            <div class="row">
                <div class="col">
                    ${prod.product_name}
                </div>
                <div class="col">
                        ${prod.stock}
                </div>
                <div class="col">
                        ${prod.price}
                </div>
            </div>
        </p:forEach>
    </div>

    <h5>Number of products: ${numberOfProducts}</h5>
</t:pageTemplate>