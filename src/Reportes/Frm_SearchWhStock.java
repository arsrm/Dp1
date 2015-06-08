/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reportes;

import Model.Warehouse;
import java.util.ArrayList;
import java.util.List;
import dao.DaoWH;
import dao.impl.DaoWHImpl;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kari
 */
public class Frm_SearchWhStock extends javax.swing.JFrame {

    int rowSel=0;
    int colSel=0;
    DaoWH daoWH = new DaoWHImpl();
    DefaultTableModel modelo;
    Frm_StockReport menuPadre = new Frm_StockReport();
    
    /**
     * Creates new form Frm_SearchWhKardex
     */
    public Frm_SearchWhStock() {
        initComponents();
    }

    Frm_SearchWhStock(Frm_StockReport menu) {
        menuPadre = menu;
        initComponents();
        modelo = (DefaultTableModel)tbl_SearchWhkardex.getModel();
        initilizeTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_SearchWhkardex = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btn_Cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_SearchWhkardex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Nombre"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_SearchWhkardex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SearchWhkardexMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_SearchWhkardex);

        jLabel1.setText("Seleccionar Almaen:");

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_Cancelar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Cancelar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_SearchWhkardexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SearchWhkardexMouseClicked
        
        Integer idWhSel;
        if (evt.getSource() == tbl_SearchWhkardex) {
            rowSel = tbl_SearchWhkardex.getSelectedRow();
            colSel = tbl_SearchWhkardex.getSelectedColumn();
         }
        idWhSel = Integer.parseInt(tbl_SearchWhkardex.getValueAt(rowSel, 0).toString());
        menuPadre.setIdWh(idWhSel);
        menuPadre.setTextIdWh();
        menuPadre.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_tbl_SearchWhkardexMouseClicked

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        menuPadre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_SearchWhkardex;
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
