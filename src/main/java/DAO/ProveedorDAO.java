package DAO;

import Modelo.Proveedor;
import java.util.List;

public interface ProveedorDAO {
    void crear(Proveedor prov);

    Proveedor leer(int id);

    void actualizar(Proveedor prov);

    void eliminar(int id);
    
    List<Proveedor> leerTodo();
}
