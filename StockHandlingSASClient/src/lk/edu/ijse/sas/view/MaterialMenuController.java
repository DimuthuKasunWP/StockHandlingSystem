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
public class MaterialMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label lblBuy;
    
    @FXML
    private Label lblRemove;
    
    @FXML
    private Label lblCurrent;
    
    @FXML
    private Label lblReturn;
    
    @FXML
    private JFXButton btnBack;
    
    @FXML
    private AnchorPane thisPane;
    
    @FXML
    AnchorPane clickPane;
    
    public static AnchorPane rootPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        rootPane=clickPane;
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/AllSearch.fxml"));
            clickPane.getChildren().setAll(box);
        } catch (IOException ex) {
            Logger.getLogger(MaterialMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    @FXML
    private void lblBuyOnClicked(MouseEvent evt){
        
        
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/BuyMaterial.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(MaterialMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void lblCurrentOnClicked(MouseEvent evt){
        
        
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/CurrentMaterial.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(MaterialMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void lblRemoveOnClicked(MouseEvent evt){
        
        
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/RemoveMaterial.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(MaterialMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void lblReturnOnClicked(MouseEvent evt){
        
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/ReturnMaterial.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(MaterialMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnBackOnAction(ActionEvent evt){
        
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/SelectionPage.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
            
            AnchorPane sidePane=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MainSidePane.fxml"));
            DashBoardController.sideP.getChildren().setAll(sidePane);
            
        } catch (IOException ex) {
            Logger.getLogger(MaterialMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
