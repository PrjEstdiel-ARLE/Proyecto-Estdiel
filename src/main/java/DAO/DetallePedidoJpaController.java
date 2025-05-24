package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.DetallePedido;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Producto;
import Modelo.Pedido;
import Modelo.Lote;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DetallePedidoJpaController implements Serializable {

    public DetallePedidoJpaController() {
        emf=Persistence.createEntityManagerFactory("persistencia");
    }

    public DetallePedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetallePedido detallePedido) {
        if (detallePedido.getLotesGenerados() == null) {
            detallePedido.setLotesGenerados(new ArrayList<Lote>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto = detallePedido.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getIdProducto());
                detallePedido.setProducto(producto);
            }
            Pedido pedido = detallePedido.getPedido();
            if (pedido != null) {
                pedido = em.getReference(pedido.getClass(), pedido.getIdPedido());
                detallePedido.setPedido(pedido);
            }
            List<Lote> attachedLotesGenerados = new ArrayList<Lote>();
            for (Lote lotesGeneradosLoteToAttach : detallePedido.getLotesGenerados()) {
                lotesGeneradosLoteToAttach = em.getReference(lotesGeneradosLoteToAttach.getClass(), lotesGeneradosLoteToAttach.getIdLote());
                attachedLotesGenerados.add(lotesGeneradosLoteToAttach);
            }
            detallePedido.setLotesGenerados(attachedLotesGenerados);
            em.persist(detallePedido);
            if (producto != null) {
                producto.getDetalles().add(detallePedido);
                producto = em.merge(producto);
            }
            if (pedido != null) {
                pedido.getDetalles().add(detallePedido);
                pedido = em.merge(pedido);
            }
            for (Lote lotesGeneradosLote : detallePedido.getLotesGenerados()) {
                DetallePedido oldDetalleOrigenOfLotesGeneradosLote = lotesGeneradosLote.getDetalleOrigen();
                lotesGeneradosLote.setDetalleOrigen(detallePedido);
                lotesGeneradosLote = em.merge(lotesGeneradosLote);
                if (oldDetalleOrigenOfLotesGeneradosLote != null) {
                    oldDetalleOrigenOfLotesGeneradosLote.getLotesGenerados().remove(lotesGeneradosLote);
                    oldDetalleOrigenOfLotesGeneradosLote = em.merge(oldDetalleOrigenOfLotesGeneradosLote);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetallePedido detallePedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetallePedido persistentDetallePedido = em.find(DetallePedido.class, detallePedido.getIdDetallePedido());
            Producto productoOld = persistentDetallePedido.getProducto();
            Producto productoNew = detallePedido.getProducto();
            Pedido pedidoOld = persistentDetallePedido.getPedido();
            Pedido pedidoNew = detallePedido.getPedido();
            List<Lote> lotesGeneradosOld = persistentDetallePedido.getLotesGenerados();
            List<Lote> lotesGeneradosNew = detallePedido.getLotesGenerados();
            if (productoNew != null) {
                productoNew = em.getReference(productoNew.getClass(), productoNew.getIdProducto());
                detallePedido.setProducto(productoNew);
            }
            if (pedidoNew != null) {
                pedidoNew = em.getReference(pedidoNew.getClass(), pedidoNew.getIdPedido());
                detallePedido.setPedido(pedidoNew);
            }
            List<Lote> attachedLotesGeneradosNew = new ArrayList<Lote>();
            for (Lote lotesGeneradosNewLoteToAttach : lotesGeneradosNew) {
                lotesGeneradosNewLoteToAttach = em.getReference(lotesGeneradosNewLoteToAttach.getClass(), lotesGeneradosNewLoteToAttach.getIdLote());
                attachedLotesGeneradosNew.add(lotesGeneradosNewLoteToAttach);
            }
            lotesGeneradosNew = attachedLotesGeneradosNew;
            detallePedido.setLotesGenerados(lotesGeneradosNew);
            detallePedido = em.merge(detallePedido);
            if (productoOld != null && !productoOld.equals(productoNew)) {
                productoOld.getDetalles().remove(detallePedido);
                productoOld = em.merge(productoOld);
            }
            if (productoNew != null && !productoNew.equals(productoOld)) {
                productoNew.getDetalles().add(detallePedido);
                productoNew = em.merge(productoNew);
            }
            if (pedidoOld != null && !pedidoOld.equals(pedidoNew)) {
                pedidoOld.getDetalles().remove(detallePedido);
                pedidoOld = em.merge(pedidoOld);
            }
            if (pedidoNew != null && !pedidoNew.equals(pedidoOld)) {
                pedidoNew.getDetalles().add(detallePedido);
                pedidoNew = em.merge(pedidoNew);
            }
            for (Lote lotesGeneradosOldLote : lotesGeneradosOld) {
                if (!lotesGeneradosNew.contains(lotesGeneradosOldLote)) {
                    lotesGeneradosOldLote.setDetalleOrigen(null);
                    lotesGeneradosOldLote = em.merge(lotesGeneradosOldLote);
                }
            }
            for (Lote lotesGeneradosNewLote : lotesGeneradosNew) {
                if (!lotesGeneradosOld.contains(lotesGeneradosNewLote)) {
                    DetallePedido oldDetalleOrigenOfLotesGeneradosNewLote = lotesGeneradosNewLote.getDetalleOrigen();
                    lotesGeneradosNewLote.setDetalleOrigen(detallePedido);
                    lotesGeneradosNewLote = em.merge(lotesGeneradosNewLote);
                    if (oldDetalleOrigenOfLotesGeneradosNewLote != null && !oldDetalleOrigenOfLotesGeneradosNewLote.equals(detallePedido)) {
                        oldDetalleOrigenOfLotesGeneradosNewLote.getLotesGenerados().remove(lotesGeneradosNewLote);
                        oldDetalleOrigenOfLotesGeneradosNewLote = em.merge(oldDetalleOrigenOfLotesGeneradosNewLote);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = detallePedido.getIdDetallePedido();
                if (findDetallePedido(id) == null) {
                    throw new NonexistentEntityException("The detallePedido with id " + id + " no longer exists.");
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
            DetallePedido detallePedido;
            try {
                detallePedido = em.getReference(DetallePedido.class, id);
                detallePedido.getIdDetallePedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detallePedido with id " + id + " no longer exists.", enfe);
            }
            Producto producto = detallePedido.getProducto();
            if (producto != null) {
                producto.getDetalles().remove(detallePedido);
                producto = em.merge(producto);
            }
            Pedido pedido = detallePedido.getPedido();
            if (pedido != null) {
                pedido.getDetalles().remove(detallePedido);
                pedido = em.merge(pedido);
            }
            List<Lote> lotesGenerados = detallePedido.getLotesGenerados();
            for (Lote lotesGeneradosLote : lotesGenerados) {
                lotesGeneradosLote.setDetalleOrigen(null);
                lotesGeneradosLote = em.merge(lotesGeneradosLote);
            }
            em.remove(detallePedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetallePedido> findDetallePedidoEntities() {
        return findDetallePedidoEntities(true, -1, -1);
    }

    public List<DetallePedido> findDetallePedidoEntities(int maxResults, int firstResult) {
        return findDetallePedidoEntities(false, maxResults, firstResult);
    }

    private List<DetallePedido> findDetallePedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetallePedido.class));
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

    public DetallePedido findDetallePedido(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetallePedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetallePedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetallePedido> rt = cq.from(DetallePedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
