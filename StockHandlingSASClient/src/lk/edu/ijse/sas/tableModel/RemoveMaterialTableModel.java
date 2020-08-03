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
public class RemoveMaterialTableModel {
    
    private SimpleStringProperty MatName=new SimpleStringProperty("");
    private SimpleStringProperty Qty=new SimpleStringProperty("");
    private SimpleStringProperty Time=new SimpleStringProperty("");
    private SimpleStringProperty SecName=new SimpleStringProperty("");
    private SimpleStringProperty Batch=new SimpleStringProperty("");
    
    public RemoveMaterialTableModel() {
    }
    
    public void setMatName(String MatName){
        
        this.MatName.set(MatName);
    }
    public String getMatName(){
        
        return MatName.get();
    }
    public void setQty(String Qty){
        
        this.Qty.set(Qty);
    }
    public String getQty(){
        
        return Qty.get();
    }
    public void setTime(String Time){
        
        this.Time.set(Time);
    }
    public String getTime(){
        
        return Time.get();
    }
    public void setSecName(String SecName){
        
        this.SecName.set(SecName);
    }
    public String getSecName(){
        
        return SecName.get();
    }
    public void setBatch(String Batch){
        
        this.Batch.set(Batch);
    }
    public String getBatch(){
        
        return Batch.get();
    }
}
