/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Operaciones;

import Model.InternmentOrder;
import Model.InternmentOrderDetail;
import Model.Log;
import Model.Product;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoInternmentOrder;
import dao.DaoLog;
import dao.DaoPalletIni;
import dao.DaoPalletProduct;
import dao.DaoProducts;
import dao.impl.DaoInternmentOrderImpl;
import dao.impl.DaoLogImpl;
import dao.impl.DaoPalletIniImpl;
import dao.impl.DaoPalletProductImpl;
import dao.impl.DaoProdImpl;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import tool.Validate;

/**
 *
 * @author Gustavo
 */
public class Frm_IntermentOrder_Load extends javax.swing.JFrame {

    /**
     * Creates new form Frm_ProductInterment
     */
    String directory = null;
    Frm_MenuPrincipal menu_padre = new Frm_MenuPrincipal();
    DaoProducts daoProducts = new DaoProdImpl();
    DaoInternmentOrder daoProdInt = new DaoInternmentOrderImpl();
    DaoPalletProduct daoPalletProduct = new DaoPalletProductImpl();
    DaoPalletIni daoPalletIni = new DaoPalletIniImpl();
    InternmentOrder internmentOrder = null;
    DefaultTableModel modelo = new DefaultTableModel();
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");

    List<InternmentOrderDetail> intOrderDetListMassive = null;
    List<InternmentOrderDetail> intOrderDetListManual = null;
    Integer lineIntOrdDetailManual = 1;
    private BarraProgreso tarea;

    public Frm_IntermentOrder_Load(Frm_MenuPrincipal menu) {

        setTitle("Internamiento de Productos");
        menu_padre = menu;
        initComponents();
        btn_manual_load.setEnabled(false);
        btn_massive_load.setEnabled(false);
        btn_saveOrder.setEnabled(false);
        modelo = (DefaultTableModel) tbl_orderDetail.getModel();
    }

    public Frm_IntermentOrder_Load() {

    }

    class BarraProgreso extends SwingWorker<Void, Void> {

        @Override
        public void done() {
            progressBar.setIndeterminate(false);
            Object[] options = {"OK"};
            int ok_option = JOptionPane.showOptionDialog(new JFrame(), "Se ha registrado la orden de internamiento con éxito", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (ok_option == JOptionPane.OK_OPTION) {
                menu_padre.setVisible(true);
                menu_padre.setLocationRelativeTo(null);
                Frm_IntermentOrder_Load.this.dispose();
                DaoLog daoLog = new DaoLogImpl();
                Log logSI = null;
                daoLog.clientIns("Se ha agregado una orden de internamiento  ", Frm_IntermentOrder_Load.class.toString(), logSI.getIduser());
            }
        }

        @Override
        public Void doInBackground() throws Exception {

            List<Integer> freePalletList;
            txt_idOrderInt.setEnabled(true);
            txt_idProduct.setEnabled(true);
            txt_quantityPallet.setEnabled(true);
            jDate_dateOrder.setEnabled(true);
            txt_route.setEnabled(true);
            btn_addProduct.setEnabled(true);
            btn_searchFile.setEnabled(true);
            btn_saveOrder.setEnabled(false);

            Object[] options = {"OK"};
            if (JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?",
                    "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                progressBar.setIndeterminate(true);
                daoProdInt.IntOrderIns(internmentOrder);

                for (int i = 0; i < internmentOrder.getInternmentOrderDetail().size(); i++) {
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(internmentOrder.getDate());
                    cal.add(Calendar.DATE, internmentOrder.getInternmentOrderDetail().get(i).getProduct().getTimeExpiration());
                    freePalletList = daoPalletProduct.GetPalletByStatus(2, internmentOrder.getInternmentOrderDetail().get(i).getQuantityPallets());
                    daoPalletProduct.PalletProductInsMasive(freePalletList, internmentOrder.getInternmentOrderDetail().get(i).getProduct().getTrademark(),
                            internmentOrder.getInternmentOrderDetail().get(i).getProduct().getIdProduct(),
                            cal.getTime(), internmentOrder.getIdInternmentOrder());
                    for (int j = 0; j < freePalletList.size(); j++) {
                        daoPalletIni.PalletsIniUpdStatus(freePalletList, 1);//1 Estado no disponible
                    }
                }
                modelo.getDataVector().removeAllElements();
                modelo.fireTableDataChanged();
                intOrderDetListMassive = null;
                intOrderDetListManual = null;
                internmentOrder = null;

            }
            return null;
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

        pnl_product_int = new javax.swing.JPanel();
        lbl_Product = new javax.swing.JLabel();
        txt_idProduct = new javax.swing.JTextField();
        btn_manual_load = new javax.swing.JButton();
        lbl_quantity = new javax.swing.JLabel();
        txt_quantityPallet = new javax.swing.JTextField();
        btn_addProduct = new javax.swing.JButton();
        lbl_orderInterment = new javax.swing.JLabel();
        txt_idOrderInt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_nameProduct = new javax.swing.JTextField();
        lbl_validate = new javax.swing.JLabel();
        lbl_date = new javax.swing.JLabel();
        jDate_dateOrder = new com.toedter.calendar.JDateChooser();
        pnl_massive_load = new javax.swing.JPanel();
        lbl_route = new javax.swing.JLabel();
        txt_route = new javax.swing.JTextField();
        btn_searchFile = new javax.swing.JButton();
        btn_massive_load = new javax.swing.JButton();
        pnl_order = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_orderDetail = new javax.swing.JTable();
        btn_Cancel = new javax.swing.JButton();
        btn_saveOrder = new javax.swing.JButton();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnl_product_int.setBorder(javax.swing.BorderFactory.createTitledBorder("Carga Manual"));

        lbl_Product.setText("Código de Producto");

        txt_idProduct.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_idProductFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_idProductFocusLost(evt);
            }
        });

