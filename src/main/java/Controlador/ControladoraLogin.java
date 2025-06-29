package Controlador;

import DAO.UsuarioJpaController;
import Extras.Mensajes;
import Extras.PasswordUtils;
import Modelo.Usuario;
import Vista.Login;
import Vista.Logistica;
import Vista.MenuAdministrador;

public class ControladoraLogin {

    /*public void autenticar(String dni, String password, JFrame loginFrame) {
        UsuarioJpaController usuarioController = new UsuarioJpaController();
        Usuario usuario = usuarioController.findUsuarioByDniAndPassword(dni, password);

        if (usuario != null) {
            Set<Rol> roles = usuario.getRoles();

            if (!roles.isEmpty()) {
                for (Rol rol : roles) {
                    if (rol.getNombre().equals("Administrador")) {
<<<<<<< HEAD
                        new MenuAdministrador(usuario).setVisible(true);
                    } else if (rol.getNombre().equals("Logística")) {
=======
                        new MenuAdministrador().setVisible(true);
                    } else if (rol.getNombre().equals("Logistica")) {
>>>>>>> main
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
    }*/

    public void autenticarCrypted(String dni, String pwdIngresada, Login aThis) {
        UsuarioJpaController dao = new UsuarioJpaController();       // o por inyección
        Usuario u = dao.findByDni(dni);

        if (u == null) {
            Mensajes.mostrarMensaje("DNI no registrado", "error");
            return;
        }

        // ¿Está habilitado?
        if (!u.isEnabled()) {
            Mensajes.mostrarMensaje("Usuario deshabilitado", "error");
            return;
        }

        // Verificar la contraseña hash
        if (!PasswordUtils.verificar(pwdIngresada, u.getPassword())) {
            Mensajes.mostrarMensaje("Contraseña incorrecta", "error");
            return;
        }

        // Autenticado
        abrirVentanaSegunRol(u);
        aThis.dispose();
    }

    private void abrirVentanaSegunRol(Usuario u) {
        // 1. Determinar si tiene un rol concreto
        boolean esAdmin = u.getRoles().stream()
                .anyMatch(r -> r.getNombre().equalsIgnoreCase("ADMINISTRADOR"));

        boolean esLogistica = u.getRoles().stream()
                .anyMatch(r -> r.getNombre().equalsIgnoreCase("LOGISTICA"));

        // 2. Abrir la UI
        if (esAdmin) {
            new MenuAdministrador(u).setVisible(true);
        } else if (esLogistica) {
            new Logistica(u).setVisible(true);
        } else {
            Mensajes.mostrarMensaje("No tiene ventana asignada para sus roles", "error");
        }
    }
}
