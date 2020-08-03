/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author dimuthu
 */
@Entity
public class Sector {
    @Id
    private String sec_name;

    public Sector() {
    }

    public Sector(String sec_name) {
        this.sec_name = sec_name;
    }

    public String getSec_name() {
        return sec_name;
    }

    public void setSec_name(String sec_name) {
        this.sec_name = sec_name;
    }

    @Override
    public String toString() {
        return "Sector{" + "sec_name=" + sec_name + '}';
    }
    
    
}
