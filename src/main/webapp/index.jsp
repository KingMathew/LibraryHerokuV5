<%@page contentType="text/html" pageEncoding="UTF-8"%>       
<!DOCTYPE html>
<html>
    <title>Library-Soft</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="CSS/estilo1.css">
    <link rel="shortcut icon" href="https://kingmathew.000webhostapp.com/images/icono.png">
    <script type="text/javascript" src="scripts/jquery-3.2.1.min.js"></script>  
    <script type="text/javascript" src="scripts/scriptIndex.js"></script> 
    <body>
    <!--    <div id="contenedor_carga">
            <img src="Images/titulo1.png" alt="Not-Found">
            <div id="carga"></div>
            <div class="tag">
                <p>Cargando...</p>
            </div>
        </div>-->

        <div class="bgimg w3-display-container w3-text-white">
            <div class="w3-display-middle w3-jumbo">
                <img id="image" src="Images/titulo2.png" alt="NF">
            </div>
            <div class="w3-display-topleft w3-container w3-xlarge">
                <p><button onclick="document.getElementById('log-in').style.display = 'block'" class="w3-button w3-white">Log-in</button></p>
                <p><button onclick="document.getElementById('sign-in').style.display = 'block'" class="w3-button w3-white">Sign-in</button></p>
            </div>
            <div class="w3-display-bottomleft w3-container">
                <p class="w3-xlarge">www.librarysoft.com.co</p>
                <p class="w3-large">librarysoftcol@gmail.com</p>
                <p>All rights reserved ®</p>
            </div>
        </div>

        <!-- Log-in -->
        <div id="log-in" class="w3-modal">
            <div style="width: 30%" class="w3-modal-content w3-animate-zoom">
                <div class="w3-container w3-black">
                    <span onclick="document.getElementById('log-in').style.display = 'none'" class="w3-button w3-display-topright w3-large">x</span>
                    <h1>Log-in</h1>
                </div>
                <div class="w3-container">
                    <form action="Inicio" method="POST">
                        <p><input name="campo1" style="text-align: center; margin-left: 15%; width: 70%" class="w3-input w3-padding-16 w3-border" type="text" placeholder="Usuario" required></p>
                        <p><input name="campo2" style="text-align: center; margin-left: 15%; width: 70%" class="submit_on_enter w3-input w3-padding-16 w3-border" type="password" placeholder="Contraseña" required></p>                        
                        <p><button style="margin-left: 20%; width: 60%" class="w3-button w3-black w3-round-xlarge" type="submit">INGRESAR</button></p>
                    </form>
                </div>
            </div>
        </div>

        <!-- Sign-in -->
        <div id="sign-in" class="w3-modal">
            <div style="width: 30%" class="w3-modal-content w3-animate-zoom">
                <div class="w3-container w3-black">
                    <span onclick="document.getElementById('sign-in').style.display = 'none'" class="w3-button w3-display-topright w3-large">x</span>
                    <h1>Sign-in</h1>
                </div>
                <div class="w3-container">
                    <p>
                        <select style="text-align: center; margin-left: 15%; width: 70%;" name="colegio" id="colegio" class="w3-select w3-padding-16 w3-border">
                            <option value="" disabled selected>Colegio o Universidad</option>
                            <option>Colegio 1</option>
                            <option>Colegio 2</option>
                        </select>
                    </p>
                    <p><input style="text-align: center; margin-left: 15%; width: 70%" class="w3-input w3-padding-16 w3-border" type="text" name="identificador" id="identificador" placeholder="Numero de identificación" required></p>
                    <p><input style="text-align: center; margin-left: 15%; width: 70%" class="w3-input w3-padding-16 w3-border" type="password" id="pwd1" placeholder="Contraseña" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required></p>
                    <p><input style="text-align: center; margin-left: 15%; width: 70%" class="w3-input w3-padding-16 w3-border" name="pwd2" id="pwd2" type="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" placeholder="Repita Contraseña" required></p>
                    <p><input style="text-align: center; margin-left: 15%; width: 70%" class="w3-input w3-padding-16 w3-border" onKeyDown="if (event.keyCode == 13)
                                validarRegistro();" name="pwd3" id="pwd3" type="email" placeholder="Correo" required></p>
                    <p><button style="margin-left: 20%; width: 60%" class="w3-button w3-black w3-round-xlarge" type="submit" onclick="validarRegistro();">REGISTRARSE</button></p>
                    <div id="divPass" class="divcito">
                        <h3 style="text-align: center; margin: 0 auto">Condiciones:</h3>
                        <p style="text-align: center" id="letter" class="invalid">Al menos una <b>letra minúscula</b></p>
                        <p style="text-align: center" id="capital" class="invalid">Al menos una <b>lera mayúscula</b></p>
                        <p style="text-align: center" id="number" class="invalid">Al menos un <b>número</b></p>
                        <p style="text-align: center" id="length" class="invalid">Mínimo <b>8 caracteres</b></p>
                        <p style="text-align: center" id="coin" class="invalid">Las claves <b>deben coincidir</b></p>
                    </div>
                </div>
            </div>
        </div>
        <%
            if (request.getAttribute("Fail") != null) {
                String respuesta = (String) request.getAttribute("Fail");
                if (respuesta.equals("NO")) {
        %>
        <script>
            alert("USUARIO Y/O CONTRASEÑA INCORRECTOS.");
        </script>

        <%      } }
        %>
    </body>
</html>


