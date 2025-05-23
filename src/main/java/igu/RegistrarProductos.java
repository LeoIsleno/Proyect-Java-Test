package igu;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Celulares;
import logica.Controladora;
import logica.Productos;
import logica.UsuarioSingleton;
import logica.Usuarios;

public class RegistrarProductos extends JInternalFrame {

    //Textos
    String mensajeInfo = "Info";
    String mensajeError = "Error";
    String vacio = "No hay nada en su tabla";
    String campoVacio = "No se ha insertado ningun codigo";
    String itemNoSeleccionado = "No seleccionó ningún ítem";
    String mensajeEliminacion = "Se eliminó el celular";
    String mensajeEditado = "Se Edito el Producto";
    String tituloEliminar = "Eliminar";
    String Alerta = "Alerta";

    //Variables 
    Controladora control = null;
    Productos prod;
    Boolean flagEdicion = false;

    public RegistrarProductos() {
        initComponents();
        control = new Controladora();

        //Traer todos los datos de las tablas
        CargarTabla();

        //Botones aceptar, eliminar, txt id, txt stock 
        setBotonesFalse();

        //Permisos de edicion y eliminar unicamente para Jefe
        initPermision();

        //Cerrar el JFrame
        setClosable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void CargarTabla() {
        //Definir Modelo de tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {

            //Seteamos filas y columnsa no es editable 
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        //Creamos el objeto de la tabla con sus titulos
        String titulos[] = {"ID", "Codigo", "Nombre", "Categoria", "Stock", "Precio"};

        //Seteamos la tabla con los titulos
        modeloTabla.setColumnIdentifiers(titulos);

        // Traer los datos de todos los celulares
        List<Productos> listaProductos = control.traerProductos();

        //Recorremos la lista y mostrar cada uno de los elementos en la tabla
        if (listaProductos != null) {
            for (Productos prod : listaProductos) {
                Object[] objProductos = {
                    prod.getId(),
                    prod.getCodigo(),
                    prod.getNombre(),
                    prod.getCategoria(),
                    prod.getStock(),
                    prod.getPrecioUnitario()};
                //Las añadimos a la tabla
                modeloTabla.addRow(objProductos);
            }
        }
        //Asignamos a la tabla el modelo de tabla creado
        tabla_productos.setModel(modeloTabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_Codigo = new javax.swing.JTextField();
        txt_Costo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_Precio = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        comb_Categoria = new javax.swing.JComboBox<>();
        btn_Aceptar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_stock = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btn_Editar = new javax.swing.JButton();
        btn_Registrar = new javax.swing.JButton();
        btn_Eliminar = new javax.swing.JButton();
        btn_Limpiar = new javax.swing.JButton();
        btn_AggStock = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_productos = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        txt_busqueda = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Registrar Producto"));

        jLabel1.setText("Codigo");

        jLabel4.setText("Costo");

        jLabel5.setText("Precio");

        jLabel6.setText("Categoria");

        comb_Categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Funda", "Vidrio", "Cargador", "Cable" }));

        btn_Aceptar.setText("Aceptar");
        btn_Aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AceptarActionPerformed(evt);
            }
        });

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        jLabel8.setText("Identificador");

        jLabel9.setText("Nombre");

        jLabel10.setText("Stock");

