/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.other;

import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author dimuthu
 */
public class JRViewerFX  extends JFrame{
    
    private Connection conn;
   
    public JRViewerFX() throws HeadlessException {
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    public void showReport(String path,HashMap<String,Object> parameters){
        
        try {
            JasperReport compiledReport=(JasperReport) JRLoader.loadObject(getClass().getResourceAsStream(path));
            JasperPrint printReport=JasperFillManager.fillReport(compiledReport, parameters,conn);
            JRViewer viewReport=new JRViewer(printReport);
            viewReport.setOpaque(true);
            viewReport.setVisible(true);
            
            this.add(viewReport);
            this.setSize(1300,700);
            this.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(JRViewerFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void showReport(String path){
        
        try {
            JasperReport compiledReport=(JasperReport) JRLoader.loadObject(getClass().getResourceAsStream(path));
            JasperPrint printReport=JasperFillManager.fillReport(compiledReport, new HashMap<>(),conn);
            JRViewer viewReport=new JRViewer(printReport);
            viewReport.setOpaque(true);
            viewReport.setVisible(true);
            
            this.add(viewReport);
            this.setSize(1300,700);
            this.setVisible(true);
            
        } catch (JRException ex) {
            Logger.getLogger(JRViewerFX.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
