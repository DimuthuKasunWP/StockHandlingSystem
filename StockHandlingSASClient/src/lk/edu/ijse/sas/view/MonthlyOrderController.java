/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.other.JRViewerFX;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import lk.edu.ijse.sas.controller.custom.QueryController;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class MonthlyOrderController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXButton btnView;
    
    @FXML
    private JFXComboBox cmbYear;
    
    @FXML
    private JFXComboBox cmbMonth;
    
    private QueryController ctrlQuary;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ctrlQuary=(QueryController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.QUARY);
        
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
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        try {
            JRViewerFX view=new JRViewerFX();
            String path="/com/sas/kem/edu/ijse/report/MonthlyProduction.jasper";
            
            String year=cmbYear.getSelectionModel().getSelectedItem().toString();
            String month=cmbMonth.getSelectionModel().getSelectedItem().toString();
            
            ArrayList<BigDecimal> blist=ctrlQuary.getTotal(month, year);
            BigDecimal total=new BigDecimal(0);
            for (BigDecimal bigDecimal : blist) {
                total=total.add(bigDecimal);
            }
            
            String grandTot=df.format(total);
            
            int index=cmbMonth.getSelectionModel().getSelectedIndex()+1;
            String monthNo=Integer.toString(index);
            
            HashMap<String,Object> parameters=new HashMap<>();
            parameters.put("year", year);
            parameters.put("month", month);
            parameters.put("monthNo",monthNo);
            parameters.put("grandTot",grandTot);
            
            view.showReport(path, parameters);
        } catch (Exception ex) {

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You didn't select a year or month!");
            alert.showAndWait();
        }
    }
    
}
