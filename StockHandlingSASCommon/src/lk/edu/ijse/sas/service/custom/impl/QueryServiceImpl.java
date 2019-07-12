/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;


import java.math.BigDecimal;
import java.util.ArrayList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.dto.BatchGrnDetailsDTO;
import lk.edu.ijse.sas.dto.BatchOrderDTO;
import lk.edu.ijse.sas.dto.BatchProDTO;
import lk.edu.ijse.sas.dto.ProOrderDTO;
import lk.edu.ijse.sas.business.custom.QueryBO;
import lk.edu.ijse.sas.service.custom.QueryService;

/**
 *
 * @author dimuthu
 */
public class QueryServiceImpl implements QueryService{
    
    private QueryBO quaryBO;

    public QueryServiceImpl() {
        
        quaryBO=(QueryBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.QUARY);
    }

    @Override
    public BigDecimal getUnitPriceFromReceiveBatch(String mid) throws Exception {
        
        return quaryBO.getUnitPriceFromReceiveBatch(mid);
    }

    @Override
    public BigDecimal getUnitPriceFromReturnReceiveBatch(String mid) throws Exception {
        
        return quaryBO.getUnitPriceFromReturnReceiveBatch(mid);
    }

    @Override
    public BatchGrnDetailsDTO getBatchGrnDetails(String brid) throws Exception {

        return quaryBO.getBatchGrnDetails(brid);
    }

    @Override
    public ArrayList<String> getBrid(String date) throws Exception {
        
        return quaryBO.getBrid(date);
    }

    @Override
    public ArrayList<BatchProDTO> getBatchProDetails() throws Exception {
        
        return quaryBO.getBatchProDetails();
    }

    @Override
    public ArrayList<ProOrderDTO> getProOrderDetails() throws Exception {
        
        return quaryBO.getProOrderDetails();
    }

    @Override
    public BatchGrnDetailsDTO getReturnBatchGrnDetails(String rbrid) throws Exception {

        return quaryBO.getReturnBatchGrnDetails(rbrid);
    }

    @Override
    public BatchOrderDTO getBatchAddDetail(String baid) throws Exception {

        return quaryBO.getBatchAddDetail(baid);
    }

    @Override
    public ArrayList<String> getOrderDate(String baid) throws Exception {

        return quaryBO.getOrderDate(baid);
    }

    @Override
    public String getProName(String baid) throws Exception {

        return quaryBO.getProName(baid);
    }

    @Override
    public ArrayList<BigDecimal> getTotal(String month, String year) throws Exception {
        return quaryBO.getTotal(month, year);
    }
    
    
    
    
    
    
}
