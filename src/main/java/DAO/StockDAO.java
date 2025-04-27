package DAO;

import Modelo.Stock;
import java.util.List;

public interface StockDAO {
    void crear(Stock stock);
    
    Stock leer(int id);

    void actualizar(Stock stock);

    void eliminar(int id);
    
    List<Stock> leerTodo();
}
