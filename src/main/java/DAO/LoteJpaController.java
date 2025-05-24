package DAO;

import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Producto;
import Modelo.DetallePedido;
import Modelo.DetalleSalida;
import Modelo.Lote;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LoteJpaController implements Serializable {

    public LoteJpaController() {
        emf=Persistence.createEntityManagerFactory("persistencia");
    }

    public LoteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lote lote) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto = lote.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getIdProducto());
                lote.setProducto(producto);
            }
            DetallePedido detalleOrigen = lote.getDetalleOrigen();
            if (detalleOrigen != null) {
                detalleOrigen = em.getReference(detalleOrigen.getClass(), detalleOrigen.getIdDetallePedido());
                lote.setDetalleOrigen(detalleOrigen);
            }
            DetalleSalida detalleSalida = lote.getDetalleSalida();
            if (detalleSalida != null) {
                detalleSalida = em.getReference(detalleSalida.getClass(), detalleSalida.getIdDetalleSalida());
                lote.setDetalleSalida(detalleSalida);
            }
            em.persist(lote);
            if (producto != null) {
                producto.getLotes().add(lote);
                producto = em.merge(producto);
            }
            if (detalleOrigen != null) {
                detalleOrigen.getLotesGenerados().add(lote);
                detalleOrigen = em.merge(detalleOrigen);
            }
            if (detalleSalida != null) {
                Lote oldLoteOfDetalleSalida = detalleSalida.getLote();
                if (oldLoteOfDetalleSalida != null) {
                    oldLoteOfDetalleSalida.setDetalleSalida(null);
                    oldLoteOfDetalleSalida = em.merge(oldLoteOfDetalleSalida);
                }
                detalleSalida.setLote(lote);
                detalleSalida = em.merge(detalleSalida);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Lote lote) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lote persistentLote = em.find(Lote.class, lote.getIdLote());
            Producto productoOld = persistentLote.getProducto();
            Producto productoNew = lote.getProducto();
            DetallePedido detalleOrigenOld = persistentLote.getDetalleOrigen();
            DetallePedido detalleOrigenNew = lote.getDetalleOrigen();
            DetalleSalida detalleSalidaOld = persistentLote.getDetalleSalida();
            DetalleSalida detalleSalidaNew = lote.getDetalleSalida();
            if (productoNew != null) {
                productoNew = em.getReference(productoNew.getClass(), productoNew.getIdProducto());
                lote.setProducto(productoNew);
            }
            if (detalleOrigenNew != null) {
                detalleOrigenNew = em.getReference(detalleOrigenNew.getClass(), detalleOrigenNew.getIdDetallePedido());
                lote.setDetalleOrigen(detalleOrigenNew);
            }
            if (detalleSalidaNew != null) {
                detalleSalidaNew = em.getReference(detalleSalidaNew.getClass(), detalleSalidaNew.getIdDetalleSalida());
                lote.setDetalleSalida(detalleSalidaNew);
            }
            lote = em.merge(lote);
            if (productoOld != null && !productoOld.equals(productoNew)) {
                productoOld.getLotes().remove(lote);
                productoOld = em.merge(productoOld);
            }
            if (productoNew != null && !productoNew.equals(productoOld)) {
                productoNew.getLotes().add(lote);
                productoNew = em.merge(productoNew);
            }
            if (detalleOrigenOld != null && !detalleOrigenOld.equals(detalleOrigenNew)) {
                detalleOrigenOld.getLotesGenerados().remove(lote);
                detalleOrigenOld = em.merge(detalleOrigenOld);
            }
            if (detalleOrigenNew != null && !detalleOrigenNew.equals(detalleOrigenOld)) {
                detalleOrigenNew.getLotesGenerados().add(lote);
                detalleOrigenNew = em.merge(detalleOrigenNew);
            }
            if (detalleSalidaOld != null && !detalleSalidaOld.equals(detalleSalidaNew)) {
                detalleSalidaOld.setLote(null);
                detalleSalidaOld = em.merge(detalleSalidaOld);
            }
            if (detalleSalidaNew != null && !detalleSalidaNew.equals(detalleSalidaOld)) {
                Lote oldLoteOfDetalleSalida = detalleSalidaNew.getLote();
                if (oldLoteOfDetalleSalida != null) {
                    oldLoteOfDetalleSalida.setDetalleSalida(null);
                    oldLoteOfDetalleSalida = em.merge(oldLoteOfDetalleSalida);
                }
                detalleSalidaNew.setLote(lote);
                detalleSalidaNew = em.merge(detalleSalidaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = lote.getIdLote();
                if (findLote(id) == null) {
                    throw new NonexistentEntityException("The lote with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lote lote;
            try {
                lote = em.getReference(Lote.class, id);
                lote.getIdLote();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lote with id " + id + " no longer exists.", enfe);
            }
            Producto producto = lote.getProducto();
            if (producto != null) {
                producto.getLotes().remove(lote);
                producto = em.merge(producto);
            }
            DetallePedido detalleOrigen = lote.getDetalleOrigen();
            if (detalleOrigen != null) {
                detalleOrigen.getLotesGenerados().remove(lote);
                detalleOrigen = em.merge(detalleOrigen);
            }
            DetalleSalida detalleSalida = lote.getDetalleSalida();
            if (detalleSalida != null) {
                detalleSalida.setLote(null);
                detalleSalida = em.merge(detalleSalida);
            }
            em.remove(lote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Lote> findLoteEntities() {
        return findLoteEntities(true, -1, -1);
    }

    public List<Lote> findLoteEntities(int maxResults, int firstResult) {
        return findLoteEntities(false, maxResults, firstResult);
    }

    private List<Lote> findLoteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lote.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Lote findLote(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lote.class, id);
        } finally {
            em.close();
        }
    }

    public int getLoteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lote> rt = cq.from(Lote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
