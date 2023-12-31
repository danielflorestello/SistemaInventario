<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../includes/header.jsp"></jsp:include>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    </head>
    
    <body>
        <jsp:include page="../includes/nav.jsp"></jsp:include>
        <h1>REGISTRAR MERCADERÍA</h1>
        
        <form name="form">
        <div class="container py-5">
            <div class="row">
                
                <!Formulario para el registro de ventas-------->
                <div class="col">
                    <div class="card border-dark">
                        <div class="card-header text-center">
                            <label class="col col-form-label fw-bold"> REGISTRO DE COMPRA </label>
                        </div>
                        
                        <div class="card-body">
                            <input type="hidden" id="Usuario" name="Usuario" value="${usuario.getIdUsuario()}">
                            <input type="hidden" id="Fecha" name="Fecha" value="">
                            
                            <div class="d-inline-flex p-2">
                                <input type="text" class="form-control" id="cliente" name="cliente" placeholder="Cliente...">
                            </div>

                            <div class="d-inline-flex p-2">
                                <a id="añadirCliente" class="btn btn-outline-info">Añadir</a>
                            </div>

                            <div class="form-group d-flex py-3">
                                <label class="col-sm-4 col-form-label">Mercadería: </label>

                                <div class="col-sm-7">
                                    <select name="mercaderia" id="mercaderia" class="form-control">                
                                        <c:forEach var="datos" items="${mercaderia}">
                                            <option value="${datos.getIdMercaderia()}">  ${datos.getNombre()} </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        
                            <div class="form-group d-flex py-2">
                                <label class="col-sm-4 col-form-label">Precio: </label>
                                
                                <div class="col-sm-4">
                                    <input type="number" name="precio" id="precio" class="form-control" placeholder="Precio.." step="0.01" min="0">
                                </div>
                            </div>
                        
                            <div class="form-group d-flex py-2">
                                <label class="col-sm-4 col-form-label">Cantidad: </label>

                                <div class="col-sm-7">
                                    <input type="number" name="cantidad" id="cantidad" class="form-control" pattern="[a-zA-Z]+" placeholder="Cantidad..." step="0.01" min="0">
                                </div>
                            </div>
                            
                            <div class="card-footer text-center">
                                <a id="agregarCompra" class="btn btn-success">Agregar</a>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!Tabla de ventas-------->
                <div class="col-sm-8">
                    <div class="container">
                        <div class="card border-dark">
                            <div class="card-header">
                                <div class="row">
                                    <div class="d-flex col-sm-5 ml-auto">
                                        <label class="fw-bold col-sm-3 col-form-label">Cliente: </label>
                                        <input type="text" name="participante" id="participante" class="form-control" value="${cliente}" readonly="">
                                    </div>
                                </div>
                            </div>
                            
                            <div class="card-body">
                                <table class="table table-hover text-center">
                                    <thead>
                                        <tr>
                                            <th>Mercadería</th>
                                            <th>Precio Unitario</th>
                                            <th>Peso</th>
                                            <th>SubTotal</th>
                                        </tr>
                                    </thead>

                                    <tbody>
                                        <c:forEach var="lista" items="${listado}">
                                            <tr>
                                                <td>${lista.getNombreMercaderia()}</td>
                                                <td>S/${lista.getPrecio()}</td>
                                                <td>${lista.getCantidad()}</td>
                                                <td>${lista.getSubTotal()}</td>
                                                
                                                <td>
                                                    <input type="hidden" name="idOperacion" id="idOperacion" value="${lista.getIdOperacion()}">
                                                    
                                                    <a id="btnEliminar" class="btn btn-outline-danger"> 
                                                        <span class="bi bi-trash">Eliminar</span>
                                                    </a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            
                            <div class="card-footer align-items-end">
                                <div class="row">
                                    <div class="col">
                                        <a id="insertarCompra" class="btn btn-success">Agregar</a>
                                        <a id="cancelarCompra" class="btn btn-danger">Cancelar</a>
                                    </div>
                                    
                                    <div class="col">
                                        <input type="number" class="form-control" value="${total}" readonly="">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
        <script src="<%=request.getContextPath()%>/resource/js/compra.js"></script>
    </body>
</html>
