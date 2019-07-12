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
public class CurrentProTableModel {
    
    private SimpleStringProperty ProName=new SimpleStringProperty("");
    private SimpleStringProperty Batch=new SimpleStringProperty("");
    private SimpleIntegerProperty ProQty=new SimpleIntegerProperty(0);
    private SimpleIntegerProperty CurQty=new SimpleIntegerProperty(0);

    public CurrentProTableModel() {
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
    public void setProQty(int ProQty){
        
        this.ProQty.set(ProQty);
    }
    public int getProQty(){
        return ProQty.get();
    }
    public void setCurQty(int CurQty){
        
        this.CurQty.set(CurQty);
    }
    public int getCurQty(){
        return CurQty.get();
    }
    
}
