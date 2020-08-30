/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.Reject_orderDTO;

/**
 *
 * @author dimuthu
 */
public interface Reject_orderDAO extends SuperDAO<Reject_orderDTO>{
    
    public boolean add(Reject_orderDTO dto) throws Exception;
}
