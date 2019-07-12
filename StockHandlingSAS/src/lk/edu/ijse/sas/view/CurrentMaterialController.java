/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.MaterialController;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import lk.edu.ijse.sas.tableModel.CurrentMatTableModel;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class CurrentMaterialController implements Initializable {
    
    @FXML
    private TableView tblCurrentMat;
    
    @FXML
    private TableColumn colMatName;
    
    @FXML
    private TableColumn colQty;
    
    @FXML
    private PieChart chart;
    
    private MaterialController ctrlMat;
    
    private ObservableList<CurrentMatTableModel> list=FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> chartList=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        tblCurrentMat.getItems().clear();
        tblCurrentMat.setItems(list);
        
        chart.setData(chartList);
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        try {
            colMatName.setCellValueFactory(new PropertyValueFactory<CurrentMatTableModel,String>("MatName"));
            colQty.setCellValueFactory(new PropertyValueFactory<CurrentMatTableModel,String>("Qty"));
            
            ctrlMat=(MaterialController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.MATERIAL);
            
            ArrayList<MaterialDTO> mlist=ctrlMat.getAll();
            
            for (MaterialDTO materialDTO : mlist) {
                
                CurrentMatTableModel tb=new CurrentMatTableModel();
                tb.setMatName(materialDTO.getMaterialName());
                tb.setQty(df.format(materialDTO.getAmount_kg()));
                
                String text=materialDTO.getMaterialName();
                chartList.add(new PieChart.Data(text,materialDTO.getAmount_kg().doubleValue()));
                list.add(tb);
            }
        } catch (Exception ex) {
            Logger.getLogger(CurrentMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }    
    
}
