/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.MaterialDTO;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author dimuthu
 */
public interface MaterialDAO extends SuperDAO<MaterialDTO>{
    
    public String getMaterialId(String matName) throws Exception;

    @Override
    public default boolean add(ArrayList<MaterialDTO> dtoList) throws Exception {return true;}
    
        public ObservableList<String> getMatNames(String matName) throws Exception;
        
        public String getMatName(String mid) throws Exception;
      
        public boolean updateAsReduce(ArrayList<MaterialDTO> matlist) throws Exception;
        
        public boolean updateMatName(String rename,String matName) throws Exception;
        
        public boolean remove(String id) throws Exception;
        
}
