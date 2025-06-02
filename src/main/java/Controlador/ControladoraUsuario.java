package Controlador;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOImpl;
import Modelo.Usuario;
import java.util.List;

public class ControladoraUsuario {
    private final UsuarioDAO usuarioDao;

    public ControladoraUsuario() {
        this.usuarioDao = new UsuarioDAOImpl();
    }
    
    public void crear(Usuario usuario){
        usuarioDao.crear(usuario);
    }

    public Usuario leer(Long id){
        return usuarioDao.leer(id);
    }

    public void actualizar(Usuario usuario){
        usuarioDao.actualizar(usuario);
    }

    public void eliminar(Long id){
        usuarioDao.eliminar(id);
    }

    public List<Usuario> leerTodo(){
        return usuarioDao.leerTodo();
    }
}
