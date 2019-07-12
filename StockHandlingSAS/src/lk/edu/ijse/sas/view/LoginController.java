/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.PasswordController;
import com.sas.kem.edu.ijse.dto.PasswordDTO;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class LoginController implements Initializable {
    
    @FXML
    private JFXTextField txtUserName;
    
    @FXML
    private JFXPasswordField pswdPassword;
    
    @FXML
    private JFXButton btnLogin;
    
    @FXML
    private JFXButton btnExit;
    
    @FXML
    private static AnchorPane pane;
    
    private String dbUserName=null;
    private String dbPassword=null;
    
    private PasswordController ctrlPassword;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            ctrlPassword=(PasswordController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PASSWORD);
            
            ArrayList<PasswordDTO> plist=ctrlPassword.getAll();
            
            for (PasswordDTO passwordDTO : plist) {
                dbUserName=passwordDTO.getUserName();
                dbPassword=passwordDTO.getPassword();
                
            }
           
            
        } catch (Exception ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void btnExitOnAction(ActionEvent evt){
        
        ButtonType yes=new ButtonType("Yes", ButtonBar.ButtonData.YES);
        ButtonType no=new ButtonType("No", ButtonBar.ButtonData.NO);
        
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION,"Are you Sure?",yes, no);
        alert.setTitle("Exit");
        alert.setHeaderText("Do You Want to Exit?");
        Optional<ButtonType> result=alert.showAndWait();
        
        if(result.get()==yes){
            
            ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
        }else{
            
        }
          
    }
    
    @FXML
    private void txtUserNameOnAction(ActionEvent evt){
        
        pswdPassword.requestFocus();
    }
    @FXML
    private void txtPasswordOnAction(ActionEvent evt){
        
        
    }
    @FXML
    private void btnLoginOnAction(ActionEvent evt){
        
        String userName=txtUserName.getText();
        String password=pswdPassword.getText();
        
        if(userName.equals(dbUserName) && password.equals(dbPassword)){
            
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/sas/kem/edu/ijse/view/DashBoard.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("SAS KEM Stock Handling");
                stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/sas/kem/edu/ijse/resource/icon/grote-aantallen.png")));
                stage.setScene(new Scene(root1));
                stage.show();
                
                ((Stage)(((JFXButton)evt.getSource()).getScene().getWindow())).hide();
                
        } catch (IOException e) {
            System.out.println(e);
        }
            
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Incorrect Combination.Try Again!");
            alert.setContentText("cause:Your userName or Password is not correct.check Again");
            alert.setTitle("Login");
            alert.showAndWait();
        }
        
    }
    
}
