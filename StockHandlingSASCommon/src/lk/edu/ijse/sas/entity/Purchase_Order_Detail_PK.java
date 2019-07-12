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
public class Purchase_Order_Detail_PK implements  Serializable{
    private String mid;
    private String pid;

    public Purchase_Order_Detail_PK() {
    }

    public Purchase_Order_Detail_PK(String mid, String pid) {
        this.mid = mid;
        this.pid = pid;
    }
    
}
