/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.UsuarioJpaController;
import Modelo.Rol;
import Modelo.Usuario;
import Vista.Logistica;
import Vista.MenuAdministrador;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ControladoraLogin {
    public void autenticar(String dni, String password, JFrame loginFrame) {
        UsuarioJpaController usuarioController = new UsuarioJpaController();
        Usuario usuario = usuarioController.findUsuarioByDniAndPassword(dni, password);

        if (usuario != null) {
            Set<Rol> roles = usuario.getRoles();

            if (!roles.isEmpty()) {
                for (Rol rol : roles) {
                    if (rol.getNombre().equals("Administrador")) {
                        new MenuAdministrador().setVisible(true);
                    } else if (rol.getNombre().equals("Logística")) {
                        new Logistica().setVisible(true);
                    }
                }
                loginFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un rol asignado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas.");
        }
    }
}