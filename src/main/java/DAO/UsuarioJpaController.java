package DAO;

import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Salida;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController() {
        emf = Persistence.createEntityManagerFactory("persistencia");
    }

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) {
        if (usuario.getSalidas() == null) {
            usuario.setSalidas(new ArrayList<Salida>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Salida> attachedSalidas = new ArrayList<Salida>();
            for (Salida salidasSalidaToAttach : usuario.getSalidas()) {
                salidasSalidaToAttach = em.getReference(salidasSalidaToAttach.getClass(), salidasSalidaToAttach.getIdSalida());
                attachedSalidas.add(salidasSalidaToAttach);
            }
            usuario.setSalidas(attachedSalidas);
            em.persist(usuario);
            for (Salida salidasSalida : usuario.getSalidas()) {
                Usuario oldUsuarioOfSalidasSalida = salidasSalida.getUsuario();
                salidasSalida.setUsuario(usuario);
                salidasSalida = em.merge(salidasSalida);
                if (oldUsuarioOfSalidasSalida != null) {
                    oldUsuarioOfSalidasSalida.getSalidas().remove(salidasSalida);
                    oldUsuarioOfSalidasSalida = em.merge(oldUsuarioOfSalidasSalida);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getIdUsuario());
            List<Salida> salidasOld = persistentUsuario.getSalidas();
            List<Salida> salidasNew = usuario.getSalidas();
            List<Salida> attachedSalidasNew = new ArrayList<Salida>();
            for (Salida salidasNewSalidaToAttach : salidasNew) {
                salidasNewSalidaToAttach = em.getReference(salidasNewSalidaToAttach.getClass(), salidasNewSalidaToAttach.getIdSalida());
                attachedSalidasNew.add(salidasNewSalidaToAttach);
            }
            salidasNew = attachedSalidasNew;
            usuario.setSalidas(salidasNew);
            usuario = em.merge(usuario);
            for (Salida salidasOldSalida : salidasOld) {
                if (!salidasNew.contains(salidasOldSalida)) {
                    salidasOldSalida.setUsuario(null);
                    salidasOldSalida = em.merge(salidasOldSalida);
                }
            }
            for (Salida salidasNewSalida : salidasNew) {
                if (!salidasOld.contains(salidasNewSalida)) {
                    Usuario oldUsuarioOfSalidasNewSalida = salidasNewSalida.getUsuario();
                    salidasNewSalida.setUsuario(usuario);
                    salidasNewSalida = em.merge(salidasNewSalida);
                    if (oldUsuarioOfSalidasNewSalida != null && !oldUsuarioOfSalidasNewSalida.equals(usuario)) {
                        oldUsuarioOfSalidasNewSalida.getSalidas().remove(salidasNewSalida);
                        oldUsuarioOfSalidasNewSalida = em.merge(oldUsuarioOfSalidasNewSalida);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = usuario.getIdUsuario();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getIdUsuario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<Salida> salidas = usuario.getSalidas();
            for (Salida salidasSalida : salidas) {
                salidasSalida.setUsuario(null);
                salidasSalida = em.merge(salidasSalida);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public Usuario findUsuarioByDniAndPassword(String dni, String password) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.dni = :dni AND u.password = :password");
            query.setParameter("dni", dni);
            query.setParameter("password", password);

            List<Usuario> usuarios = query.getResultList();
            return usuarios.isEmpty() ? null : usuarios.get(0);
        } finally {
            em.close();
        }
    }

    public Usuario findByDni(String dni) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT u FROM Usuario u WHERE u.dni = :dni", Usuario.class)
                    .setParameter("dni", dni)
                    .getResultStream() // devuelve Optional
                    .findFirst()
                    .orElse(null);
        } finally {
            em.close();
        }
    }

}
