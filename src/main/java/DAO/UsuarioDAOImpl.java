package DAO;

import Modelo.Usuario;
import java.util.List;

public class UsuarioDAOImpl implements UsuarioDAO {

    private final UsuarioJpaController usuarioJpa;

    public UsuarioDAOImpl() {
        this.usuarioJpa = new UsuarioJpaController();
    }

    @Override
    public void crear(Usuario usuario) {
        usuarioJpa.create(usuario);
    }

    @Override
    public Usuario leer(Long id) {
        return usuarioJpa.findUsuario(id);
    }

    @Override
    public void actualizar(Usuario usuario) {
        try {
            usuarioJpa.edit(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            usuarioJpa.destroy(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Usuario> leerTodo() {
        return usuarioJpa.findUsuarioEntities();
    }
}
