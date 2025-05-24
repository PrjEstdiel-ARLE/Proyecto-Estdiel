package Modelo;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLote;
    private String codigo;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EstadoLote estado=EstadoLote.ACTIVO;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaIngreso;
    @Temporal(TemporalType.DATE)
    @Builder.Default
    private LocalDate fechaVencimiento=null;
    @ManyToOne
    @JoinColumn(name="producto_id")
    private Producto producto;
    @ManyToOne
    @JoinColumn(name = "detalle_id")
    private DetallePedido detalleOrigen;
}
