$(document).ready(function () {
    getUser();
    obtenerData();    
});
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
            id = response.identificador;
        }
    });
}
function obtenerData() {
    var indic = 1;
    var parametros = {
        "id": id
    };
    $.ajax({
        data: parametros,
        type: 'GET',
        url: "../ListarReservasUsuario",
        success: function (resp) {
            console.log(resp);
            $.each(resp, function (indice, h) {
                $("#tablaHist2").append($("<tr>").append(("<td>"
                        + h.nombreSol + "</td>"
                        + "<td>" + h.cursoArea + "</td>"
                        + "<td>" + h.nombre + "</td>"
                        + "<td>" + h.cantidad + "</td>"
                        + "<td>" + h.fechaActual + "</td>"
                        + "<td>" + h.fechaReserva + "</td>"
                        + "<td>" + h.estado + "</td>")));
                indic++;
            });
        }
    });
}
