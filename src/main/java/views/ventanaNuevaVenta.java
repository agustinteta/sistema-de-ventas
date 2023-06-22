package views;

import models.Cliente;
import models.Producto;
import models.Usuario;
import models.OrdenDeVenta;
import models.OrdenItem;
import controller.ControladorCliente;
import controller.ControladorUsuario;
import controller.ControladorProducto;
import controller.ControladorOrdenItem;
import controller.ControladorOrdenDeVenta;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.PuntoDeVenta;
import models.TipoOrden;
import services.PDFGenerator;

public class VentanaNuevaVenta extends javax.swing.JFrame {

    private ControladorCliente controladorCliente = new ControladorCliente();
    private ControladorUsuario controladorUsuario = new ControladorUsuario();
    private ControladorProducto controladorProducto = new ControladorProducto();
    private ControladorOrdenItem controladorOrdenItem = new ControladorOrdenItem();
    private ControladorOrdenDeVenta controladorOrdenDeVenta = new ControladorOrdenDeVenta();
    private Usuario usuario;

    public VentanaNuevaVenta(Usuario user) {
        initComponents();
        definirTabla();
        cargarComboBoxTipoOrden();
        usuario = user;
        jLabelVendedor.setText(usuario.getNombre() + " " + usuario.getApellido());
        this.setLocationRelativeTo(this);
        this.setTitle("Sistema de ventas - Modulo de venta");

    }

    private void cargarComboBoxTipoOrden() {
        EntityManager manager;
        EntityManagerFactory emf;
        emf = Persistence.createEntityManagerFactory("BDD");
        manager = emf.createEntityManager();

        DefaultComboBoxModel<TipoOrden> comboBoxModel = new DefaultComboBoxModel<>();

        List<TipoOrden> resultados = (List<TipoOrden>) manager.createQuery("SELECT t FROM TipoOrden t").getResultList();
        for (TipoOrden p : resultados) {
            comboBoxModel.addElement(p);
        }
        jComboBoxTipoOrden.setModel(comboBoxModel);
    }

