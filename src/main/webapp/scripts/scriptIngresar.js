$(document).ready(function () {
    getUser2();
    getNumber();
});
var colegio = "";
function getUser2() {
    $.ajax({
        url: "../Sesion",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        if (response == "false") {
            window.location.href = "../index.html";
        } else {
            document.getElementById('colegioI').innerHTML = response.colegio;
            colegio = response.colegio;
        }
    });
}
function getNumber() {
    $.ajax({
        url: "../Ingresar",
        type: "GET"

    }).done(function (response) {
        console.log(response);
        document.getElementById('etiqueta').innerHTML = response;


    });
}
function soloNumeros(e) {
    var key = window.Event ? e.which : e.keyCode
    return (key >= 48 && key <= 57)
}
var et, nom, cant, area, prop, res, ub = "";

function validar() {
    $('.send').click(function () {
        et = $(this).parent().siblings('.etiqueta').text();
        nom = $(this).parent().siblings('.nombre').text();
        ub = $(this).parent().siblings('.ub').text();
        prop = $(this).parent().siblings('.prop').text();
        res = $(this).parent().siblings('.res').text();
        cant = $('#can').val();
        area = $('#area').val();
        if (cant != "" && nom != "" && area != null && ub != "" && res != "" && prop != "") {
            document.getElementById('id02').style.display = 'block';
            document.getElementById('et').innerHTML = et;
            document.getElementById('nomBR').innerHTML = nom;
            document.getElementById('cant').innerHTML = cant;
            document.getElementById('col').innerHTML = colegio;
            document.getElementById('ub').innerHTML = ub;
            document.getElementById('prop').innerHTML = prop;
            document.getElementById('res').innerHTML = res;
            document.getElementById('areaB').innerHTML = area;
        } else {
            document.getElementById('id01').style.display = 'block';
        }

    });
}
function Ingresar() {
    var parametros = {
        "valor0": et,
        "valor1": nom,
        "valor2": cant,
        "valor3": ub,
        "valor4": prop,
        "valor5": res,
        "valor6": area,
        "valor7": colegio
    };

    $.ajax({
        data: parametros,
        url: "../Ingresar",
        type: "POST"

    }).done(function (data) {
        console.log(data);
        if (data == false) {
            alert("Elemento Ingresado satisfactoriamente");
            window.location.href = "IngresarInv.html";
        }

    });
}
    