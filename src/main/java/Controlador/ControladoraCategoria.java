package Controlador;

import DAO.CategoriaDAO;
import DAO.CategoriaDAOImpl;
import Modelo.Categoria;
import java.util.List;

public class ControladoraCategoria {

    private final CategoriaDAO categoriaDao;

    public ControladoraCategoria() {
        this.categoriaDao = new CategoriaDAOImpl();
    }

    public void crearCategoria(Categoria categoria) {
        categoriaDao.crear(categoria);
    }

    public Categoria leerCategoria(int id) {
        return categoriaDao.leer(id);
    }

    public void actualizarCategoria(Categoria categoria) {
        categoriaDao.actualizar(categoria);
    }

    public void eliminarCategoria(int id) {
        categoriaDao.eliminar(id);
    }

    public List<Categoria> leerTodo() {
        return categoriaDao.leerTodo();
    }

    public Categoria leerPorNombre(String nombre) {
        return categoriaDao.leerPorNombre(nombre);
    }

    public List<String> leerNombresCategorias() {
        return categoriaDao.leerNombresCategorias();
    }

    public boolean existePorNombres(String Nombre) {
        return categoriaDao.existePorNombres(Nombre);
    }

    public List<Categoria> leerParcial(String termino) {
        return categoriaDao.leerParcial(termino);
    }
}
