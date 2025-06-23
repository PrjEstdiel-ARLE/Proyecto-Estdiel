package DAO;

import Modelo.ContactoProveedor;
import Modelo.Proveedor;
import java.util.List;

public interface ContactoProveedorDAO {

    void crear(ContactoProveedor contacto);

    ContactoProveedor leer(int id);

    void actualizar(ContactoProveedor contacto);

    void eliminar(int id);

    List<ContactoProveedor> leerTodo();
    
    List<ContactoProveedor> leerPorProveedor(Proveedor proveedor);
}
