package Controlador;

public class ControladoraGeneral {

    private final ControladoraProveedor controlProveedor;
    private final ControladoraProducto controlProducto;
    private final ControladoraDetallePedido controlDetallePedido;
    private final ControladoraCategoria controlCategoria;
    private final ControladoraDetalleSalida controlDetalleSalida;
    private final ControladoraLote controlLote;
    private final ControladoraPedido controlPedido;
    private final ControladoraRol controlRol;
    private final ControladoraSalida controlSalida;
    private final ControladoraUsuario controlUsuario;
    private final ControladoraContactosProveedor controlContactoProveedor;

    public ControladoraGeneral() {
        this.controlProveedor = new ControladoraProveedor();
        this.controlProducto = new ControladoraProducto();
        this.controlCategoria = new ControladoraCategoria();
        this.controlDetallePedido = new ControladoraDetallePedido();
        this.controlDetalleSalida = new ControladoraDetalleSalida();
        this.controlLote = new ControladoraLote();
        this.controlPedido = new ControladoraPedido();
        this.controlRol = new ControladoraRol();
        this.controlSalida = new ControladoraSalida();
        this.controlUsuario = new ControladoraUsuario();
        this.controlContactoProveedor = new ControladoraContactosProveedor();
    }

    // Métodos para obtener las controladoras específicas
    public ControladoraProveedor getControlProveedor() {
        return controlProveedor;
    }

    public ControladoraProducto getControlProducto() {
        return controlProducto;
    }

    public ControladoraDetallePedido getControlDetallePedido() {
        return controlDetallePedido;
    }

    public ControladoraCategoria getControlCategoria() {
        return controlCategoria;
    }

    public ControladoraDetalleSalida getControlDetalleSalida() {
        return controlDetalleSalida;
    }

    public ControladoraLote getControlLote() {
        return controlLote;
    }

    public ControladoraPedido getControlPedido() {
        return controlPedido;
    }

    public ControladoraRol getControlRol() {
        return controlRol;
    }

    public ControladoraSalida getControlSalida() {
        return controlSalida;
    }

    public ControladoraUsuario getControlUsuario() {
        return controlUsuario;
    }

    public ControladoraContactosProveedor getControlContactoProveedor() {
        return controlContactoProveedor;
    }

}
