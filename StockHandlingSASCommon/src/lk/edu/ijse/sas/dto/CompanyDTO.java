/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.dto;

/**
 *
 * @author dimuthu
 */
public class CompanyDTO extends SuperDTO{
    
    private String cid;
    private String comName;
    private String addressNo;
    private String addressLane;
    private String addressArea;
    private String addressCity;
    private String email;
    private String telNo;
    private String telAddNo;
    private String faxNo;

    public CompanyDTO() {
    }

    public CompanyDTO(String cid, String comName, String addressNo, String addressLane, String addressArea, String addressCity, String email, String telNo, String telAddNo, String faxNo) {
        this.cid = cid;
        this.comName = comName;
        this.addressNo = addressNo;
        this.addressLane = addressLane;
        this.addressArea = addressArea;
        this.addressCity = addressCity;
        this.email = email;
        this.telNo = telNo;
        this.telAddNo = telAddNo;
        this.faxNo = faxNo;
    }

    /**
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * @return the comName
     */
    public String getComName() {
        return comName;
    }

    /**
     * @param comName the comName to set
     */
    public void setComName(String comName) {
        this.comName = comName;
    }

    /**
     * @return the addressNo
     */
    public String getAddressNo() {
        return addressNo;
    }

    /**
     * @param addressNo the addressNo to set
     */
    public void setAddressNo(String addressNo) {
        this.addressNo = addressNo;
    }

    /**
     * @return the addressLane
     */
    public String getAddressLane() {
        return addressLane;
    }

    /**
     * @param addressLane the addressLane to set
     */
    public void setAddressLane(String addressLane) {
        this.addressLane = addressLane;
    }

    /**
     * @return the addressArea
     */
    public String getAddressArea() {
        return addressArea;
    }

    /**
     * @param addressArea the addressArea to set
     */
    public void setAddressArea(String addressArea) {
        this.addressArea = addressArea;
    }

    /**
     * @return the addressCity
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * @param addressCity the addressCity to set
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the telNo
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * @param telNo the telNo to set
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    /**
     * @return the telAddNo
     */
    public String getTelAddNo() {
        return telAddNo;
    }

    /**
     * @param telAddNo the telAddNo to set
     */
    public void setTelAddNo(String telAddNo) {
        this.telAddNo = telAddNo;
    }

    /**
     * @return the faxNo
     */
    public String getFaxNo() {
        return faxNo;
    }

    /**
     * @param faxNo the faxNo to set
     */
    public void setFaxNo(String faxNo) {
        this.faxNo = faxNo;
    }

    
    
    
}
