package grupo.proyectopapeleria;


import Controlador.ControladoraGeneral;
import Vista.Login;


public class ProyectoPapeleria {

    public static void main(String[] args) {    
        ControladoraGeneral CG = new ControladoraGeneral();
        Login igu = new Login();

        igu.setVisible(true);
        igu.setLocationRelativeTo(null);
    }
}
