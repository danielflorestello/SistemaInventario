<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="includes/header.jsp"></jsp:include>
        <script>
            function cambiarPestana(event, pestanaId) {
              // Obtener todas las pestañas y contenidos
              var pestañas = document.getElementsByClassName("tab");
              var contenidos = document.getElementsByClassName("content");

                // Remover la clase "active" de todas las pestañas y contenidos
                for (var i = 0; i < pestañas.length; i++) {
                    pestañas[i].classList.remove("active");
                    contenidos[i].classList.remove("active");
                }

                // Agregar la clase "active" a la pestaña seleccionada y su contenido correspondiente
                event.target.classList.add("active");
                document.getElementById(pestanaId).classList.add("active");
            }
        </script>
  
    </head>
    
    <body>
        <div class="tabs">
        <c:forEach var="pestaña" items="${pestañas}" varStatus="status">
            <div class="tab ${status.index == 0 ? 'active' : ''}" onclick="cambiarPestana(event, 'contenido${status.index}')">${pestaña}</div>
        </c:forEach>
        </div>

        <c:forEach var="contenido" items="${contenidos}" varStatus="status">
            <div id="contenido${status.index}" class="content ${status.index == 0 ? 'active' : ''}">
                ${contenido}
            </div>
        </c:forEach>
    </body>
</html>
