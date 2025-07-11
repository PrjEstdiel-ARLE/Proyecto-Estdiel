package Vista;

import Extras.Mensajes;
import Modelo.Usuario;
import javax.swing.JInternalFrame;

public class Logistica extends javax.swing.JFrame {

    private final Usuario userActual;

    public Logistica(Usuario usuario) {
        initComponents();
        this.userActual = usuario;
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //control jdesktoppane se cambio de nombre por ESCRITORIO
        this.setContentPane(this.pantalla);
        lblBienvenida.setText(colocarBienvenida());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pantalla = new javax.swing.JDesktopPane();
        lblBienvenida = new javax.swing.JLabel();
        toolBar = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemCambio = new javax.swing.JMenuItem();
        itemCerrar = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();
        menuLogistica = new javax.swing.JMenu();
        itemProducts = new javax.swing.JMenuItem();
        menuSalidas = new javax.swing.JMenu();
        itemSolicitarSalida = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestor de Logística para Papelería 'Estdiel' - Encargado de Logística");

        pantalla.setBackground(new java.awt.Color(239, 228, 210));

        lblBienvenida.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 65)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(137, 6, 6));
        lblBienvenida.setText("Mensaje");

        toolBar.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ToolLogo_Prod.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        toolBar.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ToolLogo_Salida_Lotes.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        toolBar.add(jButton2);

        pantalla.setLayer(lblBienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(toolBar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pantallaLayout = new javax.swing.GroupLayout(pantalla);
        pantalla.setLayout(pantallaLayout);
        pantallaLayout.setHorizontalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaLayout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(lblBienvenida)
                .addContainerGap(411, Short.MAX_VALUE))
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pantallaLayout.setVerticalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaLayout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblBienvenida)
                .addContainerGap(338, Short.MAX_VALUE))
        );

        menuArchivo.setText("Archivo");
        menuArchivo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        itemCambio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemCambio.setText("Cambiar Contraseña");
        itemCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCambioActionPerformed(evt);
            }
        });
        menuArchivo.add(itemCambio);

        itemCerrar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemCerrar.setText("Cerrar Sesión");
        itemCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarActionPerformed(evt);
            }
        });
        menuArchivo.add(itemCerrar);
        menuArchivo.add(jSeparator5);

        itemSalir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(itemSalir);

        jMenuBar1.add(menuArchivo);

        menuLogistica.setText("Logística");
        menuLogistica.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        itemProducts.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemProducts.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemProducts.setText("Productos");
        itemProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProductsActionPerformed(evt);
            }
        });
        menuLogistica.add(itemProducts);

        jMenuBar1.add(menuLogistica);

        menuSalidas.setText("Salidas");
        menuSalidas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        itemSolicitarSalida.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemSolicitarSalida.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemSolicitarSalida.setText("Solicitar Salida");
        itemSolicitarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSolicitarSalidaActionPerformed(evt);
            }
        });
        menuSalidas.add(itemSolicitarSalida);

        jMenuBar1.add(menuSalidas);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pantalla)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pantalla)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarActionPerformed
        boolean conf = Mensajes.confirmar("¿Desea cerrar sesión?");
        if (conf) {
            Login lo = new Login();
            lo.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_itemCerrarActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        boolean conf = Mensajes.confirmar("¿Desea cerrar la ventana completa?");
        if (conf) {
            this.dispose();
        }
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProductsActionPerformed
        IFProductosEmpleado pEm = new IFProductosEmpleado(userActual,pantalla,toolBar);
        cargarIF(pEm);
    }//GEN-LAST:event_itemProductsActionPerformed

    private void itemSolicitarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSolicitarSalidaActionPerformed
        IFSolicitarSalida SS = new IFSolicitarSalida(userActual);
        cargarIF(SS);
    }//GEN-LAST:event_itemSolicitarSalidaActionPerformed

    private void itemCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCambioActionPerformed
        IFCambioPassword cpwd=new IFCambioPassword(userActual);
        cargarIF(cpwd);
    }//GEN-LAST:event_itemCambioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        IFProductosEmpleado pEm = new IFProductosEmpleado(userActual,pantalla,toolBar);
        cargarIF(pEm);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        IFSolicitarSalida SS = new IFSolicitarSalida(userActual);
        cargarIF(SS);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemCambio;
    private javax.swing.JMenuItem itemCerrar;
    private javax.swing.JMenuItem itemProducts;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuItem itemSolicitarSalida;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuLogistica;
    private javax.swing.JMenu menuSalidas;
    private javax.swing.JDesktopPane pantalla;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables

    private void cargarIF(JInternalFrame internal) {
        pantalla.add(internal);
        internal.show();
        internal.setLocation(10, toolBar.getHeight()+10);
    }

    private String colocarBienvenida() {
        return "Bienvenido " + userActual.getNombres() + " " + userActual.getApellidos();
    }
}
