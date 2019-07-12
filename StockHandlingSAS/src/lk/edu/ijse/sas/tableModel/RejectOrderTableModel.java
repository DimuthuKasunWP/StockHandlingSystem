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
public class RejectOrderTableModel {
    
    private SimpleStringProperty ProName=new SimpleStringProperty("");
    private SimpleStringProperty Batch=new SimpleStringProperty("");
    private SimpleStringProperty Mfd=new SimpleStringProperty("");
    private SimpleStringProperty Exp=new SimpleStringProperty("");
    private SimpleIntegerProperty Qty=new SimpleIntegerProperty(0);
    
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
    public void setQty(int Qty){
        this.Qty.set(Qty);
    }
    public int getQty(){
        return Qty.get();
    }
    
}
