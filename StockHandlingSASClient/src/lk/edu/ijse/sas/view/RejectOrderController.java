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
import lk.edu.ijse.sas.controller.custom.Batch_addController;
import lk.edu.ijse.sas.controller.custom.IdController;
import lk.edu.ijse.sas.controller.custom.OrdersController;
import lk.edu.ijse.sas.controller.custom.ProductController;
import lk.edu.ijse.sas.controller.custom.Product_orderController;
import lk.edu.ijse.sas.controller.custom.ValidationController;
import com.sas.kem.edu.ijse.dto.BatchOrderDTO;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import com.sas.kem.edu.ijse.dto.OrdersDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import com.sas.kem.edu.ijse.dto.Product_orderDTO;
import com.sas.kem.edu.ijse.dto.Reject_orderDTO;
import com.sas.kem.edu.ijse.dto.Reject_order_detailDTO;
import lk.edu.ijse.sas.tableModel.RejectOrderTableModel;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import lk.edu.ijse.sas.controller.custom.QueryController;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class RejectOrderController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXComboBox cmbPo;
    
    @FXML
    private TextField txtOrder;
    
    @FXML
    private JFXTextField txtProName;
    
    @FXML
    private JFXTextField txtQuantity;
    
    @FXML
    private TextField txtRejNo;
    
    @FXML
    private TextField txtAmount;
    
    @FXML
    private JFXDatePicker dtReject;
    
    @FXML
    private JFXButton  btnCancel;
    
    @FXML
    private JFXButton  btntbUpdate;
    
    @FXML
    private JFXButton  btnRemove;
    
    @FXML
    private JFXButton  btnUndo;
    
    @FXML
    private JFXButton  btnRenameProduction;
    
    @FXML
    private JFXButton  btnClear;
    
    @FXML
    private JFXButton  btnUpdate;
             
    @FXML
    private TableView tblRejectOrder;
    
    @FXML
    private TableColumn colProName;
    
    @FXML
    private TableColumn colBatch;
    
    @FXML
    private TableColumn colMfd;
    
    @FXML
    private TableColumn colExp;
    
    @FXML
    private TableColumn colQty;
            
    private ObservableList<RejectOrderTableModel> list=FXCollections.observableArrayList();
    private ObservableList<RejectOrderTableModel> undoList=FXCollections.observableArrayList();
    
    private OrdersController ctrlOrders;
    private IdController ctrlId;
    private Product_orderController ctrlProOrder;
    private Batch_addController ctrlBatchAdd;
    private QueryController ctrlQuary;
    private ProductController ctrlProduct;
    private ValidationController ctrlValidation;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setTableProperties();
        setControllers();
        loadPONumbers();
        setToolTips();
        setDate();
        generateRejNo();
        btnUndo.setDisable(true);
    }    

    private void setTableProperties() {

        colProName.setCellValueFactory(new PropertyValueFactory<RejectOrderTableModel,String>("ProName"));
        colBatch.setCellValueFactory(new PropertyValueFactory<RejectOrderTableModel,String>("Batch"));
        colMfd.setCellValueFactory(new PropertyValueFactory<RejectOrderTableModel,String>("Mfd"));
        colExp.setCellValueFactory(new PropertyValueFactory<RejectOrderTableModel,String>("Exp"));
        colQty.setCellValueFactory(new PropertyValueFactory<RejectOrderTableModel,Integer>("Qty"));
        
        tblRejectOrder.getItems().clear();
        tblRejectOrder.setItems(list);
        tblRejectOrder.refresh();
    }

    private void setControllers() {
        
        ctrlValidation=(ValidationController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.VALIDATION);
        ctrlProduct=(ProductController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT);
        ctrlQuary=(QueryController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.QUARY);
        ctrlProOrder=(Product_orderController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT_ORDER);
        ctrlId=(IdController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.IDGEN);
        ctrlOrders=(OrdersController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.ORDERS);
    }

    private void loadPONumbers() {
        
        try {
            ArrayList<OrdersDTO> olist=ctrlOrders.getAll();
            for (OrdersDTO ordersDTO : olist) {
                cmbPo.getItems().add(ordersDTO.getPo());
            }
        } catch (Exception ex) {
            Logger.getLogger(RejectOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setDate() {

        Date d=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String date=df.format(d);
        dtReject.setValue(LocalDate.parse(date));
    }

    private void generateRejNo() {

        try {
            String id=ctrlId.getNewId("reject_order","rjid","RJ", 3);
            txtRejNo.setText(id);
        } catch (Exception ex) {
            Logger.getLogger(RejectOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void cmbPoOnAction(ActionEvent evt){
        
        tblRejectOrder.getItems().clear();
        
        String poder=cmbPo.getSelectionModel().getSelectedItem().toString();
        String oid=null;
        
        try {
            ArrayList<OrdersDTO> olist=ctrlOrders.getAll();
            for (OrdersDTO ordersDTO : olist) {
                if(ordersDTO.getPo().equals(poder)){
                    oid=ordersDTO.getOid();
                }
            }
            
            txtOrder.setText(oid);
        
            ArrayList<Product_orderDTO> plist=ctrlProOrder.getAll();
            for (Product_orderDTO product_orderDTO : plist) {
                RejectOrderTableModel tb=new RejectOrderTableModel();
                if(product_orderDTO.getOid().equals(oid)){
                    
                    tb.setBatch(product_orderDTO.getBaid());
                    BatchOrderDTO b=ctrlQuary.getBatchAddDetail(product_orderDTO.getBaid());
                    tb.setExp(b.getExp());
                    tb.setMfd(b.getMfd());
                    tb.setProName(b.getProName());
                    tb.setQty(product_orderDTO.getPack());
                    
                    list.add(tb);
                }
            }
            txtAmount.setText(Integer.toString(list.size()));
            
        } catch (Exception ex) {
            Logger.getLogger(RejectOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void cacelBtnOnAction(ActionEvent evt){
        
        RejectOrderTableModel tb=(RejectOrderTableModel) tblRejectOrder.getSelectionModel().getSelectedItem();
        
        if(tb==null){
            Alert alert =new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please select a row");
            alert.setContentText("You must select a row before cancel");
            alert.showAndWait();
        }else{
            
            tblRejectOrder.getSelectionModel().clearSelection();
            clearAction();
            
        }
    }
    @FXML
    private void RemoveBtnOnAction(ActionEvent evt){
        
        RejectOrderTableModel tb=(RejectOrderTableModel) tblRejectOrder.getSelectionModel().getSelectedItem();
        try{ 
            if(tb==null){
                Alert alert =new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Please select a row");
                alert.setContentText("You must select a row before Remove");
                alert.showAndWait();
            }else{
                list.remove(tb);

                undoList.add(tb);
                if(undoList.size()==0){
                    btnUndo.setDisable(true);
                }else{
                    btnUndo.setDisable(false);
                }
                list.remove(tb);
                clearAction();
                tblRejectOrder.refresh();
                clearAction();
                tblRejectOrder.getSelectionModel().clearSelection();
                txtAmount.setText(Integer.toString(list.size()));

            }
        }catch(Exception ex){
            
        }
    }
    @FXML
    private void updatebtBtnOnAction(ActionEvent evt){
        try{
            RejectOrderTableModel tb=(RejectOrderTableModel) tblRejectOrder.getSelectionModel().getSelectedItem();

            if(tb==null){
                Alert alert =new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Please select a row");
                alert.setContentText("You must select a row before update");
                alert.showAndWait();
            }else{
                RejectOrderTableModel tbl=new RejectOrderTableModel();

                tbl.setProName(txtProName.getText());
                tbl.setQty(Integer.parseInt(txtQuantity.getText()));
                tbl.setBatch(tb.getBatch());
                tbl.setMfd(tb.getMfd());
                tbl.setExp(tb.getExp());

                list.remove(tb);
                list.add(tbl);
                tblRejectOrder.refresh();
                tblRejectOrder.getSelectionModel().clearSelection();
                clearAction();
            }
        }catch(Exception ex){
            
        }
    }
    @FXML
    private void updateBtnOnAction(ActionEvent evt){
        
        ArrayList<ProductDTO> prolist=new ArrayList<>();
        ArrayList<Batch_addDTO> batchlist=new ArrayList<>();
        Reject_orderDTO rDto=null;
        ArrayList<Reject_order_detailDTO> rejOrderlist=new ArrayList<>();
        
        try {
            if(list.isEmpty()){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Reject table has not any items!");
                alert.showAndWait();
            }else{
                for (RejectOrderTableModel tbl : list) {

                    String proName=ctrlQuary.getProName(tbl.getBatch());
                    String proid=ctrlProduct.getProid(proName);

                    ProductDTO p=new ProductDTO(proid,proName,new BigDecimal(0),tbl.getQty());
                    Batch_addDTO b=new Batch_addDTO(tbl.getBatch(),"d","d","d",0,tbl.getQty(),new BigDecimal("3"),"d","d");
                    Reject_order_detailDTO rejDto=new Reject_order_detailDTO(txtRejNo.getText(),tbl.getBatch(),txtOrder.getText(),tbl.getQty());

                    prolist.add(p);
                    batchlist.add(b);
                    rejOrderlist.add(rejDto);
                }
                rDto=new Reject_orderDTO(txtRejNo.getText(),Integer.parseInt(txtAmount.getText()),dtReject.getValue().toString());

                boolean isUpdate=ctrlProduct.updateAsIncreased(prolist, batchlist, rejOrderlist, rDto);
                if(isUpdate){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Update Success!");
                    alert.setContentText("Reject stock added again to your Stock");
                    alert.setTitle("Update");
                    alert.showAndWait();
                }else{
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Update Failed!");
                    alert.setContentText("You have an error in Rejecting");
                    alert.setTitle("Update");
                    alert.showAndWait();
                }
                if(list.isEmpty()){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("You have not any item to Update your stock!");
                    alert.showAndWait();
                }else{

                    clearAction();
                    cmbPo.setValue("");
                    for (RejectOrderTableModel rejectOrderTableModel : list) {
                        list.remove(rejectOrderTableModel);
                    }
                    tblRejectOrder.getItems().clear();
                    txtAmount.setText("");
                }
                generateRejNo();
            }
            
        } catch (Exception ex) {

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed the reject date field.check again!");
            alert.showAndWait();
        }
        
    }
    @FXML
    private void clearBtnOnAction(ActionEvent evt){
        if(list.size()==0){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("You have not any item to clear!");
            alert.showAndWait();
        }else{
         
            clearAction();
            cmbPo.setValue("");
            for (RejectOrderTableModel rejectOrderTableModel : list) {
                list.remove(rejectOrderTableModel);
            }
            tblRejectOrder.getItems().clear();
            txtAmount.setText("");
        }
        
        
    }
    @FXML
    private void tblRowOnAction(MouseEvent evt){
        
        RejectOrderTableModel tb=(RejectOrderTableModel) tblRejectOrder.getSelectionModel().getSelectedItem();
        
        txtProName.setText(tb.getProName());
        txtQuantity.setText(Integer.toString(tb.getQty()));
        txtProName.setDisable(false);
        txtQuantity.setDisable(false);
        btnRenameProduction.setDisable(false);
    }
    private void clearAction(){
        
        txtProName.setText("");
        txtQuantity.setText("");
        btnRenameProduction.setDisable(true);
        txtProName.setDisable(true);
        txtQuantity.setDisable(true);
        
    }
    
    @FXML
    private void btnUndoOnAction(ActionEvent evt){
        
        int count=0;
        RejectOrderTableModel tb=new RejectOrderTableModel();
        for (RejectOrderTableModel rejectOrderTableModel : undoList) {
            tb.setProName(rejectOrderTableModel.getProName());
            tb.setBatch(rejectOrderTableModel.getBatch());
            tb.setMfd(rejectOrderTableModel.getMfd());
            tb.setExp(rejectOrderTableModel.getExp());
            tb.setQty(rejectOrderTableModel.getQty());
            count++;
        }
        list.add(tb);
        tblRejectOrder.refresh();
        undoList.remove(count-1);
        if(undoList.size()==0){
            btnUndo.setDisable(true);
        }
        txtAmount.setText(Integer.toString(list.size()));
        
    }
    @FXML
    private void renameProductionOnAction(ActionEvent evt){
        
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/sas/kem/edu/ijse/view/RenameProduction.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(BuyMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setToolTips() {

        btnCancel.setTooltip(new Tooltip("You can diselect a selected row in the table!"));
        btnRemove.setTooltip(new Tooltip("You can remove a row from table!"));
        btntbUpdate.setTooltip(new Tooltip("You can update a row in the table!"));
        btnUndo.setTooltip(new Tooltip("You can get a removed row again into the table!"));
        btnClear.setTooltip(new Tooltip("You can clear the whole Interface!"));
        btnUpdate.setTooltip(new Tooltip("You can get Rejected Stocks to your stock!"));
    }
    
    @FXML
    private void txtQtyOnKeyReleased(KeyEvent evt){
        try {
            
            RejectOrderTableModel tb=(RejectOrderTableModel) tblRejectOrder.getSelectionModel().getSelectedItem();
            
            String text=txtQuantity.getText();
            
            if(!ctrlValidation.setNumberFormat(text)){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You can use only numbers!");
                alert.setContentText("EX:232.22,2344");
                alert.showAndWait();
                txtQuantity.setText("");
            }
            
            
            BigDecimal val=new BigDecimal(text);
            
            if(txtQuantity.getText().equals("0")){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Please insert a real value!");
                alert.setContentText("EX: 1000,2333");
                alert.showAndWait();
                txtQuantity.setText("");
            }else if(val.compareTo(new BigDecimal(tb.getQty()))>0){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You can use value less than "+tb.getQty());
                alert.showAndWait();
                txtQuantity.setText("");
            }
        } catch (Exception ex) {
           // Logger.getLogger(RejectOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
