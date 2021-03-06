/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mantenimientos;

import Mantenimientos.Frm_PalletLocation;
import Mantenimientos.Frm_PalletLocation_Search;
import Model.Distribution_Center;
import Model.LocationCell;
import Model.PalletProduct;
import Model.PalletState;
import Model.Rack;
import Model.Trademark;
import Model.Warehouse;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoClient;
import dao.DaoDistributionCenter;
import dao.DaoPallet;
import dao.DaoPalletProduct;
import dao.DaoPalletState;
import dao.DaoProducts;
import dao.DaoTrademark;
import dao.DaoWH;
import dao.impl.DaoDistributionCenterImpl;
import dao.impl.DaoPalletImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoPalletStateImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoTrademarkImpl;
import dao.impl.DaoWHImpl;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/** 
 *
 * @author gzavala
 */
public class Frm_PalletLocation extends javax.swing.JFrame {

    Frm_PalletLocation_Search  ventprev = new Frm_PalletLocation_Search(); 
    Integer indsig=0; 
    Integer indcentrodistribucion=0; 
    Integer indalmacen=0; 
    Integer indrack=0; 
    Integer indcelda=0; 
    Integer inddetallecelda=0; 
    Integer indmarca=0; 
    Integer indpaso=0; 
    DaoDistributionCenter daoDC=new  DaoDistributionCenterImpl(); 
    DaoPallet daoPallet = new DaoPalletImpl();
    DaoPalletProduct daoPalletProduct= new DaoPalletProductImpl();
    String CadenaCD="";    
    String Cadenawarehouse="";
    String Cadenarack="";
    String Cadenacelda="";
    String Cadenadetallecelda="";
    String CboCD="";
    String Cboware="";
    String Cborack="";
    String Cbocelda="";
    String Cboceldadet="";
    
    
    public void llenatabla(String CadenaWhere)
    { 
      DaoPalletProduct objdao=new DaoPalletProductImpl();
      //obtiene los productos por pallet que no se encuentran asociados en una ubicacion
      Integer cantreg=objdao.GetPalletProductList2(CadenaWhere).size();
      PalletProduct[] list=new PalletProduct[cantreg];
      DefaultTableModel model= (DefaultTableModel)tbl_palletlocation.getModel(); 
      DaoPalletProduct objmarca=new DaoPalletProductImpl();
      DaoProducts objproduc= new DaoProdImpl();
      for (int i=0; i<cantreg; i++)
      { list[i]=objdao.GetPalletProductList2(CadenaWhere).get(i);
        model.addRow(new Object[]{list[i].getIdpallet(),
        objmarca.GetTradamarkid(list[i].getIdtrademark()).getName(),
        objmarca.GetProductId( list[i].getIdtrademark(),list[i].getIdproduct()).getName(),
        list[i].getNuminterna()});
      }     
    }       
    public void limpiatabla()
    {
        DefaultTableModel model= (DefaultTableModel)tbl_palletlocation.getModel(); 
        Integer cantreg=0; 
        cantreg=model.getRowCount();
        for(int i=0; i<cantreg; i++)       
        { model.removeRow(cantreg-i-1);
        }   
     }        
    public void load_tablefilter()
    { String Cadenawhere="  where status=1 ";
       limpiatabla();
       llenatabla(Cadenawhere);
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
      //cbo_locationcell_detail.addItem(" ");
      cbo_locationcell_detail.setSelectedIndex(0);
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
      cbo_location_cell.setSelectedIndex(0);
    }       
    public void  loadrack_CD(String cadena) //
    {   DaoPallet objdao=new DaoPalletImpl();
        Integer cantreg=objdao.RackQry(cadena).size();
        Rack[] list=new Rack[cantreg];
       for (int i=0; i<cantreg; i++)
        {  list[i]=objdao.RackQry(cadena).get(i);
           cbo_rack.addItem(list[i].getIdentifier());
        } 
      //cbo_rack.addItem(" ");
      cbo_rack.setSelectedIndex(0);
    } 
    public void loadalmacen_CD(String CenterD) //
    {   DaoPallet objdao=new DaoPalletImpl();
        Integer cantreg=objdao.WarehoseQry(CenterD).size();
        Warehouse[] list=new Warehouse[cantreg];
       for (int i=0; i<cantreg; i++)
        {  list[i]=objdao.WarehoseQry(CenterD).get(i);
           cbo_warehouse.addItem(list[i].getDescription());
        } 
      //cbo_warehouse.addItem(" ");
       cbo_warehouse.setSelectedIndex(0);
    }       
    public void limpiacombos()//
    { cbo_center_distribution.removeAllItems();
      cbo_warehouse.removeAllItems();  
      cbo_rack.removeAllItems();  
      cbo_location_cell.removeAllItems();  
      cbo_locationcell_detail.removeAllItems();  
     }       
    public void cargacentrodistribucion() //
    {  DaoPallet objdao=new DaoPalletImpl();
       Integer cantreg=objdao.CDQry().size();
       Distribution_Center[] list=new Distribution_Center[cantreg];
       for (int i=0; i<cantreg; i++)
       {  list[i]=objdao.CDQry().get(i);
          cbo_center_distribution.addItem(list[i].getName());
       } 
       cbo_center_distribution.addItem("");
       cbo_center_distribution.setSelectedIndex(0);
       indsig=cantreg; 
    }        
    public void load_parameter() //
    { limpiacombos();
      cargacentrodistribucion();
      indcentrodistribucion=1; 
     }       
    public  Frm_PalletLocation()
    {
    }
    
