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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class SearchMaterialComController implements Initializable {
    
    @FXML
    private JFXButton btnBack;
    
    @FXML
    private JFXListView loadList;
    
    @FXML
    private JFXTextField txtSearch;
    
    @FXML
    public AnchorPane searchPane;

    private CompanyController ctrlCom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setControllers();
        
        loadList.setOnKeyReleased(e->{
            
            if(e.getCode()==KeyCode.ENTER){
                
                txtSearch.setText(loadList.getSelectionModel().getSelectedItem().toString());
                loadList.setVisible(false);
                txtSearch.setText("");
  
            }
        });
    }    

    private void setControllers() {
        
        ctrlCom=(CompanyController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.COMPANY);
    }
    
    @FXML
    private void txtSearchOnKeyReleased(KeyEvent evt){
        
        try {
            String name=txtSearch.getText();
            
            if(name.equals("")){
                loadList.setVisible(false);
            }else{
                ObservableList<String> comList=ctrlCom.getComNames(name);
                
                if(comList.equals(null)){
                    
                    loadList.setVisible(false);
                }else{
                    
                    loadList.getItems().clear();
                    loadList.setItems(comList);
                    loadList.getSelectionModel().selectFirst();
                    loadList.setVisible(true);
                    if(txtSearch.getText().toCharArray().length>3){
                       
                        Platform.runLater(loadList::requestFocus); 
                    
                    }
                    
                }
                
            }
           
        } catch (Exception ex) {
            //Logger.getLogger(SearchProController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnBackOnAction(ActionEvent evt){
        
        try {
            AnchorPane box=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/AllSearch.fxml"));
            MaterialMenuController.rootPane.getChildren().setAll(box);
        } catch (IOException ex) {
            Logger.getLogger(SearchMaterialComController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
