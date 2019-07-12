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
public class ProOrder {
     private String oid;
    private String orderDate;
    private int product_amount;

    public ProOrder() {
    }

    public ProOrder(String oid, String orderDate, int product_amount) {
        this.oid = oid;
        this.orderDate = orderDate;
        this.product_amount = product_amount;
    }

    /**
     * @return the oid
     */
    public String getOid() {
        return oid;
    }

    /**
     * @param oid the oid to set
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * @return the orderDate
     */
    public String getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the product_amount
     */
    public int getProduct_amount() {
        return product_amount;
    }

    /**
     * @param product_amount the product_amount to set
     */
    public void setProduct_amount(int product_amount) {
        this.product_amount = product_amount;
    }
}
