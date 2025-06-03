package DAO;

import Modelo.Categoria;
import Modelo.Producto;
import java.util.List;

public interface ProductoDAO {
    void crear(Producto producto);
    
    Producto leer(int id);

    void actualizar(Producto producto);

    void eliminar(int id);
    
    Producto leerPorNombre(String nombre);
    
    Producto leerPorCodigo(String codigo);
   
    List<Producto> leerTodo();
    
    List<Producto> leerPorCategoria(Categoria categoria);
    
    void actualizarCantidad(Producto producto, int nuevaCantidad);
}
