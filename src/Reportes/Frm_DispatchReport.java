/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reportes;

import Seguridad.Frm_MenuPrincipal;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;

/**
 *
 * @author CHACON
 */
public class Frm_DispatchReport extends javax.swing.JFrame {

    /**
     * Creates new form Frm_DispatchReport
     */
    
    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();
    String fileExport;
    
    public Frm_DispatchReport(Frm_MenuPrincipal menu) {
        
        setTitle("Reporte Orden de despacho");
        menuaux = menu;
        menuaux.setEnabled(false);
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

        pnl_DispatchReport = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDate_in = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jDate_out = new com.toedter.calendar.JDateChooser();
        btn_GenerarReporte = new javax.swing.JToggleButton();
        btn_Export = new javax.swing.JToggleButton();
        jLabel3 = new javax.swing.JLabel();
        txt_client = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_NumOrden = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        cbo_Status = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        txt_Direction = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_Vehicle = new javax.swing.JTextField();
        btn_Cancelar = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Dispatch = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnl_DispatchReport.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios de filtro"));

        jLabel1.setText("Fecha de Registro");

        jLabel2.setText("Fecha Entrega Estimada ");

        btn_GenerarReporte.setText("Generar Reporte");
        btn_GenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GenerarReporteActionPerformed(evt);
            }
        });

        btn_Export.setText("Exportar");
        btn_Export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExportActionPerformed(evt);
            }
        });

        jLabel3.setText("ID Cliente:");

        jLabel4.setText("Número de Orden:");

        jLabel5.setText("Estado:");

        jLabel6.setText("Transportista:");

        cbo_Status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVO" }));
        cbo_Status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_StatusActionPerformed(evt);
            }
        });

        jLabel7.setText("Direccion:");

        txt_Direction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DirectionActionPerformed(evt);
            }
        });

        jLabel8.setText("Vehículo:");

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_DispatchReportLayout = new javax.swing.GroupLayout(pnl_DispatchReport);
        pnl_DispatchReport.setLayout(pnl_DispatchReportLayout);
        pnl_DispatchReportLayout.setHorizontalGroup(
            pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                        .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_NumOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                                .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_client, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_Direction, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(46, 46, 46)
                                .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                                        .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel5))
                                        .addGap(140, 140, 140)
                                        .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txt_Vehicle, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbo_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(64, 64, 64)
                                        .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_Export)
                                            .addComponent(jDate_out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btn_GenerarReporte))
                    .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jDate_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_DispatchReportLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Cancelar)
                .addGap(150, 150, 150))
        );
        pnl_DispatchReportLayout.setVerticalGroup(
            pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_NumOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbo_Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txt_Direction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txt_Vehicle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                        .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jDate_out, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2))
                        .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(btn_GenerarReporte))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_DispatchReportLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_Export)
                                .addGap(8, 8, 8))))
                    .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jDate_in, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(btn_Cancelar))
        );

        tbl_Dispatch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Pallet", "ID Producto", "Nombre Producto", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tbl_Dispatch);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
            .addComponent(pnl_DispatchReport, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(pnl_DispatchReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GenerarReporteActionPerformed
        
    }//GEN-LAST:event_btn_GenerarReporteActionPerformed

    private void btn_ExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExportActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int res = fileChooser.showOpenDialog(this);
        try {
            fileExport = fileChooser.getSelectedFile().getAbsolutePath();

        } catch (Exception e) {}
    }//GEN-LAST:event_btn_ExportActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        this.dispose();
        menuaux.setVisible(true);
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void cbo_StatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_StatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbo_StatusActionPerformed

    private void txt_DirectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DirectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DirectionActionPerformed

    private void formWindowClosed(ActionEvent evt) {
        menuaux.setEnabled(true);
        menuaux.setVisible(true);
        this.dispose();
    }
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_Cancelar;
    private javax.swing.JToggleButton btn_Export;
    private javax.swing.JToggleButton btn_GenerarReporte;
    private javax.swing.JComboBox cbo_Status;
    private com.toedter.calendar.JDateChooser jDate_in;
    private com.toedter.calendar.JDateChooser jDate_out;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel pnl_DispatchReport;
    private javax.swing.JTable tbl_Dispatch;
    private javax.swing.JTextField txt_Direction;
    private javax.swing.JTextField txt_NumOrden;
    private javax.swing.JTextField txt_Vehicle;
    private javax.swing.JTextField txt_client;
    // End of variables declaration//GEN-END:variables
}
