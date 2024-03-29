<%@ taglib prefix="p" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">

            <a class="navbar-brand" href="${pageContext.request.contextPath}">POS</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>


            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav me-auto mb-2 mb-md-0">


                    <li class="nav-item">
                            <a class="nav-link
                        ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf
("/")) eq '/products.jsp' ? ' active' : ''}" aria-current="page" href="${pageContext.request.contextPath}/Products">
                                Products</a>
                    </li>


<p:if test="${pageContext.request.isUserInRole('READ_USERS')}">
                    <li class="nav-item">
                        <a class="nav-link
                        ${pageContext.request.requestURI.substring(pageContext.request.requestURI.lastIndexOf
("/")) eq '/users.jsp' ? ' active' : ''}" aria-current="page" href="${pageContext.request.contextPath}/Users">
                            Users</a>

                    </li>
</p:if>

                </ul>

                <ul class="navbar-nav">
                    <li class="nav-item">
                        <p:choose>
                            <p:when test="${pageContext.request.getRemoteUser() == null}">
                                <a class="nav-link" href="${pageContext.request.contextPath}/Login">Login</a>
                            </p:when>
                            <p:otherwise>
                                <a class="nav-link" href="${pageContext.request.contextPath}/Logout">Logout</a>
                            </p:otherwise>
                        </p:choose>
                    </li>
                </ul>

            </div>
        </div>
    </nav>
</header>

<footer>
    <p style="text-align:center;">&copy; 2023 Ciutac Darius & Denis Baila</p>
</footer>