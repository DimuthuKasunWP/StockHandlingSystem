/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.Return_order_detailDTO;

/**
 *
 * @author dimuthu
 */
public interface Return_order_detailDAO extends SuperDAO<Return_order_detailDTO>{

    @Override
    public default boolean add(Return_order_detailDTO dto) throws Exception {return true;}
    
    
}
