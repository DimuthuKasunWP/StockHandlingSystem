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
public class GRN {
    @Id
    private String grid;
    @ManyToOne(cascade = CascadeType.ALL)
    private Company cid;
    @ManyToOne(cascade = CascadeType.ALL)
    private Purchase_Order pid;
    private int good_amount;
    private String add_time;
    private String grn_date;
    private double grand_total;

    public GRN() {
    }

    public GRN(String grid, Company cid, Purchase_Order pid, int good_amount, String add_time, String grn_date, double grand_total) {
        this.grid = grid;
        this.cid = cid;
        this.pid = pid;
        this.good_amount = good_amount;
        this.add_time = add_time;
        this.grn_date = grn_date;
        this.grand_total = grand_total;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public Company getCid() {
        return cid;
    }

    public void setCid(Company cid) {
        this.cid = cid;
    }

    public Purchase_Order getPid() {
        return pid;
    }

    public void setPid(Purchase_Order pid) {
        this.pid = pid;
    }

    public int getGood_amount() {
        return good_amount;
    }

    public void setGood_amount(int good_amount) {
        this.good_amount = good_amount;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getGrn_date() {
        return grn_date;
    }

    public void setGrn_date(String grn_date) {
        this.grn_date = grn_date;
    }

    public double getGrand_total() {
        return grand_total;
    }

    public void setGrand_total(double grand_total) {
        this.grand_total = grand_total;
    }

    @Override
    public String toString() {
        return "GRN{" + "grid=" + grid + ", cid=" + cid + ", pid=" + pid + ", good_amount=" + good_amount + ", add_time=" + add_time + ", grn_date=" + grn_date + ", grand_total=" + grand_total + '}';
    }
    
}
