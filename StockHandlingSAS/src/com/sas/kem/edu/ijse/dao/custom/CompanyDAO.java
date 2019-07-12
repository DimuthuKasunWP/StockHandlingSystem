/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.CompanyDTO;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Vidura
 */
public interface CompanyDAO extends SuperDAO<CompanyDTO>{

    @Override
    public default boolean add(ArrayList<CompanyDTO> dtoList) throws Exception {return true;}
        
    public String getCompanyId(String comName) throws Exception;
     
    public ObservableList<String> getComNames(String comName) throws Exception;

    @Override
    public default boolean update(ArrayList<CompanyDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean updateComName(String rename,String comName) throws Exception;
    
    public String getComName(String cid) throws Exception;
    
    public boolean remove(String id) throws Exception;
    
    public boolean update(CompanyDTO dto) throws Exception;
}
