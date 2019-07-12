/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.CompanyController;
import lk.edu.ijse.sas.controller.custom.IdController;
import com.sas.kem.edu.ijse.dto.CompanyDTO;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class UpdateCompanyController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXComboBox cmbCompany;
    
    @FXML
    private TextField txtId;
    
    @FXML
    private TextField txtName;
    
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
    private JFXButton btnUpdate;
    
    @FXML
    private JFXButton btnClear;
    
    private CompanyController ctrlCompany;
    private IdController ctrlId;
    
    ObservableList<String> mailList=FXCollections.observableArrayList("@aol.com","@att.net","@comcast.net","@email.com","@facebook.com","@fastmail.com","@gmail.com","@games.com","@gmx.com","@gmx.com","@googlemail.com","@google.com","@hotmail.com","@hotmail.co.uk","@hush.com","@hushmail.com","@icloud.com","@inbox.com","@iname.com","@mac.com","@me.com","@mail.com","@msn.com","@live.com","@lavabit.com","@love.com","@outlook.com","@pobox.com","@rocketmail.com","@sbcglobal.net","@safe-mail.net","@verzion.com","@yahoo.com","@yahoo.co.uk","@yandex.com","@ymail.com","@wow.com","@zoho.com");
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
            
            Platform.runLater(cmbCompany::requestFocus);
            loadCmbCompany();
        } catch (Exception ex) {
           // Logger.getLogger(NewCompanyController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void cmbCompanyOnAction(ActionEvent evt){
        try{
            String name=cmbCompany.getSelectionModel().getSelectedItem().toString();
            txtName.setText(name);
            txtId.setText(ctrlCompany.getCompanyId(name));
            ArrayList<CompanyDTO> clist=ctrlCompany.getAll();
            for (CompanyDTO companyDTO : clist) {
                if(txtId.getText().equals(companyDTO.getCid())){
                    txtAdArea.setText(companyDTO.getAddressArea());
                    txtAdCity.setText(companyDTO.getAddressCity());
                    txtAdLane.setText(companyDTO.getAddressLane());
                    txtAdNo.setText(companyDTO.getAddressNo());
                    txtAddTel.setText(companyDTO.getTelAddNo());
                    txtFax.setText(companyDTO.getFaxNo());
                    txtMail.setText(companyDTO.getEmail());
                    txtTel.setText(companyDTO.getTelNo());
                }
            }
            Platform.runLater(txtName::requestFocus);
        }catch(Exception ex){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You must select a company!");
            alert.showAndWait();
                    
        }
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
        lstVw.setVisible(false);
    }

    private void clearAction() {

        cmbCompany.setValue("");
        txtName.setText("");
        txtAdNo.setText("");
        txtAdLane.setText("");
        txtAdArea.setText("");
        txtAdCity.setText("");
        txtFax.setText("");
        txtTel.setText("");
        txtAddTel.setText("");
        txtMail.setText("");
    }
    
    @FXML
    private void updateBtnOnAction(ActionEvent evt){
        
        try{
            if(txtName.getText().equals("")||txtAdArea.getText().equals("")||txtAdLane.getText().equals("")||txtAdNo.getText().equals("")||txtTel.getText().equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You missed some fields.Check Again!");
                alert.showAndWait();
            }else{
                CompanyDTO c=new CompanyDTO(txtId.getText(), txtName.getText(),txtAdNo.getText(), txtAdLane.getText(), txtAdArea.getText(), txtAdCity.getText(), txtMail.getText(), txtTel.getText(), txtAddTel.getText(), txtFax.getText());
                if(ctrlCompany.update(c)){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Company Updated Success!");
                    alert.showAndWait();
                    clearAction();
                }
            }
            
        }catch(Exception ex){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You didn't select a company for update!");
            alert.showAndWait();
        }
    }
    @FXML
    private void clearBtnOnAction(ActionEvent evt){
        clearAction();
    }

    private void loadCmbCompany() {
        
        try {
            ArrayList<CompanyDTO> clist=ctrlCompany.getAll();
            for (CompanyDTO companyDTO : clist) {
                cmbCompany.getItems().add(companyDTO.getComName());
            }
        } catch (Exception ex) {
            Logger.getLogger(UpdateCompanyController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
