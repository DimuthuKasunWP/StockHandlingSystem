/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.DateDTO;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public interface DateDAO extends SuperDAO<DateDTO>{

    @Override
    public default boolean add(ArrayList<DateDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<DateDTO> dtoList) throws Exception {return true;}
    
    

    @Override
    public default ArrayList<DateDTO> getAll() throws Exception {return null;}
    
    public DateDTO getDateDetail() throws Exception;

    @Override
    public default boolean add(DateDTO dto) throws Exception {return true;}
    
    
    
}
