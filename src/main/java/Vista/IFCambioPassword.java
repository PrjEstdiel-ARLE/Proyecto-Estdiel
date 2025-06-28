package Vista;

import Controlador.ControladoraGeneral;
import Extras.Mensajes;
import Extras.PasswordUtils;
import Modelo.Usuario;
import java.awt.Color;

public class IFCambioPassword extends javax.swing.JInternalFrame {

    private final Usuario usuarioActual;
    private final ControladoraGeneral control;

    public IFCambioPassword(Usuario usuario) {
        initComponents();
        this.usuarioActual = usuario;
        this.control=new ControladoraGeneral();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        txtActual = new javax.swing.JPasswordField();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        txtNueva = new javax.swing.JPasswordField();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel4 = new javax.swing.JLabel();
        txtConfirmar = new javax.swing.JPasswordField();
        btnCambiar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Cambiar Contraseña");

        jPanel1.setBackground(new java.awt.Color(239, 228, 210));

        jLabel2.setBackground(new java.awt.Color(137, 6, 6));
        jLabel2.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(137, 6, 6));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Constraseña Actual:");

        txtActual.setForeground(new java.awt.Color(153, 153, 153));
        txtActual.setText("************");
        txtActual.setBorder(null);
        txtActual.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtActualFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtActualFocusLost(evt);
            }
        });

        jLayeredPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(txtActual, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel3.setBackground(new java.awt.Color(137, 6, 6));
        jLabel3.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(137, 6, 6));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Constraseña Nueva:");

        txtNueva.setForeground(new java.awt.Color(153, 153, 153));
        txtNueva.setText("************");
        txtNueva.setBorder(null);
        txtNueva.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNuevaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNuevaFocusLost(evt);
            }
        });

        jLayeredPane3.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(txtNueva, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(txtNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel4.setBackground(new java.awt.Color(137, 6, 6));
        jLabel4.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(137, 6, 6));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Confirmar Nueva:");
        jLabel4.setToolTipText("");

        txtConfirmar.setForeground(new java.awt.Color(153, 153, 153));
        txtConfirmar.setText("************");
        txtConfirmar.setBorder(null);
        txtConfirmar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtConfirmarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtConfirmarFocusLost(evt);
            }
        });

        jLayeredPane4.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(txtConfirmar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(txtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        btnCambiar.setBackground(new java.awt.Color(30, 58, 81));
        btnCambiar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnCambiar.setForeground(new java.awt.Color(239, 228, 210));
        btnCambiar.setText("Cambiar");
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLayeredPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtActualFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtActualFocusGained
        if (txtActual.getText().equals("************")) {
            txtActual.setText("");
            txtActual.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtActualFocusGained

    private void txtActualFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtActualFocusLost
        if (txtActual.getText().equals("")) {
            txtActual.setText("************");
            txtActual.setForeground(new Color(153, 153, 153));
        } else {
            txtActual.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtActualFocusLost

    private void txtNuevaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNuevaFocusGained
        if (txtNueva.getText().equals("************")) {
            txtNueva.setText("");
            txtNueva.setForeground(Color.BLACK);
        }    }//GEN-LAST:event_txtNuevaFocusGained

    private void txtNuevaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNuevaFocusLost
        if (txtNueva.getText().equals("")) {
            txtNueva.setText("************");
            txtNueva.setForeground(new Color(153, 153, 153));
        } else {
            txtNueva.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtNuevaFocusLost

    private void txtConfirmarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmarFocusGained
        if (txtConfirmar.getText().equals("************")) {
            txtConfirmar.setText("");
            txtConfirmar.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtConfirmarFocusGained

    private void txtConfirmarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtConfirmarFocusLost
        if (txtConfirmar.getText().equals("")) {
            txtConfirmar.setText("************");
            txtConfirmar.setForeground(new Color(153, 153, 153));
        } else {
            txtConfirmar.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtConfirmarFocusLost

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed
        //leer datos
        String actual = new String(txtActual.getPassword());
        String nueva = new String(txtNueva.getPassword());
        String confirmar = new String(txtConfirmar.getPassword());
        //validacion
        StringBuilder errores = new StringBuilder();
        if (actual.isEmpty() || actual.equals("************")) {
            errores.append("- Ingrese la contraseña actual\n");
        }
        if (nueva.isEmpty() || nueva.equals("************")) {
            errores.append("- Ingrese la nueva contraseña\n");
        }
        if (confirmar.isEmpty() || confirmar.equals("************")) {
            errores.append("- Ingrese otra vez la nueva contraseña\n");
        }
        if (!nueva.equals(confirmar)) {
            errores.append("- La nueva contraseña y la confirmación no coinciden\n");
        }
        if (errores.length() > 0) {
            Mensajes.mostrarMensaje(errores.toString(), "error");
            return;
        }
        if (strongPassword(nueva)) {
            Mensajes.mostrarMensaje("La nueva contraseña es débil", "error");
            return;
        }
        if (!PasswordUtils.verificar(actual, usuarioActual.getPassword())) {
            Mensajes.mostrarMensaje("La contraseña actual es incorrecta", "error");
            return;
        }
        if (PasswordUtils.verificar(nueva, usuarioActual.getPassword())) {
            Mensajes.mostrarMensaje("La nueva contraseña no puede ser la misma que la actual", "error");
            return;
        }
        //proceso
        String hashNuevo = PasswordUtils.hash(nueva);
        usuarioActual.setPassword(hashNuevo);
        control.getControlUsuario().actualizar(usuarioActual);
        //finalizar
        this.dispose();
        Mensajes.mostrarMensaje("Contraseña actualizada exitosamente", "informacion");
    }//GEN-LAST:event_btnCambiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPasswordField txtActual;
    public javax.swing.JPasswordField txtConfirmar;
    public javax.swing.JPasswordField txtNueva;
    // End of variables declaration//GEN-END:variables

    private boolean strongPassword(String nueva) {
        return nueva.length() < 6;
    }
}
