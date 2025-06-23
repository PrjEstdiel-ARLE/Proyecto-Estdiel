package Controlador;

import DAO.ContactoProveedorDAO;
import DAO.ContactoProveedorDAOImpl;
import Modelo.ContactoProveedor;
import Modelo.Proveedor;
import java.util.List;

public class ControladoraContactosProveedor {

    private final ContactoProveedorDAO contactoDao;

    public ControladoraContactosProveedor() {
        this.contactoDao = new ContactoProveedorDAOImpl();
    }

    public void crear(ContactoProveedor contacto) {
        contactoDao.crear(contacto);
    }

    public ContactoProveedor leer(int id) {
        return contactoDao.leer(id);
    }

    public void actualizar(ContactoProveedor contacto) {
        contactoDao.actualizar(contacto);
    }

    public void eliminar(int id) {
        contactoDao.eliminar(id);
    }

    public List<ContactoProveedor> leerTodo() {
        return contactoDao.leerTodo();
    }

    public List<ContactoProveedor> leerPorProveedor(Proveedor proveedor) {
        return contactoDao.leerPorProveedor(proveedor);
    }
}
