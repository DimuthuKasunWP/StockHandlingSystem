/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.dto;

import java.math.BigDecimal;

/**
 *
 * @author dimuthu
 */
public class Reject_return_receiveDTO extends SuperDTO{
    
    private String rbrid;
    private BigDecimal qty;
    private String cause;
    private String reject_date;

    public Reject_return_receiveDTO() {
    }

    public Reject_return_receiveDTO(String rbrid, BigDecimal qty, String cause, String reject_date) {
        this.rbrid = rbrid;
        this.qty = qty;
        this.cause = cause;
        this.reject_date = reject_date;
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
     * @return the reject_date
     */
    public String getReject_date() {
        return reject_date;
    }

    /**
     * @param reject_date the reject_date to set
     */
    public void setReject_date(String reject_date) {
        this.reject_date = reject_date;
    }

    
    
}
