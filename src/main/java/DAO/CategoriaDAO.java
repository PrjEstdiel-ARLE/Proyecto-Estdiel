package DAO;

import Modelo.Categoria;
import java.util.List;

/*Alexis*/
public interface CategoriaDAO {
    void crear(Categoria categoria);
    
    Categoria leer(int id);

    void actualizar(Categoria categoria);

    void eliminar(int id);
    
    List<Categoria> leerTodo();
    
    public Categoria leerPorNombre(String nombre);

}
