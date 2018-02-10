$(document).ready(function () {
    listarTodo();
});
var id, cant, ub, res, nom;
function send() {
    $('.send').click(function () {
        document.getElementById('id01').style.display = 'block';
        id = $(this).parent().siblings('.etiqueta').text();
        nom = $(this).parent().siblings('.nombre').text();
        cant = $(this).parent().siblings('.cant').text();
        ub = $(this).parent().siblings('.ub').text();
        res = $(this).parent().siblings('.res').text();
        document.getElementById('nom').innerHTML = nom;
        document.getElementById('cant').innerHTML = cant;
        document.getElementById('ub').innerHTML = ub;
        document.getElementById('res').innerHTML = res;
    });
}
function send2() {
    $('.send2').click(function () {
        document.getElementById('id02').style.display = 'block';
        id = $(this).parent().siblings('.etiqueta').text();
        nom = $(this).parent().siblings('.nombre').text();
        document.getElementById('nomB').innerHTML = nom;
    });
}
function borrar() {
    var parametros = {
        "et": id
    };
    $.ajax({
        data: parametros,
        url: "../Modificar",
        type: "GET"

    }).done(function (data) {
        console.log(data);
        document.getElementById('id02').style.display = 'none';
        if (data == false) {
            alert("Elemento borrado satisfactoriamente");
            window.location.href = "Modificar.jsp";
        }else{
            alert("Este elemento no se puede borrar ya que se ha prestado");
        }

    });
}

function modificar() {

    var parametros = {
        "et": id,
        "cant": cant,
        "ub": ub,
        "res": res
    };


    $.ajax({
        data: parametros,
        url: "../Modificar",
        type: "POST"

    }).done(function (data) {
        console.log(data);
        document.getElementById('id01').style.display = 'none';
        if (data == false) {
            alert("Datos Modificados");
            window.location.href = "Modificar.jsp";
        }

    });


}
function listarTodo() {
    $.ajax({
        url: "../Listar",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        $("#tabla").empty();
        $.each(response, function (indice, Elemento) {
            $("#tablaAll").append($("<tr>").append(("<td class='etiqueta'>" + Elemento.etiqueta + "</td>"
                    + "<td class='nombre'>" + Elemento.nombre + "</td>"
                    + "<td contenteditable class='cant'>" + Elemento.cantidadDisponible + "</td>"
                    + "<td class='ub' contenteditable>" + Elemento.ubicacion + "</td>"
                    + "<td class=''>" + Elemento.propiedad + "</td>"
                    + "<td class='res' contenteditable> " + Elemento.responsable + "</td>"
                    + "<td class=''>" + Elemento.area + "</td>"
                    + "<td class=''>" + Elemento.colegio + "</td>"
                    + "<td class=''><button onclick='send();' class='send w3-button w3-green'><i class='fa fa-floppy-o'></i></button>"
                    + "<button onclick='send2();' class='send2 w3-button w3-red'><i class='fa fa-trash'></i></button></td>"
                    + "</tr>")));
            indice++;
        });

    });
}



