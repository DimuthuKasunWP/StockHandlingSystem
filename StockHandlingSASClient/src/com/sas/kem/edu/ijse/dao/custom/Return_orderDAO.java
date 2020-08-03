/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.Return_orderDTO;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public interface Return_orderDAO extends SuperDAO<Return_orderDTO>{

    @Override
    public default boolean add(ArrayList<Return_orderDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<Return_orderDTO> dtoList) throws Exception {return true;}
    
    
}
