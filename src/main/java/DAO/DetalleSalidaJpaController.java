package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.DetalleSalida;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Lote;
import Modelo.Salida;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DetalleSalidaJpaController implements Serializable {

    public DetalleSalidaJpaController() {
        emf = Persistence.createEntityManagerFactory("persistencia");
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

            // Lote
            Lote lote = detalleSalida.getLote();
            if (lote != null) {
                lote = em.getReference(lote.getClass(), lote.getIdLote());
                detalleSalida.setLote(lote);
            }

            // Salida
            Salida salida = detalleSalida.getSalida();
            if (salida != null) {
                salida = em.getReference(salida.getClass(), salida.getIdSalida());
                detalleSalida.setSalida(salida);
            }

            em.persist(detalleSalida);

            // Relación bidireccional con Lote
            if (lote != null) {
                DetalleSalida oldDetalle = lote.getDetalleSalida();
                if (oldDetalle != null) {
                    oldDetalle.setLote(null);
                    em.merge(oldDetalle);
                }
                lote.setDetalleSalida(detalleSalida);
                em.merge(lote);
            }

            // Relación bidireccional con Salida
            if (salida != null) {
                if (salida.getDetalles() == null) {
                    salida.setDetalles(new ArrayList<>());
                }
                salida.getDetalles().add(detalleSalida);
                em.merge(salida);
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

            DetalleSalida persistent = em.find(DetalleSalida.class, detalleSalida.getIdDetalleSalida());
            Lote loteOld = persistent.getLote();
            Lote loteNew = detalleSalida.getLote();

            Salida salidaOld = persistent.getSalida();
            Salida salidaNew = detalleSalida.getSalida();

            // Actualizar lote
            if (loteNew != null) {
                loteNew = em.getReference(loteNew.getClass(), loteNew.getIdLote());
                detalleSalida.setLote(loteNew);
            }

            // Actualizar salida
            if (salidaNew != null) {
                salidaNew = em.getReference(salidaNew.getClass(), salidaNew.getIdSalida());
                detalleSalida.setSalida(salidaNew);
            }

            detalleSalida = em.merge(detalleSalida);

            // Actualizar relación con Lote
            if (loteOld != null && !loteOld.equals(loteNew)) {
                loteOld.setDetalleSalida(null);
                em.merge(loteOld);
            }
            if (loteNew != null && !loteNew.equals(loteOld)) {
                DetalleSalida oldDetalle = loteNew.getDetalleSalida();
                if (oldDetalle != null && !oldDetalle.equals(detalleSalida)) {
                    oldDetalle.setLote(null);
                    em.merge(oldDetalle);
                }
                loteNew.setDetalleSalida(detalleSalida);
                em.merge(loteNew);
            }

            // Actualizar relación con Salida
            if (salidaOld != null && !salidaOld.equals(salidaNew)) {
                salidaOld.getDetalles().remove(detalleSalida);
                em.merge(salidaOld);
            }
            if (salidaNew != null && !salidaNew.equals(salidaOld)) {
                if (salidaNew.getDetalles() == null) {
                    salidaNew.setDetalles(new ArrayList<>());
                }
                salidaNew.getDetalles().add(detalleSalida);
                em.merge(salidaNew);
            }

            em.getTransaction().commit();
        } catch (Exception ex) {
            if (detalleSalida.getIdDetalleSalida() == 0 || findDetalleSalida(detalleSalida.getIdDetalleSalida()) == null) {
                throw new NonexistentEntityException("El detalleSalida con ID " + detalleSalida.getIdDetalleSalida() + " no existe.", ex);
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
                throw new NonexistentEntityException("El detalleSalida con ID " + id + " no existe.", enfe);
            }

            // Lote
            Lote lote = detalleSalida.getLote();
            if (lote != null) {
                lote.setDetalleSalida(null);
                em.merge(lote);
            }

            // Salida
            Salida salida = detalleSalida.getSalida();
            if (salida != null) {
                salida.getDetalles().remove(detalleSalida);
                em.merge(salida);
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

    public List<DetalleSalida> findBySalida(Salida salida) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT ds FROM DetalleSalida ds WHERE ds.salida = :salida", DetalleSalida.class)
                    .setParameter("salida", salida)
                    .getResultList();
        } finally {
            em.close();
        }
    }

}
