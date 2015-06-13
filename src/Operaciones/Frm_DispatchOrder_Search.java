/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Operaciones;

import Model.Client;
import Model.DispatchOrder;
import Model.PickingOrder;
import Model.RequestOrder;
import Seguridad.Frm_MenuPrincipal;
import Simulacion_Algoritmica.Frm_Algorithmic_Simulator;
import dao.DaoClient;
import dao.DaoDispatchOrder;
import dao.DaoPickingOrder;
import dao.DaoRequestOrder;
import dao.impl.DaoClientImpl;
import dao.impl.DaoDispatchOrderImpl;
import dao.impl.DaoPickingOrderImpl;
import dao.impl.DaoRequestOrderImpl;
import java.text.SimpleDateFormat;
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
public class Frm_DispatchOrder_Search extends javax.swing.JFrame {
    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();
    DefaultTableModel model = new DefaultTableModel();
    List<DispatchOrder> listDispatchOrder =  new ArrayList<>();
    List<Integer> listDispatchToDelete = new ArrayList<>();
    DaoDispatchOrder daoDispatchOrder = new DaoDispatchOrderImpl();
    DaoPickingOrder daoPickingOrder = new DaoPickingOrderImpl();
    DaoRequestOrder daoRequestOrder = new DaoRequestOrderImpl();
    DaoClient daoClient = new DaoClientImpl();
    Client client = new Client();
    List<Integer> listDispatchToGenerate =  new ArrayList<>();
    /**
     * Creates new form Frm_VerOrdenesDespacho1
     */
    public Frm_DispatchOrder_Search(Frm_MenuPrincipal menu) {
        
        setTitle("ÓRDENES DE DESPACHO");
        menuaux=menu;
        initComponents();
        model = (DefaultTableModel) table_orders.getModel();
        TableColumn tc = table_orders.getColumnModel().getColumn(4);
        tc.setHeaderRenderer(new SelectAllHeader(table_orders, 4));
        initializeJPanelOrder();
        
    }

    public Frm_DispatchOrder_Search(){
        
    }
    
