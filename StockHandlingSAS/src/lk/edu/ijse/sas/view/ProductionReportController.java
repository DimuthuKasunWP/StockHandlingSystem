/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.view;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import lk.edu.ijse.sas.controller.ControllerFactory;
import lk.edu.ijse.sas.controller.custom.Batch_addController;
import lk.edu.ijse.sas.controller.custom.OrdersController;
import lk.edu.ijse.sas.controller.custom.ProductController;
import lk.edu.ijse.sas.controller.custom.Product_orderController;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import com.sas.kem.edu.ijse.dto.OrdersDTO;
import com.sas.kem.edu.ijse.dto.ProOrderDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import com.sas.kem.edu.ijse.dto.Product_orderDTO;
import lk.edu.ijse.sas.tableModel.ProductionOrderTableModel;
import lk.edu.ijse.sas.tableModel.ProductionProductTableModel;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
public class ProductionReportController implements Initializable {
    
    @FXML
    private JFXComboBox cmbProName;
    
    @FXML
    private Label lblProName;
    
    @FXML
    private Label lblOdName;
    
    @FXML
    private TextField txtDate;
    
    @FXML
    private JFXDatePicker dtView;
    
    @FXML
    private TableView  tblProduct;
    
    @FXML
    private TableView  tblOrder;
    
    @FXML
    private TableColumn colProDesc;
    
    @FXML
    private TableColumn colProQty;
    
    @FXML
    private TableColumn colProAddTime;
    
    @FXML
    private TableColumn colProDate;
    
    @FXML
    private TableColumn colOdDesc;
    
    @FXML
    private TableColumn colOdQty;
    
    @FXML
    private TableColumn colOdUnitPrice;
    
    @FXML
    private TableColumn colOdTotal;
    
    @FXML
    private TableColumn colOdDate;
    
    @FXML
    private AnchorPane thisPane;
    
    private ObservableList<ProductionProductTableModel> proList=FXCollections.observableArrayList();
    private ObservableList<ProductionOrderTableModel> orderList=FXCollections.observableArrayList();
    
