/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulacion_Algoritmica;

import Model.Client;
import Model.DispatchOrder;
import Model.Distribution_Center;
import Model.ExecutionAlgorithm;
import Model.ExecutionAlgorithmDetail;
import Model.ExecutionDetail;
import Model.Log;
import Model.PalletProduct;
import Model.Pallet_Product_Location;
import Model.PickingOrder;
import Model.PickingOrderDetail;
import Model.Product;
import Model.RequestOrder;
import Model.Vehicle;
import dao.DaoClient;
import dao.DaoDispatchOrder;
import dao.DaoDistributionCenter;
import dao.DaoExecutionAlgorithm;
import dao.DaoExecutionDetail;
import dao.DaoLog;
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
import dao.impl.DaoExecutionAlgorithmImpl;
import dao.impl.DaoExecutionDetailImpl;
import dao.impl.DaoLogImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoPallet_Producto_LocationImpl;
import dao.impl.DaoPickingOrderDetailImpl;
import dao.impl.DaoPickingOrderImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoRequestOrderImpl;
import dao.impl.DaoVehicleImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Miguel
 */
public class Frm_Detail_Algorithm extends javax.swing.JFrame {
    Frm_Algorithmic_Simulator frm_fasAux;
    List<String>listPerSolutionAux = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel();
    tabuSearchManager tabuManager;
    DaoClient daoClient = new DaoClientImpl();
    List<Client> clientList = new ArrayList();
    List<Vehicle> vehList = new ArrayList<>();
    List<Client> cliList = new ArrayList<>();
    List<DispatchOrder> dispatchListAux = new ArrayList<>();
    Double tabuCost;
    DaoExecutionAlgorithm daoExe = new DaoExecutionAlgorithmImpl();
    DaoExecutionDetail daoExeDetail = new DaoExecutionDetailImpl();
    DaoVehicle daoVehicle = new DaoVehicleImpl();
    DaoDispatchOrder daoDispatchOrder = new DaoDispatchOrderImpl();
    Integer flagAux;
    DaoLog daoLog = new DaoLogImpl();
    Log logSI = null;
    ExecutionAlgorithm execution ;
    List<ExecutionDetail> list = new ArrayList<>();
    DaoDistributionCenter daoCD = new DaoDistributionCenterImpl();
    DaoPickingOrder daoPickingOrder = new DaoPickingOrderImpl();
    DaoRequestOrder daoRequestOrder = new DaoRequestOrderImpl();
    DaoPickingOrderDetail daoPickingOrderDetail = new DaoPickingOrderDetailImpl();
    DaoPallet_Product_Location daoPalletProductLocation = new DaoPallet_Producto_LocationImpl();
    DaoPalletProduct daoPalletProduct = new DaoPalletProductImpl();
    DaoProducts daoProduct = new DaoProdImpl();
    /**
     * Creates new form Frm_Detail_Algorithm
     */
    public Frm_Detail_Algorithm() {
        initComponents();
    }

    public Frm_Detail_Algorithm(Frm_Algorithmic_Simulator frm_fas,List<String>listPerSolution, tabuSearchManager tsManager, List<DispatchOrder> dispatchList,Double cost,Integer flag, Double initialCost ){
        frm_fasAux = frm_fas;
        listPerSolutionAux = listPerSolution;
        tabuCost = cost;
        initComponents();
        flagAux = flag;
        if(flagAux==0)
            btn_Save.setName("Guardar Ejecución");
        else if(flagAux == 1)
            btn_Save.setName("Guartdar Ruta");
        tabuManager = tsManager;
        vehList = tsManager.getVehicleList();
        cliList = tsManager.getClientList();
        dispatchListAux = dispatchList;
        model = (DefaultTableModel) table_vehicles.getModel();
        txt_cost.setText(tabuCost.toString());
        txt_InitialSolution.setText(initialCost.toString());
        fillTable();
        
    }
    
