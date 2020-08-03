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
public class Return_Batch_Recieve_PK implements Serializable{
    private String pid;
    private String mid;

    public Return_Batch_Recieve_PK() {
    }

    public Return_Batch_Recieve_PK(String pid, String mid) {
        this.pid = pid;
        this.mid = mid;
    }
    
}
