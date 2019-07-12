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
import lk.edu.ijse.sas.controller.custom.ProductController;
import lk.edu.ijse.sas.controller.custom.ValidationController;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import lk.edu.ijse.sas.other.FastAdding;
import lk.edu.ijse.sas.tableModel.AddProductTableModel;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author dimuthu
 */
public class AddProductionController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private JFXComboBox cmbProName;
    
    @FXML
    private JFXComboBox cmbLastPrice;
    
    @FXML
    private JFXTextField txtQty;
    
    @FXML
    private JFXTextField txtUnitPrice;
    
    @FXML
    private TextField txtBatch;
    
    @FXML
    private TextField txtTotalQty;
    
    @FXML
    private JFXDatePicker dtMfd;
    
    @FXML
    private JFXDatePicker dtExp;
    
    @FXML
    private JFXDatePicker dtAdd;
    
    @FXML
    private Label lblProName;
    
    @FXML
    private Label lblBags;
    
    @FXML
    private JFXButton btnRemove;
    
    @FXML
    private JFXButton btnUpdate;
    
    @FXML
    private JFXButton btnUndo;
    
    @FXML
    private JFXButton btnCancel;
    
    @FXML
    private JFXButton btnAdd;
    
    @FXML
    private JFXButton btnNewPro;
    
    @FXML
    private JFXButton btnRenamePro;
    
    @FXML
    private JFXButton btnClear;
    
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
    
    @FXML
    private TableColumn colUnitPrice;
    
    @FXML
    private TableView tblAddPro;
    
    @FXML
    private AnchorPane thisPane;
    
    private ObservableList<AddProductTableModel> list=FXCollections.observableArrayList();
    private ObservableList<AddProductTableModel> undoList=FXCollections.observableArrayList();
    
    private ProductController ctrlProduct;
    private Batch_addController ctrlBatch_add;
    private ValidationController ctrlValidation;
    private IdController ctrlId;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        setControllers();
        setToolTips();
        setUIs();
        loadProductCombo();
        setDate();
        setTableProperty();
        setComponentsProperty();
        
    }
    private void setControllers(){
        
        ctrlId=(IdController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.IDGEN);
        ctrlProduct=(ProductController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.PRODUCT);
        ctrlBatch_add=(Batch_addController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.BATCH_ADD);
        ctrlValidation=(ValidationController) ControllerFactory.getInstance().getContollerTypes(ControllerFactory.ControllerTypes.VALIDATION);
    }
    private void loadProductCombo(){
        
        try {
            ArrayList<ProductDTO> prolist=ctrlProduct.getAll();
            
            for (ProductDTO productDTO : prolist) {
                cmbProName.getItems().add(productDTO.getProductName());
            }
        } catch (Exception ex) {
            Logger.getLogger(AddProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void setTableProperty(){
        
        colProName.setCellValueFactory(new PropertyValueFactory<AddProductTableModel,String>("ProductName"));
        colBatch.setCellValueFactory(new PropertyValueFactory<AddProductTableModel,String>("Batch"));
        colMfd.setCellValueFactory(new PropertyValueFactory<AddProductTableModel,String>("MFD"));
        colExp.setCellValueFactory(new PropertyValueFactory<AddProductTableModel,String>("EXP"));
        colQty.setCellValueFactory(new PropertyValueFactory<AddProductTableModel,Integer>("Qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<AddProductTableModel,String>("UnitPrice"));
        
        tblAddPro.getItems().clear();
        tblAddPro.setItems(list);
          
    }
    
    private void setComponentsProperty(){
        
        Platform.runLater(cmbProName::requestFocus);
        lblBags.setVisible(false);
        lblProName.setVisible(false);
        btnUndo.setDisable(true);
        
    }

    private void setDate() {

        Date d=new Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        String date=df.format(d);
        dtAdd.setValue(LocalDate.parse(date));
    }
    
    @FXML
    private void newProductOnAction(ActionEvent evt){
        
        try {
            FXMLLoader fXMLLoader=new FXMLLoader(getClass().getResource("/com/sas/kem/edu/ijse/view/NewProduction.fxml"));
            Parent root=(Parent)fXMLLoader.load();
            Stage stage=new Stage(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(AddProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void renameProductOnAction(ActionEvent evt){
        try {
            FXMLLoader fXMLLoader=new FXMLLoader(getClass().getResource("/com/sas/kem/edu/ijse/view/RenameProduction.fxml"));
            Parent root=(Parent)fXMLLoader.load();
            Stage stage=new Stage(StageStyle.TRANSPARENT);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(AddProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Object[] getCommonThings(String proName){
        
        String proid=null;
        double qtyBags=0;
        try {
           
            ArrayList<ProductDTO> plist=ctrlProduct.getAll();
             
            for (ProductDTO productDTO : plist) {    
                if(proName.equals(productDTO.getProductName())){
                    proid=productDTO.getProid();
                    qtyBags=productDTO.getQtyBags();
                    
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(AddProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new Object[]{proid,qtyBags};
    }
    
    @FXML
    private void cmbProductOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        cmbLastPrice.getItems().clear();
        
        try {
            
            String batch=null;
            for (AddProductTableModel addProductTableModel : list) {
                if(!addProductTableModel.getBatch().equals("")){
                    
                   batch=addProductTableModel.getBatch();
                }
            }
            if(batch==null){
                txtBatch.setText(ctrlId.getNewId("batch_add", "baid","BA", 3));
            }else{
                char[] batchArr=batch.toCharArray();

                if(batchArr[2]=='0' && batchArr[3]=='0' && batchArr[4]=='0' && batchArr[5]=='9'){
                    txtBatch.setText("BA0010");

                }else if(batchArr[2]=='0' && batchArr[3]=='0' && batchArr[4]=='9' && batchArr[5]=='9'){
                    txtBatch.setText("BA0100");

                }else if(batchArr[2]=='0' && batchArr[3]=='9' && batchArr[4]=='9' && batchArr[5]=='9' && batchArr.length==6){
                    txtBatch.setText("BA1000");

                }else if(batchArr[2]=='9' && batchArr[3]=='9' && batchArr[4]=='9' && batchArr[5]=='9' && batchArr.length==6){
                    txtBatch.setText("BA10000");

                }else if(batchArr[2]=='9' && batchArr[3]=='9' && batchArr[4]=='9' && batchArr[5]=='9' && batchArr[6]=='9' && batchArr.length==7){
                    txtBatch.setText("BA100000");

                }else if(batchArr[2]=='9' && batchArr[3]=='9' && batchArr[4]=='9' && batchArr[5]=='9' && batchArr[6]=='9' && batchArr[7]=='9' && batchArr.length==8){
                    txtBatch.setText("BA1000000");

                }
                if(batchArr[2]=='0' && batchArr[3]=='0' && batchArr[4]=='0' &&  batchArr[5]<'9'){

                   int batchNo=Integer.parseInt(batchArr[5]+"")+1;
                   txtBatch.setText("BA000"+Integer.toString(batchNo));

                }else{
                    String batchNo="";
                    for(int i=2;i<batchArr.length;i++){
                        batchNo=batchNo+(batchArr[i]+"");
                    }
                    int nextNo=Integer.parseInt(batchNo)+1;

                    char[] num=Integer.toString(nextNo).toCharArray();
                    if(num.length==2){
                        System.out.println("BA00"+nextNo);
                        txtBatch.setText("BA00"+nextNo);
                    }else if(num.length==3){
                        System.out.println("BA0"+nextNo);
                        txtBatch.setText("BA0"+nextNo);
                    }else if(num.length>3){
                        System.out.println("BA"+nextNo);
                        txtBatch.setText("BA"+nextNo);
                    }
                }
            }
            
            String proName=cmbProName.getSelectionModel().getSelectedItem().toString();
            
            Object[] getCommons=getCommonThings(proName);
            
            String proid=(String)getCommons[0];
            int qtyBags=(int)(double)getCommons[1];
            
            int qty=0;
            for (AddProductTableModel addProductTableModel : list) {
                if(proName.equals(addProductTableModel.getProductName())){
                    qty+=addProductTableModel.getQty();
                    
                }
                
            }
            if(qty>0){
                txtTotalQty.setText(Integer.toString(qtyBags+qty));
            }else{
                txtTotalQty.setText(Integer.toString(qtyBags));
                
            }
            
            
            ArrayList<Batch_addDTO> blist=ctrlBatch_add.getAll();
            
            String unitprice=null;
            for (Batch_addDTO batch_addDTO : blist) {
                if(proid.equals(batch_addDTO.getProid())){
                   unitprice=df.format(batch_addDTO.getUnitPrice());
                   cmbLastPrice.getItems().add(unitprice);
                   
                }
            }
            cmbLastPrice.setValue(unitprice);
            
            lblProName.setVisible(true);
            lblProName.setText(proName);
            
            lblBags.setVisible(true);
            
            

        } catch (Exception ex) {
            //Logger.getLogger(AddProductController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    private void txtUnitPriceOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        
        try {
            
            String mfd=dtMfd.getValue().toString();
            String exp=dtExp.getValue().toString();
            
            if(cmbProName.getSelectionModel().getSelectedItem().toString().equals("") || mfd.equals("")||exp.equals("")||txtUnitPrice.getText().equals("")||txtQty.getText().equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You missed some fields.Check Again!");
                alert.showAndWait();
                
            }else{
                BigDecimal unitprice=new BigDecimal(dfd.format(df.parse(txtUnitPrice.getText())));
            
                String proName=cmbProName.getSelectionModel().getSelectedItem().toString();
                String batch=txtBatch.getText();

                for (AddProductTableModel tb : list) {
                    if(proName.equals(tb.getProductName()) && batch.equals(tb.getBatch())){

                        AddProductTableModel tbl=new AddProductTableModel();

                        int qty=tb.getQty();
                        String unitPrice=tb.getUnitPrice();
                        String dtMfd=tb.getMFD();
                        String dtExp=tb.getEXP();

                        list.remove(tb);

                        tbl.setBatch(batch);
                        tbl.setProductName(proName);
                        tbl.setMFD(dtMfd);
                        tbl.setEXP(dtExp);
                        tbl.setQty(qty+Integer.parseInt(txtQty.getText()));
                        tbl.setUnitPrice(unitPrice);

                        list.add(tbl);

                        tblAddPro.refresh();
                        clearAction();
                        cmbLastPrice.setValue("");
                        Platform.runLater(cmbProName::requestFocus);
                        return;
                    }
                }

                
                int qty=Integer.parseInt(txtQty.getText());
                BigDecimal unitPrice=new BigDecimal(dfd.format(df.parse(txtUnitPrice.getText())));

                AddProductTableModel tbl=new AddProductTableModel();

                tbl.setBatch(batch);
                tbl.setProductName(proName);
                tbl.setMFD(mfd);
                tbl.setEXP(exp);
                tbl.setQty(qty);
                tbl.setUnitPrice(df.format(unitPrice));

                list.add(tbl);
                tblAddPro.refresh();

                clearAction();
                Platform.runLater(cmbProName::requestFocus);
                cmbLastPrice.setValue("");
            }
            
        } catch (Exception ex) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed some fields.Check Again!");
            alert.showAndWait();
        }
    }
    @FXML
    private void txtUnitPriceOnKeyReleased(){
        try {
            String text=txtUnitPrice.getText();
            if(!ctrlValidation.setNumberFormat(text)){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You can type only Numbers!");
                alert.showAndWait();
                txtUnitPrice.setText("");
                
            }
        } catch (Exception ex) {
            Logger.getLogger(AddProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void cmbLastPriceOnAction(ActionEvent evt){
      
        try{
            String unitPrice=cmbLastPrice.getSelectionModel().getSelectedItem().toString();
            txtUnitPrice.setText(unitPrice);
        }catch(Exception ex){
            
        }
    }
    
    private  void clearAction(){
        
        lblBags.setVisible(false);
        lblProName.setVisible(false);
        
        LocalDate value=null;
        
        cmbProName.setValue("");
        cmbLastPrice.getItems().clear();
        cmbLastPrice.setValue("");
        txtBatch.setText("");
        txtTotalQty.setText("");
        txtQty.setText("");
        txtUnitPrice.setText("");
        dtMfd.setValue(value);
        dtExp.setValue(value);
        
    }
    @FXML
    private void cancelBtnOnAction(ActionEvent evt){
        
        AddProductTableModel tb=(AddProductTableModel) tblAddPro.getSelectionModel().getSelectedItem();
        
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please Select A Row!");
            alert.setContentText("You must select a row to Cancel");
            alert.setTitle("Cancel");
            alert.showAndWait();
        }else{
            clearAction();
            txtUnitPrice.setDisable(false);
            cmbLastPrice.setValue("");
        }
        
    }
    
    @FXML
    private void rowOnCliked(MouseEvent evt){
        
        try{
            AddProductTableModel tb=(AddProductTableModel) tblAddPro.getSelectionModel().getSelectedItem();

            String proName=tb.getProductName();

            Object[] getQty=getCommonThings(proName);

            cmbProName.setValue(tb.getProductName());
            txtBatch.setText(tb.getBatch());
            dtMfd.setValue(LocalDate.parse(tb.getMFD()));
            dtExp.setValue(LocalDate.parse(tb.getEXP()));
            txtQty.setText(Integer.toString(tb.getQty()));
            txtUnitPrice.setText(tb.getUnitPrice());
            txtTotalQty.setText(Double.toString(tb.getQty()+(double)getQty[1]));

            txtUnitPrice.setDisable(true);
        }catch(Exception ex){
            
        }
        
    }
    
    @FXML
    private void updateBtnOnAction(ActionEvent evt){
        
        AddProductTableModel tb=(AddProductTableModel) tblAddPro.getSelectionModel().getSelectedItem();
        
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please Select A Row!");
            alert.setContentText("Cause:Not Select A Row");
            alert.setTitle("Update");
            alert.showAndWait();
        }else{
            
            AddProductTableModel tbl=new AddProductTableModel();
            
            tbl.setProductName(cmbProName.getSelectionModel().getSelectedItem().toString());
            tbl.setBatch(txtBatch.getText());
            tbl.setMFD(dtMfd.getValue().toString());
            tbl.setEXP(dtExp.getValue().toString());
            tbl.setQty(Integer.parseInt(txtQty.getText()));
            tbl.setUnitPrice(txtUnitPrice.getText());
            
            list.remove(tb);
            list.add(tbl);
            tblAddPro.refresh();
            
            clearAction();
            cmbLastPrice.setValue("");
            txtUnitPrice.setDisable(false);
            
        }
        
    }
    
    @FXML
    private void removeBtnOnAction(ActionEvent evt){
        
        AddProductTableModel tb=(AddProductTableModel) tblAddPro.getSelectionModel().getSelectedItem();
        
        if(tb==null){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Please Select A Row!");
            alert.setContentText("Cause:Not Select A Row");
            alert.setTitle("Remove");
            alert.showAndWait();
        }else{
            undoList.add(tb);
            list.remove(tb);
            clearAction();
            tblAddPro.refresh();
            
            cmbLastPrice.setValue("");
            txtUnitPrice.setDisable(false);
            if(undoList.size()>0){
                btnUndo.setDisable(false);
            }
        }
    }
    
    @FXML
    private void undoBtnOnAction(ActionEvent evt){
        
        int count=0;
        AddProductTableModel tb=new AddProductTableModel();
        for (AddProductTableModel addProductTableModel : undoList) {
            tb.setBatch(addProductTableModel.getBatch());
            tb.setEXP(addProductTableModel.getEXP());
            tb.setProductName(addProductTableModel.getProductName());
            tb.setMFD(addProductTableModel.getMFD());
            tb.setQty(addProductTableModel.getQty());
            tb.setUnitPrice(addProductTableModel.getUnitPrice());
            count++;
        }
        list.add(tb);
        tblAddPro.refresh();
        undoList.remove(count-1);
        if(undoList.size()==0){
            btnUndo.setDisable(true);
        }
    }
    @FXML
    private void txtQtyKeyReleased(KeyEvent evt){
        
        try {
            String text=txtQty.getText();
            if(ctrlValidation.setNumberFormat(text)){
            
                String name=cmbProName.getSelectionModel().getSelectedItem().toString();
            
                Object[] ob=getCommonThings(name);

                FastAdding fc=new FastAdding(txtQty.getText(),(double)ob[1]);

                String[] texts=fc.getFinalCalculation();

                String proName=cmbProName.getSelectionModel().getSelectedItem().toString();

                Object[] getCommons=getCommonThings(proName);

                String proid=(String)getCommons[0];
                int qtyBags=(int)(double)getCommons[1];

                int qty=0;
                for (AddProductTableModel addProductTableModel : list) {
                    if(proName.equals(addProductTableModel.getProductName())){
                        qty+=addProductTableModel.getQty();

                    }
                }
                if(qty>0){
                    txtTotalQty.setText(Double.toString(Double.parseDouble(texts[1])+qty));
                }else{
                    txtTotalQty.setText(texts[0]);
                    txtTotalQty.setText(texts[1]);
                }
            }else{
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("You can type only numbers!");
                alert.showAndWait();
                txtQty.setText("");
            }
            
            
        } catch (Exception ex) {
          //  Logger.getLogger(AddProductionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    @FXML
    private void addBtnOnAction(ActionEvent evt){
        
        DecimalFormat df=new DecimalFormat("#,###.00");
        df.setMaximumFractionDigits(2);
        
        DecimalFormat dfd=new DecimalFormat("#");
        dfd.setMaximumFractionDigits(2);
        try{
            if(list.size()==0 || dtAdd.getValue().toString().equals("")){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You missed the data field or your table has not any data.Check Again!");
                alert.showAndWait();
            }else{

                ArrayList<ProductDTO> prolist=new ArrayList<>();
                ArrayList<Batch_addDTO> batchlist=new ArrayList<>();

                String addDate=dtAdd.getValue().toString();

                Date d=new Date();
                SimpleDateFormat dtf=new SimpleDateFormat("hh:mm:ss");
                String time=dtf.format(d);
                try {
                    for (AddProductTableModel tbl : list) {

                        String proName=tbl.getProductName();
                        String proid=null;

                        proid=ctrlProduct.getProid(proName);

                        ProductDTO pro=new ProductDTO(proid,proName,new BigDecimal(0),tbl.getQty());
                        prolist.add(pro);

                        Batch_addDTO badd=new Batch_addDTO(tbl.getBatch(),proid,tbl.getMFD(),tbl.getEXP(),tbl.getQty(),tbl.getQty(),new BigDecimal(dfd.format(df.parse(tbl.getUnitPrice()))),time,addDate);
                        batchlist.add(badd);
                    }

                    boolean b=ctrlProduct.addProductions(prolist, batchlist);
                    if(b){
                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setHeaderText("Productions Add Successfull!");
                        alert.setContentText("Stock was Updated");
                        alert.setTitle("Add Production");
                        alert.showAndWait();
                    }else{
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setHeaderText("Productions Add is not Successfull!");
                        alert.setContentText("Check about given infromations");
                        alert.setTitle("Add Production");
                        alert.showAndWait();
                    }

                    tblAddPro.getItems().clear();


                } catch (Exception ex) {
                    Logger.getLogger(AddProductionController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }catch(Exception ex){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed the data field or your table has not any data.Check Again!");
            alert.showAndWait();
        }
        

    }
    @FXML
    private void clearBtnOnAction(ActionEvent evt){
        
        if(list.size()==0){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("You always clear the interface");
            alert.showAndWait();
        }else{
            clearAction();
            tblAddPro.getItems().clear();
            tblAddPro.refresh();
        }
    }
    @FXML
    private void txtQtyOnAction(ActionEvent evt){
        
        txtUnitPrice.requestFocus();
    }
    @FXML
    private void dtExpOnAction(ActionEvent evt){
        txtQty.requestFocus();
    }

    private void setUIs() {

        thisPane.setOnKeyReleased(e->{
            switch(e.getCode()){
                
                case A:    try{

                                    AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/OrderProduction.fxml"));
                                    DashBoardController.rootPane.getChildren().setAll(contain);
                                }catch(IOException ex){

                                }
                                break; 
                                
                case B:    try{
                                    
                                    AnchorPane contain=FXMLLoader.load(getClass().getResource("/com/sas/kem/edu/ijse/view/CurrentProduction.fxml"));
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

    private void setToolTips() {

        btnNewPro.setTooltip(new Tooltip("You can add a new Production to your stock !"));
        btnRenamePro.setTooltip(new Tooltip("You can rename a prodution in your stock !"));
        btnCancel.setTooltip(new Tooltip("You can diselect a selected row in the table!"));
        btnRemove.setTooltip(new Tooltip("You can remove a row from table!"));
        btnUpdate.setTooltip(new Tooltip("You can update a row in the table!"));
        btnUndo.setTooltip(new Tooltip("You can get a removed row again into the table!"));
        btnClear.setTooltip(new Tooltip("You can clear the whole Interface!"));
        btnAdd.setTooltip(new Tooltip("You can add a new Productions to your stock!"));
    }
    
}
