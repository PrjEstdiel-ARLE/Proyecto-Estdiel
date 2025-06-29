package Vista;

import Controlador.ControladoraGeneral;
import Extras.Mensajes;
import Modelo.ContactoCargo;
import Modelo.ContactoProveedor;
import Modelo.Proveedor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class IFProveedoresContactos extends javax.swing.JInternalFrame {

    private final ControladoraGeneral control;
    private ContactoProveedor contacto;
    private List<ContactoProveedor> contactos;
    private ContactoProveedor contactoEnEdicion = null;
    private final Proveedor prov;
    private final JDesktopPane pantalla;
    private boolean nombreAsc = false;
    private boolean apellidoAsc = false;

    public IFProveedoresContactos(JDesktopPane desktopPane, Proveedor proveedor) {
        this.prov = proveedor;
        initComponents();
        control = new ControladoraGeneral();
        cargarCargos();
        cargarFiltro();
        contactos = control.getControlContactoProveedor().leerPorProveedor(proveedor);
        cargarContactos(contactos);
        this.pantalla = desktopPane;
        soloNumerosTelefono();
        soloLetras();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cmbCargosFiltro = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        txtNombreFiltro = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnTodo = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnOrdenNombres = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnOrdenApellidos = new javax.swing.JButton();

        setTitle("Contactos Proveedor");

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
                        .addContainerGap(57, Short.MAX_VALUE))
                    .addGroup(panelContactoLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(35, 35, 35))))
        );
        panelContactoLayout.setVerticalGroup(
            panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContactoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(panelContactoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditarContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarContacto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel2.setBackground(new java.awt.Color(239, 228, 210));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 2), "Filtros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 18), new java.awt.Color(137, 6, 6))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(239, 228, 210));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 2), "Cargos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 14), new java.awt.Color(137, 6, 6))); // NOI18N

        cmbCargosFiltro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cmbCargosFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbCargosFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cmbCargosFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel4.setBackground(new java.awt.Color(239, 228, 210));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6), 2), "Nombre o Apellido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 14), new java.awt.Color(137, 6, 6))); // NOI18N

        txtNombreFiltro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtNombreFiltro)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtNombreFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnFiltrar.setBackground(new java.awt.Color(30, 58, 81));
        btnFiltrar.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 18)); // NOI18N
        btnFiltrar.setForeground(new java.awt.Color(239, 228, 210));
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTodo.setBackground(new java.awt.Color(30, 58, 81));
        btnTodo.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        btnTodo.setForeground(new java.awt.Color(239, 228, 210));
        btnTodo.setText("Ver Todos");
        btnTodo.setPreferredSize(new java.awt.Dimension(70, 40));
        btnTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodoActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(239, 228, 210));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6)), "Orden Nombres", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 12), new java.awt.Color(137, 6, 6))); // NOI18N

        btnOrdenNombres.setBackground(new java.awt.Color(30, 58, 81));
        btnOrdenNombres.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        btnOrdenNombres.setForeground(new java.awt.Color(239, 228, 210));
        btnOrdenNombres.setText("Z - A");
        btnOrdenNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenNombresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOrdenNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnOrdenNombres, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(239, 228, 210));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(137, 6, 6)), "Orden Apellidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("PMingLiU-ExtB", 1, 12), new java.awt.Color(137, 6, 6))); // NOI18N

        btnOrdenApellidos.setBackground(new java.awt.Color(30, 58, 81));
        btnOrdenApellidos.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 14)); // NOI18N
        btnOrdenApellidos.setForeground(new java.awt.Color(239, 228, 210));
        btnOrdenApellidos.setText("Z - A");
        btnOrdenApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenApellidosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnOrdenApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnOrdenApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(150, Short.MAX_VALUE)
                        .addComponent(panelContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(97, 97, 97))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnTodo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1261, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        IFProveedores provee = new IFProveedores(pantalla);
        pantalla.add(provee);
        provee.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
        if (!telefono.matches("^9\\d{8}$")) {
            Extras.Mensajes.mostrarMensaje("Ingrese un número de teléfono válido (9 dígitos que empieza con 9)", "error");
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
            recargarTabla();
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
            recargarTabla();
            limpiar();
            Mensajes.mostrarMensaje("Contacto creado correctamente", "informacion");
        }
    }//GEN-LAST:event_btnGuardarContactoActionPerformed

    private void btnEditarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarContactoActionPerformed
        if (contactoEnEdicion != null) {
            finalizarEdicion();
            Mensajes.mostrarMensaje("Edición cancelada", "informacion");
        } else {
            if (tblContactos.getRowCount() > 0) {
                int filaSelect = tblContactos.getSelectedRow();
                if (filaSelect != -1) {
                    // Marcar que estamos en modo edición
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
                    enEdicion(true);
                    Extras.Mensajes.mostrarMensaje("Modifique los datos y presione 'Actualizar'", "informacion");
                } else {
                    Extras.Mensajes.mostrarMensaje("Seleccione la fila a editar", "advertencia");
                }
            }
        }
    }//GEN-LAST:event_btnEditarContactoActionPerformed

    private void btnEliminarContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarContactoActionPerformed
        if (tblContactos.getRowCount() > 0) {
            int filaSelect = tblContactos.getSelectedRow();
            //Asegurar selección
            if (filaSelect != -1) {
                ContactoProveedor contSelect = contactos.get(filaSelect);
                boolean conf = Extras.Mensajes.confirmar("¿Desea eliminar este elemento?");
                if (conf) {
                    control.getControlContactoProveedor().eliminar(contSelect.getIdContacto());
                    contactos.remove(filaSelect);
                    recargarTabla();
                }
            } else {
                Extras.Mensajes.mostrarMensaje("Seleccione la fila a eliminar", "advertencia");
            }
        }
    }//GEN-LAST:event_btnEliminarContactoActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        //leer datos
        String nombreFiltro = txtNombreFiltro.getText();
        String cargoTexto = cmbCargosFiltro.getSelectedItem().toString();
        ContactoCargo cargoFiltro = cargoTexto.equals("Cualquiera") ? null : ContactoCargo.valueOf(cargoTexto);
        //filtrar Contactos
        contactos = filtrarContactos(control.getControlContactoProveedor().leerPorProveedor(prov), nombreFiltro, cargoFiltro);
        if (contactos.isEmpty()) {
            Mensajes.mostrarMensaje("No existen contactos con estos parámetros", "error");
            recargarTabla();
            return;
        }
        cargarContactos(contactos);
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void btnTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodoActionPerformed
        recargarTabla();
    }//GEN-LAST:event_btnTodoActionPerformed

    private void btnOrdenNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenNombresActionPerformed
        if (!nombreAsc) {
            contactos = control.getControlContactoProveedor().ordenarNombreZA(contactos);
            cargarContactos(contactos);
        } else {
            contactos = control.getControlContactoProveedor().ordenarNombreAZ(contactos);
            cargarContactos(contactos);
        }
        esAscendenteNombre();
    }//GEN-LAST:event_btnOrdenNombresActionPerformed

    private void btnOrdenApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenApellidosActionPerformed
        if (!apellidoAsc) {
            contactos = control.getControlContactoProveedor().ordenarApellidoZA(contactos);
            cargarContactos(contactos);
        } else {
            contactos = control.getControlContactoProveedor().ordenarApellidoAZ(contactos);
            cargarContactos(contactos);
        }
        esAscendenteApellido();
    }//GEN-LAST:event_btnOrdenApellidosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCopiarContacto;
    private javax.swing.JButton btnEditarContacto;
    private javax.swing.JButton btnEliminarContacto;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGuardarContacto;
    private javax.swing.JButton btnOrdenApellidos;
    private javax.swing.JButton btnOrdenNombres;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnTodo;
    private javax.swing.JComboBox<String> cmbCargos;
    private javax.swing.JComboBox<String> cmbCargosFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JPanel panelContacto;
    private javax.swing.JTable tblContactos;
    private javax.swing.JTextField txtApellidoContacto;
    private javax.swing.JTextField txtCorreoContacto;
    private javax.swing.JTextField txtNombreContacto;
    private javax.swing.JTextField txtNombreFiltro;
    private javax.swing.JTextField txtTelefonoContacto;
    // End of variables declaration//GEN-END:variables
