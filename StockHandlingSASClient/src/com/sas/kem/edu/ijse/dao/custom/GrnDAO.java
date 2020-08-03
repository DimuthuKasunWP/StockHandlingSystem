/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.GrnDTO;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public interface GrnDAO extends SuperDAO<GrnDTO>{

    @Override
    public default boolean add(ArrayList<GrnDTO> dtoList) throws Exception {return true;}
    
    public boolean add(GrnDTO grn) throws Exception;

    @Override
    public default boolean update(ArrayList<GrnDTO> dtoList) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean update(GrnDTO dto) throws Exception;
    
}
