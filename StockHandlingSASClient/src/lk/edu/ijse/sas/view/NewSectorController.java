/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.SectorController;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class NewSectorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXTextField txtName;
    
    @FXML
    private JFXButton btnAdd;
    
    @FXML
    private JFXButton btnCancel;
    
    private SectorController ctrlSector;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ctrlSector=(SectorController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.SECTOR);
    } 
    @FXML
    private void btnAddOnAction(ActionEvent evt){
        
        try {
            if(txtName.getText().equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You must mention the Sector Name!");
                alert.showAndWait();
                txtName.requestFocus();
            }else{
                String secName=txtName.getText();
                boolean add=ctrlSector.add(secName);
                if(add){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("New Sector Added Success!");
                    alert.showAndWait();
                    ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
                }else{
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("New Sector Added Failed!");
                    alert.showAndWait();
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(NewSectorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnCancelOnAction(ActionEvent evt){
        
        ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
    }
    
}
