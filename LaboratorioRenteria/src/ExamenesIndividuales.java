
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fernando Gonzalez
 */
public class ExamenesIndividuales extends javax.swing.JDialog {

    /**
     * Creates new form ExamenesIndividuales
     */
    public ExamenesIndividuales(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        ImageIcon icono = new ImageIcon(getClass().getResource("imagenes\\icono.png"));
        setIconImage(icono.getImage());
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MostrarExamenesIndividuales();
    }

    public void MostrarExamenesIndividuales() {
        ConexionBDV cnx = new ConexionBDV();
        cnx.mostrarExamenesIndividuales(TAnalisis);
        cnx.cerrarConexiones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TAnalisis = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        TFDescripcion = new javax.swing.JTextField();
        BEliminar = new javax.swing.JButton();
        BModificar = new javax.swing.JButton();
        BGuardar = new javax.swing.JButton();
        BValores = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        TFClave = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Examenes Individuales");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TAnalisis.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TAnalisis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NoExamen", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TAnalisis.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TAnalisis.setRowHeight(25);
        TAnalisis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TAnalisisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TAnalisis);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 710, 185));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nombre:");
        jLabel4.setToolTipText("");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 70, -1));

        TFDescripcion.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TFDescripcion.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFDescripcion.setToolTipText("");
        TFDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TFDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFDescripcionActionPerformed(evt);
            }
        });
        TFDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFDescripcionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFDescripcionKeyTyped(evt);
            }
        });
        getContentPane().add(TFDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 291, -1));

        BEliminar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        BEliminar.setText("Eliminar");
        BEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(BEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 300, 124, 36));

        BModificar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar.png"))); // NOI18N
        BModificar.setText("Modificar");
        BModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BModificarActionPerformed(evt);
            }
        });
        getContentPane().add(BModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 124, 36));

        BGuardar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar.gif"))); // NOI18N
        BGuardar.setText("Guardar");
        BGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(BGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 124, 36));

        BValores.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BValores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/referencia.png"))); // NOI18N
        BValores.setText("Valores de Ref.");
        BValores.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BValores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BValoresMouseClicked(evt);
            }
        });
        BValores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BValoresActionPerformed(evt);
            }
        });
        getContentPane().add(BValores, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, -1, 36));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/boratorio.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 380));
        getContentPane().add(TFClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 40, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFDescripcionKeyTyped
        char caracter = evt.getKeyChar();
        if (Character.isLowerCase(caracter)) {
            evt.setKeyChar(Character.toUpperCase(caracter));
        }
    }//GEN-LAST:event_TFDescripcionKeyTyped

    private void BGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardarActionPerformed
        ConexionBDV cnx = new ConexionBDV();

        String Nombre = TFDescripcion.getText();

        if (Nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un examen antes de guardar");
        } else {
            String consulta = "INSERT INTO exameninvidual "
                    + "VALUES (null,'" + Nombre + "')";

            System.out.println(consulta);
            cnx.ejecutarConsultas(consulta);
            cnx.mostrarExamenesIndividuales(TAnalisis);
            TFDescripcion.setText("");
            cnx.cerrarConexiones();
        }


    }//GEN-LAST:event_BGuardarActionPerformed

    private void BValoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BValoresActionPerformed

    }//GEN-LAST:event_BValoresActionPerformed

    private void TFDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFDescripcionKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BGuardar.doClick();
        }
    }//GEN-LAST:event_TFDescripcionKeyPressed

    private void TFDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFDescripcionActionPerformed

    private void BEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEliminarActionPerformed

        String Nombre = TFDescripcion.getText();

        if (Nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un examen antes");
        } else {
        ConexionBDV cnx = new ConexionBDV();
        cnx.borrarExamenIndividual(TFClave.getText());
        cnx.mostrarExamenesIndividuales(TAnalisis);
        TFDescripcion.setText("");
        TFClave.setText("");
        cnx.cerrarConexiones();
        }
    }//GEN-LAST:event_BEliminarActionPerformed

    private void BModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BModificarActionPerformed
       
          String Nombre1 = TFDescripcion.getText();

        if (Nombre1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un examen antes");
        } else {
        ConexionBDV cnx = new ConexionBDV();

        String Nombre = TFDescripcion.getText();
        String Clave = TFClave.getText();

        String consulta = "UPDATE exameninvidual "
                + "SET Nombre = '" + Nombre + "' "
                + "WHERE NoExamen = " + Clave;

        TFDescripcion.setText("");
        TFClave.setText("");
        System.out.println(consulta);
        cnx.ejecutarConsultas(consulta);
        cnx.mostrarExamenesIndividuales(TAnalisis);
        TFDescripcion.setText("");
        cnx.cerrarConexiones();
        }
    }//GEN-LAST:event_BModificarActionPerformed

    private void TAnalisisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TAnalisisMouseClicked
        int fila_seleccionada = TAnalisis.getSelectedRow();
        TFClave.setText(TAnalisis.getValueAt(fila_seleccionada, 0).toString());
        TFDescripcion.setText(TAnalisis.getValueAt(fila_seleccionada, 1).toString());


    }//GEN-LAST:event_TAnalisisMouseClicked

    private void BValoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BValoresMouseClicked
        String Nombre = TFDescripcion.getText();
        if (Nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un examen antes");
        } else {
        int fila_seleccionada = TAnalisis.getSelectedRow();
        ValoresReferencia fme = new ValoresReferencia(null, true,
                TAnalisis.getValueAt(fila_seleccionada, 0).toString(),
                TAnalisis.getValueAt(fila_seleccionada, 1).toString());

        this.dispose();
        fme.setVisible(true);
         }
    }//GEN-LAST:event_BValoresMouseClicked

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
            java.util.logging.Logger.getLogger(ExamenesIndividuales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamenesIndividuales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamenesIndividuales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamenesIndividuales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ExamenesIndividuales dialog = new ExamenesIndividuales(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BEliminar;
    private javax.swing.JButton BGuardar;
    private javax.swing.JButton BModificar;
    private javax.swing.JButton BValores;
    private javax.swing.JTable TAnalisis;
    private javax.swing.JTextField TFClave;
    private javax.swing.JTextField TFDescripcion;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
