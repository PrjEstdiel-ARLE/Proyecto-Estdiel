package DAO;

import Modelo.EstadoPedido;
import Modelo.Pedido;
import Modelo.Proveedor;
import java.util.List;

public interface PedidoDAO {

    void crear(Pedido pedido);

    Pedido leer(int id);

    void actualizar(Pedido pedido);

    void eliminar(int id);

    List<Pedido> leerTodo();

    void actualizarEstado(Pedido pedido, EstadoPedido nuevoEstado);

    List<Pedido> findPedidosPorProveedor(Proveedor proveedor);
    
    List<Pedido> findPedidosPorEstado(EstadoPedido estado);
}
