package Vista;

import Extras.Mensajes;
import Modelo.Usuario;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

public class MenuAdministrador extends javax.swing.JFrame {

    private Usuario userAct;

    public MenuAdministrador(Usuario usuario) {
        initComponents();
        colocarFondoPantalla();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //control jdesktoppane se cambio de nombre por ESCRITORIO
        this.setContentPane(this.pantalla);
        this.userAct = usuario;
        lblBienvenida.setText(colocarBienvenida());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pantalla = new javax.swing.JDesktopPane();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jToolBar2 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        icono = new javax.swing.JLabel();
        lblBienvenida = new javax.swing.JLabel();
        MenuBar = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemCambio = new javax.swing.JMenuItem();
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
        setTitle("Gestor de Logística para Papelería 'Estdiel' - Administrador");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        pantalla.setBackground(new java.awt.Color(239, 228, 210));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jToolBar2.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ToolLogo_Prod.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ToolLogo_Prove.png"))); // NOI18N
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ToolLogo_Categoria.png.png"))); // NOI18N
        jButton3.setToolTipText("");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton3);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ToolLogo_config.png"))); // NOI18N
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton4);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ToolLogo_Lotes.png"))); // NOI18N
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton5);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ToolLogo_Detalle.png"))); // NOI18N
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ToolLogo_Prod_Prov.png"))); // NOI18N
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton7);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ToolLogo_Salida_Lotes.png"))); // NOI18N
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jToolBar2.add(jButton8);

        lblBienvenida.setFont(new java.awt.Font("PMingLiU-ExtB", 1, 65)); // NOI18N
        lblBienvenida.setForeground(new java.awt.Color(137, 6, 6));
        lblBienvenida.setText("Mensaje");

        pantalla.setLayer(jSeparator3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(jSeparator2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(jToolBar2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(icono, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pantalla.setLayer(lblBienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout pantallaLayout = new javax.swing.GroupLayout(pantalla);
        pantalla.setLayout(pantallaLayout);
        pantallaLayout.setHorizontalGroup(
            pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 2592, Short.MAX_VALUE)
            .addGroup(pantallaLayout.createSequentialGroup()
                .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pantallaLayout.createSequentialGroup()
                        .addGap(226, 226, 226)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pantallaLayout.createSequentialGroup()
                        .addGap(587, 587, 587)
                        .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pantallaLayout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(lblBienvenida)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(lblBienvenida)
                .addGap(135, 135, 135)
                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 507, Short.MAX_VALUE))
            .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pantallaLayout.createSequentialGroup()
                    .addGap(0, 430, Short.MAX_VALUE)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 431, Short.MAX_VALUE)))
            .addGroup(pantallaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pantallaLayout.createSequentialGroup()
                    .addGap(0, 430, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 431, Short.MAX_VALUE)))
        );

        MenuBar.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 18)); // NOI18N

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
        menuArchivo.add(jSeparator4);

        itemSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.ALT_DOWN_MASK));
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

        itemProductos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemProductos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemProductos.setText("Productos");
        itemProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProductosActionPerformed(evt);
            }
        });
        menuGestion.add(itemProductos);

        itemProveedores.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemProveedores.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemProveedores.setText("Proveedores");
        itemProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemProveedoresActionPerformed(evt);
            }
        });
        menuGestion.add(itemProveedores);

        itemCategorias.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemCategorias.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemCategorias.setText("Categorías");
        itemCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCategoriasActionPerformed(evt);
            }
        });
        menuGestion.add(itemCategorias);

        itemUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
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

        itemLotes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemLotes.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemLotes.setText("Lotes");
        itemLotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLotesActionPerformed(evt);
            }
        });
        menuInventario.add(itemLotes);

        itemFiltro.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
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

        itemRegistrarPedido.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemRegistrarPedido.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemRegistrarPedido.setText("Registrar Pedido");
        itemRegistrarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemRegistrarPedidoActionPerformed(evt);
            }
        });
        menuLogistica.add(itemRegistrarPedido);

        itemVerPedidos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemVerPedidos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        itemVerPedidos.setText("Ver Pedidos");
        itemVerPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemVerPedidosActionPerformed(evt);
            }
        });
        menuLogistica.add(itemVerPedidos);

        itemSalidas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pantalla)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pantalla)
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
        IFProveedores prov = new IFProveedores(pantalla, jToolBar2);
        cargarIF(prov);
    }//GEN-LAST:event_itemProveedoresActionPerformed

    private void itemCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCategoriasActionPerformed
        IFCategorias cat = new IFCategorias(pantalla, true);
        cargarIF(cat);
    }//GEN-LAST:event_itemCategoriasActionPerformed

    private void itemUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemUsuariosActionPerformed
        IFUsuarios us = new IFUsuarios(pantalla, jToolBar2);
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        IFProductos prod = new IFProductos(pantalla);
        cargarIF(prod);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        IFProveedores prov = new IFProveedores(pantalla, jToolBar2);
        cargarIF(prov);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        IFCategorias cat = new IFCategorias(pantalla, true);
        cargarIF(cat);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        IFUsuarios us = new IFUsuarios(pantalla, jToolBar2);
        cargarIF(us);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        IFLotes lot = new IFLotes();
        cargarIF(lot);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        boolean conf = Mensajes.confirmar("¿Desea registrar un nuevo pedido?");
        if (!conf) {
            return;
        }
        IFRegistrarPedido reg = new IFRegistrarPedido(pantalla);
        cargarIF(reg);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        IFPedidos ped = new IFPedidos(pantalla);
        cargarIF(ped);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        IFSalidasLote SL = new IFSalidasLote();
        cargarIF(SL);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void itemCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCambioActionPerformed
        IFCambioPassword cpwd = new IFCambioPassword(userAct);
        cargarIF(cpwd);
    }//GEN-LAST:event_itemCambioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JLabel icono;
    private javax.swing.JMenuItem itemCambio;
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JToolBar jToolBar2;
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
        internal.setLocation(10, jToolBar2.getHeight() + 10);
    }

    private String colocarBienvenida() {
        return "Bienvenido " + userAct.getNombres() + " " + userAct.getApellidos();
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
