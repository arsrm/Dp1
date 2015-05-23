package Seguridad;

import dao.DaoUsers;
import dao.impl.DaoUserImpl;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static tool.Convierte.aInteger;

public class Frm_Change_Password_Admin extends javax.swing.JFrame {

    Frm_MenuPrincipal menuaux= new Frm_MenuPrincipal();
    
    public Frm_Change_Password_Admin(Frm_MenuPrincipal menu) {
        menuaux = menu ;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_id_user = new javax.swing.JLabel();
        txt_id_user = new javax.swing.JTextField();
        lbl_new_password = new javax.swing.JLabel();
        txt_new_password = new javax.swing.JPasswordField();
        lbl_confirm_password = new javax.swing.JLabel();
        txt_confirm_password = new javax.swing.JPasswordField();
        btn_save = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        lbl_id_user.setText("ID Usuario");

        lbl_new_password.setText("Nueva Contraseña");

        lbl_confirm_password.setText("Confirmar Contraseña");

        txt_confirm_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_confirm_passwordActionPerformed(evt);
            }
        });

        btn_save.setText("Guardar");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Restablecer Contraseña");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_save)
                .addGap(18, 18, 18)
                .addComponent(btn_cancel)
                .addGap(39, 39, 39))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_id_user)
                            .addComponent(lbl_new_password)
                            .addComponent(lbl_confirm_password))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_id_user, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addComponent(txt_new_password)
                            .addComponent(txt_confirm_password)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel4)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id_user)
                    .addComponent(txt_id_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_new_password)
                    .addComponent(txt_new_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_confirm_password)
                    .addComponent(txt_confirm_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_cancel))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_confirm_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_confirm_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_confirm_passwordActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
       
        String pass = new String(txt_new_password.getPassword());
       String  pass_new = new String(txt_confirm_password.getPassword());
         
         
        DaoUsers daoUsers = new DaoUserImpl();
        Integer id = aInteger(txt_id_user.getText());
        
        if((daoUsers.usersGet(id)!=null)){
           if(pass.compareTo(pass_new)==0){
                   Object[] options = {"OK"};
                if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
                    "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
                    int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se ha creado la clave con éxito","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(ok_option==JOptionPane.OK_OPTION){
                        Integer flag =0;
                        String result= daoUsers.setpasword(id,pass,flag);
                        txt_id_user.setText("");
                        txt_new_password.setText("");
                        txt_confirm_password.setText("");
                        this.setVisible(true);
                        
                        
                    }
                } 
            }
            else {
                JOptionPane.showMessageDialog(this, "Las contraseñas deben ser iguales");

            }
        }
        else {
            JOptionPane.showMessageDialog(this, "El usuario no existe");
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        menuaux.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl_confirm_password;
    private javax.swing.JLabel lbl_id_user;
    private javax.swing.JLabel lbl_new_password;
    private javax.swing.JPasswordField txt_confirm_password;
    private javax.swing.JTextField txt_id_user;
    private javax.swing.JPasswordField txt_new_password;
    // End of variables declaration//GEN-END:variables
}
