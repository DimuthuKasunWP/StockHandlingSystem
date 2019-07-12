/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.OrdersDTO;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public interface OrdersDAO extends SuperDAO<OrdersDTO>{

    @Override
    public default boolean add(ArrayList<OrdersDTO> dtoList) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<OrdersDTO> dtoList) throws Exception {return true;}
 
    public boolean add(OrdersDTO dto) throws Exception;
    
    public boolean update(OrdersDTO dto) throws Exception;
}
