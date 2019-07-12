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
import lk.edu.ijse.sas.controller.custom.CompanyController;
import lk.edu.ijse.sas.controller.custom.IdController;
import lk.edu.ijse.sas.controller.custom.OrdersController;
import lk.edu.ijse.sas.controller.custom.ProductController;
import lk.edu.ijse.sas.controller.custom.Product_orderController;
import lk.edu.ijse.sas.controller.custom.Return_orderController;
import lk.edu.ijse.sas.controller.custom.ValidationController;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import com.sas.kem.edu.ijse.dto.OrdersDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import com.sas.kem.edu.ijse.dto.Product_orderDTO;
import com.sas.kem.edu.ijse.dto.Return_orderDTO;
import com.sas.kem.edu.ijse.dto.Return_order_detailDTO;
import lk.edu.ijse.sas.other.FastReducing;
import lk.edu.ijse.sas.tableModel.OrderTableModel;
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
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class ReversingProductionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private TextField txtOrder;
    
    @FXML
    private TextField txtReturnOrderNo;
    
    @FXML
    private TextField txtProduct;
    
    @FXML
    private TextField txtTotalQty;
    
    @FXML
    private TextField txtBatchQty;
    
    @FXML
    private TextField txtTotalPrice;
    
    @FXML
    private TextField txtGoodsAmount;
    
    @FXML
    private TextField txtCompany;
    
    @FXML
    private JFXTextField txtUnitPrice;
    
    @FXML
    private JFXTextField txtQuantity;
    
    @FXML
    private JFXComboBox cmbBatch;
    
    @FXML
    private JFXComboBox cmbPO;
    
    @FXML
    private TextField txtMfd;
    
    @FXML
    private TextField txtExp;
    
    @FXML
    private JFXDatePicker dtReverse;
    
    @FXML
    private JFXButton btnUpdate;
    
    @FXML
    private JFXButton btnCancel;
    
    @FXML
    private JFXButton btnRemove;
    
    @FXML
    private JFXButton btnUndo;
    
    @FXML
    private JFXButton btnCal;
    
    @FXML
    private JFXButton btnClear;
    
    @FXML
    private JFXButton btnReverse;
    
    @FXML
    private Label lblProName;
    
    @FXML
    private Label lblTotalBags;
    
    @FXML
    private Label lblBatchBags;
    
    @FXML
    private Label lblBatchId;
    
    @FXML
    private TableView tblReverse;
    
    @FXML
    private TableColumn colName;
    
    @FXML
    private TableColumn colBatch;
    
    @FXML
    private TableColumn colQty;
    
    @FXML
    private TableColumn colUnitPrice;
    
    @FXML
    private TableColumn colTotal;
        
    
    private IdController ctrlId;
    private ProductController ctrlProduct;
    private CompanyController ctrlCompany;
    private Batch_addController ctrlBatch_add;
    private ValidationController ctrlValidation;
    private OrdersController ctrlOrders;
    private Return_orderController ctrlRetOrder;
    private Product_orderController ctrlProOrder;

    private ObservableList<OrderTableModel> list=FXCollections.observableArrayList();
    private ObservableList<OrderTableModel> undoList=FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        setTableProperty();
        setToolTips();
        setControllers();
        
        generateReturnOrderId();
        
        setDate();
        
        loadCmbPo();
        
        btnUndo.setDisable(true);
        txtQuantity.setDisable(true);
        txtUnitPrice.setDisable(true);
    }

    private void setTableProperty() {
        
        colBatch.setCellValueFactory(new PropertyValueFactory<OrderTableModel,String>("Batch"));
        colName.setCellValueFactory(new PropertyValueFactory<OrderTableModel,String>("ProName"));
        colQty.setCellValueFactory(new PropertyValueFactory<OrderTableModel,Integer>("Pack"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<OrderTableModel,String>("UnitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<OrderTableModel,String>("Total"));
        
        tblReverse.getItems().clear();
        tblReverse.setItems(list);
        
    }

    private void generateReturnOrderId() {
        
        try {
            txtReturnOrderNo.setText(ctrlId.getNewId("return_order", "rnid","RN",3));
        } catch (Exception ex) {
            Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setControllers() {
        
        ctrlId=(IdController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.IDGEN);
        ctrlProduct=(ProductController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT);
        ctrlCompany=(CompanyController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.COMPANY);
        ctrlBatch_add=(Batch_addController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.BATCH_ADD);
        ctrlValidation=(ValidationController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.VALIDATION);
        ctrlOrders=(OrdersController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.ORDERS);
        ctrlRetOrder=(Return_orderController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.RETURN_ORDER);
        ctrlProOrder=(Product_orderController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT_ORDER);
        
    }

    private void loadCmbPo() {
        
        try {
            for (OrdersDTO ordersDTO : ctrlOrders.getAll()) {
                
                cmbPO.getItems().add(ordersDTO.getPo());
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void cmbPoOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        tblReverse.getItems().clear();
        
        String po=cmbPO.getSelectionModel().getSelectedItem().toString();
        try {
            ArrayList<OrdersDTO> olist=ctrlOrders.getAll();
            for (OrdersDTO ordersDTO : olist) {
                if(ordersDTO.getPo().equals(po)){
                    txtOrder.setText(ordersDTO.getOid());
                    txtCompany.setText(ctrlCompany.getComName(ordersDTO.getCid()));
                    
                }
            }
            ArrayList<Product_orderDTO> plist=ctrlProOrder.getAll();
            for (Product_orderDTO product_orderDTO : plist) {
               OrderTableModel tb=new OrderTableModel();
               if(txtOrder.getText().equals(product_orderDTO.getOid())){
                   tb.setBatch(product_orderDTO.getBaid());
                   tb.setPack(product_orderDTO.getPack());
                   tb.setTotal(df.format(product_orderDTO.getTotal()));
                   tb.setUnitPrice(df.format(product_orderDTO.getUnitPrice_1Bag()));
                   
                   String baid=product_orderDTO.getBaid();
                   String proid=ctrlBatch_add.getProId(baid);
                   
                   String proName=ctrlProduct.getProName(proid);
                   
                   tb.setProName(proName);
                   
                   list.add(tb);
               } 
            }
        } catch (Exception ex) {
            Logger.getLogger(ReversingProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtGoodsAmount.setText(Integer.toString(list.size()));
                
    }
    
    @FXML
    private void cmbProductOnAction(ActionEvent evt){
        
        try {
            
            

        } catch (Exception ex) {
            //Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void cmbBatchOnAction(ActionEvent evt){
        
        try {
            
            String pName=txtProduct.getText();
            String batchId=cmbBatch.getSelectionModel().getSelectedItem().toString();
            
            String batchAmount=getCurrentBatchQty(pName, batchId);
            
            if(batchAmount!=null){
                
                txtBatchQty.setText("");
                txtBatchQty.setText(batchAmount);

                for (Batch_addDTO batch_addDTO : ctrlBatch_add.getAll()) {

                    if(batchId.equals(batch_addDTO.getBaid())){
                        
                        txtExp.setText(batch_addDTO.getExp());
                        txtMfd.setText(batch_addDTO.getMfd());
                        txtUnitPrice.setText(batch_addDTO.getUnitPrice().toString());

                        lblBatchId.setText(batch_addDTO.getBaid());
                        lblBatchId.setVisible(true);
                        lblBatchBags.setVisible(true);
                    }
                    return;
                }        
            
            }
            
            for (Batch_addDTO batch_addDTO : ctrlBatch_add.getAll()) {
                
                if(batchId.equals(batch_addDTO.getBaid())){
                    
                    txtQuantity.setText("");
                    txtExp.setText(batch_addDTO.getExp());
                    txtMfd.setText(batch_addDTO.getMfd());
                    txtUnitPrice.setText(batch_addDTO.getUnitPrice().toString());
                    
                    txtBatchQty.setText(Integer.toString(batch_addDTO.getCurrent_qty()));
                    lblBatchId.setText(batch_addDTO.getBaid());
                    lblBatchId.setVisible(true);
                    lblBatchBags.setVisible(true);
                }
            }
            
        } catch (Exception ex) {
            //Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private double[] getQuantity(String proName,String batch){
        
        double proAmount=0;
        double batchAmount=0;
        
        try {
            for (ProductDTO p : ctrlProduct.getAll()) {
                
                if(proName.equals(p.getProductName())){

                    proAmount=p.getQtyBags();
                }
            }
            for (Batch_addDTO b : ctrlBatch_add.getAll()) {

                if(batch.equals(b.getBaid())){

                    batchAmount=b.getCurrent_qty();

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new double[]{proAmount,batchAmount};
    }
    
    private int[] getCurrentProQty(String proName){
        
        int qty=0;
        int stockPro=0;
        int count=0;
        
        try {
            
            for (OrderTableModel tbl : list) {
                
                if(proName.equals(tbl.getProName())){
                    count++;
                    qty+=tbl.getPack();
                }
            }
            
            for (ProductDTO p : ctrlProduct.getAll()) {
                if(proName.equals(p.getProductName())){
                    stockPro=p.getQtyBags();
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new int[]{qty,stockPro,count};
    }
    
    private String getCurrentBatchQty(String proName,String batch){
        
        DecimalFormat df=new DecimalFormat("#");
        df.setMaximumFractionDigits(0);
        
        String batchAmount=null;
        
        for (OrderTableModel tbl : list) {
                
            if(proName.equals(tbl.getProName()) && batch.equals(tbl.getBatch())){

                int qty=tbl.getPack();

                double[] values=getQuantity(proName, batch);

                batchAmount=df.format(values[1]-qty);
                return batchAmount;
            }
        }
        return null;
    }
    
    @FXML
    private void txtQtyOnKeyReleased(KeyEvent evt){
        
        DecimalFormat df=new DecimalFormat("#");
        df.setMaximumFractionDigits(0);

        DecimalFormat dfd=new DecimalFormat();
        dfd.setMaximumFractionDigits(2);
        
        String name=txtProduct.getText();
        String batch=cmbBatch.getSelectionModel().getSelectedItem().toString();
        String text=txtQuantity.getText();
        
        try {
            if(!ctrlValidation.setNumberFormat(text)){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You can use only numbers!");
                alert.setContentText("EX:123,2322.23");
                alert.showAndWait();
                txtQuantity.setText("");
                
            }else{
                int[] cal=getCurrentProQty(name);
                String batchAmount=getCurrentBatchQty(name, batch);

                int count=cal[2];
                int qty=cal[0];
                int stockPro=cal[1];

                if(batchAmount!=null){

                    if(count>0){

                        double proTotal=stockPro-qty;
                        double batchTotal=Double.parseDouble(batchAmount);

                        String proTxt=txtQuantity.getText();
                        String batchTxt=txtQuantity.getText();

                        FastReducing frPro=new FastReducing(proTxt, proTotal);
                        String[] proValues=frPro.getFinalCalculation();

                        txtTotalQty.setText(proValues[0]);
                        txtTotalQty.setText(df.format(dfd.parse(proValues[1])));

                        FastReducing frBatch=new FastReducing(batchTxt, batchTotal);
                        String[] batchValues=frBatch.getFinalCalculation();

                        txtBatchQty.setText(batchValues[0]);
                        txtBatchQty.setText(df.format(dfd.parse(batchValues[1])));
                    }

                }else{

                    double[] value=getQuantity(name, batch);

                    double proTotal=value[0];
                    double batchTotal=value[1];

                    String proTxt=txtQuantity.getText();
                    String batchTxt=txtQuantity.getText();

                    FastReducing frPro=new FastReducing(proTxt, proTotal);
                    String[] proValues=frPro.getFinalCalculation();

                    txtTotalQty.setText(proValues[0]);
                    txtTotalQty.setText(df.format(dfd.parse(proValues[1])));

                    FastReducing frBatch=new FastReducing(batchTxt, batchTotal);
                    String[] batchValues=frBatch.getFinalCalculation();

                    txtBatchQty.setText(batchValues[0]);
                    txtBatchQty.setText(df.format(dfd.parse(batchValues[1])));
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
   
    
    @FXML
    private void txtQuantityOnAction(ActionEvent evt){
        try{
            String proName=txtProduct.getText();
            String batch=cmbBatch.getSelectionModel().getSelectedItem().toString();
            int txtQty=Integer.parseInt(txtQuantity.getText());

            String batchAmount=getCurrentBatchQty(proName, batch);
            double[] value=getQuantity(proName, batch);


            if(batchAmount!=null){

                int batchTotal=Integer.parseInt(batchAmount);

                if(txtQty>batchTotal){

                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("You have only "+txtBatchQty.getText()+" bags in the "+lblBatchId.getText());
                    alert.setContentText("Suggestion:Select another batch or reduce the ordered Quantity");
                    alert.setTitle("Quantity");
                    alert.showAndWait();

                    txtQuantity.setText("");
                }else{
                    txtUnitPrice.requestFocus();
                }
            }else{

                if(txtQty>(int)value[1]){

                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("You have only "+txtBatchQty.getText()+" bags in the "+lblBatchId.getText());
                    alert.setContentText("Suggestion:Select another batch or reduce the ordered Quantity");
                    alert.setTitle("Quantity");
                    alert.showAndWait();

                    txtQuantity.setText("");
                }else{
                    txtUnitPrice.requestFocus();
                }
            }
        }catch(Exception ex){
            
            OrderTableModel tb=(OrderTableModel) tblReverse.getSelectionModel().getSelectedItem();
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("You must insert a quantity!");
            alert.showAndWait();
            txtQuantity.setText(Integer.toString(tb.getPack()));
        }
        
    }
    
    @FXML
    private void txtUnitPriceOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
       try{ 
           if(new BigDecimal(dfd.format(df.parse(txtUnitPrice.getText()))).equals(new BigDecimal(0))){
               Alert alert=new Alert(Alert.AlertType.WARNING);
               alert.setHeaderText("You cannot insert 0 as unitPrice!");
               alert.showAndWait();
               txtUnitPrice.setText("");
           }else{
                BigDecimal qty=new BigDecimal(txtQuantity.getText());
                BigDecimal unitprice=new BigDecimal(dfd.format(df.parse(txtUnitPrice.getText())));

                BigDecimal total1=qty.multiply(unitprice);

                String total=df.format(total1);

                txtTotalPrice.setText(total);
                txtTotalPrice.requestFocus();
           }
            
       }catch(Exception ex){
           Alert alert=new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText("You must insert a unitPrice!");
           alert.showAndWait();
           
       }
    }
    
    @FXML
    private void txtUnitPriceOnKeyReleased(KeyEvent evt){
        
        try {
            String text=txtUnitPrice.getText();
            if(!ctrlValidation.setNumberFormat(text)){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You can use only numbers!");
                alert.setContentText("EX: 123,343.23");
                alert.showAndWait();
                txtUnitPrice.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(ReversingProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void clearAction(){
        
        cmbBatch.setValue("");
        txtProduct.setText("");
        
        txtMfd.setText("");
        txtExp.setText("");
        
        txtUnitPrice.setText("");
        txtQuantity.setText("");
        txtTotalPrice.setText("");
        txtTotalQty.setText("");
        txtBatchQty.setText("");
        
        lblBatchBags.setVisible(false);
        lblTotalBags.setVisible(false);
        lblBatchId.setVisible(false);
        lblProName.setVisible(false);
        
    }
    
    @FXML
    private void cancelBtnOnAction(ActionEvent evt){
        
        OrderTableModel tb=(OrderTableModel)tblReverse.getSelectionModel().getSelectedItem();
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Please select a row!");
            alert.setContentText("Any row is not selected");
            alert.setTitle("Cancel");
            alert.showAndWait();
        }else{
            
            tblReverse.getSelectionModel().clearSelection();
            clearAction();
            txtQuantity.setDisable(true);
            txtUnitPrice.setDisable(true);
        }
    }
    
    @FXML
    private void removeBtnOnAction(ActionEvent evt){
        
        OrderTableModel tb=(OrderTableModel)tblReverse.getSelectionModel().getSelectedItem();
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Please select a row!");
            alert.setContentText("Any row is not selected");
            alert.setTitle("Remove");
            alert.showAndWait();
        }else{
            list.remove(tb);
            tblReverse.refresh();
            undoList.add(tb);
            if(undoList.size()==0){
                btnUndo.setDisable(true);
            }else{
                btnUndo.setDisable(false);
            }
            list.remove(tb);
            tblReverse.refresh();
            clearAction();
            txtGoodsAmount.setText(Integer.toString(list.size()));
            txtQuantity.setDisable(true);
            txtUnitPrice.setDisable(true);
        }
    }
    
    @FXML
    private void updateBtnOnAction(ActionEvent evt){
        
        OrderTableModel tb=(OrderTableModel)tblReverse.getSelectionModel().getSelectedItem();
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Please select a row!");
            alert.setContentText("Any row is not selected");
            alert.setTitle("Update");
            alert.showAndWait();
        }else{
            OrderTableModel tbl=new OrderTableModel();
            
            tbl.setBatch(cmbBatch.getSelectionModel().getSelectedItem().toString());
            tbl.setProName(txtProduct.getText());
            tbl.setPack(Integer.parseInt(txtQuantity.getText()));
            tbl.setUnitPrice(txtUnitPrice.getText());
            tbl.setTotal(txtTotalPrice.getText());
            
            list.add(tbl);
            list.remove(tb);
            tblReverse.refresh();
            tblReverse.getSelectionModel().clearSelection();
            clearAction();
            txtQuantity.setDisable(true);
            txtUnitPrice.setDisable(true);
        }
        
    }
    
    @FXML
    private void rowOnClicked(MouseEvent evt){
        
        cmbBatch.getItems().clear();
        cmbBatch.setValue("");
        try {
            OrderTableModel tb=(OrderTableModel)tblReverse.getSelectionModel().getSelectedItem();
            
            txtQuantity.setText(Integer.toString(tb.getPack()));
            txtTotalPrice.setText(tb.getTotal());
            txtUnitPrice.setText(tb.getUnitPrice());
            txtProduct.setText(tb.getProName());
            
            ArrayList<Batch_addDTO> blist=ctrlBatch_add.getAll();
            for (Batch_addDTO batch_addDTO : blist) {
                if(ctrlProduct.getProid(tb.getProName()).equals(batch_addDTO.getProid())){
                    cmbBatch.getItems().add(batch_addDTO.getBaid());
                }
                
            }
            int[] cal=getCurrentProQty(tb.getProName());
            if(cal[2]>0){
                
                txtTotalQty.setText(Integer.toString(cal[1]-cal[0]));
                lblTotalBags.setVisible(true);
                lblProName.setVisible(true);
                lblProName.setText(tb.getProName());
                lblBatchId.setText(tb.getBatch());
                lblBatchId.setVisible(true);
                
            }else{
                txtTotalQty.setText(Integer.toString(cal[1]));
                lblTotalBags.setVisible(true);
                lblProName.setVisible(true);
                lblProName.setText(tb.getProName());
                lblBatchId.setText(tb.getBatch());
                lblBatchId.setVisible(true);
            }
            cmbBatch.setValue(tb.getBatch());
            txtQuantity.setDisable(false);
            txtUnitPrice.setDisable(false);
            
        } catch (Exception ex) {
            Logger.getLogger(ReversingProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void btnClearOnAction(ActionEvent evt){
        
        clearAction();
        txtOrder.setText("");
        generateReturnOrderId();
        tblReverse.getItems().clear();
        txtCompany.setText("");
        cmbPO.setValue("");
        txtGoodsAmount.setText("");
    }
    
    @FXML
    private void ReverseBtnOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#,###.00");
        dfd.setMaximumFractionDigits(2);
        
        try {
            if(list.isEmpty()){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Material Reverse table has not Any item!");
                alert.showAndWait();
            }else{
                String orderNo=txtOrder.getText();
                String returnId=txtReturnOrderNo.getText();
                String po=cmbPO.getSelectionModel().getSelectedItem().toString();
                int proAmount=Integer.parseInt(txtGoodsAmount.getText());
                String reverseDt=dtReverse.getValue().toString();
                String cName=txtCompany.getText();


                String cid=ctrlCompany.getCompanyId(cName);

                Return_orderDTO ret=new Return_orderDTO(returnId,proAmount,reverseDt);

                ArrayList<Return_order_detailDTO> rlist=new ArrayList<>();
                ArrayList<Batch_addDTO> blist=new ArrayList<>();
                ArrayList<ProductDTO> prolist=new ArrayList<>();

                for (OrderTableModel tbl : list) {

                    String baid=tbl.getBatch();

                    String proid=ctrlProduct.getProid(tbl.getProName());
                    String unitprice=df.format(dfd.parse(tbl.getUnitPrice()));
                    String total=df.format(dfd.parse(tbl.getTotal()));
                    int qty=tbl.getPack();

                    BigDecimal unitPrice=new BigDecimal(unitprice);
                    BigDecimal totalPrice=new BigDecimal(total);

                    Return_order_detailDTO retDTO=new Return_order_detailDTO(returnId,baid,orderNo,qty);

                    rlist.add(retDTO);


                    String mfd=null;
                    String exp=null;
                    String addDt=null;
                    String time=null;
                    int proQty=0;
                    BigDecimal UnitPrice=null;
                    int curqty=tbl.getPack();

                    for (Batch_addDTO batch_addDTO : ctrlBatch_add.getAll()) {

                        if(baid.equals(batch_addDTO.getBaid())){

                            mfd=batch_addDTO.getMfd();
                            exp=batch_addDTO.getExp();
                            addDt=batch_addDTO.getAddDate();
                            time=batch_addDTO.getAddTime();
                            UnitPrice=batch_addDTO.getUnitPrice();
                            proQty=batch_addDTO.getProduct_qty();
                        }

                    }
                    Batch_addDTO b=new Batch_addDTO(baid,proid,mfd,exp,proQty,curqty,UnitPrice,time,addDt);
                    blist.add(b);

                    ProductDTO pro=new ProductDTO(proid,tbl.getProName(),new BigDecimal(0),tbl.getPack());
                    prolist.add(pro);
                }

                boolean b=ctrlRetOrder.add(ret, rlist, blist, prolist);

                if(b){

                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Product Reversing Success!");
                    alert.setContentText("Your Report Will be Prepared");
                    alert.setTitle("Reversing");
                    alert.showAndWait();
                    tblReverse.getItems().clear();
                    tblReverse.refresh();
                }else{
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Product Reversing Failed!");
                    alert.setContentText("You have an Error in Reversing");
                    alert.setTitle("Reversing");
                    alert.showAndWait();
                }
            }
            
            
        } catch (Exception ex) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("you missed some fields!");
            alert.showAndWait();
            
        }
        tblReverse.getItems().clear();
        tblReverse.refresh();
        clearAction();
        txtGoodsAmount.setText("");
        txtCompany.setText("");
        cmbPO.setValue("");
        txtOrder.setText("");
        generateReturnOrderId();
    }

    private void setDate() {

        Date d=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String date=df.format(d);
        dtReverse.setValue(LocalDate.parse(date));
    }
   
    
    @FXML
    private void btnUndoOnAction(ActionEvent evt){
        
        int count=0;
        OrderTableModel tb=new OrderTableModel();
        for (OrderTableModel orderTableModel : undoList) {
            tb.setProName(orderTableModel.getProName());
            tb.setBatch(orderTableModel.getBatch());
            tb.setPack(orderTableModel.getPack());
            tb.setTotal(orderTableModel.getTotal());
            tb.setUnitPrice(orderTableModel.getUnitPrice());
            
            count++;
        }
        list.add(tb);
        tblReverse.refresh();
        undoList.remove(count-1);
        if(undoList.isEmpty()){
            btnUndo.setDisable(true);
        }
        txtGoodsAmount.setText(Integer.toString(list.size()));
        
    }
    @FXML
    private void btnCalOnAction(ActionEvent evt){
        
        try {
            Runtime.getRuntime().exec("calc.exe");
        } catch (IOException ex) {
            Logger.getLogger(ReversingProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setToolTips() {

        btnCancel.setTooltip(new Tooltip("You can diselect a selected row in the table!"));
        btnRemove.setTooltip(new Tooltip("You can remove a row from table!"));
        btnUpdate.setTooltip(new Tooltip("You can update a row in the table!"));
        btnUndo.setTooltip(new Tooltip("You can get a removed row again into the table!"));
        btnClear.setTooltip(new Tooltip("You can clear the whole Interface!"));
        btnReverse.setTooltip(new Tooltip("You can Reverse Reduced Productions to customers!"));
        btnCal.setTooltip(new Tooltip("You can make some sums using this calculator!"));
    }
    
}
