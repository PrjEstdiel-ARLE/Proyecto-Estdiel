package Controlador;

import DAO.PedidoDAO;
import DAO.PedidoDAOImpl;
import Modelo.EstadoPedido;
import Modelo.Pedido;
import Modelo.Proveedor;
import java.util.List;

public class ControladoraPedido {

    private final PedidoDAO pedidoDao;

    public ControladoraPedido() {
        this.pedidoDao = new PedidoDAOImpl();
    }

    public void crear(Pedido pedido) {
        pedidoDao.crear(pedido);
    }

    public Pedido leer(int id) {
        return pedidoDao.leer(id);
    }

    public void actualizar(Pedido pedido) {
        pedidoDao.actualizar(pedido);
    }

    public void eliminar(int id) {
        pedidoDao.eliminar(id);
    }

    public List<Pedido> leerTodo() {
        return pedidoDao.leerTodo();
    }

    public void actualizarEstado(Pedido pedido, EstadoPedido nuevoEstado) {
        pedidoDao.actualizarEstado(pedido, nuevoEstado);
    }

    public List<Pedido> findPedidosPorProveedor(Proveedor proveedor) {
        return pedidoDao.findPedidosPorProveedor(proveedor);
    }

    public List<Pedido> findPedidosPorEstado(EstadoPedido estado) {
        return pedidoDao.findPedidosPorEstado(estado);
    }
}
