package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.Pais;
import Modelo.Producto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PaisJpaController implements Serializable {

    public PaisJpaController() {
        emf = Persistence.createEntityManagerFactory("persistencia");
    }

    public PaisJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pais pais) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pais);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pais pais) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pais = em.merge(pais);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = pais.getId();
                if (findPais(id) == null) {
                    throw new NonexistentEntityException("The pais with id " + id + " no longer exists.");
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
            Pais pais;
            try {
                pais = em.getReference(Pais.class, id);
                pais.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pais with id " + id + " no longer exists.", enfe);
            }
            em.remove(pais);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pais> findPaisEntities() {
        return findPaisEntities(true, -1, -1);
    }

    public List<Pais> findPaisEntities(int maxResults, int firstResult) {
        return findPaisEntities(false, maxResults, firstResult);
    }

    private List<Pais> findPaisEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pais.class));
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

    public Pais findPais(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pais.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaisCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pais> rt = cq.from(Pais.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    
      public Pais findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        String query = "SELECT p FROM Pais p WHERE LOWER(p.nombre) = LOWER(:nombre)";
        try {
            return em.createQuery(query, Pais.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }
}
