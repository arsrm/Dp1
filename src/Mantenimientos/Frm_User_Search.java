package Mantenimientos;

import Model.Distribution_Center;
import Model.Log;
import Model.Profile;
import Model.Users;
import Seguridad.Frm_MenuPrincipal;
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static tool.Convierte.aInteger;
import tool.SelectAllHeader;

public class Frm_User_Search extends javax.swing.JFrame {

    Frm_MenuPrincipal auxmenu = new Frm_MenuPrincipal();
    
    DaoDistributionCenter daoDC = new DaoDistributionCenterImpl();
    ArrayList<Distribution_Center> distribution_centers = new ArrayList<>();
    DaoProfile daoprofile = new DaoProfileImpl();
    List<Profile> profile = new ArrayList<Profile>();
    DefaultTableModel modelo;
    DaoUsers daoUsers = new DaoUserImpl();
    
    public Frm_User_Search(Frm_MenuPrincipal menu) {
        setTitle("Mantenimiento de Usuario");
        auxmenu = menu;  
        initComponents();
        TableColumn tc = tbl_user.getColumnModel().getColumn(5);
        tc.setHeaderRenderer(new SelectAllHeader(tbl_user, 5));
        modelo = (DefaultTableModel) tbl_user.getModel();
        distribution_centers = daoDC.distribution_centerGetQry();
        for (int i = 0; i < distribution_centers.size(); i++) {
            this.cbo_center.addItem(distribution_centers.get(i).getName());
        }
        profile = daoprofile.profileCbo();
        this.cbo_profile.addItem("");
        for (int i = 0; i < profile.size(); i++) {
            this.cbo_profile.addItem(profile.get(i).getName());
        }
       
        initilizeTable();
        
      
    }

    public Frm_User_Search() {

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_user = new javax.swing.JPanel();
        lbl_center = new javax.swing.JLabel();
        lbl_profile = new javax.swing.JLabel();
        btn_search = new javax.swing.JButton();
        cbo_center = new javax.swing.JComboBox();
        cbo_profile = new javax.swing.JComboBox();
        txt_id = new javax.swing.JTextField();
        lbl_id = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_user = new javax.swing.JTable();
        btn_new = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnl_user.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios de Busqueda"));

        lbl_center.setText("Centro de Distribucion");

        lbl_profile.setText("Perfil de Usuario");

        btn_search.setText("Buscar");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        cbo_profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_profileActionPerformed(evt);
            }
        });

        lbl_id.setText("DNI");

        lbl_name.setText("Nombres");

        javax.swing.GroupLayout pnl_userLayout = new javax.swing.GroupLayout(pnl_user);
        pnl_user.setLayout(pnl_userLayout);
        pnl_userLayout.setHorizontalGroup(
            pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_userLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_center)
                    .addComponent(lbl_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id)
                    .addComponent(lbl_name))
                .addGap(26, 26, 26)
                .addGroup(pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_search)
                        .addGroup(pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_center, 0, 400, Short.MAX_VALUE)
                            .addComponent(cbo_profile, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txt_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        pnl_userLayout.setVerticalGroup(
            pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_userLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_center)
                    .addComponent(cbo_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_profile, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_profile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id))
                .addGap(18, 18, 18)
                .addGroup(pnl_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_name))
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "DNI", "Nombres", "Centro Distribución", "Perfil", "Estado", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_userMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_user);

        btn_new.setText("Nuevo");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_delete.setText("Cambiar estado");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_user, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btn_new)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cancel)
                        .addGap(11, 11, 11))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_new)
                    .addComponent(btn_delete)
                    .addComponent(btn_cancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void initilizeTable() {
        List<Users> list = new ArrayList<Users>();
        list = daoUsers.usersQry();
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        try {
            for (int i = 0; i < list.size(); i++) {
                Integer j=list.get(i).getDistribution_Center_idDistribution_Center();
                String namecenter=daoDC.distribution_centerGet(j).getName() ;
                j=list.get(i).getProfile_idProfile();
                String nameprofile=daoprofile.usersGet(j).getName();
                String state =null;
                if (list.get(i).getStatus()==1){
                    state="Activo";
                }else {state="Inactivo";}
                Object[] fila = {list.get(i).getIdUser(), list.get(i).getname(), namecenter,
                    nameprofile, state,false};
                modelo.addRow(fila);
            }
        } catch (Exception e) {
        }
        
    }
    
    public void initilizeTable(List<Users> list) {
        
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        try {
            for (int i = 0; i < list.size(); i++) {
                Integer j=list.get(i).getDistribution_Center_idDistribution_Center();
                String namecenter=daoDC.distribution_centerGet(j).getName() ;
                j=list.get(i).getProfile_idProfile();
                String nameprofile=daoprofile.usersGet(j).getName();
                String state =null;
                if (list.get(i).getStatus()==1){
                    state="Activo";
                }else {state="Inactivo";}
                Object[] fila = {list.get(i).getIdUser(), list.get(i).getname(), namecenter,
                    nameprofile, state,false};
                modelo.addRow(fila);
            }
        } catch (Exception e) {
        }
    }
    
    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        Frm_User frm_user = new Frm_User(this,null);
        frm_user.setVisible(true);
        frm_user.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        auxmenu.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.dispose();
        auxmenu.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        Integer center = daoDC.distribution_centerGet(cbo_center.getSelectedItem().toString()).getIdDistribution_Center();
        Integer profile = -1; //no selecciono perfil para buscar
        if(cbo_profile.getSelectedItem().toString().equals("")==false)
           profile = daoprofile.usersGet(cbo_profile.getSelectedItem().toString()).getIdprofile();
        Integer id_codigo = aInteger(txt_id.getText());
        String name = txt_name.getText();
        List<Users> list = new ArrayList<Users>();
        list = daoUsers.usersQry_search(center, profile, id_codigo, name);
        initilizeTable(list);
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        
        Object[] options = {"OK"};
        if (JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?",
                "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
        
        
        DaoLog daoLog = new DaoLogImpl();
                    Log logSI = null;
        modelo = (DefaultTableModel) tbl_user.getModel();
        List<Integer> ids=new  ArrayList<Integer>();
        int col,nr =modelo.getRowCount(); col =6;
        for (int i=0; i<nr ;i++){
            Object prueba = modelo.getValueAt(i,5);
            if ((Boolean)prueba){
                
                Integer numm= (Integer)modelo.getValueAt(i, 0);
               ids.add(numm);
               daoLog.clientIns("Se ha modificado el estado de un usuario al sistema con DNI :  " + numm, Frm_User_Search.class.toString(), logSI.getIduser());
            }
        }
        daoUsers.usersDel(ids);
        }
        initilizeTable();
         
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tbl_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_userMouseClicked
         
        Users users = null;
        Integer idUserSel;
        if (evt.getSource() == tbl_user) {
            int rowSel = tbl_user.getSelectedRow();
            int colSel = tbl_user.getSelectedColumn();
            idUserSel = (Integer)tbl_user.getValueAt(rowSel, 0);
            users = daoUsers.usersGet(idUserSel);
            if (colSel!=5){
                this.setVisible(false);
                Frm_User frm_User = new Frm_User(this, users);
                frm_User.setVisible(true);
                frm_User.setLocationRelativeTo(null);
                
            }
        }
    }//GEN-LAST:event_tbl_userMouseClicked

    private void cbo_profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_profileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_profileActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox cbo_center;
    private javax.swing.JComboBox cbo_profile;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_center;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_profile;
    private javax.swing.JPanel pnl_user;
    private javax.swing.JTable tbl_user;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
}
