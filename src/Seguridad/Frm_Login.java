/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad;

import Model.Users;
import dao.DaoUsers;
import dao.impl.DaoUserImpl;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import static tool.Convierte.aInteger;

/**
 *
 * @author Gustavo
 */
public class Frm_Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Frm_Login() {
        initComponents();
        setTitle("Gestión de Almacenes");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpn_login = new javax.swing.JPanel();
        txt_user = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        lbl_user = new javax.swing.JLabel();
        lbl_password = new javax.swing.JLabel();
        btn_accept = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 102));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jpn_login.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));
        jpn_login.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpn_loginKeyPressed(evt);
            }
        });

        txt_user.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_userKeyPressed(evt);
            }
        });

        txt_password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_passwordKeyPressed(evt);
            }
        });

        jLabel6.setText("  ");

        lbl_user.setText("Usuario");

        lbl_password.setText("Contraseña");

        javax.swing.GroupLayout jpn_loginLayout = new javax.swing.GroupLayout(jpn_login);
        jpn_login.setLayout(jpn_loginLayout);
        jpn_loginLayout.setHorizontalGroup(
            jpn_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpn_loginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jpn_loginLayout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jpn_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_user)
                    .addComponent(lbl_password))
                .addGap(61, 61, 61)
                .addGroup(jpn_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jpn_loginLayout.setVerticalGroup(
            jpn_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpn_loginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addGroup(jpn_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_user)
                    .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jpn_loginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_password)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        btn_accept.setText("Aceptar");
        btn_accept.setMaximumSize(new java.awt.Dimension(73, 23));
        btn_accept.setMinimumSize(new java.awt.Dimension(73, 23));
        btn_accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acceptActionPerformed(evt);
            }
        });
        btn_accept.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_acceptKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btn_acceptKeyTyped(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpn_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btn_accept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancel)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpn_login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_accept, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
