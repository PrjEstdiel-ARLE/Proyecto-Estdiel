package Vista;

import Modelo.Proveedor;
import Controlador.ControladoraGeneral;
import Extras.Mensajes;
import Modelo.ContactoCargo;
import Modelo.ContactoProveedor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

import java.util.List;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ProveedoresContactos extends javax.swing.JFrame {
    
    private final ControladoraGeneral control;
    private ContactoProveedor contacto;
    private List<ContactoProveedor> contactos;
    private ContactoProveedor contactoEnEdicion = null;
    private final Proveedor prov;
    
    public ProveedoresContactos(Proveedor proveedor) {
        this.prov = proveedor;
        initComponents();
        control = new ControladoraGeneral();
        cargarCargos();
        cargarContactos(proveedor);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        panelContacto = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblContactos = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtNombreContacto = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtApellidoContacto = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtTelefonoContacto = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCorreoContacto = new javax.swing.JTextField();
        btnCopiarContacto = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        cmbCargos = new javax.swing.JComboBox<>();
        btnGuardarContacto = new javax.swing.JButton();
        btnEditarContacto = new javax.swing.JButton();
        btnEliminarContacto = new javax.swing.JButton();
        MenuBar3 = new javax.swing.JMenuBar();
        menuArchivo3 = new javax.swing.JMenu();
        itemCerrar3 = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();
        menuGestion = new javax.swing.JMenu();
        itemProductos = new javax.swing.JMenuItem();
        itemProveedores = new javax.swing.JMenuItem();
        itemCategorias = new javax.swing.JMenuItem();
        itemUsuarios = new javax.swing.JMenuItem();
        menuInventario = new javax.swing.JMenu();
        itemLotes = new javax.swing.JMenuItem();
        itemFiltro = new javax.swing.JMenuItem();
        menuLogistica = new javax.swing.JMenu();
        itemRegistrarPedido = new javax.swing.JMenuItem();
        itemVerPedidos = new javax.swing.JMenuItem();
        itemSalidas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(239, 228, 210));
        jPanel1.setPreferredSize(new java.awt.Dimension(1046, 710));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo.png"))); // NOI18N

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

        jLabel4.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 65)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(137, 6, 6));
        jLabel4.setText(":Contactos");

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        panelContacto.setBackground(new java.awt.Color(239, 228, 210));
        panelContacto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3), "Contactos de "+prov.getNombre(), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 18), new java.awt.Color(137, 6, 6)));

        tblContactos.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        tblContactos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cargo", "Teléfono", "Correo"
            }
        ));
        tblContactos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tblContactos);

        jLabel14.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(30, 58, 81));
        jLabel14.setText("Nombre:");

        jLabel16.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(30, 58, 81));
        jLabel16.setText("Apellido:");

        jLabel17.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(30, 58, 81));
        jLabel17.setText("Teléfono:");

        jLabel18.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(30, 58, 81));
        jLabel18.setText("Correo:");

        btnCopiarContacto.setBackground(new java.awt.Color(30, 58, 81));
        btnCopiarContacto.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        btnCopiarContacto.setForeground(new java.awt.Color(239, 228, 210));
        btnCopiarContacto.setText("Copiar");
        btnCopiarContacto.setEnabled(false);
        btnCopiarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopiarContactoActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(30, 58, 81));
        jLabel19.setText("Cargo:");

        cmbCargos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbCargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardarContacto.setBackground(new java.awt.Color(30, 58, 81));
        btnGuardarContacto.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnGuardarContacto.setForeground(new java.awt.Color(239, 228, 210));
        btnGuardarContacto.setText("Guardar");
        btnGuardarContacto.setToolTipText("");
        btnGuardarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarContactoActionPerformed(evt);
            }
        });

        btnEditarContacto.setBackground(new java.awt.Color(30, 58, 81));
        btnEditarContacto.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnEditarContacto.setForeground(new java.awt.Color(239, 228, 210));
        btnEditarContacto.setText("Editar");
        btnEditarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarContactoActionPerformed(evt);
            }
        });

        btnEliminarContacto.setBackground(new java.awt.Color(30, 58, 81));
        btnEliminarContacto.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnEliminarContacto.setForeground(new java.awt.Color(239, 228, 210));
        btnEliminarContacto.setText("Eliminar");
        btnEliminarContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarContactoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContactoLayout = new javax.swing.GroupLayout(panelContacto);
        panelContacto.setLayout(panelContactoLayout);
        panelContactoLayout.setHorizontalGroup(
            panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContactoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(panelContactoLayout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelContactoLayout.createSequentialGroup()
                                .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(18, 18, 18)
                                .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefonoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCorreoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCopiarContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelContactoLayout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtApellidoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelContactoLayout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbCargos, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(btnGuardarContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelContactoLayout.createSequentialGroup()
                                .addComponent(btnEditarContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(btnEliminarContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 78, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelContactoLayout.setVerticalGroup(
            panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContactoLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtNombreContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtApellidoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTelefonoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(cmbCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtCorreoContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCopiarContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(254, 254, 254)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(254, 254, 254)
                        .addComponent(jLabel2)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(116, 116, 116))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(panelContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        MenuBar3.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N

        menuArchivo3.setText("Archivo");
        menuArchivo3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        itemCerrar3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemCerrar3.setText("Cerrar Sesión");
        itemCerrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrar3ActionPerformed(evt);
            }
        });
        menuArchivo3.add(itemCerrar3);
        menuArchivo3.add(jSeparator7);

        itemSalir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuArchivo3.add(itemSalir);

        MenuBar3.add(menuArchivo3);

        menuGestion.setText("Gestión");
        menuGestion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        itemProductos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemProductos.setText("Productos");
        itemProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProductosActionPerformed(evt);
            }
        });
        menuGestion.add(itemProductos);

        itemProveedores.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemProveedores.setText("Proveedores");
        itemProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProveedoresActionPerformed(evt);
            }
        });
        menuGestion.add(itemProveedores);

        itemCategorias.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemCategorias.setText("Categorías");
        itemCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCategoriasActionPerformed(evt);
            }
        });
        menuGestion.add(itemCategorias);

        itemUsuarios.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemUsuarios.setText("Usuarios");
        itemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUsuariosActionPerformed(evt);
            }
        });
        menuGestion.add(itemUsuarios);

        MenuBar3.add(menuGestion);

        menuInventario.setText("Inventario");
        menuInventario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        itemLotes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemLotes.setText("Lotes");
        itemLotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLotesActionPerformed(evt);
            }
        });
        menuInventario.add(itemLotes);

        itemFiltro.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemFiltro.setText("Filtro de Productos");
        itemFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFiltroActionPerformed(evt);
            }
        });
        menuInventario.add(itemFiltro);

        MenuBar3.add(menuInventario);

        menuLogistica.setText("Logística");
        menuLogistica.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        itemRegistrarPedido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemRegistrarPedido.setText("Registrar Pedido");
        itemRegistrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarPedidoActionPerformed(evt);
            }
        });
        menuLogistica.add(itemRegistrarPedido);

        itemVerPedidos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemVerPedidos.setText("Ver Pedidos");
        itemVerPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVerPedidosActionPerformed(evt);
            }
        });
        menuLogistica.add(itemVerPedidos);

        itemSalidas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemSalidas.setText("Salidas");
        itemSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalidasActionPerformed(evt);
            }
        });
        menuLogistica.add(itemSalidas);

        MenuBar3.add(menuLogistica);

        setJMenuBar(MenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1362, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 719, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCerrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrar3ActionPerformed
        boolean conf = Mensajes.confirmar("¿Desea cerrar sesión?");
        if (conf) {
            Login lo = new Login();
            lo.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_itemCerrar3ActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        boolean conf = Mensajes.confirmar("¿Desea cerrar la ventana completa?");
        if (conf) {
            this.dispose();
        }
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProductosActionPerformed
        Productos prod = new Productos();
        prod.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemProductosActionPerformed

    private void itemProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProveedoresActionPerformed
        Proveedores provIGU = new Proveedores();
        provIGU.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemProveedoresActionPerformed

    private void itemCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCategoriasActionPerformed
        Categorias cat = new Categorias();
        cat.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemCategoriasActionPerformed

    private void itemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUsuariosActionPerformed
        Usuario us = new Usuario();
        us.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemUsuariosActionPerformed

    private void itemLotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLotesActionPerformed
        Lotes lot = new Lotes();
        lot.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemLotesActionPerformed

    private void itemFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFiltroActionPerformed
        ProductoProveedor PP = new ProductoProveedor();
        PP.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemFiltroActionPerformed

    private void itemRegistrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarPedidoActionPerformed
        RegistrarPedido reg = new RegistrarPedido();
        reg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemRegistrarPedidoActionPerformed

    private void itemVerPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVerPedidosActionPerformed
        Pedidos ped = new Pedidos();
        ped.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemVerPedidosActionPerformed

    private void itemSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalidasActionPerformed
        SalidasLote SL = new SalidasLote();
        SL.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_itemSalidasActionPerformed

    private void btnEliminarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarContactoActionPerformed
        if (tblContactos.getRowCount() > 0) {
            int filaSelect = tblContactos.getSelectedRow();
            //Asegurar selección
            if (filaSelect != -1) {
                contactos = control.getControlContactoProveedor().leerPorProveedor(prov);
                ContactoProveedor contSelect = contactos.get(filaSelect);
                boolean conf = Extras.Mensajes.confirmar("¿Desea eliminar este elemento?");
                if (conf) {
                    control.getControlContactoProveedor().eliminar(contSelect.getIdContacto());
                    contactos.remove(filaSelect);
                    cargarContactos(prov);
                }
            } else {
                Extras.Mensajes.mostrarMensaje("Seleccione la fila a eliminar", "advertencia");
            }
        }
    }//GEN-LAST:event_btnEliminarContactoActionPerformed

    private void btnEditarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarContactoActionPerformed
        if (contactoEnEdicion != null) {
            finalizarEdicion();
            Mensajes.mostrarMensaje("Edición cancelada", "informacion");
        } else {
            if (tblContactos.getRowCount() > 0) {
                int filaSelect = tblContactos.getSelectedRow();
                if (filaSelect != -1) {
                    // Marcar que estamos en modo edición
                    contactos = control.getControlContactoProveedor().leerPorProveedor(prov);
                    contactoEnEdicion = contactos.get(filaSelect);
                    // Cargar datos en los campos
                    txtNombreContacto.setText(contactoEnEdicion.getNombre());
                    txtApellidoContacto.setText(contactoEnEdicion.getApellido());
                    txtTelefonoContacto.setText(contactoEnEdicion.getTelefono());
                    txtCorreoContacto.setText(contactoEnEdicion.getCorreo());
                    cmbCargos.setSelectedItem(contactoEnEdicion.getCargo().name());
                    // Cambiar el texto del botón para indicar que estamos editando
                    btnGuardarContacto.setText("Actualizar");
                    btnEditarContacto.setText("Cancelar");
                    btnCopiarContacto.setEnabled(true);
                    Extras.Mensajes.mostrarMensaje("Modifique los datos y presione 'Actualizar'", "informacion");
                } else {
                    Extras.Mensajes.mostrarMensaje("Seleccione la fila a editar", "advertencia");
                }
            }
        }
    }//GEN-LAST:event_btnEditarContactoActionPerformed

    private void btnGuardarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarContactoActionPerformed
        //leer datos
        String nombre = txtNombreContacto.getText();
        String apellido = txtApellidoContacto.getText();
        String correo = txtCorreoContacto.getText();
        String telefono = txtTelefonoContacto.getText();
        ContactoCargo cargo = ContactoCargo.valueOf((String) cmbCargos.getSelectedItem());
        //validar datos
        StringBuilder errores = new StringBuilder();
        
        if (nombre.isEmpty() || apellido.isEmpty()) {
            errores.append("- Nombre y apellido son obligatorios.\n");
        }
        if (telefono.isEmpty()) {
            errores.append("- Un teléfono es obligatorio.\n");
        }
        if (correo.isEmpty()) {
            errores.append("- Un correo es obligatorio.\n");
        }
        
        if (errores.length() > 0) {
            Mensajes.mostrarMensaje(errores.toString(), "error");
            return;
        }
        //validacion de formato
        if (!correo.matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,}$")) {
            Extras.Mensajes.mostrarMensaje("Ingrese un correo válido", "error");
            return;
        }

        // Validar teléfono (solo dígitos 9 caracteres)
        if (!telefono.matches("^\\d{9}$")) {
            Extras.Mensajes.mostrarMensaje("Ingrese un número de teléfono válido (9 dígitos)", "error");
            return;
        }
        // Validar que solo tenga letras y espacios
        if (!nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")) {
            Extras.Mensajes.mostrarMensaje("El nombre solo debe contener letras", "error");
            return;
        }
        // Validar que solo tenga letras y espacios
        if (!apellido.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")) {
            Extras.Mensajes.mostrarMensaje("El nombre solo debe contener letras", "error");
            return;
        }
        if (contactoEnEdicion != null) {
            //actualizacion
            contactoEnEdicion.setApellido(apellido);
            contactoEnEdicion.setNombre(nombre);
            contactoEnEdicion.setTelefono(telefono);
            contactoEnEdicion.setCorreo(correo);
            contactoEnEdicion.setCargo(cargo);
            control.getControlContactoProveedor().actualizar(contactoEnEdicion);
            Mensajes.mostrarMensaje("Edición exitosa", "informacion");
            //terminar edicion
            finalizarEdicion();
            cargarContactos(prov);
        } else {
            //guardar datos
            contacto = new ContactoProveedor();
            contacto.setApellido(apellido);
            contacto.setNombre(nombre);
            contacto.setCargo(cargo);
            contacto.setCorreo(correo);
            contacto.setTelefono(telefono);
            contacto.setProveedor(prov);
            control.getControlContactoProveedor().crear(contacto);
            cargarContactos(prov);
            limpiar();
            Mensajes.mostrarMensaje("Contacto creado correctamente", "informacion");
        }
    }//GEN-LAST:event_btnGuardarContactoActionPerformed

    private void btnCopiarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopiarContactoActionPerformed
        String correo = txtCorreoContacto.getText().trim();
        
        if (correo.isEmpty()) {
            Extras.Mensajes.mostrarMensaje("El campo de correo está vacío", "error");
            return;
        }

        // Copiar al portapapeles
        StringSelection seleccion = new StringSelection(correo);
        Clipboard portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();
        portapapeles.setContents(seleccion, null);
        
        Extras.Mensajes.mostrarMensaje("Correo copiado al portapapeles", "informacion");
    }//GEN-LAST:event_btnCopiarContactoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Proveedores madmin = new Proveedores();
        madmin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar3;
    private javax.swing.JButton btnCopiarContacto;
    private javax.swing.JButton btnEditarContacto;
    private javax.swing.JButton btnEliminarContacto;
    private javax.swing.JButton btnGuardarContacto;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbCargos;
    private javax.swing.JMenuItem itemCategorias;
    private javax.swing.JMenuItem itemCerrar3;
    private javax.swing.JMenuItem itemFiltro;
    private javax.swing.JMenuItem itemLotes;
    private javax.swing.JMenuItem itemProductos;
    private javax.swing.JMenuItem itemProveedores;
    private javax.swing.JMenuItem itemRegistrarPedido;
    private javax.swing.JMenuItem itemSalidas;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuItem itemUsuarios;
    private javax.swing.JMenuItem itemVerPedidos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JMenu menuArchivo3;
    private javax.swing.JMenu menuGestion;
    private javax.swing.JMenu menuInventario;
    private javax.swing.JMenu menuLogistica;
    private javax.swing.JPanel panelContacto;
    private javax.swing.JTable tblContactos;
    private javax.swing.JTextField txtApellidoContacto;
    private javax.swing.JTextField txtCorreoContacto;
    private javax.swing.JTextField txtNombreContacto;
    private javax.swing.JTextField txtTelefonoContacto;
    // End of variables declaration//GEN-END:variables

    private void cargarCargos() {
        cmbCargos.removeAllItems();
        for (ContactoCargo cargo : ContactoCargo.values()) {
            cmbCargos.addItem(cargo.name());
        }
    }
    
    private void cargarContactos(Proveedor proveedor) {
        // Inicializa el modelo de la tabla y establece las columnas
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        String[] titulos = {"Nombre", "Cargo", "Telefono", "Correo"};
        modeloTabla.setColumnIdentifiers(titulos);
        modeloTabla.setRowCount(0);
        
        contactos = control.getControlContactoProveedor().leerPorProveedor(proveedor);

        // Itera sobre los detalles y los agrega a la tabla
        for (ContactoProveedor cont : contactos) {
            Object[] obj = {
                cargarNombre(cont),
                cont.getCargo(),
                cont.getTelefono(),
                cont.getCorreo()
            };
            modeloTabla.addRow(obj);
        }
        
        tblContactos.setModel(modeloTabla);

        // Centra el texto en todas las celdas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplica el render centrado a cada columna
        for (int i = 0; i < tblContactos.getColumnCount(); i++) {
            tblContactos.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        //formatear el tamaño de texto
        tblContactos.setRowHeight(35);
        JTableHeader header = tblContactos.getTableHeader();
        header.setFont(new java.awt.Font("PMingLiU-ExtB", Font.BOLD, 26));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
    }
    
    private String cargarNombre(ContactoProveedor contacto) {
        return contacto.getNombre() + " " + contacto.getApellido();
    }
    
    private void limpiar() {
        txtApellidoContacto.setText("");
        txtNombreContacto.setText("");
        txtTelefonoContacto.setText("");
        txtCorreoContacto.setText("");
        cargarCargos();
    }
    
    private void finalizarEdicion() {
        btnGuardarContacto.setText("Guardar");
        btnEditarContacto.setText("Editar");
        btnCopiarContacto.setEnabled(false);
        limpiar();
        contactoEnEdicion=null;
    }
}
