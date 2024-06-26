/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fernando Gonzalez
 */
public class AvisodePrivacidad extends javax.swing.JFrame {

    /**
     * Creates new form AvisodePrivacidad
     */
    public AvisodePrivacidad() {
        initComponents();
         setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("AVISO DE PRIVACIDAD\n\nLaboratorio Renteria\n\nLaboratorio Renteria, en adelante \"El Laboratorio\", con domicilio en [Dirección], declara ser responsable del tratamiento de sus datos personales, \nen cumplimiento con la Ley Federal de Protección de Datos Personales en Posesión de los Particulares (en adelante la \"Ley\") y demás disposiciones aplicables.\n\nI. Identidad y Domicilio del Responsable.\n\nEl responsable del tratamiento de sus datos personales es Laboratorio Renteria.\n\nII. Datos Personales Sometidos a Tratamiento.\n\nLos datos personales que El Laboratorio recaba de usted son los necesarios para llevar a cabo sus funciones específicas en el ámbito químico, pudiendo incluir, de manera enunciativa más no limitativa, los siguientes datos:\n\n- Información de identificación personal (nombre, dirección, correo electrónico, teléfono).\n- Datos académicos y profesionales.\n- Información relacionada con análisis y resultados de pruebas químicas.\nIII. Finalidades del Tratamiento.\n\nLos datos personales recabados serán utilizados única y exclusivamente para los siguientes fines:\n\nRealizar análisis químicos y pruebas correspondientes en el laboratorio.\nGenerar informes y resultados de las pruebas realizadas.\nCumplir con obligaciones legales en materia de control y registro de sustancias químicas.\nMantener comunicación con usted para informar sobre los resultados de las pruebas y cualquier información relevante.\nIV. Transferencia de Datos.\n\nEl Laboratorio se compromete a no transferir sus datos personales a terceros, salvo en los casos previstos por la Ley y previo consentimiento expreso del titular.\n\nV. Medios para el Ejercicio de Derechos ARCO.\n\nUsted tiene derecho a Acceder, Rectificar, Cancelar u Oponerse al tratamiento de sus datos personales (derechos ARCO). Para ejercer estos derechos, deberá presentar una solicitud por escrito en el domicilio de El Laboratorio, incluyendo la siguiente información:\n\nNombre del titular y dirección de correo electrónico para comunicar la respuesta a su solicitud.\nDocumentos que acrediten la identidad o, en su caso, la representación legal del titular.\nDescripción clara y precisa de los datos personales respecto de los cuales se busca ejercer alguno de los derechos ARCO.\nVI. Seguridad de los Datos Personales.\n\nEl Laboratorio implementa medidas de seguridad administrativas, técnicas y físicas para proteger sus datos personales y evitar su pérdida, alteración, destrucción, uso, acceso o divulgación no autorizados.\n\nVII. Cambios al Aviso de Privacidad.\n\nEl presente aviso de privacidad puede ser modificado en el futuro. Cualquier modificación será notificada a través de los medios de contacto proporcionados por el titular.\n\nVIII. Legislación Aplicable.\n\nEste aviso de privacidad se rige por la legislación aplicable en Mexico.\n\nFecha de última actualización: 19-01-2024\n\nRonaldo Gabriel Garcia Cuevas\nLaboratorio Renteria\n\n\n\n");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1119, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AvisodePrivacidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AvisodePrivacidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AvisodePrivacidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AvisodePrivacidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AvisodePrivacidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
