/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.entity;

/**
 *
 * @author dimuthu
 */
public class BatchPro {
     private String baid;
    private String proid;
    private int product_qty;
    private int current_qty;

    public BatchPro() {
    }

    public BatchPro(String baid, String proid, int product_qty, int current_qty) {
        this.baid = baid;
        this.proid = proid;
        this.product_qty = product_qty;
        this.current_qty = current_qty;
    }

    /**
     * @return the baid
     */
    public String getBaid() {
        return baid;
    }

    /**
     * @param baid the baid to set
     */
    public void setBaid(String baid) {
        this.baid = baid;
    }

    /**
     * @return the proid
     */
    public String getProid() {
        return proid;
    }

    /**
     * @param proid the proid to set
     */
    public void setProid(String proid) {
        this.proid = proid;
    }

    /**
     * @return the product_qty
     */
    public int getProduct_qty() {
        return product_qty;
    }

    /**
     * @param product_qty the product_qty to set
     */
    public void setProduct_qty(int product_qty) {
        this.product_qty = product_qty;
    }

    /**
     * @return the current_qty
     */
    public int getCurrent_qty() {
        return current_qty;
    }

    /**
     * @param current_qty the current_qty to set
     */
    public void setCurrent_qty(int current_qty) {
        this.current_qty = current_qty;
    }

}
