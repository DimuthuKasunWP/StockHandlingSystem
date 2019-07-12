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
public class MaterialDTO extends SuperDTO{
    
    private String mid;
    private String materialName;
    private BigDecimal amount_kg;

    public MaterialDTO() {
    }

    public MaterialDTO(String mid, String materialName, BigDecimal amount_kg) {
        this.mid = mid;
        this.materialName = materialName;
        this.amount_kg = amount_kg;
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
     * @return the materialName
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     * @param materialName the materialName to set
     */
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    /**
     * @return the amount_kg
     */
    public BigDecimal getAmount_kg() {
        return amount_kg;
    }

    /**
     * @param amount_kg the amount_kg to set
     */
    public void setAmount_kg(BigDecimal amount_kg) {
        this.amount_kg = amount_kg;
    }

       
}