    private Batch_addController ctrlBatch_add;
    private Product_orderController ctrlProduct_order;
    private ProductController ctrlProduct;
    private QueryController ctrlQuary;
    private OrdersController ctrlOrder;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        setControllers();
        setProdctionProductTblProperty();
        setProductionOrderTblProperty();
        loadCmbProductions();
        setUIs();
        setDate();
    }    

    private void setControllers() {
        
        ctrlOrder=(OrdersController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.ORDERS);
        ctrlQuary=(QueryController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.QUARY);
        ctrlProduct=(ProductController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT);
        ctrlBatch_add=(Batch_addController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.BATCH_ADD);
        ctrlProduct_order=(Product_orderController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT_ORDER);
    }
    @FXML
    private void cmbProOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        String proName=cmbProName.getSelectionModel().getSelectedItem().toString();
        
        lblOdName.setVisible(true);
        lblOdName.setText(proName);
        
        lblProName.setVisible(true);
        lblProName.setText(proName);
        
        try {
            String proId=ctrlProduct.getProid(proName);
            tblOrder.getItems().clear();
            tblProduct.getItems().clear();
            
            ArrayList<Batch_addDTO> pList=ctrlBatch_add.getAll();
            for (Batch_addDTO batch_addDTO : pList) {
                
                ProductionProductTableModel tb=new ProductionProductTableModel();
                if(proId.equals(batch_addDTO.getProid())){
                    
                    tb.setDesc(proName);
                    tb.setQty(batch_addDTO.getProduct_qty());
                    tb.setDate(batch_addDTO.getAddDate());
                    tb.setTime(batch_addDTO.getAddTime());
                    
                    proList.add(tb);
                }
            }
            
            ArrayList<String> batchList=new ArrayList<>();
            ArrayList<Batch_addDTO> blist=ctrlBatch_add.getAll();
            for (Batch_addDTO batch_addDTO : blist) {
                if(proId.equals(batch_addDTO.getProid())){
                    batchList.add(batch_addDTO.getBaid());
                }
            }
            for (String string : batchList) {
                
                ArrayList<Product_orderDTO> proList=ctrlProduct_order.getAll();
                for (Product_orderDTO product_orderDTO : proList) {
                    
                    int count=0;
                    
                    ProductionOrderTableModel tb=new ProductionOrderTableModel();
                    if(string.equals(product_orderDTO.getBaid())){
                        
                        String date=null;
                        
                        ArrayList<String> dateList=ctrlQuary.getOrderDate(product_orderDTO.getBaid());
                        
                        if(dateList.size()>1){
                            date=dateList.get(count);
                            count++;
                            
                        }
                        tb.setDesc(ctrlProduct.getProName(proId));
                        tb.setQty(product_orderDTO.getPack());
                        tb.setUnitPrice(df.format(product_orderDTO.getUnitPrice_1Bag()));
                        tb.setTotal(df.format(product_orderDTO.getTotal()));
                        tb.setDate(date);
                        
                        orderList.add(tb);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductionReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    @FXML
    private void dateOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        try {
            lblOdName.setVisible(false);
            lblProName.setVisible(false);
            
            tblOrder.getItems().clear();
            tblProduct.getItems().clear();
            
            String date=dtView.getValue().toString();
            
            ArrayList<Batch_addDTO> blist=ctrlBatch_add.getAll();
            for (Batch_addDTO batch_addDTO : blist) {
                ProductionProductTableModel tb=new ProductionProductTableModel();
                if(date.equals(batch_addDTO.getAddDate())){
                    tb.setDate(date);
                    tb.setDesc(ctrlProduct.getProName(batch_addDTO.getProid()));
                    tb.setQty(batch_addDTO.getProduct_qty());
                    tb.setTime(batch_addDTO.getAddTime());
                    
                    proList.add(tb);
                    
                }
            }
            
            ArrayList<ProOrderDTO> List=new ArrayList<>();
            ArrayList<OrdersDTO> olist=ctrlOrder.getAll();
            for (OrdersDTO ordersDTO : olist) {
                if(date.equals(ordersDTO.getOrderDate())){
                    ProOrderDTO o=new ProOrderDTO(ordersDTO.getOid(),ordersDTO.getOrderDate(),1);
                    List.add(o);
                }
            }
            for (ProOrderDTO proOrderDTO : List) {
                
                String order=proOrderDTO.getOid();
                ArrayList<Product_orderDTO> odlist=ctrlProduct_order.getAll();
                for (Product_orderDTO product_orderDTO : odlist) {
                    ProductionOrderTableModel tb=new ProductionOrderTableModel();
                    if(order.equals(product_orderDTO.getOid())){
                        
                        tb.setDate(date);
                        tb.setDesc(ctrlQuary.getProName(product_orderDTO.getBaid()));
                        tb.setQty(product_orderDTO.getPack());
                        tb.setTotal(df.format(product_orderDTO.getTotal()));
                        tb.setUnitPrice(df.format(product_orderDTO.getUnitPrice_1Bag()));
                        
                        orderList.add(tb);
                    }
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ProductionReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }

    private void setProductionOrderTblProperty() {

        colOdDate.setCellValueFactory(new PropertyValueFactory<ProductionOrderTableModel,String>("Date"));
        colOdTotal.setCellValueFactory(new PropertyValueFactory<ProductionOrderTableModel,String>("Total"));
        colOdQty.setCellValueFactory(new PropertyValueFactory<ProductionOrderTableModel,Integer>("Qty"));
        colOdUnitPrice.setCellValueFactory(new PropertyValueFactory<ProductionOrderTableModel,String>("UnitPrice"));
        colOdDesc.setCellValueFactory(new PropertyValueFactory<ProductionOrderTableModel,String>("Desc"));
        
        tblOrder.setItems(orderList);
    }

    private void setProdctionProductTblProperty() {

        colProQty.setCellValueFactory(new PropertyValueFactory<ProductionProductTableModel,Integer>("Qty"));
        colProDesc.setCellValueFactory(new PropertyValueFactory<ProductionProductTableModel,String>("Desc"));
        colProDate.setCellValueFactory(new PropertyValueFactory<ProductionProductTableModel,String>("Date"));
        colProAddTime.setCellValueFactory(new PropertyValueFactory<ProductionProductTableModel,String>("Time"));
        
        tblProduct.setItems(proList);
    }

    private void loadCmbProductions() {

        try {
            ArrayList<ProductDTO> list=ctrlProduct.getAll();
            for (ProductDTO productDTO : list) {
                cmbProName.getItems().add(productDTO.getProductName());
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductionReportController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setDate() {

        Date d=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String date=df.format(d);
        txtDate.setText(date);
    }
    
    private void setUIs() {

        thisPane.setOnKeyReleased(e->{
            switch(e.getCode()){
                
                case DIGIT2:    try{

                                    AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/MaterialReport.fxml"));
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
