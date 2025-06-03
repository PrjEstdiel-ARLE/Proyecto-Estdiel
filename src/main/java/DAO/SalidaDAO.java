package DAO;

import Modelo.Salida;
import java.util.Date;
import java.util.List;

public interface SalidaDAO {
     void crear(Salida salida);
    
    Salida leer(int id);

    void actualizar(Salida salida);

    void eliminar(int id);
    
    List<Salida> leerTodo();
    
    List<Salida> buscarPorRangoFecha(Date desde, Date hasta);
}
