package DAO;

import Modelo.EstadoLote;
import Modelo.Lote;
import Modelo.Producto;
import java.util.Date;
import java.util.List;


public interface LoteDAO {
     void crear(Lote lote);
    
    Lote leer(int id);

    void actualizar(Lote lote);

    void eliminar(int id);
    
    List<Lote> leerTodo();
    
    List<Lote> lotesDisponiblesPorProducto(Producto producto);
    
    void actualizarEstado(Lote lote, EstadoLote nuevoEstado);
    
    Lote buscarPorCodigo(String codigo);

    public List<Lote> lotesPorProducto(Producto producto);
    
    List<Date> encontrarFechasUnicas();
}
