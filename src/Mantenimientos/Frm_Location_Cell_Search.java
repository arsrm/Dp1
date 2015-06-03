/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mantenimientos;

import Model.Distribution_Center;
import Model.LocationCell;
import Model.Rack;
import Model.Warehouse;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoDistributionCenter;
import dao.DaoLocationCell;
import dao.DaoRack;
import dao.DaoWH;
import dao.impl.DaoDistributionCenterImpl;
import dao.impl.DaoLocationCellImpl;
import dao.impl.DaoRackImpl;
import dao.impl.DaoWHImpl;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import tool.SelectAllHeader;

/**
 *
 * @author Luigi
 */
public class Frm_Location_Cell_Search extends javax.swing.JFrame {

    Frm_MenuPrincipal menuaux=new Frm_MenuPrincipal();        
    
    DaoDistributionCenter daoDC = new DaoDistributionCenterImpl();
    ArrayList<Distribution_Center> distributionCenterList = new ArrayList<>();
    Distribution_Center distributionCenter = new Distribution_Center();
    
    DaoWH daoWH = new DaoWHImpl();
    ArrayList<Warehouse> warehouseList = new ArrayList<>();
    Warehouse warehouse = new Warehouse();
    
    DaoRack daoRack = new DaoRackImpl();
    List<Rack> rackList = new ArrayList<>();
    Rack rack = new Rack();  
    
    DaoLocationCell daoLocationCell = new DaoLocationCellImpl();
    List<LocationCell> locationCellList = new ArrayList<>();
    LocationCell locationCell = new LocationCell();
    
    DefaultTableModel modelo;        
    
    public Frm_Location_Cell_Search(Frm_MenuPrincipal menu) {
        setTitle("Mantenimiento de Celdas de Ubicación");
        menuaux = menu;
        initComponents();
        
        TableColumn tc = tbl_location_cell.getColumnModel().getColumn(8);
        tc.setHeaderRenderer(new SelectAllHeader(tbl_location_cell, 8));        
        initializeForm();        
    }
    
