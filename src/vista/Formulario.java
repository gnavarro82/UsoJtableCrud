/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import conexion.Conexiones;
import java.sql.*;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Linde
 */
public class Formulario extends javax.swing.JFrame {

    PreparedStatement pstmt = null;
    DefaultTableModel dm;
    Conexiones cn = new Conexiones();
    Connection mconex = cn.getConnection();
    String atributo = "idusuario";

    public void cargarDatos() {
        try {
            DefaultTableModel modelo = new DefaultTableModel();
            String titulos[] = {"Codigo", "Nombre", "Apellidos", "Correo"};
            modelo.setColumnIdentifiers(titulos);
            tabla.setModel(modelo);

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/muestra", "root", "navarro");
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("select * from usuario");

            // Bucle para cada resultado en la consulta
            while (rs.next()) {
                // Se crea un array que será una de las filas de la tabla. 
                Object[] fila = new Object[4]; // Hay tres columnas en la tabla

                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i = 0; i < 4; i++) {
                    fila[i] = rs.getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
                }
                // Se añade al modelo la fila completa.
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
        }

    }

    private void filtro(String consulta, JTable jtableBuscar) {
        dm = (DefaultTableModel) jtableBuscar.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(dm);
        jtableBuscar.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(consulta));
    }

//    public void mostrarTabla(String Valor) {
//        try {
//            DefaultTableModel modelo = new DefaultTableModel();
//            String titulos[] = {"Codigo", "Nombre", "Apellidos", "Correo"};
//            modelo.setColumnIdentifiers(titulos);
//            tabla.setModel(modelo);
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/muestra", "root", "navarro");
//            Statement s = conexion.createStatement();
//            ResultSet rs = s.executeQuery("select * from usuario");
//            // Bucle para cada resultado en la consulta
//            while (rs.next()) {
//                // Se crea un array que será una de las filas de la tabla. 
//                Object[] fila = new Object[4]; // Hay tres columnas en la tabla
//
//                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
//                for (int i = 0; i < 4; i++) {
//                    fila[i] = rs.getObject(i + 1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
//                }
//                // Se añade al modelo la fila completa.
//                modelo.addRow(fila);
//            }
//            tabla.setModel(modelo);
//            String sql = "";
//            if (Valor.equals("")) {
//                sql = "select * from usuario";
//            } else {
//                sql = "select * from usuario where " + atributo + "='" + Valor + "'";
//
//            }
//        } catch (Exception e) {
//        }
//
//    }
    public void Limpiar() {
        txtapellido.setText("");
        txtcodigo.setText("");
        txtmail.setText("");
        txtnombre.setText("");
    }

    public Formulario() {
        initComponents();

        cargarDatos();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botones = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtmail = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnlimpiar = new javax.swing.JButton();
        btnprobar = new javax.swing.JButton();
        btninsert = new javax.swing.JButton();
        btnactualizar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        rbid = new javax.swing.JRadioButton();
        rbnombre = new javax.swing.JRadioButton();
        rbapellido = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Codigo");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("mail");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        btnprobar.setText("Probar Conexion");
        btnprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprobarActionPerformed(evt);
            }
        });

        btninsert.setText("Insertar");
        btninsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertActionPerformed(evt);
            }
        });

        btnactualizar.setText("Actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        jLabel5.setText("Buscar");

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        rbid.setText("Id/Numero");

        rbnombre.setText("Nombre");

        rbapellido.setText("Apellido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbnombre)
                        .addGap(18, 18, 18)
                        .addComponent(rbapellido))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                .addComponent(txtnombre)
                                .addComponent(txtapellido)
                                .addComponent(txtmail))
                            .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btninsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnlimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnactualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btnprobar))
                            .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnlimpiar)
                    .addComponent(btnprobar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btninsert))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnactualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbid)
                    .addComponent(rbnombre)
                    .addComponent(rbapellido))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprobarActionPerformed

        try {
            cn.obtener();
        } catch (SQLException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnprobarActionPerformed

    private void btninsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertActionPerformed
        try {
            String nombre, apelllido, mail, query;
            int codigo;
            codigo = Integer.parseInt(txtcodigo.getText());
            nombre = txtnombre.getText();
            apelllido = txtapellido.getText();
            mail = txtmail.getText();

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/muestra", "root", "navarro");
            query = "INSERT INTO usuario(idusuario,nombre,apellidos,correo) VALUES(?,?,?,?)";

            PreparedStatement pst = conexion.prepareStatement(query);
            pst.setInt(1, codigo);
            pst.setString(2, nombre);
            pst.setString(3, apelllido);
            pst.setString(4, mail);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se guardaron los datos");
            cargarDatos();
            pst.close();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btninsertActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        txtapellido.setText("");
        txtcodigo.setText("");
        txtmail.setText("");
        txtnombre.setText("");
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
        try {
            String query;
            int codigo;
            codigo = Integer.parseInt(txtcodigo.getText());

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/muestra", "root", "navarro");

            query = "UPDATE usuario SET nombre='" + txtnombre.getText()
                    + "',apellidos='" + txtapellido.getText()
                    + "',correo='" + txtmail.getText()
                    + "' WHERE idusuario='" + codigo + "";

            PreparedStatement pst = conexion.prepareStatement("UPDATE usuario SET nombre='" + txtnombre.getText()
                    + "',apellidos='" + txtapellido.getText()
                    + "',correo='" + txtmail.getText()
                    + "' WHERE idusuario='" + codigo + "';");
//            pst.setInt(1, codigo);
//            pst.setString(2, txtnombre.getText());
//            pst.setString(3, txtapellido.getText());
//            pst.setString(4, txtmail.getText());

            //pst.executeUpdate();
            int n = pst.executeUpdate();//valida si se guardaron los datos; si pst>0 entonces se guardaron
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Se Modificaron los datos");
                cargarDatos();
                pst.close();
            } else {
                JOptionPane.showMessageDialog(null, "Problemas para modificaron los datos");
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            txtcodigo.setText(tabla.getValueAt(fila, 0).toString());
            txtnombre.setText(tabla.getValueAt(fila, 1).toString());
            txtapellido.setText(tabla.getValueAt(fila, 2).toString());
            txtmail.setText(tabla.getValueAt(fila, 3).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }
    }//GEN-LAST:event_tablaMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        try {
            String query;
            int codigo;
            codigo = Integer.parseInt(txtcodigo.getText());

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/muestra", "root", "navarro");
            query = "Delete from usuario Where idusuario=?";
            PreparedStatement pst = conexion.prepareStatement(query);
            pst.setInt(1, codigo);

            int n = pst.executeUpdate();//valida si se guardaron los datos; si pst>0 entonces se guardaron
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "Se Elimino el dato");
                cargarDatos();
                pst.close();
                Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Problemas para Eliminar los datos");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed




        filtro(txtbuscar.getText(), tabla);

    }//GEN-LAST:event_btnbuscarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup botones;
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btninsert;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JButton btnprobar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbapellido;
    private javax.swing.JRadioButton rbid;
    private javax.swing.JRadioButton rbnombre;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtmail;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}