package Controlador;

import DAO.DetalleSalidaDAO;
import DAO.DetalleSalidaDAOImpl;
import Modelo.DetalleSalida;
import Modelo.Salida;
import java.util.List;

public class ControladoraDetalleSalida {

    private final DetalleSalidaDAO detalleDao;

    public ControladoraDetalleSalida() {
        this.detalleDao = new DetalleSalidaDAOImpl();
    }

    public void crear(DetalleSalida detalleSalida) {
        detalleDao.crear(detalleSalida);
    }

    public DetalleSalida leer(int id) {
        return detalleDao.leer(id);
    }

    public void actualizar(DetalleSalida detalleSalida) {
        detalleDao.actualizar(detalleSalida);
    }

    public void eliminar(int id) {
        detalleDao.eliminar(id);
    }

    public List<DetalleSalida> leerTodo() {
        return detalleDao.leerTodo();
    }

    public List<DetalleSalida> leerPorSalida(Salida salida) {
        return detalleDao.leerPorSalida(salida);
    }
}
