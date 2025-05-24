package Modelo;

import java.time.LocalDate;
import javax.persistence.Entity;
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
public class Salida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSalida;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaSalida;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
}
