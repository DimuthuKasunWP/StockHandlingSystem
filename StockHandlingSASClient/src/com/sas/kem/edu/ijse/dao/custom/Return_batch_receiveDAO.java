/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.Return_batch_receiveDTO;

/**
 *
 * @author dimuthu
 */
public interface Return_batch_receiveDAO extends SuperDAO<Return_batch_receiveDTO>{

    @Override
    public default boolean add(Return_batch_receiveDTO dto) throws Exception {return true;}
    
}
