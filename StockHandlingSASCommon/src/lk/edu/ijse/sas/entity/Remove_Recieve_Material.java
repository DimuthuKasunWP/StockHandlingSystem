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
public class Remove_Recieve_Material {
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mid",referencedColumnName = "mid",updatable = false, insertable = false)
    private Material mid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "brid",referencedColumnName = "brid",updatable = false, insertable = false)
    private Batch_Recieve brid;
    private double qty_kg;
    private String remove_date;
    private String remove_time;
    private String carry_sector_name;
    @EmbeddedId
    private Remove_Recieve_Material_PK remove_Recieve_Material_PK;

    public Remove_Recieve_Material() {
    }

    public Remove_Recieve_Material(Material mid, Batch_Recieve brid, double qty_kg, String remove_date, String remove_time, String carry_sector_name, Remove_Recieve_Material_PK remove_Recieve_Material_PK) {
        this.mid = mid;
        this.brid = brid;
        this.qty_kg = qty_kg;
        this.remove_date = remove_date;
        this.remove_time = remove_time;
        this.carry_sector_name = carry_sector_name;
        this.remove_Recieve_Material_PK = remove_Recieve_Material_PK;
    }

    public Remove_Recieve_Material_PK getRemove_Recieve_Material_PK() {
        return remove_Recieve_Material_PK;
    }

    public void setRemove_Recieve_Material_PK(Remove_Recieve_Material_PK remove_Recieve_Material_PK) {
        this.remove_Recieve_Material_PK = remove_Recieve_Material_PK;
    }

    

    public Material getMid() {
        return mid;
    }

    public void setMid(Material mid) {
        this.mid = mid;
    }

    public Batch_Recieve getBrid() {
        return brid;
    }

    public void setBrid(Batch_Recieve brid) {
        this.brid = brid;
    }

    public double getQty_kg() {
        return qty_kg;
    }

    public void setQty_kg(double qty_kg) {
        this.qty_kg = qty_kg;
    }

    public String getRemove_date() {
        return remove_date;
    }

    public void setRemove_date(String remove_date) {
        this.remove_date = remove_date;
    }

    public String getRemove_time() {
        return remove_time;
    }

    public void setRemove_time(String remove_time) {
        this.remove_time = remove_time;
    }

    public String getCarry_sector_name() {
        return carry_sector_name;
    }

    public void setCarry_sector_name(String carry_sector_name) {
        this.carry_sector_name = carry_sector_name;
    }

    @Override
    public String toString() {
        return "Remove_Recieve_Material{" + "mid=" + mid + ", brid=" + brid + ", qty_kg=" + qty_kg + ", remove_date=" + remove_date + ", remove_time=" + remove_time + ", carry_sector_name=" + carry_sector_name + '}';
    }
    
}
