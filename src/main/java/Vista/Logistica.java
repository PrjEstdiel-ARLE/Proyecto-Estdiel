package Vista;

import Extras.Mensajes;
import Modelo.Usuario;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class Logistica extends javax.swing.JFrame {

    private final Usuario userActual;

    public Logistica(Usuario usuario) {
        initComponents();
        colocarFondoPantalla();
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
        jButton3 = new javax.swing.JButton();
        icono = new javax.swing.JLabel();
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
        itemSalidasAceptadas = new javax.swing.JMenuItem();

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

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ToolLogo_Lotes.png"))); // NOI18N
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        toolBar.add(jButton3);

        pantalla.setLayer(lblBienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(toolBar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(icono, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pantallaLayout = new javax.swing.GroupLayout(pantalla);
        pantalla.setLayout(pantallaLayout);
        pantallaLayout.setHorizontalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pantallaLayout.createSequentialGroup()
                .addContainerGap(601, Short.MAX_VALUE)
                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(364, 364, 364))
            .addGroup(pantallaLayout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(lblBienvenida)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pantallaLayout.setVerticalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaLayout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lblBienvenida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(186, 186, 186))
        );

        menuArchivo.setText("Archivo");
        menuArchivo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        itemCambio.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_0, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemCambio.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemCambio.setText("Cambiar Contraseña");
        itemCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCambioActionPerformed(evt);
            }
        });
        menuArchivo.add(itemCambio);

        itemCerrar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemCerrar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemCerrar.setText("Cerrar Sesión");
        itemCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarActionPerformed(evt);
            }
        });
        menuArchivo.add(itemCerrar);
        menuArchivo.add(jSeparator5);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_DOWN_MASK));
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

        itemSolicitarSalida.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemSolicitarSalida.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemSolicitarSalida.setText("Pendientes");
        itemSolicitarSalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSolicitarSalidaActionPerformed(evt);
            }
        });
        menuSalidas.add(itemSolicitarSalida);

        itemSalidasAceptadas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemSalidasAceptadas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemSalidasAceptadas.setText("Aprobadas");
        itemSalidasAceptadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalidasAceptadasActionPerformed(evt);
            }
        });
        menuSalidas.add(itemSalidasAceptadas);

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
        IFProductosEmpleado pEm = new IFProductosEmpleado(userActual, pantalla, toolBar);
        cargarIF(pEm);
    }//GEN-LAST:event_itemProductsActionPerformed

    private void itemSolicitarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSolicitarSalidaActionPerformed
        IFSolicitarSalida SS = new IFSolicitarSalida(userActual);
        cargarIF(SS);
    }//GEN-LAST:event_itemSolicitarSalidaActionPerformed

    private void itemCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCambioActionPerformed
        IFCambioPassword cpwd = new IFCambioPassword(userActual);
        cargarIF(cpwd);
    }//GEN-LAST:event_itemCambioActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean conf = Mensajes.confirmar("¿Desea registrar una solicitud de salida?");
        if (!conf) {
            return;
        }
        IFProductosEmpleado pEm = new IFProductosEmpleado(userActual, pantalla, toolBar);
        cargarIF(pEm);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        IFSolicitarSalida SS = new IFSolicitarSalida(userActual);
        cargarIF(SS);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void itemSalidasAceptadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalidasAceptadasActionPerformed
        IFSalidasAprobadas SS=new IFSalidasAprobadas(userActual);
        cargarIF(SS);
    }//GEN-LAST:event_itemSalidasAceptadasActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        IFSalidasAprobadas SS=new IFSalidasAprobadas(userActual);
        cargarIF(SS);
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icono;
    private javax.swing.JMenuItem itemCambio;
    private javax.swing.JMenuItem itemCerrar;
    private javax.swing.JMenuItem itemProducts;
    private javax.swing.JMenuItem itemSalidasAceptadas;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuItem itemSolicitarSalida;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
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
        internal.setLocation(10, toolBar.getHeight() + 10);
    }

    private String colocarBienvenida() {
        return "Bienvenido " + userActual.getNombres() + " " + userActual.getApellidos();
    }

    private void colocarFondoPantalla() {
        // Cargar la imagen de fondo desde la carpeta resources (debe estar en src/main/resources/Img)
        ImageIcon icono = new ImageIcon(getClass().getResource("/Img/Logo.png"));
        JLabel fondo = new JLabel(icono);

        // Ajustar el tamaño del JLabel al tamaño del JDesktopPane
        fondo.setSize(pantalla.getWidth(), pantalla.getHeight());

        // Establecer posición en 0,0
        fondo.setLocation(0, 0);

        // Añadir el JLabel al escritorio en la capa más baja
        pantalla.add(fondo, new Integer(Integer.MIN_VALUE));

        // Actualizar tamaño si se redimensiona la ventana
        pantalla.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                fondo.setSize(pantalla.getSize());
            }
        });

    }
}
