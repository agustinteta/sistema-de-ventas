/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views;

/**
 *
 * @author Usuario01
 */
public class registros extends javax.swing.JFrame {

    /**
     * Creates new form registros
     */
    public registros() {
        initComponents();
        this.setLocationRelativeTo(this);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondo = new javax.swing.JPanel();
        jLabelRegistro = new javax.swing.JLabel();
        jLabelNomUs = new javax.swing.JLabel();
        jTextNomUs = new javax.swing.JTextField();
        jSeparatorUsuario = new javax.swing.JSeparator();
        jLabelContrasenia = new javax.swing.JLabel();
        jPasscontrasenia = new javax.swing.JPasswordField();
        jSeparatorContrasenia = new javax.swing.JSeparator();
        jLabelNomYap = new javax.swing.JLabel();
        jTextNomYap = new javax.swing.JTextField();
        jSeparNomYap = new javax.swing.JSeparator();
        jLabelCorreo = new javax.swing.JLabel();
        jTextCorreo = new javax.swing.JTextField();
        jSeparaCorreo = new javax.swing.JSeparator();
        jLabelTelefono = new javax.swing.JLabel();
        jTextTelefono = new javax.swing.JTextField();
        jSeparaTelefono = new javax.swing.JSeparator();
        jLabelDNI = new javax.swing.JLabel();
        jTextDNI = new javax.swing.JTextField();
        jSeparaDNI = new javax.swing.JSeparator();
        jLabelTipoUs = new javax.swing.JLabel();
        jComboUs = new javax.swing.JComboBox<>();
        JSparaTipoUs = new javax.swing.JSeparator();
        jBtnVolver = new javax.swing.JButton();
        jBtnRegistrarse = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fondo.setBackground(new java.awt.Color(1, 112, 100));
        fondo.setForeground(new java.awt.Color(100, 96, 164));

        jLabelRegistro.setFont(new java.awt.Font("Roboto Light", 1, 24)); // NOI18N
        jLabelRegistro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRegistro.setText("Registro");

        jLabelNomUs.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomUs.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabelNomUs.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNomUs.setText("Nombre  de Usuario ");

        jTextNomUs.setBackground(new java.awt.Color(1, 112, 100));
        jTextNomUs.setBorder(null);

        jSeparatorUsuario.setBackground(new java.awt.Color(10, 173, 186));

        jLabelContrasenia.setBackground(new java.awt.Color(255, 255, 255));
        jLabelContrasenia.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabelContrasenia.setForeground(new java.awt.Color(255, 255, 255));
        jLabelContrasenia.setText("Contraseña");

        jPasscontrasenia.setBackground(new java.awt.Color(1, 112, 100));
        jPasscontrasenia.setBorder(null);

        jSeparatorContrasenia.setBackground(new java.awt.Color(10, 173, 186));

        jLabelNomYap.setBackground(new java.awt.Color(255, 255, 255));
        jLabelNomYap.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabelNomYap.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNomYap.setText("Nombre y Apellido");

        jTextNomYap.setBackground(new java.awt.Color(1, 112, 100));
        jTextNomYap.setBorder(null);
        jTextNomYap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextNomYapMousePressed(evt);
            }
        });

        jSeparNomYap.setBackground(new java.awt.Color(10, 173, 186));

        jLabelCorreo.setBackground(new java.awt.Color(255, 255, 255));
        jLabelCorreo.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabelCorreo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCorreo.setText("Correo Electronico");

        jTextCorreo.setBackground(new java.awt.Color(1, 112, 100));
        jTextCorreo.setBorder(null);

        jSeparaCorreo.setBackground(new java.awt.Color(10, 173, 186));

        jLabelTelefono.setBackground(new java.awt.Color(255, 255, 255));
        jLabelTelefono.setFont(new java.awt.Font("Roboto Light", 1, 12)); // NOI18N
        jLabelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefono.setText("Telefono");

        jTextTelefono.setBackground(new java.awt.Color(1, 112, 100));
        jTextTelefono.setBorder(null);
        jTextTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextTelefonoActionPerformed(evt);
            }
        });

        jSeparaTelefono.setBackground(new java.awt.Color(10, 173, 186));

        jLabelDNI.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDNI.setText("DNI");

        jTextDNI.setBackground(new java.awt.Color(1, 112, 100));
        jTextDNI.setBorder(null);

        jLabelTipoUs.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTipoUs.setText("Tipo de Usuario");

        jComboUs.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Vendedor", "Servicio tecnico", "Administrador", " " }));
        jComboUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboUsActionPerformed(evt);
            }
        });

        jBtnVolver.setBackground(new java.awt.Color(1, 130, 160));
        jBtnVolver.setText("Volver");
        jBtnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnVolverActionPerformed(evt);
            }
        });

        jBtnRegistrarse.setBackground(new java.awt.Color(1, 130, 160));
        jBtnRegistrarse.setText("Registrarse");
        jBtnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRegistrarseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fondoLayout = new javax.swing.GroupLayout(fondo);
        fondo.setLayout(fondoLayout);
        fondoLayout.setHorizontalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabelRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fondoLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(fondoLayout.createSequentialGroup()
                                .addComponent(jBtnVolver)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                                .addComponent(jBtnRegistrarse))
                            .addComponent(jLabelNomUs)
                            .addComponent(jLabelContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNomUs)
                            .addComponent(jSeparatorUsuario)
                            .addComponent(jPasscontrasenia)
                            .addComponent(jSeparatorContrasenia)
                            .addComponent(jLabelNomYap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextNomYap)
                            .addComponent(jSeparNomYap)
                            .addComponent(jTextCorreo)
                            .addComponent(jSeparaCorreo)
                            .addComponent(jLabelTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextTelefono)
                            .addComponent(jSeparaTelefono)
                            .addComponent(jLabelDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDNI)
                            .addComponent(jSeparaDNI)
                            .addComponent(jLabelCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTipoUs, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboUs, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JSparaTipoUs))))
                .addContainerGap(75, Short.MAX_VALUE))
        );
        fondoLayout.setVerticalGroup(
            fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fondoLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabelRegistro)
                .addGap(39, 39, 39)
                .addComponent(jLabelNomYap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextNomYap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparNomYap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDNI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparaDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jSeparaCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTelefono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparaTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelNomUs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextNomUs, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelTipoUs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jComboUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(JSparaTipoUs, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabelContrasenia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasscontrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparatorContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(fondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnVolver)
                    .addComponent(jBtnRegistrarse))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRegistrarseActionPerformed
        
    }//GEN-LAST:event_jBtnRegistrarseActionPerformed

    private void jBtnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnVolverActionPerformed
        this.setVisible(false);
        Login f2 = new Login();
        f2.setVisible(true);
        
        
    }//GEN-LAST:event_jBtnVolverActionPerformed

    private void jTextNomYapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextNomYapMousePressed
        
        
    }//GEN-LAST:event_jTextNomYapMousePressed

    private void jTextTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextTelefonoActionPerformed

    private void jComboUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboUsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboUsActionPerformed

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
            java.util.logging.Logger.getLogger(registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator JSparaTipoUs;
    private javax.swing.JPanel fondo;
    private javax.swing.JButton jBtnRegistrarse;
    private javax.swing.JButton jBtnVolver;
    private javax.swing.JComboBox<String> jComboUs;
    private javax.swing.JLabel jLabelContrasenia;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelNomUs;
    private javax.swing.JLabel jLabelNomYap;
    private javax.swing.JLabel jLabelRegistro;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTipoUs;
    private javax.swing.JPasswordField jPasscontrasenia;
    private javax.swing.JSeparator jSeparNomYap;
    private javax.swing.JSeparator jSeparaCorreo;
    private javax.swing.JSeparator jSeparaDNI;
    private javax.swing.JSeparator jSeparaTelefono;
    private javax.swing.JSeparator jSeparatorContrasenia;
    private javax.swing.JSeparator jSeparatorUsuario;
    private javax.swing.JTextField jTextCorreo;
    private javax.swing.JTextField jTextDNI;
    private javax.swing.JTextField jTextNomUs;
    private javax.swing.JTextField jTextNomYap;
    private javax.swing.JTextField jTextTelefono;
    // End of variables declaration//GEN-END:variables
}