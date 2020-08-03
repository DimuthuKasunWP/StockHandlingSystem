/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author dimuthu
 */
@Entity
public class Purchase_Order_Detail {
   
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mid",referencedColumnName = "mid",updatable = false, insertable = false)
    private Material mid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pid",referencedColumnName = "pid",updatable = false, insertable = false)
    private Purchase_Order pid;
    private String unit;
    private double qty;
    private double unit_price;
    private double total;
    @EmbeddedId
    private Purchase_Order_Detail_PK purchase_Order_Detail_PK;

    public Purchase_Order_Detail() {
    }

    public Purchase_Order_Detail(Material mid, Purchase_Order pid, String unit, double qty, double unit_price, double total, Purchase_Order_Detail_PK purchase_Order_Detail_PK) {
        this.mid = mid;
        this.pid = pid;
        this.unit = unit;
        this.qty = qty;
        this.unit_price = unit_price;
        this.total = total;
        this.purchase_Order_Detail_PK = purchase_Order_Detail_PK;
    }

    public Purchase_Order getPid() {
        return pid;
    }

    public void setPid(Purchase_Order pid) {
        this.pid = pid;
    }

    public Purchase_Order_Detail_PK getPurchase_Order_Detail_PK() {
        return purchase_Order_Detail_PK;
    }

    public void setPurchase_Order_Detail_PK(Purchase_Order_Detail_PK purchase_Order_Detail_PK) {
        this.purchase_Order_Detail_PK = purchase_Order_Detail_PK;
    }

   

    public Material getMid() {
        return mid;
    }

    public void setMid(Material mid) {
        this.mid = mid;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Purchace_Order_Detail{" + "pid=" + pid + ", mid=" + mid + ", unit=" + unit + ", qty=" + qty + ", unit_price=" + unit_price + ", total=" + total + '}';
    }
    
}