    public Frm_Location_Cell_Search() {
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_rack = new javax.swing.JPanel();
        lbl_distribution_center = new javax.swing.JLabel();
        lbl_warehouse = new javax.swing.JLabel();
        cbo_distribution_center = new javax.swing.JComboBox();
        cbo_warehouse = new javax.swing.JComboBox();
        btn_search = new javax.swing.JButton();
        cbo_rack = new javax.swing.JComboBox();
        lbl_rack = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_location_cell = new javax.swing.JTable();
        btn_cancel = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnl_rack.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios de Búsqueda"));

        lbl_distribution_center.setText("Centro de Distribucion");

        lbl_warehouse.setText("Almacén");

        cbo_distribution_center.setEnabled(false);

        cbo_warehouse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_warehouseItemStateChanged(evt);
            }
        });

        btn_search.setText("Buscar");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        cbo_rack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbo_rackMouseClicked(evt);
            }
        });

        lbl_rack.setText("Rack");

        javax.swing.GroupLayout pnl_rackLayout = new javax.swing.GroupLayout(pnl_rack);
        pnl_rack.setLayout(pnl_rackLayout);
        pnl_rackLayout.setHorizontalGroup(
            pnl_rackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_rackLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnl_rackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_search)
                    .addGroup(pnl_rackLayout.createSequentialGroup()
                        .addGroup(pnl_rackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_distribution_center)
                            .addComponent(lbl_warehouse)
                            .addComponent(lbl_rack))
                        .addGap(45, 45, 45)
                        .addGroup(pnl_rackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_rack, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbo_distribution_center, 0, 400, Short.MAX_VALUE)
                            .addComponent(cbo_warehouse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_rackLayout.setVerticalGroup(
            pnl_rackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_rackLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_rackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_distribution_center)
                    .addComponent(cbo_distribution_center, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_rackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_warehouse)
                    .addComponent(cbo_warehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_rackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_rack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_rack))
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_location_cell.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Distribution Center", "Id Warehouse", "Id Rack", "Id Location Cell", "Fila", "Columna", "Descripción", "Estado", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_location_cell.getTableHeader().setReorderingAllowed(false);
        tbl_location_cell.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_location_cellMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_location_cell);
        if (tbl_location_cell.getColumnModel().getColumnCount() > 0) {
            tbl_location_cell.getColumnModel().getColumn(0).setMinWidth(0);
            tbl_location_cell.getColumnModel().getColumn(0).setPreferredWidth(0);
            tbl_location_cell.getColumnModel().getColumn(0).setMaxWidth(0);
            tbl_location_cell.getColumnModel().getColumn(1).setMinWidth(0);
            tbl_location_cell.getColumnModel().getColumn(1).setPreferredWidth(0);
            tbl_location_cell.getColumnModel().getColumn(1).setMaxWidth(0);
            tbl_location_cell.getColumnModel().getColumn(2).setMinWidth(0);
            tbl_location_cell.getColumnModel().getColumn(2).setPreferredWidth(0);
            tbl_location_cell.getColumnModel().getColumn(2).setMaxWidth(0);
            tbl_location_cell.getColumnModel().getColumn(3).setMinWidth(0);
            tbl_location_cell.getColumnModel().getColumn(3).setPreferredWidth(0);
            tbl_location_cell.getColumnModel().getColumn(3).setMaxWidth(0);
        }

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_delete.setText("Cambiar Estado");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_rack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btn_delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancel)
                .addGap(37, 37, 37))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_rack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(btn_cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void initializeForm(){
        
        distributionCenterList = daoDC.distribution_centerGetQry();
        for (int i = 0; i < distributionCenterList.size(); i++) {
            this.cbo_distribution_center.addItem(distributionCenterList.get(i).getName());
        }
        distributionCenter = distributionCenterList.get(0);        
        
        warehouseList = daoWH.whSearchByID(distributionCenterList.get(0));
        for (int i = 0; i < warehouseList.size(); i++)
            this.cbo_warehouse.addItem(warehouseList.get(i).getDescription());
        if (cbo_warehouse.getSelectedItem()!=null) 
            warehouse = warehouseList.get(0);
        
//        rackList = daoRack.rackQueryByWarehouse(warehouse);
//        for (int i = 0; i < rackList.size(); i++){
//            
//            cbo_rack.addItem(rackList.get(i).getIdentifier());
//            String id = rackList.get(i).getIdentifier();
//            
//        }
//        if (cbo_rack.getSelectedItem()!=null) 
//            rack = rackList.get(0);
        
    }
    
    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.dispose();
        menuaux.setVisible(true);
    }//GEN-LAST:event_btn_cancelActionPerformed
    
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        menuaux.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void tbl_location_cellMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_location_cellMouseClicked
//        Rack rack = null;
//        Integer idRackSel;
//        if (evt.getSource() == tbl_location_cell) {
//            int rowSel = tbl_location_cell.getSelectedRow();
//            int colSel = tbl_location_cell.getSelectedColumn();
//            if (colSel != 6) {
//                this.setVisible(false);
//                idRackSel = Integer.parseInt(tbl_location_cell.getValueAt(rowSel, 0).toString());
//                rack = daoRack.rackGet(idRackSel);
//
//                Frm_Rack frm_rack = new Frm_Rack(this, rack);
//                frm_rack.setVisible(true);
//                frm_rack.setLocationRelativeTo(null);                
//            }
//        }
    }//GEN-LAST:event_tbl_location_cellMouseClicked

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        Rack rack = null;
        int idDistributionCenter, idWarehouse, idRack, idLocationCell;
        String status;
        
        Object[] options = {"OK"};
        if (JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?",
                "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            for (int i = 0; i < tbl_location_cell.getRowCount(); i++) {
                if ((Boolean) tbl_location_cell.getValueAt(i, 8)) {
                    idDistributionCenter = Integer.parseInt(tbl_location_cell.getValueAt(i, 0).toString());
                    idWarehouse = Integer.parseInt(tbl_location_cell.getValueAt(i, 1).toString());
                    idRack = Integer.parseInt(tbl_location_cell.getValueAt(i, 2).toString());
                    idLocationCell = Integer.parseInt(tbl_location_cell.getValueAt(i, 3).toString());
                    status = tbl_location_cell.getValueAt(i, 7).toString();
                    if (status.equalsIgnoreCase("Activo")) {                        
                        locationCell = daoLocationCell.LocationCellGet(idDistributionCenter, idWarehouse, idRack, idLocationCell);
                        if (rackValidatedToDelete(locationCell)) {
                            daoLocationCell.locationCellChangeState(locationCell, 0);
                            daoLocationCell.LocationCellAvailabilityUpd(locationCell, 0);
                        }
                    } else {
                        locationCell = daoLocationCell.LocationCellGet(idDistributionCenter, idWarehouse, idRack, idLocationCell);
                        daoLocationCell.locationCellChangeState(locationCell, 1);
                        daoLocationCell.LocationCellAvailabilityUpd(locationCell, 1);
                    }
                }
            }
            int ok_option = JOptionPane.showOptionDialog(new JFrame(), "Acciones realizadas con éxito", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (ok_option == JOptionPane.OK_OPTION) {
                initializeTable();
            }
        }
        initializeTable();
    }//GEN-LAST:event_btn_deleteActionPerformed

    private boolean rackValidatedToDelete(LocationCell locationCell){
        if (daoLocationCell.locationCellInUse(locationCell)){
            JOptionPane.showMessageDialog(null,"No se puede eliminar. La celda de ubicación esta siendo usada", 
                        "Advertencias", JOptionPane.WARNING_MESSAGE);
            return false;
        } 
        return true;
    }
    
    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        modelo = (DefaultTableModel) tbl_location_cell.getModel();
        initializeTable();
    }//GEN-LAST:event_btn_searchActionPerformed

    private void cbo_warehouseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_warehouseItemStateChanged
        for (int i = 0; i < warehouseList.size(); i++) {
            if (cbo_warehouse.getSelectedItem().equals(warehouseList.get(i).getDescription())) {
                warehouse = warehouseList.get(i);
                rackList = daoRack.rackQueryByWarehouse(warehouse);
                if (cbo_rack!=null){
                    cbo_rack.removeAllItems();
                    for (int j = 0; j < rackList.size(); j++)
                        cbo_rack.addItem(rackList.get(j).getIdentifier());
                    if (cbo_rack.getSelectedItem()!=null) rack = rackList.get(0);
                }                    
                break;
            }
        }
    }//GEN-LAST:event_cbo_warehouseItemStateChanged

    private void cbo_rackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_rackMouseClicked
        for (int i = 0; i < rackList.size(); i++) {
            if (cbo_rack.getSelectedItem().equals(rackList.get(i).getIdentifier())){
                rack = rackList.get(i);
                break;
            }
        }
    }//GEN-LAST:event_cbo_rackMouseClicked
          
    public void initializeTable(){
        
        if (cbo_warehouse.getSelectedItem() != null && cbo_rack.getSelectedItem() != null) {
            for (int i=0; i < warehouseList.size(); i++){
                if (cbo_warehouse.getSelectedItem().equals(warehouseList.get(i).getDescription())){
                    warehouse = warehouseList.get(i);
                    break;
                }
            }
            for (int i=0; i < rackList.size(); i++){
                if (cbo_rack.getSelectedItem().equals(rackList.get(i).getIdentifier())){
                    rack = rackList.get(i);
                    break;
                }
            }
            locationCellList = daoLocationCell.locationCellByRack(rack);
            String status = null;
            if (modelo != null) {
                modelo.getDataVector().removeAllElements();
                modelo.fireTableDataChanged();
            }
            try {
                for (int i = 0; i < locationCellList.size(); i++) {

                    if (locationCellList.get(i).getStatus() == 0) {
                        status = "Inactivo";
                    } else {
                        status = "Activo";
                    }

                    Object newRow[] = {
                        locationCellList.get(i).getRack_Warehouse_Distribution_Center_idDistribution_Center(),
                        locationCellList.get(i).getRack_Warehouse_idWarehouse(),
                        locationCellList.get(i).getRack_idRack(),                        
                        locationCellList.get(i).getIdLocation_Cell(),
                        locationCellList.get(i).getRow_Cell(),
                        locationCellList.get(i).getColumn_Cell(),
                        locationCellList.get(i).getDescription(),                        
                        status,
                        false
                    };
                    modelo.addRow(newRow);
                }
            } catch (Exception e) {
            }
        } else {
            JOptionPane.showMessageDialog(null, "Escoja Almacén y Rack",
                    "Advertencias", JOptionPane.WARNING_MESSAGE);
            if (modelo != null) {
                modelo.getDataVector().removeAllElements();
                modelo.fireTableDataChanged();
            }
        }
        
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
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox cbo_distribution_center;
    private javax.swing.JComboBox cbo_rack;
    private javax.swing.JComboBox cbo_warehouse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_distribution_center;
    private javax.swing.JLabel lbl_rack;
    private javax.swing.JLabel lbl_warehouse;
    private javax.swing.JPanel pnl_rack;
    private javax.swing.JTable tbl_location_cell;
    // End of variables declaration//GEN-END:variables
}