<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="includes/header.jsp"></jsp:include>
    </head>

    <body>
        <section class="vh-100 gradient-custom" style="background-color: grey;">
            <div class="container py-5 h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                        <div class="card" style="border-radius: 1rem;">
                            <div class="row g-0">
                                <div class="card-body p-4 p-lg-5 text-black" >
                                    <form name="form">
                                        <div class="form-outline mb-4 text-center">
                                            <img src="resource/imagenes/LOGO TEREY.jpeg" width="100px">
                                        </div>
                                        
                                        <div class="text-center pt-1 mb-4">
                                            <span class="h1 fw-bold mb-0">Inicio de Sesión</span>
                                        </div>
                                        
                                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Ingrese a su cuenta</h5>
                                        
                                        <div class="form-outline mb-4">
                                            <input type="text" id="usuario" name="usuario" class="form-control form-control-lg" placeholder="Usuario" />
                                        </div>

                                        <div class="form-outline mb-4">
                                            <input type="password" id="clave" name="clave" class="form-control form-control-lg" placeholder="Contraseña"/>
                                        </div>

                                        <div class="pt-1 mb-4 text-center">
                                            <input type="submit" id="Ingresar" value="Ingresar" class="btn btn-dark btn-lg btn-block">
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script src="resource/js/login.js"></script>
        </section>
    </body>
</html>
