<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../includes/header.jsp"></jsp:include>
    </head>
    
    <body>
        <jsp:include page="../includes/nav.jsp"></jsp:include>
        
        <div class="row">
            <div class="col">
                <h3 class="container mt-3">COMPRA DE MERCADERÍAS</h3>
            </div>
            
            <div class="col">
                <div class="container mt-3" align="right">
                    <a href="compraControlador?accion=formularioCompra" class="btn btn-outline-success">
                        <span >Agregar</span>
                    </a>
                </div>
            </div>
        </div><hr>
        
        <div class="container mt-4">
            <div class="card border-dark">                
                <div class="card-body">
                    <table class="table table-hover text-center">
                        <thead>
                            <tr>
                                <th>Cliente</th>
                                <th>Monto</th>
                                <th>Fecha</th>
                                <th> </th>
                            </tr>
                        </thead>
                        
                        <tbody>
                            
                                <tr>
                                    <td></td>
                                    <td>S/</td>
                                    <td></td>
                                    
                                    <td>
                                        <input type="hidden" id="idOperacion" name="idOperacion" value="">
                                        <a id="eliminarCompra" class="btn btn-outline-danger">
                                            <span class="bi bi-trash">Eliminar</span>
                                        </a>
                                    </td>
                                </tr>
                            
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    
    <script src="<%=request.getContextPath()%>/resource/js/compra.js"></script>
</html>
