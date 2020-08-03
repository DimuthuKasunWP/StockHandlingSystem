/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.Batch_receiveController;
import lk.edu.ijse.sas.controller.custom.MaterialController;
import lk.edu.ijse.sas.controller.custom.Remove_receive_materialController;
import lk.edu.ijse.sas.controller.custom.Remove_return_materialController;
import lk.edu.ijse.sas.controller.custom.Return_batch_receiveController;
import com.sas.kem.edu.ijse.dto.BatchGrnDetailsDTO;
import com.sas.kem.edu.ijse.dto.Batch_receiveDTO;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import com.sas.kem.edu.ijse.dto.Remove_receive_materialDTO;
import com.sas.kem.edu.ijse.dto.Remove_return_materialDTO;
import com.sas.kem.edu.ijse.dto.Return_batch_receiveDTO;
import lk.edu.ijse.sas.tableModel.MaterialReceiveTableModel;
import lk.edu.ijse.sas.tableModel.MaterialRemoveTableModel;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.edu.ijse.sas.controller.custom.QueryController;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class MaterialReportController implements Initializable {
    
    @FXML
    private JFXComboBox cmbMaterial;
    
    @FXML
    private Label lblRecMat;
    
    @FXML
    private Label lblRemMat;
    
    @FXML
    private JFXDatePicker dtView;
    
    @FXML
    private TextField txtDate;
    
    @FXML
    private TableView tblReceive;
    
    @FXML
    private TableView tblRemove;
    
    @FXML
    private TableColumn colRecDisc;
    
    @FXML
    private TableColumn colRecBatch;
    
    @FXML
    private TableColumn colRecQty;
    
    @FXML
    private TableColumn colRecUnitPrice;
    
    @FXML
    private TableColumn colRecTotal;
    
    @FXML
    private TableColumn colRecTime;

    @FXML
    private TableColumn colRecDate;
    
    @FXML
    private TableColumn colRemDisc;
    
    @FXML
    private TableColumn colRemBatch;
    
    @FXML
    private TableColumn colRemQty;
    
    @FXML
    private TableColumn colRemSecName;
    
    @FXML
    private TableColumn colRemTime;

    @FXML
    private TableColumn colRemDate;
    
    @FXML
    private AnchorPane thisPane;
    
    ObservableList<MaterialReceiveTableModel> recList=FXCollections.observableArrayList();
    ObservableList<MaterialRemoveTableModel> remList=FXCollections.observableArrayList();
    
    private MaterialController ctrlMat;
    private Remove_receive_materialController ctrlRemRecMat;
    private Remove_return_materialController ctrlRemRetMat;
    private Batch_receiveController ctrlBatchReceive;
    private Return_batch_receiveController ctrlReturnReceive;
    private QueryController ctrlQuary;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setUIs();
        
        SetReceiveTableProperty();
        
        SetRemoveTableProperty();
        
        setControllers();
        
        loadCmbMaterial();
        
        setDate();
    }
    
    private void setControllers() {
        
        ctrlMat=(MaterialController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.MATERIAL);
        ctrlRemRecMat=(Remove_receive_materialController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.REMOVE_RECEIVE_MATERIAL);
        ctrlRemRetMat=(Remove_return_materialController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.REMOVE_RETURN_MATERIAL);
        ctrlBatchReceive=(Batch_receiveController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.BATCH_RECEIVE);
        ctrlReturnReceive=(Return_batch_receiveController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.RETURN_BATCH_RECEIVE);
        ctrlQuary=(QueryController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.QUARY);
    }

    private void SetReceiveTableProperty() {
        
        colRecDisc.setCellValueFactory(new PropertyValueFactory<MaterialReceiveTableModel,String>("Desc"));
        colRecQty.setCellValueFactory(new PropertyValueFactory<MaterialReceiveTableModel,String>("Qty"));
        colRecUnitPrice.setCellValueFactory(new PropertyValueFactory<MaterialReceiveTableModel,String>("UnitPrice"));
        colRecTotal.setCellValueFactory(new PropertyValueFactory<MaterialReceiveTableModel,String>("Total"));
        colRecTime.setCellValueFactory(new PropertyValueFactory<MaterialReceiveTableModel,String>("Time"));
        colRecDate.setCellValueFactory(new PropertyValueFactory<MaterialReceiveTableModel,String>("Date"));
        colRecBatch.setCellValueFactory(new PropertyValueFactory<MaterialReceiveTableModel,String>("Batch"));
        
        tblReceive.getItems().clear();
        tblReceive.setItems(recList);
        tblReceive.refresh();
    }

    private void SetRemoveTableProperty() {
        
        colRemDisc.setCellValueFactory(new PropertyValueFactory<MaterialRemoveTableModel,String>("Desc"));
        colRemQty.setCellValueFactory(new PropertyValueFactory<MaterialRemoveTableModel,String>("Qty"));
        colRemSecName.setCellValueFactory(new PropertyValueFactory<MaterialRemoveTableModel,String>("SecName"));
        colRemTime.setCellValueFactory(new PropertyValueFactory<MaterialRemoveTableModel,String>("Time"));
        colRemDate.setCellValueFactory(new PropertyValueFactory<MaterialRemoveTableModel,String>("Date"));
        colRemBatch.setCellValueFactory(new PropertyValueFactory<MaterialRemoveTableModel,String>("Batch"));
        
        tblRemove.getItems().clear();
        tblRemove.setItems(remList);
        tblRemove.refresh();
    }
    
    @FXML
    private void cmbMatOnAction(ActionEvent evt){
        
        tblReceive.getItems().clear();
        tblRemove.getItems().clear();
        recList.clear();
        remList.clear();
        
        String name=cmbMaterial.getSelectionModel().getSelectedItem().toString();
        
        lblRecMat.setVisible(true);
        lblRecMat.setText(name);
        lblRemMat.setVisible(true);
        lblRemMat.setText(name);
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        try {
            ArrayList<Batch_receiveDTO> bRecList=ctrlBatchReceive.getAll();
            for (Batch_receiveDTO batch_receiveDTO : bRecList) {
                if(ctrlMat.getMaterialId(name).equals(batch_receiveDTO.getMid())){
                    
                    String desc=name;
                    String batch=batch_receiveDTO.getBrid();
                    
                    BigDecimal quantity=batch_receiveDTO.getReceived_qty_kg();
                    String qty=df.format(quantity);
                    
                    BigDecimal unitprice=batch_receiveDTO.getUnitPrice_1kg();
                    String unitPrice=df.format(unitprice);
                    
                    BigDecimal Total=batch_receiveDTO.getTotal();
                    String total=df.format(Total);
                    
                    BatchGrnDetailsDTO b=ctrlQuary.getBatchGrnDetails(batch_receiveDTO.getBrid());
                    String time=b.getTime();
                    String date=b.getDate();
                    
                    MaterialReceiveTableModel tb=new MaterialReceiveTableModel();
                    tb.setBatch(batch);
                    tb.setDate(date);
                    tb.setDesc(desc);
                    tb.setQty(qty);
                    tb.setTime(time);
                    tb.setTotal(total);
                    tb.setUnitPrice(unitPrice);
                    
                    recList.add(tb);
                }
                
            }
            ArrayList<Return_batch_receiveDTO>bRetList=ctrlReturnReceive.getAll();
            for (Return_batch_receiveDTO return_batch_receiveDTO : bRetList) {
                
                if(ctrlMat.getMaterialId(name).equals(return_batch_receiveDTO.getMid())){
                    
                    String desc=name;
                    String batch=return_batch_receiveDTO.getRbrid();
                    
                    BigDecimal quantity=return_batch_receiveDTO.getReturned_qty();
                    String qty=df.format(quantity);
                    
                    BigDecimal unitprice=return_batch_receiveDTO.getUnitPrice();
                    String unitPrice=df.format(unitprice);
                    
                    BigDecimal Total=return_batch_receiveDTO.getTotal();
                    String total=df.format(Total);
                    
                    BatchGrnDetailsDTO b=ctrlQuary.getReturnBatchGrnDetails(return_batch_receiveDTO.getRbrid());
                    String time=b.getTime();
                    String date=b.getDate();
                    
                    MaterialReceiveTableModel tb=new MaterialReceiveTableModel();
                    tb.setBatch(batch);
                    tb.setDate(date);
                    tb.setDesc(desc);
                    tb.setQty(qty);
                    tb.setTime(time);
                    tb.setTotal(total);
                    tb.setUnitPrice(unitPrice);
                    
                    recList.add(tb);
                }
            }
            
            
            
            ArrayList<Remove_receive_materialDTO> remRecList=ctrlRemRecMat.getAll();
            for (Remove_receive_materialDTO remove_receive_materialDTO : remRecList) {
                
                if(ctrlMat.getMaterialId(name).equals(remove_receive_materialDTO.getMid())){
                    
                    String desc=name;
                    String batch=remove_receive_materialDTO.getBrid();
                    
                    BigDecimal quantity=remove_receive_materialDTO.getQty_kg();
                    String qty=df.format(quantity);
                    
                    String secName=remove_receive_materialDTO.getCarry_sector_name();
                    String time=remove_receive_materialDTO.getRemove_time();
                    String date=remove_receive_materialDTO.getRemove_date();
                    
                    MaterialRemoveTableModel tb=new MaterialRemoveTableModel();
                    tb.setBatch(batch);
                    tb.setDate(date);
                    tb.setDesc(desc);
                    tb.setSecName(secName);
                    tb.setQty(qty);
                    tb.setTime(time);
                    
                    remList.add(tb);
                }
            }
            
            ArrayList<Remove_return_materialDTO> remRetList=ctrlRemRetMat.getAll();
            for (Remove_return_materialDTO remove_return_materialDTO : remRetList) {
                
                if(ctrlMat.getMaterialId(name).equals(remove_return_materialDTO.getMid())){
                    
                    String desc=name;
                    String batch=remove_return_materialDTO.getRbrid();
                    
                    BigDecimal quantity=remove_return_materialDTO.getQty_kg();
                    String qty=df.format(quantity);
                    
                    String secName=remove_return_materialDTO.getCarry_sector_name();
                    String time=remove_return_materialDTO.getRemove_time();
                    String date=remove_return_materialDTO.getRemove_date();
                    
                    MaterialRemoveTableModel tb=new MaterialRemoveTableModel();
                    tb.setBatch(batch);
                    tb.setDate(date);
                    tb.setDesc(desc);
                    tb.setSecName(secName);
                    tb.setQty(qty);
                    tb.setTime(time);
                    
                    remList.add(tb);
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(MaterialReportController.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    private void loadCmbMaterial() {
        
        try {
            ctrlMat=(MaterialController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.MATERIAL);
            
            ArrayList<MaterialDTO> mlist=ctrlMat.getAll();
            
            for (MaterialDTO materialDTO : mlist) {
                
                cmbMaterial.getItems().add(materialDTO.getMaterialName());
            }
        } catch (Exception ex) {
            //Logger.getLogger(MaterialReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void setDate() {
        
        Date d=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String date=df.format(d);
        
        txtDate.setText(date);
    }
    
    @FXML
    private void dateOnAction(ActionEvent evt){
        
        lblRecMat.setVisible(false);
        lblRemMat.setVisible(false);
        recList.clear();
        remList.clear();
        
        tblReceive.getItems().clear();
        tblRemove.getItems().clear();
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        String date=dtView.getValue().toString();
        
        try {
            ArrayList<Batch_receiveDTO> bRecList=ctrlBatchReceive.getAll();
            for (Batch_receiveDTO batch_receiveDTO : bRecList) {
                
                BatchGrnDetailsDTO b=ctrlQuary.getBatchGrnDetails(batch_receiveDTO.getBrid());
                if(date.equals(b.getDate())){
                    
                    String desc=ctrlMat.getMatName(batch_receiveDTO.getMid());
                    String batch=batch_receiveDTO.getBrid();
                    
                    BigDecimal quantity=batch_receiveDTO.getReceived_qty_kg();
                    String qty=df.format(quantity);
                    
                    BigDecimal unitprice=batch_receiveDTO.getUnitPrice_1kg();
                    String unitPrice=df.format(unitprice);
                    
                    BigDecimal Total=batch_receiveDTO.getTotal();
                    String total=df.format(Total);
                    
                    String time=b.getTime();
                    
                    MaterialReceiveTableModel tb=new MaterialReceiveTableModel();
                    
                    tb.setBatch(batch);
                    tb.setDate(date);
                    tb.setDesc(desc);
                    tb.setQty(qty);
                    tb.setTime(time);
                    tb.setTotal(total);
                    tb.setUnitPrice(unitPrice);
                    
                    recList.add(tb);
                }
            }
            ArrayList<Return_batch_receiveDTO> bRetList=ctrlReturnReceive.getAll();
            for (Return_batch_receiveDTO return_batch_receiveDTO : bRetList) {
                
                BatchGrnDetailsDTO b=ctrlQuary.getReturnBatchGrnDetails(return_batch_receiveDTO.getRbrid());
                if(date.equals(b.getDate())){
                    
                    String desc=ctrlMat.getMatName(return_batch_receiveDTO.getMid());
                    String batch=return_batch_receiveDTO.getRbrid();
                    
                    BigDecimal quantity=return_batch_receiveDTO.getReturned_qty();
                    String qty=df.format(quantity);
                    
                    BigDecimal unitprice=return_batch_receiveDTO.getUnitPrice();
                    String unitPrice=df.format(unitprice);
                    
                    BigDecimal Total=return_batch_receiveDTO.getTotal();
                    String total=df.format(Total);
                    
                    String time=b.getTime();
                    
                    MaterialReceiveTableModel tb=new MaterialReceiveTableModel();
                    
                    tb.setBatch(batch);
                    tb.setDate(date);
                    tb.setDesc(desc);
                    tb.setQty(qty);
                    tb.setTime(time);
                    tb.setTotal(total);
                    tb.setUnitPrice(unitPrice);
                    
                    recList.add(tb);
                }
            }
            
            
            
            ArrayList<Remove_receive_materialDTO> remRecList=ctrlRemRecMat.getAll();
            for (Remove_receive_materialDTO remove_receive_materialDTO : remRecList) {
                
                if(date.equals(remove_receive_materialDTO.getRemove_date())){
                    
                    String desc=ctrlMat.getMatName(remove_receive_materialDTO.getMid());
                    String batch=remove_receive_materialDTO.getBrid();
                    
                    BigDecimal quantity=remove_receive_materialDTO.getQty_kg();
                    String qty=df.format(quantity);
                    
                    String secName=remove_receive_materialDTO.getCarry_sector_name();
                    String time=remove_receive_materialDTO.getRemove_time();
                    
                    MaterialRemoveTableModel tb=new MaterialRemoveTableModel();
                    
                    tb.setBatch(batch);
                    tb.setDate(date);
                    tb.setDesc(desc);
                    tb.setQty(qty);
                    tb.setSecName(secName);
                    tb.setTime(time);
                    
                    remList.add(tb);
                }
            }
            
            ArrayList<Remove_return_materialDTO> remRetList=ctrlRemRetMat.getAll();
            for (Remove_return_materialDTO remove_return_materialDTO : remRetList) {
                
                if(date.equals(remove_return_materialDTO.getRemove_date())){
                    
                    String desc=ctrlMat.getMatName(remove_return_materialDTO.getMid());
                    String batch=remove_return_materialDTO.getRbrid();
                    
                    BigDecimal quantity=remove_return_materialDTO.getQty_kg();
                    String qty=df.format(quantity);
                    
                    String secName=remove_return_materialDTO.getCarry_sector_name();
                    String time=remove_return_materialDTO.getRemove_time();
                    
                    MaterialRemoveTableModel tb=new MaterialRemoveTableModel();
                    
                    tb.setBatch(batch);
                    tb.setDate(date);
                    tb.setDesc(desc);
                    tb.setQty(qty);
                    tb.setSecName(secName);
                    tb.setTime(time);
                    
                    remList.add(tb);
                }
            }
            
        } catch (Exception ex) {
            //Logger.getLogger(MaterialReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setUIs() {

        thisPane.setOnKeyReleased(e->{
            switch(e.getCode()){
                
                case DIGIT1:    try{

                                    AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/ProductionReport.fxml"));
                                    DashBoardController.rootPane.getChildren().setAll(contain);
                                }catch(IOException ex){

                                }
                                break; 
                                
                case DIGIT3:    try{
                                    
                                    AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/SearchStock.fxml"));
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
