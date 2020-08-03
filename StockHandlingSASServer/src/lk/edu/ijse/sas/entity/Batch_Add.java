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
public class Batch_Add {
    @Id
    private String baid;
    @ManyToOne(cascade = CascadeType.ALL)
    private Product proid;
    private String manufacture_date;
    private String expire_date;
    private int product_qty;
    private int current_qty;
    private double unit_price;
    private String add_time;
    private String add_date;

    public Batch_Add() {
    }

    public Batch_Add(String baid, Product proid, String manufacture_date, String expire_date, int product_qty, int current_qty, double unit_price, String add_time, String add_date) {
        this.baid = baid;
        this.proid = proid;
        this.manufacture_date = manufacture_date;
        this.expire_date = expire_date;
        this.product_qty = product_qty;
        this.current_qty = current_qty;
        this.unit_price = unit_price;
        this.add_time = add_time;
        this.add_date = add_date;
    }

    public String getBaid() {
        return baid;
    }

    public void setBaid(String baid) {
        this.baid = baid;
    }

    public Product getProid() {
        return proid;
    }

    public void setProid(Product proid) {
        this.proid = proid;
    }

    public String getManufacture_date() {
        return manufacture_date;
    }

    public void setManufacture_date(String manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    public String getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public int getProduct_qty() {
        return product_qty;
    }

    public void setProduct_qty(int product_qty) {
        this.product_qty = product_qty;
    }

    public int getCurrent_qty() {
        return current_qty;
    }

    public void setCurrent_qty(int current_qty) {
        this.current_qty = current_qty;
    }

    public double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(double unit_price) {
        this.unit_price = unit_price;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getAdd_date() {
        return add_date;
    }

    public void setAdd_date(String add_date) {
        this.add_date = add_date;
    }

    @Override
    public String toString() {
        return "batch_add{" + "baid=" + baid + ", proid=" + proid + ", manufacture_date=" + manufacture_date + ", expire_date=" + expire_date + ", product_qty=" + product_qty + ", current_qty=" + current_qty + ", unit_price=" + unit_price + ", add_time=" + add_time + ", add_date=" + add_date + '}';
    }
    
    
}
