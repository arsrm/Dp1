/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Operaciones;

import Model.Client;
import Model.DispatchOrder;
import Model.Product;
import Model.ProductReturn;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoClient;
import dao.DaoDispatchOrder;
import dao.DaoProductReturn;
import dao.DaoProducts;
import dao.impl.DaoClientImpl;
import dao.impl.DaoDispatchOrderImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoProductReturnImpl;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Miguel
 */
public class Frm_ReturnProducts_Search extends javax.swing.JFrame {
    Frm_MenuPrincipal menuaux=new Frm_MenuPrincipal();
    /**
     * Creates new form Frm_ReturnProducts_Search
     */
    DaoDispatchOrder daoDispatchOrder = new DaoDispatchOrderImpl();
    List<DispatchOrder> dispatchOrderList = null;
    DispatchOrder dispatchOrder = null;
    
    DaoProductReturn daoProductReturn = new DaoProductReturnImpl();
    List<ProductReturn> productReturnList = null;
    ProductReturn productReturn = null;
    
    DaoClient daoClient = new DaoClientImpl();
    Client client = null;
    
    DaoProducts daoProduct = new DaoProdImpl();
    Product product = null;
    int idClient=-1;
    
    DefaultTableModel modelo;
    
    public Frm_ReturnProducts_Search(Frm_MenuPrincipal menu) {
        setTitle("DEVOLUCIONES DE PRODUCTOS");
        menuaux = menu;
        initComponents();
    }

    public Frm_ReturnProducts_Search(){
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_returns = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_returns = new javax.swing.JTable();
        btn_cancel = new javax.swing.JButton();
        pnl_search_criteria = new javax.swing.JPanel();
        lbl_date_to = new javax.swing.JLabel();
        jdate_request_date_to = new com.toedter.calendar.JDateChooser();
        lbl_date_from = new javax.swing.JLabel();
        jdate_request_date_from = new com.toedter.calendar.JDateChooser();
        lbl_client = new javax.swing.JLabel();
        txt_id_client = new javax.swing.JTextField();
        txt_client_name = new javax.swing.JTextField();
        btn_client_search = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnl_returns.setBorder(javax.swing.BorderFactory.createTitledBorder("Devoluciones"));

        tbl_returns.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Número de Despacho", "Cliente", "Producto", "Cantidad", "Fecha de Devolución", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_returns.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_returnsMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_returns);

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_returnsLayout = new javax.swing.GroupLayout(pnl_returns);
        pnl_returns.setLayout(pnl_returnsLayout);
        pnl_returnsLayout.setHorizontalGroup(
            pnl_returnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_returnsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_returnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 802, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_returnsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_cancel)))
                .addContainerGap())
        );
        pnl_returnsLayout.setVerticalGroup(
            pnl_returnsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_returnsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_cancel)
                .addContainerGap())
        );

        pnl_search_criteria.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios Búsqueda"));

        lbl_date_to.setText("Fecha Devolución Hasta:");

        lbl_date_from.setText("Fecha Devolución Desde:");

        lbl_client.setText("Cliente:");

        txt_client_name.setEditable(false);

        btn_client_search.setText("Buscar");
        btn_client_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_client_searchActionPerformed(evt);
            }
        });

        btn_search.setText("Buscar Devoluciones");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_search_criteriaLayout.createSequentialGroup()
                        .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_date_from, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_client, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                                .addComponent(jdate_request_date_from, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77)
                                .addComponent(lbl_date_to)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdate_request_date_to, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_search_criteriaLayout.createSequentialGroup()
                                .addComponent(txt_id_client, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_client_search)
                                .addGap(18, 18, 18)
                                .addComponent(txt_client_name, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_search_criteriaLayout.createSequentialGroup()
                        .addComponent(btn_search)
                        .addContainerGap())))
        );
        pnl_search_criteriaLayout.setVerticalGroup(
            pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_search_criteriaLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_client_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_client_search)
                    .addComponent(lbl_client))
                .addGap(18, 18, 18)
                .addGroup(pnl_search_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jdate_request_date_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_date_to)
                    .addComponent(lbl_date_from)
                    .addComponent(jdate_request_date_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(btn_search))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_returns, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_search_criteria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_search_criteria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_returns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void tbl_returnsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_returnsMouseClicked
        // TODO add your handling code here:
        if(evt.getSource()==tbl_returns){
            int rowSel = tbl_returns.getSelectedRow();
            int colSel = tbl_returns.getSelectedColumn();
            if (colSel==0){
              Frm_ReturnProducts_Detail frm_rpd = new Frm_ReturnProducts_Detail(this);
              frm_rpd.setLocation(450,150);
              frm_rpd.setVisible(true);
              frm_rpd.setLocationRelativeTo(null);
              this.setVisible(false);  
            }
        }
    }//GEN-LAST:event_tbl_returnsMouseClicked

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        Date dateFrom,dateTo;
        
        if ( jdate_request_date_from.getDate()!=null && jdate_request_date_to.getDate()!=null ){
            dateFrom = jdate_request_date_from.getDate();
            dateTo = jdate_request_date_to.getDate();
            productReturnList = daoProductReturn.productReturnQry(idClient, dateFrom, dateTo, 1);
            initializeTable();
        }else{
            JOptionPane.showMessageDialog(null,"Escoja las fechas de inicio y fin", 
                        "Advertencias", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_searchActionPerformed

    private void btn_client_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_client_searchActionPerformed
        
        client = daoClient.clientGet(txt_id_client.getText().trim());
        if (client!=null){
            txt_client_name.setText(client.getName().trim());
            idClient = client.getIdClient();
        }else{
            JOptionPane.showMessageDialog(null,"No existe el cliente con el RUC buscado", 
                        "Advertencias", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_client_searchActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed
    
    public void initializeTable(){
        String status= null;
        modelo = (DefaultTableModel) tbl_returns.getModel();
        if(modelo!=null){
            modelo.getDataVector().removeAllElements();
            modelo.fireTableDataChanged();
        }
        try {
            for (int i = 0; i < productReturnList.size(); i++) {
                
                if (productReturnList.get(i).getStatus()==0) status = "Inactivo";
                else status = "Activo";
                
                client = daoClient.clientGet(productReturnList.get(i).getIdClient());
                product = daoProduct.ProductsGet(productReturnList.get(i).getPicking_Order_Detail_Product_idProduct());
                
                Object newRow[] = {
                    productReturnList.get(i).getIdDispatch_Order(),                    
                    client.getName(),
                    product.getName(),
                    productReturnList.get(i).getQuantity(),
                    productReturnList.get(i).getReturn_date(),
                    status
                };
                modelo.addRow(newRow);
            }
        } catch (Exception e) {
        }
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_client_search;
    private javax.swing.JButton btn_search;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdate_request_date_from;
    private com.toedter.calendar.JDateChooser jdate_request_date_to;
    private javax.swing.JLabel lbl_client;
    private javax.swing.JLabel lbl_date_from;
    private javax.swing.JLabel lbl_date_to;
    private javax.swing.JPanel pnl_returns;
    private javax.swing.JPanel pnl_search_criteria;
    private javax.swing.JTable tbl_returns;
    private javax.swing.JTextField txt_client_name;
    private javax.swing.JTextField txt_id_client;
    // End of variables declaration//GEN-END:variables
}
