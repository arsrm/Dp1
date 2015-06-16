/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Operaciones;

import Model.LocationCellDetail;
import Model.Log;
import Model.Pallet;
import Model.Pallet_Product_Location;
import Model.PickingOrder;
import Model.PickingOrderDetail;
import Model.Product;
import Model.RequestOrder;
import Model.RequestOrderDetail;
import Model.StateRequestOrder;
import Model.Users;
import dao.DaoLog;
import dao.DaoPalletProduct;
import dao.DaoPallet_Product_Location;
import dao.DaoPickingOrder;
import dao.DaoPickingOrderDetail;
import dao.DaoRequestOrder;
import dao.DaoRequestOrderDetail;
import dao.DaoStateRequestOrder;
import dao.impl.DaoLogImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoPallet_Producto_LocationImpl;
import dao.impl.DaoPickingOrderDetailImpl;
import dao.impl.DaoPickingOrderImpl;
import dao.impl.DaoRequestOrderDetailImpl;
import dao.impl.DaoRequestOrderImpl;
import dao.impl.DaoStateRequestOrderImpl;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import static tool.Convierte.aInteger;
import tool.SelectAllHeader;
import tool.Validate;

/**
 *
 * @author Luis Miguel
 */
public class Frm_RequestOrder_Detail extends javax.swing.JFrame {
    Frm_RequestOrder_Search frm_rosAux = new Frm_RequestOrder_Search();
    DaoRequestOrder daoRequestOrder = new DaoRequestOrderImpl();
    DaoRequestOrderDetail daoRequestOrderDetail = new DaoRequestOrderDetailImpl();
    DaoPickingOrder daoPickingOrder = new DaoPickingOrderImpl();
    DaoPickingOrderDetail daoPickingOrderDetail = new DaoPickingOrderDetailImpl();
    DaoStateRequestOrder daoStateRequestOrder = new DaoStateRequestOrderImpl();
    DaoPallet_Product_Location daoPalletProductLocation = new DaoPallet_Producto_LocationImpl();
    DaoPalletProduct daoPalletProduct = new DaoPalletProductImpl();
    RequestOrder roAux = new RequestOrder();
    DefaultTableModel model = new DefaultTableModel();
    List<Integer> listRequestToDelete =  new ArrayList<>();
    Integer idRequest;
    Boolean validateRequest = true;
    Validate valida = new Validate();
    DaoLog daoLog = new DaoLogImpl();
    Log logSI = null;
    
    /**
     * Creates new form Frm_VerDetalleOrdenPedido1
     * @param frm_ros
     */
    public Frm_RequestOrder_Detail(Frm_RequestOrder_Search frm_ros) {
        setTitle("ORDEN DE PEDIDO");
        frm_rosAux = frm_ros;
        initComponents();
    }
    
    public Frm_RequestOrder_Detail(){
        
    }
    
    public Frm_RequestOrder_Detail(Frm_RequestOrder_Search frm_ros, Integer idRequestOrder) {
        setTitle("ORDEN DE PEDIDO");
        idRequest = idRequestOrder;
        roAux = daoRequestOrder.requestOrderGet(idRequest);
        frm_rosAux = frm_ros;
        initComponents();
        TableColumn tc = table_products.getColumnModel().getColumn(8);
        tc.setHeaderRenderer(new SelectAllHeader(table_products, 8));
        model = (DefaultTableModel) table_products.getModel();
        fillCombo();
        fillData();
        if(roAux.getStateRequestOrder().getIdStateRequestOrder()==3 || roAux.getStateRequestOrder().getIdStateRequestOrder()==1){//si esta cancelado o atendido
            btn_delete.setEnabled(false);
            btn_generate_order.setEnabled(false);
            
        }else
            verifyProducts();
        putComboInTable();
    }
    
    private void fillCombo(){
        List<StateRequestOrder> list = daoStateRequestOrder.stateRequestOrderQry();
        int size = list.size();
        ArrayList<String> listStates = new ArrayList<>();
        listStates.add(" ");
        for(int i=0;i<size;i++){
            listStates.add(list.get(i).getDescription());
        }
        cbo_status.setModel(new DefaultComboBoxModel(listStates.toArray()));
        
    }
    
