/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author dimuthu
 */
@Entity
public class Reject_Order {
    @Id
    private String rjid;
    private int reject_amount;
    private String reject_date;

    public Reject_Order() {
    }

    public Reject_Order(String rejectOrder, int reject_amount, String reject_date) {
        this.rjid = rejectOrder;
        this.reject_amount = reject_amount;
        this.reject_date = reject_date;
    }

    public String getRejectOrder() {
        return rjid;
    }

    public void setRejectOrder(String rejectOrder) {
        this.rjid = rejectOrder;
    }

    public int getReject_amount() {
        return reject_amount;
    }

    public void setReject_amount(int reject_amount) {
        this.reject_amount = reject_amount;
    }

    public String getReject_date() {
        return reject_date;
    }

    public void setReject_date(String reject_date) {
        this.reject_date = reject_date;
    }

    @Override
    public String toString() {
        return "Reject_Order{" + "rejectOrder=" + rjid + ", reject_amount=" + reject_amount + ", reject_date=" + reject_date + '}';
    }
    
}
