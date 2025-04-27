package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.Stock;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StockDAOImpl implements StockDAO{
    
    private StockJpaController stockJpa;
    
    public StockDAOImpl(){
        this.stockJpa=new StockJpaController();
    }
    
    @Override
    public void crear(Stock stock) {
        try {
            stockJpa.create(stock);
        } catch (Exception ex) {
            Logger.getLogger(StockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Stock leer(int id) {
        return stockJpa.findStock(id);
    }

    @Override
    public void actualizar(Stock stock) {
        try {
            stockJpa.edit(stock);
        } catch (Exception ex) {
            Logger.getLogger(StockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminar(int id) {
        try {
            stockJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(StockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Stock> leerTodo() {
        return stockJpa.findStockEntities();
    }
    
}
