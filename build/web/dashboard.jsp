<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="includes/header.jsp"></jsp:include>
    </head>
    
    <body>
        <jsp:include page="includes/nav.jsp"></jsp:include>
        
        <div class="container-fluid">
            <div class="row py-2 justify-content-center">
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-primary shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-primary text-uppercase mb-1"> Total de Ingresos </div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">S/ ${calculo.totalIngreso} </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                                
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-success shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-success text-uppercase mb-1">Total de Costos</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">S/ ${calculo.totalCosto}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- Pending Requests Card Example -->
                <div class="col-xl-3 col-md-6 mb-4">
                    <div class="card border-warning shadow h-100 py-2">
                        <div class="card-body">
                            <div class="row no-gutters align-items-center">
                                <div class="col mr-2">
                                    <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">Ganancias Netas</div>
                                    <div class="h5 mb-0 font-weight-bold text-gray-800">S/ ${calculo.totalGanancia}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
                                
            <div class="row justify-content-center">
                <div class="col-xl-5 col-lg-5">
                    <div class="card shadow mb-4">
                        <div class="card-header py-3 text-center">
                            <h6 class="m-0 font-weight-bold text-primary">MARGEN BRUTO</h6>
                        </div>
                        
                        <div class="card-body">
                            <div class="chart-area align-items-center">
                                <diV class="col-sm-3">
                                    <div class="container">
                                        <table class="table table-hover text-center">
                                            <thead>
                                                <tr>
                                                    <th>Mercaderia</th>
                                                    <th>Margen</th>
                                                </tr>
                                            </thead>

                                            <tbody>
                                                <c:forEach var="lista" items="${listado}">
                                                    <tr>
                                                        <td>${lista.getNombre()}</td>
                                                        <td></td>
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
                
                <!-- Pie Chart -->
                <div class="col-xl-5 col-lg-5">
                    <div class="card shadow mb-4">
                        <!-- Card Header - Dropdown -->
                        <div class="card-header py-3 text-center">
                            <h6 class="m-0 font-weight-bold text-primary">ROTACIÓN DE EXISTENCIAS</h6>
                        </div>
                        <!-- Card Body -->
                        <div class="card-body">
                            <div class="chart-area align-items-center">
                                <div id="chartCostos" style="height: 300px; width: 100%;"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
