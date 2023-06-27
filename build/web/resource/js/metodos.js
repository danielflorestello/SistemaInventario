/* global Swal */
const date = new Date();
const Fecha = date.getFullYear() + '-' + String(date.getMonth() + 1).padStart(2, '0') + '-' + String(date.getDate()).padStart(2, '0');

$(document).ready(function () {

    //Compra
    $("#agregarCompra").click(function () {
        var idTipo = 1;
        var cliente = document.getElementById('cliente').value;
        var idUsuario = document.getElementById('Usuario').value;
        var mercaderia = document.getElementById('mercaderia').value;
        var cantidad = document.getElementById('cantidad').value;
        var precio = document.getElementById('precio').value;

        if (!cliente || !cantidad || !precio) {
            Swal.fire({
                title: '¡Llene los todos los campos!',
                allowOutsideClick: false
            });

        } else {

            $.ajax({
                type: 'POST',
                url: 'Controlador?accion=Agregar',
                data: {
                    'participante': cliente,
                    'mercaderia': mercaderia,
                    'cantidad': cantidad,
                    'precio': precio,
                    'idUsuario': idUsuario,
                    'idTipo': idTipo
                },
            });
        }
    });
    
    $("#añadirCliente").click(function () {
        var cliente = document.getElementById('cliente').value;
        var Participante = document.getElementById('cliente').value;
        
        if (!cliente) {
            Swal.fire({
                title: '¡Llene el campo, por favor!',
                allowOutsideClick: false
            });

        } else {

            $.ajax({
                type: 'POST',
                url: 'compraControlador?accion=formularioCompra',
                data: {
                    'cliente': cliente
                },
                success: function () {
                    Participante.value = cliente;
                }
            });
        }
    });
});