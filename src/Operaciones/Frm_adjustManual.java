/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Model.InternmentOrder;
import Model.InternmentOrderDetail;
import Model.PalletProduct;
import Model.Product;
import Seguridad.Frm_MenuPrincipal;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import com.sun.org.apache.bcel.internal.generic.AASTORE;
import dao.DaoInternmentOrder;
import dao.DaoInternmentOrderDetail;
import dao.DaoKardex;
import dao.DaoPalletProduct;
import dao.DaoProducts;
import dao.DaoWH;
import dao.impl.DaoInternmentOrderDetailImpl;
import dao.impl.DaoInternmentOrderImpl;
import dao.impl.DaoKardexImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoWHImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alejandro
 */
public class Frm_adjustManual extends javax.swing.JFrame {

    Integer typeAjustSelected = 0;
    Frm_MenuPrincipal menu_padre = new Frm_MenuPrincipal();
    DaoPalletProduct daoPalletProd = new DaoPalletProductImpl();
    PalletProduct palletProd = new PalletProduct();
    DaoProducts daoProduct = new DaoProdImpl();
    DaoWH daoWh = new DaoWHImpl();
    DaoInternmentOrder daoIntOrder = new DaoInternmentOrderImpl();
    Product product = new Product();
    DaoInternmentOrderDetail daoIntOrdDetail = new DaoInternmentOrderDetailImpl();
    DaoKardex daoMov = new DaoKardexImpl();

    public Frm_adjustManual(Frm_MenuPrincipal menu) {
        setTitle("Ajuste Manual de Inventario");
        menu_padre = menu;
        initComponents();
        cbo_typeAjust.removeAllItems();
        cbo_typeAjust.addItem("Seleccionar");
        cbo_typeAjust.addItem("Ingreso");
        cbo_typeAjust.addItem("Salida");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_save = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_codPallet = new javax.swing.JTextField();
        txt_EANProd = new javax.swing.JTextField();
        txt_nameProduct = new javax.swing.JTextField();
        cbo_typeAjust = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btn_save.setText("Ajusta Manual");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajuste de Inventario"));

        jLabel2.setText("Código de Pallet");

        jLabel3.setText("EAN13  Producto");

        jLabel4.setText("Nombre Producto");

        jLabel6.setText("Tipo de Ajuste");

        txt_codPallet.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_codPalletFocusLost(evt);
            }
        });
        txt_codPallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_codPalletActionPerformed(evt);
            }
        });

        cbo_typeAjust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_typeAjustActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_codPallet, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(cbo_typeAjust, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_EANProd)
                    .addComponent(txt_nameProduct))
                .addGap(32, 32, 32))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codPallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_EANProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_nameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbo_typeAjust, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(325, 325, 325)
                        .addComponent(btn_save))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btn_save)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if (typeAjustSelected == 1) {
            InternmentOrder intOrder = daoIntOrder.IntOrderGet(999999999);
            List<InternmentOrderDetail> intOrderDetList = new ArrayList<>();
            InternmentOrderDetail intOrdDetail = new InternmentOrderDetail();
            List<InternmentOrder> internOrderList = new ArrayList<>();
            intOrdDetail.setIdInternmentOrderDetail(daoIntOrdDetail.IntOrderDetailMaxId(product.getIdProduct(), 999999999)+1);
            intOrdDetail.setProduct(product);
            intOrdDetail.setQuantityPallets(1);
            intOrdDetail.setStatus(1);
            intOrderDetList.add(intOrdDetail);
            intOrder.setInternmentOrderDetail(intOrderDetList);
            internOrderList.add(intOrder);
            daoIntOrdDetail.IntOrderDetailIns(999999999, intOrdDetail);
            daoIntOrder.IntOrdersInternAdjustManual(internOrderList);
            daoMov.MovementUpdTypeMov(1, 3, daoMov.MovementGetMaxId());
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void cbo_typeAjustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_typeAjustActionPerformed
        if (cbo_typeAjust.getSelectedItem().toString().equals("Ingreso")) {
            typeAjustSelected = 1;
        }
        if (cbo_typeAjust.getSelectedItem().toString().equals("Salida")) {
            typeAjustSelected = 2;
        }
    }//GEN-LAST:event_cbo_typeAjustActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        menu_padre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void txt_codPalletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codPalletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codPalletActionPerformed

    private void txt_codPalletFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codPalletFocusLost
        palletProd = daoPalletProd.getPalletProductById(Integer.parseInt(txt_codPallet.getText().toString()));
        product = daoProduct.ProductsGet(palletProd.getIdproduct());
        txt_EANProd.setText(product.getCodeEAN13());
        txt_nameProduct.setText(product.getName());
    }//GEN-LAST:event_txt_codPalletFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox cbo_typeAjust;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_EANProd;
    private javax.swing.JTextField txt_codPallet;
    private javax.swing.JTextField txt_nameProduct;
    // End of variables declaration//GEN-END:variables
}