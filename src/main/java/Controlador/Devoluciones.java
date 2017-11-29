package Controlador;

import Modelo.inventario;
import Modelo.prestamo;
import Modelo.usuarios;
import TX.SQLgen;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Devoluciones extends HttpServlet {
    
    public String identificador;
    public String cantidadDev;
    public String etiquetaInv;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String nombre = new String(request.getParameter("nombre").getBytes("ISO-8859-1"),"UTF-8");
            String nombre2 = new String(request.getParameter("nombreE").getBytes("ISO-8859-1"),"UTF-8");
            ArrayList<prestamo> arr = new ArrayList<prestamo>();
            prestamo pr = new prestamo();
            SQLgen sqLgen = new SQLgen();
            usuarios user = new usuarios();
            inventario inv = new inventario();
            user = sqLgen.getIdUser(nombre);
            inv = sqLgen.getIdInv(nombre2);
            identificador = user.getidentificador();
            etiquetaInv = inv.getetiqueta();
            prestamo prestamo = new prestamo(etiquetaInv, identificador, null, null, null, null);
            arr = sqLgen.Select2(prestamo);
            cantidadDev = arr.get(0).cantidadPrestamo;                     
            String json = new Gson().toJson(arr.get(0));
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Devoluciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Devoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SQLgen sqLgen = new SQLgen();
            int a = 0;
            a = sqLgen.cambiarEstado(identificador, etiquetaInv, cantidadDev);
            String json = new Gson().toJson(a);
            response.setContentType("application/json");
            response.getWriter().write(json);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Devoluciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Devoluciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
