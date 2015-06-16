/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Operaciones;

import Model.DispatchOrder;
import Model.LocationCellDetail;
import Model.Log;
import Model.Movement;
import Model.PalletProduct;
import Model.Pallet_Product_Location;
import Model.PickingOrder;
import Model.PickingOrderDetail;
import Model.Product;
import Model.RequestOrder;
import Model.RequestOrderDetail;
import Model.StateRequestOrder;
import Seguridad.Frm_MenuPrincipal;
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
import dao.DaoRequestOrderDetail;
import dao.DaoStateRequestOrder;
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
import dao.impl.DaoRequestOrderDetailImpl;
import dao.impl.DaoRequestOrderImpl;
import dao.impl.DaoStateRequestOrderImpl;
import dao.impl.DaoWHImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import tool.SelectAllHeader;
import tool.Validate;
import static tool.Validate.validarEntero;

/**
 *
 * @author Luis Miguel
 */
public class Frm_PickingOrder_Search extends javax.swing.JFrame {
    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();
    DaoPickingOrder daoPickingOrder = new DaoPickingOrderImpl();
    List<PickingOrder> pickingOrderList = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel();
    DaoRequestOrder daoRequestOrder = new DaoRequestOrderImpl();
    List<Integer> pickingToDelete = new ArrayList<>();
    DaoPickingOrderDetail daoPickingOrderDetail = new DaoPickingOrderDetailImpl();
    DaoPallet_Product_Location daoPalletProductLocation = new DaoPallet_Producto_LocationImpl();
    DaoStateRequestOrder daoStateRequestOrder = new DaoStateRequestOrderImpl();
    DaoRequestOrderDetail daoRequestOrderDetail = new DaoRequestOrderDetailImpl();
    DaoPalletProduct daoPalletProduct = new DaoPalletProductImpl();
    DaoLog daoLog = new DaoLogImpl();
    Log logSI = null;
    List<PickingOrder> pickingOrderListToDispatch = new ArrayList<>();
    DaoDispatchOrder daoDispatchOrder =  new DaoDispatchOrderImpl();
    DaoProducts daoProduct = new DaoProdImpl();
    DaoLocationCell daoLocationCell = new DaoLocationCellImpl();
    DaoLocationCellDetail daoLocationCellDetail = new DaoLocationCellDetailImpl();
    DaoWH daoWH = new DaoWHImpl();
    DaoDistributionCenter daoDistribution = new DaoDistributionCenterImpl();
    DaoRack daoRack = new DaoRackImpl();
    DaoKardex daoKardex = new DaoKardexImpl();
    private BarraProgreso tarea;
    /**
     * Creates new form Frm_VerOrdenesEntrega1
     */
    public Frm_PickingOrder_Search(Frm_MenuPrincipal menu) {
        setTitle("ÓRDENES DE ENTREGA");
        menuaux = menu;
        initComponents();
        model = (DefaultTableModel) table_orders.getModel();
        TableColumn tc = table_orders.getColumnModel().getColumn(3);
        tc.setHeaderRenderer(new SelectAllHeader(table_orders, 3));
        initializeJPanelOrder();
    }
    
    public Frm_PickingOrder_Search(){
        
    }
    
    public void refreshGrid(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
    }

    public void initializeJPanelOrder(){
            date_from.setEnabled(false);
            date_to.setEnabled(false);
            btn_searchDate.setEnabled(false);
            cbox_selectOrder.setSelected(true);
            cbox_selectDates.setSelected(false);
    }
    
    
    class BarraProgreso extends SwingWorker<Void, Void> {

        @Override
        public void done() {
            progressBar.setIndeterminate(false);
           
        }

