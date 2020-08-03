/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.entity;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author dimuthu
 */
@Entity
public class Return_Order_Detail {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "oid",referencedColumnName = "oid",updatable = false, insertable = false)
    private Orders oid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "baid",referencedColumnName = "baid",updatable = false, insertable = false)
    private Batch_Add baid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rnid",referencedColumnName = "rnid",updatable = false, insertable = false)
    private Return_Order rnid;
    private int qty;
    @EmbeddedId
    private Return_Order_Detail_PK return_Order_Detail_PK;

    public Return_Order_Detail() {
    }

    public Return_Order_Detail(Orders oid, Batch_Add baid, Return_Order rnid, int qty, Return_Order_Detail_PK return_Order_Detail_PK) {
        this.oid = oid;
        this.baid = baid;
        this.rnid = rnid;
        this.qty = qty;
        this.return_Order_Detail_PK = return_Order_Detail_PK;
    }
    
    public Return_Order_Detail_PK getReturn_Order_Detail_PK() {
        return return_Order_Detail_PK;
    }

    public void setReturn_Order_Detail_PK(Return_Order_Detail_PK return_Order_Detail_PK) {
        this.return_Order_Detail_PK = return_Order_Detail_PK;
    }

    

    public Orders getOid() {
        return oid;
    }

    public void setOid(Orders oid) {
        this.oid = oid;
    }

    public Batch_Add getBaid() {
        return baid;
    }

    public void setBaid(Batch_Add baid) {
        this.baid = baid;
    }

    public Return_Order getRnid() {
        return rnid;
    }

    public void setRnid(Return_Order rnid) {
        this.rnid = rnid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Return_Order_Detail{" + "oid=" + oid + ", baid=" + baid + ", rnid=" + rnid + ", qty=" + qty + '}';
    }
    
}
