package Controlador;

import DAO.DaoElementos;
import Modelo.inventario;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class ListarPorArea extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            ArrayList<inventario> lista = null;
            DaoElementos daoE = new DaoElementos();
            String area = new String(request.getParameter("valor1").getBytes("ISO-8859-1"), "UTF-8");
            if (area.equals("Ciencias Naturales")) {
                lista = daoE.listarPorArea("Ciencias  Naturales");
                String json = new Gson().toJson(lista);
                response.setContentType("application/json");
                response.getWriter().write(json);
            } else {
                lista = daoE.listarPorArea(area);
                String json = new Gson().toJson(lista);
                response.setContentType("application/json");
                response.getWriter().write(json);
            }

        } catch (URISyntaxException ex) {
            Logger.getLogger(ListarPorArea.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ListarPorArea.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ListarPorArea.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ListarPorArea.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ListarPorArea.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
