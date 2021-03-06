/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Operaciones;

import Model.Client;
import Model.Log;
import Model.Pallet_Product_Location;
import Model.PickingOrder;
import Model.PickingOrderDetail;
import Model.Product;
import Model.RequestOrder;
import Model.RequestOrderDetail;
import Model.StateRequestOrder;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoClient;
import dao.DaoLog;
import dao.DaoPallet_Product_Location;
import dao.DaoPickingOrder;
import dao.DaoPickingOrderDetail;
import dao.DaoRequestOrder;
import dao.DaoRequestOrderDetail;
import dao.DaoStateRequestOrder;
import dao.impl.DaoClientImpl;
import dao.impl.DaoLogImpl;
import dao.impl.DaoPallet_Producto_LocationImpl;
import dao.impl.DaoPickingOrderDetailImpl;
import dao.impl.DaoPickingOrderImpl;
import dao.impl.DaoRequestOrderDetailImpl;
import dao.impl.DaoRequestOrderImpl;
import dao.impl.DaoStateRequestOrderImpl;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import tool.SelectAllHeader;
import static tool.Validate.validarEntero;
import static tool.Validate.validarRazonSocial;

/**
 *
 * @author Luis Miguel
 */
public class Frm_RequestOrder_Search extends javax.swing.JFrame {
    DaoRequestOrder daoRequest =new DaoRequestOrderImpl();
    List<RequestOrder> requestOrderList = new ArrayList<>();
    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();
    DefaultTableModel model = new DefaultTableModel();
    DaoClient daoClient = new DaoClientImpl();
    DaoRequestOrderDetail daoRequestDetail = new DaoRequestOrderDetailImpl();
    DaoStateRequestOrder daoStateRequestOrder = new DaoStateRequestOrderImpl();
    List<StateRequestOrder> listStateRequest = new ArrayList<>();
    Client client;
    List<Integer> listRequestToDelete = new ArrayList<>();
    DaoLog daoLog = new DaoLogImpl();
    Log logSI = null;
    List<RequestOrder> requestOrderListToPicking = new ArrayList<>();
    DaoPickingOrder daoPickingOrder = new DaoPickingOrderImpl();
    DaoPickingOrderDetail daoPickingOrderDetail = new DaoPickingOrderDetailImpl();
    DaoPallet_Product_Location daoPalletProductLocation = new DaoPallet_Producto_LocationImpl();
    private BarraProgreso tarea;
    /**
     * Creates new form Frm_VerOrdenesPedidos1
     */
    public Frm_RequestOrder_Search(Frm_MenuPrincipal menu) {
        setTitle("ÓRDENES DE PEDIDO");
        listStateRequest = daoStateRequestOrder.stateRequestOrderQry();
        menuaux = menu;
        initComponents();
        fillCombo(listStateRequest);
        TableColumn tc = table_orders.getColumnModel().getColumn(3);
        tc.setHeaderRenderer(new SelectAllHeader(table_orders, 3));
        model = (DefaultTableModel) table_orders.getModel();
        refreshGrid();
    }

    public Frm_RequestOrder_Search(){
        
    }
    
    public void refreshGrid(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
    }
    
    class BarraProgreso extends SwingWorker<Void, Void> {

        @Override
        public void done() {
            progress_bar.setIndeterminate(false);
           
        }

