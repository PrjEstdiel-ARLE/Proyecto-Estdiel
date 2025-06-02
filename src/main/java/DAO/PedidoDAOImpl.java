package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.EstadoPedido;
import Modelo.Pedido;
import Modelo.Proveedor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDAOImpl implements PedidoDAO {

    private final PedidoJpaController pedidoJpa;

    public PedidoDAOImpl() {
        this.pedidoJpa = new PedidoJpaController();
    }

    @Override
    public void crear(Pedido pedido) {
        pedidoJpa.create(pedido);
    }

    @Override
    public Pedido leer(int id) {
        return pedidoJpa.findPedido(id);
    }

    @Override
    public void actualizar(Pedido pedido) {
        try {
            pedidoJpa.edit(pedido);
        } catch (Exception ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            pedidoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PedidoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Pedido> leerTodo() {
        return pedidoJpa.findPedidoEntities();
    }

    @Override
    public void actualizarEstado(Pedido pedido, EstadoPedido nuevoEstado) {
        pedidoJpa.actualizarEstado(pedido.getIdPedido(), nuevoEstado);
    }

    @Override
    public List<Pedido> findPedidosPorProveedor(Proveedor proveedor) {
        return pedidoJpa.findPedidosPorProveedor(proveedor.getIdProveedor());
    }

    @Override
    public List<Pedido> findPedidosPorEstado(EstadoPedido estado) {
        return pedidoJpa.findPedidosPorEstado(estado);
    }

}
