package Controlador;

import DAO.RolDAO;
import DAO.RolDAOImpl;
import Modelo.Rol;
import java.util.List;

public class ControladoraRol {

    private final RolDAO rolDao;

    public ControladoraRol() {
        this.rolDao = new RolDAOImpl();
    }

    public List<Rol> leerTodos() {
        return rolDao.leerTodos();
    }

    public Rol leer(int id) {
        return rolDao.leer(id);
    }

    public Rol leerPorNombre(String rolNombre) {
        return rolDao.leerPorNombre(rolNombre);
    }
}
