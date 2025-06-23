package DAO;

import DAO.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Modelo.Producto;
import java.util.ArrayList;
import java.util.List;
import Modelo.Pedido;
import Modelo.ContactoProveedor;
import Modelo.Proveedor;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

public class ProveedorJpaController implements Serializable {

    public ProveedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public ProveedorJpaController(){
          emf=Persistence.createEntityManagerFactory("persistencia");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Proveedor proveedor) {
        if (proveedor.getProductos() == null) {
            proveedor.setProductos(new ArrayList<Producto>());
        }
        if (proveedor.getPedidos() == null) {
            proveedor.setPedidos(new ArrayList<Pedido>());
        }
        if (proveedor.getContactos() == null) {
            proveedor.setContactos(new ArrayList<ContactoProveedor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Producto> attachedProductos = new ArrayList<Producto>();
            for (Producto productosProductoToAttach : proveedor.getProductos()) {
                productosProductoToAttach = em.getReference(productosProductoToAttach.getClass(), productosProductoToAttach.getIdProducto());
                attachedProductos.add(productosProductoToAttach);
            }
            proveedor.setProductos(attachedProductos);
            List<Pedido> attachedPedidos = new ArrayList<Pedido>();
            for (Pedido pedidosPedidoToAttach : proveedor.getPedidos()) {
                pedidosPedidoToAttach = em.getReference(pedidosPedidoToAttach.getClass(), pedidosPedidoToAttach.getIdPedido());
                attachedPedidos.add(pedidosPedidoToAttach);
            }
            proveedor.setPedidos(attachedPedidos);
            List<ContactoProveedor> attachedContactos = new ArrayList<ContactoProveedor>();
            for (ContactoProveedor contactosContactoProveedorToAttach : proveedor.getContactos()) {
                contactosContactoProveedorToAttach = em.getReference(contactosContactoProveedorToAttach.getClass(), contactosContactoProveedorToAttach.getIdContacto());
                attachedContactos.add(contactosContactoProveedorToAttach);
            }
            proveedor.setContactos(attachedContactos);
            em.persist(proveedor);
            for (Producto productosProducto : proveedor.getProductos()) {
                Proveedor oldProveedorOfProductosProducto = productosProducto.getProveedor();
                productosProducto.setProveedor(proveedor);
                productosProducto = em.merge(productosProducto);
                if (oldProveedorOfProductosProducto != null) {
                    oldProveedorOfProductosProducto.getProductos().remove(productosProducto);
                    oldProveedorOfProductosProducto = em.merge(oldProveedorOfProductosProducto);
                }
            }
            for (Pedido pedidosPedido : proveedor.getPedidos()) {
                Proveedor oldProveedorOfPedidosPedido = pedidosPedido.getProveedor();
                pedidosPedido.setProveedor(proveedor);
                pedidosPedido = em.merge(pedidosPedido);
                if (oldProveedorOfPedidosPedido != null) {
                    oldProveedorOfPedidosPedido.getPedidos().remove(pedidosPedido);
                    oldProveedorOfPedidosPedido = em.merge(oldProveedorOfPedidosPedido);
                }
            }
            for (ContactoProveedor contactosContactoProveedor : proveedor.getContactos()) {
                Proveedor oldProveedorOfContactosContactoProveedor = contactosContactoProveedor.getProveedor();
                contactosContactoProveedor.setProveedor(proveedor);
                contactosContactoProveedor = em.merge(contactosContactoProveedor);
                if (oldProveedorOfContactosContactoProveedor != null) {
                    oldProveedorOfContactosContactoProveedor.getContactos().remove(contactosContactoProveedor);
                    oldProveedorOfContactosContactoProveedor = em.merge(oldProveedorOfContactosContactoProveedor);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Proveedor proveedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Proveedor persistentProveedor = em.find(Proveedor.class, proveedor.getIdProveedor());
            List<Producto> productosOld = persistentProveedor.getProductos();
            List<Producto> productosNew = proveedor.getProductos();
            List<Pedido> pedidosOld = persistentProveedor.getPedidos();
            List<Pedido> pedidosNew = proveedor.getPedidos();
            List<ContactoProveedor> contactosOld = persistentProveedor.getContactos();
            List<ContactoProveedor> contactosNew = proveedor.getContactos();
            List<Producto> attachedProductosNew = new ArrayList<Producto>();
            for (Producto productosNewProductoToAttach : productosNew) {
                productosNewProductoToAttach = em.getReference(productosNewProductoToAttach.getClass(), productosNewProductoToAttach.getIdProducto());
                attachedProductosNew.add(productosNewProductoToAttach);
            }
            productosNew = attachedProductosNew;
            proveedor.setProductos(productosNew);
            List<Pedido> attachedPedidosNew = new ArrayList<Pedido>();
            for (Pedido pedidosNewPedidoToAttach : pedidosNew) {
                pedidosNewPedidoToAttach = em.getReference(pedidosNewPedidoToAttach.getClass(), pedidosNewPedidoToAttach.getIdPedido());
                attachedPedidosNew.add(pedidosNewPedidoToAttach);
            }
            pedidosNew = attachedPedidosNew;
            proveedor.setPedidos(pedidosNew);
            List<ContactoProveedor> attachedContactosNew = new ArrayList<ContactoProveedor>();
            for (ContactoProveedor contactosNewContactoProveedorToAttach : contactosNew) {
                contactosNewContactoProveedorToAttach = em.getReference(contactosNewContactoProveedorToAttach.getClass(), contactosNewContactoProveedorToAttach.getIdContacto());
                attachedContactosNew.add(contactosNewContactoProveedorToAttach);
            }
            contactosNew = attachedContactosNew;
            proveedor.setContactos(contactosNew);
            proveedor = em.merge(proveedor);
            for (Producto productosOldProducto : productosOld) {
                if (!productosNew.contains(productosOldProducto)) {
                    productosOldProducto.setProveedor(null);
                    productosOldProducto = em.merge(productosOldProducto);
                }
            }
            for (Producto productosNewProducto : productosNew) {
                if (!productosOld.contains(productosNewProducto)) {
                    Proveedor oldProveedorOfProductosNewProducto = productosNewProducto.getProveedor();
                    productosNewProducto.setProveedor(proveedor);
                    productosNewProducto = em.merge(productosNewProducto);
                    if (oldProveedorOfProductosNewProducto != null && !oldProveedorOfProductosNewProducto.equals(proveedor)) {
                        oldProveedorOfProductosNewProducto.getProductos().remove(productosNewProducto);
                        oldProveedorOfProductosNewProducto = em.merge(oldProveedorOfProductosNewProducto);
                    }
                }
            }
            for (Pedido pedidosOldPedido : pedidosOld) {
                if (!pedidosNew.contains(pedidosOldPedido)) {
                    pedidosOldPedido.setProveedor(null);
                    pedidosOldPedido = em.merge(pedidosOldPedido);
                }
            }
            for (Pedido pedidosNewPedido : pedidosNew) {
                if (!pedidosOld.contains(pedidosNewPedido)) {
                    Proveedor oldProveedorOfPedidosNewPedido = pedidosNewPedido.getProveedor();
                    pedidosNewPedido.setProveedor(proveedor);
                    pedidosNewPedido = em.merge(pedidosNewPedido);
                    if (oldProveedorOfPedidosNewPedido != null && !oldProveedorOfPedidosNewPedido.equals(proveedor)) {
                        oldProveedorOfPedidosNewPedido.getPedidos().remove(pedidosNewPedido);
                        oldProveedorOfPedidosNewPedido = em.merge(oldProveedorOfPedidosNewPedido);
                    }
                }
            }
            for (ContactoProveedor contactosOldContactoProveedor : contactosOld) {
                if (!contactosNew.contains(contactosOldContactoProveedor)) {
                    contactosOldContactoProveedor.setProveedor(null);
                    contactosOldContactoProveedor = em.merge(contactosOldContactoProveedor);
                }
            }
            for (ContactoProveedor contactosNewContactoProveedor : contactosNew) {
                if (!contactosOld.contains(contactosNewContactoProveedor)) {
                    Proveedor oldProveedorOfContactosNewContactoProveedor = contactosNewContactoProveedor.getProveedor();
                    contactosNewContactoProveedor.setProveedor(proveedor);
                    contactosNewContactoProveedor = em.merge(contactosNewContactoProveedor);
                    if (oldProveedorOfContactosNewContactoProveedor != null && !oldProveedorOfContactosNewContactoProveedor.equals(proveedor)) {
                        oldProveedorOfContactosNewContactoProveedor.getContactos().remove(contactosNewContactoProveedor);
                        oldProveedorOfContactosNewContactoProveedor = em.merge(oldProveedorOfContactosNewContactoProveedor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = proveedor.getIdProveedor();
                if (findProveedor(id) == null) {
                    throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.");
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
            Proveedor proveedor;
            try {
                proveedor = em.getReference(Proveedor.class, id);
                proveedor.getIdProveedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The proveedor with id " + id + " no longer exists.", enfe);
            }
            List<Producto> productos = proveedor.getProductos();
            for (Producto productosProducto : productos) {
                productosProducto.setProveedor(null);
                productosProducto = em.merge(productosProducto);
            }
            List<Pedido> pedidos = proveedor.getPedidos();
            for (Pedido pedidosPedido : pedidos) {
                pedidosPedido.setProveedor(null);
                pedidosPedido = em.merge(pedidosPedido);
            }
            List<ContactoProveedor> contactos = proveedor.getContactos();
            for (ContactoProveedor contactosContactoProveedor : contactos) {
                contactosContactoProveedor.setProveedor(null);
                contactosContactoProveedor = em.merge(contactosContactoProveedor);
            }
            em.remove(proveedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Proveedor> findProveedorEntities() {
        return findProveedorEntities(true, -1, -1);
    }

    public List<Proveedor> findProveedorEntities(int maxResults, int firstResult) {
        return findProveedorEntities(false, maxResults, firstResult);
    }

    private List<Proveedor> findProveedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Proveedor.class));
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

    public Proveedor findProveedor(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Proveedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProveedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Proveedor> rt = cq.from(Proveedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
        public Proveedor findByNombre(String nombre) {
        EntityManager em = getEntityManager();
        String query = "SELECT p FROM Proveedor p WHERE LOWER(p.nombre) = LOWER(:nombre)";
        try {
            return em.createQuery(query, Proveedor.class)
                    .setParameter("nombre", nombre)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        } finally {
            em.close();
        }
    }

    public boolean existeProveedorConRUC(String ruc) {
        EntityManager em = getEntityManager();
        try {
            Long count = em.createQuery("SELECT COUNT(p) FROM Proveedor p WHERE p.RUC = :ruc", Long.class)
                    .setParameter("ruc", ruc)
                    .getSingleResult();
            return count > 0;
        } finally {
            em.close();
        }
    }
    
}
