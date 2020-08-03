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
public class RejectMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label lblRejMat;
    
    @FXML
    private Label lblRejOrder;
    
    @FXML
    private Label lblReverseOrder;
    
    @FXML
    private JFXButton btnBack;
    
    @FXML
    private AnchorPane thisPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
    private void lblRejMatOnClicked(MouseEvent evt){
        
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/RejectMaterial.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(MaterialMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void lblRejOrderOnClicked(MouseEvent evt){
       
         try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/RejectOrder.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(MaterialMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void lblReverseOnClicked(MouseEvent evt){
        
         try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/ReversingProduction.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(MaterialMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void backBtnOnAction(ActionEvent evt){
        
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/SelectionPage.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
            AnchorPane sidePane=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MainSidePane.fxml"));
            DashBoardController.sideP.getChildren().setAll(sidePane);
        } catch (IOException ex) {
            Logger.getLogger(RejectMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
