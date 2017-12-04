$(document).ready(function () {
    getUser3();
});
function getUser3() {
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
        url: "../ListarPrestamosUsuario"
    }).done(function (data) {
        console.log(data);
        $.each(data, function (indic, h) {
            $("#tablaHist").append($("<tr>").append(("<td>"
                    + h.nombreUsuario + "</td>"
                    + "<td>" + h.cursoArea + "</td>"
                    + "<td>" + h.nombreElemento + "</td>"
                    + "<td>" + h.cantidadPrestamo + "</td>"
                    + "<td>" + h.fechaInicio + "</td>"
                    + "<td>" + h.fechaDevolucion + "</td>"
                    + "<td>" + h.estadoPrestamo + "</td>")))
            indic++;
        });

    });
}


