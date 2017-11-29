$(document).ready(function () {
    obtenerData();
    getUser();
});
function obtenerData() {
    var indic = 1;
    $.ajax({
        type: 'GET'
        , url: "../BuscarElementoPorNombre"
        , async: true
        , cache: false
        , success: function (resp) {
            $.each(resp, function (indice, inventario) {
                $("#tablaPrest").append($("<tr id='" + indic + "' onclick='pp(this);'> ").append(("<td>" + inventario.etiqueta + "</td>"
                        + "<td>" + inventario.nombre + "</td>"
                        + "<td>" + inventario.cantidadDisponible + "</td>"
                        + "<td>" + inventario.ubicacion + "</td>"
                        + "<td>" + inventario.propiedad + "</td>"
                        + "<td>" + inventario.responsable + "</td>"
                        + "<td>" + inventario.area + "</td>"
                        + "<td>" + inventario.colegio + "</td>")));
                indic++;
            });
        }
    });
}
function pp(x) {
    var y = x.rowIndex;

    var parametros = {
        "identificador": y
    };
    $.ajax({
        data: parametros,
        url: "../Reservas",
        type: "POST"
    }).done(function (response) {
        console.log(response);
        var cantidad = response.cantidadDisponible;
        if (cantidad <= 0) {
            alert("No hay más elementos disponibles de este elemento");
        } else {
            document.getElementById('prestamo').style.display = 'block';
            document.getElementById('element').innerHTML = response.etiqueta;
            etiqueta = response.etiqueta;
            document.getElementById('nombreLibro').innerHTML = response.nombre;
            document.getElementById('cantidad').innerHTML = response.cantidadDisponible;
            var input = document.getElementById("campo1");
            input.setAttribute("max", cantidad);
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



