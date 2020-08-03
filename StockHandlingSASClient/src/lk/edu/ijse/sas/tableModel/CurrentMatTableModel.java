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
public class CurrentMatTableModel {
    
    private SimpleStringProperty MatName=new SimpleStringProperty("");
    private SimpleStringProperty Qty=new SimpleStringProperty("");

    public CurrentMatTableModel() {
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
    
}
