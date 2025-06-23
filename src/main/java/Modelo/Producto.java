package Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "producto")
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducto;
    private String nombre;
    private String codigo;
    private int cantidadPresentacionLote;
    private int cantidadPresentacionProducto;
    private ProductoPresentacionLote presentacionLote;
    private ProductoPresentacionProducto presentacionProducto;
    private double precioCompra;
    private int cantidadLotes;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;
    
    @OneToMany(mappedBy = "producto")
    private List<DetallePedido> detalles;
    
    @OneToMany(mappedBy = "producto")
    private List<Lote> lotes;
}
