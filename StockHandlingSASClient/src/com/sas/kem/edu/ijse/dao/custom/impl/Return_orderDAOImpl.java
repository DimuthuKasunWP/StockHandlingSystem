/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sas.kem.edu.ijse.dao.custom.impl;

import com.sas.kem.edu.ijse.dao.custom.Return_orderDAO;
import com.sas.kem.edu.ijse.dao.db.ConnectionFactory;
import com.sas.kem.edu.ijse.dto.Return_orderDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author dimuthu
 */
public class Return_orderDAOImpl implements Return_orderDAO{
    
    private Connection conn;

    public Return_orderDAOImpl() {
        
        conn=ConnectionFactory.getInstance().getConnection();
    }
    
    

    @Override
    public ArrayList<Return_orderDTO> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean add(Return_orderDTO dto) throws Exception {

        int res=0;
        String sql="insert into return_order values(?,?,?) ";
        PreparedStatement stm=conn.prepareStatement(sql);
        stm.setObject(1, dto.getRnid());
        stm.setObject(2, dto.getReturned_amount());
        stm.setObject(3, dto.getReturnDate());
        res+=stm.executeUpdate();
        if(res>0){
            return true;
        }
        return false;
    }
    
}
