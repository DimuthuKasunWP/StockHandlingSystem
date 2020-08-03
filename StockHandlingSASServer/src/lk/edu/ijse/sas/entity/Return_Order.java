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
public class Return_Order {
    @Id
    private String rnid;
    private int returned_amount;
    private String date;

    public Return_Order() {
    }

    public Return_Order(String rnid, int returned_amount, String date) {
        this.rnid = rnid;
        this.returned_amount = returned_amount;
        this.date = date;
    }

    public String getRnid() {
        return rnid;
    }

    public void setRnid(String rnid) {
        this.rnid = rnid;
    }

    public int getReturned_amount() {
        return returned_amount;
    }

    public void setReturned_amount(int returned_amount) {
        this.returned_amount = returned_amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Return_Order{" + "rnid=" + rnid + ", returned_amount=" + returned_amount + ", date=" + date + '}';
    }
    
    
}
