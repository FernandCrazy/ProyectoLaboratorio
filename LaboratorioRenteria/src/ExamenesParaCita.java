
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fernando Gonzalez
 */
public class ExamenesParaCita extends javax.swing.JDialog {

  JTextField TFClave1,  TFNombre1;
  
    public ExamenesParaCita(JDialog parent, boolean modal) {
        super(parent, modal);
        ImageIcon icono = new ImageIcon(getClass().getResource("imagenes\\icono.png"));
        setIconImage(icono.getImage());
        initComponents();
        this.setLocationRelativeTo(null);
    }
      public ExamenesParaCita(JDialog parent, boolean modal, JTextField clave, JTextField nombre) {
        super(parent, modal);
         this.TFClave1=clave;
        this.TFNombre1=nombre;
        ImageIcon icono = new ImageIcon(getClass().getResource("imagenes\\icono.png"));
        setIconImage(icono.getImage());
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void MostrarExamenesIndividuales() {
        ConexionBDV cnx = new ConexionBDV();
        cnx.mostrarExamenesIndividuales(TIndividual);
        cnx.cerrarConexiones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BAgregarIndividual1 = new javax.swing.JButton();
        BQuitar1 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        TIndividual = new javax.swing.JTable();
        TFBuscador = new org.jdesktop.swingx.JXSearchField();
        jLabel4 = new javax.swing.JLabel();
        TFFBuscador = new org.jdesktop.swingx.JXSearchField();
        BQuitar = new javax.swing.JButton();
        BAgregarIndividual = new javax.swing.JButton();
        TFNombre = new javax.swing.JTextField();
        TFClave = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Examenes para cita");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BAgregarIndividual1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BAgregarIndividual1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        BAgregarIndividual1.setText("Agregar");
        BAgregarIndividual1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BAgregarIndividual1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BAgregarIndividual1MouseClicked(evt);
            }
        });
        BAgregarIndividual1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgregarIndividual1ActionPerformed(evt);
            }
        });
        getContentPane().add(BAgregarIndividual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 117, -1));

        BQuitar1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BQuitar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        BQuitar1.setText("Quitar");
        BQuitar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BQuitar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BQuitar1ActionPerformed(evt);
            }
        });
        getContentPane().add(BQuitar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 120, 40));

        TIndividual.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TIndividual.setRowHeight(25);
        TIndividual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TIndividualMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(TIndividual);

        getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 460, 188));

        TFBuscador.setText("");
        TFBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFBuscadorActionPerformed(evt);
            }
        });
        getContentPane().add(TFBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 335, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login3.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 410));

        TFFBuscador.setText("");
        getContentPane().add(TFFBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 335, -1));

        BQuitar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        BQuitar.setText("Quitar");
        BQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(BQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 120, 40));

        BAgregarIndividual.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BAgregarIndividual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        BAgregarIndividual.setText("Agregar");
        BAgregarIndividual.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(BAgregarIndividual, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 117, -1));

        TFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFNombreActionPerformed(evt);
            }
        });
        getContentPane().add(TFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 110, -1));
        getContentPane().add(TFClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BQuitarActionPerformed

        int fila = TIndividual.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) TIndividual.getModel();

        if (fila != -1) {
            modelo.removeRow(fila);
        }

    }//GEN-LAST:event_BQuitarActionPerformed

    private void BQuitar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BQuitar1ActionPerformed
        int fila = TIndividual.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) TIndividual.getModel();

        if (fila != -1) {
            modelo.removeRow(fila);
        }
    }//GEN-LAST:event_BQuitar1ActionPerformed

    private void TFBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFBuscadorActionPerformed
        ConexionBDV cnx = new ConexionBDV();
        cnx.mostrarDatosParaExamenesBuscador(TIndividual, TFBuscador);
        cnx.cerrarConexiones();
    }//GEN-LAST:event_TFBuscadorActionPerformed

    private void BAgregarIndividual1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarIndividual1ActionPerformed
         
    }//GEN-LAST:event_BAgregarIndividual1ActionPerformed

    private void TIndividualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TIndividualMouseClicked
        int fila_seleccionada = TIndividual.getSelectedRow();
//        TFClave.setText(TIndividual.getValueAt(fila_seleccionada, 0).toString());
//        TFNombre.setText(TIndividual.getValueAt(fila_seleccionada, 1).toString());
        String clave = TIndividual.getValueAt(fila_seleccionada, 0).toString();
        String nombre = TIndividual.getValueAt(fila_seleccionada, 1).toString();
        TFClave1.setText(clave);
        TFNombre1.setText(nombre);
        this.dispose();
    }//GEN-LAST:event_TIndividualMouseClicked

    private void BAgregarIndividual1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BAgregarIndividual1MouseClicked
    
    }//GEN-LAST:event_BAgregarIndividual1MouseClicked

    private void TFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFNombreActionPerformed

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
            java.util.logging.Logger.getLogger(ExamenesParaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamenesParaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamenesParaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamenesParaGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ExamenesParaGrupo dialog = new ExamenesParaGrupo(new JDialog(), true);
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
    private javax.swing.JButton BAgregarIndividual;
    private javax.swing.JButton BAgregarIndividual1;
    private javax.swing.JButton BQuitar;
    private javax.swing.JButton BQuitar1;
    private org.jdesktop.swingx.JXSearchField TFBuscador;
    private javax.swing.JTextField TFClave;
    private org.jdesktop.swingx.JXSearchField TFFBuscador;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JTable TIndividual;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}
