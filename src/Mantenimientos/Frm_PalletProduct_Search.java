/*
    -- *******************************************************************
    -- Descripcion: Venta de Busqueda de PalletProduct
    --              
    -- Datos de Entrada: 
    --
    -- Datos de Salida:
    --
    -- Author          : GZAVALA
    -- Proyecto        : 
    -- RDC             : 
    -- Fecha Creacion  : 18/05/2015
    -- *************************************************************************
 */
package Mantenimientos;

import Mantenimientos.Frm_PalletProduct;
import Model.PalletProduct;
import Model.PalletState;
import Model.Product;
import Model.Trademark;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoPallet;
import dao.DaoPalletProduct;
import dao.DaoPalletState;
import dao.DaoProducts;
import dao.DaoTrademark;
import dao.impl.DaoPalletImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoPalletStateImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoTrademarkImpl;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author gzavala
 */
public class Frm_PalletProduct_Search extends javax.swing.JFrame 
{

    /**
     * Creates new form Frm_Pallet_Search
     */
    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();
    Integer indpaso; 
    DaoPalletProduct daoPalletProduct=new DaoPalletProductImpl();
    
    public Frm_PalletProduct_Search()
    {
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
    public void load_state()
    {
      cbo_status.removeAllItems();
      cbo_status.addItem("Activo");
      cbo_status.addItem("Inactivo");
      cbo_status.addItem(" ");
      cbo_status.setSelectedIndex(2);        
    }        
    
    public String armacadena_where()
    {
       String actividad="";
       String cadWhere="";
       Integer idpallet=0; 
       String Cadenawhere=""; 
        
        if( cbo_mark.getSelectedItem().toString().trim().equals(null)|| cbo_mark.getSelectedItem().toString().trim().isEmpty())
        { cadWhere="where  (1=1) and " ;}    
        else 
        {DaoPalletProduct dao=new DaoPalletProductImpl();
          cadWhere=" Product_Trademark_id_Trademark= "+dao.GetTrademarkname(cbo_mark.getSelectedItem().toString().trim()).getId_Trademark()+"  and " ;
        }    
        if( cbo_product.getSelectedItem().toString().trim().equals(null)|| cbo_product.getSelectedItem().toString().trim().isEmpty())
        { cadWhere=cadWhere+ " (1=1) and " ;}    
        else 
        {DaoPalletProduct dao=new DaoPalletProductImpl();
          cadWhere=cadWhere+ " Product_idProduct="+ dao.GetProduct(cbo_product.getSelectedItem().toString().trim()).getIdProduct()+" and " ;
          cadWhere= cadWhere+ " Product_Trademark_id_Trademark="+dao.GetProduct(cbo_product.getSelectedItem().toString().trim()).getTrademark() +" and "; 
        }    
        if (cbo_status.getSelectedItem().toString().trim().equals(null) || cbo_status.getSelectedItem().toString().trim().isEmpty())
        { cadWhere=cadWhere +" (1=1) and "; }   
        else if (cbo_status.getSelectedItem().toString().trim().equals("Activo"))
        { cadWhere=cadWhere +" status=1 and ";}       
        else if (cbo_status.getSelectedItem().toString().trim().equals("Inactivo"))
        { cadWhere=cadWhere+" status=0 and ";}       
   
       try{
          idpallet=Integer.parseInt(txt_pallet.getText().toString().trim());
          cadWhere=cadWhere+" Pallet_idPallet="+idpallet+"  ";
       }catch(Exception e)
       {  cadWhere=cadWhere+" (1=1)";
       }    
       
       return cadWhere; 
    }       
    public void llenatabla(String CadenaWhere)
    { DaoPalletProduct objdao=new DaoPalletProductImpl();
      Integer cantreg=objdao.GetPalletProductList(CadenaWhere).size();
      PalletProduct[] list=new PalletProduct[cantreg];
      DefaultTableModel model= (DefaultTableModel)tbl_palletproduct.getModel(); 
      DaoPalletProduct objmarca=new DaoPalletProductImpl();
      DaoProducts objproduc= new DaoProdImpl();
      String status="";
      for (int i=0; i<cantreg; i++)
      { list[i]=objdao.GetPalletProductList(CadenaWhere).get(i);
     
      if(list[i].getStatus()==1)
      { status="Activo";
      }
      else 
      { status="Inactivo";
        }    
        model.addRow(new Object[]{list[i].getIdpallet(),
        objmarca.GetTradamarkid(list[i].getIdtrademark()).getName(),
        objproduc.ProductsGet(list[i].getIdproduct()).getName(),
        status,list[i].getUser_created(),list[i].getUser_updated(),list[i].getCreated_at(),list[i].getUpdated_at()});
        }   
    }       

    public void limpiatabla()
    {
        DefaultTableModel model= (DefaultTableModel)tbl_palletproduct.getModel(); 
        Integer cantreg=0; 
        cantreg=model.getRowCount();
        for(int i=0; i<cantreg; i++)       
        { model.removeRow(cantreg-i-1);
        }   
     }        
     
    public void load_tablefilter()
    { String Cadenawhere="";
       limpiatabla();
       Cadenawhere= armacadena_where();
       llenatabla(Cadenawhere);
    }
        
   public Frm_PalletProduct_Search(Frm_MenuPrincipal menu) {
        setTitle("Mantenimiento de Pallet-Producto");
        menuaux = menu;
        indpaso=0; 
        initComponents();
        load_mark();
        load_product();
        indpaso=1; 
        load_state();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_palletproduct = new javax.swing.JPanel();
        btn_search = new javax.swing.JButton();
        cbo_mark = new javax.swing.JComboBox();
        lbl_product = new javax.swing.JLabel();
        lbl_marca = new javax.swing.JLabel();
        lbl_pallet = new javax.swing.JLabel();
        cbo_product = new javax.swing.JComboBox();
        txt_pallet = new javax.swing.JTextField();
        lbl_status = new javax.swing.JLabel();
        cbo_status = new javax.swing.JComboBox();
        btn_new = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_palletproduct = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_palletproduct.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios de Busqueda"));
        pnl_palletproduct.setToolTipText("");

        btn_search.setText("Buscar");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        cbo_mark.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cbo_mark.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_markItemStateChanged(evt);
            }
        });

        lbl_product.setText("Producto");

        lbl_marca.setText("Marca");

        lbl_pallet.setText("Id.Pallet");

        lbl_status.setText("Estado Actividad");

        javax.swing.GroupLayout pnl_palletproductLayout = new javax.swing.GroupLayout(pnl_palletproduct);
        pnl_palletproduct.setLayout(pnl_palletproductLayout);
        pnl_palletproductLayout.setHorizontalGroup(
            pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_palletproductLayout.createSequentialGroup()
                .addGroup(pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_palletproductLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_marca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_pallet, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbo_mark, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_pallet, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_status, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_product, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbo_status, 0, 166, Short.MAX_VALUE)
                            .addComponent(cbo_product, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_palletproductLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnl_palletproductLayout.setVerticalGroup(
            pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_palletproductLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_product)
                    .addComponent(lbl_marca)
                    .addComponent(cbo_mark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbo_product, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_pallet)
                    .addComponent(txt_pallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_status)
                    .addComponent(cbo_status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addContainerGap(20, Short.MAX_VALUE))
        );

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

        tbl_palletproduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id. Pallet", "Marca", "Producto", "Estado", "Seleccionar"
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
        jScrollPane1.setViewportView(tbl_palletproduct);
        if (tbl_palletproduct.getColumnModel().getColumnCount() > 0) {
            tbl_palletproduct.getColumnModel().getColumn(0).setPreferredWidth(25);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btn_new, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btn_delete)
                        .addGap(404, 404, 404)
                        .addComponent(btn_cancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnl_palletproduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 714, Short.MAX_VALUE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_palletproduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_new)
                    .addComponent(btn_delete)
                    .addComponent(btn_cancel))
                .addContainerGap())
        );

        pnl_palletproduct.getAccessibleContext().setAccessibleName("Criterios de búsqueda");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:   
        this.dispose();
        menuaux.setVisible(true);
        //inicia_estado_actividad();
        //inicia_estado_pallet();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        Frm_PalletProduct frm_pallet = new Frm_PalletProduct(this);
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

       DefaultTableModel modelo = (DefaultTableModel) tbl_palletproduct.getModel();
        List<Integer> listidpallet=new  ArrayList<Integer>();
        List<Integer> listidmarca= new ArrayList<Integer>();
        List<Integer> listidproduct= new ArrayList<Integer>();
        List<Integer>  listidstatus=new ArrayList<Integer>(); 
        Integer idpallet;
        Integer idmarca;
        Integer idproduct;
        Integer idstatus; 
        
        int nr =modelo.getRowCount(); 
        for (int i=0; i<nr ;i++){
            
         try {   
         Object prueba =  modelo.getValueAt(i, 8);
             if ((Boolean)prueba){
                //Integer numm= (Integer)modelo.getValueAt(i, 8);
               idpallet=(Integer)modelo.getValueAt(i, 0);
               idmarca= (Integer)daoPalletProduct.GetTrademarkname((String)modelo.getValueAt(i,1)).getId_Trademark();
               idproduct=(Integer)daoPalletProduct.GetProduct((String)modelo.getValueAt(i, 2)).getIdProduct();
               idstatus=0; 
               if (((String)modelo.getValueAt(i, 3)).equals("Inactivo"))
               { idstatus=0; 
               }   
               if (((String)modelo.getValueAt(i, 3)).equals("Activo"))
               { idstatus=1; 
               }   
               listidpallet.add(idpallet);
               listidmarca.add(idmarca);
               listidproduct.add(idproduct);
               listidstatus.add(idstatus);
               } 
         }catch(Exception e)
          { 
         }  
         
        }   
        //dao.usersDel(ids);        
        String message = "¿Está seguro que desea cambiar de estado a los registros seleccionados?";
        String title = "Confirmación";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        JOptionPane.setDefaultLocale(null);
        if (reply == JOptionPane.YES_OPTION) {
            daoPalletProduct.PalletProductDelMasive(listidpallet, listidmarca, listidproduct, listidstatus);
        }
        load_tablefilter();    

    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
       load_tablefilter();        
    }//GEN-LAST:event_btn_searchActionPerformed

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
       loadproduct_mark(marca);      
      }
// TODO add your handling code here:
    }//GEN-LAST:event_cbo_markItemStateChanged
    /*    */
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox cbo_mark;
    private javax.swing.JComboBox cbo_product;
    private javax.swing.JComboBox cbo_status;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_marca;
    private javax.swing.JLabel lbl_pallet;
    private javax.swing.JLabel lbl_product;
    private javax.swing.JLabel lbl_status;
    private javax.swing.JPanel pnl_palletproduct;
    private javax.swing.JTable tbl_palletproduct;
    private javax.swing.JTextField txt_pallet;
    // End of variables declaration//GEN-END:variables
}
