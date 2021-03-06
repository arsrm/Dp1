/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mantenimientos;

import Model.Log;
import Model.Type_Condition_WareHouse;
import Model.Warehouse;
import dao.DaoLog;
import dao.DaoTypeConditionWH;
import dao.DaoWH;
import dao.impl.DaoLogImpl;
import dao.impl.DaoTypeConditionWHImpl;
import dao.impl.DaoWHImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tool.Validate;

/**
 *
 * @author Luigi
 */
public class Frm_Warehouse extends javax.swing.JFrame {

    /**
     * Creates new form Frm_rack
     */
    Frm_Warehouse_Search menu_padre = new Frm_Warehouse_Search();

    Warehouse warehouse;
    DaoWH daoWH = new DaoWHImpl();
    DaoTypeConditionWH daoTC = new DaoTypeConditionWHImpl();
    List<Type_Condition_WareHouse> typeConditionList = null;
    Type_Condition_WareHouse tcWhSelected;
    Validate validar = new Validate();

    public Frm_Warehouse(Frm_Warehouse_Search menu, Warehouse wh) {
        setTitle("Mantenimiento de Almacenes");
        menu_padre = menu;
        warehouse = wh;
        initComponents();

        typeConditionList = daoTC.tcwhQry();
        int cantTC = typeConditionList.size();
//        cbo_type_condition.addItem("Seleccionar");
        cbo_type_condition.addItem("Seleccione");
        for (int i = 0; i < cantTC; i++) {
            cbo_type_condition.addItem(typeConditionList.get(i).getDescription());
        }
        if (warehouse != null) {
            initializeForm();
        }

    }

    private void initializeForm() {
        cbo_type_condition.setEnabled(false);
        for (int i = 0; i < typeConditionList.size(); i++) {
            if (typeConditionList.get(i).getIdType_Condition_WareHouse() == warehouse.getType_Condition_WareHouse_idType_Condition_WareHouse()) {
                cbo_type_condition.setSelectedItem(typeConditionList.get(i).getDescription());
            }
        }
        txt_description.setText(warehouse.getDescription());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_warehouse = new javax.swing.JPanel();
        lbl_type_condition = new javax.swing.JLabel();
        txt_description = new javax.swing.JTextField();
        cbo_type_condition = new javax.swing.JComboBox();
        lbl_description = new javax.swing.JLabel();
        btn_save = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnl_warehouse.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        lbl_type_condition.setText("Condicion de almacen:");

        cbo_type_condition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_type_conditionActionPerformed(evt);
            }
        });

        lbl_description.setText("Nombre:");

        javax.swing.GroupLayout pnl_warehouseLayout = new javax.swing.GroupLayout(pnl_warehouse);
        pnl_warehouse.setLayout(pnl_warehouseLayout);
        pnl_warehouseLayout.setHorizontalGroup(
            pnl_warehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_warehouseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_warehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_type_condition)
                    .addComponent(lbl_description))
                .addGap(50, 50, 50)
                .addGroup(pnl_warehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_description, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_type_condition, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_warehouseLayout.setVerticalGroup(
            pnl_warehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_warehouseLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnl_warehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_type_condition)
                    .addComponent(cbo_type_condition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(pnl_warehouseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_description)
                    .addComponent(txt_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(258, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_warehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btn_save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancel)
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_warehouse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        menu_padre.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed

        String nombre = null;

        if (cbo_type_condition.getSelectedItem().equals("Seleccione")) {

            JOptionPane.showMessageDialog(this, "Por favor complete el campo condición de almacén");
        }

        if (txt_description.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Por favor complete el campo nombre");
        }

        if (txt_description.getText().length() != 0) {
            nombre = txt_description.getText();
            if (!Validate.validarNombre(nombre)) {
                JOptionPane.showMessageDialog(this, "solo se aceptan caracteres", "Advertencia", JOptionPane.OK_OPTION);
            } else {

                Object[] options = {"OK"};

                if (JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?",
                        "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    DaoLog daoLog = new DaoLogImpl();
                    Log logSI = null;
                    if (warehouse == null) { //Guardar nuevo producto

                        warehouse = new Warehouse();
                        warehouse.setDescription(txt_description.getText());
                        warehouse.setType_Condition_WareHouse_idType_Condition_WareHouse(tcWhSelected.getIdType_Condition_WareHouse());
                        warehouse.setDistribution_Center_idDistribution_Center(1);
                        warehouse.setStatus(1);
                        daoWH.whIns(warehouse);
                        warehouse.setIdWH(daoWH.whGetMaxId());
                        daoLog.clientIns("Se ha ingresado un nuevo Almacén al sistema con ID " + warehouse.getIdWarehouse().toString(), Frm_Warehouse.class.toString(), logSI.getIduser());
                    } else {

                        warehouse.setDescription(txt_description.getText());
                        daoWH.whUpd(warehouse);
                        daoLog.clientIns("Se ha actualizado un Almacén en el sistema con ID " + warehouse.getIdWarehouse().toString(), Frm_Warehouse.class.toString(), logSI.getIduser());
                    }
                    int ok_option = JOptionPane.showOptionDialog(new JFrame(), "Se ha registrado al Almacén con éxito", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (ok_option == JOptionPane.OK_OPTION) {
                        menu_padre.setVisible(true);
                        menu_padre.setLocationRelativeTo(null);
                        this.dispose();
                    }
                }

            }
            menu_padre.initilizeTable();
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void cbo_type_conditionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_type_conditionActionPerformed
        if (cbo_type_condition.getSelectedItem() != null) {
            for (int i = 0; i < typeConditionList.size(); i++) {
                if (cbo_type_condition.getSelectedItem().equals(typeConditionList.get(i).getDescription())) {
                    tcWhSelected = typeConditionList.get(i);

                }
            }
        }
    }//GEN-LAST:event_cbo_type_conditionActionPerformed

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
    private javax.swing.JComboBox cbo_type_condition;
    private javax.swing.JLabel lbl_description;
    private javax.swing.JLabel lbl_type_condition;
    private javax.swing.JPanel pnl_warehouse;
    private javax.swing.JTextField txt_description;
    // End of variables declaration//GEN-END:variables

}
