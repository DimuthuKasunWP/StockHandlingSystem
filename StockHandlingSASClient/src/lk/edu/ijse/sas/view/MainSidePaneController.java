/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class MainSidePaneController implements Initializable {
    
    @FXML
    Rectangle rectMat;
    
    @FXML
    Rectangle rectProduct;
    
    @FXML
    Rectangle rectOrders;
    
    @FXML
    Rectangle rectReport;
    
    @FXML
    Rectangle rectSearch;
    
    @FXML
    Rectangle rectDocument;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
