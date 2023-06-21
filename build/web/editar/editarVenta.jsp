<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../includes/header.jsp"></jsp:include>
    </head>
    
    <body>
        <jsp:include page="../includes/nav.jsp"></jsp:include>
        
        <div class="container py-5">
            <form method="POST">
                <div class="form-group row py-2">
                    <label class="col-sm-4">Comprador: </label>
                    <div class="col-sm-7"><input type="text" class="form-control" id="Persona" name="Persona" value="${lista[0].Persona}"></div>
                </div>

                <div class="form-group row py-2">
                    <label class="col-sm-4 col-form-label">Mercadería: </label>
                    <div class="col-sm-7"><input type="text" class="form-control" id="Mercaderia" name="Mercaderia" value="${lista[0].Mercaderia}"></div>
                </div>

                <div class="form-group row py-2">
                    <label class="col-sm-4 col-form-label">Peso: </label>
                    <div class="col-sm-7"><input type="number" class="form-control" id="Peso" name="Peso" value="${lista[0].Peso}" step="0.01" min="0"></div>
                </div>

                <div class="form-group row py-2">
                    <label class="col-sm-4 col-form-label">Precio: </label>
                    <div class="col-sm-7"><input type="number" class="form-control" id="Precio" name="Precio" value="${lista[0].Precio}" step="0.01" min="0"></div>
                </div>

                <div class="form-group row py-2">
                    <label class="col-sm-4 col-form-label">Monto: </label>
                    <div class="col-sm-7"><input type="text" class="form-control" id="Monto" name="Monto" value="${lista[0].Monto}" step="0.01" readonly=""></div>
                </div>
                
                <div class="form-group text-center py-5">
                    <input type="submit" value="Actualizar" class="btn btn-success">
                    <a href="consultaVenta.htm">Regresar</a>
                </div>
            </form>
        </div>
    </body>
</html>
