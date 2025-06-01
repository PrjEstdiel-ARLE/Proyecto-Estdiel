package grupo.proyectopapeleria;

import DAO.CategoriaJpaController;
import DAO.DetallePedidoJpaController;
import DAO.DetalleSalidaJpaController;
import DAO.LoteJpaController;
import DAO.PedidoJpaController;
import DAO.ProductoJpaController;
import DAO.ProveedorJpaController;
import DAO.RolJpaController;
import DAO.SalidaJpaController;
import DAO.UsuarioJpaController;
import Modelo.Proveedor;
import Vista.PantallaPrincipal;

public class ProyectoPapeleria {

    public static void main(String[] args) {
        new CategoriaJpaController();
        new DetallePedidoJpaController();
        new DetalleSalidaJpaController();
        new LoteJpaController();
        new PedidoJpaController();
        new ProductoJpaController();
        new ProveedorJpaController();
        new RolJpaController();
        new SalidaJpaController();
        new UsuarioJpaController();
        PantallaPrincipal igu = new PantallaPrincipal();
        igu.setVisible(true);
        igu.setLocationRelativeTo(null);
    }
}