//        JOptionPane.showMessageDialog(this, "Está saliendo del ");
//        System.exit(0);
        String message = "¿Está seguro que desea salir?";
        String title = "Salir";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        JOptionPane.setDefaultLocale(null);
        if (reply == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            DaoUsers daoUsers = new DaoUserImpl();

            String pass = new String(txt_password.getPassword());
            Integer id = aInteger(txt_user.getText());
            Integer perfil = daoUsers.login((txt_user.getText()), pass);
            Users user = daoUsers.usersGet(id);
            String name = null;
            
            //validar la clave  sino la cambiamos
            if (perfil != 0) {
                Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
                if (flagpwd == 0) {
                    Frm_Change_Password_user frm_ChangePassword = new Frm_Change_Password_user(this,id);
                    frm_ChangePassword.setVisible(true);
                    frm_ChangePassword.setLocationRelativeTo(null);
                    JOptionPane.showMessageDialog(this, "Su contraseña ha expirado y debe cambiarla");
                    txt_user.setText("");
                    txt_password.setText("");
                }
            }

            if (perfil == 1) {
                Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
                if (flagpwd == 1) {
                    Frm_MenuPrincipal mp = new Frm_MenuPrincipal(this,user);
                    mp.setVisible(true);
                    mp.setExtendedState(MAXIMIZED_BOTH);
                    this.setVisible(false);
                }
            }
            if (perfil == 0) {
                JOptionPane.showMessageDialog(this, "Usuario/Contraseña incorrectas");
            }
            txt_user.setText("");
            txt_password.setText("");

        }

    }//GEN-LAST:event_formKeyPressed

    private void jpn_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpn_loginKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            DaoUsers daoUsers = new DaoUserImpl();
            String pass = new String(txt_password.getPassword());
            Integer id = aInteger(txt_user.getText());
            Integer perfil = daoUsers.login((txt_user.getText()), pass);
            Users user = daoUsers.usersGet(id);
            
            //validar la clave  sino la cambiamos
            if (perfil != 0) {
                Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
                if (flagpwd == 0) {
                    Frm_Change_Password_user frm_ChangePassword = new Frm_Change_Password_user(this,id);
                    frm_ChangePassword.setVisible(true);
                    frm_ChangePassword.setLocationRelativeTo(null);
                    JOptionPane.showMessageDialog(this, "Su contraseña ha expirado y debe cambiarla");
                    txt_user.setText("");
                    txt_password.setText("");
                }
            }

            if (perfil == 1) {
                Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
                if (flagpwd == 1) {
                   
                    Frm_MenuPrincipal mp = new Frm_MenuPrincipal(this,user);
                    mp.setVisible(true);
                    mp.setExtendedState(MAXIMIZED_BOTH);
                    this.setVisible(false);
                }
            }
            if (perfil == 0) {
                JOptionPane.showMessageDialog(this, "Usuario/Contraseña incorrectas");
            }
            txt_user.setText("");
            txt_password.setText("");

        }
    }//GEN-LAST:event_jpn_loginKeyPressed

    private void btn_acceptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_acceptKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            DaoUsers daoUsers = new DaoUserImpl();

            String pass = new String(txt_password.getPassword());
            Integer id = aInteger(txt_user.getText());
            Integer perfil = daoUsers.login((txt_user.getText()), pass);
            Users user = daoUsers.usersGet(id);
            
            //validar la clave  sino la cambiamos
            if (perfil != 0) {
                Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
                if (flagpwd == 0) {
                    Frm_Change_Password_user frm_ChangePassword = new Frm_Change_Password_user(this,id);
                    frm_ChangePassword.setVisible(true);
                    frm_ChangePassword.setLocationRelativeTo(null);
                    JOptionPane.showMessageDialog(this, "Su contraseña ha expirado y debe cambiarla");
                    txt_user.setText("");
                    txt_password.setText("");
                }
            }
            if (perfil == 1) {
                Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
                if (flagpwd == 1) {
                    Frm_MenuPrincipal mp = new Frm_MenuPrincipal(this,user);
                    mp.setVisible(true);
                    mp.setExtendedState(MAXIMIZED_BOTH);
                    this.setVisible(false);
                }
            }
            if (perfil == 0) {
                JOptionPane.showMessageDialog(this, "Usuario/Contraseña incorrectas");
            }
            txt_user.setText("");
            txt_password.setText("");

        }
    }//GEN-LAST:event_btn_acceptKeyPressed

    private void btn_acceptKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_acceptKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_acceptKeyTyped

    private void btn_acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acceptActionPerformed

        DaoUsers daoUsers = new DaoUserImpl();

        String pass = new String(txt_password.getPassword());
        Integer id = aInteger(txt_user.getText());
        Integer perfil = daoUsers.login((txt_user.getText()), pass);
        Users user = daoUsers.usersGet(id);
          
        //validar la clave  sino la cambiamos
        if (perfil != 0) {
            Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
            if (flagpwd == 0) {
                Frm_Change_Password_user frm_ChangePassword = new Frm_Change_Password_user(this,id);
                frm_ChangePassword.setVisible(true);
                frm_ChangePassword.setLocationRelativeTo(null);
                JOptionPane.showMessageDialog(this, "Su contraseña ha expirado y debe cambiarla");
                txt_user.setText("");
                txt_password.setText("");
            }
        }
        if (perfil == 1) {

            Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
            if (flagpwd == 1) {
                Frm_MenuPrincipal mp = new Frm_MenuPrincipal(this,user);
                mp.setVisible(true);
                mp.setExtendedState(MAXIMIZED_BOTH);
                this.setVisible(false);
            }
        }
        if (perfil == 0) {
            JOptionPane.showMessageDialog(this, "Usuario/Contraseña incorrectas");
        }

        txt_password.setText("");
        txt_user.setText("");
    }//GEN-LAST:event_btn_acceptActionPerformed

    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            DaoUsers daoUsers = new DaoUserImpl();

            String pass = new String(txt_password.getPassword());
            Integer id = aInteger(txt_user.getText());
            Integer perfil = daoUsers.login((txt_user.getText()), pass);
            Users user = daoUsers.usersGet(id);
            
            //validar la clave  sino la cambiamos
            if (perfil != 0) {
                Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
                if (flagpwd == 0) {
                    Frm_Change_Password_user frm_ChangePassword = new Frm_Change_Password_user(this,id);
                    frm_ChangePassword.setVisible(true);
                    frm_ChangePassword.setLocationRelativeTo(null);
                    JOptionPane.showMessageDialog(this, "Su contraseña ha expirado y debe cambiarla");
                    txt_user.setText("");
                    txt_password.setText("");
                }
            }
            if (perfil == 1) {
                Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
                if (flagpwd == 1) {
                    Frm_MenuPrincipal mp = new Frm_MenuPrincipal(this,user);
                    mp.setVisible(true);
                    mp.setExtendedState(MAXIMIZED_BOTH);
                    this.setVisible(false);
                }
            }
            if (perfil == 0) {
                JOptionPane.showMessageDialog(this, "Usuario/Contraseña incorrectas");
            }
            txt_user.setText("");
            txt_password.setText("");

        }
    }//GEN-LAST:event_txt_passwordKeyPressed

    private void txt_userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_userKeyPressed
        // TODO add your handling code here:
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            DaoUsers daoUsers = new DaoUserImpl();

            String pass = new String(txt_password.getPassword());
            Integer id = aInteger(txt_user.getText());
            Integer perfil = daoUsers.login((txt_user.getText()), pass);
            Users user = daoUsers.usersGet(id);
            
            //validar la clave  sino la cambiamos
            if (perfil != 0) {
                Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
                if (flagpwd == 0) {
                    Frm_Change_Password_user frm_ChangePassword = new Frm_Change_Password_user(this,id);
                    frm_ChangePassword.setVisible(true);
                    frm_ChangePassword.setLocationRelativeTo(null);
                    JOptionPane.showMessageDialog(this, "Su contraseña ha expirado y debe cambiarla");
                    txt_user.setText("");
                    txt_password.setText("");
                }
            }
            if (perfil == 1) {
                Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
                if (flagpwd == 1) {
                    Frm_MenuPrincipal mp = new Frm_MenuPrincipal(this,user);
                    mp.setVisible(true);
                    mp.setExtendedState(MAXIMIZED_BOTH);
                    this.setVisible(false);
                }
            }
            if (perfil == 0) {
                JOptionPane.showMessageDialog(this, "Usuario/Contraseña incorrectas");
            }
            txt_user.setText("");
            txt_password.setText("");

        }
    }//GEN-LAST:event_txt_userKeyPressed

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
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_accept;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jpn_login;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
