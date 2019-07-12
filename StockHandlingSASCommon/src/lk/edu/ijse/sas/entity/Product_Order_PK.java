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
public class Product_Order_PK implements Serializable{
    private String pid;
    private String baid;

    public Product_Order_PK(String pid, String baid) {
        this.pid = pid;
        this.baid = baid;
    }

    public Product_Order_PK() {
    }
    
}
