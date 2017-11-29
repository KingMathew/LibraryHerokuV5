$(document).ready(function () {
    obtenerData();
    getUser();
});
function obtenerData() {
    var indic = 1;
    $.ajax({
        type: 'GET'
        , url: "../ListarReservas"
        , async: true
        , cache: false
        , success: function (resp) {
            console.log(resp);
            $.each(resp, function (indice, reservasPendientes) {
                $("#tablaRes").append($("<tr>").append(("<td>"
                        + reservasPendientes.nombreSol + "</td>"
                        + "<td>" + reservasPendientes.cursoArea + "</td>"
                        + "<td>" + reservasPendientes.nombre + "</td>"
                        + "<td>" + reservasPendientes.cantidad + "</td>"
                        + "<td>" + reservasPendientes.fechaActual + "</td>"
                        + "<td>" + reservasPendientes.fechaReserva + "</td>"
                        + "<td>" + reservasPendientes.estado + "</td>")));
                indic++;
            });
        }
    });
}

var id = "";
function getUser() {
    $.ajax({
        url: "../Sesion",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        if (response == "false") {
            window.location.href = "../index.html";
        } else {
            document.getElementById('miId').innerHTML = response.identificador;
            id = response.identificador;
        }
    });
}
function Reserva2(fechaRes, cantidad) {

    if (fechaRes != "" && cantidad != "") {
        var parametros = {
            "idSol": id,
            "idElm": etiqueta,
            "fechaRes": fechaRes,
            "cantidad": cantidad
        };
        $.ajax({
            data: parametros,
            url: "../Reservas",
            type: "GET"

        }).done(function (response) {
            console.log(response);
            if (response != false) {
                alert("No se pudo realizar la reserva");
            } else {
                alert("Reserva realizada satisfactoriamente");
                window.location.href = "historialReservas.html";
            }
        });

    } else {
        alert("Debe llenar los campos");
    }

}



