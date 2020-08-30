/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dto;

import java.math.BigDecimal;

/**
 *
 * @author dimuthu
 */
public class Batch_receiveDTO extends SuperDTO{
    
    private String brid;
    private String grid;
    private String mid;
    private String mfd;
    private String exp;
    private BigDecimal received_qty_kg;
    private BigDecimal current_qty_kg;
    private BigDecimal unitPrice_1kg;
    private BigDecimal total;

    public Batch_receiveDTO() {
    }

    public Batch_receiveDTO(String brid, String grid, String mid, String mfd, String exp, BigDecimal received_qty_kg, BigDecimal current_qty_kg, BigDecimal unitPrice_1kg, BigDecimal total) {
        this.brid = brid;
        this.grid = grid;
        this.mid = mid;
        this.mfd = mfd;
        this.exp = exp;
        this.received_qty_kg = received_qty_kg;
        this.current_qty_kg = current_qty_kg;
        this.unitPrice_1kg = unitPrice_1kg;
        this.total = total;
    }

    /**
     * @return the brid
     */
    public String getBrid() {
        return brid;
    }

    /**
     * @param brid the brid to set
     */
    public void setBrid(String brid) {
        this.brid = brid;
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
     * @return the received_qty_kg
     */
    public BigDecimal getReceived_qty_kg() {
        return received_qty_kg;
    }

    /**
     * @param received_qty_kg the received_qty_kg to set
     */
    public void setReceived_qty_kg(BigDecimal received_qty_kg) {
        this.received_qty_kg = received_qty_kg;
    }

    /**
     * @return the current_qty_kg
     */
    public BigDecimal getCurrent_qty_kg() {
        return current_qty_kg;
    }

    /**
     * @param current_qty_kg the current_qty_kg to set
     */
    public void setCurrent_qty_kg(BigDecimal current_qty_kg) {
        this.current_qty_kg = current_qty_kg;
    }

    /**
     * @return the unitPrice_1kg
     */
    public BigDecimal getUnitPrice_1kg() {
        return unitPrice_1kg;
    }

    /**
     * @param unitPrice_1kg the unitPrice_1kg to set
     */
    public void setUnitPrice_1kg(BigDecimal unitPrice_1kg) {
        this.unitPrice_1kg = unitPrice_1kg;
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
