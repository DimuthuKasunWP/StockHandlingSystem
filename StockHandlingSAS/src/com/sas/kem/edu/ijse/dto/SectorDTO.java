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
public class SectorDTO extends SuperDTO{
    
    private String secName;

    public SectorDTO() {
    }

    public SectorDTO(String secName) {
        this.secName = secName;
    }

    /**
     * @return the secName
     */
    public String getSecName() {
        return secName;
    }

    /**
     * @param secName the secName to set
     */
    public void setSecName(String secName) {
        this.secName = secName;
    }
    
    
    
}
