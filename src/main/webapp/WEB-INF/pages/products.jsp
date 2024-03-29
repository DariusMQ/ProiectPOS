<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="POS">
    <h1> Products </h1>

    <p:if test="${pageContext.request.isUserInRole('WRITE_CARS')}">
    <a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/AddProduct">Add Product</a>
    </p:if>

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
                <div class="col">
                    <img src="${pageContext.request.contextPath}/ProductPhoto?id=${prod.id}" width="48"/>
                </div>

                <p:if test="${pageContext.request.isUserInRole('WRITE_CARS')}">

                    <div class="col">
                        <a class="btn btn-secondary"
                           href="${pageContext.request.contextPath}/AddProductPhoto?id=${prod.id}" role="button">Add photo</a>
                    </div>

                <div class="col">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EditProduct?id=${prod.id}">Edit Product</a>
                </div>

                <div class="col">
                    <form method="POST" action="${pageContext.request.contextPath}/Products">
                        <button class="btn btn-danger" type="submit" name="deleteThis" value="${prod.id}"> Delete Product </button>
                    </form>
                </div>
                </p:if>

            </div>
        </p:forEach>
    </div>

    <h5>Number of products: ${numberOfProducts}</h5>
</t:pageTemplate>