        @Override
        public Void doInBackground() throws Exception {
            
           Object[] options = {"OK"};
            int ok_option;
            progressBar.setIndeterminate(true);
            if(ifNoColummnSelected()==false){
                pickingOrderListToDispatch = new ArrayList<>();
                for (int i = 0; i < table_orders.getRowCount(); i++) {
                    if ((Boolean) table_orders.getValueAt(i, 3)) {
                        if(pickingOrderList.get(i).getStatus()==2)
                            pickingOrderListToDispatch.add(pickingOrderList.get(i));
                        else
                            ok_option = JOptionPane.showOptionDialog(new JFrame(),"Orden N° "+(int)table_orders.getValueAt(i, 0)+" ya fue atendida. No se puede cancelar.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

                    }
                }
                if(pickingOrderListToDispatch.size()!=0){
                    if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
                        "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 

                        massive_picking_creation(pickingOrderListToDispatch);

                        ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se crearon las órdenes de despacho con éxito","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                        refreshGrid();
                    }
                }else{
                    ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se realizaron los registros.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                }
            }else{
                ok_option = JOptionPane.showOptionDialog(new JFrame(),"Seleccione al menos un registro.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            }
            return null;
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

        pnl_orders = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_orders = new javax.swing.JTable();
        btn_delete = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        btn_massive = new javax.swing.JButton();
        pnl_order = new javax.swing.JPanel();
        cbox_selectOrder = new javax.swing.JCheckBox();
        lbl_order = new javax.swing.JLabel();
        txt_num_order = new javax.swing.JTextField();
        btn_searchOrder = new javax.swing.JButton();
        pnl_date = new javax.swing.JPanel();
        cbox_selectDates = new javax.swing.JCheckBox();
        lbl_dateFrom = new javax.swing.JLabel();
        date_from = new com.toedter.calendar.JDateChooser();
        lbl_dateTo = new javax.swing.JLabel();
        date_to = new com.toedter.calendar.JDateChooser();
        btn_searchDate = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_orders.setBorder(javax.swing.BorderFactory.createTitledBorder("Órdenes de Entrega"));

        table_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de Orden", "Cliente", "Estado", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ordersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_orders);

        btn_delete.setText("Eliminar Orden");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_massive.setText("Creación Masiva de Órdenes de Despacho");
        btn_massive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_massiveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_ordersLayout = new javax.swing.GroupLayout(pnl_orders);
        pnl_orders.setLayout(pnl_ordersLayout);
        pnl_ordersLayout.setHorizontalGroup(
            pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ordersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
                    .addGroup(pnl_ordersLayout.createSequentialGroup()
                        .addComponent(btn_massive, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancel)
                        .addGap(4, 4, 4))))
        );
        pnl_ordersLayout.setVerticalGroup(
            pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ordersLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(btn_cancel)
                    .addComponent(btn_massive)))
        );

        pnl_order.setBorder(javax.swing.BorderFactory.createTitledBorder("Orden de Pedido"));

