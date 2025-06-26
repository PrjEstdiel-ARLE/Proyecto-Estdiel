package Controlador;

import DAO.ProveedorDAO;
import DAO.ProveedorDAOImpl;
import Modelo.Proveedor;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Proveedor> leerParcial(String termino) {
        return proveedorDao.leerParcial(termino);
    }

    public List<Proveedor> ordenar(boolean asc) {
        return proveedorDao.ordenar(asc);
    }

    public List<Proveedor> ordenarAZ(List<Proveedor> proveedores) {
        return proveedores.stream()
                .sorted(Comparator.comparing(Proveedor::getNombre, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public List<Proveedor> ordenarZA(List<Proveedor> proveedores) {
        return proveedores.stream()
                .sorted(Comparator.comparing(Proveedor::getNombre, String.CASE_INSENSITIVE_ORDER).reversed())
                .collect(Collectors.toList());
    }
}
