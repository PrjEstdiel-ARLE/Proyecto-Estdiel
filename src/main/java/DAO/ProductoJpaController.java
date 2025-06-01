package DAO;

import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Categoria;
import Modelo.Proveedor;
import Modelo.DetallePedido;
import java.util.ArrayList;
import java.util.List;
import Modelo.Lote;
import Modelo.Producto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProductoJpaController implements Serializable {

    public ProductoJpaController() {
        emf=Persistence.createEntityManagerFactory("persistencia");
    }

    public ProductoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producto producto) {
        if (producto.getDetalles() == null) {
            producto.setDetalles(new ArrayList<DetallePedido>());
        }
        if (producto.getLotes() == null) {
            producto.setLotes(new ArrayList<Lote>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria categoria = producto.getCategoria();
            if (categoria != null) {
                categoria = em.getReference(categoria.getClass(), categoria.getIdCategoria());
                producto.setCategoria(categoria);
            }
            Proveedor proveedor = producto.getProveedor();
            if (proveedor != null) {
                proveedor = em.getReference(proveedor.getClass(), proveedor.getIdProveedor());
                producto.setProveedor(proveedor);
            }
            List<DetallePedido> attachedDetalles = new ArrayList<DetallePedido>();
            for (DetallePedido detallesDetallePedidoToAttach : producto.getDetalles()) {
                detallesDetallePedidoToAttach = em.getReference(detallesDetallePedidoToAttach.getClass(), detallesDetallePedidoToAttach.getIdDetallePedido());
                attachedDetalles.add(detallesDetallePedidoToAttach);
            }
            producto.setDetalles(attachedDetalles);
            List<Lote> attachedLotes = new ArrayList<Lote>();
            for (Lote lotesLoteToAttach : producto.getLotes()) {
                lotesLoteToAttach = em.getReference(lotesLoteToAttach.getClass(), lotesLoteToAttach.getIdLote());
                attachedLotes.add(lotesLoteToAttach);
            }
            producto.setLotes(attachedLotes);
            em.persist(producto);
            if (categoria != null) {
                categoria.getProductos().add(producto);
                categoria = em.merge(categoria);
            }
            if (proveedor != null) {
                proveedor.getProductos().add(producto);
                proveedor = em.merge(proveedor);
            }
            for (DetallePedido detallesDetallePedido : producto.getDetalles()) {
                Producto oldProductoOfDetallesDetallePedido = detallesDetallePedido.getProducto();
                detallesDetallePedido.setProducto(producto);
                detallesDetallePedido = em.merge(detallesDetallePedido);
                if (oldProductoOfDetallesDetallePedido != null) {
                    oldProductoOfDetallesDetallePedido.getDetalles().remove(detallesDetallePedido);
                    oldProductoOfDetallesDetallePedido = em.merge(oldProductoOfDetallesDetallePedido);
                }
            }
            for (Lote lotesLote : producto.getLotes()) {
                Producto oldProductoOfLotesLote = lotesLote.getProducto();
                lotesLote.setProducto(producto);
                lotesLote = em.merge(lotesLote);
                if (oldProductoOfLotesLote != null) {
                    oldProductoOfLotesLote.getLotes().remove(lotesLote);
                    oldProductoOfLotesLote = em.merge(oldProductoOfLotesLote);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producto producto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto persistentProducto = em.find(Producto.class, producto.getIdProducto());
            Categoria categoriaOld = persistentProducto.getCategoria();
            Categoria categoriaNew = producto.getCategoria();
            Proveedor proveedorOld = persistentProducto.getProveedor();
            Proveedor proveedorNew = producto.getProveedor();
            List<DetallePedido> detallesOld = persistentProducto.getDetalles();
            List<DetallePedido> detallesNew = producto.getDetalles();
            List<Lote> lotesOld = persistentProducto.getLotes();
            List<Lote> lotesNew = producto.getLotes();
            if (categoriaNew != null) {
                categoriaNew = em.getReference(categoriaNew.getClass(), categoriaNew.getIdCategoria());
                producto.setCategoria(categoriaNew);
            }
            if (proveedorNew != null) {
                proveedorNew = em.getReference(proveedorNew.getClass(), proveedorNew.getIdProveedor());
                producto.setProveedor(proveedorNew);
            }
            List<DetallePedido> attachedDetallesNew = new ArrayList<DetallePedido>();
            for (DetallePedido detallesNewDetallePedidoToAttach : detallesNew) {
                detallesNewDetallePedidoToAttach = em.getReference(detallesNewDetallePedidoToAttach.getClass(), detallesNewDetallePedidoToAttach.getIdDetallePedido());
                attachedDetallesNew.add(detallesNewDetallePedidoToAttach);
            }
            detallesNew = attachedDetallesNew;
            producto.setDetalles(detallesNew);
            List<Lote> attachedLotesNew = new ArrayList<Lote>();
            for (Lote lotesNewLoteToAttach : lotesNew) {
                lotesNewLoteToAttach = em.getReference(lotesNewLoteToAttach.getClass(), lotesNewLoteToAttach.getIdLote());
                attachedLotesNew.add(lotesNewLoteToAttach);
            }
            lotesNew = attachedLotesNew;
            producto.setLotes(lotesNew);
            producto = em.merge(producto);
            if (categoriaOld != null && !categoriaOld.equals(categoriaNew)) {
                categoriaOld.getProductos().remove(producto);
                categoriaOld = em.merge(categoriaOld);
            }
            if (categoriaNew != null && !categoriaNew.equals(categoriaOld)) {
                categoriaNew.getProductos().add(producto);
                categoriaNew = em.merge(categoriaNew);
            }
            if (proveedorOld != null && !proveedorOld.equals(proveedorNew)) {
                proveedorOld.getProductos().remove(producto);
                proveedorOld = em.merge(proveedorOld);
            }
            if (proveedorNew != null && !proveedorNew.equals(proveedorOld)) {
                proveedorNew.getProductos().add(producto);
                proveedorNew = em.merge(proveedorNew);
            }
            for (DetallePedido detallesOldDetallePedido : detallesOld) {
                if (!detallesNew.contains(detallesOldDetallePedido)) {
                    detallesOldDetallePedido.setProducto(null);
                    detallesOldDetallePedido = em.merge(detallesOldDetallePedido);
                }
            }
            for (DetallePedido detallesNewDetallePedido : detallesNew) {
                if (!detallesOld.contains(detallesNewDetallePedido)) {
                    Producto oldProductoOfDetallesNewDetallePedido = detallesNewDetallePedido.getProducto();
                    detallesNewDetallePedido.setProducto(producto);
                    detallesNewDetallePedido = em.merge(detallesNewDetallePedido);
                    if (oldProductoOfDetallesNewDetallePedido != null && !oldProductoOfDetallesNewDetallePedido.equals(producto)) {
                        oldProductoOfDetallesNewDetallePedido.getDetalles().remove(detallesNewDetallePedido);
                        oldProductoOfDetallesNewDetallePedido = em.merge(oldProductoOfDetallesNewDetallePedido);
                    }
                }
            }
            for (Lote lotesOldLote : lotesOld) {
                if (!lotesNew.contains(lotesOldLote)) {
                    lotesOldLote.setProducto(null);
                    lotesOldLote = em.merge(lotesOldLote);
                }
            }
            for (Lote lotesNewLote : lotesNew) {
                if (!lotesOld.contains(lotesNewLote)) {
                    Producto oldProductoOfLotesNewLote = lotesNewLote.getProducto();
                    lotesNewLote.setProducto(producto);
                    lotesNewLote = em.merge(lotesNewLote);
                    if (oldProductoOfLotesNewLote != null && !oldProductoOfLotesNewLote.equals(producto)) {
                        oldProductoOfLotesNewLote.getLotes().remove(lotesNewLote);
                        oldProductoOfLotesNewLote = em.merge(oldProductoOfLotesNewLote);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = producto.getIdProducto();
                if (findProducto(id) == null) {
                    throw new NonexistentEntityException("The producto with id " + id + " no longer exists.");
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
            Producto producto;
            try {
                producto = em.getReference(Producto.class, id);
                producto.getIdProducto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producto with id " + id + " no longer exists.", enfe);
            }
            Categoria categoria = producto.getCategoria();
            if (categoria != null) {
                categoria.getProductos().remove(producto);
                categoria = em.merge(categoria);
            }
            Proveedor proveedor = producto.getProveedor();
            if (proveedor != null) {
                proveedor.getProductos().remove(producto);
                proveedor = em.merge(proveedor);
            }
            List<DetallePedido> detalles = producto.getDetalles();
            for (DetallePedido detallesDetallePedido : detalles) {
                detallesDetallePedido.setProducto(null);
                detallesDetallePedido = em.merge(detallesDetallePedido);
            }
            List<Lote> lotes = producto.getLotes();
            for (Lote lotesLote : lotes) {
                lotesLote.setProducto(null);
                lotesLote = em.merge(lotesLote);
            }
            em.remove(producto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producto> findProductoEntities() {
        return findProductoEntities(true, -1, -1);
    }

    public List<Producto> findProductoEntities(int maxResults, int firstResult) {
        return findProductoEntities(false, maxResults, firstResult);
    }

    private List<Producto> findProductoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producto.class));
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

    public Producto findProducto(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProductoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producto> rt = cq.from(Producto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
