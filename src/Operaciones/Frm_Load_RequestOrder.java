/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Operaciones;

import Model.Client;
import Model.Product;
import Model.RequestOrder;
import Model.RequestOrderDetail;
import Model.StateRequestOrder;
import Model.Users;
import Seguridad.*;
import dao.DaoClient;
import dao.DaoProducts;
import dao.DaoRequestOrder;
import dao.DaoStateRequestOrder;
import dao.DaoUsers;
import dao.impl.DaoClientImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoRequestOrderImpl;
import dao.impl.DaoStateRequestOrderImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejo
 */
public class Frm_Load_RequestOrder extends javax.swing.JFrame {
    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();
    JFileChooser chooser = new JFileChooser();
    String dispatchFileName = new String();
    List<RequestOrder> requestOrderList = new ArrayList<>();
    DaoClient daoClients = new DaoClientImpl();
    DaoStateRequestOrder daoStateRequestOrder = new DaoStateRequestOrderImpl();
    DaoProducts daoProducts = new DaoProdImpl();
    DaoRequestOrder daoRequestOrder = new DaoRequestOrderImpl();
    Users userAux = new Users();
    DefaultTableModel model;
    
    /**
     * Creates new form Frm_CambiarLog
     */
    public Frm_Load_RequestOrder(Frm_MenuPrincipal menu, Users user) {
       menuaux=menu;
       menuaux.setEnabled(false);
       setTitle("CARGAR ÓRDENES DE PEDIDO");
       userAux = user;
       initComponents();
       model = (DefaultTableModel) table_orders.getModel();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_load = new javax.swing.JPanel();
        loadLabel2 = new javax.swing.JLabel();
        txt_LoadFile = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        btn_load = new javax.swing.JButton();
        lbl_orders = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_orders = new javax.swing.JTable();
        btn_exit = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_load.setBorder(javax.swing.BorderFactory.createTitledBorder("Cargar Pedidos"));

        loadLabel2.setText("Ruta:");

        txt_LoadFile.setEditable(false);

        btn_Search.setText("Buscar");
        btn_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SearchActionPerformed(evt);
            }
        });

        btn_load.setText("Cargar Órdenes de Pedido");
        btn_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_loadLayout = new javax.swing.GroupLayout(pnl_load);
        pnl_load.setLayout(pnl_loadLayout);
        pnl_loadLayout.setHorizontalGroup(
            pnl_loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_loadLayout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(pnl_loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_load)
                    .addGroup(pnl_loadLayout.createSequentialGroup()
                        .addComponent(loadLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txt_LoadFile, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Search)))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        pnl_loadLayout.setVerticalGroup(
            pnl_loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_loadLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadLabel2)
                    .addComponent(txt_LoadFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_load)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbl_orders.setBorder(javax.swing.BorderFactory.createTitledBorder("Órdenes de Pedido"));

        table_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número de Orden", "Cliente", "Fecha Enviada", "Estado"
            }
        ));
        table_orders.setColumnSelectionAllowed(true);
        table_orders.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ordersMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_orders);

        btn_exit.setText("Salir");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        btn_save.setText("Guardar");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lbl_ordersLayout = new javax.swing.GroupLayout(lbl_orders);
        lbl_orders.setLayout(lbl_ordersLayout);
        lbl_ordersLayout.setHorizontalGroup(
            lbl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_ordersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lbl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(lbl_ordersLayout.createSequentialGroup()
                        .addComponent(btn_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        lbl_ordersLayout.setVerticalGroup(
            lbl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lbl_ordersLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(lbl_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_orders, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_load, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_load, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_orders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
        menuaux.setVisible(true);
        menuaux.setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

    private void btn_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SearchActionPerformed
        // TODO add your handling code here:
        chooser.setDialogTitle("SELECCIONAR ARCHIVO DE ÓRDENES DE PEDIDO");
        chooser.showDialog(this, null);
        dispatchFileName= chooser.getSelectedFile().getAbsolutePath();
        txt_LoadFile.setText(dispatchFileName);
    }//GEN-LAST:event_btn_SearchActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        
        menuaux.setEnabled(true);
        menuaux.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_formWindowClosing

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        Object[] options = {"OK"};
        if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
            "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
            int sizeArray = requestOrderList.size();
            for(int i=0;i<sizeArray;i++){
                daoRequestOrder.requestOrderIns(requestOrderList.get(i));
            }
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se han guardado los pedidos con éxito","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }       
    }//GEN-LAST:event_btn_saveActionPerformed

    private void table_ordersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ordersMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_table_ordersMouseClicked

    private void btn_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loadActionPerformed
        // TODO add your handling code here:
        //Al hacer click en cargar debe llevar todos los datos a objetos y cargarlos a la tabla no a la BD aun
        Object[] options = {"OK"};
        dispatchFileName = txt_LoadFile.getText();
        String words[] = dispatchFileName.split("\\.");
        if(dispatchFileName==null || dispatchFileName.length()==0){
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Seleccione un archivo.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }
        else if(words[1].equals("txt")==false){
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Formato de archivo incorrecto.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }
        else{
            //se lee el archivo
            BufferedReader dispatchFile;
            try {
                dispatchFile = new BufferedReader(new FileReader(dispatchFileName));
                String line = dispatchFile.readLine();
                String[] words_line = null;
                /*Lectura de todos los datos principales de la orden de pedido*/
                //VARIABLE PARA LA ORDEN 
                Timestamp dateArrive,dateline;
                String idClient;
                int idStateRequest;
                //VARIABLE PARA LOS DETALLES DE LA ORDEN
                int codProd;
                int cantidad;
                
                RequestOrder ro = new RequestOrder();
                while (line != null) {                     
                    //lectura por pedido
                    ro = new RequestOrder();
                    words_line = line.split("-");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    Date parsedDate = dateFormat.parse(words_line[0]);
                    dateArrive = new java.sql.Timestamp(parsedDate.getTime());
                    parsedDate = dateFormat.parse(words_line[1]);
                    dateline =  new java.sql.Timestamp(parsedDate.getTime());
                    idClient = words_line[2];
                    idStateRequest = Integer.parseInt(words_line[3]);
                    Client client = daoClients.clientGet(idClient);
                    StateRequestOrder stateRequest = daoStateRequestOrder.stateRequestOrderGet(idStateRequest);
                    if(client!=null && stateRequest != null){
                        ro.setClientidClient(client);
                        ro.setDateArrive(dateArrive);
                        ro.setDateline(dateline);
                        ro.setPickingOrder(null);
                        ro.setIdClient(client.getIdClient());
                        ro.setRequestOrderDetailList(new ArrayList<RequestOrderDetail>());
                        ro.setUserCreated(userAux.getIdUser());
                        ro.setUserUpdated(null);   
                        ro.setStateRequestOrderidStateRequestOrder(stateRequest);
                        ro.setStatus(1);
                        ro.setRequestOrdercol(null);
                    }else{
                        int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Archivo contiene datos no válidos. Intente de nuevo","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
                        txt_LoadFile.setText("");
                    }
                    line = dispatchFile.readLine();
                    if(line==null)
                        break;
                    
                    while(line.equals("FIN PEDIDO")==false){
                        //SE LEE LOS DATOS QUE CONTIENEN LA ORDEN
                        words_line = line.split("-");
                        codProd = Integer.parseInt(words[0]);
                        cantidad = Integer.parseInt(words[1]);
                        Product prod = daoProducts.ProductsGet(codProd);
                        if(prod!=null){
                            RequestOrderDetail requestOrderDetail = new RequestOrderDetail();
                            requestOrderDetail.setIdProduct(codProd);
                            requestOrderDetail.setProductidProduct(prod);
                            requestOrderDetail.setDelivered(0);
                            requestOrderDetail.setQuantity(cantidad);
                            requestOrderDetail.setRemaining(cantidad);
                            requestOrderDetail.setRequestOrder(ro);
                            requestOrderDetail.setStatus(1);
                            requestOrderDetail.setUserCreated(userAux.getIdUser());
                            requestOrderDetail.setUserUpdated(null);
                            ro.getRequestOrderDetailList().add(requestOrderDetail);
                        }
                        line = dispatchFile.readLine();
                    }
                    line = dispatchFile.readLine();
                    if(line==null)
                        break;
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Frm_Load_RequestOrder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Frm_Load_RequestOrder.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Frm_Load_RequestOrder.class.getName()).log(Level.SEVERE, null, ex);
            }
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Archivo cargado con éxito.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
        }
    }//GEN-LAST:event_btn_loadActionPerformed
 
    private void formWindowClosed(java.awt.event.WindowEvent evt) {
        // TODO add your handling code here:
        menuaux.setEnabled(true);
        menuaux.setVisible(true);
        this.dispose();
        
    }
    
    private void fillTable(){
        int sizeOrder = requestOrderList.size();
        for(int i=0;i<sizeOrder;i++){
            RequestOrder ro = requestOrderList.get(i);
            String nameState = ro.getStateRequestOrderidStateRequestOrder().getDescription();
            Object[] fila = {i,ro.getClientidClient().getName(),ro.getDateArrive().toString(),nameState};
            model.addRow(fila);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Search;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_load;
    private javax.swing.JButton btn_save;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel lbl_orders;
    private javax.swing.JLabel loadLabel2;
    private javax.swing.JPanel pnl_load;
    private javax.swing.JTable table_orders;
    private javax.swing.JTextField txt_LoadFile;
    // End of variables declaration//GEN-END:variables
}
