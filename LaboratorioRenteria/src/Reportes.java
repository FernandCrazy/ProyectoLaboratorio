
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
public class Reportes extends javax.swing.JDialog {

    private static String emailFrom = "somoslaboratoriorenteria@gmail.com";
    private static String passswordFrom = "yoayiiueziuparnz";
    private static String emailTo;
    private static String subject;
    private static String content;
//    private static String Phonenumber = "3171149818";
    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;

    public Reportes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        ImageIcon icono = new ImageIcon(getClass().getResource("imagenes\\icono.png"));
        setIconImage(icono.getImage());
        initComponents();
        mProperties = new Properties();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        MostrarTabla();
        TFNombre.setEnabled(true);
        TFSexo.setEnabled(true);
    }

    private void createEmail() throws IOException {

        String Nombre = TFNombrePReport.getText() + " - " + TFFecha.getText();
        String NombreP = TFNombrePReport.getText();
        String Correo = TFEmail.getText();

        emailTo = Correo;
        System.out.println(Correo);
        subject = "Reporte de análisis clínicos de Laboratorio Renteria";
        content = "Hola " + NombreP + " aquí tienes tu reporte.";

        mProperties.put("mail.smtp.host", "smtp.gmail.com");
        mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        mProperties.setProperty("mail.smtp.starttls.enable", "true");
        mProperties.setProperty("mail.smtp.port", "587");
        mProperties.setProperty("mail.smtp.user", emailFrom);
        mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        mProperties.setProperty("mail.smtp.auth", "true");

        mSession = Session.getDefaultInstance(mProperties);

        try {
            MimeMultipart mElementosCorreo = new MimeMultipart();
            MimeBodyPart mContenido = new MimeBodyPart();
            mContenido.setContent(content, "text/html; charset=utf-8");
            mElementosCorreo.addBodyPart(mContenido);

            // Adjuntar archivos PDF de la carpeta especificada
            String rutaDestino = "C:\\Users\\Fernando Gonzalez\\Desktop\\Trabajos escuela\\Trabajos 7tmo semestre\\Nueva carpeta\\proyectoCarrera\\LaboratorioRenteria\\src\\Analisis";
            String pdfName = Nombre + ".pdf";

            System.out.println(pdfName);

            File carpeta = new File(rutaDestino);
            if (carpeta.exists() && carpeta.isDirectory()) {
                File[] archivos = carpeta.listFiles();
                if (archivos != null) {
                    for (File archivo : archivos) {
                        if (archivo.isFile() && archivo.getName().equalsIgnoreCase(pdfName)) {
                            // Adjuntar el archivo PDF al correo
                            MimeBodyPart pdfAttachment = new MimeBodyPart();
                            pdfAttachment.attachFile(archivo);
                            mElementosCorreo.addBodyPart(pdfAttachment);
                            break; //
                        }
                    }
                }
            }

            mCorreo = new MimeMessage(mSession);
            mCorreo.setFrom(new InternetAddress(emailFrom));
            mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
            mCorreo.setSubject(subject);
            mCorreo.setContent(mElementosCorreo);

        } catch (AddressException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendEmail() {
        try {
            Transport mTransport = mSession.getTransport("smtp");
            mTransport.connect(emailFrom, passswordFrom);
            mTransport.sendMessage(mCorreo, mCorreo.getRecipients(Message.RecipientType.TO));
            mTransport.close();

            JOptionPane.showMessageDialog(null, "Correo enviado");
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void MostrarTabla() {
        ConexionBDV cnx = new ConexionBDV();
        cnx.mostrarDatosParaReportes(TDatos);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        TableColumnModel columnModel = TDatos.getColumnModel();
        columnModel.getColumn(1).setCellRenderer(centerRenderer);
        columnModel.getColumn(1).setPreferredWidth(40);
        columnModel.getColumn(7).setCellRenderer(centerRenderer);
        columnModel.getColumn(7).setPreferredWidth(40);
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
        jLabel3 = new javax.swing.JLabel();
        TFSexo = new org.jdesktop.swingx.JXTextField();
        TFClave = new javax.swing.JTextField();
        TFCE = new javax.swing.JTextField();
        TFEmail = new javax.swing.JTextField();
        TFNombrePReport = new javax.swing.JTextField();
        TFFecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Generar Reportes");
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
                "ID", "Nombre", "Examen", "Parametros", "IC", "RP", "Correo", "Fecha"
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 919, 269));

        BGuardar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte.png"))); // NOI18N
        BGuardar.setText("Generar Reporte");
        BGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(BGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 200, 50));

        BCancelar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        BCancelar.setText("Cancelar");
        BCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(BCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 450, 210, 50));

        TFNombre.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        TFNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFNombre.setText("Ingrese el nombre");
        getContentPane().add(TFNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 180, 30));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel1.setText("Nombre Paciente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 350, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 140, 20));

        TFBuscador.setText("");
        TFBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFBuscadorActionPerformed(evt);
            }
        });
        getContentPane().add(TFBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 540, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoreportes.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -24, 940, 590));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondoreportes.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -24, 930, 590));

        TFSexo.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        TFSexo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFSexo.setText("Ingrese el Sexo del Parametro");
        getContentPane().add(TFSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 180, 30));
        getContentPane().add(TFClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, 110, -1));
        getContentPane().add(TFCE, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 350, 110, -1));
        getContentPane().add(TFEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 370, -1));
        getContentPane().add(TFNombrePReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 140, -1));
        getContentPane().add(TFFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 140, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDatosMouseClicked

        int fila_seleccionada = TDatos.getSelectedRow();
        TFNombre.setText(TDatos.getValueAt(fila_seleccionada, 1).toString());
        TFNombrePReport.setText(TDatos.getValueAt(fila_seleccionada, 1).toString());
        TFSexo.setText(TDatos.getValueAt(fila_seleccionada, 3).toString());
        TFClave.setText(TDatos.getValueAt(fila_seleccionada, 5).toString());
        TFCE.setText(TDatos.getValueAt(fila_seleccionada, 4).toString());
        TFEmail.setText(TDatos.getValueAt(fila_seleccionada, 6).toString());
        TFFecha.setText(TDatos.getValueAt(fila_seleccionada, 7).toString());
        TFNombre.setEnabled(false);
        TFSexo.setEnabled(false);
    }//GEN-LAST:event_TDatosMouseClicked

    private void TDatosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TDatosKeyTyped

    }//GEN-LAST:event_TDatosKeyTyped

    private void BGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardarActionPerformed

        int respuesta = JOptionPane.showConfirmDialog(this, "¿Esta seguro de guardar el reporte?");
        if (respuesta == JOptionPane.YES_OPTION) {
            try {

                ConexionBDV cx = new ConexionBDV();
                String Sexo = TFSexo.getText();
                String Nombre = TFNombre.getText();
                String Fecha = TFFecha.getText();
                cx.generarReporte(Sexo, Nombre, Nombre + " - " + Fecha, Fecha);
                JOptionPane.showMessageDialog(null, "Su Reporte Ha Sido Guardado Correctamente");
                cx.cerrarConexiones();
                TFNombre.setText("");
                TFSexo.setText("");
                createEmail();
                sendEmail();

            } catch (Exception e) {
            }

        }
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

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Reportes dialog = new Reportes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BGuardar;
    private javax.swing.JTable TDatos;
    private org.jdesktop.swingx.JXSearchField TFBuscador;
    private javax.swing.JTextField TFCE;
    private javax.swing.JTextField TFClave;
    private javax.swing.JTextField TFEmail;
    private javax.swing.JTextField TFFecha;
    private org.jdesktop.swingx.JXTextField TFNombre;
    private javax.swing.JTextField TFNombrePReport;
    private org.jdesktop.swingx.JXTextField TFSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
