/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author dimuthu
 */
@Entity
public class Batch_Recieve {
    @Id
    private String brid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mid",referencedColumnName = "mid",updatable = false, insertable = false)
    private Material mid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grid",referencedColumnName = "grid",updatable = false, insertable = false)
    private GRN grid;
    private String manufacture_date;
    private String expire_date;
    private double received_qty_kg;
    private double current_qty_kg;
    private double unit_price_1kg;
    private double total;

    public Batch_Recieve() {
    }

    public Batch_Recieve(String brid, Material mid, GRN grid, String manufacture_date, String expire_date, double received_qty_kg, double current_qty_kg, double unit_price_1kg, double total) {
        this.brid = brid;
        this.mid = mid;
        this.grid = grid;
        this.manufacture_date = manufacture_date;
        this.expire_date = expire_date;
        this.received_qty_kg = received_qty_kg;
        this.current_qty_kg = current_qty_kg;
        this.unit_price_1kg = unit_price_1kg;
        this.total = total;
    }

    public String getBrid() {
        return brid;
    }

    public void setBrid(String brid) {
        this.brid = brid;
    }

    public Material getMid() {
        return mid;
    }

    public void setMid(Material mid) {
        this.mid = mid;
    }

    public GRN getGrid() {
        return grid;
    }

    public void setGrid(GRN grid) {
        this.grid = grid;
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

    public double getReceived_qty_kg() {
        return received_qty_kg;
    }

    public void setReceived_qty_kg(double received_qty_kg) {
        this.received_qty_kg = received_qty_kg;
    }

    public double getCurrent_qty_kg() {
        return current_qty_kg;
    }

    public void setCurrent_qty_kg(double current_qty_kg) {
        this.current_qty_kg = current_qty_kg;
    }

    public double getUnit_price_1kg() {
        return unit_price_1kg;
    }

    public void setUnit_price_1kg(double unit_price_1kg) {
        this.unit_price_1kg = unit_price_1kg;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Batch_Recieve{" + "brid=" + brid + ", mid=" + mid + ", grid=" + grid + ", manufacture_date=" + manufacture_date + ", expire_date=" + expire_date + ", received_qty_kg=" + received_qty_kg + ", current_qty_kg=" + current_qty_kg + ", unit_price_1kg=" + unit_price_1kg + ", total=" + total + '}';
    }
    
    
}
