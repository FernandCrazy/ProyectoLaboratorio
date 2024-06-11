
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class fInicio extends javax.swing.JFrame {

    public fInicio() {
        ImageIcon icono = new ImageIcon(getClass().getResource("imagenes\\icono.png"));
        setIconImage(icono.getImage());
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    public void Botonsalir() {
        dispose();
    }

    private static void abrirReporte() {
        // Ruta al archivo del reporte
        String reportPath = "C:\\Users\\Fernando Gonzalez\\Desktop\\Trabajos escuela\\Trabajos 7tmo semestre\\Nueva carpeta\\proyectoCarrera\\LaboratorioRenteria\\src\\reportes\\report1.jasper";
        File reportFile = new File(reportPath);

        if (reportFile.exists() && reportFile.isFile()) {
            try {

                Desktop.getDesktop().open(reportFile);
            } catch (IOException ex) {

                JOptionPane.showMessageDialog(null, "Error al abrir el reporte: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            JOptionPane.showMessageDialog(null, "El reporte no existe o no es un archivo válido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            System.out.println("Ruta al archivo: " + reportPath);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        BConsultas = new javax.swing.JMenuItem();
        BPacientes = new javax.swing.JMenuItem();
        BAgendarcita = new javax.swing.JMenuItem();
        BAgregarPaciente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        BExamenesExternos = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        BReportes = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        BExamenesIndividuales = new javax.swing.JMenuItem();
        BPerfil = new javax.swing.JMenuItem();
        BGrupo = new javax.swing.JMenuItem();
        BMedicos = new javax.swing.JMenuItem();
        BAgregarUsuarios = new javax.swing.JMenuItem();
        BExamenes = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        BAviso = new javax.swing.JMenuItem();
        Bsalir = new javax.swing.JMenu();
        BCerrarV = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bienvenido Admin");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/admin.gif"))); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iconoAdministrador.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/admin.png"))); // NOI18N

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setToolTipText("");
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuBar1MouseClicked(evt);
            }
        });

        jMenu1.setBorder(null);
        jMenu1.setForeground(new java.awt.Color(0, 0, 153));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/folio.png"))); // NOI18N
        jMenu1.setText("Folio");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        BConsultas.setText("Consultas");
        BConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BConsultasActionPerformed(evt);
            }
        });
        jMenu1.add(BConsultas);

        BPacientes.setText("Pacientes");
        BPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPacientesActionPerformed(evt);
            }
        });
        jMenu1.add(BPacientes);

        BAgendarcita.setText("Agendar Cita");
        BAgendarcita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgendarcitaActionPerformed(evt);
            }
        });
        jMenu1.add(BAgendarcita);

        BAgregarPaciente.setText("Agregar Paciente");
        BAgregarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgregarPacienteActionPerformed(evt);
            }
        });
        jMenu1.add(BAgregarPaciente);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(0, 0, 153));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/varios.png"))); // NOI18N
        jMenu2.setText("Varios");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        BExamenesExternos.setText("Examenes Externos");
        BExamenesExternos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExamenesExternosActionPerformed(evt);
            }
        });
        jMenu2.add(BExamenesExternos);

        jMenuBar1.add(jMenu2);

        jMenu3.setForeground(new java.awt.Color(0, 0, 153));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reportes.png"))); // NOI18N
        jMenu3.setText("Reportes");
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        BReportes.setText("Generar Reporte");
        BReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BReportesActionPerformed(evt);
            }
        });
        BReportes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BReportesKeyTyped(evt);
            }
        });
        jMenu3.add(BReportes);

        jMenuItem2.setText("Mostrar Reporte");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuBar1.add(jMenu3);

        jMenu5.setForeground(new java.awt.Color(0, 0, 153));
        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/resultados.png"))); // NOI18N
        jMenu5.setText("Catálogos");
        jMenu5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        BExamenesIndividuales.setText("Examenes individuales");
        BExamenesIndividuales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExamenesIndividualesActionPerformed(evt);
            }
        });
        jMenu5.add(BExamenesIndividuales);

        BPerfil.setText("Perfiles");
        BPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPerfilActionPerformed(evt);
            }
        });
        jMenu5.add(BPerfil);

        BGrupo.setText("Grupos");
        BGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGrupoActionPerformed(evt);
            }
        });
        jMenu5.add(BGrupo);

        BMedicos.setText("Medicos");
        BMedicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMedicosActionPerformed(evt);
            }
        });
        jMenu5.add(BMedicos);

        BAgregarUsuarios.setText("Agregar Usuario");
        BAgregarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAgregarUsuariosActionPerformed(evt);
            }
        });
        jMenu5.add(BAgregarUsuarios);

        BExamenes.setText("Examenes");
        BExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExamenesActionPerformed(evt);
            }
        });
        jMenu5.add(BExamenes);

        jMenuItem1.setText("Grupos y Perfiles de Examenes");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar1.add(jMenu5);

        jMenu6.setBorder(null);
        jMenu6.setForeground(new java.awt.Color(0, 0, 153));
        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/aviso.png"))); // NOI18N
        jMenu6.setText("Aviso de privacidad");
        jMenu6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        BAviso.setText("Aviso");
        BAviso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAvisoActionPerformed(evt);
            }
        });
        jMenu6.add(BAviso);

        jMenuBar1.add(jMenu6);

        Bsalir.setForeground(new java.awt.Color(0, 0, 153));
        Bsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        Bsalir.setText("Salir");
        Bsalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Bsalir.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Bsalir.setVerifyInputWhenFocusTarget(false);
        Bsalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BsalirMouseClicked(evt);
            }
        });
        Bsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BsalirActionPerformed(evt);
            }
        });
        Bsalir.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BsalirKeyPressed(evt);
            }
        });

        BCerrarV.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ENTER, 0));
        BCerrarV.setText("Cerrar ventana");
        BCerrarV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCerrarVActionPerformed(evt);
            }
        });
        Bsalir.add(BCerrarV);

        jMenuBar1.add(Bsalir);
        Bsalir.getAccessibleContext().setAccessibleDescription("");

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed


    }//GEN-LAST:event_jMenu1ActionPerformed

    private void BExamenesIndividualesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExamenesIndividualesActionPerformed
        ExamenesIndividuales in = new ExamenesIndividuales(null, true);
        in.setVisible(true);
    }//GEN-LAST:event_BExamenesIndividualesActionPerformed

    private void BsalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BsalirMouseClicked

    }//GEN-LAST:event_BsalirMouseClicked

    private void jMenuBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuBar1MouseClicked

    }//GEN-LAST:event_jMenuBar1MouseClicked

    private void BsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BsalirActionPerformed
        FIncio1 fr = new FIncio1();
        fr.setVisible(true);
        dispose();
    }//GEN-LAST:event_BsalirActionPerformed

    private void BsalirKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BsalirKeyPressed
        Botonsalir();
    }//GEN-LAST:event_BsalirKeyPressed

    private void BConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BConsultasActionPerformed
        ConsultasAdmin consulta = new ConsultasAdmin(null, true);
        consulta.setVisible(true);
    }//GEN-LAST:event_BConsultasActionPerformed

    private void BCerrarVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCerrarVActionPerformed
        FIncio1 fr = new FIncio1();
        fr.setVisible(true);
        dispose();
    }//GEN-LAST:event_BCerrarVActionPerformed

    private void BPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPacientesActionPerformed
        Pacientes per = new Pacientes(null, true);
        per.setVisible(true);
    }//GEN-LAST:event_BPacientesActionPerformed

    private void BExamenesExternosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExamenesExternosActionPerformed
        ExamenesParaGrupo ex = new ExamenesParaGrupo(null, true);
        ex.setVisible(true);
    }//GEN-LAST:event_BExamenesExternosActionPerformed

    private void BReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BReportesActionPerformed
        Reportes per = new Reportes(null, true);
        per.setVisible(true);
    }//GEN-LAST:event_BReportesActionPerformed

    private void BPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPerfilActionPerformed
        NombrePerfies per = new NombrePerfies(null, true);
        per.setVisible(true);
    }//GEN-LAST:event_BPerfilActionPerformed

    private void BMedicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMedicosActionPerformed
        Medicos me = new Medicos(null, true);
        me.setVisible(true);
    }//GEN-LAST:event_BMedicosActionPerformed

    private void BAgendarcitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgendarcitaActionPerformed
        Agendar ag = new Agendar(null, true);
        ag.setVisible(true);
    }//GEN-LAST:event_BAgendarcitaActionPerformed

    private void BAgregarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarPacienteActionPerformed
        AgregarPacientes me = new AgregarPacientes(null, true);
        me.setVisible(true);
    }//GEN-LAST:event_BAgregarPacienteActionPerformed

    private void BAvisoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAvisoActionPerformed
        AvisodePrivacidad av = new AvisodePrivacidad();
        av.setVisible(true);
    }//GEN-LAST:event_BAvisoActionPerformed

    private void BAgregarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAgregarUsuariosActionPerformed
        AltaUsuario al = new AltaUsuario(null, true);
        al.setVisible(true);
    }//GEN-LAST:event_BAgregarUsuariosActionPerformed

    private void BReportesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BReportesKeyTyped
        //abrir el reporte
        abrirReporte();
    }//GEN-LAST:event_BReportesKeyTyped

    private void BExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExamenesActionPerformed
        Examenes cnx = new Examenes(null, true);
        cnx.setVisible(true);
    }//GEN-LAST:event_BExamenesActionPerformed

    private void BGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGrupoActionPerformed
        NombreGrupos per = new NombreGrupos(null, true);
        per.setVisible(true);
    }//GEN-LAST:event_BGrupoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Grupos gr = new Grupos(null, true);
        gr.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        MostrarRepor mostrar = new MostrarRepor();
        mostrar.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(fInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fInicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fInicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem BAgendarcita;
    private javax.swing.JMenuItem BAgregarPaciente;
    private javax.swing.JMenuItem BAgregarUsuarios;
    private javax.swing.JMenuItem BAviso;
    private javax.swing.JMenuItem BCerrarV;
    private javax.swing.JMenuItem BConsultas;
    private javax.swing.JMenuItem BExamenes;
    private javax.swing.JMenuItem BExamenesExternos;
    private javax.swing.JMenuItem BExamenesIndividuales;
    private javax.swing.JMenuItem BGrupo;
    private javax.swing.JMenuItem BMedicos;
    private javax.swing.JMenuItem BPacientes;
    private javax.swing.JMenuItem BPerfil;
    private javax.swing.JMenuItem BReportes;
    private javax.swing.JMenu Bsalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    // End of variables declaration//GEN-END:variables
}
