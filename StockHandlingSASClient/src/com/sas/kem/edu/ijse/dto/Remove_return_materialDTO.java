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
public class Remove_return_materialDTO extends SuperDTO{
    
    private String mid;
    private String rbrid;
    private BigDecimal qty_kg;
    private String remove_date;
    private String remove_time;
    private String carry_sector_name;

    public Remove_return_materialDTO() {
    }

    public Remove_return_materialDTO(String mid, String rbrid, BigDecimal qty_kg, String remove_date, String remove_time, String carry_sector_name) {
        this.mid = mid;
        this.rbrid = rbrid;
        this.qty_kg = qty_kg;
        this.remove_date = remove_date;
        this.remove_time = remove_time;
        this.carry_sector_name = carry_sector_name;
    }

    /**
     * @return the mid
     */
    public String getMid() {
        return mid;
    }

    /**
     * @param mid the mid to set
     */
    public void setMid(String mid) {
        this.mid = mid;
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
     * @return the qty_kg
     */
    public BigDecimal getQty_kg() {
        return qty_kg;
    }

    /**
     * @param qty_kg the qty_kg to set
     */
    public void setQty_kg(BigDecimal qty_kg) {
        this.qty_kg = qty_kg;
    }

    /**
     * @return the remove_date
     */
    public String getRemove_date() {
        return remove_date;
    }

    /**
     * @param remove_date the remove_date to set
     */
    public void setRemove_date(String remove_date) {
        this.remove_date = remove_date;
    }

    /**
     * @return the remove_time
     */
    public String getRemove_time() {
        return remove_time;
    }

    /**
     * @param remove_time the remove_time to set
     */
    public void setRemove_time(String remove_time) {
        this.remove_time = remove_time;
    }

    /**
     * @return the carry_sector_name
     */
    public String getCarry_sector_name() {
        return carry_sector_name;
    }

    /**
     * @param carry_sector_name the carry_sector_name to set
     */
    public void setCarry_sector_name(String carry_sector_name) {
        this.carry_sector_name = carry_sector_name;
    }
    
    
    
}
