/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.IdController;
import lk.edu.ijse.sas.controller.custom.MaterialController;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import java.math.BigDecimal;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class NewMaterialController implements Initializable {
    
    @FXML
    private JFXTextField txtMatName;
    
    @FXML
    private TextField txtMatId;
    
    @FXML
    private JFXButton btnAdd;
    
    @FXML
    private JFXButton btnCancel;
    
    private MaterialController ctrlMat;
    private IdController ctrlId;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            ctrlId=(IdController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.IDGEN);
            ctrlMat=(MaterialController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.MATERIAL);
            
            txtMatId.setText(ctrlId.getNewId("material", "mid","M", 3));
        } catch (Exception ex) {
            Logger.getLogger(NewMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }   
    @FXML
    private void addBtnOnAction(ActionEvent evt){
        
        try {
            String text=txtMatName.getText();
            if(text.equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You didn't mention the new material!");
                alert.showAndWait();
                txtMatName.requestFocus();
            }else{
                BigDecimal qty=new BigDecimal("0");
            
                MaterialDTO m=new MaterialDTO(txtMatId.getText(),txtMatName.getText(),qty);
                boolean b=ctrlMat.add(m);
                if(b){

                    ButtonType ok=new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                    Alert alert=new Alert(Alert.AlertType.INFORMATION,"New Material Added",ok);
                    alert.setHeaderText("Added Success!");

                    Optional<ButtonType> res=alert.showAndWait();
                    if(res.get()==ok){
                         ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();

                    }

                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(NewMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void cancelBtnOnAction(ActionEvent evt){
        
        ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
       
    }
    
}
