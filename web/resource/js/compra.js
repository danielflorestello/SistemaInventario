/* global Swal */
const date = new Date();
const Fecha = date.getFullYear() + '-' + String(date.getMonth() + 1).padStart(2, '0') + '-' + String(date.getDate()).padStart(2, '0');

$(document).ready(function () {

    //Añadir Cliente
    $("#añadirCliente").click(function () {
        var cliente = document.getElementById('cliente').value;
        
        if (!cliente) {
            Swal.fire({
                title: '¡Llene el campo, por favor!',
                allowOutsideClick: false
            });

        } else {
            $.ajax({
                type: 'POST',
                url: 'compraControlador?accion=agregarCliente',
                data: {
                    'cliente': cliente
                },
                success: function () {
                    parent.location.href = "compraControlador?accion=formularioCompra";
                }
            });
        }
    });
    
    //Agregar Compra
    $("#agregarCompra").click(function () {
        var mercaderia = document.getElementById('mercaderia').value;
        var precio = document.getElementById('precio').value;
        var cantidad = document.getElementById('cantidad').value;
        
        if (!cantidad || !precio) {
            Swal.fire({
                title: '¡Llene los todos los campos!',
                allowOutsideClick: false
            });

        } else {
            $.ajax({
                type: 'POST',
                url: 'compraControlador?accion=Agregar',
                data: {
                    'mercaderia': mercaderia,
                    'precio': precio,
                    'cantidad': cantidad
                },
                success: function () {
                    parent.location.href = "compraControlador?accion=formularioCompra";
                }
            });
        }
    });
    
    //Insertar Compra
    $("#insertarCompra").click(function () {
        document.getElementById('Fecha').value = Fecha;
        
        document.form.action="compraControlador?accion=insertarCompra";
        document.form.method="POST";
        document.form.submit();
    });
    
    $("tr #btnEliminar").click(function () {
        var idOperacion = $(this).parent().find("#idOperacion").val();

        Swal.fire({
            title: "¿Está Seguro de Eliminar?",
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
                    url: 'compraControlador?accion=Delete',
                    
                    data: {
                        'idOperacion': idOperacion
                    },
                    
                    success: function () {
                        Swal.fire(
                                '¡Se eliminaron los datos correctamente!'
                                ).then((result) => {
                                    
                            if (result.isConfirmed) {
                                parent.location.href ="compraControlador?accion=formularioCompra";
                            }
                        });
                    }
                });
                
            } else {
                Swal.fire("¡Registro no eliminado!");
            }
        });
    });
    
    $("tr #eliminarCompra").click(function () {
        var idOperacion = $(this).parent().find("#idOperacion").val();

        Swal.fire({
            title: "¿Está Seguro de Eliminar?",
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
                    url: 'compraControlador?accion=eliminarCompra',
                    
                    data: {
                        'idOperacion': idOperacion
                    },
                    
                    success: function () {
                        Swal.fire(
                                '¡Se eliminaron los datos correctamente!'
                                ).then((result) => {
                                    
                            if (result.isConfirmed) {
                                parent.location.href ="compraControlador?accion=mostrarCompra";
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