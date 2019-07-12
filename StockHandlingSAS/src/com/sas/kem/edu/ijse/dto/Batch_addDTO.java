/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dto;

import java.math.BigDecimal;

/**
 *
 * @author Vidura
 */
public class Batch_addDTO extends SuperDTO{
    
    private String baid;
    private String proid;
    private String mfd;
    private String exp;
    private int product_qty;
    private int current_qty;
    private BigDecimal unitPrice;
    private String addTime;
    private String addDate;

    public Batch_addDTO() {
    }

    public Batch_addDTO(String baid, String proid, String mfd, String exp, int product_qty, int current_qty, BigDecimal unitPrice, String addTime, String addDate) {
        this.baid = baid;
        this.proid = proid;
        this.mfd = mfd;
        this.exp = exp;
        this.product_qty = product_qty;
        this.current_qty = current_qty;
        this.unitPrice = unitPrice;
        this.addTime = addTime;
        this.addDate = addDate;
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
     * @return the mfd
     */
    public String getMfd() {
        return mfd;
    }

    /**
     * @param mfd the mfd to set
     */
    public void setMfd(String mfd) {
        this.mfd = mfd;
    }

    /**
     * @return the exp
     */
    public String getExp() {
        return exp;
    }

    /**
     * @param exp the exp to set
     */
    public void setExp(String exp) {
        this.exp = exp;
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

    /**
     * @return the unitPrice
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the addTime
     */
    public String getAddTime() {
        return addTime;
    }

    /**
     * @param addTime the addTime to set
     */
    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    /**
     * @return the addDate
     */
    public String getAddDate() {
        return addDate;
    }

    /**
     * @param addDate the addDate to set
     */
    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    
}
