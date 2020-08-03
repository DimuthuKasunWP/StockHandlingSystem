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
import lk.edu.ijse.sas.controller.custom.CompanyController;
import lk.edu.ijse.sas.controller.custom.GrnController;
import lk.edu.ijse.sas.controller.custom.IdController;
import lk.edu.ijse.sas.controller.custom.MaterialController;
import lk.edu.ijse.sas.controller.custom.Purchase_orderController;
import lk.edu.ijse.sas.controller.custom.ValidationController;
import com.sas.kem.edu.ijse.dto.CompanyDTO;
import com.sas.kem.edu.ijse.dto.GrnDTO;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import com.sas.kem.edu.ijse.dto.Purchase_orderDTO;
import com.sas.kem.edu.ijse.dto.Return_batch_receiveDTO;
import lk.edu.ijse.sas.other.FastAdding;
import lk.edu.ijse.sas.tableModel.BuyMaterialTableModel;
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
import javafx.scene.input.KeyCode;
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
public class ReturnMaterialController implements Initializable {

    @FXML
    private Label lblMatName;
    
    @FXML
    private Label lblkg;
    
    @FXML
    private JFXComboBox cmbPorder;
    
    @FXML
    private JFXComboBox cmbMatName;
    
    @FXML
    private JFXComboBox cmbGrn;
    
    @FXML
    private JFXComboBox cmbLastPrice;
    
    @FXML
    private JFXDatePicker dtMfd;
    
    @FXML
    private JFXDatePicker dtExp;
    
    @FXML
    private JFXTextField txtQty;
    
    @FXML
    private JFXTextField txtUnitPrice;
    
    @FXML
    private TextField txtBatchNo;
    
    @FXML
    private TextField txtTotalQty;
    
    @FXML
    private TextField txtTotalPrice;
    
    @FXML
    private TextField txtGoodsAmount;
    
    @FXML
    private TextField txtCompany;
    
    @FXML
    private TextField txtGrnDt;
    
    @FXML
    private JFXButton btnBuy;
    
    @FXML
    private JFXButton btnUndo;
    
    @FXML
    private JFXButton btnCancel;
    
    @FXML
    private JFXButton btnNewMaterial;
    
    @FXML
    private JFXButton btnRenameMaterial;
    
    @FXML
    private JFXButton btnClear;
    
    @FXML
    private JFXButton btntbUpdate;
    
    @FXML
    private JFXButton btnRemove;
        
    @FXML
    private TableView tblBuyTable;
    
    @FXML
    private TableColumn colMatName;
    
    @FXML
    private TableColumn colBatchId;
    
    @FXML
    private TableColumn colMfd;
    
    @FXML
    private TableColumn colExp;
    
    @FXML
    private TableColumn colQty;
    
    @FXML
    private TableColumn colUnitPrice;
    
    @FXML
    private TableColumn colTotal;
    
    private ObservableList<BuyMaterialTableModel> list=FXCollections.observableArrayList();
    private ObservableList<BuyMaterialTableModel> undoList=FXCollections.observableArrayList();
    
    private Purchase_orderController ctrlPurchaseOrder;
    private MaterialController ctrlMat;
    private CompanyController ctrlCompany;
    private QueryController ctrlQuary;
    private GrnController ctrlGrn;
    private ValidationController ctrlValidation;
    private IdController ctrlId;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setControllers();
        setToolTips();
        
        setTableProperty();
        
        loadCmbPorder();
        loadCmbMaterial();
        loadCmbGrn();
        
        Platform.runLater(cmbGrn::requestFocus);
        
        cmbGrn.setOnKeyReleased(e->{
            if(e.getCode()==KeyCode.RIGHT){
                Platform.runLater(cmbPorder::requestFocus);
            }
        });
        cmbPorder.setOnKeyReleased(e->{
            if(e.getCode()==KeyCode.LEFT){
                Platform.runLater(cmbGrn::requestFocus);
            }
        });
        
