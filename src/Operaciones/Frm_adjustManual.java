/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Mantenimientos.Frm_Rack;
import Model.InternmentOrder;
import Model.InternmentOrderDetail;
import Model.Movement;
import Model.PalletProduct;
import Model.Product;
import Model.Rack;
import Model.Warehouse;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoInternmentOrder;
import dao.DaoInternmentOrderDetail;
import dao.DaoKardex;
import dao.DaoLocationCell;
import dao.DaoPallet;
import dao.DaoPalletIni;
import dao.DaoPalletProduct;
import dao.DaoProducts;
import dao.DaoRack;
import dao.DaoWH;
import dao.impl.DaoInternmentOrderDetailImpl;
import dao.impl.DaoInternmentOrderImpl;
import dao.impl.DaoKardexImpl;
import dao.impl.DaoLocationCellImpl;
import dao.impl.DaoPalletImpl;
import dao.impl.DaoPalletIniImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoRackImpl;
import dao.impl.DaoWHImpl;
import java.awt.Color;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

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
    DaoRack daoRack = new DaoRackImpl();
    DaoPallet daoPallet = new DaoPalletImpl();
    DaoLocationCell daoLocCell = new DaoLocationCellImpl();
    DaoPalletIni daoPalletIni = new DaoPalletIniImpl();
    Integer idWhSelected;
    Integer idRackSelected;
    Integer numFloorsRackSelected = 0;
    Integer numColumnsRackSelected = 0;
    Integer floorSelected;
    Integer columnSelected;
    Integer cellDetailSelected;

    List<Warehouse> whList;
    List<Rack> rackList;

    public Frm_adjustManual(Frm_MenuPrincipal menu) {
        setTitle("Ajuste Manual de Inventario");
        menu_padre = menu;
        initComponents();
        cbo_Wh.setEnabled(false);
        cbo_Rack.setEnabled(false);
//        cbo_numFloors.setEnabled(false);
//        cbo_numColumns.setEnabled(false);
//        cbo_detailCell.setEnabled(false);
        txt_codPallet.setEnabled(false);
        txt_EANProd.setEnabled(false);
        txt_nameProduct.setEnabled(false);

        txt_codPallet.setEnabled(false);
        txt_EANProd.setEnabled(false);
        whList = daoWh.whQry();
//        cbo_Wh.removeAllItems();
//        cbo_Wh.addItem("Seleccionar");        
        for (Warehouse whList1 : whList) {
            cbo_Wh.addItem(whList1.getDescription());
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
        pnl_intern = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_codPallet = new javax.swing.JTextField();
        txt_EANProd = new javax.swing.JTextField();
        txt_nameProduct = new javax.swing.JTextField();
        lbl_validatePallet = new javax.swing.JLabel();
        radioBtn_Intern = new javax.swing.JRadioButton();
        radioBtn_exit = new javax.swing.JRadioButton();
        pnl_exit = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbo_Wh = new javax.swing.JComboBox();
        cbo_Rack = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_numFloor = new javax.swing.JTextField();
        txt_numCol = new javax.swing.JTextField();
        txt_numCellDetail = new javax.swing.JTextField();
        lbl_numFloors = new javax.swing.JLabel();
        lbl_num_Columns = new javax.swing.JLabel();
        lbl_numCellDetail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btn_save.setText("Realizar Ajuste");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        pnl_intern.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Ingreso por Ajuste"));

        jLabel2.setText("Código de Pallet");

        jLabel3.setText("EAN13  Producto");

        jLabel4.setText("Nombre Producto");

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

        javax.swing.GroupLayout pnl_internLayout = new javax.swing.GroupLayout(pnl_intern);
        pnl_intern.setLayout(pnl_internLayout);
        pnl_internLayout.setHorizontalGroup(
            pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_internLayout.createSequentialGroup()
                .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_internLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(60, 60, 60)
                        .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nameProduct)
                            .addComponent(txt_EANProd)))
                    .addGroup(pnl_internLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(66, 66, 66)
                        .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_validatePallet)
                            .addComponent(txt_codPallet, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        pnl_internLayout.setVerticalGroup(
            pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_internLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codPallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(lbl_validatePallet)
                .addGap(21, 21, 21)
                .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_EANProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_nameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        radioBtn_Intern.setText("Internamiento");
        radioBtn_Intern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtn_InternActionPerformed(evt);
            }
        });

        radioBtn_exit.setText("Salida");
        radioBtn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtn_exitActionPerformed(evt);
            }
        });

        pnl_exit.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Salida por Ajuste"));

        jLabel5.setText("Almacén");

        jLabel6.setText("Rack");

        cbo_Wh.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar" }));
        cbo_Wh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_WhActionPerformed(evt);
            }
        });

        cbo_Rack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_RackActionPerformed(evt);
            }
        });

        jLabel1.setText("Piso");

        jLabel7.setText("Columna");

        jLabel8.setText("Detalle");

        txt_numCol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numColActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_exitLayout = new javax.swing.GroupLayout(pnl_exit);
        pnl_exit.setLayout(pnl_exitLayout);
        pnl_exitLayout.setHorizontalGroup(
            pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_exitLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbo_Wh, 0, 211, Short.MAX_VALUE)
                        .addComponent(cbo_Rack, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_exitLayout.createSequentialGroup()
                        .addGroup(pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txt_numFloor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                            .addComponent(txt_numCol, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_numCellDetail, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_numFloors)
                            .addComponent(lbl_num_Columns)
                            .addComponent(lbl_numCellDetail))))
                .addGap(42, 42, 42))
        );
        pnl_exitLayout.setVerticalGroup(
            pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_exitLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbo_Wh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbo_Rack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_numFloor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_numFloors))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_numCol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_num_Columns))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_numCellDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_numCellDetail))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnl_intern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioBtn_Intern))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioBtn_exit)
                            .addComponent(pnl_exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioBtn_Intern)
                    .addComponent(radioBtn_exit))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_intern, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addComponent(btn_save)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        if (!radioBtn_Intern.isSelected() && !radioBtn_exit.isSelected()) {
            JOptionPane.showMessageDialog(this, "Seleccione el tipo de ajuste manual (Internamiento o Salida)");
        } else {
            if (typeAjustSelected == 1) { //Internamiento de producto
                InternmentOrder intOrder = daoIntOrder.IntOrderGet(999999999);
                List<InternmentOrderDetail> intOrderDetList = new ArrayList<>();
                InternmentOrderDetail intOrdDetail = new InternmentOrderDetail();
                List<InternmentOrder> internOrderList = new ArrayList<>();
                intOrdDetail.setIdInternmentOrderDetail(daoIntOrdDetail.IntOrderDetailMaxId(product.getIdProduct(), 999999999) + 1);
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
            if (typeAjustSelected == 2) { //Salida de producto
                floorSelected = Integer.parseInt(txt_numFloor.getText());
                columnSelected = Integer.parseInt(txt_numCol.getText());
                cellDetailSelected = Integer.parseInt(txt_numCellDetail.getText());
                Integer idLocCell = daoLocCell.idLocatioCellByColumFloor(idWhSelected, idRackSelected, columnSelected, floorSelected);
                palletProd = daoPallet.palletProducLocatioCellDetailGet(idWhSelected, idRackSelected, idLocCell, cellDetailSelected);
                if (palletProd != null) {
                    daoLocCell.LocationCellAvailabilityUpd(1, idWhSelected, idRackSelected, idLocCell, cellDetailSelected, 1);//Se actualiza la disponibilidad a 1
                    Movement mov = new Movement();
                    mov.setIdProduct(palletProd.getIdproduct());
                    mov.setIdWh(idWhSelected);
                    mov.setType_Movement_id(2);
                    mov.setType_Movement_idSubtype(3);
                    Product prod = daoProduct.ProductsGet(palletProd.getIdproduct());
                    mov.setStock_inicial(prod.getPhysicalStock());
                    mov.setStock_final(prod.getPhysicalStock() - prod.getQuantityBoxesPerPallet());
                    mov.setDate(new Date());
                    daoMov.MovementIns(mov);
                    List<Integer> pallets = new ArrayList<>();
                    pallets.add(palletProd.getIdpallet());
                    daoPalletIni.PalletsIniUpdStatus(pallets, 2);
                    daoPalletProd.palletProductByLocaCellUpdStatus(0, palletProd.getIdpallet(), prod.getTrademark(), prod.getIdProduct(), idLocCell, cellDetailSelected, idRackSelected, idWhSelected);
                    daoProduct.ProductUpdStock(prod.getIdProduct(), 1, 2);//se actualiza el stock con un pallet con idMovimiento 2 (salida)
                } else {
                    JOptionPane.showMessageDialog(this, "La ubicación no tiene ningún Pallet asociado");
                }
            }
        }

    }//GEN-LAST:event_btn_saveActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        menu_padre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void txt_codPalletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_codPalletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_codPalletActionPerformed

    private void txt_codPalletFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_codPalletFocusLost
        if (txt_codPallet.getText().length() > 0) {
            palletProd = daoPalletProd.getPalletProductById(Integer.parseInt(txt_codPallet.getText()));
            if (palletProd != null) {
                lbl_validatePallet.setText("Pallet correcto");
                lbl_validatePallet.setForeground(Color.green);
                product = daoProduct.ProductsGet(palletProd.getIdproduct());
                txt_EANProd.setText(product.getCodeEAN13());
                txt_nameProduct.setText(product.getName());
            } else {
                lbl_validatePallet.setForeground(Color.red);
                lbl_validatePallet.setText("Pallet no asociado a un producto");
                txt_EANProd.setText("");
                txt_nameProduct.setText("");
            }
        }

    }//GEN-LAST:event_txt_codPalletFocusLost

    private void radioBtn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtn_exitActionPerformed
        cbo_Wh.setEnabled(true);
        cbo_Rack.setEnabled(false);
        radioBtn_Intern.setSelected(false);
        txt_codPallet.setEnabled(false);
        txt_EANProd.setEnabled(false);
        txt_nameProduct.setEnabled(false);

        txt_codPallet.setEnabled(false);
        txt_EANProd.setEnabled(false);
        typeAjustSelected = 2;
    }//GEN-LAST:event_radioBtn_exitActionPerformed

    private void radioBtn_InternActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtn_InternActionPerformed
        txt_codPallet.setEnabled(true);
        txt_EANProd.setEnabled(true);
        txt_nameProduct.setEnabled(true);
        radioBtn_exit.setSelected(false);
        cbo_Wh.setEnabled(false);
        cbo_Rack.setEnabled(false);
        typeAjustSelected = 1;
    }//GEN-LAST:event_radioBtn_InternActionPerformed

    private void cbo_WhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_WhActionPerformed
        int opcion = 1;
        for (Warehouse whList1 : whList) {
            if (cbo_Wh.getSelectedItem().toString().equals(whList1.getDescription()) && !cbo_Wh.getSelectedItem().toString().equals("Seleccionar")) {
                idWhSelected = whList1.getIdWarehouse();
                opcion = 1;
                break;
            } else {
                opcion = 0;
            }
        }

        cbo_Rack.setEnabled(true);
        cbo_Rack.removeAllItems();
        rackList = daoRack.rackQueryByWarehouse(daoWh.whGet(idWhSelected));
        cbo_Rack.addItem("Seleccionar");

        if (opcion == 1) {
            for (Rack rackList1 : rackList) {
                cbo_Rack.addItem(rackList1.getIdentifier());
            }
        }
    }//GEN-LAST:event_cbo_WhActionPerformed

    private void cbo_RackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_RackActionPerformed
        int opcion = 1;
        lbl_numCellDetail.setText("");
        lbl_numFloors.setText("");
        lbl_num_Columns.setText("");
        if (cbo_Rack.getItemCount() > 0) {
            for (Rack rack : rackList) {
                if (cbo_Rack.getSelectedItem().toString().equals(rack.getIdentifier()) && !cbo_Rack.getSelectedItem().toString().equals("Seleccionar")) {
                    idRackSelected = rack.getIdRack();
                    numFloorsRackSelected = rack.getFloor_numbers();
                    lbl_numFloors.setText("Máximo: " + numFloorsRackSelected.toString());
                    numColumnsRackSelected = rack.getColumn_number();
                    lbl_num_Columns.setText("Máximo: " + numColumnsRackSelected.toString());
                    lbl_numCellDetail.setText("(1 o 2)");
                    opcion = 1;
                    break;
                } else {
                    opcion = 0;
                }
            }
        }
