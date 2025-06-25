package Vista;

import Controlador.ControladoraGeneral;
import Extras.Cadenas;
import Extras.Mensajes;
import Modelo.DetallePedido;
import Modelo.EstadoPedido;
import Modelo.Lote;
import Modelo.Pedido;
import Modelo.Producto;
import Modelo.Proveedor;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.stream.Collectors;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class IFPedidos extends javax.swing.JInternalFrame {

    private final ControladoraGeneral control;
    private List<Pedido> pedidos;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat formatoControl = new SimpleDateFormat("d MMM. yyyy", new Locale("es", "ES"));
    private Pedido pedidoEnEdicion = null;
    Calendar cal;
    private final JDesktopPane pantalla;

    public IFPedidos(JDesktopPane desktopPane) {
        initComponents();
        formato.setTimeZone(TimeZone.getTimeZone("UTC"));
        formatoControl.setTimeZone(TimeZone.getTimeZone("UTC"));
        control = new ControladoraGeneral();
        cargarEstados();
        this.pedidos = control.getControlPedido().leerTodo();
        cargarTablaPedidos(pedidos);
        this.pantalla = desktopPane;
        cargarFiltros();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLayeredPane9 = new javax.swing.JLayeredPane();
        btnVolver1 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnFiltrar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        fechaHasta = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        cmbProveedores = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        cmbEstadosFiltro = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jLabel2 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        jLayeredPane7 = new javax.swing.JLayeredPane();
        jLabel7 = new javax.swing.JLabel();
        fechaLlegada = new com.toedter.calendar.JDateChooser();
        btnGuardarCambios = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLayeredPane10 = new javax.swing.JLayeredPane();
        jLabel9 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(239, 228, 210));
        jPanel2.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLayeredPane9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        btnVolver1.setBackground(new java.awt.Color(239, 228, 210));
        btnVolver1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        btnVolver1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnVolver1.setBorderPainted(false);
        btnVolver1.setContentAreaFilled(false);
        btnVolver1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver1ActionPerformed(evt);
            }
        });

        jLayeredPane9.setLayer(btnVolver1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane9Layout = new javax.swing.GroupLayout(jLayeredPane9);
        jLayeredPane9.setLayout(jLayeredPane9Layout);
        jLayeredPane9Layout.setHorizontalGroup(
            jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane9Layout.createSequentialGroup()
                .addComponent(btnVolver1)
                .addGap(0, 2, Short.MAX_VALUE))
        );
        jLayeredPane9Layout.setVerticalGroup(
            jLayeredPane9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane9Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(btnVolver1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.add(jLayeredPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1175, 35, -1, -1));

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(239, 228, 210));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 2), "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 18), new java.awt.Color(137, 6, 6))); // NOI18N

        btnFiltrar.setBackground(new java.awt.Color(30, 58, 81));
        btnFiltrar.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltrar.setText("Filtrar");
        btnFiltrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiltrar.setPreferredSize(new java.awt.Dimension(140, 50));
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(239, 228, 210));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 2), "Fecha Estimada de Llegada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 18), new java.awt.Color(137, 6, 6))); // NOI18N

        fechaDesde.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 14)); // NOI18N

        fechaHasta.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 14)); // NOI18N

        jLabel10.setBackground(new java.awt.Color(137, 6, 6));
        jLabel10.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(137, 6, 6));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Hasta:");

        jLabel11.setBackground(new java.awt.Color(137, 6, 6));
        jLabel11.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(137, 6, 6));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Desde:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(239, 228, 210));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 2), "Proveedores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 18), new java.awt.Color(137, 6, 6))); // NOI18N

        cmbProveedores.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cmbProveedores.setForeground(new java.awt.Color(0, 0, 0));
        cmbProveedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbProveedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(239, 228, 210));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 2), "Estados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 18), new java.awt.Color(137, 6, 6))); // NOI18N

        cmbEstadosFiltro.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        cmbEstadosFiltro.setForeground(new java.awt.Color(0, 0, 0));
        cmbEstadosFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbEstadosFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbEstadosFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8))
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 34, Short.MAX_VALUE))
        );

        jPanel2.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 26, 910, 260));

        tblPedidos.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPedidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblPedidos);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 1290, 256));

        jLabel2.setBackground(new java.awt.Color(137, 6, 6));
        jLabel2.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(137, 6, 6));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Estado:");

        cmbEstado.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbEstado.setEnabled(false);

        jLayeredPane2.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(cmbEstado, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 560, -1, -1));

        jLabel7.setBackground(new java.awt.Color(137, 6, 6));
        jLabel7.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(137, 6, 6));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Fecha Llegada:");

        fechaLlegada.setEnabled(false);
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

        jPanel2.add(jLayeredPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 560, -1, -1));

        btnGuardarCambios.setBackground(new java.awt.Color(30, 58, 81));
        btnGuardarCambios.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        btnGuardarCambios.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarCambios.setText("Guardar Cambios");
        btnGuardarCambios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardarCambios.setEnabled(false);
        btnGuardarCambios.setPreferredSize(new java.awt.Dimension(140, 50));
        btnGuardarCambios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarCambiosActionPerformed(evt);
            }
        });
        jPanel2.add(btnGuardarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 630, 247, 54));

        btnEliminar.setBackground(new java.awt.Color(30, 58, 81));
        btnEliminar.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setText("Eliminar");
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEliminarMouseExited(evt);
            }
        });
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 640, 247, 54));

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
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 640, 247, -1));

        jLayeredPane10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo_Pedidos.png"))); // NOI18N

        jLayeredPane10.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane10Layout = new javax.swing.GroupLayout(jLayeredPane10);
        jLayeredPane10.setLayout(jLayeredPane10Layout);
        jLayeredPane10Layout.setHorizontalGroup(
            jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane10Layout.setVerticalGroup(
            jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel2.add(jLayeredPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 36, -1, 180));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1388, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolver1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVolver1ActionPerformed

    private void btnGuardarCambiosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarCambiosActionPerformed
        boolean conf = Mensajes.confirmar("¿Desea guardar los cambios?");
        if (conf) {
            //leer datos
            Date fechaLlegadaEstimada = fechaLlegada.getDate();
            EstadoPedido estadoPedido = EstadoPedido.valueOf((String) cmbEstado.getSelectedItem());
            //validar fecha
            if (fechaLlegadaEstimada == null) {
                Extras.Mensajes.mostrarMensaje("Debe ingresar una fecha de llegada estimada", "error");
                return;
            }
            //actualizar
            if (estadoPedido == EstadoPedido.RECIBIDO) {
                boolean conf2 = Mensajes.confirmar("¿Recibió el pedido?\nRecuerde que se generarán lotes para este pedido\nLa fecha de ingreso de los lotes será hoy.");
                if (conf2) {
                    Date hoy = new Date();
                    cal = Calendar.getInstance();

                    // Preparamos todos los lotes a crear
                    List<Lote> lotes = new ArrayList<>();

                    for (DetallePedido detalle : pedidoEnEdicion.getDetalles()) {
                        Producto prodAsoc = detalle.getProducto();
                        int tiempoAlmacen = prodAsoc.getCategoria().getTiempo_estimado_almacen();
                        int cantidad = detalle.getCantidad();
                        //editar cantidad en producto
                        control.getControlProducto().actualizarCantidad(prodAsoc, cantidad + prodAsoc.getCantidadLotes());
                        // calcalar fecha
                        cal.setTime(hoy);
                        cal.add(Calendar.DAY_OF_YEAR, tiempoAlmacen);
                        Date fechaVencimiento = cal.getTime();

                        // Creamos todos los lotes necesarios
                        for (int i = 0; i < cantidad; i++) {
                            Lote nuevoLote = Lote.builder()
                                    .fechaIngreso(hoy)
                                    .producto(prodAsoc)
                                    .fechaVencimiento(fechaVencimiento)
                                    .detalleOrigen(detalle)
                                    .codigo(generarCodigoLote(detalle, i + 1))
                                    .build();
                            control.getControlLote().crear(nuevoLote);
                            lotes.add(nuevoLote);
                        }
                        detalle.setLotesGenerados(lotes);
                        control.getControlDetallePedido().actualizar(detalle);
                    }
                    pedidoEnEdicion.setEstado(estadoPedido);
                    pedidoEnEdicion.setFechaEstimadoLlegada(new Date());
                    control.getControlPedido().actualizar(pedidoEnEdicion);
                    Mensajes.mostrarMensaje("Actualización exitosa\nLotes generados exitosamente", "informacion");
                    cargarTablaPedidos(control.getControlPedido().leerTodo());
                }
            } else {
                pedidoEnEdicion.setEstado(estadoPedido);
                pedidoEnEdicion.setFechaEstimadoLlegada(fechaLlegadaEstimada);
                control.getControlPedido().actualizar(pedidoEnEdicion);
                Mensajes.mostrarMensaje("Actualización exitosa", "informacion");
                cargarTablaPedidos(control.getControlPedido().leerTodo());
            }
            finalizarEdicion();
            enEdicion(false);
        }
    }//GEN-LAST:event_btnGuardarCambiosActionPerformed

    private void btnEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseEntered
        btnEliminar.setBackground(new java.awt.Color(55, 83, 106));
    }//GEN-LAST:event_btnEliminarMouseEntered

    private void btnEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseExited
        btnEliminar.setBackground(new java.awt.Color(30, 58, 81));
    }//GEN-LAST:event_btnEliminarMouseExited

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (pedidoEnEdicion != null) {
            finalizarEdicion();
            enEdicion(false);
            Extras.Mensajes.mostrarMensaje("Edición Cancelada", "informacion");
        } else {
            if (tblPedidos.getRowCount() > 0) {
                int filaSelect = tblPedidos.getSelectedRow();
                if (filaSelect != -1) {
                    // Marcar que estamos en modo edición
                    pedidos = control.getControlPedido().leerTodo();
                    pedidoEnEdicion = pedidos.get(filaSelect);
                    //Validar que no sea un pedido recibido
                    if (pedidoEnEdicion.getEstado() == EstadoPedido.RECIBIDO) {
                        Mensajes.mostrarMensaje("No se puede editar un pedido recibido", "error");
                        return;
                    }
                    cmbEstado.setEnabled(true);
                    fechaLlegada.setEnabled(true);
                    //cargar datos
                    Date fechaLlegadaBD = pedidoEnEdicion.getFechaEstimadoLlegada();
                    cargarFechaEnDateChooser(fechaLlegada, fechaLlegadaBD);
                    cmbEstado.setSelectedItem(pedidoEnEdicion.getEstado().name());
                    // Cambiar el texto del botón para indicar que estamos editando
                    btnGuardarCambios.setEnabled(true);
                    btnEditar.setText("Cancelar Edición");
                    enEdicion(true);
                    Extras.Mensajes.mostrarMensaje("Modifique los datos y presione 'Guardar Cambios'", "informacion");
                } else {
                    Extras.Mensajes.mostrarMensaje("Seleccione la fila a editar", "advertencia");
                }
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        //leer datos
        Date desde = fechaDesde.getDate();
        Date hasta = fechaHasta.getDate();
        String estadoFiltro = cmbEstadosFiltro.getSelectedItem().toString();
        String proveedorNombre = cmbProveedores.getSelectedItem().toString();
        EstadoPedido estado = estadoFiltro.equals("Todos") ? null : EstadoPedido.valueOf(estadoFiltro);
        Proveedor proveedor = proveedorNombre.equals("Cualquiera") ? null
                : control.getControlProveedor().leerPorNombre(proveedorNombre);

        //validar
        if (!validarFechas(desde, hasta)) {
            Extras.Mensajes.mostrarMensaje("La fecha 'Hasta' debe ser posterior a 'Desde'", "error");
            limpiarFiltros();
            return;
        }

        //Filtrar la lista en memoria
        List<Pedido> pedidosFiltrados = this.pedidos.stream()
                .filter(p -> estado == null || p.getEstado().equals(estado))
                .filter(p -> proveedor == null || p.getProveedor().getIdProveedor() == proveedor.getIdProveedor())
                .filter(p -> {
                    if (desde == null) {
                        return true;
                    }
                    if (p.getFechaEstimadoLlegada() == null) {
                        return false;
                    }
                    Instant instantePedido = p.getFechaEstimadoLlegada().toInstant();
                    Instant instanteDesde = desde.toInstant();
                    return !instantePedido.isBefore(instanteDesde);
                })
                .filter(p -> {
                    if (hasta == null) {
                        return true;
                    }
                    if (p.getFechaEstimadoLlegada() == null) {
                        return false;
                    }
                    Instant instantePedido = p.getFechaEstimadoLlegada().toInstant();
                    Instant instanteHasta = hasta.toInstant();
                    return !instantePedido.isAfter(instanteHasta);
                })
                .collect(Collectors.toList());

        //Actualizar tabla
        if (pedidosFiltrados.isEmpty()) {
            Mensajes.mostrarMensaje("No existen pedidos con estos parámetros", "error");
            limpiarFiltros();
            return;
        }
        cargarTablaPedidos(pedidosFiltrados);
        System.out.println("Filtros: desde=" + desde + ", hasta=" + hasta
                + ", estado=" + estado + ", proveedorId=" + (proveedor != null ? proveedor.getIdProveedor() : "null"));
    }//GEN-LAST:event_btnFiltrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnVolver1;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbEstadosFiltro;
    private javax.swing.JComboBox<String> cmbProveedores;
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private com.toedter.calendar.JDateChooser fechaLlegada;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane10;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPedidos;
    // End of variables declaration//GEN-END:variables

    private void cargarTablaPedidos(List<Pedido> listaPedidos) {
// Inicializa el modelo de la tabla y establece las columnas
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] titulos = {"Proveedor", "Fecha Registro", "Fecha Estimada Llegada", "Total", "Estado"};
        modeloTabla.setColumnIdentifiers(titulos);
        modeloTabla.setRowCount(0);

        // Itera sobre los detalles y los agrega a la tabla
        for (Pedido pedido : listaPedidos) {
            Object[] obj = {
                pedido.getProveedor().getNombre(),
                formato.format(pedido.getFechaRegistro()),
                formato.format(pedido.getFechaEstimadoLlegada()),
                Cadenas.formatoSoles(pedido.getTotal(), true),
                pedido.getEstado()

            };
            modeloTabla.addRow(obj);
        }

        tblPedidos.setModel(modeloTabla);

        // Centra el texto en todas las celdas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplica el render centrado a cada columna
        for (int i = 0; i < tblPedidos.getColumnCount(); i++) {
            tblPedidos.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        //formatear el tamaño de texto
        tblPedidos.setRowHeight(35);
        JTableHeader header = tblPedidos.getTableHeader();
        header.setFont(new java.awt.Font("PMingLiU-ExtB", Font.BOLD, 26));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
    }

    private void cargarEstados() {
        cmbEstado.removeAllItems();

        for (EstadoPedido estado : EstadoPedido.values()) {
            cmbEstado.addItem(estado.name());
        }
    }

    private void finalizarEdicion() {
        pedidoEnEdicion = null;
        btnGuardarCambios.setEnabled(false);
        btnEditar.setText("Editar");
        fechaLlegada.setDate(null);
        fechaLlegada.setEnabled(false);
        cmbEstado.setEnabled(false);
        cargarEstados();
        limpiarFiltros();
    }

    private void cargarFechaEnDateChooser(JDateChooser dateChooser, Date fecha) {
        if (fecha != null) {
            // 1. Convertir Date a LocalDate con la zona horaria correcta
            LocalDate localDate = fecha.toInstant()
                    .atZone(ZoneId.of("UTC"))
                    .toLocalDate();

            // 2. Convertir LocalDate a Date sin problemas de zona horaria
            Date fechaAjustada = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

            // 3. Asignar al DateChooser
            dateChooser.setDate(fechaAjustada);
        } else {
            dateChooser.setDate(null);
        }
    }

    private String generarCodigoLote(DetallePedido detalle, int numeroLote) {
        // Formato: PEDIDO_ID-PRODUCTO_ID-FECHA-NUMEROLOTE
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String fechaCodigo = sdf.format(new Date());

        return String.format("%s-%s-%s-%03d",
                detalle.getPedido().getIdPedido(),
                detalle.getProducto().getIdProducto(),
                fechaCodigo,
                numeroLote);
    }

    private void cargarFiltros() {
        cargarEstadosFiltro();
        cargarProveedores();
    }

    private void cargarEstadosFiltro() {
        cmbEstadosFiltro.removeAllItems();
        cmbEstadosFiltro.addItem("Todos");
        for (EstadoPedido estado : EstadoPedido.values()) {
            cmbEstadosFiltro.addItem(estado.name());
        }
    }

    private void cargarProveedores() {
        cmbProveedores.removeAllItems();
        cmbProveedores.addItem("Cualquiera");
        for (Proveedor provCmb : control.getControlProveedor().leerTodo()) {
            cmbProveedores.addItem(provCmb.getNombre());
        }
    }

    private void limpiarFiltros() {
        fechaDesde.setDate(null);
        fechaHasta.setDate(null);
        cmbEstadosFiltro.setSelectedItem("Todos");
        cmbProveedores.setSelectedItem("Cualquiera");
        cargarTablaPedidos(this.pedidos);
    }

    private boolean validarFechas(Date desde, Date hasta) {
        return !(desde != null && hasta != null && hasta.before(desde));
    }

    private void enEdicion(boolean b) {
        btnFiltrar.setEnabled(!b);
        fechaDesde.setEnabled(!b);
        fechaHasta.setEnabled(!b);
        cmbProveedores.setEnabled(!b);
        cmbEstadosFiltro.setEnabled(!b);
    }
}
