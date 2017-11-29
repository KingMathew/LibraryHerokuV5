$(document).ready(function () {
    document.getElementById('myButton').style.display = 'none';
    $('#load').hide();
});
var oFileIn;
var oJS;
$(function () {
    oFileIn = document.getElementById('my_file_input');
    if (oFileIn.addEventListener) {
        oFileIn.addEventListener('change', filePicked, false);
    }
});
function filePicked(oEvent) {
    var oFile = oEvent.target.files[0];
    var reader = new FileReader();
    reader.onload = function (e) {
        var data = e.target.result;
        var cfb = XLS.CFB.read(data, {type: 'binary'});
        var wb = XLS.parse_xlscfb(cfb);
        wb.SheetNames.forEach(function (sheetName) {
            oJS = XLS.utils.sheet_to_row_object_array(wb.Sheets[sheetName]);
//            
            $.each(oJS, function (indice, e) {
                $("#miTabla").append($("<tr>").append(("<td>" + e.Identificador + "</td>"
                        + "<td>" + e.Nombre + "</td>"
                        + "<td>" + e.Tipo + "</td>"
                        + "<td>" + e.cursoArea + "</td>"
                        + "<td>" + e.Colegio + "</td>"
                        + "<td>" + e.Clave + "</td>"
                        + "<td>" + e.Imagen + "</td>"
                        + "<td>" + e.Correo + "</td>"
                        + "<td>" + e.Estado + "</td>"
                        + "</tr>")));
                indice++;
            });
        });
    };
    reader.readAsBinaryString(oFile);
    document.getElementById('myButton').style.display = 'block';
    document.getElementById('miP').style.textAlign = "center";
}
function cargar() {
    $('#load').show();
    $.ajax({
        url: "../cargarBaseDatos",
        data: {a: JSON.stringify(oJS)},
        type: "POST",
        dataType: 'JSON',
        success: function (response) {
            console.log(response);
            if (response == 1) {
                alert("Usuarios ingresados satisfactiamente a la base de datos ");
                window.location.href = "CargarBaseDatos.html";
            }
            if (response == 0) {
                alert("No se puede insertar, alguno de los usuarios que trata de ingresar, ya se encuentra en la base de datos");
                window.location.href = "CargarBaseDatos.html";
            }
        },
        complete: function () {
            $('#load').hide();
        }
    });

}

