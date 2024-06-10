
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
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
public class Agendar extends javax.swing.JDialog {

    JSpinner.DateEditor editor;

    public Agendar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        ImageIcon icono = new ImageIcon(getClass().getResource("imagenes\\icono.png"));
        setIconImage(icono.getImage());
        initComponents();
        TFNombreExamen.setEnabled(true);
        this.setLocationRelativeTo(null);
        ConexionBDV cnx = new ConexionBDV();
        cnx.llenarcomboMedicos(CBMedico);
        cnx.llenarcomboGrupo2(CBGrupo);
        cnx.llenarcomboPerfil2(CBPerfil);
        TFExamen.setEnabled(false);
        editor = new JSpinner.DateEditor(SPHora, "HH:mm:ss");
        SPHora.setEditor(editor);

    }

    public String obtenerFecha() {

        int annio = SPFecha.getCalendar().get(Calendar.YEAR);
        int mesSelect = SPFecha.getCalendar().get(Calendar.MONTH) + 1;
        int diaSelect = SPFecha.getCalendar().get(Calendar.DAY_OF_MONTH);

        String mes = mesSelect + "";

        if (mesSelect <= 9) {
            mes = "0" + mesSelect;
        }
        String dia = diaSelect + "";
        if (diaSelect <= 9) {
            dia = "0" + diaSelect;
        }

        String fechaseleccionada = annio + "-" + mes + "-" + dia;
        return fechaseleccionada;

    }

    public void limpiar() {
        CBMedico.setSelectedItem("Medico");
        DefaultTableModel modeloVacio = new DefaultTableModel();
        TDatos.setModel(modeloVacio);
        TFPrueba.setText("");
        TFNombrePa.setText("");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel14 = new javax.swing.JLabel();
        TFNombrePa = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        SPFecha = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        SPHora = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        CBMedico = new javax.swing.JComboBox<>();
        BPaciente = new javax.swing.JButton();
        BCancelar = new javax.swing.JButton();
        BNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TDatos = new javax.swing.JTable();
        BQuitar = new javax.swing.JButton();
        BExamenes = new javax.swing.JButton();
        TFPrueba = new javax.swing.JTextField();
        CBGrupo = new javax.swing.JComboBox<>();
        CBPerfil = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CBResultados = new javax.swing.JComboBox<>();
        CBEstado = new javax.swing.JComboBox<>();
        TFExamen = new javax.swing.JTextField();
        TFClaveExamen = new javax.swing.JTextField();
        TFNombreExamen = new javax.swing.JTextField();
        TFClavePa = new javax.swing.JTextField();
        BHabilitar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agendar Cita");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Nombre:");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 26));

        TFNombrePa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(TFNombrePa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 370, 30));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Prueba:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, 26));

        jLabel11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Fecha:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, -1, 26));
        getContentPane().add(SPFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 120, 40));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Hora:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, -1, 26));

        SPHora.setModel(new javax.swing.SpinnerDateModel());
        getContentPane().add(SPHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 120, 40));

        jLabel12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("No. Medico:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 83, -1));

        CBMedico.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CBMedico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medico" }));
        CBMedico.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CBMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBMedicoActionPerformed(evt);
            }
        });
        getContentPane().add(CBMedico, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 350, 30));

        BPaciente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agendar.png"))); // NOI18N
        BPaciente.setText("Agregar Paciente");
        BPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BPacienteMouseClicked(evt);
            }
        });
        BPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPacienteActionPerformed(evt);
            }
        });
        getContentPane().add(BPaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 180, 40));

        BCancelar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        BCancelar.setText("Cancelar");
        BCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(BCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 420, 132, 36));

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
        getContentPane().add(BNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, 132, 36));

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
        TDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TDatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TDatos);
        if (TDatos.getColumnModel().getColumnCount() > 0) {
            TDatos.getColumnModel().getColumn(0).setMinWidth(25);
            TDatos.getColumnModel().getColumn(0).setMaxWidth(25);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 430, 200));

        BQuitar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        BQuitar.setText("Quitar Examen ");
        BQuitar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BQuitarActionPerformed(evt);
            }
        });
        getContentPane().add(BQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 240, 170, 40));

        BExamenes.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BExamenes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agendar.png"))); // NOI18N
        BExamenes.setText("Agregar Examen");
        BExamenes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BExamenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BExamenesMouseClicked(evt);
            }
        });
        BExamenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BExamenesActionPerformed(evt);
            }
        });
        getContentPane().add(BExamenes, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 240, 180, 40));

        TFPrueba.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(TFPrueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 370, 30));

        CBGrupo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CBGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Grupos" }));
        CBGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBGrupoActionPerformed(evt);
            }
        });
        getContentPane().add(CBGrupo, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 310, 170, -1));

        CBPerfil.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        CBPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perfiles" }));
        CBPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBPerfilActionPerformed(evt);
            }
        });
        getContentPane().add(CBPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 180, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("SELECCIONA UN EXAMEN Y/O SELECCIONA POR GRUPO O PERFIL");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo-blanco-superficie-futurista-mini.jpg"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 490));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondo-blanco-superficie-futurista-mini.jpg"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 250, 490));

        CBResultados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En proceso" }));
        getContentPane().add(CBResultados, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 120, 30));

        CBEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En proceso" }));
        getContentPane().add(CBEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 120, 30));

        TFExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFExamenActionPerformed(evt);
            }
        });
        getContentPane().add(TFExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 20, -1));
        getContentPane().add(TFClaveExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 90, 40, -1));

        TFNombreExamen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(TFNombreExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 370, 30));
        getContentPane().add(TFClavePa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 40, -1));

        BHabilitar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BHabilitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar.png"))); // NOI18N
        BHabilitar.setText("Modificar");
        BHabilitar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BHabilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BHabilitarActionPerformed(evt);
            }
        });
        getContentPane().add(BHabilitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 410, 146, 36));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CBMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBMedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBMedicoActionPerformed

    private void BPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BPacienteMouseClicked


    }//GEN-LAST:event_BPacienteMouseClicked

    private void BPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPacienteActionPerformed

        Pacientes mc = new Pacientes(null, true, TFClavePa, TFNombrePa);
        mc.setVisible(true);
        TFNombrePa.setEnabled(false);

    }//GEN-LAST:event_BPacienteActionPerformed

    private void BHabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BHabilitarActionPerformed


    }//GEN-LAST:event_BHabilitarActionPerformed

    private void BCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_BCancelarActionPerformed

    private void TFExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFExamenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFExamenActionPerformed

    private void BQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BQuitarActionPerformed

        int fila = TDatos.getSelectedRow();
        DefaultTableModel modelo = (DefaultTableModel) TDatos.getModel();

        if (fila != -1) {
            modelo.removeRow(fila);
        }


    }//GEN-LAST:event_BQuitarActionPerformed

    private void BNuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BNuevoMouseClicked
        ConexionBDV cnx = new ConexionBDV();
        String Fecha = obtenerFecha();
        String Hora = editor.getFormat().format(SPHora.getValue());
        String Estado = CBEstado.getSelectedItem().toString().split("-")[0];
        String Resultados = CBResultados.getSelectedItem().toString().split("-")[0];
        String NoPaciente = TFClavePa.getText();
        String Prueba = TFPrueba.getText();
        String NoMedico = CBMedico.getSelectedItem().toString().split("-")[0];

        if (TDatos.getRowCount() > 0) {
            String consulta = "INSERT INTO TCita "
                    + "VALUES (null,'" + Hora + "',"
                    + "'" + Fecha + "',"
                    + "'" + Prueba + "',"
                    + "'" + Estado + "',"
                    + "'" + Resultados + "',"
                    + "'" + NoMedico + "',"
                    + "'" + NoPaciente + "')";
            System.out.println(consulta);
            int idCita = cnx.ejecutarConsultasObtenerId(consulta);

            for (int fila = 0; fila < TDatos.getRowCount(); fila++) {
                String idExamen = TDatos.getValueAt(fila, 0).toString();
                String consultaExa = "INSERT INTO citaexamen "
                        + "VALUES (null,'" + idExamen + "',"
                        + "'" + idCita + "',"
                        + "'" + NoMedico + "',"
                        + "'" + NoPaciente + "')";
                System.out.println(consultaExa);
                cnx.ejecutarConsultas(consultaExa);
            }
            limpiar();
            JOptionPane.showMessageDialog(null, "Cita Agendada Correctamente");
            cnx.cerrarConexiones();
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden agendar citas sin exámenes");
        }

    }//GEN-LAST:event_BNuevoMouseClicked

    private void BNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BNuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BNuevoActionPerformed

    private void TDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TDatosMouseClicked
        ConexionBDV cnx = new ConexionBDV();
        cnx.buscarExamenes2(TDatos, TFExamen);
        cnx.cerrarConexiones();
    }//GEN-LAST:event_TDatosMouseClicked

    private void BExamenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BExamenesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_BExamenesMouseClicked

    private void BExamenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BExamenesActionPerformed
        ExamenesParaCita gr = new ExamenesParaCita(null, true, TFClaveExamen, TFNombreExamen);
        gr.setVisible(true);
        if (TFNombreExamen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String nombrePaciente = TFNombreExamen.getText();
            DefaultTableModel model = (DefaultTableModel) TDatos.getModel();

            // Verificar si el nombre ya está en la tabla
            boolean nombreRepetido = false;
            for (int i = 0; i < model.getRowCount(); i++) {
                if (nombrePaciente.equals(model.getValueAt(i, 1))) {
                    nombreRepetido = true;
                    break;
                }
            }

            if (!nombreRepetido) {
                // Si el nombre no está en la tabla, agregarlo
                String clavePaciente = TFClaveExamen.getText();
                Object[] fila = {clavePaciente, nombrePaciente};
                model.addRow(fila);
            } else {
                JOptionPane.showMessageDialog(null, "El Examen ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_BExamenesActionPerformed

    private void CBGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBGrupoActionPerformed
        ConexionBDV cnx = new ConexionBDV();
        String nombreGrupo = (String) CBGrupo.getSelectedItem();
        if (nombreGrupo != null) {
            cnx.cargarExamenesGrupo(TDatos, nombreGrupo);
        }
    }//GEN-LAST:event_CBGrupoActionPerformed

    private void CBPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBPerfilActionPerformed
        ConexionBDV cnx = new ConexionBDV();
        String nombrePerfil = (String) CBPerfil.getSelectedItem();
        if (nombrePerfil != null) {
            cnx.cargarExamenesPerfil(TDatos, nombrePerfil);
        }
    }//GEN-LAST:event_CBPerfilActionPerformed

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
            java.util.logging.Logger.getLogger(Agendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                Agendar dialog = new Agendar(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCancelar;
    private javax.swing.JButton BExamenes;
    private javax.swing.JButton BHabilitar;
    private javax.swing.JButton BNuevo;
    private javax.swing.JButton BPaciente;
    private javax.swing.JButton BQuitar;
    private javax.swing.JComboBox<String> CBEstado;
    private javax.swing.JComboBox<String> CBGrupo;
    private javax.swing.JComboBox<String> CBMedico;
    private javax.swing.JComboBox<String> CBPerfil;
    private javax.swing.JComboBox<String> CBResultados;
    private com.toedter.calendar.JDateChooser SPFecha;
    private javax.swing.JSpinner SPHora;
    private javax.swing.JTable TDatos;
    private javax.swing.JTextField TFClaveExamen;
    private javax.swing.JTextField TFClavePa;
    private javax.swing.JTextField TFExamen;
    private javax.swing.JTextField TFNombreExamen;
    private javax.swing.JTextField TFNombrePa;
    private javax.swing.JTextField TFPrueba;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel8;
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
