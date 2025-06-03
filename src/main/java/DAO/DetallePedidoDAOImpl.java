package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.DetallePedido;
import Modelo.Pedido;
import Modelo.Producto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetallePedidoDAOImpl implements DetallePedidoDAO {

    private final DetallePedidoJpaController detalleJpa;

    public DetallePedidoDAOImpl() {
        this.detalleJpa = new DetallePedidoJpaController();
    }

    @Override
    public void crear(DetallePedido detallePedido) {
        detalleJpa.create(detallePedido);
    }

    @Override
    public DetallePedido leer(int id) {
        return detalleJpa.findDetallePedido(id);
    }

    @Override
    public void actualizar(DetallePedido detallePedido) {
        try {
            detalleJpa.edit(detallePedido);
        } catch (Exception ex) {
            Logger.getLogger(DetallePedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            detalleJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(DetallePedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<DetallePedido> leerTodo() {
        return detalleJpa.findDetallePedidoEntities();
    }

    @Override
    public List<DetallePedido> leerPorPedido(Pedido pedido) {
        return detalleJpa.findByPedido(pedido);
    }

    @Override
    public List<DetallePedido> leerPorProducto(Producto producto) {
        return detalleJpa.findByProducto(producto);
    }

}
