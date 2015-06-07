/*
    -- *******************************************************************
    -- Descripcion: Venta de Busqueda de PalletProducto_Location
    --              
    -- Datos de Entrada: 
    --
    -- Datos de Salida:
    --
    -- Author          : GZAVALA
    -- Proyecto        : 
    -- RDC             : 
    -- Fecha Creacion  : 24/05/2015
    -- *************************************************************************
 */
package Mantenimientos;

import Mantenimientos.Frm_PalletLocation;
import Model.Distribution_Center;
import Model.LocationCell;
import Model.PalletState;
import Model.Product;
import Model.Rack;
import Model.Trademark;
import Model.Warehouse;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoDistributionCenter;
import dao.DaoPallet;
import dao.DaoPalletProduct;
import dao.DaoPalletState;
import dao.DaoProducts;
import dao.DaoTrademark;
import dao.impl.DaoDistributionCenterImpl;
import dao.impl.DaoPalletImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoPalletStateImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoTrademarkImpl;
import java.util.*;
/**
 *
 * @author gzavala
 */
public class Frm_PalletLocation_Search extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Pallet_Search
     */
    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();
    Integer indcentrodistribucion=0; 
    Integer indalmacen=0; 
    Integer indrack=0; 
    Integer indcelda=0; 
    Integer inddetallecelda=0; 
    Integer indmarca=0; 
    Integer indpaso=0; 
    DaoDistributionCenter daoDC=new  DaoDistributionCenterImpl(); 
    DaoPallet daoPallet = new DaoPalletImpl();
    String CadenaCD="";    
    String Cadenawarehouse="";
    String Cadenarack="";
    String Cadenacelda="";
    String Cadenadetallecelda="";

    public void load_state()
    {
      cbo_state.removeAllItems();
      cbo_state.addItem("Activo");
      cbo_state.addItem("Inactivo");
      cbo_state.addItem(" ");
      cbo_state.setSelectedIndex(2);        
    }        
    public void load_mark()
    { 
        cbo_mark.removeAllItems();
        DaoTrademark objdao=new DaoTrademarkImpl();
        Integer cantreg=objdao.TrademarkQry().size();
        Trademark[] list=new Trademark[cantreg];
       for (int i=0; i<cantreg; i++)
       {  list[i]=objdao.TrademarkQry().get(i);
          // Se agregan los status activos
           cbo_mark.addItem(list[i].getName());
       }   
       cbo_mark.addItem(" ");
       cbo_mark.setSelectedIndex(cantreg);
    }       
    public void load_product()
    {
        cbo_product.removeAllItems();
        DaoProducts objdao=new DaoProdImpl();
        Integer cantreg=objdao.ProductsQry().size();
        Product[] list=new Product[cantreg];
       for (int i=0; i<cantreg; i++)
       {  list[i]=objdao.ProductsQry().get(i);
          // Se agregan los status activos
           if(list[i].getStatus()==1)
           {cbo_product.addItem(list[i].getName());
           }
       }   
       cbo_product.addItem(" ");
       cbo_product.setSelectedIndex(cantreg);
    }
    public void load_product(String marca)
    {   Trademark objmodel=new Trademark();
        DaoPalletProduct daomark= new DaoPalletProductImpl();
        objmodel=daomark.GetTrademarkname(marca); 
        cbo_product.removeAllItems();
        DaoPalletProduct objdao=new DaoPalletProductImpl();
        Integer cantreg=objdao.GetProductList(objmodel.getId_Trademark()).size();
        Product[] list=new Product[cantreg];
       for (int i=0; i<cantreg; i++)
       {  list[i]=objdao.GetProductList(objmodel.getId_Trademark()).get(i);
          // Se agregan los status activos
           if(list[i].getStatus()==1)
           {cbo_product.addItem(list[i].getName());
           }
       }   
       cbo_product.addItem(" ");
       cbo_product.setSelectedIndex(cantreg);
      
    }        
    public void loadproduct_mark(String marca)    
    { if (marca.isEmpty())
      { load_product();}   
      else 
      { load_product(marca);  
       }
    }       
    public void inicia_estado_pallet()
    { 
    }        
    public void limpiacombos()//
    { cbo_center_distribution.removeAllItems();
      cbo_warehouse.removeAllItems();  
      cbo_rack.removeAllItems();  
      cbo_location_cell.removeAllItems();  
      cbo_locationcell_detail.removeAllItems();  
      cbo_state.removeAllItems();  
      cbo_mark.removeAllItems();  
      cbo_mark.removeAllItems();  
      cbo_product.removeAllItems();  
     }       
    public void cargacentrodistribucion() //
    {
        DaoPallet objdao=new DaoPalletImpl();
        Integer cantreg=objdao.CDQry().size();
        Distribution_Center[] list=new Distribution_Center[cantreg];
       for (int i=0; i<cantreg; i++)
       {  list[i]=objdao.CDQry().get(i);
          cbo_center_distribution.addItem(list[i].getName());
       } 
      cbo_center_distribution.addItem(" ");
      cbo_center_distribution.setSelectedIndex(cantreg);
      
    }        
    public void loadalmacen_CD(String CenterD) //
    { 
        DaoPallet objdao=new DaoPalletImpl();
        Integer cantreg=objdao.WarehoseQry(CenterD).size();
        Warehouse[] list=new Warehouse[cantreg];
       for (int i=0; i<cantreg; i++)
        {  list[i]=objdao.WarehoseQry(CenterD).get(i);
           cbo_warehouse.addItem(list[i].getDescription());
        } 
      cbo_warehouse.addItem(" ");
      cbo_warehouse.setSelectedIndex(cantreg);
    }       
    public void  loadrack_CD(String cadena) //
    {
        DaoPallet objdao=new DaoPalletImpl();
        Integer cantreg=objdao.RackQry(cadena).size();
        Rack[] list=new Rack[cantreg];
       for (int i=0; i<cantreg; i++)
        {  list[i]=objdao.RackQry(cadena).get(i);
           cbo_rack.addItem(list[i].getIdentifier());
        } 
      cbo_rack.addItem(" ");
      cbo_rack.setSelectedIndex(cantreg);
    } 
    public void  loadcelda(String cadrack) //     
    {
        DaoPallet objdao=new DaoPalletImpl();
        Integer cantreg=objdao.CeldaQry(cadrack).size();
        String[] list=new String[cantreg];
       for (int i=0; i<cantreg; i++)
        {  list[i]=objdao.CeldaQry(cadrack).get(i);
           cbo_location_cell.addItem(list[i].toString());
        } 
      cbo_location_cell.addItem(" ");
      cbo_location_cell.setSelectedIndex(cantreg);
    }       
    public void  loadceldadetalle(String Cadenacelda)//          
    { 
        DaoPallet objdao=new DaoPalletImpl();
        Integer cantreg=objdao.DetalleCeldaQry(Cadenacelda).size();
        String[] list=new String[cantreg];
       for (int i=0; i<cantreg; i++)
        {  list[i]=objdao.DetalleCeldaQry(Cadenacelda).get(i);
           cbo_locationcell_detail.addItem(list[i].toString());
        } 
      cbo_locationcell_detail.addItem(" ");
      cbo_locationcell_detail.setSelectedIndex(cantreg);

        
    }        
    public void load_parameter() //
    { limpiacombos();
      cargacentrodistribucion();
      indcentrodistribucion=1; 
      
     }       
    public void inicia_formulario()
    {
        setTitle("Mantenimiento de Pallet");
        indpaso=0; 
        initComponents();
        load_parameter();
        load_state();
        load_mark();
        load_product();
        indpaso=1;         
    }        
    public Frm_PalletLocation_Search()
    {
     }       
    public Frm_PalletLocation_Search(Frm_MenuPrincipal menu) {
        menuaux = menu;
        inicia_formulario();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_pallet = new javax.swing.JPanel();
        btn_search = new javax.swing.JButton();
        lbl_CenterDistribution = new javax.swing.JLabel();
        lbl_warehouse = new javax.swing.JLabel();
        lbl_rack = new javax.swing.JLabel();
        lbl_cell = new javax.swing.JLabel();
        lbl_date_to = new javax.swing.JLabel();
        lbl_status = new javax.swing.JLabel();
        cbo_state = new javax.swing.JComboBox();
        cbo_warehouse = new javax.swing.JComboBox();
        cbo_rack = new javax.swing.JComboBox();
        cbo_location_cell = new javax.swing.JComboBox();
        cbo_locationcell_detail = new javax.swing.JComboBox();
        lbl_marca = new javax.swing.JLabel();
        cbo_mark = new javax.swing.JComboBox();
        lbl_product = new javax.swing.JLabel();
        cbo_product = new javax.swing.JComboBox();
        cbo_center_distribution = new javax.swing.JComboBox();
        scrl_pallet = new javax.swing.JScrollPane();
        tbl_pallet_detail = new javax.swing.JTable();
        btn_new = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        lbl_fechaini = new javax.swing.JLabel();
        lbl_fechafin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_pallet.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios de Busqueda"));
        pnl_pallet.setToolTipText("");

        btn_search.setText("Buscar");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        lbl_CenterDistribution.setText("Centro de Distribución");

        lbl_warehouse.setText("Almacen");

        lbl_rack.setText("Rack");

        lbl_cell.setText("Celda");

        lbl_date_to.setText("Detalle Celda");

        lbl_status.setText("Estado Ubicacion");

        cbo_warehouse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_warehouseItemStateChanged(evt);
            }
        });

        cbo_rack.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_rackItemStateChanged(evt);
            }
        });

        cbo_location_cell.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_location_cellItemStateChanged(evt);
            }
        });

        cbo_locationcell_detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_locationcell_detailActionPerformed(evt);
            }
        });

        lbl_marca.setText("Marca");

        cbo_mark.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_markItemStateChanged(evt);
            }
        });

        lbl_product.setText("Producto");

        cbo_center_distribution.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_center_distributionItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnl_palletLayout = new javax.swing.GroupLayout(pnl_pallet);
        pnl_pallet.setLayout(pnl_palletLayout);
        pnl_palletLayout.setHorizontalGroup(
            pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_palletLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_CenterDistribution, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                    .addComponent(lbl_rack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_date_to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_marca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbo_rack, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_locationcell_detail, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_mark, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_center_distribution, 0, 189, Short.MAX_VALUE))
                .addGap(48, 48, 48)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_palletLayout.createSequentialGroup()
                        .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_warehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(lbl_cell, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_status, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_product, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbo_location_cell, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbo_warehouse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbo_state, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbo_product, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(33, 33, 33))
        );
        pnl_palletLayout.setVerticalGroup(
            pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_palletLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_warehouse)
                    .addComponent(lbl_CenterDistribution, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_warehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_center_distribution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_rack)
                    .addComponent(cbo_rack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_cell)
                    .addComponent(cbo_location_cell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbo_locationcell_detail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_date_to)
                    .addComponent(lbl_status)
                    .addComponent(cbo_state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_marca)
                    .addComponent(cbo_mark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_product)
                    .addComponent(cbo_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbl_pallet_detail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdPallet", "Marca", "Producto", "Almacen", "Rack", "Celda", "Estado Actividad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrl_pallet.setViewportView(tbl_pallet_detail);

        btn_new.setText("Nuevo");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_fechaini, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267)
                        .addComponent(lbl_fechafin, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(263, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cancel)
                        .addGap(28, 28, 28))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_pallet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrl_pallet, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_pallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrl_pallet, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lbl_fechafin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_fechaini)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_delete)
                        .addComponent(btn_new)
                        .addComponent(btn_cancel)))
                .addContainerGap())
        );

        pnl_pallet.getAccessibleContext().setAccessibleName("Criterios de búsqueda");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:   
        this.dispose();
        menuaux.setVisible(true);

    }//GEN-LAST:event_formWindowClosed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        Frm_PalletLocation frm_pallet = new Frm_PalletLocation(this);
        frm_pallet.setVisible(true);
        frm_pallet.setLocationRelativeTo(null);
        this.setVisible(false);  
    }//GEN-LAST:event_btn_newActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_searchActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void cbo_locationcell_detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_locationcell_detailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_locationcell_detailActionPerformed

    //
    private void cbo_center_distributionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_center_distributionItemStateChanged

      if (indcentrodistribucion==1)
      { try {      
         if (cbo_center_distribution.getSelectedItem().toString().trim().equals(null) || cbo_center_distribution.getSelectedItem().toString().trim().isEmpty())    
         { CadenaCD=" (1=1) "; }
         else 
         { CadenaCD=" idDistribution_Center="+ daoDC.distribution_centerGet(cbo_center_distribution.getSelectedItem().toString().trim()).getIdDistribution_Center()  +""; }    
       } catch(Exception e)
         {  } 
       indalmacen=1; 
       cbo_warehouse.removeAllItems();
       loadalmacen_CD(CadenaCD);      
      }

    }//GEN-LAST:event_cbo_center_distributionItemStateChanged
    //
    private void cbo_warehouseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_warehouseItemStateChanged
                
      if (indalmacen==1)
      { try {      

          if (cbo_warehouse.getSelectedItem().toString().trim().equals(null) || cbo_warehouse.getSelectedItem().toString().trim().isEmpty())    
         { Cadenawarehouse=CadenaCD+ " and (1=1) ";}
         else 
         { Cadenawarehouse= CadenaCD+ " and idDistribution_Center="+ daoPallet.Warehousename(cbo_warehouse.getSelectedItem().toString().trim()).getDistribution_Center_idDistribution_Center()+"  ";
           Cadenawarehouse= Cadenawarehouse+ "  and Location_Cell_Rack_Warehouse_idWarehouse="+daoPallet.Warehousename(cbo_warehouse.getSelectedItem().toString().trim()).getIdWarehouse() +"";
          }    
       
      } catch(Exception e)
       {  } 
       indrack=1; 
       cbo_rack.removeAllItems();
       loadrack_CD(Cadenawarehouse);      
      
      }

    }//GEN-LAST:event_cbo_warehouseItemStateChanged
    //
    private void cbo_rackItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_rackItemStateChanged

      if (indrack==1)
      { try {      
          if (cbo_rack.getSelectedItem().toString().trim().equals(null) || cbo_rack.getSelectedItem().toString().trim().isEmpty())    
         { Cadenarack= Cadenawarehouse+" and (1=1) ";}
         else 
         { Cadenarack= Cadenawarehouse+ " and Location_Cell_Rack_idRack="+ daoPallet.Rackid(cbo_rack.getSelectedItem().toString().trim()).getIdRack() +"  ";
          }    
      } catch(Exception e)
       {  } 
       indcelda=1; 
       cbo_location_cell.removeAllItems();
       loadcelda(Cadenarack);      
      }
    }//GEN-LAST:event_cbo_rackItemStateChanged

    private void cbo_location_cellItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_location_cellItemStateChanged

      if (indcelda==1)
      { try {      
          if (cbo_location_cell.getSelectedItem().toString().trim().equals(null) || cbo_location_cell.getSelectedItem().toString().trim().isEmpty())    
         { Cadenacelda= Cadenarack+" and (1=1) ";}
         else 
         { Cadenacelda= Cadenarack+ " and Location_Cell_idLocation_Cell="+ daoPallet.LocationCellid(cbo_location_cell.getSelectedItem().toString().trim()).getIdLocation_Cell()  +"  ";
          }    
      } catch(Exception e)
       {  } 
       inddetallecelda=1; 
       cbo_locationcell_detail.removeAllItems();
       loadceldadetalle(Cadenacelda);      
      }
    }//GEN-LAST:event_cbo_location_cellItemStateChanged

    private void cbo_markItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_markItemStateChanged
      String marca="";
      if (indpaso==1)
      { try {      
         if (cbo_mark.getSelectedItem().toString().trim().equals(null) || cbo_mark.getSelectedItem().toString().trim().isEmpty())    
         { marca="";}
         else 
         { marca=cbo_mark.getSelectedItem().toString().trim(); }    
       } catch(Exception e)
         {  } 
       cbo_product.removeAllItems();
       loadproduct_mark(marca);      
      }
// TODO add your handling code here:
    }//GEN-LAST:event_cbo_markItemStateChanged
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox cbo_center_distribution;
    private javax.swing.JComboBox cbo_location_cell;
    private javax.swing.JComboBox cbo_locationcell_detail;
    private javax.swing.JComboBox cbo_mark;
    private javax.swing.JComboBox cbo_product;
    private javax.swing.JComboBox cbo_rack;
    private javax.swing.JComboBox cbo_state;
    private javax.swing.JComboBox cbo_warehouse;
    private javax.swing.JLabel lbl_CenterDistribution;
    private javax.swing.JLabel lbl_cell;
    private javax.swing.JLabel lbl_date_to;
    private javax.swing.JLabel lbl_fechafin;
    private javax.swing.JLabel lbl_fechaini;
    private javax.swing.JLabel lbl_marca;
    private javax.swing.JLabel lbl_product;
    private javax.swing.JLabel lbl_rack;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JLabel lbl_warehouse;
    private javax.swing.JPanel pnl_pallet;
    private javax.swing.JScrollPane scrl_pallet;
    private javax.swing.JTable tbl_pallet_detail;
    // End of variables declaration//GEN-END:variables
}
