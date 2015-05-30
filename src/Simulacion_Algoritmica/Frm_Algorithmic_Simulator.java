/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Simulacion_Algoritmica;

import Operaciones.Frm_DispatchOrder_Detail;
import Seguridad.Frm_MenuPrincipal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Luis Miguel
 */
public class Frm_Algorithmic_Simulator extends javax.swing.JFrame {
    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();
    /**
     * Creates new form Frm_algorithmic_simulator
     */
    public Frm_Algorithmic_Simulator(Frm_MenuPrincipal menu) {
        setTitle("SIMULACIÓN ALGORÍTMICA");
        menuaux=menu;
        initComponents();
    }

    public Frm_Algorithmic_Simulator(){
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_generalParameters = new javax.swing.JPanel();
        lbl_number_vehicles = new javax.swing.JLabel();
        spn_number_vehicles = new javax.swing.JSpinner();
        lbl_number_vehicles1 = new javax.swing.JLabel();
        spn_number_iterations = new javax.swing.JSpinner();
        pnl_dispatch_criteria = new javax.swing.JPanel();
        lbl_dispatch_date = new javax.swing.JLabel();
        jdate_dispatch_date = new com.toedter.calendar.JDateChooser();
        btn_search_orders = new javax.swing.JButton();
        pnl_dispatch_orders = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_dispatch_orders = new javax.swing.JTable();
        btn_generate_routes = new javax.swing.JButton();
        pnl_results = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_results = new javax.swing.JTable();
        btn_exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 500));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnl_generalParameters.setBorder(javax.swing.BorderFactory.createTitledBorder("Parámetros Generales"));

        lbl_number_vehicles.setText("Número de Vehiculos:");

        spn_number_vehicles.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        lbl_number_vehicles1.setText("Número de Iteraciones:");

        spn_number_iterations.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        javax.swing.GroupLayout pnl_generalParametersLayout = new javax.swing.GroupLayout(pnl_generalParameters);
        pnl_generalParameters.setLayout(pnl_generalParametersLayout);
        pnl_generalParametersLayout.setHorizontalGroup(
            pnl_generalParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_generalParametersLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(pnl_generalParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_generalParametersLayout.createSequentialGroup()
                        .addComponent(lbl_number_vehicles)
                        .addGap(18, 18, 18))
                    .addGroup(pnl_generalParametersLayout.createSequentialGroup()
                        .addComponent(lbl_number_vehicles1)
                        .addGap(8, 8, 8)))
                .addGroup(pnl_generalParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(spn_number_iterations, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(spn_number_vehicles))
                .addGap(62, 62, 62))
        );
        pnl_generalParametersLayout.setVerticalGroup(
            pnl_generalParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_generalParametersLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnl_generalParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_number_vehicles)
                    .addComponent(spn_number_vehicles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_generalParametersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_number_vehicles1)
                    .addComponent(spn_number_iterations, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pnl_dispatch_criteria.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios de Búsqueda de Despachos"));

        lbl_dispatch_date.setText("Fecha de Entrega:");

        btn_search_orders.setText("Buscar");

        javax.swing.GroupLayout pnl_dispatch_criteriaLayout = new javax.swing.GroupLayout(pnl_dispatch_criteria);
        pnl_dispatch_criteria.setLayout(pnl_dispatch_criteriaLayout);
        pnl_dispatch_criteriaLayout.setHorizontalGroup(
            pnl_dispatch_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dispatch_criteriaLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_dispatch_date)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jdate_dispatch_date, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_search_orders)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        pnl_dispatch_criteriaLayout.setVerticalGroup(
            pnl_dispatch_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dispatch_criteriaLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnl_dispatch_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_search_orders)
                    .addGroup(pnl_dispatch_criteriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jdate_dispatch_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_dispatch_date)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_dispatch_orders.setBorder(javax.swing.BorderFactory.createTitledBorder("Órdenes de Despacho"));

        table_dispatch_orders.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Número de Orden", "Cliente", "Estado", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_dispatch_orders.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_dispatch_orders.setColumnSelectionAllowed(true);
        table_dispatch_orders.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        table_dispatch_orders.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(table_dispatch_orders);

        btn_generate_routes.setText("Ejecutar Simulación");

        javax.swing.GroupLayout pnl_dispatch_ordersLayout = new javax.swing.GroupLayout(pnl_dispatch_orders);
        pnl_dispatch_orders.setLayout(pnl_dispatch_ordersLayout);
        pnl_dispatch_ordersLayout.setHorizontalGroup(
            pnl_dispatch_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dispatch_ordersLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_dispatch_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_dispatch_ordersLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_generate_routes)))
                .addContainerGap())
        );
        pnl_dispatch_ordersLayout.setVerticalGroup(
            pnl_dispatch_ordersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_dispatch_ordersLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_generate_routes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_results.setBorder(javax.swing.BorderFactory.createTitledBorder("Resultados"));

        table_results.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Número de Simulación", "Valor de Función Objetivo", "Seleccionar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_results.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table_results.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_resultsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_results);

        javax.swing.GroupLayout pnl_resultsLayout = new javax.swing.GroupLayout(pnl_results);
        pnl_results.setLayout(pnl_resultsLayout);
        pnl_resultsLayout.setHorizontalGroup(
            pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_resultsLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        pnl_resultsLayout.setVerticalGroup(
            pnl_resultsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_resultsLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_exit.setText("Salir");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnl_results, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_dispatch_orders, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(pnl_generalParameters, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnl_dispatch_criteria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_generalParameters, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_dispatch_criteria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_dispatch_orders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl_results, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_exit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:
        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_exitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void table_resultsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_resultsMouseClicked
        // TODO add your handling code here:
        if(evt.getSource()==table_results){
            int rowSel = table_results.getSelectedRow();
            int colSel = table_results.getSelectedColumn();
            if (colSel==0){
              Frm_Show_Route_Solution frm_srs;
                try {
                    frm_srs = new Frm_Show_Route_Solution(this);
                    //frm_srs.setLocation(450,150);
                    frm_srs.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frm_srs.setVisible(true);                      
                    //frm_srs.setLocationRelativeTo(null);
              this.setVisible(false);  
                } catch (IOException ex) {
                    Logger.getLogger(Frm_Algorithmic_Simulator.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
        }
    }//GEN-LAST:event_table_resultsMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_generate_routes;
    private javax.swing.JButton btn_search_orders;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdate_dispatch_date;
    private javax.swing.JLabel lbl_dispatch_date;
    private javax.swing.JLabel lbl_number_vehicles;
    private javax.swing.JLabel lbl_number_vehicles1;
    private javax.swing.JPanel pnl_dispatch_criteria;
    private javax.swing.JPanel pnl_dispatch_orders;
    private javax.swing.JPanel pnl_generalParameters;
    private javax.swing.JPanel pnl_results;
    private javax.swing.JSpinner spn_number_iterations;
    private javax.swing.JSpinner spn_number_vehicles;
    private javax.swing.JTable table_dispatch_orders;
    private javax.swing.JTable table_results;
    // End of variables declaration//GEN-END:variables
}
