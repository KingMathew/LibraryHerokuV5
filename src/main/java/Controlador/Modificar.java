package Controlador;


import TX.SQLgen;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.sql.SQLException;

public class Modificar extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SQLgen sqLgen = new SQLgen();
            String et = request.getParameter("et");
            boolean resp = true;
            resp = sqLgen.borrar2(Integer.valueOf(et));
            String json = new Gson().toJson(resp);
            response.setContentType("application/json");
            response.getWriter().write(json);

        } catch (URISyntaxException ex) {
            Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SQLgen sqLgen = new SQLgen();
            String et = request.getParameter("et");
            String cantidad = request.getParameter("cant");
            String ubicacion = request.getParameter("ub");
            String res = request.getParameter("res");
            System.out.println(et + cantidad + ubicacion + res + "----------------------");
            boolean resp = true;
            resp = sqLgen.modificar(Integer.valueOf(et), Integer.valueOf(cantidad), ubicacion, res);
            String json = new Gson().toJson(resp);
            response.setContentType("application/json");
            response.getWriter().write(json);

        } catch (URISyntaxException ex) {
            Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Modificar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
