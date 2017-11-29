package Controlador;

import DAO.DaoUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmacionCorreo extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public ConfirmacionCorreo() {
        super();
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String usu = request.getParameter("usuario");
            String ale = request.getParameter("aleatorio");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();

            String u = (String) request.getSession().getAttribute("identificador");
            String aleatorio = (String) request.getSession().getAttribute("cadena");
            try {
                if (usu.equals(u)) {
                    if (ale.equals(aleatorio)) {
                        out.println("<!DOCTYPE html>\n"
                                + "<html>\n"
                                + "    <title>Library-Soft</title>\n"
                                + "    <meta charset=\"UTF-8\">\n"
                                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                                + "    <link rel=\"stylesheet\" href=\"https://www.w3schools.com/w3css/4/w3.css\">\n"
                                + "    <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Raleway\">\n"
                                + "    <link rel=\"stylesheet\" href=\"CSS/estilo1.css\">\n"
                                + "    <link rel=\"shortcut icon\" href=\"https://kingmathew.000webhostapp.com/images/icono.png\">\n"
                                + "    <script type=\"text/javascript\" src=\"scripts/jquery-3.2.1.min.js\"></script>  \n"
                                + "    <script type=\"text/javascript\" src=\"scripts/scriptIndex.js\"></script> \n"
                                + "    <script>window.onload = function () {document.getElementById('log-in').style.display = 'block'}</script> \n"
                                + "    <body>\n"
                                + "        <div id=\"contenedor_carga\">\n"
                                + "            <img src=\"Images/titulo1.png\" alt=\"Not-Found\">\n"
                                + "            <div id=\"carga\"></div>\n"
                                + "            <div class=\"tag\">\n"
                                + "                <p>Cargando...</p>\n"
                                + "            </div>\n"
                                + "        </div>\n"
                                + "\n"
                                + "        <div class=\"bgimg w3-display-container w3-text-white\">\n"
                                + "            <div class=\"w3-display-middle w3-jumbo\">\n"
                                + "                <img id=\"image\" src=\"Images/titulo2.png\" alt=\"NF\">\n"
                                + "            </div>\n"
                                + "            <div class=\"w3-display-topleft w3-container w3-xlarge\">\n"
                                + "                <p><button onclick=\"document.getElementById('log-in').style.display = 'block'\" class=\"w3-button w3-white\">Log-in</button></p>\n"
                                + "                <p><button onclick=\"document.getElementById('sign-in').style.display = 'block'\" class=\"w3-button w3-white\">Sign-in</button></p>\n"
                                + "            </div>\n"
                                + "            <div class=\"w3-display-bottomleft w3-container\">\n"
                                + "                <p class=\"w3-xlarge\">www.librarysoft.com.co</p>\n"
                                + "                <p class=\"w3-large\">librarysoftcol@gmail.com</p>\n"
                                + "                <p>All rights reserved ®</p>\n"
                                + "            </div>\n"
                                + "        </div>\n"
                                + "\n"
                                + "        <!-- Log-in -->\n"
                                + "        <div id=\"log-in\" class=\"w3-modal\">\n"
                                + "            <div style=\"width: 30%\" class=\"w3-modal-content w3-animate-zoom\">\n"
                                + "                <div class=\"w3-container w3-black\">\n"
                                + "                    <span onclick=\"document.getElementById('log-in').style.display = 'none'\" class=\"w3-button w3-display-topright w3-large\">x</span>\n"
                                + "                    <h1>Log-in</h1>\n"
                                + "                </div>\n"
                                + "                <div class=\"w3-container\">\n"
                                + "                    <p><input id=\"campo1\" style=\"text-align: center; margin-left: 15%; width: 70%\" class=\"w3-input w3-padding-16 w3-border\" type=\"text\" placeholder=\"Usuario\" required></p>\n"
                                + "                    <p><input id=\"campo2\" style=\"text-align: center; margin-left: 15%; width: 70%\" onKeyDown=\"if (event.keyCode == 13)\n"
                                + "                                iniciarSesion();\" class=\"w3-input w3-padding-16 w3-border\" type=\"password\" placeholder=\"Contraseña\" required></p>                        \n"
                                + "                    <p><button style=\"margin-left: 20%; width: 60%\" class=\"w3-button w3-black w3-round-xlarge\" type=\"submit\" onclick=\"iniciarSesion();\">INGRESAR</button></p>\n"
                                + "                </div>\n"
                                + "            </div>\n"
                                + "        </div>\n"
                                + "\n"
                                + "        <!-- Sign-in -->\n"
                                + "        <div id=\"sign-in\" class=\"w3-modal\">\n"
                                + "            <div style=\"width: 30%\" class=\"w3-modal-content w3-animate-zoom\">\n"
                                + "                <div class=\"w3-container w3-black\">\n"
                                + "                    <span onclick=\"document.getElementById('sign-in').style.display = 'none'\" class=\"w3-button w3-display-topright w3-large\">x</span>\n"
                                + "                    <h1>Sign-in</h1>\n"
                                + "                </div>\n"
                                + "                <div class=\"w3-container\">\n"
                                + "                    <p>\n"
                                + "                        <select style=\"text-align: center; margin-left: 15%; width: 70%;\" name=\"colegio\" id=\"colegio\" class=\"w3-select w3-padding-16 w3-border\">\n"
                                + "                            <option value=\"\" disabled selected>Colegio o Universidad</option>\n"
                                + "                            <option>Colegio 1</option>\n"
                                + "                            <option>Colegio 2</option>\n"
                                + "                        </select>\n"
                                + "                    </p>\n"
                                + "                    <p><input style=\"text-align: center; margin-left: 15%; width: 70%\" class=\"w3-input w3-padding-16 w3-border\" type=\"text\" name=\"identificador\" id=\"identificador\" placeholder=\"Numero de identificación\" required></p>\n"
                                + "                    <p><input style=\"text-align: center; margin-left: 15%; width: 70%\" class=\"w3-input w3-padding-16 w3-border\" type=\"password\" id=\"pwd1\" placeholder=\"Contraseña\" pattern=\"(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}\" required></p>\n"
                                + "                    <p><input style=\"text-align: center; margin-left: 15%; width: 70%\" class=\"w3-input w3-padding-16 w3-border\" name=\"pwd2\" id=\"pwd2\" type=\"password\" pattern=\"(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}\" placeholder=\"Repita Contraseña\" required></p>\n"
                                + "                    <p><input style=\"text-align: center; margin-left: 15%; width: 70%\" class=\"w3-input w3-padding-16 w3-border\" onKeyDown=\"if (event.keyCode == 13)\n"
                                + "                                validarRegistro();\" name=\"pwd3\" id=\"pwd3\" type=\"email\" placeholder=\"Correo\" required></p>\n"
                                + "                    <p><button style=\"margin-left: 20%; width: 60%\" class=\"w3-button w3-black w3-round-xlarge\" type=\"submit\" onclick=\"validarRegistro();\">REGISTRARSE</button></p>\n"
                                + "                    <div id=\"divPass\" class=\"divcito\">\n"
                                + "                        <h3 style=\"text-align: center; margin: 0 auto\">Condiciones:</h3>\n"
                                + "                        <p style=\"text-align: center\" id=\"letter\" class=\"invalid\">Al menos una <b>letra minúscula</b></p>\n"
                                + "                        <p style=\"text-align: center\" id=\"capital\" class=\"invalid\">Al menos una <b>lera mayúscula</b></p>\n"
                                + "                        <p style=\"text-align: center\" id=\"number\" class=\"invalid\">Al menos un <b>número</b></p>\n"
                                + "                        <p style=\"text-align: center\" id=\"length\" class=\"invalid\">Mínimo <b>8 caracteres</b></p>\n"
                                + "                        <p style=\"text-align: center\" id=\"coin\" class=\"invalid\">Las claves <b>deben coincidir</b></p>\n"
                                + "                    </div>\n"
                                + "                </div>\n"
                                + "            </div>\n"
                                + "        </div>\n"
                                + "\n"
                                + "    </body>\n"
                                + "</html>\n"
                                + "\n"
                                + "");
                        DaoUsuario usuario = new DaoUsuario();
                        usuario.modificarEstado(usu);
                    } else {
                        out.println("<h3>ERROR!</h3>");
                        out.println("<b>Lo sentimos no es el numero de registro</b>");
                    }
                } else {
                    out.println("<h3>ERROR!</h3>");
                    out.println("<b>No existe usuario</b>");
                }

            } catch (Exception e) {
            } finally {
                out.close();
            }

        } catch (Exception e) {
            System.out.println("error" + e);
        }

    }
}
