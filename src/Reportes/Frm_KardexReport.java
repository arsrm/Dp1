/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import JasperReports.Prueba;
import Model.Movement;
import Model.Product;
import Model.Trademark;
import Seguridad.Frm_MenuPrincipal;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.formatDate;
import dao.DaoKardex;
import dao.DaoProducts;
import dao.DaoTrademark;
import dao.impl.DaoKardexImpl;
import dao.impl.DaoProdImpl;
import dao.impl.DaoTrademarkImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tool.Validate;

/**
 *
 * @author Kari
 */
public class Frm_KardexReport extends javax.swing.JFrame {

    Integer idAlmacen = null;
    Integer idProduct = null;
    String idEan = null;
    Product producto = new Product();
    Integer idtrademark = 0;
    Frm_MenuPrincipal menuaux = new Frm_MenuPrincipal();
    List<Trademark> trademarkList = null;
    DaoTrademark daoTrademark = new DaoTrademarkImpl();
    DaoKardex daoKardex = new DaoKardexImpl();
    DaoProducts daoProducts = new DaoProdImpl();
    List<Movement> movementList = new ArrayList<>();
    List<Movement> movList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    DefaultTableModel modelo;
    public Integer idAl;
    public Integer idP;
    public Date dateI;
    public Date dateF;

    SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Creates new form Frm_KardexReport
     */
    public Frm_KardexReport() {
        initComponents();
    }

    public Frm_KardexReport(Frm_MenuPrincipal menu) {

        menuaux = menu;
        initComponents();
        modelo = (DefaultTableModel) tbl_Kardex.getModel();
        trademarkList = daoTrademark.TrademarkQry();
        cbo_trademark.addItem("Todos");
        for (int i = 0; i < trademarkList.size(); i++) {
            cbo_trademark.addItem(trademarkList.get(i).getName());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        tbl_Wh = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_idWh = new javax.swing.JTextField();
        btn_Wh = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txt_EAN = new javax.swing.JTextField();
        btn_Product = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbo_trademark = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        date_Ini = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        date_End = new com.toedter.calendar.JDateChooser();
        btn_Kardex = new javax.swing.JButton();
        btn_Export = new javax.swing.JButton();
        btn_Cancel = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_Kardex = new javax.swing.JTable();
        btn_Report = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tbl_Wh.setBorder(javax.swing.BorderFactory.createTitledBorder("Almacen"));

        jLabel2.setText("Id:");

        txt_idWh.setEnabled(false);
        txt_idWh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idWhActionPerformed(evt);
            }
        });

        btn_Wh.setText("Buscar");
        btn_Wh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_WhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tbl_WhLayout = new javax.swing.GroupLayout(tbl_Wh);
        tbl_Wh.setLayout(tbl_WhLayout);
        tbl_WhLayout.setHorizontalGroup(
            tbl_WhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl_WhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tbl_WhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tbl_WhLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(tbl_WhLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(71, 71, 71)
                        .addComponent(txt_idWh, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Wh)))
                .addContainerGap())
        );
        tbl_WhLayout.setVerticalGroup(
            tbl_WhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tbl_WhLayout.createSequentialGroup()
                .addGroup(tbl_WhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Wh)
                    .addComponent(jLabel2)
                    .addComponent(txt_idWh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Producto"));

        jLabel3.setText("EAN 13:");

        txt_EAN.setEnabled(false);

        btn_Product.setText("Buscar");
        btn_Product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ProductActionPerformed(evt);
            }
        });

        jLabel6.setText("Marca:");

        cbo_trademark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_trademarkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(50, 50, 50)
                .addComponent(txt_EAN, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(77, 77, 77)
                .addComponent(cbo_trademark, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addComponent(btn_Product)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Product)
                    .addComponent(cbo_trademark, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txt_EAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Fecha"));

        jLabel4.setText("Fecha Inicio:");

        jLabel5.setText("Fecha Fin:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel4)
                .addGap(35, 35, 35)
                .addComponent(date_Ini, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(date_End, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(date_Ini, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(date_End, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        btn_Kardex.setText("Vista Previa");
        btn_Kardex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_KardexActionPerformed(evt);
            }
        });

        btn_Export.setText("Exportar");
        btn_Export.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExportActionPerformed(evt);
            }
        });

        btn_Cancel.setText("Cancelar");
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        tbl_Kardex.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID WH", "ID Producto", "Fecha", "Motivo de Moviemiento", "Entrada", "Salida", "StockInicial", "StockFinal"
            }
        ));
        jScrollPane4.setViewportView(tbl_Kardex);

        btn_Report.setText("Generar Reporte");
        btn_Report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReportActionPerformed(evt);
            }
        });

        jButton1.setText("Limpiar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbl_Wh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_Kardex)
                        .addGap(185, 185, 185)
                        .addComponent(btn_Report)
                        .addGap(154, 154, 154)
                        .addComponent(btn_Export)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(127, 127, 127)
                        .addComponent(btn_Cancel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tbl_Wh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Kardex)
                    .addComponent(btn_Report)
                    .addComponent(btn_Export)
                    .addComponent(jButton1)
                    .addComponent(btn_Cancel))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idWhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idWhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idWhActionPerformed

    private void btn_KardexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_KardexActionPerformed
        Date dateIniSearch = null;
        Date dateEndSearch = null;
        Movement movimiento = new Movement();

        if (txt_idWh.getText().length() != 0) {
            idAlmacen = Integer.parseInt(txt_idWh.getText());
        }
        if (txt_EAN.getText().length() != 0) {
            idProduct = producto.getIdProduct();
        }
        if (date_Ini.getDate() != null) {
            dateIniSearch = date_Ini.getDate();
        } else {
            dateIniSearch = new Date();
            dateIniSearch.setTime(0);
        }
        if (date_End.getDate() != null) {
            dateEndSearch = date_End.getDate();
        } else {
            dateEndSearch = new Date();
        }
        movementList = daoKardex.MovementSearch(idProduct, idAlmacen, dateIniSearch, dateEndSearch);
        initializeTable();
    }//GEN-LAST:event_btn_KardexActionPerformed

    private void btn_ProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ProductActionPerformed

        Frm_SearchProductKardex frm_SearchProductKardex = new Frm_SearchProductKardex(this, idtrademark);
        frm_SearchProductKardex.setVisible(true);
        frm_SearchProductKardex.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btn_ProductActionPerformed

    private void btn_WhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_WhActionPerformed

        Frm_SearchWhKardex frm_SearchWhKardex = new Frm_SearchWhKardex(this);
        frm_SearchWhKardex.setVisible(true);
        frm_SearchWhKardex.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btn_WhActionPerformed

    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed

        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_CancelActionPerformed

    private void cbo_trademarkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_trademarkActionPerformed
