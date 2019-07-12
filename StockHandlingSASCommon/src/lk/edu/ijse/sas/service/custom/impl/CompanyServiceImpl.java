/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.service.custom.impl;


import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.edu.ijse.sas.business.BOFactory;
import lk.edu.ijse.sas.business.custom.CompanyBO;
import lk.edu.ijse.sas.dto.CompanyDTO;
import lk.edu.ijse.sas.service.custom.CompanyService;

/**
 *
 * @author dimuthu
 */
public class CompanyServiceImpl implements CompanyService{
    
    private CompanyBO comBO;

    public CompanyServiceImpl() {
        
        comBO=(CompanyBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.COMPANY);
    }
    
    

    @Override
    public ArrayList<CompanyDTO> getAll() throws Exception {
        
        return comBO.getAll();
    }

    @Override
    public String getCompanyId(String comName) throws Exception {
        
        return comBO.getCompanyId(comName);
        
    }

    @Override
    public ObservableList<String> getComNames(String comName) throws Exception {
        
        return comBO.getComNames(comName);
    }

    @Override
    public boolean add(CompanyDTO dto) throws Exception {
            
        return comBO.add(dto);
    }

    @Override
    public boolean update(String rename, String comName) throws Exception {

        return comBO.update(rename, comName);
    }

    @Override
    public String getComName(String cid) throws Exception {

        return comBO.getComName(cid);
    }

    @Override
    public boolean remove(String id) throws Exception {

        return comBO.remove(id);
    }

    @Override
    public boolean update(CompanyDTO dto) throws Exception {

        return comBO.update(dto);
    }

   
}
