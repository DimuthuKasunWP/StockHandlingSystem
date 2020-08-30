/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.BatchGrnDetailsDTO;
import com.sas.kem.edu.ijse.dto.BatchOrderDTO;
import com.sas.kem.edu.ijse.dto.BatchProDTO;
import com.sas.kem.edu.ijse.dto.ProOrderDTO;
import com.sas.kem.edu.ijse.dto.SuperDTO;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public interface QuaryDAO extends SuperDAO<SuperDTO>{

    @Override
    public default boolean add(ArrayList<SuperDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<SuperDTO> dtoList) throws Exception {return true;}
    
    

    @Override
    public default ArrayList<SuperDTO> getAll() throws Exception {return null;}
    
    public BigDecimal getUnitPriceFromReceiveBatch(String mid) throws Exception;
    
    public BigDecimal getUnitPriceFromReturnReceiveBatch(String mid) throws Exception;
    
    public BatchGrnDetailsDTO getBatchGrnDetails(String brid) throws Exception;
    
    public BatchGrnDetailsDTO getReturnBatchGrnDetails(String rbrid) throws Exception;
    
    public ArrayList<String> getBrid(String date) throws Exception;
    
    public ArrayList<BatchProDTO> getBatchProDetail() throws Exception;

    @Override
    public default boolean add(SuperDTO dto) throws Exception {return true;}
    
    public ArrayList<ProOrderDTO> getProOrderDetails() throws Exception;
    
    public BatchOrderDTO getBatchAddDetail(String baid) throws Exception;
    
    public ArrayList<String> getOrderDate(String baid) throws Exception;
    
    public String getProName(String baid) throws Exception;
    
    public ArrayList<BigDecimal> getTotal(String month,String year) throws Exception;
}
