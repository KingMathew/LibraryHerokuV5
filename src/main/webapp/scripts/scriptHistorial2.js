$(document).ready(function () {
    getUser2();
});
function getUser2() {
    $.ajax({
        url: "../Sesion",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        var id = response.identificador;
        obtenerData2(id);
    });
}
function obtenerData2(id2) {
    var indic = 1;
    var ident = id2;
    var parametros = {
        "ident": ident
    };
    $.ajax({
        data: parametros,
        type: 'GET',
        url: "../ListarReservasUsuario"
    }).done(function (data) {
        console.log(data);
        $.each(data, function (indice, h) {
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

    });
}