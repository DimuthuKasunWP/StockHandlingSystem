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
public class Reject_orderDTO extends SuperDTO{
    
   private String rjid;
   private int reject_amount;
   private String rejectDate;

    public Reject_orderDTO() {
    }

    public Reject_orderDTO(String rjid, int reject_amount, String rejectDate) {
        this.rjid = rjid;
        this.reject_amount = reject_amount;
        this.rejectDate = rejectDate;
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
     * @return the reject_amount
     */
    public int getReject_amount() {
        return reject_amount;
    }

    /**
     * @param reject_amount the reject_amount to set
     */
    public void setReject_amount(int reject_amount) {
        this.reject_amount = reject_amount;
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
