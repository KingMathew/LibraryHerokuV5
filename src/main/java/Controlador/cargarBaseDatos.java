package Controlador;

import Modelo.usuarios;
import TX.SQLgen;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class cargarBaseDatos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name2 = request.getParameter("a");
            JSONArray arr = new JSONArray(name2);
            int respuesta = 0;
            for (int i = 0; i < arr.length(); ++i) {
                JSONObject person = arr.getJSONObject(i);
                String id, nombre, tipo, cursoArea, colegio, clave, imagen, correo, estado = "";
                id = person.getString("Identificador");
                nombre = person.getString("Nombre");
                tipo = person.getString("Tipo");
                cursoArea = person.getString("cursoArea");
                colegio = person.getString("Colegio");
                clave = person.getString("Clave");
                imagen = person.getString("Imagen");
                correo = person.getString("Correo");
                estado = person.getString("Estado");
                usuarios user = new usuarios(id, nombre, tipo, cursoArea, colegio, clave, imagen, correo, estado);
                SQLgen sql = new SQLgen();
                respuesta = sql.insertarFull(user);
            }
            String json = new Gson().toJson(respuesta);
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (JSONException ex) {
            Logger.getLogger(cargarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(cargarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cargarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(cargarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(cargarBaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
