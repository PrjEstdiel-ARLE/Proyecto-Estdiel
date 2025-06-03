package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.Salida;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SalidaDAOImpl implements SalidaDAO {

    private final SalidaJpaController salidaJpa;

    public SalidaDAOImpl() {
        this.salidaJpa = new SalidaJpaController();
    }

    @Override
    public void crear(Salida salida) {
        salidaJpa.create(salida);
    }

    @Override
    public Salida leer(int id) {
        return salidaJpa.findSalida(id);
    }

    @Override
    public void actualizar(Salida salida) {
        try {
            salidaJpa.edit(salida);
        } catch (Exception ex) {
            Logger.getLogger(SalidaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            salidaJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(SalidaDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Salida> leerTodo() {
        return salidaJpa.findSalidaEntities();
    }

    @Override
    public List<Salida> buscarPorRangoFecha(Date desde, Date hasta) {
        return salidaJpa.buscarPorRangoFecha(desde, hasta);
    }
}
