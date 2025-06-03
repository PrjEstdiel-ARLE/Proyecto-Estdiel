package Controlador;

import DAO.ProveedorDAO;
import DAO.ProveedorDAOImpl;
import Modelo.Proveedor;
import java.util.List;

public class ControladoraProveedor {

    private final ProveedorDAO proveedorDao;
    
    public ControladoraProveedor() {
        this.proveedorDao = new ProveedorDAOImpl();
    }
    
    public void crearProveedor(Proveedor prov) {
        proveedorDao.crear(prov);
    }
    
    public Proveedor leerProveedor(int id) {
        return proveedorDao.leer(id);
    }
    
    public void actualizarProveedor(Proveedor prov) {
        proveedorDao.actualizar(prov);
    }
    
    public void eliminarProveedor(int id) {
        proveedorDao.eliminar(id);
    }
    
    public Proveedor leerPorNombre(String nombre) {
        return proveedorDao.leerPorNombre(nombre);
    }
    
    public List<Proveedor> leerTodo() {
        return proveedorDao.leerTodo();
    }
    
    public boolean existePorRuc(String ruc) {
        return proveedorDao.existePorRuc(ruc);
    }
}
