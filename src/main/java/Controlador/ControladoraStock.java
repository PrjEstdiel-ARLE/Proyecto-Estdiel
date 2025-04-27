package Controlador;

import DAO.StockDAO;
import DAO.StockDAOImpl;
import Modelo.Stock;
import java.util.List;

public class ControladoraStock {
    private StockDAO stockDao;
    
    public ControladoraStock(){
        this.stockDao=new StockDAOImpl(){};
    }
    
    public void crearStock(Stock stock){
        stockDao.crear(stock);
    }
    
    public Stock leerStock(int id){
        return stockDao.leer(id);
    }
    
    public void actualizarStock(Stock stock){
        stockDao.actualizar(stock);
    }
    
    public void eliminarStock(int id){
        stockDao.eliminar(id);
    }
    
    public List<Stock> leerTodo(){
        return stockDao.leerTodo();
    }
    
    
}
