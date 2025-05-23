package DAO;

/*import DAO.exceptions.NonexistentEntityException;
import Modelo.Categoria;
import Modelo.Producto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductoDAOImpl implements ProductoDAO{

    private ProductoJpaController productoJpa;

    public ProductoDAOImpl() {
        this.productoJpa=new ProductoJpaController();
    }
    
    @Override
    public void crear(Producto producto) {
        productoJpa.create(producto);
    }

    @Override
    public Producto leer(int id) {
        return productoJpa.findProducto(id);
    }

    @Override
    public void actualizar(Producto producto) {
        try {
            productoJpa.edit(producto);
        } catch (Exception ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            productoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ProductoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Producto> leerTodo() {
        return productoJpa.findProductoEntities();
    }

    @Override
    public Producto leerPorNombre(String nombre) {
        return productoJpa.findByNombre(nombre);
    }

    @Override
    public Producto leerPorCodigo(String codigo) {
        System.out.println("Query ejecutada con código: [" + codigo + "]");
        return productoJpa.findByCodigo(codigo);
    }

    @Override
    public List<Producto> leerPorCategoria(Categoria categoria) {
        return productoJpa.findByCategory(categoria);
    }
    
}*/