    private void putComboInTable(){
        TableColumn tC = table_products.getColumnModel().getColumn(6);
        List<RequestOrderDetail> rodList = roAux.getRequestOrderDetailList();
        int sizeRows = table_products.getRowCount();
        List<Integer[]> quantities = new ArrayList<>();
        for(int i=0;i<sizeRows;i++){
            TableCellEditor tce = table_products.getCellEditor(i, 6);
            JComboBox comboBox = new JComboBox();
                try {
                    RequestOrderDetail roD = rodList.get(i);
                    int size = daoRequestOrderDetail.getAvailablePallets(roD.getProduct().getIdProduct());
                    int palletsRequested = Integer.parseInt(table_products.getValueAt(i,4).toString());
                    if(size>palletsRequested)
                        size = palletsRequested;
                    Integer[] list = new Integer[size+1];
                    int item = 0;
                    for(int j=0;j<size+1;j++){
                        list[j]=j;
                    }
                    quantities.add(list);
                } catch (NullPointerException | NumberFormatException e) {
                }            
            }
        
                
        tC.setCellEditor(new MyComboEditor(quantities));
        }
        
        
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_ClientId = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        pnl_general_info = new javax.swing.JPanel();
        lbl_num_ord = new javax.swing.JLabel();
        txt_order_num = new javax.swing.JTextField();
        lbl_client = new javax.swing.JLabel();
        lbl_deliver_date = new javax.swing.JLabel();
        lbl_status = new javax.swing.JLabel();
        cbo_status = new javax.swing.JComboBox();
        lbl_address = new javax.swing.JLabel();
        lbl_reg_date = new javax.swing.JLabel();
        jdate_arrival_date = new com.toedter.calendar.JDateChooser();
        jdate_deliver_date = new com.toedter.calendar.JDateChooser();
        txt_client_address = new javax.swing.JTextField();
        txt_id_client = new javax.swing.JTextField();
        txt_client_name = new javax.swing.JTextField();
        pnl_products = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_products = new javax.swing.JTable();
        btn_cancel = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_generate_order = new javax.swing.JButton();
        lbl_declaimer = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_general_info.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        lbl_num_ord.setText("Número de Orden: ");
        lbl_num_ord.setToolTipText("");

        txt_order_num.setEditable(false);

        lbl_client.setText("Cliente: ");

        lbl_deliver_date.setText("Fecha Entrega Estimada:");

        lbl_status.setText("Estado:");

        cbo_status.setEnabled(false);

        lbl_address.setText("Dirección:");

        lbl_reg_date.setText("Fecha de Llegada:");

        jdate_arrival_date.setEnabled(false);

        jdate_deliver_date.setEnabled(false);

        txt_client_address.setEditable(false);

        txt_id_client.setEditable(false);

        txt_client_name.setEditable(false);

