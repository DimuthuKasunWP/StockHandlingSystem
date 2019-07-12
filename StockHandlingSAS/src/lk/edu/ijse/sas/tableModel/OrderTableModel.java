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
public class OrderTableModel {
    
    private SimpleStringProperty ProName=new SimpleStringProperty("");
    private SimpleStringProperty Batch=new SimpleStringProperty("");
    private SimpleIntegerProperty Pack=new SimpleIntegerProperty(0);
    private SimpleStringProperty UnitPrice=new SimpleStringProperty("");
    private SimpleStringProperty Total=new SimpleStringProperty("");

    public OrderTableModel() {
    }
    
    public void setProName(String ProName){
        this.ProName.set(ProName);
    }
    public String getProName(){
        return ProName.get();
    }
    public void setBatch(String Batch){
        this.Batch.set(Batch);
    }
    public String getBatch(){
        return Batch.get();
    }
    public void setPack(int Pack){
        this.Pack.set(Pack);
    }
    public int getPack(){
        return Pack.get();
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
