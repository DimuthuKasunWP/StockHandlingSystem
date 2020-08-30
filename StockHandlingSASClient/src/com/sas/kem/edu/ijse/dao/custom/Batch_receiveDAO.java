/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.Batch_receiveDTO;

/**
 *
 * @author dimuthu
 */
public interface Batch_receiveDAO extends SuperDAO<Batch_receiveDTO>{

    @Override
    public default boolean add(Batch_receiveDTO dto) throws Exception {return true;}
    
}
