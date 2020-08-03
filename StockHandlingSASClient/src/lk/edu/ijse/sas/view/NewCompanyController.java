/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.CompanyController;
import lk.edu.ijse.sas.controller.custom.IdController;
import com.sas.kem.edu.ijse.dto.CompanyDTO;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class NewCompanyController implements Initializable {
    
    @FXML
    private TextField txtId;
    
    @FXML
    private JFXTextField txtName;
    
    @FXML
    private JFXTextField txtAdNo;
    
    @FXML
    private JFXTextField txtAdLane;
    
    @FXML
    private JFXTextField txtAdArea;
    
    @FXML
    private JFXTextField txtAdCity;
    
    @FXML
    private JFXTextField txtMail;
    
    @FXML
    private JFXTextField txtTel;
    
    @FXML
    private JFXTextField txtAddTel;
    
    @FXML
    private JFXTextField txtFax;
    
    @FXML
    private JFXListView lstVw;
    
    @FXML
    private JFXButton btnRegister;
    
    @FXML
    private JFXButton btnCancel;
    
    private CompanyController ctrlCompany;
    private IdController ctrlId;
    
    ObservableList<String> mailList=FXCollections.observableArrayList("@aol.com","@att.net","@comcast.net","@email.com","@facebook.com","@fastmail.com","@gmail.com","@games.com","@gmx.com","@gmx.com","@googlemail.com","@google.com","@hotmail.com","@hotmail.co.uk","@hush.com","@hushmail.com","@icloud.com","@inbox.com","@iname.com","@mac.com","@me.com","@mail.com","@msn.com","@live.com","@lavabit.com","@love.com","@outlook.com","@pobox.com","@rocketmail.com","@sbcglobal.net","@safe-mail.net","@verzion.com","@yahoo.com","@yahoo.co.uk","@yandex.com","@ymail.com","@wow.com","@zoho.com");
     
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            ctrlCompany=(CompanyController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.COMPANY);
            ctrlId=(IdController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.IDGEN);
            
            txtId.setText(ctrlId.getNewId("company","cid","C",3));
            
            lstVw.setOnKeyReleased(e->{
                if(e.getCode()==KeyCode.ENTER){
                    String txt=txtMail.getText();
                    char[] check=txt.toCharArray();
                    String newTxt="";
                    
                    for(int i=0;i<check.length;i++){
                       
                        if(check[i]=='@'){
                            newTxt=newTxt+"";
                        }else{
                            newTxt=newTxt+(check[i]+"");
                        }
                    }
                    txtMail.setText(newTxt+lstVw.getSelectionModel().getSelectedItem().toString());
                    lstVw.setVisible(false);
                    txtTel.requestFocus();
                }
            });
            
            
        } catch (Exception ex) {
            Logger.getLogger(NewCompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }    
    
    @FXML
    private void txtEmailKeyReleased(KeyEvent evt){
       
        String text=txtMail.getText();
        char[] email=text.toCharArray();
        for(int i=0;i<email.length;i++){
            if(email[i]=='@'){
                lstVw.setItems(mailList);
                lstVw.setVisible(true);
                Platform.runLater(lstVw::requestFocus); 
            }
        }
        
    } 
    
    @FXML
    private void registerBtnOnAction(ActionEvent evt){
        
        try {
            if(txtName.getText().equals("")||txtAdNo.getText().equals("")||txtAdLane.getText().equals("")||txtAdArea.getText().equals("")||txtTel.getText().equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You missed some fields.check Again!");
                alert.showAndWait();
            }else{
                CompanyDTO c=new CompanyDTO(txtId.getText(),txtName.getText(),txtAdNo.getText(),txtAdLane.getText(),txtAdArea.getText(),txtAdCity.getText(),txtMail.getText(),txtTel.getText(),txtAddTel.getText(),txtFax.getText());
            
                boolean isUpdate=ctrlCompany.add(c);

                if(isUpdate){
                    ButtonType ok=new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                    Alert alert=new Alert(Alert.AlertType.INFORMATION,"New company is "+txtName.getText()+" addedd Success!",ok);
                    alert.setHeaderText("Added Success!");
                    Optional<ButtonType> res=alert.showAndWait();
                    if(res.get()==ok){
                        ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
                    }
                }else{
                    ButtonType ok=new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                    Alert alert=new Alert(Alert.AlertType.INFORMATION,"New company is "+txtName.getText()+" not addedd !",ok);
                    alert.setHeaderText("Added Failed!");
                    Optional<ButtonType> res=alert.showAndWait();
                    if(res.get()==ok){
                        ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
                    }
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(NewCompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void cancelBtnOnAction(ActionEvent evt){
        
        ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
        
    }
    
    @FXML
    private void txtTelOnAction(ActionEvent evt){
        
        txtAddTel.requestFocus();
    }
    @FXML
    private void txtAddTelOnAction(ActionEvent evt){
        
        txtFax.requestFocus();
    }
    @FXML
    private void txtNameOnAction(ActionEvent evt){
        
      txtAdNo.requestFocus();
    }
    @FXML
    private void txtNoOnAction(ActionEvent evt){
        
        txtAdLane.requestFocus();
    }
    @FXML
    private void txtLaneOnAction(ActionEvent evt){
        
        txtAdArea.requestFocus();
    }
    @FXML
    private void txtAreaOnAction(ActionEvent evt){
        
        txtAdCity.requestFocus();
    }@FXML
    private void txtCityOnAction(ActionEvent evt){
        
        txtMail.requestFocus();
    }
    @FXML
    private void txtMailOnAction(ActionEvent evt){
        
        txtTel.requestFocus();
    }

    private void clearAction() {

        txtName.setText("");
        txtAdNo.setText("");
        txtAdLane.setText("");
        txtAdArea.setText("");
        txtAdCity.setText("");
        txtFax.setText("");
        txtTel.setText("");
        txtMail.setText("");
    }
}
