package TX;

import Modelo.inventario;
import Modelo.HistorialPrestamos;
import Modelo.reservasPendientes;
import Modelo.usuarios;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLgen<T> {

    private Connection conexion;

    public SQLgen() throws URISyntaxException, SQLException {
        conexion = Util.conexion.getConnection();
    }

    //insert into ... values 
    public boolean insertar(T p) throws IllegalArgumentException, IllegalAccessException {
        boolean rs = false;
        try {
            Field[] f = p.getClass().getDeclaredFields();
            String consulta = "insert into " + p.getClass().getSimpleName() + " values(" + "'";
            for (int i = 0; i < f.length; i++) {
                if (i == f.length - 1) {
                    consulta = consulta + f[i].get(p) + "'";
                } else {
                    consulta = consulta + f[i].get(p) + "'" + "," + "'";
                }

            }
            consulta = consulta + ")";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            rs = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rs;
    }
    public int insertarFull(T p) throws IllegalArgumentException, IllegalAccessException{
        int a=0;
        try {
            Field[] f = p.getClass().getDeclaredFields();
            String consulta = "insert into " + p.getClass().getSimpleName() + " values(" + "'";
            for (int i = 0; i < f.length; i++) {
                if (i == f.length - 1) {
                    consulta = consulta + f[i].get(p) + "'";
                } else {
                    consulta = consulta + f[i].get(p) + "'" + "," + "'";
                }

            }
            consulta = consulta + ")";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            a = statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return a;
    }

    //delete from where
    public boolean borrar(T p) {
        boolean retorno = false;
        Field[] f = p.getClass().getDeclaredFields();
        String query = "delelte from " + p.getClass().getSimpleName() + " where ";
        try {
            for (int i = 0; i < f.length; i++) {
                if (f[i].get(p) != null) {
                    query += f[i].getName() + " = '" + f[i].get(p) + "'";
                    break;
                }
            }
            System.out.println(query);
            PreparedStatement statement = this.conexion.prepareStatement(query);
            retorno = statement.execute();
        } catch (SQLException ex) {
            System.out.println("Failed to make update!");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    //select * from where
    public ArrayList<T> Select(T p) throws InvocationTargetException, NoSuchMethodException, InstantiationException {
        ArrayList<T> res = new ArrayList<T>();
        Field[] f = p.getClass().getDeclaredFields();
        String query = "select * from " + p.getClass().getSimpleName() + " where ";
        try {
            for (int i = 0; i < f.length; i++) {
                if (f[i].get(p) != null) {
                    query += f[i].getName() + " = '" + f[i].get(p) + "'";
                    break;
                }
            }
            query+=" order by etiqueta asc";
            System.out.println(query);
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                T f2 = (T) p.getClass().newInstance();
                Field[] f3 = f2.getClass().getDeclaredFields();
                for (int i = 0; i < f.length; i++) {
                    String methodName = "set" + f3[i].getName();
                    Method setNameMethod = f2.getClass().getMethod(methodName, String.class);
                    String r = rs.getString("" + f3[i].getName());
                    setNameMethod.invoke(f2, r);
                }
                res.add((T) f2);
            }
            st.close();
        } catch (SQLException ex) {
            System.out.println("Failed to make update!");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(res);
        return res;

    }
    public ArrayList<T> Select5(T p) throws InvocationTargetException, NoSuchMethodException, InstantiationException {
        ArrayList<T> res = new ArrayList<T>();
        Field[] f = p.getClass().getDeclaredFields();
        String query = "select * from " + p.getClass().getSimpleName() + " where ";
        try {
            for (int i = 0; i < f.length; i++) {
                if (f[i].get(p) != null) {
                    query += f[i].getName() + " = '" + f[i].get(p) + "'";
                    break;
                }
            }
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                T f2 = (T) p.getClass().newInstance();
                Field[] f3 = f2.getClass().getDeclaredFields();
                for (int i = 0; i < f.length; i++) {
                    String methodName = "set" + f3[i].getName();
                    Method setNameMethod = f2.getClass().getMethod(methodName, String.class);
                    String r = rs.getString("" + f3[i].getName());
                    setNameMethod.invoke(f2, r);
                }
                res.add((T) f2);
            }
            st.close();
        } catch (SQLException ex) {
            System.out.println("Failed to make update!");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(res);
        return res;

    }

    //select * from .... where .... = .... and ..... = .......
    public ArrayList<T> Select2(T p) {
        ArrayList<T> res = new ArrayList<T>();
        int contador = 0;
        Field[] f = p.getClass().getDeclaredFields();
        String query = "select * from " + p.getClass().getSimpleName() + " where ";
        try {
            for (int i = 0; i < f.length; i++) {
                if (contador == 0) {
                    if (f[i].get(p) != null) {
                        query += f[i].getName() + " = '" + f[i].get(p) + "'";

                    }
                } else {
                    if (f[i].get(p) != null) {
                        query += " and " + f[i].getName() + " = '" + f[i].get(p) + "'";

                    }
                }

                contador++;
            }
            System.out.println(query);
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                T f2 = p;
                Field[] f3 = f2.getClass().getDeclaredFields();
                for (int i = 0; i < f.length; i++) {
                    String r = rs.getString("" + f3[i].getName());
                    f3[i].set(f2, r);
                }
                res.add((T) f2);
            }
            st.close();
        } catch (SQLException ex) {
            System.out.println("Failed to make update!");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    //select * from .... where .... = .... and ..... = .......
    public boolean Select3(T p) {
        boolean res = false;
        int contador = 0;
        Field[] f = p.getClass().getDeclaredFields();
        String query = "select * from " + p.getClass().getSimpleName() + " where ";
        try {
            for (int i = 0; i < f.length; i++) {
                if (contador == 0) {
                    if (f[i].get(p) != null) {
                        query += f[i].getName() + " = '" + f[i].get(p) + "'";

                    }
                } else {
                    if (f[i].get(p) != null) {
                        query += " and " + f[i].getName() + " = '" + f[i].get(p) + "'";

                    }
                }

                contador++;
            }
            System.out.println(query);
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                res = true;
            }
            st.close();
        } catch (SQLException ex) {
            System.out.println("Failed to make update!");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public boolean update(T p) {
        boolean res = false;
        int contador = 0;
        Field[] f = p.getClass().getDeclaredFields();
        String query = "update " + p.getClass().getSimpleName() + " set ";
        try {
            for (int i = 0; i < f.length; i++) {
                if (contador == 0) {
                    if (f[i].get(p) != null) {
                        query += f[i].getName() + " = '" + f[i].get(p) + "'";

                    }
                } else {
                    if (f[i].get(p) != null) {
                        query += ", " + f[i].getName() + " = '" + f[i].get(p) + "'";

                    }
                }

                contador++;
            }
            query += " where " + f[0].getName() + " = '" + f[0].get(p) + "'";
            System.out.println(query);
            PreparedStatement statement = this.conexion.prepareStatement(query);
            res = statement.execute();
        } catch (SQLException ex) {
            System.out.println("Failed to make update!");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;

    }

    public ArrayList<T> Select4(T p) {
        ArrayList<T> res = new ArrayList<T>();
        Field[] f = p.getClass().getDeclaredFields();
        String query = "select * from " + p.getClass().getSimpleName()+" order by etiqueta asc";
        try {
            System.out.println(query);
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {
                T f2 = (T) p.getClass().newInstance();
                Field[] f3 = f2.getClass().getDeclaredFields();
                for (int i = 0; i < f.length; i++) {
                    String methodName = "set" + f3[i].getName();
                    Method setNameMethod = f2.getClass().getMethod(methodName, String.class);
                    String r = rs.getString("" + f3[i].getName());
                    setNameMethod.invoke(f2, r);
                }
                res.add((T) f2);
            }
            st.close();
        } catch (SQLException ex) {
            // TODO Auto-generated catch block
            System.out.println("Failed to make update!");
            ex.printStackTrace();
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
    }

    public ArrayList<inventario> cantidadPorArea() {
        ArrayList<inventario> arr = new ArrayList<inventario>();

        try {
            String consulta = "select area, sum(cast(cantidaddisponible as int)) as total from inventario GROUP BY area order by total desc";
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);

            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                inventario elm = new inventario();
                elm = new inventario();
                elm.setarea(resultado.getString("area"));
                elm.setcantidadDisponible(resultado.getString("total"));
                arr.add(elm);
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }

        return arr;
    }

    public int getNextEtiqueta() {
        int etM = 0;
        try {

            String query = "SELECT etiqueta FROM inventario ORDER BY etiqueta DESC LIMIT 1";
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                etM = Integer.valueOf(rs.getString("etiqueta"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(SQLgen.class.getName()).log(Level.SEVERE, null, ex);
        }
        return etM;
    }

    public ArrayList<HistorialPrestamos> listarHistorial() {
        //1.Consulta

        ArrayList<HistorialPrestamos> respuesta = new ArrayList();
        String consulta = "select usuarios.nombreSol, usuarios.cursoArea, inventario.nombre, prestamo.cantidadPrestamo,   prestamo.fechaActual, prestamo.fechaDev, prestamo.estado\n"
                + "from((inventario inner join prestamo on (inventario.etiqueta = prestamo.etiquetaInv)) inner join usuarios on (usuarios.identificador=prestamo.identificadorSol))";

        try {

            Statement statement = this.conexion.createStatement();

            ResultSet resultado
                    = statement.executeQuery(consulta);
            while (resultado.next()) {
                HistorialPrestamos pr = new HistorialPrestamos();

                pr.setNombreUsuario(resultado.getString("nombreSol"));
                pr.setCursoArea(resultado.getString("cursoArea"));
                pr.setNombreElemento(resultado.getString("nombre"));
                pr.setCantidadPrestamo(resultado.getInt("cantidadPrestamo"));
                pr.setFechaInicio(resultado.getString("fechaActual"));
                pr.setFechaDevolucion(resultado.getString("fechaDev"));
                pr.setEstadoPrestamo(resultado.getString("estado"));

                respuesta.add(pr);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

    public ArrayList<HistorialPrestamos> listarHistorialActivos() {
        //1.Consulta

        ArrayList<HistorialPrestamos> respuesta = new ArrayList();
        String consulta = "select usuarios.nombreSol, usuarios.cursoArea, inventario.nombre, prestamo.cantidadPrestamo,   prestamo.fechaActual, prestamo.fechaDev, prestamo.estado\n"
                + "from((inventario inner join prestamo on (inventario.etiqueta = prestamo.etiquetaInv)) inner join usuarios on (usuarios.identificador=prestamo.identificadorSol))"
                + " where prestamo.estado = 'prestado'";

        try {

            Statement statement = this.conexion.createStatement();

            ResultSet resultado
                    = statement.executeQuery(consulta);
            while (resultado.next()) {
                HistorialPrestamos pr = new HistorialPrestamos();

                pr.setNombreUsuario(resultado.getString("nombreSol"));
                pr.setCursoArea(resultado.getString("cursoArea"));
                pr.setNombreElemento(resultado.getString("nombre"));
                pr.setCantidadPrestamo(resultado.getInt("cantidadPrestamo"));
                pr.setFechaInicio(resultado.getString("fechaActual"));
                pr.setFechaDevolucion(resultado.getString("fechaDev"));
                pr.setEstadoPrestamo(resultado.getString("estado"));

                respuesta.add(pr);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

    public ArrayList<reservasPendientes> listarReservas() {
        //1.Consulta

        ArrayList<reservasPendientes> respuesta = new ArrayList();
        String consulta = "select usuarios.nombreSol, usuarios.cursoArea, inventario.nombre, reserva.cantidad,   reserva.fechaActual, reserva.fechaReserva, reserva.estado\n"
                + "from((inventario inner join reserva on (inventario.etiqueta = reserva.idElemento)) inner join usuarios on (usuarios.identificador=reserva.idSol))";

        try {

            Statement statement = this.conexion.createStatement();

            ResultSet resultado
                    = statement.executeQuery(consulta);
            while (resultado.next()) {
                reservasPendientes pr = new reservasPendientes();

                pr.setNombreSol(resultado.getString("nombreSol"));
                pr.setCursoArea(resultado.getString("cursoArea"));
                pr.setNombre(resultado.getString("nombre"));
                pr.setCantidad(resultado.getInt("cantidad"));
                pr.setFechaActual(resultado.getString("fechaActual"));
                pr.setFechaReserva(resultado.getString("fechaReserva"));
                pr.setEstado(resultado.getString("estado"));

                respuesta.add(pr);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }
    public ArrayList<reservasPendientes> listarReservas2(String id) {
        //1.Consulta

        ArrayList<reservasPendientes> respuesta = new ArrayList();
        String consulta = "select usuarios.nombreSol, usuarios.cursoArea, inventario.nombre, reserva.cantidad,   reserva.fechaActual, reserva.fechaReserva, reserva.estado\n"
                + "from((inventario inner join reserva on (inventario.etiqueta = reserva.idElemento)) inner join usuarios on (usuarios.identificador=reserva.idSol))"
                + " where usuarios.identificador = '"+id+"'";

        try {

            Statement statement = this.conexion.createStatement();

            ResultSet resultado
                    = statement.executeQuery(consulta);
            while (resultado.next()) {
                reservasPendientes pr = new reservasPendientes();

                pr.setNombreSol(resultado.getString("nombreSol"));
                pr.setCursoArea(resultado.getString("cursoArea"));
                pr.setNombre(resultado.getString("nombre"));
                pr.setCantidad(resultado.getInt("cantidad"));
                pr.setFechaActual(resultado.getString("fechaActual"));
                pr.setFechaReserva(resultado.getString("fechaReserva"));
                pr.setEstado(resultado.getString("estado"));

                respuesta.add(pr);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return respuesta;
    }

    public boolean restarInventario(int etiqueta, int cantidad) {
        boolean resultado = false;
        try {

            String consulta = "update inventario set cantidadDisponible =  cast(cantidadDisponible as int)-"+cantidad+" where etiqueta =?";

            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.setInt(1, etiqueta);
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public boolean sumarInventario(int etiqueta, int cantidad) {
        boolean resultado = false;
        try {

            String consulta = "update inventario set cantidadDisponible =  cast(cantidadDisponible as int)+"+cantidad+" where etiqueta =?";

            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.setInt(1, etiqueta);
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public int cambiarEstado(String idSol, String etiqetaInv, String cantidad) {
        int a = 0;
        int etiqueta = Integer.valueOf(etiqetaInv);
        int newCantidad = Integer.valueOf(cantidad);
        try {
            String consulta = "UPDATE prestamo SET estado = 'devuelto' WHERE identificadorsol='"+idSol+"' and etiquetainv="+etiqetaInv+"";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            a = statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        sumarInventario(etiqueta, newCantidad);
        return a;
    }

    public usuarios getIdUser(String nombre) {
        usuarios us = new usuarios();
        try {

            String consulta = "select identificador from usuarios where nombreSol = '" + nombre + "'";

            Statement statement = this.conexion.createStatement();
            ResultSet res
                    = statement.executeQuery(consulta);
            while (res.next()) {

                us.setidentificador(res.getString("identificador"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return us;
    }

    public inventario getIdInv(String nombre) {
        inventario inv = new inventario();
        try {

            String consulta = "select etiqueta from inventario where nombre = '" + nombre + "'";

            Statement statement = this.conexion.createStatement();
            ResultSet res
                    = statement.executeQuery(consulta);
            while (res.next()) {
                inv.setetiqueta(res.getString("etiqueta"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return inv;
    }

    public boolean modificar(int etiqueta, int cantidad, String ub, String res) {
        boolean resultado = false;
        try {
            String consulta = "UPDATE inventario SET cantidadDisponible = '" + cantidad + "',ubicacion = '" + ub + "',responsable = '" + res + "' WHERE etiqueta = " + etiqueta + "";
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            System.out.println(consulta);
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

    public boolean borrar2(int etiqueta) {
        boolean resultado = true;
        try {
            String consulta = "DELETE FROM inventario WHERE etiqueta=?";            
            PreparedStatement statement = this.conexion.prepareStatement(consulta);
            statement.setInt(1, etiqueta);
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }

}
