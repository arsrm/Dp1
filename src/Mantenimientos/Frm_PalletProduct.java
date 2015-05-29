/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mantenimientos;

import Seguridad.Frm_MenuPrincipal;
import Mantenimientos.Frm_PalletProduct_Search;
import Model.PalletIni;
import Model.Product;
import Model.Trademark;
import dao.DaoPalletIni;
import dao.DaoPalletProduct;
import dao.DaoProducts;
import dao.DaoTrademark;
import dao.impl.DaoPalletIniImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoTrademarkImpl;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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

        javax.swing.GroupLayout pnl_palletproductLayout = new javax.swing.GroupLayout(pnl_palletproduct);
        pnl_palletproduct.setLayout(pnl_palletproductLayout);
        pnl_palletproductLayout.setHorizontalGroup(
            pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_palletproductLayout.createSequentialGroup()
                .addGroup(pnl_palletproductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnl_palletproductLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_palletproductLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbl_marca, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbo_mark, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
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
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        tbl_pallet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdPallet", "Descripcion", "Fecha Creacion", "Fecha Modificacion", "UsuarioCreacion", "Usuario Modificacion", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
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
        loadproduct_mark(marca);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_markItemStateChanged

    public void load_tablefilter()
    { 
    }        
    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        load_tablefilter();
    }//GEN-LAST:event_btn_searchActionPerformed

    private void tbl_palletMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_palletMouseClicked

    }//GEN-LAST:event_tbl_palletMouseClicked

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed

         String message = "¿Está seguro que realizar el registro del Nuevo Pallet?";
         String title = "Confirmar! ";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        JOptionPane.setDefaultLocale(null);
        if (reply == JOptionPane.YES_OPTION) 
        { //daopalletini.PalletIniIns(objpalletini);
          this.dispose();
          ventprev.setVisible(true);
        }

    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
        ventprev.setVisible(true);

    }//GEN-LAST:event_btn_cancelActionPerformed

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
    private javax.swing.JLabel lbl_product;
    private javax.swing.JPanel pnl_palletproduct;
    private javax.swing.JScrollPane scrl_pallet;
    private javax.swing.JTable tbl_pallet;
    // End of variables declaration//GEN-END:variables
}
