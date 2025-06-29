/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Vista;

import Controlador.ControladoraGeneral;
import Extras.Cadenas;
import Extras.Mensajes;
import Modelo.DetallePedido;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Proveedor;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class IFRegistrarPedido extends javax.swing.JInternalFrame {

    private final ControladoraGeneral control;
    private List<Proveedor> proveedores;
    private List<Producto> productos;
    private Pedido pedido;
    private List<DetallePedido> detalles;
    private DetallePedido detalleEnEdicion = null;
    private JDesktopPane pantalla;

    public IFRegistrarPedido(JDesktopPane desktopPane) {
        initComponents();
        control = new ControladoraGeneral();
        this.proveedores = control.getControlProveedor().leerTodo();
        pedido = new Pedido();
        pedido.setTotal(0);
        control.getControlPedido().crear(pedido);
        cargarProveedores();
        setFechaRegistro();
        cargarDetalles(pedido.getDetalles());
        this.pantalla=desktopPane;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLayeredPane8 = new javax.swing.JLayeredPane();
        jSeparator4 = new javax.swing.JSeparator();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalles = new javax.swing.JTable();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        cmbProveedor = new javax.swing.JComboBox<>();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        cmbProducto = new javax.swing.JComboBox<>();
        jLayeredPane4 = new javax.swing.JLayeredPane();
        jLabel4 = new javax.swing.JLabel();
        spnCantidad = new javax.swing.JSpinner();
        btnDescripcion = new javax.swing.JButton();
        jLayeredPane5 = new javax.swing.JLayeredPane();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        jLayeredPane6 = new javax.swing.JLayeredPane();
        jLabel6 = new javax.swing.JLabel();
        txtFechaRegistro = new javax.swing.JTextField();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        fechaLlegada = new com.toedter.calendar.JDateChooser();
        btnEliminar = new javax.swing.JButton();
        btnGuardarProducto = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnGuardarPedido = new javax.swing.JButton();
        jLayeredPane9 = new javax.swing.JLayeredPane();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnVolver = new javax.swing.JButton();

        setTitle("Registrar Pedido");

        jPanel1.setBackground(new java.awt.Color(239, 228, 210));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setBorder(new javax.swing.border.MatteBorder(null));

        jLayeredPane8.setLayer(jSeparator4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane8Layout = new javax.swing.GroupLayout(jLayeredPane8);
        jLayeredPane8.setLayout(jLayeredPane8Layout);
        jLayeredPane8Layout.setHorizontalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jLayeredPane8Layout.setVerticalGroup(
            jLayeredPane8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jLayeredPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 140, 160, 30));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setBorder(new javax.swing.border.MatteBorder(null));

        jLayeredPane1.setLayer(jSeparator3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(159, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 25, -1, 130));

        tblDetalles.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        tblDetalles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblDetalles.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblDetalles);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 1350, 242));

        jLabel2.setBackground(new java.awt.Color(137, 6, 6));
        jLabel2.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(137, 6, 6));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Proveedor:");

        cmbProveedor.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        cmbProveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProveedorActionPerformed(evt);
            }
        });

        jLayeredPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(cmbProveedor, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 510, -1));

        jLabel3.setBackground(new java.awt.Color(137, 6, 6));
        jLabel3.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(137, 6, 6));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Producto:");

        cmbProducto.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        cmbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductoActionPerformed(evt);
            }
        });

        jLayeredPane3.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane3.setLayer(cmbProducto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jLayeredPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 530, 510, -1));

        jLabel4.setBackground(new java.awt.Color(137, 6, 6));
        jLabel4.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(137, 6, 6));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad de Lotes:");

        spnCantidad.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        spnCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnCantidad.setToolTipText("");

        btnDescripcion.setBackground(new java.awt.Color(30, 58, 81));
        btnDescripcion.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N
        btnDescripcion.setForeground(new java.awt.Color(255, 255, 255));
        btnDescripcion.setText("Descripción");
        btnDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDescripcion.setPreferredSize(new java.awt.Dimension(140, 50));
        btnDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescripcionActionPerformed(evt);
            }
        });

        jLayeredPane4.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(spnCantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane4.setLayer(btnDescripcion, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(spnCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jLayeredPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, -1, -1));

        jLabel5.setBackground(new java.awt.Color(137, 6, 6));
        jLabel5.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(137, 6, 6));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Precio de compra:");

        txtPrecioCompra.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        txtPrecioCompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLayeredPane5.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane5.setLayer(txtPrecioCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane5Layout = new javax.swing.GroupLayout(jLayeredPane5);
        jLayeredPane5.setLayout(jLayeredPane5Layout);
        jLayeredPane5Layout.setHorizontalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jLayeredPane5Layout.setVerticalGroup(
            jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jLayeredPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 450, -1, -1));

        jLabel6.setBackground(new java.awt.Color(137, 6, 6));
        jLabel6.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(137, 6, 6));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Fecha Registro:");

        txtFechaRegistro.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        txtFechaRegistro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtFechaRegistro.setDisabledTextColor(new java.awt.Color(69, 73, 74));
        txtFechaRegistro.setEnabled(false);

        jLayeredPane6.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane6.setLayer(txtFechaRegistro, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane6Layout = new javax.swing.GroupLayout(jLayeredPane6);
        jLayeredPane6.setLayout(jLayeredPane6Layout);
        jLayeredPane6Layout.setHorizontalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jLayeredPane6Layout.setVerticalGroup(
            jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jLayeredPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 530, -1, -1));

        jLabel7.setBackground(new java.awt.Color(137, 6, 6));
        jLabel7.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(137, 6, 6));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Fecha Llegada:");

        fechaLlegada.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N

        jLayeredPane7.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane7.setLayer(fechaLlegada, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane7Layout = new javax.swing.GroupLayout(jLayeredPane7);
        jLayeredPane7.setLayout(jLayeredPane7Layout);
        jLayeredPane7Layout.setHorizontalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jLayeredPane7Layout.setVerticalGroup(
            jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jLayeredPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 600, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(30, 58, 81));
        btnEliminar.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar Producto");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.setPreferredSize(new java.awt.Dimension(140, 50));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 600, 247, 54));

        btnGuardarProducto.setBackground(new java.awt.Color(30, 58, 81));
        btnGuardarProducto.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        btnGuardarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarProducto.setText("Agregar Producto");
        btnGuardarProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGuardarProductoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGuardarProductoMouseExited(evt);
            }
        });
        btnGuardarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarProductoActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 450, 247, 54));

        btnEditar.setBackground(new java.awt.Color(30, 58, 81));
        btnEditar.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.setPreferredSize(new java.awt.Dimension(140, 50));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 530, 247, -1));

        btnGuardarPedido.setBackground(new java.awt.Color(30, 58, 81));
        btnGuardarPedido.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        btnGuardarPedido.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarPedido.setText("Registrar");
        btnGuardarPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarPedido.setPreferredSize(new java.awt.Dimension(140, 50));
        btnGuardarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPedidoActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuardarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 490, 151, 105));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo_Detalle.png"))); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(new javax.swing.border.MatteBorder(null));

        jLayeredPane9.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane9.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane9Layout = new javax.swing.GroupLayout(jLayeredPane9);
        jLayeredPane9.setLayout(jLayeredPane9Layout);
        jLayeredPane9Layout.setHorizontalGroup(
            jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9))
            .addGroup(jLayeredPane9Layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        jLayeredPane9Layout.setVerticalGroup(
            jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jLayeredPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 25, -1, -1));

        btnVolver.setBackground(new java.awt.Color(239, 228, 210));
        btnVolver.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1561, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        detalles = control.getControlDetallePedido().leerPorPedido(pedido);
        if (detalles.isEmpty()) {
            boolean conf = Extras.Mensajes.confirmar("¿Desea cancelar el registro del pedido?");
            if (conf) {
                control.getControlPedido().eliminar(pedido.getIdPedido());
                this.dispose();
            }
        } else {
            boolean conf = Extras.Mensajes.confirmar("Tiene productos asociados al pedido, ¿Desea cancelar el registro?");
            if (conf) {
                control.getControlPedido().eliminar(pedido.getIdPedido());
                for (DetallePedido detalle : detalles) {
                    control.getControlDetallePedido().eliminar(detalle.getIdDetallePedido());
                }
                this.dispose();
            } else {
                Extras.Mensajes.mostrarMensaje("Valide y registre el pedido completo", "advertencia");
            }
        }
    }//GEN-LAST:event_btnVolverActionPerformed

    private void cmbProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProveedorActionPerformed
        if (cmbProveedor.getSelectedIndex() > -1) {
            String proveedor = (String) cmbProveedor.getSelectedItem();
            Proveedor proveedorSlct = control.getControlProveedor().leerPorNombre(proveedor);
            cargarProductos(proveedorSlct);
        }
    }//GEN-LAST:event_cmbProveedorActionPerformed

    private void cmbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductoActionPerformed
        if (cmbProducto.getSelectedIndex() > -1) {
            String producto = (String) cmbProducto.getSelectedItem();
            Producto prodSlct = control.getControlProducto().leerPorNombre(producto);
            txtPrecioCompra.setText(Cadenas.formatoSoles(prodSlct.getPrecioCompra(), true));
        }
    }//GEN-LAST:event_cmbProductoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tblDetalles.getRowCount() > 0) {
            int filaSelect = tblDetalles.getSelectedRow();
            //Asegurar selección
            if (filaSelect != -1) {
                detalles = control.getControlDetallePedido().leerPorPedido(pedido);
                DetallePedido detalleSelect = detalles.get(filaSelect);
                boolean conf = Extras.Mensajes.confirmar("¿Desea eliminar este elemento?");
                if (conf) {
                    double subtotal = detalleSelect.getSubtotal();
                    double total = pedido.getTotal();
                    double nTotal = total - subtotal;
                    pedido.setTotal(nTotal);
                    control.getControlPedido().actualizar(pedido);
                    control.getControlDetallePedido().eliminar(detalleSelect.getIdDetallePedido());
                    detalles.remove(filaSelect);
                    Pedido pedidoActualizado = control.getControlPedido().leer(pedido.getIdPedido());
                    cargarDetalles(pedidoActualizado.getDetalles());
                }
            } else {
                Extras.Mensajes.mostrarMensaje("Seleccione la fila a eliminar", "advertencia");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarProductoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarProductoMouseEntered
        btnGuardarProducto.setBackground(new java.awt.Color(55, 83, 106));
    }//GEN-LAST:event_btnGuardarProductoMouseEntered

    private void btnGuardarProductoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuardarProductoMouseExited
        btnGuardarProducto.setBackground(new java.awt.Color(30, 58, 81));
    }//GEN-LAST:event_btnGuardarProductoMouseExited

    private void btnGuardarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarProductoActionPerformed
        if (detalleEnEdicion != null) {
            // Leer nuevos datos del formulario
            Object valor = spnCantidad.getValue();
            int nuevaCantidad = (int) valor;
            String precioFormato = txtPrecioCompra.getText();
            double nuevoPrecio = Extras.Cadenas.obtenerPrecioLimpio(precioFormato);
            double nuevoSubtotal = nuevoPrecio * nuevaCantidad;

            // Calcular diferencia en el total del pedido
            double subtotalAnterior = detalleEnEdicion.getSubtotal();
            double diferencia = nuevoSubtotal - subtotalAnterior;

            // Actualizar el detalle
            detalleEnEdicion.setCantidad(nuevaCantidad);
            detalleEnEdicion.setSubtotal(nuevoSubtotal);

            // Actualizar el total del pedido
            double totalActual = pedido.getTotal();
            pedido.setTotal(totalActual + diferencia);

            // Guardar en base de datos
            control.getControlDetallePedido().actualizar(detalleEnEdicion);
            control.getControlPedido().actualizar(pedido);

            // Limpiar modo edición
            finalizarEdicion();

            // Recargar tabla
            Pedido pedidoActualizado = control.getControlPedido().leer(pedido.getIdPedido());
            cargarDetalles(pedidoActualizado.getDetalles());
        } else {
            //leer datos
            Object valor = spnCantidad.getValue();
            int cantidad = (int) valor;
            String proveedor = (String) cmbProveedor.getSelectedItem();
            Proveedor provPedido = control.getControlProveedor().leerPorNombre(proveedor);
            String producto = (String) cmbProducto.getSelectedItem();
            Producto prodPedido = control.getControlProducto().leerPorNombre(producto);
            String precioFormato = txtPrecioCompra.getText();
            double precioCompra = Extras.Cadenas.obtenerPrecioLimpio(precioFormato);
            double subtotal = precioCompra * cantidad;
            Date fechaRegistro = new Date();
            Date fechaLlegadaEstimada = fechaLlegada.getDate();

            //validar fecha
            if (fechaLlegadaEstimada == null) {
                Extras.Mensajes.mostrarMensaje("Debe ingresar una fecha de llegada estiamda", "error");
                return;
            }

            // Validar que el producto no esté en el pedido
            detalles = control.getControlDetallePedido().leerPorPedido(pedido);

            // Versión mejorada (sin necesidad de lista separada)
            for (DetallePedido detalleRev : detalles) {
                if (detalleRev.getProducto().getIdProducto() == prodPedido.getIdProducto()) {
                    Extras.Mensajes.mostrarMensaje("Este producto ya está en el pedido.\nSi necesita cambios edítelo.", "error");
                    return;
                }
            }

            //actualizar pedido PRIMERO
            pedido.setFechaRegistro(fechaRegistro);
            pedido.setFechaEstimadoLlegada(fechaLlegadaEstimada);
            pedido.setProveedor(provPedido);

            //ACTUALIZAR total
            double totalAct = pedido.getTotal();
            double nuevoTotal = totalAct + subtotal;
            pedido.setTotal(nuevoTotal);

            // ACTUALIZAR el pedido ANTES de crear
            control.getControlPedido().actualizar(pedido);

            //crear detalle pedido
            DetallePedido detalle = new DetallePedido();
            detalle.setCantidad(cantidad);
            detalle.setProducto(prodPedido);
            detalle.setSubtotal(subtotal);
            detalle.setPedido(pedido);

            List<DetallePedido> detallesActuales = pedido.getDetalles();
            detallesActuales.add(detalle);

            //guardar detalle
            control.getControlDetallePedido().crear(detalle);
            cargarDetalles(pedido.getDetalles());

            cmbProveedor.setEnabled(false);
            spnCantidad.setValue(1);
        }
    }//GEN-LAST:event_btnGuardarProductoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (detalleEnEdicion != null) {
            finalizarEdicion();
            Extras.Mensajes.mostrarMensaje("Edición Cancelada", "informacion");
        } else {
            if (tblDetalles.getRowCount() > 0) {
                int filaSelect = tblDetalles.getSelectedRow();
                if (filaSelect != -1) {
                    // Marcar que estamos en modo edición
                    detalles = control.getControlDetallePedido().leerPorPedido(pedido);
                    detalleEnEdicion = detalles.get(filaSelect);
                    cmbProducto.setEnabled(false);
                    //cargar datos
                    double precio = detalleEnEdicion.getSubtotal() / detalleEnEdicion.getCantidad();
                    txtPrecioCompra.setText(Extras.Cadenas.formatoSoles(precio, true));
                    spnCantidad.setValue(detalleEnEdicion.getCantidad());
                    // Cambiar el texto del botón para indicar que estamos editando
                    btnGuardarProducto.setText("Actualizar Producto");
                    btnEditar.setText("Cancelar Edición");
                    Extras.Mensajes.mostrarMensaje("Modifique los datos y presione 'Actualizar Producto'", "informacion");
                } else {
                    Extras.Mensajes.mostrarMensaje("Seleccione la fila a editar", "advertencia");
                }
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPedidoActionPerformed
        detalles = control.getControlDetallePedido().leerPorPedido(pedido);
        if (!detalles.isEmpty()) {
            boolean conf = Extras.Mensajes.confirmar("¿Desea registrar el pedido\n con todos los productos asociados?");
            if (conf) {
                Extras.Mensajes.mostrarMensaje("Pedido guardado exitosamente", "informacion");
                IFPedidos igu = new IFPedidos(pantalla);
                pantalla.add(igu);
                igu.setVisible(true);
                this.dispose();
            }
        } else {
            Extras.Mensajes.mostrarMensaje("Se requiere mínimo un producto asociado.\nAgregue un producto.", "advertencia");
        }
    }//GEN-LAST:event_btnGuardarPedidoActionPerformed

    private void btnDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescripcionActionPerformed
         String producto = (String) cmbProducto.getSelectedItem();
         Producto prodLote=control.getControlProducto().leerPorNombre(producto);
         StringBuilder mensaje=new StringBuilder();
         mensaje.append("EL LOTE DE '").append(producto).append("' CONTIENE:\n");
         mensaje.append("- ").append(prodLote.getPresentacionLote()).append(" con ").append(prodLote.getCantidadPresentacionLote()).append(" Unidades.");
         Mensajes.mostrarMensaje(mensaje.toString(), "informacion");
    }//GEN-LAST:event_btnDescripcionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDescripcion;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarPedido;
    private javax.swing.JButton btnGuardarProducto;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox<String> cmbProducto;
    private javax.swing.JComboBox<String> cmbProveedor;
    private com.toedter.calendar.JDateChooser fechaLlegada;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JLayeredPane jLayeredPane4;
    private javax.swing.JLayeredPane jLayeredPane5;
    private javax.swing.JLayeredPane jLayeredPane6;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane8;
    private javax.swing.JLayeredPane jLayeredPane9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSpinner spnCantidad;
    private javax.swing.JTable tblDetalles;
    private javax.swing.JTextField txtFechaRegistro;
    private javax.swing.JTextField txtPrecioCompra;
    // End of variables declaration//GEN-END:variables

    private void cargarProveedores() {
        cmbProveedor.removeAllItems();
        for (Proveedor proveedor : proveedores) {
            cmbProveedor.addItem(proveedor.getNombre());
        }
    }

    private void cargarProductos(Proveedor proveedorSlct) {
        cmbProducto.removeAllItems();
        productos = proveedorSlct.getProductos();
        for (Producto producto : productos) {
            cmbProducto.addItem(producto.getNombre());
        }
    }

    private void setFechaRegistro() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fechaHoy = LocalDate.now().format(formatter);
        txtFechaRegistro.setText(fechaHoy);
    }

    private void finalizarEdicion() {
        detalleEnEdicion = null;
        btnGuardarProducto.setText("Agregar Producto");
        btnEditar.setText("Editar");
        cmbProducto.setEnabled(true);
        // Limpiar campos
        spnCantidad.setValue(1);
        String producto = (String) cmbProducto.getSelectedItem();
        Producto prodSlct = control.getControlProducto().leerPorNombre(producto);
        txtPrecioCompra.setText(Cadenas.formatoSoles(prodSlct.getPrecioCompra(), true));
    }

    private void cargarDetalles(List<DetallePedido> detalles) {
// Inicializa el modelo de la tabla y establece las columnas
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] titulos = {"Producto", "Cantidad", "Subtotal"};
        modeloTabla.setColumnIdentifiers(titulos);
        modeloTabla.setRowCount(0);

        // Itera sobre los detalles y los agrega a la tabla
        for (DetallePedido detalle : detalles) {
            Object[] obj = {
                detalle.getProducto().getNombre(),
                detalle.getCantidad(),
                Extras.Cadenas.formatoSoles(detalle.getSubtotal(), true)
            };
            modeloTabla.addRow(obj);
        }

        tblDetalles.setModel(modeloTabla);

        // Centra el texto en todas las celdas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplica el render centrado a cada columna
        for (int i = 0; i < tblDetalles.getColumnCount(); i++) {
            tblDetalles.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        cmbProducto.setEnabled(true);
        //formatear el tamaño de texto
        tblDetalles.setRowHeight(35);
        JTableHeader header = tblDetalles.getTableHeader();
        header.setFont(new java.awt.Font("PMingLiU-ExtB", Font.BOLD, 26));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
    }
}
