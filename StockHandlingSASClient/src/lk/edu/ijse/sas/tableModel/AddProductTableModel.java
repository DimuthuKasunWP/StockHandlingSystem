/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.tableModel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author dimuthu
 */
public class AddProductTableModel {
    
    private SimpleStringProperty ProductName=new SimpleStringProperty("");
    private SimpleStringProperty Batch=new SimpleStringProperty("");
    private SimpleStringProperty MFD=new SimpleStringProperty("");
    private SimpleStringProperty EXP=new SimpleStringProperty("");
    private SimpleIntegerProperty Qty=new SimpleIntegerProperty(0);
    private SimpleStringProperty UnitPrice=new SimpleStringProperty("");

    public AddProductTableModel() {
    }
    
    public void setProductName(String ProductName){
        this.ProductName.set(ProductName);
    }
    
    public String getProductName(){
        return ProductName.get();
    }
    
    public void setBatch(String Batch){
        this.Batch.set(Batch);
    }
    
    public String getBatch(){
        return Batch.get();
    }
    
    public void setMFD(String MFD){
        this.MFD.set(MFD);
    }
    
    public String getMFD(){
        return MFD.get();
    }
    
    public void setEXP(String EXP){
        this.EXP.set(EXP);
    }
    
    public String getEXP(){
        return EXP.get();
    }
    
    public void setQty(int Qty){
        this.Qty.set(Qty);
    }
    
    public int getQty(){
        return Qty.get();
    }
    
    public void setUnitPrice(String UnitPrice){
        this.UnitPrice.set(UnitPrice);
    }
    
    public String getUnitPrice(){
        return UnitPrice.get();
    }

    
}
