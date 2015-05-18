/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mantenimientos;

/**
 *
 * @author Alejandro
 */
public class Frm_Client extends javax.swing.JFrame {

    /**
     * Creates new form Frm_Client
     */
    Frm_Client_Search aux = new Frm_Client_Search();
    
    public Frm_Client(Frm_Client_Search client) {
       setTitle("Datos del Cliente");
        aux = client;
        aux.setEnabled(false);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_client = new javax.swing.JPanel();
        lbl_id = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lbl_name = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        lbl_point = new javax.swing.JLabel();
        lbl_posx = new javax.swing.JLabel();
        lbl_posy = new javax.swing.JLabel();
        txt_posx = new javax.swing.JTextField();
        txt_posy = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        pnl_client.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos Generales"));

        lbl_id.setText("DNI");

        lbl_name.setText("Nombres");

        jLabel1.setText("Dirección");

        lbl_point.setText("Ubicacion del Cliente");

        lbl_posx.setText("Posición X");

        lbl_posy.setText("Posición Y");

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

        javax.swing.GroupLayout pnl_clientLayout = new javax.swing.GroupLayout(pnl_client);
        pnl_client.setLayout(pnl_clientLayout);
        pnl_clientLayout.setHorizontalGroup(
            pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_clientLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_clientLayout.createSequentialGroup()
                        .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_posx)
                            .addComponent(lbl_posy))
                        .addGap(32, 32, 32)
                        .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_posy, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_posx, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(355, 355, 355))
                    .addGroup(pnl_clientLayout.createSequentialGroup()
                        .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_clientLayout.createSequentialGroup()
                                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_name)
                                    .addComponent(lbl_id))
                                .addGap(18, 18, 18)
                                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_clientLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(pnl_clientLayout.createSequentialGroup()
                                    .addGap(33, 33, 33)
                                    .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(pnl_clientLayout.createSequentialGroup()
                                            .addComponent(lbl_point)
                                            .addGap(274, 274, 274))
                                        .addGroup(pnl_clientLayout.createSequentialGroup()
                                            .addComponent(btn_save)
                                            .addGap(477, 477, 477)
                                            .addComponent(btn_cancel))))))
                        .addGap(112, 112, 112))))
        );
        pnl_clientLayout.setVerticalGroup(
            pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_clientLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_name)
                    .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(58, 58, 58)
                .addComponent(lbl_point)
                .addGap(38, 38, 38)
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_posx)
                    .addComponent(txt_posx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_posy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_posy))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addGroup(pnl_clientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancel)
                    .addComponent(btn_save))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_client, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_client, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        aux.setEnabled(true);
        aux.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
         aux.setEnabled(true);
        aux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_id;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_point;
    private javax.swing.JLabel lbl_posx;
    private javax.swing.JLabel lbl_posy;
    private javax.swing.JPanel pnl_client;
    private javax.swing.JTextField txt_address;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_posx;
    private javax.swing.JTextField txt_posy;
    // End of variables declaration//GEN-END:variables
}
