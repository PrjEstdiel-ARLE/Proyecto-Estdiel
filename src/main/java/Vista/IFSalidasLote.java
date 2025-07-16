package Vista;

import Controlador.ControladoraGeneral;
import DAO.DetalleSolicitudJpaController;
import DAO.SolicitudJpaController;
import Extras.ExportadorReporte;
import Extras.Mensajes;
import Modelo.DetalleSalida;
import Modelo.DetalleSolicitud;
import Modelo.EstadoLote;
import Modelo.Lote;
import Modelo.Producto;
import Modelo.Salida;
import Modelo.Solicitud;
import Modelo.Usuario;
import java.awt.Dimension;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class IFSalidasLote extends javax.swing.JInternalFrame {

    private SolicitudJpaController daoSoli;
    private DetalleSolicitudJpaController daoDetalle;
    private List<Solicitud> solicitudes = null;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
    private final ControladoraGeneral control;

    public IFSalidasLote() {
        initComponents();
        control = new ControladoraGeneral();
        formato.setTimeZone(TimeZone.getTimeZone("America/Lima"));
        this.daoSoli = new SolicitudJpaController();
        this.daoDetalle = new DetalleSolicitudJpaController();
        solicitudes = solicitudesFiltradas();
        cargarSolicitudes(solicitudes);
        cargarSalidasAprobadas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSolicitudes = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSalidas = new javax.swing.JTable();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnReporte1 = new javax.swing.JButton();
        btnConcederPermiso = new javax.swing.JButton();

        setTitle("Salidas");

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo_Salida_Lotes.png"))); // NOI18N

        tblSolicitudes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Usuario", "Fecha de Solicitud", "Estado", "Productos Asociados"
            }
        ));
        tblSolicitudes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(tblSolicitudes);

        tblSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Fecha de Aprobacion", "Estado", "Cantidad de Lotes", "Codigo"
            }
        ));
        tblSalidas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane3.setViewportView(tblSalidas);

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator7.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel4.setBackground(new java.awt.Color(239, 228, 210));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 2), "Filtro para solicitudes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 18), new java.awt.Color(137, 6, 6))); // NOI18N

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

        btnReporte.setBackground(new java.awt.Color(30, 58, 81));
        btnReporte.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(239, 228, 210));
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ico-Repor.png"))); // NOI18N
        btnReporte.setText("Generar Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        btnReporte1.setBackground(new java.awt.Color(30, 58, 81));
        btnReporte1.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        btnReporte1.setForeground(new java.awt.Color(239, 228, 210));
        btnReporte1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ico-Repor.png"))); // NOI18N
        btnReporte1.setText("Generar Reporte");
        btnReporte1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporte1ActionPerformed(evt);
            }
        });

        btnConcederPermiso.setBackground(new java.awt.Color(30, 58, 81));
        btnConcederPermiso.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        btnConcederPermiso.setForeground(new java.awt.Color(239, 228, 210));
        btnConcederPermiso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ico-Check.png"))); // NOI18N
        btnConcederPermiso.setText("Conceder Solicitud");
        btnConcederPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConcederPermisoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(120, 120, 120)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(btnReporte1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(249, 249, 249)
                                .addComponent(btnConcederPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16)))
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReporte1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConcederPermiso, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1215, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String termino = txtBuscar.getText();
        solicitudes = filtrarPorNombre(solicitudes, termino);
        if (solicitudes.isEmpty()) {
            Mensajes.mostrarMensaje("No se encontraron solicitudes de este usuario", "error");
            recargarTabla();
            return;
        }
        cargarSolicitudes(solicitudes);
        solicitudes = solicitudesFiltradas();
        txtBuscar.setText("");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        ExportadorReporte.generarReporte(tblSalidas, "salidas");
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnReporte1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporte1ActionPerformed
        ExportadorReporte.generarReporte(tblSolicitudes, "solicitudes");
    }//GEN-LAST:event_btnReporte1ActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            String termino = txtBuscar.getText();
            solicitudes = filtrarPorNombre(solicitudes, termino);
            if (solicitudes.isEmpty()) {
                Mensajes.mostrarMensaje("No se encontraron solicitudes de este usuario", "error");
                recargarTabla();
                return;
            }
            cargarSolicitudes(solicitudes);
            solicitudes = solicitudesFiltradas();
            txtBuscar.setText("");
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnConcederPermisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConcederPermisoActionPerformed
        int filaSeleccionada = tblSolicitudes.getSelectedRow();
        if (filaSeleccionada == -1) {
            Mensajes.mostrarMensaje("Selecciona una solicitud primero.", "error");
            return;
        }

        // Busca la solicitud original en la lista
        Solicitud solicitudSeleccionada = solicitudes.get(filaSeleccionada);

        // Construir resumen de productos
        StringBuilder resumen = new StringBuilder("¿Desea aceptar la solicitud de ")
                .append(cargarNombre(solicitudSeleccionada.getUsuario()))
                .append("?\n\nProductos solicitados:\n");

        for (DetalleSolicitud detalle : solicitudSeleccionada.getDetalles()) {
            resumen.append("• ")
                    .append(detalle.getProducto().getNombre())
                    .append(" - Cantidad: ")
                    .append(detalle.getCantidad())
                    .append("\n");
        }

        // Mostrar confirmación
        if (!Mensajes.confirmar(resumen.toString())) {
            return;
        }

        //validar disponiblidad (con dos lotes de margen)
        for (DetalleSolicitud det : solicitudSeleccionada.getDetalles()) {
            if (det.getCantidad() + 2 > det.getProducto().getCantidadLotes()) {
                Mensajes.mostrarMensaje("No hay lotes suficientes de " + det.getProducto().getNombre() + "\nCancele e informe al usuario " + cargarNombre(solicitudSeleccionada.getUsuario()), "advertencia");
                return;
            }
        }

        // Cambia el estado y genera el código
        solicitudSeleccionada.setEstadoSolicitud("Aprobado");
        String codigo = generarCodigoAleatorio(solicitudSeleccionada);
        solicitudSeleccionada.setCodigoSalida(codigo);

        // Asegura la relación bidireccional con los detalles
        for (DetalleSolicitud detalle : solicitudSeleccionada.getDetalles()) {
            detalle.setSolicitud(solicitudSeleccionada);
        }

        try {
            daoSoli.actualizarEstadoYCodigo(solicitudSeleccionada.getIdSolicitud(), "Aprobado", codigo);
        } catch (Exception e) {
            Mensajes.mostrarMensaje("Error al actualizar la solicitud en la base de datos: " + e.getMessage(), "error");
            return;
        }

        //reducir cantidad de lote
        for (DetalleSolicitud det : solicitudSeleccionada.getDetalles()) {
            Producto proDet = det.getProducto();
            int nuevaCantidad = proDet.getCantidadLotes() - det.getCantidad();
            control.getControlProducto().actualizarCantidad(proDet, nuevaCantidad);
        }

        //crear salida
        Salida salida = Salida.builder()
                .fechaSalida(new Date())
                .usuario(solicitudSeleccionada.getUsuario())
                .build();
        control.getControlSalida().crear(salida);

        //crear detalles
        for (DetalleSolicitud det : solicitudSeleccionada.getDetalles()) {
            Producto prodDet = det.getProducto();
            List<Lote> lotes = control.getControlLote().lotesFIFOporProducto(prodDet, det.getCantidad());
            for (Lote lote : lotes) {
                control.getControlLote().actualizarEstado(lote, EstadoLote.RETIRO_EXITOSO);
                // Crear detalle de salida
                DetalleSalida detSal = DetalleSalida.builder()
                        .salida(salida)
                        .lote(lote)
                        .fechaRetiro(new Date())
                        .build();
                control.getControlDetalleSalida().crear(detSal);
            }
        }

        // Muestra en la tabla de salidas (como antes)
        Object usuario = cargarNombre(solicitudSeleccionada.getUsuario());
        String fechaAprobacion = formato.format(new java.util.Date());
        String estado = "Aprobado";
        Object cantidadLotes = solicitudSeleccionada.getDetalles().size();

        DefaultTableModel modeloSalidas = (DefaultTableModel) tblSalidas.getModel();
        modeloSalidas.addRow(new Object[]{usuario, fechaAprobacion, estado, cantidadLotes, codigo});

        // NO ELIMINES la fila del modelo de solicitudes, solo recarga la tabla
        recargarTabla(); // Esto hará que ya no aparezca en la tabla izquierda si solo muestras pendientes  

    }//GEN-LAST:event_btnConcederPermisoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnConcederPermiso;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnReporte1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTable tblSalidas;
    private javax.swing.JTable tblSolicitudes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    private void cargarSolicitudes(List<Solicitud> solicitudes) {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] titulos = {"Usuario", "Fecha de Solictud", "Estado", "Productos Asociados"};
        modeloTabla.setColumnIdentifiers(titulos);
        modeloTabla.setRowCount(0);

        // Itera sobre los detalles y los agrega a la tabla
        for (Solicitud sol : solicitudes) {
            Object[] obj = {
                cargarNombre(sol.getUsuario()),
                formato.format(sol.getFechaSolicitud()),
                sol.getEstadoSolicitud(),
                sol.getDetalles().size()
            };
            modeloTabla.addRow(obj);
        }

        tblSolicitudes.setModel(modeloTabla);

        //tamaños
        tblSolicitudes.getColumnModel().getColumn(0).setPreferredWidth(180);
        tblSolicitudes.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblSolicitudes.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblSolicitudes.getColumnModel().getColumn(3).setPreferredWidth(250);

        // Centra el texto en todas las celdas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplica el render centrado a cada columna
        for (int i = 0; i < tblSolicitudes.getColumnCount(); i++) {
            tblSolicitudes.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        //formatear el tamaño de texto
        tblSolicitudes.setRowHeight(35);
        JTableHeader header = tblSolicitudes.getTableHeader();
        header.setFont(new java.awt.Font("PMingLiU-ExtB", Font.BOLD, 26));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
    }

    private Object cargarNombre(Usuario user) {
        return user.getNombres() + " " + user.getApellidos();
    }

    private List<Solicitud> solicitudesFiltradas() {
        return daoSoli.findSolicitudEntities()
                .stream()
                .filter(s -> "Pendiente".equals(s.getEstadoSolicitud()))
                .collect(Collectors.toList());
    }

    private void recargarTabla() {
        solicitudes = solicitudesFiltradas();
        cargarSolicitudes(solicitudes);
    }

    private List<Solicitud> filtrarPorNombre(List<Solicitud> solicitudes, String termino) {
        String filtro = termino.trim().toLowerCase();

        return solicitudes.stream()
                .filter(c -> (filtro.isEmpty() || (c.getUsuario().getNombres() + " " + c.getUsuario().getApellidos()).toLowerCase().contains(filtro)))
                .collect(Collectors.toList());
    }

    private String generarCodigoAleatorio(Solicitud solicitud) {
        int codigo = (int) (Math.random() * 900000) + 100000; // 6 dígitos
        return String.valueOf(codigo) + solicitud.getUsuario().getIdUsuario();
    }

    private void cargarSalidasAprobadas() {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] titulos = {"Usuario", "Fecha de Aprobacion", "Estado", "Productos Asociados", "Codigo"};
        modeloTabla.setColumnIdentifiers(titulos);
        modeloTabla.setRowCount(0);

        // Obtén todas las solicitudes aprobadas
        List<Solicitud> salidasAprobadas = daoSoli.findSolicitudEntities()
                .stream()
                .filter(s -> "Aprobado".equals(s.getEstadoSolicitud()))
                .collect(Collectors.toList());

        for (Solicitud sol : salidasAprobadas) {
            Object[] obj = {
                cargarNombre(sol.getUsuario()),
                formato.format(sol.getFechaSolicitud()),
                sol.getEstadoSolicitud(),
                sol.getDetalles().size(),
                sol.getCodigoSalida()
            };
            modeloTabla.addRow(obj);
        }

        tblSalidas.setModel(modeloTabla);
        // Ajusta tamaños y formato si lo deseas
        tblSalidas.getColumnModel().getColumn(0).setPreferredWidth(180);
        tblSalidas.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblSalidas.getColumnModel().getColumn(2).setPreferredWidth(150);
        tblSalidas.getColumnModel().getColumn(3).setPreferredWidth(250);
        tblSalidas.getColumnModel().getColumn(4).setPreferredWidth(150);

        // Centra el texto en todas las celdas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplica el render centrado a cada columna
        for (int i = 0; i < tblSalidas.getColumnCount(); i++) {
            tblSalidas.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        //formatear el tamaño de texto
        tblSalidas.setRowHeight(35);
        JTableHeader header = tblSalidas.getTableHeader();
        header.setFont(new java.awt.Font("PMingLiU-ExtB", Font.BOLD, 26));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
    }
}
