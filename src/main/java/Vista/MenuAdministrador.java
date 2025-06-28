package Vista;

import Extras.Mensajes;
import Modelo.Usuario;
import javax.swing.JInternalFrame;

public class MenuAdministrador extends javax.swing.JFrame {

    private final Usuario userActual;

    public MenuAdministrador(Usuario usuario) {
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
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        lblBienvenida = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemCerrar = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        itemSalir = new javax.swing.JMenuItem();
        menuGestion = new javax.swing.JMenu();
        itemProductos = new javax.swing.JMenuItem();
        itemProveedores = new javax.swing.JMenuItem();
        itemCategorias = new javax.swing.JMenuItem();
        itemUsuarios = new javax.swing.JMenuItem();
        menuInventario = new javax.swing.JMenu();
        itemLotes = new javax.swing.JMenuItem();
        itemFiltro = new javax.swing.JMenuItem();
        menuLogistica = new javax.swing.JMenu();
        itemRegistrarPedido = new javax.swing.JMenuItem();
        itemVerPedidos = new javax.swing.JMenuItem();
        itemSalidas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pantalla.setBackground(new java.awt.Color(239, 228, 210));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblBienvenida.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 65)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(137, 6, 6));
        lblBienvenida.setText("Mensaje");

        pantalla.setLayer(jSeparator3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(lblBienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pantallaLayout = new javax.swing.GroupLayout(pantalla);
        pantalla.setLayout(pantallaLayout);
        pantallaLayout.setHorizontalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaLayout.createSequentialGroup()
                .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pantallaLayout.createSequentialGroup()
                        .addGap(922, 922, 922)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pantallaLayout.createSequentialGroup()
                        .addGap(416, 416, 416)
                        .addComponent(lblBienvenida)))
                .addContainerGap(1670, Short.MAX_VALUE))
            .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pantallaLayout.createSequentialGroup()
                    .addGap(0, 687, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1905, Short.MAX_VALUE)))
            .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pantallaLayout.createSequentialGroup()
                    .addGap(0, 687, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1905, Short.MAX_VALUE)))
        );
        pantallaLayout.setVerticalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pantallaLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(lblBienvenida)
                .addGap(383, 383, 383)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 244, Short.MAX_VALUE))
            .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pantallaLayout.createSequentialGroup()
                    .addGap(0, 334, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 334, Short.MAX_VALUE)))
            .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pantallaLayout.createSequentialGroup()
                    .addGap(0, 334, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 334, Short.MAX_VALUE)))
        );

        MenuBar.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N

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
        menuArchivo.add(jSeparator4);

        itemSalir.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(itemSalir);

        MenuBar.add(menuArchivo);

        menuGestion.setText("Gestión");
        menuGestion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        itemProductos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemProductos.setText("Productos");
        itemProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProductosActionPerformed(evt);
            }
        });
        menuGestion.add(itemProductos);

        itemProveedores.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemProveedores.setText("Proveedores");
        itemProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProveedoresActionPerformed(evt);
            }
        });
        menuGestion.add(itemProveedores);

        itemCategorias.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemCategorias.setText("Categorías");
        itemCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCategoriasActionPerformed(evt);
            }
        });
        menuGestion.add(itemCategorias);

        itemUsuarios.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemUsuarios.setText("Usuarios");
        itemUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemUsuariosActionPerformed(evt);
            }
        });
        menuGestion.add(itemUsuarios);

        MenuBar.add(menuGestion);

        menuInventario.setText("Inventario");
        menuInventario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        itemLotes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemLotes.setText("Lotes");
        itemLotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLotesActionPerformed(evt);
            }
        });
        menuInventario.add(itemLotes);

        itemFiltro.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemFiltro.setText("Filtro de Productos");
        itemFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemFiltroActionPerformed(evt);
            }
        });
        menuInventario.add(itemFiltro);

        MenuBar.add(menuInventario);

        menuLogistica.setText("Logística");
        menuLogistica.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        itemRegistrarPedido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemRegistrarPedido.setText("Registrar Pedido");
        itemRegistrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarPedidoActionPerformed(evt);
            }
        });
        menuLogistica.add(itemRegistrarPedido);

        itemVerPedidos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemVerPedidos.setText("Ver Pedidos");
        itemVerPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVerPedidosActionPerformed(evt);
            }
        });
        menuLogistica.add(itemVerPedidos);

        itemSalidas.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemSalidas.setText("Salidas");
        itemSalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalidasActionPerformed(evt);
            }
        });
        menuLogistica.add(itemSalidas);

        MenuBar.add(menuLogistica);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pantalla)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pantalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void itemCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarActionPerformed
        boolean conf = Mensajes.confirmar("¿Desea cerrar sesión?");
        if (conf) {
            Login lo = new Login();
            lo.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_itemCerrarActionPerformed

    private void itemProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProductosActionPerformed
        IFProductos prod = new IFProductos(pantalla);
        cargarIF(prod);
    }//GEN-LAST:event_itemProductosActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        boolean conf = Mensajes.confirmar("¿Desea cerrar la ventana completa?");
        if (conf) {
            this.dispose();
        }
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemProveedoresActionPerformed
        IFProveedores prov = new IFProveedores(pantalla);
        cargarIF(prov);
    }//GEN-LAST:event_itemProveedoresActionPerformed

    private void itemCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCategoriasActionPerformed
        IFCategorias cat = new IFCategorias(pantalla, true);
        cargarIF(cat);
    }//GEN-LAST:event_itemCategoriasActionPerformed

    private void itemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUsuariosActionPerformed
        IFUsuarios us = new IFUsuarios();
        cargarIF(us);
    }//GEN-LAST:event_itemUsuariosActionPerformed

    private void itemLotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLotesActionPerformed
        IFLotes lot = new IFLotes();
        cargarIF(lot);
    }//GEN-LAST:event_itemLotesActionPerformed

    private void itemFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemFiltroActionPerformed
        IFProductoProveedor PP = new IFProductoProveedor();
        cargarIF(PP);
    }//GEN-LAST:event_itemFiltroActionPerformed

    private void itemRegistrarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemRegistrarPedidoActionPerformed
        IFRegistrarPedido reg = new IFRegistrarPedido(pantalla);
        cargarIF(reg);
    }//GEN-LAST:event_itemRegistrarPedidoActionPerformed

    private void itemVerPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemVerPedidosActionPerformed
        IFPedidos ped = new IFPedidos(pantalla);
        cargarIF(ped);
    }//GEN-LAST:event_itemVerPedidosActionPerformed

    private void itemSalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalidasActionPerformed
        IFSalidasLote SL = new IFSalidasLote();
        cargarIF(SL);
    }//GEN-LAST:event_itemSalidasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem itemCategorias;
    private javax.swing.JMenuItem itemCerrar;
    private javax.swing.JMenuItem itemFiltro;
    private javax.swing.JMenuItem itemLotes;
    private javax.swing.JMenuItem itemProductos;
    private javax.swing.JMenuItem itemProveedores;
    private javax.swing.JMenuItem itemRegistrarPedido;
    private javax.swing.JMenuItem itemSalidas;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenuItem itemUsuarios;
    private javax.swing.JMenuItem itemVerPedidos;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JLabel lblBienvenida;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuGestion;
    private javax.swing.JMenu menuInventario;
    private javax.swing.JMenu menuLogistica;
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
