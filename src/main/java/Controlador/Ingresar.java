/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.inventario;
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

public class Ingresar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            SQLgen s = new SQLgen();            
            boolean respuesta;            
            String et = request.getParameter("valor0");
            String nombre = request.getParameter("valor1");
            String cantidad = request.getParameter("valor2");
            String ubicacion = request.getParameter("valor3");
            String propiedad = request.getParameter("valor4");
            String responsable = request.getParameter("valor5");
            String area = request.getParameter("valor6");
            String colegio = request.getParameter("valor7");            
            inventario inv = new inventario(et, nombre, cantidad, ubicacion, propiedad, responsable, area, colegio);
            respuesta = s.insertar(inv);
            String json = new Gson().toJson(respuesta);
            response.setContentType("application/json");
            response.getWriter().write(json);

        } catch (URISyntaxException ex) {
            Logger.getLogger(Ingresar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ingresar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Ingresar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ingresar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            SQLgen s = new SQLgen();
            int num = 0;
            num = s.getNextEtiqueta();
            int etiqueta = num + 1;           
            String json = new Gson().toJson(etiqueta);
            response.setContentType("application/json");
            response.getWriter().write(json);

        } catch (URISyntaxException ex) {
            Logger.getLogger(Ingresar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Ingresar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Ingresar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
