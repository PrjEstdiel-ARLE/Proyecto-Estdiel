package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lote implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLote;
    private String codigo;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EstadoLote estado=EstadoLote.ACTIVO;
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Temporal(TemporalType.DATE)
    @Builder.Default
    private Date fechaVencimiento=null;
    @ManyToOne
    @JoinColumn(name="producto_id")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "detalle_id")
    private DetallePedido detalleOrigen;
    @OneToOne(mappedBy = "lote")
    private DetalleSalida detalleSalida;
}
