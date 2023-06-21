/* global Swal */
const date = new Date();
const Fecha = date.getFullYear() + '-' + String(date.getMonth() + 1).padStart(2, '0') + '-' + String(date.getDate()).padStart(2, '0');

$(document).ready(function () {
    
    var Cantidad = document.getElementById('Cantidad');
    var Precio = document.getElementById('Precio');
    var Monto = document.getElementById('Monto');
    
    Cantidad.addEventListener('input', calcularMonto);
    Precio.addEventListener('input', calcularMonto);

    function calcularMonto() {
        var cantidad = parseFloat(Cantidad.value);
        var precio = parseFloat(Precio.value);

        if (!isNaN(cantidad) && !isNaN(precio)) {
            var monto = cantidad * precio;
            Monto.value = monto.toFixed(2);
        } else {
            Monto.value = '0.00';
        }
    }
    
    //Agregar
    $("#agregarVenta").click(function () {
        var idTipo = 2;
        var Comprador = document.getElementById('Comprador').value;
        var idUsuario = document.getElementById('Usuario').value;
        var idMercaderia = document.getElementById('Mercaderia').value;
        var Cantidad = document.getElementById('Cantidad').value;
        var Precio = document.getElementById('Precio').value;
        var Monto = document.getElementById('Monto').value;

        if (!Comprador || !Cantidad || !Precio || !Fecha) {
            Swal.fire({
                title: '¡Llene los todos los campos!',
                allowOutsideClick: false
            });

        } else {
            
            $.ajax({
                type: 'POST',
                url: 'Controlador?accion=agregarVenta',
                data: {
                    'Participante': Comprador,
                    'idMercaderia': idMercaderia,
                    'Cantidad': Cantidad,
                    'Precio': Precio,
                    'Monto': Monto,
                    'Fecha': Fecha,
                    'idUsuario': idUsuario,
                    'idTipo': idTipo
                },
                success: function () {
                    Swal.fire(
                            '¡Registro exitoso!',
                            '¡Se guardaron los datos correctamente!'
                            ).then((result) => {
                        if (result.isConfirmed) {
                            parent.location.href = "Controlador?accion=mostrarVenta";
                        }
                    });
                }
            });
        }
    });
    
    //Editar
    /*$("#btnEditar").click(function () {
        const lista = document.getElementById('lista').value;
        
        lista.forEach(function() {
            
        Swal.fire({
            title: "REGISTRO DE VENTA DE MERCADERÍA",
            html: ` <form name="form">
                        <input type="hidden" name="fecha"     id="fecha"        value="${fecha}">
                        <input type="hidden" name="idUsuario" id="idUsuario"    value="${idUsuario}">
                        
                        <div class="form-group row">
                            <label class="col-sm-4">Comprador: </label>
                            <div class="col-sm-7"><input type="text" class="form-control-sm" id="comprador" name="persona" value="${lista.getNombre()}"></div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Mercadería: </label>
                            <div class="col-sm-7"><input type="text" class="form-control-sm" id="mercaderia" name="mercaderia" placeholder="Mercadería..."></div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Peso: </label>
                            <div class="col-sm-7"><input type="number" class="form-control-sm" id="peso" name="peso" placeholder="Peso..." min="0"></div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Precio: </label>
                            <div class="col-sm-7"><input type="number" class="form-control-sm" id="precio" name="precio" placeholder="Precio..." min="0"></div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-4 col-form-label">Monto: </label>
                            <div class="col-sm-7"><input type="text" class="form-control-sm" id="monto" name="monto" placeholder="Monto..." readonly=""></div>
                        </div>
                    </form>`,
            didOpen: () => {
                const peso = Swal.getHtmlContainer().querySelector("#peso");
                const precio = Swal.getHtmlContainer().querySelector("#precio");
                const monto = Swal.getHtmlContainer().querySelector("#monto");
                precio.oninput = () => {
                    monto.value = "";
                    const total = parseFloat(peso.value) * parseFloat(precio.value);
                    if (total > 0) {
                        monto.value = `${total.toFixed(2)}`;
                    }
                };
            },
            allowOutsideClick: false,
            showCancelButton: true,
            confirmButtonText: "Agregar",
            cancelButtonText: "Cancelar",
            preConfirm: () => {
                const persona = Swal.getPopup().querySelector("#comprador").value;
                const mercaderia = Swal.getPopup().querySelector("#mercaderia").value;
                const peso = Swal.getPopup().querySelector("#peso").value;
                const precio = Swal.getPopup().querySelector("#precio").value;
                const monto = Swal.getPopup().querySelector("#monto").value;
                
                if (!persona || !mercaderia || !peso || !precio || !monto) {
                    Swal.showValidationMessage(`!Llene todos los campos¡`);
                    
                }
            }
        });
    }).then((result) => {
            if (result.isConfirmed) {
                var persona = Swal.getPopup().querySelector("#comprador").value;
                var mercaderia = Swal.getPopup().querySelector("#mercaderia").value;
                var peso = Swal.getPopup().querySelector("#peso").value;
                var precio = Swal.getPopup().querySelector("#precio").value;
                var monto = Swal.getPopup().querySelector("#monto").value;
                
                $.ajax({
                    type: 'POST',
                    url: 'Controlador?accion=editarVenta',
                    data: {
                        'persona': persona,
                        'mercaderia': mercaderia,
                        'peso': peso,
                        'precio': precio,
                        'monto': monto,
                        'fecha': fecha,
                        'idUsuario': idUsuario
                    },
                    success: function () {
                        Swal.fire(
                                '¡Registro exitoso!',
                                '¡Se guardaron los datos correctamente!'
                                ).then((result) => {
                            if (result.isConfirmed) {
                                parent.location.href = "Controlador?accion=mostrarVenta";
                            }
                        });
                    }
                });
            }
        });
    });*/
    
    //Eliminar
    $("tr #btnEliminar").click(function () {
        var idDetalleVenta = $(this).parent().find("#idDetalleVenta").val();

        Swal.fire({
            title: "¿Está Seguro de Eliminar?",
            text: "¡Una vez eliminado, Ud. puede agregar de nuevo!",
            icon: "warning",
            allowOutsideClick: false,
            showCancelButton: true,
            confirmButtonText: "Eliminar",
            cancelButtonText: "Cancelar",
            dangerMode: true

        }).then((result) => {

            if (result.isConfirmed) {
                $.ajax({
                    type: 'POST',
                    url: 'Controlador?accion=eliminarVenta',
                    
                    data: {
                        'idDetalleVenta': idDetalleVenta
                    },
                    
                    success: function () {
                        Swal.fire(
                                '¡Se eliminaron los datos correctamente!'
                                ).then((result) => {
                                    
                            if (result.isConfirmed) {
                                parent.location.href = "Controlador?accion=mostrarVenta";
                            }
                        });
                    }
                });
                
            } else {
                Swal.fire("¡Registro no eliminado!");
            }
        });
    });
});