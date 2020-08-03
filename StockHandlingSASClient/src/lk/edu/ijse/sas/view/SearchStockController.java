/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXComboBox;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.Batch_addController;
import lk.edu.ijse.sas.controller.custom.Batch_receiveController;
import lk.edu.ijse.sas.controller.custom.MaterialController;
import lk.edu.ijse.sas.controller.custom.ProductController;
import lk.edu.ijse.sas.controller.custom.Return_batch_receiveController;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import com.sas.kem.edu.ijse.dto.Batch_receiveDTO;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import com.sas.kem.edu.ijse.dto.Return_batch_receiveDTO;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class SearchStockController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXComboBox cmbMaterial;
    
    @FXML
    private JFXComboBox cmbProduction;
    
    @FXML
    private JFXComboBox cmbMaBatch;
    
    @FXML
    private JFXComboBox cmbProBatch;
    
    @FXML
    private TextField txtMatTotal;
    
    @FXML
    private TextField txtProTotal;
    
    @FXML
    private TextField txtMatMfd;
    
    @FXML
    private TextField txtMatExp;
    
    @FXML
    private TextField txtMatAmount;
    
    @FXML
    private TextField txtProMfd;
    
    @FXML
    private TextField txtProExp;
    
    @FXML
    private TextField txtProAmount;
    
    @FXML
    private TextField txtProUnitPrice;
    
    @FXML
    private TextField txtDate;
    
    @FXML
    private Label lblMatKg;
    
    @FXML
    private Label lblTotalKg;
    
    @FXML
    private Label lblProBags;
    
    @FXML
    private Label lblTotalBags;
    
    @FXML
    private AnchorPane thisPane;
    
    private MaterialController ctrlMat;
    private ProductController ctrlProduct;
    private Batch_addController ctrlBatchAdd;
    private Batch_receiveController ctrlBatchReceive;
    private Return_batch_receiveController ctrlRetBatch;
   
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setUIs();
        setControllers();
        setDate();
        loadCmbMaterial();
        loadCmbProduct();
  
    }    

    private void setDate() {

        Date d=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String date=df.format(d);
        txtDate.setText(date);
    }

    private void loadCmbMaterial() {

        try {
            ArrayList<MaterialDTO> matlist=ctrlMat.getAll();
            for (MaterialDTO materialDTO : matlist) {
                cmbMaterial.getItems().add(materialDTO.getMaterialName());
            }
        } catch (Exception ex) {
            Logger.getLogger(SearchStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadCmbProduct() {

        try {
            ArrayList<ProductDTO> proList=ctrlProduct.getAll();
            for (ProductDTO productDTO : proList) {
                cmbProduction.getItems().add(productDTO.getProductName());
            }
        } catch (Exception ex) {
            Logger.getLogger(SearchStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setControllers() {
        
        ctrlRetBatch=(Return_batch_receiveController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.RETURN_BATCH_RECEIVE);
        ctrlBatchAdd=(Batch_addController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.BATCH_ADD);
        ctrlBatchReceive=(Batch_receiveController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.BATCH_RECEIVE);
        ctrlMat=(MaterialController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.MATERIAL);
        ctrlProduct=(ProductController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT);
    }
    
    @FXML
    private void cmbMaterialOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        cmbMaBatch.setValue("");
        cmbMaBatch.getItems().clear();
        
        txtMatAmount.setText("");
        txtMatExp.setText("");
        txtMatTotal.setText("");
        txtMatMfd.setText("");
        
        lblMatKg.setVisible(false);
        
        
        try {
            String mid=ctrlMat.getMaterialId(cmbMaterial.getSelectionModel().getSelectedItem().toString());
            
            ArrayList<Batch_receiveDTO> blist=ctrlBatchReceive.getAll();
            for (Batch_receiveDTO batch_receiveDTO : blist) {
                if(mid.equals(batch_receiveDTO.getMid())){
                    cmbMaBatch.getItems().add(batch_receiveDTO.getBrid());
                }
            }
            
            ArrayList<Return_batch_receiveDTO> brlist=ctrlRetBatch.getAll();
            for (Return_batch_receiveDTO return_batch_receiveDTO : brlist) {
                if(mid.equals(return_batch_receiveDTO.getMid())){
                    cmbMaBatch.getItems().add(return_batch_receiveDTO.getRbrid());
                }
            }
            
            ArrayList<MaterialDTO> mlist=ctrlMat.getAll();
            for (MaterialDTO materialDTO : mlist) {
                if(mid.equals(materialDTO.getMid())){
                    txtMatTotal.setText(df.format(materialDTO.getAmount_kg()));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(SearchStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblTotalKg.setVisible(true);
        
    }
    @FXML
    private void cmbProOnAction(ActionEvent evt){
        
        
        cmbProBatch.setValue("");
        cmbProBatch.getItems().clear();
        
        txtProAmount.setText("");
        txtProExp.setText("");
        txtProMfd.setText("");
        txtProTotal.setText("");
        txtProUnitPrice.setText("");
        
        lblProBags.setVisible(false);
        try {
            String proid=ctrlProduct.getProid(cmbProduction.getSelectionModel().getSelectedItem().toString());
            
            ArrayList<Batch_addDTO> blist=ctrlBatchAdd.getAll();
            for (Batch_addDTO batch_addDTO : blist) {
                if(proid.equals(batch_addDTO.getProid())){
                    cmbProBatch.getItems().add(batch_addDTO.getBaid());
                }
            }
            
            ArrayList<ProductDTO> plist=ctrlProduct.getAll();
            for (ProductDTO productDTO : plist) {
                if(proid.equals(productDTO.getProid())){
                    txtProTotal.setText(Integer.toString(productDTO.getQtyBags()));
                    
                }
            }
        } catch (Exception ex) {
           // Logger.getLogger(SearchStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lblTotalBags.setVisible(true);
    }
    
    @FXML
    private void cmbMatBatchOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        try {
            String batch=cmbMaBatch.getSelectionModel().getSelectedItem().toString();
            char[] arr=batch.toCharArray();
            if(arr[0]=='R'){

                ArrayList<Return_batch_receiveDTO> retlist=ctrlRetBatch.getAll();
                for (Return_batch_receiveDTO return_batch_receiveDTO : retlist) {
                    if(batch.equals(return_batch_receiveDTO.getRbrid())){
                        txtMatMfd.setText(return_batch_receiveDTO.getMfd());
                        txtMatExp.setText(return_batch_receiveDTO.getExp());
                        txtMatAmount.setText(df.format(return_batch_receiveDTO.getCurrent_qty()));
                    }
                }
            }else{
                ArrayList<Batch_receiveDTO> reclist=ctrlBatchReceive.getAll();
                for (Batch_receiveDTO batch_receiveDTO : reclist) {
                    if(batch.equals(batch_receiveDTO.getBrid())){
                        txtMatMfd.setText(batch_receiveDTO.getMfd());
                        txtMatExp.setText(batch_receiveDTO.getExp());
                        txtMatAmount.setText(df.format(batch_receiveDTO.getCurrent_qty_kg()));
                    }
                }
            }
            lblMatKg.setVisible(true);
            
        }catch (Exception ex) {
            //Logger.getLogger(SearchStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void cmbProBatchOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        try {
            String batch=cmbProBatch.getSelectionModel().getSelectedItem().toString();
            ArrayList<Batch_addDTO> blist=ctrlBatchAdd.getAll();
            for (Batch_addDTO batch_addDTO : blist) {
                if(batch.equals(batch_addDTO.getBaid())){
                    
                    txtProMfd.setText(batch_addDTO.getMfd());
                    txtProExp.setText(batch_addDTO.getExp());
                    txtProAmount.setText(Integer.toString(batch_addDTO.getCurrent_qty()));
                    txtProUnitPrice.setText(df.format(batch_addDTO.getUnitPrice()));
                    
                    lblProBags.setVisible(true);
                }
            }
        } catch (Exception ex) {
          //  Logger.getLogger(SearchStockController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setUIs() {

        thisPane.setOnKeyReleased(e->{
            switch(e.getCode()){
                
                case DIGIT2:    try{

                                    AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MaterialReport.fxml"));
                                    DashBoardController.rootPane.getChildren().setAll(contain);
                                }catch(IOException ex){

                                }
                                break; 
                                
                case DIGIT1:    try{
                                    
                                    AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/ProductionReport.fxml"));
                                    DashBoardController.rootPane.getChildren().setAll(contain);
                                }catch(IOException ex){

                                }
     
                                break;
                case ESCAPE:    try{
                                    AnchorPane sidePane = FXMLLoader.load(getClass().getResource(("/com/sas/kem/edu/ijse/view/MainSidePane.fxml")));
                                    DashBoardController.sideP.getChildren().setAll(sidePane);              
                                        
                                    AnchorPane contentPane = FXMLLoader.load(getClass().getResource(("/com/sas/kem/edu/ijse/view/SelectionPage.fxml")));
                                    DashBoardController.rootPane.getChildren().setAll(contentPane);

                                    
                                }catch(IOException ex){

                                }
                                break;
            }
        });
    }
    
}
