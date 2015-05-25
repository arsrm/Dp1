package Mantenimientos;

import Model.Client;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoClient;
import dao.impl.DaoClientImpl;
import dao.impl.DaoUserImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Frm_Client_Search extends javax.swing.JFrame {

    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();
DefaultTableModel modelo;
     DaoClient daoClient = new DaoClientImpl();
     
    public Frm_Client_Search(Frm_MenuPrincipal menu) {
        setTitle("Mantenimiento de Clientes");
        menuaux = menu;
        initComponents();
        
        modelo = (DefaultTableModel) tbl_client.getModel();
        
        initilizeTable();

    }
    
    public Frm_Client_Search() {
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_client = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        txt_name = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        txt_id = new javax.swing.JTextField();
        lbl_id = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        btn_new = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_client = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnl_client.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios de Búsqueda"));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        btn_search.setText("Buscar");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        lbl_id.setText("RUC");

        lbl_name.setText("Nombres");

        javax.swing.GroupLayout pnl_clientLayout = new javax.swing.GroupLayout(pnl_client);
        pnl_client.setLayout(pnl_clientLayout);
        pnl_clientLayout.setHorizontalGroup(
            pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_clientLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_search)
                    .addGroup(pnl_clientLayout.createSequentialGroup()
                        .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_name)
                            .addComponent(lbl_id, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(46, 46, 46)
                        .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
        pnl_clientLayout.setVerticalGroup(
            pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_clientLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnl_clientLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_name)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_new.setText("Nuevo");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_delete.setText("Desactivar");
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

        tbl_client.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "RUC", "Nombres", "Dirección", "Estado", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_client.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_clientMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_client);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnl_client, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btn_new)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cancel)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        List<Client> list = new ArrayList<Client>();
        list = daoClient.clientQry();
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        try {
            for (int i = 0; i < list.size(); i++) {
                String state = null;
                if (list.get(i).getStatus() == 1) {
                    state = "Activo";
                } else {
                    state = "Inactivo";
                }
                Object[] fila = {list.get(i).getRuc(), list.get(i).getName(), list.get(i).getAddress(), state, false};
                modelo.addRow(fila);
            }
        } catch (Exception e) {
        }

    }
      
      public void initilizeTable(List<Client> list) {

        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        try {
            for (int i = 0; i < list.size(); i++) {
                String state = null;
                if (list.get(i).getStatus() == 1) {
                    state = "Activo";
                } else {
                    state = "Inactivo";
                }
                Object[] fila = {list.get(i).getRuc(), list.get(i).getName(), list.get(i).getAddress(), state, false};
                modelo.addRow(fila);
            }
        } catch (Exception e) {
        }
    }
      
    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        Frm_Client frm_Client = new Frm_Client(this,null);
        frm_Client.setVisible(true);
        frm_Client.setLocationRelativeTo(null);
         this.setVisible(false);  
    }//GEN-LAST:event_btn_newActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        
        List<Client> list = new ArrayList<Client>();
        list = daoClient.clientQry_search(txt_id.getText(), txt_name.getText());
        initilizeTable(list);
        
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        
        modelo = (DefaultTableModel) tbl_client.getModel();
        List<String> ids = new ArrayList<String>();
        int col, nr = modelo.getRowCount();
        col = 4;
        for (int i = 0; i < nr; i++) {
            Object prueba = modelo.getValueAt(i, 4);
            if ((Boolean) prueba) {
                String numm =  (String)modelo.getValueAt(i, 0);
                ids.add(numm);
            }
        }
        daoClient.clientDel(ids);
        initilizeTable();
        
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tbl_clientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_clientMouseClicked
        Client client = null;
        String idUserSel;
        if (evt.getSource() == tbl_client) {
            int rowSel = tbl_client.getSelectedRow();
            int colSel = tbl_client.getSelectedColumn();
            idUserSel = (String)tbl_client.getValueAt(rowSel, 0);
            client = daoClient.clientGet(idUserSel);
            if (colSel != 4) {
                Frm_Client frm_Client = new Frm_Client(this,client);
                frm_Client.setVisible(true);
                frm_Client.setLocationRelativeTo(null);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_tbl_clientMouseClicked

    

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_search;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JPanel pnl_client;
    private javax.swing.JTable tbl_client;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables
}
