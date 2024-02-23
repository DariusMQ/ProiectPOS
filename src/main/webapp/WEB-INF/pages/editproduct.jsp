<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:pageTemplate pageTitle="Edit Products">
  <h1>Edit Products</h1>

  <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/EditProduct">

    <div class="row">
      <div class="col-md-6 nb-3">
        <label for="product_name">Product Name</label>
        <input type="text" class="form-control" id="product_name" name="product_name"
               placeholder="" value="${product.product_name}" required>
        <div class="invalid-feedback">
          Product Name required.
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-md-6 nb-3">
        <label for="stock">Stock</label>
        <input type="number" class="form-control" id="stock" name="stock"
               placeholder="" value="${product.stock}" min="1" required>
        <div class="invalid-feedback">
          Stock required.
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-md-6 nb-3">
        <label for="price">Price</label>
        <input type="number" class="form-control" id="price" name="price"
               placeholder="" value="${product.price}" min="0"
               step="0.01" required>
        <div class="invalid-feedback">
          Price required.
        </div>
      </div>
    </div>

    <div class="row">
      <div class="col-md-6 nb-3">
        <input type="submit" class="btn btn-primary btn-lg" id="save" value="Save">
      </div>
    </div>

    <input type="hidden" name="product_id" value="${product.id}" />
  </form>
</t:pageTemplate>
