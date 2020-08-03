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
public class Reject_receiveDTO extends SuperDTO{
    
    private String brid;
    private BigDecimal qty;
    private String cause;
    private String rejectDate;

    public Reject_receiveDTO() {
    }

    public Reject_receiveDTO(String brid, BigDecimal qty, String cause, String rejectDate) {
        this.brid = brid;
        this.qty = qty;
        this.cause = cause;
        this.rejectDate = rejectDate;
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
     * @return the qty
     */
    public BigDecimal getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    /**
     * @return the cause
     */
    public String getCause() {
        return cause;
    }

    /**
     * @param cause the cause to set
     */
    public void setCause(String cause) {
        this.cause = cause;
    }

    /**
     * @return the rejectDate
     */
    public String getRejectDate() {
        return rejectDate;
    }

    /**
     * @param rejectDate the rejectDate to set
     */
    public void setRejectDate(String rejectDate) {
        this.rejectDate = rejectDate;
    }

    
}
