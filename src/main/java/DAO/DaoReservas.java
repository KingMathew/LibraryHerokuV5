package DAO;

import Modelo.reserva;
import TX.SQLgen;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoReservas {

    SQLgen<reserva> a;

    public DaoReservas() throws URISyntaxException, SQLException {
        a = new SQLgen<reserva>();
    }

    public boolean insertar(reserva p) throws IllegalArgumentException, IllegalAccessException, URISyntaxException, SQLException {
        boolean respuesta = false;
        int etiqueta = Integer.valueOf(p.idElemento);
        int cantidad = Integer.valueOf(p.cantidad);
        respuesta = a.insertar(p);
        SQLgen sql = new SQLgen();
        sql.restarInventario(etiqueta, cantidad);
        return respuesta;
    }

    public ArrayList<reserva> listarTodo() {
        ArrayList<reserva> respuesta = new ArrayList();
        reserva res = new reserva();
        respuesta = a.Select4(res);
        return respuesta;
    }

}
