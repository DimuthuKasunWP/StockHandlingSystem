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
import lk.edu.ijse.sas.controller.custom.CompanyController;
import lk.edu.ijse.sas.controller.custom.IdController;
import com.sas.kem.edu.ijse.dto.CompanyDTO;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class RenameCompanyController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton btnRename;
    
    @FXML
    private JFXButton btnCancel;
    
    @FXML
    private JFXComboBox cmbCompany;
    
    @FXML
    private JFXTextField txtName;
    
    private CompanyController ctrlCom;
    private IdController ctrlId;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ctrlCom=(CompanyController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.COMPANY);
        loadCmbCompany();
    }
    private void loadCmbCompany() {

        try {
            ArrayList<CompanyDTO> clist=ctrlCom.getAll();
            for (CompanyDTO companyDTO : clist) {
                
                cmbCompany.getItems().add(companyDTO.getComName());
            }
            Platform.runLater(cmbCompany::requestFocus);
        } catch (Exception ex) {
            Logger.getLogger(RenameMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void cmbCompanyOnAction(ActionEvent evt){
        
        txtName.requestFocus();
        String name=cmbCompany.getSelectionModel().getSelectedItem().toString();
        txtName.setText(name);
        txtName.selectAll();
        
    }
    @FXML
    private void btnRenameOnAction(ActionEvent evt){
        
        try {
            String comName=cmbCompany.getSelectionModel().getSelectedItem().toString();
            String rename=txtName.getText();
            
            if(comName.equals(rename)){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You didn't do any changes!");
                alert.showAndWait();
                
            }else if(txtName.getText().equals("")){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You didn't mention the new Name!");
                alert.showAndWait();
            }else{    
                boolean isUpdate=ctrlCom.update(rename, comName);
                if(isUpdate){
                    ButtonType ok=new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                
                    Alert alert=new Alert(Alert.AlertType.INFORMATION,"Your Company Is Renamed",ok);
                    alert.setHeaderText("Rename Success!");
                    Optional<ButtonType> res=alert.showAndWait();
                    if(res.get()==ok){

                       ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
                    }
                }else{
                    ButtonType ok=new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                
                    Alert alert=new Alert(Alert.AlertType.INFORMATION,"Your company Is not Renamed",ok);
                    alert.setHeaderText("Rename Failed!");
                    Optional<ButtonType> res=alert.showAndWait();
                    if(res.get()==ok){

                       ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
                    }
                }
                
            }
            
        } catch (Exception ex) {

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You didn't select the Company for rename!");
            alert.showAndWait();
        }
    }
    @FXML
    private void btnCancelOnAction(ActionEvent evt){
        
        ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
    }
}
