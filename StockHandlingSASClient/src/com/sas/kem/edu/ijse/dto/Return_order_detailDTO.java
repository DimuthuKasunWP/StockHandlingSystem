/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dto;

/**
 *
 * @author Vidura
 */
public class Return_order_detailDTO extends SuperDTO{
    
    private String rnid;
    private String baid;
    private String oid;
    private int qty;

    public Return_order_detailDTO() {
    }

    public Return_order_detailDTO(String rnid, String baid, String oid, int qty) {
        this.rnid = rnid;
        this.baid = baid;
        this.oid = oid;
        this.qty = qty;
    }

    /**
     * @return the rnid
     */
    public String getRnid() {
        return rnid;
    }

    /**
     * @param rnid the rnid to set
     */
    public void setRnid(String rnid) {
        this.rnid = rnid;
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
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    
}