        javax.swing.GroupLayout pnl_general_infoLayout = new javax.swing.GroupLayout(pnl_general_info);
        pnl_general_info.setLayout(pnl_general_infoLayout);
        pnl_general_infoLayout.setHorizontalGroup(
            pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                .addContainerGap(274, Short.MAX_VALUE)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_general_infoLayout.createSequentialGroup()
                        .addComponent(txt_client_name, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_general_infoLayout.createSequentialGroup()
                        .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                                .addComponent(lbl_deliver_date, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_client)
                                    .addComponent(lbl_address)
                                    .addComponent(lbl_num_ord))
                                .addGap(32, 32, 32)))
                        .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_id_client, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_client_address, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jdate_arrival_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jdate_deliver_date, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
                            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                                .addComponent(txt_order_num, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                                .addComponent(lbl_status)))))
                .addGap(18, 18, 18)
                .addComponent(cbo_status, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                .addGap(305, 305, 305)
                .addComponent(lbl_reg_date)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnl_general_infoLayout.setVerticalGroup(
            pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_general_infoLayout.createSequentialGroup()
                        .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbo_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_status))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_general_infoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_num_ord)
                            .addComponent(txt_order_num, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_client_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_client))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_client_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_address))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_deliver_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdate_deliver_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_reg_date)
                    .addComponent(jdate_arrival_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_products.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        table_products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N° Línea", "Código Producto", "Descripción", "Cantidad Solicitado (*)", "Cantidad Pendiente", "Cantidad Disponible (*)", "Cantidad Entregada (*)", "Estado", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true, false, true
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

        btn_generate_order.setText("Generar Orden de Entrega");
        btn_generate_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generate_orderActionPerformed(evt);
            }
        });

        lbl_declaimer.setFont(new java.awt.Font("Lucida Grande", 3, 9)); // NOI18N
        lbl_declaimer.setText("(*) Cantidades dadas en Cantidad de Pallets");

        javax.swing.GroupLayout pnl_productsLayout = new javax.swing.GroupLayout(pnl_products);
        pnl_products.setLayout(pnl_productsLayout);
        pnl_productsLayout.setHorizontalGroup(
            pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_productsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(pnl_productsLayout.createSequentialGroup()
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_generate_order)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_cancel)
                        .addContainerGap())
                    .addGroup(pnl_productsLayout.createSequentialGroup()
                        .addComponent(lbl_declaimer)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnl_productsLayout.setVerticalGroup(
            pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_productsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel)
                    .addComponent(btn_delete)
                    .addComponent(btn_generate_order))
                .addGap(17, 17, 17)
                .addComponent(lbl_declaimer))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_products, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_general_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_general_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(pnl_products, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fillData(){
        txt_order_num.setText(roAux.getIdRequestOrder().toString());
        txt_id_client.setText(roAux.getClient().getRuc());
        txt_client_name.setText(roAux.getClient().getName());
        txt_client_address.setText(roAux.getClient().getAddress());
        jdate_deliver_date.setDate(roAux.getDateline());
        cbo_status.setSelectedIndex(roAux.getStateRequestOrder().getIdStateRequestOrder());
        if(roAux.getDateArrive()!=null)
            jdate_arrival_date.setDate(roAux.getDateArrive());
        fillTable();
        
    }
    
    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        frm_rosAux.setVisible(true);
        frm_rosAux.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        frm_rosAux.setVisible(true);
        frm_rosAux.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_formWindowClosing

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
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
                int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se ha cambiado el estado de/del el/los producto(s) con éxito","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                if(ok_option==JOptionPane.OK_OPTION){
                    daoRequestOrderDetail.requestOrderDetailsDel(listRequestToDelete, idRequest);
                    
                }
                
                refreshGrid();
                roAux = daoRequestOrder.requestOrderGet(idRequest);
                fillTable();
                verifyProducts();
                boolean request_details_canceled= allCancelled();
                if(request_details_canceled == true){ //cancelo todo el pedido y salgo de la pantalla
                    ok_option = JOptionPane.showOptionDialog(new JFrame(),"Todos los productos del pedido fueron inactivados. Se cancela la orden de pedido.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    if(ok_option==JOptionPane.OK_OPTION){
                        StateRequestOrder state = daoStateRequestOrder.stateRequestOrderGet(3);
                        roAux.setStateRequestOrder(state);
                        daoRequestOrder.requestOrderUpd(roAux);
                        daoLog.clientIns("Se ha cancelido el pedido N° :  " + roAux.getIdRequestOrder(), Frm_RequestOrder_Detail.class.toString(), logSI.getIduser());
                    }
                    frm_rosAux.setVisible(true);
                    frm_rosAux.refreshGrid();
                    this.dispose();                    
                }
            }
        }else{
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Seleccione al menos un registro.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void logDetail(){
        int size = listRequestToDelete.size();
        for(int i=0;i<size;i++){
            daoLog.clientIns("Se ha cambiado el estado del detalle N° " +listRequestToDelete.get(i) + " del pedido N° :  " + roAux.getIdRequestOrder(), Frm_RequestOrder_Detail.class.toString(), logSI.getIduser());
        }
    }
    
    private void refreshGrid(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
    }
    
    private void fillTable(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
        
        List<RequestOrderDetail> list = daoRequestOrderDetail.requestOrderDetailQry(roAux.getIdRequestOrder());
        int size = list.size();
        for(int i=0;i<size;i++){
            RequestOrderDetail roD = list.get(i);
            String status;
            if(roD.getStatus()==0)
                status = "Inactivo";
            else
                status = "Activo";
            
            int number_pallets = daoRequestOrderDetail.getAvailablePallets(roD.getProduct().getIdProduct());
            
            Object[] fila = {list.get(i).getIdRequest_Order_Detail(),roD.getProduct().getIdProduct().toString(),roD.getProduct().getName(),roD.getQuantity().toString(),
                            roD.getRemaining(),number_pallets,"",status,false};
            
            model.addRow(fila);
           
        }
    }
    
    
    private void verifyProducts(){
        boolean emptyRequest = allUnable();
        if(emptyRequest == true){
            btn_generate_order.setEnabled(false);
        }else{
            btn_generate_order.setEnabled(true);
        }
    }
    
    private void btn_generate_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generate_orderActionPerformed
        // TODO add your handling code here:
        
        //*********************************
        //VERIFICAR ACCESIBILIDAD Y MENSAJERIA
        //**********************************
        Object[] options = {"OK"};
        int ok_option;
        if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
                "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
            boolean correctData = validateData();
            if(correctData == true){
                
                boolean allColumnInZero = verifyColumnWithzZero();
                if(  allColumnInZero == false){
                    int size = table_products.getRowCount();
                    //TERCERO: buscar los pallets
                    PickingOrder po = new PickingOrder();
                    //seteamos datos principales
                    po.setDate(new Date());
                    //1: REALIZADO 2:PENDIENTE 3:CANCELADO
                    po.setStatus(2);
                    po.setIdRequest_Order(roAux.getIdRequestOrder());
                    Integer idPicking = daoPickingOrder.pickingOrderIns(po);
                    po.setIdPickingOrder(idPicking);
                    Integer index = 1;
                    List<PickingOrderDetail> listpoD;
                    boolean requestCompleted =true;
                    List<PickingOrderDetail> poList = new ArrayList<>();
                    for(int i=0;i<size;i++){
                        //vemos la cantidad de pallets necesarios para cada uno de los productos solicitados
                        if(table_products.getValueAt(i,7).equals("Activo")==true){
                            Integer palletsNumberDelivered = (Integer)table_products.getValueAt(i,6);
                            Integer palletsNumberRequested = Integer.parseInt(table_products.getValueAt(i,4).toString());
                            if(palletsNumberDelivered <palletsNumberRequested){ //si entrega menos de lo que tienes--ya es parcial
                                requestCompleted = false;
                            }
                            Product product = roAux.getRequestOrderDetailList().get(i).getProduct();
                            listpoD = daoPickingOrderDetail.pickingOrderDetailFind(idPicking, palletsNumberDelivered, product.getIdProduct());                    
                            if(listpoD != null){
                                int sizeL= listpoD.size();
                                for(int j=0;j<sizeL;j++){
                                    daoPickingOrderDetail.pickingOrderDetailIns(listpoD.get(j));
                                    Pallet_Product_Location ppl = daoPalletProductLocation.daoPallet_Product_LocationGet(listpoD.get(j).getIdPallet_By_Product_By_Location_Cell_Detail());
                                    poList.add(listpoD.get(j));
                                    daoPalletProductLocation.daoPallet_Product_LocationDel(listpoD.get(j).getIdPallet_By_Product_By_Location_Cell_Detail(),ppl.getPallet_By_Product_Pallet_idPallet());
                                    index++;
                                }
                                Integer delivered = (Integer)table_products.getValueAt(i, 6);
                                Integer quantity = roAux.getRequestOrderDetailList().get(i).getQuantity();
                                roAux.getRequestOrderDetailList().get(i).setDelivered(delivered);
                                roAux.getRequestOrderDetailList().get(i).setRemaining(palletsNumberRequested-delivered);
                                //y se ajusta la nueva cantidad solicitada con lo que falta
                                //roAux.getRequestOrderDetailList().get(i).setQuantity(quantity-delivered);
                            }
                        }
                    }
                    //SE SETEA EN ESTADO PICKING GENERADO o PENDIENTE AUN
                    StateRequestOrder state;
                    if(requestCompleted == true)
                         state = daoStateRequestOrder.stateRequestOrderGet(4); //se setea que esta generado el picking
                    else
                        state = daoStateRequestOrder.stateRequestOrderGet(2);
                    roAux.setStateRequestOrder(state);
                    //SE PROCEDE CON UN UPDATE
                    daoRequestOrder.requestOrderUpd(roAux);
                    daoLog.clientIns("Se ha registrado la orden de picking N° " +idPicking, Frm_RequestOrder_Detail.class.toString(), logSI.getIduser());
                    if(JOptionPane.showOptionDialog(new JFrame(),"Orden de picking registrada.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0])==JOptionPane.OK_OPTION){
                        Frm_RequestOrder_Preview frm_rop =  new Frm_RequestOrder_Preview(po,poList);
                        frm_rop.setLocation(450,150);
                        frm_rop.setVisible(true);
                        frm_rop.setLocationRelativeTo(null);
                        this.dispose();
                    }
                }
            }else
                ok_option = JOptionPane.showOptionDialog(new JFrame(),"Debe completar esta columna por completo y no está permitido llenar todas la columna con 0 pallets entregados.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }
    }//GEN-LAST:event_btn_generate_orderActionPerformed

    private boolean verifyColumnWithzZero(){
        int sizeRows =  table_products.getRowCount();
        int countZeros = 0;
        for(int i=0;i<sizeRows;i++){
            if((Integer)table_products.getValueAt(i,6)==0){
                countZeros++; 
            }  
        }
        if(countZeros == sizeRows)
            return true;
        else
            return false;
    }
    private boolean validateData(){
        int sizeRows =  table_products.getRowCount();
        for(int i=0;i<sizeRows;i++){
            if(aInteger(table_products.getValueAt(i,6).toString())==null){
                return false; 
            }
               
        }
        return true;
    }
    
    private boolean ifNoColummnSelected(){
        int sizeRows =  table_products.getRowCount();
        for(int i=0;i<sizeRows;i++){
            boolean statusSelected = (Boolean)table_products.getValueAt(i, 8);
            if(statusSelected == true)
                return false;
        }
        return true;
    }
    
    private boolean allCancelled(){
        int size = table_products.getRowCount();
        for(int i=0;i<size;i++){
            if(table_products.getValueAt(i,7).equals("Activo")==true)
                return false;
        }
        return true;
    }
    
    private boolean allUnable(){
        List<RequestOrderDetail> roD = roAux.getRequestOrderDetailList();
        int size = roD.size();
        for (int i=0;i<size;i++){
            String status = table_products.getValueAt(i, 7).toString();
            if(status.equals("Activo")==true)
                return false;
        }
        return true;
    }
    
    private class MyComboEditor extends DefaultCellEditor{
                
                List<Integer[]> values;
                
                public MyComboEditor(List<Integer[]> values){
                        super(new JComboBox());
                        this.values = values;
                        
                }
                
                @Override
                public Component getTableCellEditorComponent(JTable table, Object value,
                          boolean isSelected, int row, int column) {
                        
                        JComboBox combo = (JComboBox)getComponent();
                        combo.removeAllItems();
                        Integer[] valores = values.get(row);
                        
                        for(int i=0; i<valores.length; i++){
                                combo.addItem(valores[i]);
                        }
                        combo.setSelectedItem(value);
                        
                        return combo;
                }
        }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_generate_order;
    private javax.swing.JComboBox cbo_status;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private com.toedter.calendar.JDateChooser jdate_arrival_date;
    private com.toedter.calendar.JDateChooser jdate_deliver_date;
    private javax.swing.JLabel lbl_address;
    private javax.swing.JLabel lbl_client;
    private javax.swing.JLabel lbl_declaimer;
    private javax.swing.JLabel lbl_deliver_date;
    private javax.swing.JLabel lbl_num_ord;
    private javax.swing.JLabel lbl_reg_date;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JPanel pnl_general_info;
    private javax.swing.JPanel pnl_products;
    private javax.swing.JTable table_products;
    private javax.swing.JTextField txt_ClientId;
    private javax.swing.JTextField txt_client_address;
    private javax.swing.JTextField txt_client_name;
    private javax.swing.JTextField txt_id_client;
    private javax.swing.JTextField txt_order_num;
    // End of variables declaration//GEN-END:variables
}
