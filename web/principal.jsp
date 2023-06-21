<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="includes/header.jsp"></jsp:include>
    </head>
    
    <body>
        <jsp:include page="includes/nav.jsp"></jsp:include>
        <h1 class="container py-5 h-100 text-center">Bienvenido(a) ${usuario.getNombre()}</h1>
    </body>
</html>
