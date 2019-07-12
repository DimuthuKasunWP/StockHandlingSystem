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
public class Material {
    @Id
    private String mid;
    private String material_name;
    private double amount_kg;

    public Material() {
    }

    public Material(String mid, String material_name, double amount_kg) {
        this.mid = mid;
        this.material_name = material_name;
        this.amount_kg = amount_kg;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMaterial_name() {
        return material_name;
    }

    public void setMaterial_name(String material_name) {
        this.material_name = material_name;
    }

    public double getAmount_kg() {
        return amount_kg;
    }

    public void setAmount_kg(double amount_kg) {
        this.amount_kg = amount_kg;
    }

    @Override
    public String toString() {
        return "Material{" + "mid=" + mid + ", material_name=" + material_name + ", amount_kg=" + amount_kg + '}';
    }
    
}
