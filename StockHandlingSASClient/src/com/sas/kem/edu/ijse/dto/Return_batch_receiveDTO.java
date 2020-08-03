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
public class Return_batch_receiveDTO extends SuperDTO{
    
    private String rbrid;
    private String grid;
    private String mid;
    private String mfd;
    private String exp;
    private BigDecimal returned_qty;
    private BigDecimal current_qty;
    private BigDecimal unitPrice;
    private BigDecimal total;

    public Return_batch_receiveDTO() {
    }

    public Return_batch_receiveDTO(String rbrid, String grid, String mid, String mfd, String exp, BigDecimal returned_qty, BigDecimal current_qty, BigDecimal unitPrice, BigDecimal total) {
        this.rbrid = rbrid;
        this.grid = grid;
        this.mid = mid;
        this.mfd = mfd;
        this.exp = exp;
        this.returned_qty = returned_qty;
        this.current_qty = current_qty;
        this.unitPrice = unitPrice;
        this.total = total;
    }

    /**
     * @return the rbrid
     */
    public String getRbrid() {
        return rbrid;
    }

    /**
     * @param rbrid the rbrid to set
     */
    public void setRbrid(String rbrid) {
        this.rbrid = rbrid;
    }

    /**
     * @return the grid
     */
    public String getGrid() {
        return grid;
    }

    /**
     * @param grid the grid to set
     */
    public void setGrid(String grid) {
        this.grid = grid;
    }

    /**
     * @return the mid
     */
    public String getMid() {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(String mid) {
        this.mid = mid;
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
     * @return the returned_qty
     */
    public BigDecimal getReturned_qty() {
        return returned_qty;
    }

    /**
     * @param returned_qty the returned_qty to set
     */
    public void setReturned_qty(BigDecimal returned_qty) {
        this.returned_qty = returned_qty;
    }

    /**
     * @return the current_qty
     */
    public BigDecimal getCurrent_qty() {
        return current_qty;
    }

    /**
     * @param current_qty the current_qty to set
     */
    public void setCurrent_qty(BigDecimal current_qty) {
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
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    
}
