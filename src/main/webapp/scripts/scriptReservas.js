$(document).ready(function () {
    obtenerData2();
    getUser2();
});
var et = "";
function obtenerData2() {
    var indic = 1;
    $.ajax({
        type: 'GET'
        , url: "../ListarTodo"
        , async: true
        , cache: false
        , success: function (resp) {
            $.each(resp, function (indice, inventario) {
                $("#tablaRes").append($("<tr onclick=getDataRow();> ").append(("<td>" + inventario.etiqueta + "</td>"
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

function getDataRow() {
    var table = document.getElementById('tablaRes');
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].onclick = function () {
            var cant = this.cells[2].innerHTML;
            if (cant <= 0) {
                alert("No hay más elementos disponibles de este elemento.");
            } else {
                document.getElementById('reserva').style.display = 'block';
                document.getElementById('element').innerHTML = this.cells[0].innerHTML;
                et = this.cells[0].innerHTML;
                document.getElementById('nombreLibro').innerHTML = this.cells[1].innerHTML;
                document.getElementById('cantidad').innerHTML = this.cells[2].innerHTML;
                var input = document.getElementById("campo1");
                input.setAttribute("max", this.cells[2].innerHTML);
            }

        };
    }
}

var id = "";
function getUser2() {
    $.ajax({
        url: "../Sesion",
        type: "GET"

    }).done(function (response) {
        if (response != "false") {
            document.getElementById('miId').innerHTML = response.identificador;
            id = response.identificador;
        }

    });
}
function Buscar() {

    var tableReg = document.getElementById('tablaRes');
    var searchText = document.getElementById('Busqueda').value.toLowerCase();
    var cellsOfRow = "";
    var found = false;
    var compareWith = "";

    for (var i = 1; i < tableReg.rows.length; i++)
    {
        cellsOfRow = tableReg.rows[i].getElementsByTagName('td');
        found = false;
        // Recorremos todas las celdas
        for (var j = 0; j < cellsOfRow.length && !found; j++)
        {
            compareWith = cellsOfRow[j].innerHTML.toLowerCase();
            // Buscamos el texto en el contenido de la celda
            if (searchText.length == 0 || (compareWith.indexOf(searchText) > -1))
            {
                found = true;
            }
        }
        if (found)
        {
            tableReg.rows[i].style.display = '';
        } else {
            tableReg.rows[i].style.display = 'none';
        }
    }
}
function Reserva(fechaRes, cantidad) {
    alert(et);

    if (fechaRes != "" && cantidad != "") {
        var parametros = {
            "idSol": id,
            "idElm": et,
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
                window.location.href = "historialReservas.jsp";
            }
        });

    } else {
        alert("Debe llenar los campos");
    }

}
$(function () {
    $('[type="date"].min-today').prop('min', function () {
        return new Date().toJSON().split('T')[0];
    });
});





