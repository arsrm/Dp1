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

import Mantenimientos.Frm_Pallet;
import Model.PalletState;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoPallet;
import dao.DaoPalletState;
import dao.impl.DaoPalletImpl;
import dao.impl.DaoPalletStateImpl;
import java.util.*;
/**
 *
 * @author gzavala
 */
public class Frm_Pallet_Search extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Pallet_Search
     */
    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();

    public void inicia_estado_actividad()
    { cbo_pallet_act.addItem("Activo");
      cbo_pallet_act.addItem("Inactivo");
      cbo_pallet_act.addItem(" ");
      cbo_pallet_act.setSelectedIndex(-1);
     }       
    public void inicia_estado_pallet()
    { 
      DaoPalletState objdao=new DaoPalletStateImpl(); 
      Integer cantreg= objdao.PalletStateQry().size();
      PalletState[] list=new PalletState[cantreg];
       for (int i=0; i<cantreg; i++)
       {  list[i]=objdao.PalletStateQry().get(i);
          // Se agregan los status activos
          if (list[i].getStatus()==1)
          { cbo_pallet_state.addItem(list[i].getDescription());
          }
       }   
      cbo_pallet_state.addItem(" ");
      cbo_pallet_state.setSelectedIndex(-1);
    }        
    
    
    public Frm_Pallet_Search()
    {
     }       
    public Frm_Pallet_Search(Frm_MenuPrincipal menu) {
        setTitle("Mantenimiento de Pallet");
        menuaux = menu;
        initComponents();
        inicia_estado_actividad();
        inicia_estado_pallet();
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
        cbo_pallet_act = new javax.swing.JComboBox();
        lbl_id_pallet = new javax.swing.JLabel();
        txt_id_pallet = new javax.swing.JTextField();
        lbl_ean = new javax.swing.JLabel();
        txt_ean = new javax.swing.JTextField();
        lbl_status_act = new javax.swing.JLabel();
        lbl_id_rack = new javax.swing.JLabel();
        txt_id_rack = new javax.swing.JTextField();
        lbl_id_cell = new javax.swing.JLabel();
        txt_id_cell = new javax.swing.JTextField();
        lbl_date_from = new javax.swing.JLabel();
        dch_date_from = new com.toedter.calendar.JDateChooser();
        lbl_date_to = new javax.swing.JLabel();
        dch_date_to = new com.toedter.calendar.JDateChooser();
        lbl_status_pallet = new javax.swing.JLabel();
        cbo_pallet_state = new javax.swing.JComboBox();
        scrl_pallet = new javax.swing.JScrollPane();
        tbl_pallet = new javax.swing.JTable();
        btn_new = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        lbl_fechaini = new javax.swing.JLabel();
        lbl_fechafin = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
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

        cbo_pallet_act.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        cbo_pallet_act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_pallet_actActionPerformed(evt);
            }
        });

        lbl_id_pallet.setText("Id.Pallet");

        txt_id_pallet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_palletActionPerformed(evt);
            }
        });

        lbl_ean.setText("Codigo EAN");

        lbl_status_act.setText("Estado Actividad");

        lbl_id_rack.setText("Id.Rack");

        lbl_id_cell.setText("Id.Celda");

        lbl_date_from.setText("Fecha Inicial");

        lbl_date_to.setText("Fecha Final");

        lbl_status_pallet.setText("Estado Pallet");

        javax.swing.GroupLayout pnl_palletLayout = new javax.swing.GroupLayout(pnl_pallet);
        pnl_pallet.setLayout(pnl_palletLayout);
        pnl_palletLayout.setHorizontalGroup(
            pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_palletLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_id_rack, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id_pallet, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_date_from)
                    .addComponent(lbl_status_act))
                .addGap(18, 18, 18)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(dch_date_from, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_id_pallet, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(txt_id_rack, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbo_pallet_act, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(135, 135, 135)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_palletLayout.createSequentialGroup()
                        .addComponent(lbl_ean)
                        .addGap(51, 51, 51)
                        .addComponent(txt_ean, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_search, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnl_palletLayout.createSequentialGroup()
                            .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_status_pallet)
                                .addComponent(lbl_id_cell)
                                .addComponent(lbl_date_to, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(37, 37, 37)
                            .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(dch_date_to, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_id_cell, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(cbo_pallet_state, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(50, 50, 50))))
                .addGap(0, 57, Short.MAX_VALUE))
        );
        pnl_palletLayout.setVerticalGroup(
            pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_palletLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_id_pallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_ean)
                    .addComponent(txt_ean, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id_pallet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id_rack)
                    .addComponent(txt_id_rack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id_cell)
                    .addComponent(txt_id_cell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbl_date_from)
                        .addComponent(dch_date_from, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dch_date_to, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_date_to, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(23, 23, 23)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_status_act)
                    .addComponent(cbo_pallet_act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_status_pallet)
                    .addComponent(cbo_pallet_state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        tbl_pallet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IdPallet", "Codigo EAN", "Descripcion", "Rack", "Celda", "Ubicacion_Celda", "Estato Pallet", "Fecha Creacion", "Fecha Modificacion", "Estado Actividad"
            }
        ));
        scrl_pallet.setViewportView(tbl_pallet);

        btn_new.setText("Nuevo");
        btn_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_newActionPerformed(evt);
            }
        });

        btn_delete.setText("Eliminar");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrl_pallet, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnl_pallet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_fechaini, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(267, 267, 267)
                        .addComponent(lbl_fechafin, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_new)
                        .addGap(18, 18, 18)
                        .addComponent(btn_delete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cancel)
                        .addGap(27, 27, 27))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_pallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrl_pallet, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_fechaini, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(lbl_fechafin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_new)
                    .addComponent(btn_delete)
                    .addComponent(btn_cancel))
                .addContainerGap())
        );

        pnl_pallet.getAccessibleContext().setAccessibleName("Criterios de búsqueda");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_pallet_actActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_pallet_actActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_pallet_actActionPerformed

    private void txt_id_palletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_palletActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_id_palletActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:   
        this.dispose();
        menuaux.setVisible(true);
        inicia_estado_actividad();
        inicia_estado_pallet();
    }//GEN-LAST:event_formWindowClosed

    private void btn_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_newActionPerformed
        Frm_Pallet frm_pallet = new Frm_Pallet(this);
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
       lbl_fechaini.setText(dch_date_from.getDate().toString());
       lbl_fechafin.setText(dch_date_to.getDate().toString());
    }//GEN-LAST:event_btn_searchActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_new;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox cbo_pallet_act;
    private javax.swing.JComboBox cbo_pallet_state;
    private com.toedter.calendar.JDateChooser dch_date_from;
    private com.toedter.calendar.JDateChooser dch_date_to;
    private javax.swing.JLabel lbl_date_from;
    private javax.swing.JLabel lbl_date_to;
    private javax.swing.JLabel lbl_ean;
    private javax.swing.JLabel lbl_fechafin;
    private javax.swing.JLabel lbl_fechaini;
    private javax.swing.JLabel lbl_id_cell;
    private javax.swing.JLabel lbl_id_pallet;
    private javax.swing.JLabel lbl_id_rack;
    private javax.swing.JLabel lbl_status_act;
    private javax.swing.JLabel lbl_status_pallet;
    private javax.swing.JPanel pnl_pallet;
    private javax.swing.JScrollPane scrl_pallet;
    private javax.swing.JTable tbl_pallet;
    private javax.swing.JTextField txt_ean;
    private javax.swing.JTextField txt_id_cell;
    private javax.swing.JTextField txt_id_pallet;
    private javax.swing.JTextField txt_id_rack;
    // End of variables declaration//GEN-END:variables
}
