package Controlador;

import DAO.ContactoProveedorDAO;
import DAO.ContactoProveedorDAOImpl;
import Modelo.ContactoProveedor;
import Modelo.Proveedor;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<ContactoProveedor> ordenarApellidoAZ(List<ContactoProveedor> contactos) {
        return contactos.stream()
                .sorted(Comparator.comparing(ContactoProveedor::getApellido, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public List<ContactoProveedor> ordenarApellidoZA(List<ContactoProveedor> contactos) {
        return contactos.stream()
                .sorted(Comparator.comparing(ContactoProveedor::getApellido, String.CASE_INSENSITIVE_ORDER).reversed())
                .collect(Collectors.toList());
    }

    public List<ContactoProveedor> ordenarNombreZA(List<ContactoProveedor> contactos) {
        return contactos.stream()
                .sorted(Comparator.comparing(ContactoProveedor::getNombre, String.CASE_INSENSITIVE_ORDER).reversed())
                .collect(Collectors.toList());
    }
    
    public List<ContactoProveedor> ordenarNombreAZ(List<ContactoProveedor> contactos) {
        return contactos.stream()
                .sorted(Comparator.comparing(ContactoProveedor::getNombre, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }
}
