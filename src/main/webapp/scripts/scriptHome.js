var colegio;
window.addEventListener('mouseup', function (e) {
    var box = document.getElementById("mySidebar");
    if (e.target != box) {
        box.style.display = "none";
    }
});
function w3_open() {
    document.getElementById("mySidebar").style.display = "block";
}
function w3_close() {
    document.getElementById("mySidebar").style.display = "none";
}
$(document).ready(function () {
    getUser();

});

function listarPorArea() {
    var area = document.getElementById("area").value;
    var indic = 1;
    var parametros = {
        "valor1": area
    };
    $.ajax({
        data: parametros,
        url: "../ListarPorArea",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        $("#tabla").empty();
        $.each(response, function (indice, Elemento) {
            $("#tabla").append($("<tr>").append(("<td id='"+Elemento.etiqueta+"'>" + Elemento.etiqueta + "</td>"
                    + "<td id='"+Elemento.etiqueta+"'>" + Elemento.nombre + "</td>"
                    + "<td id='"+Elemento.etiqueta+"'>" + Elemento.cantidadDisponible + "</td>"
                    + "<td id='"+Elemento.etiqueta+"'>" + Elemento.ubicacion + "</td>"
                    + "<td id='"+Elemento.etiqueta+"'>" + Elemento.propiedad + "</td>"
                    + "<td id='"+Elemento.etiqueta+"'> " + Elemento.responsable + "</td>"
                    + "<td id='"+Elemento.etiqueta+"'>" + Elemento.area + "</td>"
                    + "<td id='"+Elemento.etiqueta+"'>" + Elemento.colegio + "</td></tr>")));
            indic++;
        });

    });
}

function getUser() {
    $.ajax({
        url: "../Sesion",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        if (response == "false") {
            window.location.href = "../index.html";
        } else {
            document.getElementById('nombre').innerHTML = response.nombreSol;
            var imagen = document.getElementById("imageUser");
            imagen.src = response.imagen;
            colegio = response.colegio;
        }
    });
}
function closeSesion() {
    $.ajax({
        url: "../CloseSesion",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        if (response == "false") {
            window.location.href = "../index.html";
        }
    });
}
function sendInformation() {
    if (($('#nombre2').val() != "") && ($('#cantidad').val() != "") && ($('#ubicacion').val() != "") && ($('#propiedad').val() != "") && ($('#responsable').val() != "") && ($('#area').val() != "") && ($('#colegio').val() != "")) {
        var parametros = {
            "valor1": $('#nombre2').val(),
            "valor2": $('#cantidad').val(),
            "valor3": $('#ubicacion').val(),
            "valor4": $('#propiedad').val(),
            "valor5": $('#responsable').val(),
            "valor6": $('#area').val(),
            "valor7": colegio
        };
        $.ajax({
            data: parametros,
            url: "../Ingresar",
            type: "POST"

        }).done(function (data) {
            console.log(data);
            if (data == false) {
                alert("Elemento ingresado satisfactoriamente");
                window.location.href = "Listados.html";
            }

        });
    } else {
        alert("Debe llenar los campos");
    }
}
function PermiteNumeros() {
    var tecla = window.event.keyCode;
    tecla = String.fromCharCode(tecla);
    if (!((tecla >= "0") && (tecla <= "9"))) {
        window.event.keyCode = 0;
    }
}






