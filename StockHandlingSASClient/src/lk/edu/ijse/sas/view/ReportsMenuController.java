/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import lk.edu.ijse.sas.other.JRViewerFX;
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
public class ReportsMenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Label lblRecMat;
    
    @FXML
    private Label lblReject;
    
    @FXML
    private Label lblPro;
    
    @FXML
    private Label lblMonthlyOrders;
    
    @FXML
    private JFXButton btnBack;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void lblRecMatOnClicked(MouseEvent evt){
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MonthlyReceiveMat.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
            
        } catch (IOException ex) {
            Logger.getLogger(ProductionMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void lblProOnClicked(MouseEvent evt){
        
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MonthlyProduction.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
            
        } catch (IOException ex) {
            Logger.getLogger(ProductionMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void lblMonthlyOrdersOnClicked(MouseEvent evt){
        try {
            AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MonthlyOrder.fxml"));
            DashBoardController.rootPane.getChildren().setAll(contain);
        } catch (IOException ex) {
            Logger.getLogger(ProductionMenuController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ProductionMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void lblRejectOnClicked(MouseEvent evt){
        
        JRViewerFX view=new JRViewerFX();
        String path="/com/sas/kem/edu/ijse/report/RejectOrders.jasper";
        view.showReport(path);
    }
    
}
