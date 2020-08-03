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
import lk.edu.ijse.sas.controller.custom.ProductController;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class RenameProductionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton btnRename;
    
    @FXML
    private JFXButton btnCancel;
    
    @FXML
    private JFXComboBox cmbProduction;
    
    @FXML
    private JFXTextField txtName;
    
    private ProductController ctrlProduct;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ctrlProduct=(ProductController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT);
        loadCmbProduct();
    }    
    @FXML
    private void cmbProOnAction(ActionEvent evt){
        
        txtName.requestFocus();
        String name=cmbProduction.getSelectionModel().getSelectedItem().toString();
        txtName.setText(name);
        txtName.selectAll();
        
    }
    @FXML
    private void btnRenameOnAction(ActionEvent evt){
        
        try {
            String proName=cmbProduction.getSelectionModel().getSelectedItem().toString();
            String rename=txtName.getText();
            if(proName.equals(rename)){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You didn't do any changes!");
                alert.setTitle("Rename");
                alert.showAndWait();
                
            }else if(txtName.getText().equals("")){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You didn't mention the production Name!");
                alert.setTitle("Rename");
                alert.showAndWait();
            }else{
                
                boolean isUpdate=ctrlProduct.update(rename, proName);
                if(isUpdate){
                    ButtonType ok=new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                
                    Alert alert=new Alert(Alert.AlertType.INFORMATION,"Your Product Is Renamed",ok);
                    alert.setHeaderText("Rename Success!");
                    alert.setTitle("Rename");
                    Optional<ButtonType> res=alert.showAndWait();
                    if(res.get()==ok){

                       ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
                    }
                }else{
                    ButtonType ok=new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                
                    Alert alert=new Alert(Alert.AlertType.INFORMATION,"Your Product Is not Renamed",ok);
                    alert.setHeaderText("Rename Failed!");
                    alert.setTitle("Rename");
                    Optional<ButtonType> res=alert.showAndWait();
                    if(res.get()==ok){

                       ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
                    }
                }
                
            }
            
        } catch (Exception ex) {
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("You didn't Select a production for rename!");
            alert.setTitle("Rename");
            alert.showAndWait();
        }
    }
    @FXML
    private void btnCancelOnAction(ActionEvent evt){
        
        ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
    }

    private void loadCmbProduct() {

        try {
            ArrayList<ProductDTO> plist=ctrlProduct.getAll();
            for (ProductDTO productDTO : plist) {
                cmbProduction.getItems().add(productDTO.getProductName());
            }
        } catch (Exception ex) {
            Logger.getLogger(RenameProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
