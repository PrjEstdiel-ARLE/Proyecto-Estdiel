package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Proveedor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProveedor;
    @Basic
    private String nombre;
    private String correo;
    private String direccion;
    private String RUC;
    private String sitioWeb;
    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;
    @OneToMany(mappedBy = "proveedor")
    private List<Pedido> pedidos;
    @OneToMany(mappedBy = "proveedor")
    private List<ContactoProveedor> contactos;

}
