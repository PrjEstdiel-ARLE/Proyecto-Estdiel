package grupo.proyectopapeleria;

import Controlador.ControladoraGeneral;
import Vista.Login;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;

public class ProyectoPapeleria {

    public static void main(String[] args) {
        new JFXPanel();
        Platform.setImplicitExit(false);
        ControladoraGeneral controladora = new ControladoraGeneral();
        Login igu = new Login();
        igu.setVisible(true);
        igu.setLocationRelativeTo(null);
    }
}
