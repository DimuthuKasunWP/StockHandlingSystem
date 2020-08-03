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
import lk.edu.ijse.sas.controller.custom.ProductController;
import lk.edu.ijse.sas.controller.custom.ValidationController;
import com.sas.kem.edu.ijse.dto.ProductDTO;
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
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class NewProductionController implements Initializable {
    
    @FXML
    private TextField txtProId;
    
    @FXML
    private JFXTextField txtProName;
    
    @FXML
    private JFXTextField txtBgSize;
    
    @FXML
    private JFXButton btnAdd;
    
    @FXML
    private JFXButton btnCancel;
    
    private ProductController ctrlProduct;
    private IdController ctrlId;
    private ValidationController ctrlValidation;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            ctrlValidation=(ValidationController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.VALIDATION);
            ctrlProduct=(ProductController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT);
            ctrlId=(IdController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.IDGEN);
            
            txtProId.setText(ctrlId.getNewId("product", "proid", "PRO", 3));
        } catch (Exception ex) {
            Logger.getLogger(NewProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    private void addBtnOnAction(ActionEvent evt){
        
        try {
            
            if(txtBgSize.getText().equals("")|| txtProName.getText().equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You missed some fields.checkAgain!");
                alert.showAndWait();
                txtProName.requestFocus();
            }else{
                int qty=0;
                ProductDTO pro=new ProductDTO(txtProId.getText(),txtProName.getText(),new BigDecimal(txtBgSize.getText()),qty);

                boolean b=ctrlProduct.add(pro);
                if(b){
                    ButtonType ok=new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);

                    Alert alert=new Alert(Alert.AlertType.INFORMATION, "New Product Added",ok);
                    alert.setHeaderText("Added Success!");
                    Optional<ButtonType> res=alert.showAndWait();
                    if(res.get()==ok){
                        ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
                    }
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(NewProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    @FXML
    private void cancelBtnOnAction(ActionEvent evt){
        
        ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();

    }
    @FXML
    private void txtProNameOnAction(ActionEvent evt){
        txtBgSize.requestFocus();
    }
    @FXML
    private void txtBagSizeOnKeyReleased(KeyEvent evt){
        try {
            String text=txtBgSize.getText();
            if(!ctrlValidation.setNumberFormat(text)){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You can use only Numbers!");
                alert.setContentText("EX: 323,232.22");
                alert.showAndWait();
                txtBgSize.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(NewProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
