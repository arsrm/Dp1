/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JasperReports;

import enlaceBD.ConectaDb;
import java.awt.Frame;
import java.sql.Connection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.runtime.Debug.id;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Kari
 */
public class Prueba {

    private final ConectaDb db;
    Connection cn;

    public Prueba() {
        db = new ConectaDb();
        cn = db.getConnection();
    }

    public void mostrarReporte() {
        try {

            HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap();
            JasperReport reporte = JasperCompileManager.compileReport("report2.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, null, cn);
            
   //        JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void exportarReporte() {
        try {

            JasperReport reporte = JasperCompileManager.compileReport("report2.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, null, cn);
            
            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarReporteKardexConFiltro(Integer idP, Integer idA, Date dI, Date dF) {
        try {
           HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap(); 
            parameters.put("idW",idA);
            parameters.put("idP", idP);
            parameters.put("fechaI", dI);
            parameters.put("fechaF", dF);
            
            JasperReport reporte = JasperCompileManager.compileReport("reportKardexConFiltro.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, parameters, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte de Kardex");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarReporteKardexSinFiltro(Date dI, Date dF) {
        try {
           HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap(); 
//            parameters.put("idW",idA);
//            parameters.put("idP", idP);
            parameters.put("fechaI", dI);
            parameters.put("fechaF", dF);
            
            JasperReport reporte = JasperCompileManager.compileReport("reportKardexSinFiltro.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, parameters, cn);
            
            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteKardex.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte de Kardex sin filtro");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarReporteKardexXProducto(Integer idProduct, Date dateI, Date dateF) {
        try {
           HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap(); 
            
            parameters.put("idP", idProduct);
            parameters.put("fechaI", dateI);
            parameters.put("fechaF", dateF);
            
            JasperReport reporte = JasperCompileManager.compileReport("reportKardexXProducto.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, parameters, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte de Kardex");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarReporteKardexXAlmacen(Integer idAlmacen, Date dateI, Date dateF) {
        try {
           HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap(); 
            parameters.put("idW",idAlmacen);
            parameters.put("fechaI", dateI);
            parameters.put("fechaF", dateF);
            
            JasperReport reporte = JasperCompileManager.compileReport("reportKardexXAlmacen.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, parameters, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte de Kardex");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void exportarReporteKardexXProducto() {
        try {

            JasperReport reporte = JasperCompileManager.compileReport("kardexReport.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, null, cn);
            
            JasperExportManager.exportReportToPdfFile(p,"Reportes/kardexReport.pdf");
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void mostrarReporteStockSinFiltro() {
        try {

//            HashMap JasperParameter = new HashMap();  
//            Map parameters = new HashMap();
            JasperReport reporte = JasperCompileManager.compileReport("reportStockSinFiltro.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, null, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte de stock");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarReporteStockConFiltro(Integer idAl,Integer idP,Date dateEndSearch){
        try {
           HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap(); 
            parameters.put("idW",idAl);
            parameters.put("idP", idP);
            parameters.put("dateStock", dateEndSearch);
           
            
            JasperReport reporte = JasperCompileManager.compileReport("reportStockConFiltro.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, parameters, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte de Stock");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarReporteStockXAlamacen(Integer idAl){
        try {
           HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap(); 
            parameters.put("idW",idAl);
            
           
            
            JasperReport reporte = JasperCompileManager.compileReport("reportStockxAlmacen.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, parameters, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte de Stock");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarReporteStockXProducto(Integer idP){
        try {
           HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap(); 
            parameters.put("idP",idP);
            
           
            
            JasperReport reporte = JasperCompileManager.compileReport("reportStockxProducto.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, parameters, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte de Stock");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarReporteStockXFecha(Date dateEndSearch){
        try {
           HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap(); 
            parameters.put("dateStock",dateEndSearch);
            
           
            
            JasperReport reporte = JasperCompileManager.compileReport("reportStockxFecha.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, parameters, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte de Stock");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarReporteStockXAlmacenYProducto(Integer idAl,Integer idP){
        try {
           HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap(); 
            parameters.put("idW",idAl);
            parameters.put("idP", idP);
            
           
            
            JasperReport reporte = JasperCompileManager.compileReport("reportStockxAP.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, parameters, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte de Stock");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarReporteStockXAlmacenYFecha(Integer idAl,Date dateEndSearch){
        try {
           HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap(); 
            parameters.put("idW",idAl);
            parameters.put("dateStock",dateEndSearch);
           
            
            JasperReport reporte = JasperCompileManager.compileReport("reportStockxAF.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, parameters, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte de Stock");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarReporteStockXProductoYFecha(Integer idP,Date dateEndSearch){
        try {
           HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap(); 
            parameters.put("idP",idP);
            parameters.put("dateStock",dateEndSearch);
           
            
            JasperReport reporte = JasperCompileManager.compileReport("reportStockxPF.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, parameters, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte de Stock");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarReporteLibreDispSinFiltro( ) {
        try {

//            HashMap JasperParameter = new HashMap();  
//            Map parameters = new HashMap();
            JasperReport reporte = JasperCompileManager.compileReport("reportLibreDispSinFiltro.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, null, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte de stock");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void mostrarReporteLibreDispConFiltro(Integer idP){
        try {
           HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap(); 
            parameters.put("idP",idP);
            
           
            
            JasperReport reporte = JasperCompileManager.compileReport("reportLibreDispConFiltro.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, parameters, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte de Stock");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mostrarReporteLog(String dI, String dF) {
   
    try {
           HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap(); 

            parameters.put("fechaI", dI);
            parameters.put("fechaF", dF);
            
            JasperReport reporte = JasperCompileManager.compileReport("reportL.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, parameters, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte Log");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void mostrarReporteKardexSinFiltro2(String dI, String dF) {
   
    try {
           HashMap JasperParameter = new HashMap();  
            Map parameters = new HashMap(); 

            parameters.put("fechaI", dI);
            parameters.put("fechaF", dF);
            
            JasperReport reporte = JasperCompileManager.compileReport("reportKardex2.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, parameters, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
            JasperViewer view = new JasperViewer(p, false);
            view.setTitle("Reporte Kardex");
            view.setExtendedState(Frame.MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Prueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