        btn_manual_load.setText("Generar Orden de Internamiento");
        btn_manual_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_manual_loadActionPerformed(evt);
            }
        });

        lbl_quantity.setText("Cantidad de Pallets");

        btn_addProduct.setText("Agregar Producto");
        btn_addProduct.setEnabled(false);
        btn_addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addProductActionPerformed(evt);
            }
        });

        lbl_orderInterment.setText("N° Orden de Internamiento");

        txt_idOrderInt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_idOrderIntFocusLost(evt);
            }
        });

        jLabel1.setText("Nombre de Producto");

        txt_nameProduct.setEnabled(false);

        lbl_date.setText("Fecha");

        jDate_dateOrder.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jDate_dateOrderFocusGained(evt);
            }
        });

        javax.swing.GroupLayout pnl_product_intLayout = new javax.swing.GroupLayout(pnl_product_int);
        pnl_product_int.setLayout(pnl_product_intLayout);
        pnl_product_intLayout.setHorizontalGroup(
            pnl_product_intLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_product_intLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_product_intLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_product_intLayout.createSequentialGroup()
                        .addGroup(pnl_product_intLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_orderInterment)
                            .addComponent(lbl_date))
                        .addGap(30, 30, 30)
                        .addGroup(pnl_product_intLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_idOrderInt, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(jDate_dateOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_product_intLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_product_intLayout.createSequentialGroup()
                                .addComponent(lbl_Product)
                                .addGap(32, 32, 32)
                                .addComponent(txt_idProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_product_intLayout.createSequentialGroup()
                                .addGroup(pnl_product_intLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lbl_quantity))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnl_product_intLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_validate)
                                    .addGroup(pnl_product_intLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_quantityPallet)
                                        .addComponent(txt_nameProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))))))
                    .addGroup(pnl_product_intLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btn_manual_load)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_addProduct)))
                .addGap(33, 33, 33))
        );
        pnl_product_intLayout.setVerticalGroup(
            pnl_product_intLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_product_intLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(pnl_product_intLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Product)
                    .addComponent(txt_idProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_orderInterment)
                    .addComponent(txt_idOrderInt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addComponent(lbl_validate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_product_intLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_product_intLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txt_nameProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_date))
                    .addComponent(jDate_dateOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_product_intLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_quantityPallet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_quantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnl_product_intLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_manual_load)
                    .addComponent(btn_addProduct))
                .addContainerGap())
        );

        pnl_massive_load.setBorder(javax.swing.BorderFactory.createTitledBorder("Carga Masiva"));

        lbl_route.setText("Ruta");

        btn_searchFile.setText("Buscar");
        btn_searchFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchFileActionPerformed(evt);
            }
        });

        btn_massive_load.setText("Generar Orden de Internamiento");
        btn_massive_load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_massive_loadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_massive_loadLayout = new javax.swing.GroupLayout(pnl_massive_load);
        pnl_massive_load.setLayout(pnl_massive_loadLayout);
        pnl_massive_loadLayout.setHorizontalGroup(
            pnl_massive_loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_massive_loadLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lbl_route)
                .addGap(18, 18, 18)
                .addGroup(pnl_massive_loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_massive_loadLayout.createSequentialGroup()
                        .addComponent(btn_massive_load)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnl_massive_loadLayout.createSequentialGroup()
                        .addComponent(txt_route, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(btn_searchFile, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        pnl_massive_loadLayout.setVerticalGroup(
            pnl_massive_loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_massive_loadLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnl_massive_loadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_route)
                    .addComponent(txt_route, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_searchFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_massive_load)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_order.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle de Orden de Internamiento"));

        tbl_orderDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "N° Linea", "Id Producto", "Producto", "Fecha Vencimiento", "Cantidad Pallets"
            }
        ));
        tbl_orderDetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_orderDetailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_orderDetail);

        btn_Cancel.setText("Cancelar");
        btn_Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelActionPerformed(evt);
            }
        });

        btn_saveOrder.setText("Guardar");
        btn_saveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_orderLayout = new javax.swing.GroupLayout(pnl_order);
        pnl_order.setLayout(pnl_orderLayout);
        pnl_orderLayout.setHorizontalGroup(
            pnl_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_orderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_orderLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_orderLayout.createSequentialGroup()
                        .addComponent(btn_saveOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Cancel)
                        .addGap(28, 28, 28))))
        );
        pnl_orderLayout.setVerticalGroup(
            pnl_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_orderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(pnl_orderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cancel)
                    .addComponent(btn_saveOrder))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnl_massive_load, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_product_int, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_order, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pnl_product_int, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_massive_load, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_order, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchFileActionPerformed
        txt_idOrderInt.setEnabled(false);
        txt_idProduct.setEnabled(false);
        txt_quantityPallet.setEnabled(false);
        jDate_dateOrder.setEnabled(false);
        btn_addProduct.setEnabled(false);
        btn_manual_load.setEnabled(false);
        btn_massive_load.setEnabled(true);
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccione la Orden de Internamiento");
        fileChooser.showDialog(this, null);
        try {
            directory = fileChooser.getSelectedFile().getAbsolutePath();
            txt_route.setText(directory);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_searchFileActionPerformed

    private void btn_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelActionPerformed

        menu_padre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_CancelActionPerformed

    private void txt_idProductFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idProductFocusLost
        Product product = new Product();
        if (txt_idProduct.getText().length() != 0) {
            int idProduct = Integer.parseInt(txt_idProduct.getText());
            product = daoProducts.ProductsGet(idProduct);

            if (product != null) {
                txt_nameProduct.setBorder(BorderFactory.createLineBorder(Color.green));
                txt_nameProduct.setText(product.getName());
                btn_addProduct.setEnabled(true);
            } else {
                btn_addProduct.setEnabled(false);
                txt_nameProduct.setBorder(BorderFactory.createLineBorder(Color.red));
                txt_nameProduct.setForeground(Color.red);
                txt_nameProduct.setText("El producto no existe");
            }
        }
    }//GEN-LAST:event_txt_idProductFocusLost

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        menu_padre.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void tbl_orderDetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_orderDetailMouseClicked
//        if (evt.getSource() == tbl_orderDetail) {
//            int rowSel = tbl_orderDetail.getSelectedRow();
//            int colSel = tbl_orderDetail.getSelectedColumn();
//            if (colSel == 0) {
//                Frm_IntermentOrder_Detail frm_prodIntDetail = new Frm_IntermentOrder_Detail(this);
//                frm_prodIntDetail.setVisible(true);;
//                frm_prodIntDetail.setLocation(300, 100);
//                frm_prodIntDetail.setLocationRelativeTo(null);
//                this.setVisible(false);
//            }
//        }
    }//GEN-LAST:event_tbl_orderDetailMouseClicked

    private void btn_addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addProductActionPerformed

        Object[] options = {"OK"};
        int ok_option;
        if (txt_idOrderInt.getText().toString().length() != 9 || !Validate.validarEntero(txt_idOrderInt.getText())) {
            ok_option = JOptionPane.showOptionDialog(new JFrame(), "El código de internamiento debe tener 9 dígitos", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            txt_idOrderInt.requestFocusInWindow();
        } else {
            txt_route.setEnabled(false);
            btn_searchFile.setEnabled(false);
            btn_massive_load.setEnabled(false);
            Date dateOrder = new Date();
            if (jDate_dateOrder.getDate() != null) {
                dateOrder = jDate_dateOrder.getDate();
            }
            InternmentOrderDetail intOrdDetail = new InternmentOrderDetail();
            Product prodLine = new Product();
            if (internmentOrder == null) {
                txt_idOrderInt.setEnabled(false);
                jDate_dateOrder.setEnabled(false);
                btn_manual_load.setEnabled(true);
                internmentOrder = new InternmentOrder();
                internmentOrder.setIdInternmentOrder(Integer.parseInt(txt_idOrderInt.getText()));
                internmentOrder.setDate(dateOrder);
                internmentOrder.setStatus(1);
                intOrderDetListManual = new ArrayList<>();
            }
            prodLine = daoProducts.ProductsGet(Integer.parseInt(txt_idProduct.getText()));
            intOrdDetail.setIdInternmentOrderDetail(lineIntOrdDetailManual);
            intOrdDetail.setProduct(prodLine);
            intOrdDetail.setQuantityPallets(Integer.parseInt(txt_quantityPallet.getText()));
            intOrdDetail.setStatus(1);
            intOrderDetListManual.add(intOrdDetail);
            txt_idProduct.setText("");
            txt_nameProduct.setText("");
            txt_quantityPallet.setText("");
            lineIntOrdDetailManual += 1;
            initilizeTable();
        }
    }//GEN-LAST:event_btn_addProductActionPerformed

    private void btn_manual_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_manual_loadActionPerformed

        Object[] options = {"OK"};
        if (JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?",
                "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            internmentOrder.setInternmentOrderDetail(intOrderDetListManual);
            btn_saveOrder.setEnabled(true);
            int ok_option = JOptionPane.showOptionDialog(new JFrame(), "Se ha generado la orden de internamiento con éxito", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        }
    }//GEN-LAST:event_btn_manual_loadActionPerformed

    private void btn_massive_loadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_massive_loadActionPerformed
        Object[] options = {"OK"};
        int ok_option;
        if (directory == null) {
            ok_option = JOptionPane.showOptionDialog(new JFrame(), "Seleccione un archivo", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            txt_idOrderInt.requestFocusInWindow();
        } else {
            if (JOptionPane.showConfirmDialog(new JFrame(), "¿Desea realizar acción?",
                    "Advertencias", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                Integer nroLineTxtFile = 0, idIntOrderTxt;
                String line = null, dateTxt;

                File file = new File(directory);
                BufferedReader reader = null;

                try {
                    internmentOrder = new InternmentOrder();
                    reader = new BufferedReader(new FileReader(file));
                    idIntOrderTxt = Integer.parseInt(reader.readLine().split(",")[1]);
                    dateTxt = reader.readLine().split(",")[1];
                    reader.readLine();
                    reader.readLine();
                    internmentOrder.setIdInternmentOrder(idIntOrderTxt);

                    internmentOrder.setDate(formatDate.parse(dateTxt));
                    intOrderDetListMassive = new ArrayList<>();
                    while ((line = reader.readLine()) != null) {
                        InternmentOrderDetail intOrdDetail = new InternmentOrderDetail();
                        String[] lineArray = line.split(",");
                        Product prodline = new Product();
                        prodline = daoProducts.ProductsGet(Integer.parseInt(lineArray[1]));
                        intOrdDetail.setIdInternmentOrderDetail(Integer.parseInt(lineArray[0]));
                        intOrdDetail.setProduct(prodline);
                        intOrdDetail.setQuantityPallets(Integer.parseInt(lineArray[2]));
                        intOrdDetail.setStatus(1);
                        intOrderDetListMassive.add(intOrdDetail);
                    }
                    internmentOrder.setInternmentOrderDetail(intOrderDetListMassive);
                    internmentOrder.setStatus(1);
                    initilizeTable();
                    btn_saveOrder.setEnabled(true);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException ex) {
                    Logger.getLogger(Frm_IntermentOrder_Load.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Frm_IntermentOrder_Load.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                ok_option = JOptionPane.showOptionDialog(new JFrame(), "Se ha generado la orden de internamiento con éxito", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            }
        }
    }//GEN-LAST:event_btn_massive_loadActionPerformed

    private void btn_saveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveOrderActionPerformed
        tarea = new BarraProgreso();
        tarea.execute();
    }//GEN-LAST:event_btn_saveOrderActionPerformed

    private void txt_idOrderIntFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idOrderIntFocusLost
//        Object[] options = {"OK"};
//        int ok_option;
//        if (txt_idOrderInt.getText().toString().length() != 9 || !Validate.validarEntero(txt_idOrderInt.getText())) {
//            ok_option = JOptionPane.showOptionDialog(new JFrame(), "El código de internamiento debe tener 9 dígitos", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//        }        
//        txt_idOrderInt.requestFocusInWindow();
    }//GEN-LAST:event_txt_idOrderIntFocusLost

    private void txt_idProductFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_idProductFocusGained
//        Object[] options = {"OK"};
//        int ok_option;
//        if (txt_idOrderInt.getText().toString().length() != 9 || !Validate.validarEntero(txt_idOrderInt.getText())) {
//            ok_option = JOptionPane.showOptionDialog(new JFrame(), "El código de internamiento debe tener 9 dígitos", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//        }        
//        txt_idOrderInt.requestFocusInWindow();
    }//GEN-LAST:event_txt_idProductFocusGained

    private void jDate_dateOrderFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jDate_dateOrderFocusGained
//        Object[] options = {"OK"};
//        int ok_option;
//        if (txt_idOrderInt.getText().toString().length() != 9 || !Validate.validarEntero(txt_idOrderInt.getText())) {
//            ok_option = JOptionPane.showOptionDialog(new JFrame(), "El código de internamiento debe tener 9 dígitos", "Mensaje", JOptionPane.PLAIN_MESSAGE, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
//        }        
//        txt_idOrderInt.requestFocusInWindow();
    }//GEN-LAST:event_jDate_dateOrderFocusGained

    public void initilizeTable() {
        modelo.getDataVector().removeAllElements();
        modelo.fireTableDataChanged();
        List<InternmentOrderDetail> intOrdDetailList = null;
        if (intOrderDetListManual != null) {
            intOrdDetailList = intOrderDetListManual;
        } else {
            intOrdDetailList = intOrderDetListMassive;
        }
        try {
            for (int i = 0; i < intOrdDetailList.size(); i++) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(internmentOrder.getDate());
                cal.add(Calendar.DATE, intOrdDetailList.get(i).getProduct().getTimeExpiration());
                Object[] fila = {intOrdDetailList.get(i).getIdInternmentOrderDetail(),
                    intOrdDetailList.get(i).getProduct().getIdProduct(), intOrdDetailList.get(i).getProduct().getName(),
                    formatDate.format(cal.getTime()), intOrdDetailList.get(i).getQuantityPallets()};
                modelo.addRow(fila);
            }
        } catch (Exception e) {
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_addProduct;
    private javax.swing.JButton btn_manual_load;
    private javax.swing.JButton btn_massive_load;
    private javax.swing.JButton btn_saveOrder;
    private javax.swing.JButton btn_searchFile;
    private com.toedter.calendar.JDateChooser jDate_dateOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_Product;
    private javax.swing.JLabel lbl_date;
    private javax.swing.JLabel lbl_orderInterment;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_route;
    private javax.swing.JLabel lbl_validate;
    private javax.swing.JPanel pnl_massive_load;
    private javax.swing.JPanel pnl_order;
    private javax.swing.JPanel pnl_product_int;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTable tbl_orderDetail;
    private javax.swing.JTextField txt_idOrderInt;
    private javax.swing.JTextField txt_idProduct;
    private javax.swing.JTextField txt_nameProduct;
    private javax.swing.JTextField txt_quantityPallet;
    private javax.swing.JTextField txt_route;
    // End of variables declaration//GEN-END:variables
}
