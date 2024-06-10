
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
public class ValoresReferencia extends javax.swing.JDialog {

    public ValoresReferencia(java.awt.Frame parent, boolean modal, String clave, String nombre) {
        super(parent, modal);
        ImageIcon icono = new ImageIcon(getClass().getResource("imagenes\\icono.png"));
        setIconImage(icono.getImage());
        initComponents();
        TFClaveExamen.setText(clave);
        TFBuscador.setText(nombre);
        TFBuscador.setEnabled(false);
        TFClaveParametro.setEnabled(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        ConexionBDV cnx = new ConexionBDV();
        TFClaveExamen.setEnabled(false);
    }

    public void MostrarParametros() {
        ConexionBDV cnx = new ConexionBDV();
        cnx.mostrarParametros(TParametros);
        cnx.cerrarConexiones();
    }

    public void limpiar() {
        TFEdadFinal.setText("");
        TFEdadInicial.setText("");
        TFRangoI.setText("");
        TFRangoS.setText("");
        TFUnidades.setText("");
        TFClaveParametro.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TParametros = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        CBSexo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        TFEdadInicial = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        TFEdadFinal = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TFUnidades = new javax.swing.JTextField();
        TFRangoI = new javax.swing.JTextField();
        TFRangoS = new javax.swing.JTextField();
        BGuardar = new javax.swing.JButton();
        BEliminar = new javax.swing.JButton();
        BModificar = new javax.swing.JButton();
        BCancelarTodo = new javax.swing.JButton();
        TFBuscador = new org.jdesktop.swingx.JXSearchField();
        BRegresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        TFClaveParametro = new javax.swing.JTextField();
        TFClaveExamen = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Valores de Referencia");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre del examen:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 28, -1, -1));

        TParametros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "NoExamen", "Nombre", "Sexo:", "Edad inicial:", "Edad final:", "Unidades", "Valores de referencia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TParametros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TParametros.setRowHeight(25);
        TParametros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TParametrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TParametros);
        if (TParametros.getColumnModel().getColumnCount() > 0) {
            TParametros.getColumnModel().getColumn(0).setMinWidth(0);
            TParametros.getColumnModel().getColumn(0).setPreferredWidth(0);
            TParametros.getColumnModel().getColumn(0).setMaxWidth(0);
            TParametros.getColumnModel().getColumn(1).setMinWidth(0);
            TParametros.getColumnModel().getColumn(1).setPreferredWidth(0);
            TParametros.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 720, 126));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sexo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.setToolTipText("Sexo");
        jPanel1.setName("Sexo"); // NOI18N

        CBSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        CBSexo.setToolTipText("");
        CBSexo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(CBSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(CBSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 211, -1, 85));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edad Inicial", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        TFEdadInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFEdadInicialActionPerformed(evt);
            }
        });
        TFEdadInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFEdadInicialKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(TFEdadInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(TFEdadInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, -1, 80));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Edad Final", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        TFEdadFinal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFEdadFinalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(TFEdadFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(TFEdadFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(578, 211, -1, 85));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Unidades:");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 16, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Rango inferior:");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(281, 16, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Rango superior:");
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 16, -1, -1));

        TFUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFUnidadesActionPerformed(evt);
            }
        });
        jPanel5.add(TFUnidades, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 55, 113, -1));

        TFRangoI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFRangoIActionPerformed(evt);
            }
        });
        jPanel5.add(TFRangoI, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 55, 142, -1));

        TFRangoS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TFRangoSKeyPressed(evt);
            }
        });
        jPanel5.add(TFRangoS, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 55, 140, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 720, 91));

        BGuardar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar.gif"))); // NOI18N
        BGuardar.setText("Guardar");
        BGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(BGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 430, 123, 41));

        BEliminar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/eliminar.png"))); // NOI18N
        BEliminar.setText("Eliminar");
        BEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(BEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, 123, 41));

        BModificar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/modificar.png"))); // NOI18N
        BModificar.setText("Modificar");
        BModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BModificarActionPerformed(evt);
            }
        });
        getContentPane().add(BModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 123, 41));

        BCancelarTodo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BCancelarTodo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        BCancelarTodo.setText("Cancelar");
        BCancelarTodo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BCancelarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCancelarTodoActionPerformed(evt);
            }
        });
        getContentPane().add(BCancelarTodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 430, 123, 41));

        TFBuscador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TFBuscador.setText("");
        TFBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFBuscadorActionPerformed(evt);
            }
        });
        getContentPane().add(TFBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 420, -1));

        BRegresar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/regresar.png"))); // NOI18N
        BRegresar.setText("Regresar");
        BRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(BRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 430, 123, 41));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/laboratorio23.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, -4, 740, 510));

        TFClaveParametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFClaveParametroActionPerformed(evt);
            }
        });
        getContentPane().add(TFClaveParametro, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 30, -1));
        getContentPane().add(TFClaveExamen, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 20, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TParametrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TParametrosMouseClicked
        int fila_seleccionada = TParametros.getSelectedRow();
        TFClaveExamen.setText(TParametros.getValueAt(fila_seleccionada, 1).toString());
        TFClaveParametro.setText(TParametros.getValueAt(fila_seleccionada, 0).toString());
        TFBuscador.setText(TParametros.getValueAt(fila_seleccionada, 2).toString());
        CBSexo.setSelectedItem(TParametros.getValueAt(fila_seleccionada, 3).toString());
        TFEdadInicial.setText(TParametros.getValueAt(fila_seleccionada, 4).toString());
        TFEdadFinal.setText(TParametros.getValueAt(fila_seleccionada, 5).toString());
        TFUnidades.setText(TParametros.getValueAt(fila_seleccionada, 6).toString());
        TFRangoI.setText(TParametros.getValueAt(fila_seleccionada, 7).toString().split("-")[0]);
        TFRangoS.setText(TParametros.getValueAt(fila_seleccionada, 7).toString().split("-")[1]);

    }//GEN-LAST:event_TParametrosMouseClicked

    private void BGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BGuardarActionPerformed

        ConexionBDV cnx = new ConexionBDV();
        String Clave = TFClaveExamen.getText();
        String ClaveExamen = TFClaveParametro.getText();
        String Sexo = CBSexo.getSelectedItem().toString().split("-")[0];
        String EdadInicial = TFEdadInicial.getText();
        String EdadFinal = TFEdadFinal.getText();
        String Unidades = TFUnidades.getText();
        String RangoInferior = TFRangoI.getText();
        String RangoSuperior = TFRangoS.getText();

        String consulta = "INSERT INTO parametrosexamen "
                + "VALUES (null,"
                + "'" + Clave + "',"
                + "'" + Sexo + "',"
                + "'" + EdadInicial + "',"
                + "'" + EdadFinal + "',"
                + "'" + Unidades + "',"
                + "'" + RangoInferior + " - " + RangoSuperior + "')";
        System.out.println(consulta);
        cnx.ejecutarConsultas(consulta);
        cnx.mostrarDatosParaParametrosBuscador(TParametros, TFBuscador);
        JOptionPane.showMessageDialog(null, "Guardado con exito");
        limpiar();
        cnx.cerrarConexiones();

    }//GEN-LAST:event_BGuardarActionPerformed

    private void BEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEliminarActionPerformed
        String examen = TFClaveParametro.getText();

        if (examen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un valor");
        } else {

            int respuesta = JOptionPane.showConfirmDialog(this, "¿Esta seguro de eliminar el registro?");
            if (respuesta == JOptionPane.YES_OPTION) {
                ConexionBDV cnx = new ConexionBDV();
                cnx.borrarParametros(TFClaveParametro.getText());
                cnx.mostrarDatosParaParametrosBuscador(TParametros, TFBuscador);
                limpiar();
                cnx.cerrarConexiones();
            }
        }
    }//GEN-LAST:event_BEliminarActionPerformed

    private void BModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BModificarActionPerformed
        String examen = TFClaveParametro.getText();

        if (examen.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Seleccione un valor");
        } else {

            ConexionBDV cnx = new ConexionBDV();
            String Clave = TFClaveExamen.getText();
            String ClaveParametro = TFClaveParametro.getText();
            String Sexo = CBSexo.getSelectedItem().toString().split("-")[0];
            String EdadInicial = TFEdadInicial.getText();
            String EdadFinal = TFEdadFinal.getText();
            String Unidades = TFUnidades.getText();
            String RangoInferior = TFRangoI.getText();
            String RangoSuperior = TFRangoS.getText();

            String consulta = "UPDATE parametrosexamen "
                    + "SET NoExamen = '" + Clave + "', "
                    + "Sexo = '" + Sexo + "', "
                    + "EdadInicial = '" + EdadInicial + "', "
                    + "EdadFinal = '" + EdadFinal + "', "
                    + "Unidades = '" + Unidades + "', "
                    + "ValoresReferencia = '" + RangoInferior + "-" + RangoSuperior + "' "
                    + "WHERE NoPametroExa = " + ClaveParametro;

            System.out.println(consulta);
            cnx.ejecutarConsultas(consulta);
            cnx.mostrarDatosParaParametrosBuscador(TParametros, TFBuscador);
            JOptionPane.showMessageDialog(null, "Modificado con exito");
            limpiar();
            cnx.cerrarConexiones();
        }
    }//GEN-LAST:event_BModificarActionPerformed

    private void BCancelarTodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCancelarTodoActionPerformed
        limpiar();
    }//GEN-LAST:event_BCancelarTodoActionPerformed

    private void TFEdadInicialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFEdadInicialKeyPressed

    }//GEN-LAST:event_TFEdadInicialKeyPressed

    private void TFEdadFinalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFEdadFinalActionPerformed
        TFUnidades.requestFocus();
    }//GEN-LAST:event_TFEdadFinalActionPerformed

    private void TFRangoIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFRangoIActionPerformed
        TFRangoS.requestFocus();
    }//GEN-LAST:event_TFRangoIActionPerformed

    private void TFRangoSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFRangoSKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BGuardar.doClick();
        }
    }//GEN-LAST:event_TFRangoSKeyPressed

    private void TFUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFUnidadesActionPerformed
        TFRangoI.requestFocus();
    }//GEN-LAST:event_TFUnidadesActionPerformed

    private void TFEdadInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFEdadInicialActionPerformed
        TFEdadFinal.requestFocus();
    }//GEN-LAST:event_TFEdadInicialActionPerformed

    private void TFBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFBuscadorActionPerformed
        ConexionBDV cnx = new ConexionBDV();
        cnx.mostrarDatosParaParametrosBuscador(TParametros, TFBuscador);
        cnx.cerrarConexiones();
    }//GEN-LAST:event_TFBuscadorActionPerformed

    private void TFClaveParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFClaveParametroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFClaveParametroActionPerformed

    private void BRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BRegresarActionPerformed
        ExamenesIndividuales in = new ExamenesIndividuales(null, true);
        this.dispose();
        in.setVisible(true);

    }//GEN-LAST:event_BRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(ValoresReferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValoresReferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValoresReferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValoresReferencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                ValoresReferencia dialog = new ValoresReferencia(new javax.swing.JFrame(), true);
////                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
////                    @Override
////                    public void windowClosing(java.awt.event.WindowEvent e) {
////                        System.exit(0);
////                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BCancelarTodo;
    private javax.swing.JButton BEliminar;
    private javax.swing.JButton BGuardar;
    private javax.swing.JButton BModificar;
    private javax.swing.JButton BRegresar;
    private javax.swing.JComboBox<String> CBSexo;
    private org.jdesktop.swingx.JXSearchField TFBuscador;
    private javax.swing.JTextField TFClaveExamen;
    private javax.swing.JTextField TFClaveParametro;
    private javax.swing.JTextField TFEdadFinal;
    private javax.swing.JTextField TFEdadInicial;
    private javax.swing.JTextField TFRangoI;
    private javax.swing.JTextField TFRangoS;
    private javax.swing.JTextField TFUnidades;
    private javax.swing.JTable TParametros;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
