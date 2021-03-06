/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mantenimientos;

import Mantenimientos.Frm_PalletProduct_Search;
import Model.InternmentOrder;
import Model.Pallet;
import Model.PalletIni;
import Model.PalletProduct;
import Model.Product;
import Model.Trademark;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoInternmentOrder;
import dao.DaoPallet;
import dao.DaoPalletIni;
import dao.DaoPalletProduct;
import dao.DaoProducts;
import dao.DaoTrademark;
import dao.impl.DaoInternmentOrderImpl;
import dao.impl.DaoPalletImpl;
import dao.impl.DaoPalletIniImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoTrademarkImpl;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
//import java.sql.Date;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/** 
 *
 * @author gzavala
 */
public class Frm_PalletProduct extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Pallet
     */
    Frm_PalletProduct_Search  ventprev = new Frm_PalletProduct_Search(); 
    Integer indpaso=0; 
    InternmentOrder objmodelinternamiento; 
    Product modelproduct; 
    
    
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
       cbo_mark.setSelectedIndex(cantreg-1);
        
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
       cbo_product.setSelectedIndex(cantreg-1);
        
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
       cbo_product.setSelectedIndex(cantreg-1);
    }        
    
    public  void loadproduct_mark(String marca)
    { if (marca.isEmpty())
      { load_product();}   
      else 
      { load_product(marca);  
       }
     } 
    public Frm_PalletProduct( Frm_PalletProduct_Search ventant) {
        setTitle("Datos del Pallet");
        ventprev = ventant;
        indpaso=0;         
        initComponents();
        load_mark();
        load_product();
        indpaso=1; 
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
        cbo_product = new javax.swing.JComboBox();
        lbl_ordinter = new javax.swing.JLabel();
        txt_ordintern = new javax.swing.JTextField();
        scrl_pallet = new javax.swing.JScrollPane();
        tbl_pallet = new javax.swing.JTable();
        btn_cancel = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnl_palletproduct.setBorder(javax.swing.BorderFactory.createTitledBorder("Asignación Pallet Producto"));
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

        lbl_ordinter.setText("Orden de Intern");

        txt_ordintern.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_ordinternFocusLost(evt);
            }
        });
        txt_ordintern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ordinternActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_palletproductLayout = new javax.swing.GroupLayout(pnl_palletproduct);
        pnl_palletproduct.setLayout(pnl_palletproductLayout);
        pnl_palletproductLayout.setHorizontalGroup(
            pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_palletproductLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_palletproductLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_palletproductLayout.createSequentialGroup()
                        .addGroup(pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_palletproductLayout.createSequentialGroup()
                                .addComponent(lbl_ordinter, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txt_ordintern))
                            .addGroup(pnl_palletproductLayout.createSequentialGroup()
                                .addComponent(lbl_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(cbo_mark, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addComponent(lbl_product, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_product, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
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
                .addGap(24, 24, 24)
                .addGroup(pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ordinter)
                    .addComponent(txt_ordintern, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_search))
        );

        tbl_pallet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdPallet", "Descripcion", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_pallet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_palletMouseClicked(evt);
            }
        });
        scrl_pallet.setViewportView(tbl_pallet);

        btn_cancel.setText("Cancelar");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        btn_save.setText("Guardar");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_palletproduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrl_pallet))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btn_save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancel)
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_palletproduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrl_pallet, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel)
                    .addComponent(btn_save))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        ventprev.setVisible(true);        
    }//GEN-LAST:event_formWindowClosed
   
    public void limpiatabla()
    {
        DefaultTableModel model= (DefaultTableModel)tbl_pallet.getModel(); 
        Integer cantreg=0; 
        cantreg=model.getRowCount();
        for(int i=0; i<cantreg; i++)       
        { model.removeRow(cantreg-i-1);
        }   
    
    }       
     
    public void llenatabla()
    { DaoPalletIni objdao=new DaoPalletIniImpl();
      Integer cantreg=objdao.PalletIniQry().size();
      PalletIni[] list=new PalletIni[cantreg];
      DefaultTableModel model= (DefaultTableModel)tbl_pallet.getModel(); 
      for (int i=0; i<cantreg; i++)
      { list[i]=objdao.PalletIniQry().get(i);
          
        //Solo se mostrarán los pallet activos disponibles id estado pallet=2 disponible
        if (list[i].getStatuspallet()==2 && list[i].getStatusactividad()==1)
        { model.addRow(new Object[]{list[i].getIdpallet(),list[i].getDescription() });
        }
      }   
    }       

    public boolean validanumorden()
    { boolean b=true; 

      Integer numorden=0; 
      
      if ( (txt_ordintern.getText().toString().isEmpty() )|| (txt_ordintern.getText().equals(null) ) )
      { b=false;}   
      else 
      {
       try{
        numorden=Integer.parseInt(txt_ordintern.getText()); 
          
          DaoInternmentOrder dao=new DaoInternmentOrderImpl();
          objmodelinternamiento= dao.IntOrderGet(numorden);
          if ( (objmodelinternamiento==null)||dao.IntOrderGet(numorden).getStatus()==0 )
          {String message = "El numero de Orden de Internamiento no existe o está inactiva";
          String title = "Información";
          JFrame frame = new JFrame(" ");
          JOptionPane.showMessageDialog(frame,message,title,JOptionPane.WARNING_MESSAGE);
          JOptionPane.setDefaultLocale(null);   
          b=false;
          }
      }catch(Exception e)
      {   String message = "El numero de Orden debe ser Entero";
          String title = "Información";
          JFrame frame = new JFrame(" ");
          JOptionPane.showMessageDialog(frame,message,title,JOptionPane.WARNING_MESSAGE);
          JOptionPane.setDefaultLocale(null);
          b=false;
      }   
    }
    return b;      
    }        
    
    public boolean validaprod()
    {  String marca="";
       String product="";
     try  
     { marca=cbo_mark.getSelectedItem().toString().trim();
       product=cbo_product.getSelectedItem().toString().trim();
       return true;
     }
     catch(Exception e)
     { return false; 
       }   
    } 
    
    private void cbo_markItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_markItemStateChanged
        String marca="";
        if (indpaso==1)
        { try{
              if (cbo_mark.getSelectedItem().toString().trim().equals(null) || cbo_mark.getSelectedItem().toString().trim().isEmpty())
                { marca="";}
                else
                { marca=cbo_mark.getSelectedItem().toString().trim(); }
            }catch(Exception e)
               {  }
       cbo_product.removeAllItems();
        loadproduct_mark(marca);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_markItemStateChanged

    public void load_tablefilter()
    { String Cadenawhere="";
       limpiatabla();
       Cadenawhere= " Where (1=1)";
       llenatabla();
    }        
    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        load_tablefilter();
    }//GEN-LAST:event_btn_searchActionPerformed

    private void tbl_palletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_palletMouseClicked

    }//GEN-LAST:event_tbl_palletMouseClicked

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed

       DefaultTableModel modelo = (DefaultTableModel) tbl_pallet.getModel();
        List<Integer> listidpallet=new  ArrayList<Integer>();
        List<Integer>  listidstatus=new ArrayList<Integer>(); 
        Integer idpallet;
        Integer idmarca;
        Integer idproduct;
        Integer idstatus; 
        boolean valnumord; 
        boolean valprod; 
        
        Date expirationDate = new Date(System.currentTimeMillis()); // tendra la fecha de la orden de internamiento
        Integer timexpiration=7;  //corresponde a la cantidad de dias en las que expira un producto
        Integer idIntOrd; 
    
        valnumord=validanumorden();
        if (valnumord)
        {
        valprod=validaprod(); //valida los campos productos

        if (valprod)
        {

        int nr =modelo.getRowCount(); 

        DaoPalletProduct daoPalletProduct =new DaoPalletProductImpl(); 
        idmarca= daoPalletProduct.GetTrademarkname(cbo_mark.getSelectedItem().toString()).getId_Trademark();
        idproduct=daoPalletProduct.GetProduct(idmarca, cbo_product.getSelectedItem().toString()).getIdProduct();
        idIntOrd= Integer.parseInt(txt_ordintern.getText().toString().trim());

        timexpiration=daoPalletProduct.GetProduct(idmarca, cbo_product.getSelectedItem().toString().trim()).getTimeExpiration();
        DaoInternmentOrder dao= new DaoInternmentOrderImpl();
        expirationDate=dao.IntOrderGet(idIntOrd).getDate();
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(expirationDate);
        calendar.add(Calendar.DAY_OF_YEAR, timexpiration);
        expirationDate=(Date) calendar.getTime(); 
        
        for (int i=0; i<nr ;i++)
        {
         try {   
         Object prueba =  modelo.getValueAt(i, 2);
             if ((Boolean)prueba){
                //Integer numm= (Integer)modelo.getValueAt(i, 8);
               idpallet=(Integer)modelo.getValueAt(i, 0);
               listidpallet.add(idpallet);
               } 
         }catch(Exception e)
          { }  
        }   
        //dao.usersDel(ids);        
        String message = "¿Está seguro que desea asignar los pallets seleccionados al producto?";
        String title = "Confirmación";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        JOptionPane.setDefaultLocale(null);
        if (reply == JOptionPane.YES_OPTION) {
            daoPalletProduct.PalletProductInsMasive(listidpallet, idmarca, idproduct,expirationDate,idIntOrd);
        }
        load_tablefilter();    
        }
       else
        {
          String message = "Debe Ingresar un producto existente..";
          String title = "Información";
          JFrame frame = new JFrame(" ");
          JOptionPane.showMessageDialog(frame,message,title,JOptionPane.WARNING_MESSAGE);
          JOptionPane.setDefaultLocale(null);
        }    
        
      }
        
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ventprev.setVisible(true);

    }//GEN-LAST:event_btn_cancelActionPerformed

    private void txt_ordinternFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ordinternFocusLost
      boolean b=false;
       b=validanumorden();
       if (b)
       {System.out.println("Valido correctamente la orden de internamiento");  
       }

    }//GEN-LAST:event_txt_ordinternFocusLost

    private void txt_ordinternActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ordinternActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ordinternActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox cbo_mark;
    private javax.swing.JComboBox cbo_product;
    private javax.swing.JLabel lbl_marca;
    private javax.swing.JLabel lbl_ordinter;
    private javax.swing.JLabel lbl_product;
    private javax.swing.JPanel pnl_palletproduct;
    private javax.swing.JScrollPane scrl_pallet;
    private javax.swing.JTable tbl_pallet;
    private javax.swing.JTextField txt_ordintern;
    // End of variables declaration//GEN-END:variables
}
