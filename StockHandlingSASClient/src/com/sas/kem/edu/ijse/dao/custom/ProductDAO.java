/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.ProductDTO;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Vidura
 */
public interface ProductDAO extends SuperDAO<ProductDTO>{
    
    public String getProid(String proName) throws Exception;
    
    public ObservableList<String> getProNames(String proName) throws Exception;
    
    public String getProName(String proid) throws Exception;
    
    public boolean updateAsIncreased(ArrayList<ProductDTO> dtoList) throws Exception;
    
    public boolean update(String rename,String product) throws Exception;
    
    public boolean remove(String id) throws Exception;
}
