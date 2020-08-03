/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.Batch_receiveController;
import lk.edu.ijse.sas.controller.custom.CompanyController;
import lk.edu.ijse.sas.controller.custom.GrnController;
import com.sas.kem.edu.ijse.dto.Batch_receiveDTO;
import com.sas.kem.edu.ijse.dto.CompanyDTO;
import com.sas.kem.edu.ijse.dto.GrnDTO;
import lk.edu.ijse.sas.other.JRViewerFX;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class BuyTaxPreviewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXComboBox cmbGrn;
    
    @FXML
    private JFXButton btnInvoice1;
    
    @FXML
    private JFXButton btnInvoice2;
    
    @FXML
    private JFXButton btnCancel;
    
    @FXML
    private JFXTextField txtOid;
    
    @FXML
    private JFXTextField txtNo;
    
    @FXML
    private JFXTextField txtVatNo;
    
    @FXML
    private JFXTextField txtCustNo;
    
    @FXML
    private JFXTextField txtVtRate;
    
    private GrnController ctrlGrn;
    private Batch_receiveController ctrlBatch;
    private CompanyController ctrlCom;
    
    public static boolean b;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnCancel.setVisible(b);
        
        ctrlGrn=(GrnController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.GRN);
        ctrlBatch=(Batch_receiveController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.BATCH_RECEIVE);
        ctrlCom=(CompanyController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.COMPANY);
        
        loadCmbGrn();
        cmbGrn.getSelectionModel().selectLast();
    }    
    
    @FXML
    private void cmbGrnOnAction(ActionEvent evt){
        txtOid.requestFocus();
    }

    private void loadCmbGrn() {
        
        try {
            ArrayList<GrnDTO> glist=ctrlGrn.getAll();
            for (GrnDTO grnDTO : glist) {
                cmbGrn.getItems().add(grnDTO.getGrid());
            }
        } catch (Exception ex) {
            Logger.getLogger(BuyTaxPreviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    @FXML
    private void btnInvoice1OnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        try {
            String grn=cmbGrn.getSelectionModel().getSelectedItem().toString();
            
            JRViewerFX view=new JRViewerFX();
            
            String path="/com/sas/kem/edu/ijse/report/Tax.jasper";
            HashMap<String,Object> parameters=new HashMap<>();
            
            parameters.put("gr", grn);
            parameters.put("oid", txtOid.getText());
            parameters.put("no",txtNo.getText());
            parameters.put("vatNo",txtVatNo.getText());
            parameters.put("custNo",txtCustNo.getText());
            parameters.put("vRate",new BigDecimal(txtVtRate.getText()));
            
            BigDecimal grTotal=null;
            
            ArrayList<GrnDTO> glist=ctrlGrn.getAll();
            for (GrnDTO grnDTO : glist) {
                if(grn.equals(grnDTO.getGrid())){
                    grTotal=grnDTO.getGrandTotal();
                    
                    ArrayList<CompanyDTO> clist=ctrlCom.getAll();
                    for (CompanyDTO companyDTO : clist) {
                        if(grnDTO.getCid().equals(companyDTO.getCid())){
                            parameters.put("name", companyDTO.getComName());
                            parameters.put("adNo", companyDTO.getAddressNo());
                            parameters.put("adLane", companyDTO.getAddressLane());
                            parameters.put("adArea", companyDTO.getAddressArea());
                            parameters.put("adCity", companyDTO.getAddressCity());
                        }
                    }
                }
            }
            BigDecimal totVat=new BigDecimal(0);
            ArrayList<Batch_receiveDTO> blist=ctrlBatch.getAll();
            for (Batch_receiveDTO batch_receiveDTO : blist) {
                if(grn.equals(batch_receiveDTO.getGrid())){
                    BigDecimal total=batch_receiveDTO.getTotal();
                    BigDecimal precentage=new BigDecimal(txtVtRate.getText());
                    totVat=((total.multiply(precentage)).divide(new BigDecimal(100))).add(totVat);

                }
            }
            
            BigDecimal grandTotal=totVat.add(grTotal);
            
            String grnTotal=df.format(grandTotal);
            String totalVat=df.format(totVat);
            
            parameters.put("totVat", totalVat);
            parameters.put("grandTot", grnTotal);
            
            view.showReport(path, parameters);
            
        } catch (Exception ex) {
            Logger.getLogger(BuyTaxPreviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnInvoice2OnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        try {
            String grn=cmbGrn.getSelectionModel().getSelectedItem().toString();
            
            JRViewerFX view=new JRViewerFX();
            
            String path="/com/sas/kem/edu/ijse/report/TaxYellow.jasper";
            HashMap<String,Object> parameters=new HashMap<>();
            
            parameters.put("gr", grn);
            parameters.put("oid", txtOid.getText());
            parameters.put("no",txtNo.getText());
            parameters.put("vatNo",txtVatNo.getText());
            parameters.put("custNo",txtCustNo.getText());
            parameters.put("vRate",new BigDecimal(txtVtRate.getText()));
            
            BigDecimal grTotal=null;
            
            ArrayList<GrnDTO> glist=ctrlGrn.getAll();
            for (GrnDTO grnDTO : glist) {
                if(grn.equals(grnDTO.getGrid())){
                    grTotal=grnDTO.getGrandTotal();
                    
                    ArrayList<CompanyDTO> clist=ctrlCom.getAll();
                    for (CompanyDTO companyDTO : clist) {
                        if(grnDTO.getCid().equals(companyDTO.getCid())){
                            parameters.put("name", companyDTO.getComName());
                            parameters.put("adNo", companyDTO.getAddressNo());
                            parameters.put("adLane", companyDTO.getAddressLane());
                            parameters.put("adArea", companyDTO.getAddressArea());
                            parameters.put("adCity", companyDTO.getAddressCity());
                        }
                    }
                }
            }
            BigDecimal totVat=new BigDecimal(0);
            ArrayList<Batch_receiveDTO> blist=ctrlBatch.getAll();
            for (Batch_receiveDTO batch_receiveDTO : blist) {
                if(grn.equals(batch_receiveDTO.getGrid())){
                    BigDecimal total=batch_receiveDTO.getTotal();
                    BigDecimal precentage=new BigDecimal(txtVtRate.getText());
                    totVat=((total.multiply(precentage)).divide(new BigDecimal(100))).add(totVat);

                }
            }
            
            BigDecimal grandTotal=totVat.add(grTotal);
            
            String grnTotal=df.format(grandTotal);
            String totalVat=df.format(totVat);
            
            parameters.put("totVat", totalVat);
            parameters.put("grandTot", grnTotal);
            
            view.showReport(path, parameters);
            
        } catch (Exception ex) {
            Logger.getLogger(BuyTaxPreviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void btnCancelOnAction(ActionEvent evt){
        
        ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
        
    }
    @FXML
    private void txtOidOnAction(ActionEvent evt){
        txtNo.requestFocus();
        
    }
    @FXML
    private void txtNoOnAction(ActionEvent evt){
        txtVatNo.requestFocus();
        
    }
    @FXML
    private void txtVatNoOnAction(ActionEvent evt){
        txtCustNo.requestFocus();
        
    }
    @FXML
    private void txtCustNoOnAction(ActionEvent evt){
        txtVtRate.requestFocus();
        
    }
}
