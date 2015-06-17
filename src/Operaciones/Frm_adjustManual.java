/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Mantenimientos.Frm_Rack;
import Model.InternmentOrder;
import Model.InternmentOrderDetail;
import Model.Log;
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
import dao.DaoLog;
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
import dao.impl.DaoLogImpl;
import dao.impl.DaoPalletImpl;
import dao.impl.DaoPalletIniImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoRackImpl;
import dao.impl.DaoWHImpl;
import java.awt.Color;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
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
    Integer subTypeExit;
    List<Integer> listidpallet = new ArrayList<Integer>();

    List<Warehouse> whList;
    List<Rack> rackList;

    public Frm_adjustManual(Frm_MenuPrincipal menu) {
        setTitle("Ajuste Manual de Inventario");
        menu_padre = menu;
        initComponents();
        cbo_Wh.setEnabled(false);
        cbo_Rack.setEnabled(false);
        txt_numFloor.setEnabled(false);
        txt_numCol.setEnabled(false);
        txt_numCellDetail.setEnabled(false);
        radioBtn_adjust.setEnabled(false);
        radioBtn_perdida.setEnabled(false);
        radioBtn_rotura.setEnabled(false);

        btn_searchPallet.setEnabled(false);
        btn_searchProduct.setEnabled(false);
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
        btn_searchPallet = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_idProduct = new javax.swing.JTextField();
        btn_searchProduct = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_trademark = new javax.swing.JTextField();
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
        radioBtn_rotura = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        radioBtn_adjust = new javax.swing.JRadioButton();
        radioBtn_perdida = new javax.swing.JRadioButton();

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

        pnl_intern.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Internamiento de Producto"));

        jLabel2.setText("Código de Pallet");

        jLabel3.setText("EAN13  Producto");

        jLabel4.setText("Nombre Producto");

        txt_codPallet.setEnabled(false);
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

        txt_EANProd.setEnabled(false);

        txt_nameProduct.setEnabled(false);

        btn_searchPallet.setText("Buscar");
        btn_searchPallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchPalletActionPerformed(evt);
            }
        });

        jLabel9.setText("Código de Producto");

        txt_idProduct.setEnabled(false);

        btn_searchProduct.setText("Buscar");
        btn_searchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchProductActionPerformed(evt);
            }
        });

        jLabel10.setText("Marca Producto");

        txt_trademark.setEnabled(false);

        javax.swing.GroupLayout pnl_internLayout = new javax.swing.GroupLayout(pnl_intern);
        pnl_intern.setLayout(pnl_internLayout);
        pnl_internLayout.setHorizontalGroup(
            pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_internLayout.createSequentialGroup()
                .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_internLayout.createSequentialGroup()
                        .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_internLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel2))
                            .addGroup(pnl_internLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9)))
                        .addGap(49, 49, 49)
                        .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_codPallet, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                            .addComponent(txt_idProduct))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_searchPallet, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(lbl_validatePallet)
                            .addComponent(btn_searchProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnl_internLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10))
                        .addGap(60, 60, 60)
                        .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_EANProd)
                            .addComponent(txt_nameProduct)
                            .addComponent(txt_trademark, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        pnl_internLayout.setVerticalGroup(
            pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_internLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_codPallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchPallet))
                .addGap(2, 2, 2)
                .addComponent(lbl_validatePallet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_idProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_searchProduct)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_EANProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_nameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_internLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_trademark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        pnl_exit.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Salida de Producto"));

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

        jLabel8.setText("División");

        txt_numCol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numColActionPerformed(evt);
            }
        });

        radioBtn_rotura.setText("Rotura");
        radioBtn_rotura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtn_roturaActionPerformed(evt);
            }
        });

        jLabel11.setText("Tipo de Salida");

        radioBtn_adjust.setText("Ajuste");
        radioBtn_adjust.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtn_adjustActionPerformed(evt);
            }
        });

        radioBtn_perdida.setText("Pérdida");
        radioBtn_perdida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtn_perdidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_exitLayout = new javax.swing.GroupLayout(pnl_exit);
        pnl_exit.setLayout(pnl_exitLayout);
        pnl_exitLayout.setHorizontalGroup(
            pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_exitLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_exitLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_exitLayout.createSequentialGroup()
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
                    .addGroup(pnl_exitLayout.createSequentialGroup()
                        .addComponent(radioBtn_adjust)
                        .addGap(18, 18, 18)
                        .addComponent(radioBtn_rotura)
                        .addGap(18, 18, 18)
                        .addComponent(radioBtn_perdida)
                        .addGap(0, 142, Short.MAX_VALUE))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_exitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioBtn_rotura)
                    .addComponent(radioBtn_perdida)
                    .addComponent(radioBtn_adjust))
                .addContainerGap(36, Short.MAX_VALUE))
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
                            .addComponent(radioBtn_Intern)
                            .addComponent(pnl_intern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radioBtn_exit)
                            .addComponent(pnl_exit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(335, 335, 335)
                        .addComponent(btn_save, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
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

            Object[] options = {"OK"};
            if (JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?",
                    "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                DaoLog daoLog = new DaoLogImpl();
                Log logSI = null;
                if (typeAjustSelected == 1) { //Internamiento de producto
                    product = daoProduct.ProductsGet(Integer.parseInt(txt_idProduct.getText()));
                    insertPalletProduct();
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
                    daoLog.clientIns("Se ha realizado un internamiento por ajuste de inventario manual ", Frm_adjustManual.class.toString(), logSI.getIduser());
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
                        mov.setType_Movement_idSubtype(subTypeExit);
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
                        daoLog.clientIns("Se ha realizado una salida por ajuste de inventario manual ", Frm_adjustManual.class.toString(), logSI.getIduser());
                    } else {
                        JOptionPane.showMessageDialog(this, "La ubicación no tiene ningún Pallet asociado");
                    }
                    
                    }
                int ok_option = JOptionPane.showOptionDialog(new JFrame(), "Se ha realizado el ajuste manual de inventario con éxito", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (ok_option == JOptionPane.OK_OPTION) {
                        menu_padre.setVisible(true);
                        menu_padre.setLocationRelativeTo(null);
                        this.dispose();
                }

            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed

    public void insertPalletProduct() {
        List<Integer> listidpallet = new ArrayList<>();
        listidpallet.add(Integer.parseInt(txt_codPallet.getText()));        
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE,product.getTimeExpiration());
                daoPalletProd.PalletProductInsMasive(listidpallet, product.getTrademark(), product.getIdProduct(), cal.getTime(), 999999999);
    }
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
        btn_searchPallet.setEnabled(false);
        btn_searchProduct.setEnabled(false);
        txt_codPallet.setEnabled(false);
        txt_EANProd.setEnabled(false);
        txt_nameProduct.setEnabled(false);

        txt_codPallet.setEnabled(false);
        txt_EANProd.setEnabled(false);
        typeAjustSelected = 2;
    }//GEN-LAST:event_radioBtn_exitActionPerformed

    private void radioBtn_InternActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtn_InternActionPerformed
        btn_searchPallet.setEnabled(true);
        btn_searchProduct.setEnabled(true);
        radioBtn_exit.setSelected(false);
        cbo_Wh.setEnabled(false);
        cbo_Rack.setEnabled(false);
        txt_numFloor.setEnabled(false);
        txt_numCol.setEnabled(false);
        txt_numCellDetail.setEnabled(false);
        radioBtn_adjust.setEnabled(false);
        radioBtn_perdida.setEnabled(false);
        radioBtn_rotura.setEnabled(false);        
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
                    txt_numFloor.setEnabled(true);
                    txt_numCol.setEnabled(true);
                    txt_numCellDetail.setEnabled(true);
                    radioBtn_adjust.setEnabled(true);
                    radioBtn_perdida.setEnabled(true);
                    radioBtn_rotura.setEnabled(true);
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

    private void btn_searchPalletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchPalletActionPerformed
        Frm_searchPallet frm_searchPallet = new Frm_searchPallet(this);
        frm_searchPallet.setVisible(true);
        frm_searchPallet.setLocationRelativeTo(null);
        this.setEnabled(false);
    }//GEN-LAST:event_btn_searchPalletActionPerformed

    private void btn_searchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchProductActionPerformed
        Frm_SearchProduct frm_searchProduct = new Frm_SearchProduct(this);
        frm_searchProduct.setVisible(true);
        frm_searchProduct.setLocationRelativeTo(null);
        this.setEnabled(false);
    }//GEN-LAST:event_btn_searchProductActionPerformed

    private void radioBtn_adjustActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtn_adjustActionPerformed
        radioBtn_perdida.setSelected(false);
        radioBtn_rotura.setSelected(false);
        subTypeExit = 3;        
    }//GEN-LAST:event_radioBtn_adjustActionPerformed

    private void radioBtn_roturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtn_roturaActionPerformed
        radioBtn_perdida.setSelected(false);
        radioBtn_adjust.setSelected(false);
        subTypeExit = 4; 
    }//GEN-LAST:event_radioBtn_roturaActionPerformed

    private void radioBtn_perdidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtn_perdidaActionPerformed
        radioBtn_rotura.setSelected(false);
        radioBtn_adjust.setSelected(false);
        subTypeExit = 5; 
    }//GEN-LAST:event_radioBtn_perdidaActionPerformed

    public void setTxtCodPallet(Integer idPallet) {
        txt_codPallet.setText(idPallet.toString());
    }

    public void setTxtCodProduct(String idProduct) {
        txt_idProduct.setText(idProduct);
    }

    public void setTxtEAN13(String EAN13) {
        txt_EANProd.setText(EAN13);
    }

    public void setTxtName(String nameProduct) {
        txt_nameProduct.setText(nameProduct);
    }

    public void setTxtTrademark(String trademark) {
        txt_trademark.setText(trademark);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_searchPallet;
    private javax.swing.JButton btn_searchProduct;
    private javax.swing.JComboBox cbo_Rack;
    private javax.swing.JComboBox cbo_Wh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl_numCellDetail;
    private javax.swing.JLabel lbl_numFloors;
    private javax.swing.JLabel lbl_num_Columns;
    private javax.swing.JLabel lbl_validatePallet;
    private javax.swing.JPanel pnl_exit;
    private javax.swing.JPanel pnl_intern;
    private javax.swing.JRadioButton radioBtn_Intern;
    private javax.swing.JRadioButton radioBtn_adjust;
    private javax.swing.JRadioButton radioBtn_exit;
    private javax.swing.JRadioButton radioBtn_perdida;
    private javax.swing.JRadioButton radioBtn_rotura;
    private javax.swing.JTextField txt_EANProd;
    private javax.swing.JTextField txt_codPallet;
    private javax.swing.JTextField txt_idProduct;
    private javax.swing.JTextField txt_nameProduct;
    private javax.swing.JTextField txt_numCellDetail;
    private javax.swing.JTextField txt_numCol;
    private javax.swing.JTextField txt_numFloor;
    private javax.swing.JTextField txt_trademark;
    // End of variables declaration//GEN-END:variables
}
