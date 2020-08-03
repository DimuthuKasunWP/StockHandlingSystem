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
public class Return_orderDTO extends SuperDTO{
    
    private String rnid;
    private int returned_amount;
    private String returnDate;

    public Return_orderDTO() {
    }

    public Return_orderDTO(String rnid, int returned_amount, String returnDate) {
        this.rnid = rnid;
        this.returned_amount = returned_amount;
        this.returnDate = returnDate;
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
     * @return the returned_amount
     */
    public int getReturned_amount() {
        return returned_amount;
    }

    /**
     * @param returned_amount the returned_amount to set
     */
    public void setReturned_amount(int returned_amount) {
        this.returned_amount = returned_amount;
    }

    /**
     * @return the returnDate
     */
    public String getReturnDate() {
        return returnDate;
    }

    /**
     * @param returnDate the returnDate to set
     */
    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    
}
