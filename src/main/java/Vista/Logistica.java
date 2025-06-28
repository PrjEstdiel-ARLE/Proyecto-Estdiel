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
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemCerrar = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();
        menuLogistica = new javax.swing.JMenu();
        itemProducts = new javax.swing.JMenuItem();
        menuSalidas = new javax.swing.JMenu();
        itemSolicitarSalida = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pantalla.setBackground(new java.awt.Color(239, 228, 210));

        lblBienvenida.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 65)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(137, 6, 6));
        lblBienvenida.setText("Mensaje");

        pantalla.setLayer(lblBienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pantallaLayout = new javax.swing.GroupLayout(pantalla);
        pantalla.setLayout(pantallaLayout);
        pantallaLayout.setHorizontalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaLayout.createSequentialGroup()
                .addGap(375, 375, 375)
                .addComponent(lblBienvenida)
                .addContainerGap(411, Short.MAX_VALUE))
        );
        pantallaLayout.setVerticalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(lblBienvenida)
                .addContainerGap(338, Short.MAX_VALUE))
        );

        menuArchivo.setText("Archivo");
        menuArchivo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

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
        IFProductosEmpleado pEm = new IFProductosEmpleado();
        cargarIF(pEm);
    }//GEN-LAST:event_itemProductsActionPerformed

    private void itemSolicitarSalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSolicitarSalidaActionPerformed
        IFSolicitarSalida SS = new IFSolicitarSalida();
        cargarIF(SS);
    }//GEN-LAST:event_itemSolicitarSalidaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem itemCerrar;
    private javax.swing.JMenuItem itemProducts;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuItem itemSolicitarSalida;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuLogistica;
    private javax.swing.JMenu menuSalidas;
    private javax.swing.JDesktopPane pantalla;
    // End of variables declaration//GEN-END:variables

    private void cargarIF(JInternalFrame internal) {
        pantalla.add(internal);
        internal.show();
    }

    private String colocarBienvenida() {
        return "Bienvenido " + userActual.getNombres() + " " + userActual.getApellidos();
    }
}
