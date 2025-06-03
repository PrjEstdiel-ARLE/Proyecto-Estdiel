package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.DetalleSalida;
import Modelo.Salida;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DetalleSalidaDAOImpl implements DetalleSalidaDAO {

    private final DetalleSalidaJpaController detalleJpa;
    
    public DetalleSalidaDAOImpl() {
        this.detalleJpa = new DetalleSalidaJpaController();
    }
    
    @Override
    public void crear(DetalleSalida detalleSalida) {
        detalleJpa.create(detalleSalida);
    }
    
    @Override
    public DetalleSalida leer(int id) {
        return detalleJpa.findDetalleSalida(id);
    }
    
    @Override
    public void actualizar(DetalleSalida detalleSalida) {
        try {
            detalleJpa.edit(detalleSalida);
        } catch (Exception ex) {
            Logger.getLogger(DetalleSalidaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void eliminar(int id) {
        try {
            detalleJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(DetalleSalidaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<DetalleSalida> leerTodo() {
        return detalleJpa.findDetalleSalidaEntities();
    }
    
    @Override
    public List<DetalleSalida> leerPorSalida(Salida salida) {
        return detalleJpa.findBySalida(salida);
    }
    
}
