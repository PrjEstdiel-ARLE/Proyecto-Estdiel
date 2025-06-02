package DAO;

import Modelo.Usuario;
import java.util.List;

public interface UsuarioDAO {

    void crear(Usuario usuario);

    Usuario leer(Long id);

    void actualizar(Usuario usuario);

    void eliminar(Long id);

    List<Usuario> leerTodo();
}
