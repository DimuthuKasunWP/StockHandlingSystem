/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.Batch_receiveController;
import lk.edu.ijse.sas.controller.custom.MaterialController;
import lk.edu.ijse.sas.controller.custom.Return_batch_receiveController;
import lk.edu.ijse.sas.controller.custom.ValidationController;
import com.sas.kem.edu.ijse.dto.BatchGrnDetailsDTO;
import com.sas.kem.edu.ijse.dto.Batch_receiveDTO;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import com.sas.kem.edu.ijse.dto.Reject_receiveDTO;
import com.sas.kem.edu.ijse.dto.Reject_return_receiveDTO;
import com.sas.kem.edu.ijse.dto.Return_batch_receiveDTO;
import lk.edu.ijse.sas.other.FastReducing;
import lk.edu.ijse.sas.tableModel.RejectMaterialTableModel;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lk.edu.ijse.sas.controller.custom.QueryController;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class RejectMaterialController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private JFXComboBox cmbMaterial;
    
    @FXML
    private JFXComboBox cmbRetBatch;
    
    @FXML
    private JFXComboBox cmbRecBatch;
    
    @FXML
    private TextField txtMfd;
    
    @FXML
    private TextField txtExp;
    
    @FXML
    private JFXTextField txtQty;
    
    @FXML
    private TextField txtTotalQty;
    
    @FXML
    private TextField txtUnitPrice;
    
    @FXML
    private TextField txtBatchQty;
    
    @FXML
    private Label lblTotal;
    
    @FXML
    private Label lblBatch;
    
    @FXML
    private Label lblTotalkg;
    
    @FXML
    private Label lblBatchkg;
    
    @FXML
    private JFXDatePicker dtReject;
    
    @FXML
    private JFXTextArea txtArCause;
    
    @FXML
    private JFXButton btnCancel;
    
    @FXML
    private JFXButton btnUpdate;
    
    @FXML
    private JFXButton btnRemove;
    
    @FXML
    private JFXButton btnReject;
    
    @FXML
    private JFXButton btnClear;
    
    @FXML
    private TableView tblReject;
    
    @FXML
    private TableColumn colMatName;
    
    @FXML
    private TableColumn colBatchId;
    
    @FXML
    private TableColumn colQty;
    
    @FXML
    private TableColumn colCause;
    
    
    private ObservableList<RejectMaterialTableModel> list=FXCollections.observableArrayList();
    
    private MaterialController ctrlMat;
    private Batch_receiveController ctrlRecBatch;
    private Return_batch_receiveController ctrlRetBatch;
    private QueryController ctrlQuary;
    private ValidationController ctrlValidation;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setToolTips();
        setControllers();
        setShiftBtn();
        setTableProperties();
        loadCmbMaterial();
        setRejectDate();
    }    

    private void setTableProperties() {

        colBatchId.setCellValueFactory(new PropertyValueFactory<RejectMaterialTableModel,String>("Batch"));
        colMatName.setCellValueFactory(new PropertyValueFactory<RejectMaterialTableModel,String>("MatName"));
        colCause.setCellValueFactory(new PropertyValueFactory<RejectMaterialTableModel,String>("Cause"));
        colQty.setCellValueFactory(new PropertyValueFactory<RejectMaterialTableModel,String>("Quantity"));
        
        tblReject.getItems().clear();
        tblReject.setItems(list);
        tblReject.refresh();
    }

    private void setRejectDate() {
        
        Date d=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String date=df.format(d);
        dtReject.setValue(LocalDate.parse(date));
    }

    private void loadCmbMaterial() {
        
        try {
            ArrayList<MaterialDTO> mlist=ctrlMat.getAll();
            for (MaterialDTO materialDTO : mlist) {
                cmbMaterial.getItems().add(materialDTO.getMaterialName());
            }
        } catch (Exception ex) {
            Logger.getLogger(RejectMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setControllers() {
        
        
        ctrlValidation=(ValidationController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.VALIDATION);
        ctrlQuary=(QueryController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.QUARY);
        ctrlRecBatch=(Batch_receiveController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.BATCH_RECEIVE);
        ctrlRetBatch=(Return_batch_receiveController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.RETURN_BATCH_RECEIVE);
        ctrlMat=(MaterialController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.MATERIAL);
    }
    @FXML
    private void cmbMatOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        txtUnitPrice.setText("");
        txtArCause.setText("");
        txtBatchQty.setText("");
        lblTotal.setVisible(false);
        lblBatch.setVisible(false);
        lblBatchkg.setVisible(false);
        lblTotalkg.setVisible(false);
        txtQty.setText("");
        txtExp.setText("");
        txtMfd.setText("");
        txtTotalQty.setText("");
        
        try {
            String matName=cmbMaterial.getSelectionModel().getSelectedItem().toString();

            lblTotalkg.setVisible(true);
            lblTotal.setText(matName);

            txtBatchQty.setText("");
            lblBatchkg.setVisible(false);

            cmbRecBatch.setValue("");
            cmbRetBatch.setValue("");
            cmbRecBatch.getItems().clear();
            cmbRetBatch.getItems().clear();
            
            ArrayList<MaterialDTO>mlist=ctrlMat.getAll();
            for (MaterialDTO materialDTO : mlist) {
                if(matName.equals(materialDTO.getMaterialName())){
                    txtTotalQty.setText(df.format(materialDTO.getAmount_kg()));
                }
            }
           
                
            ArrayList<Batch_receiveDTO> blist=ctrlRecBatch.getAll();
            for (Batch_receiveDTO batch_receiveDTO : blist) {
                if(ctrlMat.getMaterialId(matName).equals(batch_receiveDTO.getMid()) && (batch_receiveDTO.getCurrent_qty_kg().compareTo(new BigDecimal("0"))>0)){

                    cmbRecBatch.getItems().add(batch_receiveDTO.getBrid());
                }
            }
            ArrayList<Return_batch_receiveDTO> rlist=ctrlRetBatch.getAll();
            for (Return_batch_receiveDTO return_batch_receiveDTO: rlist) {
                if(ctrlMat.getMaterialId(matName).equals(return_batch_receiveDTO.getMid()) && (return_batch_receiveDTO.getCurrent_qty().compareTo(new BigDecimal("0"))>0)){

                    cmbRetBatch.getItems().add(return_batch_receiveDTO.getRbrid());
                }
            }
               
            BigDecimal qty=null;
            ArrayList<MaterialDTO> matlist=ctrlMat.getAll();
            for (MaterialDTO materialDTO : matlist) {
                if(materialDTO.getMaterialName().equals(matName)){
                    qty=materialDTO.getAmount_kg();
                    for (RejectMaterialTableModel tbl : list) {

                        if(tbl.getMatName().equals(matName)){

                            BigDecimal tbqty=new BigDecimal(dfd.format(df.parse(tbl.getQuantity())));
                            qty=qty.subtract(tbqty);
                        }
                    }
                }
            }
            txtTotalQty.setText(df.format(qty));
            txtQty.setDisable(true);
            
        } catch (Exception ex) {
           // Logger.getLogger(RejectMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void cmbRecOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        cmbRetBatch.setValue("");
        try {
            
            String batch=cmbRecBatch.getSelectionModel().getSelectedItem().toString();
            
            BigDecimal qty=null;
            ArrayList<Batch_receiveDTO> blist=ctrlRecBatch.getAll();
            for (Batch_receiveDTO batch_receiveDTO : blist) {
                
                if(batch.equals(batch_receiveDTO.getBrid())){
                    txtMfd.setText(batch_receiveDTO.getMfd());
                    txtExp.setText(batch_receiveDTO.getExp());
                    txtQty.setText(df.format(batch_receiveDTO.getCurrent_qty_kg()));
                    txtUnitPrice.setText(df.format(batch_receiveDTO.getUnitPrice_1kg()));
                    qty=batch_receiveDTO.getCurrent_qty_kg();
                    for (RejectMaterialTableModel tbl: list) {
                        if(tbl.getBatch().equals(batch)){
                            
                            BigDecimal tbqty=new BigDecimal(dfd.format(df.parse(tbl.getQuantity())));
                            qty=qty.subtract(tbqty);
                        }
                    }
                }
            }
            
            txtBatchQty.setText(df.format(qty));
            txtQty.requestFocus();
            txtQty.setDisable(false);
            lblBatch.setText(batch);
            lblBatch.setVisible(true);
            lblBatchkg.setVisible(true);
        } catch (Exception ex) {
          //  Logger.getLogger(RemoveMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void cmbRetOnAction(ActionEvent evt){
        cmbRecBatch.setValue("");
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        try {
            
            String batch=cmbRetBatch.getSelectionModel().getSelectedItem().toString();
            BigDecimal qty=null;
            ArrayList<Return_batch_receiveDTO> rlist=ctrlRetBatch.getAll();
            for (Return_batch_receiveDTO return_batch_receiveDTO : rlist) {
                
                if(batch.equals(return_batch_receiveDTO.getRbrid())){
                    txtMfd.setText(return_batch_receiveDTO.getMfd());
                    txtExp.setText(return_batch_receiveDTO.getExp());
                    txtQty.setText(df.format(return_batch_receiveDTO.getCurrent_qty()));
                    txtUnitPrice.setText(df.format(return_batch_receiveDTO.getUnitPrice()));
                    qty=return_batch_receiveDTO.getCurrent_qty();
                    for (RejectMaterialTableModel tbl : list) {
                        
                        if(tbl.getBatch().equals(batch)){
                            
                            BigDecimal tbqty=new BigDecimal(dfd.format(df.parse(tbl.getQuantity())));
                            qty=qty.subtract(tbqty);
                        }
                    }

                }
            }
            
            txtBatchQty.setText(df.format(qty));
            lblBatch.setText(batch);
            lblBatch.setVisible(true);
            lblBatchkg.setVisible(true);
            txtQty.requestFocus();
            txtQty.setDisable(false);
        } catch (Exception ex) {
            //Logger.getLogger(RemoveMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void txtQtyOnAction(ActionEvent evt){
        
        txtArCause.requestFocus();
    }

    private void clearAction() {
        
        txtMfd.setText("");
        txtExp.setText("");
        txtQty.setText("");
        txtTotalQty.setText("");
        txtBatchQty.setText("");
        txtUnitPrice.setText("");
        
        lblBatch.setText("");
        lblBatchkg.setVisible(false);
        lblTotal.setText("");
        lblTotalkg.setVisible(false);
        
        txtArCause.setText("");
        
        txtQty.setDisable(true);
        
        cmbMaterial.setValue("");
        cmbRecBatch.setValue("");
        cmbRetBatch.setValue("");
    }
    @FXML
    private void txtUnitPriceOnAction(ActionEvent evt) {
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);

        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
               
        String matName=cmbMaterial.getSelectionModel().getSelectedItem().toString();
        String batch=lblBatch.getText();
        char[] ch=batch.toCharArray();

        try{
            BigDecimal amount=null;
            if(ch[0]=='B'){
                ArrayList<Batch_receiveDTO> reclist=ctrlRecBatch.getAll();
                for (Batch_receiveDTO batch_receiveDTO : reclist) {
                    if(batch.equals(batch_receiveDTO.getBrid())){
                        amount=batch_receiveDTO.getCurrent_qty_kg();
                    }
                }
                
            }else{
                ArrayList<Return_batch_receiveDTO> retlist=ctrlRetBatch.getAll();
                for (Return_batch_receiveDTO return_batch_receiveDTO : retlist) {
                    if(batch.equals(return_batch_receiveDTO.getRbrid())){
                        amount=return_batch_receiveDTO.getCurrent_qty();
                    }
                }
            }
            int count=0;
            for (RejectMaterialTableModel rejectMaterialTableModel : list) {
                if(batch.equals(rejectMaterialTableModel.getBatch()) && ((amount.subtract(new BigDecimal(dfd.format(df.parse(rejectMaterialTableModel.getQuantity()))))).compareTo(new BigDecimal(dfd.format(df.parse(txtQty.getText()))))<0 )){
                   count++; 
                   Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("You have not any amount to reject from this batch!");
                    alert.showAndWait();
                    clearAction();
                }
            }
            if(count==0 && (amount.subtract(new BigDecimal(dfd.format(df.parse(txtQty.getText()))))).compareTo(new BigDecimal(0))<0){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You have not any amount to reject from this batch!");
                alert.showAndWait();
                clearAction(); 
            
            }else if(txtArCause.getText().equals("") || cmbRecBatch.getSelectionModel().getSelectedItem().toString()==null||cmbRetBatch.getSelectionModel().getSelectedItem().toString()==null||txtQty.getText().equals("")){
                
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You missed some fields.Check Again!");
                alert.showAndWait();
            }else{
                for (RejectMaterialTableModel tbl : list) {

                    if((tbl.getBatch().equals(batch)) && (tbl.getMatName().equals(matName))){

                        BigDecimal tblqty=new BigDecimal(dfd.format(df.parse(tbl.getQuantity())));
                        BigDecimal qty=new BigDecimal(dfd.format(df.parse(txtQty.getText())));

                        BigDecimal total=tblqty.add(qty);

                        String cause=tbl.getCause();
                        String quantity=df.format(total);

                        RejectMaterialTableModel tb=new RejectMaterialTableModel();
                        tb.setBatch(batch);
                        tb.setMatName(matName);
                        tb.setCause(cause);
                        tb.setQuantity(quantity);

                        list.add(tb);
                        list.remove(tbl);

                        tblReject.refresh();
                        clearAction();
                        return;
                    }
                }

                RejectMaterialTableModel tb=new RejectMaterialTableModel();

                tb.setBatch(batch);
                tb.setQuantity(txtQty.getText());
                tb.setCause(txtArCause.getText());
                tb.setMatName(matName);

                list.add(tb);
                tblReject.refresh();
                clearAction();
            }
            
            
        }catch(Exception ex){
           if(txtArCause.getText().equals("") || cmbRecBatch.getSelectionModel().getSelectedItem().toString()==null||cmbRetBatch.getSelectionModel().getSelectedItem().toString()==null||txtQty.getText().equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed some fields.Check Again!");
            alert.showAndWait();  
           } 
        }
    }
    @FXML
    private void clearBtnOnAction(ActionEvent evt){
        
        clearAction();
        tblReject.getItems().clear();
        
    }
    @FXML
    private void cancelBtnOnAction(ActionEvent evt){
        
        RejectMaterialTableModel tb=(RejectMaterialTableModel) tblReject.getSelectionModel().getSelectedItem();
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please Select A Row!");
            alert.setContentText("You must select a row before cancel!");
            alert.showAndWait();
        }else{
           txtUnitPrice.setDisable(false);
           tblReject.getSelectionModel().clearSelection();
           clearAction();
           cmbMaterial.getItems().clear();
           cmbMaterial.setValue("");
           loadCmbMaterial();
        }
        
    }
    @FXML
    private void updateBtnOnAction(ActionEvent evt){
        
        RejectMaterialTableModel tb=(RejectMaterialTableModel) tblReject.getSelectionModel().getSelectedItem();
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please Select A Row!");
            alert.setContentText("You must select a row before update!");
            alert.showAndWait();
        }else{
            
           String matName=cmbMaterial.getSelectionModel().getSelectedItem().toString();
           String batch=lblBatch.getText();
           String qty=txtQty.getText();
           String cause=txtArCause.getText();
           
           RejectMaterialTableModel tbl=new RejectMaterialTableModel();
           tbl.setBatch(batch);
           tbl.setCause(cause);
           tbl.setMatName(matName);
           tbl.setQuantity(qty);
           
           list.remove(tb);
           list.add(tbl);
           tblReject.refresh();
           txtUnitPrice.setDisable(false);
           tblReject.getSelectionModel().clearSelection();
           clearAction();
           cmbMaterial.getItems().clear();
           cmbMaterial.setValue("");
           loadCmbMaterial();
        }
    }
    @FXML
    private void removeBtnOnAction(ActionEvent evt){
        
        RejectMaterialTableModel tb=(RejectMaterialTableModel) tblReject.getSelectionModel().getSelectedItem();
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please Select A Row!");
            alert.setContentText("You must select a row before Remove!");
            alert.showAndWait();
        }else{
            list.remove(tb);
            tblReject.refresh();
            txtUnitPrice.setDisable(false);
            tblReject.getSelectionModel().clearSelection();
            clearAction();
            cmbMaterial.getItems().clear();
            cmbMaterial.setValue("");
            loadCmbMaterial();
        }
    }
    @FXML
    private void rejectBtnOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        ArrayList<Reject_return_receiveDTO> rejRetList=new ArrayList<>();
        ArrayList<Reject_receiveDTO> rejRecList=new ArrayList<>();
        ArrayList<Batch_receiveDTO> recList=new ArrayList<>();
        ArrayList<Return_batch_receiveDTO> retList=new ArrayList<>();
        ArrayList<MaterialDTO> mlist=new ArrayList<>();
        
        try{
            
            if(dtReject.getValue().toString()==null){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You missed the reject date field.check Again!");
                alert.showAndWait();
            }else if(list.isEmpty()){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Reject table has not any items!");
                alert.showAndWait();
                
            }else{
                for (RejectMaterialTableModel tbl : list) {

                    String batch=tbl.getBatch();
                    char[] arr=batch.toCharArray();
                    if(arr[0]=='R'){

                       String quantity=dfd.format(df.parse(tbl.getQuantity()));
                       BigDecimal qty=new BigDecimal(quantity);
                       Reject_return_receiveDTO rejRecDTO=new Reject_return_receiveDTO(batch,qty,tbl.getCause(),dtReject.getValue().toString());

                       BatchGrnDetailsDTO bg=ctrlQuary.getReturnBatchGrnDetails(batch);

                       String mfd=null;
                       String exp=null;
                       BigDecimal retQty=null;
                       BigDecimal rejQty=new BigDecimal(dfd.format(df.parse(tbl.getQuantity())));
                       BigDecimal dbcurQty=null;
                       BigDecimal unitPrice=null;
                       BigDecimal total=null;

                       ArrayList<Return_batch_receiveDTO> blist=ctrlRetBatch.getAll();
                        for (Return_batch_receiveDTO return_batch_receiveDTO : blist) {
                            if(return_batch_receiveDTO.getRbrid().equals(batch)){
                                mfd=return_batch_receiveDTO.getMfd();
                                exp=return_batch_receiveDTO.getExp();
                                retQty=return_batch_receiveDTO.getReturned_qty();
                                dbcurQty=return_batch_receiveDTO.getCurrent_qty();
                                unitPrice=return_batch_receiveDTO.getUnitPrice();
                                total=return_batch_receiveDTO.getTotal();
                            }

                        }

                        BigDecimal curQty=dbcurQty.subtract(rejQty);
                        Return_batch_receiveDTO recDTO=new Return_batch_receiveDTO(batch,bg.getGrn(),ctrlMat.getMaterialId(tbl.getMatName()),mfd,exp,retQty,curQty,unitPrice,total);


                        MaterialDTO m=new MaterialDTO(ctrlMat.getMaterialId(tbl.getMatName()),tbl.getMatName(),qty);

                        rejRetList.add(rejRecDTO);
                        retList.add(recDTO);
                        mlist.add(m);
                    }else{

                       String quantity=dfd.format(df.parse(tbl.getQuantity()));
                       BigDecimal qty=new BigDecimal(quantity);
                       Reject_receiveDTO rejRecDTO=new Reject_receiveDTO(batch,qty,tbl.getCause(),dtReject.getValue().toString());

                       BatchGrnDetailsDTO bg=ctrlQuary.getBatchGrnDetails(batch);

                       String mfd=null;
                       String exp=null;
                       BigDecimal recQty=null;
                       BigDecimal rejQty=new BigDecimal(dfd.format(df.parse(tbl.getQuantity())));
                       BigDecimal dbcurQty=null;
                       BigDecimal unitPrice=null;
                       BigDecimal total=null;

                       ArrayList<Batch_receiveDTO> blist=ctrlRecBatch.getAll();
                        for (Batch_receiveDTO batch_receiveDTO : blist) {
                            if(batch_receiveDTO.getBrid().equals(batch)){

                                mfd=batch_receiveDTO.getMfd();
                                exp=batch_receiveDTO.getExp();
                                recQty=batch_receiveDTO.getReceived_qty_kg();
                                dbcurQty=batch_receiveDTO.getCurrent_qty_kg();
                                unitPrice=batch_receiveDTO.getUnitPrice_1kg();
                                total=batch_receiveDTO.getTotal();
                            }

                        }

                        BigDecimal curQty=dbcurQty.subtract(rejQty);
                        Batch_receiveDTO recDTO=new Batch_receiveDTO(batch,bg.getGrn(),ctrlMat.getMaterialId(tbl.getMatName()),mfd,exp,recQty,curQty,unitPrice,total);

                        MaterialDTO m=new MaterialDTO(ctrlMat.getMaterialId(tbl.getMatName()),tbl.getMatName(),qty);

                        rejRecList.add(rejRecDTO);
                        recList.add(recDTO);
                        mlist.add(m); 
                    }

                }
                boolean b=ctrlMat.updateAsReduce(mlist, retList, recList, rejRecList, rejRetList);
                if(b){
                    Alert alert =new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Reject is Success!");
                    alert.setContentText("The reject report will be prepared");
                    alert.showAndWait();
                    tblReject.getItems().clear();
                }else{
                    Alert alert =new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Reject is Failed!");
                    alert.setContentText("You have an error in material rejecting");
                    alert.showAndWait();
                }
            }
            
            
        }catch(Exception ex){
           
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed the reject date field.check Again!");
            alert.showAndWait();
            
        }
    }
    @FXML
    private void rowOnAction(MouseEvent evt){
        
        try{
        
            RejectMaterialTableModel tb=(RejectMaterialTableModel) tblReject.getSelectionModel().getSelectedItem();

            cmbMaterial.getItems().clear();
            cmbMaterial.getItems().add(tb.getMatName());
            txtArCause.setText(tb.getCause());
            txtQty.setText(tb.getQuantity());
            String batch=tb.getBatch();
            cmbMaterial.setValue(tb.getMatName());
            char[] arr=batch.toCharArray();
            if(arr[0]=='R'){
                cmbRetBatch.setValue(batch);
            }else{
                cmbRecBatch.setValue(batch);
            }
            txtUnitPrice.setDisable(true);
        }catch(Exception ex){
            
        }
    }
    @FXML
    private void txtQtyOnKeyReleased(KeyEvent evt){
        
        String matName=cmbMaterial.getSelectionModel().getSelectedItem().toString();
        String batch=lblBatch.getText();
        
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        BigDecimal[] amounts=getAmounts(batch, matName);
        BigDecimal batchStock_qty = amounts[0];
        BigDecimal totalStock_qty=amounts[1];
         
        
        String text=txtQty.getText();
        try{
            
            if(!ctrlValidation.setNumberFormat(text)){
                
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You can use only numbers!");
                alert.setContentText("EX: 2344.45,2323");
                alert.showAndWait();
                txtQty.setText("");
                
            }else{
                for (RejectMaterialTableModel tbl : list) {

                    if(matName.equals(tbl.getMatName()) && batch.equals(tbl.getBatch())){

                        BigDecimal tbqty=new BigDecimal(dfd.format(df.parse(tbl.getQuantity())));
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
    
    private BigDecimal[] getAmounts(String batch,String matName){
        
        String bat=batch;
        char[] arr=batch.toCharArray();
        
        BigDecimal batchQty=null;
        BigDecimal totalQty=null;
        try{
            if(arr[0]=='R'){
                ArrayList<Return_batch_receiveDTO> rlist=ctrlRetBatch.getAll();
                for (Return_batch_receiveDTO return_batch_receiveDTO : rlist) {
                    if(batch.equals(return_batch_receiveDTO.getRbrid())){
                        batchQty=return_batch_receiveDTO.getCurrent_qty();
                        
                    }
                }
            }else{
                ArrayList<Batch_receiveDTO> blist=ctrlRecBatch.getAll();
                for (Batch_receiveDTO batch_receiveDTO : blist) {
                    if(batch.equals(batch_receiveDTO.getBrid())){
                        batchQty=batch_receiveDTO.getCurrent_qty_kg();
                        
                    }
                }
            }
            
            ArrayList<MaterialDTO> mlist=ctrlMat.getAll();
            for (MaterialDTO materialDTO : mlist) {
                if(matName.equals(materialDTO.getMaterialName())){
                    totalQty=materialDTO.getAmount_kg();
                }
            }
                    
        }catch(Exception ex){
            
        }
        return new BigDecimal[]{batchQty,totalQty};
    }

    private void setToolTips() {
        btnCancel.setTooltip(new Tooltip("You can diselect a selected row in the table!"));
        btnRemove.setTooltip(new Tooltip("You can remove a row from table!"));
        btnUpdate.setTooltip(new Tooltip("You can update a row in the table!"));
        //btnUndo.setTooltip(new Tooltip("You can get a removed row again into the table!"));
        btnClear.setTooltip(new Tooltip("You can clear the whole Interface!"));
        btnReject.setTooltip(new Tooltip("You can Rejecte materials from your stock!"));
    }

    private void setShiftBtn() {

        txtArCause.setOnKeyReleased(e->{
            if(e.getCode()==KeyCode.SHIFT){
                txtUnitPrice.requestFocus();
            }
        });
    }
}
