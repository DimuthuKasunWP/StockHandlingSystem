/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.Batch_addController;
import lk.edu.ijse.sas.controller.custom.CompanyController;
import lk.edu.ijse.sas.controller.custom.IdController;
import lk.edu.ijse.sas.controller.custom.OrdersController;
import lk.edu.ijse.sas.controller.custom.ProductController;
import lk.edu.ijse.sas.controller.custom.Product_orderController;
import lk.edu.ijse.sas.controller.custom.ValidationController;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import com.sas.kem.edu.ijse.dto.OrdersDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import com.sas.kem.edu.ijse.dto.Product_orderDTO;
import lk.edu.ijse.sas.other.FastReducing;
import lk.edu.ijse.sas.tableModel.OrderTableModel;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
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
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class UpdateOrderController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField txtOrder;
    
    @FXML
    private TextField txtTotalQty;
    
    @FXML
    private TextField txtBatchQty;
    
    @FXML
    private TextField txtTotalPrice;
    
    @FXML
    private TextField txtGrandTotal;
    
    @FXML
    private TextField txtDate;
    
    @FXML
    private TextField txtCompany;
    
    @FXML
    private JFXTextField txtUnitPrice;
    
    @FXML
    private JFXTextField txtPack;
    
    @FXML
    private JFXTextField txtQty;
    
    @FXML
    private JFXComboBox cmbProduction;
    
    @FXML
    private JFXComboBox cmbPo;
    
    @FXML
    private JFXComboBox cmbBatch;
    
    @FXML
    private TextField txtMfd;
    
    @FXML
    private TextField txtExp;
    
    @FXML
    private JFXButton btntbUpdate;
    
    @FXML
    private JFXButton btnCal;
    
    @FXML
    private JFXButton btnCancel;
    
    @FXML
    private JFXButton btnRemove;
    
    @FXML
    private JFXButton btnUndo;
    
    @FXML
    private JFXButton btnClear;
    
    @FXML
    private JFXButton btnUpdate;
    
    @FXML
    private Label lblProName;
    
    @FXML
    private Label lblTotalBags;
    
    @FXML
    private Label lblBatchBags;
   
    @FXML
    private Label lblBatchId;
    
    @FXML
    private TableView tblOrder;
    
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
    
    @FXML
    private AnchorPane thisPane;
        
    
    private IdController ctrlId;
    private ProductController ctrlProduct;
    private CompanyController ctrlCompany;
    private Batch_addController ctrlBatch_add;
    private ValidationController ctrlValidation;
    private OrdersController ctrlOrders;
    private Product_orderController ctrlProduct_order;
   
    private ObservableList<OrderTableModel> list=FXCollections.observableArrayList();
    private ObservableList<OrderTableModel> undoList=FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setTableProperty();
        
        setControllers();
        
        loadCmbProduction();
        loadCmbPo();
        
        setToolTips();
        
        cmbProduction.setDisable(true);
        btnUndo.setDisable(true);
        cmbBatch.setDisable(true);
        Platform.runLater(cmbPo::requestFocus);
    }

    private void setTableProperty() {
        
        colBatch.setCellValueFactory(new PropertyValueFactory<OrderTableModel,String>("Batch"));
        colName.setCellValueFactory(new PropertyValueFactory<OrderTableModel,String>("ProName"));
        colQty.setCellValueFactory(new PropertyValueFactory<OrderTableModel,Integer>("Pack"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<OrderTableModel,String>("UnitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<OrderTableModel,String>("Total"));
        
        tblOrder.getItems().clear();
        tblOrder.setItems(list);
        
    }

    private void setControllers() {
        
        ctrlId=(IdController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.IDGEN);
        ctrlProduct=(ProductController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT);
        ctrlCompany=(CompanyController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.COMPANY);
        ctrlBatch_add=(Batch_addController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.BATCH_ADD);
        ctrlValidation=(ValidationController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.VALIDATION);
        ctrlOrders=(OrdersController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.ORDERS);
        ctrlProduct_order=(Product_orderController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT_ORDER);
        
    }

    private void loadCmbProduction() {
        
        try {
            for (ProductDTO productDTO : ctrlProduct.getAll()) {
                
                cmbProduction.getItems().add(productDTO.getProductName());
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadCmbPo(){
        
        try {
            ArrayList<OrdersDTO> olist=ctrlOrders.getAll();
            for (OrdersDTO ordersDTO : olist) {
                String po=ordersDTO.getPo();
                char[] ch=po.toCharArray();
                if(!(ch[0]=='B')){
                    cmbPo.getItems().add(ordersDTO.getPo());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UpdateOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void cmbPoOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        try {
            String po=cmbPo.getSelectionModel().getSelectedItem().toString();
            ArrayList<OrdersDTO> olist=ctrlOrders.getAll();
            for (OrdersDTO ordersDTO : olist) {
                if(po.equals(ordersDTO.getPo())){
                    txtOrder.setText(ordersDTO.getOid());
                    txtDate.setText(ordersDTO.getOrderDate());
                    txtGrandTotal.setText(df.format(ordersDTO.getTotal()));
                    txtCompany.setText(ctrlCompany.getComName(ordersDTO.getCid()));
                    
                }
            }
            
            ArrayList<Product_orderDTO> plist=ctrlProduct_order.getAll();
            tblOrder.getItems().clear();
            for (Product_orderDTO product_orderDTO : plist) {
                if(product_orderDTO.getOid().equals(txtOrder.getText())){
                   
                    OrderTableModel tb=new OrderTableModel();
  
                    tb.setBatch(product_orderDTO.getBaid());
                    tb.setPack(product_orderDTO.getPack());
                    tb.setProName(ctrlProduct.getProName(ctrlBatch_add.getProId(product_orderDTO.getBaid())));
                    tb.setTotal(df.format(product_orderDTO.getTotal()));
                    tb.setUnitPrice(df.format(product_orderDTO.getTotal()));

                    list.add(tb);
                    
                }
                
            }
            cmbProduction.setDisable(false);
        } catch (Exception ex) {
            Logger.getLogger(UpdateOrderController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
    @FXML
    private void cmbProductOnAction(ActionEvent evt){
        
        try {
            
            String name=cmbProduction.getSelectionModel().getSelectedItem().toString();
        
            cmbBatch.getItems().clear();
            cmbBatch.setValue("");

            String proid=ctrlProduct.getProid(name);

            for (Batch_addDTO batch_addDTO : ctrlBatch_add.getAll()) {

                if(proid.equals(batch_addDTO.getProid()) && batch_addDTO.getCurrent_qty()>0){

                    cmbBatch.getItems().add(batch_addDTO.getBaid());

                }
            }
            int[] cal=getCurrentProQty(name);
            
            int count=cal[2];
            int stockPro=cal[1];
            int qty=cal[0];
            
            if(count>0){
                int totalPro=stockPro-qty;
                txtTotalQty.setText(Integer.toString(totalPro));
                lblProName.setVisible(true);
                lblProName.setText(name);
                lblTotalBags.setVisible(true);
                
                txtQty.requestFocus();
                txtPack.setDisable(true);
                return;
            }

            for (ProductDTO productDTO : ctrlProduct.getAll()) {

                if(name.equals(productDTO.getProductName())){

                    txtTotalQty.setText(Integer.toString(productDTO.getQtyBags()));
                    lblProName.setVisible(true);
                    lblProName.setText(name);
                    lblTotalBags.setVisible(true);
                }
            }
            
        } catch (Exception ex) {
            //Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtPack.setDisable(true);
        txtQty.requestFocus();
        
    }
    
    @FXML
    private void txtQtyOnKeyReleased(KeyEvent evt){
        try {
            String product=cmbProduction.getSelectionModel().getSelectedItem().toString();
            if(product.equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You must select a production!");
                alert.showAndWait();
                txtQty.setText("");
                clearAction();
                Platform.runLater(cmbProduction::requestFocus);
            }
            String text=txtQty.getText();
            cmbBatch.setValue("");
            txtPack.setText("");
            if(ctrlValidation.setNumberFormat(text)){
                
                cmbBatch.setDisable(false);
            }else{
                ButtonType ok=new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You can use only numbers!");
                alert.setContentText("EX: 234,22.34");
                alert.showAndWait();
                txtQty.setText("");
            }
            if(txtQty.getText().equals("")){
                cmbBatch.setDisable(true);
            }
        } catch (Exception ex) {

           Alert alert=new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText("You must select a production!");
           alert.showAndWait();
           txtQty.setText("");
           clearAction();
           Platform.runLater(cmbProduction::requestFocus);
        }
        
    }
    @FXML
    private void txtQtyOnAction(ActionEvent evt){
        
        Platform.runLater(cmbBatch::requestFocus);
        
    }
    @FXML
    private void cmbBatchOnAction(ActionEvent evt){
        
        try{
            String pName=cmbProduction.getSelectionModel().getSelectedItem().toString();
            String batchId=cmbBatch.getSelectionModel().getSelectedItem().toString();

            String batchAmount=getCurrentBatchQty(pName, batchId);

            if(batchAmount!=null){

                for (Batch_addDTO batch_addDTO : ctrlBatch_add.getAll()) {

                    if(batchId.equals(batch_addDTO.getBaid())){

                        txtExp.setText(batch_addDTO.getExp());
                        txtMfd.setText(batch_addDTO.getMfd());
                        txtUnitPrice.setText(batch_addDTO.getUnitPrice().toString());

                        lblBatchId.setText(batch_addDTO.getBaid());
                        lblBatchId.setVisible(true);
                        lblBatchBags.setVisible(true);
                        
                        double pack=0;
                        ArrayList<ProductDTO> pro=ctrlProduct.getAll();
                        for (ProductDTO productDTO : pro) {
                            if(batch_addDTO.getProid().equals(productDTO.getProid())){
                                pack=productDTO.getBagSize_kg().doubleValue();
                            }
                        }
                        
                        double value=Double.parseDouble(txtQty.getText());

                        double packs=value/pack;
                        int packets=(int)packs;
                        txtPack.setText(Integer.toString(packets));
                        txtBatchQty.setText(Double.toString((Double.parseDouble(batchAmount)-packs)));
                        txtTotalQty.setText(Double.toString(Double.parseDouble(txtTotalQty.getText())-packs));
                        
                    }

                    Platform.runLater(txtPack::requestFocus);
                    txtPack.setDisable(false);
                    return;
                }        

            }

            for (Batch_addDTO batch_addDTO : ctrlBatch_add.getAll()) {

                if(batchId.equals(batch_addDTO.getBaid())){

                    txtExp.setText(batch_addDTO.getExp());
                    txtMfd.setText(batch_addDTO.getMfd());
                    txtUnitPrice.setText(batch_addDTO.getUnitPrice().toString());

                    lblBatchId.setText(batch_addDTO.getBaid());
                    lblBatchId.setVisible(true);
                    lblBatchBags.setVisible(true);
                    
                    double pack=0;
                    ArrayList<ProductDTO> pro=ctrlProduct.getAll();
                    for (ProductDTO productDTO : pro) {
                        if(batch_addDTO.getProid().equals(productDTO.getProid())){
                            pack=productDTO.getBagSize_kg().doubleValue();
                        }
                    }

                    double value=Double.parseDouble(txtQty.getText());

                    double packs=value/pack;
                    int packets=(int)packs;
                    txtPack.setText(Integer.toString(packets));
                    txtBatchQty.setText(Double.toString((Double.parseDouble(batchAmount)-packs)));
                    txtTotalQty.setText(Double.toString(Double.parseDouble(txtTotalQty.getText())-packs));
                }
            }

        } catch (Exception ex) {
            //Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Platform.runLater(txtPack::requestFocus);
        txtPack.setDisable(false);
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
    private void txtPackOnKeyReleased(KeyEvent evt){
        
        DecimalFormat df=new DecimalFormat("#");
        df.setMaximumFractionDigits(0);

        DecimalFormat dfd=new DecimalFormat();
        dfd.setMaximumFractionDigits(2);
        
        String name=cmbProduction.getSelectionModel().getSelectedItem().toString();
        String batch=cmbBatch.getSelectionModel().getSelectedItem().toString();
        
        try {
            String text=txtPack.getText();
            if(!ctrlValidation.setIntFormat(text)){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You can use only integer values!");
                alert.setContentText("EX: 32,22,523");
                alert.showAndWait();
                txtPack.setText("");
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

                        String proTxt=txtPack.getText();
                        String batchTxt=txtPack.getText();

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

                    String proTxt=txtPack.getText();
                    String batchTxt=txtPack.getText();

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
           // Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
   
    
    @FXML
    private void txtPackOnAction(ActionEvent evt){
        
        try{
            
            String proName=cmbProduction.getSelectionModel().getSelectedItem().toString();
            String batch=cmbBatch.getSelectionModel().getSelectedItem().toString();
            int txtQty=Integer.parseInt(txtPack.getText());

            String batchAmount=getCurrentBatchQty(proName, batch);
            double[] value=getQuantity(proName, batch);


            if(batchAmount!=null){

                int batchTotal=Integer.parseInt(batchAmount);

                if(txtQty>batchTotal){

                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("You have only "+batchTotal+" bags in the "+lblBatchId.getText());
                    alert.setContentText("Suggestion:Select another batch or reduce the ordered Quantity");
                    alert.setTitle("Quantity");
                    alert.showAndWait();

                    txtPack.setText("");
                }
            }else{

                if(txtQty>(int)value[1]){

                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setHeaderText("You have only "+(int)value[1]+" bags in the "+lblBatchId.getText());
                    alert.setContentText("Suggestion:Select another batch or reduce the ordered Quantity");
                    alert.setTitle("Quantity");
                    alert.showAndWait();

                    txtPack.setText("");
                }else{
                    Platform.runLater(txtUnitPrice::requestFocus);
                }
            }
            
        }catch(Exception ex){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You must insert the package amount!");
            alert.showAndWait();
        }
        
    }
    
    @FXML
    private void txtUnitPriceOnAction(ActionEvent evt){
       try{ 
            DecimalFormat df=new DecimalFormat("#,###.00");
            df.setMaximumFractionDigits(2);
            
            DecimalFormat dfd=new DecimalFormat("#");
            dfd.setMaximumFractionDigits(2);

            BigDecimal pack=new BigDecimal(txtPack.getText());
            BigDecimal unitprice=new BigDecimal(dfd.format(df.parse(txtUnitPrice.getText())));

            BigDecimal total1=pack.multiply(unitprice);

            String total=df.format(total1);

            txtTotalPrice.setText(total);
            txtTotalPrice.requestFocus();
       }catch(Exception ex){
           
           Alert alert=new Alert(Alert.AlertType.ERROR);
           alert.setHeaderText("You missed some fields.check Again!");
           alert.showAndWait();
           txtPack.requestFocus();
       }
    }
    @FXML
    private void txtUnitPriceOnKeyReleased(KeyEvent evt){
        
        try {
            String text=txtUnitPrice.getText();
            if(!ctrlValidation.setNumberFormat(text)){
                Alert alert =new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You can use only numbers!");
                alert.setContentText("EX: 234,223.24");
                alert.showAndWait();
                txtUnitPrice.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void txtTotalPriceOnAction(ActionEvent evt){
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        BigDecimal grandTotal=null;
        try{
            
            ArrayList<Batch_addDTO> blist=ctrlBatch_add.getAll();
            for (Batch_addDTO batch_addDTO : blist) {
                if(cmbBatch.getSelectionModel().getSelectedItem().toString().equals(batch_addDTO.getBaid())){
                    
                    BigDecimal bgSize=null;
                    ArrayList<ProductDTO> plist=ctrlProduct.getAll();
                    for (ProductDTO productDTO : plist) {
                        if(batch_addDTO.getProid().equals(productDTO.getProid())){
                            
                            bgSize=productDTO.getBagSize_kg();
                            
                        }
                    }
                    
                    BigDecimal packs=new BigDecimal(txtPack.getText());
                    
                    BigDecimal quantity=bgSize.multiply(packs);
                    
                    BigDecimal qty=new BigDecimal(txtQty.getText()).subtract(quantity);
                    
                    if(qty.equals(new BigDecimal(".00"))){
                        txtQty.setText("");
                    }else{
                        txtQty.setText(Double.toString(qty.doubleValue()));
                    }
                    
                }
            }
            
            if(txtGrandTotal.getText().equals("")){
                grandTotal=new BigDecimal(0);
            }else{
                grandTotal=new BigDecimal(dfd.format(df.parse(txtGrandTotal.getText())));
            }
            
            for (OrderTableModel tbl : list) {
                
                String proName=cmbProduction.getSelectionModel().getSelectedItem().toString();
                String batch=cmbBatch.getSelectionModel().getSelectedItem().toString();

                if(proName.equals(tbl.getProName()) && batch.equals(tbl.getBatch())){

                    OrderTableModel tb=new OrderTableModel();

                    int qty=tbl.getPack();

                    String total=dfd.format(df.parse(tbl.getTotal()));
                    String totalP=dfd.format(df.parse(txtTotalPrice.getText()));
                    
                    BigDecimal totalprice=new BigDecimal(total);
                    BigDecimal addTotal=new BigDecimal(totalP);
                    
                    BigDecimal total1=totalprice.add(addTotal);

                    String totalPrice=df.format(total1);

                    tb.setBatch(batch);
                    tb.setProName(proName);
                    tb.setPack(qty+Integer.parseInt(txtPack.getText()));
                    tb.setUnitPrice(txtUnitPrice.getText());
                    tb.setTotal(totalPrice);
                    
                    grandTotal=grandTotal.subtract(new BigDecimal(dfd.format(df.parse(tbl.getTotal()))));
                    
                    list.remove(tbl);
                    list.add(tb);
                    
                    tblOrder.refresh();
                    clearAction();
                                       
                    grandTotal=grandTotal.add(new BigDecimal(dfd.format(df.parse(tb.getTotal()))));
                    txtGrandTotal.setText(df.format(grandTotal));
                    Platform.runLater(cmbProduction::requestFocus);
                    return;
                }

            }

            OrderTableModel tb=new OrderTableModel();

            String proName=cmbProduction.getSelectionModel().getSelectedItem().toString();
            String batch=cmbBatch.getSelectionModel().getSelectedItem().toString();
            int qty=Integer.parseInt(txtPack.getText());

            String unitPrice1=txtUnitPrice.getText();

            BigDecimal unitprice=new BigDecimal(unitPrice1);
            String unitPrice=df.format(unitprice);

            String total=txtTotalPrice.getText();

            tb.setProName(proName);
            tb.setBatch(batch);
            tb.setPack(qty);
            tb.setUnitPrice(unitPrice);
            tb.setTotal(total);

            list.add(tb);
            tblOrder.refresh();
            
            grandTotal=grandTotal.add(new BigDecimal(dfd.format(df.parse(tb.getTotal()))));
            txtGrandTotal.setText(df.format(grandTotal));
            clearAction();
            Platform.runLater(cmbProduction::requestFocus);
            
        } catch (Exception ex) {

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed some fields.check Again!");
            alert.showAndWait();
        }
        
    }
    
    private void clearAction(){
        
        cmbBatch.setValue("");
        cmbBatch.setDisable(true);
        cmbProduction.setValue("");
        
        txtMfd.setText("");
        txtExp.setText("");
        txtUnitPrice.setText("");
        txtPack.setText("");
        txtPack.setDisable(true);
        txtTotalPrice.setText("");
        txtBatchQty.setText("");
        txtTotalQty.setText("");
        
        lblBatchBags.setVisible(false);
        lblTotalBags.setVisible(false);
        lblBatchId.setVisible(false);
        lblProName.setVisible(false);
        
    }
    
    @FXML
    private void cancelBtnOnAction(ActionEvent evt){
        
        OrderTableModel tb=(OrderTableModel)tblOrder.getSelectionModel().getSelectedItem();
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Please select a row!");
            alert.setContentText("Any row is not selected");
            alert.setTitle("Cancel");
            alert.showAndWait();
        }else{
            tblOrder.getSelectionModel().clearSelection();
            txtTotalPrice.setDisable(false);
            loadCmbProduction();
            clearAction();
            txtQty.setText("");
        }
    }
    
    @FXML
    private void removeBtnOnAction(ActionEvent evt){
        
        try {
            DecimalFormat df=new DecimalFormat("#,###.00");
            df.setMaximumFractionDigits(2);
            
            DecimalFormat dfd=new DecimalFormat("#");
            dfd.setMaximumFractionDigits(2);
            
            BigDecimal grandTotal=new BigDecimal(dfd.format(df.parse(txtGrandTotal.getText())));
            
            OrderTableModel tb=(OrderTableModel)tblOrder.getSelectionModel().getSelectedItem();
            if(tb==null){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Please select a row!");
                alert.setContentText("Any row is not selected");
                alert.setTitle("Remove");
                alert.showAndWait();
            }else{
                list.remove(tb);
                tblOrder.refresh();
                undoList.add(tb);
                if(undoList.isEmpty()){
                    btnUndo.setDisable(true);
                }else{
                    btnUndo.setDisable(false);
                }
                grandTotal=grandTotal.subtract(new BigDecimal(dfd.format(df.parse(tb.getTotal()))));
                list.remove(tb);
                txtTotalPrice.setDisable(false);
                tblOrder.refresh();
                loadCmbProduction();
                clearAction();
                
                txtQty.setText("");
                txtGrandTotal.setText(df.format(grandTotal));
            }
        } catch (ParseException ex) {
            Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void updatetbBtnOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        OrderTableModel tb=(OrderTableModel)tblOrder.getSelectionModel().getSelectedItem();
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Please select a row!");
            alert.setContentText("Any row is not selected");
            alert.setTitle("Update");
            alert.showAndWait();
        }else{
            try {
                OrderTableModel tbl=new OrderTableModel();
                
                String lastTot=tb.getTotal();
                
                tbl.setBatch(cmbBatch.getSelectionModel().getSelectedItem().toString());
                tbl.setProName(cmbProduction.getSelectionModel().getSelectedItem().toString());
                tbl.setPack(Integer.parseInt(txtPack.getText()));
                tbl.setUnitPrice(txtUnitPrice.getText());
                tbl.setTotal(txtTotalPrice.getText());
                
                list.add(tbl);
                list.remove(tb);
                tblOrder.refresh();
                tblOrder.getSelectionModel().clearSelection();
                txtTotalPrice.setDisable(false);
                loadCmbProduction();
                clearAction();
                txtQty.setText("");
                
                BigDecimal grandTot=(new BigDecimal(dfd.format(df.parse(txtGrandTotal.getText()))).subtract(new BigDecimal(dfd.format(df.parse(lastTot))))).add(new BigDecimal(dfd.format(df.parse(tbl.getTotal()))));
                txtGrandTotal.setText(df.format(grandTot));
            } catch (ParseException ex) {
                Logger.getLogger(UpdateOrderController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    @FXML
    private void rowOnClicked(MouseEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        try {
            OrderTableModel tb=(OrderTableModel)tblOrder.getSelectionModel().getSelectedItem();
            
            txtTotalPrice.setText(tb.getTotal());
            txtUnitPrice.setText(tb.getUnitPrice());
            
            cmbProduction.getItems().clear();
            cmbProduction.setValue("");
            cmbProduction.getItems().add(tb.getProName());
            cmbProduction.getSelectionModel().selectFirst();
            cmbBatch.setValue(tb.getBatch());
            txtPack.setText(Integer.toString(tb.getPack()));
            
            ArrayList<Batch_addDTO> blist=ctrlBatch_add.getAll();
            for (Batch_addDTO batch_addDTO : blist) {
                if(batch_addDTO.getBaid().equals(tb.getBatch())){
                    
                    BigDecimal bgsize=null;
                    ArrayList<ProductDTO> plist=ctrlProduct.getAll();
                    for (ProductDTO productDTO : plist) {
                        if(productDTO.getProid().equals(batch_addDTO.getProid())){
                            bgsize=productDTO.getBagSize_kg();
                        }
                    }
                    
                    
                    BigDecimal packs=new BigDecimal(tb.getPack());
                    
                    BigDecimal qty=bgsize.multiply(packs);
                    txtQty.setText(df.format(qty));
                }
            }
            
            lblProName.setVisible(true);
            lblProName.setText(tb.getProName());
            txtTotalPrice.setDisable(true);
            txtQty.requestFocus();
            txtQty.selectAll();
        } catch (Exception ex) {
           // Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void btnClearOnAction(ActionEvent evt){
        
        clearAction();
        txtOrder.setText("");
        txtQty.setText("");
        tblOrder.getItems().clear();
        txtGrandTotal.setText("");
        txtDate.setText("");
        txtCompany.setText("");
        cmbPo.setValue("");
        Platform.runLater(cmbPo::requestFocus);
        
        
    }
    
    @FXML
    private void btnUpdateOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        try {
            
            if(list.isEmpty()){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Order table has not any items");
                alert.showAndWait();
                return;
            
            }else{
                
                BigDecimal grandTotal=new BigDecimal(dfd.format(df.parse(txtGrandTotal.getText())));
                
                OrdersDTO o=new OrdersDTO(txtOrder.getText(),"","",grandTotal,"");
                
                ArrayList<Batch_addDTO> batchlist=ctrlBatch_add.getAll();
                ArrayList<Batch_addDTO> batlist=new ArrayList<>();
                
                ArrayList<ProductDTO> prodlist=new ArrayList<>();
                
                ArrayList<OrdersDTO> odlist=ctrlOrders.getAll();
                for (OrdersDTO orders : odlist) {
                    
                    if(txtOrder.getText().equals(orders.getOid())){
                        for (Batch_addDTO batch_addDTO : batchlist) {
                            
                            String baid=batch_addDTO.getBaid();
                            int curQty=0;
                            ArrayList<Product_orderDTO> productlist=ctrlProduct_order.getAll();
                            for (Product_orderDTO product_orderDTO : productlist) {
                                if(product_orderDTO.getOid().equals(txtOrder.getText()) && baid.equals(product_orderDTO.getBaid())){
                                    curQty=product_orderDTO.getPack();
                                    String proid=ctrlBatch_add.getProId(baid);
                                    ProductDTO p=new ProductDTO(proid, "", new BigDecimal(curQty),product_orderDTO.getPack());
                                    prodlist.add(p);
                                }
                            }
      
                            Batch_addDTO batch=new Batch_addDTO(baid, "", "", "", 0, curQty, grandTotal, "", "");
                            batlist.add(batch);
                        }
                    }
                }
                boolean updates=ctrlProduct_order.update(txtOrder.getText(), prodlist, batlist);
                
                if(updates){
                    
                    ArrayList<Product_orderDTO> plist=new ArrayList<>();
                    ArrayList<Batch_addDTO> blist=new ArrayList<>();
                    ArrayList<ProductDTO> prolist=new ArrayList<>();

                    for (OrderTableModel tbl : list) {

                        String baid=tbl.getBatch();

                        String proid=ctrlProduct.getProid(tbl.getProName());
                        String unitprice=dfd.format(df.parse(tbl.getUnitPrice()));
                        String total=dfd.format(df.parse(tbl.getTotal()));

                        BigDecimal unitPrice=new BigDecimal(unitprice);
                        BigDecimal totalPrice=new BigDecimal(total);

                        BigDecimal bgSize=null;
                        ArrayList<Batch_addDTO> btlist=ctrlBatch_add.getAll();
                        for (Batch_addDTO batch_addDTO : btlist) {
                            if(batch_addDTO.getBaid().equals(tbl.getBatch())){
                                ArrayList<ProductDTO> prlist=ctrlProduct.getAll();
                                for (ProductDTO productDTO : prlist) {
                                    if(productDTO.getProid().equals(batch_addDTO.getProid())){
                                        bgSize=productDTO.getBagSize_kg();
                                    }
                                }
                            }

                        }
                        BigDecimal qty=new BigDecimal(tbl.getPack()).multiply(bgSize);

                        Product_orderDTO porder=new Product_orderDTO(txtOrder.getText(),baid,tbl.getPack(),qty,unitPrice,totalPrice);

                        plist.add(porder);


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

                    boolean b=ctrlOrders.update(o,prolist, plist,blist);

                    if(b){

                        ButtonType ok=new ButtonType("Ok", ButtonBar.ButtonData.OK_DONE);

                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Order Success!");
                        alert.setContentText("Your order Will be Prepared");
                        alert.setTitle("Order");
                        alert.showAndWait();

                    }else{
                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Order Failed!");
                        alert.setContentText("You have an Error in Ordering");
                        alert.setTitle("Order");
                        alert.showAndWait();
                    }
                    FXMLLoader fXMLLoader=new FXMLLoader(getClass().getResource("/com/sas/kem/edu/ijse/view/OrderPreview.fxml"));
                    Parent root=(Parent)fXMLLoader.load();
                    Stage stage=new Stage(StageStyle.TRANSPARENT);
                    stage.initModality(Modality.APPLICATION_MODAL);
                    stage.setScene(new Scene(root));
                    stage.show();
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed the date field or didn't select a company!");
            alert.showAndWait();
            return;
        }
        txtGrandTotal.setText("");
        tblOrder.getItems().clear();
        tblOrder.refresh();
        txtQty.setText("");
    }
    
    
    @FXML
    private void btnUndoOnAction(ActionEvent evt){
        
        try {
            DecimalFormat df=new DecimalFormat("#,###.00");
            df.setMaximumFractionDigits(2);
            
            DecimalFormat dfd=new DecimalFormat("#");
            dfd.setMaximumFractionDigits(2);
            
            BigDecimal grandTotal=new BigDecimal(dfd.format(df.parse(txtGrandTotal.getText())));
            int count=0;
            OrderTableModel tb=new OrderTableModel();
            for (OrderTableModel orderTableModel : undoList) {
                tb.setProName(orderTableModel.getProName());
                tb.setBatch(orderTableModel.getBatch());
                tb.setPack(orderTableModel.getPack());
                tb.setTotal(orderTableModel.getTotal());
                tb.setUnitPrice(orderTableModel.getUnitPrice());
                
                grandTotal=grandTotal.add(new BigDecimal(dfd.format(df.parse(orderTableModel.getTotal()))));
                
                count++;
            }
            list.add(tb);
            tblOrder.refresh();
            undoList.remove(count-1);
            if(undoList.isEmpty()){
                btnUndo.setDisable(true);
            }
            txtGrandTotal.setText(df.format(grandTotal));
        } catch (ParseException ex) {
            Logger.getLogger(OrderProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void setToolTips() {

        btnCancel.setTooltip(new Tooltip("You can diselect a selected row in the table!"));
        btnRemove.setTooltip(new Tooltip("You can remove a row from table!"));
        btnUpdate.setTooltip(new Tooltip("You can update a row in the table!"));
        btnUndo.setTooltip(new Tooltip("You can get a removed row again into the table!"));
        btnClear.setTooltip(new Tooltip("You can clear the whole Interface!"));
        
    }
    
    @FXML
    private void btnCalOnAction(ActionEvent evt){
        
        try {
            Runtime.getRuntime().exec("calc.exe");
        } catch (IOException ex) {
            Logger.getLogger(ReversingProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
