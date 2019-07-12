/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import lk.edu.ijse.sas.other.JRViewerFX;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class MonthlyReceiveMatController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton btnView;
    
    @FXML
    private JFXComboBox cmbYear;
    
    @FXML
    private JFXComboBox cmbMonth;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadCmbYear();
        loadCmbMonth();
    }    

    private void loadCmbMonth() {

        ArrayList<String> stringList=new ArrayList<>();
        stringList.add("January");
        stringList.add("February");
        stringList.add("March");
        stringList.add("April");
        stringList.add("May");
        stringList.add("June");
        stringList.add("July");
        stringList.add("August");
        stringList.add("September");
        stringList.add("October");
        stringList.add("November");
        stringList.add("December");
        
        for (String string : stringList) {
            cmbMonth.getItems().add(string);
        }
        
        
    }
    

    private void loadCmbYear() {

        String[] string={"2017","2018","2019","2020","2021","2022","2023","2024","2025"};
        for(int i=0;i<string.length;i++){
            cmbYear.getItems().add(string[i]);
        }
    }
    
    @FXML
    private void btnViewOnAction(ActionEvent evt){
        
        try{
            JRViewerFX view=new JRViewerFX();
            String path="/com/sas/kem/edu/ijse/report/MonthlyReceiveMat.jasper";

            String year=cmbYear.getSelectionModel().getSelectedItem().toString();
            String month=cmbMonth.getSelectionModel().getSelectedItem().toString();

            int index=cmbMonth.getSelectionModel().getSelectedIndex()+1;
            String monthNo=Integer.toString(index);

            HashMap<String,Object> parameters=new HashMap<>();
            parameters.put("year", year);
            parameters.put("month", month);
            parameters.put("monthNo",monthNo);

            view.showReport(path, parameters);
        }catch(Exception ex){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed the year or month!");
            alert.showAndWait();
        }
    }   
}