        setUndoBtn();
    }    
    private void setControllers() {
          
        ctrlPurchaseOrder=(Purchase_orderController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PURCHASE_ORDER);
        ctrlMat=(MaterialController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.MATERIAL);
        ctrlCompany=(CompanyController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.COMPANY);
        ctrlQuary=(QueryController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.QUARY);
        ctrlGrn=(GrnController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.GRN);
        ctrlValidation=(ValidationController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.VALIDATION);
        ctrlId=(IdController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.IDGEN);
        
    }

    private void setTableProperty() {
        
        colMatName.setCellValueFactory(new PropertyValueFactory<BuyMaterialTableModel,String>("MatName"));
        colBatchId.setCellValueFactory(new PropertyValueFactory<BuyMaterialTableModel,String>("Batch"));
        colMfd.setCellValueFactory(new PropertyValueFactory<BuyMaterialTableModel,String>("Mfd"));
        colExp.setCellValueFactory(new PropertyValueFactory<BuyMaterialTableModel,String>("Exp"));
        colQty.setCellValueFactory(new PropertyValueFactory<BuyMaterialTableModel,String>("Qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<BuyMaterialTableModel,String>("UnitPrice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<BuyMaterialTableModel,String>("Total"));
        
        tblBuyTable.getItems().clear();
        tblBuyTable.setItems(list);
        
    }

    private void loadCmbPorder() {
        
        try {
            ArrayList<Purchase_orderDTO> pOrderList=ctrlPurchaseOrder.getAll();
            for (Purchase_orderDTO purchase_orderDTO : pOrderList) {
                
                cmbPorder.getItems().add(purchase_orderDTO.getPid());
            }
        } catch (Exception ex) {
            Logger.getLogger(BuyMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void loadCmbMaterial() {
        
        try {
            ArrayList<MaterialDTO> mList=ctrlMat.getAll();
            
            for (MaterialDTO materialDTO : mList) {
                cmbMatName.getItems().add(materialDTO.getMaterialName());
            }
        } catch (Exception ex) {
            Logger.getLogger(BuyMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    private Object[] getCommonThings(String name){
        
        String mid=null;
        BigDecimal get_amount=null;
        
        try {
            
            ArrayList<MaterialDTO> mlist=ctrlMat.getAll();
            for (MaterialDTO materialDTO : mlist) {
                if(name.equals(materialDTO.getMaterialName())){
                    get_amount=materialDTO.getAmount_kg();
                    mid=materialDTO.getMid();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(BuyMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return new Object[]{mid,get_amount};
    }
    
    @FXML
    public void cmbMatOnAction(ActionEvent evt){
     
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        cmbLastPrice.getItems().clear();
        cmbLastPrice.setValue("");
        try {
            String name=cmbMatName.getSelectionModel().getSelectedItem().toString();
            
            BigDecimal Qty=new BigDecimal(0);
            int count=0;
            String batch=null;
            for (BuyMaterialTableModel buyMaterialTableModel : list) {
                if(name.equals(buyMaterialTableModel.getMatName())){
                    Qty=Qty.add(new BigDecimal(dfd.format(df.parse(buyMaterialTableModel.getQty()))));
                    count++;
                }
                batch=buyMaterialTableModel.getBatch();
            }
            ArrayList<MaterialDTO> mlist=ctrlMat.getAll();
            if(count>0){
                
                for (MaterialDTO materialDTO : mlist) {
                    if(materialDTO.getMaterialName().equals(name)){

                        Object[] ob=getCommonThings(name);

                        BigDecimal amount=(BigDecimal)ob[1];
                        String mid=(String)ob[0];

                        txtTotalQty.setText(df.format(amount.subtract(Qty)));
                        lblMatName.setVisible(true);
                        lblMatName.setText(name);
                        lblkg.setVisible(true);

                        BigDecimal unitPrice1=ctrlQuary.getUnitPriceFromReceiveBatch(mid);
                        BigDecimal unitPrice2=ctrlQuary.getUnitPriceFromReturnReceiveBatch(mid);

                        cmbLastPrice.getItems().add(df.format(unitPrice1));
                        cmbLastPrice.getItems().add(df.format(unitPrice2));
                        if(batch!=null){
                            
                            char[] batchArr=batch.toCharArray();

                            if(batchArr[3]=='0' && batchArr[4]=='0' && batchArr[5]=='0' && batchArr[6]=='9'){
                                txtBatchNo.setText("RBR0010");
                                return;
                            }else if(batchArr[3]=='0' && batchArr[4]=='0' && batchArr[5]=='9' && batchArr[6]=='9'){
                                txtBatchNo.setText("RBR0100");
                                return;
                            }else if(batchArr[3]=='0' && batchArr[4]=='9' && batchArr[5]=='9' && batchArr[6]=='9' && batchArr.length==7){
                                txtBatchNo.setText("RBR1000");
                                return;
                            }else if(batchArr[3]=='9' && batchArr[4]=='9' && batchArr[5]=='9' && batchArr[6]=='9' && batchArr.length==7){
                                txtBatchNo.setText("RBR10000");
                                return;
                            }else if(batchArr[3]=='9' && batchArr[4]=='9' && batchArr[5]=='9' && batchArr[6]=='9' && batchArr[7]=='9' && batchArr.length==8){
                                txtBatchNo.setText("RBR100000");
                                return;
                            }else if(batchArr[3]=='9' && batchArr[4]=='9' && batchArr[5]=='9' && batchArr[6]=='9' && batchArr[7]=='9' && batchArr[8]=='9' && batchArr.length==9){
                                txtBatchNo.setText("RBR1000000");
                                return;
                            }
                            if(batchArr[3]=='0' && batchArr[4]=='0' && batchArr[5]=='0' &&  batchArr[6]<'9'){

                               int batchNo=Integer.parseInt(batchArr[6]+"")+1;
                               txtBatchNo.setText("RBR000"+Integer.toString(batchNo));

                            }else{
                                String batchNo="";
                                for(int i=3;i<batchArr.length;i++){
                                    batchNo=batchNo+(batchArr[i]+"");
                                }
                                int nextNo=Integer.parseInt(batchNo)+1;

                                char[] num=Integer.toString(nextNo).toCharArray();
                                if(num.length==2){
                                    System.out.println("RBR00"+nextNo);
                                    txtBatchNo.setText("RBR00"+nextNo);
                                }else if(num.length==3){
                                    System.out.println("RBR0"+nextNo);
                                    txtBatchNo.setText("RBR0"+nextNo);
                                }else if(num.length>3){
                                    System.out.println("RBR"+nextNo);
                                    txtBatchNo.setText("RBR"+nextNo);
                                }
                            }

                        }else{
                            String text=ctrlId.getNewId("return_batch_receive", "rbrid","RBR", 0);
                            char[] digit=text.toCharArray();
                            String batchNum="";
                            for(int i=3;i<digit.length; i++){
                                batchNum=batchNum+(digit[i]+"");
                            }
                            int number=Integer.parseInt(batchNum);
                            String no=Integer.toString(number);
                            char[] num=no.toCharArray();
                            if(num.length==1){
                                txtBatchNo.setText("RBR000"+no);
                                System.out.println("RBR000"+no);
                            }else if(num.length==2){
                                txtBatchNo.setText("RBR00"+no);
                                System.out.println("RBR00"+no);
                            }else if(num.length==3){
                                txtBatchNo.setText("RBR0"+no);
                                System.out.println("RBR0"+no);
                            }else if(num.length>3){
                                txtBatchNo.setText("RBR"+no);
                                System.out.println("RBR"+no);
                            }
                        }
                                                
                    }
                }
            }else{
                
                Object[] ob=getCommonThings(name);

                BigDecimal amount=(BigDecimal)ob[1];
                String mid=(String)ob[0];

                txtTotalQty.setText(df.format(amount));
                lblMatName.setVisible(true);
                lblMatName.setText(name);
                lblkg.setVisible(true);

                BigDecimal unitPrice1=ctrlQuary.getUnitPriceFromReceiveBatch(mid);
                BigDecimal unitPrice2=ctrlQuary.getUnitPriceFromReturnReceiveBatch(mid);

                cmbLastPrice.getItems().add(df.format(unitPrice1));
                cmbLastPrice.getItems().add(df.format(unitPrice2));

                if(batch!=null){
                            
                    char[] batchArr=batch.toCharArray();

                    if(batchArr[3]=='0' && batchArr[4]=='0' && batchArr[5]=='0' && batchArr[6]=='9'){
                        txtBatchNo.setText("RBR0010");
                        return;
                    }else if(batchArr[3]=='0' && batchArr[4]=='0' && batchArr[5]=='9' && batchArr[6]=='9'){
                        txtBatchNo.setText("RBR0100");
                        return;
                    }else if(batchArr[3]=='0' && batchArr[4]=='9' && batchArr[5]=='9' && batchArr[6]=='9' && batchArr.length==7){
                        txtBatchNo.setText("RBR1000");
                        return;
                    }else if(batchArr[3]=='9' && batchArr[4]=='9' && batchArr[5]=='9' && batchArr[6]=='9' && batchArr.length==7){
                        txtBatchNo.setText("RBR10000");
                        return;
                    }else if(batchArr[3]=='9' && batchArr[4]=='9' && batchArr[5]=='9' && batchArr[6]=='9' && batchArr[7]=='9' && batchArr.length==8){
                        txtBatchNo.setText("RBR100000");
                        return;
                    }else if(batchArr[3]=='9' && batchArr[4]=='9' && batchArr[5]=='9' && batchArr[6]=='9' && batchArr[7]=='9' && batchArr[8]=='9' && batchArr.length==9){
                        txtBatchNo.setText("RBR1000000");
                        return;
                    }
                    if(batchArr[3]=='0' && batchArr[4]=='0' && batchArr[5]=='0' &&  batchArr[6]<'9'){

                       int batchNo=Integer.parseInt(batchArr[6]+"")+1;
                       txtBatchNo.setText("RBR000"+Integer.toString(batchNo));

                    }else{
                        String batchNo="";
                        for(int i=3;i<batchArr.length;i++){
                            batchNo=batchNo+(batchArr[i]+"");
                        }
                        int nextNo=Integer.parseInt(batchNo)+1;

                        char[] num=Integer.toString(nextNo).toCharArray();
                        if(num.length==2){
                            txtBatchNo.setText("RBR00"+nextNo);
                        }else if(num.length==3){
                            txtBatchNo.setText("RBR0"+nextNo);
                        }else if(num.length>3){ 
                            txtBatchNo.setText("RBR"+nextNo);
                        }
                    }

                }else{
                    String text=ctrlId.getNewId("return_batch_receive", "rbrid","RBR", 0);
                    char[] digit=text.toCharArray();
                    String batchNum="";
                    for(int i=3;i<digit.length; i++){
                        batchNum=batchNum+(digit[i]+"");
                    }
                    int number=Integer.parseInt(batchNum);
                    String no=Integer.toString(number);
                    char[] num=no.toCharArray();
                    if(num.length==1){
                        txtBatchNo.setText("RBR000"+no);
                      
                    }else if(num.length==2){
                        txtBatchNo.setText("RBR00"+no);
                      
                    }else if(num.length==3){
                        txtBatchNo.setText("RBR0"+no);
                        
                    }else if(num.length>3){
                        txtBatchNo.setText("RBR"+no);
                        
                    }
                }
            }     
            
        } catch (Exception ex) {
           // Logger.getLogger(BuyMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    @FXML
    private void cmbLastPriceOnAction(ActionEvent evt){
        try{
            String unitPrice=cmbLastPrice.getSelectionModel().getSelectedItem().toString();
            cmbLastPrice.setValue("");
            txtUnitPrice.setText(unitPrice);
        }catch(Exception ex){
            
        }
        
    }
    
    @FXML
    private void txtUnitPriceOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        try {
            BigDecimal unitprice=new BigDecimal(dfd.format(df.parse(txtUnitPrice.getText())));

            BigDecimal qty=new BigDecimal(txtQty.getText());

            BigDecimal total=qty.multiply(unitprice);

            String total1=df.format(total);

            txtTotalPrice.setText(total1);

            txtTotalPrice.requestFocus();
            
        } catch (Exception ex) {

            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed the quantity field.Check Again!");
            alert.showAndWait();
        }
        
        
    }
    
    private void clearAction(){
        
        cmbMatName.setValue("");
        cmbMatName.setDisable(true);
        
        txtBatchNo.setText("");
        txtTotalQty.setText("");
        txtQty.setText("");
        txtUnitPrice.setText("");
        txtTotalPrice.setText("");
        
        dtMfd.setValue(null);
        dtExp.setValue(null);
        lblkg.setVisible(false);
    }
    
    @FXML
    private void txtQtyKeyReleased(KeyEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        try {
            String name=cmbMatName.getSelectionModel().getSelectedItem().toString();
            Object[] ob=getCommonThings(name);
            
            String text=txtQty.getText();
            if(!ctrlValidation.setNumberFormat(text)){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You can use only numbers!");
                alert.setContentText("EX: 2322.34,1232");
                alert.showAndWait();
                txtQty.setText("");
            }else{
                BigDecimal qty=(BigDecimal)(ob[1]);
                String quantity=qty.toString();
                FastAdding fc=new FastAdding((txtQty.getText()),Double.valueOf(quantity));

                String[] texts=fc.getFinalCalculation();

                txtTotalQty.setText(texts[0]);
                txtTotalQty.setText(df.format(dfd.parse(texts[1])));
            }
            
        } catch (Exception ex) {

        }
        
    }
    @FXML
    private void txtUnitPriceOnKeyReleased(KeyEvent evt){
        
        try {
            String name=txtUnitPrice.getText();
            if(!ctrlValidation.setNumberFormat(name)){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You can use only numbers!");
                alert.setContentText("EX: 2322.34,1232");
                alert.showAndWait();
                txtUnitPrice.setText("");
            }
        } catch (Exception ex) {
            Logger.getLogger(ReturnMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void txtTotalOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        try{
            if(txtQty.getText().equals("") || txtUnitPrice.getText().equals("") || cmbMatName.getSelectionModel().getSelectedItem().toString().equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You missed the unit price or quantity or material fields.check Again!");
                alert.showAndWait();
            }else{
                String materialName=cmbMatName.getSelectionModel().getSelectedItem().toString();
        
                for (BuyMaterialTableModel tbl : list) {

                    String material=tbl.getMatName();
                    String batch=tbl.getBatch();
                    String mfd=tbl.getMfd();
                    String exp=tbl.getExp();
                    BigDecimal qty=new BigDecimal(dfd.format(df.parse(tbl.getQty())));
                    BigDecimal unitPrice=new BigDecimal(dfd.format(df.parse(tbl.getUnitPrice())));
                    String total=tbl.getTotal();

                    if(txtBatchNo.getText().equals(tbl.getBatch()) && materialName.equals(tbl.getMatName())){

                        BuyMaterialTableModel tb=new BuyMaterialTableModel();

                        tb.setBatch(batch);
                        tb.setMatName(material);
                        tb.setMfd(mfd);
                        tb.setExp(exp);

                        BigDecimal d=new BigDecimal(txtQty.getText());
                        BigDecimal quantity=d.add(qty);

                        BigDecimal totalPrice=quantity.multiply(unitPrice);
                        tb.setQty(df.format(quantity));

                        tb.setUnitPrice(tbl.getUnitPrice());
                        tb.setTotal(df.format(totalPrice));

                        list.remove(tbl);
                        list.add(tb);
                        tblBuyTable.refresh();

                        clearAction();
                        lblkg.setVisible(false);
                        cmbMatName.setDisable(false);
                        Platform.runLater(cmbMatName::requestFocus);
                        return;

                    }

                }
                String matName=cmbMatName.getSelectionModel().getSelectedItem().toString();
                String batch=txtBatchNo.getText();
                String mfd=dtMfd.getValue().toString();
                String exp=dtExp.getValue().toString();
                BigDecimal quantity=new BigDecimal(txtQty.getText());
                String qty=df.format(quantity);
                BigDecimal unitprice=new BigDecimal(txtUnitPrice.getText());
                String unitPrice=df.format(unitprice);


                BigDecimal total1=quantity.multiply(unitprice);
                String total=df.format(total1);

                BuyMaterialTableModel tb=new BuyMaterialTableModel();

                tb.setMatName(matName);
                tb.setBatch(batch);
                tb.setMfd(mfd);
                tb.setExp(exp);
                tb.setQty(qty);
                tb.setUnitPrice(unitPrice);
                tb.setTotal(total);

                list.add(tb);
                tblBuyTable.refresh();

                lblkg.setVisible(false);
                clearAction();
                cmbMatName.setDisable(false);
                Platform.runLater(cmbMatName::requestFocus);

                txtGoodsAmount.setText("");
                txtGoodsAmount.setText(Integer.toString(list.size()));
            }
            

        }catch(Exception ex){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed some fields.check Again!");
            alert.showAndWait();
        }
        
        
    }
    
    @FXML
    private void updateBtnOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        
        try {
            if(list.isEmpty()){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Return materials table has not any items!");
                alert.showAndWait();
            }else{
                ArrayList<Return_batch_receiveDTO> blist=new ArrayList<>();
                ArrayList<MaterialDTO> mlist=new ArrayList<>();
                GrnDTO gr=null;

                String grn=cmbGrn.getSelectionModel().getSelectedItem().toString();
                String pOrder=cmbPorder.getSelectionModel().getSelectedItem().toString();
                String generateGrn=null;

                if(grn==null){
                    ArrayList<GrnDTO> glist=ctrlGrn.getAll();
                    for (GrnDTO grnDTO : glist) {
                        if(grnDTO.getPid().equals(pOrder)){
                            generateGrn=grnDTO.getGrid();
                        }
                    }
                }

                String grn_date=txtGrnDt.getText();
                int goodAmount=Integer.parseInt(txtGoodsAmount.getText());
                String comName=txtCompany.getText();

                String mid=null;
                String cid=ctrlCompany.getCompanyId(comName);

                Date d=new Date();
                SimpleDateFormat dateFormat=new SimpleDateFormat("hh:mm:ss");
                String add_time=dateFormat.format(d);

                BigDecimal grandTotal=new BigDecimal(0);

                for (BuyMaterialTableModel tbl : list) {

                    String matName=tbl.getMatName();
                    String batch=tbl.getBatch();
                    String mfd=tbl.getMfd();
                    String exp=tbl.getExp();

                    BigDecimal qty=new BigDecimal(dfd.format(df.parse(tbl.getQty()))); 
                    BigDecimal unitPrice=new BigDecimal(dfd.format(df.parse(tbl.getUnitPrice()))); 
                    BigDecimal total=new BigDecimal(dfd.format(df.parse(tbl.getTotal())));

                    grandTotal=grandTotal.add(total);

                    mid=ctrlMat.getMaterialId(matName);

                    if(grn==null){
                        Return_batch_receiveDTO b=new Return_batch_receiveDTO(batch,generateGrn,mid,mfd,exp,qty,qty,unitPrice,total);
                        blist.add(b);
                    }else{
                        Return_batch_receiveDTO b=new Return_batch_receiveDTO(batch,grn,mid,mfd,exp,qty,qty,unitPrice,total);
                        blist.add(b);
                    }    


                    MaterialDTO m=new MaterialDTO(mid,matName,qty);

                    mlist.add(m);

                }
                if(grn==null){
                    gr=new GrnDTO(generateGrn,cid,pOrder,goodAmount,add_time,grn_date,grandTotal);
                }else{
                    gr=new GrnDTO(grn,cid,pOrder,goodAmount,add_time,grn_date,grandTotal);
                }


                boolean b=ctrlGrn.update(gr,mlist,blist);

                if(b){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Update Is Successfull!");
                    alert.setContentText("Returned Material Stocks added to the System!");
                    alert.setTitle("Return Material");
                    alert.showAndWait();
                }else{
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText("Update Is not Successfull!");
                    alert.setContentText("You have a Error in your material Returning!");
                    alert.setTitle("Return Material");
                    alert.showAndWait();

                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(BuyMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cmbLastPrice.setValue("");
        txtGoodsAmount.setText("");
        txtGrnDt.setText("");
        txtCompany.setText("");
        
        cmbGrn.setValue("");
        cmbPorder.setValue("");
        tblBuyTable.getItems().clear();
        clearAction();
        Platform.runLater(cmbGrn::requestFocus);
        
    }
    
    @FXML
    private void cancelBtnOnAction(ActionEvent evt){
        
        BuyMaterialTableModel tb=(BuyMaterialTableModel)tblBuyTable.getSelectionModel().getSelectedItem();
        
        if(tb==null){
            
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please Select a Row!");
            alert.setContentText("Cause:Any row is not selected");
            alert.setTitle("Update");
            alert.showAndWait();
            
        }else{
            
            lblkg.setVisible(false);
            clearAction();
            cmbMatName.setDisable(false);
            Platform.runLater(cmbMatName::requestFocus);
            txtTotalPrice.setDisable(false);
        }
    }
    
    @FXML
    private void updatetbBtnOnAction(ActionEvent evt){
        
        
        BuyMaterialTableModel tb=(BuyMaterialTableModel)tblBuyTable.getSelectionModel().getSelectedItem();
        
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please Select a Row!");
            alert.setContentText("Cause:Any row is not selected");
            alert.setTitle("Update");
            alert.showAndWait();
        }else{
            lblkg.setVisible(false);
            txtTotalPrice.setDisable(true);
            tblBuyTable.refresh();
            list.remove(tb);

            BuyMaterialTableModel tbl=new BuyMaterialTableModel();

            tbl.setBatch(txtBatchNo.getText());
            tbl.setMatName(cmbMatName.getSelectionModel().getSelectedItem().toString());
            tbl.setExp(dtExp.getValue().toString());
            tbl.setMfd(dtMfd.getValue().toString());
            tbl.setQty(txtQty.getText());
            tbl.setUnitPrice(txtUnitPrice.getText());
            tbl.setTotal(txtTotalPrice.getText());

            list.add(tbl);
            tblBuyTable.refresh();

            clearAction();
            cmbMatName.setDisable(false);
            Platform.runLater(cmbMatName::requestFocus);
            txtTotalPrice.setDisable(false);
        }
        
        
    }
    @FXML
    private void removeBtnOnAction(ActionEvent evt){
        
        BuyMaterialTableModel tb=(BuyMaterialTableModel)tblBuyTable.getSelectionModel().getSelectedItem();
        
        if(tb==null){
            
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please Select a Row!");
            alert.setContentText("Cause:Any row is not selected");
            alert.setTitle("Update");
            alert.showAndWait();
            
        }else{
            lblkg.setVisible(false);
            undoList.add(tb);
            if(undoList.isEmpty()){
                btnUndo.setDisable(true);
            }else{
                btnUndo.setDisable(false);
            }
            list.remove(tb);
            clearAction();
            cmbMatName.setDisable(false);
            Platform.runLater(cmbMatName::requestFocus);
            txtTotalPrice.setDisable(false);
            tblBuyTable.refresh();
        }
        txtGoodsAmount.setText("");
        txtGoodsAmount.setText(Integer.toString(list.size()));
    }
    @FXML
    private void rowOnClicked(MouseEvent evt){
        
      
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);

        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);

        BuyMaterialTableModel tb=(BuyMaterialTableModel)tblBuyTable.getSelectionModel().getSelectedItem();

        cmbMatName.setValue(tb.getMatName());
        cmbMatName.setDisable(true);
        txtBatchNo.setText(tb.getBatch());
        txtQty.setText(tb.getQty()); 
        
        try{
            BigDecimal qty=new BigDecimal(dfd.format(df.parse(tb.getQty())));
            
            for (BuyMaterialTableModel buyMaterialTableModel : list) {
                if(tb.getMatName().equals(buyMaterialTableModel.getMatName())){
                    qty=qty.add(new BigDecimal(dfd.format(df.parse(buyMaterialTableModel.getQty()))));
                }
            }
            qty=qty.subtract(new BigDecimal(dfd.format(df.parse(tb.getQty()))));
            ArrayList<MaterialDTO> matlist=ctrlMat.getAll();
            for (MaterialDTO materialDTO : matlist) {
                if(tb.getMatName().equals(materialDTO.getMaterialName())){

                    txtTotalQty.setText(df.format(materialDTO.getAmount_kg().subtract(qty)));

                }
            }
            txtTotalPrice.setText(tb.getTotal());
            txtUnitPrice.setText(tb.getUnitPrice());
            dtMfd.setValue(LocalDate.parse(tb.getMfd()));
            dtExp.setValue(LocalDate.parse(tb.getExp()));

            txtTotalPrice.setDisable(true);
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        
    }
    
    @FXML
    private void clearBtnOnAction(ActionEvent evt){
        
        clearAction();
        
        tblBuyTable.getItems().clear();
        tblBuyTable.refresh();
        
        cmbGrn.setValue("");
        cmbPorder.setValue("");
        txtGoodsAmount.setText("");
    }
    
    @FXML
    private void txtQtyOnAction(ActionEvent evt){
        
        try {
              if(cmbMatName.getSelectionModel().getSelectedItem().toString()==null){
                  Alert alert=new Alert(Alert.AlertType.ERROR);
                  alert.setHeaderText("You didn't set a material!");
                  alert.showAndWait();
                  txtQty.setText("");
              }  else{
                txtUnitPrice.requestFocus();
              
              }
              
        } catch (Exception ex) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You didn't set a material!");
            alert.showAndWait();
            txtQty.setText("");
        }
        
    }
    
    @FXML
    private void dtMfdOnAction(ActionEvent evt){
        
        try {
            
            dtExp.requestFocus();
            
            
        } catch (Exception ex) {
            Logger.getLogger(BuyMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void dtExpOnAction(ActionEvent evt){
        
        try {
            
            txtQty.requestFocus();
            
            
        } catch (Exception ex) {
            Logger.getLogger(BuyMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    private void undoBtnOnAction(ActionEvent evt){
        
        int count=0;
        BuyMaterialTableModel tb=new BuyMaterialTableModel();
        for (BuyMaterialTableModel buyMaterialTableModel : undoList) {
            tb.setBatch(buyMaterialTableModel.getBatch());
            tb.setExp(buyMaterialTableModel.getExp());
            tb.setMatName(buyMaterialTableModel.getMatName());
            tb.setMfd(buyMaterialTableModel.getMfd());
            tb.setQty(buyMaterialTableModel.getQty());
            tb.setUnitPrice(buyMaterialTableModel.getUnitPrice());
            tb.setTotal(buyMaterialTableModel.getTotal());
            count++;
        }
        list.add(tb);
        tblBuyTable.refresh();
        undoList.remove(count-1);
        if(undoList.isEmpty()){
            btnUndo.setDisable(true);
        }
        txtGoodsAmount.setText(Integer.toString(list.size()));
                
        
    }

    private void setUndoBtn() {

        btnUndo.setDisable(true);
        
    }
    
    @FXML
    private void newMaterialOnAction(ActionEvent evt){
        
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/sas/kem/edu/ijse/view/NewMaterial.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(BuyMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void renameMaterialOnAction(ActionEvent evt){
        
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("/com/sas/kem/edu/ijse/view/RenameMaterial.fxml"));
            Parent root=(Parent)fxmlLoader.load();
            Stage stage=new Stage(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(BuyMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void renameComOnAction(ActionEvent evt){
        
        try {
            FXMLLoader fXMLLoader=new FXMLLoader(getClass().getResource("/com/sas/kem/edu/ijse/view/RenameCompany.fxml"));
            Parent root=(Parent)fXMLLoader.load();
            Stage stage=new Stage(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(BuyMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void newComOnAction(ActionEvent evt){
        
        try {
            FXMLLoader fXMLLoader=new FXMLLoader(getClass().getResource("/com/sas/kem/edu/ijse/view/NewCompany.fxml"));
            Parent root=(Parent)fXMLLoader.load();
            Stage stage=new Stage(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(BuyMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void loadCmbGrn() {

        try {
            ArrayList<GrnDTO> glist=ctrlGrn.getAll();
            for (GrnDTO grnDTO : glist) {
                cmbGrn.getItems().add(grnDTO.getGrid());
            }
        } catch (Exception ex) {
            Logger.getLogger(ReturnMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void cmbGrnOnAction(ActionEvent evt){
        cmbPorder.setValue("");
        String grn=cmbGrn.getSelectionModel().getSelectedItem().toString();
        try {
            ArrayList<GrnDTO> glist=ctrlGrn.getAll();
            String cid=null;
            for (GrnDTO grnDTO : glist) {
                if(grn.equals(grnDTO.getGrid())){
                    txtGrnDt.setText(grnDTO.getGrnDate());
                    cid=grnDTO.getCid();
                }
            }
            String comName=null;
            ArrayList<CompanyDTO> clist=ctrlCompany.getAll();
            for (CompanyDTO companyDTO : clist) {
                if(cid.equals(companyDTO.getCid())){
                    comName=companyDTO.getComName();
                }
            }
            txtCompany.setText(comName);
            cmbMatName.setDisable(false);
        } catch (Exception ex) {
            //Logger.getLogger(ReturnMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void cmbPorderOnAction(ActionEvent evt){
        
        cmbGrn.setValue("");
        
        String porder=cmbPorder.getSelectionModel().getSelectedItem().toString();
        
        try {
            String grn=null;
        
            ArrayList<GrnDTO> grlist=ctrlGrn.getAll();
            for (GrnDTO grnDTO : grlist) {
                if(porder.equals(grnDTO.getPid())){
                    grn=grnDTO.getGrid();
                }
            }
            ArrayList<GrnDTO> glist=ctrlGrn.getAll();
            String cid=null;
            for (GrnDTO grnDTO : glist) {
                if(grn.equals(grnDTO.getGrid())){
                    txtGrnDt.setText(grnDTO.getGrnDate());
                    cid=grnDTO.getCid();
                }
            }
            String comName=null;
            ArrayList<CompanyDTO> clist=ctrlCompany.getAll();
            for (CompanyDTO companyDTO : clist) {
                if(cid.equals(companyDTO.getCid())){
                    comName=companyDTO.getComName();
                }
            }
            txtCompany.setText(comName);
            cmbMatName.setDisable(false);
        } catch (Exception ex) {
           // Logger.getLogger(ReturnMaterialController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setToolTips() {

        btnNewMaterial.setTooltip(new Tooltip("You can introduce a new Material to your stock !"));
        btnRenameMaterial.setTooltip(new Tooltip("You can rename a Material in your stock !"));
        btnRenameMaterial.setTooltip(new Tooltip("You can introduce a new Company to buy stocks !"));
        btnCancel.setTooltip(new Tooltip("You can diselect a selected row in the table!"));
        btnRemove.setTooltip(new Tooltip("You can remove a row from table!"));
        btnUndo.setTooltip(new Tooltip("You can get a removed row again into the table!"));
        btnClear.setTooltip(new Tooltip("You can clear the whole Interface!"));
        btnBuy.setTooltip(new Tooltip("You can Buy Returned materials to your stock!"));
        btntbUpdate.setTooltip(new Tooltip("You can update a row in the table!"));
    }
    
}
