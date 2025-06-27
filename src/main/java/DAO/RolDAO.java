package DAO;

import Modelo.Rol;
import java.util.List;

public interface RolDAO {
    List<Rol> leerTodos();
    Rol leer(int id);
    public Rol leerPorNombre(String rolNombre);
}

