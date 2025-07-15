package DAO;

import Modelo.Pais;
import java.util.List;

public interface PaisDAO {

    void crear(Pais pais);

    Pais leer(Long id);

    void actualizar(Pais pais);

    void eliminar(Long id);

    List<Pais> leerTodo();
    
    Pais leerPorNombre(String nombre);
}
