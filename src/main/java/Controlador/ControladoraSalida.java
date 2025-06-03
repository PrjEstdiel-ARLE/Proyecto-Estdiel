package Controlador;

import DAO.SalidaDAO;
import DAO.SalidaDAOImpl;
import Modelo.Salida;
import java.util.Date;
import java.util.List;

public class ControladoraSalida {
    private final SalidaDAO salidaDao;

    public ControladoraSalida() {
        this.salidaDao = new SalidaDAOImpl();
    }
    
    public void crear(Salida salida){
        salidaDao.crear(salida);
    }
    
    public Salida leer(int id){
        return salidaDao.leer(id);
    }

    public void actualizar(Salida salida){
        salidaDao.actualizar(salida);
    }

    public void eliminar(int id){
        salidaDao.eliminar(id);
    }
    
    public List<Salida> leerTodo(){
        return salidaDao.leerTodo();
    }
    
    public List<Salida> buscarPorRangoFecha(Date desde, Date hasta){
        return salidaDao.buscarPorRangoFecha(desde, hasta);
    }
}
