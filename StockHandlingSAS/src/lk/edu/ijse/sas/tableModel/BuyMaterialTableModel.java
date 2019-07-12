/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.tableModel;

import java.math.BigDecimal;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author dimuthu
 */
public class BuyMaterialTableModel {
    
    private SimpleStringProperty MatName=new SimpleStringProperty("");
    private SimpleStringProperty Batch=new SimpleStringProperty("");
    private SimpleStringProperty Mfd=new SimpleStringProperty("");
    private SimpleStringProperty Exp=new SimpleStringProperty("");
    private SimpleStringProperty Qty=new SimpleStringProperty("");
    private SimpleStringProperty UnitPrice=new SimpleStringProperty("");
    private SimpleStringProperty Total=new SimpleStringProperty("");

    public BuyMaterialTableModel() {
    }
    
    public void setMatName(String MatName){
        this.MatName.set(MatName);
    }
    public String getMatName(){
        return MatName.get();
    }
    public void setBatch(String Batch){
        this.Batch.set(Batch);
    }
    public String getBatch(){
        return Batch.get();
    }
    public void setMfd(String Mfd){
        this.Mfd.set(Mfd);
    }
    public String getMfd(){
        return Mfd.get();
    }
    public void setExp(String Exp){
        this.Exp.set(Exp);
    }
    public String getExp(){
        return Exp.get();
    }
    public void setQty(String Qty){
        this.Qty.set(Qty);
    }
    public String getQty(){
        return Qty.get();
    }
    public void setUnitPrice(String UnitPrice){
        this.UnitPrice.set(UnitPrice);
    }
    public String getUnitPrice(){
        return UnitPrice.get();
    }
    public void setTotal(String Total){
        this.Total.set(Total);
    }
    public String getTotal(){
        return Total.get();
    }
    
    
}
