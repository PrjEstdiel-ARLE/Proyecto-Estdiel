package DAO;

import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.DetalleSolicitud;
import Modelo.Solicitud;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SolicitudJpaController implements Serializable {

    public SolicitudJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public SolicitudJpaController() {
        emf = Persistence.createEntityManagerFactory("persistencia");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Solicitud solicitud) {
        if (solicitud.getDetalles() == null) {
            solicitud.setDetalles(new HashSet<DetalleSolicitud>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Set<DetalleSolicitud> attachedDetalles = new HashSet<DetalleSolicitud>();
            for (DetalleSolicitud detallesDetalleSolicitudToAttach : solicitud.getDetalles()) {
                detallesDetalleSolicitudToAttach = em.getReference(detallesDetalleSolicitudToAttach.getClass(), detallesDetalleSolicitudToAttach.getIdDetalle());
                attachedDetalles.add(detallesDetalleSolicitudToAttach);
            }
            solicitud.setDetalles(attachedDetalles);
            em.persist(solicitud);
            for (DetalleSolicitud detallesDetalleSolicitud : solicitud.getDetalles()) {
                Solicitud oldSolicitudOfDetallesDetalleSolicitud = detallesDetalleSolicitud.getSolicitud();
                detallesDetalleSolicitud.setSolicitud(solicitud);
                detallesDetalleSolicitud = em.merge(detallesDetalleSolicitud);
                if (oldSolicitudOfDetallesDetalleSolicitud != null) {
                    oldSolicitudOfDetallesDetalleSolicitud.getDetalles().remove(detallesDetalleSolicitud);
                    oldSolicitudOfDetallesDetalleSolicitud = em.merge(oldSolicitudOfDetallesDetalleSolicitud);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Solicitud solicitud) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Solicitud persistentSolicitud = em.find(Solicitud.class, solicitud.getIdSolicitud());
            Set<DetalleSolicitud> detallesOld = persistentSolicitud.getDetalles();
            Set<DetalleSolicitud> detallesNew = solicitud.getDetalles();
            List<String> illegalOrphanMessages = null;
            for (DetalleSolicitud detallesOldDetalleSolicitud : detallesOld) {
                if (!detallesNew.contains(detallesOldDetalleSolicitud)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain DetalleSolicitud " + detallesOldDetalleSolicitud + " since its solicitud field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Set<DetalleSolicitud> attachedDetallesNew = new HashSet<DetalleSolicitud>();
            for (DetalleSolicitud detallesNewDetalleSolicitudToAttach : detallesNew) {
                detallesNewDetalleSolicitudToAttach = em.getReference(detallesNewDetalleSolicitudToAttach.getClass(), detallesNewDetalleSolicitudToAttach.getIdDetalle());
                attachedDetallesNew.add(detallesNewDetalleSolicitudToAttach);
            }
            detallesNew = attachedDetallesNew;
            solicitud.setDetalles(detallesNew);
            solicitud = em.merge(solicitud);
            for (DetalleSolicitud detallesNewDetalleSolicitud : detallesNew) {
                if (!detallesOld.contains(detallesNewDetalleSolicitud)) {
                    Solicitud oldSolicitudOfDetallesNewDetalleSolicitud = detallesNewDetalleSolicitud.getSolicitud();
                    detallesNewDetalleSolicitud.setSolicitud(solicitud);
                    detallesNewDetalleSolicitud = em.merge(detallesNewDetalleSolicitud);
                    if (oldSolicitudOfDetallesNewDetalleSolicitud != null && !oldSolicitudOfDetallesNewDetalleSolicitud.equals(solicitud)) {
                        oldSolicitudOfDetallesNewDetalleSolicitud.getDetalles().remove(detallesNewDetalleSolicitud);
                        oldSolicitudOfDetallesNewDetalleSolicitud = em.merge(oldSolicitudOfDetallesNewDetalleSolicitud);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = solicitud.getIdSolicitud();
                if (findSolicitud(id) == null) {
                    throw new NonexistentEntityException("The solicitud with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Solicitud solicitud;
            try {
                solicitud = em.getReference(Solicitud.class, id);
                solicitud.getIdSolicitud();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The solicitud with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Set<DetalleSolicitud> detallesOrphanCheck = solicitud.getDetalles();
            for (DetalleSolicitud detallesOrphanCheckDetalleSolicitud : detallesOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Solicitud (" + solicitud + ") cannot be destroyed since the DetalleSolicitud " + detallesOrphanCheckDetalleSolicitud + " in its detalles field has a non-nullable solicitud field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(solicitud);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Solicitud> findSolicitudEntities() {
        return findSolicitudEntities(true, -1, -1);
    }

    public List<Solicitud> findSolicitudEntities(int maxResults, int firstResult) {
        return findSolicitudEntities(false, maxResults, firstResult);
    }

    private List<Solicitud> findSolicitudEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Solicitud.class));
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

    public Solicitud findSolicitud(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Solicitud.class, id);
        } finally {
            em.close();
        }
    }

    public int getSolicitudCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Solicitud> rt = cq.from(Solicitud.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
