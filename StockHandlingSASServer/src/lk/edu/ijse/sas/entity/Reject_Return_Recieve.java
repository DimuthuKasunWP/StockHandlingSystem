/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author dimuthu
 */
@Entity
public class Reject_Return_Recieve {
    @ManyToOne(cascade = CascadeType.ALL)
    private Return_Batch_Recieve rbrid;
    private double qty;
    private String cause;
    private String reject_date;

    public Reject_Return_Recieve() {
    }

    public Reject_Return_Recieve(Return_Batch_Recieve rbrid, double qty, String cause, String reject_date) {
        this.rbrid = rbrid;
        this.qty = qty;
        this.cause = cause;
        this.reject_date = reject_date;
    }

    public Return_Batch_Recieve getRbrid() {
        return rbrid;
    }

    public void setRbrid(Return_Batch_Recieve rbrid) {
        this.rbrid = rbrid;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getReject_date() {
        return reject_date;
    }

    public void setReject_date(String reject_date) {
        this.reject_date = reject_date;
    }

    @Override
    public String toString() {
        return "Reject_Return_Recieve{" + "rbrid=" + rbrid + ", qty=" + qty + ", cause=" + cause + ", reject_date=" + reject_date + '}';
    }
    
}
