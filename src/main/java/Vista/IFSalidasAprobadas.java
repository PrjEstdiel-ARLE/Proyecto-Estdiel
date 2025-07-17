package Vista;

import DAO.DetalleSolicitudJpaController;
import DAO.SolicitudJpaController;
import Extras.ExportadorReporte;
import Extras.Mensajes;
import Modelo.DetalleSolicitud;
import Modelo.Producto;
import Modelo.Solicitud;
import Modelo.Usuario;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class IFSalidasAprobadas extends javax.swing.JInternalFrame {

    private Usuario userAct;
    private SolicitudJpaController daoSoli;
    private DetalleSolicitudJpaController daoDetalle;
    private List<Solicitud> solicitudes = null;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy hh:mm a");

    public IFSalidasAprobadas(Usuario usuario) {
        initComponents();
        formato.setTimeZone(TimeZone.getTimeZone("America/Lima"));
        this.userAct = usuario;
        this.daoSoli = new SolicitudJpaController();
        this.daoDetalle = new DetalleSolicitudJpaController();
        solicitudes = solicitudesAprobadas(usuario);
        cargarTabla(solicitudes);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSalidas = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        fechaDesde = new com.toedter.calendar.JDateChooser();
        fechaHasta = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();
        btnVerProductos = new javax.swing.JButton();

        setTitle("Solicitudes Aprobadas");

        jPanel1.setBackground(new java.awt.Color(239, 228, 210));

        jButton1.setBackground(new java.awt.Color(239, 228, 210));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo_Pedidos.png"))); // NOI18N

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tblSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Estado", "F. Llegada", "F. Registro", "Proveedor", "Total"
            }
        ));
        tblSalidas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblSalidas);

        jPanel8.setBackground(new java.awt.Color(239, 228, 210));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 2), "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 24), new java.awt.Color(137, 6, 6))); // NOI18N

        jPanel9.setBackground(new java.awt.Color(239, 228, 210));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 2), "Fecha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 18), new java.awt.Color(137, 6, 6))); // NOI18N

        fechaDesde.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 12)); // NOI18N

        fechaHasta.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(137, 6, 6));
        jLabel10.setText("Desde:");

        jLabel11.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(137, 6, 6));
        jLabel11.setText("Hasta:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(41, 41, 41))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fechaHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechaDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        btnBuscar.setBackground(new java.awt.Color(239, 228, 210));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buscar.png"))); // NOI18N
        btnBuscar.setBorderPainted(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        btnVerProductos.setBackground(new java.awt.Color(30, 58, 81));
        btnVerProductos.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        btnVerProductos.setForeground(new java.awt.Color(239, 228, 210));
        btnVerProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ico-Enviar.png"))); // NOI18N
        btnVerProductos.setText("Enviar Código");
        btnVerProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(45, 45, 45)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVerProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 901, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //leer datos
        Date desde = fechaDesde.getDate();
        Date hasta = fechaHasta.getDate();

        //validar
        if (!validarFechas(desde, hasta)) {
            Extras.Mensajes.mostrarMensaje("La fecha 'Hasta' debe ser posterior a 'Desde'", "error");
            limpiarFiltros();
            return;
        }

        //cambiar hora para incluir el día
        final Date hastaFinal;
        if (hasta != null) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(hasta);
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            cal.set(Calendar.MILLISECOND, 999);
            hastaFinal = cal.getTime();
        } else {
            hastaFinal = null;
        }

        // Filtrar la lista en memoria
        List<Solicitud> solisFiltrados = this.solicitudes.stream()
                .filter(p -> {
                    if (desde == null) {
                        return true;
                    }
                    if (p.getFechaAprobacion() == null) {
                        return false;
                    }
                    Instant fechaAprobacion = p.getFechaAprobacion().toInstant();
                    Instant desdeInstant = desde.toInstant();
                    return !fechaAprobacion.isBefore(desdeInstant);
                })
                .filter(p -> {
                    if (hastaFinal == null) {
                        return true;
                    }
                    if (p.getFechaAprobacion() == null) {
                        return false;
                    }
                    Instant fechaAprobacion = p.getFechaAprobacion().toInstant();
                    Instant hastaInstant = hastaFinal.toInstant();
                    return !fechaAprobacion.isAfter(hastaInstant);
                })
                .collect(Collectors.toList());

        //Actualizar tabla
        if (solisFiltrados.isEmpty()) {
            Mensajes.mostrarMensaje("No existen solicitudes aprobadas entre estas fechas", "error");
            limpiarFiltros();
            return;
        }
        cargarTabla(solisFiltrados);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        ExportadorReporte.generarReporte(tblSalidas, "salidas de " + userAct.getNombres() + " " + userAct.getApellidos());
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnVerProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerProductosActionPerformed
        if (tblSalidas.getRowCount() > 0) {
            int filaSelect = tblSalidas.getSelectedRow();
            if (filaSelect != -1) {
                // Busca la solicitud original en la lista
                Solicitud solicitudSeleccionada = solicitudes.get(filaSelect);

                if ("Retidarado".equals(solicitudSeleccionada.getEstadoSolicitud())) {
                    Mensajes.mostrarMensaje("La solicitud ya fue retirada.", "advertencia");
                    return;
                }

                // Construir resumen de productos
                StringBuilder resumen = new StringBuilder("¿Desea que se le envíe el código de la solicitud para retirar los siguientes productos?\n\n");

                for (DetalleSolicitud detalle : solicitudSeleccionada.getDetalles()) {
                    resumen.append("• ")
                            .append(detalle.getProducto().getNombre())
                            .append(" - Cantidad: ")
                            .append(detalle.getCantidad())
                            .append("\n");
                }

                boolean confirmar = Mensajes.confirmar(resumen.toString());
                if (!confirmar) {
                    return;
                }

                Mensajes.mostrarMensaje("Acerquese al almacén con el código:\n" + solicitudSeleccionada.getCodigoSalida(), "informacion");
                try {
                    String telefono = "51929281169";
                    String mensaje = "Hola, su código de retiro es "+solicitudSeleccionada.getCodigoSalida()+".";
                    String mensajeCodificado = URLEncoder.encode(mensaje, StandardCharsets.UTF_8.toString());

                    // Crear URL de WhatsApp
                    String url = "https://wa.me/" + telefono + "?text=" + mensajeCodificado;

                    // Abrir en navegador
                    Desktop.getDesktop().browse(new URI(url));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                Extras.Mensajes.mostrarMensaje("Seleccione una salida para ver\nsus productos asociados.", "advertencia");
            }
        }
    }//GEN-LAST:event_btnVerProductosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnVerProductos;
    private com.toedter.calendar.JDateChooser fechaDesde;
    private com.toedter.calendar.JDateChooser fechaHasta;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tblSalidas;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla(List<Solicitud> solicitudes) {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] titulos = {"Estado", "F. Registro", "F. Aprobacion", "Codigo"};
        modeloTabla.setColumnIdentifiers(titulos);
        modeloTabla.setRowCount(0);

        for (Solicitud sol : solicitudes) {
            String estado = sol.getEstadoSolicitud();
            String fechaRegistro = sol.getFechaSolicitud() != null ? formato.format(sol.getFechaSolicitud()) : "";
            String fechaAprobacion = "";
            String codigo = "";

            // Si está aprobado, muestra la fecha de aprobación y el código
            if ("Aprobado".equalsIgnoreCase(estado)) {
                // Si tienes un campo fechaAprobacion úsalo, si no, usa la fecha actual o la fecha de modificación
                fechaAprobacion = sol.getFechaAprobacion() != null
                        ? formato.format(sol.getFechaAprobacion())
                        : fechaRegistro; // O pon "" si no tienes ese campo
                codigo = sol.getCodigoSalida() != null ? sol.getCodigoSalida() : "";
            }

            modeloTabla.addRow(new Object[]{
                estado,
                fechaRegistro,
                fechaAprobacion,
                codigo
            });
        }

        tblSalidas.setModel(modeloTabla);

        // Centra el texto en todas las celdas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < tblSalidas.getColumnCount(); i++) {
            tblSalidas.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        tblSalidas.setRowHeight(35);
        JTableHeader header = tblSalidas.getTableHeader();
        header.setFont(new java.awt.Font("PMingLiU-ExtB", Font.BOLD, 26));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
    }

    private List<Solicitud> solicitudesAprobadas(Usuario usuario) {
        return daoSoli.findByUsuario(usuario)
                .stream()
                .filter(s -> "Aprobado".equals(s.getEstadoSolicitud()) || "Retirado".equals(s.getEstadoSolicitud()))
                .collect(Collectors.toList());
    }

    private void limpiarFiltros() {
        fechaDesde.setDate(null);
        fechaHasta.setDate(null);
        cargarTabla(solicitudesAprobadas(userAct));
    }

    private boolean validarFechas(Date desde, Date hasta) {
        return !(desde != null && hasta != null && hasta.before(desde));
    }
}
