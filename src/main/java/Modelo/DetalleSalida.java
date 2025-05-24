package Modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import javax.persistence.Entity;
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
public class DetalleSalida implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleSalida;
    
    @ManyToOne
    @JoinColumn(name = "salida_id")
    private Salida salida;
    
    @OneToOne
    @JoinColumn(name = "lote_id")
    private Lote lote;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRetiro;
}
