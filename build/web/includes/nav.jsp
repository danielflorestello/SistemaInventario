<!-- NAV -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
        <a class="navbar-brand" href="">
            <img src="<%=request.getContextPath()%>/resource/imagenes/Logo Empresa.png" style="height: 50px"> NEGOCIACIONES TEREY
        </a>
        
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        
        <div class="navbar-collapse justify-content-end collapse" id="navbarSupportedContent">
            <ul class="navbar-nav">
                
                <!-- CONSULTAr COMPRA -->
                <li class="nav-item">
                    <a href="Controlador?accion=mostrarCompra" class="navbar-brand">Compra</a>
                </li>
                
                <!-- CONSULTAr VENTA -->
                <li class="nav-item">
                    <a href="Controlador?accion=mostrarVenta" class="navbar-brand">Venta</a>
                </li>
                
                <!-- CONSULTAR GANANCCIA MENSAUALES -->
                <li class="nav-item">
                    <a href="Controlador?accion=mostrarGanancia" class="navbar-brand"> Dashboard </a>
                </li>
                
                <!-- CERRAR SESIÓN -->
                <li class="nav-item">
                    <a class="navbar-brand" href="Controlador?accion=logout"> Cerrar Sesión 
                        <i class="bi bi-box-arrow-right"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- END NAV -->