//        if (cbo_trademark.getSelectedItem() != null) {
//            for (int i = 0; i < trademarkList.size(); i++) {
//                if (cbo_trademark.getSelectedItem().equals(trademarkList.get(i).getName())) {
//                    idtrademark = trademarkList.get(i).getId_Trademark();
//                }
//            }
//        }

        if (cbo_trademark.getSelectedItem() != null) {
            if (cbo_trademark.getSelectedItem() != "Todos") {
                for (int i = 0; i < trademarkList.size(); i++) {
                    if (cbo_trademark.getSelectedItem().equals(trademarkList.get(i).getName())) {
                        idtrademark = trademarkList.get(i).getId_Trademark();
                    }
                }
            } else {
                idtrademark = null;
            }

        }

    }//GEN-LAST:event_cbo_trademarkActionPerformed

    private void btn_ReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReportActionPerformed

        //para reporte kardex sin filtro 2
        Calendar dateIniCal = Calendar.getInstance();
        Calendar dateFinCal = Calendar.getInstance();

        Date dateIniSearch = null;
        Date dateEndSearch = null;

        Prueba reporte = new Prueba();

//        if (txt_idWh.getText().length() == 0 && txt_EAN.getText().length() == 0 && date_Ini.getDate() == null && date_End.getDate() == null) {
//
//            dateIniSearch = new Date();
//            dateIniSearch.setTime(0);
//            dateEndSearch = new Date();
//
//            reporte.mostrarReporteKardexSinFiltro(dateIniSearch, dateEndSearch);
//        } else {
//            if (txt_idWh.getText().length() == 0 && txt_EAN.getText().length() == 0 && date_Ini.getDate() != null || date_End.getDate() != null) {
//                dateIniSearch = date_Ini.getDate();
//                dateEndSearch = date_End.getDate();
//                reporte.mostrarReporteKardexSinFiltro(dateIniSearch, dateEndSearch);
//            } else {
//                idAl = Integer.parseInt(txt_idWh.getText());
//                idP = producto.getIdProduct();
//
//                if (date_Ini.getDate() != null) {
//                    dateIniSearch = date_Ini.getDate();
//                } else {
//                    dateIniSearch = new Date();
//                    dateIniSearch.setTime(0);
//                }
//                if (date_End.getDate() != null) {
//                    dateEndSearch = date_End.getDate();
//                } else {
//                    dateEndSearch = new Date();
//                }
//
//                if (dateEndSearch.before(dateIniSearch)) {
//                    JOptionPane.showMessageDialog(this, "La Fecha Fin debe ser mayor que la Fecha Inicio");
//                }
//                reporte.mostrarReporteKardexConFiltro(idAl, idP, dateIniSearch, dateEndSearch);
//            }
//        }
//        if (txt_idWh.getText().length() != 0) {
//            idAlmacen = Integer.parseInt(txt_idWh.getText());
//        }
//        if (txt_EAN.getText().length() != 0) {
//            idProduct = producto.getIdProduct();
//        }
        if (txt_idWh.getText().length() != 0) {
            idAlmacen = Integer.parseInt(txt_idWh.getText());
        }
        if (txt_EAN.getText().length() != 0) {
            idProduct = producto.getIdProduct();
        }

        if (date_Ini.getDate() != null) {
            dateIniSearch = date_Ini.getDate();
            dateIniCal.setTime(date_Ini.getDate());
        } else {
            dateIniSearch = new Date();
            dateIniSearch.setTime(0);
            dateIniCal.setTime(new Date(0));
        }
        if (date_End.getDate() != null) {
            dateEndSearch = date_End.getDate();
            dateFinCal.setTime(date_End.getDate());
        } else {
            dateEndSearch = new Date();
            dateFinCal.setTime(new Date());
        }
        if (dateEndSearch.before(dateIniSearch)) {
            JOptionPane.showMessageDialog(this, "La Fecha Fin debe ser mayor que la Fecha Inicio");
        } else {

            if (idProduct == null && idAlmacen == null) {

                reporte.mostrarReporteKardexSinFiltro(dateIniSearch, dateEndSearch);
                // reporte.mostrarReporteKardexSinFiltro2(formatDate.format(dateIniCal.getTime()),formatDate.format(dateFinCal.getTime()));
            }
            if (idProduct != null && idAlmacen == null) {

                reporte.mostrarReporteKardexXProducto(idProduct, dateIniSearch, dateEndSearch);

            }
            if (idProduct == null && idAlmacen != null) {

                reporte.mostrarReporteKardexXAlmacen(idAlmacen, dateIniSearch, dateEndSearch);
            }
            if (idProduct != null && idAlmacen != null) {
                reporte.mostrarReporteKardexConFiltro(idProduct, idAlmacen, dateIniSearch, dateEndSearch);
            }
        }
    }//GEN-LAST:event_btn_ReportActionPerformed

    private void btn_ExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExportActionPerformed
        Prueba exportar = new Prueba();
        exportar.exportarReporte();
    }//GEN-LAST:event_btn_ExportActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txt_idWh.setText(null);
        txt_EAN.setText(null);
        date_Ini.setDate(null);
        date_End.setDate(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        menuaux.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    public void setIdWh(Integer id) {

        idAlmacen = id;
    }

    public void setTextIdWh() {

        txt_idWh.setText(idAlmacen.toString());
    }

    public void setProduct(Product p) {

        producto = p;
    }

    public void setTextIdEan() {

        txt_EAN.setText(producto.getCodeEAN13());
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_Export;
    private javax.swing.JButton btn_Kardex;
    private javax.swing.JButton btn_Product;
    private javax.swing.JButton btn_Report;
    private javax.swing.JButton btn_Wh;
    private javax.swing.JComboBox cbo_trademark;
    private com.toedter.calendar.JDateChooser date_End;
    private com.toedter.calendar.JDateChooser date_Ini;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tbl_Kardex;
    private javax.swing.JPanel tbl_Wh;
    private javax.swing.JTextField txt_EAN;
    private javax.swing.JTextField txt_idWh;
    // End of variables declaration//GEN-END:variables

    private void initializeTable() {
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();

        try {
            for (int i = 0; i < movementList.size(); i++) {
                Integer entrada = 0;
                Integer salida = 0;
                String entradaStr = "";
                String salidaStr = "";
                if (movementList.get(i).getType_Movement_id() == 1) {
                    entrada = (movementList.get(i).getStock_final() - movementList.get(i).getStock_inicial());
                    entradaStr = entrada.toString();
                } else {
                    salida = (movementList.get(i).getStock_inicial() - movementList.get(i).getStock_final());
                    salidaStr = salida.toString();
                }
                Object[] fila = {movementList.get(i).getIdWh(), movementList.get(i).getIdProduct(), movementList.get(i).getDate(), movementList.get(i).getType_Movement_idSubtype(),
                    entradaStr, salidaStr, movementList.get(i).getStock_inicial(), movementList.get(i).getStock_final()};

                modelo.addRow(fila);
            }
        } catch (Exception e) {
        }
    }

}
