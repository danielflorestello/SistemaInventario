<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <h3 class="container mt-3">VENTA DE MERCADERÍAS</h3>
            </div><hr>
        </div>
        
        <!Filtros-------->
        <div class="container">
            <div class="card border-primary h-100 py-2">
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <div class="text-xs font-weight-bold text-uppercase mb-1"> Comprador:
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
                                <input type="text" class="form-control-sm" placeholder="....">
                            </div>                          
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <!Contenedor-------->
        <div class="container py-5">
            <div class="row">
                
                <!Formulario para el registro de ventas-------->
                <div class="col d-flex">
                    <div class="card border-dark">
                        <div class="card-header text-center">
                            <label class="col col-form-label fw-bold"> REGISTRO DE VENTA </label>
                        </div>
                        
                        <div class="card-body">
                            <input type="hidden" id="Usuario" name="Usuario" value="${usuario.getIdUsuario()}">
                            
                            <div class="form-group d-flex" py-3>
                                <label class="col-sm-4 col-form-label">Comprador: </label>

                                <div class="col-sm-7">
                                    <input type="text" class="form-control" id="Comprador" name="Comprador" placeholder="Comprador...">
                                </div>
                            </div>

                            <div class="form-group d-flex py-3">
                                <label class="col-sm-4 col-form-label">Mercadería: </label>

                                <div class="col-sm-7">
                                    <select name="Mercaderia" id="Mercaderia" class="form-control">
                                    
                                    <c:forEach var="datos" items="${lista1}">
                                        <option value="${datos.getIdMercaderia()}"> ${datos.getNombre()} </option>
                                    </c:forEach>
                                        
                                    </select>
                                </div>
                            </div>
                        
                            <div class="form-group d-flex py-2">
                                <label class="col-sm-4 col-form-label">Precio: </label>
                                
                                <div class="col-sm-4">
                                    <input type="number" name="Precio" id="Precio" class="form-control" placeholder="Precio.." min="0">
                                </div>
                            </div>
                        
                            <div class="form-group d-flex py-2">
                                <label class="col-sm-4 col-form-label">Cantidad: </label>

                                <div class="col-sm-7">
                                    <input type="number" class="form-control" id="Cantidad" name="Cantidad" placeholder="Cantidad..." min="0">
                                </div>
                            </div>

                            <div class="form-group d-flex py-2">
                                <label class="col-sm-4 col-form-label">Monto: </label>
                                
                                <div class="col-sm-4">
                                    <input type="text" name="Monto" id="Monto" class="form-control" readonly="" value="0.00">
                                </div>
                            </div>
                            
                            <div class="card-footer text-center">
                                <a id="agregarVenta" class="btn btn-success">Agregar</a>
                                <a id="cancelarVenta" class="btn btn-secondary">Cancelar</a>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!Tabla de ventas-------->
                <diV class="col-sm-8">
                    <div class="container">
                        <div class="card border-dark">                
                            <div class="card-body">
                                <table class="table table-hover text-center">
                                    <thead>
                                        <tr>
                                            <th>Comprador</th>
                                            <th>Mercadería</th>
                                            <th>Precio Unitario</th>
                                            <th>Peso</th>
                                            <th>Monto</th>
                                            <th>Fecha</th>
                                            <th> </th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="lista" items="${lista}">
                                            <tr>
                                                <td>${lista.getParticipante()}</td>
                                                <td>${lista.getNombre()}</td>
                                                <td>S/${lista.getPrecio()}</td>
                                                <td>${lista.getCantidad()}</td>
                                                <td>S/${lista.getMonto()}</td>
                                                <td>${lista.getFecha()}</td>

                                                <td>                                 
                                                    <a id="btnEditar" class="btn btn-outline-warning">
                                                        <input type="hidden" name="lista" id="lista" value="${lista}">
                                                        <span class="bi bi-pencil-square">Editar</span>
                                                    </a>

                                                    <a id="btnEliminar" class="btn btn-outline-danger">
                                                        <input type="hidden" name="idDetalleVenta" id="idDetalleVenta" value="${lista}">
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
                </div>
            </div>
        </div>
                                            
        <jsp:include page="../includes/footer.jsp"></jsp:include>
    </body>
</html>
