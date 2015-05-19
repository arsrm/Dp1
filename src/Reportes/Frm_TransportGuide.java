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
public class Frm_TransportGuide extends javax.swing.JFrame {

    /**
     * Creates new form Frm_TransportGuide
     */
    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();
    String fileExport;
    
    public Frm_TransportGuide(Frm_MenuPrincipal menu) {
        
        setTitle("Reporte Guía de Transportista");
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

        pnl_TransportGuide = new javax.swing.JPanel();
        btn_GenerarReporte = new javax.swing.JToggleButton();
        btn_Export = new javax.swing.JToggleButton();
        lbl_Placa = new javax.swing.JLabel();
        txt_Placa = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_TransportGuide = new javax.swing.JTable();
        btn_Cancelar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        pnl_TransportGuide.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios de filtro"));

        btn_GenerarReporte.setText("Generar Reporte");
        btn_GenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GenerarReporteActionPerformed(evt);
            }
        });

        btn_Export.setText("Exportar");

        lbl_Placa.setText("Placa");

        javax.swing.GroupLayout pnl_TransportGuideLayout = new javax.swing.GroupLayout(pnl_TransportGuide);
        pnl_TransportGuide.setLayout(pnl_TransportGuideLayout);
        pnl_TransportGuideLayout.setHorizontalGroup(
            pnl_TransportGuideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_TransportGuideLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_TransportGuideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_TransportGuideLayout.createSequentialGroup()
                        .addComponent(lbl_Placa)
                        .addGap(32, 32, 32)
                        .addComponent(txt_Placa, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_TransportGuideLayout.createSequentialGroup()
                        .addGap(0, 303, Short.MAX_VALUE)
                        .addComponent(btn_GenerarReporte)
                        .addGap(45, 45, 45)
                        .addComponent(btn_Export)
                        .addGap(25, 25, 25))))
        );
        pnl_TransportGuideLayout.setVerticalGroup(
            pnl_TransportGuideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_TransportGuideLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnl_TransportGuideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Placa)
                    .addComponent(txt_Placa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(pnl_TransportGuideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_GenerarReporte)
                    .addComponent(btn_Export))
                .addGap(39, 39, 39))
        );

        tbl_TransportGuide.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Cliente", "ID Producto", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tbl_TransportGuide);

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnl_TransportGuide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_Cancelar)
                        .addGap(44, 44, 44)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_TransportGuide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Cancelar)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(122, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
       this.dispose();
       menuaux.setVisible(true);
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_GenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GenerarReporteActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int res = fileChooser.showOpenDialog(this);
        try {
            fileExport = fileChooser.getSelectedFile().getAbsolutePath();

        } catch (Exception e) {}
    }//GEN-LAST:event_btn_GenerarReporteActionPerformed

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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Placa;
    private javax.swing.JPanel pnl_TransportGuide;
    private javax.swing.JTable tbl_TransportGuide;
    private javax.swing.JTextField txt_Placa;
    // End of variables declaration//GEN-END:variables
}
