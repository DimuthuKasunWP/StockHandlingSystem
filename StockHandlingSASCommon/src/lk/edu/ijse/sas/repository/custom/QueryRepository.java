/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lk.edu.ijse.sas.dto.SuperDTO;
import lk.edu.ijse.sas.entity.BatchGrnDetails;
import lk.edu.ijse.sas.entity.BatchOrder;
import lk.edu.ijse.sas.entity.BatchPro;
import lk.edu.ijse.sas.entity.ProOrder;
import lk.edu.ijse.sas.repository.SuperRepository;

/**
 *
 * @author dimuthu
 */
public interface QueryRepository extends SuperRepository<SuperDTO>{

    @Override
    public default boolean add(ArrayList<SuperDTO> dtoList) throws Exception {return true;}

    @Override
    public default void update(ArrayList<SuperDTO> dtoList) throws Exception {}
    
    

    @Override
    public default ArrayList<SuperDTO> getAll() throws Exception {return null;}
    
    public BigDecimal getUnitPriceFromReceiveBatch(String mid) throws Exception;
    
    public BigDecimal getUnitPriceFromReturnReceiveBatch(String mid) throws Exception;
    
    public BatchGrnDetails getBatchGrnDetails(String brid) throws Exception;
    
    public BatchGrnDetails getReturnBatchGrnDetails(String rbrid) throws Exception;
    
    public List<String> getBrid(String date) throws Exception;
    
    public List<BatchPro> getBatchProDetail() throws Exception;

    @Override
    public default boolean add(SuperDTO dto) throws Exception {return true;}
    
    public List<ProOrder> getProOrderDetails() throws Exception;
    
    public BatchOrder getBatchAddDetail(String baid) throws Exception;
    
    public List<String> getOrderDate(String baid) throws Exception;
    
    public String getProName(String baid) throws Exception;
    
    public List<BigDecimal> getTotal(String month,String year) throws Exception;

    @Override
    public default SuperDTO getSpecific(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
