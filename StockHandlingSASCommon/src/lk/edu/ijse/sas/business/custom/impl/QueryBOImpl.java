/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;

import lk.edu.ijse.sas.service.custom.impl.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import lk.edu.ijse.sas.dto.BatchGrnDetailsDTO;
import lk.edu.ijse.sas.dto.BatchOrderDTO;
import lk.edu.ijse.sas.dto.BatchProDTO;
import lk.edu.ijse.sas.dto.ProOrderDTO;
import lk.edu.ijse.sas.business.custom.QueryBO;

/**
 *
 * @author dimuthu
 */
public class QueryBOImpl implements QueryBO{
    
    private QuaryDAO quaryDAO;

    public QueryBOImpl() {
        
        quaryDAO=(QuaryDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.QUARY);
    }

    @Override
    public BigDecimal getUnitPriceFromReceiveBatch(String mid) throws Exception {
        
        return quaryDAO.getUnitPriceFromReceiveBatch(mid);
    }

    @Override
    public BigDecimal getUnitPriceFromReturnReceiveBatch(String mid) throws Exception {
        
        return quaryDAO.getUnitPriceFromReturnReceiveBatch(mid);
    }

    @Override
    public BatchGrnDetailsDTO getBatchGrnDetails(String brid) throws Exception {

        return quaryDAO.getBatchGrnDetails(brid);
    }

    @Override
    public ArrayList<String> getBrid(String date) throws Exception {
        
        return quaryDAO.getBrid(date);
    }

    @Override
    public ArrayList<BatchProDTO> getBatchProDetails() throws Exception {
        
        return quaryDAO.getBatchProDetail();
    }

    @Override
    public ArrayList<ProOrderDTO> getProOrderDetails() throws Exception {
        
        return quaryDAO.getProOrderDetails();
    }

    @Override
    public BatchGrnDetailsDTO getReturnBatchGrnDetails(String rbrid) throws Exception {

        return quaryDAO.getReturnBatchGrnDetails(rbrid);
    }

    @Override
    public BatchOrderDTO getBatchAddDetail(String baid) throws Exception {

        return quaryDAO.getBatchAddDetail(baid);
    }

    @Override
    public ArrayList<String> getOrderDate(String baid) throws Exception {

        return quaryDAO.getOrderDate(baid);
    }

    @Override
    public String getProName(String baid) throws Exception {

        return quaryDAO.getProName(baid);
    }

    @Override
    public ArrayList<BigDecimal> getTotal(String month, String year) throws Exception {
        return quaryDAO.getTotal(month, year);
    }
    
    
    
    
    
    
}
