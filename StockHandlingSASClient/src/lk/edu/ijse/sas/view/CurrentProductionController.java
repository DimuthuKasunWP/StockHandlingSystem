/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.ProductController;
import com.sas.kem.edu.ijse.dto.BatchProDTO;
import lk.edu.ijse.sas.tableModel.CurrentProTableModel;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.edu.ijse.sas.controller.custom.QueryController;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class CurrentProductionController implements Initializable {
    
    @FXML
    private TableView tblCurrentPro;
    
    @FXML
    private TableColumn colProName;
    
    @FXML
    private TableColumn colBatch;
    
    @FXML
    private TableColumn colProQty;
    
    @FXML
    private TableColumn colCurQty;
    
    @FXML
    private AnchorPane thisPane;
    
    @FXML
    private PieChart chart;
    
    private ObservableList<CurrentProTableModel> list=FXCollections.observableArrayList();
    private ObservableList<PieChart.Data> chartList=FXCollections.observableArrayList();
    
    private QueryController ctrlQuary;
    private ProductController ctrlPro;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        try {
            setUIs();
            
            tblCurrentPro.getItems().clear();
            tblCurrentPro.setItems(list);
            chart.setData(chartList);
            
            ctrlQuary=(QueryController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.QUARY);
            ctrlPro=(ProductController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT);
            
            colBatch.setCellValueFactory(new PropertyValueFactory<CurrentProTableModel,String>("Batch"));
            colProName.setCellValueFactory(new PropertyValueFactory<CurrentProTableModel,String>("ProName"));
            colProQty.setCellValueFactory(new PropertyValueFactory<CurrentProTableModel,Integer>("ProQty"));
            colCurQty.setCellValueFactory(new PropertyValueFactory<CurrentProTableModel,Integer>("CurQty"));
            
            ArrayList<BatchProDTO> getList=ctrlQuary.getBatchProDetails();
            
            for (BatchProDTO batchProDTO : getList) {
                
                CurrentProTableModel tb=new CurrentProTableModel();
                if(!(batchProDTO.getCurrent_qty()==0)){
                    
                    tb.setBatch(batchProDTO.getBaid());
                    tb.setProName(ctrlPro.getProName(batchProDTO.getProid()));
                    tb.setProQty(batchProDTO.getProduct_qty());
                    tb.setCurQty(batchProDTO.getCurrent_qty());
                    
                    String text=ctrlPro.getProName(batchProDTO.getProid())+"("+batchProDTO.getBaid()+")";
                    chartList.add(new PieChart.Data(text, batchProDTO.getCurrent_qty()));
                    list.add(tb);
                    
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(CurrentProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    private void setUIs() {

        thisPane.setOnKeyReleased(e->{
            switch(e.getCode()){
                
                case DIGIT2:    try{

                                    AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/OrderProduction.fxml"));
                                    DashBoardController.rootPane.getChildren().setAll(contain);
                                }catch(IOException ex){

                                }
                                break; 
                                
                case DIGIT1:    try{

                    
                                    AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/AddProduction.fxml"));
                                    DashBoardController.rootPane.getChildren().setAll(contain);
                                }catch(IOException ex){

                                }
     
                                break;
                case ESCAPE:    try{

                                    AnchorPane sidePane = FXMLLoader.load(getClass().getResource(("/com/sas/kem/edu/ijse/view/MainSidePane.fxml")));
                                    DashBoardController.sideP.getChildren().setAll(sidePane);              
                                        
                                    AnchorPane contentPane = FXMLLoader.load(getClass().getResource(("/com/sas/kem/edu/ijse/view/SelectionPage.fxml")));
                                    DashBoardController.rootPane.getChildren().setAll(contentPane);

                                    
                                }catch(IOException ex){

                                }
                                break;
            }
        });
    }
    
}