    public Frm_PalletLocation( Frm_PalletLocation_Search ventant) {
        setTitle("Datos del Pallet");
        ventprev = ventant;
        indpaso=0; 
        initComponents();
        load_parameter(); 
        if (indsig>0)
        { 
         indpaso=1;         
         btn_save.setEnabled(false);
        }    
        else
        { 
          String message = "No existen registros en la tabla Ubicacion de Celdas..por favor Validar...!!";
          String title = "Información";
          JFrame frame = new JFrame(" ");
          JOptionPane.showMessageDialog(frame,message,title,JOptionPane.WARNING_MESSAGE);
          JOptionPane.setDefaultLocale(null);               
          this.dispose();
          ventprev.setVisible(true);
          ventprev.inicia_formulario();
        }    
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
        lbl_CenterDistribution = new javax.swing.JLabel();
        cbo_center_distribution = new javax.swing.JComboBox();
        lbl_warehouse = new javax.swing.JLabel();
        cbo_warehouse = new javax.swing.JComboBox();
        lbl_rack = new javax.swing.JLabel();
        cbo_rack = new javax.swing.JComboBox();
        lbl_cell = new javax.swing.JLabel();
        cbo_location_cell = new javax.swing.JComboBox();
        lbl_date_to = new javax.swing.JLabel();
        cbo_locationcell_detail = new javax.swing.JComboBox();
        btn_search = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_palletlocation = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnl_pallet.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        lbl_CenterDistribution.setText("Centro de Distribución");

        cbo_center_distribution.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_center_distributionItemStateChanged(evt);
            }
        });

        lbl_warehouse.setText("Almacen");

        cbo_warehouse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_warehouseItemStateChanged(evt);
            }
        });

        lbl_rack.setText("Rack");

        cbo_rack.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_rackItemStateChanged(evt);
            }
        });

        lbl_cell.setText("Celda");

        cbo_location_cell.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_location_cellItemStateChanged(evt);
            }
        });

        lbl_date_to.setText("Detalle Celda");

        cbo_locationcell_detail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_locationcell_detailActionPerformed(evt);
            }
        });

        btn_search.setLabel("Buscar");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_palletLayout = new javax.swing.GroupLayout(pnl_pallet);
        pnl_pallet.setLayout(pnl_palletLayout);
        pnl_palletLayout.setHorizontalGroup(
            pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_palletLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_CenterDistribution, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_rack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_date_to, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbo_locationcell_detail, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_center_distribution, 0, 173, Short.MAX_VALUE)
                    .addComponent(cbo_rack, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_palletLayout.createSequentialGroup()
                        .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_cell, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_warehouse, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_warehouse, 0, 160, Short.MAX_VALUE)
                            .addComponent(cbo_location_cell, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        pnl_palletLayout.setVerticalGroup(
            pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_palletLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_CenterDistribution, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbo_center_distribution, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_warehouse)
                    .addComponent(cbo_warehouse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_rack, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_rack)
                    .addComponent(lbl_cell, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_location_cell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbo_locationcell_detail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_date_to))
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_save.setText("Guardar");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        tbl_palletlocation.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdPallet", "Marca", "Producto", "Num Internamiento", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_palletlocation);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_pallet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(btn_save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancel)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 709, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_pallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel)
                    .addComponent(btn_save))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        ventprev.setVisible(true);        
    }//GEN-LAST:event_formWindowClosed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
       DefaultTableModel modelo = (DefaultTableModel)tbl_palletlocation.getModel();
        List<Integer> listidpallet=new  ArrayList<Integer>();
        List<Integer> listidmarca= new ArrayList<Integer>();
        List<Integer> listidproduct= new ArrayList<Integer>();
        List<Integer> listnumorden= new ArrayList<Integer>();
        Integer idpallet;
        Integer idmarca;
        Integer idproduct;
        Integer numorden; 
        Integer cantreg=0; 
        Integer idcd=0; 
        Integer idware=0; 
        Integer idrack=0; 
        Integer idcelda=0; 
        Integer idceldadet=0; 
        
        int nr =modelo.getRowCount(); 
        for (int i=0; i<nr ;i++){
         try {   
         Object prueba =  modelo.getValueAt(i, 4);
             if ((Boolean)prueba)
             {
               idpallet=(Integer)modelo.getValueAt(i, 0);
               idmarca= daoPalletProduct.GetTrademarkname(modelo.getValueAt(i,1).toString().trim()).getId_Trademark();
               idproduct=daoPalletProduct.GetProduct(idmarca, modelo.getValueAt(i,2).toString().trim()).getIdProduct();
               numorden=(Integer)modelo.getValueAt(i, 3);
               listidpallet.add(idpallet);
               listidmarca.add(idmarca);
               listidproduct.add(idproduct);
               listnumorden.add(numorden);
               cantreg=cantreg+1; 
              } 
         }catch(Exception e)
          { }  
        }   
        if ((cantreg>1) ||(cantreg==0))           
        {
          String message = "Solo se debe seleccionar un pallet por producto..por favor Validar...!!";
          String title = "Información";
          JFrame frame = new JFrame(" ");
          JOptionPane.showMessageDialog(frame,message,title,JOptionPane.WARNING_MESSAGE);
          JOptionPane.setDefaultLocale(null);               
        }
        else 
        {
        String message = "¿Está seguro que desea agregar el pallet con el producto a la celda indicada?";
        String title = "Confirmación";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        JOptionPane.setDefaultLocale(null);
        
        if (reply == JOptionPane.YES_OPTION) 
          { 
            idpallet=listidpallet.get(0);
            idmarca=listidmarca.get(0);
            idproduct=listidproduct.get(0);
            numorden=listnumorden.get(0);
            idcd=daoDC.distribution_centerGet(cbo_center_distribution.getSelectedItem().toString().trim()).getIdDistribution_Center(); 
            idware=daoPallet.GetIdwarehouse(idcd, cbo_warehouse.getSelectedItem().toString().trim()); 
            idrack=daoPallet.GetIdRack(idcd, idware, cbo_rack.getSelectedItem().toString().trim()); 
            idcelda=daoPallet.GetIdCelda(idcd, idware, idrack, cbo_location_cell.getSelectedItem().toString().trim()); 
            idceldadet=daoPallet.GetIdCeldaDetail(idcd, idware, idrack, idcelda, cbo_locationcell_detail.getSelectedItem().toString().trim()); 
            Integer cantregistro=0; 
            
            cantregistro=daoPallet.ValidaCelda(idcd, idware, idrack, idcelda, idceldadet);
            
            if (cantregistro<=0)
            {daoPallet.PalletLocationIns(idpallet, idmarca, idproduct, numorden, idcd, idware, idrack, idcelda, idceldadet);}
            else
            { message = "La Celda Seleccionada ya se encuentra ocupada..por favor seleccione otra Celda!!";
              title = "Información";
              JFrame frame = new JFrame(" ");
              JOptionPane.showMessageDialog(frame,message,title,JOptionPane.WARNING_MESSAGE);
              JOptionPane.setDefaultLocale(null);               
            }    
            load_tablefilter();   
            
            
          }
        }
    }//GEN-LAST:event_btn_saveActionPerformed
    
    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.dispose();
        ventprev.setVisible(true);
        ventprev.load_table_filter();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void cbo_rackItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_rackItemStateChanged
    if (indsig>0)
    {
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
     }   
    }//GEN-LAST:event_cbo_rackItemStateChanged

    private void cbo_warehouseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_warehouseItemStateChanged
    if (indsig>0)
    { 
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
    }
    }//GEN-LAST:event_cbo_warehouseItemStateChanged

    private void cbo_center_distributionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_center_distributionItemStateChanged

    if (indsig>0)
    {    
      if (indcentrodistribucion==1)
      { try {      
         if (cbo_center_distribution.getSelectedItem().toString().trim().equals(null) || cbo_center_distribution.getSelectedItem().toString().trim().isEmpty())    
         { CadenaCD=" (1=1) "; }
         else 
         { CadenaCD=" idDistribution_Center="+ daoDC.distribution_centerGet(cbo_center_distribution.getSelectedItem().toString().trim()).getIdDistribution_Center()  +""; }    
       } catch(Exception e)
         {  } 
       indalmacen=1; 
       System.out.append("Paso por el evento del combo CD");
       cbo_warehouse.removeAllItems();
       loadalmacen_CD(CadenaCD);      
      } 
    }   
    }//GEN-LAST:event_cbo_center_distributionItemStateChanged

    private void cbo_locationcell_detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_locationcell_detailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_locationcell_detailActionPerformed

    private void cbo_location_cellItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_location_cellItemStateChanged
    if (indsig>0)
    {
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
    }
        
    }//GEN-LAST:event_cbo_location_cellItemStateChanged

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
     String CboCD="";
     String Cboware="";
     String Cborack="";
     String Cbocelda="";
     String Cboceldadet="";
     if (cbo_center_distribution.getSelectedItem().toString().trim().length()==0)
     {
        String message = "Debe seleccionar Un Centro de distribución..por favor Validar...!!";
        String title = "Información";
        JFrame frame = new JFrame(" ");
        JOptionPane.showMessageDialog(frame,message,title,JOptionPane.WARNING_MESSAGE);
        JOptionPane.setDefaultLocale(null);               
     }  
     else 
     {load_tablefilter();
      btn_save.setEnabled(true);
     }       
    }//GEN-LAST:event_btn_searchActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox cbo_center_distribution;
    private javax.swing.JComboBox cbo_location_cell;
    private javax.swing.JComboBox cbo_locationcell_detail;
    private javax.swing.JComboBox cbo_rack;
    private javax.swing.JComboBox cbo_warehouse;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_CenterDistribution;
    private javax.swing.JLabel lbl_cell;
    private javax.swing.JLabel lbl_date_to;
    private javax.swing.JLabel lbl_rack;
    private javax.swing.JLabel lbl_warehouse;
    private javax.swing.JPanel pnl_pallet;
    private javax.swing.JTable tbl_palletlocation;
    // End of variables declaration//GEN-END:variables
}
