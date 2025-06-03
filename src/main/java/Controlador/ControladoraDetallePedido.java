package Controlador;

import DAO.DetallePedidoDAO;
import DAO.DetallePedidoDAOImpl;
import Modelo.DetallePedido;
import Modelo.Pedido;
import Modelo.Producto;
import java.util.List;

public class ControladoraDetallePedido {

    private final DetallePedidoDAO detalleDao;

    public ControladoraDetallePedido() {
        this.detalleDao = new DetallePedidoDAOImpl();
    }

    public void crear(DetallePedido detallePedido) {
        detalleDao.crear(detallePedido);
    }

    public DetallePedido leer(int id) {
        return detalleDao.leer(id);
    }

    public void actualizar(DetallePedido detallePedido) {
        detalleDao.actualizar(detallePedido);
    }

    public void eliminar(int id) {
        detalleDao.eliminar(id);
    }

    public List<DetallePedido> leerTodo() {
        return detalleDao.leerTodo();
    }

    public List<DetallePedido> leerPorPedido(Pedido pedido) {
        return detalleDao.leerPorPedido(pedido);
    }

    public List<DetallePedido> leerPorProducto(Producto producto) {
        return detalleDao.leerPorProducto(producto);
    }
}
