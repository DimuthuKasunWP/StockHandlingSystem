/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author dimuthu
 */
@Entity
public class Reject_Recieve {
    @ManyToOne
    private   Batch_Recieve brid;
    private double qty;
    private String cause;
    private String rej_date;

    public Reject_Recieve() {
    }

    public Reject_Recieve(Batch_Recieve brid, double qty, String cause, String rej_date) {
        this.brid = brid;
        this.qty = qty;
        this.cause = cause;
        this.rej_date = rej_date;
    }

    public Batch_Recieve getBrid() {
        return brid;
    }

    public void setBrid(Batch_Recieve brid) {
        this.brid = brid;
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

    public String getRej_date() {
        return rej_date;
    }

    public void setRej_date(String rej_date) {
        this.rej_date = rej_date;
    }

    @Override
    public String toString() {
        return "Reject_Recieve{" + "brid=" + brid + ", qty=" + qty + ", cause=" + cause + ", rej_date=" + rej_date + '}';
    }
    
}