//        cbo_numFloors.setEnabled(true);
//        cbo_numFloors.removeAllItems();
////        cbo_numFloors.addItem("Seleccionar");
//        cbo_numColumns.setEnabled(true);
//        cbo_numColumns.removeAllItems();
////        cbo_numColumns.addItem("Seleccionar");
//        cbo_detailCell.setEnabled(true);
//        cbo_detailCell.removeAllItems();
////        cbo_detailCell.addItem("Seleccionar");
//        if (opcion == 1) {
//            for (int i = 0; i < numFloorsRackSelected; i++) {
//                cbo_numFloors.addItem(i + 1);
//            }
//            for (int i = 0; i < numColumnsRackSelected; i++) {
//                cbo_numColumns.addItem(i + 1);
//            }
//            for (int i = 0; i < Frm_Rack.NUM_CEL_DETAILS; i++) {
//                cbo_detailCell.addItem(i + 1);
//            }
//        }
    }//GEN-LAST:event_cbo_RackActionPerformed

    private void txt_numColActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numColActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numColActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox cbo_Rack;
    private javax.swing.JComboBox cbo_Wh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbl_numCellDetail;
    private javax.swing.JLabel lbl_numFloors;
    private javax.swing.JLabel lbl_num_Columns;
    private javax.swing.JLabel lbl_validatePallet;
    private javax.swing.JPanel pnl_exit;
    private javax.swing.JPanel pnl_intern;
    private javax.swing.JRadioButton radioBtn_Intern;
    private javax.swing.JRadioButton radioBtn_exit;
    private javax.swing.JTextField txt_EANProd;
    private javax.swing.JTextField txt_codPallet;
    private javax.swing.JTextField txt_nameProduct;
    private javax.swing.JTextField txt_numCellDetail;
    private javax.swing.JTextField txt_numCol;
    private javax.swing.JTextField txt_numFloor;
    // End of variables declaration//GEN-END:variables
}
