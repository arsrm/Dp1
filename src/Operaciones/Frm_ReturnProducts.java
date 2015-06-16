/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Operaciones;

import Model.Client;
import Model.DispatchOrder;
import Model.ExecutionAlgorithm;
import Model.ExecutionAlgorithmDetail;
import Model.Movement;
import Model.PalletProduct;
import Model.Pallet_Product_Location;
import Model.PickingOrder;
import Model.PickingOrderDetail;
import Model.Product;
import Model.ProductReturn;
import Model.RequestOrder;
import Model.StateRequestOrder;
import Model.Vehicle;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoClient;
import dao.DaoDispatchOrder;
import dao.DaoExecutionAlgorithm;
import dao.DaoExecutionAlgorithmDetail;
import dao.DaoKardex;
import dao.DaoPalletProduct;
import dao.DaoPallet_Product_Location;
import dao.DaoPickingOrder;
import dao.DaoPickingOrderDetail;
import dao.DaoProductReturn;
import dao.DaoProducts;
import dao.DaoRequestOrder;
import dao.DaoStateRequestOrder;
import dao.DaoVehicle;
import dao.impl.DaoClientImpl;
import dao.impl.DaoDispatchOrderImpl;
import dao.impl.DaoExecutionAlgorithmDetailImpl;
import dao.impl.DaoExecutionAlgorithmImpl;
import dao.impl.DaoKardexImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoPallet_Producto_LocationImpl;
import dao.impl.DaoPickingOrderDetailImpl;
import dao.impl.DaoPickingOrderImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoProductReturnImpl;
import dao.impl.DaoRequestOrderImpl;
import dao.impl.DaoStateRequestOrderImpl;
import dao.impl.DaoVehicleImpl;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import tool.SelectAllHeader;

/**
 *
 * @author Luis Miguel
 */
public class Frm_ReturnProducts extends javax.swing.JFrame {
    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();
    Frm_DispatchOrder_Detail frm_dodAux = new Frm_DispatchOrder_Detail();
    
    DaoDispatchOrder daoDispatchOrder = new DaoDispatchOrderImpl();
    DispatchOrder dispatchOrder = null;
    
    DaoClient daoClient = new DaoClientImpl();
    Client client = null;
    
    
    DaoExecutionAlgorithm daoExecutionAlgorithm = new DaoExecutionAlgorithmImpl();
    List<ExecutionAlgorithm> executionAlgorithmList = null;
    ExecutionAlgorithm executionAlgorithm = null;
    
    DaoExecutionAlgorithmDetail daoExecutionAlgorithmDetail = new DaoExecutionAlgorithmDetailImpl();
    List<ExecutionAlgorithmDetail> executionAlgorithmDetailList = null;
    ExecutionAlgorithmDetail executionAlgorithmDetail = null;
    
    DaoPickingOrderDetail daoPickingOrderDetail = new DaoPickingOrderDetailImpl();
    List<PickingOrderDetail> pickingOrderDetailList = null;
    
    DaoPallet_Product_Location daoPalletProductLocation = new DaoPallet_Producto_LocationImpl();
    List<Pallet_Product_Location> palletProductLocationList = null;
    
    DaoProducts daoProduct = new DaoProdImpl();
    List<Product> productList = null;
    
    DaoVehicle daoVehicle = new DaoVehicleImpl();
    Vehicle vehicle = new Vehicle();
    
    DaoProductReturn daoProductReturn = new DaoProductReturnImpl();
    ProductReturn productReturn = null;
    
    DaoPalletProduct daoPalletProduct = new DaoPalletProductImpl();
    
    DaoKardex daoKardex = new DaoKardexImpl();
    Movement movementIn = null;
    Movement movementOut = null;
    
    DaoPickingOrder daoPickingOrder = new DaoPickingOrderImpl();
    DaoRequestOrder daoRequestOrder = new DaoRequestOrderImpl();
    DaoStateRequestOrder daoStateOrderRequest = new DaoStateRequestOrderImpl();
    int cancelAll;
    
