package Vista;

import Controlador.ControladoraGeneral;
import Extras.ExportadorReporte;
import Extras.Mensajes;
import Modelo.Categoria;
import Modelo.EstadoLote;
import Modelo.Lote;
import Modelo.Producto;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class IFLotes extends javax.swing.JInternalFrame {

    private final ControladoraGeneral control;
    SimpleDateFormat formatoControl = new SimpleDateFormat("dd MMM. yyyy", new Locale("es", "ES"));
    Lote loteEnEdicion = null;
    private List<Lote> lotes;
    private List<Lote> soloLote;
    private List<Producto> productos;
    private List<Categoria> categorias;
    private List<Date> fechas;
    private boolean combosInicializados = false;

    public IFLotes() {
        initComponents();
        this.control = new ControladoraGeneral();
        formatoControl.setTimeZone(TimeZone.getTimeZone("UTC"));
        cargarTabla();
        cargarEstados();
        cargarProducto();
        cargarCategorias();
        cmbEstado.setEnabled(false);
        combosInicializados = true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnRegresar2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLotes = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbProductos = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        btnTodos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnReporte = new javax.swing.JButton();

        setTitle("Lotes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(239, 228, 210));
        jPanel3.setPreferredSize(new java.awt.Dimension(1046, 710));

        btnRegresar2.setBackground(new java.awt.Color(239, 228, 210));
        btnRegresar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar2.setBorderPainted(false);
        btnRegresar2.setContentAreaFilled(false);
        btnRegresar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar2ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo_Lotes.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 58, 81));
        jLabel7.setText("Seleccionar Producto:");

        tblLotes.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N
        tblLotes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Producto", "Categoria", "Estado", "Fecha de Registro"
            }
        ));
        tblLotes.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblLotes.setAutoscrolls(false);
        tblLotes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblLotes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tblLotes);

        jLabel8.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 58, 81));
        jLabel8.setText("Seleccionar Categoria:");

        cmbCategoria.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N
        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCategoriaActionPerformed(evt);
            }
        });

        cmbProductos.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N
        cmbProductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProductosActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 58, 81));
        jLabel9.setText("Estado:");

        cmbEstado.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnGuardar.setBackground(new java.awt.Color(30, 58, 81));
        btnGuardar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(239, 228, 210));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ico-Guar2.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setEnabled(false);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(30, 58, 81));
        btnEditar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(239, 228, 210));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ico-Edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTodos.setBackground(new java.awt.Color(30, 58, 81));
        btnTodos.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnTodos.setForeground(new java.awt.Color(239, 228, 210));
        btnTodos.setText("Mostrar todos");
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(239, 228, 210));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 2), "Buscar por código", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 18), new java.awt.Color(137, 6, 6))); // NOI18N

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(239, 228, 210));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Buscar.png"))); // NOI18N
        btnBuscar.setBorderPainted(false);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        btnReporte.setBackground(new java.awt.Color(30, 58, 81));
        btnReporte.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(239, 228, 210));
        btnReporte.setText("Generar Reporte");
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(cmbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator6))
                                    .addGap(82, 82, 82)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jSeparator4))))
                            .addGap(81, 81, 81)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnRegresar2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jScrollPane1))
                    .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnRegresar2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 667));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (loteEnEdicion == null) {
            //leer campo
            String codigo = txtBuscar.getText();
            //validar
            if (codigo.equals("")) {
                Mensajes.mostrarMensaje("Ingrese un código en el campo", "advertencia");
                return;
            }
            //buscar
            Lote loteEnc = control.getControlLote().buscarPorCodigo(codigo);
            // validar resultado
            if (loteEnc == null) {
                Mensajes.mostrarMensaje("No se encontró ningún lote con ese código", "error");
                limpiar();
                cargarTabla();
                return;
            }
            //cargar en tabla
            soloLote = new ArrayList<>();
            soloLote.add(loteEnc);
            cargarLotes(soloLote);
            limpiar();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        cargarTabla();
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (loteEnEdicion == null) {
            if (tblLotes.getRowCount() > 0) {
                int filaSelect = tblLotes.getSelectedRow();
                if (filaSelect != -1) {
                    // Marcar que estamos en modo edición
                    lotes = control.getControlLote().leerTodo();
                    loteEnEdicion = lotes.get(filaSelect);
                    //mostrar lote en edicion
                    soloLote = new ArrayList<>();
                    soloLote.add(loteEnEdicion);
                    cargarLotes(soloLote);
                    tblLotes.setEnabled(false);
                    cmbEstado.setSelectedItem(loteEnEdicion.getEstado().name());
                    //activar botones y cambiar
                    btnEditar.setText("Cancelar");
                    btnGuardar.setEnabled(true);
                    cmbEstado.setEnabled(true);
                    btnTodos.setEnabled(false);
                    Mensajes.mostrarMensaje("Modifique el estado y presione 'Guardar'", "informacion");
                } else {
                    Mensajes.mostrarMensaje("Seleccione la fila a editar", "advertencia");
                }
            }
        } else {
            Mensajes.mostrarMensaje("Edición Cancelada", "informacion");
            terminarEdicion();
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        boolean conf = Mensajes.confirmar("¿Desea guardar los cambios?");
        if (!conf) {
            return;
        }
        //leer datos
        EstadoLote estadoLote = EstadoLote.valueOf((String) cmbEstado.getSelectedItem());
        //cambiar y guardar
        loteEnEdicion.setEstado(estadoLote);
        control.getControlLote().actualizar(loteEnEdicion);
        //terminar proceso
        Mensajes.mostrarMensaje("Lote editado exitosamente", "informacion");
        terminarEdicion();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProductosActionPerformed
        if (!combosInicializados) {
            return;
        }
        if (loteEnEdicion != null) {
            Mensajes.mostrarMensaje("Termine o cancele la edición", "advertencia");
            return;
        }
        if (cmbProductos.getSelectedIndex() > -1) {
            String producto = (String) cmbProductos.getSelectedItem();
            Producto prodSlct = control.getControlProducto().leerPorNombre(producto);
            lotes = control.getControlLote().lotesPorProducto(prodSlct);
            cargarLotes(lotes);
        }
    }//GEN-LAST:event_cmbProductosActionPerformed

    private void cmbCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCategoriaActionPerformed
        if (!combosInicializados) {
            return;
        }
        if (loteEnEdicion != null) {
            Mensajes.mostrarMensaje("Termine o cancele la edición", "advertencia");
            return;
        }
        if (cmbProductos.getSelectedIndex() > -1) {
            String categoriaSelect = (String) cmbCategoria.getSelectedItem();
            Categoria categoria = control.getControlCategoria().leerPorNombre(categoriaSelect);
            productos = control.getControlProducto().leerPorCategoria(categoria);
            List<Lote> todosLotes = new ArrayList<>();
            for (Producto producto : productos) {
                List<Lote> lotesDeProducto = control.getControlLote().lotesPorProducto(producto);
                for (Lote lote : lotesDeProducto) {
                    todosLotes.add(lote);
                }
            }
            cargarLotes(todosLotes);
        }
    }//GEN-LAST:event_cmbCategoriaActionPerformed

    private void btnRegresar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnRegresar2ActionPerformed

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        ExportadorReporte.generarReporte(tblLotes, "lotes");
    }//GEN-LAST:event_btnReporteActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            if (loteEnEdicion == null) {
                //leer campo
                String codigo = txtBuscar.getText();
                //validar
                if (codigo.equals("")) {
                    Mensajes.mostrarMensaje("Ingrese un código en el campo", "advertencia");
                    return;
                }
                //buscar
                Lote loteEnc = control.getControlLote().buscarPorCodigo(codigo);
                // validar resultado
                if (loteEnc == null) {
                    Mensajes.mostrarMensaje("No se encontró ningún lote con ese código", "error");
                    limpiar();
                    cargarTabla();
                    return;
                }
                //cargar en tabla
                soloLote = new ArrayList<>();
                soloLote.add(loteEnc);
                cargarLotes(soloLote);
                limpiar();
            }
        }
    }//GEN-LAST:event_txtBuscarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRegresar2;
    private javax.swing.JButton btnReporte;
    private javax.swing.JButton btnTodos;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable tblLotes;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla() {
        cargarLotes(control.getControlLote().leerTodo());
    }

    private void cargarLotes(List<Lote> lotes) {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] titulos = {"Producto", "F. de Ingreso", "F. de Vencimiento", "Código", "Estado"};
        modeloTabla.setColumnIdentifiers(titulos);
        modeloTabla.setRowCount(0);

        // Itera sobre los detalles y los agrega a la tabla
        for (Lote lote : lotes) {
            Object[] obj = {
                lote.getProducto().getNombre(),
                formatoControl.format(lote.getFechaIngreso()),
                formatoControl.format(lote.getFechaVencimiento()),
                lote.getCodigo(),
                lote.getEstado().name()
            };
            modeloTabla.addRow(obj);
        }

        tblLotes.setModel(modeloTabla);

        //tamaños
        tblLotes.getColumnModel().getColumn(0).setPreferredWidth(350);
        tblLotes.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblLotes.getColumnModel().getColumn(2).setPreferredWidth(250);
        tblLotes.getColumnModel().getColumn(3).setPreferredWidth(180);
        tblLotes.getColumnModel().getColumn(4).setPreferredWidth(180);

        // Centra el texto en todas las celdas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tblLotes.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplica el render centrado a cada columna
        for (int i = 0; i < tblLotes.getColumnCount(); i++) {
            tblLotes.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        //formatear el tamaño de texto
        tblLotes.setRowHeight(30);
        JTableHeader header = tblLotes.getTableHeader();
        header.setFont(new java.awt.Font("PMingLiU-ExtB", Font.BOLD, 26));
    }

    private void terminarEdicion() {
        btnEditar.setText("Editar");
        btnGuardar.setEnabled(false);
        tblLotes.setEnabled(true);
        soloLote.clear();
        cmbEstado.setEnabled(false);
        loteEnEdicion = null;
        btnTodos.setEnabled(true);
        cargarTabla();
    }

    private void cargarEstados() {
        cmbEstado.removeAllItems();
        for (EstadoLote estado : EstadoLote.values()) {
            cmbEstado.addItem(estado.name());
        }
    }

    private void limpiar() {
        txtBuscar.setText("");
    }

    private void cargarProducto() {
        cmbProductos.removeAllItems();
        productos = control.getControlProducto().leerTodo();
        for (Producto producto : productos) {
            cmbProductos.addItem(producto.getNombre());
        }
    }

    private void cargarCategorias() {
        cmbCategoria.removeAllItems();
        categorias = control.getControlCategoria().leerTodo();
        for (Categoria categoria : categorias) {
            cmbCategoria.addItem(categoria.getNombre());
        }
    }

}
