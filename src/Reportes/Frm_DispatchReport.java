/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Reportes;

import JasperReports.Prueba;
import Seguridad.Frm_MenuPrincipal;
import dao.DaoPalletProduct;
import dao.impl.DaoPalletIniImpl;
import dao.impl.DaoPalletProductImpl;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Model.DispatchOrder;
import dao.DaoClient;
import dao.impl.DaoClientImpl;


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
    
    
    public boolean validanumorden()
    { boolean b=true; 
      Integer cantreg=0; 
      Integer numorden=0; 
      
      if ( (txt_NumOrden.getText().toString().isEmpty() )|| (txt_NumOrden.getText().equals(null) ) )
      { b=false;}   
      else 
      {
       try{
        numorden=Integer.parseInt(txt_NumOrden.getText()); 
          DaoPalletProduct dao=new DaoPalletProductImpl();
          cantreg=dao.GetCantNumord(numorden);
          if ( cantreg==0 )
          {String message = "El numero de Orden de Internamiento no existe o está inactiva";
          String title = "Información";
          JFrame frame = new JFrame(" ");
          JOptionPane.showMessageDialog(frame,message,title,JOptionPane.WARNING_MESSAGE);
          JOptionPane.setDefaultLocale(null);   
          b=false;
          }
      }catch(Exception e)
      {   String message = "El numero de Orden debe ser Entero";
          String title = "Información";
          JFrame frame = new JFrame(" ");
          JOptionPane.showMessageDialog(frame,message,title,JOptionPane.WARNING_MESSAGE);
          JOptionPane.setDefaultLocale(null);
          b=false;
      }   
    }
    return b;      
    }        

    public boolean validanumpicking()
    { boolean b=true; 
      Integer cantreg=0; 
      Integer numpicking=0; 
      
      if ( (txt_numpicking.getText().toString().isEmpty() )|| (txt_numpicking.getText().equals(null) ) )
      { b=false;}   
      else 
      {
       try{
        numpicking=Integer.parseInt(txt_numpicking.getText()); 
          DaoPalletProduct dao=new DaoPalletProductImpl();
          cantreg=dao.GetCantNumpicking(numpicking);
          if ( cantreg==0 )
          {String message = "El numero de Orden de Picking no existe o está inactiva";
          String title = "Información";
          JFrame frame = new JFrame(" ");
          JOptionPane.showMessageDialog(frame,message,title,JOptionPane.WARNING_MESSAGE);
          JOptionPane.setDefaultLocale(null);   
          b=false;
          }
      }catch(Exception e)
      {   String message = "El numero de Orden Picking debe ser Entero";
          String title = "Información";
          JFrame frame = new JFrame(" ");
          JOptionPane.showMessageDialog(frame,message,title,JOptionPane.WARNING_MESSAGE);
          JOptionPane.setDefaultLocale(null);
          b=false;
      }   
    }
    return b;      
    }        
    
    public String obtiene_where()
    { 
      String Cadenawhere="";
      Integer numorden=0; 
      Integer numpick=0; 
      String cliente="";
       Integer anho1; 
       Integer anho2; 
       Integer mes1; 
       Integer mes2; 
       Integer dia1; 
       Integer dia2;
       Integer fechainicial=0; 
       Integer fechafinal=0 ; 
       String datefecini=""; 
       String datefecfin=""; 
      
       
      if ( txt_NumOrden.getText().toString().isEmpty() || (txt_NumOrden.getText().equals(null) ) ) 
        { Cadenawhere=Cadenawhere+ " where (1=1)  and "; }     
      else   
        {numorden=Integer.parseInt(txt_NumOrden.getText().toString());
         Cadenawhere=Cadenawhere+ "   where idDispatch_Order= "+numorden + "  and ";
        }

      if ( txt_numpicking.getText().toString().isEmpty() || (txt_numpicking.getText().equals(null) ) ) 
        { Cadenawhere=Cadenawhere+ "  (1=1)  and "; }     
      else   
      { numpick=Integer.parseInt(txt_numpicking.getText().toString());
        Cadenawhere=Cadenawhere+ "  idDispatch_Order= "+numorden + "  and ";      
      }
      
      if ( txt_client.getText().toString().isEmpty() || (txt_client.getText().equals(null) ) ) 
        { Cadenawhere=Cadenawhere+ "  (1=1)  and "; }     
      else
      {   cliente=txt_client.getText().toString();
          Cadenawhere=Cadenawhere+ "  idClient in (select idClient from client where upper(name) like '%"+cliente.toUpperCase()+"%'  )  and ";       
      }

        try 
        {
          String formato = jDate_in.getDateFormatString();
           //String formato = "YYYYMMDD";
           Date date1 = jDate_in.getDate();
           //SimpleDateFormat sdf = new SimpleDateFormat(formato);
           anho1=jDate_in.getCalendar().get(Calendar.YEAR);
           mes1=jDate_in.getCalendar().get(Calendar.MONTH)+1;
           dia1=jDate_in.getCalendar().get(Calendar.DAY_OF_MONTH);
           //datefecini = sdf.format(date1).toUpperCase();
           fechainicial=anho1*10000+mes1*100+dia1;
           datefecini=fechainicial.toString();
        } 
        catch (Exception e)   
        { if   (datefecini.length()>0 )
          {JOptionPane.showMessageDialog(null, "Debe Ingresar una Fecha Registro Valida", " Error..!!", JOptionPane.ERROR_MESSAGE);}
        }

       try 
        {  String formato = jDate_out.getDateFormatString();
           //String formato = "YYYYMMDD";
           //SimpleDateFormat sdf = new SimpleDateFormat(formato);
           anho2=jDate_out.getCalendar().get(Calendar.YEAR);
           mes2=jDate_out.getCalendar().get(Calendar.MONTH)+1;
           dia2=jDate_out.getCalendar().get(Calendar.DAY_OF_MONTH);
           //datefecini = sdf.format(date1).toUpperCase();
           fechafinal=anho2*10000+mes2*100+dia2;
           datefecfin=fechafinal.toString();            
        } 
        catch (Exception e)   
        {  if (datefecfin.length()>0)
            {JOptionPane.showMessageDialog(null, "Debe Ingresar una Fecha Entrega Valida", " Error..!!", JOptionPane.ERROR_MESSAGE);}
        }

        try
        {
        if ( (fechafinal<fechainicial) && (fechafinal*fechainicial>0)  )
          {JOptionPane.showMessageDialog(null, "La Fecha Entrega debe ser mayor a la Fecha de Registro", " Error Fechas..!!", JOptionPane.INFORMATION_MESSAGE); }   
        }
        catch(Exception e)
        { }    

        if (fechainicial>0)
        {Cadenawhere=Cadenawhere+ " (year(departure_date)*10000 +month(departure_date)*100  +day(departure_date) ) >= " +fechainicial +" and " ; 
        }
        else
        {Cadenawhere=Cadenawhere+ " (1=1) and ";
        }    
        if (fechafinal>0)        
        {Cadenawhere=Cadenawhere+"  (year(arrival_date)*10000 +month(arrival_date)*100  +day(arrival_date) ) <= " +fechafinal +" " ; }
        else
        {Cadenawhere=Cadenawhere+ " (1=1) ";
        }   
      
      return Cadenawhere;
     }      
    
    public void limpiatabla()
    {
        DefaultTableModel model= (DefaultTableModel)tbl_Dispatch.getModel(); 
        Integer cantreg=0; 
        cantreg=model.getRowCount();
        for(int i=0; i<cantreg; i++)       
        { model.removeRow(cantreg-i-1);
        }   
     }        
    
    public void filtra_tabla(String cadenawhere)
    {  limpiatabla();
       DaoPalletProduct objdao= new DaoPalletProductImpl();
       Integer cantreg= objdao.GetDispatchOrderList(cadenawhere).size();
       DispatchOrder[] list=new DispatchOrder[cantreg] ;  
       DefaultTableModel model= (DefaultTableModel)tbl_Dispatch.getModel();     
       DaoClient daocliente= new DaoClientImpl();
        for (int i=0; i<cantreg; i++)
         {  list[i]=objdao.GetDispatchOrderList(cadenawhere).get(i);
             model.addRow(new Object[]{list[i].getIdDispatch_Order(), daocliente.clientGet(list[i].getIdClient()).getName() ,list[i].getIdPickingOrder(),list[i].getDepartureDate(),list[i].getArrivalDate()} );           
         }   
       
       
     }       
    
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
        jLabel3 = new javax.swing.JLabel();
        txt_client = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_NumOrden = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_numpicking = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Dispatch = new javax.swing.JTable();
        btn_GenerarReporte = new javax.swing.JToggleButton();
        btn_Export = new javax.swing.JToggleButton();
        btn_Cancelar = new javax.swing.JToggleButton();
        btn_filtrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnl_DispatchReport.setBorder(javax.swing.BorderFactory.createTitledBorder("Criterios de filtro"));

        jLabel1.setText("Fecha de Registro");

        jLabel2.setText("Fecha Entrega Estimada ");

        jLabel3.setText("Cliente:");

        jLabel4.setText("Número de Orden:");

        txt_NumOrden.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_NumOrdenFocusLost(evt);
            }
        });

        jLabel9.setText("Número de Picking:");

        txt_numpicking.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_numpickingFocusLost(evt);
            }
        });

        tbl_Dispatch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orden Despach", "Cliente", "Num Picking", "Fecha llegada", "Fecha salida"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_Dispatch);

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

        btn_Cancelar.setText("Cancelar");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        btn_filtrar.setText("Filtrar");
        btn_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filtrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_DispatchReportLayout = new javax.swing.GroupLayout(pnl_DispatchReport);
        pnl_DispatchReport.setLayout(pnl_DispatchReportLayout);
        pnl_DispatchReportLayout.setHorizontalGroup(
            pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(btn_GenerarReporte)
                        .addGap(72, 72, 72)
                        .addComponent(btn_Export, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_DispatchReportLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                                .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_client, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                                        .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_NumOrden)
                                            .addComponent(jDate_in, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE))
                                        .addGap(68, 68, 68)
                                        .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_numpicking)
                                            .addComponent(jDate_out, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)))))
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        pnl_DispatchReportLayout.setVerticalGroup(
            pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_NumOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txt_numpicking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                        .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jDate_in, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                        .addGroup(pnl_DispatchReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_GenerarReporte)
                            .addComponent(btn_Export)
                            .addComponent(btn_Cancelar)
                            .addComponent(btn_filtrar)))
                    .addGroup(pnl_DispatchReportLayout.createSequentialGroup()
                        .addComponent(jDate_out, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl_DispatchReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnl_DispatchReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        this.dispose();
        menuaux.setVisible(true);
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void txt_NumOrdenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_NumOrdenFocusLost
        // TODO add your handling code here:
        //txt_NumOrden
        boolean b=false;
        b=validanumorden();
        if (b)
        {System.out.println("Valido correctamente la orden de internamiento");
        }

    }//GEN-LAST:event_txt_NumOrdenFocusLost

    private void btn_ExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExportActionPerformed
        Prueba pru = new Prueba();
        pru.exportarReporte();
    }//GEN-LAST:event_btn_ExportActionPerformed

    private void btn_GenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GenerarReporteActionPerformed
        Prueba pru = new Prueba();
        pru.mostrarReporte();
    }//GEN-LAST:event_btn_GenerarReporteActionPerformed

    private void txt_numpickingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_numpickingFocusLost
    //txt_numpicking
        // TODO add your handling code here:
        boolean b=false;
        b=validanumpicking();
        if (b)
        {System.out.println("Valido correctamente la orden de internamiento");
        }

    }//GEN-LAST:event_txt_numpickingFocusLost

    private void btn_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filtrarActionPerformed
    String cadenawhere="";
    cadenawhere=obtiene_where();
    filtra_tabla(cadenawhere);
    }//GEN-LAST:event_btn_filtrarActionPerformed

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
    private javax.swing.JButton btn_filtrar;
    private com.toedter.calendar.JDateChooser jDate_in;
    private com.toedter.calendar.JDateChooser jDate_out;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnl_DispatchReport;
    private javax.swing.JTable tbl_Dispatch;
    private javax.swing.JTextField txt_NumOrden;
    private javax.swing.JTextField txt_client;
    private javax.swing.JTextField txt_numpicking;
    // End of variables declaration//GEN-END:variables
}
