/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulacion_Algoritmica;

import Model.Client;
import Model.DispatchOrder;
import Model.Distribution_Center;
import Model.Pallet;
import Model.PalletProduct;
import Model.Pallet_Product_Location;
import Model.PickingOrder;
import Model.PickingOrderDetail;
import Model.Product;
import Model.RequestOrder;
import Model.Vehicle;
import Operaciones.Frm_DispatchOrder_Detail;
import Operaciones.Frm_DispatchOrder_Search;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoClient;
import dao.DaoDispatchOrder;
import dao.DaoDistributionCenter;
import dao.DaoPalletProduct;
import dao.DaoPallet_Product_Location;
import dao.DaoPickingOrder;
import dao.DaoPickingOrderDetail;
import dao.DaoProducts;
import dao.DaoRequestOrder;
import dao.DaoVehicle;
import dao.impl.DaoClientImpl;
import dao.impl.DaoDispatchOrderImpl;
import dao.impl.DaoDistributionCenterImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoPallet_Producto_LocationImpl;
import dao.impl.DaoPickingOrderDetailImpl;
import dao.impl.DaoPickingOrderImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoRequestOrderImpl;
import dao.impl.DaoVehicleImpl;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import tool.SelectAllHeader;

/**
 *
 * @author Luis Miguel
 */
public class Frm_Algorithmic_Simulator extends javax.swing.JFrame {
    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();
    List<Vehicle> vehicleList = new ArrayList<>();
    List<Client> clientList = new ArrayList<>();
    Integer numbMaxVeh;
    List<DispatchOrder> dispatchOrderList = new ArrayList<>();
    List<DispatchOrder> dispatchOrderListForAlgorithm;
    DaoVehicle daoVehicle = new DaoVehicleImpl();
    DaoClient daoClient = new DaoClientImpl();
    int maximumValueVehicle=100;
    DaoDispatchOrder daoDispatchOrder = new DaoDispatchOrderImpl();
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model_results = new DefaultTableModel();
    tabuSearchManager tSManager = new tabuSearchManager();
    Object[] options = {"OK"};
    ArrayList<Integer> solution;
    ArrayList<String> solutionPerVehicle;
    DaoProducts daoProduct = new DaoProdImpl();
    List<Integer> listSolutions = new ArrayList<>();
    List<String> listPerSolutions = new ArrayList<>();
    List<Double> totalFunctionCost = new ArrayList<>();
    Double tabuCost;
    //****MAS DAO****//
    DaoPickingOrder daoPickingOrder = new DaoPickingOrderImpl();
    DaoRequestOrder daoRequestOrder = new DaoRequestOrderImpl();
    DaoPickingOrderDetail daoPickingOrderDetail = new DaoPickingOrderDetailImpl();
    DaoPallet_Product_Location daoPalletProductLocation = new DaoPallet_Producto_LocationImpl();
    DaoPalletProduct daoPalletProduct = new DaoPalletProductImpl();
    DaoDistributionCenter daoCD = new DaoDistributionCenterImpl();
    Frm_DispatchOrder_Search frm_dosAux = new Frm_DispatchOrder_Search();
    List<Integer> listIdDispatch = new ArrayList<>();
    List<Client> clientToAlgorithm = new ArrayList<>();
    int flag;
    
