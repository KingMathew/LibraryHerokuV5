package DAO;

import Modelo.prestamo;
import TX.SQLgen;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoPrestamos {

    SQLgen<prestamo> a;

    public DaoPrestamos() throws URISyntaxException, SQLException {
        a = new SQLgen<prestamo>();
    }

    public boolean insertar(prestamo p) throws IllegalArgumentException, IllegalAccessException, URISyntaxException, SQLException {
        boolean respuesta = false;
        int etiqueta = Integer.valueOf(p.etiquetaInv);
        int cantidad = Integer.valueOf(p.cantidadPrestamo);
        respuesta = a.insertar(p);
        SQLgen sql = new SQLgen();
        sql.restarInventario(etiqueta, cantidad);
        return respuesta;
    }

    public ArrayList<prestamo> listarTodo() {
        ArrayList<prestamo> respuesta = new ArrayList();
        prestamo pr = new prestamo();
        respuesta = a.Select4(pr);
        return respuesta;
    }

}
