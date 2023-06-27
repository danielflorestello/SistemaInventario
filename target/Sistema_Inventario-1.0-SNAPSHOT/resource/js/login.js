$(document).ready(function () {
    $("#Ingresar").click(function () {
        var usuario = document.getElementById('usuario').value;
        var clave = document.getElementById('clave').value;

        if (usuario.length === 0) {
            alert("!Ingresar el Usuario por favor!");

        } else {

            if (clave.length === 0) {
                alert("!Ingresar Clave por favor¡");

            } else {
                document.form.action = "Controlador?accion=Ingresar";
                document.form.method = "POST";
                document.form.submit();
            }
        }
    });
});