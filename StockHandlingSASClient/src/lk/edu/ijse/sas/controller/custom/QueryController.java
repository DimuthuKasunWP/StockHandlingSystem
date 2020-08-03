/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom;

import lk.edu.ijse.sas.controller.SuperController;
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
public interface QueryController extends SuperController<SuperDTO>{

    @Override
    public default boolean add(SuperDTO dto) throws Exception {return true;}
    
    public BatchGrnDetailsDTO getReturnBatchGrnDetails(String rbrid) throws Exception;
    
    @Override
    public default ArrayList<SuperDTO> getAll() throws Exception {return null;}
    
    public BigDecimal getUnitPriceFromReceiveBatch(String mid)throws Exception;
    
    public BigDecimal getUnitPriceFromReturnReceiveBatch(String mid)throws Exception;

    @Override
    public default boolean add(ArrayList<SuperDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<SuperDTO> dtoList) throws Exception {return true;}
    
    public BatchGrnDetailsDTO getBatchGrnDetails(String brid)throws Exception;
    
    public ArrayList<String> getBrid(String date) throws Exception ;
    
    public ArrayList<BatchProDTO> getBatchProDetails() throws Exception ;
    
    public ArrayList<ProOrderDTO> getProOrderDetails() throws Exception;
    
    public BatchOrderDTO getBatchAddDetail(String baid) throws Exception;
    
    public ArrayList<String> getOrderDate(String baid) throws Exception;
    
    public String getProName(String baid) throws Exception;
    
    public ArrayList<BigDecimal> getTotal(String month, String year) throws Exception; 
}
