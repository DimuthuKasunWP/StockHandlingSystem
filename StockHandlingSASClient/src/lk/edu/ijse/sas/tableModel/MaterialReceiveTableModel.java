/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.tableModel;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author dimuthu
 */
public class MaterialReceiveTableModel {
    
    private SimpleStringProperty Desc=new SimpleStringProperty("");
    private SimpleStringProperty Batch=new SimpleStringProperty("");
    private SimpleStringProperty Qty=new SimpleStringProperty("");
    private SimpleStringProperty UnitPrice=new SimpleStringProperty("");
    private SimpleStringProperty Total=new SimpleStringProperty("");
    private SimpleStringProperty Time=new SimpleStringProperty("");
    private SimpleStringProperty Date=new SimpleStringProperty("");

    public MaterialReceiveTableModel() {
    }
    
    public void setDesc(String Desc){
        this.Desc.set(Desc);
    }
    public String getDesc(){
        return Desc.get();
    }
    public void setBatch(String Batch){
        this.Batch.set(Batch);
    }
    public String getBatch(){
        return Batch.get();
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
    public void setTime(String Time){
        this.Time.set(Time);
    }
    public String getTime(){
        return Time.get();
    }
    public void setDate(String Date){
        this.Date.set(Date);
    }
    public String getDate(){
        return Date.get();
    }
}
