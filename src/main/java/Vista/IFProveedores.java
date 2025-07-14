package Vista;

import Controlador.ControladoraGeneral;
import Extras.ExportadorReporte;
import Extras.Mensajes;
import Modelo.Proveedor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class IFProveedores extends javax.swing.JInternalFrame {

    private final ControladoraGeneral control;
    private List<Proveedor> proveedores;
    private Proveedor proveedorEnEdicion = null;
    private Proveedor prov;
    private final JDesktopPane pantalla;
    private final JToolBar tool;
    private boolean asc = false;

    public IFProveedores(JDesktopPane desktopPane, JToolBar tool) {
        initComponents();
        control = new ControladoraGeneral();
        this.proveedores = control.getControlProveedor().leerTodo();
        cargarProveedor(proveedores);
        this.prov = null;
        this.pantalla = desktopPane;
        this.tool = tool;
        soloNumerosRuc();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtRuc = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtWeb = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProveedores = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        btnWeb = new javax.swing.JButton();
        btnCopiarProv = new javax.swing.JButton();
        btnContacto = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnAscDesc = new javax.swing.JButton();
        btnTodo = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();

        setTitle("Proveedores");

        jPanel1.setBackground(new java.awt.Color(239, 228, 210));
        jPanel1.setPreferredSize(new java.awt.Dimension(1046, 710));

        btnRegresar.setBackground(new java.awt.Color(239, 228, 210));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo_Prove.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 58, 81));
        jLabel9.setText("Nombre:");

        btnGuardar.setBackground(new java.awt.Color(30, 58, 81));
        btnGuardar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(239, 228, 210));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 58, 81));
        jLabel10.setText("RUC:");

        jLabel12.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(30, 58, 81));
        jLabel12.setText("Web:");

        jLabel13.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(30, 58, 81));
        jLabel13.setText("Correo:");

        tblProveedores.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        tblProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Teléfono", "Correo", "Dirección", "Ruc"
            }
        ));
        tblProveedores.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tblProveedores);

        btnEditar.setBackground(new java.awt.Color(30, 58, 81));
        btnEditar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(239, 228, 210));
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(30, 58, 81));
        btnEliminar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(239, 228, 210));
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(30, 58, 81));
        jLabel15.setText("Dirección:");

        btnWeb.setBackground(new java.awt.Color(30, 58, 81));
        btnWeb.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnWeb.setForeground(new java.awt.Color(239, 228, 210));
        btnWeb.setText("Ir");
        btnWeb.setEnabled(false);
        btnWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWebActionPerformed(evt);
            }
        });

        btnCopiarProv.setBackground(new java.awt.Color(30, 58, 81));
        btnCopiarProv.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnCopiarProv.setForeground(new java.awt.Color(239, 228, 210));
        btnCopiarProv.setText("Copiar");
        btnCopiarProv.setEnabled(false);
        btnCopiarProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiarProvActionPerformed(evt);
            }
        });

        btnContacto.setBackground(new java.awt.Color(30, 58, 81));
        btnContacto.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnContacto.setForeground(new java.awt.Color(239, 228, 210));
        btnContacto.setText("Ver Contactos");
        btnContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContactoActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(239, 228, 210));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 3), "Buscar por Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 18), new java.awt.Color(137, 6, 6))); // NOI18N

        btnBuscar.setBackground(new java.awt.Color(30, 58, 81));
        btnBuscar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(239, 228, 210));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtBuscar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        btnAscDesc.setBackground(new java.awt.Color(30, 58, 81));
        btnAscDesc.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        btnAscDesc.setForeground(new java.awt.Color(239, 228, 210));
        btnAscDesc.setText("Z - A");
        btnAscDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAscDescActionPerformed(evt);
            }
        });

        btnTodo.setBackground(new java.awt.Color(30, 58, 81));
        btnTodo.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        btnTodo.setForeground(new java.awt.Color(239, 228, 210));
        btnTodo.setText("Ver Todo");
        btnTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodoActionPerformed(evt);
            }
        });

        btnReporte.setBackground(new java.awt.Color(30, 58, 81));
        btnReporte.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(239, 228, 210));
        btnReporte.setText("Generar Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnWeb))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btnCopiarProv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtDireccion)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1039, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator5))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(171, 171, 171)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(168, 168, 168))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(159, 159, 159)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(836, 836, 836)
                                        .addComponent(btnAscDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)))))))
                .addContainerGap(1, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAscDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btnTodo, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtWeb, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnWeb)))
                        .addGap(8, 8, 8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCopiarProv))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(btnContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // Leer datos del formulario
        String nombre = txtNombre.getText();
        String web = txtWeb.getText();
        String correo = txtCorreo.getText();
        String direccion = txtDireccion.getText();
        String ruc = txtRuc.getText();

        // Validaciones básicas
        StringBuilder errores = new StringBuilder();

        if (nombre.isEmpty()) {
            errores.append("- El nombre es obligatorio.\n");
        }
        if (web.isEmpty()) {
            errores.append("- La web es obligatoria.\n");
        }
        if (correo.isEmpty()) {
            errores.append("- El correo es obligatorio.\n");
        }
        if (direccion.isEmpty()) {
            errores.append("- La dirección es obligatoria.\n");
        }
        if (ruc.isEmpty()) {
            errores.append("- El RUC es obligatorio.\n");
        }

        if (errores.length() > 0) {
            Mensajes.mostrarMensaje(errores.toString(), "error");
            return;
        }
        // Validar correo electrónico
        if (!correo.matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,}$")) {
            Mensajes.mostrarMensaje("Ingrese un correo válido", "error");
            return;
        }
        // Validar dirección web si no está vacía
        if (!web.matches("^(https?://)?([\\w-]+\\.)+[\\w-]{2,}(\\/[\\w\\-./?%&=]*)?$")) {
            Extras.Mensajes.mostrarMensaje("Ingrese una dirección web válida", "error");
            return;
        }
        // Validar RUC (11 dígitos numéricos en Perú)
        if (!ruc.matches("^\\d{11}$")) {
            Mensajes.mostrarMensaje("El RUC debe contener exactamente 11 dígitos numéricos", "error");
            return;
        }
        // Validar que solo tenga letras y espacios
        /*if (!nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")) {
            Mensajes.mostrarMensaje("El nombre solo debe contener letras", "error");
            return;
        }*/
        if (proveedorEnEdicion != null) {
            boolean conf = Mensajes.confirmar("¿Desea actualizar el proveedor?");
            if (!conf) {
                return;
            }

            // Modo edición: actualizar proveedor existente
            proveedorEnEdicion.setNombre(nombre);
            proveedorEnEdicion.setSitioWeb(web);
            proveedorEnEdicion.setCorreo(correo);
            proveedorEnEdicion.setDireccion(direccion);
            proveedorEnEdicion.setRUC(ruc);

            control.getControlProveedor().actualizarProveedor(proveedorEnEdicion);

            Extras.Mensajes.mostrarMensaje("Proveedor actualizado correctamente", "informacion");

            finalizarEdicion(); // Limpiar modo edición
            proveedores = control.getControlProveedor().leerTodo();
            cargarProveedor(proveedores);
        } else {
            boolean conf = Mensajes.confirmar("¿Desea registrar el proveedor?");
            if (!conf) {
                return;
            }
            prov = new Proveedor();
            prov.setNombre(nombre);
            prov.setCorreo(correo);
            prov.setDireccion(direccion);
            prov.setRUC(ruc);
            prov.setSitioWeb(web);

            List<Proveedor> provee = control.getControlProveedor().leerTodo();
            provee.add(prov);

            //guardar
            control.getControlProveedor().crearProveedor(prov);
            proveedores = control.getControlProveedor().leerTodo();
            cargarProveedor(proveedores);
            prov = null;
            txtNombre.setText("");
            txtWeb.setText("");
            txtCorreo.setText("");
            txtDireccion.setText("");
            txtRuc.setText("");
            Mensajes.mostrarMensaje("Proveedor creado con éxito.\nNo olvide asociarle contactos.", "informacion");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (proveedorEnEdicion != null) {
            finalizarEdicion();
            Extras.Mensajes.mostrarMensaje("Edición Cancelada", "informacion");
        } else {
            if (tblProveedores.getRowCount() > 0) {
                int filaSelect = tblProveedores.getSelectedRow();
                if (filaSelect != -1) {
                    // Marcar que estamos en modo edición
                    proveedorEnEdicion = proveedores.get(filaSelect);

                    // Cargar datos del proveedor seleccionado en los campos de texto
                    txtNombre.setText(proveedorEnEdicion.getNombre());
                    txtWeb.setText(proveedorEnEdicion.getSitioWeb());
                    txtCorreo.setText(proveedorEnEdicion.getCorreo());
                    txtDireccion.setText(proveedorEnEdicion.getDireccion());
                    txtRuc.setText(proveedorEnEdicion.getRUC());

                    // Cambiar el texto del botón para indicar que estamos editando
                    btnGuardar.setText("Actualizar");
                    btnEditar.setText("Cancelar Edición");
                    btnWeb.setEnabled(true);
                    btnCopiarProv.setEnabled(true);
                    txtBuscar.setEnabled(false);
                    btnBuscar.setEnabled(false);
                    btnAscDesc.setEnabled(false);
                    btnTodo.setEnabled(false);
                    Extras.Mensajes.mostrarMensaje("Modifique los datos y presione 'Actualizar'", "informacion");
                } else {
                    Extras.Mensajes.mostrarMensaje("Seleccione la fila a editar", "advertencia");
                }
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tblProveedores.getRowCount() > 0) {
            int filaSelect = tblProveedores.getSelectedRow();
            //Asegurar selección
            if (filaSelect != -1) {
                Proveedor proveedoresseleccionado = proveedores.get(filaSelect);
                boolean conf = Extras.Mensajes.confirmar("¿Desea eliminar este elemento?");
                if (conf) {
                    control.getControlProveedor().eliminarProveedor(proveedoresseleccionado.getIdProveedor());
                    proveedores.remove(filaSelect);
                    proveedores = control.getControlProveedor().leerTodo();
                    cargarProveedor(proveedores);
                }
            } else {
                Extras.Mensajes.mostrarMensaje("Seleccione la fila a eliminar", "advertencia");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWebActionPerformed
        String url = txtWeb.getText().trim();

        if (url.isEmpty()) {
            Extras.Mensajes.mostrarMensaje("El campo web está vacío", "error");
            return;
        }

        // Asegurarse de que tenga protocolo
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }

        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException | URISyntaxException ex) {
            Mensajes.mostrarMensaje("No se pudo abrir el enlace: " + ex.getMessage(), "error");
        }
    }//GEN-LAST:event_btnWebActionPerformed

    private void btnCopiarProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarProvActionPerformed
        String correo = txtCorreo.getText().trim();

        if (correo.isEmpty()) {
            Extras.Mensajes.mostrarMensaje("El campo de correo está vacío", "error");
            return;
        }

        // Copiar al portapapeles
        StringSelection seleccion = new StringSelection(correo);
        Clipboard portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();
        portapapeles.setContents(seleccion, null);

        Mensajes.mostrarMensaje("Correo copiado al portapapeles", "informacion");
    }//GEN-LAST:event_btnCopiarProvActionPerformed

    private void btnContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContactoActionPerformed
        if (tblProveedores.getRowCount() > 0) {
            int filaSelect = tblProveedores.getSelectedRow();
            if (filaSelect != -1) {
                // Marcar que estamos en modo edición
                Proveedor provedorCont = proveedores.get(filaSelect);
                IFProveedoresContactos igu = new IFProveedoresContactos(pantalla, provedorCont, tool);
                pantalla.add(igu);
                igu.show();
                igu.setLocation(10, tool.getHeight() + 10);
                this.dispose();
            } else {
                Extras.Mensajes.mostrarMensaje("Seleccione un proveedor para ver sus contactos", "advertencia");
            }
        }
    }//GEN-LAST:event_btnContactoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String termino = txtBuscar.getText();
        proveedores = control.getControlProveedor().leerParcial(termino);
        if (proveedores.isEmpty()) {
            Mensajes.mostrarMensaje("No se encontraron proveedores con este término", "error");
            recargarTabla();
            return;
        }
        cargarProveedor(proveedores);
        txtBuscar.setText("");
        btnAscDesc.setText("Z - A");
        asc = false;
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAscDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAscDescActionPerformed
        if (!asc) {
            proveedores = control.getControlProveedor().ordenarZA(proveedores);
            cargarProveedor(proveedores);
        } else {
            proveedores = control.getControlProveedor().ordenarAZ(proveedores);
            cargarProveedor(proveedores);
        }
        esAscendente();
    }//GEN-LAST:event_btnAscDescActionPerformed

    private void btnTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodoActionPerformed
        proveedores = control.getControlProveedor().leerTodo();
        cargarProveedor(proveedores);
    }//GEN-LAST:event_btnTodoActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        ExportadorReporte.generarReporte(tblProveedores, "provedores");
    }//GEN-LAST:event_btnReporteActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            String termino = txtBuscar.getText();
            proveedores = control.getControlProveedor().leerParcial(termino);
            if (proveedores.isEmpty()) {
                Mensajes.mostrarMensaje("No se encontraron proveedores con este término", "error");
                recargarTabla();
                return;
            }
            cargarProveedor(proveedores);
            txtBuscar.setText("");
            btnAscDesc.setText("Z - A");
            asc = false;
        }
    }//GEN-LAST:event_txtBuscarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAscDesc;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnContacto;
    private javax.swing.JButton btnCopiarProv;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnTodo;
    private javax.swing.JButton btnWeb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable tblProveedores;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRuc;
    private javax.swing.JTextField txtWeb;
    // End of variables declaration//GEN-END:variables

    private void cargarProveedor(List<Proveedor> proveedores) {
        // Inicializa el modelo de la tabla y establece las columnas
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] titulos = {"Nombre", "RUC", "Direccion", "Correo", "Contactos", "Dirección web"};
        modeloTabla.setColumnIdentifiers(titulos);
        modeloTabla.setRowCount(0);

        // Itera sobre los detalles y los agrega a la tabla
        for (Proveedor proveedor : proveedores) {
            Object[] obj = {
                proveedor.getNombre(),
                proveedor.getRUC(),
                proveedor.getDireccion(),
                proveedor.getCorreo(),
                cargarContactos(proveedor),
                proveedor.getSitioWeb()
            };
            modeloTabla.addRow(obj);
        }

        tblProveedores.setModel(modeloTabla);

        //tamaños
        tblProveedores.getColumnModel().getColumn(0).setPreferredWidth(200);
        tblProveedores.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblProveedores.getColumnModel().getColumn(2).setPreferredWidth(200);
        tblProveedores.getColumnModel().getColumn(3).setPreferredWidth(250);
        tblProveedores.getColumnModel().getColumn(4).setPreferredWidth(150);
        tblProveedores.getColumnModel().getColumn(5).setPreferredWidth(250);

        // Centra el texto en todas las celdas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplica el render centrado a cada columna
        for (int i = 0; i < tblProveedores.getColumnCount(); i++) {
            tblProveedores.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        //formatear el tamaño de texto
        tblProveedores.setRowHeight(35);
        JTableHeader header = tblProveedores.getTableHeader();
        header.setFont(new java.awt.Font("PMingLiU-ExtB", Font.BOLD, 26));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
    }

    private void finalizarEdicion() {
        proveedorEnEdicion = null;
        btnGuardar.setText("Agregar Producto");
        btnEditar.setText("Editar");
        btnWeb.setEnabled(false);
        btnCopiarProv.setEnabled(false);
        txtBuscar.setEnabled(true);
        btnBuscar.setEnabled(true);
        btnTodo.setEnabled(true);
        btnAscDesc.setEnabled(true);
        // Limpiar campos del formulario de proveedor
        txtNombre.setText("");
        txtWeb.setText("");
        txtCorreo.setText("");
        txtDireccion.setText("");
        txtRuc.setText("");
    }

    private int cargarContactos(Proveedor proveedor) {
        int cant = proveedor.getContactos().size();
        return cant;
    }

    private void esAscendente() {
        btnAscDesc.setText(asc ? "Z - A" : "A - Z");
        asc = !asc;
    }

    private void soloNumerosRuc() {
        txtRuc.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                // Solo permite dígitos y longitud máxima de 11
                if (!Character.isDigit(c) || txtRuc.getText().length() >= 11) {
                    e.consume();
                }
            }
        });
    }

    private void recargarTabla() {
        proveedores = control.getControlProveedor().leerTodo();
        cargarProveedor(proveedores);
    }
}
