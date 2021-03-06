/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mantenimientos;

import Model.Log;
import Model.Product;
import Model.Trademark;
import Model.Type_Condition_WareHouse;
import dao.DaoLog;
import dao.DaoProducts;
import dao.DaoTrademark;
import dao.DaoTypeConditionWH;
import dao.impl.DaoLogImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoTrademarkImpl;
import dao.impl.DaoTypeConditionWHImpl;
import java.awt.Color;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import tool.Validate;

/**
 *
 * @author Gustavo
 */
public class Frm_Product extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Product
     */
    Frm_Product_Search menu_padre = new Frm_Product_Search();
    /*product indica si la opción para el botón Guardar sera para insertar un nuevo registro (product == null) o
     para hacer Update a un registro ya existente (product != null) */
    Product product;
    DaoProducts daoProducts = new DaoProdImpl();
    DaoTypeConditionWH daoTcWH = new DaoTypeConditionWHImpl();
    DaoTrademark daoTrademark = new DaoTrademarkImpl();
    List<Type_Condition_WareHouse> tcWhList = null;
    List<Trademark> trademarkList = null;
    Trademark trademarkSelected;
    Type_Condition_WareHouse tcWhSelected;

    public Frm_Product(Frm_Product_Search menu, Product p) {
        setTitle("Mantenimiento de Productos");
        menu_padre = menu;
        product = p;
        initComponents();
        tcWhList = daoTcWH.tcwhQry();
        cbo_conditionWH.addItem("Seleccione");
        for (int i = 0; i < tcWhList.size(); i++) {
            cbo_conditionWH.addItem(tcWhList.get(i).getDescription());
        }

        trademarkList = daoTrademark.TrademarkQry();
        cbo_trademark.addItem("Seleccione");
        for (int i = 0; i < trademarkList.size(); i++) {
            cbo_trademark.addItem(trademarkList.get(i).getName());
        }
        if (product != null) {
            initializeForm();
        }
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
        pnl_product = new javax.swing.JPanel();
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
        lbl_ean13 = new javax.swing.JLabel();
        txt_codEan13 = new javax.swing.JTextField();
        lbl_unitUnitsPerBox = new javax.swing.JLabel();
        lbl_unitWieghtPerBox = new javax.swing.JLabel();
        lbl_unitBoxesPerPallet = new javax.swing.JLabel();
        lbl_unitPhysicalStock = new javax.swing.JLabel();
        lbl_unitFreeStock = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_timeExpiration = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        btn_save.setText("Guardar");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        pnl_product.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));
        pnl_product.setPreferredSize(new java.awt.Dimension(800, 600));

        lbl_boxesPerPallet.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_boxesPerPallet.setText(" Empaques por Pallet (*)");

        lbl_name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_name.setText("Nombre (*)");

        lbl_physicalStock.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_physicalStock.setText("Stock Físico");

        lbl_trademark.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_trademark.setText("Marca (*)");

        txt_physicalStock.setText("0");
        txt_physicalStock.setEnabled(false);

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        lbl_FreeStock.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_FreeStock.setText("Stock Libre");

        cbo_trademark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_trademarkActionPerformed(evt);
            }
        });

        txt_freeStock.setText("0");
        txt_freeStock.setEnabled(false);

        lbl_quantityPerBox.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_quantityPerBox.setText("Unidades por Empaque (*)");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Condición de Almacén (*)");

        cbo_conditionWH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_conditionWHActionPerformed(evt);
            }
        });

        lbl_weightPerBox.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_weightPerBox.setText("Peso Neto por Empaque (*)");

        lbl_ean13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbl_ean13.setText("Código EAN13 (*)");

        lbl_unitUnitsPerBox.setText("Unidades");

        lbl_unitWieghtPerBox.setText("Kg.");

        lbl_unitBoxesPerPallet.setText("Empaques");

        lbl_unitPhysicalStock.setText("Empaques");

        lbl_unitFreeStock.setText("Empaques");

        jLabel2.setText("Tiempo de Expiración (*)");

        txt_timeExpiration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timeExpirationActionPerformed(evt);
            }
        });

        jLabel3.setText("Días");

        jLabel4.setText("(*) Campos Obligatorios");

        javax.swing.GroupLayout pnl_productLayout = new javax.swing.GroupLayout(pnl_product);
        pnl_product.setLayout(pnl_productLayout);
        pnl_productLayout.setHorizontalGroup(
            pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_productLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_productLayout.createSequentialGroup()
                        .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_quantityPerBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_weightPerBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_quatityPerBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_weightPerBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_unitWieghtPerBox)
                            .addComponent(lbl_unitUnitsPerBox)
                            .addComponent(lbl_unitBoxesPerPallet)))
                    .addGroup(pnl_productLayout.createSequentialGroup()
                        .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_trademark)
                            .addComponent(lbl_name)
                            .addComponent(lbl_ean13))
                        .addGap(92, 92, 92)
                        .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_name)
                            .addComponent(cbo_trademark, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_codEan13, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_productLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(56, 56, 56)
                        .addComponent(cbo_conditionWH, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_productLayout.createSequentialGroup()
                        .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_productLayout.createSequentialGroup()
                                    .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbl_physicalStock, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_FreeStock, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(105, 105, 105))
                                .addGroup(pnl_productLayout.createSequentialGroup()
                                    .addComponent(lbl_boxesPerPallet)
                                    .addGap(24, 24, 24)))
                            .addComponent(jLabel2))
                        .addGap(17, 17, 17)
                        .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_boxesPerPallet, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_productLayout.createSequentialGroup()
                                .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_timeExpiration, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_physicalStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(txt_freeStock, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_unitPhysicalStock)
                                    .addComponent(lbl_unitFreeStock)
                                    .addComponent(jLabel3)))))
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_productLayout.setVerticalGroup(
            pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_productLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ean13)
                    .addComponent(txt_codEan13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_name)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_trademark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_trademark))
                .addGap(19, 19, 19)
                .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbo_conditionWH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_quantityPerBox)
                    .addComponent(txt_quatityPerBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_unitUnitsPerBox))
                .addGap(18, 18, 18)
                .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_weightPerBox)
                    .addComponent(txt_weightPerBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_unitWieghtPerBox))
                .addGap(18, 18, 18)
                .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_boxesPerPallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_boxesPerPallet)
                    .addComponent(lbl_unitBoxesPerPallet))
                .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_productLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbl_physicalStock))
                    .addGroup(pnl_productLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_physicalStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_unitPhysicalStock))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_FreeStock)
                    .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_freeStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_unitFreeStock)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_productLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_timeExpiration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel4))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_product, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btn_save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 462, Short.MAX_VALUE)
                .addComponent(btn_cancel)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_product, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_cancel))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initializeForm() {
        cbo_trademark.setEnabled(false);
        for (int i = 0; i < trademarkList.size(); i++) {
            if (trademarkList.get(i).getId_Trademark() == product.getTrademark()) {
                cbo_trademark.setSelectedItem(trademarkList.get(i).getName());
            }
        }

        cbo_conditionWH.setEnabled(false);
        for (int i = 0; i < tcWhList.size(); i++) {
            if (tcWhList.get(i).getIdType_Condition_WareHouse() == product.getTypeConditionWH()) {
                cbo_conditionWH.setSelectedItem(tcWhList.get(i).getDescription());
            }
        }
        txt_codEan13.setEnabled(false);
        txt_codEan13.setText(product.getCodeEAN13());
        txt_name.setText(product.getName());
        txt_quatityPerBox.setText(product.getQuantityPerBox().toString());
        txt_weightPerBox.setText(product.getWeightPerBox().toString());
        txt_boxesPerPallet.setText(product.getQuantityBoxesPerPallet().toString());
        txt_physicalStock.setText(product.getPhysicalStock().toString());
        txt_freeStock.setText(product.getFreeStock().toString());
        txt_timeExpiration.setText(product.getTimeExpiration().toString());
    }

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.dispose();
        menu_padre.setVisible(true);
        menu_padre.initilizeTable();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed

        if (txt_codEan13.getText().length() != 13 || !Validate.validarEntero(txt_codEan13.getText())
                || txt_name.getText().length() == 0 || cbo_conditionWH.getSelectedItem() == "Seleccione"
                || cbo_trademark.getSelectedItem() == "Seleccione"
                || !Validate.validarEntero(txt_quatityPerBox.getText())
                || !Validate.validarEntero(txt_weightPerBox.getText())
                || !Validate.validarEntero(txt_boxesPerPallet.getText())
                || !Validate.validarEntero(txt_timeExpiration.getText())) {
            JOptionPane.showMessageDialog(this, "Por favor complete todos los campos correctamente.");
        } else {

            Object[] options = {"OK"};
            if (JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?",
                    "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                DaoLog daoLog = new DaoLogImpl();
                Log logSI = null;
                if (product == null) { //Guardar nuevo producto
                    product = new Product();
                    product.setIdProduct(daoProducts.ProductsGetMaxID()+1);
                    product.setName(txt_name.getText());
                    product.setQuantityPerBox(Integer.parseInt(txt_quatityPerBox.getText()));
                    product.setWeightPerBox(Integer.parseInt(txt_weightPerBox.getText()));
                    product.setQuantityBoxesPerPallet(Integer.parseInt(txt_boxesPerPallet.getText()));
                    product.setPhysicalStock(Integer.parseInt(txt_physicalStock.getText()));
                    product.setFreeStock(Integer.parseInt(txt_freeStock.getText()));
                    product.setStatus(1);
                    product.setTrademark(trademarkSelected.getId_Trademark());
                    product.setTypeConditionWH(tcWhSelected.getIdType_Condition_WareHouse());
                    product.setCodeEAN13(txt_codEan13.getText());
                    product.setTimeExpiration(Integer.parseInt(txt_timeExpiration.getText()));
                    daoProducts.ProductsIns(product);
                    
                    daoLog.clientIns("Se ha ingresado un nuevo Producto al sistema con ID " + product.getIdProduct().toString(), Frm_Product.class.toString(), logSI.getIduser());
                } else {
                    product.setName(txt_name.getText());
                    product.setQuantityPerBox(Integer.parseInt(txt_quatityPerBox.getText()));
                    product.setWeightPerBox(Integer.parseInt(txt_weightPerBox.getText()));
                    product.setQuantityBoxesPerPallet(Integer.parseInt(txt_boxesPerPallet.getText()));
                    product.setTypeConditionWH(tcWhSelected.getIdType_Condition_WareHouse());
                    product.setTimeExpiration(Integer.parseInt(txt_timeExpiration.getText()));

                    daoProducts.ProductsUpd(product);
                    daoLog.clientIns("Se ha actualizado un Producto en el sistema con ID " + product.getIdProduct().toString(), Frm_Product.class.toString(), logSI.getIduser());
                }
                int ok_option = JOptionPane.showOptionDialog(new JFrame(), "Se ha registrado el producto con éxito", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (ok_option == JOptionPane.OK_OPTION) {
                    menu_padre.setVisible(true);
                    menu_padre.setLocationRelativeTo(null);
                    menu_padre.initilizeTable();
                    this.dispose();

                    
                }
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        menu_padre.setVisible(true);
        menu_padre.initilizeTable();
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void cbo_trademarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_trademarkActionPerformed
        if (cbo_trademark.getSelectedItem() != null) {
            for (int i = 0; i < trademarkList.size(); i++) {
                if (cbo_trademark.getSelectedItem().equals(trademarkList.get(i).getName())) {
                    trademarkSelected = trademarkList.get(i);
                }
            }
        }
    }//GEN-LAST:event_cbo_trademarkActionPerformed

    private void cbo_conditionWHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_conditionWHActionPerformed
        if (cbo_conditionWH.getSelectedItem() != null) {
            for (int i = 0; i < tcWhList.size(); i++) {
                if (cbo_conditionWH.getSelectedItem().equals(tcWhList.get(i).getDescription())) {
                    tcWhSelected = tcWhList.get(i);
                }
            }
        }
    }//GEN-LAST:event_cbo_conditionWHActionPerformed

    private void txt_timeExpirationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timeExpirationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timeExpirationActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox cbo_conditionWH;
    private javax.swing.JComboBox cbo_trademark;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl_FreeStock;
    private javax.swing.JLabel lbl_boxesPerPallet;
    private javax.swing.JLabel lbl_ean13;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_physicalStock;
    private javax.swing.JLabel lbl_quantityPerBox;
    private javax.swing.JLabel lbl_trademark;
    private javax.swing.JLabel lbl_unitBoxesPerPallet;
    private javax.swing.JLabel lbl_unitFreeStock;
    private javax.swing.JLabel lbl_unitPhysicalStock;
    private javax.swing.JLabel lbl_unitUnitsPerBox;
    private javax.swing.JLabel lbl_unitWieghtPerBox;
    private javax.swing.JLabel lbl_weightPerBox;
    private javax.swing.JPanel pnl_product;
    private javax.swing.JTextField txt_boxesPerPallet;
    private javax.swing.JTextField txt_codEan13;
    private javax.swing.JTextField txt_freeStock;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_physicalStock;
    private javax.swing.JTextField txt_quatityPerBox;
    private javax.swing.JTextField txt_timeExpiration;
    private javax.swing.JTextField txt_weightPerBox;
    // End of variables declaration//GEN-END:variables
}
