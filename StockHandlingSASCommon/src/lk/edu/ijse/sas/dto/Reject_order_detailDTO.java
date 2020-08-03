/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.dto;

/**
 *
 * @author dimuthu
 */
public class Reject_order_detailDTO extends SuperDTO{
    
    private String rjid;
    private String baid;
    private String oid;
    private int qty;

    public Reject_order_detailDTO() {
    }

    public Reject_order_detailDTO(String rjid, String baid, String oid, int qty) {
        this.rjid = rjid;
        this.baid = baid;
        this.oid = oid;
        this.qty = qty;
    }

    /**
     * @return the rjid
     */
    public String getRjid() {
        return rjid;
    }

    /**
     * @param rjid the rjid to set
     */
    public void setRjid(String rjid) {
        this.rjid = rjid;
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
