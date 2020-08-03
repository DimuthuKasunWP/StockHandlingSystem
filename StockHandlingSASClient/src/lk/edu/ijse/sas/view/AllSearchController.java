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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class AllSearchController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton btnPro;
    
    @FXML
    private JFXButton btnMat;
    
    @FXML
    private JFXButton btnCom;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }
    @FXML
    private void btnProOnAction(ActionEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/SearchMaterialPro.fxml"));
            MaterialMenuController.rootPane.getChildren().setAll(box);
        } catch (IOException ex) {
            Logger.getLogger(AllSearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnComOnAction(ActionEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/SearchMaterialCom.fxml"));
            MaterialMenuController.rootPane.getChildren().setAll(box);
        } catch (IOException ex) {
            Logger.getLogger(AllSearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnMatOnAction(ActionEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/SearchMaterialMat.fxml"));
            MaterialMenuController.rootPane.getChildren().setAll(box);
        } catch (IOException ex) {
            Logger.getLogger(AllSearchController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
