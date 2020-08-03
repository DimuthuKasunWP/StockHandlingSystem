/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.repository.custom;


import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.edu.ijse.sas.dto.CompanyDTO;
import lk.edu.ijse.sas.entity.Company;
import lk.edu.ijse.sas.repository.SuperRepository;

/**
 *
 * @author dimuthu
 */
public interface CompanyRepository extends SuperRepository<Company>{

   
        
    public String getCompanyId(String comName) throws Exception;
     
    public ObservableList<String> getComNames(String comName) throws Exception;

    @Override
    public default boolean add(ArrayList<Company> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public default void update(ArrayList<Company> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    public boolean updateComName(String rename,String comName) throws Exception;
    
    public String getComName(String cid) throws Exception;
    
    public boolean remove(String id) throws Exception;
    
    public void update(Company dto) throws Exception;
}
