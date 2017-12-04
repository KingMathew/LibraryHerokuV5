package Controlador;

import DAO.DaoUsuario;
import Modelo.usuarios;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;

public class Inicio extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String identificador = request.getParameter("campo1");
            String clave = request.getParameter("campo2");
            
            usuarios user = new usuarios();
            DaoUsuario daoU = new DaoUsuario();
            user = daoU.validarUsuario(identificador, clave).get(0);
            if (user.getidentificador() != null) {
                if (user.getidentificador().equals(identificador)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", identificador);
                    session.setAttribute("pass", clave);
                    if (user.gettipo().equals("Directivo") || user.gettipo().equals("Administrativo")) {
                        response.sendRedirect(request.getContextPath()+"/Admin/homeAdmin.jsp");
                        
                    } else {
                        response.sendRedirect(request.getContextPath()+"/Usuario/homeUser.jsp");
                    }
                }
            } else {
                request.setAttribute("Fail", "NO");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
        }    

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       

    }
}
