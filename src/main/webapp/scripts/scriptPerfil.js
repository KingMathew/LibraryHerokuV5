window.onload = function () {
    mostrarPerfil();
    document.getElementById("divPass").style.display = "none";
    $("#pwd1").focus(function () {
        document.getElementById("divPass").style.display = "block";
    });
    $("#pwd1").blur(function () {
        document.getElementById("divPass").style.display = "none";
    });
    $("#pwd2").focus(function () {
        document.getElementById("divPass").style.display = "block";
    });
    $("#pwd2").blur(function () {
        document.getElementById("divPass").style.display = "none";
    });

    $("#pwd1").keyup(function () {
        var myInput = document.getElementById("pwd1");
        var letter = document.getElementById("letter");
        var capital = document.getElementById("capital");
        var number = document.getElementById("number");
        var length = document.getElementById("length");
        // Validate lowercase letters
        var lowerCaseLetters = /[a-z]/g;
        if (myInput.value.match(lowerCaseLetters)) {
            letter.classList.remove("invalid");
            letter.classList.add("valid");
        } else {
            letter.classList.remove("valid");
            letter.classList.add("invalid");
        }

        // Validate capital letters
        var upperCaseLetters = /[A-Z]/g;
        if (myInput.value.match(upperCaseLetters)) {
            capital.classList.remove("invalid");
            capital.classList.add("valid");
        } else {
            capital.classList.remove("valid");
            capital.classList.add("invalid");
        }

        // Validate numbers
        var numbers = /[0-9]/g;
        if (myInput.value.match(numbers)) {
            number.classList.remove("invalid");
            number.classList.add("valid");
        } else {
            number.classList.remove("valid");
            number.classList.add("invalid");
        }

        // Validate length
        if (myInput.value.length >= 8) {
            length.classList.remove("invalid");
            length.classList.add("valid");
        } else {
            length.classList.remove("valid");
            length.classList.add("invalid");
        }

    });

    $("#pwd2").keyup(function () {
        var myInput = document.getElementById("pwd1");
        var pass2 = document.getElementById("pwd2");
        var con = document.getElementById("coin");

        //validate coincidence
        if (myInput.value == pass2.value) {
            con.classList.remove("invalid");
            con.classList.add("valid");
        } else {
            con.classList.remove("valid");
            con.classList.add("invalid");
        }
    });

};

var clave;
function mostrarPerfil() {
    $.ajax({
        url: "../Sesion",
        type: "GET"

    }).done(function (response) {
        document.getElementById('1').innerHTML = response.identificador;
        document.getElementById('2').innerHTML = response.nombreSol;
        document.getElementById('3').innerHTML = response.colegio;
        document.getElementById('4').innerHTML = response.tipo;
        document.getElementById('5').innerHTML = response.cursoArea;
        clave = response.clave;
        var imagen = document.getElementById("imageUser2");
        imagen.src = response.imagen;

    });

}
function changePassword() {

    if (($('#campo1').val() != "") && ($('#pwd1').val() != "") && ($('#pwd2').val() != "")) {
        if (clave == $('#campo1').val()) {
            if (clave != $('pwd2').val()) {
                var parametros = {
                    "valor1": $('#campo1').val(),
                    "valor2": $('#pwd1').val(),
                    "valor3": $('#pwd2').val()
                };

                $.ajax({
                    data: parametros,
                    url: "../changePassword",
                    type: "POST"

                }).done(function (data) {
                    console.log(data);
                    var usuario = data[0];
                    var newPass = data[1];
                    updateSession(usuario, newPass);
                    alert("Clave cambiada satisfactoriamente");
                    window.location.href = "perfil.html";
                });
            } else {
                alert("La nueva contraseña debe ser diferente a la contraseña antigua");
            }
        } else {
            alert("La clave antigua no coincide.");
        }
    } else {
        alert("Debe llenar los campos para poder cambiar la contraseña.");
    }


}
function updateSession(usuario, clave) {

    var parametros = {
        "valor1": usuario,
        "valor2": clave
    };


    $.ajax({
        data: parametros,
        url: "../Inicio",
        type: "POST"

    }).done(function (data) {
        console.log(data);
    });
}

$(function () {
    $("#myForm").on("submit", function (e) {
        e.preventDefault();
        var f = $(this);
        var formData = new FormData(document.getElementById("myForm"));
        formData.append("dato", "valor");
        $.ajax({
            url: "https://kingmathew.000webhostapp.com/ftpfunc.php",
            type: "POST",
            dataType: "html",
            data: formData,
            cache: false,
            contentType: false,
            processData: false
        }).done(function (res) {
            console.log(res);
            actualizarRuta(res);

        });
    });
});

function actualizarRuta(ruta) {

    var parametros = {
        "valor1": ruta
    };
    $.ajax({
        data: parametros,
        url: "../uploadServlet",
        type: "POST"

    }).done(function (data) {
        console.log(data);
        location.reload(true);
    });

}






