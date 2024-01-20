<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:pageTemplate pageTitle="POS">
    <h1> Products </h1>

    <div class="container text-center">
        <div class="row">
            <div class="col">
                Product 1
            </div>
            <div class="col">
                Price 1
            </div>
        </div>
        <div class="row">
            <div class="col">
                Product 2
            </div>
            <div class="col">
                Price 2
            </div>
        </div>
        <div class="row">
            <div class="col">
                Product 3
            </div>
            <div class="col">
                Price 3
            </div>
        </div>
    </div>
    <h5>Number of products: ${numberOfProducts}</h5>
</t:pageTemplate>