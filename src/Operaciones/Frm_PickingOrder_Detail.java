/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Operaciones;

import Model.DispatchOrder;
import Model.LocationCell;
import Model.LocationCellDetail;
import Model.Log;
import Model.Movement;
import Model.Pallet;
import Model.PalletProduct;
import Model.Pallet_Product_Location;
import Model.PickingOrder;
import Model.PickingOrderDetail;
import Model.Product;
import Model.Rack;
import Model.RequestOrder;
import Model.Warehouse;
import dao.DaoDispatchOrder;
import dao.DaoDistributionCenter;
import dao.DaoKardex;
import dao.DaoLocationCell;
import dao.DaoLocationCellDetail;
import dao.DaoLog;
import dao.DaoPalletProduct;
import dao.DaoPallet_Product_Location;
import dao.DaoPickingOrder;
import dao.DaoPickingOrderDetail;
import dao.DaoProducts;
import dao.DaoRack;
import dao.DaoRequestOrder;
import dao.DaoWH;
import dao.impl.DaoDispatchOrderImpl;
import dao.impl.DaoDistributionCenterImpl;
import dao.impl.DaoKardexImpl;
import dao.impl.DaoLocationCellDetailImpl;
import dao.impl.DaoLocationCellImpl;
import dao.impl.DaoLogImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoPallet_Producto_LocationImpl;
import dao.impl.DaoPickingOrderDetailImpl;
import dao.impl.DaoPickingOrderImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoRackImpl;
import dao.impl.DaoRequestOrderImpl;
import dao.impl.DaoWHImpl;
import java.util.ArrayList;
import java.util.Date;
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
public class Frm_PickingOrder_Detail extends javax.swing.JFrame {
    Frm_PickingOrder_Search frm_posAux= new Frm_PickingOrder_Search();
    PickingOrder pickingOrderAux = new PickingOrder();
    DaoRequestOrder daoRequestOrder = new DaoRequestOrderImpl();
    DaoPickingOrderDetail daoPickingOrderDetail = new DaoPickingOrderDetailImpl();
    DefaultTableModel model = new DefaultTableModel();
    List<Integer> listRequestToDelete =  new ArrayList<>();
    List<Integer> listPickingToConfirm = new ArrayList<>();
    DaoDispatchOrder daoDispatchOrder =  new DaoDispatchOrderImpl();
    DaoPalletProduct daoPalletProduct = new DaoPalletProductImpl();
    DaoPallet_Product_Location daoPalletProductLocation = new DaoPallet_Producto_LocationImpl();
    DaoProducts daoProduct = new DaoProdImpl();
    DaoLocationCell daoLocationCell = new DaoLocationCellImpl();
    DaoLocationCellDetail daoLocationCellDetail = new DaoLocationCellDetailImpl();
    DaoWH daoWH = new DaoWHImpl();
    DaoDistributionCenter daoDistribution = new DaoDistributionCenterImpl();
    DaoRack daoRack = new DaoRackImpl();
    DaoPickingOrder daoPickingOrder = new DaoPickingOrderImpl();
    DaoKardex daoKardex = new DaoKardexImpl();
    DaoLog daoLog = new DaoLogImpl();
    Log logSI = null;
     /* Creates new form Frm_verDetalleOrdenEntrega1
     */
    public Frm_PickingOrder_Detail(Frm_PickingOrder_Search frm_pos) {
        setTitle("ÓRDEN DE ENTREGA");
        frm_posAux = frm_pos;
        initComponents();
    }
    
