package Controlador;

import DAO.PaisDAO;
import DAO.PaisDAOImpl;
import Modelo.Pais;
import java.util.List;

public class ControladoraPais {
    private final PaisDAO usuarioDao;

    public ControladoraPais() {
        this.usuarioDao = new PaisDAOImpl();
    }
    
    public void crear(Pais pais){
        usuarioDao.crear(pais);
    }

    public Pais leer(Long id){
        return usuarioDao.leer(id);
    }

    public void actualizar(Pais pais){
        usuarioDao.actualizar(pais);
    }

    public void eliminar(Long id){
        usuarioDao.eliminar(id);
    }

    public List<Pais> leerTodo(){
        return usuarioDao.leerTodo();
    }
}
