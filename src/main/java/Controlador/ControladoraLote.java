package Controlador;

import DAO.LoteDAO;
import DAO.LoteDAOImpl;
import Modelo.EstadoLote;
import Modelo.Lote;
import Modelo.Producto;
import java.util.List;

public class ControladoraLote {
    private final LoteDAO loteDao;

    public ControladoraLote() {
        this.loteDao = new LoteDAOImpl();
    }
    
    public void crear(Lote lote){
        loteDao.crear(lote);
    }
    
    public Lote leer(int id){
        return loteDao.leer(id);
    }

    public void actualizar(Lote lote){
        loteDao.actualizar(lote);
    }

    public void eliminar(int id){
        loteDao.eliminar(id);
    }
    
    public List<Lote> leerTodo(){
        return loteDao.leerTodo();
    }
    
    public List<Lote> lotesDisponiblesPorProducto(Producto producto){
        return loteDao.lotesDisponiblesPorProducto(producto);
    }
    
    public void actualizarEstado(Lote lote, EstadoLote nuevoEstado){
        loteDao.actualizarEstado(lote, nuevoEstado);
    }
    
    public Lote buscarPorCodigo(String codigo){
        return loteDao.buscarPorCodigo(codigo);
    }
    
    public List<Lote> lotesPorProducto(Producto producto){
        return loteDao.lotesPorProducto(producto);
    }
}
