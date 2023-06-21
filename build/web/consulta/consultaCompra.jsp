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
                    <a href="Controlador?accion=formularioCompra" class="btn btn-outline-success">
                        <span >Agregar</span>
                    </a>
                </div>
            </div>
        </div><hr>
        
        <div class="container">
            <div class="card border-primary h-100 py-2">
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <div class="text-xs font-weight-bold text-uppercase mb-1"> Cliente:
                                <input type="text" class="form-control-sm" placeholder="....">
                            </div>
                        </div>
                        
                        <div class="col">
                            <div class="text-xs font-weight-bold text-uppercase mb-1"> Mercadería:
                                <input type="text" class="form-control-sm" placeholder="....">
                            </div>                          
                        </div>
                        
                        <div class="col">
                            <div class="text-xs font-weight-bold text-uppercase mb-1"> Fecha:
                                <input type="text" class="form-control-sm"  placeholder="....">
                            </div>                          
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
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
                            <c:forEach var="lista" items="${lista}">
                                <tr>
                                    <td>${lista.getParticipante()}</td>
                                    <td>S/${lista.getMonto()}</td>
                                    <td>${lista.getFecha()}</td>
                                    <td>
                                        <a href="" class="btn btn-outline-warning">
                                            <span class="bi bi-pencil-square">Editar</span>
                                        </a>
                                            
                                        <a href="" class="btn btn-outline-danger">
                                            <span class="bi bi-trash">Eliminar</span>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>