private void cargarCargos() {
        cmbCargos.removeAllItems();
        for (ContactoCargo cargo : ContactoCargo.values()) {
            cmbCargos.addItem(cargo.name());
        }
    }

    private void cargarContactos(List<ContactoProveedor> contProv) {
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

        // Itera sobre los detalles y los agrega a la tabla
        for (ContactoProveedor cont : contProv) {
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
        contactoEnEdicion = null;
        enEdicion(false);
    }

    private void soloNumerosTelefono() {
        txtTelefonoContacto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                String textoActual = txtTelefonoContacto.getText();

                // Bloquear si:
                // - No es un dígito.
                // - Ya hay 9 caracteres.
                // - Es el primer carácter y no es '9'.
                if (!Character.isDigit(c)
                        || textoActual.length() >= 9
                        || (textoActual.isEmpty() && c != '9')) {
                    e.consume();
                }
            }
        });
    }

    private boolean esCaracterValidoParaNombres(char c) {
        // Permite letras (mayúsculas/minúsculas), espacios, acentos y ñ/Ñ
        return Character.isLetter(c) || c == ' ' || c == 'Á' || c == 'É' || c == 'Í'
                || c == 'Ó' || c == 'Ú' || c == 'á' || c == 'é' || c == 'í'
                || c == 'ó' || c == 'ú' || c == 'Ñ' || c == 'ñ';
    }

    private void soloLetrasFiltro() {
        txtNombreFiltro.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!esCaracterValidoParaNombres(c)) {
                    e.consume(); // Bloquea el carácter si no es válido
                }
            }
        });
    }

    private void soloLetrasNombreApellido() {
        // Para el campo de nombre
        txtNombreContacto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!esCaracterValidoParaNombres(c)) {
                    e.consume(); // Bloquea el carácter si no es válido
                }
            }
        });

        // Para el campo de apellido
        txtApellidoContacto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!esCaracterValidoParaNombres(c)) {
                    e.consume();
                }
            }
        });
    }

    private void cargarFiltro() {
        cmbCargosFiltro.removeAllItems();
        cmbCargosFiltro.addItem("Cualquiera");
        for (ContactoCargo cargo : ContactoCargo.values()) {
            cmbCargosFiltro.addItem(cargo.name());
        }
    }

    private void recargarTabla() {
        contactos = control.getControlContactoProveedor().leerPorProveedor(prov);
        cargarContactos(contactos);
    }

    private void enEdicion(boolean b) {
        btnFiltrar.setEnabled(!b);
        txtNombreFiltro.setEnabled(!b);
        cmbCargosFiltro.setEnabled(!b);
        btnOrdenApellidos.setEnabled(!b);
        btnOrdenNombres.setEnabled(!b);
        btnTodo.setEnabled(!b);
    }

    public List<ContactoProveedor> filtrarContactos(List<ContactoProveedor> contactos, String nombreFiltro, ContactoCargo cargoFiltro) {
        String filtro = nombreFiltro.trim().toLowerCase();

        return contactos.stream()
                .filter(c -> (filtro.isEmpty() || (c.getNombre() + " " + c.getApellido()).toLowerCase().contains(filtro)))
                .filter(c -> (cargoFiltro == null || c.getCargo() == cargoFiltro))
                .collect(Collectors.toList());
    }

    private void soloLetras() {
        soloLetrasNombreApellido();
        soloLetrasFiltro();
    }

    private void esAscendenteApellido() {
        btnOrdenApellidos.setText(apellidoAsc ? "Z - A" : "A - Z");
        apellidoAsc = !apellidoAsc;
    }

    private void esAscendenteNombre() {
        btnOrdenNombres.setText(nombreAsc ? "Z - A" : "A - Z");
        nombreAsc = !nombreAsc;
    }
}
