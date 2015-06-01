/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mantenimientos;
import Mantenimientos.Frm_Pallet_SearchIni;
import Model.PalletIni; 
import Model.PalletState;
import dao.DaoPalletIni;
import dao.DaoPalletState;
import dao.impl.DaoPalletIniImpl; 
import dao.impl.DaoPalletStateImpl;
import javax.swing.JOptionPane;
/**
 *
 * @author gzavala
 */
public class Frm_PalletIni extends javax.swing.JFrame {

    Frm_Pallet_SearchIni  menu_padre = new Frm_Pallet_SearchIni();     
    PalletIni pallet; 
    DaoPalletIni daopalletini=new DaoPalletIniImpl();
    DaoPalletState daopalletstate= new DaoPalletStateImpl(); 
    String accion=""; 
    //UPD o INS
    /**
     * Creates new form Frm_PalletIni
     */
      //caso=1 en caso de update y caso=2 en caso de insert
    public Integer inicia_estado_pallet(Integer indstate,Integer caso)
    { Integer ind=0; 
      cbo_pallet_state.removeAllItems();
      DaoPalletState objdao=new DaoPalletStateImpl(); 
      Integer cantreg= objdao.PalletStateQry().size();
          
      PalletState[] list=new PalletState[cantreg];
       for (int i=0; i<cantreg; i++)
       {  list[i]=objdao.PalletStateQry().get(i);
          // Se agregan los status activos
          if (list[i].getStatus()==1)
          { cbo_pallet_state.addItem(list[i].getDescription());
            if (indstate==list[i].getIdPallet_State())
            {  ind=i;
            }   
          }
       }   
          if (caso==2)
          { ind=0;}   
      return ind; 
      }        
    
    public void campos_iniciales(String accion)
    { Integer stateind; 
      if (accion.equals("UPD"))
      { txt_idpallet.setEnabled(false);
        txt_idpallet.setText(pallet.getIdpallet().toString());
        txt_description.setText(pallet.getDescription());
        stateind=inicia_estado_pallet(pallet.getStatuspallet(),1);
        cbo_pallet_state.setSelectedIndex(stateind);
      }
      if (accion.equals("INS"))
      { txt_idpallet.setEnabled(false);
        txt_idpallet.setText("");
        txt_description.setText("");
        stateind=inicia_estado_pallet(0,2);
        cbo_pallet_state.setSelectedIndex(stateind);
      }
      
      
    }        
    public Frm_PalletIni(Frm_Pallet_SearchIni ventant,PalletIni palletini, String acc ) {
        //accion es UPD --> Update y INS ---> Insert
        setTitle("Mantenimiento de Pallet");
        menu_padre = ventant;
        pallet=palletini; 
        accion=acc;
        initComponents();
        campos_iniciales(acc);
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
        lbl_idpallet = new javax.swing.JLabel();
        ldl_description = new javax.swing.JLabel();
        txt_idpallet = new javax.swing.JTextField();
        txt_description = new javax.swing.JTextField();
        lbl_palletstate = new javax.swing.JLabel();
        cbo_pallet_state = new javax.swing.JComboBox();
        btn_save = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnl_pallet.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));
        pnl_pallet.setName(""); // NOI18N

        lbl_idpallet.setText("Id. Pallet");
        lbl_idpallet.setMaximumSize(new java.awt.Dimension(68, 14));
        lbl_idpallet.setMinimumSize(new java.awt.Dimension(68, 14));
        lbl_idpallet.setPreferredSize(new java.awt.Dimension(68, 14));

        ldl_description.setText("Descripcion");

        lbl_palletstate.setText("Estado Pallet");

        javax.swing.GroupLayout pnl_palletLayout = new javax.swing.GroupLayout(pnl_pallet);
        pnl_pallet.setLayout(pnl_palletLayout);
        pnl_palletLayout.setHorizontalGroup(
            pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_palletLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbl_palletstate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ldl_description, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_idpallet, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_idpallet)
                    .addComponent(txt_description)
                    .addComponent(cbo_pallet_state, 0, 188, Short.MAX_VALUE))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        pnl_palletLayout.setVerticalGroup(
            pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_palletLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_idpallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_idpallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ldl_description)
                    .addComponent(txt_description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_palletLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_palletstate)
                    .addComponent(cbo_pallet_state, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_pallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(btn_save)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_cancel)
                        .addGap(78, 78, 78))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_pallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_cancel))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        menu_padre.setVisible(true);
        //menu_padre.initilizeTable();
        this.dispose();        

    }//GEN-LAST:event_formWindowClosed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.dispose();
        menu_padre.setVisible(true);
        //menu_padre.initilizeTable();
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
      Integer idpallet=0; 
      Integer idstatuspallet=0; 
      String palletstate=cbo_pallet_state.getSelectedItem().toString().trim();
      String description=txt_description.getText().toString().trim();
      idstatuspallet=daopalletstate.PalletStateIdGet(palletstate);
      //idpallet=daopalletini.PalletIniMax();
      PalletIni objpalletini=new PalletIni();
      
      //accion es UPD --> Update y INS ---> Insert
      if (accion.equals("INS"))
      {  objpalletini.setDescription(description);
         objpalletini.setStatuspallet(idstatuspallet);
         //objpalletini.setIdpallet(idpallet);
         String message = "¿Está seguro que realizar el registro del Nuevo Pallet?";
         String title = "Confirmar! ";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        JOptionPane.setDefaultLocale(null);
        if (reply == JOptionPane.YES_OPTION) 
        { daopalletini.PalletIniIns(objpalletini);
          this.dispose();
          menu_padre.setVisible(true);
          menu_padre.load_tablefilter();
        }
       }
      if (accion.equals("UPD"))
      {  objpalletini.setIdpallet(pallet.getIdpallet());
         objpalletini.setDescription(description);
         objpalletini.setStatuspallet(idstatuspallet);
        String message = "¿Está seguro realizar la actualización del pallet?";
        String title = "Confirmar! ";
        int reply = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        JOptionPane.setDefaultLocale(null);
        if (reply == JOptionPane.YES_OPTION) 
        { daopalletini.PalletIniUpd(objpalletini);;
          this.dispose();
          menu_padre.setVisible(true);
          menu_padre.load_tablefilter();
        }
      }    
    }//GEN-LAST:event_btn_saveActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox cbo_pallet_state;
    private javax.swing.JLabel lbl_idpallet;
    private javax.swing.JLabel lbl_palletstate;
    private javax.swing.JLabel ldl_description;
    private javax.swing.JPanel pnl_pallet;
    private javax.swing.JTextField txt_description;
    private javax.swing.JTextField txt_idpallet;
    // End of variables declaration//GEN-END:variables
}
