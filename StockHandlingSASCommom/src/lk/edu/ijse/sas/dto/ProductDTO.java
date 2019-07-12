/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.dto;

import java.math.BigDecimal;

/**
 *
 * @author dimuthu
 */
public class ProductDTO extends SuperDTO{
    
    private String proid;
    private String productName;
    private BigDecimal bagSize_kg;
    private int qtyBags;

    public ProductDTO() {
    }

    public ProductDTO(String proid, String productName, BigDecimal bagSize_kg, int qtyBags) {
        this.proid = proid;
        this.productName = productName;
        this.bagSize_kg = bagSize_kg;
        this.qtyBags = qtyBags;
    }

    /**
     * @return the proid
     */
    public String getProid() {
        return proid;
    }

    /**
     * @param proid the proid to set
     */
    public void setProid(String proid) {
        this.proid = proid;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the bagSize_kg
     */
    public BigDecimal getBagSize_kg() {
        return bagSize_kg;
    }

    /**
     * @param bagSize_kg the bagSize_kg to set
     */
    public void setBagSize_kg(BigDecimal bagSize_kg) {
        this.bagSize_kg = bagSize_kg;
    }

    /**
     * @return the qtyBags
     */
    public int getQtyBags() {
        return qtyBags;
    }

    /**
     * @param qtyBags the qtyBags to set
     */
    public void setQtyBags(int qtyBags) {
        this.qtyBags = qtyBags;
    }

    
}
