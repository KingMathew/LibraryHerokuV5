$(document).ready(function () {
    obtenerData();
    getUser();
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
        type: 'GET'
        , url: "../ListarReservasUsuario"
        , async: true
        , cache: false
        , success: function (resp) {
            console.log(resp);
            $.each(resp, function (indice, h) {
                $("#tablaHist").append($("<tr>").append(("<td>"
                        + h.nombreUsuario + "</td>"
                        + "<td>" + h.cursoArea + "</td>"
                        + "<td>" + h.nombreElemento + "</td>"
                        + "<td>" + h.cantidadPrestamo + "</td>"
                        + "<td>" + h.fechaInicio + "</td>"
                        + "<td>" + h.fechaDevolucion + "</td>"
                        + "<td>" + h.estadoPrestamo + "</td>")));
                indic++;
            });
        }
    });
}
