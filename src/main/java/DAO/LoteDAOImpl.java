package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.EstadoLote;
import Modelo.Lote;
import Modelo.Producto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoteDAOImpl implements LoteDAO {

    private final LoteJpaController loteJpa;

    public LoteDAOImpl() {
        this.loteJpa = new LoteJpaController();
    }

    @Override
    public void crear(Lote lote) {
        loteJpa.create(lote);
    }

    @Override
    public Lote leer(int id) {
        return loteJpa.findLote(id);
    }

    @Override
    public void actualizar(Lote lote) {
        try {
            loteJpa.edit(lote);
        } catch (Exception ex) {
            Logger.getLogger(LoteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            loteJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(LoteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Lote> leerTodo() {
        return loteJpa.findLoteEntities();
    }

    @Override
    public List<Lote> lotesDisponiblesPorProducto(Producto producto) {
        return loteJpa.findLotesDisponiblesPorProducto(producto.getIdProducto());
    }

    @Override
    public void actualizarEstado(Lote lote, EstadoLote nuevoEstado) {
        loteJpa.actualizarEstado(lote.getIdLote(), nuevoEstado);
    }

    @Override
    public Lote buscarPorCodigo(String codigo) {
        return loteJpa.findLoteByCodigo(codigo);
    }

    @Override
    public List<Lote> lotesPorProducto(Producto producto) {
        return loteJpa.findLoteByProducto(producto.getIdProducto());
    }
}
