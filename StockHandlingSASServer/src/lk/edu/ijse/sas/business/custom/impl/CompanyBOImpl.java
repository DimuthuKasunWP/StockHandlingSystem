/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom.impl;

import lk.edu.ijse.sas.service.custom.impl.*;


import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.edu.ijse.sas.business.custom.CompanyBO;
import lk.edu.ijse.sas.dto.CompanyDTO;

/**
 *
 * @author dimuthu
 */
public class CompanyBOImpl implements CompanyBO{
    
    private CompanyDAO comDAO;

    public CompanyBOImpl() {
        
        comDAO=(CompanyDAO) DAOFactory.getInstance().getDAOTypes(DAOFactory.daoTypes.COMPANY);
    }
    
    

    @Override
    public ArrayList<CompanyDTO> getAll() throws Exception {
        
        return comDAO.getAll();
    }

    @Override
    public String getCompanyId(String comName) throws Exception {
        
        return comDAO.getCompanyId(comName);
        
    }

    @Override
    public ObservableList<String> getComNames(String comName) throws Exception {
        
        return comDAO.getComNames(comName);
    }

    @Override
    public boolean add(CompanyDTO dto) throws Exception {
            
        return comDAO.add(dto);
    }

    @Override
    public boolean update(String rename, String comName) throws Exception {

        return comDAO.updateComName(rename, comName);
    }

    @Override
    public String getComName(String cid) throws Exception {

        return comDAO.getComName(cid);
    }

    @Override
    public boolean remove(String id) throws Exception {

        return comDAO.remove(id);
    }

    @Override
    public boolean update(CompanyDTO dto) throws Exception {

        return comDAO.update(dto);
    }

   
}
