package DAO;

import DAO.exceptions.NonexistentEntityException;
import Modelo.Categoria;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class CategoriaJpaController implements Serializable {

    public CategoriaJpaController() {
        emf = Persistence.createEntityManagerFactory("persistencia");
    }

    public CategoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Categoria categoria) {
        if (categoria.getProductos() == null) {
            categoria.setProductos(new ArrayList<Producto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Producto> attachedProductos = new ArrayList<Producto>();
            for (Producto productosProductoToAttach : categoria.getProductos()) {
                productosProductoToAttach = em.getReference(productosProductoToAttach.getClass(), productosProductoToAttach.getIdProducto());
                attachedProductos.add(productosProductoToAttach);
            }
            categoria.setProductos(attachedProductos);
            em.persist(categoria);
            for (Producto productosProducto : categoria.getProductos()) {
                Categoria oldCategoriaOfProductosProducto = productosProducto.getCategoria();
                productosProducto.setCategoria(categoria);
                productosProducto = em.merge(productosProducto);
                if (oldCategoriaOfProductosProducto != null) {
                    oldCategoriaOfProductosProducto.getProductos().remove(productosProducto);
                    oldCategoriaOfProductosProducto = em.merge(oldCategoriaOfProductosProducto);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Categoria categoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria persistentCategoria = em.find(Categoria.class, categoria.getIdCategoria());
            List<Producto> productosOld = persistentCategoria.getProductos();
            List<Producto> productosNew = categoria.getProductos();
            List<Producto> attachedProductosNew = new ArrayList<Producto>();
            for (Producto productosNewProductoToAttach : productosNew) {
                productosNewProductoToAttach = em.getReference(productosNewProductoToAttach.getClass(), productosNewProductoToAttach.getIdProducto());
                attachedProductosNew.add(productosNewProductoToAttach);
            }
            productosNew = attachedProductosNew;
            categoria.setProductos(productosNew);
            categoria = em.merge(categoria);
            for (Producto productosOldProducto : productosOld) {
                if (!productosNew.contains(productosOldProducto)) {
                    productosOldProducto.setCategoria(null);
                    productosOldProducto = em.merge(productosOldProducto);
                }
            }
            for (Producto productosNewProducto : productosNew) {
                if (!productosOld.contains(productosNewProducto)) {
                    Categoria oldCategoriaOfProductosNewProducto = productosNewProducto.getCategoria();
                    productosNewProducto.setCategoria(categoria);
                    productosNewProducto = em.merge(productosNewProducto);
                    if (oldCategoriaOfProductosNewProducto != null && !oldCategoriaOfProductosNewProducto.equals(categoria)) {
                        oldCategoriaOfProductosNewProducto.getProductos().remove(productosNewProducto);
                        oldCategoriaOfProductosNewProducto = em.merge(oldCategoriaOfProductosNewProducto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = categoria.getIdCategoria();
                if (findCategoria(id) == null) {
                    throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.");
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
            Categoria categoria;
            try {
                categoria = em.getReference(Categoria.class, id);
                categoria.getIdCategoria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.", enfe);
            }
            List<Producto> productos = categoria.getProductos();
            for (Producto productosProducto : productos) {
                productosProducto.setCategoria(null);
                productosProducto = em.merge(productosProducto);
            }
            em.remove(categoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Categoria> findCategoriaEntities() {
        return findCategoriaEntities(true, -1, -1);
    }

    public List<Categoria> findCategoriaEntities(int maxResults, int firstResult) {
        return findCategoriaEntities(false, maxResults, firstResult);
    }

    private List<Categoria> findCategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Categoria.class));
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

    public Categoria findCategoria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Categoria> rt = cq.from(Categoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    Categoria findByName(String nombre) {
        EntityManager em = getEntityManager();
        String query = "SELECT p FROM Categoria p WHERE LOWER(p.nombre) = LOWER(:nombre)";
        try {
            return em.createQuery(query, Categoria.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public List<String> findAllNombresCategoria() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c.nombre FROM Categoria c", String.class).getResultList();
        } finally {
            em.close();
        }
    }

    public boolean existsCategoriaWithNombre(String nombre) {
        EntityManager em = getEntityManager();
        try {
            Long count = em.createQuery(
                    "SELECT COUNT(c) FROM Categoria c WHERE c.nombre = :nombre", Long.class
            ).setParameter("nombre", nombre).getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }

    List<Categoria> buscarPorNombre(String termino) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    List<Categoria> findByNombreParcial(String termino) {
        EntityManager em = getEntityManager();
        String jpql = "SELECT p FROM Categoria p "
                + "WHERE LOWER(p.nombre) LIKE LOWER(:patron) "
                + "ORDER BY p.nombre ASC";

        try {
            return em.createQuery(jpql, Categoria.class)
                    .setParameter("patron", "%" + termino + "%") // comodín antes y después
                    .getResultList();
        } finally {
            em.close();
        }
    }

}
