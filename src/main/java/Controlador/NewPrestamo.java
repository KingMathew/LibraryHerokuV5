package Controlador;

import DAO.DaoPrestamos;
import Modelo.prestamo;
import Modelo.usuarios;
import TX.SQLgen;
import com.google.gson.Gson;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewPrestamo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            java.util.Date utilDate = new java.util.Date();
            long lnMilisegundos = utilDate.getTime();

            java.sql.Date sqlDate = new java.sql.Date(lnMilisegundos);
            String idsol = request.getParameter("idSol");
            String idlibro = request.getParameter("idElm");
            String cantidad = request.getParameter("cantidad");
            String fechadev = request.getParameter("fechaRes");

            SQLgen sql = new SQLgen();
            usuarios user = new usuarios(idsol);
            ArrayList<usuarios> arr = new ArrayList<usuarios>();
            arr = sql.Select5(user);
            if (arr.size() == 0) {
                String json = new Gson().toJson("NOT-FOUND");
                response.setContentType("application/json");
                response.getWriter().write(json);
            } else {
                DaoPrestamos pretamos = new DaoPrestamos();
                prestamo prestamo = new prestamo();
                prestamo.setetiquetaInv(idlibro);
                prestamo.setcantidadPrestamo(cantidad);
                prestamo.setfechaDev(fechadev);
                prestamo.setfechaActual(sqlDate.toString());
                prestamo.setestado("prestado");
                prestamo.setidentificadorSol(idsol);
                boolean respuesta = false;
                respuesta = pretamos.insertar(prestamo);
                String json = new Gson().toJson(respuesta);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Reservas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(NewPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NewPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(NewPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(NewPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(NewPrestamo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
