/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.SectorController;
import com.sas.kem.edu.ijse.dto.SectorDTO;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
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
public class RenameSectorController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXComboBox cmbSector;
    
    @FXML
    private JFXTextField txtName;
    
    @FXML
    private JFXButton btnRename;
    
    @FXML
    private JFXButton btnCancel;
    
    
    private SectorController ctrlSector;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Platform.runLater(cmbSector::requestFocus);
        ctrlSector=(SectorController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.SECTOR);
        loadSector();
    }    
    
    @FXML
    private void cmbSectorOnAction(ActionEvent evt){
        
        String sector=cmbSector.getSelectionModel().getSelectedItem().toString();
        txtName.setText(sector);
        txtName.requestFocus();
                
    }
    @FXML
    private void btnRenameOnAction(ActionEvent evt){
        
        try {
            String rename=txtName.getText();
            String curName=cmbSector.getSelectionModel().getSelectedItem().toString();
            
            if(txtName.getText().equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You didn't mention the new Name!");
                alert.showAndWait();
            }else if(rename.equals(curName)){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You didn't do any changes!");
                alert.showAndWait();
                
            }else{
                boolean update=ctrlSector.rename(rename, curName);
                if(update){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Sector rename is success!");
                    alert.showAndWait();
                    ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();

                }else{
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Sector rename is Failed!");
                    alert.showAndWait();
                    ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
                }
            }
            
        } catch (Exception ex) {

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You didn't select a Sector to rename!");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void btnCancelOnAction(ActionEvent evt){
        
        ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
        
    }

    private void loadSector() {

        try {
            ArrayList<SectorDTO> secList=ctrlSector.getAll();
            for (SectorDTO sectorDTO : secList) {
                cmbSector.getItems().add(sectorDTO.getSecName());
            }
        } catch (Exception ex) {
            Logger.getLogger(RenameSectorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