    public Frm_PickingOrder_Detail(Frm_PickingOrder_Search frm_pos, PickingOrder pickingOrder) {
        setTitle("ÓRDEN DE ENTREGA");
        frm_posAux = frm_pos;
        initComponents();
        pickingOrderAux = pickingOrder;
        TableColumn tc = table_products.getColumnModel().getColumn(8);
        tc.setHeaderRenderer(new SelectAllHeader(table_products, 8));
        model = (DefaultTableModel) table_products.getModel();
        fillData();
        fillTable();
        if(pickingOrderAux.getStatus()==1 || pickingOrderAux.getStatus()==3){
            btn_generate_dispatch.setEnabled(false);
            btn_confirm.setEnabled(false);
            btn_delete.setEnabled(false);
            table_products.setEnabled(false);
        }else{
           verifyProducts();
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

        pnl_general_info = new javax.swing.JPanel();
        lbl_num_order = new javax.swing.JLabel();
        txt_OrderNum = new javax.swing.JTextField();
        lbl_deliver_date = new javax.swing.JLabel();
        lbl_status = new javax.swing.JLabel();
        cbo_status = new javax.swing.JComboBox();
        lbl_reg_date = new javax.swing.JLabel();
        date_register = new com.toedter.calendar.JDateChooser();
        date_deliver = new com.toedter.calendar.JDateChooser();
        lbl_num_orderR = new javax.swing.JLabel();
        txt_OrderNumR = new javax.swing.JTextField();
        pnl_products = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_products = new javax.swing.JTable();
        btn_cancel = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_confirm = new javax.swing.JButton();
        btn_generate_dispatch = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_general_info.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        lbl_num_order.setText("Número de Orden Entrega: ");
        lbl_num_order.setToolTipText("");

        txt_OrderNum.setEditable(false);

        lbl_deliver_date.setText("Fecha Entrega Estimada:");

        lbl_status.setText("Estado:");

        cbo_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Terminado", "Pendiente", "Cancelado" }));
        cbo_status.setEnabled(false);

        lbl_reg_date.setText("Fecha Registro:");

        date_register.setEnabled(false);

        date_deliver.setEnabled(false);

        lbl_num_orderR.setText("Número de Orden Pedido: ");
        lbl_num_orderR.setToolTipText("");

        txt_OrderNumR.setEditable(false);

        javax.swing.GroupLayout pnl_general_infoLayout = new javax.swing.GroupLayout(pnl_general_info);
        pnl_general_info.setLayout(pnl_general_infoLayout);
        pnl_general_infoLayout.setHorizontalGroup(
            pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_reg_date)
                    .addComponent(lbl_num_order)
                    .addComponent(lbl_num_orderR))
                .addGap(25, 25, 25)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_general_infoLayout.createSequentialGroup()
                        .addComponent(txt_OrderNum, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addComponent(lbl_status))
                    .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_general_infoLayout.createSequentialGroup()
                            .addComponent(date_register, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addComponent(lbl_deliver_date, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txt_OrderNumR, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbo_status, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_deliver, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_general_infoLayout.setVerticalGroup(
            pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_OrderNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_num_order))
                    .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_status)
                        .addComponent(cbo_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_general_infoLayout.createSequentialGroup()
                        .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_num_orderR)
                            .addComponent(txt_OrderNumR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lbl_reg_date))
                    .addComponent(date_register, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_deliver_date, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_deliver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pnl_products.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        table_products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de Detalle", "EAN 128", "Descripción", "Almacén", "Rack", "Celda", "Posición", "Estado", "Seleccionar"
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
        jScrollPane3.setViewportView(table_products);

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

        btn_confirm.setText("Confirmar Picking");
        btn_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmActionPerformed(evt);
            }
        });

        btn_generate_dispatch.setText("Generar Orden de Despacho");
        btn_generate_dispatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generate_dispatchActionPerformed(evt);
            }
        });

        jButton1.setText("Ver Leyenda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_productsLayout = new javax.swing.GroupLayout(pnl_products);
        pnl_products.setLayout(pnl_productsLayout);
        pnl_productsLayout.setHorizontalGroup(
            pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_productsLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_delete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_generate_dispatch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancel)
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
        );
        pnl_productsLayout.setVerticalGroup(
            pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_productsLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel)
                    .addComponent(btn_delete)
                    .addComponent(btn_confirm)
                    .addComponent(btn_generate_dispatch)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_products, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_general_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_general_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_products, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        frm_posAux.setVisible(true);
        frm_posAux.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        frm_posAux.setVisible(true);
        frm_posAux.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
       Object[] options = {"OK"};
        
        if(ifNoColummnSelected()==false){
            listRequestToDelete = new ArrayList<>();
            for (int i = 0; i < table_products.getRowCount(); i++) {
                if ((Boolean) table_products.getValueAt(i, 8)) {
                    listRequestToDelete.add(Integer.parseInt(table_products.getValueAt(i, 0).toString()));

                }
            }
            
            if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
                "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
                int ok_option;
                    int size = listRequestToDelete.size();
                    for(int z=0;z<size;z++){
                        PickingOrderDetail detail = daoPickingOrderDetail.pickingOrderDetailGet(listRequestToDelete.get(z));
                        if(detail.getStatus()==2){//lo dejamos de nuevo en su sitio
                            ok_option = JOptionPane.showOptionDialog(new JFrame(),"El Pallet de la línea N° " +z+" está en estado Por Picar.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                        }else if(detail.getStatus()==1){
                            daoPickingOrderDetail.pickingOrderDetailDel(listRequestToDelete.get(z),detail.getPicking_Order_idPicking_Order(),2);
                            Pallet_Product_Location ppl = daoPalletProductLocation.daoPallet_Product_LocationGet(detail.getIdPallet_By_Product_By_Location_Cell_Detail());
                            //lo sacamos del location cell
                            daoPalletProductLocation.daoPallet_Product_LocationDel(detail.getIdPallet_By_Product_By_Location_Cell_Detail(),ppl.getPallet_By_Product_Pallet_idPallet());
                        }else{
                            Pallet_Product_Location ppl = daoPalletProductLocation.daoPallet_Product_LocationGet(detail.getIdPallet_By_Product_By_Location_Cell_Detail());
                            ok_option = JOptionPane.showOptionDialog(new JFrame(),"El Pallet de la línea N° " +z+" ya se encuentra picado.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                        }   
                    }
                    ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se ha cambiado el estado de/del el/los producto(s) con éxito","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                
                refreshGrid();
                fillTable();
                verifyProducts();
                
            }
        }else{
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Seleccione al menos un registro.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

   
    
    private boolean ifNoColummnSelected(){
        int sizeRows =  table_products.getRowCount();
        for(int i=0;i<sizeRows;i++){
            boolean statusSelected = (Boolean)table_products.getValueAt(i, 8);
            if(statusSelected == true)
                return false;
        }
        return true;
    }
    
    private void refreshGrid(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
    }
    
    private boolean allUnable(){
        int size = table_products.getRowCount();
        for (int i=0;i<size;i++){
            String status = table_products.getValueAt(i, 7).toString();
            if(status.equals("Por Picar")==true || status.equals("Cancelado")==true )
                return false;
        }
        return true;
    }
    
    private void btn_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmActionPerformed
        // TODO add your handling code here:
       Object[] options = {"OK"};
       int ok_option;
        if(ifNoColummnSelected()==false){
            listPickingToConfirm = new ArrayList<>();
            for (int i = 0; i < table_products.getRowCount(); i++) {
                if ((Boolean) table_products.getValueAt(i, 8)) {
                    listPickingToConfirm.add(Integer.parseInt(table_products.getValueAt(i, 0).toString()));

                }
            }
            
            if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
                "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
                int size = listPickingToConfirm.size();
                for(int z=0;z<size;z++){
                    PickingOrderDetail detail = daoPickingOrderDetail.pickingOrderDetailGet(listPickingToConfirm.get(z));
                    daoPickingOrderDetail.pickingOrderDetailDel(listPickingToConfirm.get(z),detail.getPicking_Order_idPicking_Order(),1);
                    Pallet_Product_Location ppl = daoPalletProductLocation.daoPallet_Product_LocationGet(detail.getIdPallet_By_Product_By_Location_Cell_Detail());
                    daoPalletProductLocation.daoPallet_Product_LocationDel(detail.getIdPallet_By_Product_By_Location_Cell_Detail(),ppl.getPallet_By_Product_Pallet_idPallet());
                    PalletProduct pallet = daoPalletProduct.getPalletProductById(ppl.getPallet_By_Product_Pallet_idPallet());
                    logDetail(pallet.getCod_ean128());
                }
                ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se ha cambiado el estado de/del el/los producto(s) con éxito","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                refreshGrid();
                fillTable();
                verifyProducts();
            }
        }else{
            ok_option = JOptionPane.showOptionDialog(new JFrame(),"Seleccione al menos un registro.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }
    }//GEN-LAST:event_btn_confirmActionPerformed

    private void logDetail(String ean){
        int size = listPickingToConfirm.size();
        for(int i=0;i<size;i++){
            daoLog.clientIns("Se ha confirmado el picado del pallet número "+ ean, Frm_PickingOrder_Detail.class.toString(), logSI.getIduser());
        }
    }
    
    
    private void btn_generate_dispatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generate_dispatchActionPerformed
        // TODO add your handling code here:
        //*********************************
        //VERIFICAR ACCESIBILIDAD Y MENSAJERIA
        //**********************************
        Object[] options = {"OK"};
        if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
            "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            DispatchOrder dispatchOrder = new DispatchOrder();
            Date date = new Date();
            dispatchOrder.setDepartureDate(date);
            dispatchOrder.setArrivalDate(date);
            dispatchOrder.setStatus(2);
            RequestOrder ro = daoRequestOrder.requestOrderGet(pickingOrderAux.getIdRequest_Order());
            dispatchOrder.setIdClient(ro.getClient().getIdClient());
            dispatchOrder.setIdPickingOrder(pickingOrderAux.getIdPickingOrder());
            daoDispatchOrder.dispatchOrderIns(dispatchOrder);
            daoPickingOrder.pickingOrderDel(pickingOrderAux.getIdPickingOrder(), 1);
            //Se registra el movimiento para el kardex:
            List<PickingOrderDetail> list = daoPickingOrderDetail.pickingOrderDetailQry(pickingOrderAux.getIdPickingOrder());
            int size = list.size();
            for(int i=0;i<size;i++){
                if(list.get(i).getStatus()==1){
                    //seteo el status del despacho referido a su status en despacho
                    //dispatch_status = 0 --> Entregado
                    //dispatch_status = 1 --> Por entregar
                    //dispatch_status = 2 --> Devuelto a Almacén
                    daoPickingOrderDetail.pickingOrderDetailAssignToDispatch(list.get(i).getIdPicking_Order_Detail(),pickingOrderAux.getIdPickingOrder());
                    Movement mov = new Movement();
                    mov.setDate(date);
                    Pallet_Product_Location ppl = daoPalletProductLocation.daoPallet_Product_LocationGet(list.get(i).getIdPallet_By_Product_By_Location_Cell_Detail());
                    mov.setIdProduct(ppl.getPallet_By_Product_Product_idProduct());
                    mov.setIdWh(ppl.getLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse());
                    Product product = daoProduct.ProductsGet(ppl.getPallet_By_Product_Product_idProduct());
                    mov.setStock_inicial(product.getPhysicalStock());
                    daoProduct.ProductUpdStock(product.getIdProduct(), 1, 2);
                    mov.setStock_final(product.getPhysicalStock() - product.getQuantityBoxesPerPallet());
                    mov.setType_Movement_id(2);
                    mov.setType_Movement_idSubtype(1);
                    daoKardex.MovementIns(mov);
                    //ademas se actualiza el location cell detail para saber que hay disponibles sitios para ubicar nuevos pallets
                    LocationCellDetail lcD = daoLocationCellDetail.locationCellDetailQry(ppl.getLocation_Cell_Detail_idLocation_Cell_Detail(),ppl.getLocation_Cell_Detail_Location_Cell_idLocation_Cell());
                    lcD.setAvailability(1);//le pongo como habilitado
                    daoLocationCell.LocationCellAvailabilityUpd(ppl.getLocation_Cell_Detail_idDistribution_Center(), ppl.getLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse(), ppl.getLocation_Cell_Detail_Location_Cell_Rack_idRack(),ppl.getLocation_Cell_Detail_Location_Cell_idLocation_Cell(),ppl.getLocation_Cell_Detail_idLocation_Cell_Detail(), 1);
                
                }
            }
            daoLog.clientIns("Se ha registrado un nuevo despacho proveniente del picking N° :"+pickingOrderAux.getIdPickingOrder(), Frm_PickingOrder_Detail.class.toString(), logSI.getIduser());
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se ha generado la orden de despacho con éxito.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            frm_posAux.setVisible(true);
            frm_posAux.refreshGrid();
            this.dispose();
        }
        
        
    }//GEN-LAST:event_btn_generate_dispatchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Frm_Pallet_Legend frm_pl = new Frm_Pallet_Legend();
        frm_pl.setVisible(true);
        frm_pl.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void verifyProducts(){
        boolean emptyRequest = allUnable();
        if(emptyRequest == false){
            btn_generate_dispatch.setEnabled(false);
        }else{
            btn_generate_dispatch.setEnabled(true);
        }
    }
    
    private boolean allCanceled(){
        int size = table_products.getRowCount();
        for(int i=0;i<size;i++){
            if(table_products.getValueAt(i,7).equals("Cancelado")==false)
                return false;
        }
        return true;
    }
    
    private void fillData(){
        txt_OrderNum.setText(pickingOrderAux.getIdPickingOrder().toString());
        txt_OrderNumR.setText(pickingOrderAux.getIdRequest_Order().toString());
        date_register.setDate(pickingOrderAux.getDate());
        Integer numOrder = pickingOrderAux.getIdRequest_Order();
        RequestOrder rO = daoRequestOrder.requestOrderGet(numOrder);
        date_deliver.setDate(rO.getDateline());
        cbo_status.setSelectedIndex(pickingOrderAux.getStatus());
        
        
    }
    
   private void fillTable(){
       List<PickingOrderDetail> lpO = daoPickingOrderDetail.pickingOrderDetailQry(pickingOrderAux.getIdPickingOrder());
       
       int size = lpO.size();
       for(int i = 0;i<size;i++){
            PickingOrderDetail poD = lpO.get(i);
            //EAN 128 - DESCRIPCION (PRODUCTO) - UBICACION - ESTADO - SELECCIONAR
            Pallet_Product_Location ppl = daoPalletProductLocation.daoPallet_Product_LocationGet(lpO.get(i).getIdPallet_By_Product_By_Location_Cell_Detail());
            List<PalletProduct> pp = daoPalletProduct.GetPalletProductList("WHERE Pallet_idPallet="+ppl.getPallet_By_Product_Pallet_idPallet());
            int sizepp = pp.size();
            String ean128 = null;
            String desc = null;
            for(int j=0;j<sizepp;j++){
                ean128 = pp.get(j).getCod_ean128();
                Product prod = daoProduct.ProductsGet(pp.get(j).getIdproduct());
                desc = prod.getName();
            }
            Integer idLocationCellDetail = ppl.getLocation_Cell_Detail_idLocation_Cell_Detail();
            Integer idLocationCell = ppl.getLocation_Cell_Detail_Location_Cell_idLocation_Cell();
            Integer idDist = ppl.getLocation_Cell_Detail_idDistribution_Center();
            Integer idWh = ppl.getLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse();
            Integer idRack = ppl.getLocation_Cell_Detail_Location_Cell_Rack_idRack();
            Rack rack = daoRack.rackGet(idRack);
            Warehouse wh = daoWH.whGet(idWh);
            LocationCell location = daoLocationCell.LocationCellGet(idDist, idWh, idRack, idLocationCell);
            LocationCellDetail cellDetail = daoLocationCellDetail.locationCellDetailQry(idLocationCellDetail,idLocationCell);
            String nameState = null;
            if(poD.getStatus()==1)
                nameState = "Picado";
            else if(poD.getStatus()==2)
                nameState = "Por Picar";
            else 
                nameState = "Cancelado";
            Object[] fila = {poD.getIdPicking_Order_Detail(),ean128,desc,wh.getDescription(),rack.getDescription(),location.getDescription(),
                            cellDetail.getDescription(),nameState,false};

             model.addRow(fila);
       }
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_confirm;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_generate_dispatch;
    private javax.swing.JComboBox cbo_status;
    private com.toedter.calendar.JDateChooser date_deliver;
    private com.toedter.calendar.JDateChooser date_register;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_deliver_date;
    private javax.swing.JLabel lbl_num_order;
    private javax.swing.JLabel lbl_num_orderR;
    private javax.swing.JLabel lbl_reg_date;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JPanel pnl_general_info;
    private javax.swing.JPanel pnl_products;
    private javax.swing.JTable table_products;
    private javax.swing.JTextField txt_OrderNum;
    private javax.swing.JTextField txt_OrderNumR;
    // End of variables declaration//GEN-END:variables
}
