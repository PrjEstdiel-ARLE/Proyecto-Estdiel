package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.DetalleSolicitud;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Solicitud;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DetalleSolicitudJpaController implements Serializable {

    public DetalleSolicitudJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public DetalleSolicitudJpaController() {
        emf = Persistence.createEntityManagerFactory("persistencia");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleSolicitud detalleSolicitud) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Solicitud solicitud = detalleSolicitud.getSolicitud();
            if (solicitud != null) {
                solicitud = em.getReference(solicitud.getClass(), solicitud.getIdSolicitud());
                detalleSolicitud.setSolicitud(solicitud);
            }
            em.persist(detalleSolicitud);
            if (solicitud != null) {
                solicitud.getDetalles().add(detalleSolicitud);
                solicitud = em.merge(solicitud);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleSolicitud detalleSolicitud) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleSolicitud persistentDetalleSolicitud = em.find(DetalleSolicitud.class, detalleSolicitud.getIdDetalle());
            Solicitud solicitudOld = persistentDetalleSolicitud.getSolicitud();
            Solicitud solicitudNew = detalleSolicitud.getSolicitud();
            if (solicitudNew != null) {
                solicitudNew = em.getReference(solicitudNew.getClass(), solicitudNew.getIdSolicitud());
                detalleSolicitud.setSolicitud(solicitudNew);
            }
            detalleSolicitud = em.merge(detalleSolicitud);
            if (solicitudOld != null && !solicitudOld.equals(solicitudNew)) {
                solicitudOld.getDetalles().remove(detalleSolicitud);
                solicitudOld = em.merge(solicitudOld);
            }
            if (solicitudNew != null && !solicitudNew.equals(solicitudOld)) {
                solicitudNew.getDetalles().add(detalleSolicitud);
                solicitudNew = em.merge(solicitudNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = detalleSolicitud.getIdDetalle();
                if (findDetalleSolicitud(id) == null) {
                    throw new NonexistentEntityException("The detalleSolicitud with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleSolicitud detalleSolicitud;
            try {
                detalleSolicitud = em.getReference(DetalleSolicitud.class, id);
                detalleSolicitud.getIdDetalle();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleSolicitud with id " + id + " no longer exists.", enfe);
            }
            Solicitud solicitud = detalleSolicitud.getSolicitud();
            if (solicitud != null) {
                solicitud.getDetalles().remove(detalleSolicitud);
                solicitud = em.merge(solicitud);
            }
            em.remove(detalleSolicitud);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleSolicitud> findDetalleSolicitudEntities() {
        return findDetalleSolicitudEntities(true, -1, -1);
    }

    public List<DetalleSolicitud> findDetalleSolicitudEntities(int maxResults, int firstResult) {
        return findDetalleSolicitudEntities(false, maxResults, firstResult);
    }

    private List<DetalleSolicitud> findDetalleSolicitudEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleSolicitud.class));
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

    public DetalleSolicitud findDetalleSolicitud(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleSolicitud.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleSolicitudCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleSolicitud> rt = cq.from(DetalleSolicitud.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<DetalleSolicitud> findBySolicitud(Solicitud solicitud) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT dp FROM DetalleSolicitud dp WHERE dp.solicitud = :solicitud", DetalleSolicitud.class
            ).setParameter("solicitud", solicitud)
                    .getResultList();
        } finally {
            em.close();
        }
    }

}
