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
public class Company {
    @Id
    private String cid;
    private String com_name;
    private String address_no;
    private String address_lane;
    private String address_area;
    private String address_city;
    private String email;
    private String tel_no;
    private String tel_add;
    private String fax_no;

    public Company() {
    }

    public Company(String cid, String com_name, String address_no, String address_lane, String address_area, String address_city, String email, String tel_no, String tel_add, String fax_no) {
        this.cid = cid;
        this.com_name = com_name;
        this.address_no = address_no;
        this.address_lane = address_lane;
        this.address_area = address_area;
        this.address_city = address_city;
        this.email = email;
        this.tel_no = tel_no;
        this.tel_add = tel_add;
        this.fax_no = fax_no;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getAddress_no() {
        return address_no;
    }

    public void setAddress_no(String address_no) {
        this.address_no = address_no;
    }

    public String getAddress_lane() {
        return address_lane;
    }

    public void setAddress_lane(String address_lane) {
        this.address_lane = address_lane;
    }

    public String getAddress_area() {
        return address_area;
    }

    public void setAddress_area(String address_area) {
        this.address_area = address_area;
    }

    public String getAddress_city() {
        return address_city;
    }

    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }

    public String getTel_add() {
        return tel_add;
    }

    public void setTel_add(String tel_add) {
        this.tel_add = tel_add;
    }

    public String getFax_no() {
        return fax_no;
    }

    public void setFax_no(String fax_no) {
        this.fax_no = fax_no;
    }

    @Override
    public String toString() {
        return "Company{" + "cid=" + cid + ", com_name=" + com_name + ", address_no=" + address_no + ", address_lane=" + address_lane + ", address_area=" + address_area + ", address_city=" + address_city + ", email=" + email + ", tel_no=" + tel_no + ", tel_add=" + tel_add + ", fax_no=" + fax_no + '}';
    }
    
}
