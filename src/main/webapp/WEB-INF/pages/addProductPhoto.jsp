<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pageTemplate pageTitle="AddProductPhoto">

    <h1>Add Product Photo</h1>

    <form class="needs-validation" novalidate method="POST" enctype="multipart/form-data"
          action="${pageContext.request.contextPath}/AddProductPhoto">

        <div class="row">
            <div class="col-md-6 nb-3">
                License plate: ${product.product_name}
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 nb-3">
                <label for="file">Photo</label>
                <input type="file" name="file" id="file" required>
                <div class="invalid-feedback">
                    Photo is required
                </div>
            </div>
        </div>

        <input type="hidden" name="Product_id" value="${product.id}"/>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button>
    </form>

</t:pageTemplate>