
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Fernando Gonzalez
 */
public class MostrarRepor extends javax.swing.JFrame {

    /**
     * Creates new form Reportes
     */
    public MostrarRepor() {
        initComponents();
        ImageIcon icono = new ImageIcon(getClass().getResource("imagenes\\icono.png"));
        setIconImage(icono.getImage());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MostrarTabla();
        TFNombre.setEnabled(true);
        TFSexo.setEnabled(true);
    }

    public void MostrarTabla() {
        ConexionBDV cnx = new ConexionBDV();
        cnx.mostrarDatosParaReportes(TDatos);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = TDatos.getColumnModel();
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(1).setPreferredWidth(40);
        cnx.cerrarConexiones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TDatos = new javax.swing.JTable();
        BGuardar = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        TFNombre = new org.jdesktop.swingx.JXTextField();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        TFBuscador = new org.jdesktop.swingx.JXSearchField();
        jLabel4 = new javax.swing.JLabel();
        TFSexo = new org.jdesktop.swingx.JXTextField();
        TFClave = new javax.swing.JTextField();
        TFCE = new javax.swing.JTextField();
        TFFecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mostrar Reportes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TDatos.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Examen", "Parametros", "IC", "RP", "Email", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TDatos.setAlignmentX(5.0F);
        TDatos.setAlignmentY(5.0F);
        TDatos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TDatos.setRowHeight(25);
        TDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TDatosMouseClicked(evt);
            }
        });
        TDatos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TDatosKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(TDatos);
        if (TDatos.getColumnModel().getColumnCount() > 0) {
            TDatos.getColumnModel().getColumn(0).setMinWidth(35);
            TDatos.getColumnModel().getColumn(0).setPreferredWidth(35);
            TDatos.getColumnModel().getColumn(0).setMaxWidth(35);
            TDatos.getColumnModel().getColumn(2).setMinWidth(0);
            TDatos.getColumnModel().getColumn(2).setPreferredWidth(0);
            TDatos.getColumnModel().getColumn(2).setMaxWidth(0);
            TDatos.getColumnModel().getColumn(3).setMinWidth(0);
            TDatos.getColumnModel().getColumn(3).setPreferredWidth(0);
            TDatos.getColumnModel().getColumn(3).setMaxWidth(0);
            TDatos.getColumnModel().getColumn(4).setMinWidth(0);
            TDatos.getColumnModel().getColumn(4).setPreferredWidth(0);
            TDatos.getColumnModel().getColumn(4).setMaxWidth(0);
            TDatos.getColumnModel().getColumn(5).setMinWidth(0);
            TDatos.getColumnModel().getColumn(5).setPreferredWidth(0);
            TDatos.getColumnModel().getColumn(5).setMaxWidth(0);
            TDatos.getColumnModel().getColumn(6).setMinWidth(0);
            TDatos.getColumnModel().getColumn(6).setPreferredWidth(0);
            TDatos.getColumnModel().getColumn(6).setMaxWidth(0);
            TDatos.getColumnModel().getColumn(7).setMinWidth(120);
            TDatos.getColumnModel().getColumn(7).setPreferredWidth(120);
            TDatos.getColumnModel().getColumn(7).setMaxWidth(120);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 919, 269));

        BGuardar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mostrar.png"))); // NOI18N
        BGuardar.setText("Mostrar Reporte");
        BGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(BGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 450, 200, 50));

        BCancelar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        BCancelar.setText("Cancelar");
        BCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(BCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 210, 50));

        TFNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        TFNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFNombre.setText("Ingrese el nombre");
        getContentPane().add(TFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 180, 30));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("Nombre Paciente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 350, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 140, 20));

        TFBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFBuscadorActionPerformed(evt);
            }
        });
        getContentPane().add(TFBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 710, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoreportes.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 930, 590));

        TFSexo.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        TFSexo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFSexo.setText("Ingrese el Sexo del Parametro");
        getContentPane().add(TFSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 180, 30));
        getContentPane().add(TFClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, 110, -1));
        getContentPane().add(TFCE, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, 110, -1));
        getContentPane().add(TFFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 350, 110, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDatosMouseClicked

        int fila_seleccionada = TDatos.getSelectedRow();
        TFNombre.setText(TDatos.getValueAt(fila_seleccionada, 1).toString());
        TFSexo.setText(TDatos.getValueAt(fila_seleccionada, 3).toString());
        TFClave.setText(TDatos.getValueAt(fila_seleccionada, 5).toString());
        TFCE.setText(TDatos.getValueAt(fila_seleccionada, 4).toString());
        TFFecha.setText(TDatos.getValueAt(fila_seleccionada, 7).toString());
        TFNombre.setEnabled(false);
        TFSexo.setEnabled(false);
    }//GEN-LAST:event_TDatosMouseClicked

    private void TDatosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TDatosKeyTyped

    }//GEN-LAST:event_TDatosKeyTyped

    private void BGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardarActionPerformed

        ConexionBDV cx = new ConexionBDV();
        String Sexo = TFSexo.getText();
        String Nombre = TFNombre.getText();
        String Fecha = TFFecha.getText();
        cx.MostrarReporte(Sexo, Nombre, Nombre, Fecha);


    }//GEN-LAST:event_BGuardarActionPerformed

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        TFNombre.setEnabled(true);
        TFSexo.setEnabled(true);
        TFNombre.setText("");
        TFSexo.setText("");
    }//GEN-LAST:event_BCancelarActionPerformed

    private void TFBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFBuscadorActionPerformed
        ConexionBDV cnx = new ConexionBDV();
        cnx.mostrarDatosReportesBuscador(TDatos, TFBuscador);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = TDatos.getColumnModel();
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(1).setPreferredWidth(40);
        columnModel.getColumn(7).setCellRenderer(centerRenderer);
        columnModel.getColumn(7).setPreferredWidth(40);
        cnx.cerrarConexiones();
        cnx.cerrarConexiones();
    }//GEN-LAST:event_TFBuscadorActionPerformed

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
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MostrarRepor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BGuardar;
    private javax.swing.JTable TDatos;
    private org.jdesktop.swingx.JXSearchField TFBuscador;
    private javax.swing.JTextField TFCE;
    private javax.swing.JTextField TFClave;
    private javax.swing.JTextField TFFecha;
    private org.jdesktop.swingx.JXTextField TFNombre;
    private org.jdesktop.swingx.JXTextField TFSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