        cbox_selectOrder.setText("Seleccionar");
        cbox_selectOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_selectOrderActionPerformed(evt);
            }
        });

        lbl_order.setText("Número de Orden de Pedido:");

        btn_searchOrder.setText("Buscar");
        btn_searchOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_orderLayout = new javax.swing.GroupLayout(pnl_order);
        pnl_order.setLayout(pnl_orderLayout);
        pnl_orderLayout.setHorizontalGroup(
            pnl_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_orderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_orderLayout.createSequentialGroup()
                        .addComponent(lbl_order)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_num_order, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE))
                    .addGroup(pnl_orderLayout.createSequentialGroup()
                        .addComponent(cbox_selectOrder)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_orderLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_searchOrder)))
                .addContainerGap())
        );
        pnl_orderLayout.setVerticalGroup(
            pnl_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_orderLayout.createSequentialGroup()
                .addComponent(cbox_selectOrder)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_order)
                    .addComponent(txt_num_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_searchOrder)
                .addContainerGap())
        );

        pnl_date.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha:"));

        cbox_selectDates.setText("Seleccionar");
        cbox_selectDates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_selectDatesActionPerformed(evt);
            }
        });

        lbl_dateFrom.setText("Fecha Desde:");

        lbl_dateTo.setText("Fecha Hasta:");

        btn_searchDate.setText("Buscar");
        btn_searchDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchDateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_dateLayout = new javax.swing.GroupLayout(pnl_date);
        pnl_date.setLayout(pnl_dateLayout);
        pnl_dateLayout.setHorizontalGroup(
            pnl_dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_searchDate)
                    .addGroup(pnl_dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_dateLayout.createSequentialGroup()
                            .addComponent(lbl_dateFrom)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(date_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lbl_dateTo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(date_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cbox_selectDates)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        pnl_dateLayout.setVerticalGroup(
            pnl_dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dateLayout.createSequentialGroup()
                .addGroup(pnl_dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(date_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_dateLayout.createSequentialGroup()
                        .addComponent(cbox_selectDates)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_dateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_dateFrom)
                            .addComponent(date_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_dateTo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btn_searchDate)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_orders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(pnl_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(269, 269, 269)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_orders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        menuaux.setEnabled(true);
        this.dispose();
        
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        menuaux.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void table_ordersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ordersMouseClicked
        // TODO add your handling code here:
        if(evt.getSource()==table_orders){
            int rowSel = table_orders.getSelectedRow();
            int colSel = table_orders.getSelectedColumn();
            if (colSel==0){
              Frm_PickingOrder_Detail frm_dod = new Frm_PickingOrder_Detail(this,pickingOrderList.get(rowSel));
              frm_dod.setVisible(true);
              frm_dod.setLocationRelativeTo(null);
              this.setVisible(false);  
            }
        }
    }//GEN-LAST:event_table_ordersMouseClicked

    private boolean ifNoColummnSelected(){
        int sizeRows =  table_orders.getRowCount();
        for(int i=0;i<sizeRows;i++){
            boolean statusSelected = (Boolean)table_orders.getValueAt(i, 3);
            if(statusSelected == true)
                return false;
        }
        return true;
    }
    
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        Object[] options = {"OK"};
        int ok_option;
        if(ifNoColummnSelected()==false){
            pickingToDelete = new ArrayList<>();
            for (int i = 0; i < table_orders.getRowCount(); i++) {
                if ((Boolean) table_orders.getValueAt(i, 3)) {
                    if(table_orders.getValueAt(i, 2).equals("Realizado")==false)
                        pickingToDelete.add(Integer.parseInt(table_orders.getValueAt(i, 0).toString()));
                    else
                        ok_option = JOptionPane.showOptionDialog(new JFrame(),"Orden N° "+(int)table_orders.getValueAt(i, 0)+" ya fue atendida. No se puede cancelar.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

                }
            }
            if(pickingToDelete.size()!=0){
                if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
                    "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
                    ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se ha cambiado el estado de/del el/los producto(s) con éxito","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(ok_option==JOptionPane.OK_OPTION){
                        int size = pickingToDelete.size();
                        for(int z=0;z<size;z++){
                            PickingOrder po = daoPickingOrder.pickingOrderGet(pickingToDelete.get(z));
                            List<PickingOrderDetail> poL = daoPickingOrderDetail.pickingOrderDetailQry(po.getIdPickingOrder());
                            List<RequestOrderDetail> roL = daoRequestOrder.requestOrderGet(po.getIdRequest_Order()).getRequestOrderDetailList();
                            int sizeRol = roL.size();
                            
                            if(po.getStatus()==2){ // pendiente lo llevamos al almacen
                                daoPickingOrder.pickingOrderDel(pickingToDelete.get(z),3);
                                daoLog.clientIns("Se ha cancelado la orden de picking N° :  " + po.getIdPickingOrder(), Frm_PickingOrder_Search.class.toString(), logSI.getIduser());
                                if(poL!=null){
                                    int sizeL = poL.size();
                                    for(int j=0;j<sizeL;j++){
                                        daoPickingOrderDetail.pickingOrderDetailDel(poL.get(j).getIdPicking_Order_Detail(),po.getIdPickingOrder() ,3);
                                        Pallet_Product_Location ppl = daoPalletProductLocation.daoPallet_Product_LocationGet(poL.get(j).getIdPallet_By_Product_By_Location_Cell_Detail());
                                        daoPalletProductLocation.daoPallet_Product_LocationActivate(poL.get(j).getIdPallet_By_Product_By_Location_Cell_Detail(),ppl.getPallet_By_Product_Pallet_idPallet());
                                        PalletProduct pp = daoPalletProduct.getPalletProductById(ppl.getPallet_By_Product_Pallet_idPallet());
                                        for(int p=0;p<sizeRol;p++){
                                            if(pp.getIdproduct()==roL.get(p).getProduct().getIdProduct()){
                                                System.out.println("ENTRO");
                                                int remaining = roL.get(p).getRemaining()+1;
                                                roL.get(p).setRemaining(remaining);
                                                roL.get(p).setDelivered(roL.get(p).getDelivered()-1);
                                            }
                                        }
                                    }
                                }
                                updateRequestOrder(pickingToDelete.get(z));
                                for(int m=0;m<sizeRol;m++){
                                    daoRequestOrderDetail.requestOrderDetailUpd(roL.get(m));
                                }

                            }else{
                                ok_option = JOptionPane.showOptionDialog(new JFrame(),"La orden N° "+po.getIdPickingOrder()+" ya fue terminada.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                            }
                        }

                    }
                    refreshGrid();
                }
            }else{
                ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se realizaron los cambios.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            }
        }else{
            ok_option = JOptionPane.showOptionDialog(new JFrame(),"Seleccione al menos un registro.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void updateRequestOrder(int idPickingOrder){
        PickingOrder po = daoPickingOrder.pickingOrderGet(idPickingOrder);
        RequestOrder ro = daoRequestOrder.requestOrderGet(po.getIdRequest_Order());
        StateRequestOrder state = daoStateRequestOrder.stateRequestOrderGet(2);
        ro.setStateRequestOrder(state);
        daoRequestOrder.requestOrderUpd(ro);
        List<RequestOrderDetail> list = ro.getRequestOrderDetailList();
        int size = list.size();
        for(int i=0;i<size;i++){
            int remaining = list.get(i).getRemaining();
            int delivered = countPalletsDelivered(po,list.get(i).getProduct().getIdProduct());
            list.get(i).setRemaining(remaining+delivered);
            list.get(i).setDelivered(0);
            daoRequestOrderDetail.requestOrderDetailUpd(list.get(i));
        }
    }
    
    private int countPalletsDelivered(PickingOrder po, int idProduct){
        List<PickingOrderDetail> list = daoPickingOrderDetail.pickingOrderDetailQry(po.getIdPickingOrder());
        int count = 0;
        int size = list.size();
        for(int i=0;i<size;i++){
            Pallet_Product_Location ppl = daoPalletProductLocation.daoPallet_Product_LocationGet(list.get(i).getIdPallet_By_Product_By_Location_Cell_Detail());
            PalletProduct pp = daoPalletProduct.getPalletProductById(ppl.getPallet_By_Product_Pallet_idPallet());
            if(idProduct == pp.getIdproduct())
                count++;
        }
        return count;
    }
    
    private void cbox_selectDatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_selectDatesActionPerformed
        // TODO add your handling code here:
        if(cbox_selectDates.isSelected()==true){
            date_from.setEnabled(true);
            date_to.setEnabled(true);
            btn_searchDate.setEnabled(true);
            txt_num_order.setEnabled(false);
            btn_searchOrder.setEnabled(false);
            cbox_selectOrder.setSelected(false);
            
        }
    }//GEN-LAST:event_cbox_selectDatesActionPerformed

    private void cbox_selectOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_selectOrderActionPerformed
        // TODO add your handling code here:
        if(cbox_selectOrder.isSelected()==true){
            date_from.setEnabled(false);
            date_to.setEnabled(false);
            btn_searchDate.setEnabled(false);
            txt_num_order.setEnabled(true);
            btn_searchOrder.setEnabled(true);
            cbox_selectDates.setSelected(false);
        }
    }//GEN-LAST:event_cbox_selectOrderActionPerformed

    private void fillTable(){
        int size = pickingOrderList.size();
        for(int i=0;i<size;i++){
            PickingOrder pO = pickingOrderList.get(i);
            int idRequest = pO.getIdRequest_Order();
            RequestOrder rO = daoRequestOrder.requestOrderGet(idRequest);
            String nameState = null;
            if(pO.getStatus()==1)
                nameState = "Realizado";
            else if(pO.getStatus()==2)
                nameState = "Pendiente";
            else
                nameState = "Cancelado";

            Object[] fila = {pO.getIdPickingOrder(),rO.getClient().getName(),nameState,false};
            model.addRow(fila);
        }
    }
    
    private void btn_searchOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchOrderActionPerformed
        // TODO add your handling code here:
        refreshGrid();
        Object[] options = {"OK"};
        String orderN =  txt_num_order.getText();
        if(orderN == null || orderN.equals("")==true || !Validate.validarEntero(txt_num_order.getText())){      
                int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Ingrese un número de orden de pedido.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                 
        }else{
                if(validarEntero(orderN)){
                    Integer orderNumb = Integer.parseInt(orderN);
                    pickingOrderList = daoPickingOrder.pickingOrderQry_search(orderNumb);
                    if(pickingOrderList == null ){
                        int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se encontraron registros.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    }else{
                        if(pickingOrderList.size()==0){
                                int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se encontraron registros.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

                        }else{
                            int size = pickingOrderList.size();
                            for(int i=0;i<size;i++){
                                PickingOrder pO = pickingOrderList.get(i);
                                int idRequest = pO.getIdRequest_Order();
                                RequestOrder rO = daoRequestOrder.requestOrderGet(idRequest);
                                String nameState = null;
                                if(pO.getStatus()==1)
                                    nameState = "Realizado";
                                else if(pO.getStatus()==2)
                                    nameState = "Pendiente";
                                else
                                    nameState = "Cancelado";

                                Object[] fila = {pO.getIdPickingOrder(),rO.getClient().getName(),nameState,false};
                                model.addRow(fila);
                            }
                        }
                    }
                }else{
                    int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Formato de número de orden no válido.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                }
        }
       
    }//GEN-LAST:event_btn_searchOrderActionPerformed

    private void btn_searchDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchDateActionPerformed
        // TODO add your handling code here:
        refreshGrid();
        Object[] options = {"OK"};
        Date dateFrom = date_from.getDate();
        Date dateTo = date_to.getDate();
       
       
            pickingOrderList = daoPickingOrder.pickingOrderQry_search(dateFrom,dateTo);
            if(pickingOrderList == null ){
                int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se encontraron registros.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            }else{
                if(pickingOrderList.size()==0){
                  int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se encontraron registros.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]); 
                }else{
                    int size = pickingOrderList.size();
                    for(int i=0;i<size;i++){
                        PickingOrder pO = pickingOrderList.get(i);
                        int idRequest = pO.getIdRequest_Order();
                        RequestOrder rO = daoRequestOrder.requestOrderGet(idRequest);
                        String nameState = null;
                        if(pO.getStatus()==1)
                            nameState = "Realizado";
                        else if(pO.getStatus()==2)
                            nameState = "Pendiente";
                        else
                            nameState = "Cancelado";

                        Object[] fila = {pO.getIdPickingOrder(),rO.getClient().getName(),nameState,false};
                        model.addRow(fila);
                    }
                }
            }
        
        
    }//GEN-LAST:event_btn_searchDateActionPerformed

    private void btn_massiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_massiveActionPerformed
        // TODO add your handling code here:
        /*Object[] options = {"OK"};
        int ok_option;
        if(ifNoColummnSelected()==false){
            pickingOrderListToDispatch = new ArrayList<>();
            for (int i = 0; i < table_orders.getRowCount(); i++) {
                if ((Boolean) table_orders.getValueAt(i, 3)) {
                    if(pickingOrderList.get(i).getStatus()==2)
                        pickingOrderListToDispatch.add(pickingOrderList.get(i));
                    else
                        ok_option = JOptionPane.showOptionDialog(new JFrame(),"Orden N° "+(int)table_orders.getValueAt(i, 0)+" ya fue atendida. No se puede cancelar.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

                }
            }
            if(pickingOrderListToDispatch.size()!=0){
                if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
                    "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
                    
                    massive_picking_creation(pickingOrderListToDispatch);
                    
                    ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se crearon las órdenes de despacho con éxito","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    refreshGrid();
                }
            }else{
                ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se realizaron los registros.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            }
        }else{
            ok_option = JOptionPane.showOptionDialog(new JFrame(),"Seleccione al menos un registro.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }*/
        tarea = new BarraProgreso();
        tarea.execute();
        
    }//GEN-LAST:event_btn_massiveActionPerformed


    private void massive_picking_creation(List<PickingOrder> listP){
        int sizeP = listP.size();
        for(int m=0;m<sizeP;m++){
            PickingOrder pickingOrderAux = listP.get(m);
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
                    //seteo el status del despacho referido a su status en despacho
                    //dispatch_status = 0 --> Entregado
                    //dispatch_status = 1 --> Por entregar
                    //dispatch_status = 2 --> Devuelto a Almacén
                    list.get(i).setStatus(1);
                    daoPickingOrderDetail.pickingOrderDetailUpd(list.get(i));
                    daoPickingOrderDetail.pickingOrderDetailAssignToDispatch(list.get(i).getIdPicking_Order_Detail(),pickingOrderAux.getIdPickingOrder());
                    Movement mov = new Movement();
                    mov.setDate(date);
                    Pallet_Product_Location ppl = daoPalletProductLocation.daoPallet_Product_LocationGet(list.get(i).getIdPallet_By_Product_By_Location_Cell_Detail());
                    mov.setIdProduct(ppl.getPallet_By_Product_Product_idProduct());
                    mov.setIdWh(ppl.getLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse());
                    Product product = daoProduct.ProductsGet(ppl.getPallet_By_Product_Product_idProduct());
                    mov.setStock_inicial(product.getPhysicalStock());
                    mov.setStock_final(product.getPhysicalStock() - product.getQuantityBoxesPerPallet());
                    mov.setType_Movement_id(2);
                    mov.setType_Movement_idSubtype(1);
                    daoKardex.MovementIns(mov);
                    //ademas se actualiza el location cell detail para saber que hay disponibles sitios para ubicar nuevos pallets
                    LocationCellDetail lcD = daoLocationCellDetail.locationCellDetailQry(ppl.getLocation_Cell_Detail_idLocation_Cell_Detail(),ppl.getLocation_Cell_Detail_Location_Cell_idLocation_Cell());
                    lcD.setAvailability(1);//le pongo como habilitado
                    daoLocationCell.LocationCellAvailabilityUpd(ppl.getLocation_Cell_Detail_idDistribution_Center(), ppl.getLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse(), ppl.getLocation_Cell_Detail_Location_Cell_Rack_idRack(),ppl.getLocation_Cell_Detail_Location_Cell_idLocation_Cell(),ppl.getLocation_Cell_Detail_idLocation_Cell_Detail(), 1);
                
            }
            daoLog.clientIns("Se ha registrado un nuevo despacho proveniente del picking N° :"+pickingOrderAux.getIdPickingOrder(), Frm_PickingOrder_Detail.class.toString(), logSI.getIduser());
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_massive;
    private javax.swing.JButton btn_searchDate;
    private javax.swing.JButton btn_searchOrder;
    private javax.swing.JCheckBox cbox_selectDates;
    private javax.swing.JCheckBox cbox_selectOrder;
    private com.toedter.calendar.JDateChooser date_from;
    private com.toedter.calendar.JDateChooser date_to;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_dateFrom;
    private javax.swing.JLabel lbl_dateTo;
    private javax.swing.JLabel lbl_order;
    private javax.swing.JPanel pnl_date;
    private javax.swing.JPanel pnl_order;
    private javax.swing.JPanel pnl_orders;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTable table_orders;
    private javax.swing.JTextField txt_num_order;
    // End of variables declaration//GEN-END:variables
}
