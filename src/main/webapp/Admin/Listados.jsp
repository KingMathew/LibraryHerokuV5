<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>Inventario</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../CSS/estilo1.css">
    <link rel="stylesheet" href="../CSS/estilo2.css">    
    <link rel="shortcut icon" href="https://kingmathew.000webhostapp.com/images/icono.png">
    <script type="text/javascript" src="../scripts/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="../scripts/scriptHome.js"></script>
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
            <a class="w3-bar-item w3-button w3-theme-dark" href="homeAdmin.jsp" onclick="w3_close()">Home</a>
            <a class="w3-bar-item w3-button" href="Listados.jsp" onclick="w3_close()">Inventario Disponible</a>
            <a class="w3-bar-item w3-button" href="IngresarInv.jsp" onclick="w3_close()">Ingresar Libro</a>
            <a class="w3-bar-item w3-button" href="Modificar.jsp" onclick="w3_close()">Modificar</a>
            <a class="w3-bar-item w3-button" href="Prestamos.jsp" onclick="w3_close()">Prestamos</a>
            <a class="w3-bar-item w3-button" href="Devoluciones.jsp" onclick="w3_close()">Devoluciones</a>
            <a class="w3-bar-item w3-button" href="reservas.jsp" onclick="w3_close()">Reservas Pendientes</a>
            <a class="w3-bar-item w3-button" href="historial.jsp" onclick="w3_close()">Historial</a>
            <a class="w3-bar-item w3-button" href="Busquedas.jsp" onclick="w3_close()">Busquedas</a>
            <a class="w3-bar-item w3-button" href="Estadisticas.jsp" onclick="w3_close()">Estadísticas</a>
            <a class="w3-bar-item w3-button" href="#" onclick="w3_close()">Convenios</a>
            <a class="w3-bar-item w3-button" href="CargarBaseDatos.jsp" onclick="w3_close()">Cargar base de datos</a>
        </nav>     
        <div class="w3-container myTop">
            <div class="w3-white w3-xlarge w3-border-bottom">
                <div class="w3-button w3-padding-16 w3-left" title="Menú" onclick="w3_open()"><i class="fa fa-bars"></i></div>
                <div class="w3-button w3-right w3-padding-16" title="Cerrar Sesión" onclick="closeSesion()"><i class="fa fa-power-off"></i></div>
                <div class="w3-center w3-padding-16">Inventario</div>
            </div>
        </div>        
        <div class="w3-main w3-content w3-padding" id="container" style="max-width:1200px;margin-top:100px">
            <div class="w3-content" id="main">
                <div class="w3-center">
                    <h1 class="heading">Inventario por Área</h1>
                    <select style="text-align: center; margin: 0 auto;" name="area" id="area" onchange="listarPorArea();">
                        <option value="" disabled selected>--Seleccione el Área--</option>
                        <option>Enciclopedia</option>
                        <option>Diccionarios</option>
                        <option>Español</option>
                        <option>Matemáticas</option>
                        <option>Física</option>
                        <option>Química</option>
                        <option>Sociales</option>
                        <option>Ingles</option>
                        <option>Ciencias Naturales</option>
                        <option>Preescolar</option>
                        <option>Filosofía</option>
                        <option>Religión</option>
                        <option>Ética y Valores</option>
                        <option>Informática</option>
                        <option>Atlas</option>
                        <option>Salud y Educación Sexual</option>
                        <option>Dibujo Técnico y Artística</option>
                        <option>Libros Institucionales</option>
                        <option>Material Didáctico</option>
                        <option>Videos - DVD- CD-ROOM</option>
                        <option>Equipo</option>
                    </select>                            
                </div>
                <br>
                <br>
                <table id="tablaMain" class="w3-table w3-bordered">
                    <tr class="w3-black">
                        <th>Etiqueta</th>
                        <th>Nombre</th>
                        <th>Cantidad Disponible</th>
                        <th>Ubicacion</th>
                        <th>Propiedad</th>
                        <th>Responsable</th> 
                        <th>Area</th>
                        <th>Colegio</th>
                    </tr>
                </table>
                <table class="w3-table-all w3-hoverable" id="tabla"></table>
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
