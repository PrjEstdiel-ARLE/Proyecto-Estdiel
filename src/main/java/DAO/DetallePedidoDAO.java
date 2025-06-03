package DAO;

import Modelo.DetallePedido;
import Modelo.Pedido;
import Modelo.Producto;
import java.util.List;

public interface DetallePedidoDAO {
    void crear(DetallePedido detallePedido);
    
    DetallePedido leer(int id);

    void actualizar(DetallePedido detallePedido);

    void eliminar(int id);
    
    List<DetallePedido> leerTodo();
    
    List<DetallePedido> leerPorPedido(Pedido pedido);
   
    List<DetallePedido> leerPorProducto (Producto producto);
}