        txt_stock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(btn_Aceptar)
                .addGap(18, 18, 18)
                .addComponent(btn_Cancelar)
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_stock)
                            .addComponent(txt_Codigo)
                            .addComponent(comb_Categoria, 0, 201, Short.MAX_VALUE)
                            .addComponent(txt_Costo))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(comb_Categoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_Costo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_stock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Aceptar)
                    .addComponent(btn_Cancelar))
                .addContainerGap())
        );

        comb_Categoria.getAccessibleContext().setAccessibleName("comboBox_Categoria");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Funciones"));

        btn_Editar.setText("Editar");
        btn_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditarActionPerformed(evt);
            }
        });

        btn_Registrar.setText("Registrar");
        btn_Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RegistrarActionPerformed(evt);
            }
        });

        btn_Eliminar.setText("Eliminar");
        btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EliminarActionPerformed(evt);
            }
        });

        btn_Limpiar.setText("Limpiar");
        btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LimpiarActionPerformed(evt);
            }
        });

        btn_AggStock.setText("Agregar Stock");
        btn_AggStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AggStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_Registrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Editar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Limpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_AggStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btn_Registrar)
                .addGap(18, 18, 18)
                .addComponent(btn_Editar)
                .addGap(18, 18, 18)
                .addComponent(btn_Eliminar)
                .addGap(18, 18, 18)
                .addComponent(btn_Limpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_AggStock)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_productos);

        jButton6.setText("Buscar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel7.setText("Buscar:");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_busqueda))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(txt_busqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EliminarActionPerformed
        EliminarProducto();
    }//GEN-LAST:event_btn_EliminarActionPerformed

    private void btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LimpiarActionPerformed
        limpiarCajaTexto();
    }//GEN-LAST:event_btn_LimpiarActionPerformed

    private void btn_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditarActionPerformed
        EditarProducto();
        setBotonesTrue();
        setFuncionesFalse();
    }//GEN-LAST:event_btn_EditarActionPerformed

    private void btn_AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AceptarActionPerformed
        if (flagEdicion) {
            registrarEdicion();
        } else {
            registrarNuevoProducto();
        }
        setBotonesFalse();
        setFuncionesTrue();
    }//GEN-LAST:event_btn_AceptarActionPerformed

    private void btn_RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RegistrarActionPerformed
        limpiarCajaTexto();
        setBotonesTrue();
        setFuncionesFalse();
    }//GEN-LAST:event_btn_RegistrarActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        limpiarCajaTexto();
        setBotonesFalse();
        setFuncionesTrue();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        buscarProducto();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CargarTabla();
        txt_busqueda.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_stockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stockActionPerformed

    private void btn_AggStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AggStockActionPerformed
        agregarStock();
    }//GEN-LAST:event_btn_AggStockActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Aceptar;
    private javax.swing.JButton btn_AggStock;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Editar;
    private javax.swing.JButton btn_Eliminar;
    private javax.swing.JButton btn_Limpiar;
    private javax.swing.JButton btn_Registrar;
    private javax.swing.JComboBox<String> comb_Categoria;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla_productos;
    private javax.swing.JTextField txt_Codigo;
    private javax.swing.JTextField txt_Costo;
    private javax.swing.JTextField txt_Precio;
    private javax.swing.JTextField txt_busqueda;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_stock;
    // End of variables declaration//GEN-END:variables

    private void EditarProducto() {
        flagEdicion = true;
        // Verificar si la tabla no está vacía
        if (tabla_productos.getRowCount() > 0) {
            // Verificar si se ha seleccionado una fila
            if (tabla_productos.getSelectedRow() != -1) {

                setFuncionesFalse();

                btn_Cancelar.setEnabled(true);
                btn_Aceptar.setEnabled(true);

                //Obtenes el ID del celular seleccionado
                int id_Producto = Integer.parseInt(String.valueOf(tabla_productos.getValueAt(tabla_productos.getSelectedRow(), 0)));

                //Nos devuelve todos los atributos del celular solicitado
                prod = control.traerProductosBuscado(id_Producto);

                //Seteamos los valores en la IGU
                txt_id.setText(String.valueOf(prod.getId()));
                txt_Codigo.setText(prod.getCodigo());
                comb_Categoria.setSelectedIndex(SeterCategoria(prod.getCategoria()));
                txt_nombre.setText(prod.getNombre());
                txt_Costo.setText(String.valueOf(prod.getCosto()));
                txt_stock.setText(String.valueOf(prod.getStock()));
                txt_Precio.setText(String.valueOf(prod.getPrecioUnitario()));

            } else {
                // Mensaje de alerta: no se seleccionó ninguna fila
                Utilidades.MostrarMensaje(itemNoSeleccionado, mensajeInfo, Alerta);
            }
        } else {
            // Mensaje de alerta: tabla vacía
            Utilidades.MostrarMensaje(vacio, mensajeInfo, Alerta);
        }

        // Volver a inicializar la tabla para mostrar nuevamente los datos
        CargarTabla();
    }

    private int SeterCategoria(String cat) {
        switch (cat) {

            case "Funda" -> {
                return 1;
            }
            case "Vidrio" -> {
                return 2;
            }
            case "Cargador" -> {
                return 3;
            }
            case "Cable" -> {
                return 4;
            }
            default ->
                throw new AssertionError();
        }
    }

    private void registrarEdicion() {
        prod.setCodigo(txt_Codigo.getText());
        prod.setNombre(txt_nombre.getText());
        prod.setStock(Integer.parseInt(txt_stock.getText()));
        prod.setCategoria(comb_Categoria.getSelectedItem().toString());
        prod.setCosto(Integer.parseInt(txt_Costo.getText()));
        prod.setPrecioUnitario(Integer.parseInt(txt_Precio.getText()));

        control.actualizarProducto(prod);

        setBotonesFalse();
        limpiarCajaTexto();
        CargarTabla();
        flagEdicion = false;
    }

    private void registrarNuevoProducto() {
        txt_stock.setEditable(true);

        String codigo = txt_Codigo.getText();
        String categoria = comb_Categoria.getSelectedItem().toString();
        int costo = Integer.parseInt(txt_Costo.getText());
        int precio = Integer.parseInt(txt_Precio.getText());
        int stock = Integer.parseInt(txt_stock.getText());
        String nombre = txt_nombre.getText();

        if (codigo.equals("") || txt_Costo.getText().trim().equals("")
                || txt_Precio.getText().trim().equals("") || categoria.equals("-") || txt_stock.getText().trim().equals("") || nombre.equals("")) {

            Utilidades.MostrarMensaje("No se pueden cargar celdas vacias", "Error", Alerta);

        } else {
            control.registrarProducto(codigo, categoria, costo, precio, stock, nombre);
            Utilidades.MostrarMensaje("Se guardo exitosamente", "Info", "Guardado");

            //Limpiamos las cajas de texto
            CargarTabla();
        }

        limpiarCajaTexto();
        setFuncionesTrue();

        txt_stock.setEditable(false);
    }

    private void setBotonesFalse() {
        txt_id.setEditable(false);
        txt_stock.setEnabled(false);
        btn_Aceptar.setEnabled(false);
        btn_Cancelar.setEnabled(false);
    }

    private void setBotonesTrue() {
        btn_Aceptar.setEnabled(true);
        btn_Cancelar.setEnabled(true);
        txt_stock.setEnabled(true);
    }

    private void setFuncionesTrue() {
        btn_Registrar.setEnabled(true);
        btn_Editar.setEnabled(true);
    }

    private void setFuncionesFalse() {
        btn_Registrar.setEnabled(false);
        btn_Editar.setEnabled(false);
    }

    private void limpiarCajaTexto() {
        txt_id.setText("");
        txt_Codigo.setText("");
        txt_Costo.setText("");
        txt_Precio.setText("");
        txt_stock.setText("");
        txt_nombre.setText("");
        comb_Categoria.setSelectedIndex(0);
    }

    private void EliminarProducto() {
        // Verificar si la tabla no está vacía
        if (tabla_productos.getRowCount() > 0) {
            // Verificar si se ha seleccionado una fila
            if (tabla_productos.getSelectedRow() != -1) {

                //Obtenes el ID del celular seleccionado
                int id_Producto = Integer.parseInt(String.valueOf(tabla_productos.getValueAt(tabla_productos.getSelectedRow(), 0)));

                //Eliminamos el producto
                control.EliminarProducto(id_Producto);

                // Mensaje de eliminacion
                Utilidades.MostrarMensaje("Se elimino un producto", mensajeInfo, tituloEliminar);

            } else {
                // Mensaje de alerta: no se seleccionó ninguna fila
                Utilidades.MostrarMensaje(itemNoSeleccionado, mensajeInfo, Alerta);
            }
        } else {
            // Mensaje de alerta: tabla vacía
            Utilidades.MostrarMensaje(vacio, mensajeInfo, Alerta);
        }

        // Volver a inicializar la tabla para mostrar nuevamente los datos
        CargarTabla();
    }

    private void initPermision() {
        Usuarios usuarioActual = UsuarioSingleton.getInstance();

        if (!"Fabian-Jefe".equals(usuarioActual.getNombreVendedor())) {
            btn_Eliminar.setEnabled(false);
            btn_Editar.setEnabled(false);
        } else {
            btn_Eliminar.setEnabled(true);
            btn_Editar.setEnabled(true);
        }
    }

    private void buscarProducto() {
        // Definir modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Definir títulos de la tabla
        String titulos[] = {"ID", "Nombre", "Código", "Categoría", "Stock", "Precio"};
        modeloTabla.setColumnIdentifiers(titulos);

        // Obtener el código buscado
        String codigo = txt_busqueda.getText().trim(); // Elimina espacios innecesarios

        // Verificar si el campo está vacío
        if (codigo.isEmpty()) {
            Utilidades.MostrarMensaje("El campo de búsqueda está vacío", "Información", "Alerta");
            return; // Sale del método
        }

        // Simulación: Obtener productos desde la base de datos o una lista global
        List<Productos> listProductos = control.traerProductos(); // Debe existir este método

        // Recorrer la lista y buscar coincidencias
        for (Productos prod : listProductos) {
            if (prod.getCodigo().equals(codigo)) { // Comparar correctamente Strings
                Object[] objProductos = {
                    prod.getId(),
                    prod.getNombre(),
                    prod.getCodigo(),
                    prod.getCategoria(),
                    prod.getStock(),
                    prod.getPrecioUnitario()
                };
                modeloTabla.addRow(objProductos);
            }
        }
        tabla_productos.setModel(modeloTabla);
        // Asignar el modelo a la tabla (asegúrate de que la tabla existe en tu UI)

    }

    private void agregarStock() {
        if (tabla_productos.getRowCount() > 0) {
            // Verificar si se ha seleccionado una fila
            if (tabla_productos.getSelectedRow() != -1) {

                //Obtenes el ID del producto seleccionado
                int id_Producto = Integer.parseInt(String.valueOf(tabla_productos.getValueAt(tabla_productos.getSelectedRow(), 0)));

                //Nos devuelve todos los atributos del celular solicitado
                prod = control.traerProductosBuscado(id_Producto);

                boolean inputValido = false;
                int cantNuevo = 0;

                while (!inputValido) {
                    String input = JOptionPane.showInputDialog("Ingresá la cantidad que desees agregar al Stock");

                    if (input == null) {
                        // El usuario apretó cancelar
                        return;
                    }

                    try {
                        cantNuevo = Integer.parseInt(input);
                        if (cantNuevo < 0) {
                            JOptionPane.showMessageDialog(null, "Por favor, ingresá un número positivo.");
                        } else {
                            inputValido = true;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: solo se permiten números enteros.");
                    }
                }

                int cantReal = prod.getStock();

                prod.setStock(cantNuevo + cantReal);
                control.actualizarProducto(prod);

            } else {
                // Mensaje de alerta: no se seleccionó ninguna fila
                Utilidades.MostrarMensaje(itemNoSeleccionado, mensajeInfo, Alerta);
            }
        } else {
            // Mensaje de alerta: tabla vacía
            Utilidades.MostrarMensaje(vacio, mensajeInfo, Alerta);
        }

        CargarTabla();
    }
}
