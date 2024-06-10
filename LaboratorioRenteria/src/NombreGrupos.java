
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class NombreGrupos extends javax.swing.JDialog {

    /**
     * Creates new form NombreGrupos
     */
    public NombreGrupos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        ImageIcon icono = new ImageIcon(getClass().getResource("imagenes\\icono.png"));
        setIconImage(icono.getImage());
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MostrarGrupos();
    }

    public void MostrarGrupos() {
        ConexionBDV cnx = new ConexionBDV();
        cnx.mostrarGrupos(TGrupos);
        cnx.cerrarConexiones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TFNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TGrupos = new javax.swing.JTable();
        BAgregarExamenes = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        BModificar = new javax.swing.JButton();
        BEliminar = new javax.swing.JButton();
        BGuardar1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TFClave = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Administrar Grupos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Titulo:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 60, 20));

        TFNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFNombreActionPerformed(evt);
            }
        });
        TFNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFNombreKeyTyped(evt);
            }
        });
        getContentPane().add(TFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 350, -1));

        TGrupos.setModel(new javax.swing.table.DefaultTableModel(
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
        TGrupos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TGrupos.setRowHeight(25);
        TGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TGruposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TGrupos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 438, 160));

        BAgregarExamenes.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BAgregarExamenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        BAgregarExamenes.setText("Agregar Examenes");
        BAgregarExamenes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BAgregarExamenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BAgregarExamenesMouseClicked(evt);
            }
        });
        BAgregarExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgregarExamenesActionPerformed(evt);
            }
        });
        getContentPane().add(BAgregarExamenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 210, 35));

        BCancelar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        BCancelar.setText("Cancelar");
        BCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(BCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 142, 35));

        BModificar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar.png"))); // NOI18N
        BModificar.setText("Modificar");
        BModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BModificarActionPerformed(evt);
            }
        });
        getContentPane().add(BModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 140, 40));

        BEliminar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        BEliminar.setText("Eliminar");
        BEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(BEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 140, 40));

        BGuardar1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        BGuardar1.setText("Agregar");
        BGuardar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardar1ActionPerformed(evt);
            }
        });
        getContentPane().add(BGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 142, 35));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/laboratorio4.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 190));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/laboratorio4.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 470, 240));
        getContentPane().add(TFClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 60, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BAgregarExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarExamenesActionPerformed

    }//GEN-LAST:event_BAgregarExamenesActionPerformed

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed

        TFNombre.setText("");
    }//GEN-LAST:event_BCancelarActionPerformed

    private void TFNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFNombreKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BGuardar1.doClick();
        }
    }//GEN-LAST:event_TFNombreKeyPressed

    private void TFNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFNombreKeyTyped
        char caracter = evt.getKeyChar();
        if (Character.isLowerCase(caracter)) {
            evt.setKeyChar(Character.toUpperCase(caracter));
        }
    }//GEN-LAST:event_TFNombreKeyTyped

    private void TFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFNombreActionPerformed

    private void BModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BModificarActionPerformed
       String Nombre1 = TFNombre.getText();

        if (Nombre1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un examen antes");
        } else {
        
        ConexionBDV cnx = new ConexionBDV();

        String Nombre = TFNombre.getText();
        String Clave = TFClave.getText();

        String consulta = "UPDATE grupo "
                + "SET Nombre = '" + Nombre + "' "
                + "WHERE NoGrupo = " + Clave;

        TFNombre.setText("");
        TFClave.setText("");
        System.out.println(consulta);
        cnx.ejecutarConsultas(consulta);
        cnx.mostrarGrupos(TGrupos);
        cnx.cerrarConexiones();
        }
    }//GEN-LAST:event_BModificarActionPerformed

    private void BEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEliminarActionPerformed
         String Nombre1 = TFNombre.getText();

        if (Nombre1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un examen antes");
        } else {
        ConexionBDV cnx = new ConexionBDV();
        cnx.borrarGrupo(TFClave.getText());
        cnx.mostrarGrupos(TGrupos);
        TFNombre.setText("");
        TFClave.setText("");
        cnx.cerrarConexiones();
        }
    }//GEN-LAST:event_BEliminarActionPerformed

    private void TGruposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TGruposMouseClicked
        int fila_seleccionada = TGrupos.getSelectedRow();
        TFClave.setText(TGrupos.getValueAt(fila_seleccionada, 0).toString());
        TFNombre.setText(TGrupos.getValueAt(fila_seleccionada, 1).toString());
    }//GEN-LAST:event_TGruposMouseClicked

    private void BGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardar1ActionPerformed
         String Nombre1 = TFNombre.getText();

        if (Nombre1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese un examen antes");
        } else {
        
        ConexionBDV cnx = new ConexionBDV();
        String Nombre = TFNombre.getText();
        String consultaVerificar = "SELECT COUNT(*) FROM grupo WHERE nombre = '" + Nombre + "'";
        int cantidad = cnx.contarRegistros(consultaVerificar);

        if (cantidad == 0) {
            // El nombre no existe en la base de datos, por lo que lo insertamos
            String consultaInsertar = "INSERT INTO grupo VALUES (null,'" + Nombre + "')";
            System.out.println(consultaInsertar);
            cnx.ejecutarConsultas(consultaInsertar);
            cnx.mostrarGrupos(TGrupos);
        } else {
             JOptionPane.showMessageDialog(null, "El grupo ya existe en la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        cnx.cerrarConexiones();
        TFNombre.setText("");
        }

    }//GEN-LAST:event_BGuardar1ActionPerformed

    private void BAgregarExamenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BAgregarExamenesMouseClicked
 String Nombre1 = TFNombre.getText();

        if (Nombre1.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un examen antes");
        } else {
        int fila_seleccionada = TGrupos.getSelectedRow();
        AñadirAGrupo fme = new AñadirAGrupo(null, true,
                TGrupos.getValueAt(fila_seleccionada, 0).toString(),
                TGrupos.getValueAt(fila_seleccionada, 1).toString());

        this.dispose();
        fme.setVisible(true);
        }
    }//GEN-LAST:event_BAgregarExamenesMouseClicked

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
            java.util.logging.Logger.getLogger(NombreGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NombreGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NombreGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NombreGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NombreGrupos dialog = new NombreGrupos(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BAgregarExamenes;
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BEliminar;
    private javax.swing.JButton BGuardar1;
    private javax.swing.JButton BModificar;
    private javax.swing.JTextField TFClave;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JTable TGrupos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
