<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <title>Mi Perfil</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../CSS/estilo1.css">
    <link rel="stylesheet" href="../CSS/estilo2.css">
    <link rel="stylesheet" href="../CSS/estilo3.css">      
    <link rel="shortcut icon" href="https://kingmathew.000webhostapp.com/images/icono.png">
    <script type="text/javascript" src="../scripts/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../scripts/scriptHome.js"></script>
    <script type="text/javascript" src="../scripts/scriptPerfil.js"></script>
    <script>
        window.setTimeout("document.getElementById('contenedor_carga').style.display='none';", 1500);
    </script>
    <body>
        <div id="contenedor_carga">
            <img src="../Images/titulo1.png" alt="Not-Found">
            <div id="carga"></div>
            <div class="tag">
                <p>Cargando...</p>
            </div>
        </div>
        <nav class="w3-sidebar w3-bar-block w3-card w3-top w3-xlarge w3-animate-left" style="display:none;z-index:2;width:25%;min-width:300px" id="mySidebar">
            <a href="perfil.jsp"><img src="" id="imageUser" class="mid" alt="NF"></a>
            <p id="nombre" class="w3-bar-item"></p>            
            <a class="w3-bar-item w3-button w3-theme-dark" href="homeUser.jsp" onclick="w3_close()">Home</a>
            <a class="w3-bar-item w3-button" href="Listados.jsp" onclick="w3_close()">Inventario Disponible</a>
            <a class="w3-bar-item w3-button" href="reservas.jsp" onclick="w3_close()">Reservar</a>
            <a class="w3-bar-item w3-button" href="historialReservas.jsp" onclick="w3_close()">Historial Reservas</a>
            <a class="w3-bar-item w3-button" href="historialPrestamos.jsp" onclick="w3_close()">Historial Prestamos</a>
            <a class="w3-bar-item w3-button" href="Busquedas.jsp" onclick="w3_close()">Busquedas</a>
        </nav>       
        <div class="w3-container myTop">
            <div class="w3-white w3-xlarge w3-border-bottom">
                <div class="w3-button w3-padding-16 w3-left" title="Menú" onclick="w3_open()"><i class="fa fa-bars"></i></div>
                <div class="w3-button w3-right w3-padding-16" title="Cerrar Sesión" onclick="closeSesion()"><i class="fa fa-power-off"></i></div>
                <div class="w3-center w3-padding-16">Mi Perfil</div>
            </div>
        </div>        
        <div class="w3-main w3-content w3-padding" id="container" style="max-width:1200px;margin-top:100px">
            <div class="w3-content" id="main">
                <div class="w3-card-4 w3-round w3-dark-grey">
                    <br>
                    <br>
                    <p class="w3-center"><img src="" id="imageUser2" alt="NotFound"></p>
                    <br>
                    <br>
                    <div class="w3-row">
                        <div class="w3-col w3-container" style="width:70%; padding-left: 40px;">
                            <p class="w3-xlarge"><i class="material-icons">mood</i> Nombre: <a id="2"></a></p>
                            <p class="w3-xlarge"><i class="material-icons">fingerprint</i> ID: <a id="1"></a></p>                            
                            <p class="w3-xlarge"><i class="material-icons">school</i> Colegio: <a id="3"></a></p>
                            <p class="w3-xlarge"><i class="material-icons">person</i> Tipo de Usuario: <a id="4"></a></p>
                            <p class="w3-xlarge"><i class="material-icons">business_center</i> Cargo: <a id="5"></a></p>
                        </div>
                        <div class="w3-rest w3-container">
                            <p class="w3-padding-16 w3-center"><button onclick="document.getElementById('changePass').style.display = 'block'" class="w3-button w3-white">Cambiar Clave</button></p>
                            <p class="w3-padding-16 w3-center"><button onclick="document.getElementById('changeImage').style.display = 'block'" class="w3-button w3-white">Cambiar Foto</button></p>
                        </div>
                    </div>
                    <br>
                    <br>
                </div>
            </div>

        </div>
        <div class="w3-container w3-white w3-border-top b">
            <div class="w3-center w3-padding w3-xlarge w3-white">
                <a href="#" id="face"><i class="fa fa-facebook"></i></a>
                <a href="#" id="tw"><i class="fa fa-twitter"></i></a>
                <a href="#" id="gp"><i class="fa fa-google-plus"></i></a>
                <a href="#" id="you"><i class="fa fa-youtube"></i></a>                
            </div>
        </div>

        <div id="changePass" class="w3-modal">
            <div style="width: 30%" class="w3-modal-content w3-animate-zoom">
                <div class="w3-container w3-black">
                    <span onclick="document.getElementById('changePass').style.display = 'none'" class="w3-button w3-display-topright w3-large">x</span>
                    <h1>Cambiar ContraseÃ±a</h1>
                </div>
                <div class="w3-container">
                    <p class="pading"><input id="campo1" class="w3-input w3-padding-16 w3-border" type="password" placeholder="ContraseÃ±a Antigua" required></p>
                    <p class="pading"><input id="pwd1" class="w3-input w3-padding-16 w3-border" type="password" placeholder="ContraseÃ±a Nueva" required></p>
                    <p class="pading"><input id="pwd2" class="w3-input w3-padding-16 w3-border" type="password" placeholder="Repita ContraseÃ±a" required></p>
                    <p class="pading"><button style="margin-left: 20%; width: 60%" class="w3-button w3-black w3-round-xlarge" type="submit" onclick="changePassword();">CAMBIAR</button></p>
                    <div id="divPass" class="divcito">
                        <h3 style="text-align: center; margin: 0 auto">Condiciones:</h3>
                        <p style="text-align: center" id="letter" class="invalid">Al menos una <b>letra minÃºscula</b></p>
                        <p style="text-align: center" id="capital" class="invalid">Al menos una <b>lera mayÃºscula</b></p>
                        <p style="text-align: center" id="number" class="invalid">Al menos un <b>nÃºmero</b></p>
                        <p style="text-align: center" id="length" class="invalid">MÃ­nimo <b>8 caracteres</b></p>
                        <p style="text-align: center" id="coin" class="invalid">Las claves <b>deben coincidir</b></p>
                    </div>
                    <br>
                    <br>
                </div>                
            </div>
        </div>
        <div id="changeImage" class="w3-modal">
            <div style="width: 30%" class="w3-modal-content w3-animate-zoom">
                <div class="w3-container w3-black">
                    <span onclick="document.getElementById('changeImage').style.display = 'none'" class="w3-button w3-display-topright w3-large">x</span>
                    <h1>Cambiar imagen</h1>
                </div>
                <div class="w3-container">
                    <form method="POST" id="myForm" enctype="multipart/form-data">
                        <input style="margin: 10px; display: inline-block; padding: 8px 18px 10px; text-transform: uppercase;" type="file" name="archivo" size="50">
                        <br>
                        <input style="margin-left: 20%; width: 60%" class="w3-button w3-black w3-round-xlarge" type="submit" value="SUBIR ARCHIVO">
                    </form>
                    <br>
                </div>                
            </div>
        </div>
        <%
            String usuario = (String) session.getAttribute("user");
            if (usuario == null) {
                response.sendRedirect("../index.jsp");
            }

        %>

    </body>

</html>

