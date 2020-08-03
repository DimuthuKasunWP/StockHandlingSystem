/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.dto;

import java.io.Serializable;

/**
 *
 * @author dimuthu
 */
public class BatchGrnDetailsDTO {
    
    private String cid;
    private String time;
    private String date;
    private String grn;

    public BatchGrnDetailsDTO() {
    }

    public BatchGrnDetailsDTO(String cid, String time, String date, String grn) {
        this.cid = cid;
        this.time = time;
        this.date = date;
        this.grn = grn;
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
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(String time) {
        this.time = time;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the grn
     */
    public String getGrn() {
        return grn;
    }

    /**
     * @param grn the grn to set
     */
    public void setGrn(String grn) {
        this.grn = grn;
    }

    
}