    DefaultTableModel modelo;
    /**
     * Creates new form Frm_ReturnProducts
     */
    public Frm_ReturnProducts(Frm_MenuPrincipal menu) {
        setTitle("Devolución de Productos");
        menuaux = menu;
        initComponents();
        blockObjects();
        TableColumn tc = tbl_products.getColumnModel().getColumn(4);
        tc.setHeaderRenderer(new SelectAllHeader(tbl_products, 4));
        cancelAll = 0;
    }
    
    public Frm_ReturnProducts(Frm_DispatchOrder_Detail frm_dod, DispatchOrder dispatch) {
        setTitle("Devolución de Productos");
        frm_dodAux = frm_dod;
        initComponents();
        blockObjects();
        dispatchOrder = dispatch;
        vehicle = dispatchOrder.getIdVehicle();
        pickingOrderDetailList = daoPickingOrderDetail.pickingOrderDetailQry(dispatchOrder.getIdPickingOrder());
        TableColumn tc = tbl_products.getColumnModel().getColumn(4);
        tc.setHeaderRenderer(new SelectAllHeader(tbl_products, 4));
        fillData();
        getProductList();
        cancelAll = 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_search_criteria = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_search = new javax.swing.JButton();
        txt_DispatchOrder = new javax.swing.JTextField();
        pnl_products = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_products = new javax.swing.JTable();
        btn_cancel = new javax.swing.JButton();
        btn_return = new javax.swing.JButton();
        pnl_general_info = new javax.swing.JPanel();
        lbl_order_num = new javax.swing.JLabel();
        txt_OrderNum = new javax.swing.JTextField();
        lbl_client = new javax.swing.JLabel();
        txt_ClientId = new javax.swing.JTextField();
        txt_ClientName = new javax.swing.JTextField();
        lbl_deliver_date = new javax.swing.JLabel();
        lbl_address = new javax.swing.JLabel();
        lbl_reg_date = new javax.swing.JLabel();
        jDate_RegisterDate = new com.toedter.calendar.JDateChooser();
        jDate_DeliverDate = new com.toedter.calendar.JDateChooser();
        txt_ClientAddress = new javax.swing.JTextField();
        lbl_dispatcher = new javax.swing.JLabel();
        txt_name_dispatcher = new javax.swing.JTextField();
        txt_id_dispatcher = new javax.swing.JTextField();
        lbl_vehicle = new javax.swing.JLabel();
        txt_vehicle_license_plate = new javax.swing.JTextField();
        pnl_return = new javax.swing.JPanel();
        lbl_return_date = new javax.swing.JLabel();
        jDate_return_date = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_search_criteria.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios Búsqueda"));

        jLabel1.setText("Número de Orden de Despacho:");

        btn_search.setText("Buscar Orden");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_search_criteriaLayout = new javax.swing.GroupLayout(pnl_search_criteria);
        pnl_search_criteria.setLayout(pnl_search_criteriaLayout);
        pnl_search_criteriaLayout.setHorizontalGroup(
            pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_DispatchOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btn_search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_search_criteriaLayout.setVerticalGroup(
            pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_search_criteriaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_search)
                    .addComponent(jLabel1)
                    .addComponent(txt_DispatchOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pnl_products.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        tbl_products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número Detalle", "Código Pallet", "Descripción", "Estado", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_products);

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_return.setText("Registrar Devolución");
        btn_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_returnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_productsLayout = new javax.swing.GroupLayout(pnl_products);
        pnl_products.setLayout(pnl_productsLayout);
        pnl_productsLayout.setHorizontalGroup(
            pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_productsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_productsLayout.createSequentialGroup()
                        .addComponent(btn_return)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cancel)))
                .addContainerGap())
        );
        pnl_productsLayout.setVerticalGroup(
            pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_productsLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_cancel)
                    .addComponent(btn_return))
                .addGap(3, 3, 3))
        );

        pnl_general_info.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        lbl_order_num.setText("Número de Orden: ");
        lbl_order_num.setToolTipText("");

        txt_OrderNum.setEditable(false);

        lbl_client.setText("Cliente: ");

        txt_ClientId.setEditable(false);

        txt_ClientName.setEditable(false);

        lbl_deliver_date.setText("Fecha Entrega Estimada:");

        lbl_address.setText("Dirección:");

        lbl_reg_date.setText("Fecha Registro:");

        txt_ClientAddress.setEditable(false);

        lbl_dispatcher.setText("Transportista:");

        txt_name_dispatcher.setEditable(false);

        txt_id_dispatcher.setEditable(false);

        lbl_vehicle.setText("Vehículo:");

        txt_vehicle_license_plate.setEditable(false);

        javax.swing.GroupLayout pnl_general_infoLayout = new javax.swing.GroupLayout(pnl_general_info);
        pnl_general_info.setLayout(pnl_general_infoLayout);
        pnl_general_infoLayout.setHorizontalGroup(
            pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_client)
                    .addComponent(lbl_order_num)
                    .addComponent(lbl_address)
                    .addComponent(lbl_vehicle)
                    .addComponent(lbl_reg_date))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_general_infoLayout.createSequentialGroup()
                        .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_vehicle_license_plate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDate_RegisterDate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_dispatcher)
                            .addComponent(lbl_deliver_date))
                        .addGap(23, 23, 23)
                        .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                                .addComponent(jDate_DeliverDate, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112))
                            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                                .addComponent(txt_id_dispatcher)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_name_dispatcher, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))))
                    .addGroup(pnl_general_infoLayout.createSequentialGroup()
                        .addComponent(txt_OrderNum, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_general_infoLayout.createSequentialGroup()
                        .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_ClientAddress, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                                .addComponent(txt_ClientId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_ClientName)))
                        .addGap(281, 281, 281))))
        );
        pnl_general_infoLayout.setVerticalGroup(
            pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_OrderNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_order_num))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ClientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_ClientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_client))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_address)
                    .addComponent(txt_ClientAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_general_infoLayout.createSequentialGroup()
                            .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_id_dispatcher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbl_vehicle)
                                    .addComponent(txt_name_dispatcher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(6, 6, 6))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_general_infoLayout.createSequentialGroup()
                            .addComponent(txt_vehicle_license_plate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_general_infoLayout.createSequentialGroup()
                        .addComponent(lbl_dispatcher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDate_RegisterDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_deliver_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDate_DeliverDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_reg_date))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_return.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Devolucion"));

        lbl_return_date.setText("Fecha Devolución");

        javax.swing.GroupLayout pnl_returnLayout = new javax.swing.GroupLayout(pnl_return);
        pnl_return.setLayout(pnl_returnLayout);
        pnl_returnLayout.setHorizontalGroup(
            pnl_returnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_returnLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(lbl_return_date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jDate_return_date, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_returnLayout.setVerticalGroup(
            pnl_returnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_returnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_returnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDate_return_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_return_date))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnl_products, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_search_criteria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_general_info, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_return, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_search_criteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_general_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_return, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_products, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        if(cancelAll==1){
            frm_dodAux.setVisible(true);
            this.dispose();
        }else{
            menuaux.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(cancelAll==1){
            frm_dodAux.setVisible(true);
            this.dispose();
        }else{
            menuaux.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void btn_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_returnActionPerformed

        int idDispatchDetail=0,idPickingOrder,idPickingOrderDetail,initialStock,finalStock;
        
        
        Object[] options = {"OK"};
        if (JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?",
                "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if(jDate_return_date.getDate()!=null){
                for (int i = 0; i < tbl_products.getRowCount(); i++) {
                    getProductList();
                    if ((Boolean) tbl_products.getValueAt(i, 4)) {
                        idDispatchDetail = Integer.parseInt(tbl_products.getValueAt(i, 0).toString());
                        idPickingOrder = pickingOrderDetailList.get(i).getPicking_Order_idPicking_Order();
                        idPickingOrderDetail = pickingOrderDetailList.get(i).getIdPicking_Order_Detail();
                        int status = pickingOrderDetailList.get(i).getDispatchStatus();
                        if (status == 2) {
                            //lo pondre inactivo
                            daoPickingOrderDetail.pickingOrderDetailDel(idPickingOrderDetail, idPickingOrder, 4);
                            daoPickingOrderDetail.pickingOrderDetailReturnToWarehouse(idPickingOrderDetail, idPickingOrder);
                            //guardo el ProductReturn
                            productReturn = new ProductReturn();
                            productReturn.setQuantity(1);
                            productReturn.setStatus(1);
                            productReturn.setIdDispatch_Order(dispatchOrder.getIdDispatch_Order());
                            productReturn.setIdClient(client.getIdClient());
                            productReturn.setReturn_date(jDate_return_date.getDate());
                            productReturn.setMotive_Return_idMotive_Return(1);
                            productReturn.setPicking_Order_Detail_idPicking_Order_Detail(idPickingOrderDetail);;
                            productReturn.setPicking_Order_Detail_Picking_Order_idPicking_Order(idPickingOrder);
                            productReturn.setPicking_Order_Detail_Product_idProduct(productList.get(i).getIdProduct());
                            daoProductReturn.productReturnIns(productReturn);
                            
                            //guardo la entrada por devolucion y salida por devolucion del producto
                            movementIn = new Movement();
                            movementIn.setDate(jDate_return_date.getDate());
                            movementIn.setType_Movement_id(1);
                            movementIn.setType_Movement_idSubtype(2);
                            initialStock = productList.get(i).getPhysicalStock();
                            System.out.println("initial Stock"+initialStock);
                            System.out.println("id:"+productList.get(i).getIdProduct());
                            movementIn.setStock_inicial(initialStock);
                            finalStock = initialStock + productList.get(i).getQuantityBoxesPerPallet() * 1;
                            movementIn.setStock_final(finalStock);
                            movementIn.setIdProduct(productList.get(i).getIdProduct());
                            movementIn.setIdWh(palletProductLocationList.get(i).getLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse());
                            daoKardex.MovementIns(movementIn);
                            daoProduct.ProductUpdStock(productList.get(i).getIdProduct(), 1, 1);
                             getProductList();
                            movementOut = new Movement();
                            movementOut.setDate(jDate_return_date.getDate());
                            movementOut.setType_Movement_id(2);
                            movementOut.setType_Movement_idSubtype(2);
                            initialStock = productList.get(i).getPhysicalStock();
                            System.out.println("initial Stock"+initialStock);
                            movementOut.setStock_inicial(initialStock);
                            finalStock = initialStock - productList.get(i).getQuantityBoxesPerPallet() * 1;
                            movementOut.setStock_final(finalStock);
                            movementOut.setIdProduct(productList.get(i).getIdProduct());
                            movementOut.setIdWh(palletProductLocationList.get(i).getLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse());
                            daoKardex.MovementIns(movementOut);
                            daoProduct.ProductUpdStock(productList.get(i).getIdProduct(), 1, 2);
                            
                            
                        }
                    }
                }
                int ok_option = JOptionPane.showOptionDialog(new JFrame(), "Se ha registrado la devolución con éxito", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if(cancelAll == 1){//cancelar la orden de despacho y de pedido
                    daoDispatchOrder.dispatchOrderDel(dispatchOrder.getIdDispatch_Order());
                    PickingOrder po = daoPickingOrder.pickingOrderGet(dispatchOrder.getIdPickingOrder());
                    RequestOrder ro = daoRequestOrder.requestOrderGet(po.getIdRequest_Order());
                    StateRequestOrder state = daoStateOrderRequest.stateRequestOrderGet(3);
                    ro.setStateRequestOrder(state);
                    daoRequestOrder.requestOrderUpd(ro);
                    frm_dodAux.setVisible(true);
                    this.dispose();
                }
                initializeTable();
            }else{
                int ok_option = JOptionPane.showOptionDialog(new JFrame(), "Ingrese una fecha de devolución.", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            }
        }
    }//GEN-LAST:event_btn_returnActionPerformed

    private void fillData(){
        int idPickingOrder, idDispatchOrder;
        Date dispatchDate;
        double functionValue;
        int idExecutionAlgorithm;
        int idVehicle;
        int idPalletProductLocation, idProduct;
        if (dispatchOrder != null) {
                idPickingOrder = dispatchOrder.getIdPickingOrder();
                dispatchDate = dispatchOrder.getDepartureDate();
                client = daoClient.clientGet(dispatchOrder.getIdClient());
                vehicle = dispatchOrder.getIdVehicle();
                fillGeneralData();
                //buscar lista de ExecutionAlgorithm por date para sacar todas las ejecuciones del dia
                pickingOrderDetailList = daoPickingOrderDetail.pickingOrderDetailQry(idPickingOrder);
                initializeTable();
                
                
            } else {
                JOptionPane.showMessageDialog(null, "No existe la orden de despacho buscada",
                        "Advertencias", JOptionPane.WARNING_MESSAGE);
            }
    }
    
    private void getProductList(){
        int idPalletProductLocation, idProduct;
        productList = new LinkedList<>();
        palletProductLocationList = new LinkedList<>();
        for (int j = 0; j < pickingOrderDetailList.size(); j++) {
            Pallet_Product_Location palletProductLocation = new Pallet_Product_Location();
            Product product = new Product();
            idPalletProductLocation = pickingOrderDetailList.get(j).getIdPallet_By_Product_By_Location_Cell_Detail();
            palletProductLocation = daoPalletProductLocation.daoPallet_Product_LocationGet(idPalletProductLocation);
            PalletProduct pp = daoPalletProduct.getPalletProductById(palletProductLocation.getPallet_By_Product_Pallet_idPallet());
            product = daoProduct.ProductsGet(pp.getIdproduct());
            palletProductLocationList.add(palletProductLocation);
            productList.add(product);
        }
    }
    
    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        int idDispatchOrder, idPickingOrder,idPalletProductLocation,idProduct;
        Date dispatchDate;
        
        try {
            idDispatchOrder = Integer.parseInt(txt_DispatchOrder.getText());
            dispatchOrder = daoDispatchOrder.dispatchOrderGet(idDispatchOrder);

            if (dispatchOrder != null) {
                if (dispatchOrder.getStatus()!=3){ // 3  - Orden de Despacho Entregada con Vehiculo asignado
                    idPickingOrder = dispatchOrder.getIdPickingOrder();
                    dispatchDate = dispatchOrder.getDepartureDate();
                    client = daoClient.clientGet(dispatchOrder.getIdClient());
                    vehicle = dispatchOrder.getIdVehicle(); // llena data para todo un vehiculo - PD:getIdVehicle hasta la shit el name
                    fillGeneralData();
                    //busco el detalle de los productos asociado al PickingOrder
                    pickingOrderDetailList = daoPickingOrderDetail.pickingOrderDetailQry(idPickingOrder);
                    palletProductLocationList = new LinkedList<>();
                    productList = new LinkedList<>();
                    for (int j = 0; j < pickingOrderDetailList.size(); j++) {
                        Pallet_Product_Location palletProductLocation = new Pallet_Product_Location();
                        Product product = new Product();
                        idPalletProductLocation = pickingOrderDetailList.get(j).getIdPallet_By_Product_By_Location_Cell_Detail();
                        idProduct = pickingOrderDetailList.get(j).getIdPallet_By_Product_By_Location_Cell_Detail();
                        palletProductLocation = daoPalletProductLocation.daoPallet_Product_LocationGet(idPalletProductLocation);
                        product = daoProduct.ProductsGet(idProduct);
                        palletProductLocationList.add(palletProductLocation);
                        productList.add(product);
                    }
                    initializeTable();
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede retornar. La orden de despacho no ha sido entregada",
                            "Advertencias", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe la orden de despacho buscada",
                        "Advertencias", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Algunos datos deben ser numéricos",
                    "Advertencias", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_searchActionPerformed
    
    public void fillGeneralData(){
        txt_ClientId.setText(client.getRuc().trim());
        txt_ClientName.setText(client.getName().trim());
        txt_ClientAddress.setText(client.getAddress().trim());
        
        if(vehicle!=null){
            txt_vehicle_license_plate.setText(vehicle.getLicense_plate().trim());
            txt_id_dispatcher.setText(vehicle.getDriver().getIdDriver().toString().trim());
            txt_name_dispatcher.setText(vehicle.getDriver().getName().trim());
        }
        jDate_RegisterDate.setDate(dispatchOrder.getDepartureDate());
        jDate_DeliverDate.setDate(dispatchOrder.getArrivalDate());
    }
    
    public void initializeTable(){
        String status= null;
        boolean check;
        modelo = (DefaultTableModel) tbl_products.getModel();
        if(modelo!=null){
            modelo.getDataVector().removeAllElements();
            modelo.fireTableDataChanged();
        }
        
        boolean select = false;
        if(cancelAll==1)select=true;
        else select = false;
        try {
            for (int i = 0; i < pickingOrderDetailList.size(); i++) {                
                if (pickingOrderDetailList.get(i).getDispatchStatus()==1){
                    status = "Entregado";
                }
                else if(pickingOrderDetailList.get(i).getDispatchStatus()==2) {
                    status = "Por Entregar";
                }else if(pickingOrderDetailList.get(i).getDispatchStatus()==3){
                    status = "Devuelto a Almacén";
                }
                
                Pallet_Product_Location ppl = daoPalletProductLocation.daoPallet_Product_LocationGet(pickingOrderDetailList.get(i).getIdPallet_By_Product_By_Location_Cell_Detail());
                PalletProduct pp = daoPalletProduct.getPalletProductById(ppl.getPallet_By_Product_Pallet_idPallet());
                Product product = daoProduct.ProductsGet(pp.getIdproduct());
                
                Object newRow[] = {
                    pickingOrderDetailList.get(i).getIdPicking_Order_Detail(),
                    pp.getCod_ean128(),
                    product.getName(),
                    status,
                    select
                };
                modelo.addRow(newRow);
            }
        } catch (Exception e) {
        }
    }
    
    public void blockObjects(){        
        txt_ClientId.setEnabled(false);
        txt_ClientName.setEnabled(false);
        txt_ClientAddress.setEnabled(false);
       
        txt_vehicle_license_plate.setEnabled(false);
        txt_id_dispatcher.setEnabled(false);
        txt_name_dispatcher.setEnabled(false);
        
        jDate_RegisterDate.setEnabled(false);
        jDate_DeliverDate.setEnabled(false);        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_return;
    private javax.swing.JButton btn_search;
    private com.toedter.calendar.JDateChooser jDate_DeliverDate;
    private com.toedter.calendar.JDateChooser jDate_RegisterDate;
    private com.toedter.calendar.JDateChooser jDate_return_date;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_address;
    private javax.swing.JLabel lbl_client;
    private javax.swing.JLabel lbl_deliver_date;
    private javax.swing.JLabel lbl_dispatcher;
    private javax.swing.JLabel lbl_order_num;
    private javax.swing.JLabel lbl_reg_date;
    private javax.swing.JLabel lbl_return_date;
    private javax.swing.JLabel lbl_vehicle;
    private javax.swing.JPanel pnl_general_info;
    private javax.swing.JPanel pnl_products;
    private javax.swing.JPanel pnl_return;
    private javax.swing.JPanel pnl_search_criteria;
    private javax.swing.JTable tbl_products;
    private javax.swing.JTextField txt_ClientAddress;
    private javax.swing.JTextField txt_ClientId;
    private javax.swing.JTextField txt_ClientName;
    private javax.swing.JTextField txt_DispatchOrder;
    private javax.swing.JTextField txt_OrderNum;
    private javax.swing.JTextField txt_id_dispatcher;
    private javax.swing.JTextField txt_name_dispatcher;
    private javax.swing.JTextField txt_vehicle_license_plate;
    // End of variables declaration//GEN-END:variables
}
