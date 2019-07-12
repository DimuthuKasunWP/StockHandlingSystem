/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author dimuthu
 */
@Entity
public class Product_Order {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "oid",referencedColumnName = "oid",updatable = false, insertable = false)
    private Orders oid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "baid",referencedColumnName = "baid",updatable = false, insertable = false)
    private Batch_Add baid;
    private int packages;
    private double qty_kg;
    private double unit_price_1bag;
    private double total;
    @EmbeddedId Product_Order_PK product_Order_PK;

    public Product_Order(Orders oid, Batch_Add baid, int packages, double qty_kg, double unit_price_1bag, double total, Product_Order_PK product_Order_PK) {
        this.oid = oid;
        this.baid = baid;
        this.packages = packages;
        this.qty_kg = qty_kg;
        this.unit_price_1bag = unit_price_1bag;
        this.total = total;
        this.product_Order_PK = product_Order_PK;
    }

    public Product_Order_PK getProduct_Order_PK() {
        return product_Order_PK;
    }

    public void setProduct_Order_PK(Product_Order_PK product_Order_PK) {
        this.product_Order_PK = product_Order_PK;
    }

   

    public Orders getOid() {
        return oid;
    }

    public void setOid(Orders oid) {
        this.oid = oid;
    }

    public Batch_Add getBaid() {
        return baid;
    }

    public void setBaid(Batch_Add baid) {
        this.baid = baid;
    }

    public int getPackages() {
        return packages;
    }

    public void setPackages(int packages) {
        this.packages = packages;
    }

    public double getQty_kg() {
        return qty_kg;
    }

    public void setQty_kg(double qty_kg) {
        this.qty_kg = qty_kg;
    }

    public double getUnit_price_1bag() {
        return unit_price_1bag;
    }

    public void setUnit_price_1bag(double unit_price_1bag) {
        this.unit_price_1bag = unit_price_1bag;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Product_Order{" + "oid=" + oid + ", baid=" + baid + ", packages=" + packages + ", qty_kg=" + qty_kg + ", unit_price_1bag=" + unit_price_1bag + ", total=" + total + '}';
    }
    
    
    
}
