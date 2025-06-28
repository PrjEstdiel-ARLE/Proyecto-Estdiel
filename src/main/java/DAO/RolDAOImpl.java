package DAO;

import Modelo.Rol;
import java.util.List;

public class RolDAOImpl implements RolDAO {

    private final RolJpaController rolJpa;

    public RolDAOImpl() {
        this.rolJpa = new RolJpaController();
    }

    @Override
    public List<Rol> leerTodos() {
        return rolJpa.findRolEntities();
    }

    @Override
    public Rol leer(int id) {
        return rolJpa.findRol(id);
    }

    @Override
    public Rol leerPorNombre(String rolNombre) {
        return rolJpa.finByName(rolNombre);
    }
}
