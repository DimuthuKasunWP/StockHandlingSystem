/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.SuperDTO;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public interface IdDAO extends SuperDAO<SuperDTO>{

    @Override
    public default boolean add(ArrayList<SuperDTO> dtoList) throws Exception {return true;}

    @Override
    public default ArrayList<SuperDTO> getAll() throws Exception {return null;}

    @Override
    public default boolean update(ArrayList<SuperDTO> dtoList) throws Exception {return true;}
    
    public String getNewId(String tblName,String colName) throws Exception;

    @Override
    public default boolean add(SuperDTO dto) throws Exception {return true;}
    
    
}
