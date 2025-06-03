package DAO;

import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Proveedor;
import Modelo.DetallePedido;
import Modelo.EstadoPedido;
import Modelo.Pedido;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PedidoJpaController implements Serializable {

    public PedidoJpaController() {
        emf = Persistence.createEntityManagerFactory("persistencia");
    }

    public PedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedido pedido) {
        if (pedido.getDetalles() == null) {
            pedido.setDetalles(new ArrayList<DetallePedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor proveedor = pedido.getProveedor();
            if (proveedor != null) {
                proveedor = em.getReference(proveedor.getClass(), proveedor.getIdProveedor());
                pedido.setProveedor(proveedor);
            }
            List<DetallePedido> attachedDetalles = new ArrayList<DetallePedido>();
            for (DetallePedido detallesDetallePedidoToAttach : pedido.getDetalles()) {
                detallesDetallePedidoToAttach = em.getReference(detallesDetallePedidoToAttach.getClass(), detallesDetallePedidoToAttach.getIdDetallePedido());
                attachedDetalles.add(detallesDetallePedidoToAttach);
            }
            pedido.setDetalles(attachedDetalles);
            em.persist(pedido);
            if (proveedor != null) {
                proveedor.getPedidos().add(pedido);
                proveedor = em.merge(proveedor);
            }
            for (DetallePedido detallesDetallePedido : pedido.getDetalles()) {
                Pedido oldPedidoOfDetallesDetallePedido = detallesDetallePedido.getPedido();
                detallesDetallePedido.setPedido(pedido);
                detallesDetallePedido = em.merge(detallesDetallePedido);
                if (oldPedidoOfDetallesDetallePedido != null) {
                    oldPedidoOfDetallesDetallePedido.getDetalles().remove(detallesDetallePedido);
                    oldPedidoOfDetallesDetallePedido = em.merge(oldPedidoOfDetallesDetallePedido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedido pedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido persistentPedido = em.find(Pedido.class, pedido.getIdPedido());
            Proveedor proveedorOld = persistentPedido.getProveedor();
            Proveedor proveedorNew = pedido.getProveedor();
            List<DetallePedido> detallesOld = persistentPedido.getDetalles();
            List<DetallePedido> detallesNew = pedido.getDetalles();
            if (proveedorNew != null) {
                proveedorNew = em.getReference(proveedorNew.getClass(), proveedorNew.getIdProveedor());
                pedido.setProveedor(proveedorNew);
            }
            List<DetallePedido> attachedDetallesNew = new ArrayList<DetallePedido>();
            for (DetallePedido detallesNewDetallePedidoToAttach : detallesNew) {
                detallesNewDetallePedidoToAttach = em.getReference(detallesNewDetallePedidoToAttach.getClass(), detallesNewDetallePedidoToAttach.getIdDetallePedido());
                attachedDetallesNew.add(detallesNewDetallePedidoToAttach);
            }
            detallesNew = attachedDetallesNew;
            pedido.setDetalles(detallesNew);
            pedido = em.merge(pedido);
            if (proveedorOld != null && !proveedorOld.equals(proveedorNew)) {
                proveedorOld.getPedidos().remove(pedido);
                proveedorOld = em.merge(proveedorOld);
            }
            if (proveedorNew != null && !proveedorNew.equals(proveedorOld)) {
                proveedorNew.getPedidos().add(pedido);
                proveedorNew = em.merge(proveedorNew);
            }
            for (DetallePedido detallesOldDetallePedido : detallesOld) {
                if (!detallesNew.contains(detallesOldDetallePedido)) {
                    detallesOldDetallePedido.setPedido(null);
                    detallesOldDetallePedido = em.merge(detallesOldDetallePedido);
                }
            }
            for (DetallePedido detallesNewDetallePedido : detallesNew) {
                if (!detallesOld.contains(detallesNewDetallePedido)) {
                    Pedido oldPedidoOfDetallesNewDetallePedido = detallesNewDetallePedido.getPedido();
                    detallesNewDetallePedido.setPedido(pedido);
                    detallesNewDetallePedido = em.merge(detallesNewDetallePedido);
                    if (oldPedidoOfDetallesNewDetallePedido != null && !oldPedidoOfDetallesNewDetallePedido.equals(pedido)) {
                        oldPedidoOfDetallesNewDetallePedido.getDetalles().remove(detallesNewDetallePedido);
                        oldPedidoOfDetallesNewDetallePedido = em.merge(oldPedidoOfDetallesNewDetallePedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = pedido.getIdPedido();
                if (findPedido(id) == null) {
                    throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.");
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
            Pedido pedido;
            try {
                pedido = em.getReference(Pedido.class, id);
                pedido.getIdPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.", enfe);
            }
            Proveedor proveedor = pedido.getProveedor();
            if (proveedor != null) {
                proveedor.getPedidos().remove(pedido);
                proveedor = em.merge(proveedor);
            }
            List<DetallePedido> detalles = pedido.getDetalles();
            for (DetallePedido detallesDetallePedido : detalles) {
                detallesDetallePedido.setPedido(null);
                detallesDetallePedido = em.merge(detallesDetallePedido);
            }
            em.remove(pedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedido> findPedidoEntities() {
        return findPedidoEntities(true, -1, -1);
    }

    public List<Pedido> findPedidoEntities(int maxResults, int firstResult) {
        return findPedidoEntities(false, maxResults, firstResult);
    }

    private List<Pedido> findPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedido.class));
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

    public Pedido findPedido(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedido> rt = cq.from(Pedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void actualizarEstado(int idPedido, EstadoPedido nuevoEstado) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Pedido pedido = em.find(Pedido.class, idPedido);
            if (pedido != null) {
                pedido.setEstado(nuevoEstado);
                em.merge(pedido);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    public List<Pedido> findPedidosPorEstado(EstadoPedido estado) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT p FROM Pedido p WHERE p.estado = :estado", Pedido.class
            ).setParameter("estado", estado).getResultList();
        } finally {
            em.close();
        }
    }

    public List<Pedido> findPedidosPorProveedor(int idProveedor) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT p FROM Pedido p WHERE p.proveedor.idProveedor = :idProveedor", Pedido.class
            ).setParameter("idProveedor", idProveedor)
                    .getResultList();
        } finally {
            em.close();
        }
    }

}
