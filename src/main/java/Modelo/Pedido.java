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
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EstadoPedido estado = EstadoPedido.REGISTRADO;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaRegistro;
    @Builder.Default
    private LocalDate fechaEstimadoLlegada = null;
    private double total;
    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;
}