    public Frm_Detail_Algorithm(Frm_Algorithmic_Simulator frm_fas,ExecutionAlgorithm exe){
        frm_fasAux = frm_fas;
        execution = exe;
        clientList = daoClient.clientQry();
        
        initComponents();
        model = (DefaultTableModel) table_vehicles.getModel();
        txt_cost.setText(execution.getFunction_value().toString());
        createObjects();
        flagAux = -1;
        btn_Save.setEnabled(false);
    }
    
    private void createObjects(){
        Object[] options = {"OK"};
        int ok_option;
        list = daoExeDetail.executionDetailQry(execution.getIdExecutionAlgorithm());
        if(list==null){
           ok_option =  JOptionPane.showOptionDialog(new JFrame(),"Lista vacía.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }else{
            if(list.size()==0){
                ok_option =  JOptionPane.showOptionDialog(new JFrame(),"Lista vacía.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            }else{
                //se tendra que crear artificialmente la lista de clientes y vehiculos
                createClientList();
                createVehicleList();
                fillTableFromExecution();
                
            }
        }
        
    }
    
    private void fillTableFromExecution(){
        int size = vehList.size();
        for(int i=0;i<size;i++){
            double distance = Math.round(calculateDistance(vehList.get(i).getRoute())*100)/100;
            double totalWeight = Math.round(calculateWeight(vehList.get(i).getRoute())*100)/100;
            Object[] fila = {vehList.get(i).getLicense_plate(),distance,totalWeight};
            model.addRow(fila);
        }
    }
    
   private void createClientList(){
       List<DispatchOrder> dispatchOrderListForAlgorithm = new ArrayList<>();
       
       int sizeList =list.size();
       for(int i=0;i<sizeList;i++){
           DispatchOrder dor = daoDispatchOrder.dispatchOrderGet(list.get(i).getIdDispatch_Order());
           dispatchOrderListForAlgorithm.add(dor);
       }
       
       setCDtoClientList();
       setDispatchToClient(dispatchOrderListForAlgorithm);
   }
   
   private void createVehicleList(){
       int numberVehicles = daoExeDetail.countVehiclesInExecution(execution.getIdExecutionAlgorithm());
       System.out.println("numero "+numberVehicles);
       vehList = new ArrayList<>();
       for(int i=0;i<numberVehicles;i++){
           Vehicle veh =daoVehicle.vehicleGet(i+1);
           System.out.println(veh.getIdVehicle());
           veh.setRoute(new ArrayList<>());
           veh.getRoute().add(0);
           List<Integer> listClient = daoExeDetail.getClientsFromRoute(execution.getIdExecutionAlgorithm(), veh.getIdVehicle());
           for(int j=0;j<listClient.size();j++){
               System.out.println(" cli "+listClient.get(j));
               veh.getRoute().add(listClient.get(j));
           }
           veh.getRoute().add(0);
           vehList.add(veh);
           System.out.println("NUEVO");
       }
       
   }
   
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
        cliList.add(client);
        
    }
    
    private void setDispatchToClient(List<DispatchOrder> dispatchListToAlg){
        int size = dispatchListToAlg.size();
        Double totalWeight;
        int sizeClient = clientList.size();
        
        for(int i=0;i<size;i++){
            //por cada despacho le asigno a su cliente
            DispatchOrder dOrder = dispatchListToAlg.get(i);
            PickingOrder po = daoPickingOrder.pickingOrderGet(dOrder.getIdPickingOrder());
            RequestOrder ro = daoRequestOrder.requestOrderGet(po.getIdRequest_Order());
            for(int j=0;j<sizeClient;j++){
                if(clientList.get(j).getIdClient()==dOrder.getIdClient()){
                    totalWeight = clientList.get(j).getTotalWeight();
                    List<PickingOrderDetail> poDList = daoPickingOrderDetail.pickingOrderDetailQry(po.getIdPickingOrder());
                    int sizePod = poDList.size();
                    for(int p=0;p<sizePod;p++){
                        PickingOrderDetail poD = poDList.get(p);
                        totalWeight += getTotalWeight(poD);
                    }
                    clientList.get(j).setTotalWeight(totalWeight);
                    clientList.get(j).getListDispatch().add(dOrder.getIdDispatch_Order());
                    break;
                }
            }
            
        }
        for(int i=0;i<sizeClient;i++){
            if(clientList.get(i).getTotalWeight()!=0)
               cliList.add(clientList.get(i)); 
        }
        
        
    }
    
    private void fillTable(){
        int size = listPerSolutionAux.size();
        for(int i = 0;i<size;i++){
            double distance = Math.round(calculateDistance(listPerSolutionAux.get(i))*100)/100;
            double totalWeight = Math.round(calculateWeight(listPerSolutionAux.get(i))*100)/100;
            Object[] fila = {vehList.get(i).getLicense_plate(),distance,totalWeight};
            model.addRow(fila);
        }
        
    }
    
    private double calculateDistance(String route){
        double distance = 0.0;
        System.out.println(route);
        String[] clientsId = route.split("-");
        int sizeId = clientsId.length;
        double distanceMatrix[][] = tabuManager.getDistances();
        
        for(int i=0;i<sizeId-1;i++){
            int indexIni = getIndex(clientsId[i]);
            int indexEnd = getIndex(clientsId[i+1]);
            distance+=distanceMatrix[indexIni][indexEnd];
        }
        return distance;
    }
    
    private Double calculateDistance(List<Integer> listId){
        double distance = 0.0;
        int sizeId = listId.size();
        
        Client client1,client2;
        for(int i=0;i<sizeId-1;i++){
            
            System.out.print(listId.get(i)+"/ ");
            if(i==0){
                client1=cliList.get(0);
            }else{
                client1 = daoClient.clientGet(listId.get(i));//cliente i
            }
            if(i==sizeId-2){
                client2=cliList.get(0);
            }else{
                client2 = daoClient.clientGet(listId.get(i+1));//cliente j
            }
            //extraemos las coordenadas
            int client1x = client1.getPos_x();
            int client1y = client1.getPos_y();
            int client2x = client2.getPos_x();
            int client2y = client2.getPos_y();
            //calculamos la distancia
            double dist = (double)Math.round(Math.pow(Math.pow(client1x-client2x,2)+Math.pow(client1y-client2y,2),0.5)*100)/100;
            distance += dist;
        }
        return distance;
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
    
    
    private int getIndex(String id){
        int size = cliList.size();
        
        for(int i=0;i<size;i++){
            if(Integer.parseInt(id)==cliList.get(i).getIdClient())
                return i;
        }
        return -1;
    }
    
    private double calculateWeight(String route){
        double totalweight = 0.0;
        String[] clientsId = route.split("-");
        int sizeId = clientsId.length;
        int sizeClient = cliList.size();
        for(int i=1;i<sizeId-1;i++){
            Client cli = new Client();
            
            for(int j=0;j<sizeClient;j++){
                if(cliList.get(j).getIdClient()==Integer.parseInt(clientsId[i])){
                    cli = cliList.get(j);
                    break;
                }
            }
            totalweight+=cli.getTotalWeight();
        }
        return totalweight;
    }
    
    private double calculateWeight(List<Integer> list){
        double totalweight = 0.0;
        int size = list.size();
        for(int i=1;i<size;i++){
            int sizeCl = cliList.size();
           
            for(int j=1;j<sizeCl;j++){
                if(cliList.get(j).getIdClient()==list.get(i)){
                    totalweight += cliList.get(j).getTotalWeight();
                    break;
                }
            }
            
        }
        return totalweight;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_vehicles = new javax.swing.JTable();
        btn_Save = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_cost = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_InitialSolution = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle Ejecución"));

        table_vehicles.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de Vehículo", "Kilometros Recorridos", "Peso Total Despachado"
            }
        ));
        table_vehicles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_vehiclesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_vehicles);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        );

        btn_Save.setText("Guardar Ejecución");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });

        jLabel1.setText("Valor Función Objetivo:");

        txt_cost.setEditable(false);
        txt_cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costActionPerformed(evt);
            }
        });

        jLabel2.setText("Valor Función Objetivo (Inicial): ");

        txt_InitialSolution.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Save))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_InitialSolution, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_cost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txt_InitialSolution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Save)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_vehiclesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_vehiclesMouseClicked
        // TODO add your handling code here:
        if(evt.getSource()==table_vehicles){
            int rowSel = table_vehicles.getSelectedRow();
            int colSel = table_vehicles.getSelectedColumn();
            if (colSel==0){
              Frm_Detail_Route frm_srs;
              if(flagAux!=-1)
                  frm_srs = new Frm_Detail_Route(this,listPerSolutionAux.get(rowSel),vehList.get(rowSel),cliList);
              else
                  frm_srs = new Frm_Detail_Route(this,null,vehList.get(rowSel),cliList);
              frm_srs.setLocationRelativeTo(null);  
              frm_srs.setVisible(true);
              this.setVisible(false);
              
            }
        }
    }//GEN-LAST:event_table_vehiclesMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        frm_fasAux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        // TODO add your handling code here:
        Object[] options = {"OK"};
        int ok_option;
        if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?",
            "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            //setear los datos de la ejecución
            ExecutionAlgorithm exe = new ExecutionAlgorithm();
            Date now = new Date();
            exe.setDate(now);
            exe.setFunction_value(tabuCost);
            if(flagAux==0)
                exe.setStatus(1); //significa activo pero que proviene de una simulacion
            else
                exe.setStatus(2); //significa activo pero que proviene de la generacion de rutas
            exe.setVehicles_number(vehList.size());
            Integer id = daoExe.executionAlgorithmIns(exe);
            exe.setIdExecutionAlgorithm(id);
            //insertamos el detalle
            int sizeV = listPerSolutionAux.size();
            
            for(int i=0;i<sizeV;i++){
                //por cada vehiculo
                int index_order = 1;
                Vehicle veh = vehList.get(i);
                String route = listPerSolutionAux.get(i);
                String[] idClients = route.split("-");
                int sizeCli = idClients.length;
                for(int j=1;j<sizeCli-1;j++){
                    int pos=tabuManager.getClientIndex(Integer.parseInt(idClients[j]));
                    Client cli = cliList.get(pos);
                    int listDisp = cli.getListDispatch().size();
                    for(int z=0;z<listDisp;z++){
                        DispatchOrder dor = daoDispatchOrder.dispatchOrderGet(cli.getListDispatch().get(z));
                        /*****************************************************************/
                        /***************QUEDA PENDIENTE AGREGAR EL VEHICULO***************/
                        /****************************************************************/
                        if(flagAux==1){ //SE REGISTRARA EL VEHICULO EN LOS DETERMINADOS DESPACHOS
                            dor.setStatus(3);
                            dor.setIdVehicle(veh);
                            daoDispatchOrder.dispatchOrderAssignVehicle(dor);
                        }
                        daoDispatchOrder.dispatchOrderUpd(dor);
                        int idPicking = dor.getIdPickingOrder();
                        ExecutionDetail exeD = new ExecutionDetail();
                        exeD.setIdVehicle(vehList.get(i).getIdVehicle());
                        exeD.setIdExecutionAlgorithm(id);
                        exeD.setIdDriver(vehList.get(i).getDriver().getIdDriver());
                        exeD.setIdVehicle_State(vehList.get(i).getVehicleState().getIdVehicleState());
                        exeD.setOrder_route(index_order);
                        exeD.setIdPicking_Order(idPicking);
                        exeD.setIdDispatch_Order(dor.getIdDispatch_Order());
                        daoExeDetail.executionDetailIns(exeD);
                      
                        
                    }
                    if(flagAux==1){
                        int countDispatches = veh.getDispatchNumber();
                        veh.setDispatchNumber(countDispatches+1);
                        daoVehicle.vehicleUpd(veh);
                    }
                    index_order++;
                }
                
            }
            daoLog.clientIns("Se ha registrado la simulación N°  " + id, Frm_Detail_Algorithm.class.toString(), logSI.getIduser());
            ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se registró la ejecución.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            frm_fasAux.setVisible(true);
            frm_fasAux.addExecution(exe);
            this.dispose();
        }
    }//GEN-LAST:event_btn_SaveActionPerformed

    private void txt_costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_vehicles;
    private javax.swing.JTextField txt_InitialSolution;
    private javax.swing.JTextField txt_cost;
    // End of variables declaration//GEN-END:variables
}
