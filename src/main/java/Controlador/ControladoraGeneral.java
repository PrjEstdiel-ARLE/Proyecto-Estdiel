package Controlador;

public class ControladoraGeneral {

    private final ControladoraProveedor controlProveedor;
    private final ControladoraProducto controlProducto;
    private final ControladoraStock controlStock;
    private final ControladoraCategoria controlCategoria;

    public ControladoraGeneral() {
        this.controlProveedor = new ControladoraProveedor();
        this.controlProducto = new ControladoraProducto();
        this.controlStock = new ControladoraStock();
        this.controlCategoria=new ControladoraCategoria();
    }

    // Métodos para obtener las controladoras específicas
    public ControladoraProveedor getControladoraProveedor() {
        return controlProveedor;
    }

    public ControladoraProducto getControladoraProducto() {
        return controlProducto;
    }

    public ControladoraStock getControladoraStock() {
        return controlStock;
    }

    public ControladoraCategoria getControladoraCategoria(){
        return controlCategoria;
    }

}
