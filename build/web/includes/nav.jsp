<!-- NAV -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="">
            <img src="<%=request.getContextPath()%>/resource/imagenes/LOGO TEREY.jpeg" style="height: 50px"> NEGOCIACIONES TEREY
        </a>
        
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="navbar-collapse justify-content-end collapse" id="navbarSupportedContent">
            <ul class="navbar-nav">
                <!-- PÁGINA PRINCIPAL -->
                <li class="nav-item">
                    <a href="Controlador?accion=home" class="navbar-brand">Inicio</a>
                </li>
                
                <!-- CONSULTAR COMPRA -->
                <li class="nav-item">
                    <a href="compraControlador?accion=mostrarCompra" class="navbar-brand">Compra</a>
                </li>
                
                <!-- CONSULTAR VENTA -->
                <li class="nav-item">
                    <a href="ventaControlador?accion=mostrarVenta" class="navbar-brand">Venta</a>
                </li>
                
                <!-- CONSULTAR GANANCIAS MENSUALES -->
                <li class="nav-item">
                    <a href="Controlador?accion=mostrarDashboard" class="navbar-brand"> Dashboard </a>
                </li>
                
                <!-- CERRAR SESIÓN -->
                <li class="nav-item">
                    <a class="navbar-brand" href="Controlador?accion=Salir"> Cerrar Sesión 
                        <i class="bi bi-box-arrow-right"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- END NAV -->
