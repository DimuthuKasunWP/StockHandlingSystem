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
public class Orders {
    @Id
    private String oid;
    @ManyToOne(cascade = CascadeType.ALL)
    private Company cid;
    private String po;
    private double total;
    private String date;

    public Orders() {
    }

    public Orders(String oid, Company cid, String po, double total, String date) {
        this.oid = oid;
        this.cid = cid;
        this.po = po;
        this.total = total;
        this.date = date;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Company getCid() {
        return cid;
    }

    public void setCid(Company cid) {
        this.cid = cid;
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Orders{" + "oid=" + oid + ", cid=" + cid + ", po=" + po + ", total=" + total + ", date=" + date + '}';
    }

    
}
