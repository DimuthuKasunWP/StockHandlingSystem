/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author dimuthu
 */
@Embeddable
public class Reject_Order_Detail_PK implements Serializable{
    private String oid;
    private String rjid;
    private String baid;

    public Reject_Order_Detail_PK() {
    }

    public Reject_Order_Detail_PK(String oid, String rjid, String baid) {
        this.oid = oid;
        this.rjid = rjid;
        this.baid = baid;
    }
}
