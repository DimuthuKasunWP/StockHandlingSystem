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
public class RejectMaterialTableModel {
    
    private SimpleStringProperty MatName=new SimpleStringProperty("");
    private SimpleStringProperty Batch=new SimpleStringProperty("");
    private SimpleStringProperty Quantity=new SimpleStringProperty("");
    private SimpleStringProperty Cause=new SimpleStringProperty("");
    
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
    public void setQuantity(String Quantity){
        this.Quantity.set(Quantity);
    }
    public String getQuantity(){
        return Quantity.get();
    }
    public void setCause(String Cause){
        this.Cause.set(Cause);
    }
    public String getCause(){
        return Cause.get();
    }
}
