/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.edu.ijse.sas.business.custom;


import java.util.ArrayList;
import javafx.collections.ObservableList;
import lk.edu.ijse.sas.business.SuperBO;
import lk.edu.ijse.sas.dto.CompanyDTO;
import lk.edu.ijse.sas.service.SuperService;

/**
 *
 * @author dimuthu
 */
public interface CompanyBO extends SuperBO<CompanyDTO>{
    
    public String getCompanyId(String comName) throws Exception;

    @Override
    public default boolean add(ArrayList<CompanyDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<CompanyDTO> dtoList) throws Exception {return true;}

    public ObservableList<String> getComNames(String comName) throws Exception;
   
    public boolean update(String rename,String comName) throws Exception;
    
    public String getComName(String cid) throws Exception;
    
    public boolean remove(String id) throws Exception;
    
    public boolean update(CompanyDTO dto) throws Exception;
}
