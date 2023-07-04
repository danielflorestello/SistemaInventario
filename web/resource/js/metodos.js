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
        document.getElementById('mercaderia').value = Fecha;
        
        document.form.action="compraControlador?accion=insertarCompra";
        document.form.method="POST";
        document.form.submit();
    });
});