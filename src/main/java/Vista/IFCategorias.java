package Vista;

import Controlador.ControladoraCategoria;
import Controlador.ControladoraGeneral;
import Extras.Mensajes;
import Modelo.Categoria;
import Modelo.Producto;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class IFCategorias extends javax.swing.JInternalFrame {

    private final ControladoraGeneral control;
    private Categoria categoriaEnEdicion = null;
    private List<Categoria> categorias;
    private final JDesktopPane pantalla;
    private final boolean vista;
    private ControladoraCategoria controladoraCategoria;

    public IFCategorias(JDesktopPane desktopPane, boolean vista) {
        initComponents();
        control = new ControladoraGeneral();
        controladoraCategoria = control.getControlCategoria();
        this.categorias = control.getControlCategoria().leerTodo();
        cargarTabla(categorias);
        this.pantalla = desktopPane;
        this.vista = vista;
        soloLetras();
        configurarSpinnerMeses(); // llamamos la configuración del modelo
        soloNumerosEnSpinner(jpnMesDurac);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnRegresar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jpnMesDurac = new javax.swing.JSpinner();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategoria = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btnBuscar5 = new javax.swing.JButton();
        txtBuscarNombre = new javax.swing.JTextField();

        setTitle("Categorías");

        jPanel1.setBackground(new java.awt.Color(239, 228, 210));

        btnRegresar.setBackground(new java.awt.Color(239, 228, 210));
        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Regresar.png"))); // NOI18N
        btnRegresar.setBorderPainted(false);
        btnRegresar.setContentAreaFilled(false);
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Menu_Categoria.png"))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(239, 228, 210));

        jLabel4.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 58, 81));
        jLabel4.setText("Nombre:");

        txtNombre.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 20)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setText("Ingrese el nombre");
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 58, 81));
        jLabel10.setText("Meses de duración:");

        jpnMesDurac.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 20)); // NOI18N
        jpnMesDurac.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        btnGuardar.setBackground(new java.awt.Color(30, 58, 81));
        btnGuardar.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 20)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ico-Guar2.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setPreferredSize(new java.awt.Dimension(120, 50));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(30, 58, 81));
        btnEditar.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 20)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ico-Edit.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(30, 58, 81));
        btnLimpiar.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 20)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ico-Limp.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(30, 58, 81));
        btnEliminar.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Ico-Borr.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel10))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jpnMesDurac, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jpnMesDurac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tblCategoria.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 24)); // NOI18N
        tblCategoria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Meses de Duración"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCategoria.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblCategoria.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblCategoria);

        jPanel8.setBackground(new java.awt.Color(239, 228, 210));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 3), "Buscar por Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 18), new java.awt.Color(137, 6, 6))); // NOI18N

        btnBuscar5.setBackground(new java.awt.Color(30, 58, 81));
        btnBuscar5.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnBuscar5.setForeground(new java.awt.Color(239, 228, 210));
        btnBuscar5.setText("Buscar");
        btnBuscar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar5ActionPerformed(evt);
            }
        });

        txtBuscarNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarNombreActionPerformed(evt);
            }
        });
        txtBuscarNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarNombreKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnBuscar5, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(63, 63, 63))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(57, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        if (vista) {
            this.dispose();
        } else {
            IFProductos prod = new IFProductos(pantalla);
            pantalla.add(prod);
            prod.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        if (txtNombre.getText().equals("Ingrese el nombre")) {
            txtNombre.setText("");
            txtNombre.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if (txtNombre.getText().equals("")) {
            txtNombre.setText("Ingrese el nombre");
            txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        } else {
            txtNombre.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (categoriaEnEdicion == null) {
            //leer datos
            String nombre = txtNombre.getText();
            Object obj = jpnMesDurac.getValue();
            int meses = (int) obj;
            //validar nombre
            if (nombre.equals("Ingrese el nombre") || nombre.equals("")) {
                Mensajes.mostrarMensaje("Es necesario un nombre", "advertencia");
                return;
            }
            boolean conf = Mensajes.confirmar("¿Desea guardar la categoría?");
            if (!conf) {
                return;
            }
            //crear categoria
            Categoria nuevaCat = new Categoria();
            nuevaCat.setNombre(nombre);
            nuevaCat.setTiempo_estimado_almacen(meses * 30);
            //guardar y volver a cargar la tabla
            control.getControlCategoria().crearCategoria(nuevaCat);
            cargarTabla(control.getControlCategoria().leerTodo());
            limpiar();
        } else {
            //leer los datos
            String nombre = txtNombre.getText();
            Object obj = jpnMesDurac.getValue();
            int meses = (int) obj;
            //validar nombre
            if (nombre.equals("Ingrese el nombre") || nombre.equals("")) {
                Mensajes.mostrarMensaje("Es necesario un nombre", "advertencia");
                return;
            }
            boolean conf = Mensajes.confirmar("¿Desea guardar los cambios?");
            if (!conf) {
                return;
            }
            //cargar datos en categoria
            categoriaEnEdicion.setNombre(nombre);
            categoriaEnEdicion.setTiempo_estimado_almacen(meses * 30);
            List<Producto> prodDeCategoria = categoriaEnEdicion.getProductos();
            categoriaEnEdicion.setProductos(prodDeCategoria);
            //actualizar y terminar
            control.getControlCategoria().actualizarCategoria(categoriaEnEdicion);
            categorias = control.getControlCategoria().leerTodo();
            cargarTabla(categorias);
            terminarEdicion();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (categoriaEnEdicion == null) {
            if (tblCategoria.getRowCount() > 0) {
                int filaSelect = tblCategoria.getSelectedRow();
                if (filaSelect != -1) {
                    //cargar el elemento a editar
                    categoriaEnEdicion = categorias.get(filaSelect);
                    //cargar campos
                    txtNombre.setText(categoriaEnEdicion.getNombre());
                    jpnMesDurac.setValue(categoriaEnEdicion.getTiempo_estimado_almacen() / 30);
                    //Cambiar estados para empezar edicion
                    btnEditar.setText("Cancelar");
                    btnGuardar.setText("Actualizar");
                    btnLimpiar.setEnabled(false);
                    btnEliminar.setEnabled(false);
                    txtNombre.setForeground(Color.BLACK);
                    Mensajes.mostrarMensaje("Modifique los datos y luego presione 'Actualizar'", "informacion");
                } else {
                    Extras.Mensajes.mostrarMensaje("Seleccione la fila a editar", "advertencia");
                }
            }
        } else {
            terminarEdicion();
            Mensajes.mostrarMensaje("Edición cancelada", "informacion");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tblCategoria.getRowCount() > 0) {
            int filaSelect = tblCategoria.getSelectedRow();
            if (filaSelect != -1) {
                //cargar el elemento a editar
                Categoria categoriaEliminar = categorias.get(filaSelect);
                boolean conf = Mensajes.confirmar("¿Desea eliminar la categoría '" + categoriaEliminar.getNombre() + "'?");
                if (conf) {
                    control.getControlCategoria().eliminarCategoria(categoriaEliminar.getIdCategoria());
                    categorias = control.getControlCategoria().leerTodo();
                    cargarTabla(categorias);
                }
            } else {
                Extras.Mensajes.mostrarMensaje("Seleccione la fila a eliminar", "advertencia");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar5ActionPerformed
        String termino = txtBuscarNombre.getText();
        categorias = control.getControlCategoria().leerParcial(termino);
        if (categorias.isEmpty()) {
            Mensajes.mostrarMensaje("No se encontraron categorias con este término", "error");
            cargarTabla(control.getControlCategoria().leerTodo());
            return;
        }
        cargarTabla(categorias);
        txtBuscarNombre.setText("");
    }//GEN-LAST:event_btnBuscar5ActionPerformed

    private void txtBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarNombreActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtBuscarNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarNombreKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            String termino = txtBuscarNombre.getText();
            categorias = control.getControlCategoria().leerParcial(termino);
            if (categorias.isEmpty()) {
                Mensajes.mostrarMensaje("No se encontraron categorias con este término", "error");
                cargarTabla(control.getControlCategoria().leerTodo());
                return;
            }
            cargarTabla(categorias);
            txtBuscarNombre.setText("");
        }
    }//GEN-LAST:event_txtBuscarNombreKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar5;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSpinner jpnMesDurac;
    public javax.swing.JTable tblCategoria;
    private javax.swing.JTextField txtBuscarNombre;
    public javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void cargarTabla(List<Categoria> categorias) {
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        String[] titulos = {"Nombre", "Meses de duración"};
        modeloTabla.setColumnIdentifiers(titulos);
        modeloTabla.setRowCount(0);

        // Itera sobre los detalles y los agrega a la tabla
        for (Categoria cat : categorias) {
            Object[] obj = {
                cat.getNombre(),
                cat.getTiempo_estimado_almacen() / 30
            };
            modeloTabla.addRow(obj);
        }

        tblCategoria.setModel(modeloTabla);

        // Centra el texto en todas las celdas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) tblCategoria.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplica el render centrado a cada columna
        for (int i = 0; i < tblCategoria.getColumnCount(); i++) {
            tblCategoria.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }
        //formatear el tamaño de texto
        tblCategoria.setRowHeight(35);
        JTableHeader header = tblCategoria.getTableHeader();
        header.setFont(new java.awt.Font("PMingLiU-ExtB", Font.BOLD, 26));

    }

    private void limpiar() {
        txtNombre.setText("Ingrese el nombre");
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        jpnMesDurac.setValue(1);
    }

    private void terminarEdicion() {
        categoriaEnEdicion = null;
        btnEditar.setText("Editar");
        btnGuardar.setText("Guardar");
        btnLimpiar.setEnabled(true);
        btnEliminar.setEnabled(true);
        limpiar();
    }

    private boolean esCaracterValidoParaNombres(char c) {
        // Permite letras (mayúsculas/minúsculas), espacios, acentos y ñ/Ñ
        return Character.isLetter(c) || c == ' ' || c == 'Á' || c == 'É' || c == 'Í'
                || c == 'Ó' || c == 'Ú' || c == 'á' || c == 'é' || c == 'í'
                || c == 'ó' || c == 'ú' || c == 'Ñ' || c == 'ñ';
    }

    private void soloLetras() {
        // Para el campo de nombre
        txtNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!esCaracterValidoParaNombres(c)) {
                    e.consume(); // Bloquea el carácter si no es válido
                }
            }

        });
        // Para el campo de nombre
        txtBuscarNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!esCaracterValidoParaNombres(c)) {
                    e.consume(); // Bloquea el carácter si no es válido
                }
            }

        });
    }

    private void soloNumerosEnSpinner(JSpinner spinner) {
        JComponent editor = spinner.getEditor();
        if (editor instanceof JSpinner.DefaultEditor) {
            JFormattedTextField txt = ((JSpinner.DefaultEditor) editor).getTextField();
            txt.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    // Solo permitir dígitos
                    if (!Character.isDigit(c)) {
                        e.consume();
                    }
                }
            });
        }
    }

    private void configurarSpinnerMeses() {
        jpnMesDurac.setModel(new SpinnerNumberModel(1, 1, 60, 1));
    }
}
