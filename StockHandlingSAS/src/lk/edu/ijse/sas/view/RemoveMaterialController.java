/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.Batch_receiveController;
import lk.edu.ijse.sas.controller.custom.MaterialController;
import lk.edu.ijse.sas.controller.custom.Return_batch_receiveController;
import lk.edu.ijse.sas.controller.custom.SectorController;
import lk.edu.ijse.sas.controller.custom.ValidationController;
import com.sas.kem.edu.ijse.dto.BatchGrnDetailsDTO;
import com.sas.kem.edu.ijse.dto.Batch_receiveDTO;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import com.sas.kem.edu.ijse.dto.Remove_receive_materialDTO;
import com.sas.kem.edu.ijse.dto.Remove_return_materialDTO;
import com.sas.kem.edu.ijse.dto.Return_batch_receiveDTO;
import com.sas.kem.edu.ijse.dto.SectorDTO;
import lk.edu.ijse.sas.other.FastReducing;
import lk.edu.ijse.sas.tableModel.RemoveMaterialTableModel;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.edu.ijse.sas.controller.custom.QueryController;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class RemoveMaterialController implements Initializable {
    
    @FXML
    private JFXComboBox cmbMatName;
    
    @FXML
    private JFXComboBox cmbReceiveBatch;
    
    @FXML
    private JFXComboBox cmbSecName;
    
    @FXML
    private JFXComboBox cmbReturnBatch;
    
    @FXML
    private TextField txtMfd;
    
    @FXML
    private TextField txtExp;
    
    @FXML
    private JFXTextField txtQty;
    
    @FXML
    private TextField txtTime;
    
    @FXML
    private TextField txtTotalQty;
    
    @FXML
    private TextField txtBatchQty;
    
    @FXML
    private Label lblMatName;
    
    @FXML
    private Label lblBatch;
    
    @FXML
    private Label lblTotalkg;
    
    @FXML
    private Label lblBatchkg;
    @FXML
    private JFXButton btnCancel;
    
    @FXML
    private JFXButton btnUpdate;
    
    @FXML
    private JFXButton btnRemovetb;
    
    @FXML
    private JFXButton btnClear;
    
    @FXML
    private JFXButton btnRemove;
    
    @FXML
    private JFXButton btnRenameSec;
    
    @FXML
    private JFXButton btnNewSec;
    
    
    @FXML
    private JFXDatePicker dtRemove;
    
    @FXML
    private TableView tblRemove;
    
    @FXML
    private TableColumn colMatName;
    
    @FXML
    private TableColumn colQty;
    
    @FXML
    private TableColumn colTime;
    
    @FXML
    private TableColumn colSecName;
    
    @FXML
    private TableColumn colBatch;
    
    private MaterialController ctrlMat;
    private Batch_receiveController ctrlBatch_receive;
    private SectorController ctrlSec;
    private Return_batch_receiveController ctrlReturn_batch;
    private QueryController ctrlQuary;
    private ValidationController ctrlValidation;
    
    private ObservableList<RemoveMaterialTableModel> list=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                
        setControllers();
        setDate();
        setToolTips();
        SetTableProperty();
        loadCmbMaterial();
        loadCmbSector();
        Platform.runLater(cmbMatName::requestFocus);
    }   
    
    private void setDate() {

        Date d=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String date=df.format(d);
        dtRemove.setValue(LocalDate.parse(date));
    }
    @FXML
    private void txtQtyOnAction(ActionEvent evt){
        cmbSecName.requestFocus();
        
        
    }
    @FXML
    private void cmbSectorOnAction(ActionEvent evt){
        
        Date d=new Date();
        SimpleDateFormat df=new SimpleDateFormat("hh:mm:ss");
        String time=df.format(d);
        txtTime.setText(time);
        
        txtTime.requestFocus();
    }
    private void clearAction(){
        
        cmbMatName.setValue("");
        cmbSecName.setValue("");
        cmbSecName.setDisable(true);
        txtQty.setDisable(true);
        cmbReceiveBatch.setValue("");
        cmbReturnBatch.setValue("");
        txtMfd.setText("");
        txtExp.setText("");
        txtQty.setText("");
        txtTime.setText("");
        txtTotalQty.setText("");
        txtBatchQty.setText("");
        lblMatName.setVisible(false);
        lblBatch.setVisible(false);
        lblBatchkg.setVisible(false);
        lblTotalkg.setVisible(false);
    }

    private void SetTableProperty() {

        colMatName.setCellValueFactory(new PropertyValueFactory<RemoveMaterialTableModel,String>("MatName"));
        colQty.setCellValueFactory(new PropertyValueFactory<RemoveMaterialTableModel,String>("Qty"));
        colTime.setCellValueFactory(new PropertyValueFactory<RemoveMaterialTableModel,String>("Time"));
        colSecName.setCellValueFactory(new PropertyValueFactory<RemoveMaterialTableModel,String>("SecName"));
        colBatch.setCellValueFactory(new PropertyValueFactory<RemoveMaterialTableModel,String>("Batch"));
        
        tblRemove.getItems().clear();
        tblRemove.setItems(list);
    }

    private void loadCmbMaterial() {
        
        try {
            ArrayList<MaterialDTO> mlist=ctrlMat.getAll();
            
            for (MaterialDTO materialDTO : mlist) {
                
                cmbMatName.getItems().add(materialDTO.getMaterialName());
            }
        } catch (Exception ex) {
            Logger.getLogger(RemoveMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setControllers() {
        
        ctrlValidation=(ValidationController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.VALIDATION);
        ctrlQuary=(QueryController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.QUARY);
        ctrlReturn_batch=(Return_batch_receiveController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.RETURN_BATCH_RECEIVE);
        ctrlSec=(SectorController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.SECTOR);
        ctrlMat=(MaterialController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.MATERIAL);
        ctrlBatch_receive=(Batch_receiveController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.BATCH_RECEIVE);
    }
    
    @FXML
    private void cmbMatOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        try {
            cmbReceiveBatch.getItems().clear();
            cmbReceiveBatch.setValue("");
            
            cmbReturnBatch.getItems().clear();
            cmbReturnBatch.setValue("");
            
            String MatName=cmbMatName.getSelectionModel().getSelectedItem().toString();
            
            ArrayList<Batch_receiveDTO> blist=ctrlBatch_receive.getAll();
            for (Batch_receiveDTO batch_receiveDTO : blist) {
                if(ctrlMat.getMaterialId(MatName).equals(batch_receiveDTO.getMid()) && batch_receiveDTO.getCurrent_qty_kg().compareTo(new BigDecimal("0"))>0){
                    
                    cmbReceiveBatch.getItems().add(batch_receiveDTO.getBrid());
                }
            }
            
            ArrayList<Return_batch_receiveDTO> rlist=ctrlReturn_batch.getAll();
            for (Return_batch_receiveDTO return_batch_receiveDTO : rlist) {
                
                if(ctrlMat.getMaterialId(MatName).equals(return_batch_receiveDTO.getMid()) && return_batch_receiveDTO.getCurrent_qty().compareTo(new BigDecimal("0"))>0){
                    
                    cmbReturnBatch.getItems().add(return_batch_receiveDTO.getRbrid());
                }
            }
            BigDecimal qty=null;
            ArrayList<MaterialDTO> mlist=ctrlMat.getAll();
            for (MaterialDTO materialDTO : mlist) {
                if(materialDTO.getMaterialName().equals(MatName)){
                    qty=materialDTO.getAmount_kg();
                    for (RemoveMaterialTableModel tbl : list) {
                        
                        if(tbl.getMatName().equals(MatName)){
                            
                            BigDecimal tbqty=new BigDecimal(dfd.format(df.parse(tbl.getQty())));
                            qty=qty.subtract(tbqty);
                        }
                    }
                }
            }
            txtTotalQty.setText(df.format(qty));
            
            lblMatName.setText(MatName);
            lblTotalkg.setVisible(true);

         } catch (Exception ex) {
           // Logger.getLogger(RemoveMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadCmbSector() {

        try {
            ArrayList<SectorDTO> list=ctrlSec.getAll();
            for (SectorDTO sectorDTO : list) {
                
                cmbSecName.getItems().add(sectorDTO.getSecName());
            }
        } catch (Exception ex) {
            Logger.getLogger(RemoveMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void cmbReceiveBatchOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        cmbReturnBatch.setValue("");
        try {
            
            String batch=cmbReceiveBatch.getSelectionModel().getSelectedItem().toString();
            
            BigDecimal qty=null;
            ArrayList<Batch_receiveDTO> blist=ctrlBatch_receive.getAll();
            for (Batch_receiveDTO batch_receiveDTO : blist) {
                
                if(batch.equals(batch_receiveDTO.getBrid())){
                    txtMfd.setText(batch_receiveDTO.getMfd());
                    txtExp.setText(batch_receiveDTO.getExp());
                    qty=batch_receiveDTO.getCurrent_qty_kg();
                    for (RemoveMaterialTableModel tbl: list) {
                        if(tbl.getBatch().equals(batch)){
                            
                            BigDecimal tbqty=new BigDecimal(dfd.format(df.parse(tbl.getQty())));
                            qty=qty.subtract(tbqty);
                        }
                    }
                }
            }
            txtBatchQty.setText(df.format(qty));
            
            lblBatch.setText(batch);
            lblBatchkg.setVisible(true);
            cmbSecName.setDisable(false);
            txtQty.setDisable(false);
            txtQty.requestFocus();
        } catch (Exception ex) {
          //  Logger.getLogger(RemoveMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void cmbReturnBatchOnAction(ActionEvent evt){
        cmbReceiveBatch.setValue("");
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        try {
            
            String batch=cmbReturnBatch.getSelectionModel().getSelectedItem().toString();
            BigDecimal qty=null;
            ArrayList<Return_batch_receiveDTO> rlist=ctrlReturn_batch.getAll();
            for (Return_batch_receiveDTO return_batch_receiveDTO : rlist) {
                
                if(batch.equals(return_batch_receiveDTO.getRbrid())){
                    txtMfd.setText(return_batch_receiveDTO.getMfd());
                    txtExp.setText(return_batch_receiveDTO.getExp());
                    qty=return_batch_receiveDTO.getCurrent_qty();
                    for (RemoveMaterialTableModel tbl : list) {
                        
                        if(tbl.getBatch().equals(batch)){
                            
                            BigDecimal tbqty=new BigDecimal(dfd.format(df.parse(tbl.getQty())));
                            qty=qty.subtract(tbqty);
                        }
                    }

                }
            }
            
            txtBatchQty.setText(df.format(qty));
            lblBatch.setText(batch);
            lblBatchkg.setVisible(true);
            cmbSecName.setDisable(false);
            txtQty.setDisable(false);
            txtQty.requestFocus();
                    
        } catch (Exception ex) {
            //Logger.getLogger(RemoveMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void txtTimeOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        try{
            String cmbRecbatch=cmbReceiveBatch.getSelectionModel().getSelectedItem().toString();
            String cmbRetbatch=cmbReturnBatch.getSelectionModel().getSelectedItem().toString();
            String matName=cmbMatName.getSelectionModel().getSelectedItem().toString();
            String secname=cmbSecName.getSelectionModel().getSelectedItem().toString();
            
            if(txtQty.getText().equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You missed the quantity Field.check Again!");
                alert.showAndWait();
            }else{
                for (RemoveMaterialTableModel tbl : list) {

                    if((tbl.getBatch().equals(cmbRecbatch) || tbl.getBatch().equals(cmbRetbatch)) && tbl.getMatName().equals(matName) && tbl.getSecName().equals(secname)){

                        String qty=tbl.getQty();
                        String quantity=null;
                        try {
                            quantity=dfd.format(df.parse(qty));
                        } catch (ParseException ex) {
                            Logger.getLogger(RemoveMaterialController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        String batch=tbl.getBatch();
                        String name=tbl.getMatName();
                        String secName=tbl.getSecName();
                        String time=tbl.getTime();

                        RemoveMaterialTableModel tb=new RemoveMaterialTableModel();

                        tb.setBatch(batch);
                        tb.setMatName(matName);
                        tb.setSecName(secName);
                        tb.setTime(time);

                        BigDecimal totalQty = null;
                        try {
                            totalQty = new BigDecimal(quantity).add(new BigDecimal(dfd.format(df.parse(txtQty.getText()))));
                        } catch (ParseException ex) {
                            Logger.getLogger(RemoveMaterialController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        tb.setQty(df.format(totalQty));

                        list.remove(tbl);
                        list.add(tb);

                        tblRemove.refresh();
                        clearAction();
                        return;
                    }
                }

                RemoveMaterialTableModel tb=new RemoveMaterialTableModel();

                BigDecimal quantity=new BigDecimal(txtQty.getText());
                if(cmbRecbatch.equals("")){
                    tb.setBatch(cmbRetbatch);
                }else{
                    tb.setBatch(cmbRecbatch);
                }

                tb.setMatName(matName);
                tb.setTime(txtTime.getText());
                tb.setQty(df.format(quantity));
                tb.setSecName(cmbSecName.getSelectionModel().getSelectedItem().toString());

                list.add(tb);
                tblRemove.refresh();
                clearAction();
            }
            
        }catch(Exception ex){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed some fields.check Again!");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void cancelBtnOnAction(ActionEvent evt){
        
        RemoveMaterialTableModel tb=(RemoveMaterialTableModel)tblRemove.getSelectionModel().getSelectedItem();
        
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please select a row!");
            alert.setContentText("you should select a row before cancel");
            alert.showAndWait();
        }else{
            loadCmbMaterial();
            txtTime.setDisable(false);
            clearAction();
            tblRemove.getSelectionModel().clearSelection();
           
        }
             
    }
    @FXML
    private void updateBtnOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        RemoveMaterialTableModel tb=(RemoveMaterialTableModel)tblRemove.getSelectionModel().getSelectedItem();
        
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please select a row!");
            alert.setContentText("you should select a row before Update");
            alert.showAndWait();
        }else{
            
            RemoveMaterialTableModel tbl=new RemoveMaterialTableModel();
            
            String quantity=txtQty.getText();
            
            BigDecimal qty=new BigDecimal(quantity);
            
            tbl.setBatch(tb.getBatch());
            tbl.setMatName(cmbMatName.getSelectionModel().getSelectedItem().toString());
            tbl.setTime(txtTime.getText());
            tbl.setSecName(cmbSecName.getSelectionModel().getSelectedItem().toString());
            tbl.setQty(df.format(qty));
            
            list.remove(tb);
            list.add(tbl);
            tblRemove.refresh();
            tblRemove.getSelectionModel().clearSelection();
            loadCmbMaterial();
            txtTime.setDisable(false);
            clearAction();
        }
    }
    @FXML
    private void removetbBtnOnAction(ActionEvent evt){
        
        RemoveMaterialTableModel tb=(RemoveMaterialTableModel)tblRemove.getSelectionModel().getSelectedItem();
        
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please select a row!");
            alert.setContentText("you should select a row before Remove a row");
            alert.showAndWait();
        }else{
            
            list.remove(tb);
            tblRemove.refresh();
            tblRemove.getSelectionModel().clearSelection();
            loadCmbMaterial();
            txtTime.setDisable(false);
            clearAction();
        }
    }
    @FXML
    private void tblRowOnAction(MouseEvent evt){
        
        RemoveMaterialTableModel tb=(RemoveMaterialTableModel)tblRemove.getSelectionModel().getSelectedItem();
        
        cmbMatName.getItems().clear();
       
        cmbMatName.setValue(tb.getMatName());
        cmbSecName.setValue(tb.getSecName());
        txtTime.setText(tb.getTime());
        txtQty.setText(tb.getQty());
        
        char[] batch=tb.getBatch().toCharArray();
        if(batch[0]=='R'){
           cmbReturnBatch.setValue(tb.getBatch()); 
        }else{
            cmbReceiveBatch.setValue(tb.getBatch());
        }
        
        
        txtTime.setDisable(true);
        
        
    }
    @FXML
    private void clearBtnOnAction(ActionEvent evt){
        
        clearAction();
        tblRemove.getItems().clear();
        for (RemoveMaterialTableModel tbl : list) {
            list.remove(tbl);
        }
        cmbMatName.setValue("");
    }
    @FXML
    private void removeBtnOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        ArrayList<Return_batch_receiveDTO> retList=new ArrayList<>();
        ArrayList<Batch_receiveDTO> recList=new ArrayList<>();
        ArrayList<MaterialDTO> matList=new ArrayList<>();
        ArrayList<Remove_receive_materialDTO> remRecList=new ArrayList<>();
        ArrayList<Remove_return_materialDTO> remRetList=new ArrayList<>();
        
        try {
            if(list.isEmpty()){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You have not selected items to remove");
                alert.showAndWait();
            }else{
                
                for (RemoveMaterialTableModel tbl : list) {

                    String batch=tbl.getBatch();
                    char[] batchArray=batch.toCharArray();
                    if(batchArray[0]=='R'){

                        BatchGrnDetailsDTO b=ctrlQuary.getReturnBatchGrnDetails(batch);
                        ArrayList<Return_batch_receiveDTO> blist=ctrlReturn_batch.getAll();

                        String mfd=null;
                        String exp=null;
                        BigDecimal dbQty=null;
                        BigDecimal curQty=null;
                        BigDecimal retQty=null;
                        BigDecimal unitPrice=null;
                        BigDecimal total=null;

                        for (Return_batch_receiveDTO return_batch_receiveDTO : blist) {

                            if(batch.equals(return_batch_receiveDTO.getRbrid())){
                                mfd=return_batch_receiveDTO.getMfd();
                                exp=return_batch_receiveDTO.getExp(); 
                                dbQty=return_batch_receiveDTO.getCurrent_qty();
                                retQty=return_batch_receiveDTO.getReturned_qty();
                                String tblQty=dfd.format(df.parse(tbl.getQty()));
                                curQty=dbQty.subtract(new BigDecimal(tblQty));
                                unitPrice=return_batch_receiveDTO.getUnitPrice();
                                total=return_batch_receiveDTO.getTotal();
                            }
                        }
                        Return_batch_receiveDTO rbr=new Return_batch_receiveDTO(tbl.getBatch(),b.getGrn(),ctrlMat.getMaterialId(tbl.getMatName()),mfd,exp,retQty,curQty,unitPrice,total);
                        retList.add(rbr);

                        Remove_return_materialDTO retDto=new Remove_return_materialDTO(ctrlMat.getMaterialId(tbl.getMatName()),tbl.getBatch(),new BigDecimal(dfd.format(df.parse(tbl.getQty()))),dtRemove.getValue().toString(),tbl.getTime(),tbl.getSecName());
                        remRetList.add(retDto);

                    }else{

                        BatchGrnDetailsDTO b=ctrlQuary.getBatchGrnDetails(batch);
                        ArrayList<Batch_receiveDTO> blist=ctrlBatch_receive.getAll();

                        String mfd=null;
                        String exp=null;
                        BigDecimal dbQty=null;
                        BigDecimal recQty=null;
                        BigDecimal curQty=null;
                        BigDecimal unitPrice=null;
                        BigDecimal total=null;

                        for (Batch_receiveDTO batch_receiveDTO : blist) {

                            if(batch.equals(batch_receiveDTO.getBrid())){
                                mfd=batch_receiveDTO.getMfd();
                                exp=batch_receiveDTO.getExp(); 
                                dbQty=batch_receiveDTO.getCurrent_qty_kg();
                                recQty=batch_receiveDTO.getReceived_qty_kg();
                                String tblQty=dfd.format(df.parse(tbl.getQty()));
                                curQty=dbQty.subtract(new BigDecimal(tblQty));
                                unitPrice=batch_receiveDTO.getUnitPrice_1kg();
                                total=batch_receiveDTO.getTotal();
                            }
                        }
                        Batch_receiveDTO br=new Batch_receiveDTO(tbl.getBatch(),b.getGrn(),ctrlMat.getMaterialId(tbl.getMatName()),mfd,exp,recQty,curQty,unitPrice,total);
                        recList.add(br);


                        Remove_receive_materialDTO recDto=new Remove_receive_materialDTO(ctrlMat.getMaterialId(tbl.getMatName()),tbl.getBatch(),new BigDecimal(dfd.format(df.parse(tbl.getQty()))),dtRemove.getValue().toString(),tbl.getTime(),tbl.getSecName());
                        remRecList.add(recDto);
                    }

                    MaterialDTO m=new MaterialDTO(ctrlMat.getMaterialId(tbl.getMatName()),tbl.getMatName(),new BigDecimal(dfd.format(df.parse(tbl.getQty()))));
                    matList.add(m);

                }

                boolean b=ctrlBatch_receive.update_receive_batch(recList, retList, matList, remRecList, remRetList);

                if(b){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Material Remove successful!");
                    alert.setTitle("Remove");
                    alert.showAndWait();
                    tblRemove.getItems().clear();
                }else{
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Material Remove Failed!");
                    alert.setTitle("Remove");
                    alert.showAndWait();
                }
            }
            
            
        }catch (Exception ex) {

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed the remove date field.check Again!");
            alert.showAndWait();
        }
        
        
    }
    
    private BigDecimal[] getAmounts(String batch,String matName){
        
        BigDecimal qty=null;
        BigDecimal totQty=null;
        char[] ch=batch.toCharArray();
         try {
            if(ch[0]=='R'){
           
                ArrayList<Return_batch_receiveDTO> bretList=ctrlReturn_batch.getAll();
                for (Return_batch_receiveDTO return_batch_receiveDTO: bretList) {
                    if(batch.equals(return_batch_receiveDTO.getRbrid())){
                        qty=return_batch_receiveDTO.getCurrent_qty();
                    }
                }
            } else{
                ArrayList<Batch_receiveDTO> brecList=ctrlBatch_receive.getAll();
                for (Batch_receiveDTO batch_receiveDTO : brecList) {
                    if(batch.equals(batch_receiveDTO.getBrid())){
                        qty=batch_receiveDTO.getCurrent_qty_kg();
                    }
                }
            }
            
            ArrayList<MaterialDTO> matlist=ctrlMat.getAll();
             for (MaterialDTO materialDTO : matlist) {
                 if(matName.equals(materialDTO.getMaterialName())){
                     totQty=materialDTO.getAmount_kg();
                 }
             }
        }catch (Exception ex) {
                Logger.getLogger(RemoveMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new BigDecimal[]{qty,totQty};
    }
    @FXML
    private void txtQtyOnKeyReleased(KeyEvent evt){
        
        String matName=cmbMatName.getSelectionModel().getSelectedItem().toString();
        String batch=lblBatch.getText();
        
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        BigDecimal[] amounts=getAmounts(batch, matName);
        BigDecimal batchStock_qty = amounts[0];
        BigDecimal totalStock_qty=amounts[1];
         
        String batches=lblBatch.getText();
        String text=txtQty.getText();
        try{
            char[] ch=batches.toCharArray();
            BigDecimal amount=null;
            BigDecimal value=new BigDecimal(0);
            
            if(ch[0]=='B'){
                ArrayList<Batch_receiveDTO> blist=ctrlBatch_receive.getAll();
                for (Batch_receiveDTO batch_receiveDTO : blist) {
                    if(batches.equals(batch_receiveDTO.getBrid())){
                        amount=batch_receiveDTO.getCurrent_qty_kg();
                    }
                }
                for (RemoveMaterialTableModel removeMaterialTableModel : list) {
                    if(batches.equals(removeMaterialTableModel.getBatch())){
                        value=value.add(new BigDecimal(dfd.format(df.parse(removeMaterialTableModel.getQty()))));
                    }
                }
                if(value.add((new BigDecimal(dfd.format(df.parse(txtQty.getText()))))).compareTo(amount)>0){
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("You have not this Quantity to remove!");
                    alert.showAndWait();
                    txtQty.setText("");
                }
            }else{
                ArrayList<Return_batch_receiveDTO> rlist=ctrlReturn_batch.getAll();
                for (Return_batch_receiveDTO return_batch_receiveDTO : rlist) {
                    if(batches.equals(return_batch_receiveDTO.getRbrid())){
                        amount=return_batch_receiveDTO.getCurrent_qty();
                    }
                }
                for (RemoveMaterialTableModel removeMaterialTableModel : list) {
                    if(batches.equals(removeMaterialTableModel.getBatch())){
                        value=value.add(new BigDecimal(dfd.format(df.parse(removeMaterialTableModel.getQty()))));
                    }
                }
                if(value.add((new BigDecimal(dfd.format(df.parse(txtQty.getText()))))).compareTo(amount)>0){
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("You have not this Quantity to remove!");
                    alert.showAndWait();
                    txtQty.setText("");
                }
            }
            if(!ctrlValidation.setNumberFormat(text)){
                
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You can use only numbers!");
                alert.setContentText("EX: 1233.34,3433");
                alert.showAndWait();
                txtQty.setText("");
                
            }else{
                for (RemoveMaterialTableModel tbl : list) {

                    if(matName.equals(tbl.getMatName()) && batch.equals(tbl.getBatch())){

                        BigDecimal tbqty=new BigDecimal(dfd.format(df.parse(tbl.getQty())));
                        batchStock_qty=batchStock_qty.subtract(tbqty);
                        totalStock_qty=totalStock_qty.subtract(tbqty);

                    }
                }


                double batch_qty=batchStock_qty.doubleValue();
                double total_qty=totalStock_qty.doubleValue();

                FastReducing batchfr=new FastReducing(text, batch_qty);
                String qtyBatch[]=batchfr.getFinalCalculation();
                txtBatchQty.setText(qtyBatch[0]);
                txtBatchQty.setText(df.format(new BigDecimal(qtyBatch[1])));

                FastReducing totalfr=new FastReducing(text, total_qty);
                String qtyTotal[]=totalfr.getFinalCalculation();
                txtTotalQty.setText(qtyTotal[0]);
                txtTotalQty.setText(df.format(new BigDecimal(qtyTotal[1])));
            }
            
            
        }catch(Exception ex){
        }
    }

    private void setToolTips() {

        btnNewSec.setTooltip(new Tooltip("You can introduce a new Sector to your stock !"));
        btnRenameSec.setTooltip(new Tooltip("You can rename a Sector in your stock !"));
        btnCancel.setTooltip(new Tooltip("You can diselect a selected row in the table!"));
        btnRemovetb.setTooltip(new Tooltip("You can remove a row from table!"));
        btnUpdate.setTooltip(new Tooltip("You can update a row in the table!"));
       // btnUndo.setTooltip(new Tooltip("You can get a removed row again into the table!"));
        btnClear.setTooltip(new Tooltip("You can clear the whole Interface!"));
        btnRemove.setTooltip(new Tooltip("You can Remove materials to do Productions!"));
    }
    @FXML
    private void btnNewSecOnAction(ActionEvent evt){
        
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/sas/kem/edu/ijse/view/NewSector.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RemoveMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnRenameSecOnAction(ActionEvent evt){
        
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/sas/kem/edu/ijse/view/RenameSector.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(RemoveMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
