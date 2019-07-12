/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.Batch_addDTO;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public interface Batch_addDAO extends SuperDAO<Batch_addDTO>{

    @Override
    public default boolean add(Batch_addDTO dto) throws Exception {return true;}
    
    public boolean updateAsIncreased(ArrayList<Batch_addDTO> dtoList) throws Exception;
    
    public String getProId(String baid) throws Exception;
    
}
