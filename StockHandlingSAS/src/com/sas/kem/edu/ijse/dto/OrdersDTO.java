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
public class OrdersDTO extends SuperDTO{
    
    private String oid;
    private String cid;
    private String po;
    private BigDecimal total;
    private String orderDate;

    public OrdersDTO() {
    }

    public OrdersDTO(String oid, String cid, String po, BigDecimal total, String orderDate) {
        this.oid = oid;
        this.cid = cid;
        this.po = po;
        this.total = total;
        this.orderDate = orderDate;
    }

    /**
     * @return the oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOid(String oid) {
        this.oid = oid;
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
     * @return the po
     */
    public String getPo() {
        return po;
    }

    /**
     * @param po the po to set
     */
    public void setPo(String po) {
        this.po = po;
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

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    
}
