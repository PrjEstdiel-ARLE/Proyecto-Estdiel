package Vista;

import Controlador.ControladoraGeneral;
import Extras.Mensajes;
import Modelo.Rol;
import Modelo.Usuario;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.ComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class IFUsuarios extends javax.swing.JInternalFrame {

    ControladoraGeneral control = new ControladoraGeneral();
    List<Usuario> usuarios;
    Usuario usuarioEnEdicion = null;

    public IFUsuarios() {
        initComponents();
        usuarios = control.getControlUsuario().leerTodo();
        generarTabla(usuarios);
        soloNumerosTelefono();
        soloNumerosDni();
        soloLetrasNombreApellido();
        cargarRoles();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        labelRol = new javax.swing.JLabel();
        btnGuardar1 = new javax.swing.JButton();
        btnEditar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        txtApellido1 = new javax.swing.JTextField();
        txtTelefono1 = new javax.swing.JTextField();
        txtNombre1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnRegresar1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnRestablecer = new javax.swing.JButton();
        cmbRoles = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();

        jPanel2.setBackground(new java.awt.Color(239, 228, 210));

        jLabel4.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 65)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(149, 76, 46));
        jLabel4.setText(": Ajustes de usuarios");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo.png"))); // NOI18N

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo_config.png"))); // NOI18N

        jLabel15.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 50)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(149, 76, 46));
        jLabel15.setText("Registro de Sesiones");

        jLabel18.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(37, 77, 112));
        jLabel18.setText("Nombre:");

        jLabel19.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(37, 77, 112));
        jLabel19.setText("Apellido:");

        jLabel20.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(37, 77, 112));
        jLabel20.setText("Telefono:");

        jLabel21.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(37, 77, 112));
        jLabel21.setText("Contraseña:");

        labelRol.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        labelRol.setForeground(new java.awt.Color(37, 77, 112));
        labelRol.setText("Rol:");

        btnGuardar1.setBackground(new java.awt.Color(30, 58, 81));
        btnGuardar1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnGuardar1.setForeground(new java.awt.Color(239, 228, 210));
        btnGuardar1.setText("Guardar");
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });

        btnEditar1.setBackground(new java.awt.Color(30, 58, 81));
        btnEditar1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnEditar1.setForeground(new java.awt.Color(239, 228, 210));
        btnEditar1.setText("Editar");
        btnEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditar1ActionPerformed(evt);
            }
        });

        btnEliminar1.setBackground(new java.awt.Color(30, 58, 81));
        btnEliminar1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnEliminar1.setForeground(new java.awt.Color(239, 228, 210));
        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Telefono", "Password", "Rol"
            }
        ));
        tblUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblUsuarios);

        btnRegresar1.setBackground(new java.awt.Color(239, 228, 210));
        btnRegresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar1.setBorderPainted(false);
        btnRegresar1.setContentAreaFilled(false);
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnRestablecer.setBackground(new java.awt.Color(30, 58, 81));
        btnRestablecer.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnRestablecer.setForeground(new java.awt.Color(239, 228, 210));
        btnRestablecer.setText("Restablecer");
        btnRestablecer.setToolTipText("");
        btnRestablecer.setEnabled(false);
        btnRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestablecerActionPerformed(evt);
            }
        });

        cmbRoles.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbRoles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel23.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(37, 77, 112));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel23.setText("DNI:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(101, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(100, 100, 100)
                        .addComponent(btnRegresar1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(828, 828, 828)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(60, 60, 60)
                                        .addComponent(jLabel15)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnGuardar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelRol, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRestablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(85, 85, 85))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(btnRegresar1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(74, 74, 74)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(16, 16, 16)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 15, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator3))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel15)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(btnRestablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelRol)
                            .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        //leer datos
        String nombre = txtNombre1.getText();
        String apellido = txtApellido1.getText();
        String dni = txtDni.getText();
        String telefono = txtTelefono1.getText();
        String rolNombre = cmbRoles.getSelectedItem().toString();
        Rol rol = control.getControlRol().leerPorNombre(rolNombre);
        //validar datos
        StringBuilder errores = new StringBuilder();

        if (nombre.isEmpty() || apellido.isEmpty()) {
            errores.append("- Nombre y apellido son obligatorios.\n");
        }
        if (telefono.isEmpty()) {
            errores.append("- Un teléfono es obligatorio.\n");
        }
        if (dni.isEmpty()) {
            errores.append("- El DNI es obligatorio.\n");
        }
        if (errores.length() > 0) {
            Mensajes.mostrarMensaje(errores.toString(), "error");
            return;
        }
        if (!dni.matches("\\d{8}")) {
            Mensajes.mostrarMensaje("DNI debe tener 8 dígitos", "error");
            return;
        }
        //determina edicion
        if (usuarioEnEdicion == null) {
            Usuario nuevo = new Usuario();
            nuevo.setNombres(nombre);
            nuevo.setApellidos(apellido);
            nuevo.setDni(dni);
            nuevo.setTelefono(telefono);
            String hash = Extras.PasswordUtils.hash("123456");
            nuevo.setPassword(hash);
            nuevo.setEnabled(true);

            //Asignar roles
            Set<Rol> setRoles = new HashSet<>();
            setRoles.add(rol);
            nuevo.setRoles(setRoles);
            control.getControlUsuario().crear(nuevo);
            Mensajes.mostrarMensaje("Usuario creado correctamente", "informacion");
        } else {
            usuarioEnEdicion.setNombres(nombre);
            usuarioEnEdicion.setApellidos(apellido);
            usuarioEnEdicion.setDni(dni);
            usuarioEnEdicion.setTelefono(telefono);

            // 2. Reconstruir set de roles
            Set<Rol> nuevosRoles = new HashSet<>();

            // Recorres TODO lo que hay en el combo (no solo el seleccionado)
            ComboBoxModel<String> modelo = cmbRoles.getModel();
            for (int i = 0; i < modelo.getSize(); i++) {
                String rolNombreCombo = modelo.getElementAt(i);          // ← nombre distinto
                Rol rolReal = control.getControlRol().leerPorNombre(rolNombreCombo);
                nuevosRoles.add(rolReal);
            }
            // 3. Sustituyes el set completo
            usuarioEnEdicion.getRoles().clear();
            usuarioEnEdicion.getRoles().addAll(nuevosRoles);
            control.getControlUsuario().actualizar(usuarioEnEdicion);
            Mensajes.mostrarMensaje("Usuario editado correctamente", "informacion");
            finalizarEdicion();
        }
        limpiarCampos();
        recargarTablaUsuarios();
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerActionPerformed
        boolean conf = Mensajes.confirmar("¿Desea reestablecer la contraseña del usuario?");
        if (conf) {
            if (usuarioEnEdicion != null) {
                String nuevaPassword = "123456";
                String hash = Extras.PasswordUtils.hash(nuevaPassword); // tu método de hash
                usuarioEnEdicion.setPassword(hash);

                control.getControlUsuario().actualizar(usuarioEnEdicion);

                Mensajes.mostrarMensaje("Contraseña restablecida a '123456'\nInformar a: "+cargarNombre(usuarioEnEdicion), "informacion");
            } else {
                Mensajes.mostrarMensaje("No hay usuario seleccionado para restablecer contraseña", "error");
            }
        }
    }//GEN-LAST:event_btnRestablecerActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        if (tblUsuarios.getRowCount() > 0) {
            int filaSelect = tblUsuarios.getSelectedRow();
            //Asegurar selección
            if (filaSelect != -1) {
                Usuario userSelect = usuarios.get(filaSelect);
                boolean conf = Extras.Mensajes.confirmar("¿Desea eliminar este elemento?");
                if (conf) {
                    control.getControlUsuario().eliminar(userSelect.getIdUsuario());
                    usuarios.remove(filaSelect);
                    usuarios = control.getControlUsuario().leerTodo();
                    generarTabla(usuarios);
                }
            } else {
                Extras.Mensajes.mostrarMensaje("Seleccione la fila a eliminar", "advertencia");
            }
        }
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditar1ActionPerformed
        if (usuarioEnEdicion != null) {
            finalizarEdicion();
            Extras.Mensajes.mostrarMensaje("Edición Cancelada", "informacion");
        } else {
            if (tblUsuarios.getRowCount() > 0) {
                int filaSelect = tblUsuarios.getSelectedRow();
                if (filaSelect != -1) {
                    // Marcar que estamos en modo edición
                    usuarioEnEdicion = usuarios.get(filaSelect);
                    //cargar datos
                    txtNombre1.setText(usuarioEnEdicion.getNombres());
                    txtApellido1.setText(usuarioEnEdicion.getApellidos());
                    txtTelefono1.setText(usuarioEnEdicion.getTelefono());
                    txtDni.setText(usuarioEnEdicion.getDni());
                    cargarRolesUsuario(usuarioEnEdicion);
                    // Cambiar el texto del botón para indicar que estamos editando
                    btnGuardar1.setText("Actualizar");
                    btnEditar1.setText("Cancelar");
                    btnRestablecer.setEnabled(true);
                    labelRol.setText("Roles:");
                    Extras.Mensajes.mostrarMensaje("Modifique los datos y presione 'Actualizar'", "informacion");
                } else {
                    Extras.Mensajes.mostrarMensaje("Seleccione la fila a editar", "advertencia");
                }
            }
        }
    }//GEN-LAST:event_btnEditar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btnRestablecer;
    private javax.swing.JComboBox<String> cmbRoles;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelRol;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JTextField txtTelefono1;
    // End of variables declaration//GEN-END:variables

    private void soloNumerosTelefono() {
        txtTelefono1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String textoActual = txtTelefono1.getText();

                // Bloquear si:
                // - No es un dígito.
                // - Ya hay 9 caracteres.
                // - Es el primer carácter y no es '9'.
                if (!Character.isDigit(c)
                        || textoActual.length() >= 9
                        || (textoActual.isEmpty() && c != '9')) {
                    e.consume();
                }
            }
        });
    }

    private boolean esCaracterValidoParaNombres(char c) {
        // Permite letras (mayúsculas/minúsculas), espacios, acentos y ñ/Ñ
        return Character.isLetter(c) || c == ' ' || c == 'Á' || c == 'É' || c == 'Í'
                || c == 'Ó' || c == 'Ú' || c == 'á' || c == 'é' || c == 'í'
                || c == 'ó' || c == 'ú' || c == 'Ñ' || c == 'ñ';
    }

    private void soloLetrasNombreApellido() {
        // Para el campo de nombre
        txtNombre1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!esCaracterValidoParaNombres(c)) {
                    e.consume(); // Bloquea el carácter si no es válido
                }
            }
        });

        // Para el campo de apellido
        txtApellido1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!esCaracterValidoParaNombres(c)) {
                    e.consume();
                }
            }
        });
    }

    private void generarTabla(List<Usuario> listUsuarios) {
        // Inicializa el modelo de la tabla y establece las columnas
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] titulos = {"Nombre", "Rol", "DNI", "Telefono"};
        modeloTabla.setColumnIdentifiers(titulos);
        modeloTabla.setRowCount(0);

        // Itera sobre los detalles y los agrega a la tabla
        for (Usuario user : listUsuarios) {
            Object[] obj = {
                cargarNombre(user),
                rolesComoTexto(user.getRoles()),
                user.getDni(),
                user.getTelefono()
            };
            modeloTabla.addRow(obj);
        }

        tblUsuarios.setModel(modeloTabla);

        // Centra el texto en todas las celdas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplica el render centrado a cada columna
        for (int i = 0; i < tblUsuarios.getColumnCount(); i++) {
            tblUsuarios.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        //formatear el tamaño de texto
        tblUsuarios.setRowHeight(35);
        JTableHeader header = tblUsuarios.getTableHeader();
        header.setFont(new java.awt.Font("PMingLiU-ExtB", Font.BOLD, 26));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
    }

    private Object cargarNombre(Usuario user) {
        return user.getNombres() + " " + user.getApellidos();
    }

    private String rolesComoTexto(Set<Rol> roles) {
        return roles.stream()
                .map(Rol::getNombre) // solo el atributo nombre
                .sorted() // opcional: orden alfabético
                .collect(Collectors.joining(", "));
    }

    private void cargarRoles() {
        cmbRoles.removeAllItems();
        for (Rol rol : control.getControlRol().leerTodos()) {
            cmbRoles.addItem(rol.getNombre());
        }
    }

    private void soloNumerosDni() {
        txtDni.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String textoActual = txtDni.getText();

                // Bloquear si:
                // - No es un dígito.
                if (!Character.isDigit(c)
                        || textoActual.length() >= 8) {
                    e.consume();
                }
            }
        });
    }

    private void limpiarCampos() {
        txtApellido1.setText("");
        txtNombre1.setText("");
        txtDni.setText("");
        txtTelefono1.setText("");
        cargarRoles();
    }

    private void recargarTablaUsuarios() {
        usuarios = control.getControlUsuario().leerTodo();
        generarTabla(usuarios);
    }

    private void finalizarEdicion() {
        usuarioEnEdicion = null;
        btnGuardar1.setText("Guardar");
        btnEditar1.setText("Editar");
        btnRestablecer.setEnabled(false);
        cargarRoles();
        labelRol.setText("Rol:");
    }

    private void cargarRolesUsuario(Usuario user) {
        cmbRoles.removeAllItems();
        for (Rol r : user.getRoles()) {
            cmbRoles.addItem(r.getNombre());
        }
    }
}
