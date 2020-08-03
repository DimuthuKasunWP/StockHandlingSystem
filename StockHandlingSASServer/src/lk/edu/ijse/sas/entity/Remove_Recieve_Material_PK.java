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
public class Remove_Recieve_Material_PK implements Serializable{
    private String mid;
    private String brid;

    public Remove_Recieve_Material_PK() {
    }

    public Remove_Recieve_Material_PK(String mid, String brid) {
        this.mid = mid;
        this.brid = brid;
    }
    
}
