package Vista;

import Controlador.ControladoraGeneral;
import Extras.Cadenas;
import Extras.Mensajes;
import Modelo.DetallePedido;
import Modelo.EstadoPedido;
import Modelo.Lote;
import Modelo.Pedido;
import Modelo.Producto;
import com.toedter.calendar.JDateChooser;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
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
        cargarTablaPedidos(control.getControlPedido().leerTodo());
        this.pantalla=desktopPane;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLayeredPane9 = new javax.swing.JLayeredPane();
        btnVolver1 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
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

        jLabel1.setBackground(new java.awt.Color(137, 6, 6));
        jLabel1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 65)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(137, 6, 6));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Detalle Pedido");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo.png"))); // NOI18N

        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(43, 43, 43)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel2.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(271, 6, -1, 206));

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

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 241, 1290, 256));

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

        jPanel2.add(jLayeredPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 531, -1, -1));

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

        jPanel2.add(jLayeredPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(934, 531, -1, -1));

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
        jPanel2.add(btnGuardarCambios, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 620, 247, 54));

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
        jPanel2.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 625, 247, 54));

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
        jPanel2.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(599, 627, 247, -1));

        jLayeredPane10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo_Pedidos.png"))); // NOI18N

        jLayeredPane10.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane10Layout = new javax.swing.GroupLayout(jLayeredPane10);
        jLayeredPane10.setLayout(jLayeredPane10Layout);
        jLayeredPane10Layout.setHorizontalGroup(
            jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9))
        );
        jLayeredPane10Layout.setVerticalGroup(
            jLayeredPane10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(17, 17, 17))
        );

        jPanel2.add(jLayeredPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 36, -1, -1));

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
                    finalizarEdicion();
                    cargarTablaPedidos(control.getControlPedido().leerTodo());
                }
            } else {
                pedidoEnEdicion.setEstado(estadoPedido);
                pedidoEnEdicion.setFechaEstimadoLlegada(fechaLlegadaEstimada);
                control.getControlPedido().actualizar(pedidoEnEdicion);
                Mensajes.mostrarMensaje("Actualización exitosa", "informacion");
                finalizarEdicion();
                cargarTablaPedidos(control.getControlPedido().leerTodo());
            }
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
                    Extras.Mensajes.mostrarMensaje("Modifique los datos y presione 'Guardar Cambios'", "informacion");
                } else {
                    Extras.Mensajes.mostrarMensaje("Seleccione la fila a editar", "advertencia");
                }
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardarCambios;
    private javax.swing.JButton btnVolver1;
    private javax.swing.JComboBox<String> cmbEstado;
    private com.toedter.calendar.JDateChooser fechaLlegada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane10;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JLayeredPane jLayeredPane7;
    private javax.swing.JLayeredPane jLayeredPane9;
    private javax.swing.JPanel jPanel2;
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
}
