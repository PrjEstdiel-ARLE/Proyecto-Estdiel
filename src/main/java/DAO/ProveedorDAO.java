package DAO;

import Modelo.Proveedor;
import java.util.List;

public interface ProveedorDAO {
    void crear(Proveedor prov);

    Proveedor leer(int id);

    void actualizar(Proveedor prov);

    void eliminar(int id);
    
    List<Proveedor> leerTodo();
    
    Proveedor leerPorNombre(String nombre);
    
    List<Proveedor> leerParcial(String termino);
    
    List<Proveedor> ordenar(boolean asc);
    
    boolean existePorRuc(String RUC);
}
