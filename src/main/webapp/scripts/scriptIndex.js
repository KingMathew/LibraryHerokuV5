window.setTimeout("document.getElementById('contenedor_carga').style.display='none';", 1500);
window.onload = function () {
    $('.submit_on_enter').keydown(function (event) {
        if (event.keyCode == 13) {
            this.form.submit();
            return false;
        }
    });
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

function validarRegistro() {
    var myInput = document.getElementById("pwd1");
    var pass2 = document.getElementById("pwd2");
    var identificador = document.getElementById("identificador");
    var colegio = document.getElementById("colegio");
    var correo = document.getElementById("pwd3");

    var lowerCaseLetters = /[a-z]/g;
    var upperCaseLetters = /[A-Z]/g;
    var numbers = /[0-9]/g;
    var emailValues = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if ((identificador.value != "") && (colegio.value != "") && (myInput.value != "") && (pass2.value != "") && (correo.value != "")) {
        if (myInput.value.match(lowerCaseLetters)) {
            if (myInput.value.match(upperCaseLetters)) {
                if (myInput.value.match(numbers)) {
                    if (myInput.value.length >= 8) {
                        if (correo.value.match(emailValues)) {
                            if (myInput.value == pass2.value) {

                                var parametros = {
                                    "identificador": identificador.value,
                                    "colegio": colegio.value,
                                    "pwd2": pass2.value,
                                    "pwd3": correo.value

                                };
                                $.ajax({
                                    data: parametros,
                                    url: "Registro",
                                    type: "POST"

                                }).done(function (response) {
                                    console.log(response);
                                    if (response == true) {
                                        alert("Usuario registrado satisfactoriamente, por favor verifique su correo para terminar el registro ☺ ");
                                    } else {
                                        alert("Las credenciales no son correctas.");
                                        alert("Usted no se encuentra asociado a esta institución o no está registrado en nuestra base de datos.");
                                    }
                                });

                            } else {
                                alert("Las claves no coinciden");
                            }
                        } else {
                            alert("Ingrese un correo electrónico válido");
                        }
                    } else {
                        alert("La clave debe tener mínimo 8 carácteres");
                    }
                } else {
                    alert("La clave debe contener al menos un número");
                }
            } else {
                alert("La clave debe contener al menos una letra mayúscula");
            }
        } else {
            alert("La clave debe contener al menos una letra minúscula");
        }
    } else {
        alert("Debe llenar los campos solicitados para poder registrarse");
    }
}