    /**
     * Creates new form Frm_algorithmic_simulator
     */
    public Frm_Algorithmic_Simulator(Frm_MenuPrincipal menu) {
        setTitle("SIMULACIÓN ALGORÍTMICA");
        menuaux=menu;
        initComponents();
        fillActualData();
        clientList = daoClient.clientQry();
        listSolutions = new ArrayList<>();
        listPerSolutions =  new ArrayList<>();
        TableColumn tc = table_dispatch_orders.getColumnModel().getColumn(3);
        tc.setHeaderRenderer(new SelectAllHeader(table_dispatch_orders, 3));
        vehicleList = daoVehicle.vehicleQry();
        if(vehicleList!=null)
          maximumValueVehicle = vehicleList.size();
        btn_loadVehicles.setEnabled(false);
        model = (DefaultTableModel) table_dispatch_orders.getModel();
        ChangeListener listener = new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
                if((Integer)spn_number_vehicles.getValue()==0 || (Integer)spn_number_vehicles.getValue()>maximumValueVehicle)
                    btn_loadVehicles.setEnabled(false);
                else
                    btn_loadVehicles.setEnabled(true);
            }
          };
        spn_number_vehicles.addChangeListener(listener);
        btn_generate_routes.setEnabled(false);
        flag = 0;
        
    }

    public Frm_Algorithmic_Simulator(){
        
    }
    
    public Frm_Algorithmic_Simulator(Frm_DispatchOrder_Search frm_dos, List<Integer> listDispatchToGenerate) {
        setTitle("SIMULACIÓN ALGORÍTMICA");
        frm_dosAux = frm_dos;
        initComponents();
        fillActualData();
        clientList = daoClient.clientQry();
        listSolutions = new ArrayList<>();
        listPerSolutions =  new ArrayList<>();
        TableColumn tc = table_dispatch_orders.getColumnModel().getColumn(3);
        tc.setHeaderRenderer(new SelectAllHeader(table_dispatch_orders, 3));
        vehicleList = daoVehicle.vehicleQry();
        if(vehicleList!=null)
          maximumValueVehicle = vehicleList.size();
        btn_loadVehicles.setEnabled(false);
        model = (DefaultTableModel) table_dispatch_orders.getModel();
        ChangeListener listener = new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
                if((Integer)spn_number_vehicles.getValue()==0 || (Integer)spn_number_vehicles.getValue()>maximumValueVehicle)
                    btn_loadVehicles.setEnabled(false);
                else
                    btn_loadVehicles.setEnabled(true);
            }
          };
        spn_number_vehicles.addChangeListener(listener);
        btn_generate_routes.setEnabled(false);
        jdate_dispatch_date.setEnabled(false);
        btn_search_orders.setEnabled(false);
        listIdDispatch = listDispatchToGenerate;
        fillTableDispatch();
        flag = 1;
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_generalParameters = new javax.swing.JPanel();
        lbl_number_vehicles = new javax.swing.JLabel();
        spn_number_vehicles = new javax.swing.JSpinner();
        lbl_number_vehicles1 = new javax.swing.JLabel();
        spn_number_iterations = new javax.swing.JSpinner();
        btn_loadVehicles = new javax.swing.JButton();
        pnl_dispatch_criteria = new javax.swing.JPanel();
        lbl_dispatch_date = new javax.swing.JLabel();
        jdate_dispatch_date = new com.toedter.calendar.JDateChooser();
        btn_search_orders = new javax.swing.JButton();
        pnl_dispatch_orders = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_dispatch_orders = new javax.swing.JTable();
        btn_generate_routes = new javax.swing.JButton();
        btn_Clean = new javax.swing.JButton();
        btn_exit = new javax.swing.JButton();
        lbl_declaimer = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_generalParameters.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros Generales"));

        lbl_number_vehicles.setText("Número de Vehiculos:");

        spn_number_vehicles.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        spn_number_vehicles.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spn_number_vehiclesStateChanged(evt);
            }
        });

        lbl_number_vehicles1.setText("Número de Iteraciones:");

        spn_number_iterations.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        btn_loadVehicles.setText("Cargar Vehiculos");
        btn_loadVehicles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loadVehiclesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_generalParametersLayout = new javax.swing.GroupLayout(pnl_generalParameters);
        pnl_generalParameters.setLayout(pnl_generalParametersLayout);
        pnl_generalParametersLayout.setHorizontalGroup(
            pnl_generalParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_generalParametersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_generalParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_generalParametersLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbl_number_vehicles1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spn_number_iterations, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_generalParametersLayout.createSequentialGroup()
                        .addComponent(btn_loadVehicles)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addComponent(lbl_number_vehicles)
                        .addGap(18, 18, 18)
                        .addComponent(spn_number_vehicles, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        pnl_generalParametersLayout.setVerticalGroup(
            pnl_generalParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_generalParametersLayout.createSequentialGroup()
                .addGroup(pnl_generalParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_generalParametersLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(pnl_generalParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_number_vehicles)
                            .addComponent(spn_number_vehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnl_generalParametersLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btn_loadVehicles)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_generalParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_number_vehicles1)
                    .addComponent(spn_number_iterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pnl_dispatch_criteria.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios de Búsqueda de Despachos"));

        lbl_dispatch_date.setText("Fecha de Entrega: (*)");

        btn_search_orders.setText("Buscar");
        btn_search_orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_search_ordersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_dispatch_criteriaLayout = new javax.swing.GroupLayout(pnl_dispatch_criteria);
        pnl_dispatch_criteria.setLayout(pnl_dispatch_criteriaLayout);
        pnl_dispatch_criteriaLayout.setHorizontalGroup(
            pnl_dispatch_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dispatch_criteriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_dispatch_date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jdate_dispatch_date, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search_orders)
                .addGap(22, 22, 22))
        );
        pnl_dispatch_criteriaLayout.setVerticalGroup(
            pnl_dispatch_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dispatch_criteriaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnl_dispatch_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_search_orders)
                    .addComponent(jdate_dispatch_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_dispatch_date))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_dispatch_orders.setBorder(javax.swing.BorderFactory.createTitledBorder("Órdenes de Despacho"));

        table_dispatch_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de Orden", "Cliente", "Estado", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_dispatch_orders.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_dispatch_orders.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table_dispatch_orders.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(table_dispatch_orders);

        btn_generate_routes.setText("Ejecutar Simulación");
        btn_generate_routes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generate_routesActionPerformed(evt);
            }
        });

        btn_Clean.setText("Limpiar");
        btn_Clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CleanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_dispatch_ordersLayout = new javax.swing.GroupLayout(pnl_dispatch_orders);
        pnl_dispatch_orders.setLayout(pnl_dispatch_ordersLayout);
        pnl_dispatch_ordersLayout.setHorizontalGroup(
            pnl_dispatch_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dispatch_ordersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_dispatch_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_dispatch_ordersLayout.createSequentialGroup()
                        .addComponent(btn_Clean)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_generate_routes)))
                .addContainerGap())
        );
        pnl_dispatch_ordersLayout.setVerticalGroup(
            pnl_dispatch_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dispatch_ordersLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_dispatch_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_generate_routes)
                    .addComponent(btn_Clean))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_exit.setText("Salir");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        lbl_declaimer.setFont(new java.awt.Font("Lucida Grande", 3, 9)); // NOI18N
        lbl_declaimer.setText("Todos los campos marcados con (*) son obligatorios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pnl_dispatch_orders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(pnl_generalParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pnl_dispatch_criteria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbl_declaimer)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_generalParameters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_dispatch_criteria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_dispatch_orders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_exit)
                    .addComponent(lbl_declaimer))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
        if(flag == 0){
            menuaux.setVisible(true);
            this.dispose();
        }else{
            frm_dosAux.setVisible(true);
            this.dispose();
        }
        
    }//GEN-LAST:event_btn_exitActionPerformed

    private void fillTableDispatch(){
        int size = listIdDispatch.size();
        List<DispatchOrder> list = new ArrayList<>();
        for(int i=0;i<size;i++){
            DispatchOrder dor = daoDispatchOrder.dispatchOrderGet(listIdDispatch.get(i));
            list.add(dor);
            PickingOrder po = daoPickingOrder.pickingOrderGet(dor.getIdPickingOrder());
                RequestOrder ro = daoRequestOrder.requestOrderGet(po.getIdRequest_Order());
                String nameState = null;
                if(dor.getStatus()==1)
                    nameState = "Entregado";
                else if(dor.getStatus()==2)
                    nameState = "Pendiente";
                else if(dor.getStatus()==3)
                    nameState = "En vehículo";
                else
                    nameState = "Cancelado";
                Object[] fila = {dor.getIdDispatch_Order(),ro.getClient().getName(), nameState,false};
                model.addRow(fila);
        }
        dispatchOrderList = list;
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if(flag == 0){
            menuaux.setVisible(true);
            this.dispose();
        }else{
            frm_dosAux.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void btn_loadVehiclesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadVehiclesActionPerformed
        // TODO add your handling code here:
        //SE CARGAN LOS VEHICULOS AL SISTEMA
        Object[] options = {"OK"};
        int ok_option;
        if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
                "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
            if((Integer)spn_number_vehicles.getValue()==0)
                ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se ha cargado ningún vehículo.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            else{
                int numbVeh = (Integer)spn_number_vehicles.getValue();
                vehicleList = daoVehicle.vehicleQry(numbVeh);
                if(vehicleList==null){
                    ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se encontraron vehiculos.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                }else{
                    
                    if(vehicleList.size()<(Integer)spn_number_vehicles.getValue())
                        ok_option = JOptionPane.showOptionDialog(new JFrame(),"Cantidad no posible de solicitar, se cargó la cantidad total que cuenta el Centro de Distribución.\nTotal cargado: "+vehicleList.size()+" vehículos.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    else
                        ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se cargaron los vehiculos con éxito.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                    btn_generate_routes.setEnabled(true);
                }
            }    
        }
        
    }//GEN-LAST:event_btn_loadVehiclesActionPerformed

    private void spn_number_vehiclesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spn_number_vehiclesStateChanged
        // TODO add your handling code here:
       
    }//GEN-LAST:event_spn_number_vehiclesStateChanged

    private void btn_search_ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_search_ordersActionPerformed
        // TODO add your handling code here:
        Date requestDate = jdate_dispatch_date.getDate();
        int ok_option;
        if(requestDate==null){
             ok_option = JOptionPane.showOptionDialog(new JFrame(),"Ingrese fecha válida.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }else{
            //BUSQUEDA DESPACHOS
            dispatchOrderList = daoDispatchOrder.dispatchOrderQry_search(requestDate);
            if(dispatchOrderList == null)
                 ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se encontraron registros.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            else{
                if(dispatchOrderList.size()==0)
                    ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se encontraron registros.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                else{
                    fillTable();
                    btn_generate_routes.setEnabled(true);
                }
            }
        }
        
        
    }//GEN-LAST:event_btn_search_ordersActionPerformed

    private void btn_generate_routesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generate_routesActionPerformed
        // TODO add your handling code here:
        boolean correctData = validateData();
        if(correctData ==true){
            //se realiza el trabajo de seleccionar todos los despachos
            dispatchOrderListForAlgorithm = new ArrayList<>();
            int size = dispatchOrderList.size();
            for(int i=0;i<size;i++){
                if((Boolean)table_dispatch_orders.getValueAt(i,3)==true)
                    dispatchOrderListForAlgorithm.add(dispatchOrderList.get(i));
            }
            //tenemos la lista de despachos
            //debemos transformarlo en lista de clientes
            setCDtoClientList();
            setDispatchToClient(dispatchOrderListForAlgorithm);
            
            //ya tenemos la lista de vehiculos
            //ya tenemos la lista de clientes
            //se realiza la busqueda tabu
            tSManager = new tabuSearchManager(vehicleList,clientToAlgorithm,(Integer)spn_number_iterations.getValue());
            runAlgorithm();
            
            //se procede a asignar
            //LLENAR DATA
            Frm_Detail_Algorithm frm_srs;
            frm_srs = new Frm_Detail_Algorithm(this,listPerSolutions,tSManager,dispatchOrderListForAlgorithm,tabuCost,flag);
            frm_srs.setLocationRelativeTo(null);
            frm_srs.setVisible(true);
            this.setVisible(false);
            
        }
    }//GEN-LAST:event_btn_generate_routesActionPerformed

    private void setCDtoClientList(){
        Client client = new Client();
        Distribution_Center cd = daoCD.distribution_centerGetQry().get(0);
        client.setIdClient(0);
        client.setPos_x(cd.getPos_x());
        client.setPos_y(cd.getPos_y());
        client.setName(cd.getName());
        client.setStatus(0);
        client.setTotalWeight(0.0);
        client.setPriority(0);
        clientToAlgorithm.add(client);
        
    }
    
    private void btn_CleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CleanActionPerformed
        // TODO add your handling code here:
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        btn_generate_routes.setEnabled(false);
    }//GEN-LAST:event_btn_CleanActionPerformed
    
    private void runAlgorithm(){
       
            ArrayList<Integer> tabuSolution = tSManager.OptimizeTSearch();   
            int size = tabuSolution.size();
            listSolutions = tabuSolution;
            tabuCost = tSManager.calculateFunctionCost(tabuSolution);
            List<String> solutionPerVehicle = tSManager.generateRoutes(tabuSolution);
            listPerSolutions = solutionPerVehicle;
            totalFunctionCost.add(tabuCost);
        
    }
    
    
    
    private void cleanTable(){
        model_results.getDataVector().removeAllElements();
        model_results.fireTableDataChanged();
    }
    
    
    private void setDispatchToClient(List<DispatchOrder> dispatchListToAlg){
        int size = dispatchListToAlg.size();
        Double totalWeight;
        int sizeClient = clientList.size();
        for(int j=0;j<sizeClient;j++){
            boolean clientHasOrder = false;
            for(int z=0;z<size;z++){
                DispatchOrder dOrder = dispatchListToAlg.get(z);
                PickingOrder po = daoPickingOrder.pickingOrderGet(dOrder.getIdPickingOrder());
                RequestOrder ro = daoRequestOrder.requestOrderGet(po.getIdRequest_Order());
                if(clientList.get(j).getIdClient()==dOrder.getIdClient()){ //depacho pertenece a cliente
                    clientHasOrder = true;
                    totalWeight = 0.0;
                    List<PickingOrderDetail> poDList = daoPickingOrderDetail.pickingOrderDetailQry(po.getIdPickingOrder());
                    int sizePod = poDList.size();
                    for(int p=0;p<sizePod;p++){
                        PickingOrderDetail poD = poDList.get(p);
                        totalWeight += getTotalWeight(poD);
                    }
                    clientList.get(j).setTotalWeight(totalWeight);
                    clientList.get(j).getListDispatch().add(dOrder.getIdDispatch_Order());
                }
            }
            if(clientHasOrder==true)
                clientToAlgorithm.add(clientList.get(j));

        }  
        
    }
    
    private boolean validateData(){
        boolean noAllSelected = ifNoColummnSelected();
        if((Integer)spn_number_iterations.getValue()<500 || (Integer)spn_number_vehicles.getValue()==0 || noAllSelected==true )
            return false;
        return true;
    }
   
    private Double getTotalWeight(PickingOrderDetail poD){
        Double weight = 0.0;
        Pallet_Product_Location ppl = daoPalletProductLocation.daoPallet_Product_LocationGet(poD.getIdPallet_By_Product_By_Location_Cell_Detail());
        List<PalletProduct> pp = daoPalletProduct.GetPalletProductList("WHERE Pallet_idPallet="+ppl.getPallet_By_Product_Pallet_idPallet());
        Product product = new Product();
        int sizepp = pp.size();
        for(int j=0;j<sizepp;j++){
            product = daoProduct.ProductsGet(pp.get(j).getIdproduct());
        }
        weight = product.getQuantityBoxesPerPallet()*product.getWeightPerBox()*1.0;
        return weight;
    }
    
     private boolean ifNoColummnSelected(){
        int sizeRows =  table_dispatch_orders.getRowCount();
        for(int i=0;i<sizeRows;i++){
            boolean statusSelected = (Boolean)table_dispatch_orders.getValueAt(i, 3);
            if(statusSelected == true)
                return false;
        }
        return true;
    }
    
    private void fillActualData(){ 
        spn_number_iterations.setValue(1000);
    }
    
    private void fillTable(){
        int size = dispatchOrderList.size();
        if(size==0){
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"No se encontraron registros.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }else{
            for(int i=0;i<size;i++){
                DispatchOrder dor = dispatchOrderList.get(i);
                PickingOrder po = daoPickingOrder.pickingOrderGet(dor.getIdPickingOrder());
                RequestOrder ro = daoRequestOrder.requestOrderGet(po.getIdRequest_Order());
                String nameState = null;
                if(dor.getStatus()==1)
                    nameState = "REALIZADO";
                else if(dor.getStatus()==2)
                    nameState = "POR ENTREGAR";
                else 
                    nameState = "CANCELADO";
                Object[] fila = {dor.getIdDispatch_Order(),ro.getClient().getName(), nameState,false};
                model.addRow(fila);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Clean;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_generate_routes;
    private javax.swing.JButton btn_loadVehicles;
    private javax.swing.JButton btn_search_orders;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdate_dispatch_date;
    private javax.swing.JLabel lbl_declaimer;
    private javax.swing.JLabel lbl_dispatch_date;
    private javax.swing.JLabel lbl_number_vehicles;
    private javax.swing.JLabel lbl_number_vehicles1;
    private javax.swing.JPanel pnl_dispatch_criteria;
    private javax.swing.JPanel pnl_dispatch_orders;
    private javax.swing.JPanel pnl_generalParameters;
    private javax.swing.JSpinner spn_number_iterations;
    private javax.swing.JSpinner spn_number_vehicles;
    private javax.swing.JTable table_dispatch_orders;
    // End of variables declaration//GEN-END:variables
}
