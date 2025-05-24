package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.Salida;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SalidaJpaController implements Serializable {

    public SalidaJpaController() {
        emf=Persistence.createEntityManagerFactory("persistencia");
    }

    public SalidaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Salida salida) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario usuario = salida.getUsuario();
            if (usuario != null) {
                usuario = em.getReference(usuario.getClass(), usuario.getIdUsuario());
                salida.setUsuario(usuario);
            }
            em.persist(salida);
            if (usuario != null) {
                usuario.getSalidas().add(salida);
                usuario = em.merge(usuario);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Salida salida) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Salida persistentSalida = em.find(Salida.class, salida.getIdSalida());
            Usuario usuarioOld = persistentSalida.getUsuario();
            Usuario usuarioNew = salida.getUsuario();
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getIdUsuario());
                salida.setUsuario(usuarioNew);
            }
            salida = em.merge(salida);
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.getSalidas().remove(salida);
                usuarioOld = em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                usuarioNew.getSalidas().add(salida);
                usuarioNew = em.merge(usuarioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = salida.getIdSalida();
                if (findSalida(id) == null) {
                    throw new NonexistentEntityException("The salida with id " + id + " no longer exists.");
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
            Salida salida;
            try {
                salida = em.getReference(Salida.class, id);
                salida.getIdSalida();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The salida with id " + id + " no longer exists.", enfe);
            }
            Usuario usuario = salida.getUsuario();
            if (usuario != null) {
                usuario.getSalidas().remove(salida);
                usuario = em.merge(usuario);
            }
            em.remove(salida);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Salida> findSalidaEntities() {
        return findSalidaEntities(true, -1, -1);
    }

    public List<Salida> findSalidaEntities(int maxResults, int firstResult) {
        return findSalidaEntities(false, maxResults, firstResult);
    }

    private List<Salida> findSalidaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Salida.class));
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

    public Salida findSalida(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Salida.class, id);
        } finally {
            em.close();
        }
    }

    public int getSalidaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Salida> rt = cq.from(Salida.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
