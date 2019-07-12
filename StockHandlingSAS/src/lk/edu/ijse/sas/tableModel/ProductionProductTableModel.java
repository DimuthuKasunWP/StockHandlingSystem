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
public class ProductionProductTableModel {
    
    private SimpleStringProperty Desc=new SimpleStringProperty("");
    private SimpleIntegerProperty Qty=new SimpleIntegerProperty(0);
    private SimpleStringProperty Time=new SimpleStringProperty("");
    private SimpleStringProperty Date=new SimpleStringProperty("");

    public ProductionProductTableModel() {
    }
    
    public void setDesc(String Desc){
        
        this.Desc.set(Desc);
    }
    public String getDesc(){
        
        return Desc.get();
    }
    public void setQty(int Qty){
        
        this.Qty.set(Qty);
    }
    public int getQty(){
        
        return Qty.get();
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
