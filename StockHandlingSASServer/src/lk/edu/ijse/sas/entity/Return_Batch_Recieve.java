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
public class Return_Batch_Recieve {
    @Id
    private String rbrid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grid",referencedColumnName = "grid",updatable = false, insertable = false)
    private GRN grid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mid",referencedColumnName = "mid",updatable = false, insertable = false)
    private Material mid;
    private String manufacture_date;
    private String expire_date;
    private double returned_qty_kg;
    private double current_qty_kg;
    private double unit_price_kg;
    private double total;
    @EmbeddedId
    private Return_Batch_Recieve_PK return_Batch_Recieve_PK;

    public Return_Batch_Recieve() {
    }

    public Return_Batch_Recieve(String rbrid, GRN grid, Material mid, String manufacture_date, String expire_date, double returned_qty_kg, double current_qty_kg, double unit_price_kg, double total) {
        this.rbrid = rbrid;
        this.grid = grid;
        this.mid = mid;
        this.manufacture_date = manufacture_date;
        this.expire_date = expire_date;
        this.returned_qty_kg = returned_qty_kg;
        this.current_qty_kg = current_qty_kg;
        this.unit_price_kg = unit_price_kg;
        this.total = total;
    }

    public String getRbrid() {
        return rbrid;
    }

    public void setRbrid(String rbrid) {
        this.rbrid = rbrid;
    }

    public GRN getGrid() {
        return grid;
    }

    public void setGrid(GRN grid) {
        this.grid = grid;
    }

    public Material getMid() {
        return mid;
    }

    public void setMid(Material mid) {
        this.mid = mid;
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

    public double getReturned_qty_kg() {
        return returned_qty_kg;
    }

    public void setReturned_qty_kg(double returned_qty_kg) {
        this.returned_qty_kg = returned_qty_kg;
    }

    public double getCurrent_qty_kg() {
        return current_qty_kg;
    }

    public void setCurrent_qty_kg(double current_qty_kg) {
        this.current_qty_kg = current_qty_kg;
    }

    public double getUnit_price_kg() {
        return unit_price_kg;
    }

    public void setUnit_price_kg(double unit_price_kg) {
        this.unit_price_kg = unit_price_kg;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Return_Batch_Recieve{" + "rbrid=" + rbrid + ", grid=" + grid + ", mid=" + mid + ", manufacture_date=" + manufacture_date + ", expire_date=" + expire_date + ", returned_qty_kg=" + returned_qty_kg + ", current_qty_kg=" + current_qty_kg + ", unit_price_kg=" + unit_price_kg + ", total=" + total + '}';
    }
    
}
