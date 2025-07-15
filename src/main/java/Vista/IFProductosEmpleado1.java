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

public class IFProductosEmpleado1 extends javax.swing.JInternalFrame {

    private final ControladoraGeneral control;
    private List<Producto> productos;
    private String estadoProducto;
    private final Usuario userActual;
    private Solicitud solicitud;
    private Producto producSelect = null;
    private SolicitudJpaController daoSoli;
    private DetalleSolicitudJpaController daoDetalle;
    private List<DetalleSolicitud> detalles = null;
    private JDesktopPane pantalla;
    private JToolBar tool;

    public IFProductosEmpleado1(Usuario user, JDesktopPane pantalla, JToolBar tool, Solicitud solicitud) {
        initComponents();
        control = new ControladoraGeneral();
        productos = control.getControlProducto().leerTodo();
        this.daoSoli = new SolicitudJpaController();
        this.daoDetalle = new DetalleSolicitudJpaController();
        this.userActual = user;
        listarProductos(productos);
        this.pantalla = pantalla;
        this.tool = tool;
        this.solicitud = solicitud;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btnSolicitar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jpnAgregarProduc = new javax.swing.JSpinner();
        jPanel3 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        btnSolicitud = new javax.swing.JButton();
        btnDescripcion = new javax.swing.JButton();

        setTitle("Registrar Solicitud de Salida");

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

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSolicitar.setBackground(new java.awt.Color(30, 58, 81));
        btnSolicitar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnSolicitar.setForeground(new java.awt.Color(239, 228, 210));
        btnSolicitar.setText("Solicitar");
        btnSolicitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitarActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jpnAgregarProduc.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 20)); // NOI18N
        jpnAgregarProduc.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        jPanel3.setBackground(new java.awt.Color(239, 228, 210));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 3), "Buscar por Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 18), new java.awt.Color(137, 6, 6))); // NOI18N

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        btnSolicitud.setBackground(new java.awt.Color(30, 58, 81));
        btnSolicitud.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnSolicitud.setForeground(new java.awt.Color(239, 228, 210));
        btnSolicitud.setText("Ver Solicitud");
        btnSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSolicitudActionPerformed(evt);
            }
        });

        btnDescripcion.setBackground(new java.awt.Color(30, 58, 81));
        btnDescripcion.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnDescripcion.setForeground(new java.awt.Color(239, 228, 210));
        btnDescripcion.setText("Descripción Producto");
        btnDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescripcionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegresar)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jpnAgregarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSolicitar)
                        .addGap(18, 18, 18)
                        .addComponent(btnDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnRegresar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSolicitar)
                    .addComponent(jpnAgregarProduc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSolicitud)
                    .addComponent(btnDescripcion))
                .addContainerGap(65, Short.MAX_VALUE))
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

    private void btnSolicitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitarActionPerformed
        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay productos para solicitar.");
            return;
        }
        if (tblProductos.getRowCount() > 0) {
            int filaSelect = tblProductos.getSelectedRow();
            if (filaSelect != -1) {
                producSelect = productos.get(filaSelect);
                //validar disponibilidad{
                if (validarEstado(producSelect).equals("NO DISPONIBLE")) {
                    Mensajes.mostrarMensaje("Producto no disponible", "error");
                    return;
                }
                //leer spinner
                Object obj = jpnAgregarProduc.getValue();
                int cantidad = (int) obj;
                //proceso para agregar
                // Validar que el producto no esté en el pedido
                List<DetalleSolicitud> detallesRev = daoDetalle.findBySolicitud(solicitud);

                // Versión mejorada (sin necesidad de lista separada)
                for (DetalleSolicitud detalleRev : detallesRev) {
                    if (detalleRev.getProducto().getIdProducto() == producSelect.getIdProducto()) {
                        Extras.Mensajes.mostrarMensaje("Este producto ya está en la solicitud.\nSi necesita cambios edítelo.", "error");
                        return;
                    }
                }

                boolean conf = Mensajes.confirmar("¿Desea agregar el prudcto a la solicitud?");
                if (!conf) {
                    return;
                }

                //crear detalle
                DetalleSolicitud detalle = new DetalleSolicitud();
                detalle.setCantidad(cantidad);
                detalle.setProducto(producSelect);
                detalle.setSolicitud(solicitud);
                daoDetalle.create(detalle);
                solicitud.getDetalles().add(detalle);
                //finalizacion
                jpnAgregarProduc.setValue(1);
                Mensajes.mostrarMensaje("Producto '" + producSelect.getNombre() + "' agregado a la solicitud.", "informacion");
            } else {
                Extras.Mensajes.mostrarMensaje("Seleccione un producto", "advertencia");
            }
        }
    }//GEN-LAST:event_btnSolicitarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        detalles = daoDetalle.findBySolicitud(solicitud);
        if (detalles.isEmpty()) {
            boolean conf = Extras.Mensajes.confirmar("¿Desea cancelar el registro del pedido?");
            if (conf) {
                try {
                    daoSoli.destroy(solicitud.getIdSolicitud());
                } catch (IllegalOrphanException ex) {
                    Logger.getLogger(IFProductosEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(IFProductosEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.dispose();
            }
        } else {
            boolean conf = Extras.Mensajes.confirmar("Tiene productos asociados a la solicitud, ¿Desea cancelar el registro?");
            if (conf) {
                detalles = daoDetalle.findBySolicitud(solicitud);
                for (DetalleSolicitud d : detalles) {
                    try {
                        daoDetalle.destroy(d.getIdDetalle());
                    } catch (NonexistentEntityException ex) {
                        Logger.getLogger(IFProductosEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                try {
                    // 2. Eliminar la solicitud
                    daoSoli.destroy(solicitud.getIdSolicitud());
                } catch (IllegalOrphanException ex) {
                    Logger.getLogger(IFProductosEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(IFProductosEmpleado.class.getName()).log(Level.SEVERE, null, ex);
                }

                this.dispose();
                this.dispose();
            } else {
                Extras.Mensajes.mostrarMensaje("Valide y registre la solicitud completa", "advertencia");
            }
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String termino = txtBuscar.getText();
        productos = control.getControlProducto().leerParcial(termino);
        if (productos.isEmpty()) {
            Mensajes.mostrarMensaje("No se encontraron productos con este término", "error");
            listarProductos(control.getControlProducto().leerTodo());
            return;
        }
        listarProductos(productos);
        txtBuscar.setText("");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSolicitudActionPerformed
        if (solicitud.getDetalles().isEmpty()) {
            Mensajes.mostrarMensaje("La solicitud no tiene productos asociados", "error");
            return;
        }
        IFSolicitudEmpleado inter = new IFSolicitudEmpleado(userActual, solicitud, pantalla, tool);
        cargarIF(inter);
        this.dispose();
    }//GEN-LAST:event_btnSolicitudActionPerformed

    private void btnDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescripcionActionPerformed
        if (tblProductos.getRowCount() > 0) {
            int filaSelect = tblProductos.getSelectedRow();
            if (filaSelect != -1) {
                // Marcar que estamos en modo edición
                producSelect = productos.get(filaSelect);
                StringBuilder mensaje = new StringBuilder();
                mensaje.append("EL LOTE DE '").append(producSelect.getNombre()).append("' CONTIENE:\n");
                mensaje.append("- ").append(producSelect.getPresentacionLote()).append(" con ").append(producSelect.getCantidadPresentacionLote()).append(" Unidades.");
                Mensajes.mostrarMensaje(mensaje.toString(), "informacion");
            } else {
                Extras.Mensajes.mostrarMensaje("Seleccione un producto", "advertencia");
            }
        }
    }//GEN-LAST:event_btnDescripcionActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            String termino = txtBuscar.getText();
            productos = control.getControlProducto().leerParcial(termino);
            if (productos.isEmpty()) {
                Mensajes.mostrarMensaje("No se encontraron productos con este término", "error");
                productos=control.getControlProducto().leerTodo();
                listarProductos(productos);
                return;
            }
            listarProductos(productos);
            txtBuscar.setText("");
        }
    }//GEN-LAST:event_txtBuscarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDescripcion;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSolicitar;
    private javax.swing.JButton btnSolicitud;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jpnAgregarProduc;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    private void listarProductos(List<Producto> productos) {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] titulos = {"Nombre", "Categoria", "Estado", "Codigo"};
        modeloTabla.setColumnIdentifiers(titulos);
        modeloTabla.setRowCount(0);

        // Itera sobre los detalles y los agrega a la tabla
        for (Producto produc : productos) {
            Object[] obj = {
                produc.getNombre(),
                produc.getCategoria().getNombre(),
                validarEstado(produc),
                produc.getCodigo()
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

}
