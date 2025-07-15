package Vista;

import Controlador.ControladoraGeneral;
import Extras.ExportadorReporte;
import Extras.Mensajes;
import Modelo.Pais;
import Modelo.Rol;
import Modelo.TipoDocumento;
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
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class IFUsuarios extends javax.swing.JInternalFrame {

    ControladoraGeneral control = new ControladoraGeneral();
    List<Usuario> usuarios;
    Usuario usuarioEnEdicion = null;
    private final JDesktopPane pantalla;
    private final JToolBar tool;

    public IFUsuarios(JDesktopPane desktopPane, JToolBar tool) {
        initComponents();
        usuarios = control.getControlUsuario().leerTodo();
        generarTabla(usuarios);
        cargarTipoDocumento();
        cargarPaises();
        soloNumerosTelefono();
        soloNumerosDocumento();
        soloLetrasNombreApellido();
        cargarRoles();
        this.pantalla = desktopPane;
        this.tool = tool;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
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
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnRestablecer = new javax.swing.JButton();
        cmbRoles = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        txtDocumento = new javax.swing.JTextField();
        btnCrearRol = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnTodo = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        cmbTipoDocumento = new javax.swing.JComboBox<>();
        cmbPais = new javax.swing.JComboBox<>();
        btnAgregarPais = new javax.swing.JButton();

        setTitle("Usuarios");

        jPanel2.setBackground(new java.awt.Color(239, 228, 210));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo_config.png"))); // NOI18N

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
        tblUsuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
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
        jLabel23.setText("Documento:");

        btnCrearRol.setBackground(new java.awt.Color(30, 58, 81));
        btnCrearRol.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        btnCrearRol.setForeground(new java.awt.Color(239, 228, 210));
        btnCrearRol.setText("Crear Rol");
        btnCrearRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearRolActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(239, 228, 210));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 2), "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 18), new java.awt.Color(137, 6, 6))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(239, 228, 210));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 2), "Nombre o Apellido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 14), new java.awt.Color(137, 6, 6))); // NOI18N

        txtBuscar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnBuscar.setBackground(new java.awt.Color(30, 58, 81));
        btnBuscar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(239, 228, 210));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnTodo.setBackground(new java.awt.Color(30, 58, 81));
        btnTodo.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnTodo.setForeground(new java.awt.Color(239, 228, 210));
        btnTodo.setText("Ver Todo");
        btnTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodoActionPerformed(evt);
            }
        });

        btnReporte.setBackground(new java.awt.Color(30, 58, 81));
        btnReporte.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(239, 228, 210));
        btnReporte.setText("Generar Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(37, 77, 112));
        jLabel22.setText("País:");

        jLabel24.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(37, 77, 112));
        jLabel24.setText("Tipo:");

        jLabel25.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(37, 77, 112));
        jLabel25.setText("Dirección:");

        cmbTipoDocumento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipoDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoDocumentoActionPerformed(evt);
            }
        });

        cmbPais.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAgregarPais.setBackground(new java.awt.Color(239, 228, 210));
        btnAgregarPais.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAgregarPais.setText("+");
        btnAgregarPais.setBorderPainted(false);
        btnAgregarPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(269, 269, 269)
                                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(labelRol)
                                        .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21)
                                        .addComponent(jLabel20)
                                        .addComponent(jLabel19)))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnRestablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnCrearRol, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel24)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel25))
                                        .addComponent(jLabel22))
                                    .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDireccion)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cmbTipoDocumento, 0, 187, Short.MAX_VALUE)
                                            .addComponent(cmbPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAgregarPais, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(171, 171, 171))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRegresar1)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)))
                .addGap(43, 43, 43))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel18))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnRegresar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)
                            .addComponent(cmbPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregarPais, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(cmbTipoDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(btnRestablecer, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelRol)
                            .addComponent(cmbRoles, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrearRol, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        String telefono = txtTelefono1.getText();
        String rolNombre = cmbRoles.getSelectedItem().toString();
        Rol rol = control.getControlRol().leerPorNombre(rolNombre);
        String documento = txtDocumento.getText();
        String direccion = txtDireccion.getText();
        TipoDocumento tipo = TipoDocumento.valueOf((String) cmbTipoDocumento.getSelectedItem());
        //validar datos
        StringBuilder errores = new StringBuilder();

        if (nombre.isEmpty() || apellido.isEmpty()) {
            errores.append("- Nombre y apellido son obligatorios.\n");
        }
        if (telefono.isEmpty()) {
            errores.append("- Un teléfono es obligatorio.\n");
        }
        if (documento.isEmpty()) {
            errores.append("- Un número de documento es obligatorio.\n");
        }
        if (direccion.isEmpty()) {
            errores.append("- Una dirección es obligatoria.");
        }
        if (errores.length() > 0) {
            Mensajes.mostrarMensaje(errores.toString(), "error");
            return;
        }
        // Validar el documento
        String mensajeDocumento = validarDocumentoPorTipo(tipo, documento);
        if (mensajeDocumento != null) {
            Mensajes.mostrarMensaje(mensajeDocumento, "error");
            return;
        }
        //determina edicion
        if (usuarioEnEdicion == null) {
            boolean conf = Mensajes.confirmar("¿Desea guardar el nuevo usuarios?");
            if (!conf) {
                return;
            }
            Usuario nuevo = new Usuario();
            nuevo.setNombres(nombre);
            nuevo.setApellidos(apellido);
            //nuevo.setDni(dni);
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
            boolean conf = Mensajes.confirmar("¿Desea guardar los cambios?");
            if (!conf) {
                return;
            }
            usuarioEnEdicion.setNombres(nombre);
            usuarioEnEdicion.setApellidos(apellido);
            //usuarioEnEdicion.setDni(dni);
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

                Mensajes.mostrarMensaje("Contraseña restablecida a '123456'\nInformar a: " + cargarNombre(usuarioEnEdicion), "informacion");
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
            limpiarCampos();
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
                    txtDocumento.setText(usuarioEnEdicion.getDocumento());
                    txtDireccion.setText(usuarioEnEdicion.getDireccion());
                    cargarRolesUsuario(usuarioEnEdicion);
                    // Cambiar el texto del botón para indicar que estamos editando
                    btnGuardar1.setText("Actualizar");
                    btnEditar1.setText("Cancelar");
                    btnCrearRol.setText("Agregar rol");
                    btnRestablecer.setEnabled(true);
                    btnTodo.setEnabled(false);
                    labelRol.setText("Roles:");
                    Extras.Mensajes.mostrarMensaje("Modifique los datos y presione 'Actualizar'", "informacion");
                } else {
                    Extras.Mensajes.mostrarMensaje("Seleccione la fila a editar", "advertencia");
                }
            }
        }
    }//GEN-LAST:event_btnEditar1ActionPerformed

    private void btnCrearRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearRolActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String termino = txtBuscar.getText();
        usuarios = filtrarPorNombre(usuarios, termino);
        if (usuarios.isEmpty()) {
            Mensajes.mostrarMensaje("No se encontraron usuarios con este término", "error");
            recargarTablaUsuarios();
            return;
        }
        generarTabla(usuarios);
        usuarios = control.getControlUsuario().leerTodo();
        txtBuscar.setText("");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodoActionPerformed
        recargarTablaUsuarios();    }//GEN-LAST:event_btnTodoActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            String termino = txtBuscar.getText();
            usuarios = filtrarPorNombre(usuarios, termino);
            if (usuarios.isEmpty()) {
                Mensajes.mostrarMensaje("No se encontraron usuarios con este término", "error");
                recargarTablaUsuarios();
                return;
            }
            generarTabla(usuarios);
            usuarios = control.getControlUsuario().leerTodo();
            txtBuscar.setText("");
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        ExportadorReporte.generarReporte(tblUsuarios, "usuarios");
    }//GEN-LAST:event_btnReporteActionPerformed

    private void cmbTipoDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoDocumentoActionPerformed
        txtDocumento.setText("");
    }//GEN-LAST:event_cmbTipoDocumentoActionPerformed

    private void btnAgregarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPaisActionPerformed
        IFPaises igu = new IFPaises(pantalla, tool);
        pantalla.add(igu);
        igu.show();
        igu.setLocation(10, tool.getHeight() + 10);
        this.dispose();
    }//GEN-LAST:event_btnAgregarPaisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarPais;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrearRol;
    private javax.swing.JButton btnEditar1;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnRestablecer;
    private javax.swing.JButton btnTodo;
    private javax.swing.JComboBox<String> cmbPais;
    private javax.swing.JComboBox<String> cmbRoles;
    private javax.swing.JComboBox<String> cmbTipoDocumento;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel labelRol;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento;
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

        String[] titulos = {"Nombre", "Rol", "Tipo de Documento", "Nro. de Documento", "Telefono", "Dirección", "País"};
        modeloTabla.setColumnIdentifiers(titulos);
        modeloTabla.setRowCount(0);

        // Itera sobre los detalles y los agrega a la tabla
        for (Usuario user : listUsuarios) {
            Object[] obj = {
                cargarNombre(user),
                rolesComoTexto(user.getRoles()),
                user.getTipoDocumento().toString(),
                user.getDocumento(),
                user.getTelefono(),
                user.getDireccion(),
                user.getPais().getNombre()
            };
            modeloTabla.addRow(obj);
        }

        tblUsuarios.setModel(modeloTabla);

        //tamaños
        tblUsuarios.getColumnModel().getColumn(0).setPreferredWidth(180);
        tblUsuarios.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblUsuarios.getColumnModel().getColumn(2).setPreferredWidth(250);
        tblUsuarios.getColumnModel().getColumn(3).setPreferredWidth(250);
        tblUsuarios.getColumnModel().getColumn(4).setPreferredWidth(150);
        tblUsuarios.getColumnModel().getColumn(5).setPreferredWidth(180);
        tblUsuarios.getColumnModel().getColumn(6).setPreferredWidth(200);

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

    private void soloNumerosDocumento() {
        txtDocumento.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String textoActual = txtDocumento.getText();

                // Obtener el tipo seleccionado
                String tipo = cmbTipoDocumento.getSelectedItem().toString();
                // Validar solo si es carácter numérico
                if (!Character.isDigit(c)) {
                    e.consume();
                    return;
                }

                // Validar longitud máxima según tipo
                int maxDigitos = switch (tipo) {
                    case "DNI" ->
                        8;
                    case "CARNET_EXTRANJERIA" ->
                        9;
                    default ->
                        10;
                };

                if (textoActual.length() >= maxDigitos) {
                    e.consume();
                }
            }
        });

    }

    private void limpiarCampos() {
        txtApellido1.setText("");
        txtNombre1.setText("");
        txtDocumento.setText("");
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
        btnCrearRol.setText("Crear Rol");
        btnTodo.setEnabled(true);
    }

    private void cargarRolesUsuario(Usuario user) {
        cmbRoles.removeAllItems();
        for (Rol r : user.getRoles()) {
            cmbRoles.addItem(r.getNombre());
        }
    }

    public List<Usuario> filtrarPorNombre(List<Usuario> usuarioos, String nombreFiltro) {
        String filtro = nombreFiltro.trim().toLowerCase();

        return usuarios.stream()
                .filter(c -> (filtro.isEmpty() || (c.getNombres() + " " + c.getApellidos()).toLowerCase().contains(filtro)))
                .collect(Collectors.toList());
    }

    private void cargarTipoDocumento() {
        cmbTipoDocumento.removeAllItems();
        for (TipoDocumento tip : TipoDocumento.values()) {
            cmbTipoDocumento.addItem(tip.name());
        }
    }

    private String validarDocumentoPorTipo(TipoDocumento tipo, String documento) {
        if (!documento.matches("\\d+")) {
            return "El número de documento solo debe contener dígitos.";
        }

        return switch (tipo) {
            case DNI ->
                documento.length() == 8 ? null : "El DNI debe tener 8 dígitos.";
            case CARNET_EXTRANJERIA ->
                documento.length() == 9 ? null : "El carnet de extranjería debe tener 9 dígitos.";
            default ->
                (documento.length() >= 6 && documento.length() <= 12)
                ? null
                : "El documento debe tener entre 6 y 12 dígitos.";
        };
    }

    private void cargarPaises() {
        cmbPais.removeAllItems();
        for (Pais pais : control.getControlPais().leerTodo()) {
            cmbPais.addItem(pais.getNombre());
        }
    }
}
