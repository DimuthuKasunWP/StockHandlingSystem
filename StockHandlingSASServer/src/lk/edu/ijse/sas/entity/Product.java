/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.entity;

/**
 *
 * @author dimuthu
 */
public class Product {
    private String prid;
    private String product_name;
    private double bag_size_kg;
    private int qty_bags;

    public Product() {
    }

    public Product(String prid, String product_name, double bag_size_kg, int qty_bags) {
        this.prid = prid;
        this.product_name = product_name;
        this.bag_size_kg = bag_size_kg;
        this.qty_bags = qty_bags;
    }

    public String getPrid() {
        return prid;
    }

    public void setPrid(String prid) {
        this.prid = prid;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getBag_size_kg() {
        return bag_size_kg;
    }

    public void setBag_size_kg(double bag_size_kg) {
        this.bag_size_kg = bag_size_kg;
    }

    public int getQty_bags() {
        return qty_bags;
    }

    public void setQty_bags(int qty_bags) {
        this.qty_bags = qty_bags;
    }

    @Override
    public String toString() {
        return "Product{" + "prid=" + prid + ", product_name=" + product_name + ", bag_size_kg=" + bag_size_kg + ", qty_bags=" + qty_bags + '}';
    }
    
}
