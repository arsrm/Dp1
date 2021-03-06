/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reportes;

import Model.Product;
import Model.Trademark;
import dao.DaoProducts;
import dao.DaoTrademark;
import dao.impl.DaoProdImpl;
import dao.impl.DaoTrademarkImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kari
 */
public class Frm_SearchProductIO extends javax.swing.JFrame {

    /**
     * Creates new form Frm_SearchProductIO
     */
    int rowSel = 0;
    int colSel = 0;
    DaoProducts daoProducts = new DaoProdImpl();
    List<Trademark> trademarkList = null;
    DaoTrademark daoTrademark = new DaoTrademarkImpl();
    DefaultTableModel modelo;
    Frm_InternmentReport menuPadre= new Frm_InternmentReport();
    Integer idTrademark = 0;
    
    public Frm_SearchProductIO() {
        initComponents();
    }
    
    public Frm_SearchProductIO(Frm_InternmentReport menu, Integer idTrade) {
       menuPadre = menu;
        initComponents();
        modelo = (DefaultTableModel) tlb_Pro.getModel();
        trademarkList = daoTrademark.TrademarkQry();
        idTrademark = idTrade;
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tlb_Pro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccionar Producto:");

        tlb_Pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Product", "EAN 13", "Nombre"
            }
        ));
        tlb_Pro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tlb_ProMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tlb_Pro);
        if (tlb_Pro.getColumnModel().getColumnCount() > 0) {
            tlb_Pro.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tlb_ProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tlb_ProMouseClicked
       Integer idProductSel;
        String ean=null;
        if (evt.getSource() == tlb_Pro) {
            rowSel = tlb_Pro.getSelectedRow();
            colSel = tlb_Pro.getSelectedColumn();
        }
        
        //idProductSel = Integer.parseInt(tbl_SearchProductKardex.getValueAt(rowSel, 0).toString());
        idProductSel=Integer.parseInt(tlb_Pro.getValueAt(rowSel, 0).toString());
        menuPadre.setProduct(daoProducts.ProductsGet(idProductSel));
        menuPadre.setTextIdEan();
        //menuPadre.setIdProduct(idProductSel);
        //menuPadre.setTextIdProduct();
        menuPadre.setVisible(true);

        this.dispose();
    }//GEN-LAST:event_tlb_ProMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {                                  
        menuPadre.setVisible(true);
        this.dispose();
    }
    /**
     * @param args the command line arguments
     */
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tlb_Pro;
    // End of variables declaration//GEN-END:variables

    private void initilizeTable() {
        String trademark = null;
        String status = null;
        List<Product> list = new ArrayList<Product>();
        list = daoProducts.ProductsQryByTrademark(idTrademark);
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        try {
            for (int i = 0; i < list.size(); i++) {


                Object[] fila = {list.get(i).getIdProduct(),list.get(i).getCodeEAN13(), list.get(i).getName()
                };
                modelo.addRow(fila);
            }
        } catch (Exception e) {
        }
    }
}
