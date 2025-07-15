package Vista;

import Controlador.ControladoraGeneral;
import DAO.DetalleSolicitudJpaController;
import DAO.ProductoJpaController;
import DAO.SolicitudJpaController;
import DAO.UsuarioJpaController;
import DAO.exceptions.IllegalOrphanException;
import DAO.exceptions.NonexistentEntityException;
import Extras.Mensajes;
import Modelo.DetalleSolicitud;
import Modelo.Producto;
import Modelo.Solicitud;
import Modelo.Usuario;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class IFSolicitudEmpleado extends javax.swing.JInternalFrame {

    private final ControladoraGeneral control;
    private List<Producto> productos;
    private String estadoProducto;
    private final Usuario usuario;
    private Solicitud solicitud;
    private SolicitudJpaController daoSoli;
    private DetalleSolicitudJpaController daoDetalle;
    List<DetalleSolicitud> detalles = null;
    private JDesktopPane pantalla;
    private JToolBar tool;
    private DetalleSolicitud detalle = null;

    public IFSolicitudEmpleado(Usuario user, Solicitud solicitud, JDesktopPane pantalla, JToolBar tool) {
        initComponents();
        control = new ControladoraGeneral();
        this.daoSoli = new SolicitudJpaController();
        this.daoDetalle = new DetalleSolicitudJpaController();
        this.usuario = user;
        this.solicitud = solicitud;
        detalles = daoDetalle.findBySolicitud(solicitud);
        listarProductos(detalles);
        this.pantalla = pantalla;
        this.tool = tool;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jpnAgregarProduc = new javax.swing.JSpinner();
        btnSolicitud = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        lblBienvenida = new javax.swing.JLabel();

        setTitle("Solicitud de Salida");

        jPanel1.setBackground(new java.awt.Color(239, 228, 210));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo_Prod.png"))); // NOI18N

        btnRegresar.setBackground(new java.awt.Color(239, 228, 210));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Categoria", "Nombre", "Precio Compra", "Cantidad", "Estado", "Código"
            }
        ));
        jScrollPane1.setViewportView(tblProductos);

        btnEditar.setBackground(new java.awt.Color(30, 58, 81));
        btnEditar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(239, 228, 210));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ico-Edit.png"))); // NOI18N
        btnEditar.setText("Editar Cantidad");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jpnAgregarProduc.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 20)); // NOI18N
        jpnAgregarProduc.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        jpnAgregarProduc.setEnabled(false);

        btnSolicitud.setBackground(new java.awt.Color(30, 58, 81));
        btnSolicitud.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnSolicitud.setForeground(new java.awt.Color(239, 228, 210));
        btnSolicitud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ico-Enviar.png"))); // NOI18N
        btnSolicitud.setText("Enviar Solicitud");
        btnSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitudActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(30, 58, 81));
        btnGuardar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(239, 228, 210));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ico-Guar2.png"))); // NOI18N
        btnGuardar.setText("Guardar Cambios");
        btnGuardar.setEnabled(false);
        btnGuardar.setFocusCycleRoot(true);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblBienvenida.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 50)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(137, 6, 6));
        lblBienvenida.setText("Solicitud de Salida");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBienvenida)
                        .addGap(99, 99, 99)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jpnAgregarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnRegresar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3)))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lblBienvenida)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(jpnAgregarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addContainerGap(49, Short.MAX_VALUE))
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

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (detalle != null) {
            enEdicion(false);
            detalle = null;
            jpnAgregarProduc.setValue(1);
            Mensajes.mostrarMensaje("Edición cancelada", "informacion");
        } else {
            if (tblProductos.getRowCount() > 0) {
                int filaSelect = tblProductos.getSelectedRow();
                if (filaSelect != -1) {
                    detalle = detalles.get(filaSelect);
                    enEdicion(true);
                    //stear cantidad
                    jpnAgregarProduc.setValue(detalle.getCantidad());
                    System.out.println("El detalle seleccionado es el: " + detalle.getIdDetalle());
                    //finalizacion
                    Mensajes.mostrarMensaje("Realice los cambios y presione guardar.", "informacion");
                } else {
                    Extras.Mensajes.mostrarMensaje("Seleccione un producto", "advertencia");
                }
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        IFProductosEmpleado1 inter = new IFProductosEmpleado1(usuario, pantalla, tool, solicitud);
        cargarIF(inter);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitudActionPerformed
        if (!Mensajes.confirmar("¿Desea terminar la solicitud?")) {
            return;
        }

        try {
            daoSoli.actualizarFechaEstado(
                    solicitud.getIdSolicitud(),
                    new Date(),
                    "Pendiente");

            Mensajes.mostrarMensaje("Solicitud enviada correctamente", "informacion");

            IFSolicitarSalida ss = new IFSolicitarSalida(usuario);
            cargarIF(ss);
            this.dispose();

        } catch (Exception ex) {
            Logger.getLogger(IFSolicitudEmpleado.class.getName())
                    .log(Level.SEVERE, null, ex);
            Mensajes.mostrarMensaje("Error al finalizar la solicitud", "error");
        }
    }//GEN-LAST:event_btnSolicitudActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //leer
        Object obj = jpnAgregarProduc.getValue();
        int cantidad = (int) obj;
        //actualizar
        detalle.setCantidad(cantidad);
        try {
            daoDetalle.edit(detalle);
        } catch (Exception ex) {
            Logger.getLogger(IFSolicitudEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        //termina
        Mensajes.mostrarMensaje("Producto '" + detalle.getProducto().getNombre() + "' editado exitosamente.", "informacion");
        detalle = null;
        jpnAgregarProduc.setValue(1);
        enEdicion(false);
        recargarTablar();
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSolicitud;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jpnAgregarProduc;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables

    private void listarProductos(List<DetalleSolicitud> detalles) {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] titulos = {"Nombre", "Categoria", "Codigo", "Cantidad de Lotes"};
        modeloTabla.setColumnIdentifiers(titulos);
        modeloTabla.setRowCount(0);

        // Itera sobre los detalles y los agrega a la tabla
        for (DetalleSolicitud det : detalles) {
            Object[] obj = {
                det.getProducto().getNombre(),
                det.getProducto().getCategoria().getNombre(),
                det.getProducto().getCodigo(),
                det.getCantidad()
            };
            modeloTabla.addRow(obj);
        }

        tblProductos.setModel(modeloTabla);

        // Centra el texto en todas las celdas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplica el render centrado a cada columna
        for (int i = 0; i < tblProductos.getColumnCount(); i++) {
            tblProductos.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        //formatear el tamaño de texto
        tblProductos.setRowHeight(35);
        JTableHeader header = tblProductos.getTableHeader();
        header.setFont(new java.awt.Font("PMingLiU-ExtB", Font.BOLD, 26));
        header.setPreferredSize(new Dimension(header.getWidth(), 40));
    }

    private Object validarEstado(Producto produc) {
        int cant = produc.getCantidadLotes();
        estadoProducto = cant > 10 ? "DISPONIBLE" : "NO DISPONIBLE";
        return estadoProducto;
    }

    private void cargarIF(JInternalFrame internal) {
        pantalla.add(internal);
        internal.show();
        internal.setLocation(10, tool.getHeight() + 10);
    }

    private void enEdicion(boolean b) {
        jpnAgregarProduc.setEnabled(b);
        btnGuardar.setEnabled(b);
        btnSolicitud.setEnabled(!b);
        btnEditar.setText(!b ? "Editar Cantidad" : "Cancelar");
    }

    private void recargarTablar() {
        detalles = daoDetalle.findBySolicitud(solicitud);
        listarProductos(detalles);
    }

}
