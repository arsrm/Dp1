/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mantenimientos;

import java.awt.Color;
import java.awt.event.WindowEvent;

/**
 *
 * @author Gustavo
 */
public class Frm_Product extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Product
     */
    Frm_Product_Search menu_padre = new Frm_Product_Search();
    
    public Frm_Product(Frm_Product_Search menu) {
        setTitle("Mantenimiento de Productos");
        menu_padre = menu;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_Save = new javax.swing.JButton();
        pnl_Product = new javax.swing.JPanel();
        txt_weightPerBox = new javax.swing.JTextField();
        lbl_boxesPerPallet = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        txt_boxesPerPallet = new javax.swing.JTextField();
        lbl_physicalStock = new javax.swing.JLabel();
        lbl_trademark = new javax.swing.JLabel();
        txt_physicalStock = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        lbl_FreeStock = new javax.swing.JLabel();
        cbo_trademark = new javax.swing.JComboBox();
        txt_freeStock = new javax.swing.JTextField();
        lbl_quantityPerBox = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_quatityPerBox = new javax.swing.JTextField();
        cbo_conditionWH = new javax.swing.JComboBox();
        lbl_weightPerBox = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btn_Save.setText("Guardar");

        pnl_Product.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        lbl_boxesPerPallet.setText("Cantidad de Cajas por Pallet");

        lbl_name.setText("Nombre");

        lbl_physicalStock.setText("Stock Físico");

        lbl_trademark.setText("Marca");

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        lbl_FreeStock.setText("Stock Libre");

        lbl_quantityPerBox.setText("Unidades por Caja");

        jLabel1.setText("Condición de Almacén");

        lbl_weightPerBox.setText("Peso Neto por Caja");

        javax.swing.GroupLayout pnl_ProductLayout = new javax.swing.GroupLayout(pnl_Product);
        pnl_Product.setLayout(pnl_ProductLayout);
        pnl_ProductLayout.setHorizontalGroup(
            pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnl_ProductLayout.createSequentialGroup()
                        .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_boxesPerPallet)
                            .addComponent(lbl_physicalStock)
                            .addComponent(lbl_FreeStock)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_boxesPerPallet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_physicalStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_freeStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_conditionWH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(cbo_trademark, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnl_ProductLayout.createSequentialGroup()
                            .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_name)
                                .addComponent(lbl_trademark)
                                .addComponent(lbl_quantityPerBox)
                                .addComponent(lbl_weightPerBox))
                            .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(pnl_ProductLayout.createSequentialGroup()
                                    .addGap(72, 72, 72)
                                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_ProductLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_quatityPerBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_weightPerBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_ProductLayout.setVerticalGroup(
            pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ProductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_name)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_trademark)
                    .addComponent(cbo_trademark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_quantityPerBox)
                    .addComponent(txt_quatityPerBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_weightPerBox)
                    .addComponent(txt_weightPerBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_boxesPerPallet)
                    .addComponent(txt_boxesPerPallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_physicalStock)
                    .addComponent(txt_physicalStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_FreeStock)
                    .addComponent(txt_freeStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_ProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbo_conditionWH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_Product, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_Save)
                        .addGap(321, 321, 321)
                        .addComponent(btn_cancel)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_Product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_Save))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(btn_cancel)))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.dispose();
        menu_padre.setVisible(true);
    }//GEN-LAST:event_btn_cancelActionPerformed
    
    private void frmWindowClosed(java.awt.event.WindowEvent evt) {
        this.dispose();
        menu_padre.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Save;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JComboBox cbo_conditionWH;
    private javax.swing.JComboBox cbo_trademark;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_FreeStock;
    private javax.swing.JLabel lbl_boxesPerPallet;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_physicalStock;
    private javax.swing.JLabel lbl_quantityPerBox;
    private javax.swing.JLabel lbl_trademark;
    private javax.swing.JLabel lbl_weightPerBox;
    private javax.swing.JPanel pnl_Product;
    private javax.swing.JTextField txt_boxesPerPallet;
    private javax.swing.JTextField txt_freeStock;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_physicalStock;
    private javax.swing.JTextField txt_quatityPerBox;
    private javax.swing.JTextField txt_weightPerBox;
    // End of variables declaration//GEN-END:variables
}
