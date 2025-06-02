package DAO;

import Modelo.Categoria;
import java.util.List;

public interface CategoriaDAO {
    void crear(Categoria categoria);
    
    Categoria leer(int id);

    void actualizar(Categoria categoria);

    void eliminar(int id);
    
    List<Categoria> leerTodo();
    
    Categoria leerPorNombre(String nombre);
    
    List<String> leerNombresCategorias ();
    
    boolean existePorNombres(String Nombre);

}
