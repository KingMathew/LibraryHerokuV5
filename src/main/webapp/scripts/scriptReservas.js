$(document).ready(function () {
    obtenerData();
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


