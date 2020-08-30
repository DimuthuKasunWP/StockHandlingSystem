/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.PasswordDTO;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public interface PasswordDAO extends SuperDAO<PasswordDTO>{

    @Override
    public default boolean add(ArrayList<PasswordDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<PasswordDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean add(PasswordDTO dto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean updatePassword(String userName,String password,String lastName) throws Exception;
    
}
