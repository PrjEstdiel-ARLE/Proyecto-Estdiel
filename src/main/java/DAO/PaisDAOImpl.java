package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.Pais;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaisDAOImpl implements PaisDAO {
    
    private final PaisJpaController paisJpa;
    
    public PaisDAOImpl() {
        this.paisJpa = new PaisJpaController();
    }
    
    @Override
    public void crear(Pais pais) {
        paisJpa.create(pais);
    }
    
    @Override
    public Pais leer(Long id) {
        return paisJpa.findPais(id);
    }
    
    @Override
    public void actualizar(Pais pais) {
        try {
            paisJpa.edit(pais);
        } catch (Exception ex) {
            Logger.getLogger(PaisDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public List<Pais> leerTodo() {
        return paisJpa.findPaisEntities();
    }
    
    @Override
    public void eliminar(Long id) {
        try {
            paisJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PaisDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Pais leerPorNombre(String nombre) {
        return paisJpa.findByNombre(nombre);
    }
    
}
