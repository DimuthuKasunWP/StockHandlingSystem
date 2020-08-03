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
public class UpdateMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label lblUpdateOrder;
    
    @FXML
    private Label lblUpdateCompany;
    
    @FXML
    private JFXButton btnBack;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
    @FXML
    private void lblUpdateOrderOnClicked(MouseEvent evt){
        
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/UpdateOrder.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(UpdateMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void lblUpdateCompanyOnClicked(MouseEvent evt){
        
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/UpdateCompany.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(UpdateMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnBackOnAction(ActionEvent evt){
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/SelectionPage.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
            
            AnchorPane side=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MainSidePane.fxml"));
            DashBoardController.sideP.getChildren().setAll(side);
            
        } catch (IOException ex) {
            Logger.getLogger(UpdateMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
