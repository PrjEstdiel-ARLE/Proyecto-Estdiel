package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "solicitud")
public class Solicitud implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud")
    private Integer idSolicitud;

    @ManyToOne
    @JoinColumn(name = "IDUSUARIO", nullable = false)
    private Usuario usuario;

    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSolicitud;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_aprobacion")
    private Date fechaAprobacion;

    @Column(name = "estado_solicitud", length = 20)
    private String estadoSolicitud = "Pendiente";
    
    @Column (name = "codigo_salida", length = 20)
    private String codigoSalida;

    @OneToMany(mappedBy = "solicitud", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<DetalleSolicitud> detalles;

    public Solicitud() {
    }

    // Getters y Setters

    public Integer getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(Integer idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public Date getFechaAprobacion() {
        return fechaAprobacion;
    }

    public void setFechaAprobacion(Date fechaAprobacion) {
        this.fechaAprobacion = fechaAprobacion;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public Set<DetalleSolicitud> getDetalles() {
        return detalles;
    }

    public void setDetalles(Set<DetalleSolicitud> detalles) {
        this.detalles = detalles;
    }

    public String getCodigoSalida() {
        return codigoSalida;
    }

    public void setCodigoSalida(String codigoSalida) {
        this.codigoSalida = codigoSalida;
    }
}

