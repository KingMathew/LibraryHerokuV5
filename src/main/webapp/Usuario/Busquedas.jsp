<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
    <title>Busqueda</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../CSS/estilo1.css">
    <link rel="stylesheet" href="../CSS/estilo2.css">
    <link rel="stylesheet" href="../CSS/estilo3.css">
    <link rel="shortcut icon" href="https://kingmathew.000webhostapp.com/images/icono.png">
    <script type="text/javascript" src="../scripts/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../scripts/scriptHome.js"></script>
    <script type="text/javascript" src="../scripts/scriptBuscar.js"></script>
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
                <div class="w3-center w3-padding-16">Busqueda</div>
            </div>
        </div>        
        <div class="w3-main w3-content w3-padding" id="container" style="max-width:1200px;margin-top:100px">
            <div class="w3-content" id="main">

                <div class="w3-padding-16">
                    <input id="Busqueda"  onkeyup="Buscar()" class="w3-input w3-border" type="text" style="width: 70%; margin-left: 15%; text-align: center;"  placeholder="Busca en el inventario">
                </div>
                <table class="w3-table-all w3-hoverable" id="tablaPrest">                    
                    <tr class="w3-black">
                        <th>Etiqueta</th>
                        <th>Nombre</th>
                        <th>CantidadDisponible</th>
                        <th>Ubicacion</th>
                        <th>Propiedad</th>
                        <th>Responsable</th> 
                        <th>Area</th>
                        <th>Colegio</th>
                    </tr>
                </table>
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
        <%
            String usuario = (String) session.getAttribute("user");
            if (usuario == null) {
                response.sendRedirect("../index.jsp");
            }

        %>

    </body>

</html>
