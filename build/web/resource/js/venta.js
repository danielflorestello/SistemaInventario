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

        if (!Comprador || !Cantidad || !Precio) {
            Swal.fire({
                title: '¡Llene los todos los campos!',
                allowOutsideClick: false
            });
            
        } else if (!idUsuario) {
            Swal.fire({
                icon: 'error',
                title: '¡Oops...!',
                text: 'Acaba de ocurrir un error relacionado con su sesión, vuelva a ingresar para solucionarlo',
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
    
    //Eliminar Venta
    $("tr #eliminarVenta").click(function () {
        var idOperacion = $(this).parent().find("#idOperacion").val();

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
                    url: 'ventaControlador?accion=eliminarVenta',
                    
                    data: {
                        'idOperacion': idOperacion
                    },
                    
                    success: function () {
                        Swal.fire(
                                '¡Se eliminaron los datos correctamente!'
                                ).then((result) => {
                                    
                            if (result.isConfirmed) {
                                parent.location.href = "ventaControlador?accion=mostrarVenta";
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