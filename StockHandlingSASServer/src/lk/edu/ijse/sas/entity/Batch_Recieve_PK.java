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
public class Batch_Recieve_PK implements Serializable{
    private String mid;
    private String grid;

    public Batch_Recieve_PK(String mid, String grid) {
        this.mid = mid;
        this.grid = grid;
    }

    public Batch_Recieve_PK() {
    }
    
}
