package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.Categoria;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDAOImpl implements CategoriaDAO {

    private final CategoriaJpaController categoriaJpa;

    public CategoriaDAOImpl() {
        this.categoriaJpa = new CategoriaJpaController();
    }

    @Override
    public void crear(Categoria categoria) {
        categoriaJpa.create(categoria);
    }

    @Override
    public Categoria leer(int id) {
        return categoriaJpa.findCategoria(id);
    }

    @Override
    public void actualizar(Categoria categoria) {
        try {
            categoriaJpa.edit(categoria);
        } catch (Exception ex) {
            Logger.getLogger(CategoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            categoriaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CategoriaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Categoria> leerTodo() {
        return categoriaJpa.findCategoriaEntities();
    }

    @Override
    public Categoria leerPorNombre(String nombre) {
        return categoriaJpa.findByName(nombre);
    }

    @Override
    public List<String> leerNombresCategorias() {
        return categoriaJpa.findAllNombresCategoria();
    }

    @Override
    public boolean existePorNombres(String Nombre) {
        return categoriaJpa.existsCategoriaWithNombre(Nombre);
    }

    @Override
    public List<Categoria> leerParcial(String termino) {
        return categoriaJpa.findByNombreParcial(termino);
    }

}