    public void initializeJPanelOrder(){
            txt_id_client.setEnabled(false);
            jdate_request_date_from.setEnabled(false);
            jdate_request_date_to.setEnabled(false);
            cbo_Status.setEnabled(false);
            check_advanced.setSelected(false);
            check_num.setSelected(true);
            txt_num_order.setEnabled(true);
            btn_search_order.setEnabled(true);
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
        btn_Cancel = new javax.swing.JButton();
        btn_GenerateRoute = new javax.swing.JButton();
        pnl_search_criteria = new javax.swing.JPanel();
        lbl_date_to = new javax.swing.JLabel();
        jdate_request_date_to = new com.toedter.calendar.JDateChooser();
        lbl_date_from = new javax.swing.JLabel();
        jdate_request_date_from = new com.toedter.calendar.JDateChooser();
        lbl_client = new javax.swing.JLabel();
        txt_id_client = new javax.swing.JTextField();
        txt_client_name = new javax.swing.JTextField();
        btn_client_search = new javax.swing.JButton();
        lbl_status = new javax.swing.JLabel();
        cbo_Status = new javax.swing.JComboBox();
        check_advanced = new javax.swing.JCheckBox();
        btn_search_advanced = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        check_num = new javax.swing.JCheckBox();
        lbl_num_order = new javax.swing.JLabel();
        txt_num_order = new javax.swing.JTextField();
        btn_search_order = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_orders.setBorder(javax.swing.BorderFactory.createTitledBorder("Órdenes de Despacho"));

        table_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de Orden", "Cliente", "Fecha Entrega", "Estado", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ordersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_orders);

        btn_Cancel.setText("Cancelar");
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        btn_GenerateRoute.setText("Generar Rutas");
        btn_GenerateRoute.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GenerateRouteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_ordersLayout = new javax.swing.GroupLayout(pnl_orders);
        pnl_orders.setLayout(pnl_ordersLayout);
        pnl_ordersLayout.setHorizontalGroup(
            pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ordersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1203, Short.MAX_VALUE)
                    .addGroup(pnl_ordersLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_GenerateRoute)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Cancel)
                        .addGap(4, 4, 4))))
        );
        pnl_ordersLayout.setVerticalGroup(
            pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_ordersLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(pnl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cancel)
                    .addComponent(btn_GenerateRoute))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pnl_search_criteria.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios Búsqueda Avanzada"));

        lbl_date_to.setText("Fecha Entrega Hasta:");

        lbl_date_from.setText("Fecha Entrega Desde:");

        lbl_client.setText("Cliente:");

        txt_id_client.setEditable(false);

        txt_client_name.setEditable(false);

        btn_client_search.setText("Buscar");
        btn_client_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_client_searchActionPerformed(evt);
            }
        });

        lbl_status.setText("Estado:");

        cbo_Status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "Entregado", "Pendiente", "En Vehículo", "Cancelado" }));

        check_advanced.setText("Seleccionar");
        check_advanced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_advancedActionPerformed(evt);
            }
        });

        btn_search_advanced.setText("Buscar Órdenes de Despacho");
        btn_search_advanced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_advancedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_search_criteriaLayout = new javax.swing.GroupLayout(pnl_search_criteria);
        pnl_search_criteria.setLayout(pnl_search_criteriaLayout);
        pnl_search_criteriaLayout.setHorizontalGroup(
            pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_search_criteriaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_date_from, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_client, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_status, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                                .addComponent(cbo_Status, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_search_advanced))
                            .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                                .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdate_request_date_from, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                                        .addComponent(txt_id_client, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_client_search)))
                                .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(lbl_date_to)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jdate_request_date_to, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txt_client_name, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(123, 123, 123))
                    .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                        .addComponent(check_advanced)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnl_search_criteriaLayout.setVerticalGroup(
            pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_search_criteriaLayout.createSequentialGroup()
                .addComponent(check_advanced)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_client_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_client_search)
                    .addComponent(txt_id_client, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_client))
                .addGap(18, 18, 18)
                .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdate_request_date_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbl_date_to))
                    .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jdate_request_date_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_date_from)))
                .addGap(18, 18, 18)
                .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbo_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_status)
                    .addComponent(btn_search_advanced))
                .addGap(14, 14, 14))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Número de Orden"));

        check_num.setText("Seleccionar");
        check_num.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_numActionPerformed(evt);
            }
        });

        lbl_num_order.setText("Número de Orden de Despacho:");

        btn_search_order.setText("Buscar Órdenes de Despacho");
        btn_search_order.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_orderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_search_order)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(lbl_num_order)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txt_num_order, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(check_num))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(check_num)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_num_order)
                    .addComponent(txt_num_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_search_order)
                .addGap(19, 19, 19))
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnl_search_criteria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_search_criteria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_orders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_search_orderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_orderActionPerformed
        // TODO add your handling code here:
        int numOrder;
        Object[] options = {"OK"};
        if(txt_num_order.getText().equals("")==true){
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Ingrese un número de orden de despacho.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }else{
             if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
                "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
                numOrder = Integer.parseInt(txt_num_order.getText());
                listDispatchOrder = daoDispatchOrder.dispatchOrderQry_search(numOrder);
                if(listDispatchOrder == null ){
                    int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se encontraron registros.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                }else{
                    if(listDispatchOrder.size()==0){
                        int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se encontraron registros.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    }else{
                        fillTable();
                    }
                }
             }
        }
    }//GEN-LAST:event_btn_search_orderActionPerformed

    public void refreshGrid(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
    }
    
    private void fillTable(){
        int size = listDispatchOrder.size();
        for(int i=0;i<size;i++){
            String nameState = null;
            DispatchOrder dor = listDispatchOrder.get(i);
            PickingOrder po = daoPickingOrder.pickingOrderGet(dor.getIdPickingOrder());
            RequestOrder ro = daoRequestOrder.requestOrderGet(po.getIdRequest_Order());
            if(dor.getStatus()==1)
                nameState = "Atendido";
            else if(dor.getStatus()==2)
                nameState = "Pendiente";
            else if(dor.getStatus()==3)
                nameState = "En vehículo";
            else
                nameState = "Cancelado";
            Object[] fila = {dor.getIdDispatch_Order(),ro.getClient().getName(),dor.getArrivalDate(),nameState,false};
            model.addRow(fila);
        }
    }
    
    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed
        // TODO add your handling code here:
        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_CancelActionPerformed

    private void table_ordersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ordersMouseClicked
        // TODO add your handling code here:
        if(evt.getSource()==table_orders){
            int rowSel = table_orders.getSelectedRow();
            int colSel = table_orders.getSelectedColumn();
            if (colSel==0){
              Frm_DispatchOrder_Detail frm_dod = new Frm_DispatchOrder_Detail(this,listDispatchOrder.get(rowSel));
              frm_dod.setLocation(450,150);
              frm_dod.setVisible(true);
              frm_dod.setLocationRelativeTo(null);
              this.setVisible(false);  
            }
        }
    }//GEN-LAST:event_table_ordersMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btn_search_advancedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_advancedActionPerformed
        // TODO add your handling code here:
        searchFilter();
        fillTable();
    }//GEN-LAST:event_btn_search_advancedActionPerformed

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
        Integer index_status = cbo_Status.getSelectedIndex();
        listDispatchOrder = daoDispatchOrder.dispatchOrderQry_search(id, dateFrom, dateTo, index_status);
        
    }
    
    private boolean ifNoColummnSelected(){
        int sizeRows =  table_orders.getRowCount();
        for(int i=0;i<sizeRows;i++){
            boolean statusSelected = (Boolean)table_orders.getValueAt(i, 4);
            if(statusSelected == true)
                return false;
        }
        return true;
    }
    
    private void check_numActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_numActionPerformed
        // TODO add your handling code here:
        if(check_num.isSelected()==true){
            txt_id_client.setEnabled(false);
            jdate_request_date_from.setEnabled(false);
            jdate_request_date_to.setEnabled(false);
            cbo_Status.setEnabled(false);
            check_advanced.setSelected(false);
            check_num.setSelected(true);
            txt_num_order.setEnabled(true);
            btn_search_order.setEnabled(true);
        }
            
    }//GEN-LAST:event_check_numActionPerformed

    private void check_advancedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_advancedActionPerformed
        // TODO add your handling code here:
        if(check_advanced.isSelected()==true){
            txt_id_client.setEnabled(true);
            jdate_request_date_from.setEnabled(true);
            jdate_request_date_to.setEnabled(true);
            cbo_Status.setEnabled(true);
            check_advanced.setSelected(true);
            check_num.setSelected(false);
            txt_num_order.setEnabled(false);
            btn_search_order.setEnabled(false);
        }
    }//GEN-LAST:event_check_advancedActionPerformed

    private void btn_client_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_client_searchActionPerformed
        // TODO add your handling code here:
        Frm_Client_Get frm_cg = new Frm_Client_Get(this);
        frm_cg.setLocation(450,150);
        frm_cg.setVisible(true);
        frm_cg.setLocationRelativeTo(null);
        this.setVisible(false); 
    }//GEN-LAST:event_btn_client_searchActionPerformed

    public void setClient(Client cliente){
        Object[] options = {"OK"};
        
        if(cliente == null){
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se obtuvo un cliente.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }else{
            client = cliente;
            txt_id_client.setText(client.getRuc());
            txt_client_name.setText(client.getName());
        }
    }
    
    private void btn_GenerateRouteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GenerateRouteActionPerformed
        // TODO add your handling code here:
        Object[] options = {"OK"};
        String message = "Las siguientes  órdenes no se pueden generar sus rutas, puesto que ya fueron atendidas, ya cuentan con una ruta o se encuentran canceladas:\n";
        if(ifNoColummnSelected()==false){
            listDispatchToGenerate =  new ArrayList<>();
            boolean allPending = verifyAllPending();
             for (int i = 0; i < table_orders.getRowCount(); i++) {
                if ((Boolean) table_orders.getValueAt(i, 4)) {
                    if(table_orders.getValueAt(i,3).equals("Pendiente")==true)
                        listDispatchToGenerate.add(Integer.parseInt(table_orders.getValueAt(i, 0).toString()));
                    else{
                        message+="Orden N° "+(int)table_orders.getValueAt(i,0)+" \n ";
                    }
                }
            }
            if(listDispatchToGenerate.size()!=0){
                if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
                    "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
                    if ( JOptionPane.showConfirmDialog(new JFrame(), message+" ¿Desea continuar? (se tomaran las órdenes en estado pendiente).", 
                    "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
                        Frm_Algorithmic_Simulator frm_as = new Frm_Algorithmic_Simulator(this,listDispatchToGenerate);
                        frm_as.setLocation(450,150);
                        frm_as.setVisible(true);
                        frm_as.setLocationRelativeTo(null);
                        this.setVisible(false);
                    }
                }
            }else{
                int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Seleccione órdenes en estado pendiente.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);  
            }
        }else{
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Seleccione un registro.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }
    }//GEN-LAST:event_btn_GenerateRouteActionPerformed

   private boolean verifyAllPending(){
       Object[] options = {"OK"};
       int size = listDispatchOrder.size();
       if(size==0){
           return false;
       }else{
          for(int i=0;i<size;i++){
              if(listDispatchOrder.get(i).getStatus()!=2)
                  return false;
          }
          return true;
       }
       
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_GenerateRoute;
    private javax.swing.JButton btn_client_search;
    private javax.swing.JButton btn_search_advanced;
    private javax.swing.JButton btn_search_order;
    private javax.swing.JComboBox cbo_Status;
    private javax.swing.JCheckBox check_advanced;
    private javax.swing.JCheckBox check_num;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdate_request_date_from;
    private com.toedter.calendar.JDateChooser jdate_request_date_to;
    private javax.swing.JLabel lbl_client;
    private javax.swing.JLabel lbl_date_from;
    private javax.swing.JLabel lbl_date_to;
    private javax.swing.JLabel lbl_num_order;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JPanel pnl_orders;
    private javax.swing.JPanel pnl_search_criteria;
    private javax.swing.JTable table_orders;
    private javax.swing.JTextField txt_client_name;
    private javax.swing.JTextField txt_id_client;
    private javax.swing.JTextField txt_num_order;
    // End of variables declaration//GEN-END:variables
}
