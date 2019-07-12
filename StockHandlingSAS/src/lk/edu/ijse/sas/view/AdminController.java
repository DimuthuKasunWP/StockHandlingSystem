/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.CompanyController;
import lk.edu.ijse.sas.controller.custom.MaterialController;
import lk.edu.ijse.sas.controller.custom.PasswordController;
import lk.edu.ijse.sas.controller.custom.ProductController;
import lk.edu.ijse.sas.controller.custom.SectorController;
import com.sas.kem.edu.ijse.dto.CompanyDTO;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import com.sas.kem.edu.ijse.dto.PasswordDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import com.sas.kem.edu.ijse.dto.SectorDTO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class AdminController implements Initializable {
    
    @FXML
    private JFXPasswordField pfCurPwrd;
    
    @FXML
    private JFXTextField txtUserName;
    
    @FXML
    private JFXPasswordField pfNewPwrd;
    
    @FXML
    private JFXPasswordField pfVerifyPwrd;
    
    @FXML
    private JFXButton btnChange;
    
    @FXML
    private JFXButton btnBack;
    
    @FXML
    private Label lblInform;
    
    @FXML
    private JFXComboBox cmbCom;
    
    @FXML
    private JFXComboBox cmbPro;
    
    @FXML
    private JFXComboBox cmbSec;
    
    @FXML
    private JFXComboBox cmbMat;
    
    @FXML
    private JFXButton btnRemCom;
    
    @FXML
    private JFXButton btnRemMat;
    
    @FXML
    private JFXButton btnRemSec;
    
    @FXML
    private JFXButton btnRemPro;
    
    @FXML
    private TextField txtCom;
    
    @FXML
    private TextField txtMat;
    
    @FXML
    private TextField txtSec;
    
    @FXML
    private TextField txtPro;
    
    private PasswordController ctrlPswd;
    private CompanyController ctrlCom;
    private MaterialController ctrlMat;
    private SectorController ctrlSec;
    private ProductController ctrlPro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ctrlPswd=(PasswordController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PASSWORD);
        
        ctrlCom=(CompanyController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.COMPANY);
        ctrlPro=(ProductController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT);
        ctrlMat=(MaterialController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.MATERIAL);
        ctrlSec=(SectorController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.SECTOR);
        
        loadCmbMat();
        loadCmbPro();
        loadCmbCom();
        loadCmbSec();
                
    }    
    
    @FXML
    private void pfCurOnAction(ActionEvent evt){
        
        try {
            ArrayList<PasswordDTO> plist=ctrlPswd.getAll();
            String password=null;
            for (PasswordDTO passwordDTO : plist) {
                password=passwordDTO.getPassword();
            }
            if(password.equals(pfCurPwrd.getText())){
                lblInform.setVisible(false);
                pfNewPwrd.requestFocus();
                
            }else{
               
                lblInform.setVisible(true);
                lblInform.setText("Your Current Password is Wrong!");
                pfCurPwrd.setText("");
                
            }
             
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @FXML
    private void txtUserNameOnAction(ActionEvent evt){
        
        pfCurPwrd.requestFocus();
    }
    
    @FXML
    private void pfnewPwrdOnAction(ActionEvent evt){
        
        String text=pfNewPwrd.getText();
        char[] pwrd=text.toCharArray();
        int count=0;
        int leters=0;
        for(int i=0;i<pwrd.length;i++){
            if(pwrd[i]=='!' ||pwrd[i]=='@' ||pwrd[i]=='#' ||pwrd[i]=='$' ||pwrd[i]=='%' ||pwrd[i]=='^' ||pwrd[i]=='&' ||pwrd[i]=='*' ||pwrd[i]=='(' ||pwrd[i]==')' ||pwrd[i]=='_' ||pwrd[i]=='-' ||pwrd[i]=='+' ||pwrd[i]=='=' ||pwrd[i]=='|' ||pwrd[i]=='[' ||pwrd[i]==']' ||pwrd[i]=='{' ||pwrd[i]=='}' ||pwrd[i]==';' ||pwrd[i]==':' ||pwrd[i]=='"' ||pwrd[i]=='?' ||pwrd[i]=='/' ||pwrd[i]=='.' ||pwrd[i]=='>'||pwrd[i]=='<'||pwrd[i]==','){
                count++;
                
            }
            leters++;
        }
        if(count>=2 && leters==8){
            lblInform.setText("Your Password is Strong!");
            lblInform.setTextFill(Paint.valueOf("#00ef22"));
            lblInform.setVisible(true);
            pfVerifyPwrd.requestFocus();
        }else if(count<2){
            lblInform.setText("You must use #,@.. as Symbols to your Password!");
            pfNewPwrd.setText("");
            lblInform.setVisible(true);
            
        }else if(leters<8){
            lblInform.setText("You must use 8 letters to your Password!");
            pfNewPwrd.setText("");
            lblInform.setVisible(true);
        }else if(leters>8){
            lblInform.setText("You can use only 8 letters to your Password!");
            pfNewPwrd.setText("");
            lblInform.setVisible(true);
        }
    }
    @FXML
    private void pfVerifyOnAction(ActionEvent evt){
        
        if(pfNewPwrd.getText().equals(pfVerifyPwrd.getText())){
            lblInform.setText("All Complete.click the change Button!");
            lblInform.setVisible(true);
            lblInform.setTextFill(Paint.valueOf("#00ef22"));
            
        }else{
            lblInform.setText("Verify password Is wrong!");
            lblInform.setTextFill(Paint.valueOf("#ff8000"));
            lblInform.setVisible(true);
            pfVerifyPwrd.setText("");
        }
    }
    
    @FXML
    private void changeBtnOnAction(ActionEvent evt){
        if(txtUserName.getText().equals("")||pfCurPwrd.getText().equals("")||pfNewPwrd.getText().equals("")||pfVerifyPwrd.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed a field when filling!");
            alert.setContentText("Check the fields Again");
            alert.setTitle("Error");
            alert.showAndWait();
        }else{
            ButtonType yes=new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
            ButtonType no=new ButtonType("No", ButtonBar.ButtonData.NO);

            Alert alert=new Alert(Alert.AlertType.CONFIRMATION, "Are you Sure?", yes,no);
            alert.setHeaderText("Do you want to change the Password?");
            alert.setTitle("Change Password");
            Optional<ButtonType> res=alert.showAndWait();
            if(res.get()==yes){
                String lastName=null;
                try {
                    String userName=txtUserName.getText();
                    String password=pfNewPwrd.getText();
                    ArrayList<PasswordDTO> plist=ctrlPswd.getAll();
                    for (PasswordDTO passwordDTO : plist) {
                        lastName=passwordDTO.getUserName();
                    }

                    boolean b=ctrlPswd.updatePassword(userName, password, lastName);

                    if(b){
                        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                        alert1.setHeaderText("Password Changed!");
                        alert1.setTitle("Password");
                        alert1.showAndWait();
                        clearAction();
                    }

                } catch (Exception ex) {
                    Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
               clearAction();
            }
        }
        
    }
    
    private void clearAction(){
        txtUserName.setText("");
        pfCurPwrd.setText("");
        pfNewPwrd.setText("");
        pfVerifyPwrd.setText("");
    }
    
    @FXML
    private void cmbComOnAction(ActionEvent evt){
        
        String comName=cmbCom.getSelectionModel().getSelectedItem().toString();
        txtCom.setText(comName);
          
    }
    @FXML
    private void cmbMatOnAction(ActionEvent evt){
        String matName=cmbMat.getSelectionModel().getSelectedItem().toString();
        txtMat.setText(matName);
    }
    @FXML
    private void cmbProOnAction(ActionEvent evt){
        String proName=cmbPro.getSelectionModel().getSelectedItem().toString();
        txtPro.setText(proName);
    }
    @FXML
    private void cmbSecOnAction(ActionEvent evt){
        String secName=cmbSec.getSelectionModel().getSelectedItem().toString();
        txtSec.setText(secName);
    }
    @FXML
    private void btnRemComOnAction(ActionEvent evt){
        
        if(txtCom.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Please select a company before remove!");
            alert.setTitle("Company");
            alert.showAndWait();
        }else{
            
            try {
                String name=cmbCom.getSelectionModel().getSelectedItem().toString();
                String id=null;
                
                ArrayList<CompanyDTO> clist=ctrlCom.getAll();
                for (CompanyDTO companyDTO : clist) {
                    if(name.equals(companyDTO.getComName())){
                        id=companyDTO.getCid();
                    }
                }
                boolean b=ctrlCom.remove(id);
                
                if(b){
                    ButtonType yes=new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no=new ButtonType("No", ButtonBar.ButtonData.NO);

                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure?",yes,no);
                    alert.setHeaderText("Do you want to Remove this Company?");
                    alert.setTitle("Remove");
                    Optional<ButtonType> res=alert.showAndWait();
                    if(res.get()==yes){
                        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Remove Success!");
                        alert.setTitle("Remove");
                        alert.showAndWait();
                    }
                }else{
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Remove Failed!");
                    alert.setTitle("Remove");
                    alert.showAndWait();
                }
                
            } catch (Exception ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    private void btnRemProOnAction(ActionEvent evt){
        
        if(txtPro.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Please select a product before remove!");
            alert.setTitle("Product");
            alert.showAndWait();
        }else{
            
            try {
                String name=cmbPro.getSelectionModel().getSelectedItem().toString();
                String id=null;
                
                ArrayList<ProductDTO> plist=ctrlPro.getAll();
                for (ProductDTO productDTO : plist) {
                    if(name.equals(productDTO.getProductName())){
                        id=productDTO.getProid();
                    }
                }
                boolean b=ctrlPro.remove(id);
                if(b){
                    ButtonType yes=new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no=new ButtonType("No", ButtonBar.ButtonData.NO);

                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure?",yes,no);
                    alert.setHeaderText("Do you want to Remove this Product?");
                    alert.setTitle("Remove");
                    Optional<ButtonType> res=alert.showAndWait();
                    if(res.get()==yes){
                        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Remove Success!");
                        alert.setTitle("Remove");
                        alert.showAndWait();
                    }
                }else{
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Remove Failed!");
                    alert.setTitle("Remove");
                    alert.showAndWait();
                }
                
            } catch (Exception ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    private void btnRemMatOnAction(ActionEvent evt){
        
        if(txtMat.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Please select a Material before remove!");
            alert.setTitle("Material");
            alert.showAndWait();
        }else{
            
            try {
                String name=cmbMat.getSelectionModel().getSelectedItem().toString();
                String id=null;
                
                ArrayList<MaterialDTO> mlist=ctrlMat.getAll();
                for (MaterialDTO materialDTO : mlist) {
                    if(name.equals(materialDTO.getMaterialName())){
                        id=materialDTO.getMid();
                    }
                }
                boolean b=ctrlMat.remove(id);
                
                if(b){
                    ButtonType yes=new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no=new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure?",yes,no);
                    alert.setHeaderText("Do you want to Remove this Material?");
                    alert.setTitle("Remove");
                    Optional<ButtonType> res=alert.showAndWait();
                    if(res.get()==yes){
                        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Remove Success!");
                        alert.setTitle("Remove");
                        alert.showAndWait();
                        cmbMat.setValue("");
                    }
                }else{
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Remove Failed!");
                    alert.setTitle("Remove");
                    alert.showAndWait();
                    cmbMat.setValue("");
                }
                
            } catch (Exception ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    private void btnRemSecOnAction(ActionEvent evt){
        
        if(txtSec.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Please select a Sector before remove!");
            alert.setTitle("Sector");
            alert.showAndWait();
        }else{
            
            try {
                String name=cmbSec.getSelectionModel().getSelectedItem().toString();
                String id=null;
                
                ArrayList<SectorDTO> slist=ctrlSec.getAll();
                for (SectorDTO sectorDTO : slist) {
                    if(name.equals(sectorDTO.getSecName())){
                        id=sectorDTO.getSecName();
                    }
                }
                boolean b=ctrlSec.remove(id);
                
                if(b){
                    ButtonType yes=new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no=new ButtonType("No", ButtonBar.ButtonData.NO);

                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION, "Are You Sure?",yes,no);
                    alert.setHeaderText("Do you want to Remove this Sector?");
                    alert.setTitle("Remove");
                    Optional<ButtonType> res=alert.showAndWait();
                    if(res.get()==yes){
                        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Remove Success!");
                        alert.setTitle("Remove");
                        alert.showAndWait();
                    }
                }else{
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Remove Failed!");
                    alert.setTitle("Remove");
                    alert.showAndWait();
                }
                
            } catch (Exception ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void loadCmbSec() {
        
        try {
            ArrayList<SectorDTO> slist=ctrlSec.getAll();
            for (SectorDTO sectorDTO : slist) {
                cmbSec.getItems().add(sectorDTO.getSecName());
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadCmbCom() {

        try {
            ArrayList<CompanyDTO> clist=ctrlCom.getAll();
            for (CompanyDTO companyDTO : clist) {
                cmbCom.getItems().add(companyDTO.getComName());
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadCmbPro() {
        
        try {
            ArrayList<ProductDTO> plist=ctrlPro.getAll();
            for (ProductDTO productDTO : plist) {
                cmbPro.getItems().add(productDTO.getProductName());
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadCmbMat() {

        try {
            ArrayList<MaterialDTO> mlist=ctrlMat.getAll();
            for (MaterialDTO materialDTO : mlist) {
                cmbMat.getItems().add(materialDTO.getMaterialName());
            }
        } catch (Exception ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MaterialMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
