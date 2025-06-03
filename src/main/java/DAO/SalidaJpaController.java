package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.DetalleSalida;
import Modelo.Lote;
import Modelo.Salida;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SalidaJpaController implements Serializable {

    public SalidaJpaController() {
        emf = Persistence.createEntityManagerFactory("persistencia");
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

            // Inicializa la lista si es null
            if (salida.getDetalles() == null) {
                salida.setDetalles(new ArrayList<>());
            }

            // Manejar relación bidireccional con DetalleSalida
            List<DetalleSalida> attachedDetalles = new ArrayList<>();
            for (DetalleSalida detalle : salida.getDetalles()) {
                detalle.setSalida(salida);
                if (detalle.getLote() != null) {
                    Lote lote = em.getReference(Lote.class, detalle.getLote().getIdLote());
                    detalle.setLote(lote);
                    lote.setDetalleSalida(detalle);
                    em.merge(lote);
                }
                attachedDetalles.add(detalle);
            }

            salida.setDetalles(attachedDetalles);
            em.persist(salida);

            for (DetalleSalida detalle : attachedDetalles) {
                em.persist(detalle);
            }

            if (usuario != null) {
                usuario.getSalidas().add(salida);
                em.merge(usuario);
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

            // Actualiza usuario si cambió
            if (usuarioNew != null) {
                usuarioNew = em.getReference(usuarioNew.getClass(), usuarioNew.getIdUsuario());
                salida.setUsuario(usuarioNew);
            }

            // Actualiza lista de detalles
            List<DetalleSalida> oldDetalles = persistentSalida.getDetalles();
            List<DetalleSalida> newDetalles = salida.getDetalles();

            List<DetalleSalida> attachedNewDetalles = new ArrayList<>();
            for (DetalleSalida detalle : newDetalles) {
                detalle.setSalida(salida);
                if (detalle.getLote() != null) {
                    Lote lote = em.getReference(Lote.class, detalle.getLote().getIdLote());
                    detalle.setLote(lote);
                    lote.setDetalleSalida(detalle);
                    em.merge(lote);
                }
                attachedNewDetalles.add(detalle);
            }

            salida.setDetalles(attachedNewDetalles);
            salida = em.merge(salida);

            // Eliminar detalles que ya no están
            for (DetalleSalida oldDetalle : oldDetalles) {
                if (!attachedNewDetalles.contains(oldDetalle)) {
                    Lote lote = oldDetalle.getLote();
                    if (lote != null) {
                        lote.setDetalleSalida(null);
                        em.merge(lote);
                    }
                    em.remove(em.contains(oldDetalle) ? oldDetalle : em.merge(oldDetalle));
                }
            }

            // Persistir nuevos detalles si son nuevos
            for (DetalleSalida newDetalle : attachedNewDetalles) {
                if (!oldDetalles.contains(newDetalle)) {
                    em.persist(newDetalle);
                }
            }

            // Manejo de relación usuario
            if (usuarioOld != null && !usuarioOld.equals(usuarioNew)) {
                usuarioOld.getSalidas().remove(salida);
                em.merge(usuarioOld);
            }
            if (usuarioNew != null && !usuarioNew.equals(usuarioOld)) {
                usuarioNew.getSalidas().add(salida);
                em.merge(usuarioNew);
            }

            em.getTransaction().commit();
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

            // Eliminar detalles
            for (DetalleSalida detalle : salida.getDetalles()) {
                Lote lote = detalle.getLote();
                if (lote != null) {
                    lote.setDetalleSalida(null);
                    em.merge(lote);
                }
                em.remove(em.contains(detalle) ? detalle : em.merge(detalle));
            }

            Usuario usuario = salida.getUsuario();
            if (usuario != null) {
                usuario.getSalidas().remove(salida);
                em.merge(usuario);
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

    public List<Salida> buscarPorRangoFecha(Date desde, Date hasta) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT s FROM Salida s WHERE s.fechaSalida BETWEEN :desde AND :hasta", Salida.class)
                    .setParameter("desde", desde)
                    .setParameter("hasta", hasta)
                    .getResultList();
        } finally {
            em.close();
        }
    }

}
