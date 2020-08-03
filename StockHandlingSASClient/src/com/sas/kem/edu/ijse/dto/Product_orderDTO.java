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
public class Product_orderDTO extends SuperDTO{
    
    private String oid;
    private String baid;
    private int pack;
    private BigDecimal qty;
    private BigDecimal unitPrice_1Bag;
    private BigDecimal total;

    public Product_orderDTO() {
    }

    public Product_orderDTO(String oid, String baid, int pack, BigDecimal qty, BigDecimal unitPrice_1Bag, BigDecimal total) {
        this.oid = oid;
        this.baid = baid;
        this.pack = pack;
        this.qty = qty;
        this.unitPrice_1Bag = unitPrice_1Bag;
        this.total = total;
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
     * @return the pack
     */
    public int getPack() {
        return pack;
    }

    /**
     * @param pack the pack to set
     */
    public void setPack(int pack) {
        this.pack = pack;
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
     * @return the unitPrice_1Bag
     */
    public BigDecimal getUnitPrice_1Bag() {
        return unitPrice_1Bag;
    }

    /**
     * @param unitPrice_1Bag the unitPrice_1Bag to set
     */
    public void setUnitPrice_1Bag(BigDecimal unitPrice_1Bag) {
        this.unitPrice_1Bag = unitPrice_1Bag;
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
