/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class ProductionMenuController implements Initializable {
    
    @FXML
    private JFXButton proSearchBtn;
    
    @FXML
    private JFXButton comSearchBtn;
    
    @FXML
    private JFXButton backBtn;
    
    @FXML
    private Label lblOrder;
    
    @FXML
    private Label lblAdd;
    
    @FXML
    private Label lblCurrent;
    
    @FXML
    private AnchorPane clickPane;
    
    @FXML
    private AnchorPane thisPane;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
   /* @FXML
    private void proSearchBtnOnAction(ActionEvent evt){
        
        try {
            AnchorPane box = FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/SearchPro.fxml"));
            clickPane.getChildren().setAll(box);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    @FXML
    private void comSearchBtnOnAction(ActionEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/SearchCom.fxml"));
            clickPane.getChildren().setAll(box);
        } catch (IOException ex) {
            Logger.getLogger(ProductionMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    @FXML
    private void backBtnOnAction(ActionEvent evt){
        
        try {
            AnchorPane contentPane = FXMLLoader.load(getClass().getResource(("/com/sas/kem/edu/ijse/view/SelectionPage.fxml")));
            DashBoardController.rootPane.getChildren().setAll(contentPane);
            
            AnchorPane sidePane=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MainSidePane.fxml"));
            DashBoardController.sideP.getChildren().setAll(sidePane);
            
        } catch (IOException ex) {
            // Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void lblOrderProOnClicked(MouseEvent evt){
        
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/OrderProduction.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(ProductionMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void lblAddProOnClicked(MouseEvent evt){
        
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/AddProduction.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(ProductionMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void lblCurrentProOnClicked(MouseEvent evt){
        
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/CurrentProduction.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(ProductionMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
