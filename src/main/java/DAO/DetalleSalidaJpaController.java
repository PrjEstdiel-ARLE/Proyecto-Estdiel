package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.DetalleSalida;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Lote;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DetalleSalidaJpaController implements Serializable {

    public DetalleSalidaJpaController() {
        emf=Persistence.createEntityManagerFactory("persistencia");
    }

    public DetalleSalidaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DetalleSalida detalleSalida) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lote lote = detalleSalida.getLote();
            if (lote != null) {
                lote = em.getReference(lote.getClass(), lote.getIdLote());
                detalleSalida.setLote(lote);
            }
            em.persist(detalleSalida);
            if (lote != null) {
                DetalleSalida oldDetalleSalidaOfLote = lote.getDetalleSalida();
                if (oldDetalleSalidaOfLote != null) {
                    oldDetalleSalidaOfLote.setLote(null);
                    oldDetalleSalidaOfLote = em.merge(oldDetalleSalidaOfLote);
                }
                lote.setDetalleSalida(detalleSalida);
                lote = em.merge(lote);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DetalleSalida detalleSalida) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DetalleSalida persistentDetalleSalida = em.find(DetalleSalida.class, detalleSalida.getIdDetalleSalida());
            Lote loteOld = persistentDetalleSalida.getLote();
            Lote loteNew = detalleSalida.getLote();
            if (loteNew != null) {
                loteNew = em.getReference(loteNew.getClass(), loteNew.getIdLote());
                detalleSalida.setLote(loteNew);
            }
            detalleSalida = em.merge(detalleSalida);
            if (loteOld != null && !loteOld.equals(loteNew)) {
                loteOld.setDetalleSalida(null);
                loteOld = em.merge(loteOld);
            }
            if (loteNew != null && !loteNew.equals(loteOld)) {
                DetalleSalida oldDetalleSalidaOfLote = loteNew.getDetalleSalida();
                if (oldDetalleSalidaOfLote != null) {
                    oldDetalleSalidaOfLote.setLote(null);
                    oldDetalleSalidaOfLote = em.merge(oldDetalleSalidaOfLote);
                }
                loteNew.setDetalleSalida(detalleSalida);
                loteNew = em.merge(loteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = detalleSalida.getIdDetalleSalida();
                if (findDetalleSalida(id) == null) {
                    throw new NonexistentEntityException("The detalleSalida with id " + id + " no longer exists.");
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
            DetalleSalida detalleSalida;
            try {
                detalleSalida = em.getReference(DetalleSalida.class, id);
                detalleSalida.getIdDetalleSalida();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The detalleSalida with id " + id + " no longer exists.", enfe);
            }
            Lote lote = detalleSalida.getLote();
            if (lote != null) {
                lote.setDetalleSalida(null);
                lote = em.merge(lote);
            }
            em.remove(detalleSalida);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DetalleSalida> findDetalleSalidaEntities() {
        return findDetalleSalidaEntities(true, -1, -1);
    }

    public List<DetalleSalida> findDetalleSalidaEntities(int maxResults, int firstResult) {
        return findDetalleSalidaEntities(false, maxResults, firstResult);
    }

    private List<DetalleSalida> findDetalleSalidaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DetalleSalida.class));
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

    public DetalleSalida findDetalleSalida(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DetalleSalida.class, id);
        } finally {
            em.close();
        }
    }

    public int getDetalleSalidaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DetalleSalida> rt = cq.from(DetalleSalida.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
