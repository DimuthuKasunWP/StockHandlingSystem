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
public class Purchase_orderDTO extends SuperDTO{
    
    private String pid;
    private String cid;
    private int goodsAmount;
    private double vat;
    private double svat;
    private double discount;
    private double grandTotal;
    private String create_date;
    private String confirm_date;

    public Purchase_orderDTO() {
    }

    public Purchase_orderDTO(String pid, String cid, int goodsAmount, double vat, double svat, double discount, double grandTotal, String create_date, String confirm_date) {
        this.pid = pid;
        this.cid = cid;
        this.goodsAmount = goodsAmount;
        this.vat = vat;
        this.svat = svat;
        this.discount = discount;
        this.grandTotal = grandTotal;
        this.create_date = create_date;
        this.confirm_date = confirm_date;
    }

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * @return the goodsAmount
     */
    public int getGoodsAmount() {
        return goodsAmount;
    }

    /**
     * @param goodsAmount the goodsAmount to set
     */
    public void setGoodsAmount(int goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    /**
     * @return the vat
     */
    public double getVat() {
        return vat;
    }

    /**
     * @param vat the vat to set
     */
    public void setVat(double vat) {
        this.vat = vat;
    }

    /**
     * @return the svat
     */
    public double getSvat() {
        return svat;
    }

    /**
     * @param svat the svat to set
     */
    public void setSvat(double svat) {
        this.svat = svat;
    }

    /**
     * @return the discount
     */
    public double getDiscount() {
        return discount;
    }

    /**
     * @param discount the discount to set
     */
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * @return the grandTotal
     */
    public double getGrandTotal() {
        return grandTotal;
    }

    /**
     * @param grandTotal the grandTotal to set
     */
    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    /**
     * @return the create_date
     */
    public String getCreate_date() {
        return create_date;
    }

    /**
     * @param create_date the create_date to set
     */
    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    /**
     * @return the confirm_date
     */
    public String getConfirm_date() {
        return confirm_date;
    }

    /**
     * @param confirm_date the confirm_date to set
     */
    public void setConfirm_date(String confirm_date) {
        this.confirm_date = confirm_date;
    }

    
}
