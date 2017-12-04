var etiqueta = "0";
$(document).ready(function () {
    obtenerData();
});
function obtenerData() {
    var indic = 1;
    $.ajax({
        type: 'GET'
        , url: "../ListarTodo"
        , async: true
        , cache: false
        , success: function (resp) {
            $.each(resp, function (indice, inventario) {
                $("#tablaPrest").append($("<tr>").append(("<td>" + inventario.etiqueta + "</td>"
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
function Buscar() {

    var tableReg = document.getElementById('tablaPrest');
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
