$(document).ready(function () {
    obtenerData();
});
function obtenerData() {
    var indic = 1;
    $.ajax({
        type: 'GET'
        , url: "../ListarPrestamos"
        , async: true
        , cache: false
        , success: function (resp) {
            console.log(resp);
            $.each(resp, function (indice, HistorialPrestamos) {
                $("#tablaHist").append($("<tr>").append(("<td>"
                        + HistorialPrestamos.nombreUsuario + "</td>"
                        + "<td>" + HistorialPrestamos.cursoArea + "</td>"
                        + "<td>" + HistorialPrestamos.nombreElemento + "</td>"
                        + "<td>" + HistorialPrestamos.cantidadPrestamo + "</td>"
                        + "<td>" + HistorialPrestamos.fechaInicio + "</td>"
                        + "<td>" + HistorialPrestamos.fechaDevolucion + "</td>"
                        + "<td>" + HistorialPrestamos.estadoPrestamo + "</td>")))
                indic++;
            });
        }
    });
}