        @Override
        public Void doInBackground() throws Exception {
           progress_bar.setIndeterminate(true); 
           Object[] options = {"OK"};
            if(ifNoColummnSelected()==false){
                requestOrderListToPicking =  new ArrayList<>();
                 for (int i = 0; i < table_orders.getRowCount(); i++) {
                    if ((Boolean) table_orders.getValueAt(i, 3)) {
                        if(requestOrderList.get(i).getStateRequestOrder().getIdStateRequestOrder()==2)//verificamos solo los pendientes
                            requestOrderListToPicking.add(requestOrderList.get(i));
                        else{
                            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Pedido N° "+(int)table_orders.getValueAt(i,0)+" fue atendido. No se puede cancelar","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                        }
                    }
                }
                if(requestOrderListToPicking.size()!=0){
                    if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
                        "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
                        massive_picking_creation(requestOrderListToPicking);
                        int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se han creado las órdenes de picking.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);

                        refreshGrid();
                        searchFilter();
                        fillTable();

                    }
                }else{
                    int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se realizaron cambios.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);  
                }
            }else{
                int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Seleccione un registro.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            }
            return null;
        }
    }
    
    public void fillCombo(List<StateRequestOrder> list){
        int size = list.size();
        ArrayList<String> listStates = new ArrayList<>();
        listStates.add(" ");
        for(int i=0;i<size;i++){
            listStates.add(list.get(i).getDescription());
        }
        cbo_status.setModel(new DefaultComboBoxModel(listStates.toArray()));
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
        jdate_request_date_to = new com.toedter.calendar.JDateChooser();
        lbl_status = new javax.swing.JLabel();
        jdate_request_date_from = new com.toedter.calendar.JDateChooser();
        lbl_client = new javax.swing.JLabel();
        txt_id_client = new javax.swing.JTextField();
        txt_client_name = new javax.swing.JTextField();
        btn_client_search = new javax.swing.JButton();
        cbo_status = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        pnl_orders = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_orders = new javax.swing.JTable();
        btn_delete = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_massive = new javax.swing.JButton();
        progress_bar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_search_criteria.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios Búsqueda"));

        jLabel1.setText("Fecha Pedido Hasta:");

        btn_search.setText("Buscar Pedidos");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        lbl_status.setText("Estado:");

        lbl_client.setText("Cliente:");

        txt_id_client.setEditable(false);

        txt_client_name.setEditable(false);

        btn_client_search.setText("Buscar");
        btn_client_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_client_searchActionPerformed(evt);
            }
        });

        cbo_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "TODO", "ATENDIDO", "PENDIENTE", "CANCELADO" }));
        cbo_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_statusActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha Pedido Desde:");

        javax.swing.GroupLayout pnl_search_criteriaLayout = new javax.swing.GroupLayout(pnl_search_criteria);
        pnl_search_criteria.setLayout(pnl_search_criteriaLayout);
        pnl_search_criteriaLayout.setHorizontalGroup(
            pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                        .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(lbl_status))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                                .addComponent(cbo_status, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_search))
                            .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                                .addComponent(jdate_request_date_from, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdate_request_date_to, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                        .addComponent(lbl_client)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_id_client, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_client_search)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_client_name, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                        .addGap(188, 188, 188))))
        );
        pnl_search_criteriaLayout.setVerticalGroup(
            pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_search_criteriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_client)
                    .addComponent(btn_client_search)
                    .addComponent(txt_client_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jdate_request_date_from, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jdate_request_date_to, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_search)
                    .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbo_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_status)))
                .addGap(33, 33, 33))
        );

        pnl_orders.setBorder(javax.swing.BorderFactory.createTitledBorder("Órdenes de Pedido"));

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
                false, false, false, true
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

        btn_delete.setText("Cambiar Estado");
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

        btn_update.setText("Actualizar Pedidos");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_massive.setText("Creación Masiva de Órdenes de Entrega");
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 809, Short.MAX_VALUE)
                    .addGroup(pnl_ordersLayout.createSequentialGroup()
                        .addComponent(btn_massive)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delete)
                        .addGap(18, 18, 18)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cancel)
                        .addGap(4, 4, 4))))
        );
        pnl_ordersLayout.setVerticalGroup(
            pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ordersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_delete)
                    .addComponent(btn_cancel)
                    .addComponent(btn_update)
                    .addComponent(btn_massive))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_search_criteria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_orders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(progress_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(349, 349, 349))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_search_criteria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_orders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progress_bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_ordersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ordersMouseClicked
        // TODO add your handling code here:
        if(evt.getSource()==table_orders){
            int rowSel = table_orders.getSelectedRow();
            int colSel = table_orders.getSelectedColumn();
            if (colSel==0){
              RequestOrder ro = requestOrderList.get(rowSel);
              Frm_RequestOrder_Detail frm_vdop = new Frm_RequestOrder_Detail(this,ro.getIdRequestOrder());
              frm_vdop.setLocation(450,150);
              frm_vdop.setVisible(true);
              frm_vdop.setLocationRelativeTo(null);
              this.setVisible(false);  
            }
        }
    }//GEN-LAST:event_table_ordersMouseClicked

    public void setClient(Client cliente){
        Object[] options = {"OK"};
        
        if(cliente == null){
            
            txt_id_client.setText(null);
            txt_client_name.setText(null);
        
        }else{
            client = cliente;
            
            txt_id_client.setText(client.getRuc());
            txt_client_name.setText(client.getName());
        }
    }
    
    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        Object[] options = {"OK"};
        if(ifNoColummnSelected()==false){
            listRequestToDelete =  new ArrayList<>();
             for (int i = 0; i < table_orders.getRowCount(); i++) {
                if ((Boolean) table_orders.getValueAt(i, 3)) {
                    
                    if(requestOrderList.get(i).getStateRequestOrder().getIdStateRequestOrder()==2)
                        listRequestToDelete.add(Integer.parseInt(table_orders.getValueAt(i, 0).toString()));
                    else{
                        int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Pedido N° "+(int)table_orders.getValueAt(i,0)+" fue atendido. No se puede cancelar","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    }
                }
            }
            if(listRequestToDelete.size()!=0){
                if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
                    "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
                    daoRequest.requestsDel(listRequestToDelete);
                    int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se han cambiado los estados de los pedidos.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    log();
                    refreshGrid();
                    searchFilter();
                    fillTable();

                }
            }else{
                int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se realizaron cambios.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);  
            }
        }else{
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Seleccione un registro.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_client_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_client_searchActionPerformed
        // TODO add your handling code here:
        Frm_Client_Get frm_cg = new Frm_Client_Get(this);
        frm_cg.setLocation(450,150);
        frm_cg.setVisible(true);
        frm_cg.setLocationRelativeTo(null);
        this.setVisible(false);  
            
    }//GEN-LAST:event_btn_client_searchActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        searchFilter();
        fillTable();
    }//GEN-LAST:event_btn_searchActionPerformed

    private void cbo_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_statusActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:
        Object[] options = {"OK"};
        List<RequestOrder> list = daoRequest.requestOrderQryByStatus(2);
        if(list == null){
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se encontraron pedidos pendientes.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);  
        }else{
            if(list.size()==0){
                int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se encontraron pedidos pendientes.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);  
            }else{
                int size = list.size();
                for(int i=0;i<size;i++){
                    RequestOrder ro = list.get(i);
                    updateByDate(ro);
                }
            }
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se han cancelado los pedidos que pasaron el límite de fecha máxima de entrega.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);  
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_massiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_massiveActionPerformed
        // TODO add your handling code here:
        /*Object[] options = {"OK"};
        if(ifNoColummnSelected()==false){
            requestOrderListToPicking =  new ArrayList<>();
             for (int i = 0; i < table_orders.getRowCount(); i++) {
                if ((Boolean) table_orders.getValueAt(i, 3)) {
                    if(requestOrderList.get(i).getStateRequestOrder().getIdStateRequestOrder()==2)//verificamos solo los pendientes
                        requestOrderListToPicking.add(requestOrderList.get(i));
                    else{
                        int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Pedido N° "+(int)table_orders.getValueAt(i,0)+" fue atendido. No se puede cancelar","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    }
                }
            }
            if(requestOrderListToPicking.size()!=0){
                if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
                    "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
                    massive_picking_creation(requestOrderListToPicking);
                    int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se han creado las órdenes de picking.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    
                    refreshGrid();
                    searchFilter();
                    fillTable();

                }
            }else{
                int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se realizaron cambios.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);  
            }
        }else{
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Seleccione un registro.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }*/
        tarea = new BarraProgreso();
        tarea.execute();
    }//GEN-LAST:event_btn_massiveActionPerformed

    
    private void massive_picking_creation(List<RequestOrder> list){
        int sizeR = requestOrderListToPicking.size();
        for(int m=0;m<sizeR;m++){
            RequestOrder roAux = requestOrderListToPicking.get(m);
            List<RequestOrderDetail> roAuxDetail = roAux.getRequestOrderDetailList();
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
            int size = roAuxDetail.size();
            boolean isEmptyRequest = false;
            for(int i=0;i<size;i++){
                //vemos la cantidad de pallets necesarios para cada uno de los productos solicitados
                if(roAuxDetail.get(i).getStatus()==1){
                    Integer palletsNumberDelivered = roAuxDetail.get(i).getQuantity(); //le entrego todos los pallets de ese detalle
                    Integer palletsNumberRequested = roAuxDetail.get(i).getQuantity();
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
                        Integer delivered = roAuxDetail.get(i).getQuantity();
                        Integer quantity = roAux.getRequestOrderDetailList().get(i).getQuantity();
                        roAux.getRequestOrderDetailList().get(i).setDelivered(delivered);
                        roAux.getRequestOrderDetailList().get(i).setRemaining(palletsNumberRequested-delivered);
                        //y se ajusta la nueva cantidad solicitada con lo que falta
                        //roAux.getRequestOrderDetailList().get(i).setQuantity(quantity-delivered);
                    }else
                        isEmptyRequest = true;
                }
            }
            if(isEmptyRequest == false){
                StateRequestOrder state;
                if(requestCompleted == true)
                     state = daoStateRequestOrder.stateRequestOrderGet(4); //se setea que esta generado el picking
                else
                    state = daoStateRequestOrder.stateRequestOrderGet(2);
                roAux.setStateRequestOrder(state);
                //SE PROCEDE CON UN UPDATE
                daoRequest.requestOrderUpd(roAux);
                daoLog.clientIns("Se ha registrado la orden de picking N° " +idPicking, Frm_RequestOrder_Detail.class.toString(), logSI.getIduser());
            }
            
        }
    }
    
     private void updateByDate(RequestOrder ro){
        Date actualDate = new Date();
        System.out.println(actualDate);
        Date requestDate = ro.getDateline();
        System.out.println(requestDate);
        DaoPickingOrder daoPickingOrder = new DaoPickingOrderImpl();
        if(actualDate.getTime()<requestDate.getTime()){
            List<PickingOrder> listPo = daoPickingOrder.pickingOrderQry_search(ro.getIdRequestOrder());
            if(listPo!=null){
                if(listPo.size()==0){
                    StateRequestOrder state = daoStateRequestOrder.stateRequestOrderGet(3);
                    ro.setStateRequestOrder(state);
                    daoRequest.requestOrderUpd(ro);
                }else{
                    StateRequestOrder state = daoStateRequestOrder.stateRequestOrderGet(1);
                    ro.setStateRequestOrder(state);
                    daoRequest.requestOrderUpd(ro);
                }
            }else{
                    StateRequestOrder state = daoStateRequestOrder.stateRequestOrderGet(3);
                    ro.setStateRequestOrder(state);
                    daoRequest.requestOrderUpd(ro);
            }
            
        }
        
    }
    
    private void log(){
        int size = listRequestToDelete.size();
        for(int i=0;i<size;i++){
            daoLog.clientIns("Se ha cambiado el estado del pedido N° :  " + listRequestToDelete.get(i), Frm_RequestOrder_Search.class.toString(), logSI.getIduser());

        }
    } 
     
    private boolean validateRequest(Integer idRequest){
        RequestOrder ro = daoRequest.requestOrderGet(idRequest);
        if(ro!=null){
            List<RequestOrderDetail> roD = ro.getRequestOrderDetailList();
            if(roD !=null){
                if(roD.size()!=0){
                    int size = roD.size();
                    for(int i=0;i<size;i++){
                        RequestOrderDetail detail = roD.get(i);
                        int multiply = detail.getProduct().getQuantityBoxesPerPallet();
                        int quantityRequested = detail.getQuantity();
                        int remainder = quantityRequested % multiply ;
                        if(remainder!=0 || quantityRequested<multiply){
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }
    
    private void searchFilter(){
        String ruc = txt_id_client.getText();
        Client client = daoClient.clientGet(ruc);
        int id;
        if(client!=null)
            id=client.getIdClient();
        else
            id=-1;
        
        Date dateFrom = jdate_request_date_from.getDate();
        Date dateTo = jdate_request_date_to.getDate();
        Integer index_status = cbo_status.getSelectedIndex();
        requestOrderList = daoRequest.requestOrderQry_search(id, dateFrom, dateTo, index_status);
        
    }
    
    private boolean ifNoColummnSelected(){
        int sizeRows =  table_orders.getRowCount();
        for(int i=0;i<sizeRows;i++){
            boolean statusSelected = (Boolean)table_orders.getValueAt(i, 3);
            if(statusSelected == true)
                return false;
        }
        return true;
    }
    
    private void fillTable(){
        refreshGrid();
        Object[] options = {"OK"};
        DaoRequestOrder daoRO = new DaoRequestOrderImpl();
       
        if(requestOrderList==null){
             int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se han encontrado registros.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }
        else{
            int size = requestOrderList.size();
            if(size==0){
                 int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se han encontrado registros.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            }else{
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYYY");
                for(int i=0;i<size;i++){
                    RequestOrder ro = requestOrderList.get(i);
                    String nameState = ro.getStateRequestOrder().getDescription();
                    String dateArrive = null;
                    if(ro.getDateArrive()!=null)
                        dateArrive = sdf.format(ro.getDateArrive());
                    String dateLine = sdf.format(ro.getDateline());
                    Object[] fila = {ro.getIdRequestOrder(),ro.getClient().getName(), nameState,false};
                    model.addRow(fila);
                }
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_client_search;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_massive;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_update;
    private javax.swing.JComboBox cbo_status;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdate_request_date_from;
    private com.toedter.calendar.JDateChooser jdate_request_date_to;
    private javax.swing.JLabel lbl_client;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JPanel pnl_orders;
    private javax.swing.JPanel pnl_search_criteria;
    private javax.swing.JProgressBar progress_bar;
    private javax.swing.JTable table_orders;
    private javax.swing.JTextField txt_client_name;
    private javax.swing.JTextField txt_id_client;
    // End of variables declaration//GEN-END:variables
}
