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
public class ReceiveMatDateDTO extends SuperDTO {
    
    private double unitPrice;
    private String date;

    public ReceiveMatDateDTO() {
    }

    public ReceiveMatDateDTO(double unitPrice, String date) {
        this.unitPrice = unitPrice;
        this.date = date;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    
    
}
