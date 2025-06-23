package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.ContactoProveedor;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Proveedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContactoProveedorJpaController implements Serializable {

    public ContactoProveedorJpaController() {
        emf = Persistence.createEntityManagerFactory("persistencia");
    }

    public ContactoProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ContactoProveedor contactoProveedor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor proveedor = contactoProveedor.getProveedor();
            if (proveedor != null) {
                proveedor = em.getReference(proveedor.getClass(), proveedor.getIdProveedor());
                contactoProveedor.setProveedor(proveedor);
            }
            em.persist(contactoProveedor);
            if (proveedor != null) {
                proveedor.getContactos().add(contactoProveedor);
                proveedor = em.merge(proveedor);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ContactoProveedor contactoProveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ContactoProveedor persistentContactoProveedor = em.find(ContactoProveedor.class, contactoProveedor.getIdContacto());
            Proveedor proveedorOld = persistentContactoProveedor.getProveedor();
            Proveedor proveedorNew = contactoProveedor.getProveedor();
            if (proveedorNew != null) {
                proveedorNew = em.getReference(proveedorNew.getClass(), proveedorNew.getIdProveedor());
                contactoProveedor.setProveedor(proveedorNew);
            }
            contactoProveedor = em.merge(contactoProveedor);
            if (proveedorOld != null && !proveedorOld.equals(proveedorNew)) {
                proveedorOld.getContactos().remove(contactoProveedor);
                proveedorOld = em.merge(proveedorOld);
            }
            if (proveedorNew != null && !proveedorNew.equals(proveedorOld)) {
                proveedorNew.getContactos().add(contactoProveedor);
                proveedorNew = em.merge(proveedorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = contactoProveedor.getIdContacto();
                if (findContactoProveedor(id) == null) {
                    throw new NonexistentEntityException("The contactoProveedor with id " + id + " no longer exists.");
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
            ContactoProveedor contactoProveedor;
            try {
                contactoProveedor = em.getReference(ContactoProveedor.class, id);
                contactoProveedor.getIdContacto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contactoProveedor with id " + id + " no longer exists.", enfe);
            }
            Proveedor proveedor = contactoProveedor.getProveedor();
            if (proveedor != null) {
                proveedor.getContactos().remove(contactoProveedor);
                proveedor = em.merge(proveedor);
            }
            em.remove(contactoProveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ContactoProveedor> findContactoProveedorEntities() {
        return findContactoProveedorEntities(true, -1, -1);
    }

    public List<ContactoProveedor> findContactoProveedorEntities(int maxResults, int firstResult) {
        return findContactoProveedorEntities(false, maxResults, firstResult);
    }

    private List<ContactoProveedor> findContactoProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ContactoProveedor.class));
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

    public ContactoProveedor findContactoProveedor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ContactoProveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getContactoProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ContactoProveedor> rt = cq.from(ContactoProveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<ContactoProveedor> findByProveedor(Proveedor proveedor) {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery(
                    "SELECT ds FROM ContactoProveedor ds WHERE ds.proveedor= :proveedor", ContactoProveedor.class)
                    .setParameter("proveedor", proveedor)
                    .getResultList();
        } finally {
            em.close();
        }
    }

}
