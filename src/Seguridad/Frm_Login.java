package Seguridad;

import Model.Users;
import dao.DaoUsers;
import dao.impl.DaoUserImpl;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import static tool.Convierte.aInteger;

public class Frm_Login extends javax.swing.JFrame {

    public Frm_Login() {
        initComponents();
        setTitle("Gestión de Almacenes");
    }

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
        lbl_log = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 102));
        setMinimumSize(new java.awt.Dimension(507, 310));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jpn_login.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N
        jpn_login.setOpaque(false);
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

        lbl_user.setForeground(new java.awt.Color(255, 255, 255));
        lbl_user.setText("Usuario");

        lbl_password.setForeground(new java.awt.Color(255, 255, 255));
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

        getContentPane().add(jpn_login);
        jpn_login.setBounds(6, 6, 495, 207);

        btn_accept.setText("Aceptar");
        btn_accept.setMaximumSize(new java.awt.Dimension(73, 23));
        btn_accept.setMinimumSize(new java.awt.Dimension(73, 23));
        btn_accept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_acceptActionPerformed(evt);
            }
        });
        btn_accept.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                btn_acceptKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_acceptKeyPressed(evt);
            }
        });
        getContentPane().add(btn_accept);
        btn_accept.setBounds(28, 231, 92, 29);

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancel);
        btn_cancel.setBounds(382, 231, 98, 29);

        lbl_log.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/log.jpg"))); // NOI18N
        lbl_log.setText("    ");
        getContentPane().add(lbl_log);
        lbl_log.setBounds(0, 0, 520, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        String message = "¿Está seguro que desea salir?";
        String title = "Salir";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        JOptionPane.setDefaultLocale(null);
        if (reply == JOptionPane.YES_OPTION) {
            System.exit(0);
        }

    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        /*
         int key = evt.getKeyCode();
         if (key == KeyEvent.VK_ENTER) {
         DaoUsers daoUsers = new DaoUserImpl();

         String pass = new String(txt_password.getPassword());
         Integer id = aInteger(txt_user.getText());
         if (txt_user.getText().length() == 0 || txt_password.getPassword().length == 0) {
         JOptionPane.showMessageDialog(this, "Ingrese un usuario y/o contraseña valida");
         txt_user.setText("");
         txt_password.setText("");
         } else {

         Integer perfil = daoUsers.login((txt_user.getText()), pass);
         Users user = daoUsers.usersGet(id);

         //validar la clave  sino la cambiamos
         if (perfil != 0) {
         Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
         if (flagpwd == 0) {
         Frm_Change_Password_user frm_ChangePassword = new Frm_Change_Password_user(this, id);
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
         Frm_MenuPrincipal mp = new Frm_MenuPrincipal(this, user);
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
         }
         }
         */
    }//GEN-LAST:event_formKeyPressed

    private void jpn_loginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpn_loginKeyPressed
        // TODO add your handling code here:
        /*
         int key = evt.getKeyCode();
         if (key == KeyEvent.VK_ENTER) {
         DaoUsers daoUsers = new DaoUserImpl();

         String pass = new String(txt_password.getPassword());
         Integer id = aInteger(txt_user.getText());
         if (txt_user.getText().length() == 0 || txt_password.getPassword().length == 0) {
         JOptionPane.showMessageDialog(this, "Ingrese un usuario y/o contraseña valida");
         txt_user.setText("");
         txt_password.setText("");
         } else {

         Integer perfil = daoUsers.login((txt_user.getText()), pass);
         Users user = daoUsers.usersGet(id);

         //validar la clave  sino la cambiamos
         if (perfil != 0) {
         Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
         if (flagpwd == 0) {
         Frm_Change_Password_user frm_ChangePassword = new Frm_Change_Password_user(this, id);
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
         Frm_MenuPrincipal mp = new Frm_MenuPrincipal(this, user);
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
         }
         }
         */
    }//GEN-LAST:event_jpn_loginKeyPressed

    private void btn_acceptKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_acceptKeyPressed
        // TODO add your handling code here:
        /*
         int key = evt.getKeyCode();
         if (key == KeyEvent.VK_ENTER) {
         DaoUsers daoUsers = new DaoUserImpl();

         String pass = new String(txt_password.getPassword());
         Integer id = aInteger(txt_user.getText());
         if (txt_user.getText().length() == 0 || txt_password.getPassword().length == 0) {
         JOptionPane.showMessageDialog(this, "Ingrese un usuario y/o contraseña valida");
         txt_user.setText("");
         txt_password.setText("");
         } else {

         Integer perfil = daoUsers.login((txt_user.getText()), pass);
         Users user = daoUsers.usersGet(id);

         //validar la clave  sino la cambiamos
         if (perfil != 0) {
         Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
         if (flagpwd == 0) {
         Frm_Change_Password_user frm_ChangePassword = new Frm_Change_Password_user(this, id);
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
         Frm_MenuPrincipal mp = new Frm_MenuPrincipal(this, user);
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
         }
         }*/
    }//GEN-LAST:event_btn_acceptKeyPressed

    private void btn_acceptKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_acceptKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_acceptKeyTyped

    private void btn_acceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_acceptActionPerformed

        String input = txt_user.getText();

        Pattern pat = Pattern.compile("^[^a-zA-ZñÑ@'$%#@^&*()}{||;:><.,/?]+");
        Matcher mat = pat.matcher(input);

        if (!mat.matches()) {
            JOptionPane.showMessageDialog(this, "El valor en el campo usario debe ser un valor numerico");
        } else {

            if (txt_user.getText().length() != 8) {
                JOptionPane.showMessageDialog(this, "El valor del campo Usuario debe tener 8 digitos");
            } else {
                DaoUsers daoUsers = new DaoUserImpl();
                String pass = new String(txt_password.getPassword());
                Integer id = aInteger(txt_user.getText());
                if (txt_user.getText().length() == 0 || txt_password.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(this, "Ingrese un usuario y/o contraseña valida");
                    txt_user.setText("");
                    txt_password.setText("");
                } else {

                    Integer perfil = daoUsers.login((txt_user.getText()), pass);
                    Users user = daoUsers.usersGet(id);

                    //validar la clave  sino la cambiamos
                    if (perfil != 0) {
                        Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
                        if (flagpwd == 0) {
                            Frm_Change_Password_user frm_ChangePassword = new Frm_Change_Password_user(this, id);
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
                            Frm_MenuPrincipal mp = new Frm_MenuPrincipal(this, user);
                            mp.setVisible(true);
                            mp.setExtendedState(MAXIMIZED_BOTH);
                            this.setVisible(false);
                        }
                    }
                    if (perfil == 0) {
                        JOptionPane.showMessageDialog(this, "Usuario y/o Contraseña incorrectas");
                    }

                    txt_password.setText("");
                    txt_user.setText("");
                }
            }
        }
    }//GEN-LAST:event_btn_acceptActionPerformed


    private void txt_passwordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_passwordKeyPressed
        // TODO add your handling code here:si va

        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            String input = txt_user.getText();

            Pattern pat = Pattern.compile("^[^a-zA-ZñÑ@'$%#@^&*()}{||;:><.,/?]+");
            Matcher mat = pat.matcher(input);

            if (!mat.matches()) {
                JOptionPane.showMessageDialog(this, "El valor en el campo usario debe ser un valor numerico");
            } else {

                if (txt_user.getText().length() != 8) {
                    JOptionPane.showMessageDialog(this, "El valor del campo Usuario debe tener 8 digitos");
                } else {

                    DaoUsers daoUsers = new DaoUserImpl();
                    String pass = new String(txt_password.getPassword());
                    Integer id = aInteger(txt_user.getText());
                    if (txt_user.getText().length() == 0 || txt_password.getPassword().length == 0) {
                        JOptionPane.showMessageDialog(this, "Ingrese un usuario y/o contraseña valida");
                        txt_user.setText("");
                        txt_password.setText("");
                    } else {

                        Integer perfil = daoUsers.login((txt_user.getText()), pass);
                        Users user = daoUsers.usersGet(id);

                        //validar la clave  sino la cambiamos
                        if (perfil != 0) {
                            Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
                            if (flagpwd == 0) {
                                Frm_Change_Password_user frm_ChangePassword = new Frm_Change_Password_user(this, id);
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
                                Frm_MenuPrincipal mp = new Frm_MenuPrincipal(this, user);
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
                    }
                }
            }
        }

    }//GEN-LAST:event_txt_passwordKeyPressed

    private void txt_userKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_userKeyPressed
        // TODO add your handling code here: no va
       /*  
         int key = evt.getKeyCode();
         if (key == KeyEvent.VK_ENTER) {
         DaoUsers daoUsers = new DaoUserImpl();

         String pass = new String(txt_password.getPassword());
         Integer id = aInteger(txt_user.getText());
         if (txt_user.getText().length() == 0 || txt_password.getPassword().length == 0) {
         JOptionPane.showMessageDialog(this, "Ingrese un usuario y/o contraseña valida");
         txt_user.setText("");
         txt_password.setText("");
         } else {

         Integer perfil = daoUsers.login((txt_user.getText()), pass);
         Users user = daoUsers.usersGet(id);

         //validar la clave  sino la cambiamos
         if (perfil != 0) {
         Integer flagpwd = daoUsers.getflagpwd(aInteger(txt_user.getText()));
         if (flagpwd == 0) {
         Frm_Change_Password_user frm_ChangePassword = new Frm_Change_Password_user(this, id);
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
         Frm_MenuPrincipal mp = new Frm_MenuPrincipal(this, user);
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
         }
         }
        
         */
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
    private javax.swing.JLabel lbl_log;
    private javax.swing.JLabel lbl_password;
    private javax.swing.JLabel lbl_user;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables
}
