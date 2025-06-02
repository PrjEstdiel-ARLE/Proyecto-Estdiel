package DAO;

import Modelo.DetalleSalida;
import Modelo.Salida;
import java.util.List;

public interface DetalleSalidaDAO {
    void crear(DetalleSalida detalleSalida);
    
    DetalleSalida leer(int id);

    void actualizar(DetalleSalida detalleSalida);

    void eliminar(int id);
    
    List<DetalleSalida> leerTodo();
    
    List<DetalleSalida> leerPorSalida(Salida salida);
}
