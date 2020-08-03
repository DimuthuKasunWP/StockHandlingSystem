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
public class Remove_Return_Material_PK implements Serializable{
    private String mid;
    private String rbrid;

    public Remove_Return_Material_PK() {
    }

    public Remove_Return_Material_PK(String mid, String rbrid) {
        this.mid = mid;
        this.rbrid = rbrid;
    }
    
    
}
