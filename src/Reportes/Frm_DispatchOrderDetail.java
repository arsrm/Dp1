/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Mantenimientos.Frm_Pallet_SearchIni;
import Model.DispatchOrder;
import Model.LocationCell;
import Model.LocationCellDetail;
import Model.PalletProduct;
import Model.Pallet_Product_Location;
import Model.PickingOrderDetail;
import Model.Product;
import Model.Rack;
import Model.Warehouse;
import Reportes.Frm_DispatchReport;
import dao.DaoClient;
import dao.DaoDistributionCenter;
import dao.DaoLocationCell;
import dao.DaoLocationCellDetail;
import dao.DaoPalletProduct;
import dao.DaoPallet_Product_Location;
import dao.DaoPickingOrderDetail;
import dao.DaoProducts;
import dao.DaoRack;
import dao.DaoWH;
import dao.impl.DaoClientImpl;
import dao.impl.DaoDistributionCenterImpl;
import dao.impl.DaoLocationCellDetailImpl;
import dao.impl.DaoLocationCellImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoPallet_Producto_LocationImpl;
import dao.impl.DaoPickingOrderDetailImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoRackImpl;
import dao.impl.DaoWHImpl;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author gzavala
 */
public class Frm_DispatchOrderDetail extends javax.swing.JFrame {

    /**
     * Creates new form Frm_DispatchOrderDetail
     */
    Frm_DispatchReport  menu_padre = new Frm_DispatchReport();   
    DispatchOrder objmodel= new DispatchOrder(); 
    DaoClient objclient= new DaoClientImpl();
    DefaultTableModel model = new DefaultTableModel();
    DaoPickingOrderDetail daoPickingOrderDetail = new DaoPickingOrderDetailImpl();
    DaoPallet_Product_Location daoPalletProductLocation = new DaoPallet_Producto_LocationImpl();
    DaoPalletProduct daoPalletProduct = new DaoPalletProductImpl();
    DaoProducts daoProduct = new DaoProdImpl();
    DaoWH daoWH = new DaoWHImpl();
    DaoDistributionCenter daoDistribution = new DaoDistributionCenterImpl();
    DaoRack daoRack = new DaoRackImpl();
    DaoLocationCell daoLocationCell = new DaoLocationCellImpl();
    DaoLocationCellDetail daoLocationCellDetail = new DaoLocationCellDetailImpl();
    

    private void fillTable(){
        List<PickingOrderDetail> list = daoPickingOrderDetail.pickingOrderDetailQry(objmodel.getIdPickingOrder());
        if(list!=null){
            int size = list.size();
            for(int i=0;i<size;i++){
                PickingOrderDetail poD = list.get(i);
                //EAN 128 - DESCRIPCION (PRODUCTO) - UBICACION - ESTADO - SELECCIONAR
                Pallet_Product_Location ppl = daoPalletProductLocation.daoPallet_Product_LocationGet(list.get(i).getIdPallet_By_Product_By_Location_Cell_Detail());
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
                if(poD.getDispatchStatus()==1)
                    nameState = "Entregado";
                else if(poD.getDispatchStatus()==2)
                    nameState = "Por Entregar";
                else if(poD.getDispatchStatus()==3)
                    nameState = "Devuelto a Almacén";
                Object[] fila = {ean128,desc,nameState};
                model.addRow(fila);
            }
        }
    }
    
    public Frm_DispatchOrderDetail( Frm_DispatchReport ventana,DispatchOrder dispatch ) {
        setTitle("Detalle Orden Despacho");
        menu_padre=ventana;
        objmodel=dispatch;
        initComponents();
        model = (DefaultTableModel)tbl_Dispatch.getModel();
        txt_numorden.setText(objmodel.getIdDispatch_Order().toString());
        txt_picking.setText(objmodel.getIdPickingOrder().toString());
        txt_client.setText(objclient.clientGet(objmodel.getIdClient()).getName()  );
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        pnl_cabecera = new javax.swing.JPanel();
        lbl_ordendespach = new javax.swing.JLabel();
        txt_numorden = new javax.swing.JTextField();
        lbl_picking = new javax.swing.JLabel();
        txt_picking = new javax.swing.JTextField();
        lbl_client = new javax.swing.JLabel();
        txt_client = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Dispatch = new javax.swing.JTable();
        btn_report = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_cabecera.setBorder(javax.swing.BorderFactory.createTitledBorder("Orden de Despacho"));

        lbl_ordendespach.setText("Orden de Despacho");

        txt_numorden.setEnabled(false);

        lbl_picking.setText("Número Picking");

        txt_picking.setToolTipText("");
        txt_picking.setEnabled(false);

        lbl_client.setText("Cliente");

        txt_client.setEnabled(false);

        javax.swing.GroupLayout pnl_cabeceraLayout = new javax.swing.GroupLayout(pnl_cabecera);
        pnl_cabecera.setLayout(pnl_cabeceraLayout);
        pnl_cabeceraLayout.setHorizontalGroup(
            pnl_cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_client, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_ordendespach, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_numorden, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(txt_client))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_picking, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_picking, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnl_cabeceraLayout.setVerticalGroup(
            pnl_cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_cabeceraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ordendespach)
                    .addComponent(txt_numorden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_picking)
                    .addComponent(txt_picking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_cabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_client)
                    .addComponent(txt_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        tbl_Dispatch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Pallet", "Descripcion", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_Dispatch);

        btn_report.setText("Generar Reporte");

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(btn_report)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_cabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_cabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel)
                    .addComponent(btn_report))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.dispose();
        menu_padre.setVisible(true);
    }//GEN-LAST:event_btn_cancelActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_report;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_client;
    private javax.swing.JLabel lbl_ordendespach;
    private javax.swing.JLabel lbl_picking;
    private javax.swing.JPanel pnl_cabecera;
    private javax.swing.JTable tbl_Dispatch;
    private javax.swing.JTextField txt_client;
    private javax.swing.JTextField txt_numorden;
    private javax.swing.JTextField txt_picking;
    // End of variables declaration//GEN-END:variables
}
