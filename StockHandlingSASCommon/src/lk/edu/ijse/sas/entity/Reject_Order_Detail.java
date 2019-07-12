/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.engine.jdbc.batch.spi.Batch;

/**
 *
 * @author dimuthu
 */
@Entity
public class Reject_Order_Detail {
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rjid",referencedColumnName = "rjid",updatable = false, insertable = false)
    private Reject_Order rjid;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "baid",referencedColumnName = "baid",updatable = false, insertable = false)
    private Batch_Add baid;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "oid",referencedColumnName = "oid",updatable = false, insertable = false)
    private Orders oid;
    private int qty;
    @EmbeddedId
    private Reject_Order_Detail_PK reject_Order_Detail_PK;
    public Reject_Order_Detail() {
    }

    public Reject_Order_Detail(Reject_Order rjid, Batch_Add baid, Orders oid, int qty, Reject_Order_Detail_PK reject_Order_Detail_PK) {
        this.rjid = rjid;
        this.baid = baid;
        this.oid = oid;
        this.qty = qty;
        this.reject_Order_Detail_PK = reject_Order_Detail_PK;
    }

    public Reject_Order_Detail_PK getReject_Order_Detail_PK() {
        return reject_Order_Detail_PK;
    }

    public void setReject_Order_Detail_PK(Reject_Order_Detail_PK reject_Order_Detail_PK) {
        this.reject_Order_Detail_PK = reject_Order_Detail_PK;
    }

   

    public Reject_Order getRjid() {
        return rjid;
    }

    public void setRjid(Reject_Order rjid) {
        this.rjid = rjid;
    }

    public Batch_Add getBaid() {
        return baid;
    }

    public void setBaid(Batch_Add baid) {
        this.baid = baid;
    }

    public Orders getOid() {
        return oid;
    }

    public void setOid(Orders oid) {
        this.oid = oid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Reject_Order_Detail{" + "rjid=" + rjid + ", baid=" + baid + ", oid=" + oid + ", qty=" + qty + '}';
    }
    
}
