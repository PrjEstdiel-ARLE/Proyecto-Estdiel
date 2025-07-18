package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.Proveedor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProveedorDAOImpl implements ProveedorDAO {
    
    private final ProveedorJpaController provJpa;
    
    public ProveedorDAOImpl() {
        this.provJpa = new ProveedorJpaController();
    }
    
    @Override
    public void crear(Proveedor prov) {
        provJpa.create(prov);
    }
    
    @Override
    public Proveedor leer(int id) {
        return provJpa.findProveedor(id);
    }
    
    @Override
    public void actualizar(Proveedor prov) {
        try {
            provJpa.edit(prov);
        } catch (Exception ex) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void eliminar(int id) {
        try {
            provJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProveedorDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Proveedor> leerTodo() {
        return provJpa.findProveedorEntities();
    }
    
    @Override
    public Proveedor leerPorNombre(String nombre) {
        return provJpa.findByNombre(nombre);
    }
    
    @Override
    public boolean existePorRuc(String RUC) {
        return provJpa.existeProveedorConRUC(RUC);
    }
    
    @Override
    public List<Proveedor> leerParcial(String termino) {
        return provJpa.findByNombreParcial(termino);
    }
    
    @Override
    public List<Proveedor> ordenar(boolean asc) {
        return provJpa.findAllOrdenados(asc);
    }
    
}
