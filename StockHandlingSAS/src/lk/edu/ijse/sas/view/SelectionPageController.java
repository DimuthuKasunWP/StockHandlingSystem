/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXTextArea;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.DateController;
import lk.edu.ijse.sas.controller.custom.MaterialController;
import lk.edu.ijse.sas.controller.custom.ProductController;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class SelectionPageController implements Initializable {
    
    @FXML
    JFXTextArea txtarNotify;
    
    @FXML
    Label lblDay;
    
    @FXML
    Label lblDayName;
    
    @FXML
    Label lblMonthName;
    
    @FXML
    Label lblDisplayTime;
    
    @FXML
    Label lblTime;
    
    @FXML
    Label lblDate;
    
    @FXML
    Label lblProduction;
    
    @FXML
    Label lblMaterial;
    
    @FXML
    Label lblReport;
    
    @FXML
    Label lblRejReverse;
    
    @FXML
    Label lblDocument;
    
    @FXML
    Label lblSearch;
    
    @FXML
    Label lblAdmin;
    
    @FXML
    Label lblCount;
    
    @FXML
    private AnchorPane thisPane;
    
    private DateController ctrlDate;
    private MaterialController ctrlMat;
    private ProductController ctrlProduct;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        setControllers();
        
        setDateDetails();
        setTime();
        
        setNotifications();
        
        setUIs();
        
       
    }
    
    
    private void setControllers() {
        
        ctrlDate=(DateController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.DATE);
        ctrlProduct=(ProductController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT);
        ctrlMat=(MaterialController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.MATERIAL);
    }

    private void setDateDetails() {
        
        try {
            lblDayName.setText(ctrlDate.getDateDetail().getDayName());
            lblDay.setText(ctrlDate.getDateDetail().getDay());
            lblMonthName.setText(ctrlDate.getDateDetail().getMonthName());
            
        } catch (Exception ex) {
            Logger.getLogger(SelectionPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void setTime() {
        
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0),
                        new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        Calendar time = Calendar.getInstance();
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                        lblDisplayTime.setText(simpleDateFormat.format(time.getTime()));
                    }
                }
                ),
                new KeyFrame(Duration.seconds(1))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void setNotifications() {
        
        try {
            
            int count=0;
            for (MaterialDTO mat : ctrlMat.getAll()) {
                BigDecimal stockAmount=mat.getAmount_kg();
                BigDecimal orderAmount=new BigDecimal("10000.00");
                BigDecimal bgAmount=new BigDecimal("2000.00");
                
                if(orderAmount.compareTo(stockAmount)>0 ||bgAmount.compareTo(stockAmount)>0){
                    
                    txtarNotify.appendText((mat.getMaterialName()+" remaining "+mat.getAmount_kg()+" Kg Only."+" Please Reorder "+mat.getMaterialName())+'\n'+'\n');
                    count++;
                }
                    
            }
            
            for (ProductDTO pro : ctrlProduct.getAll()) {
                int stockAmount=pro.getQtyBags();
                int productAmount=1000;
                
                if(stockAmount<productAmount){
                    
                    txtarNotify.appendText((pro.getProductName()+" remaining "+pro.getQtyBags()+" Bags Only."+" Please Product More "+pro.getProductName())+'\n'+'\n');
                    count++;
                }
                    
            }
            
            if(count>0){
                lblCount.setText(Integer.toString(count));
                lblCount.setVisible(true);
            }else{
                lblCount.setVisible(false);
            }
        } catch (Exception ex) {
            Logger.getLogger(SelectionPageController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    @FXML
    private void lblProOnMouseClicked(MouseEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/ProductionMenu.fxml"));
            DashBoardController.sideP.getChildren().setAll(box);
            
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/AddProduction.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(SelectionPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    @FXML
    private void lblMatOnMouseClicked(MouseEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MaterialMenu.fxml"));
            DashBoardController.sideP.getChildren().setAll(box);
            
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/BuyMaterial.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(SelectionPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    @FXML
    private void lblRejRecOnClicked(MouseEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/RejectMenu.fxml"));
            DashBoardController.sideP.getChildren().setAll(box);
            
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/RejectMaterial.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(SelectionPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void lblUpdateOnClicked(MouseEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/UpdateMenu.fxml"));
            DashBoardController.sideP.getChildren().setAll(box);
            
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/UpdateOrder.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(SelectionPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setUIs() {
    
        thisPane.setOnKeyReleased(e->{

        switch(e.getCode()){
            
            case HOME:  try{
                            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MaterialMenu.fxml"));
                            DashBoardController.sideP.getChildren().setAll(box);

                            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/Admin.fxml"));
                            DashBoardController.rootPane.getChildren().setAll(contain);
                        }catch(IOException ex){

                        }
                        break;
            
            case F1:    try{
                            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/ProductionMenu.fxml"));
                            DashBoardController.sideP.getChildren().setAll(box);

                            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/AddProduction.fxml"));
                            DashBoardController.rootPane.getChildren().setAll(contain);
                        }catch(IOException ex){

                        }
                        break;
            
            case F2:    try{
                            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/ReportsMenu.fxml"));
                            DashBoardController.sideP.getChildren().setAll(box);

                            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MonthlyReceiveMat.fxml"));
                            DashBoardController.rootPane.getChildren().setAll(contain);
                        }catch(IOException ex){

                        }
                        break;
            
            case F3:    try{
                            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/DocumentMenu.fxml"));
                            DashBoardController.sideP.getChildren().setAll(box);

                            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/OrderPreview.fxml"));
                            DashBoardController.rootPane.getChildren().setAll(contain);
                        }catch(IOException ex){

                        }
                        break;
            
            case F4:    try{
                            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/UpdateMenu.fxml"));
                            DashBoardController.sideP.getChildren().setAll(box);

                            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/UpdateOrder.fxml"));
                            DashBoardController.rootPane.getChildren().setAll(contain);
                        }catch(IOException ex){

                        }
                        break;
            
            case F5:    try{
                            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MaterialMenu.fxml"));
                            DashBoardController.sideP.getChildren().setAll(box);

                            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/BuyMaterial.fxml"));
                            DashBoardController.rootPane.getChildren().setAll(contain);
                        }catch(IOException ex){

                        }
                        break;
            
            case F6:    try{
                            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/RejectMenu.fxml"));
                            DashBoardController.sideP.getChildren().setAll(box);

                            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/RejectMaterial.fxml"));
                            DashBoardController.rootPane.getChildren().setAll(contain);
                        }catch(IOException ex){

                        }
                        break;
            
            case F7:    try{
                            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/SearchMenu.fxml"));
                            DashBoardController.sideP.getChildren().setAll(box);

                            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/ProductionReport.fxml"));
                            DashBoardController.rootPane.getChildren().setAll(contain);
                        }catch(IOException ex){
                            
                        }
                            
        }
     });    
    }
    @FXML
    private void lblAdminOnMouseClicked(MouseEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MainSidePane.fxml"));
            DashBoardController.sideP.getChildren().setAll(box);
            
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/Admin.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(SelectionPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void lblSearchOnClicked(MouseEvent evt){
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/SearchMenu.fxml"));
            DashBoardController.sideP.getChildren().setAll(box);
            
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/ProductionReport.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(SelectionPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void lblReportsOnClicked(MouseEvent evt){
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/ReportsMenu.fxml"));
            DashBoardController.sideP.getChildren().setAll(box);
            
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MonthlyReceiveMat.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(SelectionPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void lblDocumentOnClicked(MouseEvent evt){
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/DocumentMenu.fxml"));
            DashBoardController.sideP.getChildren().setAll(box);
            
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/OrderPreview.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(SelectionPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
