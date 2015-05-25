package Mantenimientos;

import Model.Client;
import dao.DaoClient;
import dao.impl.DaoClientImpl;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static tool.Convierte.aDouble;
import static tool.Convierte.aInteger;


public class Frm_Client extends javax.swing.JFrame {

    Frm_Client_Search frm_Client_Search = new Frm_Client_Search();
    DaoClient daoClient = new DaoClientImpl();
   
    public Frm_Client(Frm_Client_Search client, Client cliente) {
       setTitle("Datos del Cliente");
        frm_Client_Search = client;
        initComponents();
        if (cliente != null) {
            txt_id.setText(cliente.getRuc());
            txt_id.setEnabled(false);
            txt_name.setText(cliente.getName());
            txt_address.setText(cliente.getAddress());
            txt_posx.setText(cliente.getPos_x().toString());
            txt_posy.setText(cliente.getPos_y().toString());
            op_priority.setValue(cliente.getPriority());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_client = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        lbl_name = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();
        pnl_client_location = new javax.swing.JPanel();
        lbl_posx = new javax.swing.JLabel();
        txt_posx = new javax.swing.JTextField();
        lbl_posy = new javax.swing.JLabel();
        txt_posy = new javax.swing.JTextField();
        pnl_client_priority = new javax.swing.JPanel();
        lbl_priority = new javax.swing.JLabel();
        op_priority = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnl_client.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        lbl_id.setText("Ruc");

        lbl_name.setText("Nombres");

        jLabel1.setText("Dirección");

        javax.swing.GroupLayout pnl_clientLayout = new javax.swing.GroupLayout(pnl_client);
        pnl_client.setLayout(pnl_clientLayout);
        pnl_clientLayout.setHorizontalGroup(
            pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_clientLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_clientLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(725, 725, 725))
                    .addGroup(pnl_clientLayout.createSequentialGroup()
                        .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_clientLayout.createSequentialGroup()
                                .addComponent(lbl_name)
                                .addGap(46, 46, 46)
                                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                    .addComponent(txt_address)))
                            .addComponent(lbl_id))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnl_clientLayout.setVerticalGroup(
            pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_clientLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_name)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(24, Short.MAX_VALUE))
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

        pnl_client_location.setBorder(javax.swing.BorderFactory.createTitledBorder("Ubicación del Cliente"));

        lbl_posx.setText("Posición X");

        lbl_posy.setText("Posición Y");

        javax.swing.GroupLayout pnl_client_locationLayout = new javax.swing.GroupLayout(pnl_client_location);
        pnl_client_location.setLayout(pnl_client_locationLayout);
        pnl_client_locationLayout.setHorizontalGroup(
            pnl_client_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_client_locationLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(pnl_client_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_posx)
                    .addComponent(lbl_posy))
                .addGap(18, 18, 18)
                .addGroup(pnl_client_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_posx, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                    .addComponent(txt_posy))
                .addGap(27, 27, 27))
        );
        pnl_client_locationLayout.setVerticalGroup(
            pnl_client_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_client_locationLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnl_client_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_posx)
                    .addComponent(txt_posx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_client_locationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_posy)
                    .addComponent(txt_posy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pnl_client_priority.setBorder(javax.swing.BorderFactory.createTitledBorder("Prioridad del Cliente"));

        lbl_priority.setText("Prioridad");

        op_priority.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        op_priority.setToolTipText("");

        javax.swing.GroupLayout pnl_client_priorityLayout = new javax.swing.GroupLayout(pnl_client_priority);
        pnl_client_priority.setLayout(pnl_client_priorityLayout);
        pnl_client_priorityLayout.setHorizontalGroup(
            pnl_client_priorityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_client_priorityLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbl_priority)
                .addGap(34, 34, 34)
                .addComponent(op_priority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        pnl_client_priorityLayout.setVerticalGroup(
            pnl_client_priorityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_client_priorityLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnl_client_priorityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_priority)
                    .addComponent(op_priority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnl_client_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(pnl_client_priority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_client, javax.swing.GroupLayout.PREFERRED_SIZE, 602, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btn_save)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_cancel)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnl_client_priority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl_client_location, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_save)
                    .addComponent(btn_cancel))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
       
       if (txt_id.getText().length() == 0 || txt_name.getText().length() == 0 
               ||  txt_address.getText().length() == 0 ||  txt_posx.getText().length() == 0 
               ||  txt_posy.getText().length() == 0 ) {
            JOptionPane.showMessageDialog(this, "Por favor completar todos los campos del formulario");
        
       }else{
        Object[] options = {"OK"};
        if (JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?",
                "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            int ok_option = JOptionPane.showOptionDialog(new JFrame(), "Se ha registrado al usuario con éxito", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (ok_option == JOptionPane.OK_OPTION) {

                    Client client = new Client();
                    client.setRuc(txt_id.getText());
                    client.setName(txt_name.getText());
                    client.setAddress(txt_address.getText());
                    client.setAddress(txt_address.getText());
                    client.setPriority(aInteger(op_priority.getValue().toString()));
                    client.setPos_x(aDouble(txt_posx.getText()));
                    client.setPos_y(aDouble(txt_posy.getText()));
                    client.setStatus(1);
                    
                    if(daoClient.clientGet(client.getRuc())==null){
                    daoClient.clientIns(client);
                    }else daoClient.clientUpd(client);
                    
                    frm_Client_Search.setVisible(true);
                    frm_Client_Search.setLocationRelativeTo(null);
                    this.dispose();
                    frm_Client_Search.initilizeTable();
               // }
            }
        }
      }
    }//GEN-LAST:event_btn_saveActionPerformed

   
    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
        frm_Client_Search.setVisible(true);
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.dispose();
        frm_Client_Search.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_posx;
    private javax.swing.JLabel lbl_posy;
    private javax.swing.JLabel lbl_priority;
    private javax.swing.JSpinner op_priority;
    private javax.swing.JPanel pnl_client;
    private javax.swing.JPanel pnl_client_location;
    private javax.swing.JPanel pnl_client_priority;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_posx;
    private javax.swing.JTextField txt_posy;
    // End of variables declaration//GEN-END:variables
}
