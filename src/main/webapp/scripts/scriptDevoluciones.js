$(document).ready(function () {
    obtenerData();
});
function obtenerData() {
    var indic = 1;
    $.ajax({
        type: 'GET'
        , url: "../ListarPrestamosActivos"
        , async: true
        , cache: false
        , success: function (resp) {
            console.log(resp);
            if (resp == "") {
                document.getElementById('mensaje').innerHTML = "Actualmente no hay elementos en calidad de prestamo";                
            } else {
                $.each(resp, function (indice, HistorialPrestamos) {
                    $("#tablaPA").append($("<tr onclick='getDataRow();'>").append(("<td>"
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
        }
    });
}

function getDataRow() {
    var table = document.getElementById('tablaPA');
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            var a = this.cells[0].innerHTML;
            var b = this.cells[2].innerHTML;
            var c = this.cells[3].innerHTML;
            var parametros = {
                "nombre": this.cells[0].innerHTML,
                "nombreE": this.cells[2].innerHTML
            };
            $.ajax({
                data: parametros,
                url: "../Devoluciones",
                type: "GET"
            }).done(function (response) {
                console.log(response);
                var j = confirm("Se devolverá el elemento: " + b + "\nUsado por: " + a + "\nCantidad: " + c);
                if (j == true) {
                    executeDev(j);
                } else {
                    alert("No se realizó la devolución");
                }
            });
        };
    }
}
function executeDev(a) {
    var parametros = {
        "boolean": a
    };
    $.ajax({
        data: parametros,
        url: "../Devoluciones",
        type: "POST"
    }).done(function (response) {
        console.log(response);
        alert("Devolución realizada correctamente");
        window.location.href = "Devoluciones.html";

    });
}





