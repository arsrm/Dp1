/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JasperReports;

import enlaceBD.ConectaDb;
import java.awt.Frame;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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

            JasperReport reporte = JasperCompileManager.compileReport("report2.jrxml");
            JasperPrint p = JasperFillManager.fillReport(reporte, null, cn);
            
//            JasperExportManager.exportReportToPdfFile(p,"Reportes/reporteReceta.pdf");
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
}
