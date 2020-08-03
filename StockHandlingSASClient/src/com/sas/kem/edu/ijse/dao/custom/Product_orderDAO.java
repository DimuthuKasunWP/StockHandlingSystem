/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom;

import com.sas.kem.edu.ijse.dao.SuperDAO;
import com.sas.kem.edu.ijse.dto.Product_orderDTO;
import java.util.ArrayList;

/**
 *
 * @author Vidura
 */
public interface Product_orderDAO extends SuperDAO<Product_orderDTO>{
    
    public boolean delete(String oid) throws Exception;

    @Override
    public default boolean add(Product_orderDTO dto) throws Exception {return true;}

    @Override
    public default boolean update(ArrayList<Product_orderDTO> dtoList) throws Exception {return true;}
    
    
}
