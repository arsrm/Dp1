/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mantenimientos;

import Model.Type_Condition_WareHouse;
import Model.Warehouse;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoWH;
import dao.DaoTypeConditionWH;
import dao.impl.DaoTypeConditionWHImpl;
import dao.impl.DaoWHImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CHACON
 */
public class Frm_Warehouse_Search extends javax.swing.JFrame {

    /**
     * Creates new form Frm_WH
     */
    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();
    DaoWH daoWH = new DaoWHImpl();
    DaoTypeConditionWH daoTypeWh = new DaoTypeConditionWHImpl();
    DefaultTableModel modelo;
    List<Integer> idWhList = new ArrayList<Integer>();
    List<Warehouse> typeWhList = null;
    List<Type_Condition_WareHouse> typeConditionList = null;
    Integer idTypeConditionSearch;
    Integer idWhSearch;

    public Frm_Warehouse_Search(Frm_MenuPrincipal menu) {
        setTitle("Mantenimiento de Almacenes");
        menuaux = menu;
        initComponents();
               typeConditionList = daoTypeWh.tcwhQry();
        int cantTC = typeConditionList.size();
        cbo_type_condition.addItem("Todos");
        for (int i = 0; i < cantTC; i++) {
            cbo_type_condition.addItem(typeConditionList.get(i).getDescription());
        }
        modelo = (DefaultTableModel) tbl_warehouse.getModel();
        initilizeTable();
    }

    public Frm_Warehouse_Search() {

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_new = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_warehouse = new javax.swing.JTable();
        btn_cancel = new javax.swing.JButton();
        pnl_warehouse = new javax.swing.JPanel();
        btn_search = new javax.swing.JButton();
        lbl_type_condition = new javax.swing.JLabel();
        cbo_type_condition = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txt_IdWh = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btn_new.setText("Nuevo");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_delete.setText("Cambiar Estado");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        tbl_warehouse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Descripción", "Estado", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_warehouse.getTableHeader().setReorderingAllowed(false);
        tbl_warehouse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_warehouseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_warehouse);

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        pnl_warehouse.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterio de Búsqueda"));

        btn_search.setText("Buscar");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        lbl_type_condition.setText("Condición de almacén:");

        jLabel1.setText("ID:");

        javax.swing.GroupLayout pnl_warehouseLayout = new javax.swing.GroupLayout(pnl_warehouse);
        pnl_warehouse.setLayout(pnl_warehouseLayout);
        pnl_warehouseLayout.setHorizontalGroup(
            pnl_warehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_warehouseLayout.createSequentialGroup()
                .addGroup(pnl_warehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_warehouseLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_search))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_warehouseLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(pnl_warehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_type_condition)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(pnl_warehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_type_condition, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_IdWh, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(197, 197, 197))
        );
        pnl_warehouseLayout.setVerticalGroup(
            pnl_warehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_warehouseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_warehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_type_condition)
                    .addComponent(cbo_type_condition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_warehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_IdWh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btn_search)
                .addGap(77, 77, 77))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_warehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btn_new)
                .addGap(35, 35, 35)
                .addComponent(btn_delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancel)
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_warehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(btn_new)
                    .addComponent(btn_cancel))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
        menuaux.setVisible(true);
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.dispose();
        menuaux.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        // TODO add your handling code here:
        Frm_Warehouse frm_warehouse = new Frm_Warehouse(this, null);
        frm_warehouse.setVisible(true);
        frm_warehouse.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btn_newActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed

        for (int i = 0; i < tbl_warehouse.getRowCount(); i++) {
            if ((Boolean) tbl_warehouse.getValueAt(i, 3)) {
                idWhList.add(Integer.parseInt(tbl_warehouse.getValueAt(i, 0).toString()));
            }
        }
        daoWH.whsDel(idWhList);
        initilizeTable();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void tbl_warehouseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_warehouseMouseClicked
        Warehouse wh = null;
        Integer idWhSel;
        if (evt.getSource() == tbl_warehouse) {
            int rowSel = tbl_warehouse.getSelectedRow();
            int colSel = tbl_warehouse.getSelectedColumn();

            if (colSel!=3) {
                idWhSel = Integer.parseInt(tbl_warehouse.getValueAt(rowSel, 0).toString());
                wh = daoWH.whGet(idWhSel);

                Frm_Warehouse frm_wh = new Frm_Warehouse(this, wh);
                frm_wh.setVisible(true);
                frm_wh.setLocation(300, 100);
                frm_wh.setLocationRelativeTo(null);
                this.setVisible(false);
            }
        }
    }//GEN-LAST:event_tbl_warehouseMouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed

        List<Warehouse> whList = new ArrayList<Warehouse>();
     
        List<Type_Condition_WareHouse> typeConditionList = new ArrayList<Type_Condition_WareHouse>();
        typeConditionList = daoTypeWh.tcwhQry();        

        if(txt_IdWh.getText().length()!=0)
            idWhSearch=Integer.parseInt(txt_IdWh.getText().toString());
        else idWhSearch=0;
        if(cbo_type_condition.getSelectedItem()!=null){
            if(cbo_type_condition.getSelectedItem()!=null){
            for(int i=0; i<typeConditionList.size(); i++)
                if(cbo_type_condition.getSelectedItem().equals(typeConditionList.get(i).getDescription()))
                       idTypeConditionSearch=typeConditionList.get(i).getIdType_Condition_WareHouse();
            }
            else{
                idTypeConditionSearch=null;
            }
        }
        whList=daoWH.whSearch(idWhSearch, idTypeConditionSearch);
        
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        
        String estado=null;
        try {
            for (int i = 0; i < whList.size(); i++) {
                
                    if(whList.get(i).getStatus()==0)
                        estado="Inactivo";
                    else estado="Activo";
                
                    Object[] fila = {whList.get(i).getIdWarehouse(), whList.get(i).getDescription(),estado, false};
                    modelo.addRow(fila);
                
            }
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btn_searchActionPerformed

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
//            java.util.logging.Logger.getLogger(Frm_WH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Frm_WH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Frm_WH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Frm_WH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        /*java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Frm_WH().setVisible(true);
//            }
//        });*/
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox cbo_type_condition;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_type_condition;
    private javax.swing.JPanel pnl_warehouse;
    private javax.swing.JTable tbl_warehouse;
    private javax.swing.JTextField txt_IdWh;
    // End of variables declaration//GEN-END:variables

    public void initilizeTable() {
        List<Warehouse> list = new ArrayList<Warehouse>();
        list = daoWH.whQry();
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        try {
            for (int i = 0; i < list.size(); i++) {
                String estado;
                if(list.get(i).getStatus()==0)estado="Inactivo";
                else estado="Activo";
                    
                Object[] fila = {list.get(i).getIdWarehouse(), list.get(i).getDescription(), estado, false};
                modelo.addRow(fila);
            }
        } catch (Exception e) {
        }
    }
}
