
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
public class AñadirAPerfil extends javax.swing.JDialog {

    /**
     * Creates new form Grupos
     */
    public AñadirAPerfil(java.awt.Frame parent, boolean modal, String Clave, String Nombre) {
        super(parent, modal);
        ImageIcon icono = new ImageIcon(getClass().getResource("imagenes\\icono.png"));
        setIconImage(icono.getImage());
        initComponents();
        TFClave.setText(Clave);
        TFNombre.setText(Nombre);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        ConexionBDV cnx = new ConexionBDV();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TDatos = new javax.swing.JTable();
        BQuitar = new javax.swing.JButton();
        BNuevo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        BGuardar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TFNombre = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        TFClave = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir Examen a Perfil");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TDatos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        TDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Examen"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TDatos.setRowHeight(25);
        TDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TDatos);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 350, 200));

        BQuitar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        BQuitar.setText("Quitar");
        BQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(BQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 120, 40));

        BNuevo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agendar.png"))); // NOI18N
        BNuevo.setText("Agendar Cita");
        BNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BNuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BNuevoMouseClicked(evt);
            }
        });
        BNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BNuevoActionPerformed(evt);
            }
        });
        getContentPane().add(BNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 132, 36));

        jLabel2.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Agregue los Examenes que desee");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 310, -1));

        BGuardar1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        BGuardar1.setText("Agregar Examenes");
        BGuardar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BGuardar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BGuardar1MouseClicked(evt);
            }
        });
        BGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardar1ActionPerformed(evt);
            }
        });
        getContentPane().add(BGuardar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 210, 35));

        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PERFIL");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 310, -1));

        TFNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(TFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 180, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/laboratorio1.jpg"))); // NOI18N
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 240));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/laboratorio1.jpg"))); // NOI18N
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, -1, 240));

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/laboratorio1.jpg"))); // NOI18N
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 240));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/laboratorio1.jpg"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, 250));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/laboratorio1.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 250));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/laboratorio1.jpg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, -1, 250));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/laboratorio1.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, -1, 250));
        getContentPane().add(TFClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 50, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDatosMouseClicked

    }//GEN-LAST:event_TDatosMouseClicked

    private void BQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BQuitarActionPerformed

        int fila = TDatos.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) TDatos.getModel();

        if (fila != -1) {
            modelo.removeRow(fila);
        }

    }//GEN-LAST:event_BQuitarActionPerformed

    private void BNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BNuevoMouseClicked
        ConexionBDV cnx = new ConexionBDV();
        String Perfil = TFClave.getText();
        String PerfilCodigo = Perfil.split(" - ")[0];

        for (int fila = 0; fila < TDatos.getRowCount(); fila++) {
            String idExamen = TDatos.getValueAt(fila, 0).toString();
            String consultaExa = "INSERT INTO examenperfil "
                    + "VALUES (null, '" + idExamen + "', '" + PerfilCodigo + "')";
            System.out.println(consultaExa);
            cnx.ejecutarConsultas(consultaExa);
        }

        DefaultTableModel modeloVacio = new DefaultTableModel();
        TDatos.setModel(modeloVacio);
        TFClave.setText("");
        TFNombre.setText("");
        JOptionPane.showMessageDialog(null, "Guardado con exito");
    }//GEN-LAST:event_BNuevoMouseClicked

    private void BNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevoActionPerformed

    }//GEN-LAST:event_BNuevoActionPerformed

    private void BGuardar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BGuardar1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BGuardar1MouseClicked

    private void BGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardar1ActionPerformed
        ExamenesParaPerfil fme = new ExamenesParaPerfil(this, true);
        fme.setVisible(true);
    }//GEN-LAST:event_BGuardar1ActionPerformed

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
            java.util.logging.Logger.getLogger(Grupos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grupos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grupos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grupos.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                AñadirAPerfil dialog = new AñadirAPerfil(new JDialog(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BGuardar1;
    private javax.swing.JButton BNuevo;
    private javax.swing.JButton BQuitar;
    private javax.swing.JTable TDatos;
    private javax.swing.JTextField TFClave;
    private javax.swing.JTextField TFNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    void setdatos(String ClaveTbla, String NombreTbla) {
        //Darle un valor al nombre
        DefaultTableModel modeloT = (DefaultTableModel) TDatos.getModel();
        String nombreNuevo = NombreTbla;
        boolean nombreExiste = false;

        // Verificar si el nombre ya existe en la tabla
        for (int i = 0; i < modeloT.getRowCount(); i++) {
            String nombreExistente = modeloT.getValueAt(i, 1).toString();
            if (nombreExistente.equals(nombreNuevo)) {
                nombreExiste = true;
                break;
            }
        }

        if (!nombreExiste) {
            Object[] fila = {ClaveTbla, NombreTbla};
            modeloT.addRow(fila);
        } else {
            JOptionPane.showMessageDialog(null, "El examen ya existe en la tabla.", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
