/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author dimuthu
 */
@Entity
public class Purchase_Order {
    @Id
    private String pid;
    @ManyToOne(cascade = CascadeType.ALL)
    private Company cid;
    private double goodsAmount;
    private double vat;
    private double svat;
    private double discount;
    private double grand_total;
    private String create_date;
    private String confirm_date;

    public Purchase_Order(String pid, Company cid, double goodsAmount, double vat, double svat, double discount, double grand_total, String create_date, String confirm_date) {
        this.pid = pid;
        this.cid = cid;
        this.goodsAmount = goodsAmount;
        this.vat = vat;
        this.svat = svat;
        this.discount = discount;
        this.grand_total = grand_total;
        this.create_date = create_date;
        this.confirm_date = confirm_date;
    }

    public Purchase_Order() {
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Company getCid() {
        return cid;
    }

    public void setCid(Company cid) {
        this.cid = cid;
    }

    public double getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(double goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public double getVat() {
        return vat;
    }

    public void setVat(double vat) {
        this.vat = vat;
    }

    public double getSvat() {
        return svat;
    }

    public void setSvat(double svat) {
        this.svat = svat;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getGrand_total() {
        return grand_total;
    }

    public void setGrand_total(double grand_total) {
        this.grand_total = grand_total;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getConfirm_date() {
        return confirm_date;
    }

    public void setConfirm_date(String confirm_date) {
        this.confirm_date = confirm_date;
    }

    @Override
    public String toString() {
        return "Purchase_Order{" + "pid=" + pid + ", cid=" + cid + ", goodsAmount=" + goodsAmount + ", vat=" + vat + ", svat=" + svat + ", discount=" + discount + ", grand_total=" + grand_total + ", create_date=" + create_date + ", confirm_date=" + confirm_date + '}';
    }
    
           
}
