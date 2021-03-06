/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Seguridad;

import Mantenimientos.*;
import Model.Log;
import Model.Profile;
import Model.ProfileWindow;
import dao.DaoLog;
import dao.DaoProfile;
import dao.impl.DaoLogImpl;
import dao.impl.DaoProfileImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Luigi
 */
public class Frm_Profile extends javax.swing.JFrame {

    /**
     * Creates new form Frm_perfil
     */
    Frm_Profile_Search menu_padre = new Frm_Profile_Search();
    
    Profile profile;    
    DaoProfile daoProfile = new DaoProfileImpl();
        List<ProfileWindow> profileWindowList = new ArrayList<>();
    
    public Frm_Profile(Frm_Profile_Search menu) {
        setTitle("Mantenimiento de Perfiles"); 
        menu_padre = menu;
        initComponents();        
    }
    
    public Frm_Profile() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_profile = new javax.swing.JPanel();
        lbl_name = new javax.swing.JLabel();
        lbl_description = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        txt_description = new javax.swing.JTextField();
        lbl_obligatory_field = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnl_profile.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        lbl_name.setText("Nombre (*)");

        lbl_description.setText("Descripción");

        lbl_obligatory_field.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        lbl_obligatory_field.setText("(*) Campos Obligatorios");

        javax.swing.GroupLayout pnl_profileLayout = new javax.swing.GroupLayout(pnl_profile);
        pnl_profile.setLayout(pnl_profileLayout);
        pnl_profileLayout.setHorizontalGroup(
            pnl_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_profileLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnl_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_obligatory_field)
                    .addGroup(pnl_profileLayout.createSequentialGroup()
                        .addGroup(pnl_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_name)
                            .addComponent(lbl_description))
                        .addGap(42, 42, 42)
                        .addGroup(pnl_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_description, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        pnl_profileLayout.setVerticalGroup(
            pnl_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_profileLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(pnl_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_name))
                .addGap(27, 27, 27)
                .addGroup(pnl_profileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_description))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(lbl_obligatory_field))
        );

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_save.setText("Guardar");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btn_save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancel)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_cancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       
    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.dispose();
        menu_padre.setVisible(true);
        menu_padre.initializeTable();
    }//GEN-LAST:event_btn_cancelActionPerformed
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        menu_padre.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        profile = new Profile();
        Integer idProfile;
        profile.setName(txt_name.getText().trim());
        profile.setDescription(txt_description.getText().trim());        
        
        Object[] options = {"OK"};
        if (JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?",
                "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (profileValidatedToSave(profile.getName())) {
                daoProfile.profileIns(profile);
                idProfile = daoProfile.profileMaxIdGet();                
                profileWindowList = daoProfile.windowsGet(idProfile);
                for (int i = 0; i < profileWindowList.size(); i++) {
                    daoProfile.profileWindowIns(profileWindowList.get(i));
                }
                DaoLog daoLog =new DaoLogImpl();
                Log logSI = null; 
                daoLog.clientIns("Se ha ingresado un nuevo perfil al sistema con ID " + profile.getName(), Frm_Profile.class.toString(), logSI.getIduser());
                int ok_option = JOptionPane.showOptionDialog(new JFrame(), "Se ha registrado el perfil con éxito", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (ok_option == JOptionPane.OK_OPTION) {
                    menu_padre.setVisible(true);
                    menu_padre.setLocationRelativeTo(null);
                    menu_padre.initializeTable();
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed
    
    private boolean profileValidatedToSave(String name){
        String empty = "";
        if(empty.equals(name)) {
            JOptionPane.showMessageDialog(null,"El nombre de perfil no puede ser vacio", 
                        "Advertencias", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (daoProfile.existsProfileName(name)){
            JOptionPane.showMessageDialog(null,"El nombre de perfil ya existe", 
                        "Advertencias", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (daoProfile.profileMaxIdGet()==-1){
            JOptionPane.showMessageDialog(null,"No se pudieron asignar los permisos", 
                        "Advertencias", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        if (name.length()>128){
            JOptionPane.showMessageDialog(null,"El nombre del perfil es muy largo", 
                        "Advertencias", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Frm_rack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Frm_rack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Frm_rack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Frm_rack.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Frm_rack().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel lbl_description;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_obligatory_field;
    private javax.swing.JPanel pnl_profile;
    private javax.swing.JTextField txt_description;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
}
