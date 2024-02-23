<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>

<t:pageTemplate pageTitle="Users">
    <h1> Users </h1>

    <div class="container text-center">
        <p:forEach var="user" items="${users}">
            <div class="row">
                <div class="col">
                        ${user.id}
                </div>
                <div class="col">
                        ${user.username}
                </div>
                <div class="col">
                        ${user.email}
                </div>
            </div>
        </p:forEach>
    </div>

    <h5>Number of users: ${numberOfUsers}</h5>
</t:pageTemplate>