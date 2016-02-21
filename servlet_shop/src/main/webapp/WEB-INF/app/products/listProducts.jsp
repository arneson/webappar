<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="btn-group btn-group-sm">
    <a class="btn btn-default" href="${pageContext.request.contextPath}/products/add">New</a>
</nav>
<section id="pageSection">
    <h1>This is products</h1>
    <div class="btn-group-sm">
        <c:choose>
            <c:when test="${CURRENT_PAGE gt 0}">
                <a href="${pageContext.request.contextPath}/products/list/${CURRENT_PAGE-1}" class="btn">Prev</a>
            </c:when>
            <c:otherwise>
                <a href="" disabled class="btn">Prev</a> 
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${CURRENT_PAGE lt COUNT / PAGE_SIZE - 1}">
                <a href="${pageContext.request.contextPath}/products/list/${CURRENT_PAGE+1}" class="btn">Next</a>
            </c:when>
            <c:otherwise>
                <a href="" disabled class="btn">Next</a> 
            </c:otherwise> 
        </c:choose>
    </div>
    <table class="table table-striped">
        <thead>
            <tr>
                <td>Id</td>
                <td>Name</td>
                <td>Price</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${PRODUCT_LIST}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td><a href="${pageContext.request.contextPath}/products/edit/${product.id}" class="btn">Edit</a></td>
                    <td><a href="${pageContext.request.contextPath}/products/del/${product.id}" class="btn">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>

