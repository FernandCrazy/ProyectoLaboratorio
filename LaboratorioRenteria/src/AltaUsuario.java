
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
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
public class AltaUsuario extends javax.swing.JDialog {

    /**
     * Creates new form AltaUsuario
     */
    public AltaUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        ImageIcon icono = new ImageIcon(getClass().getResource("imagenes\\icono.png"));
        setIconImage(icono.getImage());
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TFContra = new javax.swing.JPasswordField();
        TFContraConfir = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        CTNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BCancelar = new javax.swing.JButton();
        BNuevo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbMostrar = new javax.swing.JCheckBox();
        cbMostrar1 = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo Usuario");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TFContra.setText("jPasswordField1");
        getContentPane().add(TFContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 210, 30));

        TFContraConfir.setText("jPasswordField1");
        getContentPane().add(TFContraConfir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 210, 30));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("AGREGAR UN NUEVO USUARIO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 210, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Usuario:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, 20));

        CTNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CTNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CTNombreActionPerformed(evt);
            }
        });
        CTNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CTNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                CTNombreKeyTyped(evt);
            }
        });
        getContentPane().add(CTNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 209, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Contraseña:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        BCancelar.setBackground(new java.awt.Color(255, 255, 255));
        BCancelar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        BCancelar.setText("Cancelar");
        BCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BCancelarMouseClicked(evt);
            }
        });
        getContentPane().add(BCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 370, 130, 40));

        BNuevo.setBackground(new java.awt.Color(255, 255, 255));
        BNuevo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar.png"))); // NOI18N
        BNuevo.setText("Guardar");
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
        getContentPane().add(BNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 130, 40));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Confirmar Contraseña:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 20));

        cbMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMostrarActionPerformed(evt);
            }
        });
        getContentPane().add(cbMostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));

        cbMostrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMostrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(cbMostrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/login3.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BCancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_BCancelarMouseClicked

    private void BNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BNuevoMouseClicked
        ConexionBDV cnx = new ConexionBDV();

        String usuario = CTNombre.getText();
        String contraseña = TFContra.getText();
        String Confirmar = TFContraConfir.getText();

        if (contraseña.equals(Confirmar)) {
            String consulta = "INSERT INTO tusuario (Usuario, Contrasena) VALUES ('" + usuario + "', AES_ENCRYPT('" + contraseña + "', 'hola'))";

            System.out.println(consulta); // Solo para depuración

            cnx.ejecutarConsultas(consulta);
            cnx.cerrarConexiones();

            CTNombre.setText("");
            TFContra.setText("");
            TFContraConfir.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Tu contraseña no coincide");
        }
    }//GEN-LAST:event_BNuevoMouseClicked

    private void BNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BNuevoActionPerformed

    private void CTNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CTNombreActionPerformed
        TFContra.requestFocus();
    }//GEN-LAST:event_CTNombreActionPerformed

    private void CTNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CTNombreKeyTyped

    }//GEN-LAST:event_CTNombreKeyTyped

    private void CTNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CTNombreKeyPressed

    }//GEN-LAST:event_CTNombreKeyPressed

    private void cbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMostrarActionPerformed
        if (cbMostrar.isSelected()) {
            TFContra.setEchoChar((char) 0); //password = JPasswordField
        } else {
            TFContra.setEchoChar('*');
        }
    }//GEN-LAST:event_cbMostrarActionPerformed

    private void cbMostrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMostrar1ActionPerformed
        if (cbMostrar.isSelected()) {
            TFContraConfir.setEchoChar((char) 0); //password = JPasswordField
        } else {
            TFContraConfir.setEchoChar('*');
        }
    }//GEN-LAST:event_cbMostrar1ActionPerformed

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
            java.util.logging.Logger.getLogger(AltaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AltaUsuario dialog = new AltaUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BNuevo;
    private javax.swing.JTextField CTNombre;
    private javax.swing.JPasswordField TFContra;
    private javax.swing.JPasswordField TFContraConfir;
    private javax.swing.JCheckBox cbMostrar;
    private javax.swing.JCheckBox cbMostrar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}