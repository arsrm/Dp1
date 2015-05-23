/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Operaciones;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Miguel
 */
public class Frm_DispatchOrder_Detail extends javax.swing.JFrame {
    Frm_DispatchOrder_Search frm_dosAux = new Frm_DispatchOrder_Search();
    
    
    /**
     * Creates new form Frm_VerDetalleOrdenDespacho1
     */
    public Frm_DispatchOrder_Detail(Frm_DispatchOrder_Search frm_fds) {
        frm_dosAux = frm_fds;
        setTitle("ORDEN DE DESPACHO");
        initComponents();
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
        lbl_order_num = new javax.swing.JLabel();
        txt_OrderNum = new javax.swing.JTextField();
        lbl_client = new javax.swing.JLabel();
        txt_ClientId = new javax.swing.JTextField();
        txt_ClientName = new javax.swing.JTextField();
        lbl_deliver_date = new javax.swing.JLabel();
        lbl_status = new javax.swing.JLabel();
        cbo_status = new javax.swing.JComboBox();
        lbl_address = new javax.swing.JLabel();
        lbl_reg_date = new javax.swing.JLabel();
        jDate_RegisterDate = new com.toedter.calendar.JDateChooser();
        jDate_DeliverDate = new com.toedter.calendar.JDateChooser();
        txt_ClientAddress = new javax.swing.JTextField();
        lbl_dispatcher = new javax.swing.JLabel();
        txt_name_dispatcher = new javax.swing.JTextField();
        txt_id_dispatcher = new javax.swing.JTextField();
        lbl_vehicle = new javax.swing.JLabel();
        txt_ClientAddress1 = new javax.swing.JTextField();
        pnl_products = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_products = new javax.swing.JTable();
        btn_cancel = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_confirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_general_info.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        lbl_order_num.setText("Número de Orden: ");
        lbl_order_num.setToolTipText("");

        txt_OrderNum.setEditable(false);
        txt_OrderNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_OrderNumActionPerformed(evt);
            }
        });

        lbl_client.setText("Cliente: ");

        txt_ClientId.setEditable(false);

        txt_ClientName.setEditable(false);

        lbl_deliver_date.setText("Fecha Entrega Estimada:");

        lbl_status.setText("Estado:");

        cbo_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO", "INACTIVO" }));

        lbl_address.setText("Dirección:");

        lbl_reg_date.setText("Fecha Registro:");

        txt_ClientAddress.setEditable(false);

        lbl_dispatcher.setText("Transportista:");

        txt_name_dispatcher.setEditable(false);

        txt_id_dispatcher.setEditable(false);

        lbl_vehicle.setText("Vehículo:");

        txt_ClientAddress1.setEditable(false);

        javax.swing.GroupLayout pnl_general_infoLayout = new javax.swing.GroupLayout(pnl_general_info);
        pnl_general_info.setLayout(pnl_general_infoLayout);
        pnl_general_infoLayout.setHorizontalGroup(
            pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_address)
                    .addComponent(lbl_reg_date)
                    .addComponent(lbl_client)
                    .addComponent(lbl_order_num)
                    .addComponent(lbl_vehicle))
                .addGap(33, 33, 33)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_general_infoLayout.createSequentialGroup()
                        .addComponent(txt_ClientAddress1)
                        .addGap(49, 49, 49)
                        .addComponent(lbl_dispatcher)
                        .addGap(30, 30, 30)
                        .addComponent(txt_id_dispatcher, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_name_dispatcher, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(pnl_general_infoLayout.createSequentialGroup()
                        .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDate_RegisterDate, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(pnl_general_infoLayout.createSequentialGroup()
                                    .addComponent(txt_ClientId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txt_ClientName))
                                .addComponent(txt_ClientAddress)
                                .addComponent(txt_OrderNum, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_deliver_date)
                            .addComponent(lbl_status))
                        .addGap(16, 16, 16)
                        .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDate_DeliverDate, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_status, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))))
        );
        pnl_general_infoLayout.setVerticalGroup(
            pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_general_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_OrderNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_status)
                    .addComponent(cbo_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_dispatcher)
                    .addComponent(lbl_vehicle)
                    .addComponent(txt_ClientAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id_dispatcher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_name_dispatcher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDate_RegisterDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_general_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbl_deliver_date, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jDate_DeliverDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbl_reg_date, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_products.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        table_products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código Pallet", "Estado"
            }
        ));
        jScrollPane3.setViewportView(table_products);

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_delete.setText("Eliminar");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_confirm.setText("Confirmar Entrega");
        btn_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_productsLayout = new javax.swing.GroupLayout(pnl_products);
        pnl_products.setLayout(pnl_productsLayout);
        pnl_productsLayout.setHorizontalGroup(
            pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_productsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 799, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_productsLayout.createSequentialGroup()
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancel)))
                .addContainerGap())
        );
        pnl_productsLayout.setVerticalGroup(
            pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_productsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_productsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel)
                    .addComponent(btn_delete)
                    .addComponent(btn_confirm))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_general_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_products, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_general_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_products, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_OrderNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_OrderNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_OrderNumActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        frm_dosAux.setVisible(true);
        frm_dosAux.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        frm_dosAux.setVisible(true);
        frm_dosAux.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btn_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmActionPerformed
        // TODO add your handling code here:
        Object[] options = {"OK"};
        if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?",
            "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

        int ok_option = JOptionPane.showOptionDialog(new JFrame(),"El despacho ha finalizado con éxito.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(ok_option==JOptionPane.OK_OPTION){
                frm_dosAux.setVisible(true);
                frm_dosAux.setLocationRelativeTo(null);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btn_confirmActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        Object[] options = {"OK"};
        if ( JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?", 
            "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
            
            int ok_option = JOptionPane.showOptionDialog(new JFrame(),"Se ha eliminado la orden de despacho con éxito.","Mensaje",JOptionPane.PLAIN_MESSAGE,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(ok_option == JOptionPane.OK_OPTION){
                frm_dosAux.setVisible(true);
                frm_dosAux.setLocationRelativeTo(null);
                this.dispose();
            }
            
        } 
    }//GEN-LAST:event_btn_deleteActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_confirm;
    private javax.swing.JButton btn_delete;
    private javax.swing.JComboBox cbo_status;
    private com.toedter.calendar.JDateChooser jDate_DeliverDate;
    private com.toedter.calendar.JDateChooser jDate_RegisterDate;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_address;
    private javax.swing.JLabel lbl_client;
    private javax.swing.JLabel lbl_deliver_date;
    private javax.swing.JLabel lbl_dispatcher;
    private javax.swing.JLabel lbl_order_num;
    private javax.swing.JLabel lbl_reg_date;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_vehicle;
    private javax.swing.JPanel pnl_general_info;
    private javax.swing.JPanel pnl_products;
    private javax.swing.JTable table_products;
    private javax.swing.JTextField txt_ClientAddress;
    private javax.swing.JTextField txt_ClientAddress1;
    private javax.swing.JTextField txt_ClientId;
    private javax.swing.JTextField txt_ClientName;
    private javax.swing.JTextField txt_OrderNum;
    private javax.swing.JTextField txt_id_dispatcher;
    private javax.swing.JTextField txt_name_dispatcher;
    // End of variables declaration//GEN-END:variables
}
