/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.CompanyController;
import lk.edu.ijse.sas.controller.custom.OrdersController;
import com.sas.kem.edu.ijse.dto.OrdersDTO;
import lk.edu.ijse.sas.other.JRViewerFX;
import java.net.URL;
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
public class OrderPreviewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXComboBox cmbPo;
    
    @FXML
    private JFXComboBox cmbBill;
    
    @FXML
    private JFXButton btnBill;
    
    @FXML
    private JFXButton btnInvoice1;
    
    @FXML
    private JFXButton btnInvoice2;
    
    @FXML
    private JFXButton btnInvoice3;
    
    @FXML
    private JFXButton btnCancel;
    
    private OrdersController ctrlOrders;
    private CompanyController ctrlCom;
    
    public static String custName;
    public static boolean b;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btnCancel.setVisible(b);
        
        ctrlOrders=(OrdersController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.ORDERS);
        ctrlCom=(CompanyController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.COMPANY);
        loadCmbPo();
        loadCmbBill();
        cmbBill.getSelectionModel().selectLast();
        cmbPo.getSelectionModel().selectLast();
        
    }    

    private void loadCmbPo() {
        
        try {
            ArrayList<OrdersDTO> olist=ctrlOrders.getAll();
            for (OrdersDTO ordersDTO : olist) {
                char[] po=ordersDTO.getPo().toCharArray();
                if(!(po[0]=='B' && po[1]=='L')){
                    cmbPo.getItems().add(ordersDTO.getPo());
                }
                
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderPreviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void BtnBillOnAction(ActionEvent evt){
        
        try {
            
            String bl=cmbBill.getSelectionModel().getSelectedItem().toString();
            String od=null;
            String cid=custName;
            
            ArrayList<OrdersDTO> list=ctrlOrders.getAll();
            for (OrdersDTO ordersDTO : list) {
                if(bl.equals(ordersDTO.getPo())){
                    od=ordersDTO.getOid();
                    
                }
            }
            
            JRViewerFX view=new JRViewerFX();
            String path="/com/sas/kem/edu/ijse/report/Bill.jasper";
            
            HashMap<String,Object> parameters=new HashMap<>();
            parameters.put("bl", bl);
            parameters.put("no", od);
            parameters.put("name", cid);
            
            view.showReport(path, parameters);
        } catch (Exception ex) {
            Logger.getLogger(OrderPreviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void BtnInvoice1OnAction(ActionEvent evt){
        
        try {
            
            String po=cmbPo.getSelectionModel().getSelectedItem().toString();
            String od=null;
            String cid=null;
            
            ArrayList<OrdersDTO> list=ctrlOrders.getAll();
            for (OrdersDTO ordersDTO : list) {
                if(po.equals(ordersDTO.getPo())){
                    od=ordersDTO.getOid();
                    cid=ordersDTO.getCid();
                }
            }
            
            String com=ctrlCom.getComName(cid);
            
            JRViewerFX view=new JRViewerFX();
            String path="/com/sas/kem/edu/ijse/report/Order.jasper";
            
            HashMap<String,Object> parameters=new HashMap<>();
            parameters.put("po", po);
            parameters.put("no", od);
            parameters.put("to", com);
            
            view.showReport(path, parameters);
        } catch (Exception ex) {
            Logger.getLogger(OrderPreviewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @FXML
    private void BtnInvoice2OnAction(ActionEvent evt){
        
        try {
            
            String po=cmbPo.getSelectionModel().getSelectedItem().toString();
            String od=null;
            String cid=null;
            
            ArrayList<OrdersDTO> list=ctrlOrders.getAll();
            for (OrdersDTO ordersDTO : list) {
                if(po.equals(ordersDTO.getPo())){
                    od=ordersDTO.getOid();
                    cid=ordersDTO.getCid();
                }
            }
            
            String com=ctrlCom.getComName(cid);
            
            JRViewerFX view=new JRViewerFX();
            String path="/com/sas/kem/edu/ijse/report/OrderRed.jasper";
            
            HashMap<String,Object> parameters=new HashMap<>();
            parameters.put("po", po);
            parameters.put("no", od);
            parameters.put("to", com);
            
            view.showReport(path, parameters);
        } catch (Exception ex) {
            Logger.getLogger(OrderPreviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void BtnInvoice3OnAction(ActionEvent evt){
        
        try {
            
            String po=cmbPo.getSelectionModel().getSelectedItem().toString();
            String od=null;
            String cid=null;
            
            ArrayList<OrdersDTO> list=ctrlOrders.getAll();
            for (OrdersDTO ordersDTO : list) {
                if(po.equals(ordersDTO.getPo())){
                    od=ordersDTO.getOid();
                    cid=ordersDTO.getCid();
                }
            }
            
            String com=ctrlCom.getComName(cid);
            
            JRViewerFX view=new JRViewerFX();
            String path="/com/sas/kem/edu/ijse/report/OrderBlue.jasper";
            
            HashMap<String,Object> parameters=new HashMap<>();
            parameters.put("po", po);
            parameters.put("no", od);
            parameters.put("to", com);
            
            view.showReport(path, parameters);
        } catch (Exception ex) {
            Logger.getLogger(OrderPreviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void btnCancelOnAction(ActionEvent evt){
        
        ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();


    }

    private void loadCmbBill() {

        try {
            ArrayList<OrdersDTO> list=ctrlOrders.getAll();
            for (OrdersDTO ordersDTO : list) {
                char[] bill=ordersDTO.getPo().toCharArray();
                if(bill[0]=='B' && bill[1]=='L'){
                    cmbBill.getItems().add(ordersDTO.getPo());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderPreviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
