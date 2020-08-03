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
public class GrnDTO extends SuperDTO{
    
    private String grid;
    private String cid;
    private String pid;
    private int goodAmount;
    private String addTime;
    private String grnDate;
    private BigDecimal grandTotal;

    public GrnDTO() {
    }

    public GrnDTO(String grid, String cid, String pid, int goodAmount, String addTime, String grnDate, BigDecimal grandTotal) {
        this.grid = grid;
        this.cid = cid;
        this.pid = pid;
        this.goodAmount = goodAmount;
        this.addTime = addTime;
        this.grnDate = grnDate;
        this.grandTotal = grandTotal;
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
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the goodAmount
     */
    public int getGoodAmount() {
        return goodAmount;
    }

    /**
     * @param goodAmount the goodAmount to set
     */
    public void setGoodAmount(int goodAmount) {
        this.goodAmount = goodAmount;
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
     * @return the grnDate
     */
    public String getGrnDate() {
        return grnDate;
    }

    /**
     * @param grnDate the grnDate to set
     */
    public void setGrnDate(String grnDate) {
        this.grnDate = grnDate;
    }

    /**
     * @return the grandTotal
     */
    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    /**
     * @param grandTotal the grandTotal to set
     */
    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    
}
