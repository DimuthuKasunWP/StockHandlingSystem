/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.controller.custom.impl;

import com.sas.kem.edu.ijse.dao.DAOFactory;
import com.sas.kem.edu.ijse.dao.custom.QuaryDAO;
import com.sas.kem.edu.ijse.dto.BatchGrnDetailsDTO;
import com.sas.kem.edu.ijse.dto.BatchOrderDTO;
import com.sas.kem.edu.ijse.dto.BatchProDTO;
import com.sas.kem.edu.ijse.dto.ProOrderDTO;
import java.math.BigDecimal;
import java.util.ArrayList;
import lk.edu.ijse.sas.controller.custom.QueryController;

/**
 *
 * @author Vidura
 */
public class QueryControllerImpl implements QueryController{
    
    private QuaryDAO quaryDAO;

    public QueryControllerImpl() {
        
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
