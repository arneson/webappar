<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--
        This is the overall layout for all pages
        Dynamic content inserted at ${param.partial}
        (= jsp segments)
-->
<!DOCTYPE html>
<html>
    <head> 
        <title>Servlet Shop</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <!-- 
            We use ${pageContext.request.contextPath} (vs / ) for root of
            URIs (easier to change application location)    
        -->
        <c:set var="res" value="${pageContext.request.contextPath}/resources" />
        <link rel="stylesheet" type="text/css" href="${res}/css/normalize.css" />
        <link rel="stylesheet" type="text/css" href="${res}/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="${res}/css/default.css" />
        <script  type="text/javascript" src="${res}/js/jquery-1.11.3.min.js"></script>
        <script type="text/javascript" src="${res}/js/check.js"></script>
        <link rel="icon" type="image/png" href="${res}/img/favicon.png">
    </head>
    <body class="container">
        <header>
            <hgroup>
                <h1>Fruitology</h1>
                <h2>We taste better</h2>
            </hgroup>
        </header>   
        <c:set var="root" value="${pageContext.request.contextPath}" />
        <nav class="navbar navbar-default" role="navigation">
            <a class="navbar-brand" href="${root}/home">Home</a>
            <a class="navbar-brand" href="${root}/products/list/0">Products</a>
            <a class="navbar-brand" href="${root}/customers">Customers</a>         
            <a class="navbar-brand" href="${root}/orders">Orders</a>
        </nav>   
        <!-- Insert the dynamic content -->
        <jsp:include page="${param.partial}.jsp" />
        <footer class="panel panel-default"> 
            <p>Contact: No way ...</p>
        </footer>
    </body>
</html>

