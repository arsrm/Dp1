package Mantenimientos;

import Model.Distribution_Center;
import Model.Log;
import Model.Profile;
import Model.Users;
import dao.DaoDistributionCenter;
import dao.DaoLog;
import dao.DaoProfile;
import dao.DaoUsers;
import dao.impl.DaoDistributionCenterImpl;
import dao.impl.DaoLogImpl;
import dao.impl.DaoProfileImpl;
import dao.impl.DaoUserImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static tool.Convierte.aInteger;
import static tool.Convierte.esNumero;
import static tool.Convierte.esString;

public class Frm_User extends javax.swing.JFrame {

    Frm_User_Search frm_user_search = new Frm_User_Search();
    String pwdgenerica = "123456";
    DaoUsers daoUsers = new DaoUserImpl();
    DaoDistributionCenter daoDC = new DaoDistributionCenterImpl();
    ArrayList<Distribution_Center> distribution_centers = new ArrayList<>();
    DaoProfile daoprofile = new DaoProfileImpl();
    List<Profile> profile = new ArrayList<Profile>();
    Integer flag = 1; //si esta habilidato el dni por defecto esta activado

    public Frm_User(Frm_User_Search user_menu, Users user) {
        setTitle("Mantenimiento de Usuarios");
        frm_user_search = user_menu;
        initComponents();
        if (user != null) {
            pwdgenerica = user.getPassword();
        }
        if (user != null) { //para el update
            int num_item = 0;
            distribution_centers = daoDC.distribution_centerGetQry();
            for (int i = 0; i < distribution_centers.size(); i++) {
                this.cbo_center.addItem(distribution_centers.get(i).getName());
                if (distribution_centers.get(i).getIdDistribution_Center() == user.getDistribution_Center_idDistribution_Center()) {
                    num_item = i;
                }
            }
            cbo_center.setSelectedIndex(num_item);
            num_item = -1;
            profile = daoprofile.profileCbo1();
            this.cbo_profile.addItem("");
            for (int i = 0; i < profile.size(); i++) {
                this.cbo_profile.addItem(profile.get(i).getName());
                if (profile.get(i).getIdprofile() == user.getProfile_idProfile()) {
                    num_item = i;
                }
            }
            if (num_item == -1) {
                cbo_profile.setSelectedIndex(0);
            }
            cbo_profile.setSelectedIndex(num_item + 1);
            txt_id.setText(user.getIdUser().toString());
            txt_id.setEnabled(false);
            flag = 0;//para usaruis nuevos
            txt_name.setText(user.getname());
        } else {
            distribution_centers = daoDC.distribution_centerGetQry();
            for (int i = 0; i < distribution_centers.size(); i++) {
                this.cbo_center.addItem(distribution_centers.get(i).getName());
            }
            profile = daoprofile.profileCbo1();
            this.cbo_profile.addItem("");
            for (int i = 0; i < profile.size(); i++) {
                this.cbo_profile.addItem(profile.get(i).getName());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_user = new javax.swing.JPanel();
        lbl_center = new javax.swing.JLabel();
        cbo_center = new javax.swing.JComboBox();
        lbl_profile = new javax.swing.JLabel();
        cbo_profile = new javax.swing.JComboBox();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lbl_name = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnl_user.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));
        pnl_user.setToolTipText("");

        lbl_center.setText("Centro de Distribución");

        cbo_center.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_centerActionPerformed(evt);
            }
        });

        lbl_profile.setText("Perfil de Usuario");

        cbo_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_profileActionPerformed(evt);
            }
        });

        lbl_id.setText("DNI");

        lbl_name.setText("Nombres");

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_userLayout = new javax.swing.GroupLayout(pnl_user);
        pnl_user.setLayout(pnl_userLayout);
        pnl_userLayout.setHorizontalGroup(
            pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_userLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_center)
                    .addComponent(lbl_profile)
                    .addComponent(lbl_id)
                    .addComponent(lbl_name))
                .addGap(18, 18, 18)
                .addGroup(pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbo_profile, 0, 400, Short.MAX_VALUE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(cbo_center, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnl_userLayout.setVerticalGroup(
            pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_userLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_center)
                    .addComponent(cbo_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_profile)
                    .addComponent(cbo_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_name)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btn_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cancel)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_cancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:

        String input = txt_id.getText();

        Pattern pat = Pattern.compile("^[^a-zA-ZñÑ@'$%#@^&*()}{||;:><.,/?]+");
        Matcher mat = pat.matcher(input);

        if (!mat.matches()) {
            JOptionPane.showMessageDialog(this, "El valor en el campo usario debe ser un valor numerico");
        } else {

            if (txt_id.getText().length() != 8) {
                JOptionPane.showMessageDialog(this, "El valor del campo Usuario debe tener 8 digitos");
            } else {

                if (txt_id.getText().length() == 0 || txt_name.getText().length() == 0) {
                    JOptionPane.showMessageDialog(this, "Por favor completar todos los campos del formulario");

                } else {

                    if (((String) cbo_profile.getSelectedItem()).equals("") == true) {
                        JOptionPane.showMessageDialog(this, "Por favor seleccionar un perfil");
                    } else {

                        if ((flag == 1) && (daoUsers.usersGet(aInteger(txt_id.getText())) != null)) { //si el flag esta activado es un usario nuevo

                            JOptionPane.showMessageDialog(this, "El usuario ya se encuentra registrado");

                        }
                        else {

                        Object[] options = {"OK"};
                        if (JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?",
                                "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            int ok_option = JOptionPane.showOptionDialog(new JFrame(), "Se ha registrado al usuario con éxito", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                            if (ok_option == JOptionPane.OK_OPTION) {
                                Users users = new Users();
                                users.setIdUser(aInteger(txt_id.getText()));
                                users.setname(txt_name.getText());

                                users.setPassword(pwdgenerica);
                                users.setPassword_change(1);
                                users.setStatus(1);
                                DaoDistributionCenter daoDistributionCenter = new DaoDistributionCenterImpl();

                                users.setDistribution_Center_idDistribution_Center(daoDistributionCenter.distribution_centerGet((String) cbo_center.getSelectedItem()).getIdDistribution_Center());
                                DaoProfile daoProfile = new DaoProfileImpl();
                                users.setProfile_idProfile(daoProfile.usersGet((String) cbo_profile.getSelectedItem()).getIdprofile());
                                DaoLog daoLog = new DaoLogImpl();
                                Log logSI = null;

                                if (daoUsers.usersGet(users.getIdUser()) == null) {

                                    users.setPassword_change(0);
                                    daoUsers.usersIns(users);
                                    daoLog.clientIns("Se ha ingresado un nuevo usuario al sistema con ID " + users.getIdUser().toString(), Frm_User.class.toString(), logSI.getIduser());

                                } else {
                                    daoUsers.usersUpd(users);
                                    daoLog.clientIns("Se ha actualizado un usuario al sistema con ID " + users.getIdUser().toString(), Frm_User.class.toString(), logSI.getIduser());
                                }
                                frm_user_search.setVisible(true);
                                frm_user_search.setLocationRelativeTo(null);
                                this.dispose();
                                frm_user_search.initilizeTable();

                            }
                        }
                        //
                    }}
                    //   
                }
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
        frm_user_search.setVisible(true);

    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.dispose();
        frm_user_search.setVisible(true);

    }//GEN-LAST:event_formWindowClosed

    private void cbo_centerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_centerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_centerActionPerformed

    private void cbo_profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_profileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_profileActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox cbo_center;
    private javax.swing.JComboBox cbo_profile;
    private javax.swing.JLabel lbl_center;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_profile;
    private javax.swing.JPanel pnl_user;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
}
