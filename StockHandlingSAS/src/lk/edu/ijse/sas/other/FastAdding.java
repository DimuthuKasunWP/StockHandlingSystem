/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.other;

/**
 *
 * @author dimuthu
 */
public class FastAdding {
    
    private double stock_qty;
    private String txt_qty;

    public FastAdding() {
    }

    public FastAdding(String txt_qty,double stock_qty ) {
        this.stock_qty = stock_qty;
        this.txt_qty = txt_qty;
    }

    /**
     * @return the stock_qty
     */
    public double getStock_qty() {
        return stock_qty;
    }

    /**
     * @param stock_qty the stock_qty to set
     */
    public void setStock_qty(double stock_qty) {
        this.stock_qty = stock_qty;
    }

    /**
     * @return the txt_qty
     */
    public String getTxt_qty() {
        return txt_qty;
    }

    /**
     * @param txt_qty the txt_qty to set
     */
    public void setTxt_qty(String txt_qty) {
        this.txt_qty = txt_qty;
    }
    
    public String[] getFinalCalculation(){
        
        double value=0;
        if(getTxt_qty().equals("")){
            value=0;
        }else{
            value=Double.parseDouble(getTxt_qty());
        }

         return new String[]{" ",Double.toString(value+getStock_qty())};

       
    }
}