    private void definirTabla() {
        DefaultTableModel model = new DefaultTableModel(null, new Object[]{"ID", "NOMBRE", "DESC.", "PRECIO", "CANTIDAD", "TOTAL"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        jTableProductos.setModel(model);
    }

    private void agregarProductoTabla(Producto p, int cantidad) {
        DefaultTableModel model = (DefaultTableModel) jTableProductos.getModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            if (jTableProductos.getValueAt(i, 1).equals(jLabelNombreProd.getText())) {
                JOptionPane.showMessageDialog(null, "El producto ya se encuentra en la tabla.");
                return;
            }
        }
        model.addRow(new Object[]{p.getId(), p.getNombre(), p.getDescripcion(), p.getPrecio(), cantidad, p.getPrecio() * cantidad});
        calcularTotalTabla();
    }

    private double calcularTotalTabla() {
        DefaultTableModel model = (DefaultTableModel) jTableProductos.getModel();
        double total = 0;
        double valor = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            valor = (Double) jTableProductos.getValueAt(i, 5);
            total += valor;
        }
        jLabelPrecioTotal.setText(Double.toString(total));
        return total;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabeltitulo = new javax.swing.JLabel();
        jLabelDNI = new javax.swing.JLabel();
        jTxtDNI = new javax.swing.JTextField();
        jButtonBuscarCliente = new javax.swing.JButton();
        jLabelCliente = new javax.swing.JLabel();
        jTxtCorreo = new javax.swing.JTextField();
        jLabelDireccion = new javax.swing.JLabel();
        jTxtTelf = new javax.swing.JTextField();
        jLabelCodProducto = new javax.swing.JLabel();
        jTxtIDProd = new javax.swing.JTextField();
        jButtonBuscarProducto = new javax.swing.JButton();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabelStock = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelCantidad = new javax.swing.JLabel();
        jTxtCantidad = new javax.swing.JTextField();
        jButtonAgregarProducto = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButtonGenerarVenta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTxtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtApellido = new javax.swing.JTextField();
        jLabelCliente1 = new javax.swing.JLabel();
        jLabelDescripcionProd = new javax.swing.JLabel();
        jLabelPrecioProd = new javax.swing.JLabel();
        jLabelStockProd = new javax.swing.JLabel();
        jLabelPrecioTotal = new javax.swing.JLabel();
        jLabelVendedor = new javax.swing.JLabel();
        jLabelDescripcion1 = new javax.swing.JLabel();
        jLabelNombreProd = new javax.swing.JLabel();
        jComboBoxTipoOrden = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabeltitulo.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        jLabeltitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeltitulo.setText("Ventas");

        jLabelDNI.setText("N° DNI");

        jButtonBuscarCliente.setBackground(new java.awt.Color(0, 204, 255));
        jButtonBuscarCliente.setText("Buscar");
        jButtonBuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarClienteActionPerformed(evt);
            }
        });

        jLabelCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelCliente.setText("CLIENTE");

        jLabelDireccion.setText("Apellido");

        jLabelCodProducto.setText("ID");

        jButtonBuscarProducto.setBackground(new java.awt.Color(0, 204, 255));
        jButtonBuscarProducto.setText("Buscar");
        jButtonBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarProductoActionPerformed(evt);
            }
        });

        jLabelDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDescripcion.setText("Descripcion");

        jLabelStock.setText("Stock");

        jLabelPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPrecio.setText("Precio");

        jLabelCantidad.setText("Cantidad");

        jButtonAgregarProducto.setBackground(new java.awt.Color(0, 204, 255));
        jButtonAgregarProducto.setText("Agregar");
        jButtonAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarProductoActionPerformed(evt);
            }
        });

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NRO", "COD", "Descripcion", "Cant.", "Prec.Unit.", "Total"
            }
        ));
        jScrollPane2.setViewportView(jTableProductos);
        if (jTableProductos.getColumnModel().getColumnCount() > 0) {
            jTableProductos.getColumnModel().getColumn(0).setMaxWidth(50);
            jTableProductos.getColumnModel().getColumn(1).setMaxWidth(50);
            jTableProductos.getColumnModel().getColumn(2).setMaxWidth(400);
            jTableProductos.getColumnModel().getColumn(3).setMaxWidth(50);
            jTableProductos.getColumnModel().getColumn(4).setMaxWidth(100);
            jTableProductos.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        jLabel10.setText("Vendedor");

        jLabel13.setText("Precio Total");

        jButtonGenerarVenta.setBackground(new java.awt.Color(0, 204, 102));
        jButtonGenerarVenta.setText("Generar Venta");
        jButtonGenerarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenerarVentaActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Correo");

        jLabel3.setText("Telf");

        jLabelCliente1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelCliente1.setText("PRODUCTO");

        jLabelDescripcionProd.setText("Label de descripcion");

        jLabelPrecioProd.setText("Label de precio");

        jLabelStockProd.setText("Label de stock");

        jLabelPrecioTotal.setText("Label de precio total");

        jLabelVendedor.setText("Label de vendedor");

        jLabelDescripcion1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDescripcion1.setText("Nombre");

        jLabelNombreProd.setText("Label de nombre");

        jComboBoxTipoOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoOrdenActionPerformed(evt);
            }
        });

        jLabel11.setText("Tipo de orden");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabelDescripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelDescripcionProd, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelDNI)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTxtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonBuscarCliente))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelCodProducto)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTxtIDProd, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonBuscarProducto))))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabeltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel2)
                                                .addComponent(jLabel1))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabelDireccion))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelPrecioProd, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabelStock, javax.swing.GroupLayout.Alignment.TRAILING)))))
                                        .addComponent(jLabelPrecio))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelDescripcion1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelNombreProd, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabelCantidad)))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTxtTelf)
                                        .addComponent(jTxtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonAgregarProducto))
                                    .addComponent(jLabelStockProd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(17, 29, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelVendedor)
                                    .addComponent(jComboBoxTipoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelPrecioTotal))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonGenerarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(258, 258, 258))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelCliente1))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabeltitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabelCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscarCliente)
                            .addComponent(jLabelDNI)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabelDireccion)
                            .addComponent(jTxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTxtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtTelf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabelCliente1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCodProducto)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonBuscarProducto)
                        .addComponent(jLabelStock)
                        .addComponent(jTxtIDProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelPrecio)
                        .addComponent(jLabelPrecioProd)
                        .addComponent(jLabelStockProd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCantidad)
                    .addComponent(jTxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAgregarProducto)
                    .addComponent(jLabelDescripcion)
                    .addComponent(jLabelDescripcionProd)
                    .addComponent(jLabelDescripcion1)
                    .addComponent(jLabelNombreProd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(jLabelPrecioTotal)
                    .addComponent(jLabelVendedor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGenerarVenta)
                    .addComponent(jComboBoxTipoOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(119, 119, 119))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarClienteActionPerformed
        String dni = jTxtDNI.getText();
        Cliente cliente = controladorCliente.buscarClienteDNI(dni);

        if (cliente != null) {
            jTxtNombre.setText(cliente.getNombre());
            jTxtApellido.setText(cliente.getApellido());
            jTxtCorreo.setText(cliente.getCorreo());
            jTxtTelf.setText(cliente.getCelular());
        }

    }//GEN-LAST:event_jButtonBuscarClienteActionPerformed

    private void jButtonBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarProductoActionPerformed
        String idProducto = jTxtIDProd.getText();
        Producto producto = controladorProducto.buscarProducto(Integer.parseInt(idProducto));

        if (producto != null) {
            jLabelPrecioProd.setText(Double.toString(producto.getPrecio()));
            jLabelStockProd.setText(Integer.toString(producto.getStock()));
            jLabelNombreProd.setText(producto.getNombre());
            jLabelDescripcionProd.setText(producto.getDescripcion());
        }
    }//GEN-LAST:event_jButtonBuscarProductoActionPerformed

    private void jButtonAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarProductoActionPerformed
        String idProducto = jTxtIDProd.getText();
        Producto producto = controladorProducto.buscarProducto(Integer.parseInt(idProducto));
        int cantidad = Integer.parseInt(jTxtCantidad.getText());

        if (cantidad <= producto.getStock() && cantidad > 0) {
            controladorProducto.actualizarProducto(Integer.parseInt(idProducto), cantidad);
            agregarProductoTabla(producto, cantidad);
            jLabelStockProd.setText(Integer.toString(producto.getStock() - cantidad));
            jTxtIDProd.setText("");
            jTxtCantidad.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "La cantidad solicitada supera el stock del producto");
        }

    }//GEN-LAST:event_jButtonAgregarProductoActionPerformed

    private void jButtonGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenerarVentaActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableProductos.getModel();
        int numRows = model.getRowCount();
        int idProducto = 0;
        int cantidad = 0;
        double precio = 0;
        double precioTotal = Double.parseDouble(jLabelPrecioTotal.getText());

        try {
            TipoOrden tipoOrden = (TipoOrden) jComboBoxTipoOrden.getSelectedItem();
            Date fechaCreacion = Calendar.getInstance().getTime();
            String dni = jTxtDNI.getText();
            if ("".equals(dni)) {
                JOptionPane.showMessageDialog(null, "Debe completar los datos del cliente antes de continuar");
                return;
            }
            Cliente cliente = controladorCliente.buscarClienteDNI(dni);
            if (cliente == null) {
                String nombre = jTxtNombre.getText();
                String apellido = jTxtApellido.getText();
                String correo = jTxtCorreo.getText();
                String telf = jTxtTelf.getText();
                controladorCliente.agregarCliente(nombre, apellido, dni, telf, correo);
                cliente = controladorCliente.buscarClienteDNI(dni);
            }
            PuntoDeVenta pos = usuario.getPunto_de_venta();
            controladorOrdenDeVenta.agregarOrden(fechaCreacion, tipoOrden, pos, precioTotal, cliente);
            OrdenDeVenta orden = controladorOrdenDeVenta.obtenerUltimaOrden();

            List<OrdenItem> listaItems = new ArrayList<>();
            for (int row = 0; row < numRows; row++) {
                idProducto = (int) jTableProductos.getValueAt(row, 0);
                cantidad = (int) jTableProductos.getValueAt(row, 4);
                precio = (double) jTableProductos.getValueAt(row, 3);
                Producto producto = controladorProducto.buscarProducto(idProducto);
                OrdenItem oi = new OrdenItem(producto, orden, cantidad, precio);
                listaItems.add(oi);
                controladorOrdenItem.agregarOrdenItem(producto, orden, cantidad, precio);
            }
            PDFGenerator pdf = new PDFGenerator();
            pdf.crearPDFOrdenDeVenta(cliente, listaItems, usuario, orden);
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al realizar la venta." + e);

        }


    }//GEN-LAST:event_jButtonGenerarVentaActionPerformed

    private void jComboBoxTipoOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxTipoOrdenActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaNuevaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaNuevaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaNuevaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaNuevaVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario user = null;
                new VentanaNuevaVenta(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarProducto;
    private javax.swing.JButton jButtonBuscarCliente;
    private javax.swing.JButton jButtonBuscarProducto;
    private javax.swing.JButton jButtonGenerarVenta;
    private javax.swing.JComboBox<TipoOrden> jComboBoxTipoOrden;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelCliente1;
    private javax.swing.JLabel jLabelCodProducto;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelDescripcion1;
    private javax.swing.JLabel jLabelDescripcionProd;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelNombreProd;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelPrecioProd;
    private javax.swing.JLabel jLabelPrecioTotal;
    private javax.swing.JLabel jLabelStock;
    private javax.swing.JLabel jLabelStockProd;
    private javax.swing.JLabel jLabelVendedor;
    private javax.swing.JLabel jLabeltitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextField jTxtApellido;
    private javax.swing.JTextField jTxtCantidad;
    private javax.swing.JTextField jTxtCorreo;
    private javax.swing.JTextField jTxtDNI;
    private javax.swing.JTextField jTxtIDProd;
    private javax.swing.JTextField jTxtNombre;
    private javax.swing.JTextField jTxtTelf;
    // End of variables declaration//GEN-END:variables
}
