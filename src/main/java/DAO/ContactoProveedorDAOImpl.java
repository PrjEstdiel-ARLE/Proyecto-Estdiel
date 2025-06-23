package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.ContactoProveedor;
import Modelo.Proveedor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ContactoProveedorDAOImpl implements ContactoProveedorDAO {

    private final ContactoProveedorJpaController contactoJpa;
    
    public ContactoProveedorDAOImpl() {
        this.contactoJpa = new ContactoProveedorJpaController();
    }
    
    @Override
    public void crear(ContactoProveedor contacto) {
        contactoJpa.create(contacto);
    }
    
    @Override
    public ContactoProveedor leer(int id) {
        return contactoJpa.findContactoProveedor(id);
    }
    
    @Override
    public void actualizar(ContactoProveedor contacto) {
        try {
            contactoJpa.edit(contacto);
        } catch (Exception ex) {
            Logger.getLogger(ContactoProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void eliminar(int id) {
        try {
            contactoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ContactoProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<ContactoProveedor> leerTodo() {
        return contactoJpa.findContactoProveedorEntities();
    }
    
    @Override
    public List<ContactoProveedor> leerPorProveedor(Proveedor proveedor) {
        return contactoJpa.findByProveedor(proveedor);
    }
    
}
