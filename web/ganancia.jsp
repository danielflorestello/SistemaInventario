<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="includes/header.jsp"></jsp:include>
        <script type="text/javascript">
            var cantidad1 = 1000.00;
            var cantidad2 = 1500.00;
            var cantidad3 = 2500.00;
            var cantidad4 = 3000.00;
            var cantidad5 = 2800.00;
            
            var costo1 = 500.00;
            var costo2 = 800.00;
            var costo3 = 900.00;
            var costo4 = 1500.00;
            var costo5 = 700.00;
            
            var ingresos    = (cantidad1+cantidad2+cantidad3+cantidad4+cantidad5).toFixed(2);
            var costos      = (costo1+costo2+costo3+costo4+costo5).toFixed(2);
            var ganancias    = (ingresos-costos).toFixed(2);
            
            $(function () {
                var chart = new CanvasJS.Chart("chartIngresos", {
                    theme: "light1", // "light2", "dark1", "dark2"
                    animationEnabled: false, // change to true
                    data: [
                    {   
                        // Change type to "bar", "area", "spline", "pie",etc.
                                    type: "line",
                                    dataPoints: [
                                        {label: "Enero",    y: cantidad1},
                                        {label: "Febrero",  y: cantidad2},
                                        {label: "Marzo",    y: cantidad3},
                                        {label: "Abril",    y: cantidad4},
                                        {label: "Mayo",     y: cantidad5}
                            ]
                        }
                    ]
                });
                chart.render();
            });
            
            $(function () {
                var chart = new CanvasJS.Chart("chartCostos", {
                    theme: "light1", // "light2", "dark1", "dark2"
                    animationEnabled: false, // change to true
                    data: [
                    {   
                        // Change type to "bar", "area", "spline", "pie",etc.
                                    type: "line",
                                    dataPoints: [
                                        {label: "Enero",    y: costo1},
                                        {label: "Febrero",  y: costo2},
                                        {label: "Marzo",    y: costo3},
                                        {label: "Abril",    y: costo4},
                                        {label: "Mayo",     y: costo5}
                            ]
                        }
                    ]
                });
                chart.render();
            });
        </script>
    </head>
    
    <body>
        <jsp:include page="includes/nav.jsp"></jsp:include>
        
        <!-- Begin Page Content -->
        <div class="container-fluid">
            
            <!-- Content Row -->
            <div class="row py-2">

                <!-- Earnings (Monthly) Card Example -->
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

                <!-- Earnings (Monthly) Card Example -->
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

            <!-- Content Row -->

            <div class="row">

                <!-- Area Chart -->
                <div class="col-xl-5 col-lg-5">
                    <div class="card shadow mb-4">
                        <!-- Card Header - Dropdown -->
                        <div class="card-header py-3 text-center">
                            <h6 class="m-0 font-weight-bold text-primary">INGRESOS MENSUALES</h6>
                        </div>
                        <!-- Card Body -->
                        <div class="card-body">
                            <div class="chart-area align-items-center">
                                <div id="chartIngresos" style="height: 300px; width: 100%;"></div>
                            </div>
                        </div>
                    </div>
                </div>
                
                <!-- Pie Chart -->
                <div class="col-xl-5 col-lg-5">
                    <div class="card shadow mb-4">
                        <!-- Card Header - Dropdown -->
                        <div class="card-header py-3 text-center">
                            <h6 class="m-0 font-weight-bold text-primary">COSTOS MENSUALES</h6>
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
                                    <td>${lista.getNombreMercaderia()}</td>
                                    <td></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>
        <!-- /.container-fluid -->
    </body>
</html>
